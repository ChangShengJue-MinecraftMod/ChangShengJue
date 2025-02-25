package com.shengchanshe.changshengjue.cilent.hud.martial_arts.turtle_breath_work;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.hud.CSJDisplayHud;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class TurtleBreathWorkHudOverlay {
    // 绘制的领悟后技能贴图的位置
    private static final ResourceLocation TURTLE_BREATH_WORK = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/turtle_breath_work/turtle_breath_work.png");
    // 绘制的大成后技能贴图的位置
    private static final ResourceLocation TURTLE_BREATH_WORK_1 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/turtle_breath_work/turtle_breath_work_1.png");
    // 绘制的技能不可使用的贴图的位置
    private static final ResourceLocation TURTLE_BREATH_WORK_2 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/turtle_breath_work/turtle_breath_work_2.png");
    //绘制技能冷却时的贴图位置
    private static final ResourceLocation COOLING = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/cooling.png");

    private static final Minecraft minecraft = Minecraft.getInstance();

    public static float frameTime() {
        return TurtleBreathWorkClientData.getTurtleBreathWorkUseCooldownPercent();
    }
    public static float frameTimeMax() {
        return 900;
    }

    public static boolean playerCanOpened() {
        int foodLevel = minecraft.player.getFoodData().getFoodLevel();
        return foodLevel > 8;
    }

    // 通过这个属性进行绘制，这个是一个IguiOverLay的接口，实现这个接口，注册他。
    // 通过lammbd表达式实现。
    public static final IGuiOverlay HUD_TURTLE_BREATH_WORK = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        boolean turtleBreathWorkComprehend = TurtleBreathWorkClientData.isTurtleBreathWorkComprehend();
        if (turtleBreathWorkComprehend){
            int getTurtleBreathWorkLevel = TurtleBreathWorkClientData.getTurtleBreathWorkLevel();
            // 通过宽高获得绘制的x，y
            int x = 5;
            int y = screenHeight / 2;
            //设置绘制的信息
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            if (TurtleBreathWorkClientData.isSkillZActive()){
                CSJDisplayHud.displayHudPermanent(getTurtleBreathWorkLevel,frameTime(),frameTimeMax(),playerCanOpened(),guiGraphics,TURTLE_BREATH_WORK,TURTLE_BREATH_WORK_1,TURTLE_BREATH_WORK_2,COOLING,gui.getFont(),x,y - 25);
                CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item.chang_sheng_jue.turtle_breath_work"),x, y - 25,ChatFormatting.BLUE.getColor());
            }
            if (TurtleBreathWorkClientData.isSkillXActive()){
                CSJDisplayHud.displayHudPermanent(getTurtleBreathWorkLevel,frameTime(),frameTimeMax(),playerCanOpened(),guiGraphics,TURTLE_BREATH_WORK,TURTLE_BREATH_WORK_1,TURTLE_BREATH_WORK_2,COOLING,gui.getFont(),x,y);
                CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item.chang_sheng_jue.turtle_breath_work"),x, y,ChatFormatting.BLUE.getColor());
            }
            if (TurtleBreathWorkClientData.isSkillCActive()){
                CSJDisplayHud.displayHudPermanent(getTurtleBreathWorkLevel,frameTime(),frameTimeMax(),playerCanOpened(),guiGraphics,TURTLE_BREATH_WORK,TURTLE_BREATH_WORK_1,TURTLE_BREATH_WORK_2,COOLING,gui.getFont(),x,y + 25);
                CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item.chang_sheng_jue.turtle_breath_work"),x, y + 25,ChatFormatting.BLUE.getColor());
            }
        }
    };
}
