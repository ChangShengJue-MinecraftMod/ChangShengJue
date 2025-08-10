package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.forgeblock;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.*;
import com.shengchanshe.chang_sheng_jue.recipe.ForgeBlockRecipe;
import com.shengchanshe.chang_sheng_jue.recipe.CSJRecipeTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.core.RegistryAccess;
import org.joml.Quaternionf;

import java.util.*;

public class ForgeBlockScreen extends AbstractContainerScreen<ForgeBlockMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/forge_block_menu.png");
    private final List<CustomButton> customButtons = new ArrayList<>();
    private ItemStack currentSelectedItem = ItemStack.EMPTY;
    private ArmorStand armorStandEntity;
    private float rotation = 0;
    private Button craftButton;

    private int scrollOffset = 0;
    private static final int VISIBLE_ROWS = 8;
    private static final int TOTAL_ROWS = 10;
    private boolean isDragging = false;
    private int scrollBarHeight = 0;
    private int scrollBarY = 0;
    private int scrollBarX = 0;
    private final List<ItemStack> currentMaterials = new ArrayList<>();
    private List<ForgeBlockRecipe> cachedRecipes = new ArrayList<>();
    
    // 添加配方轮播相关变量
    private final Map<String, List<ForgeBlockRecipe>> recipesByGroup = new HashMap<>();
    private int currentRecipeIndex = 0;
    private int carouselTick = 0;
    private static final int CAROUSEL_INTERVAL = 20; // 1秒(20tick)切换一次
    private boolean isCarouselPaused = false;
    private List<ForgeBlockRecipe> currentRecipeGroup = new ArrayList<>();
    private ForgeBlockRecipe localCurrentRecipe = null;

    public ForgeBlockScreen(ForgeBlockMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        imageWidth = 276;
        imageHeight = 216;
    }

    // 初始化界面
    @Override
    protected void init() {
        super.init();
        customButtons.clear();
        scrollOffset = 0;
        createArmorStandEntity();
        refreshRecipes();
        refreshItemButtons();

        ForgeBlockRecipe serverRecipe = menu.getCurrentRecipe();

        //如果处于制作状态
        if (serverRecipe != null || menu.isCrafting()) {
            currentMaterials.clear();
            currentMaterials.addAll(Arrays.asList(getMaterialsFromRecipe(serverRecipe)));
            currentSelectedItem = serverRecipe.getResultItem(getRegistryAccess());
        }

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        craftButton = Button.builder(Component.translatable("gui."+ ChangShengJue.MOD_ID + ".forge_block.craft"), button -> {
                    // 发送制作请求到服务端
                    ChangShengJueMessages.sendToServer(
                            new ForgeCraftPacket(menu.getBlockPos())
                    );
                    
                    // 立即停止轮播
                    isCarouselPaused = true;
                    carouselTick = 0;
                })
                .bounds(x + 200, y + 95, 35, 15)
                .build();

        addRenderableWidget(craftButton);
    }

    // 刷新配方列表
    private void refreshRecipes() {
        if (minecraft != null && minecraft.level != null) {
            try {
                var recipeManager = minecraft.level.getRecipeManager();
                var recipeType = ForgeBlockRecipe.Type.INSTANCE;
                cachedRecipes = recipeManager.getAllRecipesFor(recipeType);
                
                // 按组分类配方
                recipesByGroup.clear();
                for (ForgeBlockRecipe recipe : cachedRecipes) {
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

    // 刷新配方按钮
    private void refreshItemButtons() {
        // 保存当前选中的物品
        ItemStack previouslySelectedItem = currentSelectedItem.copy();
        
        // 移除旧按钮
        for (CustomButton button : customButtons) {
            this.removeWidget(button);
        }
        customButtons.clear();

        int row = 0;
        int col = 0;

        // 计算起始索引：已滚动的行数 × 每行的按钮数（5个）
        int startIndex = scrollOffset * 5;
        
        // 计算最大滚动偏移
        int maxScrollOffset = Math.max(0, (cachedRecipes.size() + 4) / 5 - VISIBLE_ROWS);
        
        // 确保滚动偏移在有效范围内
        if (scrollOffset > maxScrollOffset) {
            scrollOffset = maxScrollOffset;
        }
        
        // 使用List来跟踪已经添加的物品，避免重复
        List<ItemStack> addedItems = new ArrayList<>();
        
        // 遍历配方，从起始索引开始
        for (int i = startIndex; i < cachedRecipes.size() && row < VISIBLE_ROWS; i++) {
            ForgeBlockRecipe recipe = cachedRecipes.get(i);
            ItemStack resultItem = recipe.getResultItem(getRegistryAccess());

            // 检查此物品是否已经添加过
            boolean alreadyAdded = false;
            for (ItemStack addedItem : addedItems) {
                if (ItemStack.isSameItemSameTags(addedItem, resultItem)) {
                    alreadyAdded = true;
                    break;
                }
            }
            
            // 如果尚未添加此物品，则创建按钮
            if (!alreadyAdded) {
                addedItems.add(resultItem);
                // 创建按钮
                createButton(col, row, resultItem, recipe);

                // 每行5个按钮
                col++;
                if (col >= 5) {
                    col = 0;
                    row++;
                }
            }
        }
        
        // 如果没有任何配方，也尝试刷新一次配方
        if (cachedRecipes.isEmpty()) {
            refreshRecipes();
        }
        
        // 恢复之前选中的按钮状态
        if (!previouslySelectedItem.isEmpty()) {
            for (CustomButton button : customButtons) {
                if (ItemStack.isSameItemSameTags(button.itemStack, previouslySelectedItem)) {
                    button.COUNT = 1;
                    break;
                }
            }
        }
    }

    // 创建配方按钮
    private void createButton(int x, int y, ItemStack item, ForgeBlockRecipe recipe) {
        int centerX = (width - imageWidth) / 2 - 13 + x * 18;
        int centerY = (height - imageHeight) / 2 + 45 + y * 18;

        CustomButton button = new CustomButton(
                centerX,
                centerY,
                18,
                18,
                Component.literal(" "),
                (button1) -> {
                    // 重置其他按钮的状态
                    for (CustomButton btn : customButtons) {
                        btn.COUNT = 0;
                    }
                    // 设置当前按钮为选中状态
                    ((CustomButton) button1).COUNT = 1;
                    currentSelectedItem = ((CustomButton) button1).itemStack;

                    // 如果该物品有多个配方组，初始化轮播
                    String group = recipe.getGroup();
                    if (!group.isEmpty() && recipesByGroup.containsKey(group)) {
                        currentRecipeGroup = new ArrayList<>(recipesByGroup.get(group));
                        currentRecipeIndex = currentRecipeGroup.indexOf(recipe);
                        // 更新槽位显示并同步配方到服务端
                        updateSlotsForSelectedItem(currentRecipeGroup.get(currentRecipeIndex));
                    } else {
                        currentRecipeGroup.clear();
                        currentRecipeIndex = 0;
                        // 更新槽位显示并同步配方到服务端
                        updateSlotsForSelectedItem(recipe);
                    }
                },
                item,
                recipe
        );

        button.active = !menu.isCrafting();
        button.setAlpha(menu.isCrafting() ? 0.5f : 1.0f);

        addRenderableWidget(button);
        customButtons.add(button);
    }

    // 更新槽位显示并同步配方到服务端
    private void updateSlotsForSelectedItem(ForgeBlockRecipe recipe) {
        if (menu.isCrafting()) {
            return;
        }

        // 更新当前配方组
        String group = recipe.getGroup();
        if (!group.isEmpty() && recipesByGroup.containsKey(group)) {
            currentRecipeGroup = new ArrayList<>(recipesByGroup.get(group));
            currentRecipeIndex = currentRecipeGroup.indexOf(recipe);
        } else {
            currentRecipeGroup.clear();
            currentRecipeIndex = 0;
        }

        currentMaterials.clear();
        ItemStack[] materials = getMaterialsFromRecipe(recipe);
        currentMaterials.addAll(Arrays.asList(materials));

        // 立即更新客户端本地显示
        menu.setCurrentRecipe(recipe);
        this.localCurrentRecipe = recipe;

        // 发送同步包到服务端
        ChangShengJueMessages.sendToServer(
                new ForgeSyncRecipePacket(menu.getBlockPos(), recipe)
        );

        // 强制刷新UI
        menu.updateRecipeSlots();
    }
    
    // 更新槽位显示并同步配方到服务端（重载版本，用于制作时的配方切换）
    private void updateSlotsForCraftingRecipe(ForgeBlockRecipe recipe) {
        // 更新当前配方组
        String group = recipe.getGroup();
        if (!group.isEmpty() && recipesByGroup.containsKey(group)) {
            currentRecipeGroup = new ArrayList<>(recipesByGroup.get(group));
            currentRecipeIndex = currentRecipeGroup.indexOf(recipe);
        } else {
            currentRecipeGroup.clear();
            currentRecipeIndex = 0;
        }

        currentMaterials.clear();
        ItemStack[] materials = getMaterialsFromRecipe(recipe);
        currentMaterials.addAll(Arrays.asList(materials));

        // 立即更新客户端本地显示
        menu.setCurrentRecipe(recipe);
        this.localCurrentRecipe = recipe;

        // 发送同步包到服务端
        ChangShengJueMessages.sendToServer(
                new ForgeSyncRecipePacket(menu.getBlockPos(), recipe)
        );

        // 强制刷新UI
        menu.updateRecipeSlots();
    }

    // 获取菜单的Level对象
    private net.minecraft.world.level.Level getMenuLevel() {
        return minecraft.level;
    }
    
    // 获取注册表访问对象
    private RegistryAccess getRegistryAccess() {
        return getMenuLevel().registryAccess();
    }

    // 从配方中获取材料示例物品（用于UI显示）
    private ItemStack[] getMaterialsFromRecipe(ForgeBlockRecipe recipe) {
        if (recipe == null) {
            return new ItemStack[0];
        }
        
        ItemStack[] materials = recipe.getIngredients().stream()
                .map(ingredient -> {
                    ItemStack[] items = ingredient.getItems();
                    if (items.length > 0) {
                        return items[0];
                    } else {
                        return ItemStack.EMPTY;
                    }
                })
                .toArray(ItemStack[]::new);
        
        return materials;
    }

    // 创建盔甲架实体用于显示物品
    private void createArmorStandEntity() {
        if (minecraft == null || minecraft.level == null) return;

        armorStandEntity = new ArmorStand(minecraft.level, 0, 0, 0);
        armorStandEntity.setNoBasePlate(true);
        armorStandEntity.setShowArms(true);
        armorStandEntity.setInvisible(false);
        armorStandEntity.setYBodyRot(0);
    }

    // 渲染背景纹理
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
                int slotX = x + 134 + col * 18;
                int slotY = y + 45 + row * 18;

                // 仅当槽位有材料需求时才渲染
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

        // 渲染滚动条
        int maxScrollOffset = Math.max(0, (cachedRecipes.size() + 4) / 5 - VISIBLE_ROWS);
        float scrollProgress = maxScrollOffset > 0 ? (float) scrollOffset / maxScrollOffset : 0;
        int sliderHeight = Math.max(15, (int) (VISIBLE_ROWS * 1.0f / Math.max(1, (cachedRecipes.size() + 4) / 5) * scrollBarHeight));
        int sliderY = scrollBarY + (int) (scrollProgress * (scrollBarHeight - sliderHeight));

        int scrollerTextureV = isDragging ? 6 : 0;
        guiGraphics.blit(TEXTURE, scrollBarX+1, sliderY, scrollerTextureV, 271, 6, 15, 512, 512);
        
    }

    // 处理鼠标滚动事件
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

    // 处理鼠标点击事件
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        // 处理滚动条点击
        int maxScrollOffset = Math.max(0, (cachedRecipes.size() + 4) / 5 - VISIBLE_ROWS);
        if (maxScrollOffset > 0) {
            float scrollProgress = maxScrollOffset > 0 ? (float) scrollOffset / maxScrollOffset : 0;
            int sliderHeight = Math.max(15, (int) (VISIBLE_ROWS * 1.0f / Math.max(1, (cachedRecipes.size() + 4) / 5) * scrollBarHeight));
            int sliderY = scrollBarY + (int) (scrollProgress * (scrollBarHeight - sliderHeight));

            // 检查是否点击了滚动条滑块
            if (mouseX >= scrollBarX && mouseX <= scrollBarX + 6 &&
                    mouseY >= sliderY && mouseY <= sliderY + sliderHeight) {
                isDragging = true;
                return true;
            }

            // 检查是否点击了滚动条背景
            if (mouseX >= scrollBarX && mouseX <= scrollBarX + 6 &&
                    mouseY >= scrollBarY && mouseY <= scrollBarY + scrollBarHeight) {
                // 计算点击位置对应的滚动偏移
                float clickProgress = (float) (mouseY - scrollBarY) / scrollBarHeight;
                int newScrollOffset = Math.round(clickProgress * maxScrollOffset);
                scrollOffset = Math.max(0, Math.min(maxScrollOffset, newScrollOffset));
                refreshItemButtons();
                return true;
            }
        }

        // 移除轮播指示器点击处理逻辑

        return super.mouseClicked(mouseX, mouseY, button);
    }

    // 处理鼠标拖拽事件
    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (isDragging) {
            updateScrollFromMousePos(mouseY);
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    // 根据鼠标位置更新滚动条
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

    // 处理鼠标释放事件
    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (isDragging) {
            isDragging = false;
            return true;
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    // 渲染进度条
    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if (menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 79, y + 34, 176, 0, 8, menu.getScaledProgress());
        }
    }

    // 渲染盔甲架和物品
    private void renderArmorStandWithItem(GuiGraphics guiGraphics) {
        if (armorStandEntity == null) {
            return;
        }

        updateArmorStandEquipment();

        int armorStandX = width / 2 - 30;
        int armorStandY = height / 2 - 15;

        renderEntityInInventory(
                guiGraphics,
                armorStandX,
                armorStandY,
                25,
                rotation,
                180,
                armorStandEntity
        );

        rotation = (rotation + 0.5f) % 360;
    }

    // 更新盔甲架装备
    private void updateArmorStandEquipment() {
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            armorStandEntity.setItemSlot(slot, ItemStack.EMPTY);
        }
        armorStandEntity.setItemInHand(net.minecraft.world.InteractionHand.MAIN_HAND, ItemStack.EMPTY);

        if (currentSelectedItem.getItem() instanceof ArmorItem armor) {
            armorStandEntity.setItemSlot(armor.getEquipmentSlot(), currentSelectedItem);
        } else {
            armorStandEntity.setItemInHand(net.minecraft.world.InteractionHand.MAIN_HAND, currentSelectedItem);
        }
    }

    // 在GUI中渲染实体
    private void renderEntityInInventory(
            GuiGraphics guiGraphics,
            int posX, int posY,
            int scale,
            float rotationY, float rotationX,
            Entity entity
    ) {
        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();

        poseStack.translate(posX, posY, 50.0);
        poseStack.scale(scale, scale, scale);

        Quaternionf rotationQuat = new Quaternionf().rotationXYZ(
                (float) Math.toRadians(rotationX),
                (float) Math.toRadians(rotationY),
                0
        );
        poseStack.mulPose(rotationQuat);

        EntityRenderDispatcher renderer = Minecraft.getInstance().getEntityRenderDispatcher();
        renderer.overrideCameraOrientation(rotationQuat);
        renderer.setRenderShadow(false);

        MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();
        renderer.render(
                entity,
                0, 0, 0,
                0.0F,
                1.0F,
                poseStack,
                buffer,
                0xF000F0
        );
        buffer.endBatch();
        renderer.setRenderShadow(true);

        poseStack.popPose();
    }

    // 渲染标签
    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        // 保持原样
    }

    // 渲染主界面
    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);

        // 渲染按钮工具提示（确保在最上层）
        for (CustomButton button : customButtons) {
            if (button.isHovered() && !button.getItemStack().isEmpty()) {
                renderToolTip(guiGraphics, mouseX, mouseY, button.getItemStack());
            }
        }
        renderTooltip(guiGraphics, mouseX, mouseY);
        renderArmorStandWithItem(guiGraphics);
    }

    // 定期更新界面
    @Override
    public void containerTick() {
        super.containerTick();
        // 定期刷新配方以确保显示最新数据
        if (minecraft != null && minecraft.level != null && minecraft.level.getGameTime() % 20 == 0) {
            refreshRecipes();
            refreshItemButtons();
        }
        
        // 处理配方轮播 (1秒自动轮播)
        // 只有在非制作状态且有配方组时才进行轮播
        if (!currentRecipeGroup.isEmpty() && !menu.isCrafting()) {
            carouselTick++;
            if (carouselTick >= 20) { // 1秒(20tick)切换一次
                carouselTick = 0;
                currentRecipeIndex = (currentRecipeIndex + 1) % currentRecipeGroup.size();
                // 只有在按钮被选中时才自动轮播
                CustomButton selectedButton = null;
                for (CustomButton btn : customButtons) {
                    if (btn.COUNT == 1) {
                        selectedButton = btn;
                        break;
                    }
                }
                
                // 如果当前选中的按钮对应的物品与轮播组一致，则更新显示
                if (selectedButton != null && 
                    !selectedButton.itemStack.isEmpty() && 
                    !currentRecipeGroup.isEmpty() &&
                    ItemStack.isSameItemSameTags(selectedButton.itemStack, 
                                                currentRecipeGroup.get(currentRecipeIndex).getResultItem(getRegistryAccess()))) {
                    updateSlotsForSelectedItem(currentRecipeGroup.get(currentRecipeIndex));
                }
            }
        }
        
        // 如果正在制作，确保轮播停止并显示当前配方
        if (menu.isCrafting()) {
            // 清除轮播计时
            carouselTick = 0;
            
            // 检查方块实体中的当前配方是否与本地配方不同
            ForgeBlockRecipe blockEntityRecipe = menu.blockEntity.getCurrentRecipe();
            if (blockEntityRecipe != null && localCurrentRecipe != blockEntityRecipe) {
                // 更新显示为方块实体中的当前配方
                updateSlotsForCraftingRecipe(blockEntityRecipe);
            } else if (localCurrentRecipe != null) {
                // 确保显示的是当前制作的配方
                updateSlotsForCraftingRecipe(localCurrentRecipe);
            }
        }
    }

    // 自定义按钮类
    private class CustomButton extends Button {
        private ItemStack itemStack;
        private static final int TEXTURE_Y_NORMAL = 217;
        private static final int TEXTURE_Y_PRESS = 235;
        int COUNT = 0;
        private ForgeBlockRecipe recipe;
        private boolean isHovered;

        protected CustomButton(int pX, int pY, int pWidth, int pHeight, Component pMessage, OnPress pOnPress,
                               ItemStack itemStack, ForgeBlockRecipe recipe) {
            super(pX, pY, pWidth, pHeight, pMessage, pOnPress, Button.DEFAULT_NARRATION);
            this.itemStack = itemStack;
            this.recipe = recipe;
            this.isHovered = false;
        }

        @Override
        public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
            if (this.visible) {
                int textureY = this.COUNT == 1 ? TEXTURE_Y_PRESS : TEXTURE_Y_NORMAL;

                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                RenderSystem.setShaderTexture(0, TEXTURE);
                guiGraphics.blit(TEXTURE, this.getX(), this.getY(),
                        0, textureY, 18, 18, 512, 512);

                // 显示配方结果物品
                ItemStack displayStack = itemStack.copy();

                guiGraphics.renderItem(displayStack, this.getX() + 1, this.getY() + 1);
                if ( !itemStack.isEmpty() && isAir(this.getX(),this.getY(),mouseX,mouseY)) {
                    // 渲染物品提示
                    renderToolTip(guiGraphics, mouseX, mouseY, displayStack);
                }

                // 更新合成按钮状态
                if (craftButton != null) {
                    boolean isCrafting = menu.isCrafting();
                    craftButton.active = !isCrafting;
                    craftButton.visible = !isCrafting;
                }
            }
        }
        
        // 重写isHoveredOrFocused方法，确保按钮聚焦状态正确
        @Override
        public boolean isHoveredOrFocused() {
            return this.COUNT == 1 || super.isHoveredOrFocused();
        }
        
        // 重写 onPress 方法，移除配方轮播功能，只保留原始的点击逻辑
        @Override
        public void onPress() {
            // 执行原始的点击逻辑
            super.onPress();
        }

        // 获取悬停状态和物品信息以供渲染工具提示使用 
        public boolean isHovered() {
            return isHovered;
        }

        public ItemStack getItemStack() {
            return itemStack;
        }
    }

    private boolean isAir(int guix,int guiy,int mouseX, int mouseY) {
        return mouseX >= guix && mouseX < guix + 18 && mouseY >= guiy && mouseY < guiy + 18;
    }

    private void renderToolTip(GuiGraphics guiGraphics, int mouseX, int mouseY, ItemStack stack) {
        // 计算提示框位置（稍微偏移鼠标位置避免遮挡）
        int tooltipX = mouseX + 10;
        int tooltipY = mouseY + 10;

        // 渲染物品提示
        guiGraphics.renderTooltip(font, stack, tooltipX, tooltipY);
    }

    // 渲染自定义进度条
    private void renderCustomProgressBar(GuiGraphics guiGraphics, int x, int y) {
        // 计算进度条位置
        int progressBarX = x + 191;
        int progressBarY = y + 59;
        int progressBarWidth = 32;
        int progressBarHeight = 22;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        // 渲染背景部分
        guiGraphics.blit(TEXTURE, progressBarX, progressBarY,
                0, 308, progressBarWidth, progressBarHeight, 512, 512);

        // 渲染进度条填充部分
        if (menu.isCrafting()) {
            int scaledProgress = menu.getScaledProgress();
            guiGraphics.blit(TEXTURE, progressBarX, progressBarY,
                    0, 286, scaledProgress + 5, progressBarHeight, 512, 512);
        }
    }
    
    // 处理键盘按键事件，支持TAB键切换配方
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 258 && !currentRecipeGroup.isEmpty()) { // TAB键
            isCarouselPaused = true;
            carouselTick = 0; // 重置轮播计时器
            currentRecipeIndex = (currentRecipeIndex + 1) % currentRecipeGroup.size();
            updateSlotsForSelectedItem(currentRecipeGroup.get(currentRecipeIndex));
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
    
    // 处理鼠标移动，恢复轮播
    @Override
    public void mouseMoved(double mouseX, double mouseY) {
        // 不再恢复轮播，保持当前状态
        super.mouseMoved(mouseX, mouseY);
    }
}