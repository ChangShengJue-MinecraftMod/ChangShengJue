package com.shengchanshe.changshengjue.block.food.nobox;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Mango extends NoBoxTypeBlock{
    protected static final VoxelShape PLATE_SHAPE = Block.box(3D, 0.0D, 7D, 12.25D, 5.0D, 10D);

    public Mango(Properties pProperties, int nutrition, float saturationMod) {
        super(pProperties, nutrition,saturationMod);
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return PLATE_SHAPE;
    }
}
