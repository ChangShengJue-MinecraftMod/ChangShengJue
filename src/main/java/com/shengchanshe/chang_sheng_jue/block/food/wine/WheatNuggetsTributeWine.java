package com.shengchanshe.chang_sheng_jue.block.food.wine;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WheatNuggetsTributeWine extends WineBlock {

    protected static final VoxelShape PLATE_SHAPE = Block.box(2.75D, 0.0D, 2.75D, 13.25D, 12.0D, 13.25D);


    public WheatNuggetsTributeWine(Properties properties, boolean hasLeftovers, int fed, float fedpro) {
        super(properties, hasLeftovers, fed, fedpro);
    }


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return PLATE_SHAPE;
    }
}
