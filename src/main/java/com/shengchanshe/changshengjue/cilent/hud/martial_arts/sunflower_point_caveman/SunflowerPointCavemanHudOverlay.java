package com.shengchanshe.changshengjue.cilent.hud.martial_arts.sunflower_point_caveman;

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
public class SunflowerPointCavemanHudOverlay {
    // 绘制的领悟后技能贴图的位置
    private static final ResourceLocation SUNFLOWER_POINT_CAVEMAN = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/sunflower_point_caveman/sunflower_point_caveman.png");
    // 绘制的大成后技能贴图的位置
    private static final ResourceLocation SUNFLOWER_POINT_CAVEMAN_1 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/sunflower_point_caveman/sunflower_point_caveman_1.png");
    // 绘制的技能不可使用的贴图的位置
    private static final ResourceLocation SUNFLOWER_POINT_CAVEMAN_2 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/sunflower_point_caveman/sunflower_point_caveman_2.png");
    //绘制技能冷却时的贴图位置
    private static final ResourceLocation COOLING = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/cooling.png");

    private static final Minecraft minecraft = Minecraft.getInstance();

    public static float frameTime() {
        return SunflowerPointCavemanClientData.getSunflowerPointCavemanUseCooldownPercent();
    }

    public static float frameTimeMax() {
        return 180;
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
    public static final IGuiOverlay HUD_SUNFLOWER_POINT_CAVEMAN = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (shouldDisplayHud() && SunflowerPointCavemanClientData.isSkillActive()) {
            boolean sunflowerPointCavemanComprehend = SunflowerPointCavemanClientData.isSunflowerPointCavemanComprehend();
            if (sunflowerPointCavemanComprehend) {
                int getSunflowerPointCavemanLevel = SunflowerPointCavemanClientData.getSunflowerPointCavemanLevel();
                // 通过宽高获得绘制的x，y
                int x = 5;
                int y = screenHeight / 2;
                //设置绘制的信息
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                CSJDisplayHud.displayHudPermanent(getSunflowerPointCavemanLevel, frameTime(), frameTimeMax(), playerCanOpened(), guiGraphics, SUNFLOWER_POINT_CAVEMAN, SUNFLOWER_POINT_CAVEMAN_1, SUNFLOWER_POINT_CAVEMAN_2, COOLING, gui.getFont(), x, y);
                CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item." + ChangShengJue.MOD_ID + ".sunflower_point_caveman"), x, y, ChatFormatting.YELLOW.getColor());
//            if (getSunflowerPointCavemanLevel != 0) {//获取技能等级,为零则绘制不可使用的技能贴图
//                if (frameTime() <= 0){ //获取技能剩余冷却时间,小于等于0则绘制技能贴图否则绘制冷却中的技能贴图
//                    if (playerCanOpened()) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图
//                        if (getSunflowerPointCavemanLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
//                            CSJDisplayHud.displayHudPermanent(guiGraphics, SUNFLOWER_POINT_CAVEMAN, x, y);
//                        } else {
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,SUNFLOWER_POINT_CAVEMAN_1,x,y);
//                        }
//                    }else {
//                        if (getSunflowerPointCavemanLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
//                            CSJDisplayHud.displayHudPermanent(guiGraphics, SUNFLOWER_POINT_CAVEMAN, x, y);
//                        } else {
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,SUNFLOWER_POINT_CAVEMAN_1,x,y);
//                        }
//                        CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                    }
//                }else{
//                    float v = ((frameTime() / 20) / 9);
//                    int v1 = (int) (16 * v + 1);//计算技能剩余冷却时间
//                    if (playerCanOpened()) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图并渲染技能剩余冷却时间
//                        if (getSunflowerPointCavemanLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,SUNFLOWER_POINT_CAVEMAN,x,y);
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                            guiGraphics.blit(SUNFLOWER_POINT_CAVEMAN, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
//                        } else {
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,SUNFLOWER_POINT_CAVEMAN_1,x,y);
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                            guiGraphics.blit(SUNFLOWER_POINT_CAVEMAN_1, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
//                        }
//                        //以文字形式绘制剩余冷却时间
//                        guiGraphics.drawString(gui.getFont(),new Formatter().format("%.1f",(v * 9)).toString(),x + 1, y + 25, ChatFormatting.AQUA.getColor());
//                    }else {
//                        if (getSunflowerPointCavemanLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,SUNFLOWER_POINT_CAVEMAN,x,y);
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                            guiGraphics.blit(SUNFLOWER_POINT_CAVEMAN, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
//                        } else {
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,SUNFLOWER_POINT_CAVEMAN_1,x,y);
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                            guiGraphics.blit(SUNFLOWER_POINT_CAVEMAN_1, x, y + 20, 0, 0, 0,16, -v1 + 16, 16, 16);
//                        }
//                        CSJDisplayHud.displayHudPermanent(guiGraphics,COOLING,x,y);
//                        guiGraphics.drawString(gui.getFont(),new Formatter().format("%.1f",(v * 9)).toString(),x + 1,y + 25, ChatFormatting.AQUA.getColor());
//                    }
//                }
//            }else {
//                CSJDisplayHud.displayHudPermanent(guiGraphics,SUNFLOWER_POINT_CAVEMAN_2,x,y);
//            }
            }
        }
    };
}
