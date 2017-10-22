/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.untappd.discovery;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.smarthome.config.discovery.AbstractDiscoveryService;
import org.eclipse.smarthome.config.discovery.DiscoveryResult;
import org.eclipse.smarthome.config.discovery.DiscoveryResultBuilder;
import org.eclipse.smarthome.core.thing.ThingUID;
import org.openhab.binding.untappd.UntappdBindingConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UntappdDiscoveryService extends AbstractDiscoveryService {

    private final Logger logger = LoggerFactory.getLogger(UntappdDiscoveryService.class);

    public UntappdDiscoveryService() {
        super(UntappdBindingConstants.SUPPORTED_THING_TYPES_UIDS, 900, false);
    }

    @Override
    protected void startScan() {
        logger.info("Startscan");
    }

    @Override
    protected synchronized void stopScan() {
        logger.info("Stopscan");
    }

    public void newThing(String token, String username) {
        ThingUID uid = new ThingUID(UntappdBindingConstants.THING_TYPE_CHECKIN, username);

        if (uid != null) {
            Map<String, Object> properties = new HashMap<>(1);
            properties.put(UntappdBindingConstants.PARAMETER_TOKEN, token);
            DiscoveryResult result = DiscoveryResultBuilder.create(uid).withProperties(properties)
                    .withLabel("Untappd " + username).build();
            thingDiscovered(result);
        }
    }
}
