package com.shengchanshe.changshengjue.block.custom.furniture.chair;

import com.shengchanshe.changshengjue.entity.decoration.seat.SeatEntity;
import com.shengchanshe.changshengjue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FiveScreenThrone extends HorizontalDirectionalBlock {

    public FiveScreenThrone(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        return SeatEntity.useOn(pLevel, pPos, 0.5, pPlayer, pState.getValue(FACING));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction facing = pState.getValue(FACING); // 获取朝向
        return switch (facing) {
            case WEST -> ChangShengJueVoxelShape.FIVE_SCREEN_THRONE_WEST;
            case EAST-> ChangShengJueVoxelShape.FIVE_SCREEN_THRONE_EAST;
            case SOUTH -> ChangShengJueVoxelShape.FIVE_SCREEN_THRONE_SOUTH;
            default -> ChangShengJueVoxelShape.FIVE_SCREEN_THRONE_NORTH;
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}
