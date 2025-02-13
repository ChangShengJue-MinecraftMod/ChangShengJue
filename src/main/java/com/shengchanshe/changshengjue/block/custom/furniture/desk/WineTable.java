package com.shengchanshe.changshengjue.block.custom.furniture.desk;

import com.shengchanshe.changshengjue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WineTable extends AbstractDesk {
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    public static final BooleanProperty MIDDLE = BooleanProperty.create("middle");

    public WineTable(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false).setValue(MIDDLE,false).setValue(FACING, Direction.NORTH));
    }
    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean isMoving) {
        super.neighborChanged(pState, pLevel, pPos, pBlock, pFromPos, isMoving);

        // 获取当前位置的北方向坐标
        BlockPos northPos = pPos.north();
        // 获取当前位置的南方向坐标
        BlockPos southPos = pPos.south();
        // 获取当前位置的东方向坐标
        BlockPos eastPos = pPos.east();
        // 获取当前位置的西方向坐标
        BlockPos westPos = pPos.west();

        // 检查北方向的邻居块是否与当前块相同
        boolean northNeighbor = isSameBlock(pLevel, northPos);
        // 检查南方向的邻居块是否与当前块相同
        boolean southNeighbor = isSameBlock(pLevel, southPos);
        // 检查东方向的邻居块是否与当前块相同
        boolean eastNeighbor = isSameBlock(pLevel, eastPos);
        // 检查西方向的邻居块是否与当前块相同
        boolean westNeighbor = isSameBlock(pLevel, westPos);

        // 创建一个新的BlockState对象，基于当前的pState对象，并设置其四个方向的邻居状态
        BlockState newState = pState
                // 设置北方向的邻居状态为northNeighbor
                .setValue(NORTH, northNeighbor)
                // 设置南方向的邻居状态为southNeighbor
                .setValue(SOUTH, southNeighbor)
                // 设置东方向的邻居状态为eastNeighbor
                .setValue(EAST, eastNeighbor)
                // 设置西方向的邻居状态为westNeighbor
                .setValue(WEST, westNeighbor);

        // 检查当前方块的所有邻近方块是否存在
        // northNeighbor 表示北方邻近方块是否存在
        // southNeighbor 表示南方邻近方块是否存在
        // eastNeighbor 表示东方邻近方块是否存在
        // westNeighbor 表示西方邻近方块是否存在
        boolean allNeighbors = northNeighbor && southNeighbor && eastNeighbor && westNeighbor;
        // 设置新的状态
        // newState 是一个对象，它有一个方法 setValue
        // MIDDLE 是一个常量，表示中间状态
        // allNeighbors 是一个布尔值，表示所有邻居是否存在
        // 将 allNeighbors 的值设置为 MIDDLE 状态
        newState = newState.setValue(MIDDLE, allNeighbors);

        // 更新方块状态
        pLevel.setBlock(pPos, newState, 3); // 更新状态，标记为需要同步到客户端
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
        boolean middle = pState.getValue(MIDDLE);

        // 根据属性值返回不同的VoxelShape
        return south && north && east && !middle ? ChangShengJueVoxelShape.WINE_TABLE_MIDDLE_SIDE : south && west && east && !middle ? ChangShengJueVoxelShape.WINE_TABLE_MIDDLE_SIDE :
                south && north && west && !middle ? ChangShengJueVoxelShape.WINE_TABLE_MIDDLE_SIDE : north && west && east && !middle ? ChangShengJueVoxelShape.WINE_TABLE_MIDDLE_SIDE :

                south && east && !middle ? ChangShengJueVoxelShape.WINE_TABLE_NORTH_WEST_SIDE : south && west && !middle ? ChangShengJueVoxelShape.WINE_TABLE_SOUTH_WEST_SIDE :
                north && east && !middle ? ChangShengJueVoxelShape.WINE_TABLE_SOUTH_EAST_SIDE : north && west && !middle ? ChangShengJueVoxelShape.WINE_TABLE_NORTH_EAST_SIDE :

                south && north && !middle ? ChangShengJueVoxelShape.WINE_TABLE_NORTH_SOUTH_SIDE : east && west && !middle ? ChangShengJueVoxelShape.WINE_TABLE_EAST_WEST_SIDE :
                south && !middle ? ChangShengJueVoxelShape.WINE_TABLE_WEST_SIDE : north && !middle ? ChangShengJueVoxelShape.WINE_TABLE_EAST_SIDE :
                east && !middle ? ChangShengJueVoxelShape.WINE_TABLE_SOUTH_SIDE : west && !middle ? ChangShengJueVoxelShape.WINE_TABLE_NORTH_SIDE :
                middle ? ChangShengJueVoxelShape.WINE_TABLE_MIDDLE : ChangShengJueVoxelShape.WINE_TABLE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        // 这里仍然设置方块的朝向为玩家的反方向
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, NORTH, EAST, SOUTH, WEST, MIDDLE);
    }

    // 检查邻近方块是否是相同的方块
    private boolean isSameBlock(Level pLevel, BlockPos pos) {
        BlockState neighborState = pLevel.getBlockState(pos);
        return neighborState.getBlock() instanceof WineTable; // 检查邻近方块是否是 WineTable
    }
}
