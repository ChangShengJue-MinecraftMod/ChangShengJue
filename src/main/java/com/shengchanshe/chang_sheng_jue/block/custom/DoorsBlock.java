package com.shengchanshe.chang_sheng_jue.block.custom;

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
import net.minecraftforge.eventbus.api.SubscribeEvent;

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
            // 获取其他两部分的位置和状态
            BlockPos lowerPos = half == ThreeBlockHalf.LOWER ? pCurrentPos :
                    (half == ThreeBlockHalf.MIDDLE ? pCurrentPos.below() : pCurrentPos.below(2));
            BlockPos middlePos = half == ThreeBlockHalf.LOWER ? pCurrentPos.above() :
                    (half == ThreeBlockHalf.MIDDLE ? pCurrentPos : pCurrentPos.below());
            BlockPos upperPos = half == ThreeBlockHalf.LOWER ? pCurrentPos.above(2) :
                    (half == ThreeBlockHalf.MIDDLE ? pCurrentPos.above() : pCurrentPos);

            BlockState lowerState = pLevel.getBlockState(lowerPos);
            BlockState middleState = pLevel.getBlockState(middlePos);
            BlockState upperState = pLevel.getBlockState(upperPos);

            // 检查三部分是否完整且一致
            boolean isStructureValid = lowerState.is(this) && lowerState.getValue(HALF) == ThreeBlockHalf.LOWER &&
                    middleState.is(this) && middleState.getValue(HALF) == ThreeBlockHalf.MIDDLE &&
                    upperState.is(this) && upperState.getValue(HALF) == ThreeBlockHalf.UPPER;

            // 如果结构不完整，破坏整个门
            if (!isStructureValid) {
                // 只在服务器端执行破坏操作，避免客户端重复调用
                if (!pLevel.isClientSide()) {
                    if (lowerState.is(this)) {
                        pLevel.destroyBlock(lowerPos, true);
                    }
                    if (middleState.is(this)) {
                        pLevel.destroyBlock(middlePos, true);
                    }
                    if (upperState.is(this)) {
                        pLevel.destroyBlock(upperPos, true);
                    }
                }
                return Blocks.AIR.defaultBlockState();
            }

            // 如果结构有效，同步三个部分的状态
            if (pFacingState.is(this)) {
                return syncDoorStates(pState, lowerState, middleState, upperState);
            }
        }

        // 处理其他方向的更新
        return half == ThreeBlockHalf.LOWER && pFacing == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ?
                Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    /**
     * 同步三部分门的状态
     */
    private BlockState syncDoorStates(BlockState currentState, BlockState lowerState, BlockState middleState, BlockState upperState) {
        // 假设我们从lowerState获取状态值，因为它是第一个放置的部分
        Direction facing = lowerState.getValue(FACING);
        Boolean open = lowerState.getValue(OPEN);
        DoorHingeSide hinge = lowerState.getValue(HINGE);
        Boolean powered = lowerState.getValue(POWERED);

        // 更新当前部分的状态
        return (BlockState)((BlockState)((BlockState)currentState.setValue(FACING, facing)).setValue(OPEN, open)).setValue(HINGE, hinge).setValue(POWERED, powered);
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pLevel.isClientSide && pPlayer.isCreative()) {
            // 防止创造性模式下只破坏部分门
            ThreeBlockHalf half = pState.getValue(HALF);
            if (half == ThreeBlockHalf.LOWER) {
                System.out.println("lower");
                pLevel.destroyBlock(pPos.above(),false);
                pLevel.destroyBlock(pPos, false);
                pLevel.destroyBlock(pPos.above(2), false);
            } else if (half == ThreeBlockHalf.MIDDLE) {
                System.out.println("middle");
                pLevel.destroyBlock(pPos.below(), false);
                pLevel.destroyBlock(pPos, false);
                pLevel.destroyBlock(pPos.above(), false);
            } else if (half == ThreeBlockHalf.UPPER) {
                System.out.println("upper");
                pLevel.destroyBlock(pPos.below(), false);
                pLevel.destroyBlock(pPos, false);
                pLevel.destroyBlock(pPos.below(2), false);
            }
        }
        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    // 确保三格门的路径寻路判定与原版一致
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return true;
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

    // 在use方法中确保事件正确触发
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!this.type.canOpenByHand()) {
            return InteractionResult.PASS;
        } else {
            boolean newOpenState = !(Boolean)pState.getValue(OPEN);
            BlockState newState = pState.setValue(OPEN, newOpenState);
            pLevel.setBlock(pPos, newState, 10);

            // 更新三格门状态
            ThreeBlockHalf half = pState.getValue(HALF);
            if (half == ThreeBlockHalf.LOWER) {
                pLevel.setBlock(pPos.above(), newState.setValue(HALF, ThreeBlockHalf.MIDDLE), 10);
                pLevel.setBlock(pPos.above(2), newState.setValue(HALF, ThreeBlockHalf.UPPER), 10);
            } else if (half == ThreeBlockHalf.MIDDLE) {
                pLevel.setBlock(pPos.below(), newState.setValue(HALF, ThreeBlockHalf.LOWER), 10);
                pLevel.setBlock(pPos.above(), newState.setValue(HALF, ThreeBlockHalf.UPPER), 10);
            } else if (half == ThreeBlockHalf.UPPER) {
                pLevel.setBlock(pPos.below(), newState.setValue(HALF, ThreeBlockHalf.MIDDLE), 10);
                pLevel.setBlock(pPos.below(2), newState.setValue(HALF, ThreeBlockHalf.LOWER), 10);
            }

            // 触发所有三格门的事件
            this.playSound(pPlayer, pLevel, pPos, newOpenState);
            pLevel.gameEvent(pPlayer, newOpenState ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos);

            if (half == ThreeBlockHalf.LOWER) {
                pLevel.gameEvent(pPlayer, newOpenState ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos.above());
                pLevel.gameEvent(pPlayer, newOpenState ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos.above(2));
            }

            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
    }

    public boolean isOpen(BlockState pState) {
        return (Boolean)pState.getValue(OPEN);
    }

    // 修改setOpen方法，确保事件正确触发且状态一致
    public void setOpen(@Nullable Entity pEntity, Level pLevel, BlockState pState, BlockPos pPos, boolean pOpen) {
        if (pState.is(this) && (Boolean)pState.getValue(OPEN) != pOpen) {
            // 先更新当前格状态
            BlockState newState = pState.setValue(OPEN, pOpen);
            pLevel.setBlock(pPos, newState, 10);

            // 更新整个三格门状态
            ThreeBlockHalf half = pState.getValue(HALF);
            if (half == ThreeBlockHalf.LOWER) {
                pLevel.setBlock(pPos.above(), newState.setValue(HALF, ThreeBlockHalf.MIDDLE), 10);
                pLevel.setBlock(pPos.above(2), newState.setValue(HALF, ThreeBlockHalf.UPPER), 10);
            } else if (half == ThreeBlockHalf.MIDDLE) {
                pLevel.setBlock(pPos.below(), newState.setValue(HALF, ThreeBlockHalf.LOWER), 10);
                pLevel.setBlock(pPos.above(), newState.setValue(HALF, ThreeBlockHalf.UPPER), 10);
            } else if (half == ThreeBlockHalf.UPPER) {
                pLevel.setBlock(pPos.below(), newState.setValue(HALF, ThreeBlockHalf.MIDDLE), 10);
                pLevel.setBlock(pPos.below(2), newState.setValue(HALF, ThreeBlockHalf.LOWER), 10);
            }

            // 确保事件在所有三格门位置触发
            this.playSound(pEntity, pLevel, pPos, pOpen);
            pLevel.gameEvent(pEntity, pOpen ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos);

            // 额外触发中间和顶部方块的事件
            if (half == ThreeBlockHalf.LOWER) {
                pLevel.gameEvent(pEntity, pOpen ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos.above());
                pLevel.gameEvent(pEntity, pOpen ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos.above(2));
            }
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
        return true;
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



    public static boolean isWoodenDoor(Level pLevel, BlockPos pPos) {
        return isWoodenDoor(pLevel.getBlockState(pPos));
    }

    public static boolean isWoodenDoor(BlockState pState) {
        Block var2 = pState.getBlock();
        boolean var10000;
        if (var2 instanceof DoorBlock $$1) {
            if ($$1.type().canOpenByHand()) {
                var10000 = true;
                return var10000;
            }
        }

        var10000 = false;
        return var10000;
    }
}