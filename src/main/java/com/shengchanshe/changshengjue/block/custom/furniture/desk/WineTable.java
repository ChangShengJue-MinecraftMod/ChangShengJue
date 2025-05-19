package com.shengchanshe.changshengjue.block.custom.furniture.desk;

import com.shengchanshe.changshengjue.util.ChangShengJueVoxelShape;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class WineTable extends Desks {
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    protected static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION;

    public WineTable(Properties pProperties) {
        super(pProperties);
//        this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, false)
//                .setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false));
        this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, false)
                .setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(FACING, Direction.NORTH));

    }

// 获取方块形状的方法，参数包括方块状态、方块获取器、方块位置和碰撞上下文
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        // 使用switch表达式根据方块状态中的NORTH, EAST, SOUTH, WEST, MIDDLE属性值来返回不同的VoxelShape

        // 获取NORTH, EAST, SOUTH, WEST, MIDDLE属性值
        boolean north = pState.getValue(NORTH);
        boolean east = pState.getValue(EAST);
        boolean south = pState.getValue(SOUTH);
        boolean west = pState.getValue(WEST);

        // 根据属性值返回不同的VoxelShape
        return south && north && east && west ? ChangShengJueVoxelShape.WINE_TABLE_MIDDLE :
                south && north && east ? ChangShengJueVoxelShape.WINE_TABLE_MIDDLE_SIDE_1 :
                south && west && east ? ChangShengJueVoxelShape.WINE_TABLE_MIDDLE_SIDE :
                south && north && west ? ChangShengJueVoxelShape.WINE_TABLE_MIDDLE_SIDE_1 :
                        north && west && east ? ChangShengJueVoxelShape.WINE_TABLE_MIDDLE_SIDE :
                                south && east ? ChangShengJueVoxelShape.WINE_TABLE_NORTH_WEST_SIDE :
                                south && west ? ChangShengJueVoxelShape.WINE_TABLE_SOUTH_WEST_SIDE :
                                north && east ? ChangShengJueVoxelShape.WINE_TABLE_SOUTH_EAST_SIDE :
                                        north && west ? ChangShengJueVoxelShape.WINE_TABLE_NORTH_EAST_SIDE :
                                                south && north ? ChangShengJueVoxelShape.WINE_TABLE_NORTH_SOUTH_SIDE :
                                                        east && west ? ChangShengJueVoxelShape.WINE_TABLE_EAST_WEST_SIDE :
                                                                south ? ChangShengJueVoxelShape.WINE_TABLE_WEST_SIDE :
                                                                        north ? ChangShengJueVoxelShape.WINE_TABLE_EAST_SIDE :
                                                                        east ? ChangShengJueVoxelShape.WINE_TABLE_SOUTH_SIDE :
                                                                                west ? ChangShengJueVoxelShape.WINE_TABLE_NORTH_SIDE : ChangShengJueVoxelShape.WINE_TABLE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockGetter $$1 = pContext.getLevel();
        BlockPos $$2 = pContext.getClickedPos();
        BlockPos $$4 = $$2.north();
        BlockPos $$5 = $$2.east();
        BlockPos $$6 = $$2.south();
        BlockPos $$7 = $$2.west();
        BlockState $$8 = $$1.getBlockState($$4);
        BlockState $$9 = $$1.getBlockState($$5);
        BlockState $$10 = $$1.getBlockState($$6);
        BlockState $$11 = $$1.getBlockState($$7);
        return super.getStateForPlacement(pContext).
                setValue(NORTH, this.isSameBlock($$8)).
                setValue(EAST, this.isSameBlock($$9)).
                setValue(SOUTH, this.isSameBlock($$10)).
                setValue(WEST, this.isSameBlock($$11));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING,NORTH, EAST, WEST, SOUTH);
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {

        return pFacing.getAxis().getPlane() == Direction.Plane.HORIZONTAL ?
                pState.setValue(PROPERTY_BY_DIRECTION.get(pFacing),
                        this.isSameBlock(pFacingState)) : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    public BlockState rotate(BlockState pState, Rotation pRot) {
        switch (pRot) {
            case CLOCKWISE_180 -> {
                return pState.setValue(NORTH, pState.getValue(SOUTH)).setValue(EAST, pState.getValue(WEST))
                        .setValue(SOUTH, pState.getValue(NORTH)).setValue(WEST, pState.getValue(EAST));
            }
            case COUNTERCLOCKWISE_90 -> {
                return pState.setValue(NORTH, pState.getValue(EAST)).setValue(EAST, pState.getValue(SOUTH))
                        .setValue(SOUTH, pState.getValue(WEST)).setValue(WEST, pState.getValue(NORTH));
            }
            case CLOCKWISE_90 -> {
                return pState.setValue(NORTH, pState.getValue(WEST)).setValue(EAST, pState.getValue(NORTH))
                        .setValue(SOUTH, pState.getValue(EAST)).setValue(WEST, pState.getValue(SOUTH));
            }
            default -> {
                return pState;
            }
        }
    }

    public BlockState mirror(BlockState pState, Mirror pMirror) {
        switch (pMirror) {
            case LEFT_RIGHT -> {
                return pState.setValue(NORTH, pState.getValue(SOUTH)).setValue(SOUTH, pState.getValue(NORTH));
            }
            case FRONT_BACK -> {
                return pState.setValue(EAST, pState.getValue(WEST)).setValue(WEST, pState.getValue(EAST));
            }
            default -> {
                return super.mirror(pState, pMirror);
            }
        }
    }

    // 检查邻近方块是否是相同的方块
    private boolean isSameBlock(BlockState pState) {
        return pState.getBlock() instanceof WineTable;
    }

    static {
        PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION.entrySet().stream().filter((p_52346_) -> (p_52346_.getKey()).getAxis().isHorizontal()).collect(Util.toMap());
    }
}