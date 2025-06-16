package com.shengchanshe.changshengjue.block.custom.furniture.desk;

import com.shengchanshe.changshengjue.tags.CSJTags;
import com.shengchanshe.changshengjue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LowDesk extends Desks {
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty MIDDLE = BooleanProperty.create("middle");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
    private VoxelShape AABB = Shapes.empty();

    public LowDesk(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LEFT, false)
                .setValue(MIDDLE, false)
                .setValue(RIGHT, false)
                .setValue(FACING, Direction.NORTH));
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

    public Direction leftOf(Direction facing) {
        switch (facing) {
            case NORTH:
                return Direction.EAST;
            case EAST:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.WEST;
            case WEST:
                return Direction.NORTH;
            default:
                return facing; // 如果不是水平方向，就返回原方向
        }
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
        super.neighborChanged(pState, pLevel, pPos, pNeighborBlock, pNeighborPos, pMovedByPiston);
        splicingBlock(pState,pLevel,pPos,FACING, CSJTags.Blocks.LOW_DESK,RIGHT,LEFT,MIDDLE);
    }

    public void splicingBlock(BlockState pState, Level pLevel, BlockPos pPos, DirectionProperty directionProperty, TagKey<Block> blockTagKey, BooleanProperty right, BooleanProperty left, BooleanProperty middle){
        Direction facing = pState.getValue(directionProperty);
        Direction rightDirection = rightOf(facing);
        BlockPos posRight = pPos.relative(rightDirection); // 获取右侧的位置
        Direction leftDirection = leftOf(facing);
        BlockPos posLeft = pPos.relative(leftDirection); // 获取左侧的位置
        // 如果相邻方块的类型与当前方块相同
        if (pLevel.getBlockState(posRight).getBlock().defaultBlockState().is(blockTagKey) && !(pLevel.getBlockState(posLeft).getBlock().defaultBlockState().is(blockTagKey)) && facing == pLevel.getBlockState(posRight).getValue(directionProperty)) {
            // 修改当前方块的状态
            pLevel.setBlock(pPos,  pState.setValue(right, true).setValue(middle, false).setValue(left, false), 3);
        }else if (pLevel.getBlockState(posLeft).getBlock().defaultBlockState().is(blockTagKey) && !(pLevel.getBlockState(posRight).getBlock().defaultBlockState().is(blockTagKey)) && facing == pLevel.getBlockState(posLeft).getValue(directionProperty)){
            pLevel.setBlock(pPos,  pState.setValue(right, false).setValue(middle, false).setValue(left, true), 3);
        }else if (pLevel.getBlockState(posLeft).getBlock().defaultBlockState().is(blockTagKey) && pLevel.getBlockState(posRight).getBlock().defaultBlockState().is(blockTagKey)){
            if (facing == pLevel.getBlockState(posLeft).getValue(directionProperty) && facing == pLevel.getBlockState(posRight).getValue(directionProperty)){
                pLevel.setBlock(pPos, pState.setValue(right, true).setValue(middle, true).setValue(left, true), 3);
            }else {
                if (pLevel.getBlockState(posRight).getBlock().defaultBlockState().is(blockTagKey) && facing == pLevel.getBlockState(posRight).getValue(directionProperty) && facing != pLevel.getBlockState(posLeft).getValue(directionProperty)) {
                    // 修改当前方块的状态
                    pLevel.setBlock(pPos,  pState.setValue(right, true).setValue(middle, false).setValue(left, false), 3);
                }else if (pLevel.getBlockState(posLeft).getBlock().defaultBlockState().is(blockTagKey) && facing == pLevel.getBlockState(posLeft).getValue(directionProperty) && facing != pLevel.getBlockState(posRight).getValue(directionProperty)){
                    pLevel.setBlock(pPos,  pState.setValue(right, false).setValue(middle, false).setValue(left, true), 3);
                }else {
                    pLevel.setBlock(pPos, pState.setValue(right, false).setValue(middle, false).setValue(left, false), 3);
                }
            }
        }else {
            pLevel.setBlock(pPos, pState.setValue(right, false).setValue(middle, false).setValue(left, false), 3);
        }
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING,LEFT,MIDDLE,RIGHT);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction value = pState.getValue(FACING);
        boolean left = pState.getValue(LEFT);
        boolean middle = pState.getValue(MIDDLE);
        boolean right = pState.getValue(RIGHT);
        return switch (value){
            case SOUTH ->  !left && !middle && !right ? this.AABB = ChangShengJueVoxelShape.LOW_DESK_SOUTH : !middle && !right ? ChangShengJueVoxelShape.LOW_DESK_SOUTH_SIDE : left && middle && right ? ChangShengJueVoxelShape.LOW_DESK_NORTH_AND_SOUTH_MIDDLE : ChangShengJueVoxelShape.LOW_DESK_NORTH_SIDE;
            case WEST ->  !left && !middle && !right ? this.AABB = ChangShengJueVoxelShape.LOW_DESK_WEST : !middle && !right ? ChangShengJueVoxelShape.LOW_DESK_WEST_SIDE : left && middle && right ? ChangShengJueVoxelShape.LOW_DESK_WEST_AND_EAST_MIDDLE : ChangShengJueVoxelShape.LOW_DESK_EAST_SIDE;
            case EAST ->  !left && !middle && !right ? this.AABB = ChangShengJueVoxelShape.LOW_DESK_EAST : !middle && !right ? ChangShengJueVoxelShape.LOW_DESK_EAST_SIDE : left && middle && right ? ChangShengJueVoxelShape.LOW_DESK_WEST_AND_EAST_MIDDLE : ChangShengJueVoxelShape.LOW_DESK_WEST_SIDE;
            default ->  !left && !middle && !right ? this.AABB = ChangShengJueVoxelShape.LOW_DESK_NORTH : !middle && !right ? ChangShengJueVoxelShape.LOW_DESK_NORTH_SIDE : left && middle && right ? ChangShengJueVoxelShape.LOW_DESK_NORTH_AND_SOUTH_MIDDLE : ChangShengJueVoxelShape.LOW_DESK_SOUTH_SIDE;
        };
    }
}
