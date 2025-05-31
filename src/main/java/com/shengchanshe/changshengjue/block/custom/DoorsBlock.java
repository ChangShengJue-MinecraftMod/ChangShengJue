package com.shengchanshe.changshengjue.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
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

    protected static final VoxelShape SOUTH_AABB;
    protected static final VoxelShape NORTH_AABB;
    protected static final VoxelShape WEST_AABB;
    protected static final VoxelShape EAST_AABB;
    static {
        SOUTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 32.0, 3.0);
        NORTH_AABB = Block.box(0.0, 0.0, 13.0, 16.0, 32.0, 16.0);
        WEST_AABB = Block.box(13.0, 0.0, 0.0, 16.0, 32.0, 16.0);
        EAST_AABB = Block.box(0.0, 0.0, 0.0, 3.0, 32.0, 16.0);
    }
}
