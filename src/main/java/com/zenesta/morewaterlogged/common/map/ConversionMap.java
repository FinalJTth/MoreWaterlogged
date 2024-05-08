package com.zenesta.morewaterlogged.common.map;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.zenesta.morewaterlogged.common.MoreWaterlogged.LOGGER;

public abstract class ConversionMap {
    public static final Map<String, Map<String, Boolean>> CONFIG_MAP = new LinkedHashMap<>();
    public static final List<Boolean> HAS_INITIALIZED_LIST = Collections.synchronizedList(new ArrayList<>());
    public static final AtomicBoolean MARKED_FOR_CONFIG_CREATION = new AtomicBoolean(false);

    public abstract void initialize();

    protected void log(String key, String modId) {
        if (isKeyEnabled(key, modId))
            LOGGER.debug("Key \"{}\" matched. Replacing that block with waterlogged counterpart.", key);
        else
            LOGGER.debug("Key \"{}\" matched but is disabled. Skip the replacement.", key);
    }

    protected boolean isKeyEnabled(String key, String modId) {
        return CONFIG_MAP.get(modId).containsKey(key) && CONFIG_MAP.get(modId).get(key);
    }
}
