package com.zenesta.morewaterlogged.common.map;

import static com.zenesta.morewaterlogged.common.MoreWaterlogged.LOGGER;

public abstract class ConversionMap {

    public abstract void initialize();

    protected void log(String name) {
        LOGGER.debug("Key \"{}\" matched. Replacing that block with waterlogged counterpart.", name);
    }
}
