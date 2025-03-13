package com.shengchanshe.changshengjue.block.food.nobox;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class Banana extends NoBoxTypeBlock{

//    protected static final VoxelShape PLATE_BANANA = Block.box(1D, 0.0D, 4D, 12.82D, 4.25D, 12D);
    protected static final VoxelShape BANANA_WEST = Block.box(1.0D, 0.0D, 4D, 15.2D, 4.25D, 12D);
    protected static final VoxelShape BANANA_EAST = Block.box(0.8D, 0.0D, 4D, 15.0D, 4.25D, 12D);
    protected static final VoxelShape BANANA_SOUTH = Block.box(4D, 0.0D, 3.0D, 12D, 4.25D, 15.5D);
    protected static final VoxelShape BANANA_NORTH = Block.box(4D, 0.0D, 3.0D, 12D, 4.25D, 15.5D);




    public Banana(Properties pProperties, int nutrition, float saturationMod) {
        super(pProperties, nutrition,saturationMod);
    }


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        switch (direction) {
            case NORTH:
                return BANANA_NORTH;
            case SOUTH:
                return BANANA_SOUTH;
            case WEST:
                return BANANA_WEST;
            case EAST:
                return BANANA_EAST;
            default:
                return BANANA_NORTH; // 默认情况
        }
    }

}
