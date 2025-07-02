package com.shengchanshe.chang_sheng_jue.block.custom;

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
    public WallZhuTaiBlock(Properties properties, ParticleOptions particleOptions) {
        super(properties, particleOptions);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return getShape(pState);
    }

    public static VoxelShape getShape(BlockState state) {
        return AABBS.get(state.getValue(FACING));
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        return pFacing.getOpposite() == pState.getValue(FACING) && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : pState;
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
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        AABBS = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.box(4.0, 1.0, 7.0, 12.0, 13.0, 16.0),
                Direction.SOUTH, Block.box(4.0, 1.0, 0.0, 12.0, 13.0, 9.0),
                Direction.WEST, Block.box(7.0, 1.0, 4.0, 16.0, 13.0, 12.0),
                Direction.EAST, Block.box(0.0, 1.0, 4.0, 9.0, 13.0, 12.0)));
    }
}
