package com.zenesta.morewaterlogged.mixin;

import com.mojang.datafixers.types.Type;
import com.zenesta.morewaterlogged.common.MoreWaterlogged;
import com.zenesta.morewaterlogged.common.block.BellBlock;
// import com.zenesta.morewaterlogged.common.block.entity.BedBlockEntity;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BellBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import static com.zenesta.morewaterlogged.common.MoreWaterlogged.BED_BLOCK_ENTITY_TYPE;
import static com.zenesta.morewaterlogged.common.MoreWaterlogged.BELL_BLOCK_ENTITY_TYPE;

@Mixin(BlockEntityType.class)
public class MixinBlockEntityType {
    /*
    @Shadow
    private static <T extends BlockEntity> BlockEntityType<T> register(String pKey, BlockEntityType.Builder<T> pBuilder) {
        return null;
    }
     */
    /*
    @Shadow
    public static final BlockEntityType<BellBlockEntity> BELL = BELL_BLOCK_ENTITY_TYPE;
    @Shadow
    public static final BlockEntityType<BedBlockEntity> BED = BED_BLOCK_ENTITY_TYPE;
     */
}
