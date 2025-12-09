package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.workbench;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.custom.workbench.WoodworkingBenchEntity;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.ChangShengJueMenuTypes;
import com.shengchanshe.chang_sheng_jue.recipe.WoodworkingBenchRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class WoodworkingBenchMenu extends AbstractContainerMenu {

    // 常量定义
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_SLOT_COUNT = 10;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // 输入槽位坐标数组
    private static final int[][] INPUT_SLOT_POSITIONS = {
            {113, 46}, {131, 46}, {149, 46},
            {113, 64}, {131, 64}, {149, 64},
            {113, 82}, {131, 82}, {149, 82}
    };

    public final WoodworkingBenchEntity blockEntity;
    public final Level level;

    public final ContainerData data;
    public WoodworkingBenchRecipe currentRecipe = null;

    // 材料缓存，避免重复计算
    private ItemStack[] cachedSingleMaterials;
    private ItemStack[] cachedTotalMaterials;
    private int lastCachedCraftTimes = -1;
    private WoodworkingBenchRecipe lastCachedRecipe = null;

    public WoodworkingBenchMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(3)); // 改为3个数据
    }

    public WoodworkingBenchMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ChangShengJueMenuTypes.WOOD_WORKING_BENCH_MENU.get(), pContainerId);
        checkContainerSize(inv, 10);

        this.blockEntity = (WoodworkingBenchEntity) entity;
        this.level = inv.player.level();
        this.data = data;
        this.currentRecipe = blockEntity.getCurrentRecipe();

        addPlayerInventory(inv);
        addPlayerHotbar(inv);
        addInputSlots();
        addOutputSlot();
        addDataSlots(data);

        // 初始化时显示当前配方
        if (currentRecipe != null) {
            updateRecipeSlots();
        }
    }

    // 获取制作次数
    public int getCraftTimes() {
        return data.get(2);
    }
    // 设置制作次数
    public void setCraftTimes(int times) {
        int clampedTimes = Math.max(1, Math.min(64, times));
        this.data.set(2, clampedTimes);

        // 只有服务端才更新实体
        if (!level.isClientSide) {
            blockEntity.setCraftTimes(clampedTimes);
            blockEntity.setChanged();
        }

        // 更新材料显示
        if (currentRecipe != null) {
            updateRecipeSlots();
        }
    }

    public void setCurrentRecipe(WoodworkingBenchRecipe recipe) {
        this.currentRecipe = recipe;
        invalidateMaterialCache();
        updateRecipeSlots();

        // 只有服务端才更新实体
        if (!level.isClientSide) {
            blockEntity.setCurrentRecipe(recipe);
            blockEntity.setChanged();
        }
    }

    /**
     * 使材料缓存失效
     */
    private void invalidateMaterialCache() {
        cachedSingleMaterials = null;
        cachedTotalMaterials = null;
        lastCachedCraftTimes = -1;
        lastCachedRecipe = null;
    }

    public WoodworkingBenchRecipe getCurrentRecipe() {
        if (this.currentRecipe != null) {
            return this.currentRecipe;
        }
        if (blockEntity != null) {
            return blockEntity.getCurrentRecipe();
        }
        return null;
    }

    void updateRecipeSlots() {
        // 清空槽位，材料显示由Screen的renderCarouselMaterials处理
        clearAllSlots();
    }

    /**
     * 获取单次合成所需材料（使用缓存）
     */
    public ItemStack[] getSingleMaterialsFromRecipe(WoodworkingBenchRecipe recipe) {
        if (recipe == null) {
            return new ItemStack[0];
        }

        // 使用配方内置的缓存
        return recipe.getCachedMaterials();
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        blockEntity.onClose(player);
        // 只有不在制作中时才清除
        if (!isCrafting()) {
            clearAllSlots();
            blockEntity.setCurrentRecipe(null);
        }
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int progressArrowSize = 26;
        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    /**
     * 获取总材料需求（使用缓存）
     */
    public ItemStack[] getMaterialsFromRecipe(WoodworkingBenchRecipe recipe) {
        if (recipe == null) {
            return new ItemStack[0];
        }

        int craftTimes = getCraftTimes();

        // 检查缓存是否有效
        if (cachedTotalMaterials != null &&
                lastCachedRecipe == recipe &&
                lastCachedCraftTimes == craftTimes) {
            return cachedTotalMaterials;
        }

        // 使用配方的优化方法
        cachedTotalMaterials = recipe.getMaterialsForCraftTimes(craftTimes);
        lastCachedRecipe = recipe;
        lastCachedCraftTimes = craftTimes;

        return cachedTotalMaterials;
    }

    void clearAllSlots() {
        for (int i = 0; i < 9; i++) {
            final int slotIndex = i;
            blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
                handler.extractItem(slotIndex, 64, false);
            });
        }
    }

    public boolean craftItem(Player player) {
        if (currentRecipe == null || level.isClientSide()) {
            return false;
        }

        // 检查输出槽是否有物品
        if (!blockEntity.getItemHandler().getStackInSlot(WoodworkingBenchEntity.SLOT_OUTPUT).isEmpty()) {
            return false;
        }

        if (hasEnoughMaterials(player.getInventory())) {
            consumeMaterials(player.getInventory());
            blockEntity.progress = 1;
            blockEntity.setChanged();
            return true;
        }
        return false;
    }

    /**
     * 检查玩家是否有足够材料（优化版）
     */
    boolean hasEnoughMaterials(Inventory playerInventory) {
        if (currentRecipe == null) return false;

        // 使用配方内置的优化方法
        return currentRecipe.hasEnoughMaterials(playerInventory, getCraftTimes());
    }

    void consumeMaterials(Inventory playerInventory) {
        if (currentRecipe == null) return;

        var ingredients = currentRecipe.getIngredients();
        int[] requiredCounts = currentRecipe.getCachedRequiredCounts();
        int craftTimes = getCraftTimes();

        for (int idx = 0; idx < ingredients.size(); idx++) {
            Ingredient ingredient = ingredients.get(idx);
            if (ingredient.isEmpty()) continue;

            int needed = requiredCounts[idx] * craftTimes;
            for (int i = 0; i < playerInventory.getContainerSize() && needed > 0; i++) {
                ItemStack stack = playerInventory.getItem(i);
                // 使用ingredient.test()支持tag标签匹配
                if (!stack.isEmpty() && ingredient.test(stack)) {
                    int take = Math.min(needed, stack.getCount());
                    stack.shrink(take);
                    needed -= take;
                }
            }
        }
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (!sourceSlot.hasItem()) return ItemStack.EMPTY;

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // 从锻台移动到玩家物品栏
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX,
                    VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            return ItemStack.EMPTY;
        }

        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }

        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ChangShengJueBlocks.WOOD_WORKING_BENCH.get());
    }

    public BlockPos getBlockPos() {
        return blockEntity.getBlockPos();
    }

    private void addInputSlots() {
        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            for (int i = 0; i < INPUT_SLOT_POSITIONS.length; i++) {
                int[] pos = INPUT_SLOT_POSITIONS[i];
                this.addSlot(new ReadOnlySlot(handler, i, pos[0], pos[1]));
            }
        });
    }

    private void addOutputSlot() {
        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new OutputSlot(handler, 9, 207, 63));
        });
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 89 + l * 18, 115 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 89 + i * 18, 173));
        }
    }

    /**
     * 检查玩家是否有足够的指定材料（支持tag标签）
     * @param playerInventory 玩家背包
     * @param required 需要的材料物品
     * @param ingredientIndex 材料在配方中的索引（用于获取对应的Ingredient进行tag匹配）
     */
    public boolean hasEnoughOfMaterial(Inventory playerInventory, ItemStack required, int ingredientIndex) {
        if (required.isEmpty()) return true;
        if (currentRecipe == null) return false;

        var ingredients = currentRecipe.getIngredients();
        if (ingredientIndex < 0 || ingredientIndex >= ingredients.size()) {
            return hasEnoughOfMaterialExact(playerInventory, required);
        }

        Ingredient ingredient = ingredients.get(ingredientIndex);
        int needed = required.getCount();
        int found = 0;

        for (int i = 0; i < playerInventory.getContainerSize(); i++) {
            ItemStack stack = playerInventory.getItem(i);
            if (!stack.isEmpty() && ingredient.test(stack)) {
                found += stack.getCount();
                if (found >= needed) return true;
            }
        }
        return false;
    }

    /**
     * 检查玩家是否有足够的指定材料（精确匹配，兼容旧调用）
     */
    public boolean hasEnoughOfMaterial(Inventory playerInventory, ItemStack required) {
        if (required.isEmpty()) return true;
        if (currentRecipe == null) return hasEnoughOfMaterialExact(playerInventory, required);

        // 尝试找到对应的ingredient进行tag匹配
        var ingredients = currentRecipe.getIngredients();
        ItemStack[] cachedMaterials = currentRecipe.getCachedMaterials();

        for (int i = 0; i < cachedMaterials.length && i < ingredients.size(); i++) {
            if (ItemStack.isSameItemSameTags(cachedMaterials[i], required)) {
                return hasEnoughOfMaterial(playerInventory, required, i);
            }
        }

        // 找不到对应的ingredient，使用精确匹配
        return hasEnoughOfMaterialExact(playerInventory, required);
    }

    /**
     * 精确匹配检查材料是否充足
     */
    private boolean hasEnoughOfMaterialExact(Inventory playerInventory, ItemStack required) {
        if (required.isEmpty()) return true;

        int needed = required.getCount();
        int found = 0;

        for (int i = 0; i < playerInventory.getContainerSize(); i++) {
            ItemStack stack = playerInventory.getItem(i);
            if (ItemStack.isSameItemSameTags(stack, required)) {
                found += stack.getCount();
                if (found >= needed) return true;
            }
        }
        return false;
    }

    public static class ReadOnlySlot extends SlotItemHandler {
        public ReadOnlySlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(ItemStack stack) {
            return false;
        }

        @Override
        public boolean mayPickup(Player playerIn) {
            return false;
        }
    }

    public static class OutputSlot extends SlotItemHandler {
        public OutputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(ItemStack stack) {
            return false;
        }
    }
}