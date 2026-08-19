package com.shengchanshe.chang_sheng_jue.block.custom.workbench;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.block.custom.CraftingMaterialTransaction;
import com.shengchanshe.chang_sheng_jue.block.custom.PersistedCraftingJob;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.workbench.WoodworkingBenchMenu;
import com.shengchanshe.chang_sheng_jue.recipe.WoodworkingBenchRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RangedWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class WoodworkingBenchEntity extends BlockEntity implements MenuProvider, GeoBlockEntity {
    private static final int INPUT_SLOT_COUNT = 9;
    private static final String ACTIVE_JOB = "active_job";
    public static final int SLOT_OUTPUT = 9;
    public static final DirectionProperty FACING = WoodworkingBench.FACING;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final ItemStackHandler itemHandler = new ItemStackHandler(10) {
        @Override public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
            if (slot == SLOT_OUTPUT || (slot < INPUT_SLOT_COUNT && level != null && !level.isClientSide)) return stack;
            return super.insertItem(slot, stack, simulate);
        }
        @Override protected void onContentsChanged(int slot) {
            if (level != null && !level.isClientSide && !suppressHandlerCallbacks) {
                if (slot == SLOT_OUTPUT) WoodworkingBenchEntity.this.syncToClient();
                else WoodworkingBenchEntity.this.setChanged();
            }
        }
    };
    private LazyOptional<ItemStackHandler> itemHandlerLazy = LazyOptional.empty();
    private LazyOptional<IItemHandler> outputHandlerLazy = LazyOptional.empty();
    protected final ContainerData data;
    public int progress;
    public int maxProgress = 100;
    private WoodworkingBenchRecipe currentRecipe;
    private String currentRecipeGroup = "";
    private Player currentUser;
    private int craftTimes = 1;
    private ResourceLocation pendingRecipeId;
    private PersistedCraftingJob activeJob;
    private boolean activeRecipeAvailable;
    private boolean legacyWaiting;
    private boolean missingRecipeLogged;
    private boolean legacyGhostLogged;
    private boolean suppressHandlerCallbacks;
    private int recipeRetryTicks;

    public WoodworkingBenchEntity(BlockPos pos, BlockState state) {
        super(ChangShengJueBlocksEntities.WOOD_WORKING_BENCH_ENTITY.get(), pos, state);
        data = new ContainerData() {
            @Override public int get(int index) { return index == 0 ? progress : index == 1 ? maxProgress : index == 2 ? craftTimes : 0; }
            @Override public void set(int index, int value) { if (index == 0) progress = value; else if (index == 1) maxProgress = value; else if (index == 2 && activeJob == null) craftTimes = clamp(value); }
            @Override public int getCount() { return 3; }
        };
    }
    private static int clamp(int count) { return Math.max(1, Math.min(64, count)); }
    @Override public @Nullable <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) return (side == null ? itemHandlerLazy : outputHandlerLazy).cast();
        return super.getCapability(cap, side);
    }
    @Override public void onLoad() {
        super.onLoad();
        itemHandlerLazy = LazyOptional.of(() -> itemHandler);
        outputHandlerLazy = LazyOptional.of(() -> new RangedWrapper(itemHandler, SLOT_OUTPUT, SLOT_OUTPUT + 1));
        if (level != null && !level.isClientSide) clearLegacyGhostInputs();
        resolveRecipes();
    }
    @Override public void invalidateCaps() { super.invalidateCaps(); itemHandlerLazy.invalidate(); outputHandlerLazy.invalidate(); }
    public void drop() { SimpleContainer inventory = new SimpleContainer(1); inventory.setItem(0, itemHandler.getStackInSlot(SLOT_OUTPUT)); Containers.dropContents(level, worldPosition, inventory); }
    @Override public Component getDisplayName() { return Component.translatable("container." + ChangShengJue.MOD_ID + ".wood_working_bench"); }
    @Nullable @Override public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        if (currentUser != null && currentUser != player) return null;
        currentUser = player;
        return new WoodworkingBenchMenu(id, inventory, this, data);
    }
    public void onClose(Player player) { if (player == currentUser) currentUser = null; }
    @Override protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("progress", progress);
        tag.putInt("craft_times", craftTimes);
        ResourceLocation selected = currentRecipe != null ? currentRecipe.getId() : pendingRecipeId;
        if (selected != null) tag.putString("current_recipe", selected.toString());
        if (activeJob != null) tag.put(ACTIVE_JOB, activeJob.save(progress));
    }
    @Override public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        int loadedProgress = tag.getInt("progress");
        progress = loadedProgress >= 0 && loadedProgress <= maxProgress ? loadedProgress : 0;
        craftTimes = tag.contains("craft_times") ? clamp(tag.getInt("craft_times")) : 1;
        pendingRecipeId = tag.contains("current_recipe") ? ResourceLocation.tryParse(tag.getString("current_recipe")) : null;
        currentRecipe = null;
        activeJob = null;
        if (tag.contains(ACTIVE_JOB)) {
            PersistedCraftingJob.Loaded loaded = PersistedCraftingJob.load(tag.getCompound(ACTIVE_JOB), maxProgress);
            if (loaded != null) { activeJob = loaded.job(); progress = loaded.progress(); craftTimes = activeJob.remaining(); }
        }
        if (level != null) resolveRecipes();
    }
    private void resolveRecipes() {
        if (level == null) return;
        ResourceLocation selected = activeJob != null ? activeJob.recipeId() : pendingRecipeId;
        currentRecipe = findRecipe(selected).orElse(null);
        activeRecipeAvailable = activeJob == null || findRecipe(activeJob.recipeId()).isPresent();
        if (activeJob == null && progress > 0 && currentRecipe != null) {
            activeJob = new PersistedCraftingJob(currentRecipe.getId(), currentRecipe.getResultItem(level.registryAccess()), craftTimes, craftTimes);
            activeRecipeAvailable = true;
        }
        legacyWaiting = progress > 0 && activeJob == null;
        if (!level.isClientSide && (legacyWaiting || !activeRecipeAvailable) && !missingRecipeLogged) {
            ChangShengJue.LOGGER.warn("Woodworking bench at {} is waiting for missing recipe {}", worldPosition, selected);
            missingRecipeLogged = true;
        } else if (!legacyWaiting && activeRecipeAvailable) missingRecipeLogged = false;
    }
    private Optional<WoodworkingBenchRecipe> findRecipe(@Nullable ResourceLocation id) {
        if (id == null || level == null) return Optional.empty();
        Optional<? extends Recipe<?>> recipe = level.getRecipeManager().byKey(id);
        return recipe.isPresent() && recipe.get() instanceof WoodworkingBenchRecipe typed ? Optional.of(typed) : Optional.empty();
    }
    @Nullable @Override public Packet<ClientGamePacketListener> getUpdatePacket() { return ClientboundBlockEntityDataPacket.create(this); }
    @Override public CompoundTag getUpdateTag() { CompoundTag tag = new CompoundTag(); saveAdditional(tag); return tag; }
    @Override public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet) { load(packet.getTag()); }
    @Override public void handleUpdateTag(CompoundTag tag) { super.handleUpdateTag(tag); load(tag); }
    public ItemStackHandler getItemHandler() { return itemHandler; }
    public int getCraftTimes() { return craftTimes; }
    public boolean isCrafting() { return activeJob != null; }
    public void setCraftTimes(int count) { if (activeJob != null || progress > 0) return; craftTimes = clamp(count); syncToClient(); }
    public void tick(Level level, BlockPos pos, BlockState state) {
        if (level.isClientSide) return;
        retryMissingRecipe();
        if (activeJob == null || !activeRecipeAvailable) return;
        if (progress < maxProgress) { progress++; super.setChanged(); return; }
        ItemStack result = activeJob.output();
        if (!canInsert(result)) return;
        craftItem(result);
        if (activeJob.finishOne()) { activeJob = null; progress = 0; craftTimes = 1; }
        else { craftTimes = activeJob.remaining(); progress = 1; }
        syncToClient();
    }
    private boolean canInsert(ItemStack result) {
        if (!isValidOutput(result)) return false;
        ItemStack output = itemHandler.getStackInSlot(SLOT_OUTPUT);
        return output.isEmpty() || ItemStack.isSameItemSameTags(output, result) && output.getCount() + result.getCount() <= output.getMaxStackSize();
    }
    public void craftItem(ItemStack result) {
        ItemStack output = itemHandler.getStackInSlot(SLOT_OUTPUT);
        if (output.isEmpty()) itemHandler.setStackInSlot(SLOT_OUTPUT, result.copy()); else output.grow(result.getCount());
        super.setChanged();
    }
    public void craftCurrentRecipe(Player player) {
        if (level == null || level.isClientSide || activeJob != null || currentRecipe == null) return;
        int count = craftTimes;
        WoodworkingBenchRecipe recipe = chooseRecipe(player.getInventory(), count);
        if (recipe == null) return;
        ItemStack result = recipe.getResultItem(level.registryAccess()).copy();
        if (!isValidOutput(result) || !canFitWholeJob(result, count)) return;
        if (!CraftingMaterialTransaction.consume(player.getInventory(), recipe.getIngredients(), recipe.getCachedRequiredCounts(), count)) return;
        currentRecipe = recipe;
        pendingRecipeId = recipe.getId();
        activeJob = new PersistedCraftingJob(recipe.getId(), result, count, count);
        activeRecipeAvailable = true;
        legacyWaiting = false;
        progress = 1;
        syncToClient();
    }
    private boolean canFitWholeJob(ItemStack result, int count) {
        long added = (long) result.getCount() * count;
        ItemStack output = itemHandler.getStackInSlot(SLOT_OUTPUT);
        return added <= result.getMaxStackSize() && (output.isEmpty() || ItemStack.isSameItemSameTags(output, result) && output.getCount() + added <= output.getMaxStackSize());
    }
    @Nullable private WoodworkingBenchRecipe chooseRecipe(Inventory inventory, int count) {
        if (CraftingMaterialTransaction.canConsume(inventory, currentRecipe.getIngredients(), currentRecipe.getCachedRequiredCounts(), count)) return currentRecipe;
        ItemStack wanted = currentRecipe.getResultItem(level.registryAccess());
        for (WoodworkingBenchRecipe recipe : level.getRecipeManager().getAllRecipesFor(WoodworkingBenchRecipe.Type.INSTANCE)) {
            if (ItemStack.isSameItemSameTags(recipe.getResultItem(level.registryAccess()), wanted)
                    && CraftingMaterialTransaction.canConsume(inventory, recipe.getIngredients(), recipe.getCachedRequiredCounts(), count)) return recipe;
        }
        return null;
    }
    public ItemStack[] getMaterialsFromRecipe(WoodworkingBenchRecipe recipe) { return recipe.getIngredients().stream().map(i -> i.getItems().length > 0 ? i.getItems()[0] : ItemStack.EMPTY).toArray(ItemStack[]::new); }
    public void setCurrentRecipe(WoodworkingBenchRecipe recipe) { setCurrentRecipe(recipe, recipe != null ? recipe.getGroup() : null); }
    public void setCurrentRecipe(WoodworkingBenchRecipe recipe, String group) {
        if (activeJob != null || progress > 0) return;
        currentRecipe = recipe;
        pendingRecipeId = recipe == null ? null : recipe.getId();
        currentRecipeGroup = group == null ? "" : group;
        clearInputSlots();
        syncToClient();
    }
    private void clearInputSlots() { for (int i = 0; i < INPUT_SLOT_COUNT; i++) itemHandler.setStackInSlot(i, ItemStack.EMPTY); }
    private void clearLegacyGhostInputs() {
        boolean found = false;
        suppressHandlerCallbacks = true;
        try {
            for (int i = 0; i < INPUT_SLOT_COUNT; i++) {
                if (!itemHandler.getStackInSlot(i).isEmpty()) { found = true; itemHandler.setStackInSlot(i, ItemStack.EMPTY); }
            }
        } finally { suppressHandlerCallbacks = false; }
        if (found) {
            super.setChanged();
            if (!legacyGhostLogged) {
                ChangShengJue.LOGGER.warn("Cleared legacy woodworking display items at {} without dropping them", worldPosition);
                legacyGhostLogged = true;
            }
        }
    }
    public WoodworkingBenchRecipe getCurrentRecipe() { return currentRecipe; }
    public ItemStack getRecipeResultItem() { return currentRecipe == null || level == null ? ItemStack.EMPTY : currentRecipe.getResultItem(level.registryAccess()); }
    private static boolean isValidOutput(ItemStack output) { return !output.isEmpty() && output.getCount() <= output.getMaxStackSize(); }
    private void retryMissingRecipe() {
        if (!legacyWaiting && activeRecipeAvailable) return;
        if (recipeRetryTicks-- > 0) return;
        recipeRetryTicks = 100;
        resolveRecipes();
    }
    private void syncToClient() { super.setChanged(); if (level != null) level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_CLIENTS); }
    @Override public void setChanged() { super.setChanged(); }
    @Override public void registerControllers(AnimatableManager.ControllerRegistrar registrar) {
        registrar.add(new AnimationController<>(this, "idle", 0, state -> {
            if (progress != 0) { state.setAndContinue(DefaultAnimations.IDLE); return PlayState.CONTINUE; }
            return PlayState.STOP;
        }));
    }
    @Override public AnimatableInstanceCache getAnimatableInstanceCache() { return cache; }
}
