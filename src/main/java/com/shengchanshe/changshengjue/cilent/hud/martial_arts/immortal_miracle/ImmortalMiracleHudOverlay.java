package com.shengchanshe.changshengjue.cilent.hud.martial_arts.immortal_miracle;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.hud.CSJDisplayHud;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.util.Formatter;

public class ImmortalMiracleHudOverlay {
    // 绘制的领悟后技能贴图的位置
    private static final ResourceLocation IMMORTAL_MIRACLE = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/immortal_miracle/immortal_miracle.png");
    // 绘制的大成后技能贴图的位置
    private static final ResourceLocation IMMORTAL_MIRACLE_1 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/immortal_miracle/immortal_miracle_1.png");
    // 绘制的技能不可使用的贴图的位置
    private static final ResourceLocation IMMORTAL_MIRACLE_2 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/immortal_miracle/immortal_miracle_2.png");
    //绘制技能冷却时的贴图位置
    private static final ResourceLocation COOLING = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/cooling.png");

    private static final Minecraft minecraft = Minecraft.getInstance();

    public static float frameTime() {
        return ImmortalMiracleClientData.getImmortalMiracleUseCooldownPercent();
    }
    public static float frameTimeMax() {
        return ImmortalMiracleClientData.getImmortalMiracleUseCooldownPercentMax();
    }
    public static boolean playerCanOpened() {
        int foodLevel = minecraft.player.getFoodData().getFoodLevel();
        return foodLevel > 8;
    }

    // 通过这个属性进行绘制，这个是一个IguiOverLay的接口，实现这个接口，注册他。
    // 通过lammbd表达式实现。
    public static final IGuiOverlay HUD_IMMORTAL_MIRACLE = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        boolean immortalMiracleComprehend = ImmortalMiracleClientData.isImmortalMiracleComprehend();
        boolean immortalMiracleOff = ImmortalMiracleClientData.isImmortalMiracleOff();
        if (immortalMiracleComprehend && immortalMiracleOff){
            int getImmortalMiracleLevel = ImmortalMiracleClientData.getImmortalMiracleLevel();
            // 通过宽高获得绘制的x，y
            int x = 5;
            int y = screenHeight / 2;
            //设置绘制的信息
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            if (ImmortalMiracleClientData.isSkillZActive()){
                CSJDisplayHud.displayHudPermanent(getImmortalMiracleLevel,frameTime(),frameTimeMax(),playerCanOpened(),guiGraphics,IMMORTAL_MIRACLE,IMMORTAL_MIRACLE_1,IMMORTAL_MIRACLE_2,COOLING,gui.getFont(),x,y - 20);
            }
            if (ImmortalMiracleClientData.isSkillXActive()){
                CSJDisplayHud.displayHudPermanent(getImmortalMiracleLevel,frameTime(),frameTimeMax(),playerCanOpened(),guiGraphics,IMMORTAL_MIRACLE,IMMORTAL_MIRACLE_1,IMMORTAL_MIRACLE_2,COOLING,gui.getFont(),x,y);
            }
            if (ImmortalMiracleClientData.isSkillCActive()){
                CSJDisplayHud.displayHudPermanent(getImmortalMiracleLevel,frameTime(),frameTimeMax(),playerCanOpened(),guiGraphics,IMMORTAL_MIRACLE,IMMORTAL_MIRACLE_1,IMMORTAL_MIRACLE_2,COOLING,gui.getFont(),x,y + 20);
            }
//            if (getImmortalMiracleLevel != 0) {//获取技能等级,为零则绘制不可使用的技能贴图
//                if (frameTime() <= 0){ //获取技能剩余冷却时间,小于等于0则绘制技能贴图否则绘制冷却中的技能贴图
//                    if (playerCanOpened()) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图
//                        if (getImmortalMiracleLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
//                            CSJDisplayHud.displayHudPermanent(guiGraphics, IMMORTAL_MIRACLE, x, y);
//                        } else {
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,IMMORTAL_MIRACLE_1,x,y);
//                        }
//                    }else {
//                        if (getImmortalMiracleLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
//                            CSJDisplayHud.displayHudPermanent(guiGraphics, IMMORTAL_MIRACLE, x, y);
//                        } else {
//                            CSJDisplayHud.displayHudPermanent(guiGraphics, IMMORTAL_MIRACLE_1,x,y);
//                        }
//                        CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                    }
//                }else{
//                    float frameTimeMax = frameTimeMax() / 20;
//                    float frameTime = ((frameTime() / 20) / frameTimeMax);
//                    int v1 = (int) (16 * frameTime + 1);//计算技能剩余冷却时间
//                    if (playerCanOpened()) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图并渲染技能剩余冷却时间
//                        if (getImmortalMiracleLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,IMMORTAL_MIRACLE,x,y);
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                            guiGraphics.blit(IMMORTAL_MIRACLE, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
//                        } else {
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,IMMORTAL_MIRACLE_1,x,y);
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                            guiGraphics.blit(IMMORTAL_MIRACLE_1, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
//                        }
//                        //以文字形式绘制剩余冷却时间
//                        guiGraphics.drawString(gui.getFont(),new Formatter().format("%.0f",(frameTime * frameTimeMax)).toString(),x + 2, y + 25, ChatFormatting.AQUA.getColor());
//                    }else {
//                        if (getImmortalMiracleLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,IMMORTAL_MIRACLE,x,y);
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                            guiGraphics.blit(IMMORTAL_MIRACLE, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
//                        } else {
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,IMMORTAL_MIRACLE_1,x,y);
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                            guiGraphics.blit(IMMORTAL_MIRACLE_1, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
//                        }
//                        CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                        guiGraphics.drawString(gui.getFont(),new Formatter().format("%.0f",(frameTime * frameTimeMax)).toString(),x + 2,y + 25, ChatFormatting.AQUA.getColor());
//                    }
//                }
//            }else {
//                CSJDisplayHud.displayHudPermanent(guiGraphics,IMMORTAL_MIRACLE_2,x,y);
//            }
        }
    };
}
