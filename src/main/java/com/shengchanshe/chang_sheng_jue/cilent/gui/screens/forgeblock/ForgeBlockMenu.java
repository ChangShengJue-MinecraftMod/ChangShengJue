package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.forgeblock;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.custom.forgeblock.ForgeBlockEntity;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.ChangShengJueMenuTypes;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
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
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class ForgeBlockMenu extends AbstractContainerMenu {

    public final ForgeBlockEntity blockEntity;
    private final Level level;
    public final ContainerData data;
    ForgeRecipe currentRecipe = null;

    public ForgeBlockMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
    }

    public ForgeBlockMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ChangShengJueMenuTypes.FORGE_BLOCK_MENU.get(), pContainerId);
        checkContainerSize(inv, 10);
        blockEntity = ((ForgeBlockEntity) entity);
        this.level = inv.player.level();
        this.data = data;

        // 从实体加载当前配方
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

    public ForgeRecipe getCurrentRecipe() {
        return currentRecipe;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
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

    public void setCurrentRecipe(ForgeRecipe recipe) {
        this.currentRecipe = recipe;
        updateRecipeSlots();

        // 只有服务端才更新实体
        if (!level.isClientSide) {
            blockEntity.setCurrentRecipe(recipe);
            blockEntity.setChanged(); // 标记区块需要保存
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

    public boolean craftItem(Player player) {
        if (currentRecipe == null || level.isClientSide()) {
            return false;
        }

        // 检查输出槽是否有物品
        if (!blockEntity.getItemHandler().getStackInSlot(ForgeBlockEntity.SLOT_OUTPUT).isEmpty()) {
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

    // 修正槽位数量为10（9个输入槽 + 1个输出槽）
    private static final int TE_INVENTORY_SLOT_COUNT = 10;

    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // 检查点击的槽位是否是玩家物品栏
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // 从玩家物品栏移动到锻台
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX,
                    TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
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
                player, ChangShengJueBlocks.FORGE_BLOCK.get());
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

        // NBT序列化（与缝纫台一致）
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

        // NBT反序列化（与缝纫台一致）
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

    // 优化配方存储结构（与缝纫台一致）
    public static final Map<ResourceLocation, ForgeRecipe> RECIPE_MAP = new HashMap<>();
    public static final List<ForgeRecipe> RECIPES = new ArrayList<>();

    public static void registerRecipe(ForgeRecipe recipe) {
        ResourceLocation key = new ResourceLocation(
                ForgeRegistries.ITEMS.getKey(recipe.result.getItem()).toString() + "_" + recipe.result.getCount()
        );

        if (!RECIPE_MAP.containsKey(key)) {
            RECIPE_MAP.put(key, recipe);
            RECIPES.add(recipe);
        }
    }

    public static Optional<ForgeRecipe> findRecipe(ItemStack result) {
        if (result.isEmpty()) return Optional.empty();

        ResourceLocation key = new ResourceLocation(
                ForgeRegistries.ITEMS.getKey(result.getItem()).toString() + "_" + result.getCount()
        );
        return Optional.ofNullable(RECIPE_MAP.get(key));
    }

    // 静态初始化块 - 在这里添加配方
    static {
        // 添加配方（使用registerRecipe方法注册）
        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.FEMALE_TAOIST_HELMET.get()),
                        new ItemStack(Items.IRON_INGOT, 3),
                        new ItemStack(Items.GOLD_INGOT, 2)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_BLACK_GAUZE_CAP.get()),
                        new ItemStack(Items.IRON_INGOT, 5)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_PHOENIX_CORONET.get()),
                        new ItemStack(Items.GOLD_INGOT, 3),
                        new ItemStack(Items.LAPIS_LAZULI, 3),
                        new ItemStack(Items.REDSTONE, 1)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.MOUNTAIN_PATTERN_HELMET_GUN_HOOD.get()),
                        new ItemStack(Items.IRON_INGOT, 2),
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(Items.GOLD_INGOT, 1),
                        new ItemStack(Items.COPPER_INGOT, 1)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR.get()),
                        new ItemStack(Items.IRON_INGOT, 4),
                        new ItemStack(Items.GOLD_INGOT, 1),
                        new ItemStack(Items.COPPER_INGOT, 3)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.WALKER_GOLD_RING_BAND.get()),
                        new ItemStack(Items.GOLD_INGOT, 3)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_PHOENIX_WINGS_HELMET.get()),
                        new ItemStack(Items.IRON_INGOT, 1),
                        new ItemStack(Items.GOLD_INGOT, 1),
                        new ItemStack(Items.COPPER_INGOT, 3)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LIGHT_CHESTPLATE.get()),
                        new ItemStack(Items.IRON_INGOT, 4),
                        new ItemStack(Items.GOLD_INGOT, 3),
                        new ItemStack(Items.COPPER_INGOT, 1)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LAZULI_KNEE_PADS.get()),
                        new ItemStack(Items.LEATHER, 5),
                        new ItemStack(Items.LAPIS_LAZULI, 2)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.FLY_FISH_IRON_HAT.get()),
                        new ItemStack(Items.IRON_INGOT, 4),
                        new ItemStack(Items.GOLD_INGOT, 1)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.WALKER_GREEN_TREASURE_PENDANT.get()),
                        new ItemStack(ChangShengJueItems.AG_INGOT.get(),2),
                        new ItemStack(Items.EMERALD, 1)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.GOLD_SILK_SOFT_ARMOR.get()),
                        new ItemStack(Items.GOLD_INGOT, 6)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.BRONZE_SWORD.get()),
                        new ItemStack(Items.COPPER_INGOT,2),
                        new ItemStack(Items.STICK,2)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.HAN_JIAN.get()),
                        new ItemStack(Items.COPPER_INGOT,1),
                        new ItemStack(Items.IRON_INGOT,2)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.HENG_DAO.get()),
                        new ItemStack(Items.COPPER_INGOT,1),
                        new ItemStack(Items.IRON_INGOT,2)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.LARGE_KNIFE.get()),
                        new ItemStack(Items.GOLD_INGOT,1),
                        new ItemStack(Items.IRON_INGOT,2)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.RED_TASSELLED_SPEAR.get()),
                        new ItemStack(Items.IRON_INGOT,1),
                        new ItemStack(Items.RED_WOOL,1),
                        new ItemStack(Items.STICK,1)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.THROWING_KNIVES.get()),
                        new ItemStack(Items.IRON_INGOT,1),
                        new ItemStack(Items.LEATHER,1)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.SOFT_SWORD.get()),
                        new ItemStack(Items.IRON_INGOT,1),
                        new ItemStack(Items.STRING,1),
                        new ItemStack(Items.STICK,1)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.PAN_HUA_GUN.get()),
                        new ItemStack(Items.COPPER_INGOT,1),
                        new ItemStack(Items.OAK_LOG,1)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.KITCHEN_KNIFE.get()),
                        new ItemStack(Items.IRON_INGOT,1),
                        new ItemStack(Items.STICK,1)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.GOLD_THREAD_GLOVE.get()),
                        new ItemStack(Items.GOLD_INGOT,1),
                        new ItemStack(Items.LEATHER,1)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.KAISHAN_PICKAXE.get()),
                        new ItemStack(Items.IRON_INGOT,3),
                        new ItemStack(Items.COPPER_INGOT,2)
                )
        );

        registerRecipe(
                new ForgeRecipe(
                        new ItemStack(ChangShengJueItems.XUANHUA_AXE.get()),
                        new ItemStack(Items.IRON_INGOT,3),
                        new ItemStack(Items.COPPER_INGOT,2)
                )
        );
    }

    /**
     * 检查玩家是否拥有指定材料的足够数量
     * @param playerInventory 玩家背包
     * @param required 所需材料
     * @return 若数量充足返回true，否则返回false
     */
    public boolean hasEnoughOfMaterial(Inventory playerInventory, ItemStack required) {
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