package com.shengchanshe.chang_sheng_jue.block.custom.lockers;

import com.shengchanshe.chang_sheng_jue.block.BigBlockType;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class LargeCabinet extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<BigBlockType> PART = EnumProperty.create("part", BigBlockType.class);

    public LargeCabinet(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(PART, BigBlockType.BOTTOM_LEFT));
    }

    private int getDx(BigBlockType part) {
        return switch (part) {
            case BOTTOM_LEFT, MIDDLE_LEFT, TOP_LEFT -> 0;
            case BOTTOM_RIGHT, MIDDLE_RIGHT, TOP_RIGHT -> 1;
        };
    }

    private int getDy(BigBlockType part) {
        return switch (part) {
            case BOTTOM_LEFT, BOTTOM_RIGHT -> 0;
            case MIDDLE_LEFT, MIDDLE_RIGHT -> 1;
            case TOP_LEFT, TOP_RIGHT -> 2;
        };
    }

    private BlockPos findMasterPos(BlockPos pos, BlockState state) {
        BigBlockType part = state.getValue(PART);
        int dx = getDx(part);
        int dy = getDy(part);
        Direction facing = state.getValue(FACING);
        Direction right = facing.getCounterClockWise();
        return pos.relative(right.getOpposite(), dx).below(dy);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getHorizontalDirection().getOpposite();

        Direction right = facing.getCounterClockWise();

        for (int dx = 0; dx <= 1; dx++) {
            for (int dy = 0; dy <= 2; dy++) {
                BlockPos partPos = pos.relative(right, dx).above(dy);
                if (!level.getBlockState(partPos).canBeReplaced(context)) {
                    return null;
                }
            }
        }

        return this.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(PART, BigBlockType.BOTTOM_LEFT);
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        if (pLevel.isClientSide) return;
        Direction facing = pState.getValue(FACING);
        Direction right = facing.getCounterClockWise();

        for (int dx = 0; dx <= 1; dx++) {
            for (int dy = 0; dy <= 2; dy++) {
                BlockPos partPos = pPos.relative(right, dx).above(dy);
                if (partPos.equals(pPos)) continue;

                BigBlockType part = getPartByCoords(dx, dy);
                BlockState partState = this.defaultBlockState().setValue(FACING, facing).setValue(PART, part);

                pLevel.setBlockAndUpdate(partPos, partState);
            }
        }
    }

    private static BigBlockType getPartByCoords(int dx, int dy) {
        if (dx == 0) {
            if (dy == 0) return BigBlockType.BOTTOM_LEFT;
            if (dy == 1) return BigBlockType.MIDDLE_LEFT;
            return BigBlockType.TOP_LEFT;
        } else {
            if (dy == 0) return BigBlockType.BOTTOM_RIGHT;
            if (dy == 1) return BigBlockType.MIDDLE_RIGHT;
            return BigBlockType.TOP_RIGHT;
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;

        BlockPos masterPos = findMasterPos(pos, state);
        BlockEntity be = level.getBlockEntity(masterPos);

        if (be instanceof LargeCabinetEntity cabinet) {
            player.openMenu(cabinet);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ChangShengJueBlocksEntities.LARGE_CABINET_ENTITY.get(),
                level.isClientSide() ? LargeCabinetEntity::tick : null);
    }

    @Override
    public boolean triggerEvent(BlockState state, Level level, BlockPos pos, int id, int param) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        return blockentity != null && blockentity.triggerEvent(id, param);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() == newState.getBlock()) {
            super.onRemove(state, level, pos, newState, isMoving);
            return;
        }
        BlockPos masterPos = findMasterPos(pos, state);
        BlockEntity be = level.getBlockEntity(masterPos);
        if (be instanceof LargeCabinetEntity master) {
            master.unpackLootTable(null);
            Containers.dropContents(level, masterPos, master);
            level.removeBlock(masterPos, false);
            Direction facing = state.getValue(FACING);
            Direction right = facing.getCounterClockWise();
            for (int dx = 0; dx <= 1; dx++) {
                for (int dy = 0; dy <= 2; dy++) {
                    BlockPos p = masterPos.relative(right, dx).above(dy);
                    if (!p.equals(masterPos)) {
                        level.removeBlock(p, false);
                    }
                }
            }
        } else {
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new LargeCabinetEntity(blockPos, blockState);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        BlockState rotated = state.rotate(mirror.getRotation(state.getValue(FACING)));
        BigBlockType p = rotated.getValue(PART);
        return switch (p) {
            case BOTTOM_LEFT -> rotated.setValue(PART, BigBlockType.BOTTOM_RIGHT);
            case MIDDLE_LEFT -> rotated.setValue(PART, BigBlockType.MIDDLE_RIGHT);
            case TOP_LEFT -> rotated.setValue(PART, BigBlockType.TOP_RIGHT);
            case BOTTOM_RIGHT -> rotated.setValue(PART, BigBlockType.BOTTOM_LEFT);
            case MIDDLE_RIGHT -> rotated.setValue(PART, BigBlockType.MIDDLE_LEFT);
            case TOP_RIGHT -> rotated.setValue(PART, BigBlockType.TOP_LEFT);
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, PART);
    }
}
