package com.shengchanshe.chang_sheng_jue.block.custom.furniture.chair;

import com.shengchanshe.chang_sheng_jue.entity.decoration.seat.SeatEntity;
import com.shengchanshe.chang_sheng_jue.util.ChangShengJueVoxelShape;
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

public class TaishiChair extends HorizontalDirectionalBlock {

    public TaishiChair(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        return SeatEntity.useOn(pLevel, pPos, 0.3, pPlayer, pState.getValue(FACING));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction facing = pState.getValue(FACING); // 获取朝向
        return switch (facing) {
            case WEST -> ChangShengJueVoxelShape.TAISHI_CHAIR_WEST;
            case EAST-> ChangShengJueVoxelShape.TAISHI_CHAIR_EAST;
            case SOUTH -> ChangShengJueVoxelShape.TAISHI_CHAIR_SOUTH;
            default -> ChangShengJueVoxelShape.TAISHI_CHAIR_NORTH;
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
