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

        // 获取邻近方块位置
        BlockPos northPos = pPos.north();
        BlockPos southPos = pPos.south();
        BlockPos eastPos = pPos.east();
        BlockPos westPos = pPos.west();

        // 获取邻近方块的状态
        boolean northNeighbor = isSameBlock(pLevel, northPos);
        boolean southNeighbor = isSameBlock(pLevel, southPos);
        boolean eastNeighbor = isSameBlock(pLevel, eastPos);
        boolean westNeighbor = isSameBlock(pLevel, westPos);

        // 计算新的状态
        BlockState newState = pState
                .setValue(NORTH, northNeighbor)
                .setValue(SOUTH, southNeighbor)
                .setValue(EAST, eastNeighbor)
                .setValue(WEST, westNeighbor);

        // 如果四个方向的状态都是 true，则设置 MIDDLE 为 true
        boolean allNeighbors = northNeighbor && southNeighbor && eastNeighbor && westNeighbor;
        newState = newState.setValue(MIDDLE, allNeighbors);

        // 更新方块状态
        pLevel.setBlock(pPos, newState, 3); // 更新状态，标记为需要同步到客户端
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Block.box(0,1,0,16,16,16);
    }
//    @Override
//    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
//        Direction facing = pState.getValue(FACING); // 获取朝向
//        Boolean north = pState.getValue(NORTH); // 获取是否打开
//        Boolean east = pState.getValue(EAST); // 获取是否打开
//        Boolean south = pState.getValue(SOUTH); // 获取是否打开
//        Boolean west = pState.getValue(WEST); // 获取是否打开
//        Boolean middle = pState.getValue(MIDDLE);
//
//        boolean f = north && east && south && west && middle;
//        boolean n = north && !east && !south && !west && !middle;
//        boolean e = !north && east && !south && !west && !middle;
//        boolean s = !north && !east && south && !west && !middle;
//        boolean w = !north && !east && !south && west && !middle;
//        boolean ns = north && !east && south && !west && !middle;
//        boolean ew = !north && east && !south && west && !middle;
////      根据是否打开选择碰撞箱的形状
////      OPEN = false 时，保持原始碰撞箱
//        return switch (facing) {
//            case WEST -> w ? ChangShengJueVoxelShape.WINE_TABLE_WEST_SIDE : ChangShengJueVoxelShape.WINE_TABLE;
//            case EAST -> e ? ChangShengJueVoxelShape.WINE_TABLE_EAST_SIDE : ChangShengJueVoxelShape.WINE_TABLE;
//            case SOUTH -> s ? ChangShengJueVoxelShape.WINE_TABLE_SOUTH_SIDE : ChangShengJueVoxelShape.WINE_TABLE;
//            default -> n ? ChangShengJueVoxelShape.WINE_TABLE_NORTH_SIDE : ChangShengJueVoxelShape.WINE_TABLE;
//        };
//    }


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
