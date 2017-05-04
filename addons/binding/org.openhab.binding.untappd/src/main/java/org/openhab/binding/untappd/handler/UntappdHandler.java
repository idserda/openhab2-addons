/**

 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.untappd.handler;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.eclipse.smarthome.core.library.types.DateTimeType;
import org.eclipse.smarthome.core.library.types.HSBType;
import org.eclipse.smarthome.core.library.types.PercentType;
import org.eclipse.smarthome.core.library.types.StringType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.thing.ThingStatusDetail;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandler;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.State;
import org.eclipse.smarthome.core.types.UnDefType;
import org.openhab.binding.untappd.UntappdBindingConstants;
import org.openhab.binding.untappd.UntappdService;
import org.openhab.binding.untappd.gson.Item;
import org.openhab.binding.untappd.gson.NotificationItem;
import org.openhab.binding.untappd.gson.Recent;
import org.openhab.binding.untappd.internal.UntappdConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.androidpit.colorthief.ColorThief;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The {@link UntappdHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Jeroen Idserda - Initial contribution
 */
public class UntappdHandler extends BaseThingHandler {

    private static final int REFRESH = 5; // 5 minutes

    private static final int MAX_ITEMS = 25;

    private Logger logger = LoggerFactory.getLogger(UntappdHandler.class);

    private ScheduledFuture<?> refreshJob;

    private UpdateNotifier updateJob;

    private ToastUpdateNotifier toastJob;

    private UntappdService service;

    private Integer lastId = 0;

    private Date lastToast;

    private String accessToken;

    private boolean filterSelf;

    public UntappdHandler(Thing thing) {
        super(thing);
        logger.trace("constructor");

        Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz")
                .registerTypeAdapter(Integer.class, new IntegerTypeAdapter())
                .registerTypeAdapterFactory(new ObjectCheckTypeAdapterFactory()).create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.untappd.com/").client(client)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        service = retrofit.create(UntappdService.class);
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {
        // NOOP
    }

    @Override
    public void initialize() {
        logger.trace("initialize");

        UntappdConfiguration config = getThing().getConfiguration().as(UntappdConfiguration.class);
        accessToken = config.getAccess_token();
        filterSelf = config.getFilter_self();

        Recent recent = getRecent();
        if (recent != null) {
            updateStatus(ThingStatus.ONLINE);
            setCurrentState(recent);
            setInitialToast();
            startRefresh();
        } else {
            updateStatus(ThingStatus.OFFLINE, ThingStatusDetail.CONFIGURATION_ERROR, "Access token is invalid");
        }
    }

    @Override
    public void dispose() {
        logger.trace("dispose");

        if (refreshJob != null) {
            refreshJob.cancel(true);
        }
        if (updateJob != null) {
            updateJob.shutdown();
        }
        if (toastJob != null) {
            toastJob.shutdown();
        }
    }

    private Recent getRecent() {
        logger.trace("getRecent");

        Call<Recent> call = service.recent(accessToken, lastId, MAX_ITEMS);
        try {
            return call.execute().body();
        } catch (IOException e) {
            logger.debug("Error getting recent checkins", e);
        }

        return null;
    }

    private Recent getNotifications() {
        logger.trace("getNotifications");

        Call<Recent> call = service.notifications(accessToken, 10);
        try {
            return call.execute().body();
        } catch (IOException e) {
            logger.debug("Error getting recent checkins", e);
        }

        return null;
    }

    private void setCurrentState(Recent body) {
        if (body == null) {
            return;
        }

        List<Item> checkins = body.getResponse().getCheckins().getItems();
        List<Item> filteredCheckins = getFilteredCheckin(checkins);

        if (filteredCheckins.size() > 0) {
            Item lastCheckin = checkins.get(0);
            update(lastCheckin);
        }

        setLastId(checkins);
    }

    private void setLastId(List<Item> checkins) {
        if (checkins.size() > 0) {
            lastId = checkins.get(0).getCheckinId();
        }
    }

    private void setInitialToast() {
        Recent recent = getNotifications();
        List<NotificationItem> notifications = recent.getResponse().getNotifications().getItems();
        if (notifications.size() > 0) {
            NotificationItem notification = notifications.get(0);
            lastToast = notification.getNotificationCreatedAt();
            updateToast(notification);
        }
    }

    private void updateNotfication(Recent recent) {
        if (recent == null) {
            return;
        }

        List<NotificationItem> notifications = recent.getResponse().getNotifications().getItems();
        List<NotificationItem> filtered = new ArrayList<>();

        for (NotificationItem notification : notifications) {
            if (notification.getNotificationType().equals("toast")) {
                Date toastDate = notification.getNotificationCreatedAt();
                if (lastToast == null || toastDate.after(lastToast)) {
                    filtered.add(notification);
                }
            }
        }

        if (filtered.size() > 0) {
            toastJob.addAll(filtered);
            lastToast = filtered.get(0).getNotificationCreatedAt();
        }
    }

    private void updateToast(NotificationItem item) {
        String user = item.getActor().getFirstName() + " " + item.getActor().getLastName();
        updateState(new ChannelUID(getThing().getUID(), UntappdBindingConstants.TOAST_USER), new StringType(user));
    }

    private void updateState(Recent body) {
        logger.trace("updateState");

        if (body == null) {
            logger.warn("Recent update from untappd is null");
            return;
        }

        List<Item> checkins = body.getResponse().getCheckins().getItems();
        updateJob.addAll(getFilteredCheckin(checkins));

        setLastId(checkins);
    }

    private List<Item> getFilteredCheckin(List<Item> checkins) {
        List<Item> ret = new ArrayList<>();

        for (Item checkin : checkins) {
            if (!filterSelf || !checkin.getUser().getRelationship().equals("self")) {
                ret.add(checkin);
            }
        }

        Collections.reverse(ret);
        return ret;
    }

    private void updateColor(Item firstItem) {
        String url = firstItem.getBeer().getBeerLabel();
        State state = null;

        if (!StringUtils.isBlank(url)) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            try {
                okhttp3.Response response = client.newCall(request).execute();
                InputStream is = response.body().byteStream();
                BufferedImage img = ImageIO.read(is);

                if (img != null) {
                    int colors[][] = ColorThief.getPalette(img, 5, 50, true);
                    if (colors != null) {
                        HSBType firstColor = HSBType.fromRGB(colors[0][0], colors[0][1], colors[0][2]);
                        firstColor = new HSBType(firstColor.getHue(), new PercentType(100), firstColor.getSaturation());

                        updateState(new ChannelUID(getThing().getUID(), UntappdBindingConstants.CHANNEL_LAST_COLOR),
                                firstColor);

                        int count = 0;
                        while (state == null && count < 5) {
                            int color[] = colors[count];
                            HSBType value = HSBType.fromRGB(color[0], color[1], color[2]);
                            if (value.getBrightness().longValue() > 50) {
                                state = value;
                            }
                            count++;
                        }
                    } else {
                        logger.debug("Cannot determine colors for image {}", url);
                    }
                } else {
                    logger.debug("Cannot fetch image {}", url);
                }
            } catch (IOException e) {
                logger.debug("Error fetching beer label", e);
            }
        }

        updateState(new ChannelUID(getThing().getUID(), UntappdBindingConstants.CHANNEL_LAST_COLOR_BRIGHT),
                state != null ? state : UnDefType.UNDEF);
    }

