package com.shengchanshe.changshengjue.block.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class WallZhuTaiBlock extends WallTorchBlock{
    public static final DirectionProperty FACING;
    private static final Map<Direction, VoxelShape> AABBS;
    public WallZhuTaiBlock(Properties p_57491_, ParticleOptions p_57492_) {
        super(p_57491_, p_57492_);
    }

    @Override
    public VoxelShape getShape(BlockState p_58152_, BlockGetter p_58153_, BlockPos p_58154_, CollisionContext p_58155_) {
        return getShape(p_58152_);
    }

    public static VoxelShape getShape(BlockState p_58157_) {
        return AABBS.get(p_58157_.getValue(FACING));
    }

    @Override
    public BlockState updateShape(BlockState p_58143_, Direction p_58144_, BlockState p_58145_, LevelAccessor p_58146_, BlockPos p_58147_, BlockPos p_58148_) {
        return p_58144_.getOpposite() == p_58143_.getValue(FACING) && !p_58143_.canSurvive(p_58146_, p_58147_) ? Blocks.AIR.defaultBlockState() : p_58143_;
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        double d0 = (double)blockPos.getX() + 0.5D;
        double d1 = (double)blockPos.getY() + 0.85D;
        double d2 = (double)blockPos.getZ() + 0.5D;
        level.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        level.addParticle(this.flameParticle, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }

    @Override
    public BlockState rotate(BlockState p_58140_, Rotation p_58141_) {
        return p_58140_.setValue(FACING, p_58141_.rotate(p_58140_.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState p_58137_, Mirror p_58138_) {
        return p_58137_.rotate(p_58138_.getRotation(p_58137_.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_58150_) {
        p_58150_.add(FACING);
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        AABBS = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.box(4.0, 1.0, 7.0, 12.0, 13.0, 16.0),
                Direction.SOUTH, Block.box(4.0, 1.0, 0.0, 12.0, 13.0, 9.0),
                Direction.WEST, Block.box(7.0, 1.0, 4.0, 16.0, 13.0, 12.0),
                Direction.EAST, Block.box(0.0, 1.0, 4.0, 9.0, 13.0, 12.0)));
    }
}
