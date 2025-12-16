package com.shengchanshe.chang_sheng_jue.block.custom.lantern;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HeightLightStand extends HorizontalDirectionalBlock {
    public static final EnumProperty<HeightLightStandSection> PART = EnumProperty.create("part", HeightLightStandSection.class);

    public HeightLightStand(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(PART, HeightLightStandSection.BOTTOM));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();

        if (pos.getY() < level.getMaxBuildHeight() - 3 &&
                level.getBlockState(pos.above()).canBeReplaced(context) &&
                level.getBlockState(pos.above(2)).canBeReplaced(context) &&
                level.getBlockState(pos.above(3)).canBeReplaced(context)) {

            // 根据朝向计算顶部左边的位置
            Direction facing = context.getHorizontalDirection();
            BlockPos topLeftPos = pos.above(3).relative(facing.getClockWise());

            if (level.getBlockState(topLeftPos).canBeReplaced(context)) {
                return this.defaultBlockState().setValue(FACING, facing)
                        .setValue(PART, HeightLightStandSection.BOTTOM);
            }
        }
        return null;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        HeightLightStandSection part = state.getValue(PART);

        switch (part) {
            case BOTTOM -> {
                if (!level.getBlockState(pos.above()).is(this) ||
                        !level.getBlockState(pos.above(2)).is(this) ||
                        !level.getBlockState(pos.above(3)).is(this)) {
                    return Blocks.AIR.defaultBlockState();
                }

                Direction facing = state.getValue(FACING);
                BlockPos topLeftPos = pos.above(3).relative(facing.getClockWise());
                if (!level.getBlockState(topLeftPos).is(this)) {
                    return Blocks.AIR.defaultBlockState();
                }
            }
            case MIDDLE1, MIDDLE2 -> {
                if (!level.getBlockState(pos.below()).is(this) ||
                        !level.getBlockState(pos.above()).is(this)) {
                    return Blocks.AIR.defaultBlockState();
                }
            }
            case TOP -> {
                if (!level.getBlockState(pos.below()).is(this)) {
                    return Blocks.AIR.defaultBlockState();
                }
            }
            case TOP_LEFT -> {
                Direction facing = state.getValue(FACING);
                BlockPos topPos = pos.relative(facing.getCounterClockWise());
                if (!level.getBlockState(topPos).is(this)) {
                    return Blocks.AIR.defaultBlockState();
                }
            }
        }

        return state;
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            HeightLightStandSection part = state.getValue(PART);

            if (player.isCreative()) {
                BlockPos bottomPos = findBottomPos(pos, state);

                if (bottomPos != null) {
                    switch (part) {
                        case MIDDLE1 -> {
                            level.setBlock(bottomPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                            level.setBlock(bottomPos.above(2), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                            level.setBlock(bottomPos.above(3), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                            level.setBlock(bottomPos.above(3).relative(state.getValue(FACING).getClockWise()),
                                    Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                        }
                        case MIDDLE2 -> {
                            level.setBlock(bottomPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                            level.setBlock(bottomPos.above(), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                            level.setBlock(bottomPos.above(3), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                            level.setBlock(bottomPos.above(3).relative(state.getValue(FACING).getClockWise()),
                                    Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                        }
                        case TOP -> {
                            level.setBlock(bottomPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                            level.setBlock(bottomPos.above(), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                            level.setBlock(bottomPos.above(2), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                            level.setBlock(bottomPos.above(3).relative(state.getValue(FACING).getClockWise()),
                                    Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                        }
                        case TOP_LEFT -> {
                            level.setBlock(bottomPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                            level.setBlock(bottomPos.above(), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                            level.setBlock(bottomPos.above(2), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                            level.setBlock(bottomPos.above(3), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                        }
                    }
                }
            }
            super.playerWillDestroy(level, pos, state, player);
        }
    }

    /**
     * 根据任意部分的位置找到底部方块的位置
     */
    private BlockPos findBottomPos(BlockPos pos, BlockState state) {
        HeightLightStandSection part = state.getValue(PART);
        Direction facing = state.getValue(FACING);

        return switch (part) {
            case BOTTOM -> pos;
            case MIDDLE1 -> pos.below();
            case MIDDLE2 -> pos.below(2);
            case TOP -> pos.below(3);
            case TOP_LEFT -> pos.below(3).relative(facing.getCounterClockWise());
        };
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        Direction facing = state.getValue(FACING);

        level.setBlock(pos.above(), state.setValue(PART, HeightLightStandSection.MIDDLE1), Block.UPDATE_ALL);
        level.setBlock(pos.above(2), state.setValue(PART, HeightLightStandSection.MIDDLE2), Block.UPDATE_ALL);
        level.setBlock(pos.above(3), state.setValue(PART, HeightLightStandSection.TOP), Block.UPDATE_ALL);

        BlockPos topLeftPos = pos.above(3).relative(facing.getClockWise());
        if (level.getBlockState(topLeftPos).canBeReplaced()) {
            level.setBlock(topLeftPos, state.setValue(PART, HeightLightStandSection.TOP_LEFT), Block.UPDATE_ALL);
        }
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return super.rotate(blockState, rotation);
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return super.mirror(blockState, mirror);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pState.getValue(FACING) == Direction.SOUTH) {
            if (pState.getValue(PART) == HeightLightStandSection.TOP) {
                return Shapes.join(Block.box(2, 0, 7, 4, 4, 9),
                        Block.box(0, 0, 7, 2, 2, 9), BooleanOp.OR);
            } else if (pState.getValue(PART) == HeightLightStandSection.TOP_LEFT) {
                return Block.box(4, 0, 7, 16, 2, 9);
            } else {
                return Block.box(2, 0, 7, 4, 16, 9);
            }
        } else if (pState.getValue(FACING) == Direction.WEST) {
            if (pState.getValue(PART) == HeightLightStandSection.TOP) {
                return Shapes.join(Block.box(7, 0, 2, 9, 4, 4), Block.box(7, 0, 0, 9, 2, 2), BooleanOp.OR);
            } else if (pState.getValue(PART) == HeightLightStandSection.TOP_LEFT) {
                return Block.box(7, 0, 4, 9, 2, 16);
            } else {
                return Block.box(7, 0, 2, 9, 16, 4);
            }
        } else if (pState.getValue(FACING) == Direction.EAST) {
            if (pState.getValue(PART) == HeightLightStandSection.TOP) {
                return Shapes.join(Block.box(7, 0, 12, 9, 4, 14),
                        Block.box(7, 0, 14, 9, 2, 16), BooleanOp.OR);
            } else if (pState.getValue(PART) == HeightLightStandSection.TOP_LEFT) {
                return Block.box(7, 0, 0, 9, 2, 12);
            } else {
                return Block.box(7, 0, 12, 9, 16, 14);
            }
        } else {
            if (pState.getValue(PART) == HeightLightStandSection.TOP) {
                return Shapes.join(Block.box(12, 0, 7, 14, 4, 9),
                        Block.box(14, 0, 7, 16, 2, 9), BooleanOp.OR);
            } else if (pState.getValue(PART) == HeightLightStandSection.TOP_LEFT) {
                return Block.box(0, 0, 7, 12, 2, 9);
            } else {
                return Block.box(12, 0, 7, 14, 16, 9);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PART, FACING);
    }

    public enum HeightLightStandSection implements StringRepresentable {
        TOP("top"),
        TOP_LEFT("top_left"),
        MIDDLE1("middle1"),
        MIDDLE2("middle2"),
        BOTTOM("bottom");

        private final String name;

        HeightLightStandSection(String pName) {
            this.name = pName;
        }

        public String toString() {
            return this.name;
        }

        public String getSerializedName() {
            return this.name;
        }
    }
}