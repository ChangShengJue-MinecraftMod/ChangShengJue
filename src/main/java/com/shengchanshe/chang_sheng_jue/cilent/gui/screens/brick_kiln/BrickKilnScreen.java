package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.brick_kiln;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.button.TexturedButtonWithText;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.BrickKilnPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.BrickKilnSetAmountPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.BrickKilnSyncRecipePacket;
import com.shengchanshe.chang_sheng_jue.recipe.BrickKilnRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

import java.util.*;

public class BrickKilnScreen extends AbstractContainerScreen<BrickKilnMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/brick_kiln_menu.png");
    private static final ResourceLocation BOTTON = new ResourceLocation(ChangShengJue.MOD_ID,"textures/gui/botton.png");

    // 界面常量
    private static final int VISIBLE_ROWS = 8;
    private static final int CAROUSEL_INTERVAL = 20;

    private final List<CustomButton> customButtons = new ArrayList<>();
    private final List<ItemStack> currentMaterials = new ArrayList<>();
    private final Map<String, List<BrickKilnRecipe>> recipesByGroup = new HashMap<>();

    private List<BrickKilnRecipe> cachedRecipes = new ArrayList<>();
    private List<BrickKilnRecipe> currentRecipeGroup = new ArrayList<>();

    private ItemStack currentSelectedItem = ItemStack.EMPTY;
