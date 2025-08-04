package com.shengchanshe.chang_sheng_jue.cilent.hud.kungfu;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.cilent.hud.CSJDisplayHud;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.clubbed.Clubbed;
import com.shengchanshe.chang_sheng_jue.item.combat.glove.GoldThreadGlove;
import com.shengchanshe.chang_sheng_jue.item.combat.knife.Knife;
import com.shengchanshe.chang_sheng_jue.item.combat.lance.Lance;
import com.shengchanshe.chang_sheng_jue.item.combat.sword.SoftSword;
import com.shengchanshe.chang_sheng_jue.item.combat.sword.Sword;
import com.shengchanshe.chang_sheng_jue.item.combat.throwingknives.FlyingDaggerPouch;
import com.shengchanshe.chang_sheng_jue.item.combat.throwingknives.ThrowingKnives;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.*;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.GoldenBellJar;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.Hercules;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.ImmortalMiracle;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.QianKunDaNuoYi;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.light_kungfu.TreadTheSnowWithoutTrace;
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
public class KungFuHudOverlay {
    // 绘制的领悟后技能贴图的位置
    private static final ResourceLocation DUGU_NINE_SWORDS = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/dugu_nine_swords/dugu_nine_swords.png");
    // 绘制的大成后技能贴图的位置
    private static final ResourceLocation DUGU_NINE_SWORDS_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/dugu_nine_swords/dugu_nine_swords_1.png");
    // 绘制的技能不可使用的贴图的位置
    private static final ResourceLocation DUGU_NINE_SWORDS_2 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/dugu_nine_swords/dugu_nine_swords_2.png");
    private static final ResourceLocation GAO_MARKSMANSHIP = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/gao_marksmanship/gao_marksmanship.png");
    private static final ResourceLocation GAO_MARKSMANSHIP_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/gao_marksmanship/gao_marksmanship_1.png");
    private static final ResourceLocation GAO_MARKSMANSHIP_2 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/gao_marksmanship/gao_marksmanship_2.png");
    private static final ResourceLocation GE_SHAN_DA_NIU = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/ge_shan_da_niu/ge_shan_da_niu.png");
    private static final ResourceLocation GE_SHAN_DA_NIU_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/ge_shan_da_niu/ge_shan_da_niu_1.png");
    private static final ResourceLocation GE_SHAN_DA_NIU_2 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/ge_shan_da_niu/ge_shan_da_niu_2.png");
    private static final ResourceLocation GOLDEN_BLACK_KNIFE_METHOD = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/golden_black_knife_method/golden_black_knife_method.png");
    private static final ResourceLocation GOLDEN_BLACK_KNIFE_METHOD_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/golden_black_knife_method/golden_black_knife_method_1.png");
    private static final ResourceLocation GOLDEN_BLACK_KNIFE_METHOD_2 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/golden_black_knife_method/golden_black_knife_method_2.png");
    private static final ResourceLocation SHAOLIN_STICK_METHOD = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/shaolin_stick_method/shaolin_stick_method.png");
    private static final ResourceLocation SHAOLIN_STICK_METHOD_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/shaolin_stick_method/shaolin_stick_method_1.png");
    private static final ResourceLocation SHAOLIN_STICK_METHOD_2 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/shaolin_stick_method/shaolin_stick_method_2.png");
    private static final ResourceLocation SUNFLOWER_POINT_CAVEMAN = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/sunflower_point_caveman/sunflower_point_caveman.png");
    private static final ResourceLocation SUNFLOWER_POINT_CAVEMAN_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/sunflower_point_caveman/sunflower_point_caveman_1.png");
    private static final ResourceLocation SUNFLOWER_POINT_CAVEMAN_2 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/sunflower_point_caveman/sunflower_point_caveman_2.png");
    private static final ResourceLocation TURTLE_BREATH_WORK = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/turtle_breath_work/turtle_breath_work.png");
    private static final ResourceLocation TURTLE_BREATH_WORK_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/turtle_breath_work/turtle_breath_work_1.png");
    private static final ResourceLocation TURTLE_BREATH_WORK_2 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/turtle_breath_work/turtle_breath_work_2.png");
    private static final ResourceLocation XUANNU_SWORDSMANSHIP = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/xuannu_swordsmanship/xuannu_swordsmanship.png");
    private static final ResourceLocation XUANNU_SWORDSMANSHIP_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/xuannu_swordsmanship/xuannu_swordsmanship_1.png");
    private static final ResourceLocation XUANNU_SWORDSMANSHIP_2 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/xuannu_swordsmanship/xuannu_swordsmanship_2.png");
    private static final ResourceLocation RELENTLESS_THROWING_KNIVES = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/relentless_throwing_knives/relentless_throwing_knives.png");
    private static final ResourceLocation RELENTLESS_THROWING_KNIVES_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/relentless_throwing_knives/relentless_throwing_knives_1.png");
    private static final ResourceLocation RELENTLESS_THROWING_KNIVES_2 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/relentless_throwing_knives/relentless_throwing_knives_2.png");

