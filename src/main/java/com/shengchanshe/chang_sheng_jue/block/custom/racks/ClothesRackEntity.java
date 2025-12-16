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

import java.util.ArrayList;
import java.util.List;

public class ClothesRackEntity extends BlockEntity {
    // 存储3个盔甲物品
    private final List<ItemStack> armorItems = new ArrayList<>();

    // 3个槽位的物品处理器，每个槽位对应固定的盔甲类型
    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            // 每个槽位只允许特定的盔甲类型
            if (stack.getItem() instanceof ArmorItem armor) {
                EquipmentSlot equipmentSlot = armor.getEquipmentSlot();
                return switch (slot) {
                    case 0 -> equipmentSlot == EquipmentSlot.CHEST;
                    case 1 -> equipmentSlot == EquipmentSlot.LEGS;
                    case 2 -> equipmentSlot == EquipmentSlot.FEET;
                    default -> false;
                };
            }
            return false;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            // 同步到 armorItems 列表
            if (slot >= 0 && slot < armorItems.size()) {
                armorItems.set(slot, getStackInSlot(slot).copy());
            }
            if (level != null && !level.isClientSide) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
            }
        }
    };

    private final LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.of(() -> itemHandler);

    public ClothesRackEntity(BlockPos pos, BlockState state) {
        super(ChangShengJueBlocksEntities.CLOTHES_RACK_ENTITY.get(), pos, state);
        // 初始化3个空槽位
        for (int i = 0; i < 3; i++) {
            armorItems.add(ItemStack.EMPTY);
        }
    }

    // 检查是否有任何盔甲
    public boolean hasArmor() {
        return getArmorCount() > 0;
    }

    // 获取盔甲数量
    public int getArmorCount() {
        int count = 0;
        for (ItemStack stack : armorItems) {
            if (!stack.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    // 获取指定槽位的盔甲
    public ItemStack getArmorItem(int slot) {
        if (slot >= 0 && slot < armorItems.size()) {
            return armorItems.get(slot);
        }
        return ItemStack.EMPTY;
    }

    // 获取所有盔甲物品
    public List<ItemStack> getAllArmorItems() {
        return new ArrayList<>(armorItems);
    }

    // 在指定槽位设置盔甲
    public boolean setArmorItem(int slot, ItemStack stack) {
        if (slot >= 0 && slot < armorItems.size() && isAllowedArmorForSlot(slot, stack)) {
            ItemStack armorStack = stack.copy();
            armorStack.setCount(1);
            armorItems.set(slot, armorStack);
            itemHandler.setStackInSlot(slot, armorStack);

            setChanged();
            if (level != null && !level.isClientSide) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
            }
            return true;
        }
        return false;
    }

    // 清除指定槽位的盔甲
    public void clearArmor(int slot) {
        if (slot >= 0 && slot < armorItems.size()) {
            armorItems.set(slot, ItemStack.EMPTY);
            itemHandler.setStackInSlot(slot, ItemStack.EMPTY);
            setChanged();
            if (level != null && !level.isClientSide) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
            }
        }
    }

    // 清除所有盔甲
    public void clearAllArmor() {
        for (int i = 0; i < armorItems.size(); i++) {
            armorItems.set(i, ItemStack.EMPTY);
            itemHandler.setStackInSlot(i, ItemStack.EMPTY);
        }
        setChanged();
        if (level != null && !level.isClientSide) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    private boolean isAllowedArmorForSlot(int slot, ItemStack stack) {
        if (stack.getItem() instanceof ArmorItem armor) {
            EquipmentSlot equipmentSlot = armor.getEquipmentSlot();
            return switch (slot) {
                case 0 -> equipmentSlot == EquipmentSlot.CHEST;
                case 1 -> equipmentSlot == EquipmentSlot.LEGS;
                case 2 -> equipmentSlot == EquipmentSlot.FEET;
                default -> false;
            };
        }
        return false;
    }

    public int getSlotForArmorType(EquipmentSlot armorType) {
        return switch (armorType) {
            case CHEST -> 0;
            case LEGS -> 1;
            case FEET -> 2;
            default -> -1;
        };
    }

    // 检查指定槽位是否为空
    public boolean isSlotEmpty(int slot) {
        return slot >= 0 && slot < armorItems.size() && armorItems.get(slot).isEmpty();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", itemHandler.serializeNBT());

        // 保存每个盔甲物品
        CompoundTag armorTag = new CompoundTag();
        for (int i = 0; i < armorItems.size(); i++) {
            if (!armorItems.get(i).isEmpty()) {
                CompoundTag itemTag = new CompoundTag();
                armorItems.get(i).save(itemTag);
                armorTag.put("ArmorItem_" + i, itemTag);
            }
        }
        tag.put("ArmorItems", armorTag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);

        // 初始化列表
        armorItems.clear();
        for (int i = 0; i < 3; i++) {
            armorItems.add(ItemStack.EMPTY);
        }

        if (tag.contains("inventory")) {
            itemHandler.deserializeNBT(tag.getCompound("inventory"));
            // 从 itemHandler 同步到 armorItems
            for (int i = 0; i < armorItems.size(); i++) {
                armorItems.set(i, itemHandler.getStackInSlot(i).copy());
            }
        }

        // 兼容旧版本数据
        if (tag.contains("ArmorItems")) {
            CompoundTag armorTag = tag.getCompound("ArmorItems");
            for (int i = 0; i < armorItems.size(); i++) {
                String key = "ArmorItem_" + i;
                if (armorTag.contains(key)) {
                    ItemStack stack = ItemStack.of(armorTag.getCompound(key));
                    armorItems.set(i, stack);
                    itemHandler.setStackInSlot(i, stack.copy());
                }
            }
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