package com.shengchanshe.chang_sheng_jue.block.custom.storage;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class BookGridEntity extends BlockEntity implements Container {
    private final ItemStackHandler itemHandler = createItemHandler();
    private final LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.of(() -> itemHandler);
    private Component customName;

    public BookGridEntity(BlockPos pos, BlockState blockState) {
        super(ChangShengJueBlocksEntities.BOOK_GRID_ENTITY.get(), pos, blockState);
    }

    private ItemStackHandler createItemHandler() {
        return new ItemStackHandler(1) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
                if (level != null) {
                    level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
                }
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return true;
            }

            @Override
            public int getSlotLimit(int slot) {
                return 16; // 每个槽位可以放16个物品
            }
        };
    }

    public InteractionResult placeItem(ItemStack heldItem, Player player, boolean isSneaking) {
        if (level == null || level.isClientSide) {
            return InteractionResult.PASS;
        }

        ItemStack currentItem = getItem(0);

        if (!currentItem.isEmpty()) {
            if (!ItemStack.isSameItemSameTags(currentItem, heldItem)) {
                return InteractionResult.FAIL;
            }
            if (currentItem.getCount() >= getMaxStackSize()) {
                return InteractionResult.FAIL;
            }
        }

        int spaceLeft = getMaxStackSize() - currentItem.getCount();
        int toPlace = isSneaking ? Math.min(heldItem.getCount(), spaceLeft) : 1;

        if (toPlace <= 0) {
            return InteractionResult.FAIL;
        }

        if (heldItem.getCount() < toPlace && !player.isCreative()) {
            return InteractionResult.FAIL;
        }

        if (currentItem.isEmpty()) {
            ItemStack stackToPlace = heldItem.copy();
            stackToPlace.setCount(toPlace);
            setItem(0, stackToPlace);
        } else {
            currentItem.grow(toPlace);
            setItem(0, currentItem);
        }

        if (!player.isCreative()) {
            heldItem.shrink(toPlace);
        }

        return InteractionResult.SUCCESS;
    }

    public InteractionResult takeItem(Player player, boolean isSneaking) {
        if (level == null || level.isClientSide) {
            return InteractionResult.PASS;
        }

        ItemStack storedItem = getItem(0);
        if (storedItem.isEmpty()) {
            return InteractionResult.FAIL;
        }

        int toTake = isSneaking ? storedItem.getCount() : 1;
        ItemStack stackToGive = storedItem.copy();
        stackToGive.setCount(toTake);

        if (!player.getInventory().add(stackToGive)) {
            ItemEntity itemEntity = new ItemEntity(level,
                    player.getX(), player.getY() + 0.5, player.getZ(),
                    stackToGive);
            itemEntity.setDefaultPickUpDelay();
            level.addFreshEntity(itemEntity);
        }

        storedItem.shrink(toTake);
        if (storedItem.isEmpty()) {
            setItem(0, ItemStack.EMPTY);
        } else {
            setItem(0, storedItem);
        }

        return InteractionResult.SUCCESS;

    }


    @Override
    public int getMaxStackSize() {
        return 16;
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, BookGridEntity entity) {
    }

    @Override
    public int getContainerSize() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return getItem(0).isEmpty();
    }

    @Override
    public ItemStack getItem(int slot) {
        return itemHandler.getStackInSlot(slot);
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        ItemStack stack = itemHandler.extractItem(slot, amount, false);
        if (!stack.isEmpty()) {
            setChanged();
        }
        return stack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        ItemStack stack = getItem(slot);
        if (stack.isEmpty()) {
            return ItemStack.EMPTY;
        } else {
            setItem(slot, ItemStack.EMPTY);
            return stack;
        }
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        itemHandler.setStackInSlot(slot, stack);
        setChanged();
    }

    @Override
    public boolean stillValid(Player player) {
        if (level == null || level.getBlockEntity(worldPosition) != this) {
            return false;
        }
        return player.distanceToSqr(worldPosition.getX() + 0.5, worldPosition.getY() + 0.5, worldPosition.getZ() + 0.5) <= 64.0;
    }

    @Override
    public void clearContent() {
        for (int i = 0; i < getContainerSize(); i++) {
            setItem(i, ItemStack.EMPTY);
        }
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", itemHandler.serializeNBT());
        if (this.customName != null) {
            tag.putString("CustomName", Component.Serializer.toJson(this.customName));
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        if (tag.contains("CustomName", 8)) {
            this.customName = Component.Serializer.fromJson(tag.getString("CustomName"));
        }
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    public void setCustomName(Component name) {
        this.customName = name;
    }

    public Component getDisplayName() {
        return null;
    }
}