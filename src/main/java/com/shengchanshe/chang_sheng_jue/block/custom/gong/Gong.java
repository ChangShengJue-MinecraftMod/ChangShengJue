package com.shengchanshe.chang_sheng_jue.block.custom.gong;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BellAttachType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class Gong extends BellBlock {
    public Gong(Properties pProperties) {
        super(pProperties);
    }

    private VoxelShape getVoxelShape(BlockState pState) {
        if (pState.getValue(FACING) == Direction.SOUTH || pState.getValue(FACING) == Direction.NORTH) {
            return Block.box(1, 0.25, 7, 15, 16.25, 9);
        }else {
            return Block.box(7, 0.25, 1, 9, 16.25, 15);
        }
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return this.getVoxelShape(pState);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return this.getVoxelShape(pState);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ChangShengJueBlocksEntities.GONG_ENTITY.get(),
                pLevel.isClientSide ? GongEntity::clientTick : GongEntity::serverTick);
    }

    public void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile) {
        Entity $$4 = pProjectile.getOwner();
        Player $$5 = $$4 instanceof Player ? (Player)$$4 : null;
        this.onHit(pLevel, pState, pHit, $$5, true);
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        return this.onHit(pLevel, pState, pHit, pPlayer, true) ? InteractionResult.sidedSuccess(pLevel.isClientSide) : InteractionResult.PASS;
    }

    public boolean onHit(Level pLevel, BlockState pState, BlockHitResult pResult, @Nullable Player pPlayer, boolean pCanRingBell) {
        Direction direction = pResult.getDirection();
        BlockPos blockPos = pResult.getBlockPos();
        boolean $$7 = !pCanRingBell || this.isProperHit(pState, direction, pResult.getLocation().y - (double)blockPos.getY());
        if ($$7) {
            boolean $$8 = this.attemptToRing(pPlayer, pLevel, blockPos, direction);
            if ($$8 && pPlayer != null) {
                pPlayer.awardStat(Stats.BELL_RING);
            }

            return true;
        } else {
            return false;
        }
    }

    private boolean isProperHit(BlockState pPos, Direction pDirection, double pDistanceY) {
        if (pDirection.getAxis() != Direction.Axis.Y && !(pDistanceY > 0.8123999834060669)) {
            Direction value = pPos.getValue(FACING);
            return value.getAxis() == pDirection.getAxis();
        } else {
            return false;
        }
    }

    public boolean attemptToRing(Level pLevel, BlockPos pPos, @Nullable Direction pDirection) {
        return this.attemptToRing(null, pLevel, pPos, pDirection);
    }

    public boolean attemptToRing(@Nullable Entity pEntity, Level pLevel, BlockPos pPos, @Nullable Direction pDirection) {
        BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
        if (!pLevel.isClientSide && blockEntity instanceof GongEntity) {
            if (pDirection == null) {
                pDirection = pLevel.getBlockState(pPos).getValue(FACING);
            }

            ((GongEntity)blockEntity).onHit(pDirection);
            pLevel.playSound(null, pPos, ChangShengJueSound.GONG_SOUND.get(), SoundSource.BLOCKS, 2.0F, 1.0F);
            pLevel.gameEvent(pEntity, GameEvent.BLOCK_CHANGE, pPos);
            return true;
        } else {
            return false;
        }
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
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean isMoving) {
        if (!level.isClientSide) {
            if (!this.canSurvive(state, level, pos)) {
                level.destroyBlock(pos, true);
            }
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction clickedFace = pContext.getClickedFace();
        BlockPos clickedPos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        Direction.Axis axis = clickedFace.getAxis();
        BlockState blockState;
        if (axis == Direction.Axis.Y) {
            blockState = this.defaultBlockState().setValue(ATTACHMENT, clickedFace == Direction.DOWN ? BellAttachType.CEILING : BellAttachType.FLOOR).setValue(FACING, pContext.getHorizontalDirection().getOpposite());
            if (blockState.canSurvive(pContext.getLevel(), clickedPos)) {
                return blockState;
            }
        } else {
            boolean $$6 = axis == Direction.Axis.X && level.getBlockState(clickedPos.west()).isFaceSturdy(level, clickedPos.west(), Direction.EAST) && level.getBlockState(clickedPos.east()).isFaceSturdy(level, clickedPos.east(), Direction.WEST) || axis == Direction.Axis.Z && level.getBlockState(clickedPos.north()).isFaceSturdy(level, clickedPos.north(), Direction.SOUTH) && level.getBlockState(clickedPos.south()).isFaceSturdy(level, clickedPos.south(), Direction.NORTH);
            blockState = this.defaultBlockState().setValue(FACING, clickedFace).setValue(ATTACHMENT, $$6 ? BellAttachType.DOUBLE_WALL : BellAttachType.SINGLE_WALL);
            if (blockState.canSurvive(pContext.getLevel(), pContext.getClickedPos())) {
                return blockState;
            }

            boolean $$8 = level.getBlockState(clickedPos.below()).isFaceSturdy(level, clickedPos.below(), Direction.UP);
            blockState = blockState.setValue(ATTACHMENT, $$8 ? BellAttachType.FLOOR : BellAttachType.CEILING);
            if (blockState.canSurvive(pContext.getLevel(), pContext.getClickedPos())) {
                return blockState;
            }
        }

        return null;
    }


    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new GongEntity(pPos, pState);
    }

}
