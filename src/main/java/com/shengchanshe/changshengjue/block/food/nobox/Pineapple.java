package com.shengchanshe.changshengjue.block.food.nobox;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Pineapple extends NoBoxTypeBlock{
    protected static final VoxelShape PINEAPPLE_NORTH = Block.box(5.5D, 0.0D, 5.5D, 10.5D, 10.0D, 10.5D);
    protected static final VoxelShape PINEAPPLE_SOUTH = Block.box(5.5D, 0.0D, 5.5D, 10.5D, 10.0D, 10.5D);
    protected static final VoxelShape PINEAPPLE_EAST = Block.box(5.5D, 0.0D, 5.5D, 10.5D, 10.0D, 10.5D);
    protected static final VoxelShape PINEAPPLE_WEST = Block.box(5.5D, 0.0D, 5.5D, 10.5D, 10.0D, 10.5D);

    public Pineapple(Properties pProperties, int nutrition, float saturationMod) {
        super(pProperties, nutrition, saturationMod);
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return PINEAPPLE_NORTH;
            case SOUTH:
                return PINEAPPLE_SOUTH;
            case EAST:
                return PINEAPPLE_EAST;
            case WEST:
                return PINEAPPLE_WEST;
            default:
                return PINEAPPLE_NORTH;
        }
    }
}
