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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

    private Logger logger = LoggerFactory.getLogger(UntappdHandler.class);

    private ScheduledFuture<?> refreshJob;

    private UntappdService service;

    private Integer lastId = null;

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
    }

    private Recent getRecent() {
        logger.trace("getRecent");

        Call<Recent> call = service.recent(accessToken, lastId);
        try {
            return call.execute().body();
        } catch (IOException e) {
            logger.debug("Error getting recent checkins", e);
        }

        return null;
    }

    private void updateState(Recent body) {
        logger.trace("updateState");

        if (body == null) {
            logger.warn("Recent update from untappd is null");
            return;
        }

        List<Item> checkins = body.getResponse().getCheckins().getItems();
        Item checkin = getFirstFilteredCheckin(checkins);
        if (checkin != null) {
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
            updateState(new ChannelUID(getThing().getUID(), UntappdBindingConstants.CHANNEL_USER),
                    new StringType(user));
            updateState(new ChannelUID(getThing().getUID(), UntappdBindingConstants.CHANNEL_DATE_TIME),
                    new DateTimeType(checkinTimeCalendar));

            updateColor(checkin);
            triggerChannel(UntappdBindingConstants.CHANNEL_NEWCHECKIN);

        }

        if (checkins.size() > 0) {
            lastId = checkins.get(0).getCheckinId();
        }
    }

    private Item getFirstFilteredCheckin(List<Item> checkins) {
        for (Item checkin : checkins) {
            if (!filterSelf || !checkin.getUser().getRelationship().equals("self")) {
                return checkin;
            }
        }

        return null;
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
                int colors[][] = ColorThief.getPalette(img, 5, 50, true);

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
                updateState(getRecent());
            }
        };

        refreshJob = scheduler.scheduleAtFixedRate(runnable, 0, REFRESH, TimeUnit.MINUTES);
    }
}