    private static final ResourceLocation GOLDEN_BELL_JAR = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/golden_bell_jar/golden_bell_jar.png");
    private static final ResourceLocation GOLDEN_BELL_JAR_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/golden_bell_jar/golden_bell_jar_1.png");
    private static final ResourceLocation GOLDEN_BELL_JAR_2 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/golden_bell_jar/golden_bell_jar_2.png");
    private static final ResourceLocation HERCULES = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/hercules/hercules.png");
    private static final ResourceLocation HERCULES_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/hercules/hercules_1.png");
    private static final ResourceLocation HERCULES_2 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/hercules/hercules_2.png");
    private static final ResourceLocation IMMORTAL_MIRACLE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/immortal_miracle/immortal_miracle.png");
    private static final ResourceLocation IMMORTAL_MIRACLE_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/immortal_miracle/immortal_miracle_1.png");
    private static final ResourceLocation IMMORTAL_MIRACLE_2 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/immortal_miracle/immortal_miracle_2.png");
    private static final ResourceLocation QIAN_KUN_DA_NUO_YI = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/qian_kun_da_nuo_yi/qian_kun_da_nuo_yi.png");
    private static final ResourceLocation QIAN_KUN_DA_NUO_YI_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/qian_kun_da_nuo_yi/qian_kun_da_nuo_yi_1.png");
    private static final ResourceLocation QIAN_KUN_DA_NUO_YI_2 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/qian_kun_da_nuo_yi/qian_kun_da_nuo_yi_2.png");
    private static final ResourceLocation TREAD_THE_SNOW_WITHOUT_TRACE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/tread_the_snow_without_trace/tread_the_snow_without_trace.png");
    private static final ResourceLocation TREAD_THE_SNOW_WITHOUT_TRACE_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/tread_the_snow_without_trace/tread_the_snow_without_trace_1.png");
    private static final ResourceLocation TREAD_THE_SNOW_WITHOUT_TRACE_2 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/tread_the_snow_without_trace/tread_the_snow_without_trace_2.png");
    private static final ResourceLocation COOLING = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/martial_arts/cooling.png");

    private static final Minecraft minecraft = Minecraft.getInstance();

    public static float frameTime(String id) {
//        LocalPlayer player = minecraft.player;
//        ItemStack mainHand = player.getMainHandItem();
//        if(mainHand.getItem() instanceof Sword && mainHand.getItem() != ChangShengJueItems.SOFT_SWORD.get()){
//            float cooldownPercent = player.getCooldowns().getCooldownPercent(mainHand.getItem(), Minecraft.getInstance().getFrameTime());
//            return cooldownPercent;
//        }else {
//            return 0.0f;
//        }
        return KungFuClientData.get().kungFuCoolDown(id);
    }

    public static int getMaxCoolDown(String id) {
        return KungFuClientData.get().getMaxCoolDown(id);
    }

    public static int getKungLevel(String id) {
        return KungFuClientData.get().getKungFuLevel(id);
    }

    public static int getMaxKungFuLevel(String id) {
        return KungFuClientData.get().getMaxKungFuLevel(id);
    }

    public static boolean playerCanOpened() {
        int foodLevel = minecraft.player.getFoodData().getFoodLevel();
        return foodLevel > 8;
    }

