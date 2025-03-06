package com.shengchanshe.changshengjue.block.food.nobox;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Mulberry extends NoBoxTypeBlock{
    protected static final VoxelShape PLATE_SHAPE = Block.box(4.25D, 0.0D, 6D, 11.2D, 2.5D, 9.8D);

    public Mulberry(Properties pProperties, int nutrition, float saturationMod) {
        super(pProperties, nutrition,saturationMod);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return PLATE_SHAPE;
    }
}
