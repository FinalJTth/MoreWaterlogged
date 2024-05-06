package com.zenesta.morewaterlogged.mixin;

import com.google.common.collect.Maps;
import net.minecraft.client.main.GameConfig;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.levelgen.DebugLevelSource;
import net.minecraftforge.common.util.LogMessageAdapter;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryInternal;
import net.minecraftforge.registries.RegistryManager;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Locale;
import java.util.stream.Collectors;

@Mixin(GameData.BlockCallbacks.class)
public class MixinGameData {
    /**
     * @author Zenesta
     * @reason Test
     */
    /*
    @Overwrite(remap = false)
    public void onAdd(IForgeRegistryInternal<Block> owner, RegistryManager stage, int id, ResourceKey<Block> key, Block block, @Nullable Block oldBlock) {
        return;
    }

     */
}
