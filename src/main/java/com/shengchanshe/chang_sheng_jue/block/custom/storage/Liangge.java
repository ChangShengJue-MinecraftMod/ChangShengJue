package com.shengchanshe.chang_sheng_jue.block.custom.storage;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class Liangge extends BaseEntityBlock {
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<ChestType> TYPE = BlockStateProperties.CHEST_TYPE;

    public Liangge(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(TYPE, ChestType.SINGLE));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection().getOpposite();
        ChestType chestType = ChestType.SINGLE;

        Direction leftDir = direction.getCounterClockWise();
        Direction rightDir = direction.getClockWise();

        BlockPos leftPos = context.getClickedPos().relative(leftDir);
        BlockPos rightPos = context.getClickedPos().relative(rightDir);
        Level level = context.getLevel();

        if (level.getBlockState(leftPos).is(this) && level.getBlockState(leftPos).getValue(TYPE) == ChestType.SINGLE) {
            chestType = ChestType.RIGHT;
        } else if (level.getBlockState(rightPos).is(this) && level.getBlockState(rightPos).getValue(TYPE) == ChestType.SINGLE) {
            chestType = ChestType.LEFT;
        }

        return this.defaultBlockState()
                .setValue(FACING, direction)
                .setValue(TYPE, chestType);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pFacingState.is(this) && pFacing.getAxis().isHorizontal()) {
            ChestType chesttype = pFacingState.getValue(TYPE);
            if (pState.getValue(TYPE) == ChestType.SINGLE && chesttype != ChestType.SINGLE && pState.getValue(FACING) == pFacingState.getValue(FACING) && getConnectedDirection(pFacingState) == pFacing.getOpposite()) {
                return pState.setValue(TYPE, chesttype.getOpposite());
            }
        } else if (getConnectedDirection(pState) == pFacing) {
            return pState.setValue(TYPE, ChestType.SINGLE);
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    public static Direction getConnectedDirection(BlockState state) {
        Direction direction = state.getValue(FACING);
        return state.getValue(TYPE) == ChestType.LEFT ? direction.getClockWise() : direction.getCounterClockWise();
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof LianggeEntity storageEntity) {
            ItemStack heldItem = player.getItemInHand(hand);
            boolean isSneaking = player.isShiftKeyDown();

            if (heldItem.isEmpty()) {
                return storageEntity.takeItem(player, isSneaking);
            } else {
                return storageEntity.placeItem(heldItem, player, isSneaking);
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof Container container) {
                Containers.dropContents(level, pos, container);
                level.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (stack.hasCustomHoverName()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof LianggeEntity storageEntity) {
                storageEntity.setCustomName(stack.getHoverName());
            }
        }

        updateNeighborConnections(level, pos, state);
    }

    private void updateNeighborConnections(Level level, BlockPos pos, BlockState state) {
        Direction facing = state.getValue(FACING);
        ChestType type = state.getValue(TYPE);

        if (type != ChestType.SINGLE) {
            Direction neighborDir = type == ChestType.LEFT ? facing.getClockWise() : facing.getCounterClockWise();
            BlockPos neighborPos = pos.relative(neighborDir);
            BlockState neighborState = level.getBlockState(neighborPos);

            if (neighborState.is(this) && neighborState.getValue(TYPE) == ChestType.SINGLE) {
                ChestType newNeighborType = type == ChestType.LEFT ? ChestType.RIGHT : ChestType.LEFT;
                level.setBlock(neighborPos, neighborState.setValue(TYPE, newNeighborType), 3);
            }
        }
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LianggeEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? null : createTickerHelper(blockEntityType, ChangShengJueBlocksEntities.LIANGGE_ENTITY.get(), LianggeEntity::serverTick);
    }
}