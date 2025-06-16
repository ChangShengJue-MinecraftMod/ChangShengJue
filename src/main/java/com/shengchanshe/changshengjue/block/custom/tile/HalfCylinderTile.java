package com.shengchanshe.changshengjue.block.custom.tile;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class HalfCylinderTile extends SlabBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty BAFFLE = BooleanProperty.create("baffle");

    public HalfCylinderTile(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM)
                .setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH).setValue(BAFFLE, false));
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState pState) {
        return pState.getValue(TYPE) != SlabType.DOUBLE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        SlabType value1 = state.getValue(TYPE);
        return value1 == SlabType.DOUBLE ? Block.box(0, 0, 0, 16, 16, 16)
                : value1 == SlabType.BOTTOM ? Block.box(0, 0, 0, 16, 8, 16)
                : Block.box(0, 8, 0, 16, 16, 16);
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
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        // 获取放置方块和触发事件的方块的状态
        BlockState fromState = level.getBlockState(fromPos);

        // 如果放置的方块和触发事件的方块是相同的
        if (state.getBlock() == fromState.getBlock() && state.getValue(TYPE) == fromState.getValue(TYPE) && state.getValue(FACING) == fromState.getValue(FACING)) {
            // 更改放置方块的BAFFLE属性
            level.setBlock(fromPos, state.setValue(BAFFLE, true), 3);
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
        builder.add(FACING,TYPE, WATERLOGGED,BAFFLE);
    }
}
