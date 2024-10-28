package com.shengchanshe.changshengjue.block.building;

import com.shengchanshe.changshengjue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.WorldlyContainerHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PigTrough extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty LEVEL = IntegerProperty.create("level", 0, 8);
    private VoxelShape AABB = Shapes.empty();
    public PigTrough(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LEVEL, 0).setValue(FACING, Direction.NORTH));
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
        if (!pLevel.getBlockState(pos2).isAir()) {
            return false; // 如果被阻挡，返回false，阻止方块放置
        }
        return true; // 如果没有阻挡，允许放置
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.getItem() == Items.WHEAT) {
            if (!world.isClientSide) {
                int level = state.getValue(LEVEL);
                if (level < 8) {
                    world.setBlock(pos, state.setValue(LEVEL, level + 1), 3);
                    if (!player.isCreative()) {
                        itemStack.shrink(1);
                    }
                    updateAdjacentTrough(world, pos, state);
                }
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    private void updateAdjacentTrough(Level world, BlockPos pos, BlockState state) {
        Direction facing = state.getValue(FACING);
        Direction rightDirection = rightOf(facing);
        BlockPos pos2 = pos.relative(rightDirection); // 获取右侧的位置
        BlockState rightState = world.getBlockState(pos2);
        if (rightState.getBlock() == this) { // 检查是否是同类型的猪食槽
            int rightLevel = rightState.getValue(LEVEL);
            if (rightLevel < 8) {
                world.setBlock(pos2, rightState.setValue(LEVEL, rightLevel + 1), 3);
            }
        }
    }

    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!world.isClientSide) {
            Direction facing = state.getValue(FACING);
            Direction rightDirection = rightOf(facing);
            BlockPos pos2 = pos.relative(rightDirection); // 获取右侧的位置
            // 检查目标位置是否已经有合适的方块，避免递归放置
            if (world.isEmptyBlock(pos2)) { // 只有当目标位置为空时才放置新方块
                // 根据需要调整状态
                BlockState newState = this.defaultBlockState().setValue(FACING, facing.getOpposite());
                world.setBlockAndUpdate(pos2, newState);
            }
        }
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            Direction facing = state.getValue(FACING);
            Direction rightDirection = rightOf(facing);
            BlockPos pos2 = pos.relative(rightDirection);
            BlockState stateAtPos2 = world.getBlockState(pos2);
            if (stateAtPos2.getBlock() == this) {
                // 安全移除方块，确保更新
                world.setBlock(pos2, Blocks.AIR.defaultBlockState(), 3); // 3 表示立即更新并重新计算光照
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction value = pState.getValue(FACING);
        return switch (value){
            case SOUTH -> this.AABB = ChangShengJueVoxelShape.CHANG_SHENG_JUE_PIG_TROUGH_SOUTH;
            case WEST -> this.AABB = ChangShengJueVoxelShape.CHANG_SHENG_JUE_PIG_TROUGH_WEST;
            case EAST -> this.AABB = ChangShengJueVoxelShape.CHANG_SHENG_JUE_PIG_TROUGH_EAST;
            default -> this.AABB = ChangShengJueVoxelShape.CHANG_SHENG_JUE_PIG_TROUGH_NORTH;
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING,LEVEL);
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }
    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

}
