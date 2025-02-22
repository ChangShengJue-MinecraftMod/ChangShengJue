package com.shengchanshe.changshengjue.block.custom.tile;

import com.shengchanshe.changshengjue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class HalfCylinderTile extends SlabBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public HalfCylinderTile(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM).setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH));
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState pState) {
        return pState.getValue(TYPE) != SlabType.DOUBLE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        Direction value = state.getValue(FACING);
        SlabType value1 = state.getValue(TYPE);
        return switch (value){
            case NORTH, SOUTH -> value1 == SlabType.DOUBLE ? ChangShengJueVoxelShape.CYLINDER_TILE_DOUBLE_NS
                    : value1 == SlabType.BOTTOM ? ChangShengJueVoxelShape.CYLINDER_TILE_BOTTOM_NS
                    : ChangShengJueVoxelShape.CYLINDER_TILE_TOP_NS;
            default -> value1 == SlabType.DOUBLE ? ChangShengJueVoxelShape.CYLINDER_TILE_DOUBLE_EW
                    : value1 == SlabType.BOTTOM ? ChangShengJueVoxelShape.CYLINDER_TILE_BOTTOM_EW
                    : ChangShengJueVoxelShape.CYLINDER_TILE_TOP_EW;
        };
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        BlockPos clickedPos = placeContext.getClickedPos();
        BlockState blockState = placeContext.getLevel().getBlockState(clickedPos);
        if (blockState.is(this)) {
            return blockState.setValue(TYPE, SlabType.DOUBLE).setValue(WATERLOGGED, false).setValue(FACING,placeContext.getHorizontalDirection().getOpposite());
        } else {
            FluidState fluidState = placeContext.getLevel().getFluidState(clickedPos);
            BlockState blockState1 = this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM).setValue(FACING,placeContext.getHorizontalDirection().getOpposite())
                    .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER).setValue(FACING,placeContext.getHorizontalDirection().getOpposite());
            Direction clickedFace = placeContext.getClickedFace();
            return clickedFace != Direction.DOWN && (clickedFace == Direction.UP || !(placeContext.getClickLocation().y - (double)clickedPos.getY() > 0.5)) ?
                    blockState1 : blockState1.setValue(TYPE, SlabType.TOP).setValue(FACING,placeContext.getHorizontalDirection().getOpposite());
        }
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
        builder.add(FACING,TYPE, WATERLOGGED);
    }
}
