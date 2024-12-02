package com.shengchanshe.changshengjue.cilent.hud.martial_arts.dugu_nine_swords;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.sword.Sword;
import com.shengchanshe.changshengjue.cilent.hud.CSJDisplayHud;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.util.Formatter;

public class DuguNineSwordsHudOverlay {
    // 绘制的领悟后技能贴图的位置
    private static final ResourceLocation DUGU_NINE_SWORDS = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/dugu_nine_swords/dugu_nine_swords.png");
    // 绘制的大成后技能贴图的位置
    private static final ResourceLocation DUGU_NINE_SWORDS_1 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/dugu_nine_swords/dugu_nine_swords_1.png");
    // 绘制的技能不可使用的贴图的位置
    private static final ResourceLocation DUGU_NINE_SWORDS_2 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/dugu_nine_swords/dugu_nine_swords_2.png");
    //绘制技能冷却时的贴图位置
    private static final ResourceLocation COOLING = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/cooling.png");

    private static final Minecraft minecraft = Minecraft.getInstance();

    public static boolean shouldDisplayHud() {
        LocalPlayer player = minecraft.player;
        ItemStack mainHand = player.getMainHandItem();
        return mainHand.getItem() instanceof Sword && mainHand.getItem() != ChangShengJueItems.SOFT_SWORD.get();
    }

    public static float frameTime() {
        LocalPlayer player = minecraft.player;
        ItemStack mainHand = player.getMainHandItem();
        if(mainHand.getItem() instanceof Sword && mainHand.getItem() != ChangShengJueItems.SOFT_SWORD.get()){
            float cooldownPercent = player.getCooldowns().getCooldownPercent(mainHand.getItem(), Minecraft.getInstance().getFrameTime());
            return cooldownPercent;
        }else {
            return 0.0f;
        }
    }

    public static boolean playerCanOpened() {
        int foodLevel = minecraft.player.getFoodData().getFoodLevel();
        return foodLevel > 8;
    }

    // 通过这个属性进行绘制，这个是一个IguiOverLay的接口，实现这个接口，注册他。
    // 通过lammbd表达式实现。
    public static final IGuiOverlay HUD_DUGU_NINE_SWORDS = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (shouldDisplayHud()) {
            boolean duguNineSwordsComprehend = DuguNineSwordsClientData.isDuguNineSwordsComprehend();
            if (duguNineSwordsComprehend){
                int duguNineSwordsLevel = DuguNineSwordsClientData.getDuguNineSwordsLevel();
                // 通过宽高获得绘制的x，y
                int x = 5;
                int y = screenHeight / 2;
                //设置绘制的信息
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                if (duguNineSwordsLevel != 0) {
                    if (frameTime() <= 0){
                        if (playerCanOpened()) {
                            if (duguNineSwordsLevel < 2) {
                                CSJDisplayHud.displayHud(guiGraphics, DUGU_NINE_SWORDS, x, y);
                            } else {
                                CSJDisplayHud.displayHud(guiGraphics,DUGU_NINE_SWORDS_1,x,y);
                            }
                        }else {
                            CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                        }
                    }else{
                        if (playerCanOpened()) {

                            float v = frameTime();
                            int v1 = (int) (16 * v + 1);
                            if (duguNineSwordsLevel < 2) {
                                CSJDisplayHud.displayHud(guiGraphics,DUGU_NINE_SWORDS,x,y);
                                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                                guiGraphics.blit(DUGU_NINE_SWORDS, x, y, 90, 0, 0,16, -v1 + 16, 16, 16);
                            } else {
                                CSJDisplayHud.displayHud(guiGraphics,DUGU_NINE_SWORDS_1,x,y);
                                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                                guiGraphics.blit(DUGU_NINE_SWORDS_1, x, y, 90, 0, 0,16, -v1 + 16, 16, 16);
                            }
                            guiGraphics.drawString(gui.getFont(),new Formatter().format("%.1f",(frameTime() * 5)).toString(),x + 1, y + 20, ChatFormatting.AQUA.getColor());
                        }else {
                            CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                            guiGraphics.drawString(gui.getFont(),new Formatter().format("%.1f",(frameTime() * 5)).toString(),x + 1, y + 20, ChatFormatting.AQUA.getColor());
                        }
                    }
                }else {
                    CSJDisplayHud.displayHud(guiGraphics,DUGU_NINE_SWORDS_2,x,y);
                }
            }
        }
    };
}
