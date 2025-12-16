package com.shengchanshe.chang_sheng_jue.block.custom.lockers;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.BigBlockType;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ChestLidController;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class LargeCabinetEntity extends RandomizableContainerBlockEntity {
    private final NonNullList<ItemStack> items = NonNullList.withSize(162, ItemStack.EMPTY);
    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        @Override
        protected void onOpen(Level level, BlockPos pos, BlockState state) {
            level.playSound(null, pos, SoundEvents.CHEST_OPEN, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
            level.blockEvent(pos, state.getBlock(), 1, 1);
        }

        @Override
        protected void onClose(Level level, BlockPos pos, BlockState state) {
            level.playSound(null, pos, SoundEvents.CHEST_CLOSE, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
            level.blockEvent(pos, state.getBlock(), 1, 0);
        }

        @Override
        protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int previousOpenCount, int openCount) {
        }

        @Override
        protected boolean isOwnContainer(Player player) {
            if (player.containerMenu instanceof ChestMenu chestMenu) {
                return chestMenu.getContainer() == LargeCabinetEntity.this;
            }
            return false;
        }
    };

    private final ChestLidController lidController = new ChestLidController();

    public LargeCabinetEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.LARGE_CABINET_ENTITY.get(), pPos, pBlockState);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, LargeCabinetEntity blockEntity) {
        blockEntity.lidController.tickLid();
    }

    private LargeCabinetEntity getMasterEntity() {
        BlockState state = getBlockState();
        if (!(state.getBlock() instanceof LargeCabinet)) {
            return this;
        }

        BigBlockType part = state.getValue(LargeCabinet.PART);
        if (part == BigBlockType.BOTTOM_LEFT) {
            return this;
        }

        BlockPos masterPos = findMasterPos(getBlockPos(), state);
        if (level != null && level.getBlockEntity(masterPos) instanceof LargeCabinetEntity master) {
            return master;
        }

        return this;
    }

    private BlockPos findMasterPos(BlockPos pos, BlockState state) {
        BigBlockType part = state.getValue(LargeCabinet.PART);
        int dx = switch (part) {
            case BOTTOM_LEFT, MIDDLE_LEFT, TOP_LEFT -> 0;
            case BOTTOM_RIGHT, MIDDLE_RIGHT, TOP_RIGHT -> 1;
        };
        int dy = switch (part) {
            case BOTTOM_LEFT, BOTTOM_RIGHT -> 0;
            case MIDDLE_LEFT, MIDDLE_RIGHT -> 1;
            case TOP_LEFT, TOP_RIGHT -> 2;
        };
        Direction facing = state.getValue(LargeCabinet.FACING);
        Direction right = facing.getCounterClockWise();
        return pos.relative(right.getOpposite(), dx).below(dy);
    }

    public float getOpenNess(float partialTicks) {
        LargeCabinetEntity master = getMasterEntity();
        if (master != this) {
            return master.lidController.getOpenness(partialTicks);
        }
        return this.lidController.getOpenness(partialTicks);
    }

    @Override
    public boolean triggerEvent(int id, int type) {
        if (id == 1) {
            if (isMasterBlock()) {
                notifyAllParts(type);
            }
            this.lidController.shouldBeOpen(type > 0);
            return true;
        }
        return super.triggerEvent(id, type);
    }

    private boolean isMasterBlock() {
        BlockState state = getBlockState();
        return state.getBlock() instanceof LargeCabinet &&
                state.getValue(LargeCabinet.PART) == BigBlockType.BOTTOM_LEFT;
    }

    private void notifyAllParts(int type) {
        if (level == null) return;

        BlockState state = getBlockState();
        Direction facing = state.getValue(LargeCabinet.FACING);
        Direction right = facing.getCounterClockWise();

        for (int dx = 0; dx <= 1; dx++) {
            for (int dy = 0; dy <= 2; dy++) {
                BlockPos partPos = worldPosition.relative(right, dx).above(dy);
                if (!partPos.equals(worldPosition)) { // 跳过自己
                    level.blockEvent(partPos, state.getBlock(), 1, type);
                }
            }
        }
    }

    @Override
    public void startOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            LargeCabinetEntity master = getMasterEntity();
            if (master.isMasterBlock()) {
                master.openersCounter.incrementOpeners(player, master.getLevel(), master.getBlockPos(), master.getBlockState());
            }
        }
    }

    @Override
    public void stopOpen(Player player) {
        if (!this.remove && !player.isSpectator()) {
            LargeCabinetEntity master = getMasterEntity();
            if (master.isMasterBlock()) {
                master.openersCounter.decrementOpeners(player, master.getLevel(), master.getBlockPos(), master.getBlockState());
            }
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.items.clear();
        if (!this.tryLoadLootTable(tag)) {
            ContainerHelper.loadAllItems(tag, this.items);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (!this.trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, this.items);
        }
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> nonNullList) {
        for (int i = 0; i < items.size() && i < nonNullList.size(); i++) {
            items.set(i, nonNullList.get(i));
        }
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container."+ ChangShengJue.MOD_ID +".cabinet");
    }

    @Nullable
    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        if (this.level == null) return null;
        return ChestMenu.sixRows(id, inventory, this);
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    public void setChanged() {
        super.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }
}