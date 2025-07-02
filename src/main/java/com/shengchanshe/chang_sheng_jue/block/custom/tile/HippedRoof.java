package com.shengchanshe.chang_sheng_jue.block.custom.tile;

import com.shengchanshe.chang_sheng_jue.block.RoofPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class HippedRoof extends CylinderTile {
    public static final EnumProperty<RoofPart> PART = EnumProperty.create("part", RoofPart.class);

    public HippedRoof(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(PART, RoofPart.BOTTOM));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();

        // 检查上方两个位置是否可放置
        if (pos.getY() < level.getMaxBuildHeight() - 2 &&
                level.getBlockState(pos.above()).canBeReplaced(context) &&
                level.getBlockState(pos.above(2)).canBeReplaced(context)) {

            return this.defaultBlockState()
                    .setValue(FACING, context.getHorizontalDirection())
                    .setValue(PART, RoofPart.BOTTOM);
        }
        return null; // 空间不足时取消放置
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        // 自动生成中部和顶部
        level.setBlock(pos.above(), state.setValue(PART, RoofPart.MIDDLE), Block.UPDATE_ALL);
        level.setBlock(pos.above(2), state.setValue(PART, RoofPart.TOP), Block.UPDATE_ALL);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        RoofPart part = state.getValue(PART);

        // 只在垂直方向检查（性能优化）
        if (direction.getAxis() != Direction.Axis.Y) {
            return state;
        }

        // 检查三部分结构完整性
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

        return state;
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            super.playerWillDestroy(level, pos, state, player);
        }
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return super.rotate(blockState,rotation);
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return super.mirror(blockState, mirror);
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PART,FACING);
    }
}