    private void startRefresh() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    updateState(getRecent());
                    updateNotfication(getNotifications());
                } catch (Exception e) {
                    logger.error("Exception in scheduled task", e);
                }
            }
        };

        refreshJob = scheduler.scheduleAtFixedRate(runnable, 0, REFRESH, TimeUnit.MINUTES);

        updateJob = new UpdateNotifier(60_000);
        new Thread(updateJob).start();

        toastJob = new ToastUpdateNotifier(5_000);
        new Thread(toastJob).start();
    }

    private void update(Item checkin) {
        String beerName = checkin.getBeer().getBeerName();
        String beerLabel = checkin.getBeer().getBeerLabel();
        String user = checkin.getUser().getFirstName() + " " + checkin.getUser().getLastName();

        Date checkinTime = checkin.getCreatedAt();
        Calendar checkinTimeCalendar = Calendar.getInstance();
        checkinTimeCalendar.setTime(checkinTime);

        updateState(new ChannelUID(getThing().getUID(), UntappdBindingConstants.CHANNEL_BEER_NAME),
                new StringType(beerName));
        updateState(new ChannelUID(getThing().getUID(), UntappdBindingConstants.CHANNEL_BEER_LABEL),
                new StringType(beerLabel));
        updateState(new ChannelUID(getThing().getUID(), UntappdBindingConstants.CHANNEL_USER), new StringType(user));
        updateState(new ChannelUID(getThing().getUID(), UntappdBindingConstants.CHANNEL_DATE_TIME),
                new DateTimeType(checkinTimeCalendar));

        updateColor(checkin);
    }

    private class UpdateNotifier extends Notifier<Item> {

        public UpdateNotifier(int delay) {
            super(delay);
        }

        @Override
        protected void handleItem(Item item) {
            logger.trace("New checkin item");

            update(item);
            triggerChannel(UntappdBindingConstants.CHANNEL_NEWCHECKIN);
        }
    }

    private class ToastUpdateNotifier extends Notifier<NotificationItem> {

        public ToastUpdateNotifier(int delay) {
            super(delay);
        }

        @Override
        protected void handleItem(NotificationItem item) {
            logger.trace("New toast item");

            updateToast(item);
            triggerChannel(UntappdBindingConstants.CHANNEL_NEWTOAST);
        }
    }

    private abstract class Notifier<T> implements Runnable {

        private int delay;

        private boolean running = true;

        private BlockingQueue<T> items = new LinkedBlockingQueue<>();

        public Notifier(int delay) {
            this.delay = delay;
        }

        @Override
        public void run() {
            try {
                while (running) {
                    handleItem(items.take());
                    Thread.sleep(delay);
                }
            } catch (InterruptedException e) {
                running = false;
                logger.error("Notify thread interrupted", e);
            }
        }

        public void addAll(List<T> list) {
            Integer noItems = list != null ? list.size() : 0;
            logger.trace("Added to UpdateNotifier: " + noItems);

            items.addAll(list);
        }

        public void shutdown() {
            running = false;
        }

        protected abstract void handleItem(T item);
    }
}
