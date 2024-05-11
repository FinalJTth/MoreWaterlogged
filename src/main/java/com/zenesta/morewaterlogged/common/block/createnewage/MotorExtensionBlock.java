package com.zenesta.morewaterlogged.common.block.createnewage;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.antarcticgardens.newage.NewAgeBlockEntityTypes;
import org.antarcticgardens.newage.content.motors.MotorBlockEntity;
import org.antarcticgardens.newage.content.motors.extension.MotorExtensionBlockEntity;
import org.antarcticgardens.newage.content.motors.extension.variants.AdvancedMotorExtensionVariant;
import org.antarcticgardens.newage.content.motors.extension.variants.BasicMotorExtensionVariant;
import org.antarcticgardens.newage.content.motors.extension.variants.IMotorExtensionVariant;
import org.antarcticgardens.newage.content.motors.variants.AdvancedMotorVariant;
import org.antarcticgardens.newage.content.motors.variants.BasicMotorVariant;
import org.antarcticgardens.newage.content.motors.variants.IMotorVariant;
import org.antarcticgardens.newage.content.motors.variants.ReinforcedMotorVariant;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class MotorExtensionBlock extends org.antarcticgardens.newage.content.motors.extension.MotorExtensionBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static MotorExtensionBlock basic(Properties properties) {
        return new MotorExtensionBlock(properties, NewAgeBlockEntityTypes.BASIC_MOTOR_EXTENSION, new BasicMotorExtensionVariant());
    }

    public static MotorExtensionBlock advanced(Properties properties) {
        return new MotorExtensionBlock(properties, NewAgeBlockEntityTypes.ADVANCED_MOTOR_EXTENSION, new AdvancedMotorExtensionVariant());
    }

    public MotorExtensionBlock(Properties properties, BlockEntityEntry<MotorExtensionBlockEntity> entry, IMotorExtensionVariant variant) {
        super(properties, entry, variant);
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
