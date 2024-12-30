package com.shengchanshe.changshengjue.cilent.hud.martial_arts.ge_shan_da_niu;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.hud.CSJDisplayHud;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class GeShanDaNiuHudOverlay {
    // 绘制的领悟后技能贴图的位置
    private static final ResourceLocation GE_SHAN_DA_NIU = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/ge_shan_da_niu/ge_shan_da_niu.png");
    // 绘制的大成后技能贴图的位置
    private static final ResourceLocation GE_SHAN_DA_NIU_1 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/ge_shan_da_niu/ge_shan_da_niu_1.png");
    // 绘制的技能不可使用的贴图的位置
    private static final ResourceLocation GE_SHAN_DA_NIU_2 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/ge_shan_da_niu/ge_shan_da_niu_2.png");
    //绘制技能冷却时的贴图位置
    private static final ResourceLocation COOLING = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/cooling.png");

    private static final Minecraft minecraft = Minecraft.getInstance();

    public static float frameTime() {
        return GeShanDaNiuClientData.getGeShanDaNiuUseCooldownPercent();
    }
    public static float frameTimeMax() {
        return GeShanDaNiuClientData.getGeShanDaNiuUseCooldownPercentMax();
    }
    public static boolean playerCanOpened() {
        int foodLevel = minecraft.player.getFoodData().getFoodLevel();
        return foodLevel > 8;
    }

    // 通过这个属性进行绘制，这个是一个IguiOverLay的接口，实现这个接口，注册他。
    // 通过lammbd表达式实现。
    public static final IGuiOverlay HUD_GE_SHAN_DA_NIU = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        boolean geShanDaNiuComprehend = GeShanDaNiuClientData.isGeShanDaNiuComprehend();
        if (geShanDaNiuComprehend){
                int getGeShanDaNiuLevel = GeShanDaNiuClientData.getGeShanDaNiuLevel();
                // 通过宽高获得绘制的x，y
                int x = 5;
                int y = screenHeight / 2;
            //设置绘制的信息
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                if (GeShanDaNiuClientData.isSkillZActive()){
                    CSJDisplayHud.displayHudPermanent(getGeShanDaNiuLevel,frameTime(),frameTimeMax(),playerCanOpened(),guiGraphics,GE_SHAN_DA_NIU,GE_SHAN_DA_NIU_1,GE_SHAN_DA_NIU_2,COOLING,gui.getFont(),x,y - 20);
                }
                if (GeShanDaNiuClientData.isSkillXActive()){
                    CSJDisplayHud.displayHudPermanent(getGeShanDaNiuLevel,frameTime(),frameTimeMax(),playerCanOpened(),guiGraphics,GE_SHAN_DA_NIU,GE_SHAN_DA_NIU_1,GE_SHAN_DA_NIU_2,COOLING,gui.getFont(),x,y);
                }
                if (GeShanDaNiuClientData.isSkillCActive()){
                    CSJDisplayHud.displayHudPermanent(getGeShanDaNiuLevel,frameTime(),frameTimeMax(),playerCanOpened(),guiGraphics,GE_SHAN_DA_NIU,GE_SHAN_DA_NIU_1,GE_SHAN_DA_NIU_2,COOLING,gui.getFont(),x,y + 20);
                }
//            if (getGeShanDaNiuLevel != 0) {//获取技能等级,为零则绘制不可使用的技能贴图
//                if (frameTime() <= 0){ //获取技能剩余冷却时间,小于等于0则绘制技能贴图否则绘制冷却中的技能贴图
//                    if (playerCanOpened()) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图
//                        if (getGeShanDaNiuLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
//                            CSJDisplayHud.displayHudPermanent(guiGraphics, GE_SHAN_DA_NIU, x, y);
//                        } else {
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,GE_SHAN_DA_NIU_1,x,y);
//                        }
//                    }else {
//                        if (getGeShanDaNiuLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
//                            CSJDisplayHud.displayHudPermanent(guiGraphics, GE_SHAN_DA_NIU, x, y);
//                        } else {
//                            CSJDisplayHud.displayHudPermanent(guiGraphics, GE_SHAN_DA_NIU_1,x,y);
//                        }
//                        CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                    }
//                }else{
//                    float frameTimeMax = frameTimeMax() / 20;
//                    float frameTime = ((frameTime() / 20) / frameTimeMax);
//                    int v1 = (int) (16 * frameTime + 1);//计算技能剩余冷却时间
//                    if (playerCanOpened()) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图并渲染技能剩余冷却时间
//                        if (getGeShanDaNiuLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,GE_SHAN_DA_NIU,x,y);
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                            guiGraphics.blit(GE_SHAN_DA_NIU, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
//                        } else {
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,GE_SHAN_DA_NIU_1,x,y);
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                            guiGraphics.blit(GE_SHAN_DA_NIU_1, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
//                        }
//                        //以文字形式绘制剩余冷却时间
//                        guiGraphics.drawString(gui.getFont(),new Formatter().format("%.1f",(frameTime * frameTimeMax)).toString(),x + 1, y + 25, ChatFormatting.AQUA.getColor());
//                    }else {
//                        if (getGeShanDaNiuLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,GE_SHAN_DA_NIU,x,y);
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                            guiGraphics.blit(GE_SHAN_DA_NIU, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
//                        } else {
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,GE_SHAN_DA_NIU_1,x,y);
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                            guiGraphics.blit(GE_SHAN_DA_NIU_1, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
//                        }
//                        CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                        guiGraphics.drawString(gui.getFont(),new Formatter().format("%.1f",(frameTime * frameTimeMax)).toString(),x + 1,y + 25, ChatFormatting.AQUA.getColor());
//                    }
//                }
//            }else {
//                CSJDisplayHud.displayHudPermanent(guiGraphics,GE_SHAN_DA_NIU_2,x,y);
//            }
        }
    };
}
