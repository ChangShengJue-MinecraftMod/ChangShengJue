package com.shengchanshe.changshengjue.block.food.nobox;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Corn extends NoBoxTypeBlock{
//    protected static final VoxelShape PLATE_SHAPE = Block.box(3.5D, 0.0D, 5.5D, 12.5D, 5.0D, 10.5D);

    protected static final VoxelShape CORN_EAST = Block.box(3.5D, 0.0D, 5.5D, 12.5D, 5.0D, 10.5D);
    protected static final VoxelShape CORN_SOUTH = Block.box(5.5D, 0.0D, 3.5D, 10.5D, 5.0D, 12.5D);
    protected static final VoxelShape CORN_WEST = Block.box(3.5D, 0.0D, 5.5D, 12.5D, 5.0D, 10.5D);
    protected static final VoxelShape CORN_NORTH = Block.box(5.5D, 0.0D, 3.5D, 10.5D, 5.0D, 12.5D);



    public Corn(Properties pProperties, int nutrition, float saturationMod) {
        super(pProperties, nutrition,saturationMod);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        switch (direction) {
            case NORTH:
                return CORN_NORTH;
            case SOUTH:
                return CORN_SOUTH;
            case WEST:
                return CORN_WEST;
            case EAST:
                return CORN_EAST;
            default:
                return CORN_NORTH; // 默认情况
        }
    }



}