    // 通过这个属性进行绘制，这个是一个IguiOverLay的接口，实现这个接口，注册他。
    // 通过lammbd表达式实现。
    public static final IGuiOverlay HUD = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        LocalPlayer player = minecraft.player;
        ItemStack mainHand = player.getMainHandItem();
        // 通过宽高获得绘制的x，y
        int x = 5;
        int y = screenHeight / 2;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        if (mainHand.getItem() instanceof Sword && mainHand.getItem() != ChangShengJueItems.SOFT_SWORD.get()) {
            if (KungFuClientData.get().knowsKungFu(DuguNineSwords.KUNG_FU_ID.toString())) {
                CSJDisplayHud.displayHudPermanent(
                        getKungLevel(DuguNineSwords.KUNG_FU_ID.toString()),
                        getMaxKungFuLevel(DuguNineSwords.KUNG_FU_ID.toString()),
                        frameTime(DuguNineSwords.KUNG_FU_ID.toString()),
                        getMaxCoolDown(DuguNineSwords.KUNG_FU_ID.toString()),
                        playerCanOpened(),
                        guiGraphics,
                        DUGU_NINE_SWORDS,
                        DUGU_NINE_SWORDS_1,
                        DUGU_NINE_SWORDS_2,
                        COOLING,
                        gui.getFont(),
                        x, y);
                CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item." + ChangShengJue.MOD_ID + "." + DuguNineSwords.KUNG_FU_ID.getPath()),
                        x, y, ChatFormatting.AQUA.getColor());
            }
        } else if (mainHand.getItem() instanceof Lance) {
            if (KungFuClientData.get().knowsKungFu(GaoMarksmanship.KUNG_FU_ID.toString())) {
                CSJDisplayHud.displayHudPermanent(
                        getKungLevel(GaoMarksmanship.KUNG_FU_ID.toString()),
                        getMaxKungFuLevel(GaoMarksmanship.KUNG_FU_ID.toString()),
                        frameTime(GaoMarksmanship.KUNG_FU_ID.toString()),
                        getMaxCoolDown(GaoMarksmanship.KUNG_FU_ID.toString()),
                        playerCanOpened(),
                        guiGraphics,
                        GAO_MARKSMANSHIP,
                        GAO_MARKSMANSHIP_1,
                        GAO_MARKSMANSHIP_2,
                        COOLING,
                        gui.getFont(),
                        x, y);
                CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item." + ChangShengJue.MOD_ID + "." + GaoMarksmanship.KUNG_FU_ID.getPath()),
                        x, y, ChatFormatting.RED.getColor());
            }
        } else if (mainHand.getItem() instanceof GoldThreadGlove) {
            if (KungFuClientData.get().knowsKungFu(GeShanDaNiu.KUNG_FU_ID.toString())
                    && KungFuClientData.get().isStart(GeShanDaNiu.KUNG_FU_ID.toString())) {
                CSJDisplayHud.displayHudPermanent(
                        getKungLevel(GeShanDaNiu.KUNG_FU_ID.toString()),
                        getMaxKungFuLevel(GeShanDaNiu.KUNG_FU_ID.toString()),
                        frameTime(GeShanDaNiu.KUNG_FU_ID.toString()),
                        getMaxCoolDown(GeShanDaNiu.KUNG_FU_ID.toString()),
                        playerCanOpened(),
                        guiGraphics,
                        GE_SHAN_DA_NIU,
                        GE_SHAN_DA_NIU_1,
                        GE_SHAN_DA_NIU_2,
                        COOLING,
                        gui.getFont(),
                        x, y);
                CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item." + ChangShengJue.MOD_ID + "." + GeShanDaNiu.KUNG_FU_ID.getPath()),
                        x, y, ChatFormatting.YELLOW.getColor());
            } else if (KungFuClientData.get().knowsKungFu(SunflowerPointCaveman.KUNG_FU_ID.toString())
                    && KungFuClientData.get().isStart(SunflowerPointCaveman.KUNG_FU_ID.toString())) {
                CSJDisplayHud.displayHudPermanent(getKungLevel(SunflowerPointCaveman.KUNG_FU_ID.toString()),
                        getMaxKungFuLevel(SunflowerPointCaveman.KUNG_FU_ID.toString()),
                        frameTime(SunflowerPointCaveman.KUNG_FU_ID.toString()),
                        getMaxCoolDown(SunflowerPointCaveman.KUNG_FU_ID.toString()),
                        playerCanOpened(),
                        guiGraphics,
                        SUNFLOWER_POINT_CAVEMAN,
                        SUNFLOWER_POINT_CAVEMAN_1,
                        SUNFLOWER_POINT_CAVEMAN_2,
                        COOLING,
                        gui.getFont(),
                        x, y);
                CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item." + ChangShengJue.MOD_ID + "." + SunflowerPointCaveman.KUNG_FU_ID.getPath()),
                        x, y, ChatFormatting.YELLOW.getColor());
            } else if (KungFuClientData.get().knowsKungFu(TurtleBreathWork.KUNG_FU_ID.toString())
                    && KungFuClientData.get().isStart(TurtleBreathWork.KUNG_FU_ID.toString())) {
                CSJDisplayHud.displayHudPermanent(
                        getKungLevel(TurtleBreathWork.KUNG_FU_ID.toString()),
                        getMaxKungFuLevel(TurtleBreathWork.KUNG_FU_ID.toString()),
                        frameTime(TurtleBreathWork.KUNG_FU_ID.toString()),
                        getMaxCoolDown(TurtleBreathWork.KUNG_FU_ID.toString()),
                        playerCanOpened(),
                        guiGraphics,
                        TURTLE_BREATH_WORK,
                        TURTLE_BREATH_WORK_1,
                        TURTLE_BREATH_WORK_2,
                        COOLING,
                        gui.getFont(),
                        x, y);
                CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item." + ChangShengJue.MOD_ID + "." + TurtleBreathWork.KUNG_FU_ID.getPath()), x, y, ChatFormatting.BLUE.getColor());
            } else if (KungFuClientData.get().knowsKungFu(Hercules.KUNG_FU_ID.toString()) && KungFuClientData.get().isStart(Hercules.KUNG_FU_ID.toString())) {
                CSJDisplayHud.displayHudPermanent(
                        getKungLevel(Hercules.KUNG_FU_ID.toString()),
                        getMaxKungFuLevel(Hercules.KUNG_FU_ID.toString()),
                        frameTime(Hercules.KUNG_FU_ID.toString()),
                        getMaxCoolDown(Hercules.KUNG_FU_ID.toString()),
                        true,
                        guiGraphics,
                        HERCULES,
                        HERCULES_1,
                        HERCULES_2,
                        COOLING,
                        gui.getFont(),
                        x, y);
                CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item." + ChangShengJue.MOD_ID + "." + Hercules.KUNG_FU_ID.getPath()),
                        x, y, ChatFormatting.YELLOW.getColor());
            }
        } else if (mainHand.getItem() instanceof Knife) {
            if (KungFuClientData.get().knowsKungFu(GoldenBlackKnifeMethod.KUNG_FU_ID.toString())) {
                CSJDisplayHud.displayHudPermanent(
                        getKungLevel(GoldenBlackKnifeMethod.KUNG_FU_ID.toString()),
                        getMaxKungFuLevel(GoldenBlackKnifeMethod.KUNG_FU_ID.toString()),
                        frameTime(GoldenBlackKnifeMethod.KUNG_FU_ID.toString()),
                        getMaxCoolDown(GoldenBlackKnifeMethod.KUNG_FU_ID.toString()),
                        playerCanOpened(),
                        guiGraphics,
                        GOLDEN_BLACK_KNIFE_METHOD,
                        GOLDEN_BLACK_KNIFE_METHOD_1,
                        GOLDEN_BLACK_KNIFE_METHOD_2,
                        COOLING, gui.getFont(),
                        x, y);
                CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item." + ChangShengJue.MOD_ID + "." + GoldenBlackKnifeMethod.KUNG_FU_ID.getPath()), x, y, ChatFormatting.GOLD.getColor());
            }
        } else if (mainHand.getItem() instanceof Clubbed) {
            if (KungFuClientData.get().knowsKungFu(ShaolinStickMethod.KUNG_FU_ID.toString())) {
                CSJDisplayHud.displayHudPermanent(
                        getKungLevel(ShaolinStickMethod.KUNG_FU_ID.toString()),
                        getMaxKungFuLevel(ShaolinStickMethod.KUNG_FU_ID.toString()),
                        frameTime(ShaolinStickMethod.KUNG_FU_ID.toString()),
                        getMaxCoolDown(ShaolinStickMethod.KUNG_FU_ID.toString()),
                        playerCanOpened(), guiGraphics,
                        SHAOLIN_STICK_METHOD,
                        SHAOLIN_STICK_METHOD_1,
                        SHAOLIN_STICK_METHOD_2,
                        COOLING,
                        gui.getFont(),
                        x, y);
                CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item." + ChangShengJue.MOD_ID + "." + ShaolinStickMethod.KUNG_FU_ID.getPath()), x, y, ChatFormatting.RED.getColor());
            }
        } else if (mainHand.getItem() instanceof SoftSword) {
            if (KungFuClientData.get().knowsKungFu(XuannuSwordsmanship.KUNG_FU_ID.toString())) {
                CSJDisplayHud.displayHudPermanent(
                        getKungLevel(XuannuSwordsmanship.KUNG_FU_ID.toString()),
                        getMaxKungFuLevel(XuannuSwordsmanship.KUNG_FU_ID.toString()),
                        frameTime(XuannuSwordsmanship.KUNG_FU_ID.toString()),
                        getMaxCoolDown(XuannuSwordsmanship.KUNG_FU_ID.toString()),
                        playerCanOpened(),
                        guiGraphics,
                        XUANNU_SWORDSMANSHIP,
                        XUANNU_SWORDSMANSHIP_1,
                        XUANNU_SWORDSMANSHIP_2,
                        COOLING,
                        gui.getFont(),
                        x, y);
                CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item." + ChangShengJue.MOD_ID + "." + XuannuSwordsmanship.KUNG_FU_ID.getPath()),
                        x, y, ChatFormatting.RED.getColor());
            }
        } else if (mainHand.getItem() instanceof ThrowingKnives || mainHand.getItem() instanceof FlyingDaggerPouch) {
            if (KungFuClientData.get().knowsKungFu(RelentlessThrowingKnives.KUNG_FU_ID.toString())) {
                CSJDisplayHud.displayHudPermanent(
                        getKungLevel(RelentlessThrowingKnives.KUNG_FU_ID.toString()),
                        getMaxKungFuLevel(RelentlessThrowingKnives.KUNG_FU_ID.toString()),
                        frameTime(RelentlessThrowingKnives.KUNG_FU_ID.toString()),
                        getMaxCoolDown(RelentlessThrowingKnives.KUNG_FU_ID.toString()),
                        playerCanOpened(),
                        guiGraphics,
                        RELENTLESS_THROWING_KNIVES,
                        RELENTLESS_THROWING_KNIVES_1,
                        RELENTLESS_THROWING_KNIVES_2,
                        COOLING, gui.getFont(),
                        x, y);
                CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                        ChatFormatting.BOLD + I18n.get("item." + ChangShengJue.MOD_ID + "." + RelentlessThrowingKnives.KUNG_FU_ID.getPath()),
                        x, y, ChatFormatting.BLUE.getColor());
            }
        }

        if (KungFuClientData.get().knowsKungFu(GoldenBellJar.KUNG_FU_ID.toString()) && KungFuClientData.get().isCoolingDown(GoldenBellJar.KUNG_FU_ID.toString())) {
            int y1 = 25;
            CSJDisplayHud.displayHudPermanent(
                    getKungLevel(GoldenBellJar.KUNG_FU_ID.toString()),
                    getMaxKungFuLevel(GoldenBellJar.KUNG_FU_ID.toString()),
                    frameTime(GoldenBellJar.KUNG_FU_ID.toString()),
                    getMaxCoolDown(GoldenBellJar.KUNG_FU_ID.toString()),
                    playerCanOpened(),
                    guiGraphics,
                    GOLDEN_BELL_JAR,
                    GOLDEN_BELL_JAR_1,
                    GOLDEN_BELL_JAR_2,
                    COOLING,
                    gui.getFont(),
                    x, y + y1);
            CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                    ChatFormatting.GOLD + I18n.get("item." + ChangShengJue.MOD_ID + "." + GoldenBellJar.KUNG_FU_ID.getPath()),
                    x, y + y1, ChatFormatting.GOLD.getColor());
        }

        if (KungFuClientData.get().knowsKungFu(ImmortalMiracle.KUNG_FU_ID.toString()) && KungFuClientData.get().isCoolingDown(ImmortalMiracle.KUNG_FU_ID.toString())) {
            int y1 = 25;
            if (KungFuClientData.get().isCoolingDown(GoldenBellJar.KUNG_FU_ID.toString()) && KungFuClientData.get().isCoolingDown(ImmortalMiracle.KUNG_FU_ID.toString())) {
                y1 = 50;
            }
            CSJDisplayHud.displayHudPermanent(
                    getKungLevel(ImmortalMiracle.KUNG_FU_ID.toString()),
                    getMaxKungFuLevel(ImmortalMiracle.KUNG_FU_ID.toString()),
                    frameTime(ImmortalMiracle.KUNG_FU_ID.toString()),
                    getMaxCoolDown(ImmortalMiracle.KUNG_FU_ID.toString()),
                    playerCanOpened(),
                    guiGraphics,
                    IMMORTAL_MIRACLE,
                    IMMORTAL_MIRACLE_1,
                    IMMORTAL_MIRACLE_2,
                    COOLING,
                    gui.getFont(),
                    x, y + y1);
            CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                    ChatFormatting.GOLD + I18n.get("item." + ChangShengJue.MOD_ID + "." + ImmortalMiracle.KUNG_FU_ID.getPath()),
                    x, y + y1, ChatFormatting.GOLD.getColor());
        }

        if (KungFuClientData.get().knowsKungFu(QianKunDaNuoYi.KUNG_FU_ID.toString()) && KungFuClientData.get().isCoolingDown(QianKunDaNuoYi.KUNG_FU_ID.toString())) {
            int y1 = 25;
            if (KungFuClientData.get().isCoolingDown(GoldenBellJar.KUNG_FU_ID.toString()) && KungFuClientData.get().isCoolingDown(ImmortalMiracle.KUNG_FU_ID.toString())) {
                y1 = 75;
            }else if (KungFuClientData.get().isCoolingDown(GoldenBellJar.KUNG_FU_ID.toString()) || KungFuClientData.get().isCoolingDown(ImmortalMiracle.KUNG_FU_ID.toString())) {
                y1 = 50;
            }
            CSJDisplayHud.displayHudPermanent(
                    getKungLevel(QianKunDaNuoYi.KUNG_FU_ID.toString()),
                    getMaxKungFuLevel(QianKunDaNuoYi.KUNG_FU_ID.toString()),
                    frameTime(QianKunDaNuoYi.KUNG_FU_ID.toString()),
                    getMaxCoolDown(QianKunDaNuoYi.KUNG_FU_ID.toString()),
                    playerCanOpened(),
                    guiGraphics,
                    QIAN_KUN_DA_NUO_YI,
                    QIAN_KUN_DA_NUO_YI_1,
                    QIAN_KUN_DA_NUO_YI_2,
                    COOLING,
                    gui.getFont(),
                    x, y + y1);
            CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                    ChatFormatting.YELLOW + I18n.get("item." + ChangShengJue.MOD_ID + "." + QianKunDaNuoYi.KUNG_FU_ID.getPath()),
                    x, y + y1, ChatFormatting.YELLOW.getColor());
        }

        if (KungFuClientData.get().knowsKungFu(TreadTheSnowWithoutTrace.KUNG_FU_ID.toString()) && KungFuClientData.get().isCoolingDown(TreadTheSnowWithoutTrace.KUNG_FU_ID.toString())) {
            CSJDisplayHud.displayHudPermanent(
                    getKungLevel(TreadTheSnowWithoutTrace.KUNG_FU_ID.toString()),
                    getMaxKungFuLevel(TreadTheSnowWithoutTrace.KUNG_FU_ID.toString()),
                    frameTime(TreadTheSnowWithoutTrace.KUNG_FU_ID.toString()),
                    getMaxCoolDown(TreadTheSnowWithoutTrace.KUNG_FU_ID.toString()),
                    true,
                    guiGraphics,
                    TREAD_THE_SNOW_WITHOUT_TRACE,
                    TREAD_THE_SNOW_WITHOUT_TRACE_1,
                    TREAD_THE_SNOW_WITHOUT_TRACE_2,
                    COOLING,
                    gui.getFont(),
                    x,y - 50);
            CSJDisplayHud.displayHudPermanent(guiGraphics, gui.getFont(),
                    ChatFormatting.DARK_BLUE + I18n.get("item." + ChangShengJue.MOD_ID + "." + TreadTheSnowWithoutTrace.KUNG_FU_ID.getPath()),
                    x,y - 50, ChatFormatting.DARK_BLUE.getColor());
        }
    };
}
