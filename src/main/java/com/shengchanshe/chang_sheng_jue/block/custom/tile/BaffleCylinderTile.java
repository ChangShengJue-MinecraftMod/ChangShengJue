package com.shengchanshe.chang_sheng_jue.block.custom.tile;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BaffleCylinderTile extends CylinderTile {
    public static final BooleanProperty BAFFLE = BooleanProperty.create("baffle");
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public BaffleCylinderTile(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(BAFFLE, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        Direction value = state.getValue(FACING);
        if (state.is(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE.get()) || state.is(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE.get())
                || state.is(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE.get()) || state.is(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE.get())
                || state.is(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE.get()) || state.is(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE.get())
                || state.is(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE.get())){
            return switch (value){
                case NORTH -> state.getValue(BAFFLE) ? ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_2 : ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_2_B;
                case SOUTH -> state.getValue(BAFFLE) ? ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_2 : ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_2_B;
                case EAST -> state.getValue(BAFFLE) ? ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_2 : ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_2_B;
                default ->  state.getValue(BAFFLE) ? ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_2 : ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_2_B;
            };
        }else {
            return AABB;
        }
    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        BlockPos clickedPos = placeContext.getClickedPos();
        Level level = placeContext.getLevel();

        Direction facing = placeContext.getHorizontalDirection().getOpposite();
        BlockPos oppositePos = clickedPos.relative(facing.getOpposite());
        BlockState oppositeState = level.getBlockState(oppositePos);
        boolean hasBaffle = oppositeState.getBlock() instanceof CylinderTile;

        return this.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(BAFFLE, !hasBaffle);
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return super.rotate(blockState,rotation);
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
