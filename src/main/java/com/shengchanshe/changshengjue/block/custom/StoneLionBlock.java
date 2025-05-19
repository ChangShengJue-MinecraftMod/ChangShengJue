package com.shengchanshe.changshengjue.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
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

public class StoneLionBlock extends HorizontalDirectionalBlock {
    protected static VoxelShape AABB = Shapes.empty();
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public StoneLionBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter p_57511_, BlockPos p_57512_, CollisionContext p_57513_) {
        Direction value = blockState.getValue(FACING);
        switch (value){
            case NORTH :
                return AABB = Block.box(-1.0D, 0.0D, -8.0D, 17.0D, 32.0D, 16.0D);
            case SOUTH:
                return AABB = Block.box(-1.0D, 0.0D, 0.0D, 17.0D, 32.0D, 24.0D);
            case EAST:
                return AABB = Block.box(0.0D, 0.0D, -1.0D, 24.0D, 32.0D, 17.0D);
            case WEST:
                return AABB = Block.box(-8.0D, 0.0D, -1.0D, 16.0D, 32.0D, 17.0D);
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
