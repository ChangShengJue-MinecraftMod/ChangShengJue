package com.shengchanshe.changshengjue.cilent.gui.screens.plaque;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PlaqueScreen extends AbstractContainerScreen<PlaqueMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/plaque_gui.png");
    private String inputText = ""; // 用于保存用户输入的文本
    // 文本输入框
    private EditBox textBox;

    Button button_empty;

    public PlaqueScreen(PlaqueMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
//        this.getMenu().blockEntity
        // 计算 GUI 的中心位置
        int centerX = (this.width - imageWidth) / 2;
        int centerY = (this.height - imageHeight) / 2;
        // 初始化文本输入框
        this.textBox = new EditBox(this.font, centerX + 10, centerY + 60, 120, 20, Component.literal(inputText));
        this.textBox.setMaxLength(1); // 限制输入最大字符数
        this.textBox.setEditable(true); // 可编辑
        this.textBox.setFocused(false); // 默认不聚焦
        this.textBox.setValue(""); // 默认内容为空
        this.addRenderableWidget(this.textBox); // 添加到渲染列表
        button_empty = Button.builder(Component.translatable("写下"), e -> {
            String text = this.textBox.getValue();
            ChangShengJueMessages.sendToServer(new UpdatePlaqueTextPacket(this.menu.getBlockPos(), text));
        }).bounds(centerX - 15, centerY + 90, imageWidth, 20).build();
        this.addRenderableWidget(button_empty);
    }

    @Override
    protected void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
        // 不执行任何操作，避免绘制标签
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
    }
    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        // 渲染背景
        this.renderBackground(guiGraphics);

        // 渲染自定义 GUI 背景纹理
        int centerX = (this.width - imageWidth) / 2;
        int centerY = (this.height - imageHeight) / 2;
        guiGraphics.blit(TEXTURE, centerX, centerY, 0, 0, imageWidth, imageHeight);

        // 渲染文本框
        super.render(guiGraphics, mouseX, mouseY, delta);
        // 渲染提示文字（当文本框为空且未聚焦时）
        if (this.textBox.getValue().isEmpty() && !this.textBox.isFocused()) {
            guiGraphics.drawString(this.font, "写...", this.textBox.getX() + 4, this.textBox.getY() + 6, 0xAAAAAA, false);
        }
    }
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (this.textBox.keyPressed(keyCode, scanCode, modifiers)) {
            return true; // 事件已被处理
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (!this.textBox.isMouseOver(mouseX, mouseY)) {
            this.textBox.setFocused(false); // 如果鼠标未在文本框上，取消聚焦
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }
    @Override
    public boolean charTyped(char codePoint, int modifiers) {
        // 处理用户输入
        inputText += codePoint; // 简单实现：将输入字符追加到字符串中
        return super.charTyped(codePoint, modifiers);
    }
}