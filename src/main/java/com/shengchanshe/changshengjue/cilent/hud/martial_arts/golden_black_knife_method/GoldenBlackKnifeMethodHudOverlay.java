package com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_black_knife_method;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.hud.CSJDisplayHud;
import com.shengchanshe.changshengjue.item.combat.knife.Knife;
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
public class GoldenBlackKnifeMethodHudOverlay {
    // 绘制的领悟后技能贴图的位置
    private static final ResourceLocation GOLDEN_BLACK_KNIFE_METHOD = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/golden_black_knife_method/golden_black_knife_method.png");
    // 绘制的大成后技能贴图的位置
    private static final ResourceLocation GOLDEN_BLACK_KNIFE_METHOD_1 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/golden_black_knife_method/golden_black_knife_method_1.png");
    // 绘制的技能不可使用的贴图的位置
    private static final ResourceLocation GOLDEN_BLACK_KNIFE_METHOD_2 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/golden_black_knife_method/golden_black_knife_method_2.png");
    //绘制技能冷却时的贴图位置
    private static final ResourceLocation COOLING = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/cooling.png");

    private static final Minecraft minecraft = Minecraft.getInstance();

    public static boolean shouldDisplayHud() {
        LocalPlayer player = minecraft.player;
        ItemStack mainHand = player.getMainHandItem();
        return mainHand.getItem() instanceof Knife;
    }

    public static float frameTime() {
        LocalPlayer player = minecraft.player;
        ItemStack mainHand = player.getMainHandItem();
        if(mainHand.getItem() instanceof Knife){
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
    public static final IGuiOverlay HUD_GOLDEN_BLACK_KNIFE_METHOD = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (shouldDisplayHud()) {
            boolean goldenBlackKnifeMethodComprehend = GoldenBlackKnifeMethodClientData.isGoldenBlackKnifeMethodComprehend();
            // 通过宽高获得绘制的x，y
            int x = 5;
            int y = screenHeight / 2;
            if (goldenBlackKnifeMethodComprehend){
//                CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(),ChatFormatting.BOLD + I18n.get("item."+ ChangShengJue.MOD_ID +".golden_black_knife_method"),x, y,ChatFormatting.GOLD.getColor());
                int getGoldenBlackKnifeMethodLevel = GoldenBlackKnifeMethodClientData.getGoldenBlackKnifeMethodLevel();
                //设置绘制的信息
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                CSJDisplayHud.displayHudPermanent1(getGoldenBlackKnifeMethodLevel,frameTime(),7,playerCanOpened(),guiGraphics,GOLDEN_BLACK_KNIFE_METHOD,GOLDEN_BLACK_KNIFE_METHOD_1,GOLDEN_BLACK_KNIFE_METHOD_2,COOLING,gui.getFont(),x,y);
                CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item."+ ChangShengJue.MOD_ID +".golden_black_knife_method"),x, y,ChatFormatting.GOLD.getColor());
//                if (getGoldenBlackKnifeMethodLevel != 0) {//获取技能等级,为零则绘制不可使用的技能贴图
//                    if (frameTime() <= 0){ //获取技能剩余冷却时间,小于等于0则绘制技能贴图否则绘制冷却中的技能贴图
//                        if (playerCanOpened()) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图
//                            if (getGoldenBlackKnifeMethodLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
//                                CSJDisplayHud.displayHud(guiGraphics, GOLDEN_BLACK_KNIFE_METHOD, x, y);
//                            } else {
//                                CSJDisplayHud.displayHud(guiGraphics,GOLDEN_BLACK_KNIFE_METHOD_1,x,y);
//                            }
//                        }else {
//                            if (getGoldenBlackKnifeMethodLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
//                                CSJDisplayHud.displayHud(guiGraphics, GOLDEN_BLACK_KNIFE_METHOD, x, y);
//                            } else {
//                                CSJDisplayHud.displayHud(guiGraphics,GOLDEN_BLACK_KNIFE_METHOD_1,x,y);
//                            }
//                            CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
//                        }
//                    }else{
//                        float v = frameTime();
//                        int v1 = (int) (16 * v + 1);//计算技能剩余冷却时间
//                        if (playerCanOpened()) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图并渲染技能剩余冷却时间
//                            if (getGoldenBlackKnifeMethodLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
//                                CSJDisplayHud.displayHud(guiGraphics,GOLDEN_BLACK_KNIFE_METHOD,x,y);
//                                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
//                                guiGraphics.blit(GOLDEN_BLACK_KNIFE_METHOD, x, y, 0, 0, 0,16, -v1 + 16, 16, 16);
//                            } else {
//                                CSJDisplayHud.displayHud(guiGraphics,GOLDEN_BLACK_KNIFE_METHOD_1,x,y);
//                                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
//                                guiGraphics.blit(GOLDEN_BLACK_KNIFE_METHOD_1, x, y, 0, 0, 0,16, -v1 + 16, 16, 16);
//                            }
//                            //以文字形式绘制剩余冷却时间
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(),frameTime(),7,x,y);
//                        }else {
//                            if (getGoldenBlackKnifeMethodLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
//                                CSJDisplayHud.displayHud(guiGraphics,GOLDEN_BLACK_KNIFE_METHOD,x,y);
//                                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
//                                guiGraphics.blit(GOLDEN_BLACK_KNIFE_METHOD, x, y, 0, 0, 0,16, -v1 + 16, 16, 16);
//                            } else {
//                                CSJDisplayHud.displayHud(guiGraphics,GOLDEN_BLACK_KNIFE_METHOD_1,x,y);
//                                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
//                                guiGraphics.blit(GOLDEN_BLACK_KNIFE_METHOD_1, x, y, 0, 0, 0,16, -v1 + 16, 16, 16);
//                            }
//                            CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(),frameTime(),7,x,y);
//                        }
//                    }
//                }else {
//                    CSJDisplayHud.displayHud(guiGraphics,GOLDEN_BLACK_KNIFE_METHOD_2,x,y);
//                }
            }
        }
    };
}
