package com.shengchanshe.changshengjue.event.quest;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.ChangShengJueConfig;
import com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.gao_marksmanship.GaoMarksmanshipCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.hercules.HerculesCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.paoding.PaodingCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.wheat_nugget_encyclopedia.WheatNuggetEncyclopediaCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.wu_gang_cut_gui.WuGangCutGuiCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.yugong_moves_mountains.YugongMovesMountainsCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.zhang_men_xin_xue.ZhangMenXinxueCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.custom.tiger.Tiger;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagerEntity;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagers;
import com.shengchanshe.changshengjue.quest.Quest;
import com.shengchanshe.changshengjue.quest.QuestManager;
import com.shengchanshe.changshengjue.util.TimeDetection;
import com.shengchanshe.changshengjue.util.VillageUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.gossip.GossipType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerQuestEvent {
    // 存储已触发自动任务的玩家
    private static final UUID FIRST_VILLAGER_QUEST_ID = UUID.fromString("2b0fedb0-2b4d-4b24-81fb-c4b6c8a47fa7");
    private static final UUID KUAI_YI_EN_CHOU_QUEST_ID = UUID.fromString("584DF3EE-BD1A-44C1-B66D-5F1015AF8A0E");
    private static final UUID WEI_MIN_CHU_HAI_QUEST_ID = UUID.fromString("3A54CDE8-91B4-42A8-9F37-9C40934A15C8");
    private static final UUID CHU_BAO_AN_LIANG_QUEST_ID = UUID.fromString("066905EA-4B2D-408D-A86E-9D37F450B729");
    private static final UUID LARGE_TRANSACTIONS_A_QUEST_ID = UUID.fromString("7C19EB4E-6E86-41B1-A397-36F7572D383B");
    private static final UUID LARGE_TRANSACTIONS_B_QUEST_ID = UUID.fromString("0A9301D6-0B79-4346-A700-35E7C8339658");
    private static final UUID MARTIAL_ARTS_QUEST_ID = UUID.fromString("C8DA8DB7-2AE8-4FB0-9956-179D9D9D1CA8");
    private static final UUID SHA_REN_DUO_BAO_QUEST_ID = UUID.fromString("10D0CFC0-CD81-4DDE-9716-30D735045D1A");
    private static final UUID REN_WO_XING_QUEST_ID = UUID.fromString("dab3e694-291c-4b58-8ed2-4b215fbcf543");
    private static final UUID CHU_QIANG_FU_RUO_QUEST_ID = UUID.fromString("D8633102-1BC2-47D4-A9D4-311A28860F7D");
    private static final UUID JIANG_HU_ZHUI_SHA_LING_QUEST_ID = UUID.fromString("4ECF3936-B0F7-4F78-90FE-C7E613A08916");
    private static final UUID AO_QI_TINA_DI_JIAN_QUEST_ID = UUID.fromString("edd0cd54-c00c-43b7-aa4c-105e949cf883");
    private static final UUID TIAN_RUO_YOU_QIANG_TIN_YI_LAO_QUEST_ID = UUID.fromString("b005b283-34fa-4217-b417-866d830ccda8");

    private static final UUID SHA_JI_JING_HOU_QUEST_ID =  UUID.fromString("C99BC619-6361-4485-9DA9-C0835F0ABB12");
    public static QuestManager instance = QuestManager.getInstance();

    public static void onPlayerDeath(LivingDeathEvent event){
        if ((event.getEntity() instanceof ServerPlayer player)){
            if (player.level().isClientSide) return;
            QuestManager manager = QuestManager.getInstance();
            List<Quest> playerQuests = manager.getPlayerQuests(player.getUUID());

            // 防御性检查
            if (playerQuests == null || playerQuests.isEmpty()) return;

            // 使用迭代器安全删除
            Iterator<Quest> iterator = playerQuests.iterator();
            while (iterator.hasNext()) {
                Quest quest = iterator.next();
                if (quest == null) continue;

                UUID questId = quest.getQuestId();

                // 处理"任我行"任务重置
                if (REN_WO_XING_QUEST_ID.equals(questId)) {
                    quest.setQuestCurrentDay(0);
                    continue;
                }

                if (AO_QI_TINA_DI_JIAN_QUEST_ID.equals(questId)) {
                    if (!quest.canComplete(player) && quest.getQuestCurrentTime() < quest.getQuestTime()) {
                        manager.removePlayerQuests(iterator);
                        player.sendSystemMessage(getColoredTranslation(
                                "quest." + ChangShengJue.MOD_ID + ".fail",
                                getColoredTranslation(quest.getQuestName())
                        ));
                    }
                }
            }
        }
    }

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (!(player instanceof ServerPlayer)) return;
        if (event.phase != TickEvent.Phase.END) return;

        if (instance.getQuestCompletionCount(JIANG_HU_ZHUI_SHA_LING_QUEST_ID) >= 2){
            Quest martialArtsQuestId = getOrCreateQuest(player, TIAN_RUO_YOU_QIANG_TIN_YI_LAO_QUEST_ID, null);
            if (martialArtsQuestId != null) {
                if (!martialArtsQuestId.canComplete(player) && !martialArtsQuestId.isComplete()) {
                    martialArtsQuestId.setComplete(true);
                    player.sendSystemMessage(getColoredTranslation(
                            "quest." + ChangShengJue.MOD_ID + ".finish", getColoredTranslation(martialArtsQuestId.getQuestName())));
                }
            }
        }
        if (instance.getQuestCompletionCount(TIAN_RUO_YOU_QIANG_TIN_YI_LAO_QUEST_ID) >= 1){
            if (!player.hasEffect(ChangShengJueEffects.VILLAGER_CHARM_EFFECT.get())) {
                player.addEffect(new MobEffectInstance(ChangShengJueEffects.VILLAGER_CHARM_EFFECT.get(), -1,
                        1, false, false, true));
            }
        }

        // 获取当前游戏时间（0-23999）
        long currentTime = player.level().getDayTime() % 24000;
        // 每天只在第一次tick时检查（避免重复触发）
        if (currentTime != 1) return; // 改为每天开始时检测
        if (player.level().isClientSide) return;
        Quest renWoXingQuest = getOrCreateQuest(player, REN_WO_XING_QUEST_ID, null);
        if (renWoXingQuest != null){
            if (renWoXingQuest.getQuestCurrentDay() < 7) {
                renWoXingQuest.setQuestCurrentDay(renWoXingQuest.getQuestCurrentDay() + 1);
            }else if (renWoXingQuest.getQuestCurrentDay() >= 7){
                if (!renWoXingQuest.isComplete()) {
                    renWoXingQuest.setComplete(true);
                    renWoXingQuest.setQuestCurrentDay(0);
                    player.sendSystemMessage(getColoredTranslation(
                            "quest." + ChangShengJue.MOD_ID + ".finish", getColoredTranslation(renWoXingQuest.getQuestName())));
                }
            }
        }

        if (player.getRandom().nextFloat() < 0.1F) {
            Quest jiangHuZhuiShaLingQuest = getOrCreateQuest(player, JIANG_HU_ZHUI_SHA_LING_QUEST_ID, null);
            if (jiangHuZhuiShaLingQuest != null){
                if (jiangHuZhuiShaLingQuest.getQuestCurrentTargetCount() <= jiangHuZhuiShaLingQuest.getQuestTargetCount()) {
                    if (!jiangHuZhuiShaLingQuest.canComplete(player) && !jiangHuZhuiShaLingQuest.isComplete()) {
                        jiangHuZhuiShaLingQuest.setComplete(true);
                        player.sendSystemMessage(getColoredTranslation(
                                "quest." + ChangShengJue.MOD_ID + ".trigger", getColoredTranslation(jiangHuZhuiShaLingQuest.getQuestName())));
                    }
                }
            }
        }
    }

    public static void onEntityGenerate(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (!(player instanceof ServerPlayer)) return;
        if (event.phase != TickEvent.Phase.END) return;
        entityGenerate(player, 200, JIANG_HU_ZHUI_SHA_LING_QUEST_ID, 3);
//        if ((player.level().getGameTime() % 200 != 0)) return;
//        List<Quest> jiangHuZhuiShaLingQuests = instance.getPlayerQuests(player.getUUID());
//        if (jiangHuZhuiShaLingQuests != null){
//            for (Quest quest : jiangHuZhuiShaLingQuests){
//                if (quest.getQuestId().equals(JIANG_HU_ZHUI_SHA_LING_QUEST_ID)) {
//                    if (quest.getQuestCurrentTargetCount() < quest.getQuestTargetCount()){
//                        if (!quest.canComplete(player) && quest.isComplete()) {
//                            instance.spawnTargetForQuest((ServerPlayer) player, quest, (quest.getRequiredKills()) / 3);
//                            quest.setQuestCurrentTargetCount(quest.getQuestCurrentTargetCount() + 1);
//                        }
//                    }
//                }
//            }
//        }
    }
    public static void onZombieGenerate(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (!(player instanceof ServerPlayer)) return;
        if (event.phase != TickEvent.Phase.END) return;
        List<Quest> jiangHuZhuiShaLingQuests = instance.getPlayerQuests(player.getUUID());
        if (jiangHuZhuiShaLingQuests != null){
            for (Quest quest : jiangHuZhuiShaLingQuests){
                if (quest.getQuestId().equals(AO_QI_TINA_DI_JIAN_QUEST_ID)) {
                    if (!quest.canComplete(player)) {
                        if (quest.getQuestCurrentTime() < quest.getQuestTime()){
                            quest.setQuestCurrentTime();
                        }else {
                            quest.setCurrentKills(100);
                            player.sendSystemMessage(getColoredTranslation(
                                    "quest." + ChangShengJue.MOD_ID + ".finish", getColoredTranslation(quest.getQuestName())));
                        }
                    }
                }
            }
        }
        entityGenerate(player, 20, AO_QI_TINA_DI_JIAN_QUEST_ID, 5);
    }

    public static void entityGenerate(Player player, int tick, UUID questUUID, int count) {
        if ((player.level().getGameTime() % tick != 0)) return;
        List<Quest> jiangHuZhuiShaLingQuests = instance.getPlayerQuests(player.getUUID());
        if (jiangHuZhuiShaLingQuests != null){
            for (Quest quest : jiangHuZhuiShaLingQuests){
                if (quest.getQuestId().equals(questUUID)) {
                    if (quest.getQuestCurrentTargetCount() < quest.getQuestTargetCount()){
                        if (!quest.canComplete(player) && quest.isComplete()) {
                            instance.spawnTargetForQuest((ServerPlayer) player, quest, ((quest.getRequiredKills()) / count));
                            quest.setQuestCurrentTargetCount(quest.getQuestCurrentTargetCount() + 1);
                        }
                    }
                }
            }
        }
    }

    public static void onVillagerInteract(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getTarget() instanceof ChangShengJueVillagerEntity villager)) return;
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        // 全局开关检查
        if (!ChangShengJueConfig.ENABLE_QUESTS.get()) return;
        // 检查村民职业（例如农民）
        if (villager.getVillagerData().getProfession() != ChangShengJueVillagers.CHANG_SHENG_JUE_CHIEF.get()) {
            return;
        }

        Set<UUID> allDone = instance.getAllAcceptRepeatableQuests();
        if (allDone != null && !allDone.contains(SHA_JI_JING_HOU_QUEST_ID)){
            if (player.getRandom().nextFloat() < 0.3F){
                Quest chuQiangFuRuoQuest = getOrCreateQuest(player, CHU_QIANG_FU_RUO_QUEST_ID, null);
                if (chuQiangFuRuoQuest != null){
                    if (!chuQiangFuRuoQuest.canComplete(player) && !chuQiangFuRuoQuest.isComplete()){
                        chuQiangFuRuoQuest.setComplete(true);
                        instance.spawnTargetForQuest(player, chuQiangFuRuoQuest, chuQiangFuRuoQuest.getRequiredKills());
                        player.sendSystemMessage(getColoredTranslation(
                                "quest." + ChangShengJue.MOD_ID + ".trigger", getColoredTranslation(chuQiangFuRuoQuest.getQuestName())));
                    }
                }
            }
        }
        if (player.getRandom().nextFloat() < 0.5){
            Quest villagerInteractQuest = getOrCreateQuest(player, CHU_BAO_AN_LIANG_QUEST_ID,null);
            if (villagerInteractQuest != null) {
                if (!villagerInteractQuest.canComplete(player) && !villagerInteractQuest.isComplete()) {
                    villagerInteractQuest.setComplete(true);
                    instance.spawnTargetForQuest(player, villagerInteractQuest, villagerInteractQuest.getRequiredKills());
                    player.sendSystemMessage(getColoredTranslation(
                            "quest." + ChangShengJue.MOD_ID + ".trigger", getColoredTranslation(villagerInteractQuest.getQuestName())));
                }
            }
        }else {
            List<Quest> playerQuests = Optional.ofNullable(QuestManager.getInstance().getPlayerQuests(player.getUUID()))
                    .orElse(Collections.emptyList());

            // 检查是否存在未完成的A或B任务
            Optional<Quest> existingUncompleted = playerQuests.stream()
                    .filter(quest -> quest != null && !quest.isComplete())
                    .filter(quest -> quest.getQuestId().equals(LARGE_TRANSACTIONS_A_QUEST_ID) ||
                            quest.getQuestId().equals(LARGE_TRANSACTIONS_B_QUEST_ID))
                    .findFirst();

            Quest targetQuest = null;

            if (existingUncompleted.isPresent()) {
                // 如果存在未完成的A或B任务，使用该任务
                targetQuest = existingUncompleted.get();
            } else {
                // 只有当A和B都不存在或都已完成时，才生成新任务
                boolean hasA = playerQuests.stream().anyMatch(q -> q != null && q.getQuestId().equals(LARGE_TRANSACTIONS_A_QUEST_ID));
                boolean hasB = playerQuests.stream().anyMatch(q -> q != null && q.getQuestId().equals(LARGE_TRANSACTIONS_B_QUEST_ID));

                if (!hasA && !hasB) {
                    // 如果两个任务都不存在，随机生成一个
                    UUID newQuestId = player.getRandom().nextBoolean() ? LARGE_TRANSACTIONS_A_QUEST_ID : LARGE_TRANSACTIONS_B_QUEST_ID;
                    targetQuest = getOrCreateQuest(player, newQuestId, null);
                }
            }

            if (targetQuest != null && !targetQuest.isComplete()) {
                targetQuest.setComplete(true);
                player.sendSystemMessage(getColoredTranslation(
                        "quest." + ChangShengJue.MOD_ID + ".trigger",
                        getColoredTranslation(targetQuest.getQuestName())));
            }

        }

    }

    public static void onTrackingStart(PlayerEvent.StartTracking event) {
        if (event.getEntity().level().isClientSide) return;
        if (!ChangShengJueConfig.ENABLE_QUESTS.get()) return;

        Player player = event.getEntity();
        Entity target = event.getTarget();

        if (target instanceof Villager){
            onEntityEncounter(player,FIRST_VILLAGER_QUEST_ID,null,1.0F);
        }if (target instanceof Tiger){
            onEntityEncounter(player,WEI_MIN_CHU_HAI_QUEST_ID,null, 0.75F);
        }else if (target instanceof Zombie){
            if (VillageUtils.isPlayerInVillage(player) && TimeDetection.isFullNight(player.level())){
                onEntityEncounter(player,MARTIAL_ARTS_QUEST_ID,null,0.5F);
            }
            if (TimeDetection.isFullNight(player.level())){
                onEntityEncounter(player,AO_QI_TINA_DI_JIAN_QUEST_ID,null,0.1F);
            }
        }else if (target instanceof WanderingTrader){
            onEntityEncounter(player,SHA_REN_DUO_BAO_QUEST_ID,null,0.5F);
        }
    }

