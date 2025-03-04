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
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class FiveScreenThrone extends HorizontalDirectionalBlock {
    //五围屏宝座
    public static final VoxelShape FIVE_SCREEN_THRONE_NORTH;
    public static final VoxelShape FIVE_SCREEN_THRONE_EAST;
    public static final VoxelShape FIVE_SCREEN_THRONE_SOUTH;
    public static final VoxelShape FIVE_SCREEN_THRONE_WEST;
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
            case WEST -> FIVE_SCREEN_THRONE_WEST;
            case EAST-> FIVE_SCREEN_THRONE_EAST;
            case SOUTH -> FIVE_SCREEN_THRONE_SOUTH;
            default -> FIVE_SCREEN_THRONE_NORTH;
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


    static {
        FIVE_SCREEN_THRONE_NORTH = Stream.of(
                Block.box(-4.25, 0, -0.3500000000000032, 20.25, 8, 22.65),
                Block.box(-3.349999999999998, 9.5, 0.4499999999999975, 19.349999999999998, 10.75, 21.25),
                Block.box(-4.5, 7.75, -0.5500000000000025, 20.5, 9, 22.449999999999996),
                Block.box(14, 9, 21.449999999999996, 20.5, 20, 22.449999999999996),
                Block.box(-4.5, 9, 21.449999999999996, 2, 20, 22.449999999999996),
                Block.box(19.5, 9, 1.9499999999999975, 20.5, 14, 11.45),
                Block.box(19.5, 9, 11.45, 20.5, 17, 21.449999999999996),
                Block.box(-4.5, 9, 11.45, -3.5, 17, 21.449999999999996),
                Block.box(-4.5, 9, 1.9499999999999975, -3.5, 14, 11.45),
                Block.box(2, 9, 21.449999999999996, 14, 24.5, 22.449999999999996),
                Block.box(-4, 8.700000000000001, 0.6999999999999975, 20, 9.7, 21.699999999999996)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
        FIVE_SCREEN_THRONE_EAST = Stream.of(
                Block.box(-6.649999999999999, 0, -4.25, 16.35, 8, 20.25),
                Block.box(-5.25, 9.5, -3.349999999999998, 15.550000000000002, 10.75, 19.349999999999998),
                Block.box(-6.449999999999996, 7.75, -4.5, 16.550000000000004, 9, 20.5),
                Block.box(-6.449999999999996, 9, 14, -5.449999999999996, 20, 20.5),
                Block.box(-6.449999999999996, 9, -4.5, -5.449999999999996, 20, 2),
                Block.box(4.550000000000001, 9, 19.5, 14.050000000000002, 14, 20.5),
                Block.box(-5.449999999999996, 9, 19.5, 4.550000000000001, 17, 20.5),
                Block.box(-5.449999999999996, 9, -4.5, 4.550000000000001, 17, -3.5),
                Block.box(4.550000000000001, 9, -4.5, 14.050000000000002, 14, -3.5),
                Block.box(-6.449999999999996, 9, 2, -5.449999999999996, 24.5, 14),
                Block.box(-5.699999999999996, 8.700000000000001, -4, 15.300000000000002, 9.7, 20)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
        FIVE_SCREEN_THRONE_SOUTH = Stream.of(
                Block.box(-4.25, 0, -6.649999999999999, 20.25, 8, 16.35),
                Block.box(-3.349999999999998, 9.5, -5.25, 19.349999999999998, 10.75, 15.550000000000002),
                Block.box(-4.5, 7.75, -6.449999999999996, 20.5, 9, 16.550000000000004),
                Block.box(-4.5, 9, -6.449999999999996, 2, 20, -5.449999999999996),
                Block.box(14, 9, -6.449999999999996, 20.5, 20, -5.449999999999996),
                Block.box(-4.5, 9, 4.550000000000001, -3.5, 14, 14.050000000000002),
                Block.box(-4.5, 9, -5.449999999999996, -3.5, 17, 4.550000000000001),
                Block.box(19.5, 9, -5.449999999999996, 20.5, 17, 4.550000000000001),
                Block.box(19.5, 9, 4.550000000000001, 20.5, 14, 14.050000000000002),
                Block.box(2, 9, -6.449999999999996, 14, 24.5, -5.449999999999996),
                Block.box(-4, 8.700000000000001, -5.699999999999996, 20, 9.7, 15.300000000000002)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
        FIVE_SCREEN_THRONE_WEST = Stream.of(
                Block.box(-0.3500000000000014, 0, -4.25, 22.65, 8, 20.25),
                Block.box(0.4499999999999975, 9.5, -3.349999999999998, 21.25, 10.75, 19.349999999999998),
                Block.box(-0.5500000000000043, 7.75, -4.5, 22.449999999999996, 9, 20.5),
                Block.box(21.449999999999996, 9, -4.5, 22.449999999999996, 20, 2),
                Block.box(21.449999999999996, 9, 14, 22.449999999999996, 20, 20.5),
                Block.box(1.9499999999999975, 9, -4.5, 11.45, 14, -3.5),
                Block.box(11.45, 9, -4.5, 21.449999999999996, 17, -3.5),
                Block.box(11.45, 9, 19.5, 21.449999999999996, 17, 20.5),
                Block.box(1.9499999999999975, 9, 19.5, 11.45, 14, 20.5),
                Block.box(21.449999999999996, 9, 2, 22.449999999999996, 24.5, 14),
                Block.box(0.6999999999999975, 8.700000000000001, -4, 21.699999999999996, 9.7, 20)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }
}
