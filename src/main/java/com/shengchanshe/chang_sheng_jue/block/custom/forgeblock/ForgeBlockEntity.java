package com.shengchanshe.chang_sheng_jue.block.custom.forgeblock;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.forgeblock.ForgeBlockMenu;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import com.shengchanshe.chang_sheng_jue.recipe.CSJRecipeTypes;
import com.shengchanshe.chang_sheng_jue.recipe.ForgeBlockRecipe;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.ClientUtils;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Arrays;
import java.util.Collection;

public class ForgeBlockEntity extends BlockEntity implements MenuProvider , GeoBlockEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public static final DirectionProperty FACING = ForgeBlock.FACING;
    // 物品槽位处理器（9个输入，1个输出）
    private final ItemStackHandler itemHandler = new ItemStackHandler(10);
    public static final int SLOT_OUTPUT = 9;
    private LazyOptional<ItemStackHandler> itemHandlerLazy = LazyOptional.empty();
    protected final ContainerData data;
    public int progress = 0;
    public int maxProgress = 100;
    // 当前选中的配方和配方组
    private ForgeBlockRecipe currentRecipe;
    private String currentRecipeGroup = ""; // 当前配方组

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

    public ForgeBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.FORGE_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int getCount() {
                return 2; // 只需要进度和最大进度
            }

            @Override
            public int get(int i) {
                return switch (i){
                    case 0 -> progress;
                    case 1 -> maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int i1) {
                switch (i){
                    case 0 -> progress = i1;
                    case 1 -> maxProgress = i1;
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
        return Component.translatable("container." + ChangShengJue.MOD_ID + ".forge_block");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new ForgeBlockMenu(containerId, inventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("progress", progress);

        // 保存当前配方信息
        if (currentRecipe != null) {
            tag.putString("current_recipe", currentRecipe.getId().toString());
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        progress = tag.getInt("progress");

        // 加载当前配方信息
        if (tag.contains("current_recipe")) {
            ResourceLocation recipeId = new ResourceLocation(tag.getString("current_recipe"));
            // 注意：这里我们只保存配方ID，在实际使用时需要通过配方管理器获取完整配方
            // 在getOrCreateLevel()方法中处理配方的实际获取
            if (level != null) {
                java.util.Optional<? extends net.minecraft.world.item.crafting.Recipe<?>> recipe = level.getRecipeManager().byKey(recipeId);
                if (recipe.isPresent() && recipe.get() instanceof ForgeBlockRecipe) {
                    currentRecipe = (ForgeBlockRecipe) recipe.get();
                } else {
                    currentRecipe = null;
                }
            } else {
                currentRecipe = null;
            }
        } else {
            currentRecipe = null;
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
                craftItem(currentRecipe.getResultItem(pLevel.registryAccess()));
            }
            progress = 0;
            this.setChanged();
        }
    }

    public void craftItem(ItemStack result) {
        ItemStack output = itemHandler.getStackInSlot(SLOT_OUTPUT);
        ItemStack stack = new ItemStack(result.getItem());
        if (output.isEmpty()) {
            itemHandler.setStackInSlot(SLOT_OUTPUT, stack);
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
        ForgeBlockRecipe recipeToUse = null;
        
        // 首先检查当前配方是否有足够材料
        if (currentRecipe != null && hasEnoughMaterials(player.getInventory(), currentRecipe)) {
            recipeToUse = currentRecipe;
        } else {
            // 如果当前配方材料不足，只查找同一结果物品的其他配方
            if (currentRecipe != null) {
                ItemStack resultItem = currentRecipe.getResultItem(level.registryAccess());
                // 获取所有可用的配方
                Collection<ForgeBlockRecipe> allRecipes = level.getRecipeManager().getAllRecipesFor(ForgeBlockRecipe.Type.INSTANCE);
                
                // 查找第一个材料足够的配方，且结果物品相同
                for (ForgeBlockRecipe recipe : allRecipes) {
                    if (ItemStack.isSameItemSameTags(recipe.getResultItem(level.registryAccess()), resultItem)) {
                        if (hasEnoughMaterials(player.getInventory(), recipe)) {
                            // 找到匹配的配方
                            recipeToUse = recipe;
                            break;
                        }
                    }
                }
            }
        }

        if (recipeToUse == null) return;

        // 检查输出槽是否有物品
        if (!itemHandler.getStackInSlot(SLOT_OUTPUT).isEmpty()) {
            return; // 输出槽有物品，禁止合成
        }

        // 设置要使用的配方为当前配方（如果不同的话）
        if (recipeToUse != currentRecipe) {
            setCurrentRecipe(recipeToUse);
        }

        // 检查玩家是否有足够材料（再次检查以确保一致性）
        if (hasEnoughMaterials(player.getInventory(), recipeToUse)) {
            // 消耗材料
            consumeMaterials(player.getInventory(), recipeToUse);
            // 开始制作进度
            this.progress = 1;
            this.setChanged();
        }
    }

    private boolean hasEnoughMaterials(Inventory playerInventory, ForgeBlockRecipe recipe) {
        ItemStack[] requiredMaterials = getMaterialsFromRecipe(recipe);
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

    private void consumeMaterials(Inventory playerInventory, ForgeBlockRecipe recipe) {
        ItemStack[] requiredMaterials = getMaterialsFromRecipe(recipe);
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
    
    // 从配方中获取材料示例物品（用于UI显示）
    public ItemStack[] getMaterialsFromRecipe(ForgeBlockRecipe recipe) {
        return recipe.getIngredients().stream()
                .map(ingredient -> ingredient.getItems().length > 0 ? ingredient.getItems()[0] : ItemStack.EMPTY)
                .toArray(ItemStack[]::new);
    }

    public void setCurrentRecipe(ForgeBlockRecipe recipe) {
        setCurrentRecipe(recipe, recipe != null ? recipe.getGroup() : null);
    }

    public void setCurrentRecipe(ForgeBlockRecipe recipe, String group) {
        this.currentRecipe = recipe;
        this.currentRecipeGroup = group != null ? group : "";
        
        // 清空输入槽
        for (int i = 0; i < 9; i++) {
            itemHandler.setStackInSlot(i, ItemStack.EMPTY);
        }

        // 设置配方材料到输入槽
        if (recipe != null) {
            NonNullList<Ingredient> ingredients = recipe.getIngredients();
            for (int i = 0; i < ingredients.size() && i < 9; i++) {
                ItemStack[] matchingStacks = ingredients.get(i).getItems();
                if (matchingStacks.length > 0) {
                    itemHandler.setStackInSlot(i, matchingStacks[0].copy());
                }
            }
        }

        setChanged();
        if (level != null) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    public void setRecipeGroup(String group) {
        this.currentRecipeGroup = group != null ? group : "";
        // 如果需要根据组更新UI，可以在这里添加相关逻辑
        setChanged();
    }

    public ForgeBlockRecipe getCurrentRecipe() {
        return currentRecipe;
    }
    
    // 获取当前配方的结果物品
    public ItemStack getRecipeResultItem() {
        if (currentRecipe != null) {
            return currentRecipe.getResultItem(level.registryAccess());
        }
        return ItemStack.EMPTY;
    }

    //新增配方
    //新增配方
    public void addRecipeWithMaterials(ItemStack result, ItemStack... materials) {
        // 这个方法在新的配方系统中不再需要
    }

    @Override
    public void setChanged() {
        super.setChanged();
        if (this.level != null){
            this.level.sendBlockUpdated(this.getBlockPos(),this.getBlockState(),this.getBlockState(), Block.UPDATE_CLIENTS);
        }
    }

    @Override
    public void onChunkUnloaded() {
        super.onChunkUnloaded();
        // 当区块卸载时，从OPEN_PLAYERS中移除该方块的位置
        ForgeBlock.OPEN_PLAYERS.remove(this.getBlockPos());
    }
    
    @Override
    public void setRemoved() {
        super.setRemoved();
        // 当方块被移除时，从OPEN_PLAYERS中移除该方块的位置
        ForgeBlock.OPEN_PLAYERS.remove(this.getBlockPos());
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
            level1.playSound(player,this.getBlockPos(), ChangShengJueSound.FORGE_BLOCK_SOUND.get(), SoundSource.BLOCKS, 0.1F, 1.0F);
        }).setParticleKeyframeHandler((state) -> {
            Level level1 = ClientUtils.getLevel();
            spawnForgeParticles(level1);
        }))));
    }

    public void spawnForgeParticles(Level level) {
        if (level == null) return;

        Direction facing = getBlockState().getValue(FACING);

        double baseX = worldPosition.getX() + 0.5;
        double baseY = worldPosition.getY() + 0.8;
        double baseZ = worldPosition.getZ() + 0.5;

        switch (facing) {
            case NORTH -> {
                baseX += 0.2;
                baseZ += 0.2;
            }
            case SOUTH -> {
                baseX -= 0.2;
                baseZ -= 0.2;
            }
            case EAST -> {
                baseZ += 0.2;
                baseX -= 0.2;
            }
            case WEST -> {
                baseZ -= 0.2;
                baseX += 0.2;
            }
        }
        int particleCount = 6 + level.random.nextInt(6);
        for (int i = 0; i < particleCount; i++) {
            // 小范围随机偏移
            double xOffset = (level.random.nextDouble() - 0.5) * 0.1;
            double yOffset = level.random.nextDouble() * 0.15;
            double zOffset = (level.random.nextDouble() - 0.5) * 0.1;

            // 速度参数
            double xSpeed = (level.random.nextDouble() - 0.5) * 0.2;
            double ySpeed = level.random.nextDouble() * 0.06 + 0.03;
            double zSpeed = (level.random.nextDouble() - 0.5) * 0.2;

            // 根据朝向调整主要喷射方向
            switch (facing) {
                case NORTH -> zSpeed = -Math.abs(zSpeed) * 1.2;
                case SOUTH -> zSpeed = Math.abs(zSpeed) * 1.2;
                case EAST -> xSpeed = Math.abs(xSpeed) * 1.2;
                case WEST -> xSpeed = -Math.abs(xSpeed) * 1.2;
            }

            level.addParticle(ChangShengJueParticles.FORGE_BLOCK_PARTCLE.get(),
                    baseX + xOffset,
                    baseY + yOffset,
                    baseZ + zOffset,
                    xSpeed,
                    ySpeed,
                    zSpeed);
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}