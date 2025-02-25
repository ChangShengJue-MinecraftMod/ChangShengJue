package com.shengchanshe.changshengjue.cilent.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

import java.util.Formatter;

public class CSJDisplayHud {
    public static void displayHud(GuiGraphics guiGraphics, ResourceLocation pAtlasLocation, int x, int y){
        RenderSystem.setShaderTexture(0, pAtlasLocation);
        // 绘制图标
        // 贴图，x坐标，y坐标，z坐标（图层 越高越不容易被遮盖）
        guiGraphics.blit(pAtlasLocation, x, y, 0, 0, 0, 16, 16,
                16, 16);
    }

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
        guiGraphics.blit(pAtlasLocation, x, y, 0, 0, 0,16,  frameTime + 16, 16, 16);
    }

    public static void displayHudPermanent(GuiGraphics guiGraphics, Font font,float frameTime,float frameTimeMax, int x, int y){
        // 绘制文字
//        PoseStack poseStack = guiGraphics.pose(); // 获取 PoseStack
//        poseStack.pushPose(); // 保存当前矩阵状态
//         设置缩放比例
//        float scale = 0.5f; // 0.5 表示缩放到 50%
//        poseStack.scale(scale, scale, scale);

        guiGraphics.drawCenteredString(font,new Formatter().format((frameTime * frameTimeMax) > 10 ? "%.0f" : "%.1f",(frameTime * frameTimeMax)).toString(),x + 8,y + 4, ChatFormatting.AQUA.getColor());
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


    public static void displayHudPermanent(int capabilityLevel, float frameTime, float frameTimeMax, boolean playerCanOpened, GuiGraphics guiGraphics,
                                           ResourceLocation pAtlasLocation0,ResourceLocation pAtlasLocation1,ResourceLocation pAtlasLocation2,ResourceLocation pAtlasLocation3, Font pFont, int x, int y){
        if (capabilityLevel > 0) {//获取技能等级,为零则绘制不可使用的技能贴图
            if (frameTime <= 0){ //获取技能剩余冷却时间,小于等于0则绘制技能贴图否则绘制冷却中的技能贴图
                if (playerCanOpened) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图
                    if (capabilityLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
                        CSJDisplayHud.displayHudPermanent(guiGraphics, pAtlasLocation0, x, y);
                    } else {
                        CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation1,x,y);
                    }
                }else {
                    if (capabilityLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
                        CSJDisplayHud.displayHudPermanent(guiGraphics, pAtlasLocation0, x, y);
                    } else {
                        CSJDisplayHud.displayHudPermanent(guiGraphics, pAtlasLocation1,x,y);
                    }
                    CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation3,x,y);
                }
            }else{
                float frameTimeMax_ = frameTimeMax / 20;
                float frameTime_ = ((frameTime / 20.0F) / frameTimeMax_);
                int v1 = (int) (16 * frameTime_ + 1);//计算技能剩余冷却时间
                if (playerCanOpened) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图并渲染技能剩余冷却时间
                    if (capabilityLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
                        CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation0,x,y);
                        CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation3,x,y);
                        CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation0,x,y,-v1);
                    } else {
                        CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation1,x,y);
                        CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation3,x,y);
                        CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation1,x,y,-v1);
                    }
                    //以文字形式绘制剩余冷却时间
                    CSJDisplayHud.displayHudPermanent(guiGraphics,pFont,frameTime_,frameTimeMax_,x,y);
                }else {
                    if (capabilityLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
                        CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation0,x,y);
                        CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation3,x,y);
                        CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation0,x,y,-v1);
                    } else {
                        CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation1,x,y);
                        CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation3,x,y);
                        CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation1,x,y,-v1);
                    }
                    CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation3,x,y);
                    CSJDisplayHud.displayHudPermanent(guiGraphics,pFont,frameTime_,frameTimeMax_,x,y);
                }
            }
        }else {
            CSJDisplayHud.displayHudPermanent(guiGraphics,pAtlasLocation2,x,y);
        }
    }
}
