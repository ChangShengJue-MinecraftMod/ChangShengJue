package com.shengchanshe.changshengjue.cilent.hud.martial_arts.relentless_throwing_knives;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.hud.CSJDisplayHud;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesClientData;
import com.shengchanshe.changshengjue.item.combat.knife.Knife;
import com.shengchanshe.changshengjue.item.combat.throwingknives.SevenThrowingKnives;
import com.shengchanshe.changshengjue.item.combat.throwingknives.ThreeThrowingKnives;
import com.shengchanshe.changshengjue.item.combat.throwingknives.ThrowingKnives;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.util.Formatter;

public class RelentlessThrowingKnivesHudOverlay {
    // 绘制的领悟后技能贴图的位置
    private static final ResourceLocation RELENTLESS_THROWING_KNIVES = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/relentless_throwing_knives/relentless_throwing_knives.png");
    // 绘制的大成后技能贴图的位置
    private static final ResourceLocation RELENTLESS_THROWING_KNIVES_1 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/relentless_throwing_knives/relentless_throwing_knives_1.png");
    // 绘制的技能不可使用的贴图的位置
    private static final ResourceLocation RELENTLESS_THROWING_KNIVES_2 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/relentless_throwing_knives/relentless_throwing_knives_2.png");
    //绘制技能冷却时的贴图位置
    private static final ResourceLocation COOLING = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/cooling.png");

    private static final Minecraft minecraft = Minecraft.getInstance();

    public static boolean shouldDisplayHud() {
        LocalPlayer player = minecraft.player;
        ItemStack mainHand = player.getMainHandItem();
        return mainHand.getItem() instanceof ThrowingKnives || mainHand.getItem() instanceof ThreeThrowingKnives || mainHand.getItem() instanceof SevenThrowingKnives;
    }

    public static float frameTime() {
        return RelentlessThrowingKnivesClientData.getRelentlessThrowingKnivesUseCooldownPercent();
    }

    public static boolean playerCanOpened() {
        int foodLevel = minecraft.player.getFoodData().getFoodLevel();
        return foodLevel > 8;
    }

    // 通过这个属性进行绘制，这个是一个IguiOverLay的接口，实现这个接口，注册他。
    // 通过lammbd表达式实现。
    public static final IGuiOverlay HUD_RELENTLESS_THROWING_KNIVES = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (shouldDisplayHud()) {
            boolean relentlessThrowingKnivesComprehend = RelentlessThrowingKnivesClientData.isRelentlessThrowingKnivesComprehend();
            // 通过宽高获得绘制的x，y
            int x = 5;
            int y = (screenHeight / 2) - 50;
            if (relentlessThrowingKnivesComprehend){
                CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(), ChatFormatting.BOLD + I18n.get("item.chang_sheng_jue.relentless_throwing_knives"),x, y,ChatFormatting.BLUE.getColor());
                int getRelentlessThrowingKnivesLevel = RelentlessThrowingKnivesClientData.getRelentlessThrowingKnivesLevel();
                //设置绘制的信息
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                if (getRelentlessThrowingKnivesLevel != 0) {//获取技能等级,为零则绘制不可使用的技能贴图
                    if (frameTime() <= 0){ //获取技能剩余冷却时间,小于等于0则绘制技能贴图否则绘制冷却中的技能贴图
                        if (playerCanOpened()) {
                            if (getRelentlessThrowingKnivesLevel < 2) {
                                CSJDisplayHud.displayHud(guiGraphics, RELENTLESS_THROWING_KNIVES, x, y);
                            } else {
                                CSJDisplayHud.displayHud(guiGraphics,RELENTLESS_THROWING_KNIVES_1,x,y);
                            }
                        }else {
                            if (getRelentlessThrowingKnivesLevel < 2) {
                                CSJDisplayHud.displayHud(guiGraphics, RELENTLESS_THROWING_KNIVES, x, y);
                            } else {
                                CSJDisplayHud.displayHud(guiGraphics,RELENTLESS_THROWING_KNIVES_1,x,y);
                            }
                            CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                        }
                    }else{
                        float frameTimeMax_ = 8 / 20F;
                        float frameTime_ = ((frameTime() / 20.0F) / frameTimeMax_);
                        int v1 = (int) (16 * frameTime_ + 1);//计算技能剩余冷却时间
                        if (playerCanOpened()) {
                            if (getRelentlessThrowingKnivesLevel < 2) {
                                CSJDisplayHud.displayHud(guiGraphics,RELENTLESS_THROWING_KNIVES,x,y);
                                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                                guiGraphics.blit(RELENTLESS_THROWING_KNIVES, x, y, 0, 0, 0,16, -v1 + 16, 16, 16);
                            } else {
                                CSJDisplayHud.displayHud(guiGraphics,RELENTLESS_THROWING_KNIVES_1,x,y);
                                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                                guiGraphics.blit(RELENTLESS_THROWING_KNIVES_1, x, y, 0, 0, 0,16, -v1 + 16, 16, 16);
                            }
                            guiGraphics.drawString(gui.getFont(),new Formatter().format("%.1f",(frameTime_ * frameTimeMax_)).toString(),x + 1, y + 5, ChatFormatting.AQUA.getColor());
                        }else {
                            if (getRelentlessThrowingKnivesLevel < 2) {
                                CSJDisplayHud.displayHud(guiGraphics,RELENTLESS_THROWING_KNIVES,x,y);
                                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                                guiGraphics.blit(RELENTLESS_THROWING_KNIVES, x, y, 0, 0, 0,16, -v1 + 16, 16, 16);
                            } else {
                                CSJDisplayHud.displayHud(guiGraphics,RELENTLESS_THROWING_KNIVES_1,x,y);
                                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                                guiGraphics.blit(RELENTLESS_THROWING_KNIVES_1, x, y, 0, 0, 0,16, -v1 + 16, 16, 16);
                            }
                            CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
                            guiGraphics.drawString(gui.getFont(),new Formatter().format("%.1f",(frameTime_ * frameTimeMax_)).toString(),x + 1, y + 5, ChatFormatting.AQUA.getColor());
                        }
                    }
                }else {
                    CSJDisplayHud.displayHud(guiGraphics,RELENTLESS_THROWING_KNIVES_2,x,y);
                }
            }
        }
    };
}
