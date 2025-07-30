package com.shengchanshe.chang_sheng_jue.cilent.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.joml.Math;
import org.lwjgl.opengl.GL11;

import java.util.Formatter;

public class CSJDisplayHud {
    public static void displayHudPermanent(GuiGraphics guiGraphics, ResourceLocation pAtlasLocation, int x, int y){
        RenderSystem.setShaderTexture(0, pAtlasLocation);
        // 绘制图标
        // 贴图，x坐标，y坐标，z坐标（图层 越高越不容易被遮盖）
        guiGraphics.blit(pAtlasLocation, x, y, 0, 0, 0, 16, 16,
                16, 16);
    }

    public static void displayHudPermanent(GuiGraphics guiGraphics, ResourceLocation pAtlasLocation, int x, int y,int frameTime){
        RenderSystem.setShaderTexture(0, pAtlasLocation);
        // 绘制图标
        // 贴图，x坐标，y坐标，z坐标（图层 越高越不容易被遮盖）
        guiGraphics.blit(pAtlasLocation, x, y, 1000, 0, 0,16,  frameTime + 16, 16, 16);
    }

    public static void displayHudPermanent(GuiGraphics guiGraphics, Font font,float frameTime,float frameTimeMax, int x, int y){
        // 绘制文字
//        PoseStack poseStack = guiGraphics.pose(); // 获取 PoseStack
//        poseStack.pushPose(); // 保存当前矩阵状态
//         设置缩放比例
//        float scale = 0.5f; // 0.5 表示缩放到 50%
//        poseStack.scale(scale, scale, scale);

        guiGraphics.drawCenteredString(font,new Formatter().format((frameTime * frameTimeMax) > 10 ? "%.0f" : "%.1f",
                (frameTime * frameTimeMax)).toString(),x + 8,y + 4, ChatFormatting.AQUA.getColor());
//        poseStack.popPose(); // 恢复矩阵状态
    }

    public static void displayHudPermanent(GuiGraphics guiGraphics, Font font,String text, int x, int y,Integer color){
    // 获取GuiGraphics的PoseStack对象，用于管理图形的变换
        PoseStack poseStack = guiGraphics.pose();
    // 保存当前的变换状态，以便之后可以恢复
        poseStack.pushPose();
    // 设置缩放比例，这里将图形缩放为原来的一半
        float scale = 0.5f;
        poseStack.scale(scale, scale, scale);
    // 在指定位置绘制居中的字符串，颜色为传入的color
        guiGraphics.drawCenteredString(font, text,x + 22, 2 * y + 36, color);
    // 恢复之前的变换状态
        poseStack.popPose();
    }

    public static void displayHudPermanent(GuiGraphics guiGraphics, Font font, int x, int y ,String text){
        // 绘制文字
        guiGraphics.drawString(font,text,x + 8,y + 8, ChatFormatting.BLACK.getColor());
    }

    public static void displayHudPermanent(int kungFuLevel, int maxKungFuLevel,
                                           float frameTime, float frameTimeMax,
                                           boolean playerCanOpened, GuiGraphics guiGraphics,
                                           ResourceLocation normalTexture,
                                           ResourceLocation maxLevelTexture,
                                           ResourceLocation disabledTexture,
                                           ResourceLocation cooldownMask,
                                           Font font, int x, int y) {
        // 参数有效性检查
        if (guiGraphics == null || normalTexture == null || maxLevelTexture == null ||
                disabledTexture == null || cooldownMask == null || font == null) {
            return;
        }

        // 1. 检查技能是否解锁
        if (kungFuLevel <= 0) {
            renderDisabledSkill(guiGraphics, disabledTexture, x, y);
            return;
        }

        // 2. 渲染基础技能图标
        ResourceLocation baseTexture = getBaseTexture(kungFuLevel, maxKungFuLevel, normalTexture, maxLevelTexture);
        renderBaseIcon(guiGraphics, baseTexture, x, y);

        // 3. 处理冷却状态
        if (frameTime > 0) {
            handleCooldown(guiGraphics, frameTime, frameTimeMax, cooldownMask, font, x, y);
        }
        if (!playerCanOpened) {
            handleCooldown(guiGraphics, cooldownMask, x, y);
        }
    }

    private static void renderDisabledSkill(GuiGraphics guiGraphics, ResourceLocation texture, int x, int y) {
        RenderSystem.setShaderTexture(0, texture);
        guiGraphics.blit(texture, x, y, 0, 0, 16, 16, 16, 16);
    }

    private static ResourceLocation getBaseTexture(int currentLevel, int maxLevel,
                                                   ResourceLocation normal, ResourceLocation maxed) {
        return currentLevel < maxLevel ? normal : maxed;
    }

    private static void renderBaseIcon(GuiGraphics guiGraphics, ResourceLocation texture, int x, int y) {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, texture);
        guiGraphics.blit(texture, x, y, 0, 0, 16, 16, 16, 16);
        RenderSystem.disableBlend();
    }

    private static void handleCooldown(GuiGraphics guiGraphics, float currentTime, float maxTime,
                                       ResourceLocation maskTexture, Font font,
                                       int x, int y) {
        // 确保时间值有效
        if (maxTime <= 0) return;

        // 计算冷却进度 (0.0 - 1.0)
        float progress = Math.min(1.0f, Math.max(0.0f, currentTime / maxTime));

        // 渲染冷却遮罩
        renderCooldownMask(guiGraphics, maskTexture, x, y, progress);

        // 渲染冷却时间文字
        renderCooldownText(guiGraphics, font, currentTime, x, y);
    }

    private static void handleCooldown(GuiGraphics guiGraphics, ResourceLocation maskTexture, int x, int y) {
        float progress = 16;
        renderCooldownMask(guiGraphics, maskTexture, x, y, progress);
    }

    private static void renderCooldownMask(GuiGraphics guiGraphics, ResourceLocation texture,
                                           int x, int y, float progress) {
        // 计算遮罩高度并确保在0-16范围内
        int height = (int)(16 * progress);
        height = Math.min(16, Math.max(0, height));

        if (height <= 0) return;

        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        RenderSystem.setShaderTexture(0, texture);

        // 计算渲染区域
        int renderY = y + (16 - height); // 从底部开始渲染

        // 确保不会渲染到图标范围外
        if (renderY < y) renderY = y;
        if (height > 16) height = 16;

        // 渲染遮罩部分
        guiGraphics.blit(texture,
                x, renderY,          // 渲染位置(x,y)
                0, 16 - height,     // 纹理UV坐标(u,v)
                16, height,         // 渲染宽度和高度
                16, 16);            // 纹理宽度和高度

        RenderSystem.disableBlend();
    }

    private static void renderCooldownText(GuiGraphics guiGraphics, Font font,
                                           float remainingTime, int x, int y) {
        String text = String.format(remainingTime / 20f >= 10 ? "%.0f" : "%.1f", remainingTime / 20f);
        int textWidth = font.width(text);

        // 计算居中位置
        int textX = x + 8 - textWidth / 2;
        int textY = y + 4;

        // 确保文字不会超出图标范围
        textX = Math.max(x, Math.min(x + 16 - textWidth, textX));
        textY = Math.max(y, Math.min(y + 16 - font.lineHeight, textY));

        // 带阴影的文字渲染
        guiGraphics.drawString(font, text, textX + 1, textY + 1, 0x000000, false);
        guiGraphics.drawString(font, text, textX, textY, 0xFFFFFF, false);
    }
}
