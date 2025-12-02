package com.shengchanshe.chang_sheng_jue.block.custom.racks;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DryingRailEntity extends BlockEntity {
    private ItemStack armorItem = ItemStack.EMPTY;

    private final ItemStackHandler itemHandler = new ItemStackHandler(1) {
        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            if (stack.getItem() instanceof ArmorItem armor) {
                EquipmentSlot equipmentSlot = armor.getEquipmentSlot();
                return equipmentSlot == EquipmentSlot.CHEST || equipmentSlot == EquipmentSlot.LEGS;
            }
            return false;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null && !level.isClientSide) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
            }
        }
    };

    private final LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.of(() -> itemHandler);

    public DryingRailEntity(BlockPos pos, BlockState state) {
        super(ChangShengJueBlocksEntities.DRYING_RAIL_ENTITY.get(), pos, state);
    }

    public boolean hasArmor() {
        return !armorItem.isEmpty();
    }

    public ItemStack getArmorItem() {
        return armorItem;
    }

    public void setArmorItem(ItemStack stack) {
        this.armorItem = stack.copy();
        this.armorItem.setCount(1);

        this.itemHandler.setStackInSlot(0, this.armorItem);

        setChanged();
        if (level != null && !level.isClientSide) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    public void clearArmor() {
        this.armorItem = ItemStack.EMPTY;
        this.itemHandler.setStackInSlot(0, ItemStack.EMPTY);
        setChanged();
        if (level != null && !level.isClientSide) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", itemHandler.serializeNBT());
        if (!armorItem.isEmpty()) {
            tag.put("ArmorItem", armorItem.save(new CompoundTag()));
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("inventory")) {
            itemHandler.deserializeNBT(tag.getCompound("inventory"));
            this.armorItem = itemHandler.getStackInSlot(0);
        } else if (tag.contains("ArmorItem")) {
            this.armorItem = ItemStack.of(tag.getCompound("ArmorItem"));
            this.itemHandler.setStackInSlot(0, this.armorItem);
        } else {
            this.armorItem = ItemStack.EMPTY;
            this.itemHandler.setStackInSlot(0, ItemStack.EMPTY);
        }
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        saveAdditional(tag);
        return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        CompoundTag tag = pkt.getTag();
        if (tag != null) {
            load(tag);
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
}