package com.shengchanshe.changshengjue.block.decoration;

import com.shengchanshe.changshengjue.block.entity.BlueAndWhitePorcelainFlowerPotsEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class BlueAndWhitePorcelainFlowerPots extends BaseEntityBlock {
    public BlueAndWhitePorcelainFlowerPots(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
        if (blockEntity instanceof BlueAndWhitePorcelainFlowerPotsEntity entity) {
            ItemStack itemStack = pPlayer.getItemInHand(pHand);
            boolean isPlaceable = itemStack.is(ItemTags.FLOWERS);
            ItemStack itemStack2 = entity.getPlant(Slot.PLANT);
            if (isPlaceable && itemStack2.isEmpty()) {
                this.setPlant(entity, Slot.PLANT, pPlayer, itemStack);
            } else {
                if (!itemStack2.isEmpty()) {
                    Block.popResource(pLevel, pPos, itemStack2.copyWithCount(1));
                    this.setPlant(entity, Slot.PLANT, pPlayer, ItemStack.EMPTY);
                } else {
                    return InteractionResult.PASS;
                }
            }
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide);
    }

    private void setPlant(BlueAndWhitePorcelainFlowerPotsEntity entity, Slot slot, Player player, ItemStack itemStack) {
        Level level = entity.getLevel();
        if (level == null){
            return;
        }
        level.gameEvent(GameEvent.BLOCK_CHANGE, entity.getBlockPos(), GameEvent.Context.of(player, entity.getBlockState()));
        entity.setPlant(slot, itemStack.copyWithCount(1));
        if (!itemStack.isEmpty()) {
            if (!player.getAbilities().instabuild){
                itemStack.shrink(1);
            }
            level.playSound(null, entity.getBlockPos(), SoundEvents.CROP_PLANTED, SoundSource.BLOCKS, 1.0F, 1.2F);
        }
        entity.setChanged();
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof BlueAndWhitePorcelainFlowerPotsEntity) {
                for (Slot slot : Slot.values()) {
                    ItemStack itemstack = ((BlueAndWhitePorcelainFlowerPotsEntity) blockentity).getPlant(slot).copyWithCount(1);
                    if (!itemstack.isEmpty()) {
                        ItemEntity itementity = new ItemEntity(pLevel, (double) pPos.getX() + 0.5D, pPos.getY() + 1, (double) pPos.getZ() + 0.5D, itemstack);
                        itementity.setDefaultPickUpDelay();
                        pLevel.addFreshEntity(itementity);
                    }
                }
            }
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        }
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Stream.of(
                Block.box(5.5, 0, 5.5, 10.5, 1, 10.5),
                Block.box(5, 1, 5, 11, 4, 11),
                Block.box(4.5, 4, 4.5, 11.5, 5, 11.5),
                Block.box(4, 5, 4, 12, 5.5, 12)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }

    @Override
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos.below()).isFaceSturdy(pLevel, pPos.below(), Direction.UP);
    }


    @Override
    public SoundType getSoundType(BlockState state, LevelReader level, BlockPos pos, @Nullable Entity entity) {
        return SoundType.DECORATED_POT;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BlueAndWhitePorcelainFlowerPotsEntity(pPos, pState);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public enum Slot {
        PLANT,
    }
}
