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

    public ForgeBlockScreen(ForgeBlockMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        imageWidth = 276;
        imageHeight = 216;
    }

    @Override
    protected void init() {
        super.init();
        System.out.println("正在初始化ForgeBlockScreen");
        customButtons.clear();
        scrollOffset = 0; // 确保滚动偏移初始化为0
        createArmorStandEntity();
        refreshRecipes(); // 刷新配方缓存
        refreshItemButtons();

        ForgeBlockRecipe serverRecipe = menu.getCurrentRecipe();
        System.out.println("服务端配方: " + (serverRecipe != null ? serverRecipe.getId() : "无"));

        //如果处于制作状态
        if (serverRecipe != null || menu.isCrafting()) {
            currentMaterials.clear();
            currentMaterials.addAll(Arrays.asList(getMaterialsFromRecipe(serverRecipe)));
            currentSelectedItem = serverRecipe.getResultItem(getRegistryAccess());
            System.out.println("设置当前选中物品: " + currentSelectedItem);
        }

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        craftButton = Button.builder(Component.translatable("gui."+ ChangShengJue.MOD_ID + ".forge_block.craft"), button -> {
                    // 发送制作请求到服务端
                    ChangShengJueMessages.sendToServer(
                            new ForgeCraftPacket(menu.getBlockPos())
                    );
                })
                .bounds(x + 200, y + 95, 35, 15)
                .build();

        addRenderableWidget(craftButton);
        // System.out.println("ForgeBlockScreen初始化完成，共有 " + customButtons.size() + " 个按钮");
    }

    private void refreshRecipes() {
        // 获取所有配方并缓存
        if (minecraft != null && minecraft.level != null) {
            try {
                System.out.println("尝试获取配方管理器...");
                var recipeManager = minecraft.level.getRecipeManager();
                System.out.println("配方管理器: " + recipeManager);
                
                System.out.println("尝试获取配方类型...");
                var recipeType = CSJRecipeTypes.FORGE_BLOCK_TYPE.get();
                System.out.println("配方类型: " + recipeType);
                
                System.out.println("尝试获取所有配方...");
                cachedRecipes = recipeManager.getAllRecipesFor(recipeType);
            } catch (Exception e) {
                cachedRecipes = new ArrayList<>();
                e.printStackTrace();
            }
        } else {
            cachedRecipes.clear();
            if (minecraft == null) {
                System.out.println("Minecraft实例为空");
            } else if (minecraft.level == null) {
                System.out.println("Minecraft世界实例为空");
            }
        }
    }

    private void refreshItemButtons() {
        // 保存当前选中的物品
        ItemStack previouslySelectedItem = currentSelectedItem.copy();

        System.out.println("正在刷新按钮，找到 " + cachedRecipes.size() + " 个配方");

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

        // 清除现有按钮的内容，但不删除按钮对象
        for (CustomButton button : customButtons) {
            button.itemStack = ItemStack.EMPTY;
        }

        // 遍历配方，从起始索引开始
        for (int i = startIndex; i < cachedRecipes.size() && row < VISIBLE_ROWS; i++) {
            ForgeBlockRecipe recipe = cachedRecipes.get(i);
            System.out.println("正在为配方创建按钮: " + recipe.getId() + " 位置 (" + col + ", " + row + ")");

            // 更新现有按钮
            if (col + row * 5 < customButtons.size()) {
                CustomButton button = customButtons.get(col + row * 5);
                button.itemStack = recipe.getResultItem(getRegistryAccess());
            } else {
                // 如果按钮数量不够，创建新按钮
                createButton(col, row, recipe.getResultItem(getRegistryAccess()));
            }

            // 每行5个按钮
            col++;
            if (col >= 5) {
                col = 0;
                row++;
            }
        }

        // 如果没有任何配方，也尝试刷新一次配方
        if (cachedRecipes.isEmpty()) {
            System.out.println("没有找到配方，尝试重新加载...");
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


    private void createButton(int x, int y, ItemStack item) {
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

                    // 更新槽位显示并同步配方到服务端
                    updateSlotsForSelectedItem(currentSelectedItem);
                },
                item,
                0
        );

        button.active = !menu.isCrafting();
        // 可选：添加半透明效果表示不可用
        button.setAlpha(menu.isCrafting() ? 0.5f : 1.0f);

        addRenderableWidget(button);
        customButtons.add(button);
    }

    // 更新槽位显示并同步配方到服务端
    private void updateSlotsForSelectedItem(ItemStack selectedItem) {
        System.out.println("更新槽位显示，选中物品: " + selectedItem);

        if (menu.isCrafting()) {
            System.out.println("正在制作中，无法更新配方");
            return;
        }

        Optional<ForgeBlockRecipe> newRecipe = selectedItem.isEmpty()
                ? Optional.empty()
                : cachedRecipes.stream()
                .filter(recipe -> ItemStack.isSameItemSameTags(recipe.getResultItem(getRegistryAccess()), selectedItem))
                .findFirst();
        
        System.out.println("找到匹配的配方: " + (newRecipe.isPresent() ? newRecipe.get().getId() : "无"));

        currentMaterials.clear();
        if (newRecipe.isPresent()) {
            ItemStack[] materials = getMaterialsFromRecipe(newRecipe.get());
            currentMaterials.addAll(Arrays.asList(materials));
            System.out.println("设置材料显示，共 " + materials.length + " 个材料");
        }
        
        // 立即更新客户端本地显示
        menu.setCurrentRecipe(newRecipe.orElse(null));

        // 发送同步包到服务端
        System.out.println("准备发送配方同步包...");
        ChangShengJueMessages.sendToServer(
                new ForgeSyncRecipePacket(menu.getBlockPos(), newRecipe.orElse(null))
        );
        System.out.println("配方同步包已发送");

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
        System.out.println("从配方获取材料: " + (recipe != null ? recipe.getId() : "无配方"));
        if (recipe == null) {
            System.out.println("配方为空，返回空材料数组");
            return new ItemStack[0];
        }
        
        ItemStack[] materials = recipe.getIngredients().stream()
                .map(ingredient -> {
                    ItemStack[] items = ingredient.getItems();
                    if (items.length > 0) {
                        System.out.println("材料: " + items[0]);
                        return items[0];
                    } else {
                        System.out.println("空材料");
                        return ItemStack.EMPTY;
                    }
                })
                .toArray(ItemStack[]::new);
        
        System.out.println("总共获取到 " + materials.length + " 个材料");
        return materials;
    }

    private void createArmorStandEntity() {
        if (minecraft == null || minecraft.level == null) return;

        armorStandEntity = new ArmorStand(minecraft.level, 0, 0, 0);
        armorStandEntity.setNoBasePlate(true);
        armorStandEntity.setShowArms(true);
        armorStandEntity.setInvisible(false);
        armorStandEntity.setYBodyRot(0);
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
                int slotIndex = row * 3 + col; // 槽位索引（0-8）
                int slotX = x + 134 + col * 18; // 槽位X坐标
                int slotY = y + 45 + row * 18;  // 槽位Y坐标

                // 仅当槽位有材料需求时才渲染
                if (slotIndex < currentMaterials.size()) {
                    ItemStack required = currentMaterials.get(slotIndex);
                    if (!required.isEmpty()) { // 非空材料才处理
                        boolean isMaterialEnough = menu.hasEnoughOfMaterial(minecraft.player.getInventory(), required);
                        int textureV = isMaterialEnough ? 217 : 235; // 充足用217，不足用235
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
        if (mouseX >= scrollBarX && mouseX <= scrollBarX + 6 &&
                mouseY >= scrollBarY && mouseY <= scrollBarY + scrollBarHeight) {
            isDragging = true;
            return true;
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
        // 计算最大滚动偏移，使用更精确的除法
        int maxScrollOffset = Math.max(0, (int) Math.ceil((double) cachedRecipes.size() / 5) - VISIBLE_ROWS);
        System.out.println("拖拽时最大滚动偏移: " + maxScrollOffset);
        
        if (maxScrollOffset <= 0) {
            System.out.println("无需滚动，配方数量不足");
            return;
        }

        // 计算鼠标位置对应的滚动比例
        float relativeY = (float) (mouseY - scrollBarY) / scrollBarHeight;
        relativeY = Math.max(0, Math.min(1, relativeY));

        // 更新滚动偏移量
        scrollOffset = (int) (relativeY * maxScrollOffset);
        scrollOffset = Math.max(0, Math.min(scrollOffset, maxScrollOffset));
        
        System.out.println("拖拽更新滚动偏移: " + scrollOffset);
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

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if (menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 79, y + 34, 176, 0, 8, menu.getScaledProgress());
        }
    }

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

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        // 保持原样
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
        renderArmorStandWithItem(guiGraphics);
    }

    @Override
    public void containerTick() {
        super.containerTick();
        // 定期刷新配方以确保显示最新数据，但不刷新按钮状态
        if (minecraft != null && minecraft.level != null && minecraft.level.getGameTime() % 20 == 0) {
            System.out.println("定期刷新配方...");
            refreshRecipes();

            // 只更新现有按钮的物品，不改变按钮状态
            for (CustomButton button : customButtons) {
                if (!button.itemStack.isEmpty()) {
                    ItemStack updatedStack = button.itemStack.getItem().getDefaultInstance();
                    if (!ItemStack.isSameItemSameTags(button.itemStack, updatedStack)) {
                        button.itemStack = updatedStack;
                    }
                }
            }
        }
    }

    private class CustomButton extends Button {
        private ItemStack itemStack;
        private static final int TEXTURE_Y_NORMAL = 217;
        private static final int TEXTURE_Y_PRESS = 235;
        int COUNT = 0;

        protected CustomButton(int pX, int pY, int pWidth, int pHeight, Component pMessage, OnPress pOnPress,
                               CreateNarration pCreateNarration, ItemStack itemStack) {
            super(pX, pY, pWidth, pHeight, pMessage, pOnPress, pCreateNarration);
            this.itemStack = itemStack;
        }

        protected CustomButton(int pX, int pY, int pWidth, int pHeight, Component pMessage, OnPress pOnPress,
                               ItemStack itemStack, int count) {
            super(pX, pY, pWidth, pHeight, pMessage, pOnPress, Button.DEFAULT_NARRATION);
            this.itemStack = itemStack;
            this.COUNT = count;
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

                guiGraphics.renderItem(itemStack, this.getX() + 1, this.getY() + 1);
                if ( !itemStack.isEmpty() && isAir(this.getX(),this.getY(),mouseX,mouseY)) {
                    // 渲染物品提示
                    renderToolTip(guiGraphics, mouseX, mouseY, itemStack);
                }

                // 更新合成按钮状态
                if (craftButton != null) {
                    boolean isCrafting = menu.isCrafting();
                    craftButton.active = !isCrafting; // 正在合成时禁用按钮
                    craftButton.visible = !isCrafting;
                }
            }
        }

        @Override
        public boolean isHoveredOrFocused() {
            return this.COUNT == 1 || super.isHoveredOrFocused();
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

    private void renderCustomProgressBar(GuiGraphics guiGraphics, int x, int y) {
        // 计算进度条位置
        int progressBarX = x + 191; // 进度条X坐标
        int progressBarY = y + 59; // 进度条Y坐标
        int progressBarWidth = 32; // 进度条总宽度
        int progressBarHeight = 22; // 进度条高度

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
}