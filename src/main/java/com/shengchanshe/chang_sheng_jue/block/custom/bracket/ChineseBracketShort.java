package com.shengchanshe.chang_sheng_jue.block.custom.bracket;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChineseBracketShort extends Block implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty ATTACHED_TO_SIDE = BooleanProperty.create("attached_to_side");

    // 统一碰撞箱（关闭状态的碰撞箱）
    protected static final VoxelShape NORTH_AABB = Block.box(7.0, 0.0, 0.0, 9.0, 16.0, 16.0);
    protected static final VoxelShape SOUTH_AABB = Block.box(7.0, 0.0, 0.0, 9.0, 16.0, 16.0);
    protected static final VoxelShape WEST_AABB = Block.box(0.0, 0.0, 7.0, 16.0, 16.0, 9.0);
    protected static final VoxelShape EAST_AABB = Block.box(0.0, 0.0, 7.0, 16.0, 16.0, 9.0);


    public ChineseBracketShort(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
                .setValue(ATTACHED_TO_SIDE, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        boolean isSide = state.getValue(ATTACHED_TO_SIDE);

        if (isSide) {
            return switch (direction) {
                case NORTH -> NORTH_AABB;
                case SOUTH -> SOUTH_AABB;
                case WEST -> WEST_AABB;
                case EAST -> EAST_AABB;
                default -> NORTH_AABB;
            };
        } else {
            return switch (direction) {
                case NORTH -> NORTH_AABB;
                case SOUTH -> SOUTH_AABB;
                case WEST -> WEST_AABB;
                case EAST -> EAST_AABB;
                default -> NORTH_AABB;
            };
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Direction clickedFace = context.getClickedFace();
        FluidState fluidState = context.getLevel().getFluidState(pos);

        // 判断是否点击的是侧面或底面
        boolean isSidePlacement = clickedFace.getAxis().isHorizontal();
        boolean isBottomPlacement = clickedFace == Direction.DOWN;

        // 根据点击的面确定方向
        Direction facing;
        if (isSidePlacement) {
            // 侧面放置时，支架朝向与点击面的方向一致
            facing = clickedFace;
        } else if (isBottomPlacement) {
            // 底面放置时，使用玩家的相反水平朝向
            facing = context.getHorizontalDirection().getOpposite();
        } else {
            // 顶面放置时，使用玩家的水平朝向
            facing = context.getHorizontalDirection();
        }

        return this.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER)
                .setValue(ATTACHED_TO_SIDE, isSidePlacement || isBottomPlacement);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        // 取消交互功能，返回默认结果
        return InteractionResult.PASS;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        // 无特殊逻辑
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        // 如果是侧面或底面附着，检查附着方块是否还存在
        if (state.getValue(ATTACHED_TO_SIDE)) {
            Direction attachedDirection = state.getValue(FACING).getOpposite();
            BlockPos attachedPos = currentPos.relative(attachedDirection);

            if (!level.getBlockState(attachedPos).isFaceSturdy(level, attachedPos, attachedDirection.getOpposite())) {
                return Blocks.AIR.defaultBlockState();
            }
        } else {
            // 顶面附着，检查下方方块是否稳固
            BlockPos belowPos = currentPos.below();
            if (!level.getBlockState(belowPos).isFaceSturdy(level, belowPos, Direction.UP)) {
                return Blocks.AIR.defaultBlockState();
            }
        }

        return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (state.getValue(ATTACHED_TO_SIDE)) {
            // 侧面或底面附着时，检查附着的方块面是否稳固
            Direction attachedDirection = state.getValue(FACING).getOpposite();
            BlockPos attachedPos = pos.relative(attachedDirection);
            return level.getBlockState(attachedPos).isFaceSturdy(level, attachedPos, attachedDirection.getOpposite());
        } else {
            // 顶面附着时，检查下方方块是否稳固
            BlockPos belowPos = pos.below();
            return level.getBlockState(belowPos).isFaceSturdy(level, belowPos, Direction.UP);
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, ATTACHED_TO_SIDE);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
}





