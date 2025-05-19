package com.shengchanshe.changshengjue.block.custom.furniture.chair;

import com.shengchanshe.changshengjue.entity.decoration.seat.SeatEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

public class Chair extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty MIDDLE = BooleanProperty.create("middle");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");

    public Chair(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LEFT, false)
                .setValue(MIDDLE, false)
                .setValue(RIGHT, false)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        return SeatEntity.useOn(pLevel, pPos, 0.4, pPlayer, pState.getValue(FACING));
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
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return super.mirror(blockState, mirror);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING,LEFT,MIDDLE,RIGHT);
    }
}
