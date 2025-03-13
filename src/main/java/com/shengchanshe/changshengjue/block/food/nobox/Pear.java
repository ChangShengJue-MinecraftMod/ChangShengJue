package com.shengchanshe.changshengjue.block.food.nobox;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Pear extends NoBoxTypeBlock{
    protected static final VoxelShape PEAR_NORTH = Block.box(6D, 0.0D, 5D, 10D, 8.0D, 9D);
    protected static final VoxelShape PEAR_SOUTH = Block.box(6D, 0.0D, 7D, 10D, 8.0D, 11D);
    protected static final VoxelShape PEAR_EAST = Block.box(7D, 0.0D, 6D, 11D, 8.0D, 10D);
    protected static final VoxelShape PEAR_WEST = Block.box(5D, 0.0D, 6D, 9D, 8.0D, 10D);

    public Pear(Properties pProperties, int nutrition, float saturationMod) {
        super(pProperties, nutrition, saturationMod);
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return PEAR_NORTH;
            case SOUTH:
                return PEAR_SOUTH;
            case EAST:
                return PEAR_EAST;
            case WEST:
                return PEAR_WEST;
            default:
                return super.getShape(state, level, pos, context);
        }
    }
}
