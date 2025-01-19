package com.shengchanshe.changshengjue.block.custom.furniture.desk;

import com.shengchanshe.changshengjue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BookDesk extends AbstractDesk {
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
    private VoxelShape AABB = Shapes.empty();

    public BookDesk(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(RIGHT, false));
    }

    public Direction rightOf(Direction facing) {
        switch (facing) {
            case NORTH:
                return Direction.WEST;
            case EAST:
                return Direction.NORTH;
            case SOUTH:
                return Direction.EAST;
            case WEST:
                return Direction.SOUTH;
            default:
                return facing; // 如果不是水平方向，就返回原方向
        }
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Direction facing = pState.getValue(FACING);
        Direction rightDirection = rightOf(facing);
        BlockPos pos2 = pPos.relative(rightDirection); // 获取右侧的位置
        if (!pLevel.getBlockState(pos2).canBeReplaced()) {
            return false; // 如果某个位置不可替换，返回 false
        }
        return true; // 如果没有阻挡，允许放置
    }

    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!world.isClientSide) {
            Direction facing = state.getValue(FACING);
            Direction rightDirection = rightOf(facing);
            BlockPos pos2 = pos.relative(rightDirection); // 获取右侧的位置
            // 检查目标位置是否已经有合适的方块，避免递归放置
            if (world.isEmptyBlock(pos2) && !state.getValue(RIGHT)) { // 只有当目标位置为空时才放置新方块
                // 根据需要调整状态
                BlockState newState = this.defaultBlockState().setValue(RIGHT, true).setValue(FACING, facing);
                world.setBlockAndUpdate(pos2, newState);
            }
        }
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        if (pState.getBlock() != pNewState.getBlock()) {
            Direction facing = pState.getValue(FACING);
            Direction rightDirection = rightOf(pState.getValue(RIGHT) ? facing.getOpposite() : facing);
            BlockPos pos2 = pPos.relative(rightDirection);
            BlockState stateAtPos2 = pLevel.getBlockState(pos2);
            if (stateAtPos2.getBlock() == this) {
                // 安全移除方块，确保更新
                pLevel.setBlock(pos2, Blocks.AIR.defaultBlockState(), 3); // 3 表示立即更新并重新计算光照
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction value = pState.getValue(FACING);
        boolean flag1 = pState.getValue(RIGHT);

        return switch (value){
            case SOUTH ->  flag1 ? this.AABB = ChangShengJueVoxelShape.BOOK_DESK_SOUTH_RIGHT : ChangShengJueVoxelShape.BOOK_DESK_SOUTH_LEFT;
            case WEST ->  flag1 ? this.AABB = ChangShengJueVoxelShape.BOOK_DESK_WEST_RIGHT : ChangShengJueVoxelShape.BOOK_DESK_WEST_LEFT;
            case EAST ->  flag1 ? this.AABB = ChangShengJueVoxelShape.BOOK_DESK_EAST_RIGHT : ChangShengJueVoxelShape.BOOK_DESK_EAST_LEFT;
            default -> flag1 ? this.AABB = ChangShengJueVoxelShape.BOOK_DESK_NORTH_RIGHT : ChangShengJueVoxelShape.BOOK_DESK_NORTH_LEFT;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING,RIGHT);
    }
}
