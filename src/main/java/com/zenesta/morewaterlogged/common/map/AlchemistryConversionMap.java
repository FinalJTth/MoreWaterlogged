package com.zenesta.morewaterlogged.common.map;

import com.zenesta.morewaterlogged.common.MoreWaterlogged;
import com.zenesta.morewaterlogged.common.block.alchemistry.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.zenesta.morewaterlogged.common.MoreWaterlogged.LOGGER;

public class AlchemistryConversionMap extends ConversionMap {
    public static AlchemistryConversionMap instance = null;

    public AlchemistryConversionMap() {
        super(MoreWaterlogged.ALCHEMISTRY_MOD_ID);
        instance = this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void initialize() {
        LOGGER.debug("Initializing blocks map for mod \"{}\"", modId);
        // Processing
        conversionMap.put("atomizer", (props) -> new AtomizerBlock());
        conversionMap.put("compactor", (props) -> new CombinerBlock());
        conversionMap.put("combiner", (props) -> new CompactorBlock());
        conversionMap.put("dissolver", (props) -> new DissolverBlock());
        conversionMap.put("liquifier", (props) -> new LiquifierBlock());

        postInitialize(conversionMap.keySet());

        hasInitialized = true;
    }

    @SuppressWarnings("unchecked")
    public Supplier<Block> convert(String key, Supplier<Block> sup) {
        if (conversionMap.containsKey(key)) {
            log(key);
            if (isKeyEnabled(key)) {
                return () -> (Block) conversionMap.get(key).apply(null);
            }
        }
        return sup;
    }
}
