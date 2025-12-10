package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.workbench;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.button.TexturedButtonWithText;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.WoodworkingBenchPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.WoodworkingBenchSetAmountPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.WoodworkingBenchSyncRecipePacket;
import com.shengchanshe.chang_sheng_jue.recipe.WoodworkingBenchRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.*;

public class WoodworkingBenchScreen extends AbstractContainerScreen<WoodworkingBenchMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/wood_working_bench_menu.png");
    private static final ResourceLocation BOTTON = new ResourceLocation(ChangShengJue.MOD_ID,"textures/gui/botton.png");

    // 界面常量
    private static final int VISIBLE_ROWS = 8;
    private static final int CAROUSEL_INTERVAL = 20;

    // 分类常量
    private static final String[] CATEGORIES = {"all", "da_mu_zuo", "xiao_mu_zuo", "chen_she", "furniture"};
    private static final String CATEGORY_KEY_PREFIX = "gui." + ChangShengJue.MOD_ID + ".wood_working_bench.category.";

    private final List<CustomButton> customButtons = new ArrayList<>();
    private final Map<String, List<WoodworkingBenchRecipe>> recipesByGroup = new HashMap<>();

    // 分类相关
    private final List<TexturedButtonWithText> categoryButtons = new ArrayList<>();
    private String currentCategory = "all"; // 当前选中的分类
    private List<WoodworkingBenchRecipe> filteredRecipes = new ArrayList<>(); // 过滤后的配方列表
    private int uniqueItemCount = 0; // 去重后的物品数量（用于滚动条计算）

    private List<WoodworkingBenchRecipe> cachedRecipes = new ArrayList<>();
    private List<WoodworkingBenchRecipe> currentRecipeGroup = new ArrayList<>();

    private ItemStack currentSelectedItem = ItemStack.EMPTY;
    private TexturedButtonWithText craftButton;
    private WoodworkingBenchRecipe localCurrentRecipe = null;

    // 数量选择相关
    private TexturedButtonWithText decreaseButton;
    private TexturedButtonWithText increaseButton;
    private TexturedButtonWithText batchDecreaseButton;
    private TexturedButtonWithText batchIncreaseButton;

    // 材料缓存和状态跟踪
    private int lastCraftTimes = 1;
    private WoodworkingBenchRecipe lastRecipe = null;

    // 材料充足状态缓存
    private boolean[] materialSufficiencyCache;
    private boolean materialCacheValid = false;

    // 材料tag轮播相关
    private int[] materialCarouselIndex;
    private int materialCarouselTick = 0;
    private static final int MATERIAL_CAROUSEL_INTERVAL = 30;

    // 制作时使用的实际材料
    private ItemStack[] craftingMaterials;

    private int scrollOffset = 0;
    private int carouselTick = 0;
    private int currentRecipeIndex = 0;

    private boolean isDragging = false;
    private boolean isCarouselPaused = false;
    private int scrollBarHeight = 0;
    private int scrollBarY = 0;
    private int scrollBarX = 0;

    public WoodworkingBenchScreen(WoodworkingBenchMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        imageWidth = 276;
        imageHeight = 216;
    }

    @Override
    protected void init() {
        super.init();
        customButtons.clear();
        scrollOffset = 0;
        refreshRecipes();
        refreshItemButtons();

        WoodworkingBenchRecipe serverRecipe = menu.getCurrentRecipe();
        if (serverRecipe != null || menu.isCrafting()) {
            currentSelectedItem = serverRecipe.getResultItem(getRegistryAccess());
            localCurrentRecipe = serverRecipe;
            materialCarouselIndex = new int[serverRecipe.getIngredientCount()];
            materialCarouselTick = 0;
        }

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.decreaseButton = this.addRenderableWidget(new TexturedButtonWithText(
                x + 120, y + 101, 9, 9,
                18, 141, 9,
                BOTTON, 256, 256,
                button -> decreaseCraftTimes(),
                Component.empty(),0xFFFFFF,0xFFFFFF,1.0F
        ));
        this.batchDecreaseButton = this.addRenderableWidget(new TexturedButtonWithText(
                x + 110, y + 101, 9, 9,
                0, 141, 9,
                BOTTON, 256, 256,
                button -> batchDecreaseCraftTimes(),
                Component.empty(),0xFFFFFF,0xFFFFFF,1.0F
        ));
        // 创建增加按钮
        this.increaseButton = this.addRenderableWidget(new TexturedButtonWithText(
                x + 150, y + 101, 9, 9,
                27, 141, 9,
                BOTTON, 256, 256,
                button -> increaseCraftTimes(),
                Component.empty(),0xFFFFFF,0xFFFFFF,1.0F,true
        ));
        this.batchIncreaseButton = this.addRenderableWidget(new TexturedButtonWithText(
                x + 160, y + 101, 9, 9,
                9, 141, 9,
                BOTTON, 256, 256,
                button -> batchIncreaseCraftTimes(),
                Component.empty(),0xFFFFFF,0xFFFFFF,1.0F,true
        ));

        this.craftButton = this.addRenderableWidget(new TexturedButtonWithText(
                x + 192, y + 95, 55, 17,
                0, 106, 17,
                BOTTON, 256, 256,
                button -> {
                    ChangShengJueMessages.sendToServer(new WoodworkingBenchPacket(menu.getBlockPos()));
                    isCarouselPaused = true;
                    carouselTick = 0;
                },
                Component.translatable("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.craft"),0xFFFFFF,0xFFFFFF,1.0F,true
        ));

        // 创建分类按钮
        createCategoryButtons(x, y);

        updateTimesButtons();

        // 初始化状态跟踪
        lastCraftTimes = menu.getCraftTimes();
        lastRecipe = menu.getCurrentRecipe();
    }

    // 减少制作次数
    private void decreaseCraftTimes() {
        int currentTimes = menu.getCraftTimes();
        if (currentTimes > 1 && !menu.isCrafting()) {
            int newTimes = currentTimes - 1;
            menu.setCraftTimes(newTimes);
            lastCraftTimes = newTimes;

            ChangShengJueMessages.sendToServer(new WoodworkingBenchSetAmountPacket(menu.getBlockPos(), newTimes));

            updateTimesButtons();
            updateMaterialsDisplay();
        }
    }
    private void batchDecreaseCraftTimes() {
        int currentTimes = menu.getCraftTimes();
        if (currentTimes > 1 && !menu.isCrafting()) {
            int newTimes = Math.max(1, currentTimes - 4);
            menu.setCraftTimes(newTimes);
            lastCraftTimes = newTimes;

            ChangShengJueMessages.sendToServer(new WoodworkingBenchSetAmountPacket(menu.getBlockPos(), newTimes));

            updateTimesButtons();
            updateMaterialsDisplay();
        }
    }
    // 增加制作次数
    private void increaseCraftTimes() {
        int currentTimes = menu.getCraftTimes();
        if (currentTimes < 64 && !menu.isCrafting()) {
            int newTimes = currentTimes + 1;
            menu.setCraftTimes(newTimes);
            lastCraftTimes = newTimes;

            ChangShengJueMessages.sendToServer(new WoodworkingBenchSetAmountPacket(menu.getBlockPos(), newTimes));

            updateTimesButtons();
            updateMaterialsDisplay();
        }
    }
    private void batchIncreaseCraftTimes() {
        int currentTimes = menu.getCraftTimes();
        if (currentTimes < 64 && !menu.isCrafting()) {
            int newTimes = Math.min(64, currentTimes + 4);
            menu.setCraftTimes(newTimes);
            lastCraftTimes = newTimes;

            ChangShengJueMessages.sendToServer(new WoodworkingBenchSetAmountPacket(menu.getBlockPos(), newTimes));

            updateTimesButtons();
            updateMaterialsDisplay();
        }
    }
    // 更新按钮状态
    private void updateTimesButtons() {
        int currentTimes = menu.getCraftTimes();
        boolean isCrafting = menu.isCrafting();

        boolean canDecrease = currentTimes > 1;
        decreaseButton.active = canDecrease;
        decreaseButton.visible = canDecrease;

        boolean canIncrease = currentTimes < 64 || !isCrafting;
        increaseButton.active = canIncrease;
        increaseButton.visible = canIncrease;

        // 批量增减按钮
        boolean canBatchDecrease = currentTimes > 4;
        batchDecreaseButton.active = canBatchDecrease;
        batchDecreaseButton.visible = canBatchDecrease;

        boolean canBatchIncrease = currentTimes <= 60 || !isCrafting;
        batchIncreaseButton.active = canBatchIncrease;
        batchIncreaseButton.visible = canBatchIncrease;
    }

    // 创建分类按钮
    private void createCategoryButtons(int guiX, int guiY) {
        categoryButtons.clear();

        int buttonWidth = 37;
        int buttonHeight = 26;
        int buttonX = guiX - 56; // 在物品列表左侧
        int startY = guiY + 45; // 与物品列表顶部对齐
        int buttonSpacing = 30; // 按钮间距

        // 每个分类对应的代表物品
        ItemStack[] categoryIcons = {
                new ItemStack(ChangShengJueBlocks.WOOD_WORKING_BENCH.get()),
                new ItemStack(ChangShengJueBlocks.OAK_DOUGONG.get()),
                new ItemStack(ChangShengJueBlocks.OAK_BALUSTRADE.get()),
                new ItemStack(ChangShengJueBlocks.OAK_FOLDING_SCREEN.get()),
                new ItemStack(ChangShengJueBlocks.OAK_WINE_TABLE.get())
        };

        for (int i = 0; i < CATEGORIES.length; i++) {
            String category = CATEGORIES[i];
            int buttonY = startY + i * buttonSpacing;

            TexturedButtonWithText categoryButton = new TexturedButtonWithText(
                    buttonX, buttonY, buttonWidth, buttonHeight,
                    0, 160, buttonHeight,
                    BOTTON, 256, 256,
                    button -> onCategoryButtonClicked(category),
                    Component.empty(), 0x000, 0x000, 1.0F, 1.0F, 1.0F, 1.0F
            );

            // 设置分类对应的物品图标
            categoryButton.setItemIcon(categoryIcons[i])
                    .setItemIconScale(1.0F)
                    .setItemIconPosition(TexturedButtonWithText.IconPosition.CENTER);

            this.addRenderableWidget(categoryButton);
            categoryButtons.add(categoryButton);
        }

        updateCategoryButtonStates();
    }

    // 分类按钮点击事件
    private void onCategoryButtonClicked(String category) {
        if (menu.isCrafting()) return; // 制作中不允许切换分类

        currentCategory = category;
        scrollOffset = 0;
        filterRecipesByCategory();
        refreshItemButtons();
        updateCategoryButtonStates();
    }

    // 更新分类按钮状态
    private void updateCategoryButtonStates() {
        for (int i = 0; i < categoryButtons.size() && i < CATEGORIES.length; i++) {
            TexturedButtonWithText button = categoryButtons.get(i);
            boolean isSelected = CATEGORIES[i].equals(currentCategory);
            button.active = !menu.isCrafting();
        }
    }

    // 根据分类过滤配方
    private void filterRecipesByCategory() {
        if ("all".equals(currentCategory)) {
            filteredRecipes = new ArrayList<>(cachedRecipes);
        } else {
            filteredRecipes = new ArrayList<>();
            for (WoodworkingBenchRecipe recipe : cachedRecipes) {
                String group = recipe.getGroup();
                // 根据group字段判断配方属于哪个分类
                if (matchesCategory(group, currentCategory)) {
                    filteredRecipes.add(recipe);
                }
            }
        }

        // 计算去重后的物品数量（用于滚动条）
        updateUniqueItemCount();
    }

    // 计算去重后的物品数量
    private void updateUniqueItemCount() {
        List<ItemStack> uniqueItems = new ArrayList<>();
        for (WoodworkingBenchRecipe recipe : filteredRecipes) {
            ItemStack resultItem = recipe.getResultItem(getRegistryAccess());
            boolean alreadyAdded = false;
            for (ItemStack item : uniqueItems) {
                if (ItemStack.isSameItemSameTags(item, resultItem)) {
                    alreadyAdded = true;
                    break;
                }
            }
            if (!alreadyAdded) {
                uniqueItems.add(resultItem);
            }
        }
        uniqueItemCount = uniqueItems.size();
    }

    // 判断配方的group是否匹配当前分类
    private boolean matchesCategory(String group, String category) {
        if (group == null || group.isEmpty()) {
            return false;
        }
        // group字段格式: "分类:子分组" 或直接 "分类"
        String lowerGroup = group.toLowerCase();
        // 只匹配以分类名开头的group（精确匹配分类前缀）
        return lowerGroup.equals(category) || lowerGroup.startsWith(category + ":");
    }

    /**
     * 获取当前分类的最大滚动偏移量
     */
    private int getMaxScrollOffset() {
        return Math.max(0, (uniqueItemCount + 4) / 5 - VISIBLE_ROWS);
    }

    /**
     * 获取滚动条滑块高度
     */
    private int getSliderHeight() {
        int totalRows = Math.max(1, (uniqueItemCount + 4) / 5);
        return Math.max(15, (int) (VISIBLE_ROWS * 1.0f / totalRows * scrollBarHeight));
    }

    // 更新材料显示
    private void updateMaterialsDisplay() {
        if (localCurrentRecipe != null) {
            materialCacheValid = false;
            materialCarouselIndex = new int[localCurrentRecipe.getIngredientCount()];
            materialCarouselTick = 0;
        }
    }

    // 更新材料显示但不重置轮播索引
    private void updateMaterialsDisplayWithoutResetCarousel() {
        if (localCurrentRecipe != null) {
            materialCacheValid = false;
            if (materialCarouselIndex == null || materialCarouselIndex.length != localCurrentRecipe.getIngredientCount()) {
                materialCarouselIndex = new int[localCurrentRecipe.getIngredientCount()];
                materialCarouselTick = 0;
            }
        }
    }

    /**
     * 更新材料充足状态缓存
     */
    private void updateMaterialSufficiencyCache() {
        if (materialCacheValid || minecraft == null || minecraft.player == null || localCurrentRecipe == null) {
            return;
        }

        int size = localCurrentRecipe.getIngredientCount();
        if (materialSufficiencyCache == null || materialSufficiencyCache.length != size) {
            materialSufficiencyCache = new boolean[size];
        }

        var ingredients = localCurrentRecipe.getIngredients();
        int[] requiredCounts = localCurrentRecipe.getCachedRequiredCounts();
        int craftTimes = menu.getCraftTimes();

        for (int i = 0; i < size && i < ingredients.size(); i++) {
            var ingredient = ingredients.get(i);
            if (ingredient.isEmpty()) {
                materialSufficiencyCache[i] = true;
                continue;
            }
            int needed = (i < requiredCounts.length ? requiredCounts[i] : 1) * craftTimes;
            int found = 0;
            var playerInventory = minecraft.player.getInventory();
            for (int j = 0; j < playerInventory.getContainerSize(); j++) {
                ItemStack stack = playerInventory.getItem(j);
                if (!stack.isEmpty() && ingredient.test(stack)) {
                    found += stack.getCount();
                    if (found >= needed) break;
                }
            }
            materialSufficiencyCache[i] = found >= needed;
        }
        materialCacheValid = true;
    }

    /**
     * 检查指定槽位材料是否充足
     */
    private boolean isMaterialSufficient(int slotIndex) {
        if (!materialCacheValid) {
            updateMaterialSufficiencyCache();
        }
        if (materialSufficiencyCache != null && slotIndex < materialSufficiencyCache.length) {
            return materialSufficiencyCache[slotIndex];
        }
        return true;
    }

    /**
     * 缓存制作时实际使用的材料类型
     * 在制作开始时调用，记录每个槽位实际使用的材料物品类型
     */
    private void cacheCraftingMaterials() {
        if (localCurrentRecipe == null || minecraft == null || minecraft.player == null) {
            craftingMaterials = null;
            return;
        }

        var ingredients = localCurrentRecipe.getIngredients();
        craftingMaterials = new ItemStack[ingredients.size()];
        var playerInventory = minecraft.player.getInventory();

        for (int i = 0; i < ingredients.size(); i++) {
            var ingredient = ingredients.get(i);
            craftingMaterials[i] = ItemStack.EMPTY;

            if (ingredient.isEmpty()) continue;

            // 查找背包中第一个匹配的物品类型
            for (int j = 0; j < playerInventory.getContainerSize(); j++) {
                ItemStack stack = playerInventory.getItem(j);
                if (!stack.isEmpty() && ingredient.test(stack)) {
                    craftingMaterials[i] = new ItemStack(stack.getItem());
                    break;
                }
            }
        }
    }

    /**
     * 获取指定槽位当前应显示的材料物品
     */
    private ItemStack getDisplayMaterialForSlot(int slotIndex) {
        if (localCurrentRecipe == null || slotIndex >= localCurrentRecipe.getIngredientCount()) {
            return ItemStack.EMPTY;
        }

        var ingredients = localCurrentRecipe.getIngredients();
        if (slotIndex >= ingredients.size()) {
            return ItemStack.EMPTY;
        }

        var ingredient = ingredients.get(slotIndex);

        ItemStack[] items = getItemsForIngredient(ingredient);

        if (items.length == 0) {
            return ItemStack.EMPTY;
        }

        int craftTimes = menu.getCraftTimes();
        int[] requiredCounts = localCurrentRecipe.getCachedRequiredCounts();
        int baseCount = slotIndex < requiredCounts.length ? requiredCounts[slotIndex] : 1;

        // 如果正在制作，优先使用缓存的材料类型
        if (menu.isCrafting()) {
            if (craftingMaterials != null && slotIndex < craftingMaterials.length
                    && !craftingMaterials[slotIndex].isEmpty()) {
                ItemStack displayStack = craftingMaterials[slotIndex].copy();
                displayStack.setCount(baseCount * craftTimes);
                return displayStack;
            }
        }

        int carouselIdx = 0;
        if (materialCarouselIndex != null && slotIndex < materialCarouselIndex.length) {
            carouselIdx = materialCarouselIndex[slotIndex] % items.length;
        }

        ItemStack displayStack = items[carouselIdx].copy();
        displayStack.setCount(baseCount * craftTimes);

        return displayStack;
    }

    /**
     * 获取Ingredient对应的所有物品
     */
    private ItemStack[] getItemsForIngredient(Ingredient ingredient) {
        int count = 1;
        String tagId = null;

        if (ingredient instanceof WoodworkingBenchRecipe.CountedIngredient counted) {
            count = counted.requiredCount;
            tagId = counted.tagId;
        }

        if (tagId != null && minecraft != null && minecraft.level != null) {
            ResourceLocation tagLocation = new ResourceLocation(tagId);
            TagKey<Item> tag = TagKey.create(Registries.ITEM, tagLocation);
            List<ItemStack> items = new ArrayList<>();
            final int finalCount = count;

            var registry = minecraft.level.registryAccess().registryOrThrow(Registries.ITEM);
            registry.getTagOrEmpty(tag).forEach(holder -> {
                ItemStack stack = new ItemStack(holder.value());
                stack.setCount(finalCount);
                items.add(stack);
            });

            if (!items.isEmpty()) {
                return items.toArray(new ItemStack[0]);
            }
        }
        return ingredient.getItems();
    }

    private void refreshRecipes() {
        if (minecraft != null && minecraft.level != null) {
            try {
                var recipeManager = minecraft.level.getRecipeManager();
                var recipeType = WoodworkingBenchRecipe.Type.INSTANCE;
                cachedRecipes = new ArrayList<>(recipeManager.getAllRecipesFor(recipeType));

                // 按配方ID排序，确保每次显示顺序一致
                // 首先按group分组排序
                // 同组内按配方ID排序
                cachedRecipes.sort(Comparator.comparing(WoodworkingBenchRecipe::getGroup).thenComparing(a -> a.getId().toString()));

                recipesByGroup.clear();
                for (WoodworkingBenchRecipe recipe : cachedRecipes) {
                    String group = recipe.getGroup();
                    if (!group.isEmpty()) {
                        recipesByGroup.computeIfAbsent(group, k -> new ArrayList<>()).add(recipe);
                    }
                }
            } catch (Exception e) {
                cachedRecipes = new ArrayList<>();
                recipesByGroup.clear();
                e.printStackTrace();
            }
        } else {
            cachedRecipes.clear();
            recipesByGroup.clear();
        }

        // 根据当前分类过滤配方
        filterRecipesByCategory();
    }

    private void refreshItemButtons() {
        ItemStack previouslySelectedItem = currentSelectedItem.copy();

        for (CustomButton button : customButtons) {
            this.removeWidget(button);
        }
        customButtons.clear();

        // 先构建去重后的物品列表和对应配方
        List<ItemStack> uniqueItems = new ArrayList<>();
        List<WoodworkingBenchRecipe> uniqueRecipes = new ArrayList<>();
        for (WoodworkingBenchRecipe recipe : filteredRecipes) {
            ItemStack resultItem = recipe.getResultItem(getRegistryAccess());
            boolean alreadyAdded = false;
            for (ItemStack item : uniqueItems) {
                if (ItemStack.isSameItemSameTags(item, resultItem)) {
                    alreadyAdded = true;
                    break;
                }
            }
            if (!alreadyAdded) {
                uniqueItems.add(resultItem);
                uniqueRecipes.add(recipe);
            }
        }

        // 同步更新 uniqueItemCount，确保与渲染一致
        uniqueItemCount = uniqueItems.size();

        int maxScrollOffset = getMaxScrollOffset();

        if (scrollOffset > maxScrollOffset) {
            scrollOffset = maxScrollOffset;
        }

        int startIndex = scrollOffset * 5;
        int row = 0;
        int col = 0;

        for (int i = startIndex; i < uniqueItems.size() && row < VISIBLE_ROWS; i++) {
            createButton(col, row, uniqueItems.get(i), uniqueRecipes.get(i));
            col++;
            if (col >= 5) {
                col = 0;
                row++;
            }
        }

        if (filteredRecipes.isEmpty() && cachedRecipes.isEmpty()) {
            refreshRecipes();
        }

        if (!previouslySelectedItem.isEmpty()) {
            for (CustomButton button : customButtons) {
                if (ItemStack.isSameItemSameTags(button.itemStack, previouslySelectedItem)) {
                    button.COUNT = 1;
                    break;
                }
            }
        }
    }

    private void createButton(int x, int y, ItemStack item, WoodworkingBenchRecipe recipe) {
        int centerX = (width - imageWidth) / 2 - 13 + x * 18;
        int centerY = (height - imageHeight) / 2 + 45 + y * 18;

        CustomButton button = new CustomButton(
                centerX,
                centerY,
                18,
                18,
                Component.literal(" "),
                (button1) -> {
                    for (CustomButton btn : customButtons) {
                        btn.COUNT = 0;
                    }
                    ((CustomButton) button1).COUNT = 1;
                    currentSelectedItem = ((CustomButton) button1).itemStack;

                    String group = recipe.getGroup();
                    if (!group.isEmpty() && recipesByGroup.containsKey(group)) {
                        currentRecipeGroup = new ArrayList<>(recipesByGroup.get(group));
                        currentRecipeIndex = currentRecipeGroup.indexOf(recipe);
                    } else {
                        currentRecipeGroup.clear();
                        currentRecipeIndex = 0;
                    }

                    updateSlotsForSelectedItem(recipe);
                },
                item,
                recipe
        );

        button.active = !menu.isCrafting();
        button.setAlpha(menu.isCrafting() ? 0.5f : 1.0f);

        addRenderableWidget(button);
        customButtons.add(button);
    }

    /**
     * 统一的配方更新方法
     * @param recipe 要设置的配方
     * @param checkCrafting 是否检查制作状态（true则制作中不更新）
     * @param resetCarousel 是否重置材料轮播索引
     */
    private void updateRecipeSlots(WoodworkingBenchRecipe recipe, boolean checkCrafting, boolean resetCarousel) {
        if (checkCrafting && menu.isCrafting()) {
            return;
        }

        String group = recipe.getGroup();
        if (!group.isEmpty() && recipesByGroup.containsKey(group)) {
            currentRecipeGroup = new ArrayList<>(recipesByGroup.get(group));
            currentRecipeIndex = currentRecipeGroup.indexOf(recipe);
        } else {
            currentRecipeGroup.clear();
            currentRecipeIndex = 0;
        }

        menu.setCurrentRecipe(recipe);
        this.localCurrentRecipe = recipe;
        this.lastRecipe = recipe;

        if (resetCarousel) {
            updateMaterialsDisplay();
        } else {
            updateMaterialsDisplayWithoutResetCarousel();
        }

        ChangShengJueMessages.sendToServer(new WoodworkingBenchSyncRecipePacket(menu.getBlockPos(), recipe));
        menu.updateRecipeSlots();
    }

    private void updateSlotsForSelectedItem(WoodworkingBenchRecipe recipe) {
        updateRecipeSlots(recipe, true, true);
    }

    private void updateSlotsForRecipeGroupCarousel(WoodworkingBenchRecipe recipe) {
        updateRecipeSlots(recipe, true, false);
    }

    private void updateSlotsForCraftingRecipe(WoodworkingBenchRecipe recipe) {
        updateRecipeSlots(recipe, false, true);
    }

    private RegistryAccess getRegistryAccess() {
        return minecraft.level.registryAccess();
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(TEXTURE, x - 20, y - 20, 0, 0, imageWidth, imageHeight, 512, 512);
        renderCustomProgressBar(guiGraphics, x, y);

        scrollBarX = x - 13 + 5 * 18;
        scrollBarY = y + 45;
        scrollBarHeight = VISIBLE_ROWS * 18;

        // 渲染材料槽位背景（使用缓存的材料充足状态）
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int slotIndex = row * 3 + col;
                int slotX = x + 112 + col * 18;
                int slotY = y + 45 + row * 18;

                // 使用轮播显示的材料来判断
                ItemStack required = getDisplayMaterialForSlot(slotIndex);
                if (!required.isEmpty()) {
                    boolean isMaterialEnough = isMaterialSufficient(slotIndex);
                    int textureV = isMaterialEnough ? 217 : 235;
                    guiGraphics.blit(TEXTURE, slotX, slotY, 18, textureV, 18, 18, 512, 512);
                }
            }
        }

        // 渲染次数显示
        String timesText = String.valueOf(menu.getCraftTimes());
        int textWidth = font.width(timesText);
        int textX = x + 140 - textWidth / 2;
        int textY = y + 103;
        guiGraphics.drawString(font, timesText, textX, textY, 0x404040, false);

        // 渲染滚动条
        int maxScrollOffset = getMaxScrollOffset();
        float scrollProgress = maxScrollOffset > 0 ? (float) scrollOffset / maxScrollOffset : 0;
        int sliderHeight = getSliderHeight();
        int sliderY = scrollBarY + (int) (scrollProgress * (scrollBarHeight - sliderHeight));

        int scrollerTextureV = isDragging ? 6 : 0;
        guiGraphics.blit(TEXTURE, scrollBarX+1, sliderY, scrollerTextureV, 271, 6, 15, 512, 512);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        int maxScrollOffset = getMaxScrollOffset();

        if (delta > 0 && scrollOffset > 0) {
            scrollOffset--;
            refreshItemButtons();
            return true;
        } else if (delta < 0 && scrollOffset < maxScrollOffset) {
            scrollOffset++;
            refreshItemButtons();
            return true;
        }
        return super.mouseScrolled(mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int maxScrollOffset = getMaxScrollOffset();
        if (maxScrollOffset > 0) {
            float scrollProgress = maxScrollOffset > 0 ? (float) scrollOffset / maxScrollOffset : 0;
            int sliderHeight = getSliderHeight();
            int sliderY = scrollBarY + (int) (scrollProgress * (scrollBarHeight - sliderHeight));

            if (mouseX >= scrollBarX && mouseX <= scrollBarX + 6 &&
                    mouseY >= sliderY && mouseY <= sliderY + sliderHeight) {
                isDragging = true;
                return true;
            }

            if (mouseX >= scrollBarX && mouseX <= scrollBarX + 6 &&
                    mouseY >= scrollBarY && mouseY <= scrollBarY + scrollBarHeight) {
                float clickProgress = (float) (mouseY - scrollBarY) / scrollBarHeight;
                int newScrollOffset = Math.round(clickProgress * maxScrollOffset);
                scrollOffset = Math.max(0, Math.min(maxScrollOffset, newScrollOffset));
                refreshItemButtons();
                return true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (isDragging) {
            updateScrollFromMousePos(mouseY);
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    private void updateScrollFromMousePos(double mouseY) {
        int maxScrollOffset = getMaxScrollOffset();
        if (maxScrollOffset <= 0) return;

        // 计算滑块高度
        int sliderHeight = getSliderHeight();
        // 计算可滑动区域
        int scrollableHeight = scrollBarHeight - sliderHeight;
        if (scrollableHeight <= 0) return;

        // 根据鼠标位置计算滚动进度
        float relativeY = (float) (mouseY - scrollBarY - sliderHeight / 2.0f) / scrollableHeight;
        relativeY = Math.max(0, Math.min(1, relativeY));

        scrollOffset = Math.round(relativeY * maxScrollOffset);
        scrollOffset = Math.max(0, Math.min(scrollOffset, maxScrollOffset));
        refreshItemButtons();
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (isDragging) {
            isDragging = false;
            return true;
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    protected void renderLabels(GuiGraphics transform, int x, int y) {
        boolean isChinese = Minecraft.getInstance().options.languageCode.startsWith("zh_");
        if (!isChinese) {
            int fontWidth = this.font.width(Component.translatable(ChangShengJueBlocks.WOOD_WORKING_BENCH.get().getDescriptionId()));
            int k = 25 + this.imageWidth / 2 - fontWidth / 2;
            transform.drawString(this.font, Component.translatable(ChangShengJueBlocks.WOOD_WORKING_BENCH.get().getDescriptionId()), k, 35, 0x404040, false);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);

        // 渲染轮播的材料物品（覆盖槽位中的显示）
        renderCarouselMaterials(guiGraphics);

        for (CustomButton button : customButtons) {
            if (!button.getItemStack().isEmpty() && isMouseInArea(button.getX(), button.getY(), mouseX, mouseY)) {
                renderToolTip(guiGraphics, mouseX, mouseY, button.getItemStack());
                break;
            }
        }
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    /**
     * 渲染轮播的材料物品
     */
    private void renderCarouselMaterials(GuiGraphics guiGraphics) {
        if (localCurrentRecipe == null) return;

        int guiLeft = (width - imageWidth) / 2;
        int guiTop = (height - imageHeight) / 2;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int slotIndex = row * 3 + col;
                int slotX = guiLeft + 112 + col * 18 + 1; // +1 是槽位内边距
                int slotY = guiTop + 45 + row * 18 + 1;

                ItemStack displayStack = getDisplayMaterialForSlot(slotIndex);
                if (!displayStack.isEmpty()) {
                    // 渲染物品
                    guiGraphics.renderItem(displayStack, slotX, slotY);
                    // 渲染物品数量
                    guiGraphics.renderItemDecorations(font, displayStack, slotX, slotY);
                }
            }
        }
    }

    @Override
    public void containerTick() {
        super.containerTick();

        // 检测制作状态变化，缓存/清除制作材料
        if (menu.isCrafting() && craftingMaterials == null) {
            cacheCraftingMaterials();
        } else if (!menu.isCrafting() && craftingMaterials != null) {
            craftingMaterials = null;
        }

        // 每10 tick刷新一次材料充足状态缓存
        if (carouselTick % 10 == 0) {
            materialCacheValid = false;
        }

        // 材料tag轮播逻辑
        if (localCurrentRecipe != null && materialCarouselIndex != null) {
            materialCarouselTick++;
            if (materialCarouselTick >= MATERIAL_CAROUSEL_INTERVAL) {
                materialCarouselTick = 0;
                var ingredients = localCurrentRecipe.getIngredients();
                for (int i = 0; i < materialCarouselIndex.length && i < ingredients.size(); i++) {
                    // 使用getItemsForIngredient而不是ingredient.getItems()
                    ItemStack[] items = getItemsForIngredient(ingredients.get(i));
                    if (items.length > 1) {
                        // 只有当tag有多个物品时才轮播
                        materialCarouselIndex[i] = (materialCarouselIndex[i] + 1) % items.length;
                    }
                }
            }
        }

        // 检查制作次数是否变化
        int currentTimes = menu.getCraftTimes();
        if (currentTimes != lastCraftTimes) {
            lastCraftTimes = currentTimes;
            if (localCurrentRecipe != null) {
                updateMaterialsDisplayWithoutResetCarousel();
            }
        }
        updateTimesButtons();

        // 检查当前配方是否变化（使用ID比较而不是对象引用）
        WoodworkingBenchRecipe currentRecipe = menu.getCurrentRecipe();
        boolean recipeChanged = false;
        if (currentRecipe == null && lastRecipe != null) {
            recipeChanged = true;
        } else if (currentRecipe != null && lastRecipe == null) {
            recipeChanged = true;
        } else if (currentRecipe != null && lastRecipe != null) {
            // 使用配方ID比较
            recipeChanged = !currentRecipe.getId().equals(lastRecipe.getId());
        }

        if (recipeChanged) {
            lastRecipe = currentRecipe;
            if (currentRecipe != null) {
                this.localCurrentRecipe = currentRecipe;
                updateMaterialsDisplay();
            }
        }

        // 更新合成按钮状态
        updateCraftButtonState();

        // 轮播逻辑
        if (!currentRecipeGroup.isEmpty() && !menu.isCrafting() && !isCarouselPaused) {
            carouselTick++;
            if (carouselTick >= CAROUSEL_INTERVAL) {
                carouselTick = 0;
                currentRecipeIndex = (currentRecipeIndex + 1) % currentRecipeGroup.size();

                CustomButton selectedButton = null;
                for (CustomButton btn : customButtons) {
                    if (btn.COUNT == 1) {
                        selectedButton = btn;
                        break;
                    }
                }

                if (selectedButton != null &&
                        !selectedButton.itemStack.isEmpty() &&
                        !currentRecipeGroup.isEmpty() &&
                        ItemStack.isSameItemSameTags(selectedButton.itemStack,
                                currentRecipeGroup.get(currentRecipeIndex).getResultItem(getRegistryAccess()))) {
                    // 使用不重置材料轮播索引的方法，避免材料轮播被配方组轮播打断
                    updateSlotsForRecipeGroupCarousel(currentRecipeGroup.get(currentRecipeIndex));
                }
            }
        } else {
            carouselTick++;
        }

        if (menu.isCrafting()) {
            carouselTick = 0;

            WoodworkingBenchRecipe blockEntityRecipe = menu.blockEntity.getCurrentRecipe();
            if (blockEntityRecipe != null && localCurrentRecipe != blockEntityRecipe) {
                updateSlotsForCraftingRecipe(blockEntityRecipe);
            } else if (localCurrentRecipe != null) {
                updateSlotsForCraftingRecipe(localCurrentRecipe);
            }
        }
    }

    /**
     * 更新合成按钮状态
     */
    private void updateCraftButtonState() {
        if (craftButton == null) return;

        boolean isCrafting = menu.isCrafting();

        craftButton.active = !isCrafting;
        craftButton.visible = !isCrafting;
    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int x, int y) {
        super.renderTooltip(guiGraphics, x, y);

        int guiLeft = (width - imageWidth) / 2;
        int guiTop = (height - imageHeight) / 2;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int slotIndex = row * 3 + col;
                int slotX = guiLeft + 112 + col * 18;
                int slotY = guiTop + 45 + row * 18;

                if (x >= slotX && x < slotX + 18 && y >= slotY && y < slotY + 18) {
                    // 使用轮播显示的材料
                    ItemStack required = getDisplayMaterialForSlot(slotIndex);
                    if (!required.isEmpty()) {
                        guiGraphics.renderTooltip(font, required, x, y);
                    }
                }
            }
        }

        // 渲染分类按钮的tooltip
        for (int i = 0; i < categoryButtons.size() && i < CATEGORIES.length; i++) {
            TexturedButtonWithText button = categoryButtons.get(i);
            if (button.isHovered()) {
                Component categoryName = Component.translatable(CATEGORY_KEY_PREFIX + CATEGORIES[i]);
                guiGraphics.renderTooltip(font, categoryName, x, y);
                break;
            }
        }
    }

    private void renderCustomProgressBar(GuiGraphics guiGraphics, int x, int y) {
        int progressBarX = x + 169;
        int progressBarY = y + 64;
        int progressBarWidth = 32;
        int progressBarHeight = 16;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        guiGraphics.blit(TEXTURE, progressBarX, progressBarY,
                0, 302, progressBarWidth, progressBarHeight, 512, 512);

        if (menu.isCrafting()) {
            int scaledProgress = menu.getScaledProgress();
            guiGraphics.blit(TEXTURE, progressBarX, progressBarY,
                    0, 286, scaledProgress + 5, progressBarHeight, 512, 512);
        }
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 258 && !currentRecipeGroup.isEmpty()) {
            isCarouselPaused = true;
            carouselTick = 0;
            currentRecipeIndex = (currentRecipeIndex + 1) % currentRecipeGroup.size();
            updateSlotsForSelectedItem(currentRecipeGroup.get(currentRecipeIndex));
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    private static class CustomButton extends Button {
        private final ItemStack itemStack;
        private static final int TEXTURE_Y_NORMAL = 217;
        private static final int TEXTURE_Y_PRESS = 235;
        int COUNT = 0;
        private final WoodworkingBenchRecipe recipe;
        private float alpha = 1.0f;

        protected CustomButton(int pX, int pY, int pWidth, int pHeight, Component pMessage, OnPress pOnPress,
                               ItemStack itemStack, WoodworkingBenchRecipe recipe) {
            super(pX, pY, pWidth, pHeight, pMessage, pOnPress, Button.DEFAULT_NARRATION);
            this.itemStack = itemStack;
            this.recipe = recipe;
        }

        @Override
        public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
            if (this.visible) {
                int textureY = this.COUNT == 1 ? TEXTURE_Y_PRESS : TEXTURE_Y_NORMAL;

                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, alpha);
                RenderSystem.setShaderTexture(0, TEXTURE);
                guiGraphics.blit(TEXTURE, this.getX(), this.getY(),
                        0, textureY, 18, 18, 512, 512);

                // 渲染物品前重置颜色
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

                ItemStack displayStack = itemStack.copy();
                guiGraphics.renderItem(displayStack, this.getX() + 1, this.getY() + 1);
                // 渲染物品数量（如果数量大于1）
                if (displayStack.getCount() > 1) {
                    guiGraphics.renderItemDecorations(Minecraft.getInstance().font, displayStack, this.getX() + 1, this.getY() + 1);
                }
            }
        }

        @Override
        public boolean isHoveredOrFocused() {
            return this.COUNT == 1 || super.isHoveredOrFocused();
        }

        public ItemStack getItemStack() {
            return itemStack;
        }

        public void setAlpha(float alpha) {
            this.alpha = alpha;
        }
    }

    private boolean isMouseInArea(int guix,int guiy,int mouseX, int mouseY) {
        return mouseX >= guix && mouseX < guix + 18 && mouseY >= guiy && mouseY < guiy + 18;
    }

    private void renderToolTip(GuiGraphics guiGraphics, int mouseX, int mouseY, ItemStack stack) {
        int tooltipX = mouseX + 10;
        int tooltipY = mouseY + 10;
        guiGraphics.renderTooltip(font, stack, tooltipX, tooltipY);
    }
}