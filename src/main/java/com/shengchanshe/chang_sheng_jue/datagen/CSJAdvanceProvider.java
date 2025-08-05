package com.shengchanshe.chang_sheng_jue.datagen;



import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.advancement.first.MiChangSheng;
import com.shengchanshe.chang_sheng_jue.advancement.forth.*;
import com.shengchanshe.chang_sheng_jue.advancement.third.*;
import com.shengchanshe.chang_sheng_jue.advancement.second.*;
import com.shengchanshe.chang_sheng_jue.advancement.third.UseWaiGong;
import com.shengchanshe.chang_sheng_jue.advancement.third.LearnGongFa;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.items.Parcel;
import com.shengchanshe.chang_sheng_jue.world.CSJStructures;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class CSJAdvanceProvider implements AdvancementSubProvider {
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer) {
        //一级进度
        //长生诀
        Advancement begin = Advancement.Builder.advancement()
                .display(ChangShengJueBlocks.STONE_LAMPS_BLOCK.get()
                        , Component.translatable("advancement.chang_sheng_jue.begin").withStyle(ChatFormatting.GOLD)
                        , Component.translatable("advancement.chang_sheng_jue.begin.desc").withStyle(ChatFormatting.DARK_GREEN),
                        new ResourceLocation("chang_sheng_jue:textures/block/blue_stone_fine_bricks.png"),
                        FrameType.TASK, true, true, false)
                .addCriterion("changshengjue", MiChangSheng.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID+":advancement/begin");

        //二级进度
        //人是铁饭是钢
        Advancement hasmifan = Advancement.Builder.advancement().parent(begin)
                .display(ChangShengJueItems.MI_FAN.get()
                        , Component.translatable("advancement.chang_sheng_jue.hasmifan").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.hasmifan.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("hasmifan", HasMiFan.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/hasmifan");

        //银华熠熠
        Advancement hassilverbullions = Advancement.Builder.advancement().parent(begin)
                .display(ChangShengJueItems.SILVER_BULLIONS.get()
                        , Component.translatable("advancement.chang_sheng_jue.hassilverbullions").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.hassilverbullions.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("hassilverbullions", HasSilverBullions.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/hassilverbullions");

        //侠客行
        Advancement hasbronzesword = Advancement.Builder.advancement().parent(begin)
                .display(ChangShengJueItems.BRONZE_SWORD.get()
                        ,Component.translatable("advancement.chang_sheng_jue.hasbronzesword").withStyle(ChatFormatting.GREEN)
                        ,Component.translatable("advancement.chang_sheng_jue.hasbronzesword.desc").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.TASK, true, true, false)
                .addCriterion("hasbronzesword", HasBronzeSword.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID+"advancement/hasbronzesword");

        //新生活！
        Advancement findchinesevillage = Advancement.Builder.advancement().parent(begin)
                .display(ChangShengJueBlocks.DESK.get()
                        , Component.translatable("advancement.chang_sheng_jue.findchinesevillage").withStyle(ChatFormatting.AQUA)
                        , Component.translatable("advancement.chang_sheng_jue.findchinesevillage.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("findchinesevillage-pityard", PlayerTrigger.TriggerInstance.located(
                        LocationPredicate.inStructure(CSJStructures.PIT_YARD)))
                .addCriterion("findchinesevillage-sandstonecastle", PlayerTrigger.TriggerInstance.located(
                        LocationPredicate.inStructure(CSJStructures.SANDSTONE_CASTLE)))
                .addCriterion("findchinesevillage-siheyuan", PlayerTrigger.TriggerInstance.located(
                        LocationPredicate.inStructure(CSJStructures.SI_HE_YUAN)))
                .addCriterion("findchinesevillage-supaivillage", PlayerTrigger.TriggerInstance.located(
                        LocationPredicate.inStructure(CSJStructures.SU_PAI_VILLAGE)))
                .addCriterion("findchinesevillage-wanpaivillage/", PlayerTrigger.TriggerInstance.located(
                        LocationPredicate.inStructure(CSJStructures.HUI_PAI_VILLAGE)))
                .requirements(RequirementsStrategy.OR)
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/findchinesevillage");

        //帮会？
        Advancement accessguildtask = Advancement.Builder.advancement().parent(begin)
                .display(ChangShengJueItems.GANG_TOKEN.get()
                        , Component.translatable("advancement.chang_sheng_jue.accessguildtask").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.accessguildtask.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("accessguildtask", AccessGuildTask.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/accessguildtask");

        // 三级成就
        // 似是妃子笑
        Advancement haslichee = Advancement.Builder.advancement().parent(hasmifan)
                .display(ChangShengJueItems.LICHEE.get()
                        , Component.translatable("advancement.chang_sheng_jue.haslichee").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.haslichee.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("haslichee", HasLichee.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/haslichee");

        //家常小炒
        Advancement hastomatoegg = Advancement.Builder.advancement().parent(hasmifan)
                .display(ChangShengJueItems.TOMATO_EGG.get()
                        , Component.translatable("advancement.chang_sheng_jue.hastomatoegg").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.hastomatoegg.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("hastomatoEgg", HasTomatoEgg.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/hastomatoegg");

        //习习清风生
        Advancement hastea = Advancement.Builder.advancement().parent(hasmifan)
                .display(ChangShengJueItems.LONG_JING_TEAS.get()
                        , Component.translatable("advancement.chang_sheng_jue.hastea").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.hastea.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("hasTea", HasTea.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/hastea");

        //对酒当歌，人生几何？
        Advancement haswine = Advancement.Builder.advancement().parent(hasmifan)
                .display(ChangShengJueItems.SHI_LI_XIANG.get()
                        , Component.translatable("advancement.chang_sheng_jue.haswine").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.haswine.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("haswine", HasWine.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/haswine");

        //金光闪闪
        ///*目标进度*///
        Advancement hasgoldbullions = Advancement.Builder.advancement().parent(hassilverbullions)
                .display(ChangShengJueItems.GOLD_BULLIONS.get()
                        , Component.translatable("advancement.chang_sheng_jue.hasgoldbullions").withStyle(ChatFormatting.DARK_PURPLE)
                        , Component.translatable("advancement.chang_sheng_jue.hasgoldbullions.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.GOAL, true, true, false)
                .addCriterion("hasgoldbullions", HasgoldBullions.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/hasgoldbullions");

        //趁手兵器
        Advancement usewaigong = Advancement.Builder.advancement().parent(hasbronzesword)
                .display(ChangShengJueItems.HAN_JIAN.get()
                        , Component.translatable("advancement.chang_sheng_jue.usewaigong").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.usewaigong.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("usewaigong", UseWaiGong.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/usewaigong");

        //布衣侠客
        Advancement hasarmor = Advancement.Builder.advancement().parent(hasbronzesword)
                .display(ChangShengJueItems.CONFUCIAN_INK_CHESTPLATE.get()
                        , Component.translatable("advancement.chang_sheng_jue.hasarmor").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.hasarmor.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("hasarmor", HasArmor.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/hasarmor");

        //初学乍练
        Advancement learngongfa = Advancement.Builder.advancement().parent(hasbronzesword)
                .display(ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get()
                        ,Component.translatable("advancement.chang_sheng_jue.learngongfa").withStyle(ChatFormatting.GREEN)
                        ,Component.translatable("advancement.chang_sheng_jue.learngongfa.desc").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.TASK, true, true, false)
                .addCriterion("learngongfa", LearnGongFa.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID+":advancement/learngongfa");

        //做瓷器
        Advancement makechinaware = Advancement.Builder.advancement().parent(findchinesevillage)
                .display(ChangShengJueBlocks.POTTERY_WHEEL.get()
                        , Component.translatable("advancement.chang_sheng_jue.makechinaware").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.makechinaware.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("makechinaware", MakeChinaware.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/makechinaware");

        //善恶谁定？
        Advancement finishtask = Advancement.Builder.advancement().parent(accessguildtask)
                .display(ChangShengJueItems.YI_TIAN_JIAN.get()
                        , Component.translatable("advancement.chang_sheng_jue.finishtask").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.finishtask.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("finishtask", FinishTask.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/finishtask");

        //四级
        //吉祥如意
        ///*目标进度*///
        Advancement hasbabaozhu = Advancement.Builder.advancement().parent(hastomatoegg)
                .display(ChangShengJueItems.BA_BAO_ZHOU.get()
                        , Component.translatable("advancement.chang_sheng_jue.hasbabaozhu").withStyle(ChatFormatting.DARK_PURPLE)
                        , Component.translatable("advancement.chang_sheng_jue.hasbabaozhu.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.GOAL, true, true, false)
                .addCriterion("hasbabaozhu", HasBaBaoZhou.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/hasbabaozhu");

        // 甜蜜蜜
        ///*目标进度*///
        Advancement hasguihuatangou = Advancement.Builder.advancement().parent(hastomatoegg)
                .display(ChangShengJueItems.GUI_HUA_TANG_OU.get()
                        , Component.translatable("advancement.chang_sheng_jue.hasguihuatangou").withStyle(ChatFormatting.DARK_PURPLE)
                        , Component.translatable("advancement.chang_sheng_jue.hasguihuatangou.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.GOAL, true, true, false)
                .addCriterion("hasguihuatangou", HasGuiHuaTangOu.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/hasguihuatangou");

        // 绝世神兵
        ///*挑战进度*///
        Advancement hassword = Advancement.Builder.advancement().parent(usewaigong)
                .display(ChangShengJueItems.YI_TIAN_JIAN.get()
                        , Component.translatable("advancement.chang_sheng_jue.hassword").withStyle(ChatFormatting.GOLD)
                        , Component.translatable("advancement.chang_sheng_jue.hassword.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.CHALLENGE, true, true, false)
                .addCriterion("hassword", HasSword.TriggerInstance.createInstance())
                .rewards(net.minecraft.advancements.AdvancementRewards.Builder.experience(1000))
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/hassword");

        // 将门之后
        Advancement hasadvancedarrmor = Advancement.Builder.advancement().parent(hasarmor)
                .display(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LIGHT_CHESTPLATE.get()
                        , Component.translatable("advancement.chang_sheng_jue.hasadvancedarrmor").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.hasadvancedarrmor.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("hasadvancedarrmor", HasAdvancedArrmor.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/hasadvancedarrmor");

        // 融会贯通
        Advancement mastergongfa = Advancement.Builder.advancement().parent(learngongfa)
                .display(ChangShengJueItems.IMMORTAL_MIRACLE.get()
                        , Component.translatable("advancement.chang_sheng_jue.mastergongfa").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.mastergongfa.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("mastergongfa", MaterGongFa.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/mastergongfa");

        //有求必应
        Advancement donefivetask = Advancement.Builder.advancement().parent(makechinaware)
                .display(ChangShengJueItems.YI_GUAN_TONG_QIAN.get()
                        , Component.translatable("advancement.chang_sheng_jue.donefivetask").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.donefivetask.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.TASK, true, true, false)
                .addCriterion("donefivetask", DoneFiveTask.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/donefivetask");

        //扛把子
        Advancement agroupgangtoken = Advancement.Builder.advancement().parent(finishtask)
                .display(Parcel.createCottonParcel().getItem()
                        , Component.translatable("advancement.chang_sheng_jue.agroupgangtoken").withStyle(ChatFormatting.GREEN)
                        , Component.translatable("advancement.chang_sheng_jue.agroupgangtoken.desc").withStyle(ChatFormatting.GRAY)
                        , null
                        , FrameType.TASK, true, true, false)
                .addCriterion("agroupgangtoken", AGroupGangToken.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/agroupgangtoken");

        //五级进度
        ///*挑战进度*///
        //未竟
        Advancement hasqitian = Advancement.Builder.advancement().parent(hasadvancedarrmor)
                .display(ChangShengJueItems.OLDEN_CHAIN_MAIL_SHIRT.get()
                        , Component.translatable("advancement.chang_sheng_jue.hasqitian").withStyle(ChatFormatting.GOLD)
                        , Component.translatable("advancement.chang_sheng_jue.hasqitian.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.CHALLENGE, true, true, false)
                .addCriterion("hasqitian", HasQiTian.TriggerInstance.createInstance())
                .rewards(net.minecraft.advancements.AdvancementRewards.Builder.experience(1000))
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/hasqitian");

        //一代宗师
        Advancement gongfadone = Advancement.Builder.advancement().parent(mastergongfa)
                .display(ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()
                        , Component.translatable("advancement.chang_sheng_jue.gongfadone").withStyle(ChatFormatting.GOLD)
                        , Component.translatable("advancement.chang_sheng_jue.gongfadone.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.CHALLENGE, true, true, false)
                .addCriterion("gongfadone", GongFaDone.TriggerInstance.createInstance())
                .rewards(net.minecraft.advancements.AdvancementRewards.Builder.experience(1000))
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/gongfadone");

        //隐世大侠
        Advancement donefinaltask = Advancement.Builder.advancement().parent(donefivetask)
                .display(ChangShengJueItems.KITCHEN_KNIFE.get()
                        , Component.translatable("advancement.chang_sheng_jue.donefinaltask").withStyle(ChatFormatting.GOLD)
                        , Component.translatable("advancement.chang_sheng_jue.donefinaltask.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.CHALLENGE, true, true, false)
                .addCriterion("donefinaltask", DoneFinalTask.TriggerInstance.createInstance())
                .rewards(net.minecraft.advancements.AdvancementRewards.Builder.experience(1000))
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/donefinaltask");

        //头把交椅
        Advancement beatleader = Advancement.Builder.advancement().parent(agroupgangtoken)
                .display(ChangShengJueItems.TU_LONG_DAO.get()
                        , Component.translatable("advancement.chang_sheng_jue.beatleader").withStyle(ChatFormatting.GOLD)
                        , Component.translatable("advancement.chang_sheng_jue.beatleader.desc").withStyle(ChatFormatting.GRAY)
                        , (ResourceLocation) null
                        , FrameType.CHALLENGE, true, true, false)
                .addCriterion("beatleader", BeatLeader.TriggerInstance.createInstance())
                .rewards(net.minecraft.advancements.AdvancementRewards.Builder.experience(1000))
                .save(consumer, ChangShengJue.MOD_ID + ":advancement/beatleader");
    }
}
