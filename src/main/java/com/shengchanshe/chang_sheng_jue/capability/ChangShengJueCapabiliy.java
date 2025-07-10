package com.shengchanshe.chang_sheng_jue.capability;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.cultivation.entity.CultivationCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.cultivation.entity.ICultivationCapability;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.gao_marksmanship.GaoMarksmanshipCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.hercules.HerculesCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.paoding.PaodingCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.wheat_nugget_encyclopedia.WheatNuggetEncyclopediaCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.wu_gang_cut_gui.WuGangCutGuiCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.yugong_moves_mountains.YugongMovesMountainsCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.zhang_men_xin_xue.ZhangMenXinxueCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapability;
import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapabilityProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class ChangShengJueCapabiliy {
    // Capability 声明
    public static final Capability<ICultivationCapability> SPIRIT_ROOT_CAP =
            CapabilityManager.get(new CapabilityToken<>() {});

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.register(ICultivationCapability.class);
        event.register(PlayerQuestCapability.class);
    }

    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {//判断生物为玩家,只给玩家添加这些能力
            if (!event.getObject().getCapability(CultivationCapabilityProvider.XIU_XIAN_CAPABILITY).isPresent()) {
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID, "spirit_root"), new CultivationCapabilityProvider());
            }
            if (!event.getObject().getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).isPresent()) {
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID, "quest"), new PlayerQuestCapabilityProvider());
            }
            //独孤九剑
            if (!event.getObject().getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"dugu_nine_swords_properties"),new DuguNineSwordsCapabilityProvider());
            }
            //金乌刀法
            if (!event.getObject().getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"golden_black_knife_method_properties"),new GoldenBlackKnifeMethodCapabilityProvider());
            }
            //玄女剑法
            if (!event.getObject().getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"xuannu_swordsmanship_properties"),new XuannuSwordsmanshipCapabilityProvider());
            }
            //高家枪法
            if (!event.getObject().getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"gao_marksmanship_properties"),new GaoMarksmanshipCapabilityProvider());
            }
            //少林棍法
            if (!event.getObject().getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"shaolin_stick_method_properties"),new ShaolinStickMethodCapabilityProvider());
            }
            //踏雪无痕
            if (!event.getObject().getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"tread_the_snow_without_trace_properties"),new TreadTheSnowWithoutTraceCapabilityProvider());
            }
            //吴刚伐桂
            if (!event.getObject().getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"wu_gang_cut_gui_properties"),new WuGangCutGuiCapabilityProvider());
            }
            //吴刚伐桂
            if (!event.getObject().getCapability(YugongMovesMountainsCapabilityProvider.YUGONG_MOVES_MOUNTAINS_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"yugong_moves_mountains_properties"),new YugongMovesMountainsCapabilityProvider());
            }
            //庖丁解牛
            if (!event.getObject().getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"paoding_properties"),new PaodingCapabilityProvider());
            }
            //葵花点穴手
            if (!event.getObject().getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"sunflower_point_caveman_properties"),new SunflowerPointCavemanCapabilityProvider());
            }
            //金钟罩
            if (!event.getObject().getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"golden_bell_jar_properties"),new GoldenBellJarCapabilityProvider());
            }
            //张门心学
            if (!event.getObject().getCapability(ZhangMenXinxueCapabilityProvider.ZHANG_MEN_XIN_XUE_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"zhang_men_xin_xue_properties"),new ZhangMenXinxueCapabilityProvider());
            }
            //不死神功
            if (!event.getObject().getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"immortal_miracle_properties"),new ImmortalMiracleCapabilityProvider());
            }
            //隔山打牛
            if (!event.getObject().getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"ge_shan_da_niu_properties"),new GeShanDaNiuCapabilityProvider());
            }
            //麦块百科
            if (!event.getObject().getCapability(WheatNuggetEncyclopediaCapabilityProvider.WHEAT_NUGGET_ENCYCLOPEDIA_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"wheat_nugget_encyclopedia_properties"),new WheatNuggetEncyclopediaCapabilityProvider());
            }
            //龟息功
            if (!event.getObject().getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"turtle_breath_work_properties"),new TurtleBreathWorkCapabilityProvider());
            }
            //无情飞刀
            if (!event.getObject().getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"relentless_throwing_knives_properties"),new RelentlessThrowingKnivesCapabilityProvider());
            }
            //易筋经
            if (!event.getObject().getCapability(TheClassicsOfTendonChangingCapabilityProvider.THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"the_classics_of_tendon_changing_properties"),new TheClassicsOfTendonChangingCapabilityProvider());
            }
            //乾坤大挪移
            if (!event.getObject().getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"qian_kun_da_nuo_yi_properties"),new QianKunDaNuoYiCapabilityProvider());
            }
            //大力神功
            if (!event.getObject().getCapability(HerculesCapabilityProvider.HERCULES_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"hercules_properties"),new HerculesCapabilityProvider());
            }
        }
    }

}
