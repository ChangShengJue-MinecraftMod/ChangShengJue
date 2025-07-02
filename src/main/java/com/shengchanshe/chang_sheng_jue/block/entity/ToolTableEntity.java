package com.shengchanshe.chang_sheng_jue.block.entity;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
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
import net.minecraft.world.item.Items;
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

public class ToolTableEntity extends BlockEntity {
    private ItemStackHandler inventory = new ItemStackHandler(1){
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

    public ToolTableEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.TOOL_TABLE_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0-> ToolTableEntity.this.progress;
                    case 1-> ToolTableEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex){
                    case 0-> ToolTableEntity.this.progress = pValue;
                    case 1-> ToolTableEntity.this.maxProgress = pValue;
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

        ItemStack stackInSlot = this.inventory.getStackInSlot(0);
        if(stackInSlot.isEmpty()){
            this.inventory.setStackInSlot(0,itemStack.split(1));
            setChanged();
            return true;
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
        this.inventory.deserializeNBT(pTag.getCompound("ToolTableInventory"));
        progress = pTag.getInt("ToolTableProgress");
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyOptional.invalidate();
    }

    private CompoundTag writeItems(CompoundTag compoundTag){
        super.saveAdditional(compoundTag);
        compoundTag.put("ToolTableInventory",this.inventory.serializeNBT());
        compoundTag.putInt("ToolTableProgress",progress);
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

    public Vec2 getItemOffset(int i) {
        float x = 0.0f;
        float y = 0.0f;
        Vec2 offset = new Vec2(x,y);
        return offset;
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
        ItemStack stack = this.inventory.getStackInSlot(INPUT_SLOT);
        if (stack.isDamageableItem()){
            int maxDamage = stack.getMaxDamage();
            int damageValue = stack.getDamageValue();
            int i = maxDamage - damageValue;
            stack.setDamageValue(Math.max(0,damageValue - i));
            this.inventory.extractItem(0,1,false);
        }
        BlockPos pos = this.getBlockPos();
        Containers.dropItemStack(this.level, this.getBlockPos().getX(),  this.getBlockPos().getY(),  this.getBlockPos().getZ(), stack);
        this.getLevel().playSeededSound(null,pos.getX(),pos.getY(),pos.getZ(),SoundEvents.VILLAGER_WORK_TOOLSMITH, SoundSource.BLOCKS,1.0f,1.0f,0);
    }

    private boolean hasRecipe() {
        boolean hasCraftingItem = this.inventory.getStackInSlot(INPUT_SLOT).getItem() == Items.BOW;
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
