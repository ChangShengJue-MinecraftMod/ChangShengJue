package com.shengchanshe.changshengjue.block.food.cibei;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CiBeiFood extends CiBeiTypeBlock{
    protected static final VoxelShape PLATE_SHAPE = Block.box(5.5D, 0.0D, 5.5D, 10.5D, 5.0D, 10.5D);
    protected static final VoxelShape PIE_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(6.5D, 1.0D, 6.5D, 9.5D, 5.0D, 9.5D), BooleanOp.OR);


    public CiBeiFood(BlockBehaviour.Properties properties, boolean hasLeftovers, int nutrition, float saturationMod) {
        super(properties, hasLeftovers, nutrition, saturationMod);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(TYPES) == 0 ? PLATE_SHAPE : PIE_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPES);
    }
}
