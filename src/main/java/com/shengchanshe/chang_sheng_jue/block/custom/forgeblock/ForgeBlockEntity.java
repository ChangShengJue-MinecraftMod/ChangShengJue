package com.shengchanshe.chang_sheng_jue.block.custom.forgeblock;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.block.custom.CraftingMaterialTransaction;
import com.shengchanshe.chang_sheng_jue.block.custom.PersistedCraftingJob;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.forgeblock.ForgeBlockMenu;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import com.shengchanshe.chang_sheng_jue.recipe.ForgeBlockRecipe;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
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
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class ForgeBlockEntity extends BlockEntity implements MenuProvider, GeoBlockEntity {
    private static final int INPUT_SLOT_COUNT = 9;
    private static final String ACTIVE_JOB = "active_job";
    public static final int SLOT_OUTPUT = 9;
    public static final DirectionProperty FACING = ForgeBlock.FACING;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final ItemStackHandler itemHandler = new ItemStackHandler(10) {
        @Override public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
            if (slot == SLOT_OUTPUT || (slot < INPUT_SLOT_COUNT && level != null && !level.isClientSide)) return stack;
            return super.insertItem(slot, stack, simulate);
        }
        @Override protected void onContentsChanged(int slot) {
            if (level != null && !level.isClientSide && !suppressHandlerCallbacks) {
                if (slot == SLOT_OUTPUT) ForgeBlockEntity.this.syncToClient();
                else ForgeBlockEntity.this.setChanged();
            }
        }
    };
    private LazyOptional<ItemStackHandler> itemHandlerLazy = LazyOptional.empty();
    private LazyOptional<IItemHandler> outputHandlerLazy = LazyOptional.empty();
    protected final ContainerData data;
    public int progress;
    public int maxProgress = 100;
    private ForgeBlockRecipe currentRecipe;
    private String currentRecipeGroup = "";
    private Player currentUser;
    private ResourceLocation pendingRecipeId;
    private PersistedCraftingJob activeJob;
    private boolean activeRecipeAvailable;
    private boolean legacyWaiting;
    private boolean missingRecipeLogged;
    private boolean legacyGhostLogged;
    private boolean suppressHandlerCallbacks;
    private int recipeRetryTicks;

    public ForgeBlockEntity(BlockPos pos, BlockState state) {
        super(ChangShengJueBlocksEntities.FORGE_BLOCK_ENTITY.get(), pos, state);
        data = new ContainerData() {
            @Override public int get(int index) { return index == 0 ? progress : index == 1 ? maxProgress : 0; }
            @Override public void set(int index, int value) { if (index == 0) progress = value; else if (index == 1) maxProgress = value; }
            @Override public int getCount() { return 2; }
        };
    }

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
    @Override public Component getDisplayName() { return Component.translatable("container." + ChangShengJue.MOD_ID + ".forge_block"); }
    @Nullable @Override public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        if (currentUser != null && currentUser != player) return null;
        currentUser = player;
        return new ForgeBlockMenu(id, inventory, this, data);
    }
    public void onClose(Player player) { if (player == currentUser) currentUser = null; }

    @Override protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("progress", progress);
        ResourceLocation selected = currentRecipe != null ? currentRecipe.getId() : pendingRecipeId;
        if (selected != null) tag.putString("current_recipe", selected.toString());
        if (activeJob != null) tag.put(ACTIVE_JOB, activeJob.save(progress));
    }
    @Override public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        int loadedProgress = tag.getInt("progress");
        progress = loadedProgress >= 0 && loadedProgress <= maxProgress ? loadedProgress : 0;
        pendingRecipeId = tag.contains("current_recipe") ? ResourceLocation.tryParse(tag.getString("current_recipe")) : null;
        currentRecipe = null;
        activeJob = null;
        if (tag.contains(ACTIVE_JOB)) {
            PersistedCraftingJob.Loaded loaded = PersistedCraftingJob.load(tag.getCompound(ACTIVE_JOB), maxProgress);
            if (loaded != null) { activeJob = loaded.job(); progress = loaded.progress(); }
        }
        if (level != null) resolveRecipes();
    }
    private void resolveRecipes() {
        if (level == null) return;
        ResourceLocation selected = activeJob != null ? activeJob.recipeId() : pendingRecipeId;
        currentRecipe = findRecipe(selected).orElse(null);
        activeRecipeAvailable = activeJob == null || findRecipe(activeJob.recipeId()).isPresent();
        if (activeJob == null && progress > 0 && currentRecipe != null) {
            activeJob = new PersistedCraftingJob(currentRecipe.getId(), currentRecipe.getResultItem(level.registryAccess()), 1, 1);
            activeRecipeAvailable = true;
        }
        legacyWaiting = progress > 0 && activeJob == null;
        if (!level.isClientSide && (legacyWaiting || !activeRecipeAvailable) && !missingRecipeLogged) {
            ChangShengJue.LOGGER.warn("Forge block at {} is waiting for missing recipe {}", worldPosition, selected);
            missingRecipeLogged = true;
        } else if (!legacyWaiting && activeRecipeAvailable) missingRecipeLogged = false;
    }
    private Optional<ForgeBlockRecipe> findRecipe(@Nullable ResourceLocation id) {
        if (id == null || level == null) return Optional.empty();
        Optional<? extends Recipe<?>> recipe = level.getRecipeManager().byKey(id);
        return recipe.isPresent() && recipe.get() instanceof ForgeBlockRecipe typed ? Optional.of(typed) : Optional.empty();
    }
    @Nullable @Override public ClientboundBlockEntityDataPacket getUpdatePacket() { return ClientboundBlockEntityDataPacket.create(this); }
    @Override public CompoundTag getUpdateTag() { CompoundTag tag = new CompoundTag(); saveAdditional(tag); return tag; }
    @Override public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet) { load(packet.getTag()); }
    @Override public void handleUpdateTag(CompoundTag tag) { super.handleUpdateTag(tag); load(tag); }
    public ItemStackHandler getItemHandler() { return itemHandler; }
    public boolean isCrafting() { return activeJob != null; }

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (level.isClientSide) return;
        retryMissingRecipe();
        if (activeJob == null || !activeRecipeAvailable) return;
        if (progress < maxProgress) { progress++; super.setChanged(); return; }
        if (!canInsert(activeJob.output())) return;
        craftItem(activeJob.output());
        activeJob = null;
        progress = 0;
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
        ForgeBlockRecipe recipe = chooseRecipe(player.getInventory());
        if (recipe == null) return;
        ItemStack result = recipe.getResultItem(level.registryAccess()).copy();
        if (!isValidOutput(result) || !canInsert(result)) return;
        var ingredients = recipe.getIngredients();
        int[] counts = CraftingMaterialTransaction.countsFromIngredients(ingredients);
        if (!CraftingMaterialTransaction.consume(player.getInventory(), ingredients, counts, 1)) return;
        currentRecipe = recipe;
        pendingRecipeId = recipe.getId();
        activeJob = new PersistedCraftingJob(recipe.getId(), result, 1, 1);
        activeRecipeAvailable = true;
        legacyWaiting = false;
        progress = 1;
        syncToClient();
    }
    @Nullable private ForgeBlockRecipe chooseRecipe(Inventory inventory) {
        var ingredients = currentRecipe.getIngredients();
        if (CraftingMaterialTransaction.canConsume(inventory, ingredients, CraftingMaterialTransaction.countsFromIngredients(ingredients), 1)) return currentRecipe;
        ItemStack wanted = currentRecipe.getResultItem(level.registryAccess());
        for (ForgeBlockRecipe recipe : level.getRecipeManager().getAllRecipesFor(ForgeBlockRecipe.Type.INSTANCE)) {
            var alternative = recipe.getIngredients();
            if (ItemStack.isSameItemSameTags(recipe.getResultItem(level.registryAccess()), wanted)
                    && CraftingMaterialTransaction.canConsume(inventory, alternative, CraftingMaterialTransaction.countsFromIngredients(alternative), 1)) return recipe;
        }
        return null;
    }
    public ItemStack[] getMaterialsFromRecipe(ForgeBlockRecipe recipe) { return recipe.getIngredients().stream().map(i -> i.getItems().length > 0 ? i.getItems()[0] : ItemStack.EMPTY).toArray(ItemStack[]::new); }
    public void setCurrentRecipe(ForgeBlockRecipe recipe) { setCurrentRecipe(recipe, recipe != null ? recipe.getGroup() : null); }
    public void setCurrentRecipe(ForgeBlockRecipe recipe, String group) {
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
                ChangShengJue.LOGGER.warn("Cleared legacy forge display items at {} without dropping them", worldPosition);
                legacyGhostLogged = true;
            }
        }
    }
    public void setRecipeGroup(String group) { if (activeJob == null) currentRecipeGroup = group == null ? "" : group; }
    public ForgeBlockRecipe getCurrentRecipe() { return currentRecipe; }
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
        registrar.add(new AnimationController<>(this, "work", 0, state -> {
            if (progress != 0) { state.setAndContinue(RawAnimation.begin().thenPlay("work")); return PlayState.CONTINUE; }
            return PlayState.STOP;
        }).setSoundKeyframeHandler(state -> {
            if (level != null && level.isClientSide) level.playLocalSound(worldPosition, ChangShengJueSound.FORGE_BLOCK_SOUND.get(), SoundSource.BLOCKS, 0.1F, 1.0F, false);
        }).setParticleKeyframeHandler(state -> { if (level != null && level.isClientSide) spawnForgeParticles(level); }));
    }
    public void spawnForgeParticles(Level level) {
        if (level == null) return;
        Direction facing = getBlockState().getValue(FACING);
        double x = worldPosition.getX() + 0.5;
        double y = worldPosition.getY() + 0.8;
        double z = worldPosition.getZ() + 0.5;
        switch (facing) {
            case NORTH -> { x += 0.2; z += 0.2; }
            case SOUTH -> { x -= 0.2; z -= 0.2; }
            case EAST -> { z += 0.2; x -= 0.2; }
            case WEST -> { z -= 0.2; x += 0.2; }
        }
        int count = 6 + level.random.nextInt(6);
        for (int i = 0; i < count; i++) {
            double xs = (level.random.nextDouble() - 0.5) * 0.2;
            double ys = level.random.nextDouble() * 0.06 + 0.03;
            double zs = (level.random.nextDouble() - 0.5) * 0.2;
            switch (facing) { case NORTH -> zs = -Math.abs(zs) * 1.2; case SOUTH -> zs = Math.abs(zs) * 1.2; case EAST -> xs = Math.abs(xs) * 1.2; case WEST -> xs = -Math.abs(xs) * 1.2; }
            level.addParticle(ChangShengJueParticles.FORGE_BLOCK_PARTCLE.get(), x + (level.random.nextDouble() - 0.5) * 0.1,
                    y + level.random.nextDouble() * 0.15, z + (level.random.nextDouble() - 0.5) * 0.1, xs, ys, zs);
        }
    }
    @Override public AnimatableInstanceCache getAnimatableInstanceCache() { return cache; }
}
