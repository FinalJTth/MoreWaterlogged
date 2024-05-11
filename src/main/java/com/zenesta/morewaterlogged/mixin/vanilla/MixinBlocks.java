package com.zenesta.morewaterlogged.mixin.vanilla;

import com.zenesta.morewaterlogged.common.map.MinecraftConversionMap;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Blocks.class)
public class MixinBlocks {

    @Inject(method = "<clinit>", at = @At("HEAD"))
    private static void constructorHead(CallbackInfo ci) {
        if (MinecraftConversionMap.instance == null)
            new MinecraftConversionMap();
    }

    /**
     * @author Zenesta
     * @reason Test
     */
    @Overwrite
    public static Block register(String pKey, Block pBlock) {
        return Registry.register(BuiltInRegistries.BLOCK, pKey, MinecraftConversionMap.instance.convert(pKey, pBlock));
    }
}
