package com.shengchanshe.changshengjue.block.entity;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.changshengjue.block.custom.WeaponRack;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WeaponRackEntity extends BlockEntity {
    private float rotation = 0.0f;

    private Vec2 itemOffset = new Vec2(8.0f, 160.0f); // 默认居中位置
    private float rotationOffset = 100.0f;

//    // 添加设置偏移量的方法
//    public void setItemOffset(float x, float y) {
//        this.itemOffset = new Vec2(x, y);
//        setChanged();
//    }
//
//    // 添加设置旋转偏移的方法
//    public void setRotationOffset(float degrees) {
//        this.rotationOffset = degrees;
//        setChanged();
//    }
//
//    public float getItemRotation() {
//        return this.rotationOffset + getBlockState().getValue(WeaponRack.FACING).toYRot();
//    }
    private ItemStackHandler inventory = new ItemStackHandler(1) {
        @Override
        protected int getStackLimit(int slot, @NotNull ItemStack stack) {
            return 1;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyOptional = LazyOptional.empty();
    private final int INPUT_SLOT = 0;

    public WeaponRackEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.WEAPON_RACK_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyOptional.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyOptional = LazyOptional.of(() -> inventory);
    }




    public boolean addItem(ItemStack itemStack) {
        ItemStack stackInSlot = this.inventory.getStackInSlot(0);
        if (stackInSlot.isEmpty()) {
            this.inventory.setStackInSlot(0, itemStack.split(1));
            setChanged();
            this.rotation = 90.0f; // 随机旋转
            setChanged();
            return true;
        }
        return false;
    }

    public void drops(){
        SimpleContainer simpleContainer = new SimpleContainer(inventory.getSlots());
        simpleContainer.setItem(INPUT_SLOT,inventory.getStackInSlot(INPUT_SLOT));
        Containers.dropContents(this.level,this.worldPosition,simpleContainer);
    }

    public void drops(Player player){
        // 获取当前槽位的物品
        ItemStack stack = this.inventory.getStackInSlot(INPUT_SLOT);
        // 确保物品槽不为空
        if (!stack.isEmpty()) {
            // 尝试将物品放入玩家的背包
            boolean added = player.getInventory().add(stack);
            // 如果物品无法全部添加到背包，则掉落剩余的物品
            if (!added || !stack.isEmpty()) {
                // 在玩家附近掉落物品
                Containers.dropItemStack(this.level, player.getX(), player.getY(), player.getZ(), stack);
            }
            // 清空输入槽位中的物品
            this.inventory.setStackInSlot(INPUT_SLOT, ItemStack.EMPTY);
        }
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        if (pTag.contains("ItemOffsetX") && pTag.contains("ItemOffsetY")) {
            itemOffset = new Vec2(pTag.getFloat("ItemOffsetX"), pTag.getFloat("ItemOffsetY"));
        }
        rotationOffset = pTag.getFloat("RotationOffset");
        this.inventory.deserializeNBT(pTag.getCompound("ToolTableInventory"));
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyOptional.invalidate();
    }


    private CompoundTag writeItems(CompoundTag compoundTag){
        super.saveAdditional(compoundTag);
        compoundTag.put("ToolTableInventory",this.inventory.serializeNBT());
        return compoundTag;
    }
    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putFloat("ItemOffsetX", itemOffset.x);
        pTag.putFloat("ItemOffsetY", itemOffset.y);
        pTag.putFloat("RotationOffset", rotationOffset);
        this.writeItems(pTag);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.writeItems(new CompoundTag());
    }


    public ItemStackHandler getInventory() {
        return this.inventory;
    }

    public Vec2 getItemOffset() {
        return this.itemOffset;
    }
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        this.load(pkt.getTag());
    }

    @Override
    public void setChanged() {
        super.setChanged();
        if (this.level != null){
            this.level.sendBlockUpdated(this.getBlockPos(),this.getBlockState(),this.getBlockState(), Block.UPDATE_CLIENTS);
        }
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
    }


}
