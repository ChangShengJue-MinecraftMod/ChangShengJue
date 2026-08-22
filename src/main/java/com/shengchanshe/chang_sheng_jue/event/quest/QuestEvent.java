package com.shengchanshe.chang_sheng_jue.event.quest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.init.CSJAdvanceInit;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import com.shengchanshe.chang_sheng_jue.util.TimeDetection;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.village.VillageSiege;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingConversionEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.LevelEvent;

import java.util.*;

public class QuestEvent {
    public static final UUID PROTECT_THE_VILLAGE_QUEST_ID = UUID.fromString("85248ab7-ff1b-4d4d-8a05-92d5360e70eb");
    public static final UUID XING_XIA_ZHANG_YI_QUEST_ID = UUID.fromString("a35c7c77-6920-43c0-abaa-94763adfaa10");
    private static final UUID WRITTEN_PLEDGE_QUEST_ID = UUID.fromString("c4ac1553-b219-4e7c-a54d-e274f9815109");
    private static final UUID RESCUE_VILLAGERS_QUEST_ID = UUID.fromString("7dc9c671-ec29-4f3f-9467-5324fa026499");
    private static final int QUEST_STATE_REFRESH_INTERVAL_TICKS = 20;
    private static final Set<UUID> FIRST_GANG_TASK_IDS = Set.of(
            WRITTEN_PLEDGE_QUEST_ID,
            RESCUE_VILLAGERS_QUEST_ID,
            PlayerQuestEvent.VEGETARIAN_FOOD_QUEST_ID);
    private static final Map<ServerLevel, VillageSiege> DIMENSION_SIEGES = new WeakHashMap<>();
    private static final Set<ServerLevel> ACTIVE_SIEGE_LEVELS = Collections.newSetFromMap(new WeakHashMap<>());
    private static final Map<ServerLevel, Long> INITIALIZED_SIEGE_DAYS = new WeakHashMap<>();

