package com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.qian_kun_da_nuo_yi;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.cilent.hud.CSJDisplayHud;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

@OnlyIn(Dist.CLIENT)
public class QianKunDaNuoYiHudOverlay {
    // 绘制的领悟后技能贴图的位置
    private static final ResourceLocation QIAN_KUN_DA_NUO_YI = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/qian_kun_da_nuo_yi/qian_kun_da_nuo_yi.png");
    // 绘制的大成后技能贴图的位置
    private static final ResourceLocation QIAN_KUN_DA_NUO_YI_1 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/qian_kun_da_nuo_yi/qian_kun_da_nuo_yi_1.png");
    // 绘制的技能不可使用的贴图的位置
    private static final ResourceLocation QIAN_KUN_DA_NUO_YI_2 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/qian_kun_da_nuo_yi/qian_kun_da_nuo_yi_2.png");
    //绘制技能冷却时的贴图位置
    private static final ResourceLocation COOLING = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/cooling.png");

    private static final Minecraft minecraft = Minecraft.getInstance();

    public static float frameTime() {
        return QianKunDaNuoYiClientData.getQianKunDaNuoYiUseCooldownPercent();
    }

    public static float frameTimeMax() {
        return QianKunDaNuoYiClientData.isQianKunDaNuoYiUseCooldownMax();
    }

    public static boolean playerCanOpened() {
        int foodLevel = minecraft.player.getFoodData().getFoodLevel();
        return foodLevel > 8;
    }

    // 通过这个属性进行绘制，这个是一个IguiOverLay的接口，实现这个接口，注册他。
    // 通过lammbd表达式实现。
    public static final IGuiOverlay HUD_QIAN_KUN_DA_NUO_YI = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (QianKunDaNuoYiClientData.isSkillActive() && frameTime() > 0) {
            boolean qianKunDaNuoYiComprehend = QianKunDaNuoYiClientData.isQianKunDaNuoYiComprehend();
            if (qianKunDaNuoYiComprehend) {
                int getQianKunDaNuoYiLevel = QianKunDaNuoYiClientData.getQianKunDaNuoYiLevel();
                // 通过宽高获得绘制的x，y
                int x = 5;
                int y = screenHeight / 2;
//                int textureYPosition;
//                if (GoldenBellJarClientData.getGoldenBellJarUseCooldownPercent() > 0){
//                    textureYPosition = 50;
//                }else {
//                    textureYPosition = 25;
//                }
                //设置绘制的信息
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                CSJDisplayHud.displayHudPermanent(getQianKunDaNuoYiLevel, frameTime(), frameTimeMax(),
                        playerCanOpened(), guiGraphics, QIAN_KUN_DA_NUO_YI, QIAN_KUN_DA_NUO_YI_1, QIAN_KUN_DA_NUO_YI_2, COOLING, gui.getFont(),
                        x, y + 50);
                CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item."+ ChangShengJue.MOD_ID +".qian_kun_da_nuo_yi"),
                        x, y + 50, ChatFormatting.YELLOW.getColor());
            }
        }
    };
}
