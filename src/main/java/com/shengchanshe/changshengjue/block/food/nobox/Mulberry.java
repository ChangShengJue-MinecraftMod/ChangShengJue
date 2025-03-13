package com.shengchanshe.changshengjue.block.food.nobox;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Mulberry extends NoBoxTypeBlock {
    protected static final VoxelShape MULBERRY_NORTH = Block.box(4.25D, 0.0D, 6D, 11.2D, 2.5D, 9.8D);
    protected static final VoxelShape MULBERRY_SOUTH = Block.box(4.8D, 0.0D, 6D, 11.15D, 2.5D, 10.2D);
    protected static final VoxelShape MULBERRY_EAST = Block.box(6D, 0.0D, 4.25D, 10.2D, 2.5D, 11.2D);
    protected static final VoxelShape MULBERRY_WEST = Block.box(6D, 0.0D, 4.8D, 9.8D, 2.5D, 11.15D);


    public Mulberry(Properties pProperties, int nutrition, float saturationMod) {
        super(pProperties, nutrition, saturationMod);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return MULBERRY_NORTH;
            case SOUTH:
                return MULBERRY_SOUTH;
            case EAST:
                return MULBERRY_EAST;
            case WEST:
                return MULBERRY_WEST;
            default:
                return MULBERRY_NORTH;
        }
    }
}
