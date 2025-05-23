package com.shengchanshe.changshengjue.cilent.hud.martial_arts.hercules;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.hud.CSJDisplayHud;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_bell_jar.GoldenBellJarClientData;
import com.shengchanshe.changshengjue.item.combat.glove.GoldThreadGlove;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class HerculesHudOverlay {
    // 绘制的领悟后技能贴图的位置
    private static final ResourceLocation HERCULES = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/hercules/hercules.png");
    // 绘制的大成后技能贴图的位置
    private static final ResourceLocation HERCULES_1 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/hercules/hercules_1.png");
    // 绘制的技能不可使用的贴图的位置
    private static final ResourceLocation HERCULES_2 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/hercules/hercules_2.png");
    //绘制技能冷却时的贴图位置
    private static final ResourceLocation COOLING = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/cooling.png");

    private static final Minecraft minecraft = Minecraft.getInstance();

    public static float frameTime() {
        return 0;
    }

    public static float frameTimeMax() {
        return 0;
    }

    public static boolean playerCanOpened() {
        int foodLevel = minecraft.player.getFoodData().getFoodLevel();
        return foodLevel > 0;
    }
    public static boolean shouldDisplayHud() {
        LocalPlayer player = minecraft.player;
        ItemStack mainHand = player.getMainHandItem();
        return mainHand.getItem() instanceof GoldThreadGlove;
    }

    // 通过这个属性进行绘制，这个是一个IguiOverLay的接口，实现这个接口，注册他。
    // 通过lammbd表达式实现。
    public static final IGuiOverlay HUD_HERCULES = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (shouldDisplayHud() && HerculesClientData.isSkillActive()) {
            boolean herculesComprehend = HerculesClientData.isHerculesComprehend();
            if (herculesComprehend) {
                int getHerculesLevel = HerculesClientData.getHerculesLevel();
                // 通过宽高获得绘制的x，y
                int x = 5;
                int y = screenHeight / 2;
                //设置绘制的信息
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                CSJDisplayHud.displayHudPermanent(getHerculesLevel, frameTime(), frameTimeMax(), playerCanOpened(), guiGraphics, HERCULES, HERCULES_1, HERCULES_2, COOLING, gui.getFont(), x, y);
                CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item."+ ChangShengJue.MOD_ID +".hercules"), x, y, ChatFormatting.YELLOW.getColor());
            }
        }
    };
}