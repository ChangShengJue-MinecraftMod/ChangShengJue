package com.shengchanshe.changshengjue.block.custom.tile;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BaffleCylinderTile extends CylinderTile {
    public static final BooleanProperty BAFFLE = BooleanProperty.create("baffle");

    public BaffleCylinderTile(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(BAFFLE, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        Direction value = state.getValue(FACING);
        if (state.is(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_5.get()) || state.is(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_5.get())
                || state.is(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_5.get()) || state.is(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_5.get())
                || state.is(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_5.get())){
            return switch (value){
                case NORTH -> state.getValue(BAFFLE) ? ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_NS_5_B : ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_5;
                case SOUTH -> state.getValue(BAFFLE) ? ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_NS_5_B : ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_5;
                case EAST -> state.getValue(BAFFLE) ? ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_EW_5_B : ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_5;
                default ->  state.getValue(BAFFLE) ? ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_EW_5_B : ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_5;
            };
        }if (state.is(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_2.get()) || state.is(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_2.get())
                || state.is(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_2.get()) || state.is(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_2.get())
                || state.is(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_2.get())){
            return switch (value){
                case NORTH -> state.getValue(BAFFLE) ? ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_2_B : ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_2;
                case SOUTH -> state.getValue(BAFFLE) ? ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_2_B : ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_2;
                case EAST -> state.getValue(BAFFLE) ? ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_2_B : ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_2;
                default ->  state.getValue(BAFFLE) ? ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_2_B : ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_2;
            };
        }else {
            return AABB;
        }
    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getClickedFace();
        BlockState blockstate = this.defaultBlockState().setValue(FACING,pContext.getHorizontalDirection().getOpposite())
                .setValue(BAFFLE, direction == Direction.NORTH || direction == Direction.EAST || direction == Direction.WEST || direction == Direction.SOUTH);
        return blockstate;
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return super.mirror(blockState, mirror);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING,BAFFLE);
    }
}
