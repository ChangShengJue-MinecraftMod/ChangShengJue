package com.shengchanshe.changshengjue.block.entity;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PotteryWheelEntity extends BlockEntity {
    private ItemStackHandler inventory = new ItemStackHandler(2){
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
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 200;
    private final int INPUT_SLOT = 0;
    private final int OUTPUT_SLOT = 1;

    public PotteryWheelEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.POTTERY_WHEEL_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0-> PotteryWheelEntity.this.progress;
                    case 1-> PotteryWheelEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex){
                    case 0-> PotteryWheelEntity.this.progress = pValue;
                    case 1-> PotteryWheelEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER){
            return lazyOptional.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyOptional = LazyOptional.of(() -> inventory);
    }

    public boolean addItem(ItemStack itemStack){
//        boolean isShiftDown = Minecraft.getInstance().options.keyShift.isDown();

        for (int i = 0; i <  this.inventory.getSlots(); i++) {
        ItemStack stackInSlot = this.inventory.getStackInSlot(i);
            if(stackInSlot.isEmpty()){
                this.inventory.setStackInSlot(i,itemStack.split(1));
                setChanged();
                return true;
            }
        }
//        if(stackInSlot.isEmpty()){
//            this.inventory.setStackInSlot(0,itemStack.split(1));
//            setChanged();
//            return true;
//        }else if (!stackInSlot.isEmpty() && this.inventory.getStackInSlot(INPUT_SLOT).getItem() == itemStack.getItem() && stackInSlot.getCount() < stackInSlot.getMaxStackSize()) {// 如果槽位非空，且物品类型相同，并且槽位中的物品没有达到最大堆叠限制
////            Math.min(itemStack.getCount(), stackInSlot.getMaxStackSize() - stackInSlot.getCount()) :如果没满全部放入
//            int transferableAmount = 1;
//            stackInSlot.grow(transferableAmount);  // 将可以堆叠的数量加到当前槽位
//            itemStack.shrink(transferableAmount);  // 减少原始物品堆中的数量
//            setChanged();
//            return true;
//        }
        return false;
    }

    public void drops(){
        SimpleContainer simpleContainer = new SimpleContainer(inventory.getSlots());
        for (int i = 0; i < this.inventory.getSlots(); i++) {
            simpleContainer.setItem(i,inventory.getStackInSlot(i));
        }
        Containers.dropContents(this.level,this.worldPosition,simpleContainer);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.inventory.deserializeNBT(pTag.getCompound("Inventory"));
        progress = pTag.getInt("PotteryProgress");
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyOptional.invalidate();
    }

    private CompoundTag writeItems(CompoundTag compoundTag){
        super.saveAdditional(compoundTag);
        compoundTag.put("Inventory",this.inventory.serializeNBT());
        compoundTag.putInt("PotteryProgress",progress);
        return compoundTag;
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        this.writeItems(pTag);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.writeItems(new CompoundTag());
    }


    public ItemStackHandler getInventory() {
        return this.inventory;
    }

    public Vec3 getItemOffset(int i) {
        float x = 0.0f;
        float y = 0.2f;
        float z = 0.02f;
        Vec3[] offset = new Vec3[]{
                new Vec3(x,y,z),new Vec3(-x,y,-z),
                new Vec3(x,-y,z), new Vec3(-x,-y,-z)
        };
        return offset[i];
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
        if (hasRecipe()){
            increaseCraftingProgress();
            setChanged(pLevel,pPos,pState);
            if (hasProgressFinished()){
                craftItem();
                resrtProgress();
            }
        }else {
            resrtProgress();
        }
    }

    private void resrtProgress() {
        progress = 0;
    }

    private void craftItem() {
        ItemStack stack;
        if (!this.inventory.getStackInSlot(0).isEmpty() && !this.inventory.getStackInSlot(1).isEmpty()){
            stack = new ItemStack(ChangShengJueItems.CI_WAN.get(),1);
            this.inventory.extractItem(INPUT_SLOT,2,false);
        }else {
            stack = new ItemStack(ChangShengJueItems.CI_PAN.get(),1);
            this.inventory.extractItem(INPUT_SLOT,1,false);
        }
        Containers.dropItemStack(this.level, this.getBlockPos().getX(),  this.getBlockPos().getY(),  this.getBlockPos().getZ(), stack);
        this.inventory.setStackInSlot(OUTPUT_SLOT,new ItemStack(stack.getItem(),this.inventory.getStackInSlot(OUTPUT_SLOT).getCount() + stack.getCount()));
    }
    private boolean hasRecipe() {
        boolean hasCraftingItem = this.inventory.getStackInSlot(INPUT_SLOT).getItem() == Items.CLAY_BALL;
//        ItemStack itemStack = new ItemStack(Items.CLAY_BALL);

        return hasCraftingItem;
    }
//
//    private boolean canInsertItemIntoOutputSlot(Item item) {
//        return this.inventory.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.inventory.getStackInSlot(OUTPUT_SLOT).is(item);
//    }
//
//    private boolean canInsertAmountIntoOutputSlot(int count) {
//         return this.inventory.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.inventory.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
//    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

}
