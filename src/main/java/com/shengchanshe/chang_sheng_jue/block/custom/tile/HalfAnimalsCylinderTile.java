package com.shengchanshe.chang_sheng_jue.block.custom.tile;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class HalfAnimalsCylinderTile extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED;
    public static final int MAX_HEIGHT = 3;
    public static final IntegerProperty LAYERS;

    public HalfAnimalsCylinderTile(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LAYERS, 1)
                .setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH));
    }

    public boolean placeLiquid(LevelAccessor pLevel, BlockPos pPos, BlockState pState, FluidState pFluidState) {
        return SimpleWaterloggedBlock.super.placeLiquid(pLevel, pPos, pState, pFluidState);
    }

    public boolean canPlaceLiquid(BlockGetter pLevel, BlockPos pPos, BlockState pState, Fluid pFluid) {
        return SimpleWaterloggedBlock.super.canPlaceLiquid(pLevel, pPos, pState, pFluid);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        int value1 = state.getValue(LAYERS);
        return value1 == 2 ? Block.box(0, 0, 0, 16, 12, 16)
                : value1 == 1 ? Block.box(0, 0, 0, 16, 8, 16)
                : Block.box(0, 0, 0, 16, 16, 16);
    }

    public boolean canBeReplaced(BlockState pState, BlockPlaceContext pContext) {
        int layers = pState.getValue(LAYERS);
        if (pContext.getItemInHand().is(this.asItem()) && layers < MAX_HEIGHT) {
            if (pContext.replacingClickedOnBlock()) {
                return pContext.getClickedFace() == Direction.UP;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        BlockPos clickedPos = placeContext.getClickedPos();
        Level level = placeContext.getLevel();
        BlockState blockState = level.getBlockState(clickedPos);

        if (blockState.is(this)) {
            int existingLayers = blockState.getValue(LAYERS);
            return blockState.setValue(LAYERS, Math.min(MAX_HEIGHT, existingLayers + 1))
                    .setValue(FACING, placeContext.getHorizontalDirection().getOpposite());
        }
        return this.defaultBlockState().setValue(FACING, placeContext.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, false);
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return super.rotate(blockState,rotation);
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return super.mirror(blockState, mirror);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED,LAYERS);
    }

    static {
        LAYERS = BlockStateProperties.LAYERS;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }
}
