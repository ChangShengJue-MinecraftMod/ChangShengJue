package com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_bell_jar;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.hud.CSJDisplayHud;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.util.Formatter;

public class GoldenBellJarHudOverlay {
    // 绘制的领悟后技能贴图的位置
    private static final ResourceLocation GOLDEN_BELL_JAR = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/golden_bell_jar/golden_bell_jar.png");
    // 绘制的大成后技能贴图的位置
    private static final ResourceLocation GOLDEN_BELL_JAR_1 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/golden_bell_jar/golden_bell_jar_1.png");
    // 绘制的技能不可使用的贴图的位置
    private static final ResourceLocation GOLDEN_BELL_JAR_2 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/golden_bell_jar/golden_bell_jar_2.png");
    //绘制技能冷却时的贴图位置
    private static final ResourceLocation COOLING = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/cooling.png");

    private static final Minecraft minecraft = Minecraft.getInstance();


    public static float frameTime() {
        return GoldenBellJarClientData.getGoldenBellJarUseCooldownPercent();
    }

    public static boolean playerCanOpened() {
        int foodLevel = minecraft.player.getFoodData().getFoodLevel();
        return foodLevel > 8;
    }

    // 通过这个属性进行绘制，这个是一个IguiOverLay的接口，实现这个接口，注册他。
    // 通过lammbd表达式实现。
    public static final IGuiOverlay HUD_GOLDEN_BELL_JAR = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        boolean goldenBellJarComprehend = GoldenBellJarClientData.isGoldenBellJarComprehend();
        boolean goldenBellJarOff = GoldenBellJarClientData.isGoldenBellJarOff();
        if (goldenBellJarComprehend && goldenBellJarOff){
            int getGoldenBellJarLevel = GoldenBellJarClientData.getGoldenBellJarLevel();
            // 通过宽高获得绘制的x，y
            int x = 5;
            int y = screenHeight / 2;
            //设置绘制的信息
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            if (getGoldenBellJarLevel != 0) {//获取技能等级,为零则绘制不可使用的技能贴图
                if (frameTime() <= 0){ //获取技能剩余冷却时间,小于等于0则绘制技能贴图否则绘制冷却中的技能贴图
                    if (playerCanOpened()) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图
                        if (getGoldenBellJarLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
                            CSJDisplayHud.displayHudPermanent(guiGraphics, GOLDEN_BELL_JAR, x, y);
                        } else {
                            CSJDisplayHud.displayHudPermanent(guiGraphics,GOLDEN_BELL_JAR_1,x,y);
                        }
                    }else {
                        if (getGoldenBellJarLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
                            CSJDisplayHud.displayHudPermanent(guiGraphics, GOLDEN_BELL_JAR, x, y);
                        } else {
                            CSJDisplayHud.displayHudPermanent(guiGraphics,GOLDEN_BELL_JAR_1,x,y);
                        }
                        CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
                    }
                }else{
                    float v = ((frameTime() / 20) / 8);
                    int v1 = (int) (16 * v + 1);//计算技能剩余冷却时间
                    if (playerCanOpened()) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图并渲染技能剩余冷却时间
                        if (getGoldenBellJarLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
                            CSJDisplayHud.displayHudPermanent(guiGraphics,GOLDEN_BELL_JAR,x,y);
                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
                            guiGraphics.blit(GOLDEN_BELL_JAR, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
                        } else {
                            CSJDisplayHud.displayHudPermanent(guiGraphics,GOLDEN_BELL_JAR_1,x,y);
                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
                            guiGraphics.blit(GOLDEN_BELL_JAR_1, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
                        }
                        //以文字形式绘制剩余冷却时间
                        guiGraphics.drawString(gui.getFont(),new Formatter().format("%.1f",(v * 8)).toString(),x + 1, y + 25, ChatFormatting.AQUA.getColor());
                    }else {
                        if (getGoldenBellJarLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
                            CSJDisplayHud.displayHudPermanent(guiGraphics,GOLDEN_BELL_JAR,x,y);
                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
                            guiGraphics.blit(GOLDEN_BELL_JAR, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
                        } else {
                            CSJDisplayHud.displayHudPermanent(guiGraphics,GOLDEN_BELL_JAR_1,x,y);
                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
                            guiGraphics.blit(GOLDEN_BELL_JAR_1, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
                        }
                        CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
                        guiGraphics.drawString(gui.getFont(),new Formatter().format("%.1f",(v * 8)).toString(),x + 1,y + 25, ChatFormatting.AQUA.getColor());
                    }
                }
            }else {
                CSJDisplayHud.displayHudPermanent(guiGraphics,GOLDEN_BELL_JAR_2,x,y);
            }
        }
    };
}
