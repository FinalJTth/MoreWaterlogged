package com.zenesta.morewaterlogged.common.map;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.lang.invoke.MethodHandle;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.zenesta.morewaterlogged.common.MoreWaterlogged.LOGGER;

public abstract class ConversionMap {
    public static AlchemistryConversionMap instance;

    public static final Map<String, Map<String, Boolean>> CONFIG_MAP = new LinkedHashMap<>();
    public static final List<Boolean> HAS_INITIALIZED_LIST = Collections.synchronizedList(new ArrayList<>());
    public static final AtomicBoolean MARKED_FOR_CONFIG_CREATION = new AtomicBoolean(false);

    public Boolean hasInitialized = false;
    public String modId = "";

    public final Map<String, Function<BlockBehaviour.Properties, SimpleWaterloggedBlock>> conversionMap = new LinkedHashMap<>();

    public ConversionMap(String modId) {
        this.modId = modId;
        initialize();
    }

    protected abstract void initialize();

    protected void log(String key) {
        if (isKeyEnabled(key))
            LOGGER.debug("Key \"{}\" matched. Replacing that block with waterlogged counterpart.", key);
        else
            LOGGER.debug("Key \"{}\" matched but is disabled. Skip the replacement.", key);
    }

    protected boolean isKeyEnabled(String key) {
        return CONFIG_MAP.get(modId).containsKey(key) && CONFIG_MAP.get(modId).get(key);
    }

    protected void postInitialize(Set<String> keys) {
        if (!CONFIG_MAP.containsKey(modId)) {
            CONFIG_MAP.put(modId, new LinkedHashMap<>());
        }

        for (String key : keys) {
            if (!CONFIG_MAP.get(modId).containsKey(key)) {
                LOGGER.debug("[{}] key {} is not in the config file. Adding one.", modId, key);
                MARKED_FOR_CONFIG_CREATION.set(true);
                CONFIG_MAP.get(modId).put(key, true);
            }
        }

        HAS_INITIALIZED_LIST.add(true);
    }
}
