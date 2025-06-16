package com.shengchanshe.changshengjue.block.custom;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DoorsBlock extends Block {
    // 新增三格门的半块属性，增加MIDDLE状态
    public static final EnumProperty<ThreeBlockHalf> HALF;
    public static final DirectionProperty FACING;
    public static final BooleanProperty OPEN;
    public static final EnumProperty<DoorHingeSide> HINGE;
    public static final BooleanProperty POWERED;

    // 三格门的碰撞箱定义
    protected static final VoxelShape SOUTH_AABB_LOWER;
    protected static final VoxelShape SOUTH_AABB_MIDDLE;
    protected static final VoxelShape SOUTH_AABB_UPPER;
    protected static final VoxelShape NORTH_AABB_LOWER;
    protected static final VoxelShape NORTH_AABB_MIDDLE;
    protected static final VoxelShape NORTH_AABB_UPPER;
    protected static final VoxelShape WEST_AABB_LOWER;
    protected static final VoxelShape WEST_AABB_MIDDLE;
    protected static final VoxelShape WEST_AABB_UPPER;
    protected static final VoxelShape EAST_AABB_LOWER;
    protected static final VoxelShape EAST_AABB_MIDDLE;
    protected static final VoxelShape EAST_AABB_UPPER;

    private final BlockSetType type;

    public DoorsBlock(BlockBehaviour.Properties pProperties, BlockSetType pType) {
        super(pProperties.sound(pType.soundType()));
        this.type = pType;
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(OPEN, false)).setValue(HINGE, DoorHingeSide.LEFT)).setValue(POWERED, false)).setValue(HALF, ThreeBlockHalf.LOWER));
    }

    public BlockSetType type() {
        return this.type;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction facing = pState.getValue(FACING);
        boolean isOpen = (Boolean)pState.getValue(OPEN);
        boolean isRightHinge = pState.getValue(HINGE) == DoorHingeSide.RIGHT;
        ThreeBlockHalf half = pState.getValue(HALF);

        // 根据门的朝向、开关状态和部分选择合适的碰撞箱
        switch (facing) {
            case EAST:
            default:
                if (isOpen) {
                    return isRightHinge ?
                            (half == ThreeBlockHalf.LOWER ? NORTH_AABB_LOWER :
                                    half == ThreeBlockHalf.MIDDLE ? NORTH_AABB_MIDDLE : NORTH_AABB_UPPER) :
                            (half == ThreeBlockHalf.LOWER ? SOUTH_AABB_LOWER :
                                    half == ThreeBlockHalf.MIDDLE ? SOUTH_AABB_MIDDLE : SOUTH_AABB_UPPER);
                } else {
                    return half == ThreeBlockHalf.LOWER ? EAST_AABB_LOWER :
                            half == ThreeBlockHalf.MIDDLE ? EAST_AABB_MIDDLE : EAST_AABB_UPPER;
                }
            case SOUTH:
                if (isOpen) {
                    return isRightHinge ?
                            (half == ThreeBlockHalf.LOWER ? EAST_AABB_LOWER :
                                    half == ThreeBlockHalf.MIDDLE ? EAST_AABB_MIDDLE : EAST_AABB_UPPER) :
                            (half == ThreeBlockHalf.LOWER ? WEST_AABB_LOWER :
                                    half == ThreeBlockHalf.MIDDLE ? WEST_AABB_MIDDLE : WEST_AABB_UPPER);
                } else {
                    return half == ThreeBlockHalf.LOWER ? SOUTH_AABB_LOWER :
                            half == ThreeBlockHalf.MIDDLE ? SOUTH_AABB_MIDDLE : SOUTH_AABB_UPPER;
                }
            case WEST:
                if (isOpen) {
                    return isRightHinge ?
                            (half == ThreeBlockHalf.LOWER ? SOUTH_AABB_LOWER :
                                    half == ThreeBlockHalf.MIDDLE ? SOUTH_AABB_MIDDLE : SOUTH_AABB_UPPER) :
                            (half == ThreeBlockHalf.LOWER ? NORTH_AABB_LOWER :
                                    half == ThreeBlockHalf.MIDDLE ? NORTH_AABB_MIDDLE : NORTH_AABB_UPPER);
                } else {
                    return half == ThreeBlockHalf.LOWER ? WEST_AABB_LOWER :
                            half == ThreeBlockHalf.MIDDLE ? WEST_AABB_MIDDLE : WEST_AABB_UPPER;
                }
            case NORTH:
                if (isOpen) {
                    return isRightHinge ?
                            (half == ThreeBlockHalf.LOWER ? WEST_AABB_LOWER :
                                    half == ThreeBlockHalf.MIDDLE ? WEST_AABB_MIDDLE : WEST_AABB_UPPER) :
                            (half == ThreeBlockHalf.LOWER ? EAST_AABB_LOWER :
                                    half == ThreeBlockHalf.MIDDLE ? EAST_AABB_MIDDLE : EAST_AABB_UPPER);
                } else {
                    return half == ThreeBlockHalf.LOWER ? NORTH_AABB_LOWER :
                            half == ThreeBlockHalf.MIDDLE ? NORTH_AABB_MIDDLE : NORTH_AABB_UPPER;
                }
        }
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        ThreeBlockHalf half = pState.getValue(HALF);

        // 处理Y轴方向的相邻方块更新（上、中、下部分的关联）
        if (pFacing.getAxis() == Axis.Y) {
            if (half == ThreeBlockHalf.LOWER && pFacing == Direction.UP) {
                // 下部分检查中间部分是否是三格门
                if (pFacingState.is(this) && pFacingState.getValue(HALF) == ThreeBlockHalf.MIDDLE) {
                    BlockPos upperPos = pFacingPos.above();
                    BlockState upperState = pLevel.getBlockState(upperPos);
                    // 中间部分存在时，检查上部分是否是三格门
                    if (upperState.is(this) && upperState.getValue(HALF) == ThreeBlockHalf.UPPER) {
                        return (BlockState)((BlockState)((BlockState)((BlockState)pState.setValue(FACING, (Direction)pFacingState.getValue(FACING))).setValue(OPEN, (Boolean)pFacingState.getValue(OPEN))).setValue(HINGE, (DoorHingeSide)pFacingState.getValue(HINGE))).setValue(POWERED, (Boolean)pFacingState.getValue(POWERED));
                    }
                }
                return Blocks.AIR.defaultBlockState();
            } else if (half == ThreeBlockHalf.MIDDLE) {
                // 中间部分检查下部分和上部分
                if ((pFacing == Direction.DOWN && pFacingState.is(this) && pFacingState.getValue(HALF) == ThreeBlockHalf.LOWER) ||
                        (pFacing == Direction.UP && pFacingState.is(this) && pFacingState.getValue(HALF) == ThreeBlockHalf.UPPER)) {
                    return (BlockState)((BlockState)((BlockState)((BlockState)pState.setValue(FACING, (Direction)pFacingState.getValue(FACING))).setValue(OPEN, (Boolean)pFacingState.getValue(OPEN))).setValue(HINGE, (DoorHingeSide)pFacingState.getValue(HINGE))).setValue(POWERED, (Boolean)pFacingState.getValue(POWERED));
                }
                return Blocks.AIR.defaultBlockState();
            } else if (half == ThreeBlockHalf.UPPER && pFacing == Direction.DOWN) {
                // 上部分检查中间部分是否是三格门
                if (pFacingState.is(this) && pFacingState.getValue(HALF) == ThreeBlockHalf.MIDDLE) {
                    BlockPos lowerPos = pFacingPos.below();
                    BlockState lowerState = pLevel.getBlockState(lowerPos);
                    // 中间部分存在时，检查下部分是否是三格门
                    if (lowerState.is(this) && lowerState.getValue(HALF) == ThreeBlockHalf.LOWER) {
                        return (BlockState)((BlockState)((BlockState)((BlockState)pState.setValue(FACING, (Direction)pFacingState.getValue(FACING))).setValue(OPEN, (Boolean)pFacingState.getValue(OPEN))).setValue(HINGE, (DoorHingeSide)pFacingState.getValue(HINGE))).setValue(POWERED, (Boolean)pFacingState.getValue(POWERED));
                    }
                }
                return Blocks.AIR.defaultBlockState();
            }
        }

        // 处理其他方向的更新
        return half == ThreeBlockHalf.LOWER && pFacing == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ?
                Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pLevel.isClientSide && pPlayer.isCreative()) {
            // 防止创造性模式下只破坏部分门
            ThreeBlockHalf half = pState.getValue(HALF);
            if (half == ThreeBlockHalf.LOWER) {
                pLevel.removeBlock(pPos.above(), false);
                pLevel.removeBlock(pPos.above(2), false);
            } else if (half == ThreeBlockHalf.MIDDLE) {
                pLevel.removeBlock(pPos.below(), false);
                pLevel.removeBlock(pPos.above(), false);
            } else if (half == ThreeBlockHalf.UPPER) {
                pLevel.removeBlock(pPos.below(), false);
                pLevel.removeBlock(pPos.below(2), false);
            }
        }
        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    @Override
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        switch (pType) {
            case LAND:
            case AIR:
                return (Boolean)pState.getValue(OPEN);
            default:
                return false;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos pos = pContext.getClickedPos();
        Level level = pContext.getLevel();

        // 检查是否有足够的空间放置三格门
        if (pos.getY() < level.getMaxBuildHeight() - 2 &&
                level.getBlockState(pos.above()).canBeReplaced(pContext) &&
                level.getBlockState(pos.above(2)).canBeReplaced(pContext)) {

            boolean isPowered = level.hasNeighborSignal(pos) ||
                    level.hasNeighborSignal(pos.above()) ||
                    level.hasNeighborSignal(pos.above(2));

            return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection())).setValue(HINGE, this.getHinge(pContext))).setValue(POWERED, isPowered)).setValue(OPEN, isPowered)).setValue(HALF, ThreeBlockHalf.LOWER);
        }
        return null;
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack) {
        // 放置下部分时，同时放置中间和上部分
        if (pState.getValue(HALF) == ThreeBlockHalf.LOWER) {
            pLevel.setBlock(pPos.above(), (BlockState)pState.setValue(HALF, ThreeBlockHalf.MIDDLE), 3);
            pLevel.setBlock(pPos.above(2), (BlockState)pState.setValue(HALF, ThreeBlockHalf.UPPER), 3);
        }
    }

    private DoorHingeSide getHinge(BlockPlaceContext pContext) {
        BlockGetter level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        Direction facing = pContext.getHorizontalDirection();
        BlockPos middlePos = pos.above();
        BlockPos upperPos = pos.above(2);

        Direction counterClockwise = facing.getCounterClockWise();
        Direction clockwise = facing.getClockWise();

        // 检查周围方块以确定合页位置
        BlockPos counterPos = pos.relative(counterClockwise);
        BlockState counterState = level.getBlockState(counterPos);
        BlockPos counterMiddlePos = middlePos.relative(counterClockwise);
        BlockState counterMiddleState = level.getBlockState(counterMiddlePos);
        BlockPos counterUpperPos = upperPos.relative(counterClockwise);
        BlockState counterUpperState = level.getBlockState(counterUpperPos);

        BlockPos clockPos = pos.relative(clockwise);
        BlockState clockState = level.getBlockState(clockPos);
        BlockPos clockMiddlePos = middlePos.relative(clockwise);
        BlockState clockMiddleState = level.getBlockState(clockMiddlePos);
        BlockPos clockUpperPos = upperPos.relative(clockwise);
        BlockState clockUpperState = level.getBlockState(clockUpperPos);

        // 计算阻挡情况（-1表示左侧有阻挡，1表示右侧有阻挡）
        int blockCount = (counterState.isCollisionShapeFullBlock(level, counterPos) ? -1 : 0) +
                (counterMiddleState.isCollisionShapeFullBlock(level, counterMiddlePos) ? -1 : 0) +
                (counterUpperState.isCollisionShapeFullBlock(level, counterUpperPos) ? -1 : 0) +
                (clockState.isCollisionShapeFullBlock(level, clockPos) ? 1 : 0) +
                (clockMiddleState.isCollisionShapeFullBlock(level, clockMiddlePos) ? 1 : 0) +
                (clockUpperState.isCollisionShapeFullBlock(level, clockUpperPos) ? 1 : 0);

        // 检查是否已有门的部分存在
        boolean hasLeftDoor = counterState.is(this) && counterState.getValue(HALF) == ThreeBlockHalf.LOWER;
        boolean hasRightDoor = clockState.is(this) && clockState.getValue(HALF) == ThreeBlockHalf.LOWER;

        if ((!hasLeftDoor || hasRightDoor) && blockCount <= 0) {
            if ((!hasRightDoor || hasLeftDoor) && blockCount >= 0) {
                // 根据点击位置确定合页方向
                int stepX = facing.getStepX();
                int stepZ = facing.getStepZ();
                Vec3 clickPos = pContext.getClickLocation();
                double xDiff = clickPos.x - (double)pos.getX();
                double zDiff = clickPos.z - (double)pos.getZ();

                return (stepX >= 0 || !(zDiff < 0.5)) && (stepX <= 0 || !(zDiff > 0.5)) &&
                        (stepZ >= 0 || !(xDiff > 0.5)) && (stepZ <= 0 || !(xDiff < 0.5)) ?
                        DoorHingeSide.LEFT : DoorHingeSide.RIGHT;
            }
            return DoorHingeSide.LEFT;
        }
        return DoorHingeSide.RIGHT;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!this.type.canOpenByHand()) {
            return InteractionResult.PASS;
        }

        // 切换门的开关状态，并同步到整个三格门
        boolean newOpenState = !(Boolean)pState.getValue(OPEN);
        pState = (BlockState)pState.setValue(OPEN, newOpenState);
        pLevel.setBlock(pPos, pState, 10);

        // 更新中间和上部分的门状态
        ThreeBlockHalf half = pState.getValue(HALF);
        if (half == ThreeBlockHalf.LOWER) {
            pLevel.setBlock(pPos.above(), pState.setValue(HALF, ThreeBlockHalf.MIDDLE), 10);
            pLevel.setBlock(pPos.above(2), pState.setValue(HALF, ThreeBlockHalf.UPPER), 10);
        } else if (half == ThreeBlockHalf.MIDDLE) {
            pLevel.setBlock(pPos.below(), pState.setValue(HALF, ThreeBlockHalf.LOWER), 10);
            pLevel.setBlock(pPos.above(), pState.setValue(HALF, ThreeBlockHalf.UPPER), 10);
        } else if (half == ThreeBlockHalf.UPPER) {
            pLevel.setBlock(pPos.below(), pState.setValue(HALF, ThreeBlockHalf.MIDDLE), 10);
            pLevel.setBlock(pPos.below(2), pState.setValue(HALF, ThreeBlockHalf.LOWER), 10);
        }

        // 播放开门/关门声音
        this.playSound(pPlayer, pLevel, pPos, newOpenState);
        pLevel.gameEvent(pPlayer, newOpenState ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos);

        return InteractionResult.sidedSuccess(pLevel.isClientSide);
    }

    public boolean isOpen(BlockState pState) {
        return (Boolean)pState.getValue(OPEN);
    }

    public void setOpen(@Nullable Entity pEntity, Level pLevel, BlockState pState, BlockPos pPos, boolean pOpen) {
        if (pState.is(this) && (Boolean)pState.getValue(OPEN) != pOpen) {
            // 更新当前部分状态
            pLevel.setBlock(pPos, (BlockState)pState.setValue(OPEN, pOpen), 10);

            // 更新整个三格门的状态
            ThreeBlockHalf half = pState.getValue(HALF);
            if (half == ThreeBlockHalf.LOWER) {
                pLevel.setBlock(pPos.above(), pState.setValue(HALF, ThreeBlockHalf.MIDDLE).setValue(OPEN, pOpen), 10);
                pLevel.setBlock(pPos.above(2), pState.setValue(HALF, ThreeBlockHalf.UPPER).setValue(OPEN, pOpen), 10);
            } else if (half == ThreeBlockHalf.MIDDLE) {
                pLevel.setBlock(pPos.below(), pState.setValue(HALF, ThreeBlockHalf.LOWER).setValue(OPEN, pOpen), 10);
                pLevel.setBlock(pPos.above(), pState.setValue(HALF, ThreeBlockHalf.UPPER).setValue(OPEN, pOpen), 10);
            } else if (half == ThreeBlockHalf.UPPER) {
                pLevel.setBlock(pPos.below(), pState.setValue(HALF, ThreeBlockHalf.MIDDLE).setValue(OPEN, pOpen), 10);
                pLevel.setBlock(pPos.below(2), pState.setValue(HALF, ThreeBlockHalf.LOWER).setValue(OPEN, pOpen), 10);
            }

            // 播放声音
            this.playSound(pEntity, pLevel, pPos, pOpen);
            pLevel.gameEvent(pEntity, pOpen ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos);
        }
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        boolean isPowered = pLevel.hasNeighborSignal(pPos) ||
                pLevel.hasNeighborSignal(pPos.above()) ||
                pLevel.hasNeighborSignal(pPos.above(2));

        if (!this.defaultBlockState().is(pBlock) && isPowered != (Boolean)pState.getValue(POWERED)) {
            if (isPowered != (Boolean)pState.getValue(OPEN)) {
                this.playSound((Entity)null, pLevel, pPos, isPowered);
                pLevel.gameEvent((Entity)null, isPowered ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos);
            }

            // 更新当前部分状态
            pLevel.setBlock(pPos, (BlockState)((BlockState)pState.setValue(POWERED, isPowered)).setValue(OPEN, isPowered), 2);

            // 更新整个三格门的状态
            ThreeBlockHalf half = pState.getValue(HALF);
            if (half == ThreeBlockHalf.LOWER) {
                pLevel.setBlock(pPos.above(), pState.setValue(HALF, ThreeBlockHalf.MIDDLE).setValue(POWERED, isPowered).setValue(OPEN, isPowered), 2);
                pLevel.setBlock(pPos.above(2), pState.setValue(HALF, ThreeBlockHalf.UPPER).setValue(POWERED, isPowered).setValue(OPEN, isPowered), 2);
            } else if (half == ThreeBlockHalf.MIDDLE) {
                pLevel.setBlock(pPos.below(), pState.setValue(HALF, ThreeBlockHalf.LOWER).setValue(POWERED, isPowered).setValue(OPEN, isPowered), 2);
                pLevel.setBlock(pPos.above(), pState.setValue(HALF, ThreeBlockHalf.UPPER).setValue(POWERED, isPowered).setValue(OPEN, isPowered), 2);
            } else if (half == ThreeBlockHalf.UPPER) {
                pLevel.setBlock(pPos.below(), pState.setValue(HALF, ThreeBlockHalf.MIDDLE).setValue(POWERED, isPowered).setValue(OPEN, isPowered), 2);
                pLevel.setBlock(pPos.below(2), pState.setValue(HALF, ThreeBlockHalf.LOWER).setValue(POWERED, isPowered).setValue(OPEN, isPowered), 2);
            }
        }
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        ThreeBlockHalf half = pState.getValue(HALF);
        if (half == ThreeBlockHalf.LOWER) {
            // 下部分需要底部方块支撑
            BlockState bottomState = pLevel.getBlockState(pPos.below());
            return bottomState.isFaceSturdy(pLevel, pPos.below(), Direction.UP);
        } else {
            // 中、上部分需要下方是三格门的对应部分
            BlockState lowerState = pLevel.getBlockState(pPos.below());
            return lowerState.is(this) &&
                    (half == ThreeBlockHalf.MIDDLE ? lowerState.getValue(HALF) == ThreeBlockHalf.LOWER :
                            lowerState.getValue(HALF) == ThreeBlockHalf.MIDDLE);
        }
    }

    private void playSound(@Nullable Entity pSource, Level pLevel, BlockPos pPos, boolean pIsOpening) {
        pLevel.playSound(pSource, pPos, pIsOpening ? this.type.doorOpen() : this.type.doorClose(), SoundSource.BLOCKS, 1.0F, pLevel.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return (BlockState)pState.setValue(FACING, pRotation.rotate((Direction)pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pMirror == Mirror.NONE ? pState :
                (BlockState)pState.rotate(pMirror.getRotation((Direction)pState.getValue(FACING))).cycle(HINGE);
    }

    @Override
    public long getSeed(BlockState pState, BlockPos pPos) {
        ThreeBlockHalf half = pState.getValue(HALF);
        int yOffset = half == ThreeBlockHalf.LOWER ? 0 : (half == ThreeBlockHalf.MIDDLE ? 1 : 2);
        return Mth.getSeed(pPos.getX(), pPos.below(yOffset).getY(), pPos.getZ());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{HALF, FACING, OPEN, HINGE, POWERED});
    }

    public static boolean isWoodenThreeBlockDoor(Level pLevel, BlockPos pPos) {
        return isWoodenThreeBlockDoor(pLevel.getBlockState(pPos));
    }

    public static boolean isWoodenThreeBlockDoor(BlockState pState) {
        Block block = pState.getBlock();
        if (block instanceof DoorsBlock doorBlock) {
            return doorBlock.type().canOpenByHand();
        }
        return false;
    }

    // 新增三格门的半块枚举
    public enum ThreeBlockHalf implements StringRepresentable {
        LOWER,
        MIDDLE,
        UPPER;

        @Override
        public String getSerializedName() {
            return this.name().toLowerCase();
        }
    }

    static {
        // 初始化属性
        HALF = EnumProperty.create("half", ThreeBlockHalf.class);
        FACING = HorizontalDirectionalBlock.FACING;
        OPEN = BlockStateProperties.OPEN;
        HINGE = BlockStateProperties.DOOR_HINGE;
        POWERED = BlockStateProperties.POWERED;

        // 初始化三格门的碰撞箱（每个方向分下、中、上三部分）
        SOUTH_AABB_LOWER = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
        SOUTH_AABB_MIDDLE = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);
        SOUTH_AABB_UPPER = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 3.0);

        NORTH_AABB_LOWER = Block.box(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
        NORTH_AABB_MIDDLE = Block.box(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);
        NORTH_AABB_UPPER = Block.box(0.0, 0.0, 13.0, 16.0, 16.0, 16.0);

        WEST_AABB_LOWER = Block.box(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        WEST_AABB_MIDDLE = Block.box(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        WEST_AABB_UPPER = Block.box(13.0, 0.0, 0.0, 16.0, 16.0, 16.0);

        EAST_AABB_LOWER = Block.box(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
        EAST_AABB_MIDDLE = Block.box(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
        EAST_AABB_UPPER = Block.box(0.0, 0.0, 0.0, 3.0, 16.0, 16.0);
    }
}