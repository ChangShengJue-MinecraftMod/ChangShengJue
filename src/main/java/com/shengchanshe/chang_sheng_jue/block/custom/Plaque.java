package com.shengchanshe.chang_sheng_jue.block.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.shengchanshe.chang_sheng_jue.block.entity.PlaqueEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class Plaque extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty MIDDLE = BooleanProperty.create("middle");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
    private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.box(0.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D),
            Direction.SOUTH, Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D),
            Direction.EAST, Block.box(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 16.0D),
            Direction.WEST, Block.box(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)));

    public Plaque(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEFT, false)
                .setValue(MIDDLE, false).setValue(RIGHT, false).setValue(FACING, Direction.NORTH));
    }
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return AABBS.get(pState.getValue(FACING));
    }
    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof PlaqueEntity) {
                NetworkHooks.openScreen(((ServerPlayer)pPlayer), (PlaqueEntity)entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }
    public Direction rightOf(Direction facing) {
        return switch (facing) {
            case NORTH -> Direction.WEST;
            case EAST -> Direction.NORTH;
            case SOUTH -> Direction.EAST;
            case WEST -> Direction.SOUTH;
            default -> facing; // 如果不是水平方向，就返回原方向
        };
    }
    public Direction leftOf(Direction facing) {
        return switch (facing) {
            case NORTH -> Direction.EAST;
            case EAST -> Direction.SOUTH;
            case SOUTH -> Direction.WEST;
            case WEST -> Direction.NORTH;
            default -> facing; // 如果不是水平方向，就返回原方向
        };
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean isMoving) {
        super.neighborChanged(pState, pLevel, pPos, pBlock, pFromPos, isMoving);

        Direction facing = pState.getValue(FACING);
        Direction rightDirection = rightOf(facing);
        BlockPos posRight = pPos.relative(rightDirection); // 获取右侧的位置
        Direction leftDirection = leftOf(facing);
        BlockPos posLeft = pPos.relative(leftDirection); // 获取右侧的位置
        // 如果相邻方块的类型与当前方块相同
        if (pLevel.getBlockState(posRight).getBlock() == this && pLevel.getBlockState(posLeft).getBlock() != this ) {
            // 修改当前方块的状态
            pLevel.setBlock(pPos,  pState.setValue(RIGHT, true).setValue(MIDDLE, false).setValue(LEFT, false), 3);
        }else if (pLevel.getBlockState(posLeft).getBlock() == this && pLevel.getBlockState(posRight).getBlock() != this){
            pLevel.setBlock(pPos,  pState.setValue(RIGHT, false).setValue(MIDDLE, false).setValue(LEFT, true), 3);
        }else if (pLevel.getBlockState(posLeft).getBlock() == this || pLevel.getBlockState(posRight).getBlock() == this){
            pLevel.setBlock(pPos, pState.setValue(RIGHT, false).setValue(MIDDLE, true).setValue(LEFT, false), 3);
        }else {
            pLevel.setBlock(pPos, pState.setValue(RIGHT, false).setValue(MIDDLE, false).setValue(LEFT, false), 3);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }
    @Override
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }
    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING,LEFT,MIDDLE,RIGHT);
    }
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new PlaqueEntity(pPos,pState);
    }
}