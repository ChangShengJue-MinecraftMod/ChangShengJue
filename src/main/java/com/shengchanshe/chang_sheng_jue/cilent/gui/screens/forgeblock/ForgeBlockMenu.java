package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.forgeblock;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.custom.forgeblock.ForgeBlockEntity;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.ChangShengJueMenuTypes;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.MenuBlockEntityResolver;
import com.shengchanshe.chang_sheng_jue.recipe.ForgeBlockRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import java.util.Arrays;
import java.util.function.BooleanSupplier;

public class ForgeBlockMenu extends AbstractContainerMenu {

    public final ForgeBlockEntity blockEntity;
    public final Level level;
    public final ContainerData data;
    private final boolean backingEntityValid;
    private final IItemHandler menuItemHandler;
    ForgeBlockRecipe currentRecipe = null;

    public ForgeBlockMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, MenuBlockEntityResolver.resolve(
                inv.player.level(), extraData.readBlockPos(), ForgeBlockEntity.class,
                ChangShengJueBlocks.FORGE_BLOCK.get(), ForgeBlockEntity::new), new SimpleContainerData(2));
    }

    public ForgeBlockMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        this(pContainerId, inv, MenuBlockEntityResolver.resolve(
                inv.player.level(), entity, ForgeBlockEntity.class,
                ChangShengJueBlocks.FORGE_BLOCK.get(), ForgeBlockEntity::new), data);
    }

    private ForgeBlockMenu(int pContainerId, Inventory inv,
                           MenuBlockEntityResolver.Resolution<ForgeBlockEntity> resolution,
                           ContainerData data) {
        super(ChangShengJueMenuTypes.FORGE_BLOCK_MENU.get(), pContainerId);
        checkContainerSize(inv, 10);
        blockEntity = resolution.entity();
        this.level = inv.player.level();
        this.data = data;
        this.backingEntityValid = resolution.valid();
        this.menuItemHandler = this.backingEntityValid
                ? this.blockEntity.getItemHandler()
                : new ItemStackHandler(TE_INVENTORY_SLOT_COUNT);

        // 从实体加载当前配方
        this.currentRecipe = blockEntity.getCurrentRecipe();

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        // 输入槽（只读，仅显示配方材料）
        {
            IItemHandler handler = this.menuItemHandler;
            this.addSlot(new ReadOnlySlot(handler, 0, 135, 46));
            this.addSlot(new ReadOnlySlot(handler, 1, 153, 46));
            this.addSlot(new ReadOnlySlot(handler, 2, 171, 46));
            this.addSlot(new ReadOnlySlot(handler, 3, 135, 64));
            this.addSlot(new ReadOnlySlot(handler, 4, 153, 64));
            this.addSlot(new ReadOnlySlot(handler, 5, 171, 64));
            this.addSlot(new ReadOnlySlot(handler, 6, 135, 82));
            this.addSlot(new ReadOnlySlot(handler, 7, 153, 82));
            this.addSlot(new ReadOnlySlot(handler, 8, 171, 82));
        }

        // 输出槽（可拾取）
        this.addSlot(new OutputSlot(this.menuItemHandler, 9, 229, 63, this::hasValidBackingEntity));

        addDataSlots(data);

        // 初始化时显示当前配方
        if (currentRecipe != null) {
            updateRecipeSlots();
        }
    }

    // 设置当前配方
    public void setCurrentRecipe(ForgeBlockRecipe recipe) {
        if (!hasValidBackingEntity()) return;
        this.currentRecipe = recipe;
        updateRecipeSlots();

        // 只有服务端才更新实体
        if (!level.isClientSide) {
            blockEntity.setCurrentRecipe(recipe);
            blockEntity.setChanged(); // 标记区块需要保存
        }
    }

    // 获取当前配方
    public ForgeBlockRecipe getCurrentRecipe() {
        if (!hasValidBackingEntity()) return null;
        // 优先使用菜单中的配方，如果没有则从方块实体获取
        if (this.currentRecipe != null) {
            return this.currentRecipe;
        }
        if (blockEntity != null) {
            return blockEntity.getCurrentRecipe();
        }
        return null;
    }

    // 更新配方槽位显示
    void updateRecipeSlots() {
        // 展示材料由Screen根据currentRecipe直接绘制，不能进入真实物品处理器。
    }

    // 移除界面时的处理
    @Override
    public void removed(Player player) {
        super.removed(player);
        if (!hasValidBackingEntity()) return;
        blockEntity.onClose(player);
        // 只有不在制作中时才清除
        if (!isCrafting()) {
            clearAllSlots();
            blockEntity.setCurrentRecipe(null);
        }
    }

    // 检查是否正在制作中
    public boolean isCrafting() {
        return hasValidBackingEntity() && data.get(0) > 0;
    }

    // 获取缩放后的进度值
    public int getScaledProgress() {
        if (!hasValidBackingEntity()) return 0;
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int progressArrowSize = 26;
        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    /**
     * 从配方中获取材料示例物品（用于UI显示）
     * @param recipe 配方对象
     * @return 材料物品数组
     */
    public ItemStack[] getMaterialsFromRecipe(ForgeBlockRecipe recipe) {
        if (!hasValidBackingEntity() || recipe == null) return new ItemStack[0];
        ItemStack[] materials = new ItemStack[recipe.getIngredients().size()];
        for (int i = 0; i < recipe.getIngredients().size(); i++) {
            Ingredient ingredient = recipe.getIngredients().get(i);
            if (ingredient.getItems().length > 0) {
                // 直接使用ingredient中的物品，它已经包含了正确的数量
                materials[i] = ingredient.getItems()[0].copy();
            } else {
                materials[i] = ItemStack.EMPTY;
            }
        }
        return materials;
    }

    // 清空所有槽位
    void clearAllSlots() {
        // 保留方法描述符兼容旧调用；输入槽不再承载展示物。
    }

    // 制作物品
    public boolean craftItem(Player player) {
        if (!hasValidBackingEntity() || currentRecipe == null || level.isClientSide()) return false;
        blockEntity.craftCurrentRecipe(player);
        return blockEntity.isCrafting();
    }

    // 检查是否有足够材料
    boolean hasEnoughMaterials(Inventory playerInventory) {
        if (!hasValidBackingEntity() || currentRecipe == null) return false;

        IItemHandler playerItems = new InvWrapper(playerInventory);
        ItemStack[] requiredMaterials = getMaterialsFromRecipe(currentRecipe);

        for (ItemStack required : requiredMaterials) {
            if (required.isEmpty()) continue;

            int needed = required.getCount();
            int found = 0;

            for (int i = 0; i < playerItems.getSlots(); i++) {
                ItemStack stack = playerItems.getStackInSlot(i);
                if (ItemStack.isSameItemSameTags(stack, required)) {
                    // 使用ItemStack.matches()方法确保tag和count都匹配
                    if (stack.getCount() >= needed) {
                        found = needed;
                        break;
                    } else {
                        found += stack.getCount();
                        if (found >= needed) break;
                    }
                }
            }

            if (found < needed) return false;
        }
        return true;
    }

    // 消耗材料
    void consumeMaterials(Inventory playerInventory) {
        if (!hasValidBackingEntity() || currentRecipe == null) return;

        ItemStack[] requiredMaterials = getMaterialsFromRecipe(currentRecipe);
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

    // 修正槽位数量为10（9个输入槽 + 1个输出槽）
    private static final int TE_INVENTORY_SLOT_COUNT = 10;

    // 快速移动物品
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        if (!hasValidBackingEntity() || pIndex < 0 || pIndex >= slots.size()) return ItemStack.EMPTY;
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;
        if (sourceSlot instanceof ReadOnlySlot) return ItemStack.EMPTY;
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        if (pIndex >= TE_INVENTORY_FIRST_SLOT_INDEX
                && pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            if (pIndex != TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT - 1) {
                return ItemStack.EMPTY;
            }
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

    // 检查界面是否仍然有效
    @Override
    public boolean stillValid(Player player) {
        return hasValidBackingEntity() && stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ChangShengJueBlocks.FORGE_BLOCK.get());
    }

    public boolean hasValidBackingEntity() {
        return this.backingEntityValid
                && MenuBlockEntityResolver.isWorldBackingValid(
                this.level, this.blockEntity, ChangShengJueBlocks.FORGE_BLOCK.get());
    }

    // 获取方块位置
    public BlockPos getBlockPos() {
        return blockEntity.getBlockPos();
    }

    // 添加玩家物品栏
    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 89 + l * 18, 115 + i * 18));
            }
        }
    }

    // 添加玩家快捷栏
    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 89 + i * 18, 173));
        }
    }

    // 只读槽位
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

    // 输出槽位
    public static class OutputSlot extends SlotItemHandler {
        private final BooleanSupplier backingEntityValid;

        public OutputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            this(itemHandler, index, xPosition, yPosition, () -> true);
        }

        public OutputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition,
                          BooleanSupplier backingEntityValid) {
            super(itemHandler, index, xPosition, yPosition);
            this.backingEntityValid = backingEntityValid;
        }

        @Override
        public boolean mayPlace(ItemStack stack) {
            return false; // 输出槽不接受输入
        }

        @Override
        public boolean mayPickup(Player playerIn) {
            return this.backingEntityValid.getAsBoolean();
        }
    }

    // 配方类
    public static class ForgeRecipe {
        private final ItemStack result;
        private final ItemStack[] materials;

        public ForgeRecipe(ItemStack result, ItemStack... materials) {
            this.result = result;
            this.materials = materials;
        }

        public ItemStack getResult() {
            return result.copy();
        }

        public ItemStack[] getMaterials() {
            return Arrays.stream(materials).map(ItemStack::copy).toArray(ItemStack[]::new);
        }

        // NBT序列化
        public CompoundTag serializeNBT() {
            CompoundTag tag = new CompoundTag();
            tag.put("result", result.serializeNBT());

            ListTag materialsList = new ListTag();
            for (ItemStack material : materials) {
                materialsList.add(material.serializeNBT());
            }
            tag.put("materials", materialsList);

            return tag;
        }

        // NBT反序列化
        public static ForgeRecipe deserializeNBT(CompoundTag tag) {
            ItemStack result = ItemStack.of(tag.getCompound("result"));
            ListTag materialsList = tag.getList("materials", Tag.TAG_COMPOUND);

            ItemStack[] materials = new ItemStack[materialsList.size()];
            for (int i = 0; i < materialsList.size(); i++) {
                materials[i] = ItemStack.of(materialsList.getCompound(i));
            }

            return new ForgeRecipe(result, materials);
        }
    }

    /**
     * 检查玩家是否拥有指定材料的足够数量
     * @param playerInventory 玩家背包
     * @param required 所需材料
     * @return 若数量充足返回true，否则返回false
     */
    public boolean hasEnoughOfMaterial(Inventory playerInventory, ItemStack required) {
        if (!hasValidBackingEntity()) return false;
        if (required.isEmpty()) return true; // 空材料默认充足

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
}
