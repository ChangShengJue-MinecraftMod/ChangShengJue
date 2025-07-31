package com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.block.custom.loom.ChangShengJueLoomBlockEntity;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.tailoringcase.TailoringCaseMenu;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.ClientUtils;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Arrays;

public class TailoringCaseEntity extends BlockEntity implements MenuProvider , GeoBlockEntity {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public static final DirectionProperty FACING = TailoringCase.FACING;
    // 物品槽位处理器（9个输入，1个输出）
    private final ItemStackHandler itemHandler = new ItemStackHandler(10);
    public static final int SLOT_OUTPUT = 9;
    private LazyOptional<ItemStackHandler> itemHandlerLazy = LazyOptional.empty();
    protected final ContainerData data;
    public int progress = 0;
    public int maxProgress = 100;

    // 当前选中的配方
    private TailoringCaseMenu.TailoringRecipe currentRecipe;

    @Override
    public @Nullable <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return itemHandlerLazy.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        itemHandlerLazy = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        itemHandlerLazy.invalidate();
    }

    public TailoringCaseEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.TAILORING_CASE_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int getCount() {
                return 2; // 只需要进度和最大进度
            }

            @Override
            public int get(int i) {
                return switch (i){
                    case 0 -> TailoringCaseEntity.this.progress;
                    case 1 -> TailoringCaseEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int i1) {
                switch (i){
                    case 0 -> TailoringCaseEntity.this.progress = i1;
                    case 1 -> TailoringCaseEntity.this.maxProgress = i1;
                }
            }
        };
    }


    public void drop() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, worldPosition, inventory);
    }


    @Override
    public Component getDisplayName() {
        return Component.translatable("container." + ChangShengJue.MOD_ID + ".tailoring_case");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new TailoringCaseMenu(containerId, inventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("progress", progress);

        // 保存当前配方信息
        if (currentRecipe != null) {
            CompoundTag recipeTag = new CompoundTag();
            currentRecipe.getResult().save(recipeTag);
            tag.put("current_recipe", recipeTag);
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        progress = tag.getInt("progress");

        // 加载当前配方信息
        if (tag.contains("current_recipe")) {
            ItemStack result = ItemStack.of(tag.getCompound("current_recipe"));
            // 从结果查找配方
            currentRecipe = TailoringCaseMenu.findRecipe(result).orElse(null);
        }
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag);
        return tag;
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        load(pkt.getTag());
    }

    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (pLevel.isClientSide()) return; // 客户端不处理逻辑

        // 只有在制作中时才增加进度
        if (progress > 0 && progress < maxProgress) {
            progress++;
            this.setChanged();
        } else if (progress >= maxProgress) {
            // 进度完成，生成物品
            if (currentRecipe != null) {
                craftItem(currentRecipe.getResult());
            }
            progress = 0;
            this.setChanged();
        }
    }

    public void craftItem(ItemStack result) {
        ItemStack output = itemHandler.getStackInSlot(SLOT_OUTPUT);
        if (output.isEmpty()) {
            itemHandler.setStackInSlot(SLOT_OUTPUT, result.copy());
        } else {
            output.grow(result.getCount());
        }
        setChanged(); // 标记数据变更
        if (level != null) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3); // 同步到客户端
        }
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        load(tag); // 确保客户端同步物品数据
    }


    public void craftCurrentRecipe(Player player) {
        if (currentRecipe == null) return;

        // 检查输出槽是否有物品
        if (!itemHandler.getStackInSlot(SLOT_OUTPUT).isEmpty()) {
            return; // 输出槽有物品，禁止合成
        }

        // 检查玩家是否有足够材料
        if (hasEnoughMaterials(player.getInventory(), currentRecipe)) {
            // 消耗材料
            consumeMaterials(player.getInventory(), currentRecipe);
            // 开始制作进度
            this.progress = 1;
            this.setChanged();
        }
    }

    private boolean hasEnoughMaterials(Inventory playerInventory, TailoringCaseMenu.TailoringRecipe recipe) {
        ItemStack[] requiredMaterials = recipe.getMaterials();
        for (ItemStack required : requiredMaterials) {
            if (required.isEmpty()) continue;

            int needed = required.getCount();
            int found = 0;

            for (int i = 0; i < playerInventory.getContainerSize(); i++) {
                ItemStack stack = playerInventory.getItem(i);
                if (ItemStack.isSameItemSameTags(stack, required)) {
                    found += stack.getCount();
                    if (found >= needed) break;
                }
            }

            if (found < needed) return false;
        }
        return true;
    }

    private void consumeMaterials(Inventory playerInventory, TailoringCaseMenu.TailoringRecipe recipe) {
        ItemStack[] requiredMaterials = recipe.getMaterials();
        for (ItemStack required : requiredMaterials) {
            if (required.isEmpty()) continue;

            int needed = required.getCount();
            for (int i = 0; i < playerInventory.getContainerSize(); i++) {
                ItemStack stack = playerInventory.getItem(i);
                if (ItemStack.isSameItemSameTags(stack, required)) {
                    int take = Math.min(needed, stack.getCount());
                    stack.shrink(take);
                    needed -= take;
                    if (needed <= 0) break;
                }
            }
        }
    }

    public void setCurrentRecipe(TailoringCaseMenu.TailoringRecipe recipe) {
        this.currentRecipe = recipe;
        // 立即更新输入槽位
        if (recipe != null) {
            for (int i = 0; i < recipe.getMaterials().length && i < 9; i++) {
                itemHandler.setStackInSlot(i, recipe.getMaterials()[i].copy());
            }
        } else {
            // 清空输入槽
            for (int i = 0; i < 9; i++) {
                itemHandler.setStackInSlot(i, ItemStack.EMPTY);
            }
        }
        setChanged();
        if (level != null) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    public TailoringCaseMenu.TailoringRecipe getCurrentRecipe() {
        return currentRecipe;
    }


    //新增配方
    public void addRecipeWithMaterials(ItemStack result, ItemStack... materials) {
        // 1. 将材料放入输入槽位
        for (int i = 0; i < materials.length && i < 9; i++) {
            itemHandler.setStackInSlot(i, materials[i].copy());
        }

        // 2. 将成果放入输出槽位
        itemHandler.setStackInSlot(SLOT_OUTPUT, result.copy());

        // 3. 创建新配方并添加到配方列表
        TailoringCaseMenu.TailoringRecipe newRecipe = new TailoringCaseMenu.TailoringRecipe(
                result.copy(),
                Arrays.stream(materials).map(ItemStack::copy).toArray(ItemStack[]::new)
        );

        // 避免重复添加相同配方
        if (!TailoringCaseMenu.RECIPES.contains(newRecipe)) {
            TailoringCaseMenu.RECIPES.add(newRecipe);
        }

        // 4. 设置当前配方
        this.currentRecipe = newRecipe;

        // 5. 保存更改并同步到客户端
        setChanged();
        if (level != null) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    @Override
    public void setChanged() {
        super.setChanged();
        if (this.level != null){
            this.level.sendBlockUpdated(this.getBlockPos(),this.getBlockState(),this.getBlockState(), Block.UPDATE_CLIENTS);
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(((new AnimationController<>(this, "work", 0, (state) ->{
            if (this.progress != 0){
                state.setAndContinue(RawAnimation.begin().thenPlay("work"));
                return PlayState.CONTINUE;
            } else {
                return PlayState.STOP;
            }
        }).setSoundKeyframeHandler((state) -> {
            Player player = ClientUtils.getClientPlayer();
            Level level1 = ClientUtils.getLevel();
                level1.playSound(player,this.getBlockPos(), ChangShengJueSound.TAILORING_CASE_SOUND.get(), SoundSource.BLOCKS, 0.1F, 1.0F);
            }))));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}