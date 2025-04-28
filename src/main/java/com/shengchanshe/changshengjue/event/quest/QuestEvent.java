package com.shengchanshe.changshengjue.event.quest;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.quest.Quest;
import com.shengchanshe.changshengjue.quest.QuestManager;
import com.shengchanshe.changshengjue.entity.custom.wuxia.challenger.Challenger;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingConversionEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.util.*;

public class QuestEvent {
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
                if (quests.getQuestType() == Quest.QuestType.RAID && quests.getAcceptedBy() != null && quests.getAcceptedBy().equals(player.getUUID())) {
                    if (raid != null && raid.isVictory()) {
                        quests.setComplete(true);
                        if (quests.canComplete(player)) {
                            player.sendSystemMessage(Component.literal("§a" + quests.getQuestName() + "任务已完成"));
                            break;
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
