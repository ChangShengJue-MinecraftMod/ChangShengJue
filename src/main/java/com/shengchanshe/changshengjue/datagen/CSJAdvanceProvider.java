package com.shengchanshe.changshengjue.datagen;



import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.advancement.hasitem.*;
import com.shengchanshe.changshengjue.advancement.MiChangSheng;
import com.shengchanshe.changshengjue.advancement.usesth.LearnWaiGong;
import com.shengchanshe.changshengjue.advancement.usesth.UseWaiGong;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class CSJAdvanceProvider implements AdvancementSubProvider {
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer) {
        Advancement root = Advancement.Builder.advancement()
                .display(ChangShengJueBlocks.STONE_LAMPS_BLOCK.get()
                        , Component.translatable("csj.cj.open").withStyle(ChatFormatting.GOLD)
                        , Component.translatable("csj.cj.open.context").withStyle(ChatFormatting.DARK_GREEN),
                        new ResourceLocation("textures/block/diamond_block.png"),
                        FrameType.GOAL, true, true, false)
                .addCriterion("changshengjue", MiChangSheng.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID+":joinchangshengjue/root");

        Advancement hasmifan = Advancement.Builder.advancement().parent(root)
                .display(ChangShengJueItems.MI_FAN.get()
                        ,Component.translatable("csj.cj.hmf").withStyle(ChatFormatting.GREEN)
                        ,Component.translatable("csj.cj.hmf.context").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("hasmifan", HasMiFan.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID+":joinchangshengjue/has/hasmifan");

        Advancement haslichee = Advancement.Builder.advancement().parent(hasmifan)
                .display(ChangShengJueItems.LICHEE.get()
                        ,Component.translatable("csj.cj.hlc").withStyle(ChatFormatting.DARK_PURPLE)
                        ,Component.translatable("csj.cj.hlc.context").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("haslichee", HasLichee.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID+":joinchangshengjue/has/haslichee");

        Advancement hastea = Advancement.Builder.advancement().parent(hasmifan)
                .display(ChangShengJueItems.LONG_JING_TEAS.get()
                        ,Component.translatable("csj.cj.ht").withStyle(ChatFormatting.DARK_PURPLE)
                        ,Component.translatable("csj.cj.ht.context").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("hasTea", HasTea.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID+":joinchangshengjue/has/hastea");

        Advancement hastomatoegg = Advancement.Builder.advancement().parent(hasmifan)
                .display(ChangShengJueItems.TOMATO_EGG.get()
                        ,Component.translatable("csj.cj.tomatoegg").withStyle(ChatFormatting.DARK_PURPLE)
                        ,Component.translatable("csj.cj.tomatoegg.context").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("hastomatoEgg", HasTomatoEgg.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID+":joinchangshengjue/has/hastomatoegg");

        Advancement haswine = Advancement.Builder.advancement().parent(hasmifan)
                .display(ChangShengJueItems.SHI_LI_XIANG.get()
                        ,Component.translatable("csj.cj.wine").withStyle(ChatFormatting.DARK_PURPLE)
                        ,Component.translatable("csj.cj.wine.context").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("haswine", HasWine.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID+":joinchangshengjue/has/haswine");

        Advancement hasbronzesword = Advancement.Builder.advancement().parent(root)
                .display(ChangShengJueItems.BRONZE_SWORD.get()
                        ,Component.translatable("csj.cj.hsbs").withStyle(ChatFormatting.GREEN)
                        ,Component.translatable("csj.cj.hsbs.context").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("hasbronzesword", HasBronzeSword.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID+":joinchangshengjue/has/hasbronzesword");

        Advancement usewaigong = Advancement.Builder.advancement().parent(hasbronzesword)
                .display(ChangShengJueItems.IMMORTAL_MIRACLE.get()
                        ,Component.translatable("csj.cj.usewaigong").withStyle(ChatFormatting.GREEN)
                        ,Component.translatable("csj.cj.usewaigong.context").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("usewaigong", UseWaiGong.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID+":joinchangshengjue/use/usewaigong");

        Advancement hassword = Advancement.Builder.advancement().parent(usewaigong)
                .display(ChangShengJueItems.DUGU_NINE_SWORDS.get()
                        ,Component.translatable("csj.cj.hassword").withStyle(ChatFormatting.GREEN)
                        ,Component.translatable("csj.cj.hassword.context").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("hassword", HasSword.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID+":joinchangshengjue/has/hassword");

        Advancement learnwaigong = Advancement.Builder.advancement().parent(hasbronzesword)
                .display(ChangShengJueItems.IMMORTAL_MIRACLE.get()
                        ,Component.translatable("csj.cj.learnwaigong").withStyle(ChatFormatting.GREEN)
                        ,Component.translatable("csj.cj.learnwaigong.context").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("learnwaigong", LearnWaiGong.TriggerInstance.createInstance())
                .save(consumer, ChangShengJue.MOD_ID+":joinchangshengjue/learn/learnwaigong");
        


    }
}
