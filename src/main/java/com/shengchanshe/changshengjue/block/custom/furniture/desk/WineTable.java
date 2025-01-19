package com.shengchanshe.changshengjue.block.custom.furniture.desk;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

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
