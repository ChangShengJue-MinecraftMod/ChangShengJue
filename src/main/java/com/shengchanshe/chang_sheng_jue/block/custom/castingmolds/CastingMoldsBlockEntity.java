package com.shengchanshe.chang_sheng_jue.block.custom.castingmolds;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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

public class CastingMoldsBlockEntity extends BlockEntity implements GeoBlockEntity {
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

    public CastingMoldsBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.CASTING_MOLDS_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0-> CastingMoldsBlockEntity.this.progress;
                    case 1-> CastingMoldsBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex){
                    case 0-> CastingMoldsBlockEntity.this.progress = pValue;
                    case 1-> CastingMoldsBlockEntity.this.maxProgress = pValue;
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

            // 如果是铜钱，扣除税收（5个铜币）
            if (outputStack.is(ChangShengJueItems.TONG_QIAN.get())) {
                int taxAmount = 5;
                int afterTax = Math.max(0, outputStack.getCount() - taxAmount);

                if (afterTax > 0) {
                    simpleContainer.setItem(OUTPUT_SLOT, new ItemStack(outputStack.getItem(), afterTax));
                } else {
                    simpleContainer.setItem(OUTPUT_SLOT, ItemStack.EMPTY);
                }

                // 生成税收粒子效果
                if (this.level instanceof ServerLevel serverLevel && taxAmount > 0) {
                    spawnTaxParticles(serverLevel);
                }
            } else {
                // 其他物品（如铜锭）不扣税，直接放入
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
            Containers.dropContents(this.level, this.worldPosition, simpleContainer);
        }
    }
    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.inventory.deserializeNBT(pTag.getCompound("CastingMoldsInventory"));
        progress = pTag.getInt("CastingMoldsProgress");
        open = pTag.getBoolean("CastingMoldsOpen");
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyOptional.invalidate();
    }

    private CompoundTag writeItems(CompoundTag compoundTag){
        super.saveAdditional(compoundTag);
        compoundTag.put("CastingMoldsInventory",this.inventory.serializeNBT());
        compoundTag.putInt("CastingMoldsProgress",progress);
        compoundTag.putBoolean("CastingMoldsOpen", open);
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
            // 总共铸币24枚，每8个锭产出24枚，即每个锭对应3枚铜钱
            int totalCoins = 24;
            int coinsPerIngot = 3; // 24枚 / 8个锭 = 3枚/锭

            // 计算坏币率 (0% - 30%)
            double defectRate = 0;
            if (this.level != null) {
                defectRate = this.level.random.nextDouble() * 0.3;
            }

            // 计算损坏的铜钱数量（必须是3的倍数，这样才能刚好归还整数个锭）
            int defectCoins = (int)(totalCoins * defectRate);
            defectCoins = (defectCoins / coinsPerIngot) * coinsPerIngot; // 向下取整到3的倍数

            // 计算实际产出的铜钱数量（不扣税）
            int actualCoins = totalCoins - defectCoins;

            // 计算需要归还的锭数量
            int returnedIngots = defectCoins / coinsPerIngot;

            // 移除输入槽的材料
            this.inventory.extractItem(INPUT_SLOT, 1, false);

            // 添加产出的铜钱到输出槽
            if (actualCoins > 0) {
                ItemStack coinStack = new ItemStack(ChangShengJueItems.TONG_QIAN.get(), actualCoins);
                this.inventory.setStackInSlot(OUTPUT_SLOT,
                    new ItemStack(coinStack.getItem(),
                        this.inventory.getStackInSlot(OUTPUT_SLOT).getCount() + coinStack.getCount()));
            }

            // 归还损坏部分对应的锭到输出槽（如果有空间）
            if (returnedIngots > 0 && this.inventory.getStackInSlot(OUTPUT_SLOT).getCount() + returnedIngots <= 64) {
                ItemStack ingotStack = new ItemStack(Items.COPPER_INGOT, returnedIngots);
                // 如果输出槽为空或者已经是锭，则添加
                if (this.inventory.getStackInSlot(OUTPUT_SLOT).isEmpty()) {
                    this.inventory.setStackInSlot(OUTPUT_SLOT, ingotStack);
                } else if (this.inventory.getStackInSlot(OUTPUT_SLOT).is(Items.COPPER_INGOT)) {
                    this.inventory.setStackInSlot(OUTPUT_SLOT,
                        new ItemStack(ingotStack.getItem(),
                            this.inventory.getStackInSlot(OUTPUT_SLOT).getCount() + returnedIngots));
                } else {
                    // 如果输出槽已经有铜钱，则将锭掉落到世界中
                    Containers.dropItemStack(this.level, this.worldPosition.getX(),
                        this.worldPosition.getY(), this.worldPosition.getZ(), ingotStack);
                }
            }

            this.open = true;
        }
    }

    /**
     * 生成税收粒子效果
     */
    private void spawnTaxParticles(ServerLevel level) {
        double x = this.worldPosition.getX() + 0.5;
        double y = this.worldPosition.getY() + 2.0;
        double z = this.worldPosition.getZ() + 0.5;

        // 铸币税粒子显示一个在方块正上方
        level.sendParticles(ChangShengJueParticles.MINTING_PARTCLE.get(),
            x, y, z,
            1, 0.0, 0.0, 0.0, 0.0);

        // 铜钱粒子在方块范围内随机生成一个
        double coinX = this.worldPosition.getX() + level.random.nextDouble();
        double coinY = this.worldPosition.getY() + level.random.nextDouble();
        double coinZ = this.worldPosition.getZ() + level.random.nextDouble();

        level.sendParticles(ChangShengJueParticles.TONG_QIAN_PARTCLE.get(),
            coinX, coinY, coinZ,
            1, 0.0, 0.0, 0.0, 0.0);
    }

    private boolean hasRecipe() {
        boolean hasCraftingItem = this.inventory.getStackInSlot(INPUT_SLOT).getItem() == ChangShengJueItems.CRUCIBLE_LIQUID_COPPER.get();
        ItemStack itemStack = new ItemStack(ChangShengJueItems.TONG_QIAN.get());

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

    protected <E extends CastingMoldsBlockEntity> PlayState deployAnimController(final AnimationState<E> state) {
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
