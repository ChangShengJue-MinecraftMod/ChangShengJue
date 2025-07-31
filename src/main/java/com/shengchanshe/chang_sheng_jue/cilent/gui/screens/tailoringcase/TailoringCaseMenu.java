package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.tailoringcase;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase.TailoringCaseEntity;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.ChangShengJueMenuTypes;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TailoringCaseMenu extends AbstractContainerMenu {
    public final TailoringCaseEntity blockEntity;
    private final Level level;
    public final ContainerData data;
    TailoringRecipe currentRecipe = null;

    public TailoringCaseMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
    }

    public TailoringCaseMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ChangShengJueMenuTypes.TAILORING_CASE_MENU.get(), pContainerId);
        checkContainerSize(inv, 10);
        blockEntity = ((TailoringCaseEntity) entity);
        this.level = inv.player.level();
        this.data = data;

        // 加载配方
        this.currentRecipe = blockEntity.getCurrentRecipe();

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        // 输入槽（只读，仅显示配方材料）
        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new ReadOnlySlot(handler, 0, 135, 46));
            this.addSlot(new ReadOnlySlot(handler, 1, 153, 46));
            this.addSlot(new ReadOnlySlot(handler, 2, 171, 46));
            this.addSlot(new ReadOnlySlot(handler, 3, 135, 64));
            this.addSlot(new ReadOnlySlot(handler, 4, 153, 64));
            this.addSlot(new ReadOnlySlot(handler, 5, 171, 64));
            this.addSlot(new ReadOnlySlot(handler, 6, 135, 82));
            this.addSlot(new ReadOnlySlot(handler, 7, 153, 82));
            this.addSlot(new ReadOnlySlot(handler, 8, 171, 82));
        });

        // 输出槽（可拾取）
        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new OutputSlot(handler, 9, 229, 63));
        });

        addDataSlots(data);

        // 初始化时显示当前配方
        if (currentRecipe != null) {
            updateRecipeSlots();
        }

    }

    public TailoringRecipe getCurrentRecipe() {
        return currentRecipe;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        // 只有不在制作中时才清除
        if(!isCrafting()) {
            clearAllSlots();
            if (!player.level().isClientSide) {
                blockEntity.setCurrentRecipe(null);
            }
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

    public void setCurrentRecipe(TailoringRecipe recipe) {
        this.currentRecipe = recipe;
        updateRecipeSlots();

        // 只有服务端才更
        if (!level.isClientSide) {
            blockEntity.setCurrentRecipe(recipe);
        }
    }

    void updateRecipeSlots() {
        clearAllSlots();

        if (currentRecipe != null) {
            ItemStack[] materials = currentRecipe.getMaterials();
            for (int i = 0; i < materials.length && i < 9; i++) {
                int finalI = i;
                blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
                    handler.insertItem(finalI, materials[finalI].copy(), false);
                });
            }
        }
    }

    void clearAllSlots() {
        for (int i = 0; i < 9; i++) { // 只清空输入槽
            int finalI = i;
            blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
                handler.extractItem(finalI, 64, false);
            });
        }
    }

    //已废弃制作物品逻辑
    public boolean craftItem(Player player) {
        if (currentRecipe == null || level.isClientSide()) {
            return false;
        }

        // 检查输出槽是否有物品
        if (!blockEntity.getItemHandler().getStackInSlot(TailoringCaseEntity.SLOT_OUTPUT).isEmpty()) {
            return false; // 输出槽有物品，禁止合成
        }

        if (hasEnoughMaterials(player.getInventory())) {
            consumeMaterials(player.getInventory());
            blockEntity.progress = 1; // 开始进度
            blockEntity.setChanged();
            return true;
        }
        return false;
    }

    private boolean hasEnoughMaterials(Inventory playerInventory) {
        if (currentRecipe == null) return false;

        IItemHandler playerItems = new InvWrapper(playerInventory);
        ItemStack[] requiredMaterials = currentRecipe.getMaterials();

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

    private void consumeMaterials(Inventory playerInventory) {
        if (currentRecipe == null) return;

        ItemStack[] requiredMaterials = currentRecipe.getMaterials();
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

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 2;  // must be the number of slots you have!
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
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
                player, ChangShengJueBlocks.TAILORING_CASE.get());
    }

    public BlockPos getBlockPos() {
        return blockEntity.getBlockPos();
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
            return false; // 输出槽不接受输入
        }
    }

    public static class TailoringRecipe {
        private final ItemStack result;
        private final ItemStack[] materials;

        public TailoringRecipe(ItemStack result, ItemStack... materials) {
            this.result = result;
            this.materials = materials;
        }

        public ItemStack getResult() {
            return result.copy();
        }

        public ItemStack[] getMaterials() {
            return Arrays.stream(materials).map(ItemStack::copy).toArray(ItemStack[]::new);
        }

        // 用于NBT序列化
        public CompoundTag serializeNBT() {
            CompoundTag tag = new CompoundTag();
            tag.put("result", result.serializeNBT());

            CompoundTag materialsTag = new CompoundTag();
            for (int i = 0; i < materials.length; i++) {
                materialsTag.put("material_" + i, materials[i].serializeNBT());
            }
            tag.put("materials", materialsTag);
            tag.putInt("material_count", materials.length);

            return tag;
        }

        // 用于NBT反序列化
        public static TailoringRecipe deserializeNBT(CompoundTag tag) {
            ItemStack result = ItemStack.of(tag.getCompound("result"));
            int count = tag.getInt("material_count");
            ItemStack[] materials = new ItemStack[count];

            CompoundTag materialsTag = tag.getCompound("materials");
            for (int i = 0; i < count; i++) {
                materials[i] = ItemStack.of(materialsTag.getCompound("material_" + i));
            }

            return new TailoringRecipe(result, materials);
        }
    }


    public static Optional<TailoringRecipe> findRecipe(ItemStack result) {
        return RECIPES.stream()
                .filter(recipe -> {
                    ItemStack recipeResult = recipe.getResult();
                    return ItemStack.isSameItemSameTags(recipeResult, result) &&
                            recipeResult.getCount() == result.getCount();
                })
                .findFirst();
    }

    //添加配方
    // 配方定义
    public static final List<TailoringRecipe> RECIPES = new ArrayList<>();

    // 静态初始化块 - 在这里添加配方
    static {
        // 添加钻石靴子配方（li
        addRecipe(
                new ItemStack(Items.DIAMOND_BOOTS),
                new ItemStack(Items.DIAMOND, 4),
                new ItemStack(Items.LEATHER, 2)
        );

        // 添加钻石护甲配方（li
        addRecipe(
                new ItemStack(Items.DIAMOND_CHESTPLATE),
                new ItemStack(Items.DIAMOND, 8),
                new ItemStack(Items.LEATHER, 5)
        );

    }

    // 添加配方的辅助方法
    private static void addRecipe(ItemStack result, ItemStack... materials) {
        RECIPES.add(new TailoringRecipe(result, materials));
    }

}