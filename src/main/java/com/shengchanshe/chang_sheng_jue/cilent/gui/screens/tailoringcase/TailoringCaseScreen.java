package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.tailoringcase;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.TailoringCraftPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.TailoringSyncRecipePacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import org.joml.Quaternionf;

import java.util.*;

public class TailoringCaseScreen extends AbstractContainerScreen<TailoringCaseMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/tailoring_case_menu.png");
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
    private List<ItemStack> currentMaterials = new ArrayList<>();

    public TailoringCaseScreen(TailoringCaseMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        imageWidth = 276;
        imageHeight = 216;
    }

    @Override
    protected void init() {
        super.init();
        customButtons.clear();
        createArmorStandEntity();
        refreshItemButtons();

        TailoringCaseMenu.TailoringRecipe serverRecipe = menu.getCurrentRecipe();
        if (serverRecipe != null) {
            currentMaterials.clear();
            currentMaterials.addAll(Arrays.asList(serverRecipe.getMaterials()));
            currentSelectedItem = serverRecipe.getResult();
        }

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        craftButton = Button.builder(Component.translatable("gui."+ ChangShengJue.MOD_ID + ".tailoring_case.craft"), button -> {
                    // 发送制作请求到服务端
                    ChangShengJueMessages.sendToServer(
                            new TailoringCraftPacket(menu.getBlockPos())
                    );
                })
                .bounds(x + 200, y + 95, 35, 15)
                .build();

        addRenderableWidget(craftButton);
    }

    private void refreshItemButtons() {
        for (CustomButton button : customButtons) {
            this.removeWidget(button);
        }
        customButtons.clear();

        int row = 0;
        int col = 0;

        // 遍历所有配方
        for (TailoringCaseMenu.TailoringRecipe recipe : TailoringCaseMenu.RECIPES) {
            // 只显示当前可见行
            if (row >= VISIBLE_ROWS) break;

            // 创建按钮
            createButton(col, row, recipe.getResult());

            // 每行5个按钮
            col++;
            if (col >= 5) {
                col = 0;
                row++;
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
                    for (CustomButton btn : customButtons) {
                        btn.COUNT = (btn == button1) ? 1 : 0;
                    }
                    currentSelectedItem = ((CustomButton) button1).itemStack;

                    // 更新槽位显示并同步配方到服务端
                    updateSlotsForSelectedItem(currentSelectedItem);
                },
                item,
                0
        );

        button.active = !menu.isCrafting();
        button.setAlpha(menu.isCrafting() ? 0.5f : 1.0f);


        addRenderableWidget(button);
        customButtons.add(button);
    }

    // 更新槽位显示并同步配方到服务端
    private void updateSlotsForSelectedItem(ItemStack selectedItem) {
        if (menu.isCrafting()) {
            return;
        }

        Optional<TailoringCaseMenu.TailoringRecipe> newRecipe = selectedItem.isEmpty()
                ? Optional.empty()
                : TailoringCaseMenu.findRecipe(selectedItem);

        currentMaterials.clear();
        if (newRecipe.isPresent()) {
            currentMaterials.addAll(Arrays.asList(newRecipe.get().getMaterials()));
        }

        // 立即更新客户端本地显示
        menu.setCurrentRecipe(newRecipe.orElse(null));

        // 发送同步包到服务端
        ChangShengJueMessages.sendToServer(
                new TailoringSyncRecipePacket(menu.getBlockPos(), newRecipe.orElse(null))
        );

        // 强制刷新UI
        menu.updateRecipeSlots();
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
        renderCustomProgressBar(guiGraphics, x, y); // 新增这一行
        scrollBarX = x - 13 + 5 * 18;
        scrollBarY = y + 45;
        scrollBarHeight = VISIBLE_ROWS * 18;


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


        int maxScrollOffset = TOTAL_ROWS - VISIBLE_ROWS;
        float scrollProgress = maxScrollOffset > 0 ? (float) scrollOffset / maxScrollOffset : 0;
        int sliderHeight = Math.max(15, (int) (VISIBLE_ROWS * 1.0f / TOTAL_ROWS * scrollBarHeight));
        int sliderY = scrollBarY + (int) (scrollProgress * (scrollBarHeight - sliderHeight));

        int scrollerTextureV = isDragging ? 6 : 0;
        guiGraphics.blit(TEXTURE, scrollBarX, sliderY, scrollerTextureV, 271, 6, 15, 512, 512);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        int maxScrollOffset = TOTAL_ROWS - VISIBLE_ROWS;
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
        int maxScrollOffset = TOTAL_ROWS - VISIBLE_ROWS;
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
        armorStandEntity.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);

        if (currentSelectedItem.getItem() instanceof ArmorItem armor) {
            armorStandEntity.setItemSlot(armor.getEquipmentSlot(), currentSelectedItem);
        } else {
            armorStandEntity.setItemInHand(InteractionHand.MAIN_HAND, currentSelectedItem);
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

                guiGraphics.renderItem(itemStack, this.getX() + 1, this.getY());

                int textColor = isHoveredOrFocused() ? 0xFFFFA0 : 0xE0E0E0;
                guiGraphics.drawCenteredString(font, getMessage(),
                        this.getX() + 9,
                        this.getY() + 4,
                        textColor);
                //新加
                if (craftButton != null) {
                    boolean isCrafting = menu.isCrafting();
                    craftButton.active = !isCrafting; // 正在合成时禁用按钮
                    craftButton.visible = !isCrafting;
                }





            }
        }
    }


    private void renderCustomProgressBar(GuiGraphics guiGraphics, int x, int y) {
        // 计算进度条位置（根据你的GUI布局调整坐标）
        int progressBarX = x + 191; // 进度条X坐标
        int progressBarY = y + 59; // 进度条Y坐标
        int progressBarWidth = 32; // 进度条总宽度
        int progressBarHeight = 22; // 进度条高度q


        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        // 从纹理中裁剪背景部分（参数：目标X, 目标Y, 纹理X, 纹理Y, 宽度, 高度）
        guiGraphics.blit(TEXTURE, progressBarX, progressBarY,
                0, 308, progressBarWidth, progressBarHeight,512,512);

        // 2. 渲染进度条填充部分（根据合成进度动态显示）
        if (menu.isCrafting()) {
            int scaledProgress = menu.getScaledProgress(); // 获取当前进度（0-26）
            // 从纹理中裁剪填充部分（使用自定义材质的坐标）
            guiGraphics.blit(TEXTURE, progressBarX, progressBarY,
                    0, 286, scaledProgress+5, progressBarHeight,512,512);
        }
    }

}