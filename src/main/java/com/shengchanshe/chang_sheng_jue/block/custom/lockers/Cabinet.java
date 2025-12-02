package com.shengchanshe.chang_sheng_jue.block.custom.lockers;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.BiPredicate;

public class Cabinet extends BaseEntityBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<ChestType> TYPE = BlockStateProperties.CHEST_TYPE;

    private static final DoubleBlockCombiner.Combiner<CabinetEntity, Optional<Container>> CONTAINER_COMBINER =
            new DoubleBlockCombiner.Combiner<>() {
                public Optional<Container> acceptDouble(CabinetEntity left, CabinetEntity right) {
                    return Optional.of(new CompoundContainer(left, right));
                }

                public Optional<Container> acceptSingle(CabinetEntity single) {
                    return Optional.of(single);
                }

                public Optional<Container> acceptNone() {
                    return Optional.empty();
                }
            };

    private static final DoubleBlockCombiner.Combiner<CabinetEntity, Optional<MenuProvider>> MENU_PROVIDER_COMBINER =
            new DoubleBlockCombiner.Combiner<>() {
                public Optional<MenuProvider> acceptDouble(final CabinetEntity left, final CabinetEntity right) {
                    final Container container = new CompoundContainer(left, right);
                    return Optional.of(new MenuProvider() {
                        @Nullable
                        public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                            if (left.stillValid(player) && right.stillValid(player)) {
                                return ChestMenu.sixRows(id, inventory, container);
                            } else {
                                return null;
                            }
                        }

                        public Component getDisplayName() {
                            if (left.hasCustomName()) {
                                return left.getDisplayName();
                            } else {
                                return right.hasCustomName() ? right.getDisplayName() : Component.translatable("container."+ ChangShengJue.MOD_ID +".cabinet");
                            }
                        }
                    });
                }

                public Optional<MenuProvider> acceptSingle(CabinetEntity single) {
                    return Optional.of(single);
                }

                public Optional<MenuProvider> acceptNone() {
                    return Optional.empty();
                }
            };

    public Cabinet(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(TYPE, ChestType.SINGLE));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        ChestType chesttype = ChestType.SINGLE;
        Direction direction = pContext.getHorizontalDirection().getOpposite();
        boolean flag = pContext.isSecondaryUseActive();
        Direction direction1 = pContext.getClickedFace();
        if (direction1.getAxis().isHorizontal() && flag) {
            Direction direction2 = this.candidatePartnerFacing(pContext, direction1.getOpposite());
            if (direction2 != null && direction2.getAxis() != direction1.getAxis()) {
                direction = direction2;
                chesttype = direction2.getCounterClockWise() == direction1.getOpposite() ? ChestType.RIGHT : ChestType.LEFT;
            }
        }

        if (chesttype == ChestType.SINGLE && !flag) {
            if (direction == this.candidatePartnerFacing(pContext, direction.getClockWise())) {
                chesttype = ChestType.LEFT;
            } else if (direction == this.candidatePartnerFacing(pContext, direction.getCounterClockWise())) {
                chesttype = ChestType.RIGHT;
            }
        }

        return this.defaultBlockState().setValue(FACING, direction).setValue(TYPE, chesttype);
    }

    @Nullable
    private Direction candidatePartnerFacing(BlockPlaceContext pContext, Direction pDirection) {
        BlockState blockstate = pContext.getLevel().getBlockState(pContext.getClickedPos().relative(pDirection));
        return blockstate.is(this) && blockstate.getValue(TYPE) == ChestType.SINGLE ? blockstate.getValue(FACING) : null;
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

    public static DoubleBlockCombiner.BlockType getBlockType(BlockState state) {
        ChestType chesttype = state.getValue(TYPE);
        if (chesttype == ChestType.SINGLE) {
            return DoubleBlockCombiner.BlockType.SINGLE;
        } else {
            return chesttype == ChestType.RIGHT ? DoubleBlockCombiner.BlockType.FIRST : DoubleBlockCombiner.BlockType.SECOND;
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        MenuProvider menuprovider = this.getMenuProvider(state, level, pos);
        if (menuprovider != null) {
            player.openMenu(menuprovider);
        }

        return InteractionResult.CONSUME;
    }

    @Nullable
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return this.combine(state, level, pos, false).apply(MENU_PROVIDER_COMBINER).orElse(null);
    }

    @Nullable
    public static Container getContainer(Cabinet cabinet, BlockState state, Level level, BlockPos pos, boolean override) {
        return cabinet.combine(state, level, pos, override).apply(CONTAINER_COMBINER).orElse(null);
    }

    public DoubleBlockCombiner.NeighborCombineResult<? extends CabinetEntity> combine(BlockState state, Level level, BlockPos pos, boolean override) {
        BiPredicate<LevelAccessor, BlockPos> bipredicate;
        if (override) {
            bipredicate = (levelAccessor, blockPos) -> false;
        } else {
            bipredicate = Cabinet::isCabinetBlockedAt;
        }

        return DoubleBlockCombiner.combineWithNeigbour(
                ChangShengJueBlocksEntities.CABINET_ENTITY.get(),
                Cabinet::getBlockType,
                Cabinet::getConnectedDirection,
                FACING, state, level, pos, bipredicate
        );
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        Container container = getContainer(this, state, level, pos, false);
        return AbstractContainerMenu.getRedstoneSignalFromContainer(container);
    }

    private static boolean isCabinetBlockedAt(LevelAccessor level, BlockPos pos) {
        return isBlockedCabinetByBlock(level, pos);
    }

    private static boolean isBlockedCabinetByBlock(LevelAccessor level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        if (!state.hasProperty(FACING)) {
            return false;
        }

        Direction facing = state.getValue(FACING);
        // 检查柜子前方的方块
        BlockPos frontPos = pos.relative(facing);
        return level.getBlockState(frontPos).isRedstoneConductor(level, frontPos);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof Container container) {
                Containers.dropContents(level, pos, container);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        BlockState rotated = state.rotate(mirror.getRotation(state.getValue(FACING)));
        return mirror == Mirror.NONE ? rotated : rotated.setValue(TYPE, rotated.getValue(TYPE).getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CabinetEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, ChangShengJueBlocksEntities.CABINET_ENTITY.get(),
                level.isClientSide() ? CabinetEntity::tick : null);
    }
}