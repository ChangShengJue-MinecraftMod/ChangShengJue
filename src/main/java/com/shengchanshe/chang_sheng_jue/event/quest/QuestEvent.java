package com.shengchanshe.chang_sheng_jue.event.quest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest.ClientQuestDataCache;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.init.CSJAdvanceInit;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import com.shengchanshe.chang_sheng_jue.quest.QuestManager;
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

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class QuestEvent {
    public static final UUID PROTECT_THE_VILLAGE_QUEST_ID = UUID.fromString("85248ab7-ff1b-4d4d-8a05-92d5360e70eb");
    public static final UUID XING_XIA_ZHANG_YI_QUEST_ID = UUID.fromString("a35c7c77-6920-43c0-abaa-94763adfaa10");

    public static void onEntityDeath(LivingDeathEvent event){
        if (event.getSource().getEntity() instanceof Player player) {
            if (player.level().isClientSide) return;
            UUID playerId = player.getUUID();
            player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
                LivingEntity entity = event.getEntity();
                List<Quest> currentQuest = cap.getQuests(playerId);
                for (Quest quest : currentQuest) {
                    if (quest != null && quest.getQuestType() == Quest.QuestType.KILL) {
                        if (quest.getCurrentKills() < quest.getRequiredKills()){
                            if (quest.matchesEntity(entity)) {
                                if (quest.getQuestId().equals(PlayerQuestEvent.MARTIAL_ARTS_QUEST_ID)){
                                    BlockPos blockpos = player.blockPosition();
                                    ServerLevel level = (ServerLevel) player.level();
                                    if (level.isVillage(blockpos) && TimeDetection.isFullNight(player.level())) {
                                        quest.incrementKills();
                                    }
                                } else {
                                    quest.incrementKills();
                                }
                            } else if(quest.getQuestId().equals(PlayerQuestEvent.KUAI_YI_EN_CHOU_QUEST_ID)) {
                                if (quest.getQuestNpcId() != null && entity.getUUID().equals(quest.getQuestNpcId())) {
                                    quest.incrementKills();
                                }
                            }
                            if (quest.canComplete(player)) {
                                player.sendSystemMessage(Component.literal(
                                        "§a"+ quest.getQuestName()+ "任务进度: " + quest.getCurrentKills() + "/" + quest.getRequiredKills()));
                                if(Objects.equals(quest.getQuestName(), "救民侠医") && Objects.equals(quest.getQuestName(), "投名状") && Objects.equals(quest.getQuestName(), "斋饭")){
                                    if(player instanceof ServerPlayer serverPlayer) {
                                        CSJAdvanceInit.FINISH_TASK.trigger(serverPlayer);
                                    }
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
                    QuestManager manager = QuestManager.getInstance();
                    // 防御性检查（包含日志记录）
                    if (manager == null) {
                        ChangShengJue.LOGGER.warn("QuestManager或PlayerUUID为空");
                        return;
                    }
                    // 优化后的查询逻辑
                    manager.getPlayerQuests(player.level(),playerId).stream()
                            .filter(Objects::nonNull) // 过滤空任务
                            .filter(quest -> PlayerQuestEvent.VEGETARIAN_FOOD_QUEST_ID.equals(quest.getQuestId()))
                            .findFirst() // 找到第一个匹配即可
                            .ifPresent(quest -> {
                                if (quest.canComplete(player)) {
                                    quest.setQuestCurrentDay(0);
                                }
                            });
                }
                cap.syncToClient((ServerPlayer) player);
            });
        }
    }

    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return; // 只在 tick 结束时检测

        // 遍历所有服务器玩家
        for (ServerPlayer player : event.getServer().getPlayerList().getPlayers()) {
            ServerLevel level = (ServerLevel) player.level();
            Raid raid = level.getRaidAt(player.blockPosition());
            player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
                List<Quest> quests = cap.getQuests(player.getUUID());
                Optional<Quest> existingUncompleted = quests.stream()
                        .filter(Objects::nonNull)
                        .findFirst();

                if (existingUncompleted.isPresent()) {
                    Quest quest = existingUncompleted.get();
                    if (quest.getAcceptedBy() != null && quest.getAcceptedBy().equals(player.getUUID())
                            && quest.getQuestId().equals(PROTECT_THE_VILLAGE_QUEST_ID)) {
                        if (raid != null && raid.isVictory() && !quest.isComplete()) {
                            quest.setComplete(true);
                            if (quest.canComplete(player)) {
                                player.sendSystemMessage(Component.literal("§a" + quest.getQuestName() + "任务已完成"));
                            }
                        }
                    }else if (quest.getQuestId().equals(XING_XIA_ZHANG_YI_QUEST_ID) && quest.getAcceptedBy() != null
                            && quest.getAcceptedBy().equals(player.getUUID())) {
                        if (!player.isSpectator()) {
                            if (!quest.isComplete() && !level.isDay()) {
                                if (level.isVillage(player.blockPosition()) && !level.getBiome(player.blockPosition()).is(BiomeTags.WITHOUT_ZOMBIE_SIEGES)) {
                                    float f = level.getTimeOfDay(0.0F);
                                    VillageSiege siege = new VillageSiege();
                                    if ((double) f >= 0.5 && f < 0.503) {
                                        siege.siegeState = VillageSiege.State.SIEGE_TONIGHT;
                                    }
                                    siege.tick(level, true, false); // 参数：世界、是否生成敌对生物、是否生成友好生物
                                }
                            } else if (!quest.isComplete()) {
                                float f = level.getTimeOfDay(0.0F);
                                if ((double) f >= 0.0 && level.isVillage(player.blockPosition())
                                        && !level.getBiome(player.blockPosition()).is(BiomeTags.WITHOUT_ZOMBIE_SIEGES)) {
                                    quest.setComplete(true);
                                }
                                if (quest.canComplete(player)) {
                                    player.sendSystemMessage(Component.literal("§a" + quest.getQuestName() + "任务已完成"));
                                }
                            }
                        }
                    }
                }
            });
        }

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

            UUID playerId = oldZombie.getPersistentData()
                    .getUUID("CuringPlayer");

            ServerPlayer player = (ServerPlayer) villager.level()
                    .getPlayerByUUID(playerId);
            if (player != null) {
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
                                player.sendSystemMessage(Component.literal("§a" + quest.getQuestName() + "任务已完成"));
                            }
                        }
                    }
                });
            }
        }
    }

    public static void onWorldUnload(LevelEvent.Unload event) {
        ClientQuestDataCache.get().clear();
    }

}
