package com.shengchanshe.changshengjue.block.food.wine;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EmptyShiLiXiang extends WineBlock{
    protected static final VoxelShape PLATE_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.55D, 11.0D);

    public EmptyShiLiXiang(Properties properties, boolean hasLeftovers, int nutrition, float saturationMod) {
        super(properties, hasLeftovers, nutrition, saturationMod);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return PLATE_SHAPE;
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPES);
    }
}
