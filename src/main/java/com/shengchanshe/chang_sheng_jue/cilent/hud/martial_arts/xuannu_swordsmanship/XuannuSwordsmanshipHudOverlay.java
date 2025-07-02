package com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.xuannu_swordsmanship;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.cilent.hud.CSJDisplayHud;
import com.shengchanshe.chang_sheng_jue.event.CSJEvent;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
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
public class XuannuSwordsmanshipHudOverlay {
    // 绘制的领悟后技能贴图的位置
    private static final ResourceLocation XUANNU_SWORDSMANSHIP = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/xuannu_swordsmanship/xuannu_swordsmanship.png");
    // 绘制的大成后技能贴图的位置
    private static final ResourceLocation XUANNU_SWORDSMANSHIP_1 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/xuannu_swordsmanship/xuannu_swordsmanship_1.png");
    // 绘制的技能不可使用的贴图的位置
    private static final ResourceLocation XUANNU_SWORDSMANSHIP_2 = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/xuannu_swordsmanship/xuannu_swordsmanship_2.png");
    //绘制技能冷却时的贴图位置
    private static final ResourceLocation COOLING = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/martial_arts/cooling.png");

    private static final Minecraft minecraft = Minecraft.getInstance();

    public static boolean shouldDisplayHud() {
        LocalPlayer player = minecraft.player;
        ItemStack mainHand = player.getMainHandItem();
        return mainHand.getItem() == ChangShengJueItems.SOFT_SWORD.get();
    }

    public static float frameTime() {
        LocalPlayer player = minecraft.player;
        ItemStack mainHand = player.getMainHandItem();
        if(mainHand.getItem() == ChangShengJueItems.SOFT_SWORD.get()){
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
    public static final IGuiOverlay HUD_XUANNU_SWORDSMANSHIP = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (shouldDisplayHud()) {
            boolean xuannuSwordsmanshipComprehend = XuannuSwordsmanshipClientData.isXuannuSwordsmanshipComprehend();
            // 通过宽高获得绘制的x，y
            int x = 5;
            int y = screenHeight / 2;
            if (xuannuSwordsmanshipComprehend){
//                CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(), ChatFormatting.BOLD + I18n.get("item.chang_sheng_jue.xuannu_swordsmanship"),x, y,ChatFormatting.LIGHT_PURPLE.getColor());
                int getXuannuSwordsmanshipLevel = XuannuSwordsmanshipClientData.getXuannuSwordsmanshipLevel();
                //设置绘制的信息
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                CSJDisplayHud.displayHudPermanent1(getXuannuSwordsmanshipLevel,frameTime(), CSJEvent.hasWheatNuggetsTributeWine ? 2.5f:4,playerCanOpened(),guiGraphics,XUANNU_SWORDSMANSHIP,XUANNU_SWORDSMANSHIP_1,XUANNU_SWORDSMANSHIP_2,COOLING,gui.getFont(),x,y);
                CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship"),x, y,ChatFormatting.LIGHT_PURPLE.getColor());
//                if (getXuannuSwordsmanshipLevel != 0) {//获取技能等级,为零则绘制不可使用的技能贴图
//                    if (frameTime() <= 0){ //获取技能剩余冷却时间,小于等于0则绘制技能贴图否则绘制冷却中的技能贴图
//                        if (playerCanOpened()) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图
//                            if (getXuannuSwordsmanshipLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
//                                CSJDisplayHud.displayHud(guiGraphics, XUANNU_SWORDSMANSHIP, x, y);
//                            } else {
//                                CSJDisplayHud.displayHud(guiGraphics,XUANNU_SWORDSMANSHIP_1,x,y);
//                            }
//                        }else {
//                            if (getXuannuSwordsmanshipLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图
//                                CSJDisplayHud.displayHud(guiGraphics, XUANNU_SWORDSMANSHIP, x, y);
//                            } else {
//                                CSJDisplayHud.displayHud(guiGraphics,XUANNU_SWORDSMANSHIP_1,x,y);
//                            }
//                            CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
//                        }
//                    }else{
//                        float v = frameTime();
//                        int v1 = (int) (16 * v + 1);//计算技能剩余冷却时间
//                        if (playerCanOpened()) {//检查玩家剩余饥饿值,剩余饥饿值不足则绘制冷却中的技能贴图并渲染技能剩余冷却时间
//                            if (getXuannuSwordsmanshipLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
//                                CSJDisplayHud.displayHud(guiGraphics,XUANNU_SWORDSMANSHIP,x,y);
//                                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
//                                guiGraphics.blit(XUANNU_SWORDSMANSHIP, x, y, 0, 0, 0,16, -v1 + 16, 16, 16);
//                            } else {
//                                CSJDisplayHud.displayHud(guiGraphics,XUANNU_SWORDSMANSHIP_1,x,y);
//                                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
//                                guiGraphics.blit(XUANNU_SWORDSMANSHIP_1, x, y, 0, 0, 0,16, -v1 + 16, 16, 16);
//                            }
//                            //以文字形式绘制剩余冷却时间
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(),frameTime(),4,x,y);
//                        }else {
//                            if (getXuannuSwordsmanshipLevel < 2) {//如果技能等级不为2,绘制普通技能贴图否则绘制大成技能贴图并渲染技能剩余冷却时间
//                                CSJDisplayHud.displayHud(guiGraphics,XUANNU_SWORDSMANSHIP,x,y);
//                                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
//                                guiGraphics.blit(XUANNU_SWORDSMANSHIP, x, y, 0, 0, 0,16, -v1 + 16, 16, 16);
//                            } else {
//                                CSJDisplayHud.displayHud(guiGraphics,XUANNU_SWORDSMANSHIP_1,x,y);
//                                CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
//                                guiGraphics.blit(XUANNU_SWORDSMANSHIP_1, x, y, 0, 0, 0,16, -v1 + 16, 16, 16);
//                            }
//                            CSJDisplayHud.displayHud(guiGraphics,COOLING,x,y);
//                            CSJDisplayHud.displayHudPermanent(guiGraphics,gui.getFont(),frameTime(),4,x,y);
//                        }
//                    }
//                }else {
//                    CSJDisplayHud.displayHud(guiGraphics,XUANNU_SWORDSMANSHIP_2,x,y);
//                }
            }
        }
    };
}
