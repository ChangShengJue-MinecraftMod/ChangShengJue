package com.shengchanshe.changshengjue.cilent.hud.martial_arts.tread_the_snow_without_trace;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.hud.CSJDisplayHud;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.util.Formatter;

public class TreadTheSnowWithoutTraceHudOverlay {
    // 绘制的领悟后技能贴图的位置
    private static final ResourceLocation TREAD_THE_SNOW_WITHOUT_TRACE = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/tread_the_snow_without_trace/tread_the_snow_without_trace.png");
    // 绘制的大成后技能贴图的位置
    private static final ResourceLocation TREAD_THE_SNOW_WITHOUT_TRACE_1 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/tread_the_snow_without_trace/tread_the_snow_without_trace_1.png");
    // 绘制的技能不可使用的贴图的位置
    private static final ResourceLocation TREAD_THE_SNOW_WITHOUT_TRACE_2 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/tread_the_snow_without_trace/tread_the_snow_without_trace_2.png");
    //绘制技能冷却时的贴图位置
    private static final ResourceLocation COOLING = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/cooling.png");

    private static final Minecraft minecraft = Minecraft.getInstance();

    public static float frameTime() {
        return TreadTheSnowWithoutTraceClientData.getTreadTheSnowWithoutTraceUseCooldownPercent();
    }

    public static boolean playerCanOpened() {
        int foodLevel = minecraft.player.getFoodData().getFoodLevel();
        return foodLevel > 8;
    }

    // 通过这个属性进行绘制，这个是一个IguiOverLay的接口，实现这个接口，注册他。
    // 通过lammbd表达式实现。
    public static final IGuiOverlay HUD_TREAD_THE_SNOW_WITHOUT_TRACE = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        int getTreadTheSnowWithoutTraceLevel = TreadTheSnowWithoutTraceClientData.getTreadTheSnowWithoutTraceLevel();
        // 通过宽高获得绘制的x，y
        int x = 5;
        int y = (screenHeight / 2) - 50;
        boolean xuannuSwordsmanshipComprehend = TreadTheSnowWithoutTraceClientData.isTreadTheSnowWithoutTraceComprehend();
        if (xuannuSwordsmanshipComprehend && TreadTheSnowWithoutTraceClientData.getjumpCount() > 0){
            //设置绘制的信息
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(), ChatFormatting.BOLD + I18n.get("item.chang_sheng_jue.tread_the_snow_without_trace"),x, y,ChatFormatting.DARK_BLUE.getColor());
            if (getTreadTheSnowWithoutTraceLevel > 0) {//获取技能等级,为零则绘制不可使用的技能贴图
                if (playerCanOpened()) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图
                    if (getTreadTheSnowWithoutTraceLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
                        CSJDisplayHud.displayHud(guiGraphics, TREAD_THE_SNOW_WITHOUT_TRACE, x, y);
                    } else {
                        CSJDisplayHud.displayHud(guiGraphics,TREAD_THE_SNOW_WITHOUT_TRACE_1,x,y);
                    }
                }else {
                    CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                }
            }else {
                CSJDisplayHud.displayHud(guiGraphics,TREAD_THE_SNOW_WITHOUT_TRACE_2,x,y);
            }
        }
        if (frameTime() > 0){
            if (playerCanOpened()) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图并渲染技能剩余冷却时间
                float v = ((frameTime() / 20) / 5);
                int v1 = (int) (16 * v + 1);//计算技能剩余冷却时间
                if (getTreadTheSnowWithoutTraceLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
                    CSJDisplayHud.displayHud(guiGraphics,TREAD_THE_SNOW_WITHOUT_TRACE,x,y);
                    CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                    guiGraphics.blit(TREAD_THE_SNOW_WITHOUT_TRACE, x, y, 0, 0, 0,16, -v1 + 16, 16, 16);
                } else {
                    CSJDisplayHud.displayHud(guiGraphics,TREAD_THE_SNOW_WITHOUT_TRACE_1,x,y);
                    CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                    guiGraphics.blit(TREAD_THE_SNOW_WITHOUT_TRACE_1, x, y, 0, 0, 0,16, -v1 + 16, 16, 16);
                }
                //以文字形式绘制剩余冷却时间
                guiGraphics.drawString(gui.getFont(),new Formatter().format("%.1f",(v * 5)).toString(),x + 1, y + 4, ChatFormatting.AQUA.getColor());
                CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(), ChatFormatting.BOLD + I18n.get("item.chang_sheng_jue.tread_the_snow_without_trace"),x, y,ChatFormatting.DARK_BLUE.getColor());
            }else {
                if (getTreadTheSnowWithoutTraceLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
                    CSJDisplayHud.displayHud(guiGraphics,TREAD_THE_SNOW_WITHOUT_TRACE,x,y);
                    CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                    guiGraphics.blit(TREAD_THE_SNOW_WITHOUT_TRACE, x, y, 0, 0, 0,16, 16, 16, 16);
                } else {
                    CSJDisplayHud.displayHud(guiGraphics,TREAD_THE_SNOW_WITHOUT_TRACE_1,x,y);
                    CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                    guiGraphics.blit(TREAD_THE_SNOW_WITHOUT_TRACE_1, x, y, 0, 0, 0,16, 16, 16, 16);
                }
                CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(), ChatFormatting.BOLD + I18n.get("item.chang_sheng_jue.tread_the_snow_without_trace"),x, y,ChatFormatting.DARK_BLUE.getColor());
                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
            }
        }
    };
}