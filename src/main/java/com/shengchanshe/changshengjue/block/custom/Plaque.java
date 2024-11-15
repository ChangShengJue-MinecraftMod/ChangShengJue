package com.shengchanshe.changshengjue.block.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.shengchanshe.changshengjue.block.entity.PlaqueEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class Plaque extends WallSignBlock{
    private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.box(0.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D),
            Direction.SOUTH, Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D),
            Direction.EAST, Block.box(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 16.0D),
            Direction.WEST, Block.box(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)));

    public Plaque(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return AABBS.get(pState.getValue(FACING));
    }
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new PlaqueEntity(pPos,pState);
    }

    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
}
