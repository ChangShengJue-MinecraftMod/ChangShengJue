package com.shengchanshe.changshengjue.block.custom.tile;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.util.ChangShengJueVoxelShape;
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
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CylinderTile extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final VoxelShape AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public CylinderTile(Properties p_49795_) {
        super(p_49795_);
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
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        Direction value = state.getValue(FACING);
        if (state.is(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_1.get()) || state.is(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_1.get())
                || state.is(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_1.get()) || state.is(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_1.get())
                || state.is(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_1.get())){
            return switch (value){
                case NORTH -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_1;
                case SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_1;
                case EAST -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_1;
                default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_1;
            };
        }else if (state.is(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_3.get()) || state.is(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_3.get())
                || state.is(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_3.get()) || state.is(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_3.get())
                || state.is(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_3.get())){
            return switch (value){
                case NORTH -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_3;
                case SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_3;
                case EAST -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_3;
                default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_3;
            };
        }else if (state.is(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_4.get()) || state.is(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_4.get())
                || state.is(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_4.get()) || state.is(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_4.get())
                || state.is(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_4.get())){
            return Block.box(0, 0, 0, 16, 8, 16);
        }else {
            return AABB;
        }

    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos)
    {
        return AABB;
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