//    public static void onVillagerEncounter(Player player, Entity target){
//        if (target instanceof Villager){
//            Quest firstVillagerQuest = getOrCreateQuest(player,FIRST_VILLAGER_QUEST_ID,null);
//
//            if (firstVillagerQuest != null) {
//                if (!firstVillagerQuest.isComplete()) {
//                    firstVillagerQuest.setComplete(true);
//                    player.sendSystemMessage(
//                            getColoredTranslation("quest." + ChangShengJue.MOD_ID + ".trigger",
//                                    getColoredTranslation(firstVillagerQuest.getQuestName()))
//                    );
//                }
//            }
//        }
//    }
//    public static void onTigerEncounter(Player player, Entity target){
//        if (target instanceof Tiger){
//            Quest weiMinChuHaiQuestId = getOrCreateQuest(player, WEI_MIN_CHU_HAI_QUEST_ID,null);
//
//            if (weiMinChuHaiQuestId != null) {
//                if (player.getRandom().nextFloat() < 0.75F){
//                    if (!weiMinChuHaiQuestId.canComplete(player) && !weiMinChuHaiQuestId.isComplete()) {
//                        weiMinChuHaiQuestId.setComplete(true);
//                        player.sendSystemMessage(getColoredTranslation(
//                                        "quest." + ChangShengJue.MOD_ID + ".trigger", getColoredTranslation(weiMinChuHaiQuestId.getQuestName())));
//                    }
//                }
//            }
//        }
//    }
    public static void onEntityEncounter(Player player, UUID questUUID, UUID npcUUID, Float f){
        Quest martialArtsQuestId = getOrCreateQuest(player, questUUID, npcUUID);
        if (martialArtsQuestId != null) {
            if (player.getRandom().nextFloat() < f){
                if (!martialArtsQuestId.canComplete(player) && !martialArtsQuestId.isComplete()) {
                    martialArtsQuestId.setComplete(true);
                    player.sendSystemMessage(getColoredTranslation(
                            "quest." + ChangShengJue.MOD_ID + ".trigger", getColoredTranslation(martialArtsQuestId.getQuestName())));
                }
            }
        }
    }



    public static void onEntityHurt(LivingDamageEvent event){
        if (event.getEntity().level().isClientSide) return;
        if (!ChangShengJueConfig.ENABLE_QUESTS.get()) return;

        if (event.getEntity() instanceof Player player) {
            if (event.getSource().getEntity() instanceof Mob mob) {
                if (player.getRandom().nextFloat() < 0.2) {
                    Quest kuaiYiEnChouQuest = getOrCreateQuest(player,KUAI_YI_EN_CHOU_QUEST_ID,mob.getUUID());
                    if (kuaiYiEnChouQuest != null) {
                        if (!kuaiYiEnChouQuest.isComplete()) {
                            player.sendSystemMessage(getColoredTranslation(
                                            "quest." + ChangShengJue.MOD_ID + ".trigger", getColoredTranslation(kuaiYiEnChouQuest.getQuestName())));
                        }
                    }
                }
            }
        }
        if (!(event.getEntity() instanceof Player) && event.getSource().getEntity() instanceof Player player1) {
            LivingEntity mob = event.getEntity();
//            List<Quest> kuaiYiEnChouQuest = QuestManager.getInstance().getPlayerQuests(player1.getUUID());
//            for (Quest quest : kuaiYiEnChouQuest){
//                if (quest != null && !quest.isComplete()
//                        && quest.getQuestId().equals(KUAI_YI_EN_CHOU_QUEST_ID) && quest.getQuestNpcId() != null) {
//                    if (mob.getUUID().equals(quest.getQuestNpcId()) && event.getAmount() > mob.getHealth()) {
//                        quest.setComplete(true);
//                        if (quest.canComplete(player1)) {
//                            player1.sendSystemMessage(getColoredTranslation(
//                                    "quest." + ChangShengJue.MOD_ID + ".finish", getColoredTranslation(quest.getQuestName())));
//                        }
//                    }
//                }
//            }
            List<Quest> kuaiYiEnChouQuest = QuestManager.getInstance().getPlayerQuests(player1.getUUID());
            Optional.ofNullable(kuaiYiEnChouQuest)
                    .orElse(Collections.emptyList())
                    .stream()
                    .filter(Objects::nonNull)
                    .filter(quest -> quest.getQuestId().equals(KUAI_YI_EN_CHOU_QUEST_ID))
                    .filter(quest -> quest.getQuestNpcId() != null)
                    .filter(quest -> !quest.isComplete())
                    .findFirst()
                    .ifPresent(quest -> {
                        if (mob.getUUID().equals(quest.getQuestNpcId()) &&
                                event.getAmount() > mob.getHealth()) {
                            quest.setComplete(true);
                            if (quest.canComplete(player1)) {
                                player1.sendSystemMessage(getColoredTranslation(
                                        "quest." + ChangShengJue.MOD_ID + ".finish", getColoredTranslation(quest.getQuestName())));
                            }
                        }
                    });
        }
    }

    // 获取带颜色的翻译文本
    public static Component getColoredTranslation(String key, Object... args) {
        String raw = Component.translatable(key, args).getString();
        return Component.literal(raw);
    }

    public static Quest getOrCreateQuest(Player player, UUID uuid, UUID npcId) {
        QuestManager manager = QuestManager.getInstance();

        List<Quest> autoQuests = manager.getPlayerQuests(player.getUUID());

        return autoQuests.stream()
                .filter(q -> uuid.equals(q.getQuestId()))
                .findFirst()
                .orElseGet(() -> {
                    // 不存在则生成并保存
                    Quest newQuest = manager.generateSpecificQuestForPlayer(player, uuid, npcId);
                    manager.saveQuestProgress(newQuest); // 确保持久化
                    manager.saveData();
                    return newQuest;
                });
    }

}
