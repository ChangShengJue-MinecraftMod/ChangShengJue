package com.shengchanshe.chang_sheng_jue.block.custom.castingmolds;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
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

            // 处理输出槽的物品
            ItemStack outputStack = inventory.getStackInSlot(OUTPUT_SLOT);

            // 如果是银锭或金锭，扣除税收（1个元宝）
            if (outputStack.is(ChangShengJueItems.SILVER_BULLIONS.get()) ||
                outputStack.is(ChangShengJueItems.GOLD_BULLIONS.get())) {
                int taxAmount = 1;
                int afterTax = Math.max(0, outputStack.getCount() - taxAmount);

                if (afterTax > 0) {
                    simpleContainer.setItem(OUTPUT_SLOT, new ItemStack(outputStack.getItem(), afterTax));
                } else {
                    simpleContainer.setItem(OUTPUT_SLOT, ItemStack.EMPTY);
                }

                // 生成税收粒子效果
                if (this.level instanceof ServerLevel serverLevel && taxAmount > 0) {
                    spawnTaxParticles(serverLevel, outputStack.is(ChangShengJueItems.GOLD_BULLIONS.get()));
                }
            } else {
                // 其他物品不扣税，直接放入
                simpleContainer.setItem(OUTPUT_SLOT, outputStack.copy());
            }

            // 输入槽的物品（应该为空）
            simpleContainer.setItem(INPUT_SLOT, inventory.getStackInSlot(INPUT_SLOT));

            // 清空原始inventory，防止重复取出
            this.inventory.setStackInSlot(INPUT_SLOT, ItemStack.EMPTY);
            this.inventory.setStackInSlot(OUTPUT_SLOT, ItemStack.EMPTY);

            this.open = false;
            this.isEmpty = true;
            this.setChanged();
            if (this.level != null) {
                Containers.dropContents(this.level, this.worldPosition, simpleContainer);
            }
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
        if (!this.inventory.getStackInSlot(0).isEmpty()){
            ItemStack outputStack;
            // 确定产出的物品类型（元宝不考虑坏币率）
            if (this.inventory.getStackInSlot(INPUT_SLOT).is(ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get())){
                outputStack = new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 3);
            } else {
                outputStack = new ItemStack(ChangShengJueItems.GOLD_BULLIONS.get(), 3);
            }

            // 移除输入槽的材料
            this.inventory.extractItem(INPUT_SLOT, 1, false);

            // 添加产出的元宝到输出槽（不扣税）
            this.inventory.setStackInSlot(OUTPUT_SLOT,
                new ItemStack(outputStack.getItem(),
                    this.inventory.getStackInSlot(OUTPUT_SLOT).getCount() + outputStack.getCount()));

            this.open = true;
        }
    }

    /**
     * 生成税收粒子效果
     * @param level 世界
     * @param isGold 是否是金元宝（true=金元宝, false=银元宝）
     */
    private void spawnTaxParticles(ServerLevel level, boolean isGold) {
        double x = this.worldPosition.getX() + 0.5;
        double y = this.worldPosition.getY() + 1.5;
        double z = this.worldPosition.getZ() + 0.5;

        // 铸币税粒子显示一个在方块正上方
        level.sendParticles(
            isGold ? ChangShengJueParticles.GOLD_BULLIONS_MINTING_PARTCLE.get()
                   : ChangShengJueParticles.SILVER_BULLIONS_MINTING_PARTCLE.get(), x, y, z,
            1, 0.0, 0.0, 0.0, 0.0);

        double bullionX = this.worldPosition.getX() + 0.25 + level.random.nextDouble() * 0.5;
        double bullionY = this.worldPosition.getY() + 0.25 + level.random.nextDouble() * 0.5;
        double bullionZ = this.worldPosition.getZ() + 0.25 + level.random.nextDouble() * 0.5;

        level.sendParticles(
            isGold ? ChangShengJueParticles.GOLD_BULLIONS_PARTCLE.get() : ChangShengJueParticles.SILVER_BULLIONS_PARTCLE.get(),
            bullionX, bullionY, bullionZ, 1, 0.0, 0.0, 0.0, 0.0);
            
        level.playSound(null, this.worldPosition, ChangShengJueSound.TAXATION_SOUND.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
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
            }else if (this.inventory.getStackInSlot(0).isEmpty() && !this.inventory.getStackInSlot(1).isEmpty()){
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
