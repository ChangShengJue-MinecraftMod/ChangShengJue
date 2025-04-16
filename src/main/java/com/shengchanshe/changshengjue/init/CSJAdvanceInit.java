package com.shengchanshe.changshengjue.init;

import com.shengchanshe.changshengjue.advancement.forth.*;
import com.shengchanshe.changshengjue.advancement.first.MiChangSheng;
import com.shengchanshe.changshengjue.advancement.second.*;
import com.shengchanshe.changshengjue.advancement.third.*;
import com.shengchanshe.changshengjue.advancement.third.LearnGongFa;
import com.shengchanshe.changshengjue.advancement.third.UseWaiGong;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;

public class CSJAdvanceInit {
    /*
    if (player instanceof ServerPlayer serverPlayer) {
        CSJAdvanceInit.makechinaware.trigger(serverPlayer);
    }
    */
    //一级
    public static final MiChangSheng michangsheng = CriteriaTriggers.register(new MiChangSheng());
    //二级
    public static final HasMiFan hasmifan = CriteriaTriggers.register(new HasMiFan());
    public static final HasSilverBullions hassilverbullions = CriteriaTriggers.register(new HasSilverBullions());
    public static final HasBronzeSword hasbronzesword = CriteriaTriggers.register(new HasBronzeSword());
    public static final FindChineseVillage findchinesevillage = CriteriaTriggers.register(new FindChineseVillage());
    public static final AccessGuildTask accessguildtask = CriteriaTriggers.register(new AccessGuildTask());

    //三级
    public static final HasLichee haslichee = CriteriaTriggers.register(new HasLichee());
    public static final HasTea hastea = CriteriaTriggers.register(new HasTea());
    public static final HasWine haswine = CriteriaTriggers.register(new HasWine());
    public static final HasTomatoEgg hastomatoegg = CriteriaTriggers.register(new HasTomatoEgg());
    public static final HasgoldBullions hasgoldbullions = CriteriaTriggers.register(new HasgoldBullions());
    public static final UseWaiGong usewaigong = CriteriaTriggers.register(new UseWaiGong());
    public static final HasArmor hasarmor = CriteriaTriggers.register(new HasArmor());
    public static final LearnGongFa learngongfa = CriteriaTriggers.register(new LearnGongFa());
    public static final MakeChinaware makechinaware = CriteriaTriggers.register(new MakeChinaware());
    public static final FinishTask finishtask = CriteriaTriggers.register(new FinishTask());
    //四级
    public static final HasBaBaoZhou hasbabaozhou = CriteriaTriggers.register(new HasBaBaoZhou());
    public static final HasGuiHuaTangOu hasguihuatangou = CriteriaTriggers.register(new HasGuiHuaTangOu());
    public static final HasSword hassword = CriteriaTriggers.register(new HasSword());
    public static final HasAdvancedArrmor hasadvancedarrmor = CriteriaTriggers.register(new HasAdvancedArrmor());
    public static final MaterGongFa matergongfa = CriteriaTriggers.register(new MaterGongFa());
    public static final DoneFiveTask donefivetask = CriteriaTriggers.register(new DoneFiveTask());
    public static final AGroupGangToken agroupgangtoken = CriteriaTriggers.register(new AGroupGangToken());
    //五级
    public static final HasQiTian hasqitian = CriteriaTriggers.register(new HasQiTian());
    public static final GongFaDone gongfadone = CriteriaTriggers.register(new GongFaDone());
    public static final DoneFinalTask DoneFinalTask = CriteriaTriggers.register(new DoneFinalTask());
    public static final BeatLeader beatleader = CriteriaTriggers.register(new BeatLeader());
    



}
