package com.shengchanshe.changshengjue.event.quest;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.custom.wuxia.challenger.Challenger;
import com.shengchanshe.changshengjue.init.CSJAdvanceInit;
import com.shengchanshe.changshengjue.quest.Quest;
import com.shengchanshe.changshengjue.quest.QuestManager;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.village.VillageSiege;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingConversionEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class QuestEvent {
    public static final UUID VEGETARIAN_FOOD_QUEST_ID = UUID.fromString("33954498-78EF-492C-9338-B2E85C0AD184");

    public static final UUID PROTECT_THE_VILLAGE_QUEST_ID = UUID.fromString("85248ab7-ff1b-4d4d-8a05-92d5360e70eb");
    public static final UUID XING_XIA_ZHANG_YI_QUEST_ID = UUID.fromString("a35c7c77-6920-43c0-abaa-94763adfaa10");

    public static void onEntityDeath(LivingDeathEvent event){
        if (event.getSource().getEntity() instanceof Player player) {
            if (player.level().isClientSide) return;
            UUID playerId = player.getUUID();
            if (event.getEntity() instanceof Challenger challenger) {
                float health = challenger.getHealth();
                if (health > 0) {return;}
            }
            List<Quest> currentQuest = QuestManager.getInstance().getPlayerQuests(playerId);
            for (Quest quest : currentQuest) {
                if (quest != null && quest.getQuestType() == Quest.QuestType.KILL) {
                    if (quest.matchesEntity(event.getEntity()) && quest.getCurrentKills() < quest.getRequiredKills()) {
                        quest.incrementKills();
                        QuestManager.getInstance().saveQuestProgress(quest);
                        if (quest.canComplete(player)) {
                            player.sendSystemMessage(Component.literal(
                                    "§a"+ quest.getQuestName()+ "任务进度: " + quest.getCurrentKills() + "/" + quest.getRequiredKills()
                            ));
                            if(Objects.equals(quest.getQuestName(), "救民侠医") && Objects.equals(quest.getQuestName(), "投名状") && Objects.equals(quest.getQuestName(), "斋饭")){
                                if(player instanceof ServerPlayer serverPlayer) {
                                    CSJAdvanceInit.FINISH_TASK.trigger(serverPlayer);
                                }
                            }
                        }
                    }
                }
            }
            if (event.getEntity() instanceof Villager) {
                if (player.hasEffect(ChangShengJueEffects.VILLAGER_CHARM_EFFECT.get())){
                    player.removeEffect(ChangShengJueEffects.VILLAGER_CHARM_EFFECT.get());
                    player.addEffect(new MobEffectInstance(ChangShengJueEffects.INSTANT_DISFAVOR_EFFECT.get(), 1, 10, false, true));
                    QuestManager.getInstance().removeQuestCompletion(UUID.fromString("b005b283-34fa-4217-b417-866d830ccda8"));
                }
            }
            if (event.getEntity() instanceof Animal){
                QuestManager manager = QuestManager.getInstance();
                // 防御性检查（包含日志记录）
                if (manager == null) {
                    ChangShengJue.LOGGER.warn("QuestManager或PlayerUUID为空");
                    return;
                }
                // 优化后的查询逻辑
                manager.getPlayerQuests(playerId).stream()
                        .filter(Objects::nonNull) // 过滤空任务
                        .filter(quest -> VEGETARIAN_FOOD_QUEST_ID.equals(quest.getQuestId()))
                        .findFirst() // 找到第一个匹配即可
                        .ifPresent(quest -> {
                            if (quest.canComplete(player)) {
                                quest.setQuestCurrentDay(0);
                                manager.saveData();
                            }
                        });
            }
        }
    }

    public static void onEntityHurt(LivingDamageEvent event){
        if (event.getEntity().level().isClientSide) return;
        if (!(event.getEntity() instanceof Challenger target)) return;
        if (!(event.getSource().getEntity() instanceof Player player)) return;

        boolean isDying = target.getHealth() <= event.getAmount() &&
                target.getHealth() < target.getMaxHealth() * 0.15 && target.getHealth() > 0;
        if (!isDying) return;

        QuestManager manager = QuestManager.getInstance();
        manager.getPlayerQuests(player.getUUID()).stream()
                .filter(quest -> quest != null &&
                        quest.getQuestType() == Quest.QuestType.KILL &&
                        quest.matchesEntity(target))
                .forEach(quest -> {
                    quest.incrementKills();
                    manager.saveQuestProgress(quest);

                    target.discard();

                    if (quest.canComplete(player)) {
                        player.sendSystemMessage(Component.literal(
                                "§a"+ quest.getQuestName()+ "任务进度: " + quest.getCurrentKills() + "/" + quest.getRequiredKills()
                        ));
                        if(Objects.equals(quest.getQuestName(), "救民侠医") && Objects.equals(quest.getQuestName(), "投名状") && Objects.equals(quest.getQuestName(), "斋饭")){
                            if(player instanceof ServerPlayer serverPlayer) {
                                CSJAdvanceInit.FINISH_TASK.trigger(serverPlayer);
                            }
                        }
                    }
                });
    }

    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return; // 只在 tick 结束时检测

        // 遍历所有服务器玩家
        for (ServerPlayer player : event.getServer().getPlayerList().getPlayers()) {
            ServerLevel level = (ServerLevel) player.level();
            Raid raid = level.getRaidAt(player.blockPosition());
            if (QuestManager.getInstance().getPlayerQuests(player.getUUID()).isEmpty()) return;
            List<Quest> playerQuests = QuestManager.getInstance().getPlayerQuests(player.getUUID());
            for (Quest quests : playerQuests) {
                if (quests.getAcceptedBy() != null && quests.getAcceptedBy().equals(player.getUUID())
                        && quests.getQuestId().equals(PROTECT_THE_VILLAGE_QUEST_ID)) {
                    if (raid != null && raid.isVictory()) {
                        quests.setComplete(true);
                        if (quests.canComplete(player)) {
                            player.sendSystemMessage(Component.literal("§a" + quests.getQuestName() + "任务已完成"));
                            break;
                        }
                    }
                }else if (quests.getQuestId().equals(XING_XIA_ZHANG_YI_QUEST_ID) && quests.getAcceptedBy() != null
                        && quests.getAcceptedBy().equals(player.getUUID())) {
                    if (!player.isSpectator()) {
                        if (!quests.isComplete() && !level.isDay()) {
                            if (level.isVillage(player.blockPosition()) && !level.getBiome(player.blockPosition()).is(BiomeTags.WITHOUT_ZOMBIE_SIEGES)) {
                                float f = level.getTimeOfDay(0.0F);
                                VillageSiege siege = new VillageSiege();
                                if ((double) f >= 0.5 && f < 0.503) {
                                    siege.siegeState = VillageSiege.State.SIEGE_TONIGHT;
                                }
                                siege.tick(level, true, false); // 参数：世界、是否生成敌对生物、是否生成友好生物
                            }
                        } else if (!quests.isComplete()) {
                            float f = level.getTimeOfDay(0.0F);
                            if ((double) f >= 0.0 && level.isVillage(player.blockPosition())
                                    && !level.getBiome(player.blockPosition()).is(BiomeTags.WITHOUT_ZOMBIE_SIEGES)) {
                                quests.setComplete(true);
                            }
                            if (quests.canComplete(player)) {
                                player.sendSystemMessage(Component.literal("§a" + quests.getQuestName() + "任务已完成"));
                                break;
                            }
                        }
                    }
                }
            }
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

            if (playerId != null) {
                ServerPlayer player = (ServerPlayer) villager.level()
                        .getPlayerByUUID(playerId);
                if (player != null) {
                    List<Quest> playerQuests = QuestManager.getInstance().getPlayerQuests(player.getUUID());
                    for (Quest quests : playerQuests) {
                        if (quests.getQuestType() == Quest.QuestType.TREAT && quests.getAcceptedBy() != null && quests.getAcceptedBy().equals(player.getUUID())) {
                            quests.setComplete(true);
                            if (quests.canComplete(player)) {
                                player.sendSystemMessage(Component.literal("§a" + quests.getQuestName() + "任务已完成"));
                            }
                        }
                    }
                }
            }
        }
    }

}
