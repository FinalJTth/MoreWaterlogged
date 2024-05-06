package com.zenesta.morewaterlogged.mixin;

import com.zenesta.morewaterlogged.common.map.ConversionMap;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Blocks.class)
public class MixinBlocks {
    /**
     * @author Zenesta
     * @reason Test
     */
    @Overwrite
    public static Block register(String pKey, Block pBlock) {
        final ConversionMap map = new ConversionMap();
        return Registry.register(BuiltInRegistries.BLOCK, pKey, map.parse(pKey, pBlock));
    }
}
