package com.zenesta.morewaterlogged.common.map;

import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public abstract class RegistrateConversionMap extends ConversionMap {
    public RegistrateConversionMap(String modId) {
        super(modId);
    }

    @SuppressWarnings("unchecked")
    public <T> NonNullFunction<BlockBehaviour.Properties, T> convert(String key, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        if (conversionMap.containsKey(key)) {
            log(key);
            if (isKeyEnabled(key)) {
                return (props) -> (T) conversionMap.get(key).apply(props);
            }
        }
        return factory;
    }
}
