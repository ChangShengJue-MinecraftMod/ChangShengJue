package com.shengchanshe.chang_sheng_jue.block.custom.bracket;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Dougong extends ChineseBracketLong{
    public Dougong(Properties properties) {
        super(properties);
    }

    protected static final VoxelShape BASE_AABB = Block.box(0, 0.1, 0, 16, 15.9, 16);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        boolean isSide = state.getValue(ATTACHED_TO_SIDE);

        if (isSide) {
            return switch (direction) {
                case NORTH -> BASE_AABB;
                case SOUTH -> BASE_AABB;
                case WEST -> BASE_AABB;
                case EAST -> BASE_AABB;
                default -> BASE_AABB;
            };
        } else {
            return switch (direction) {
                case NORTH -> BASE_AABB;
                case SOUTH -> BASE_AABB;
                case WEST -> BASE_AABB;
                case EAST -> BASE_AABB;
                default -> BASE_AABB;
            };
        }
    }

}
