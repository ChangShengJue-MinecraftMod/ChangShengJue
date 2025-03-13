package com.shengchanshe.changshengjue.block.food.nobox;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Lichee extends NoBoxTypeBlock{
    protected static final VoxelShape LICHEE_EAST = Block.box(4.75D, 0.0D, 5.25D, 13.5D, 3.0D, 12.0D);
    protected static final VoxelShape LICHEE_WEST = Block.box(2D, 0.0D, 4.0D, 11.25D, 3.0D, 11.5D);
    protected static final VoxelShape LICHEE_SOUTH = Block.box(4.25D, 0.0D, 4.75D, 11.5D, 3.0D, 14.0D);
    protected static final VoxelShape LICHEE_NORTH = Block.box(5.25D, 0.0D, 2.0D, 11.5D, 3.0D, 10.75D);


    public Lichee(Properties pProperties, int nutrition, float saturationMod) {
        super(pProperties, nutrition, saturationMod);
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        switch (direction) {
            case NORTH:
                return LICHEE_NORTH;
            case SOUTH:
                return LICHEE_SOUTH;
            case WEST:
                return LICHEE_WEST;
            case EAST:
                return LICHEE_EAST;
            default:
                return LICHEE_NORTH;
        }
    }
}
