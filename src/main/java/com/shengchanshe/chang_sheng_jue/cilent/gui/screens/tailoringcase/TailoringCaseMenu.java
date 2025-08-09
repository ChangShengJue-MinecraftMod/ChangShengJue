package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.tailoringcase;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase.TailoringCaseEntity;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.ChangShengJueMenuTypes;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.recipe.TailoringCaseRecipe;
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

public class TailoringCaseMenu extends AbstractContainerMenu {
    public final TailoringCaseEntity blockEntity;
    private final Level level;
    public final ContainerData data;
    TailoringCaseRecipe currentRecipe = null;

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

    public TailoringCaseRecipe getCurrentRecipe() {
        // 优先使用菜单中的配方，如果没有则从方块实体获取
        if (this.currentRecipe != null) {
            return this.currentRecipe;
        }
        if (blockEntity != null) {
            return blockEntity.getCurrentRecipe();
        }
        return null;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        // 只有不在制作中时才清除
        if(!isCrafting()) {
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

    public void setCurrentRecipe(TailoringCaseRecipe recipe) {
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
            ItemStack[] materials = getMaterialsFromRecipe(currentRecipe);
            // 将材料放入对应的槽位
            for (int i = 0; i < materials.length && i < 9; i++) {
                final int slotIndex = i;
                ItemStack material = materials[i].copy();
                // 在客户端只更新显示，在服务端更新实际的物品处理器
                blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
                    handler.insertItem(slotIndex, material, false);
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


    boolean hasEnoughMaterials(Inventory playerInventory) {
        if (currentRecipe == null) return false;

        IItemHandler playerItems = new InvWrapper(playerInventory);
        ItemStack[] requiredMaterials = getMaterialsFromRecipe(currentRecipe);

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

    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
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

            ListTag materialsList = new ListTag();
            for (ItemStack material : materials) {
                materialsList.add(material.serializeNBT());
            }
            tag.put("materials", materialsList);

            return tag;
        }

        // 用于NBT反序列化
        public static TailoringRecipe deserializeNBT(CompoundTag tag) {
            ItemStack result = ItemStack.of(tag.getCompound("result"));
            ListTag materialsList = tag.getList("materials", Tag.TAG_COMPOUND);

            ItemStack[] materials = new ItemStack[materialsList.size()];
            for (int i = 0; i < materialsList.size(); i++) {
                materials[i] = ItemStack.of(materialsList.getCompound(i));
            }

            return new TailoringRecipe(result, materials);
        }
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

    /**
     * 从配方中获取材料示例物品（用于UI显示）
     * @param recipe 配方对象
     * @return 材料物品数组
     */
    public ItemStack[] getMaterialsFromRecipe(TailoringCaseRecipe recipe) {
        ItemStack[] materials = new ItemStack[recipe.getIngredients().size()];
        for (int i = 0; i < recipe.getIngredients().size(); i++) {
            ItemStack[] items = recipe.getIngredients().get(i).getItems();
            if (items.length > 0) {
                // 直接使用ingredient中的物品，它已经包含了正确的数量
                materials[i] = items[0].copy();
            } else {
                materials[i] = ItemStack.EMPTY;
            }
        }
        return materials;
    }

    // 优化配方存储结构
    public static final Map<ResourceLocation, TailoringRecipe> RECIPE_MAP = new HashMap<>();
    public static final List<TailoringRecipe> RECIPES = new ArrayList<>();

    public static void registerRecipe(TailoringRecipe recipe) {
        ResourceLocation key = new ResourceLocation(
                ForgeRegistries.ITEMS.getKey(recipe.result.getItem()).toString() + "_" + recipe.result.getCount()
        );

        if (!RECIPE_MAP.containsKey(key)) {
            RECIPE_MAP.put(key, recipe);
            RECIPES.add(recipe);
        }
    }

    public static Optional<TailoringRecipe> findRecipe(ItemStack result) {
        if (result.isEmpty()) return Optional.empty();

        ResourceLocation key = new ResourceLocation(
                ForgeRegistries.ITEMS.getKey(result.getItem()).toString() + "_" + result.getCount()
        );
        return Optional.ofNullable(RECIPE_MAP.get(key));
    }

    // 静态初始化块 - 在这里添加配方
    static {
        // 四方巾
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.MALE_TAOIST_HELMET.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 5)
                )
        );

        // 道服
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.MALE_TAOIST_CHESTPLATE.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 8)
                )
        );

        // 丝裳
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.TAOIST_LEGGINGS.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 7)
                )
        );

        // 丝履
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.TAOIST_BOOTS.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 4)
                )
        );

        // 道袍
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.FEMALE_TAOIST_CHESTPLATE.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 8)
                )
        );

        // 麒麟补服
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_KYLIN_BUFU.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 7),
                        new ItemStack(Items.GOLD_INGOT, 1)
                )
        );

        // 金丝履
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.CHINESE_WEDDING_DRESS_GOLDEN_THREAD_SHOES.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 2),
                        new ItemStack(Items.GOLD_INGOT, 2)
                )
        );

        // 袆衣
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_QUEEN_CLOTHING.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 7),
                        new ItemStack(Items.GOLD_INGOT, 1)
                )
        );

        // 棉盔(白翎)
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.WHITE_COTTON_HELMET.get()),
                        new ItemStack(Items.LEATHER, 2),
                        new ItemStack(ChangShengJueItems.COTTON.get(), 2),
                        new ItemStack(ChangShengJueItems.WHITE_PEACOCK_FEATHERS.get(), 1)
                )
        );

        // 棉盔(彩翎)
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.COTTON_HELMET.get()),
                        new ItemStack(Items.LEATHER, 2),
                        new ItemStack(ChangShengJueItems.COTTON.get(), 2),
                        new ItemStack(ChangShengJueItems.PEACOCK_FEATHERS.get(), 1)
                )
        );

        // 棉甲
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.COTTON_CHESTPLATE.get()),
                        new ItemStack(Items.LEATHER, 4),
                        new ItemStack(ChangShengJueItems.COTTON.get(), 4)
                )
        );

        // 棉护腿
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.COTTON_LEGGINGS.get()),
                        new ItemStack(Items.LEATHER, 4),
                        new ItemStack(ChangShengJueItems.COTTON.get(), 3)
                )
        );

        // 棉靴
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.COTTON_BOOTS.get()),
                        new ItemStack(Items.LEATHER, 2),
                        new ItemStack(ChangShengJueItems.COTTON.get(), 2)
                )
        );

        // 鹿皮胫甲
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.MOUNTAIN_PATTERN_DEERSKIN_TIBIAL_ARMOR.get()),
                        new ItemStack(Items.IRON_INGOT, 5),
                        new ItemStack(Items.LEATHER, 2)
                )
        );

        // 云头乌皮靴
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.MOUNTAIN_PATTERN_CLOUD_BLACK_BOOTS.get()),
                        new ItemStack(Items.IRON_INGOT, 2),
                        new ItemStack(Items.LEATHER, 2)
                )
        );


        // 行者装
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.WALKER_CHESTPLATE.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 6),
                        new ItemStack(Items.LAPIS_LAZULI, 1),
                        new ItemStack(Items.IRON_INGOT, 1)
                )
        );

        // 虎皮裙
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.WALKER_TIGER_SKIN_SKIRT.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 5),
                        new ItemStack(ChangShengJueItems.TIGER_SKIN.get(), 2)
                )
        );

        // 短靴
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.WALKER_SHORT_BOOTS.get()),
                        new ItemStack(Items.LEATHER, 2),
                        new ItemStack(Items.IRON_INGOT, 2)
                )
        );

        // 云纱冠
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.FLY_FISH_CLOUD_VEIL_CROWN.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 5)
                )
        );

        // 飞鱼服
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.FLY_FISH_CHESTPLATE.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 7),
                        new ItemStack(Items.GOLD_INGOT, 1),
                        new ItemStack(ChangShengJueItems.CROC_SKIN.get(), 1)
                )
        );

        // 长靴
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.FLY_FISH_LONG_BOOTS.get()),
                        new ItemStack(ChangShengJueItems.CROC_SKIN.get(), 1),
                        new ItemStack(Items.IRON_INGOT, 3)
                )
        );

        // 皮内甲
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.LEATHER_INNER_ARMOR.get()),
                        new ItemStack(ChangShengJueItems.CROC_SKIN.get(), 8)));

        // 儒装
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.CONFUCIAN_HELMET.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 4),
                        new ItemStack(Items.DIAMOND, 1)));
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.CONFUCIAN_INK_CHESTPLATE.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 7),
                        new ItemStack(Items.EMERALD, 1)));
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.CONFUCIAN_INK_LEGGINGS.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 7)));
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.CONFUCIAN_INK_BOOTS.get()),
                        new ItemStack(ChangShengJueItems.SILK.get(), 3)));

        // 兽皮靴
        registerRecipe(
                new TailoringRecipe(
                        new ItemStack(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_ANIMAL_SKIN_BOOTS.get()),
                        new ItemStack(Items.LEATHER, 2),
                        new ItemStack(ChangShengJueItems.CROC_SKIN.get(), 2)
                )
        );
    }
}