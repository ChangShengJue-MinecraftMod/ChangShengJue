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
import net.minecraftforge.items.wrapper.InvWrapper;

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
        updateRecipeSlots();

        // 只有服务端才更新实体
        if (!level.isClientSide) {
            blockEntity.setCurrentRecipe(recipe);
            blockEntity.setChanged();
        }
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
        clearAllSlots();

        if (currentRecipe != null) {
            // 这里应该放置单次材料用于显示
            ItemStack[] singleMaterials = getSingleMaterialsFromRecipe(currentRecipe);

            // 将单次材料放入对应的槽位
            for (int i = 0; i < singleMaterials.length && i < 9; i++) {
                final int slotIndex = i;
                ItemStack material = singleMaterials[i].copy();
                blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
                    handler.insertItem(slotIndex, material, false);
                });
            }
        }
    }

    public ItemStack[] getSingleMaterialsFromRecipe(WoodworkingBenchRecipe recipe) {
        if (recipe == null) {
            return new ItemStack[0];
        }

        ItemStack[] materials = new ItemStack[recipe.getIngredients().size()];

        for (int i = 0; i < recipe.getIngredients().size(); i++) {
            Ingredient ingredient = recipe.getIngredients().get(i);
            if (ingredient.getItems().length > 0) {
                materials[i] = ingredient.getItems()[0].copy();
            } else {
                materials[i] = ItemStack.EMPTY;
            }
        }
        return materials;
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

    public ItemStack[] getMaterialsFromRecipe(WoodworkingBenchRecipe recipe) {
        if (recipe == null) {
            return new ItemStack[0];
        }

        ItemStack[] singleMaterials = getSingleMaterialsFromRecipe(recipe);
        int craftTimes = getCraftTimes();

        // 复制单次材料并乘以制作次数
        ItemStack[] totalMaterials = new ItemStack[singleMaterials.length];
        for (int i = 0; i < singleMaterials.length; i++) {
            if (!singleMaterials[i].isEmpty()) {
                totalMaterials[i] = singleMaterials[i].copy();
                totalMaterials[i].setCount(singleMaterials[i].getCount() * craftTimes);
            } else {
                totalMaterials[i] = ItemStack.EMPTY;
            }
        }

        return totalMaterials;
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

    boolean hasEnoughMaterials(Inventory playerInventory) {
        if (currentRecipe == null) return false;

        IItemHandler playerItems = new InvWrapper(playerInventory);
        ItemStack[] requiredMaterials = getMaterialsFromRecipe(currentRecipe);
        int craftTimes = getCraftTimes();

        for (ItemStack required : requiredMaterials) {
            if (required.isEmpty()) continue;

            int needed = required.getCount();
            int found = 0;

            for (int i = 0; i < playerItems.getSlots(); i++) {
                ItemStack stack = playerItems.getStackInSlot(i);
                if (ItemStack.isSameItemSameTags(stack, required)) {
                    found += stack.getCount();
                    if (found >= needed) break;
                }
            }

            if (found < needed) return false;
        }
        return true;
    }

    void consumeMaterials(Inventory playerInventory) {
        if (currentRecipe == null) return;

        ItemStack[] requiredMaterials = getMaterialsFromRecipe(currentRecipe);
        int craftTimes = getCraftTimes();

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

    public boolean hasEnoughOfMaterial(Inventory playerInventory, ItemStack required) {
        if (required.isEmpty()) return true;

        IItemHandler playerItems = new InvWrapper(playerInventory);
        int needed = required.getCount();
        int found = 0;

        for (int i = 0; i < playerItems.getSlots(); i++) {
            ItemStack stack = playerItems.getStackInSlot(i);
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