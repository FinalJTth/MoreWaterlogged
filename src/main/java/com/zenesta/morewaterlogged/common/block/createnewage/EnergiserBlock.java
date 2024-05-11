package com.zenesta.morewaterlogged.common.block.createnewage;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.antarcticgardens.newage.NewAgeBlockEntityTypes;
import org.antarcticgardens.newage.content.energiser.EnergiserBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class EnergiserBlock extends org.antarcticgardens.newage.content.energiser.EnergiserBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static EnergiserBlock createT1(BlockBehaviour.Properties properties) {
        return new EnergiserBlock(properties, 1, NewAgeBlockEntityTypes.ENERGISER_T1);
    }

    public static EnergiserBlock createT2(BlockBehaviour.Properties properties) {
        return new EnergiserBlock(properties, 2, NewAgeBlockEntityTypes.ENERGISER_T2);
    }

    public static EnergiserBlock createT3(BlockBehaviour.Properties properties) {
        return new EnergiserBlock(properties, 3, NewAgeBlockEntityTypes.ENERGISER_T3);
    }

    public EnergiserBlock(Properties properties, int tier, BlockEntityEntry<EnergiserBlockEntity> entry) {
        super(properties, tier, entry);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos clickPos = context.getClickedPos();
        FluidState fluidAtPos = context.getLevel().getFluidState(clickPos);
        BlockState superState = super.getStateForPlacement(context);
        return superState != null ? superState.setValue(WATERLOGGED, fluidAtPos.getType() == Fluids.WATER) : null;
    }

    @SuppressWarnings("deprecation")
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }
}
