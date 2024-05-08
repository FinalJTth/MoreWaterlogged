package com.zenesta.morewaterlogged.mixin;

import com.zenesta.morewaterlogged.common.map.CreateConversionMap;
import com.zenesta.morewaterlogged.common.map.MinecraftConversionMap;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Blocks.class)
public class MixinBlocks {
    @Unique
    private static MinecraftConversionMap moreWaterlogged$map;

    @Inject(method = "<clinit>", at = @At("HEAD"))
    private static void constructorHead(CallbackInfo ci) {
        moreWaterlogged$map = new MinecraftConversionMap();
    }

    /**
     * @author Zenesta
     * @reason Test
     */
    @Overwrite
    public static Block register(String pKey, Block pBlock) {
        return Registry.register(BuiltInRegistries.BLOCK, pKey, moreWaterlogged$map.convert(pKey, pBlock));
    }
}
