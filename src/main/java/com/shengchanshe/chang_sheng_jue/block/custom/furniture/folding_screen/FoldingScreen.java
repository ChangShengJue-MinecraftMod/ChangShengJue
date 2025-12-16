package com.shengchanshe.chang_sheng_jue.block.custom.furniture.folding_screen;

import com.shengchanshe.chang_sheng_jue.block.RoofPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FoldingScreen extends HorizontalDirectionalBlock {
    public static final EnumProperty<RoofPart> PART = EnumProperty.create("part", RoofPart.class);
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");

    public FoldingScreen(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(PART, RoofPart.BOTTOM)
                .setValue(RIGHT, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();

        // 检查上方两个位置是否可放置
        if (pos.getY() < level.getMaxBuildHeight() - 2 &&
                level.getBlockState(pos.above()).canBeReplaced(context) &&
                level.getBlockState(pos.above(2)).canBeReplaced(context)) {

            Direction facing = context.getHorizontalDirection();
            boolean isRight = determineRightState(level, pos, facing, context);

            return this.defaultBlockState()
                    .setValue(FACING, facing)
                    .setValue(PART, RoofPart.BOTTOM)
                    .setValue(RIGHT, isRight);
        }
        return null;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction value = pState.getValue(FACING);
        if (value == Direction.SOUTH || value == Direction.NORTH) {
            return Block.box(0, 0, 4, 16, 16, 12);
        }else {
            return Block.box(4, 0, 0, 12, 16, 16);
        }
    }

    /**
     * 确定左右状态的简单逻辑，不会导致崩溃
     */
    private boolean determineRightState(Level level, BlockPos pos, Direction facing, BlockPlaceContext context) {
        // 简单的基于点击位置的逻辑
        // 如果点击位置在方块的右侧，则设置为右侧状态
        double hitX = context.getClickLocation().x - pos.getX();
        double hitZ = context.getClickLocation().z - pos.getZ();

        return switch (facing) {
            case NORTH -> hitX > 0.5;
            case SOUTH -> hitX < 0.5;
            case EAST -> hitZ < 0.5;
            case WEST -> hitZ > 0.5;
            default -> false;
        };
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        if (level.isClientSide) return;

        RoofPart part = state.getValue(PART);

        // 只生成垂直部分，不自动生成水平对称部分
        if (part == RoofPart.BOTTOM) {
            level.setBlock(pos.above(), state.setValue(PART, RoofPart.MIDDLE), Block.UPDATE_ALL);
            level.setBlock(pos.above(2), state.setValue(PART, RoofPart.TOP), Block.UPDATE_ALL);
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        RoofPart part = state.getValue(PART);

        // 只在垂直方向检查结构完整性
        if (direction.getAxis() == Direction.Axis.Y) {
            switch (part) {
                case BOTTOM -> {
                    if (!level.getBlockState(pos.above()).is(this)) {
                        return Blocks.AIR.defaultBlockState();
                    }
                }
                case MIDDLE -> {
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
            }
        }

        return state;
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide && player.isCreative()) {
            RoofPart part = state.getValue(PART);

            // 只在创造模式下破坏垂直结构
            switch (part) {
                case BOTTOM -> {
                    level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                    level.setBlock(pos.above(2), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                }
                case MIDDLE -> {
                    level.setBlock(pos.below(), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                    level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                }
                case TOP -> {
                    level.setBlock(pos.below(), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                    level.setBlock(pos.below(2), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                }
            }
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PART, FACING, RIGHT);
    }
}