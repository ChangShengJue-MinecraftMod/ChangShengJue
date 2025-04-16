package com.shengchanshe.changshengjue.event.quest;

import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.quest.Quest;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.quest.QuestManager;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.custom.wuxia.challenger.Challenger;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.event.entity.living.LivingConversionEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.ZombieEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class QuestEvent {
    public static void onEntityDeath(LivingDeathEvent event){
        if (event.getSource().getEntity() instanceof Player player) {
            UUID playerId = player.getUUID();
            if (event.getEntity() instanceof Challenger challenger) {
                float health = challenger.getHealth();
                if (health > 0){
                    return;
                }
            }
            // 获取玩家当前接受的任务
            List<Quest> currentQuest = QuestManager.getInstance().getPlayerQuests(playerId);
            for(Quest quest : currentQuest){
                if (quest != null && quest.getQuestType() == Quest.QuestType.KILL) {
                    if (quest.matchesEntity(event.getEntity())) {
                        quest.incrementKills();
                        // 保存任务进度
                        QuestManager.getInstance().saveQuestProgress(quest);
                    }
                    if (quest.canComplete(player)) {
//                        // 通知玩家任务完成
                        player.sendSystemMessage(Component.literal(
                                "§a"+ quest.getQuestName()+ "任务进度: " + quest.getCurrentKills() + "/" + quest.getRequiredKills()
                        ));
                    }
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
                                "§a任务进度: " + quest.getCurrentKills() + "/" + quest.getRequiredKills()
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
