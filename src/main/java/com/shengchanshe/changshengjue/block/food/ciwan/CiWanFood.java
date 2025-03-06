package com.shengchanshe.changshengjue.block.food.ciwan;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CiWanFood extends WanTypeBlock{
    protected static final VoxelShape PLATE_SHAPE = Block.box(3.5D, 0.0D, 3.5D, 12.5D, 5.0D, 12.5D);
    protected static final VoxelShape PIE_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(4.5D, 2.0D, 4.5D, 11.5D, 7.0D, 11.5D), BooleanOp.OR);


    public CiWanFood(Properties properties, boolean hasLeftovers, int nutrition, float saturationMod) {
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