//    private ArmorStand armorStandEntity;
    private TexturedButtonWithText craftButton;
    private BrickKilnRecipe localCurrentRecipe = null;

    // 数量选择相关
    private TexturedButtonWithText decreaseButton;
    private TexturedButtonWithText increaseButton;
    private TexturedButtonWithText batchDecreaseButton;
    private TexturedButtonWithText batchIncreaseButton;

    // 材料缓存和状态跟踪
    private int lastCraftTimes = 1;
    private BrickKilnRecipe lastRecipe = null;

    private float rotation = 0;
    private int scrollOffset = 0;
    private int carouselTick = 0;
    private int currentRecipeIndex = 0;

    private boolean isDragging = false;
    private boolean isCarouselPaused = false;
    private int scrollBarHeight = 0;
    private int scrollBarY = 0;
    private int scrollBarX = 0;

    public BrickKilnScreen(BrickKilnMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
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

        BrickKilnRecipe serverRecipe = menu.getCurrentRecipe();
        if (serverRecipe != null || menu.isCrafting()) {
            currentMaterials.clear();
            ItemStack[] materials = getMaterialsFromRecipe(serverRecipe);
            if (materials != null) {
                currentMaterials.addAll(Arrays.asList(materials));
            }
            currentSelectedItem = serverRecipe.getResultItem(getRegistryAccess());
        }

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        // 创建减少按钮
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
                    ChangShengJueMessages.sendToServer(new BrickKilnPacket(menu.getBlockPos()));
                    isCarouselPaused = true;
                    carouselTick = 0;
                },
                Component.translatable("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.craft"),0xFFFFFF,0xFFFFFF,1.0F,true
        ));

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

            ChangShengJueMessages.sendToServer(new BrickKilnSetAmountPacket(menu.getBlockPos(), newTimes));

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

            ChangShengJueMessages.sendToServer(new BrickKilnSetAmountPacket(menu.getBlockPos(), newTimes));

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

            ChangShengJueMessages.sendToServer(new BrickKilnSetAmountPacket(menu.getBlockPos(), newTimes));

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

            ChangShengJueMessages.sendToServer(new BrickKilnSetAmountPacket(menu.getBlockPos(), newTimes));

            updateTimesButtons();
            updateMaterialsDisplay();
        }
    }
    // 更新按钮状态
    private void updateTimesButtons() {
        int currentTimes = menu.getCraftTimes();

        // 单个增减按钮
        decreaseButton.active = currentTimes > 1 && !menu.isCrafting();
        increaseButton.active = currentTimes < 64 && !menu.isCrafting();

        // 批量增减按钮
        batchDecreaseButton.active = currentTimes > 4 && !menu.isCrafting();
        batchIncreaseButton.active = currentTimes <= 60 && !menu.isCrafting(); // 64-4=60
    }
    // 更新材料显示
    private void updateMaterialsDisplay() {
        if (localCurrentRecipe != null) {
            currentMaterials.clear();
            // 使用总材料进行显示
            ItemStack[] materials = menu.getMaterialsFromRecipe(localCurrentRecipe);
            if (materials != null) {
                currentMaterials.addAll(Arrays.asList(materials));

//                // 调试：检查材料数量
//                if (!currentMaterials.isEmpty() && !currentMaterials.get(0).isEmpty()) {
//                    System.out.println("材料显示更新 - 单次需求: " +
//                            menu.getSingleMaterialsFromRecipe(localCurrentRecipe)[0].getCount() +
//                            ", 制作次数: " + menu.getCraftTimes() +
//                            ", 总需求: " + currentMaterials.get(0).getCount());
//                }
            }
        }
    }

    private void refreshRecipes() {
        if (minecraft != null && minecraft.level != null) {
            try {
                var recipeManager = minecraft.level.getRecipeManager();
                var recipeType = BrickKilnRecipe.Type.INSTANCE;
                cachedRecipes = recipeManager.getAllRecipesFor(recipeType);

                recipesByGroup.clear();
                for (BrickKilnRecipe recipe : cachedRecipes) {
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
    }

    private void refreshItemButtons() {
        ItemStack previouslySelectedItem = currentSelectedItem.copy();

        for (CustomButton button : customButtons) {
            this.removeWidget(button);
        }
        customButtons.clear();

        int row = 0;
        int col = 0;
        int startIndex = scrollOffset * 5;
        int maxScrollOffset = Math.max(0, (cachedRecipes.size() + 4) / 5 - VISIBLE_ROWS);

        if (scrollOffset > maxScrollOffset) {
            scrollOffset = maxScrollOffset;
        }

        List<ItemStack> addedItems = new ArrayList<>();
        for (int i = startIndex; i < cachedRecipes.size() && row < VISIBLE_ROWS; i++) {
            BrickKilnRecipe recipe = cachedRecipes.get(i);
            ItemStack resultItem = recipe.getResultItem(getRegistryAccess());

            boolean alreadyAdded = false;
            for (ItemStack addedItem : addedItems) {
                if (ItemStack.isSameItemSameTags(addedItem, resultItem)) {
                    alreadyAdded = true;
                    break;
                }
            }

            if (!alreadyAdded) {
                addedItems.add(resultItem);
                createButton(col, row, resultItem, recipe);

                col++;
                if (col >= 5) {
                    col = 0;
                    row++;
                }
            }
        }

        if (cachedRecipes.isEmpty()) {
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

    private void createButton(int x, int y, ItemStack item, BrickKilnRecipe recipe) {
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

    private void updateSlotsForSelectedItem(BrickKilnRecipe recipe) {
        if (menu.isCrafting()) {
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

        updateMaterialsDisplay();

        ChangShengJueMessages.sendToServer(new BrickKilnSyncRecipePacket(menu.getBlockPos(), recipe));
        menu.updateRecipeSlots();
    }

    private void updateSlotsForCraftingRecipe(BrickKilnRecipe recipe) {
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

        updateMaterialsDisplay();

        ChangShengJueMessages.sendToServer(new BrickKilnSyncRecipePacket(menu.getBlockPos(), recipe));
        menu.updateRecipeSlots();
    }

    private RegistryAccess getRegistryAccess() {
        return minecraft.level.registryAccess();
    }

    // 获取材料方法 - 确保始终显示最终材料
    private ItemStack[] getMaterialsFromRecipe(BrickKilnRecipe recipe) {
        if (recipe == null) {
            return new ItemStack[0];
        }

        // 确保使用总材料方法
        return menu.getMaterialsFromRecipe(recipe);
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

        // 渲染材料槽位背景
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int slotIndex = row * 3 + col;
                int slotX = x + 112 + col * 18;
                int slotY = y + 45 + row * 18;

                if (slotIndex < currentMaterials.size()) {
                    ItemStack required = currentMaterials.get(slotIndex);
                    if (!required.isEmpty()) {
                        boolean isMaterialEnough = menu.hasEnoughOfMaterial(minecraft.player.getInventory(), required);
                        int textureV = isMaterialEnough ? 217 : 235;
                        guiGraphics.blit(TEXTURE, slotX, slotY, 18, textureV, 18, 18, 512, 512);
                    }
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
        int maxScrollOffset = Math.max(0, (cachedRecipes.size() + 4) / 5 - VISIBLE_ROWS);
        float scrollProgress = maxScrollOffset > 0 ? (float) scrollOffset / maxScrollOffset : 0;
        int sliderHeight = Math.max(15, (int) (VISIBLE_ROWS * 1.0f / Math.max(1, (cachedRecipes.size() + 4) / 5) * scrollBarHeight));
        int sliderY = scrollBarY + (int) (scrollProgress * (scrollBarHeight - sliderHeight));

        int scrollerTextureV = isDragging ? 6 : 0;
        guiGraphics.blit(TEXTURE, scrollBarX+1, sliderY, scrollerTextureV, 271, 6, 15, 512, 512);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        int maxScrollOffset = Math.max(0, (cachedRecipes.size() + 4) / 5 - VISIBLE_ROWS);

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
        int maxScrollOffset = Math.max(0, (cachedRecipes.size() + 4) / 5 - VISIBLE_ROWS);
        if (maxScrollOffset > 0) {
            float scrollProgress = maxScrollOffset > 0 ? (float) scrollOffset / maxScrollOffset : 0;
            int sliderHeight = Math.max(15, (int) (VISIBLE_ROWS * 1.0f / Math.max(1, (cachedRecipes.size() + 4) / 5) * scrollBarHeight));
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
        int maxScrollOffset = Math.max(0, (cachedRecipes.size() + 4) / 5 - VISIBLE_ROWS);
        if (maxScrollOffset <= 0) return;

        float scrollSensitivity = 0.2f;
        float relativeY = (float) (mouseY - scrollBarY) / (scrollBarHeight * scrollSensitivity);
        relativeY = Math.max(0, Math.min(1, relativeY));

        scrollOffset = (int) (relativeY * maxScrollOffset);
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

        for (CustomButton button : customButtons) {
            if (button.isHovered() && !button.getItemStack().isEmpty()) {
                renderToolTip(guiGraphics, mouseX, mouseY, button.getItemStack());
            }
        }
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    public void containerTick() {
        super.containerTick();

        // 检查制作次数是否变化
        int currentTimes = menu.getCraftTimes();
        if (currentTimes != lastCraftTimes) {
            lastCraftTimes = currentTimes;
            if (localCurrentRecipe != null) {
                updateMaterialsDisplay();
            }
        }

        // 检查当前配方是否变化
        BrickKilnRecipe currentRecipe = menu.getCurrentRecipe();
        if (currentRecipe != lastRecipe) {
            lastRecipe = currentRecipe;
            if (currentRecipe != null) {
                this.localCurrentRecipe = currentRecipe;
                updateMaterialsDisplay();
            }
        }

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
                    updateSlotsForSelectedItem(currentRecipeGroup.get(currentRecipeIndex));
                }
            }
        }

        if (menu.isCrafting()) {
            carouselTick = 0;

            BrickKilnRecipe blockEntityRecipe = menu.blockEntity.getCurrentRecipe();
            if (blockEntityRecipe != null && localCurrentRecipe != blockEntityRecipe) {
                updateSlotsForCraftingRecipe(blockEntityRecipe);
            } else if (localCurrentRecipe != null) {
                updateSlotsForCraftingRecipe(localCurrentRecipe);
            }
        }
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
                    if (slotIndex < currentMaterials.size()) {
                        ItemStack required = currentMaterials.get(slotIndex);
                        if (!required.isEmpty()) {
                            guiGraphics.renderTooltip(font, required, x, y);
                        }
                    }
                }
            }
        }

        // 次数显示区域的工具提示
//        int timesX = guiLeft + 190;
//        int timesY = guiTop + 85;
//        if (x >= timesX && x < timesX + 40 && y >= timesY && y < timesY + 20) {
//            guiGraphics.renderTooltip(font, Component.translatable("gui." + ChangShengJue.MOD_ID + ".wood_working_bench.craft_times"), x, y);
//        }
    }

    private void renderCustomProgressBar(GuiGraphics guiGraphics, int x, int y) {
        int progressBarX = x + 169;
        int progressBarY = y + 57;
        int progressBarWidth = 32;
        int progressBarHeight = 24;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        guiGraphics.blit(TEXTURE, progressBarX, progressBarY,
                0, 310, progressBarWidth, progressBarHeight, 512, 512);

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

    @Override
    public void mouseMoved(double mouseX, double mouseY) {
        super.mouseMoved(mouseX, mouseY);
    }

    private class CustomButton extends Button {
        private ItemStack itemStack;
        private static final int TEXTURE_Y_NORMAL = 217;
        private static final int TEXTURE_Y_PRESS = 235;
        int COUNT = 0;
        private BrickKilnRecipe recipe;
        private float alpha = 1.0f;

        protected CustomButton(int pX, int pY, int pWidth, int pHeight, Component pMessage, OnPress pOnPress,
                               ItemStack itemStack, BrickKilnRecipe recipe) {
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

                if (!itemStack.isEmpty() && isAir(this.getX(),this.getY(),mouseX,mouseY)) {
                    renderToolTip(guiGraphics, mouseX, mouseY, displayStack);
                }

                if (craftButton != null) {
                    boolean isCrafting = menu.isCrafting();
                    craftButton.active = !isCrafting;
                    craftButton.visible = !isCrafting;
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

    private boolean isAir(int guix,int guiy,int mouseX, int mouseY) {
        return mouseX >= guix && mouseX < guix + 18 && mouseY >= guiy && mouseY < guiy + 18;
    }

    private void renderToolTip(GuiGraphics guiGraphics, int mouseX, int mouseY, ItemStack stack) {
        int tooltipX = mouseX + 10;
        int tooltipY = mouseY + 10;
        guiGraphics.renderTooltip(font, stack, tooltipX, tooltipY);
    }
}