    public static void onEntityDeath(LivingDeathEvent event){
        if (event.getSource().getEntity() instanceof Player player) {
            if (player.level().isClientSide) return;
            UUID playerId = player.getUUID();
            player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
                LivingEntity entity = event.getEntity();
                List<Quest> currentQuest = cap.getQuests(playerId);
                boolean changed = false;
                for (Quest quest : currentQuest) {
                    if (quest != null && quest.getQuestType() == Quest.QuestType.KILL) {
                        if (quest.getSecondTargetEntity() != null && !quest.getSecondTargetEntity().isEmpty()) {
                            if (quest.getCurrentKills() < quest.getRequiredKills()) {
                                if (quest.matchesEntity(entity)) {
                                    if (quest.getQuestId().equals(PlayerQuestEvent.MARTIAL_ARTS_QUEST_ID)){
                                        BlockPos blockpos = player.blockPosition();
                                        ServerLevel level = (ServerLevel) player.level();
                                        if (level.isVillage(blockpos) && TimeDetection.isFullNight(player.level())) {
                                            quest.incrementKills();
                                            changed = true;
                                        }
                                    } else {
                                        quest.incrementKills();
                                        changed = true;
                                    }
                                } else if(quest.getQuestId().equals(PlayerQuestEvent.KUAI_YI_EN_CHOU_QUEST_ID)) {
                                    if (quest.getQuestNpcId() != null && entity.getUUID().equals(quest.getQuestNpcId())) {
                                        quest.incrementKills();
                                        changed = true;
                                    }
                                }
                                if (quest.canComplete(player)) {
                                    player.sendSystemMessage(getColoredTranslation(
                                            "quest." + ChangShengJue.MOD_ID + ".finish",
                                            getColoredTranslation(quest.getQuestName())));
                                    triggerFinishTaskAdvancement(player, quest);
                                }
                            } else if (quest.getSecondCurrentKills() < quest.getSecondRequiredKills()) {
                                if (quest.matchesSecondEntity(entity)) {
                                    quest.secondIncrementKills();
                                    changed = true;
                                }
                                if (quest.canComplete(player)) {
                                    player.sendSystemMessage(getColoredTranslation(
                                            "quest." + ChangShengJue.MOD_ID + ".finish",
                                            getColoredTranslation(quest.getQuestName())));
                                }
                            }
                        } else {
                            if (quest.getCurrentKills() < quest.getRequiredKills()){
                                if (quest.matchesEntity(entity)) {
                                    if (quest.getQuestId().equals(PlayerQuestEvent.MARTIAL_ARTS_QUEST_ID)){
                                        BlockPos blockpos = player.blockPosition();
                                        ServerLevel level = (ServerLevel) player.level();
                                        if (level.isVillage(blockpos) && TimeDetection.isFullNight(player.level())) {
                                            quest.incrementKills();
                                            changed = true;
                                        }
                                    } else {
                                        quest.incrementKills();
                                        changed = true;
                                    }
                                } else if(quest.getQuestId().equals(PlayerQuestEvent.KUAI_YI_EN_CHOU_QUEST_ID)) {
                                    if (quest.getQuestNpcId() != null && entity.getUUID().equals(quest.getQuestNpcId())) {
                                        quest.incrementKills();
                                        changed = true;
                                    }
                                }
                                if (quest.canComplete(player)) {
                                    player.sendSystemMessage(getColoredTranslation(
                                            "quest." + ChangShengJue.MOD_ID + ".finish",
                                            getColoredTranslation(quest.getQuestName())));
                                    triggerFinishTaskAdvancement(player, quest);
                                }
                            }
                        }

                    }
                }

                if (entity instanceof Villager) {
                    if (player.hasEffect(ChangShengJueEffects.VILLAGER_CHARM_EFFECT.get())){
                        player.removeEffect(ChangShengJueEffects.VILLAGER_CHARM_EFFECT.get());
                        player.addEffect(new MobEffectInstance(ChangShengJueEffects.INSTANT_DISFAVOR_EFFECT.get(), 1, 10, false, true));
                    }
                }
                if (entity instanceof Animal){
                    Optional<Quest> vegetarianQuest = currentQuest.stream()
                            .filter(Objects::nonNull) // 过滤空任务
                            .filter(quest -> PlayerQuestEvent.VEGETARIAN_FOOD_QUEST_ID.equals(quest.getQuestId()))
                            .findFirst(); // 保持第一个匹配任务的旧语义
                    if (vegetarianQuest.isPresent()) {
                        Quest quest = vegetarianQuest.get();
                        if (quest.canComplete(player) && quest.getQuestCurrentDay() != 0) {
                            quest.setQuestCurrentDay(0);
                            changed = true;
                        }
                    }
                }
                if (changed && player instanceof ServerPlayer serverPlayer) {
                    cap.syncToClient(serverPlayer);
                }
            });
        }
    }

    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        if (shouldRefreshQuestState(event.getServer().getTickCount())) {
            refreshQuestState(event);
        }
        tickActiveSieges();
    }

    static boolean shouldRefreshQuestState(int serverTickCount) {
        return Math.floorMod(serverTickCount, QUEST_STATE_REFRESH_INTERVAL_TICKS) == 0;
    }

    private static void refreshQuestState(TickEvent.ServerTickEvent event) {
        Set<ServerLevel> activeSiegeLevels = Collections.newSetFromMap(new IdentityHashMap<>());
        for (ServerPlayer player : event.getServer().getPlayerList().getPlayers()) {
            ServerLevel level = (ServerLevel) player.level();

            player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
                List<Quest> quests = cap.getQuests(player.getUUID());
                int activeQuestMask = 0;
                List<Quest> activeQuests = new ArrayList<>(2);
                for (Quest quest : quests) {
                    if (quest == null || quest.isComplete() || !player.getUUID().equals(quest.getAcceptedBy())) {
                        continue;
                    }
                    if (PROTECT_THE_VILLAGE_QUEST_ID.equals(quest.getQuestId())) {
                        activeQuestMask |= 1;
                        activeQuests.add(quest);
                    } else if (XING_XIA_ZHANG_YI_QUEST_ID.equals(quest.getQuestId())) {
                        activeQuestMask |= 2;
                        activeQuests.add(quest);
                    }
                }
                if (activeQuestMask == 0) {
                    return;
                }

                Raid raid = (activeQuestMask & 1) != 0 ? level.getRaidAt(player.blockPosition()) : null;

                for (Quest quest : activeQuests) {
                    if (quest.getQuestId().equals(PROTECT_THE_VILLAGE_QUEST_ID)) {

                        if (raid != null && raid.isVictory() && !quest.isComplete()) {
                            quest.setComplete(true);
                            if (quest.canComplete(player)) {
                                player.sendSystemMessage(getColoredTranslation(
                                        "quest." + ChangShengJue.MOD_ID + ".finish",
                                        getColoredTranslation(quest.getQuestName())));
                            }
                            cap.syncToClient(player);
                        }

                    } else if (quest.getQuestId().equals(XING_XIA_ZHANG_YI_QUEST_ID)
                            && quest.getAcceptedBy() != null
                            && quest.getAcceptedBy().equals(player.getUUID())) {

                        if (!player.isSpectator()) {
                            if (!quest.isComplete() && !level.isDay()) {
                                if (level.isVillage(player.blockPosition())
                                        && !level.getBiome(player.blockPosition()).is(BiomeTags.WITHOUT_ZOMBIE_SIEGES)) {

                                    activeSiegeLevels.add(level);
                                }
                            } else if (!quest.isComplete()) {
                                if (level.isVillage(player.blockPosition())
                                        && !level.getBiome(player.blockPosition()).is(BiomeTags.WITHOUT_ZOMBIE_SIEGES)) {
                                    quest.setComplete(true);
                                    if (quest.canComplete(player)) {
                                        player.sendSystemMessage(getColoredTranslation(
                                                "quest." + ChangShengJue.MOD_ID + ".finish",
                                                getColoredTranslation(quest.getQuestName())));
                                    }
                                    cap.syncToClient(player);
                                }
                            }
                        }
                    }
                }
            });
        }

        for (ServerLevel level : activeSiegeLevels) {
            VillageSiege siege = DIMENSION_SIEGES.computeIfAbsent(level, ignored -> new VillageSiege());
            initializeSiegeForNightWindow(level, siege);
        }
        ACTIVE_SIEGE_LEVELS.retainAll(activeSiegeLevels);
        ACTIVE_SIEGE_LEVELS.addAll(activeSiegeLevels);
    }

    private static void tickActiveSieges() {
        for (ServerLevel level : List.copyOf(ACTIVE_SIEGE_LEVELS)) {
            VillageSiege siege = DIMENSION_SIEGES.get(level);
            if (siege == null) {
                ACTIVE_SIEGE_LEVELS.remove(level);
                continue;
            }
            siege.tick(level, true, false);
        }
    }

    private static void initializeSiegeForNightWindow(ServerLevel level, VillageSiege siege) {
        long currentDay = Math.floorDiv(level.getDayTime(), 24000L);
        Long initializedDay = INITIALIZED_SIEGE_DAYS.get(level);
        if (shouldInitializeSiege(level.getTimeOfDay(0.0F), currentDay, initializedDay)) {
            siege.siegeState = VillageSiege.State.SIEGE_TONIGHT;
            INITIALIZED_SIEGE_DAYS.put(level, currentDay);
        }
    }

    static boolean isSiegeInitializationWindow(float timeOfDay) {
        return (double) timeOfDay >= 0.5D && (double) timeOfDay < 0.503D;
    }

    static boolean shouldInitializeSiege(float timeOfDay, long currentDay, Long initializedDay) {
        return isSiegeInitializationWindow(timeOfDay)
                && (initializedDay == null || initializedDay.longValue() != currentDay);
    }

    public static void onWorldUnload(LevelEvent.Unload event) {
        if (event.getLevel() instanceof ServerLevel serverLevel) {
            ACTIVE_SIEGE_LEVELS.remove(serverLevel);
            DIMENSION_SIEGES.remove(serverLevel);
            INITIALIZED_SIEGE_DAYS.remove(serverLevel);
        }
    }

    public static void clearServerState() {
        ACTIVE_SIEGE_LEVELS.clear();
        DIMENSION_SIEGES.clear();
        INITIALIZED_SIEGE_DAYS.clear();
    }

    // 在僵尸村民实体上直接标记治愈者
    public static void onGoldenAppleUse(PlayerInteractEvent.EntityInteract event) {
        if (event.getTarget() instanceof ZombieVillager zombie &&
                event.getItemStack().is(Items.GOLDEN_APPLE) &&
                event.getEntity() instanceof ServerPlayer player) {

            zombie.getPersistentData().putUUID(
                    "CuringPlayer",
                    player.getUUID()
            );
        }
    }

    public static void onCureComplete(LivingConversionEvent.Post event) {
        if (event.getEntity() instanceof ZombieVillager oldZombie &&
                event.getOutcome() instanceof Villager villager) {

            if (!oldZombie.getPersistentData().hasUUID("CuringPlayer")) {
                return;
            }
            UUID playerId = oldZombie.getPersistentData().getUUID("CuringPlayer");

            Player curingPlayer = villager.level().getPlayerByUUID(playerId);
            if (curingPlayer instanceof ServerPlayer player) {
                player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
                    List<Quest> quests = cap.getQuests(player.getUUID());
                    Optional<Quest> existingUncompleted = quests.stream()
                            .filter(Objects::nonNull)
                            .filter(quest -> quest.getQuestType() == Quest.QuestType.TREAT)
                            .findFirst();

                    if (existingUncompleted.isPresent()) {
                        Quest quest = existingUncompleted.get();
                        if (quest.getQuestType() == Quest.QuestType.TREAT && quest.getAcceptedBy() != null && quest.getAcceptedBy().equals(player.getUUID())) {
                            quest.setComplete(true);
                            if (quest.canComplete(player)) {
                                player.sendSystemMessage(getColoredTranslation(
                                        "quest." + ChangShengJue.MOD_ID + ".finish",
                                        getColoredTranslation(quest.getQuestName())));
                                triggerFinishTaskAdvancement(player, quest);
                                cap.syncToClient(player);
                            }
                        }
                    }
                });
            }
        }
    }

    private static void triggerFinishTaskAdvancement(Player player, Quest quest) {
        if (player instanceof ServerPlayer serverPlayer
                && quest != null
                && FIRST_GANG_TASK_IDS.contains(quest.getQuestId())) {
            CSJAdvanceInit.FINISH_TASK.trigger(serverPlayer);
        }
    }

    // 获取带颜色的翻译文本
    public static Component getColoredTranslation(String key, Object... args) {
        return Component.translatable(key, args);
    }
}
