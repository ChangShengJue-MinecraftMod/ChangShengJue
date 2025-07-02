package com.shengchanshe.chang_sheng_jue.block.custom.bracket;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChineseBracketLong extends Block implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty MAIN_PART = BooleanProperty.create("main_part");
    public static final BooleanProperty ATTACHED_TO_SIDE = BooleanProperty.create("attached_to_side");

    protected static final VoxelShape NORTH_AABB = Block.box(7.0, 0.0, 0.0, 9.0, 16.0, 16.0);
    protected static final VoxelShape SOUTH_AABB = Block.box(7.0, 0.0, 0.0, 9.0, 16.0, 16.0);
    protected static final VoxelShape WEST_AABB = Block.box(0.0, 0.0, 7.0, 16.0, 16.0, 9.0);
    protected static final VoxelShape EAST_AABB = Block.box(0.0, 0.0, 7.0, 16.0, 16.0, 9.0);

    public ChineseBracketLong(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
                .setValue(MAIN_PART, true)
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

        // 检查主体方块是否可以放置
        if (!canMainSurvive(context.getLevel(), pos, facing, isSidePlacement || isBottomPlacement, clickedFace)) {
            return null;
        }

        // 检查第二个方块位置是否可放置
        BlockPos secondPos = getSecondPosition(pos, facing);
        if (!context.getLevel().getBlockState(secondPos).canBeReplaced(context)) {
            return null;
        }

        // 创建主方块状态
        BlockState mainState = this.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER)
                .setValue(MAIN_PART, true)
                .setValue(ATTACHED_TO_SIDE, isSidePlacement || isBottomPlacement);

        return mainState;
    }

    private boolean canMainSurvive(LevelReader level, BlockPos pos, Direction facing, boolean isSide, Direction clickedFace) {
        if (isSide) {
            // 主体侧面依附：检查侧面方块是否稳固
            BlockPos attachPos = pos.relative(clickedFace.getOpposite());
            return level.getBlockState(attachPos).isFaceSturdy(level, attachPos, clickedFace);
        } else {
            // 主体地面依附：检查下方方块是否稳固
            return level.getBlockState(pos.below()).isFaceSturdy(level, pos.below(), Direction.UP);
        }
    }

    private BlockPos getSecondPosition(BlockPos pos, Direction facing) {
        return pos.relative(facing); // 向前延伸
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        if (state.getValue(MAIN_PART)) {
            Direction facing = state.getValue(FACING);
            boolean isSide = state.getValue(ATTACHED_TO_SIDE);
            BlockPos secondPos = getSecondPosition(pos, facing);

            // 确保主方块存在时才放置次要方块
            if (level.getBlockState(pos).getBlock() == this && level.getBlockState(pos).getValue(MAIN_PART)) {
                BlockState secondState = this.defaultBlockState()
                        .setValue(FACING, facing)
                        .setValue(WATERLOGGED, level.getFluidState(secondPos).getType() == Fluids.WATER)
                        .setValue(MAIN_PART, false)
                        .setValue(ATTACHED_TO_SIDE, isSide);

                level.setBlock(secondPos, secondState, 3);
            }
        }
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            removeBothParts(level, pos, state, player);
        }
        super.playerWillDestroy(level, pos, state, player);
    }

    private void removeBothParts(Level level, BlockPos pos, BlockState state, Player player) {
        if (state.getValue(MAIN_PART)) {
            // 如果是主方块被破坏，移除次要方块
            Direction facing = state.getValue(FACING);
            BlockPos secondPos = getSecondPosition(pos, facing);
            BlockState secondState = level.getBlockState(secondPos);
            if (secondState.getBlock() == this && !secondState.getValue(MAIN_PART)) {
                level.setBlock(secondPos, Blocks.AIR.defaultBlockState(), 35);
                level.levelEvent(player, 2001, secondPos, Block.getId(secondState));
            }
        } else {
            // 如果是次要方块被破坏，移除主方块
            BlockPos mainPos = getMainPosition(pos, state.getValue(FACING));
            BlockState mainState = level.getBlockState(mainPos);
            if (mainState.getBlock() == this && mainState.getValue(MAIN_PART)) {
                level.setBlock(mainPos, Blocks.AIR.defaultBlockState(), 35);
                level.levelEvent(player, 2001, mainPos, Block.getId(mainState));
            }
        }
    }

    private BlockPos getMainPosition(BlockPos pos, Direction facing) {
        return pos.relative(facing.getOpposite());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        // 只检查主体方块的依附情况
        if (state.getValue(MAIN_PART)) {
            if (state.getValue(ATTACHED_TO_SIDE)) {
                // 主体侧面依附：检查侧面方块是否稳固
                Direction facing = state.getValue(FACING);
                Direction attachDirection = facing.getOpposite();
                BlockPos attachPos = currentPos.relative(attachDirection);

                if (!level.getBlockState(attachPos).isFaceSturdy(level, attachPos, facing)) {
                    return Blocks.AIR.defaultBlockState();
                }
            } else {
                // 主体地面依附：检查下方方块是否稳固
                BlockPos belowPos = currentPos.below();
                if (!level.getBlockState(belowPos).isFaceSturdy(level, belowPos, Direction.UP)) {
                    return Blocks.AIR.defaultBlockState();
                }
            }
        }

        // 检查双方块结构完整性
        if (state.getValue(MAIN_PART)) {
            Direction facing = state.getValue(FACING);
            BlockPos secondPos = getSecondPosition(currentPos, facing);
            BlockState secondState = level.getBlockState(secondPos);
            if (secondState.getBlock() != this || !secondState.getValue(FACING).equals(facing) ||
                    secondState.getValue(MAIN_PART) ||
                    secondState.getValue(ATTACHED_TO_SIDE) != state.getValue(ATTACHED_TO_SIDE)) {
                return Blocks.AIR.defaultBlockState();
            }
        } else {
            Direction facing = state.getValue(FACING);
            BlockPos mainPos = getMainPosition(currentPos, facing);
            BlockState mainState = level.getBlockState(mainPos);
            if (mainState.getBlock() != this || !mainState.getValue(FACING).equals(facing) ||
                    !mainState.getValue(MAIN_PART) ||
                    mainState.getValue(ATTACHED_TO_SIDE) != state.getValue(ATTACHED_TO_SIDE)) {
                return Blocks.AIR.defaultBlockState();
            }
        }

        return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (state.getValue(MAIN_PART)) {
            // 主方块需要检查依附
            if (state.getValue(ATTACHED_TO_SIDE)) {
                Direction facing = state.getValue(FACING);
                Direction attachDirection = facing.getOpposite();
                BlockPos attachPos = pos.relative(attachDirection);
                return level.getBlockState(attachPos).isFaceSturdy(level, attachPos, facing);
            } else {
                return level.getBlockState(pos.below()).isFaceSturdy(level, pos.below(), Direction.UP);
            }
        } else {
            // 次要方块需要检查主方块是否存在
            Direction facing = state.getValue(FACING);
            BlockPos mainPos = getMainPosition(pos, facing);
            BlockState mainState = level.getBlockState(mainPos);
            return mainState.getBlock() == this && mainState.getValue(MAIN_PART);
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, MAIN_PART, ATTACHED_TO_SIDE);
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