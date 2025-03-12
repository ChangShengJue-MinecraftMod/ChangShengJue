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
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CylinderTile extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final VoxelShape AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public CylinderTile(Properties properties) {
        super(properties);
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
        }else if (state.is(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_5.get()) || state.is(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_5.get())
                || state.is(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_5.get()) || state.is(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_5.get())
                || state.is(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_5.get())){
            return switch (value){
                case NORTH -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_5;
                case SOUTH -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_5;
                case EAST -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_5;
                default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_5;
            };
        }else if (state.is(ChangShengJueBlocks.GRE_ROOF_RIDGE.get()) || state.is(ChangShengJueBlocks.RED_ROOF_RIDGE.get())
                || state.is(ChangShengJueBlocks.BLACK_ROOF_RIDGE.get()) || state.is(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.get())
                || state.is(ChangShengJueBlocks.BLUE_ROOF_RIDGE.get())){
            return switch (value){
                case NORTH ,SOUTH-> Shapes.join(Block.box(0, 0, 0, 16, 5, 16), Block.box(4, 5, 0, 12, 13, 16), BooleanOp.OR);
                default ->  Shapes.join(Block.box(0, 0, 0, 16, 5, 16), Block.box(0, 5, 4, 16, 13, 12), BooleanOp.OR);
            };
        }else if (state.is(ChangShengJueBlocks.GRE_DEMON_MASK.get()) || state.is(ChangShengJueBlocks.RED_DEMON_MASK.get())
                || state.is(ChangShengJueBlocks.BLACK_DEMON_MASK.get()) || state.is(ChangShengJueBlocks.GOLDEN_DEMON_MASK.get())
                || state.is(ChangShengJueBlocks.BLUE_DEMON_MASK.get())){
            return switch (value){
                case NORTH -> ChangShengJueVoxelShape.DEMON_MASK_N;
                case SOUTH -> ChangShengJueVoxelShape.DEMON_MASK_S;
                case EAST -> ChangShengJueVoxelShape.DEMON_MASK_E;
                default ->  ChangShengJueVoxelShape.DEMON_MASK_W;
            };
        }else if (state.is(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_7.get()) || state.is(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_7.get())
                || state.is(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_7.get()) || state.is(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_7.get())
                || state.is(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_7.get())){
            return Block.box(2, 0, 2, 15, 14, 15);
        }else if (state.is(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get()) || state.is(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get())
                || state.is(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get()) || state.is(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get())
                || state.is(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get())){
            return switch (value){
                case NORTH -> ChangShengJueVoxelShape.DOUBLE_GABLE_RIDGE_CYLINDER_TILE_N;
                case SOUTH -> ChangShengJueVoxelShape.DOUBLE_GABLE_RIDGE_CYLINDER_TILE_S;
                case EAST -> ChangShengJueVoxelShape.DOUBLE_GABLE_RIDGE_CYLINDER_TILE_E;
                default ->  ChangShengJueVoxelShape.DOUBLE_GABLE_RIDGE_CYLINDER_TILE_W;
            };
        }else if (state.is(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get()) || state.is(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get())
                || state.is(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get()) || state.is(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get())
                || state.is(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get())){
            return switch (value){
                case NORTH -> ChangShengJueVoxelShape.DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE_N;
                case SOUTH -> ChangShengJueVoxelShape.DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE_S;
                case EAST -> ChangShengJueVoxelShape.DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE_E;
                default ->  ChangShengJueVoxelShape.DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE_W;
            };
        }else if (state.is(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE.get()) || state.is(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE.get())
                || state.is(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE.get()) || state.is(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE.get())
                || state.is(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE.get())){
            return switch (value){
                case NORTH -> ChangShengJueVoxelShape.SHORT_CYLINDER_TILE_N;
                case SOUTH -> ChangShengJueVoxelShape.SHORT_CYLINDER_TILE_S;
                case EAST -> ChangShengJueVoxelShape.SHORT_CYLINDER_TILE_E;
                default ->  ChangShengJueVoxelShape.SHORT_CYLINDER_TILE_W;
            };
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
