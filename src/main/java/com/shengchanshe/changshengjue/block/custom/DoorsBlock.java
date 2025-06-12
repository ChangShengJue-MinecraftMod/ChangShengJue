package com.shengchanshe.changshengjue.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DoorsBlock extends DoorBlock {
    public DoorsBlock(Properties p_273303_, BlockSetType p_272854_) {
        super(p_273303_, p_272854_);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction $$4 = (Direction)pState.getValue(FACING);
        boolean $$5 = !(Boolean)pState.getValue(OPEN);
        boolean $$6 = pState.getValue(HINGE) == DoorHingeSide.RIGHT;
        switch ($$4) {
            case EAST:
            default:
                return $$5 ? EAST_AABB : ($$6 ? NORTH_AABB : SOUTH_AABB);
            case SOUTH:
                return $$5 ? SOUTH_AABB : ($$6 ? EAST_AABB : WEST_AABB);
            case WEST:
                return $$5 ? WEST_AABB : ($$6 ? SOUTH_AABB : NORTH_AABB);
            case NORTH:
                return $$5 ? NORTH_AABB : ($$6 ? WEST_AABB : EAST_AABB);
        }
    }
    // 添加新的碰撞箱
    protected static final VoxelShape MIDDLE_AABB = Block.box(0.0, 8.0, 0.0, 16.0, 24.0, 3.0);
    protected static final VoxelShape TOP_AABB = Block.box(0.0, 16.0, 0.0, 16.0, 32.0, 3.0);

    // ... 现有代码 ...

    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack) {
        BlockPos abovePos = pPos.above();
        BlockPos topPos = abovePos.above();
        pLevel.setBlock(abovePos, (BlockState)pState.setValue(HALF, DoubleBlockHalf.UPPER), 3);
        pLevel.setBlock(topPos, (BlockState)pState.setValue(HALF, DoubleBlockHalf.UPPER), 3);
    }

    // 修改碰撞检测和渲染
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos belowPos = pPos.below();
        BlockState belowState = pLevel.getBlockState(belowPos);
        return pState.getValue(HALF) == DoubleBlockHalf.LOWER ? belowState.isFaceSturdy(pLevel, belowPos, Direction.UP) : belowState.is(this);
    }

    protected static final VoxelShape SOUTH_AABB;
    protected static final VoxelShape NORTH_AABB;
    protected static final VoxelShape WEST_AABB;
    protected static final VoxelShape EAST_AABB;
    static {
        SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
        NORTH_AABB = Block.box(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
        WEST_AABB = Block.box(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        EAST_AABB = Block.box(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
    }
}
