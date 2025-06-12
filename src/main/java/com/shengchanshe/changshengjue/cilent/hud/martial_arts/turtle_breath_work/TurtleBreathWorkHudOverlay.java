package com.shengchanshe.changshengjue.cilent.hud.martial_arts.turtle_breath_work;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.hud.CSJDisplayHud;
import com.shengchanshe.changshengjue.item.combat.glove.GoldThreadGlove;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

@OnlyIn(Dist.CLIENT)
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

    public static boolean shouldDisplayHud() {
        LocalPlayer player = minecraft.player;
        ItemStack mainHand = player.getMainHandItem();
        return mainHand.getItem() instanceof GoldThreadGlove;
    }

    // 通过这个属性进行绘制，这个是一个IguiOverLay的接口，实现这个接口，注册他。
    // 通过lammbd表达式实现。
    public static final IGuiOverlay HUD_TURTLE_BREATH_WORK = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (shouldDisplayHud() && TurtleBreathWorkClientData.isSkillActive()) {
            boolean turtleBreathWorkComprehend = TurtleBreathWorkClientData.isTurtleBreathWorkComprehend();
            if (turtleBreathWorkComprehend) {
                int getTurtleBreathWorkLevel = TurtleBreathWorkClientData.getTurtleBreathWorkLevel();
                // 通过宽高获得绘制的x，y
                int x = 5;
                int y = screenHeight / 2;
                //设置绘制的信息
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                CSJDisplayHud.displayHudPermanent(getTurtleBreathWorkLevel, frameTime(), frameTimeMax(), playerCanOpened(), guiGraphics, TURTLE_BREATH_WORK, TURTLE_BREATH_WORK_1, TURTLE_BREATH_WORK_2, COOLING, gui.getFont(), x, y);
                CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item." + ChangShengJue.MOD_ID + ".turtle_breath_work"), x, y, ChatFormatting.BLUE.getColor());
            }
        }
    };
}
