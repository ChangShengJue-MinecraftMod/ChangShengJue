package com.shengchanshe.chang_sheng_jue.block.custom;

import com.shengchanshe.chang_sheng_jue.block.RoofPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class DoorsBlock extends DoorBlock {
    public static final EnumProperty<RoofPart> PART = EnumProperty.create("part", RoofPart.class);
    private final BlockSetType type;
    public DoorsBlock(Properties pProperties, BlockSetType pType) {
        super(pProperties, pType);
        this.type = pType;
        // 基于父类的默认状态，只添加我们自定义的PART属性
        BlockState defaultState = this.stateDefinition.any().setValue(PART, RoofPart.BOTTOM);

        // 设置其他属性（如果存在的话）
        if (defaultState.hasProperty(FACING)) {
            defaultState = defaultState.setValue(FACING, Direction.NORTH);
        }
        if (defaultState.hasProperty(OPEN)) {
            defaultState = defaultState.setValue(OPEN, false);
        }
        if (defaultState.hasProperty(HINGE)) {
            defaultState = defaultState.setValue(HINGE, DoorHingeSide.LEFT);
        }
        if (defaultState.hasProperty(POWERED)) {
            defaultState = defaultState.setValue(POWERED, false);
        }
        if (defaultState.hasProperty(HALF)) {
            defaultState = defaultState.setValue(HALF, DoubleBlockHalf.LOWER);
        }

        if (defaultState.hasProperty(BlockStateProperties.WATERLOGGED)) {
            defaultState = defaultState.setValue(BlockStateProperties.WATERLOGGED, false);
        }

        this.registerDefaultState(defaultState);
    }

    public @NotNull BlockSetType type() {
        return this.type;
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        if (!pLevel.isClientSide && pPlayer.isCreative()) {
            this.preventCreativeDropFromBottomPart(pLevel, pPos, pState, pPlayer);
        }

        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    protected void preventCreativeDropFromBottomPart(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        RoofPart value = pState.getValue(PART);
        if (value == RoofPart.BOTTOM) {
            BlockPos blockpos = pPos.above();
            BlockState blockstate = pLevel.getBlockState(blockpos);
            if (blockstate.is(pState.getBlock()) && blockstate.getValue(PART) == RoofPart.MIDDLE) {
                BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                pLevel.setBlock(blockpos, blockstate1, 35);
                pLevel.levelEvent(pPlayer, 2001, blockpos, Block.getId(blockstate));
            }
        }else if (value == RoofPart.TOP) {
            BlockPos blockpos = pPos.below();
            BlockState blockstate = pLevel.getBlockState(blockpos);
            if (blockstate.is(pState.getBlock()) && blockstate.getValue(PART) == RoofPart.MIDDLE) {
                BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                pLevel.setBlock(blockpos, blockstate1, 35);
                pLevel.levelEvent(pPlayer, 2001, blockpos, Block.getId(blockstate));
            }
        }

    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos pos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        if (pos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(pos.above()).canBeReplaced(pContext)) {
            boolean $$3 = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above());
            return this.defaultBlockState()
                    .setValue(FACING, pContext.getHorizontalDirection())
                    .setValue(HINGE, this.getHinge(pContext))
                    .setValue(POWERED, $$3).setValue(OPEN, $$3)
                    .setValue(PART, RoofPart.BOTTOM);
        } else {
            return null;
        }
    }
    private DoorHingeSide getHinge(BlockPlaceContext pContext) {
        BlockGetter $$1 = pContext.getLevel();
        BlockPos $$2 = pContext.getClickedPos();
        Direction $$3 = pContext.getHorizontalDirection();
        BlockPos $$4 = $$2.above();
        Direction $$5 = $$3.getCounterClockWise();
        BlockPos $$6 = $$2.relative($$5);
        BlockState $$7 = $$1.getBlockState($$6);
        BlockPos $$8 = $$4.relative($$5);
        BlockState $$9 = $$1.getBlockState($$8);
        Direction $$10 = $$3.getClockWise();
        BlockPos $$11 = $$2.relative($$10);
        BlockState $$12 = $$1.getBlockState($$11);
        BlockPos $$13 = $$4.relative($$10);
        BlockState $$14 = $$1.getBlockState($$13);
        int $$15 = ($$7.isCollisionShapeFullBlock($$1, $$6) ? -1 : 0) + ($$9.isCollisionShapeFullBlock($$1, $$8) ? -1 : 0) + ($$12.isCollisionShapeFullBlock($$1, $$11) ? 1 : 0) + ($$14.isCollisionShapeFullBlock($$1, $$13) ? 1 : 0);
        boolean $$16 = $$7.is(this) && $$7.getValue(PART) == RoofPart.BOTTOM;
        boolean $$17 = $$12.is(this) && $$12.getValue(PART) == RoofPart.BOTTOM;
        if ((!$$16 || $$17) && $$15 <= 0) {
            if ((!$$17 || $$16) && $$15 >= 0) {
                int $$18 = $$3.getStepX();
                int $$19 = $$3.getStepZ();
                Vec3 $$20 = pContext.getClickLocation();
                double $$21 = $$20.x - (double)$$2.getX();
                double $$22 = $$20.z - (double)$$2.getZ();
                return ($$18 >= 0 || !($$22 < 0.5)) && ($$18 <= 0 || !($$22 > 0.5)) && ($$19 >= 0 || !($$21 > 0.5)) && ($$19 <= 0 || !($$21 < 0.5)) ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT;
            } else {
                return DoorHingeSide.LEFT;
            }
        } else {
            return DoorHingeSide.RIGHT;
        }
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        // 自动生成中部和顶部
        level.setBlock(pos.above(), state.setValue(PART, RoofPart.MIDDLE), Block.UPDATE_ALL);
        level.setBlock(pos.above(2), state.setValue(PART, RoofPart.TOP), Block.UPDATE_ALL);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos below = pPos.below();
        BlockState blockState = pLevel.getBlockState(below);
        return pState.getValue(PART) == RoofPart.BOTTOM ? blockState.isFaceSturdy(pLevel, below, Direction.UP) : blockState.is(this);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!this.type.canOpenByHand()) {
            return InteractionResult.PASS;
        } else {
            pState = pState.cycle(OPEN);
            pLevel.setBlock(pPos, pState, 10);
            this.playSound(pPlayer, pLevel, pPos, pState.getValue(OPEN));
            pLevel.gameEvent(pPlayer, this.isOpen(pState) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos);
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
    }

    public boolean isOpen(BlockState pState) {
        return pState.getValue(OPEN);
    }

    public void setOpen(@Nullable Entity pEntity, Level pLevel, BlockState pState, BlockPos pPos, boolean pOpen) {
        if (pState.is(this) && pState.getValue(OPEN) != pOpen) {
            pLevel.setBlock(pPos, pState.setValue(OPEN, pOpen), 10);
            this.playSound(pEntity, pLevel, pPos, pOpen);
            pLevel.gameEvent(pEntity, pOpen ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos);
        }
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        // 检测红石信号（包含三部分联动）
        boolean hasSignal = pLevel.hasNeighborSignal(pPos); // 先检查当前位置

        switch (pState.getValue(PART)) {
            case BOTTOM -> { // 底部部分检查上方两个方块
                hasSignal |= pLevel.hasNeighborSignal(pPos.above());
                hasSignal |= pLevel.hasNeighborSignal(pPos.above(2));
            }
            case MIDDLE -> { // 中间部分检查上下各一个方块
                hasSignal |= pLevel.hasNeighborSignal(pPos.below());
                hasSignal |= pLevel.hasNeighborSignal(pPos.above());
            }
            case TOP -> { // 顶部部分检查下方两个方块
                hasSignal |= pLevel.hasNeighborSignal(pPos.below());
                hasSignal |= pLevel.hasNeighborSignal(pPos.below(2));
            }
        }

        // 只有当信号状态变化且不是自身方块更新时才处理
        if (!this.defaultBlockState().is(pBlock) && hasSignal != pState.getValue(POWERED)) {
            // 如果开关状态需要改变
            if (hasSignal != pState.getValue(OPEN)) {
                this.playSound(null, pLevel, pPos, hasSignal);
                pLevel.gameEvent(null, hasSignal ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos);
            }

            // 更新方块状态（同时更新POWERED和OPEN状态）
            pLevel.setBlock(pPos,
                    pState.setValue(POWERED, hasSignal)
                            .setValue(OPEN, hasSignal),
                    2); // Flag 2表示只更新客户端不触发邻居更新
        }
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing,
                                  BlockState pFacingState, LevelAccessor pLevel,
                                  BlockPos pCurrentPos, BlockPos pFacingPos) {
        RoofPart value = pState.getValue(PART);
            if ((pFacing.getAxis() == Direction.Axis.Y) && (value == RoofPart.BOTTOM && pFacing == Direction.UP) ||
                    (value == RoofPart.TOP && pFacing == Direction.DOWN) ||
                    (value == RoofPart.MIDDLE && (pFacing == Direction.UP || pFacing == Direction.DOWN))) {

                return pFacingState.is(this) && pFacingState.getValue(PART) != value ?
                        pState.setValue(FACING, pFacingState.getValue(FACING)).setValue(OPEN, pFacingState.getValue(OPEN))
                                .setValue(HINGE, pFacingState.getValue(HINGE)).setValue(POWERED, pFacingState.getValue(POWERED))
                        : Blocks.AIR.defaultBlockState();
            }else {
                return value == RoofPart.BOTTOM && pFacing == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos)
                        ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
            }
    }

    public long getSeed(BlockState pState, BlockPos pPos) {
        return Mth.getSeed(pPos.getX(), pPos.below(pState.getValue(PART) == RoofPart.BOTTOM ? 0
                : pState.getValue(PART) == RoofPart.MIDDLE ? 1 : 2).getY(), pPos.getZ());
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

    private void playSound(@Nullable Entity pSource, Level pLevel, BlockPos pPos, boolean pIsOpening) {
        pLevel.playSound(pSource, pPos, pIsOpening ? this.type.doorOpen() : this.type.doorClose(), SoundSource.BLOCKS, 1.0F, pLevel.getRandom().nextFloat() * 0.1F + 0.9F);
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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(PART);
    }
}