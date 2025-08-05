package com.shengchanshe.chang_sheng_jue.block.custom.tile;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class Pavilion extends CylinderTile {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    protected static final VoxelShape AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public Pavilion(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        if (!pLevel.isClientSide) {
            pLevel.setBlock(pPos.above(), pState.setValue(HALF, DoubleBlockHalf.UPPER), 3);
        }
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
        super.neighborChanged(pState, pLevel, pPos, pNeighborBlock, pNeighborPos, pMovedByPiston);
        DoubleBlockHalf half = pState.getValue(HALF);
        BlockPos otherPartPos = half == DoubleBlockHalf.LOWER ? pPos.above() : pPos.below();
        BlockState otherPartState = pLevel.getBlockState(otherPartPos);

        if (otherPartState.getBlock() != this) {
            // 如果另一半不是相同的方块，则将当前部分也移除
            pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 35);
            pLevel.levelEvent(2001, pPos, Block.getId(pState));
        }
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction value = pState.getValue(FACING);
        boolean flag1 = pState.getValue(HALF) == DoubleBlockHalf.UPPER;

        if (pState.is(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.get()) || pState.is(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.get()) ||
                pState.is(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.get()) || pState.is(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.get()) ||
                    pState.is(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.get())){
            return switch (value){
                case WEST,EAST ->  flag1 ? Block.box(3, 0, 3, 13, 16, 13) : ChangShengJueVoxelShape.RIDGE_FINIAL_PAVILION_BOTTOM_EW;
                default -> flag1 ? Block.box(3, 0, 3, 13, 16, 13) : ChangShengJueVoxelShape.RIDGE_FINIAL_PAVILION_BOTTOM_NS;
            };
        }else {
            return AABB;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos clickedPos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        if (clickedPos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(clickedPos.above()).canBeReplaced(pContext)) {
            return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection()).setValue(HALF, DoubleBlockHalf.LOWER);
        } else {
            return null;
        }
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
        builder.add(HALF,FACING);
    }
}
