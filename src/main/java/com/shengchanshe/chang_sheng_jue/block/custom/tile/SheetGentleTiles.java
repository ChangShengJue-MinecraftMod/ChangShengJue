package com.shengchanshe.chang_sheng_jue.block.custom.tile;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class SheetGentleTiles extends StairBlock {
    public static final int MAX_HEIGHT = 2;
    public static final IntegerProperty LAYERS = BlockStateProperties.LAYERS;

    public SheetGentleTiles(BlockState pBaseState, Properties pProperties) {
        super(pBaseState, pProperties);
        this.registerDefaultState(this.defaultBlockState()
                .setValue(LAYERS, 1)
                .setValue(FACING, Direction.NORTH)
                .setValue(HALF, Half.BOTTOM)
                .setValue(SHAPE, StairsShape.STRAIGHT)
                .setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, SHAPE, WATERLOGGED, LAYERS);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos clickedPos = context.getClickedPos();
        Level level = context.getLevel();
        BlockState existingState = level.getBlockState(clickedPos);

        // 如果点击的是同类型方块，增加层数
        if (existingState.is(this)) {
            int existingLayers = existingState.getValue(LAYERS);
            if (existingLayers < MAX_HEIGHT) {
                return existingState.setValue(LAYERS, existingLayers + 1)
                        .setValue(WATERLOGGED, false);
            }
        }

        // 否则使用父类的放置逻辑
        BlockState parentState = super.getStateForPlacement(context);
        if (parentState != null) {
            return parentState.setValue(LAYERS, 1);
        }
        return null;
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        int layers = state.getValue(LAYERS);
        // 允许在层数未达上限时替换（增加层数）
        if (context.getItemInHand().is(this.asItem()) && layers < MAX_HEIGHT) {
            if (context.replacingClickedOnBlock()) {
                return context.getClickedFace() == Direction.UP;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        int layers = pState.getValue(LAYERS);
        if (layers == 1) {
            return Block.box(0, 0, 0, 16, 8, 16);
        }
        return super.getShape(pState, pLevel, pPos, pContext);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }
}