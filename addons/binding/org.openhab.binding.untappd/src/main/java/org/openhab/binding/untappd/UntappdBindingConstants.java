/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.untappd;

import java.util.Collections;
import java.util.Set;

import org.eclipse.smarthome.core.thing.ThingTypeUID;

/**
 * The {@link UntappdBinding} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Jeroen Idserda - Initial contribution
 */
public class UntappdBindingConstants {

    public static final String BINDING_ID = "untappd";

    // List of all Thing Type UIDs
    public final static ThingTypeUID THING_TYPE_CHECKIN = new ThingTypeUID(BINDING_ID, "checkin");

    // List of all Channel ids
    public final static String CHANNEL_NEWCHECKIN = "checkin";
    public final static String CHANNEL_NEWTOAST = "toast";

    public final static String CHANNEL_BEER_NAME = "beer_name";
    public final static String CHANNEL_BEER_LABEL = "beer_label";
    public final static String CHANNEL_USER = "user";
    public final static String CHANNEL_LAST_COLOR = "last_color";
    public final static String CHANNEL_LAST_COLOR_BRIGHT = "last_color_bright";
    public final static String CHANNEL_DATE_TIME = "date_time";

    public final static String TOAST_USER = "toast_user";

    public final static String PARAMETER_TOKEN = "token";

    public final static Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Collections.singleton(THING_TYPE_CHECKIN);

}
