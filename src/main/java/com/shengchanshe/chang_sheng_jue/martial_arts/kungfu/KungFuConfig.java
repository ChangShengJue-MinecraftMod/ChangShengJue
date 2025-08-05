package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.AbstractionExternalKunfu;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.DuguNineSwords;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.server.ServerLifecycleHooks;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KungFuConfig {
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.IntValue DUGU_NINE_SWORDS_MAX_LEVEL;
    public static final ForgeConfigSpec.IntValue DUGU_NINE_SWORDS_MAX_EXP;
    public static final ForgeConfigSpec.IntValue DUGU_NINE_SWORDS_MAX_COOLDOWN;

    public static final ForgeConfigSpec.IntValue GAO_MARKSMANSHIP_MAX_LEVEL;
    public static final ForgeConfigSpec.IntValue GAO_MARKSMANSHIP_MAX_EXP;
    public static final ForgeConfigSpec.IntValue GAO_MARKSMANSHIP_MAX_COOLDOWN;

    public static final ForgeConfigSpec.IntValue GE_SHAN_DA_NIU_MAX_LEVEL;
    public static final ForgeConfigSpec.IntValue GE_SHAN_DA_NIU_MAX_EXP;
    public static final ForgeConfigSpec.IntValue GE_SHAN_DA_NIU_MAX_COOLDOWN;

    public static final ForgeConfigSpec.IntValue GOLDEN_BLACK_KNIFE_METHOD_MAX_LEVEL;
    public static final ForgeConfigSpec.IntValue GOLDEN_BLACK_KNIFE_METHOD_MAX_EXP;
    public static final ForgeConfigSpec.IntValue GOLDEN_BLACK_KNIFE_METHOD_MAX_COOLDOWN;

    public static final ForgeConfigSpec.IntValue SHAOLIN_STICK_METHOD_MAX_LEVEL;
    public static final ForgeConfigSpec.IntValue SHAOLIN_STICK_METHOD_MAX_EXP;
    public static final ForgeConfigSpec.IntValue SHAOLIN_STICK_METHOD_MAX_COOLDOWN;

    public static final ForgeConfigSpec.IntValue SUNFLOWER_POINT_CAVEMAN_MAX_LEVEL;
    public static final ForgeConfigSpec.IntValue SUNFLOWER_POINT_CAVEMAN_MAX_EXP;
    public static final ForgeConfigSpec.IntValue SUNFLOWER_POINT_CAVEMAN_MAX_COOLDOWN;

    public static final ForgeConfigSpec.IntValue TURTLE_BREATH_WORK_MAX_LEVEL;
    public static final ForgeConfigSpec.IntValue TURTLE_BREATH_WORK_MAX_EXP;
    public static final ForgeConfigSpec.IntValue TURTLE_BREATH_WORK_MAX_COOLDOWN;

    public static final ForgeConfigSpec.IntValue XUANNU_SWORDSMANSHIP_MAX_LEVEL;
    public static final ForgeConfigSpec.IntValue XUANNU_SWORDSMANSHIP_MAX_EXP;
    public static final ForgeConfigSpec.IntValue XUANNU_SWORDSMANSHIP_MAX_COOLDOWN;

    public static final ForgeConfigSpec.IntValue RELENTLESS_THROWING_KNIVES_MAX_LEVEL;
    public static final ForgeConfigSpec.IntValue RELENTLESS_THROWING_KNIVES_MAX_EXP;
    public static final ForgeConfigSpec.IntValue RELENTLESS_THROWING_KNIVES_MAX_COOLDOWN;

    public static final ForgeConfigSpec.IntValue GOLDEN_BELL_JAR_MAX_LEVEL;
    public static final ForgeConfigSpec.IntValue GOLDEN_BELL_JAR_MAX_EXP;
    public static final ForgeConfigSpec.IntValue GOLDEN_BELL_JAR_MAX_COOLDOWN;

    public static final ForgeConfigSpec.IntValue HERCULES_MAX_EXP;

    public static final ForgeConfigSpec.IntValue IMMORTAL_MIRACLE_MAX_LEVEL;
    public static final ForgeConfigSpec.IntValue IMMORTAL_MIRACLE_MAX_EXP;
    public static final ForgeConfigSpec.IntValue IMMORTAL_MIRACLE_MAX_COOLDOWN;

    public static final ForgeConfigSpec.IntValue QIAN_KUN_DA_NUO_YI_MAX_LEVEL;
    public static final ForgeConfigSpec.IntValue QIAN_KUN_DA_NUO_YI_MAX_EXP;
    public static final ForgeConfigSpec.IntValue QIAN_KUN_DA_NUO_YI_MAX_COOLDOWN;
    public static final ForgeConfigSpec.IntValue QIAN_KUN_DA_NUO_YI_MAX_COOLDOWN_EXTRA_TICK;
    public static final ForgeConfigSpec.IntValue QIAN_KUN_DA_NUO_YI_BOUNCE_DAMAGE_PROBABILITY;
    public static final ForgeConfigSpec.IntValue QIAN_KUN_DA_NUO_YI_BOUNCE_DAMAGE_EXTRA_PROBABILITY;
    public static final ForgeConfigSpec.IntValue QIAN_KUN_DA_NUO_YI_BOUNCE_DAMAGE_MULTIPLIER;
    public static final ForgeConfigSpec.IntValue QIAN_KUN_DA_NUO_YI_BOUNCE_DAMAGE_TICK;

    public static final ForgeConfigSpec.IntValue THE_CLASSICS_OF_TENDON_CHANGING_MAX_EXP;

    public static final ForgeConfigSpec.IntValue PAODING_MAX_EXP;
    public static final ForgeConfigSpec.IntValue PAODING_ADDITIONAL_DROPS_COUNT;

    public static final ForgeConfigSpec.IntValue WU_GANG_CUT_GUI_MAX_EXP;

    public static final ForgeConfigSpec.IntValue YUGONG_MOVES_MOUNTAINS_MAX_EXP;
    public static final ForgeConfigSpec.IntValue YUGONG_MOVES_MOUNTAINS_EXCAVATION_RANGE;

    public static final ForgeConfigSpec.IntValue ZHANG_MEN_XIN_XUE_MAX_EXP;
    public static final ForgeConfigSpec.IntValue ZHANG_MEN_XIN_XUE_EXTRA_PROBABILITY;

    public static final ForgeConfigSpec.IntValue TREAD_THE_SNOW_WITHOUT_TRACE_MAX_LEVEL;
    public static final ForgeConfigSpec.IntValue TREAD_THE_SNOW_WITHOUT_TRACE_MAX_EXP;
    public static final ForgeConfigSpec.IntValue TREAD_THE_SNOW_WITHOUT_TRACE_MAX_COOLDOWN;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        DUGU_NINE_SWORDS_MAX_LEVEL = builder
                .comment("独孤九剑最大等级上限", "默认: 2")
                .translation("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_level")
                .defineInRange("duguNineSwordsMaxLevel", 2, 0, Integer.MAX_VALUE);
        DUGU_NINE_SWORDS_MAX_EXP = builder
                .comment("独孤九剑突破所需的成功释放次数", "默认: 100")
                .translation("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_exp")
                .defineInRange("duguNineSwordsMaxExp", 100, 0, Integer.MAX_VALUE);
        DUGU_NINE_SWORDS_MAX_COOLDOWN = builder
                .comment("独孤九剑最大冷却时间", "默认: 100(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_cooldown")
                .defineInRange("duguNineSwordsMaxCooldown", 100, 0, Integer.MAX_VALUE);

        GAO_MARKSMANSHIP_MAX_LEVEL = builder
                .comment("高家枪法最大等级上限", "默认: 2")
                .translation("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_level")
                .defineInRange("gaoMarksmanshipMaxLevel", 2, 0, Integer.MAX_VALUE);
        GAO_MARKSMANSHIP_MAX_EXP = builder
                .comment("高家枪法突破所需的成功释放次数", "默认: 100")
                .translation("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_exp")
                .defineInRange("gaoMarksmanshipMaxExp", 100, 0, Integer.MAX_VALUE);
        GAO_MARKSMANSHIP_MAX_COOLDOWN = builder
                .comment("高家枪法最大冷却时间", "默认: 120(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_cooldown")
                .defineInRange("gaoMarksmanshipMaxCooldown", 120, 0, Integer.MAX_VALUE);

        GE_SHAN_DA_NIU_MAX_LEVEL = builder
                .comment("隔山打牛最大等级上限", "默认: 2")
                .translation("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_level")
                .defineInRange("geShanDaNiuMaxLevel", 2, 0, Integer.MAX_VALUE);
        GE_SHAN_DA_NIU_MAX_EXP = builder
                .comment("隔山打牛突破所需的成功释放次数", "默认: 100")
                .translation("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_exp")
                .defineInRange("geShanDaNiuMaxExp", 100, 0, Integer.MAX_VALUE);
        GE_SHAN_DA_NIU_MAX_COOLDOWN = builder
                .comment("隔山打牛最大冷却时间", "默认: 200(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_cooldown")
                .defineInRange("geShanDaNiuMaxCooldown", 200, 0, Integer.MAX_VALUE);

        GOLDEN_BLACK_KNIFE_METHOD_MAX_LEVEL = builder
                .comment("金乌刀法最大等级上限", "默认: 2")
                .translation("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_level")
                .defineInRange("goldenBlackKnifeMethodMaxLevel", 2, 0, Integer.MAX_VALUE);
        GOLDEN_BLACK_KNIFE_METHOD_MAX_EXP = builder
                .comment("金乌刀法突破所需的成功释放次数", "默认: 100")
                .translation("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_exp")
                .defineInRange("goldenBlackKnifeMethodMaxExp", 100, 0, Integer.MAX_VALUE);
        GOLDEN_BLACK_KNIFE_METHOD_MAX_COOLDOWN = builder
                .comment("金乌刀法最大冷却时间", "默认: 140(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_cooldown")
                .defineInRange("goldenBlackKnifeMethodMaxCooldown", 140, 0, Integer.MAX_VALUE);

        SHAOLIN_STICK_METHOD_MAX_LEVEL = builder
                .comment("少林棍法最大等级上限", "默认: 2")
                .translation("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_level")
                .defineInRange("shaolinStickMethodMaxLevel", 2, 0, Integer.MAX_VALUE);
        SHAOLIN_STICK_METHOD_MAX_EXP = builder
                .comment("少林棍法突破所需的成功释放次数", "默认: 100")
                .translation("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_exp")
                .defineInRange("shaolinStickMethodMaxExp", 100, 0, Integer.MAX_VALUE);
        SHAOLIN_STICK_METHOD_MAX_COOLDOWN = builder
                .comment("少林棍法最大冷却时间", "默认: 160(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_cooldown")
                .defineInRange("shaolinStickMethodMaxCooldown", 160, 0, Integer.MAX_VALUE);

        SUNFLOWER_POINT_CAVEMAN_MAX_LEVEL = builder
                .comment("葵花点穴手最大等级上限", "默认: 2")
                .translation("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_level")
                .defineInRange("sunflowerPointCavemanMaxLevel", 2, 0, Integer.MAX_VALUE);
        SUNFLOWER_POINT_CAVEMAN_MAX_EXP = builder
                .comment("葵花点穴手突破所需的成功释放次数", "默认: 100")
                .translation("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_exp")
                .defineInRange("sunflowerPointCavemanMaxExp", 100, 0, Integer.MAX_VALUE);
        SUNFLOWER_POINT_CAVEMAN_MAX_COOLDOWN = builder
                .comment("葵花点穴手最大冷却时间", "默认: 180(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_cooldown")
                .defineInRange("sunflowerPointCavemanMaxCooldown", 180, 0, Integer.MAX_VALUE);

        TURTLE_BREATH_WORK_MAX_LEVEL = builder
                .comment("龟息功最大等级上限", "默认: 2")
                .translation("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_max_level")
                .defineInRange("turtleBreathWorkMaxLevel", 2, 0, Integer.MAX_VALUE);
        TURTLE_BREATH_WORK_MAX_EXP = builder
                .comment("龟息功突破所需的成功释放次数", "默认: 100")
                .translation("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_max_exp")
                .defineInRange("turtleBreathWorkMaxExp", 100, 0, Integer.MAX_VALUE);
        TURTLE_BREATH_WORK_MAX_COOLDOWN = builder
                .comment("龟息功最大冷却时间", "默认: 900(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_cooldown")
                .defineInRange("turtleBreathWorkMaxCooldown", 900, 0, Integer.MAX_VALUE);

        XUANNU_SWORDSMANSHIP_MAX_LEVEL = builder
                .comment("玄女剑法最大等级上限", "默认: 2")
                .translation("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_level")
                .defineInRange("xuannuSwordsmanshipMaxLevel", 2, 0, Integer.MAX_VALUE);
        XUANNU_SWORDSMANSHIP_MAX_EXP = builder
                .comment("玄女剑法突破所需的成功释放次数", "默认: 100")
                .translation("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_exp")
                .defineInRange("xuannuSwordsmanshipMaxExp", 100, 0, Integer.MAX_VALUE);
        XUANNU_SWORDSMANSHIP_MAX_COOLDOWN = builder
                .comment("玄女剑法最大冷却时间", "默认: 80(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_cooldown")
                .defineInRange("xuannuSwordsmanshipMaxCooldown", 80, 0, Integer.MAX_VALUE);

        RELENTLESS_THROWING_KNIVES_MAX_LEVEL = builder
                .comment("无情飞刀最大等级上限", "默认: 2")
                .translation("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_level")
                .defineInRange("relentlessThrowingKnivesMaxLevel", 2, 0, Integer.MAX_VALUE);
        RELENTLESS_THROWING_KNIVES_MAX_EXP = builder
                .comment("无情飞刀突破所需的成功释放次数", "默认: 100")
                .translation("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_exp")
                .defineInRange("relentlessThrowingKnivesMaxExp", 100, 0, Integer.MAX_VALUE);
        RELENTLESS_THROWING_KNIVES_MAX_COOLDOWN = builder
                .comment("无情飞刀最大冷却时间", "默认: 160(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_cooldown")
                .defineInRange("relentlessThrowingKnivesMaxCooldown", 160, 0, Integer.MAX_VALUE);

        GOLDEN_BELL_JAR_MAX_LEVEL = builder
                .comment("金钟罩最大等级上限", "默认: 2")
                .translation("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_level")
                .defineInRange("relentlessThrowingKnivesMaxLevel", 2, 0, Integer.MAX_VALUE);
        GOLDEN_BELL_JAR_MAX_EXP = builder
                .comment("金钟罩突破所需的成功释放次数", "默认: 100")
                .translation("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_exp")
                .defineInRange("relentlessThrowingKnivesMaxExp", 100, 0, Integer.MAX_VALUE);
        GOLDEN_BELL_JAR_MAX_COOLDOWN = builder
                .comment("金钟罩最大冷却时间", "默认: 160(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_cooldown")
                .defineInRange("relentlessThrowingKnivesMaxCooldown", 160, 0, Integer.MAX_VALUE);

        HERCULES_MAX_EXP = builder
                .comment("大力神功突破所需的移动距离", "默认: 1000000")
                .translation("config."+ ChangShengJue.MOD_ID +".hercules_max_exp")
                .defineInRange("herculesMaxExp", 1000000, 0, Integer.MAX_VALUE);

        IMMORTAL_MIRACLE_MAX_LEVEL = builder
                .comment("不死神功最大等级上限", "默认: 2")
                .translation("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_level")
                .defineInRange("immortalMiracleMaxLevel", 2, 0, Integer.MAX_VALUE);
        IMMORTAL_MIRACLE_MAX_EXP = builder
                .comment("不死神功突破所需的成功释放次数", "默认: 25")
                .translation("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_exp")
                .defineInRange("immortalMiracleMaxExp", 25, 0, Integer.MAX_VALUE);
        IMMORTAL_MIRACLE_MAX_COOLDOWN = builder
                .comment("不死神功最大冷却时间", "默认: 1600(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_cooldown")
                .defineInRange("immortalMiracleMaxCooldown", 1600, 0, Integer.MAX_VALUE);

        QIAN_KUN_DA_NUO_YI_MAX_LEVEL = builder
                .comment("乾坤大挪移最大等级上限", "默认: 2")
                .translation("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_level")
                .defineInRange("qianKunDaNuoYiMaxLevel", 2, 0, Integer.MAX_VALUE);
        QIAN_KUN_DA_NUO_YI_MAX_EXP = builder
                .comment("乾坤大挪移突破所需的成功释放次数", "默认: 100")
                .translation("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_exp")
                .defineInRange("qianKunDaNuoYiMaxExp", 100, 0, Integer.MAX_VALUE);
        QIAN_KUN_DA_NUO_YI_MAX_COOLDOWN = builder
                .comment("乾坤大挪移最大冷却时间", "默认: 40(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_cooldown")
                .defineInRange("qianKunDaNuoYiMaxCooldown", 40, 0, Integer.MAX_VALUE);
        QIAN_KUN_DA_NUO_YI_BOUNCE_DAMAGE_PROBABILITY = builder
                .comment("乾坤大挪移每次反弹伤害的概率", "默认: 35%")
                .translation("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_probability")
                .defineInRange("qianKunDaNuoYiProbability", 35, 0, 100);
        QIAN_KUN_DA_NUO_YI_BOUNCE_DAMAGE_EXTRA_PROBABILITY = builder
                .comment("乾坤大挪移大成后每点血量增加反弹伤害的概率", "默认: 2%")
                .translation("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_extra_probability")
                .defineInRange("qianKunDaNuoYiBounceDamageExtraProbability", 2, 0, 100);
        QIAN_KUN_DA_NUO_YI_BOUNCE_DAMAGE_MULTIPLIER = builder
                .comment("乾坤大挪移反弹伤害的倍率", "默认: 150%")
                .translation("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_multiplier")
                .defineInRange("qianKunDaNuoYiBounceDamageMultiplier", 150, 0, Integer.MAX_VALUE);
        QIAN_KUN_DA_NUO_YI_BOUNCE_DAMAGE_TICK = builder
                .comment("乾坤大挪移每次反弹伤害需要的时间", "默认: 20(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_tick")
                .defineInRange("qianKunDaNuoYiTick", 20, 0, Integer.MAX_VALUE);
        QIAN_KUN_DA_NUO_YI_MAX_COOLDOWN_EXTRA_TICK = builder
                .comment("乾坤大挪移每次释放后增加的冷却恢复到默认冷却的时间", "默认: 3600(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".qian_kun_da_nuo_yi_max_cooldown_extra_tick")
                .defineInRange("qianKunDaNuoYiMaxCooldownExtraTick", 3600, 0, Integer.MAX_VALUE);

        THE_CLASSICS_OF_TENDON_CHANGING_MAX_EXP = builder
                .comment("易筋经突破所需的成功释放次数", "默认: 1000")
                .translation("config."+ ChangShengJue.MOD_ID +".the_classics_of_tendon_changing_max_exp")
                .defineInRange("theClassicsOfTendonChangingMaxExp", 1000, 0, Integer.MAX_VALUE);

        PAODING_MAX_EXP = builder
                .comment("庖丁解牛突破所需的成功释放次数", "默认: 1000")
                .translation("config."+ ChangShengJue.MOD_ID +".paoding_max_exp")
                .defineInRange("paodingMaxExp", 1000, 0, Integer.MAX_VALUE);
        PAODING_ADDITIONAL_DROPS_COUNT = builder
                .comment("庖丁解牛杀死生物时额外掉落肉的数量", "默认: 1")
                .translation("config."+ ChangShengJue.MOD_ID +".paoding_additional_drops_count")
                .defineInRange("paodingAdditionalDropsCount", 1, 0, Integer.MAX_VALUE);

        WU_GANG_CUT_GUI_MAX_EXP = builder
                .comment("吴刚伐桂突破所需的成功释放次数", "默认: 1000")
                .translation("config."+ ChangShengJue.MOD_ID +".wu_gang_cut_gui_max_exp")
                .defineInRange("wuGangCutGuiMaxExp", 1000, 0, Integer.MAX_VALUE);

        YUGONG_MOVES_MOUNTAINS_MAX_EXP = builder
                .comment("愚公移山突破所需的成功释放次数", "默认: 1000")
                .translation("config."+ ChangShengJue.MOD_ID +".yugong_moves_mountains_max_exp")
                .defineInRange("yugongMovesMountainsMaxExp", 1000, 0, Integer.MAX_VALUE);
        YUGONG_MOVES_MOUNTAINS_EXCAVATION_RANGE = builder
                .comment("愚公移山的挖掘范围", "默认: 2")
                .translation("config."+ ChangShengJue.MOD_ID +".yugong_moves_mountains_excavation_range")
                .defineInRange("yugongMovesMountainsExcavationRange", 2, 0, Integer.MAX_VALUE);

        ZHANG_MEN_XIN_XUE_MAX_EXP = builder
                .comment("张门心学突破所需的交易成功次数", "默认: 100")
                .translation("config."+ ChangShengJue.MOD_ID +".zhang_men_xin_xue_max_exp")
                .defineInRange("zhangMenXinXueMaxExp", 100, 0, Integer.MAX_VALUE);
        ZHANG_MEN_XIN_XUE_EXTRA_PROBABILITY = builder
                .comment("张门心学大成后交易不消耗物品的概率", "默认: 10%")
                .translation("config."+ ChangShengJue.MOD_ID +".zhang_men_xin_xue_extra_probability")
                .defineInRange("zhangMenXinXueExtraProbability", 10, 0, Integer.MAX_VALUE);

        TREAD_THE_SNOW_WITHOUT_TRACE_MAX_LEVEL = builder
                .comment("踏雪无痕最大等级上限", "默认: 2")
                .translation("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_level")
                .defineInRange("duguNineSwordsMaxLevel", 2, 0, Integer.MAX_VALUE);
        TREAD_THE_SNOW_WITHOUT_TRACE_MAX_EXP = builder
                .comment("踏雪无痕突破所需的成功释放次数", "默认: 100")
                .translation("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_exp")
                .defineInRange("duguNineSwordsMaxExp", 100, 0, Integer.MAX_VALUE);
        TREAD_THE_SNOW_WITHOUT_TRACE_MAX_COOLDOWN = builder
                .comment("踏雪无痕最大冷却时间", "默认: 100(tick)")
                .translation("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_cooldown")
                .defineInRange("duguNineSwordsMaxCooldown", 100, 0, Integer.MAX_VALUE);
        SPEC = builder.build();
    }

    @SubscribeEvent
    public static void onConfigReload(ModConfigEvent.Reloading event) {
        if (event.getConfig().getModId().equals(ChangShengJue.MOD_ID)) {
            // 遍历所有玩家，修正等级
            for (ServerPlayer player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()) {
                player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(kungFuData ->
                        kungFuData.getKungFu(DuguNineSwords.KUNG_FU_ID.toString()).ifPresent(kungFu -> {
                    if (kungFu instanceof AbstractionExternalKunfu) {
                        ((AbstractionExternalKunfu) kungFu).clampLevelToMax();
                    }
                }));
            }
        }
    }

}
