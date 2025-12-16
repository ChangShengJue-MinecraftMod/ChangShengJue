package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.button;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
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

    // 图标相关属性
    private ResourceLocation iconTexture;
    private int iconX;
    private int iconY;
    private int iconWidth;
    private int iconHeight;
    private int iconTextureWidth;
    private int iconTextureHeight;
    private float iconScale;
    private IconPosition iconPosition;

    // 物品图标相关属性
    private ItemStack itemIcon;
    private float itemIconScale;
    private IconPosition itemIconPosition;

    public enum IconPosition {
        LEFT,      // 图标在文字左侧
        RIGHT,     // 图标在文字右侧
        TOP,       // 图标在文字上方
        BOTTOM,    // 图标在文字下方
        CENTER     // 图标覆盖在文字中心
    }

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
        this.iconScale = 1.0f;
        this.iconPosition = IconPosition.LEFT;
        this.itemIconScale = 1.0f;
        this.itemIconPosition = IconPosition.LEFT;
    }

    public TexturedButtonWithText(int x, int y, int width, int height,
                                  int xTexStart, int yTexStart, int yDiffTex,
                                  ResourceLocation resourceLocation,
                                  int textureWidth, int textureHeight,
                                  OnPress onPress, Component text,
                                  int textColor, int hoverTextColor, float textScale, boolean pDropShadow) {
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
        this.iconScale = 1.0f;
        this.iconPosition = IconPosition.LEFT;
        this.itemIconScale = 1.0f;
        this.itemIconPosition = IconPosition.LEFT;
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
        this.iconScale = 1.0f;
        this.iconPosition = IconPosition.LEFT;
        this.itemIconScale = 1.0f;
        this.itemIconPosition = IconPosition.LEFT;
    }

    // 设置纹理图标的方法
    public TexturedButtonWithText setIcon(ResourceLocation texture, int x, int y, int width, int height,
                                          int textureWidth, int textureHeight) {
        this.iconTexture = texture;
        this.iconX = x;
        this.iconY = y;
        this.iconWidth = width;
        this.iconHeight = height;
        this.iconTextureWidth = textureWidth;
        this.iconTextureHeight = textureHeight;
        return this;
    }

    // 设置物品图标的方法
    public TexturedButtonWithText setItemIcon(ItemStack itemStack) {
        this.itemIcon = itemStack;
        return this;
    }

    // 设置物品图标缩放
    public TexturedButtonWithText setItemIconScale(float scale) {
        this.itemIconScale = scale;
        return this;
    }

    // 设置物品图标位置
    public TexturedButtonWithText setItemIconPosition(IconPosition position) {
        this.itemIconPosition = position;
        return this;
    }

    // 设置图标位置
    public TexturedButtonWithText setIconPosition(IconPosition position) {
        this.iconPosition = position;
        return this;
    }

    // 设置图标缩放
    public TexturedButtonWithText setIconScale(float scale) {
        this.iconScale = scale;
        return this;
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

        renderIconAndText(guiGraphics, poseStack);

        poseStack.popPose();
    }

    private void renderIconAndText(GuiGraphics guiGraphics, PoseStack poseStack) {
        Font font = Minecraft.getInstance().font;
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        if (itemIcon != null) {
            renderItemIconAndText(guiGraphics, poseStack, font, itemRenderer);
        } else if (iconTexture != null) {
            renderTextureIconAndText(guiGraphics, poseStack, font);
        } else {
            renderTextOnly(guiGraphics, poseStack, font);
        }
    }

    private void renderItemIconAndText(GuiGraphics guiGraphics, PoseStack poseStack, Font font, ItemRenderer itemRenderer) {
        List<FormattedCharSequence> lines = font.split(buttonText, (int)((width - 8) / textScale));

        // 按钮的中心点
        double buttonCenterX = this.getX() + this.width / 2.0;
        double buttonCenterY = this.getY() + this.height / 2.0;

        int itemIconSize = (int)(16 * itemIconScale);

        // 计算文字总高度和最大宽度
        int totalTextHeight = (int)(lines.size() * font.lineHeight * textScale);
        double maxTextWidth = getMaxLineWidth(font, lines) * textScale;

        // 计算物品图标和文字的总尺寸
        double totalWidth, totalHeight;
        double iconX, iconY, textStartX, textStartY;

        switch (itemIconPosition) {
            case LEFT:
            case RIGHT:
                totalWidth = maxTextWidth + itemIconSize + 4;

                iconX = buttonCenterX - totalWidth / 2.0;
                textStartX = iconX + itemIconSize + 4;
                iconY = buttonCenterY - itemIconSize / 2.0;
                textStartY = buttonCenterY - totalTextHeight / 2.0;

                if (itemIconPosition == IconPosition.RIGHT) {
                    iconX = buttonCenterX + totalWidth / 2.0 - itemIconSize;
                    textStartX = iconX - maxTextWidth - 4;
                }
                break;

            case TOP:
            case BOTTOM:
                totalHeight = totalTextHeight + itemIconSize + 4;

                iconX = buttonCenterX - itemIconSize / 2.0;
                textStartX = buttonCenterX - maxTextWidth / 2.0;
                iconY = buttonCenterY - totalHeight / 2.0;
                textStartY = iconY + itemIconSize + 4;

                if (itemIconPosition == IconPosition.BOTTOM) {
                    iconY = buttonCenterY + totalHeight / 2.0 - itemIconSize;
                    textStartY = iconY - totalTextHeight - 4;
                }
                break;

            case CENTER:
            default:
                iconX = buttonCenterX - itemIconSize / 2.0;
                iconY = buttonCenterY - itemIconSize / 2.0;
                textStartX = textStartY = 0;
                break;
        }

        poseStack.pushPose();
        poseStack.translate(iconX, iconY, 0);
        poseStack.scale(itemIconScale, itemIconScale, 1f);
        poseStack.translate(-iconX, -iconY, 0);

        guiGraphics.renderItem(itemIcon, (int)iconX, (int)iconY);
        poseStack.popPose();

        if (itemIconPosition != IconPosition.CENTER && !lines.isEmpty()) {
            renderTextLines(guiGraphics, font, lines, textStartX, textStartY,poseStack);
        }
    }

    private void renderTextureIconAndText(GuiGraphics guiGraphics, PoseStack poseStack, Font font) {
        // 按钮的中心点
        double buttonCenterX = this.getX() + this.width / 2.0;
        double buttonCenterY = this.getY() + this.height / 2.0;

        // 计算图标尺寸
        int iconRenderWidth = (int)(iconWidth * iconScale);
        int iconRenderHeight = (int)(iconHeight * iconScale);

        // 图标位置（居中）
        double iconX = buttonCenterX - iconRenderWidth / 2.0;
        double iconY = buttonCenterY - iconRenderHeight / 2.0;

        // 渲染纹理图标
        poseStack.pushPose();
        poseStack.translate(iconX, iconY, 0);
        poseStack.scale(iconScale, iconScale, 1f);
        poseStack.translate(-iconX, -iconY, 0);

        guiGraphics.blit(iconTexture,
                (int)iconX, (int)iconY,
                iconRenderWidth, iconRenderHeight,
                this.iconX, this.iconY,
                iconWidth, iconHeight,
                iconTextureWidth, iconTextureHeight);

        poseStack.popPose();
    }

    private void renderTextOnly(GuiGraphics guiGraphics, PoseStack poseStack, Font font) {
        List<FormattedCharSequence> lines = font.split(buttonText, (int)((width - 8) / textScale));

        // 按钮的中心点
        double buttonCenterX = this.getX() + this.width / 2.0;
        double buttonCenterY = this.getY() + this.height / 2.0;

        // 计算文字总高度
        int totalTextHeight = (int)(lines.size() * font.lineHeight * textScale);
        double textStartY = buttonCenterY - totalTextHeight / 2.0;

        renderTextLines(guiGraphics, font, lines, buttonCenterX, textStartY,poseStack);
    }

    private void renderTextLines(GuiGraphics guiGraphics, Font font, List<FormattedCharSequence> lines,
                                 double centerX, double startY, PoseStack poseStack) {
        int color = this.isHoveredOrFocused() ? hoverTextColor : textColor;

        for (int i = 0; i < lines.size(); i++) {
            FormattedCharSequence line = lines.get(i);
            double lineWidth = font.width(line) * textScale;
            double x = centerX - lineWidth / 2.0;
            double y = startY + i * font.lineHeight * textScale;


            poseStack.pushPose();
            poseStack.translate(x, y, 0);
            poseStack.scale(textScale, textScale, 1f);
            poseStack.translate(-x, -y, 0);

            guiGraphics.drawString(
                    font,
                    line,
                    (int)Math.round(x),
                    (int)Math.round(y),
                    color,
                    pDropShadow
            );

            poseStack.popPose();
        }
    }

    // 获取最大行宽
    private double getMaxLineWidth(Font font, List<FormattedCharSequence> lines) {
        return lines.stream()
                .mapToDouble(font::width)
                .max()
                .orElse(0);
    }

    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y);
        this.originalX = x;
        this.originalY = y;
    }
}