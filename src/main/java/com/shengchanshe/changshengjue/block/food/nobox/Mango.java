package com.shengchanshe.changshengjue.block.food.nobox;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Mango extends NoBoxTypeBlock{
    protected static final VoxelShape NORTH_SHAPE = Block.box(3D, 0.0D, 7D, 12.25D, 5.0D, 10D);
    protected static final VoxelShape SOUTH_SHAPE = Block.box(3.75D, 0.0D, 6D, 13D, 5.0D, 9D);
    protected static final VoxelShape WEST_SHAPE = Block.box(7D, 0.0D, 3.75D, 10D, 5.0D, 13D);
    protected static final VoxelShape EAST_SHAPE = Block.box(6D, 0.0D, 3D, 9D, 5.0D, 12.25D);

    public Mango(Properties pProperties, int nutrition, float saturationMod) {
        super(pProperties, nutrition,saturationMod);
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
                return EAST_SHAPE;
            default:
                return PLATE_SHAPE;
        }
    }

}
