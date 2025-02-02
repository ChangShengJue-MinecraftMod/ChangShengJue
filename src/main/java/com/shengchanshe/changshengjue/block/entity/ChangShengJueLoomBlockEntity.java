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

public class ChangShengJueLoomBlockEntity extends BlockEntity implements GeoBlockEntity {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private ItemStackHandler inventory = new ItemStackHandler(3){
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
    private int maxProgress = 100;

    public ChangShengJueLoomBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.CHANG_SHENG_JUE_LOOM_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0-> ChangShengJueLoomBlockEntity.this.progress;
                    case 1-> ChangShengJueLoomBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex){
                    case 0-> ChangShengJueLoomBlockEntity.this.progress = pValue;
                    case 1-> ChangShengJueLoomBlockEntity.this.maxProgress = pValue;
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
        for (int i = 0; i <  this.inventory.getSlots(); i++) {
            ItemStack stackInSlot = this.inventory.getStackInSlot(i);
            if(stackInSlot.isEmpty()){
                this.inventory.setStackInSlot(i,itemStack.split(1));
                setChanged();
                return true;
            }
        }
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
        progress = pTag.getInt("LoomBlockProgress");
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyOptional.invalidate();
    }

    private CompoundTag writeItems(CompoundTag compoundTag){
        super.saveAdditional(compoundTag);
        compoundTag.put("Inventory",this.inventory.serializeNBT());
        compoundTag.putInt("LoomBlockProgress",progress);
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
        if (!this.inventory.getStackInSlot(0).isEmpty() && !this.inventory.getStackInSlot(1).isEmpty() && !this.inventory.getStackInSlot(2).isEmpty()){
            stack = new ItemStack(ChangShengJueItems.SILK.get(),1);
            for (int i = 0; i < this.inventory.getSlots(); i++) {
                this.inventory.extractItem(i,1,false);
            }
            Containers.dropItemStack(this.level, this.getBlockPos().getX(),  this.getBlockPos().getY(),  this.getBlockPos().getZ(), stack);
        }
    }
    private boolean hasRecipe() {
        boolean hasCraftingItem = this.inventory.getStackInSlot(0).getItem() == ChangShengJueItems.NATURAL_SILK.get();
        boolean hasCraftingItem1 = this.inventory.getStackInSlot(1).getItem() == ChangShengJueItems.NATURAL_SILK.get();
        boolean hasCraftingItem2 = this.inventory.getStackInSlot(2).getItem() == ChangShengJueItems.NATURAL_SILK.get();
        if (hasCraftingItem && hasCraftingItem1 && hasCraftingItem2){
            return true;
        }
        return false;
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }
    protected <E extends ChangShengJueLoomBlockEntity> PlayState deployAnimController(final AnimationState<E> state) {
        if (this.progress != 0){
            state.setAndContinue(RawAnimation.begin().thenPlay("idle2"));
        }else {
            state.setAndContinue(RawAnimation.begin().thenPlay("idle"));
        }
        return PlayState.CONTINUE;
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
