package com.shengchanshe.chang_sheng_jue.block.custom.workbench;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.workbench.WoodworkingBenchMenu;
import com.shengchanshe.chang_sheng_jue.recipe.WoodworkingBenchRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class WoodworkingBenchEntity extends BlockEntity implements MenuProvider, GeoBlockEntity {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public static final DirectionProperty FACING = WoodworkingBench.FACING;

    /** 输出槽位索引 */
    public static final int SLOT_OUTPUT = 9;

    /** 输入槽位数量 */
    private static final int INPUT_SLOT_COUNT = 9;

    /** 总槽位数量 (9输入 + 1输出) */
    private static final int TOTAL_SLOT_COUNT = 10;

    /** 最大合成进度 */
    private static final int DEFAULT_MAX_PROGRESS = 100;

    /** 物品处理器：9个输入槽，1个输出槽 */
    private final ItemStackHandler itemHandler = new ItemStackHandler(TOTAL_SLOT_COUNT);

    /** 物品处理器的延迟包装 */
    private LazyOptional<ItemStackHandler> itemHandlerLazy = LazyOptional.empty();

    /** 容器数据同步对象 */
    protected final ContainerData data;

    /** 当前合成进度 */
    public int progress = 0;

    /** 最大合成进度 */
    public int maxProgress = DEFAULT_MAX_PROGRESS;

    /** 当前选中的配方 */
    private WoodworkingBenchRecipe currentRecipe;

    /** 当前配方组 */
    private String currentRecipeGroup = "";

    /** 当前使用玩家（用于防止多人同时使用） */
    private Player currentUser;

    /** 制作次数 */
    private int craftTimes = 1;

    /**
     * 构造方法
     * @param pPos 方块位置
     * @param pBlockState 方块状态
     */
    public WoodworkingBenchEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.WOOD_WORKING_BENCH_ENTITY.get(), pPos, pBlockState);

        // 初始化容器数据同步对象
        this.data = new ContainerData() {
            @Override
            public int getCount() {
                return 3; // 进度、最大进度、制作次数
            }

            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> progress;      // 当前进度
                    case 1 -> maxProgress;   // 最大进度
                    case 2 -> craftTimes;    // 制作次数
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> progress = value;
                    case 1 -> maxProgress = value;
                    case 2 -> craftTimes = Math.max(1, Math.min(64, value)); // 限制在1-64次
                }
            }
        };
    }

    /**
     * 当方块被破坏时掉落所有物品
     */
    public void drop() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, worldPosition, inventory);
    }

    /**
     * 获取显示名称
     * @return 翻译后的显示名称
     */
    @Override
    public Component getDisplayName() {
        return Component.translatable("container." + ChangShengJue.MOD_ID + ".wood_working_bench");
    }

    /**
     * 创建菜单容器
     * @param containerId 容器ID
     * @param inventory 玩家背包
     * @param player 玩家实例
     * @return 木工台菜单实例
     */
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        // 防止多个玩家同时使用同一个木工台
        if (currentUser != null && currentUser != player) {
            return null;
        }

        if (currentUser == null) {
            currentUser = player;
        }

        return new WoodworkingBenchMenu(containerId, inventory, this, this.data);
    }

    /**
     * 玩家关闭容器时的处理
     * @param player 关闭容器的玩家
     */
    public void onClose(Player player) {
        if (player == currentUser) {
            currentUser = null;
        }
    }

    /**
     * 保存额外数据到NBT
     * @param tag NBT标签
     */
    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("progress", progress);
        tag.putInt("craft_times", craftTimes);

        // 保存当前配方信息
        if (currentRecipe != null) {
            tag.putString("current_recipe", currentRecipe.getId().toString());
        }
    }

    /**
     * 从NBT加载数据
     * @param tag NBT标签
     */
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        progress = tag.getInt("progress");

        // 加载制作次数
        if (tag.contains("craft_times")) {
            craftTimes = tag.getInt("craft_times");
        }

        // 加载当前配方信息
        if (tag.contains("current_recipe")) {
            ResourceLocation recipeId = new ResourceLocation(tag.getString("current_recipe"));
            loadRecipeById(recipeId);
        } else {
            currentRecipe = null;
        }
    }

    /**
     * 根据配方ID加载配方
     * @param recipeId 配方ID
     */
    private void loadRecipeById(ResourceLocation recipeId) {
        if (level != null) {
            Optional<? extends net.minecraft.world.item.crafting.Recipe<?>> recipe =
                    level.getRecipeManager().byKey(recipeId);

            if (recipe.isPresent() && recipe.get() instanceof WoodworkingBenchRecipe) {
                currentRecipe = (WoodworkingBenchRecipe) recipe.get();
            } else {
                currentRecipe = null;
            }
        } else {
            currentRecipe = null;
        }
    }

    /**
     * 获取能力支持
     * @param cap 能力类型
     * @param side 方块面
     * @return 能力包装
     */
    @Override
    public @Nullable <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return itemHandlerLazy.cast();
        }
        return super.getCapability(cap, side);
    }

    /**
     * 方块实体加载时的处理
     */
    @Override
    public void onLoad() {
        super.onLoad();
        itemHandlerLazy = LazyOptional.of(() -> itemHandler);
    }

    /**
     * 失效能力包装
     */
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        itemHandlerLazy.invalidate();
    }

    /**
     * 获取更新标签（客户端同步）
     * @return 包含同步数据的NBT标签
     */
    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag);
        return tag;
    }

    /**
     * 处理数据包
     * @param net 网络连接
     * @param pkt 数据包
     */
    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        load(Objects.requireNonNull(pkt.getTag()));
    }

    /**
     * 处理更新标签
     * @param tag NBT标签
     */
    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        load(tag); // 确保客户端同步物品数据
    }

    /**
     * 获取更新数据包
     * @return 数据包实例
     */
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    /**
     * 获取物品处理器
     * @return 物品处理器实例
     */
    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }

    /**
     * 获取制作次数
     * @return 制作次数
     */
    public int getCraftTimes() {
        return craftTimes;
    }

    /**
     * 设置制作次数
     * @param times 制作次数
     */
    public void setCraftTimes(int times) {
        this.craftTimes = Math.max(1, Math.min(64, times));
        setChanged();
        if (level != null) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
        }
    }

    /**
     * 每tick更新处理
     * @param pLevel 世界实例
     * @param pPos 方块位置
     * @param pState 方块状态
     */
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if (pLevel.isClientSide()) return; // 客户端不处理逻辑

        // 处理合成进度
        if (progress > 0 && progress < maxProgress) {
            progress++;
            this.setChanged();
        } else if (progress >= maxProgress) {
            // 进度完成，生成物品
            completeCrafting();
        }
    }

    /**
     * 完成合成过程
     */
    private void completeCrafting() {
        if (currentRecipe != null) {
            // 每次只产出1个物品
            ItemStack result = currentRecipe.getResultItem(level.registryAccess()).copy();
            craftItem(result);

            // 减少制作次数，如果还有次数则继续制作
            craftTimes--;
            if (craftTimes > 0) {
                // 还有制作次数，重新开始制作
                progress = 1;
            } else {
                // 制作完成，重置进度
                progress = 0;
                craftTimes = 1; // 重置为默认1次
            }
        } else {
            progress = 0;
            craftTimes = 1; // 重置为默认1次
        }
        this.setChanged();
    }

    /**
     * 生成合成物品到输出槽
     * @param result 合成结果物品
     */
    public void craftItem(ItemStack result) {
        ItemStack output = itemHandler.getStackInSlot(SLOT_OUTPUT);
        ItemStack stack = result.copy();

        if (output.isEmpty()) {
            itemHandler.setStackInSlot(SLOT_OUTPUT, stack);
        } else if (ItemStack.isSameItemSameTags(output, stack)) {
            int newCount = output.getCount() + stack.getCount();
            if (newCount <= output.getMaxStackSize()) {
                output.setCount(newCount);
            }
        }

        setChanged();
        if (level != null) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
        }
    }

    /**
     * 开始合成当前配方
     * @param player 执行合成的玩家
     */
    public void craftCurrentRecipe(Player player) {
        WoodworkingBenchRecipe recipeToUse = findUsableRecipe();

        if (recipeToUse == null) return;

        // 检查输出槽是否可以放入物品
        ItemStack output = itemHandler.getStackInSlot(SLOT_OUTPUT);
        ItemStack resultItem = recipeToUse.getResultItem(level.registryAccess());
        if (!output.isEmpty() && (!ItemStack.isSameItemSameTags(output, resultItem) ||
                output.getCount() + craftTimes > output.getMaxStackSize())) {
            return;
        }

        // 更新当前配方
        if (recipeToUse != currentRecipe) {
            setCurrentRecipe(recipeToUse);
        }

        // 检查并消耗材料（乘以制作次数）
        if (hasEnoughMaterials(player.getInventory(), recipeToUse)) {
            consumeMaterials(player.getInventory(), recipeToUse);
            this.progress = 1;
            this.setChanged();
        }
    }

    /**
     * 查找可用的配方
     * @return 可用的配方，如果没有则返回null
     */
    private WoodworkingBenchRecipe findUsableRecipe() {
        // 首先检查当前配方是否有足够材料
        if (currentRecipe != null && hasEnoughMaterials(currentUser.getInventory(), currentRecipe)) {
            return currentRecipe;
        }

        // 如果当前配方材料不足，查找同一结果物品的其他配方
        if (currentRecipe != null) {
            return findAlternativeRecipe();
        }

        return null;
    }

    /**
     * 查找替代配方
     * @return 替代配方，如果没有则返回null
     */
    private WoodworkingBenchRecipe findAlternativeRecipe() {
        ItemStack resultItem = currentRecipe.getResultItem(level.registryAccess());
        Collection<WoodworkingBenchRecipe> allRecipes =
                level.getRecipeManager().getAllRecipesFor(WoodworkingBenchRecipe.Type.INSTANCE);

        for (WoodworkingBenchRecipe recipe : allRecipes) {
            if (ItemStack.isSameItemSameTags(recipe.getResultItem(level.registryAccess()), resultItem)) {
                if (hasEnoughMaterials(currentUser.getInventory(), recipe)) {
                    return recipe;
                }
            }
        }
        return null;
    }

    /**
     * 检查玩家是否有足够材料（支持Tag标签匹配）
     * @param playerInventory 玩家背包
     * @param recipe 要检查的配方
     * @return 材料是否足够
     */
    private boolean hasEnoughMaterials(Inventory playerInventory, WoodworkingBenchRecipe recipe) {
        NonNullList<Ingredient> ingredients = recipe.getIngredients();
        int[] requiredCounts = recipe.getCachedRequiredCounts();

        for (int idx = 0; idx < ingredients.size(); idx++) {
            Ingredient ingredient = ingredients.get(idx);
            if (ingredient.isEmpty()) continue;

            int needed = requiredCounts[idx] * craftTimes; // 乘以制作次数
            int found = 0;

            for (int i = 0; i < playerInventory.getContainerSize() && found < needed; i++) {
                ItemStack stack = playerInventory.getItem(i);
                // 使用ingredient.test()支持Tag标签匹配
                if (!stack.isEmpty() && ingredient.test(stack)) {
                    found += stack.getCount();
                }
            }

            if (found < needed) return false;
        }
        return true;
    }

    /**
     * 消耗玩家材料（支持Tag标签匹配）
     * @param playerInventory 玩家背包
     * @param recipe 要消耗材料的配方
     */
    private void consumeMaterials(Inventory playerInventory, WoodworkingBenchRecipe recipe) {
        NonNullList<Ingredient> ingredients = recipe.getIngredients();
        int[] requiredCounts = recipe.getCachedRequiredCounts();

        for (int idx = 0; idx < ingredients.size(); idx++) {
            Ingredient ingredient = ingredients.get(idx);
            if (ingredient.isEmpty()) continue;

            int needed = requiredCounts[idx] * craftTimes; // 乘以制作次数
            for (int i = 0; i < playerInventory.getContainerSize() && needed > 0; i++) {
                ItemStack stack = playerInventory.getItem(i);
                // 使用ingredient.test()支持Tag标签匹配
                if (!stack.isEmpty() && ingredient.test(stack)) {
                    int take = Math.min(needed, stack.getCount());
                    stack.shrink(take);
                    needed -= take;
                }
            }
        }
    }

    // ========== 配方管理相关方法 ==========

    /**
     * 从配方中获取材料示例物品（用于UI显示）
     * @param recipe 配方实例
     * @return 材料物品数组
     */
    public ItemStack[] getMaterialsFromRecipe(WoodworkingBenchRecipe recipe) {
        return recipe.getIngredients().stream()
                .map(ingredient -> ingredient.getItems().length > 0 ? ingredient.getItems()[0] : ItemStack.EMPTY)
                .toArray(ItemStack[]::new);
    }

    /**
     * 设置当前配方
     * @param recipe 配方实例
     */
    public void setCurrentRecipe(WoodworkingBenchRecipe recipe) {
        setCurrentRecipe(recipe, recipe != null ? recipe.getGroup() : null);
    }

    /**
     * 设置当前配方和配方组
     * @param recipe 配方实例
     * @param group 配方组
     */
    public void setCurrentRecipe(WoodworkingBenchRecipe recipe, String group) {
        this.currentRecipe = recipe;
        this.currentRecipeGroup = group != null ? group : "";

        // 清空输入槽并设置新的配方材料
        clearInputSlots();

        setChanged();
        if (level != null) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
        }
    }

    /**
     * 清空所有输入槽
     */
    private void clearInputSlots() {
        for (int i = 0; i < INPUT_SLOT_COUNT; i++) {
            itemHandler.setStackInSlot(i, ItemStack.EMPTY);
        }
    }

    /**
     * 获取当前配方
     * @return 当前配方实例
     */
    public WoodworkingBenchRecipe getCurrentRecipe() {
        return currentRecipe;
    }

    /**
     * 获取当前配方的结果物品
     * @return 结果物品堆栈
     */
    public ItemStack getRecipeResultItem() {
        if (currentRecipe != null) {
            return currentRecipe.getResultItem(level.registryAccess());
        }
        return ItemStack.EMPTY;
    }

    /**
     * 标记数据已变更
     */
    @Override
    public void setChanged() {
        super.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_CLIENTS);
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "idle", 0, (state) -> {
            if (this.progress != 0) {
                state.setAndContinue(DefaultAnimations.IDLE);
                return PlayState.CONTINUE;
            } else {
                return PlayState.STOP;
            }
        }));
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}