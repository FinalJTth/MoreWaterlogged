package com.zenesta.morewaterlogged.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import static com.zenesta.morewaterlogged.common.MoreWaterlogged.BED_BLOCK_ENTITY_TYPE;

public class BedBlockEntity extends BlockEntity {
    private DyeColor color;

    public BedBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BED_BLOCK_ENTITY_TYPE, pPos, pBlockState);
        this.color = ((BedBlock)pBlockState.getBlock()).getColor();
    }

    public BedBlockEntity(BlockPos pPos, BlockState pBlockState, DyeColor pColor) {
        super(BED_BLOCK_ENTITY_TYPE, pPos, pBlockState);
        this.color = pColor;
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public DyeColor getColor() {
        return this.color;
    }

    public void setColor(DyeColor pColor) {
        this.color = pColor;
    }
}