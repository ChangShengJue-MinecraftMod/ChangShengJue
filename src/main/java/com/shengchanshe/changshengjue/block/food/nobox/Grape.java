package com.shengchanshe.changshengjue.block.food.nobox;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Grape extends NoBoxTypeBlock{
    protected static final VoxelShape GRAPE_WEST = Block.box(3D, 0.0D, 4D, 14D, 5.0D, 12.25D);
    protected static final VoxelShape GRAPE_EAST = Block.box(1D, 0.0D, 4D, 13D, 5.0D, 12.25D);
    protected static final VoxelShape GRAPE_NORTH = Block.box(4D, 0.0D, 3D, 12.25D, 5.0D, 14D);
    protected static final VoxelShape GRAPE_SOUTH = Block.box(4D, 0.0D, 1D, 12.25D, 5.0D, 13D);

    public Grape(BlockBehaviour.Properties pProperties, int nutrition, float saturationMod) {
        super(pProperties, nutrition,saturationMod);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        switch (direction) {
            case NORTH:
                return GRAPE_NORTH;
            case SOUTH:
                return GRAPE_SOUTH;
            case WEST:
                return GRAPE_WEST;
            case EAST:
                return GRAPE_EAST;
            default:
                return GRAPE_NORTH;
        }
    }
}
