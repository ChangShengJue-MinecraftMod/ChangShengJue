package com.shengchanshe.changshengjue.init;

import com.shengchanshe.changshengjue.advancement.forth.*;
import com.shengchanshe.changshengjue.advancement.first.MiChangSheng;
import com.shengchanshe.changshengjue.advancement.second.*;
import com.shengchanshe.changshengjue.advancement.third.*;
import com.shengchanshe.changshengjue.advancement.third.LearnGongFa;
import com.shengchanshe.changshengjue.advancement.third.UseWaiGong;
import net.minecraft.advancements.CriteriaTriggers;

public class CSJAdvanceInit {
    /*
    if (player instanceof ServerPlayer serverPlayer) {
        CSJAdvanceInit.makechinaware.trigger(serverPlayer);
    }
    */
    //一级
    public static final MiChangSheng MI_CHANG_SHENG = CriteriaTriggers.register(new MiChangSheng());
    //二级
    public static final HasMiFan HAS_MI_FAN = CriteriaTriggers.register(new HasMiFan());
    public static final HasSilverBullions HAS_SILVER_BULLIONS = CriteriaTriggers.register(new HasSilverBullions());
    public static final HasBronzeSword HAS_BRONZE_SWORD = CriteriaTriggers.register(new HasBronzeSword());
//    public static final FindChineseVillage FIND_CHINESE_VILLAGE = CriteriaTriggers.register(new FindChineseVillage());
    public static final AccessGuildTask ACCESS_GUILD_TASK = CriteriaTriggers.register(new AccessGuildTask());

    //三级
    public static final HasLichee HAS_LICHEE = CriteriaTriggers.register(new HasLichee());
    public static final HasTea HAS_TEA = CriteriaTriggers.register(new HasTea());
    public static final HasWine HAS_WINE = CriteriaTriggers.register(new HasWine());
    public static final HasTomatoEgg HAS_TOMATO_EGG = CriteriaTriggers.register(new HasTomatoEgg());
    public static final HasgoldBullions HASGOLD_BULLIONS = CriteriaTriggers.register(new HasgoldBullions());
    public static final UseWaiGong USE_WAI_GONG = CriteriaTriggers.register(new UseWaiGong());
    public static final HasArmor HAS_ARMOR = CriteriaTriggers.register(new HasArmor());
    public static final LearnGongFa LEARN_GONG_FA = CriteriaTriggers.register(new LearnGongFa());
    public static final MakeChinaware MAKE_CHINAWARE = CriteriaTriggers.register(new MakeChinaware());
    public static final FinishTask FINISH_TASK = CriteriaTriggers.register(new FinishTask());
    //四级
    public static final HasBaBaoZhou HAS_BA_BAO_ZHOU = CriteriaTriggers.register(new HasBaBaoZhou());
    public static final HasGuiHuaTangOu HAS_GUI_HUA_TANG_OU = CriteriaTriggers.register(new HasGuiHuaTangOu());
    public static final HasSword HAS_SWORD = CriteriaTriggers.register(new HasSword());
    public static final HasAdvancedArrmor HAS_ADVANCED_ARRMOR = CriteriaTriggers.register(new HasAdvancedArrmor());
    public static final MaterGongFa MATER_GONG_FA = CriteriaTriggers.register(new MaterGongFa());
    public static final DoneFiveTask DONE_FIVE_TASK = CriteriaTriggers.register(new DoneFiveTask());
    public static final AGroupGangToken A_GROUP_GANG_TOKEN = CriteriaTriggers.register(new AGroupGangToken());
    //五级
    public static final HasQiTian HAS_QI_TIAN = CriteriaTriggers.register(new HasQiTian());
    public static final GongFaDone GONG_FA_DONE = CriteriaTriggers.register(new GongFaDone());
    public static final DoneFinalTask DONE_FINAL_TASK = CriteriaTriggers.register(new DoneFinalTask());
    public static final BeatLeader BEAT_LEADER = CriteriaTriggers.register(new BeatLeader());
    



}
