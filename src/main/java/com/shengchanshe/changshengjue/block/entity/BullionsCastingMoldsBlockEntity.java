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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class BullionsCastingMoldsBlockEntity extends BlockEntity implements GeoBlockEntity {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
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
    private int maxProgress = 300;
    private boolean open = false;
    private boolean isEmpty = false;
    private final int INPUT_SLOT = 0;
    private final int OUTPUT_SLOT = 1;

    public BullionsCastingMoldsBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.BULLIONS_CASTING_MOLDS_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0-> BullionsCastingMoldsBlockEntity.this.progress;
                    case 1-> BullionsCastingMoldsBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }
            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex){
                    case 0-> BullionsCastingMoldsBlockEntity.this.progress = pValue;
                    case 1-> BullionsCastingMoldsBlockEntity.this.maxProgress = pValue;
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
//        for (int i = 0; i <  this.inventory.getSlots(); i++) {
            ItemStack stackInSlot = this.inventory.getStackInSlot(0);
            if(stackInSlot.isEmpty()){
                this.inventory.setStackInSlot(0,itemStack.split(1));
                setChanged();
                return true;
            }
//        }
        return false;
    }
    public void drops(){
        if (!this.inventory.getStackInSlot(1).isEmpty()){
            SimpleContainer simpleContainer = new SimpleContainer(inventory.getSlots());
            for (int i = 0; i < this.inventory.getSlots(); i++) {
                simpleContainer.setItem(i,inventory.getStackInSlot(i));
            }
            this.open = false;
            this.isEmpty = true;
            this.setChanged();
            Containers.dropContents(this.level,this.worldPosition,simpleContainer);
        }
    }
    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.inventory.deserializeNBT(pTag.getCompound("LngotMoldsInventory"));
        progress = pTag.getInt("LngotMoldsProgress");
        open = pTag.getBoolean("LngotMoldsOpen");
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyOptional.invalidate();
    }

    private CompoundTag writeItems(CompoundTag compoundTag){
        super.saveAdditional(compoundTag);
        compoundTag.put("LngotMoldsInventory",this.inventory.serializeNBT());
        compoundTag.putInt("LngotMoldsProgress",progress);
        compoundTag.putBoolean("LngotMoldsOpen", open);
        return compoundTag;
    }
    @Override
    protected void saveAdditional(CompoundTag pTag) {
        this.writeItems(pTag);
    }

    public ItemStackHandler getInventory() {
        return this.inventory;
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.writeItems(new CompoundTag());
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
    public void tick() {
        if (this.hasRecipe()){
            this.increaseCraftingProgress();
            this.setChanged();
            if (this.hasProgressFinished()){
                this.craftItem();
                this.resrtProgress();
            }
        }else {
            this.resrtProgress();
        }
    }

    private void resrtProgress() {
        progress = 0;
    }

    private void craftItem() {
        ItemStack stack;
        if (!this.inventory.getStackInSlot(0).isEmpty()){
            if (this.inventory.getStackInSlot(INPUT_SLOT).is(ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get())){
                stack = new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(),3);
            }else {
                stack = new ItemStack(ChangShengJueItems.GOLD_BULLIONS.get(),3);
            }
            for (int i = 0; i < this.inventory.getSlots(); i++) {
                this.inventory.extractItem(i,1,false);
            }
            this.inventory.setStackInSlot(INPUT_SLOT,new ItemStack(ChangShengJueItems.CRUCIBLE.get(),1));
            this.open = true;
//            Containers.dropItemStack(this.level, this.getBlockPos().getX(),  this.getBlockPos().getY(),  this.getBlockPos().getZ(), stack);
            this.inventory.setStackInSlot(OUTPUT_SLOT,new ItemStack(stack.getItem(),this.inventory.getStackInSlot(OUTPUT_SLOT).getCount() + stack.getCount()));
        }
    }

    private boolean hasRecipe() {
        boolean hasCraftingItem = this.inventory.getStackInSlot(INPUT_SLOT).getItem() == ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get() || this.inventory.getStackInSlot(INPUT_SLOT).getItem() == ChangShengJueItems.CRUCIBLE_LIQUID_GOLD.get();
        ItemStack itemStack = new ItemStack(inventory.getStackInSlot(INPUT_SLOT).getItem() == ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get() ? ChangShengJueItems.SILVER_BULLIONS.get() : ChangShengJueItems.GOLD_BULLIONS.get());

        return hasCraftingItem && canInsertItemIntoOutputSlot(itemStack.getItem()) && canInsertAmountIntoOutputSlot(itemStack.getCount());
    }
    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.inventory.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.inventory.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
         return this.inventory.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.inventory.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }
    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    protected <E extends BullionsCastingMoldsBlockEntity> PlayState deployAnimController(final AnimationState<E> state) {
        if (!this.open && !this.isEmpty){
            return PlayState.STOP;
        }else {
            if (this.inventory.getStackInSlot(0).isEmpty() && this.inventory.getStackInSlot(1).isEmpty()){
                state.setAndContinue(RawAnimation.begin().thenPlay("idle2"));
            }else if (!this.inventory.getStackInSlot(0).isEmpty() && !this.inventory.getStackInSlot(1).isEmpty()){
                state.setAndContinue(RawAnimation.begin().thenPlay("idle1"));
            }
            return PlayState.CONTINUE;
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, this::deployAnimController));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
