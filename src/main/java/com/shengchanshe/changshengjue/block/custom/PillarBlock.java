package com.shengchanshe.changshengjue.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PillarBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    protected static VoxelShape AABB = Shapes.empty();

    public PillarBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        Direction value = blockState.getValue(FACING);
        switch (value){
            case NORTH :
                return AABB = Block.box(7.0D, 0.0D, 11.25D, 9.0D, 16.0D, 14.25D);
            case SOUTH:
                return AABB = Block.box(7.0D, 0.0D, 1.75D, 9.0D, 16.0D, 4.75D);
            case EAST:
                return AABB = Block.box(1.75D, 0.0D, 7.0D, 4.75D, 16.0D, 9.0D);
            case WEST:
                return AABB = Block.box(11.25D, 0.0D, 7.0D, 14.25D, 16.0D, 9.0D);
        }
        return AABB;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return this.defaultBlockState().setValue(FACING,placeContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING,rotation.rotate(blockState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return super.mirror(blockState, mirror);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
