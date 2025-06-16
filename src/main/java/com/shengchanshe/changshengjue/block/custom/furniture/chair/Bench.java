package com.shengchanshe.changshengjue.block.custom.furniture.chair;

import com.shengchanshe.changshengjue.entity.decoration.seat.SeatEntity;
import com.shengchanshe.changshengjue.tags.CSJTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Bench extends Chair {
    public Bench(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        return SeatEntity.useOn(pLevel, pPos, 0.4, pPlayer, pState.getValue(FACING));
    }
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction facing = pState.getValue(FACING); // 获取朝向
        return switch (facing) {
            case WEST , EAST-> Block.box(3, 0, 0.5, 13, 10, 15.5);
            default -> Block.box(0.5, 0, 3, 15.5, 10, 13);
        };
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean isMoving) {
        super.neighborChanged(pState, pLevel, pPos, pBlock, pFromPos, isMoving);
        splicingBlock(pState,pLevel,pPos,FACING,CSJTags.Blocks.BENCH,RIGHT,LEFT,MIDDLE);
    }
}
