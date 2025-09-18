package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.button;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class TexturedButtonWithText extends ImageButton {
    private int originalX;
    private int originalY;
    private float currentScale;
    private final float targetScale;
    private final float hoverScale;
    private final float animationSpeed = 0.1f;
    private final Component buttonText;
    private final int textColor;
    private final int hoverTextColor;
    private final float textScale;
    private final boolean pDropShadow;

    public TexturedButtonWithText(int x, int y, int width, int height,
                                  int xTexStart, int yTexStart, int yDiffTex,
                                  ResourceLocation resourceLocation,
                                  int textureWidth, int textureHeight,
                                  OnPress onPress, Component text,
                                  int textColor, int hoverTextColor, float textScale) {
        super(x, y, width, height, xTexStart, yTexStart, yDiffTex,
                resourceLocation, textureWidth, textureHeight, onPress, text);
        this.originalX = x;
        this.originalY = y;
        this.currentScale = 1.0f;
        this.targetScale = 1.0f;
        this.hoverScale = 1.1f;
        this.buttonText = text;
        this.textColor = textColor;
        this.hoverTextColor = hoverTextColor;
        this.textScale = textScale;
        this.pDropShadow = false;
    }

    public TexturedButtonWithText(int x, int y, int width, int height,
                                  int xTexStart, int yTexStart, int yDiffTex,
                                  ResourceLocation resourceLocation,
                                  int textureWidth, int textureHeight,
                                  OnPress onPress, Component text,
                                  int textColor, int hoverTextColor, float textScale,boolean pDropShadow) {
        super(x, y, width, height, xTexStart, yTexStart, yDiffTex,
                resourceLocation, textureWidth, textureHeight, onPress, text);
        this.originalX = x;
        this.originalY = y;
        this.currentScale = 1.0f;
        this.targetScale = 1.0f;
        this.hoverScale = 1.1f;
        this.buttonText = text;
        this.textColor = textColor;
        this.hoverTextColor = hoverTextColor;
        this.textScale = textScale;
        this.pDropShadow = pDropShadow;
    }

    public TexturedButtonWithText(int x, int y, int width, int height,
                                  int xTexStart, int yTexStart, int yDiffTex,
                                  ResourceLocation resourceLocation,
                                  int textureWidth, int textureHeight,
                                  OnPress onPress, Component text,
                                  int textColor, int hoverTextColor, float textScale,
                                  float currentScale, float targetScale, float hoverScale) {
        super(x, y, width, height, xTexStart, yTexStart, yDiffTex,
                resourceLocation, textureWidth, textureHeight, onPress, text);
        this.originalX = x;
        this.originalY = y;
        this.currentScale = currentScale;
        this.targetScale = targetScale;
        this.hoverScale = hoverScale;
        this.buttonText = text;
        this.textColor = textColor;
        this.hoverTextColor = hoverTextColor;
        this.textScale = textScale;
        this.pDropShadow = false;
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        currentScale = Mth.lerp(animationSpeed, currentScale, this.isHoveredOrFocused() ? hoverScale : targetScale);

        this.setX(originalX);
        this.setY(originalY);

        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();

        float centerX = originalX + this.width / 2f;
        float centerY = originalY + this.height / 2f;
        poseStack.translate(centerX, centerY, 0);
        poseStack.scale(currentScale, currentScale, 1);
        poseStack.translate(-centerX, -centerY, 0);

        super.renderWidget(guiGraphics, mouseX, mouseY, partialTick);

        renderText(guiGraphics, poseStack);

        poseStack.popPose();
    }

    private void renderText(GuiGraphics guiGraphics, PoseStack poseStack) {
        Font font = Minecraft.getInstance().font;

        List<FormattedCharSequence> lines = font.split(buttonText, (int)((width - 8) / textScale));
        int totalTextHeight = (int)(lines.size() * font.lineHeight * textScale); // 总渲染高度（含缩放）

        double centerX = this.getX() + this.width / 2.0;
        double startY = this.getY() + (this.height - totalTextHeight) / 2.0; // 视觉补偿

        poseStack.pushPose();
        poseStack.translate(centerX, startY, 0);
        poseStack.scale(textScale, textScale, 1f);
        poseStack.translate(-centerX, -startY, 0);

        int color = this.isHoveredOrFocused() ? hoverTextColor : textColor;
        for (int i = 0; i < lines.size(); i++) {
            FormattedCharSequence line = lines.get(i);
            double lineWidth = font.width(line);
            double x = centerX - lineWidth / 2.0 + 0.5;
            double y = startY + i * font.lineHeight;

            guiGraphics.drawString(
                    font,
                    line,
                    (int)Math.round(x),
                    (int)Math.round(y),
                    color,
                    pDropShadow
            );
        }
        poseStack.popPose();
    }


    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y);
        this.originalX = x;
        this.originalY = y;
    }
}