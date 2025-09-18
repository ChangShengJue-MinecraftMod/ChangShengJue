package com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.AbstractWuXia;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.AbstractWuXiaMerchant;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AbstractGangLeader extends AbstractWuXiaMerchant {
    // 使用ConcurrentHashMap存储每个玩家的任务列表
    private final Map<UUID, List<Quest>> playerQuests = new ConcurrentHashMap<>();

    public AbstractGangLeader(EntityType<? extends AbstractWuXia> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public void resetOffers() {
        this.offers = null; // 强制下次访问时重新生成
    }

    public void openTradingScreen(Player pPlayer, Component pDisplayName, int pLevel) {
        // 实现交易界面打开逻辑
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemInHand = pPlayer.getItemInHand(pHand);
        if (this.isAlive() && !this.isTrading() && !this.isBaby()) {
            if (pHand == InteractionHand.MAIN_HAND) {
                pPlayer.awardStat(Stats.TALKED_TO_VILLAGER);
            }

            if (this.getOffers().isEmpty()) {
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            } else {
                if (!this.level().isClientSide) {
                    this.startTrading(pPlayer);
                }
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }
        } else {
            return super.mobInteract(pPlayer, pHand);
        }
    }

    /**
     * 移除指定玩家接受的任务
     * @param playerId 玩家UUID
     * @param questId 要删除的任务ID
     */
    public void removeQuest(UUID playerId, UUID questId) {
        if (playerQuests.containsKey(playerId)) {
            playerQuests.get(playerId).removeIf(quest -> quest.getQuestId().equals(questId));
            ChangShengJue.LOGGER.info("已移除玩家{}的任务: {}", playerId, questId);
        }
    }

    /**
     * 移除玩家所有已经接受的任务(acceptedBy为null的任务)
     * @param playerId 玩家UUID
     */
    public void removeUnacceptedQuests(UUID playerId) {
        if (playerQuests.containsKey(playerId)) {
            playerQuests.get(playerId).removeIf(quest -> quest.getAcceptedBy() == null);
        }
    }

    /**
     * 清除指定玩家的所有任务
     * @param playerId 玩家UUID
     */
    public void clearPlayerQuests(UUID playerId) {
        playerQuests.remove(playerId);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);

        // 保存所有玩家的任务数据
        ListTag playerQuestsTag = new ListTag();
        for (Map.Entry<UUID, List<Quest>> entry : playerQuests.entrySet()) {
            CompoundTag playerTag = new CompoundTag();
            playerTag.putUUID("PlayerId", entry.getKey());

            ListTag questsTag = new ListTag();
            for (Quest quest : entry.getValue()) {
                CompoundTag questTag = quest.toNbt();
                questsTag.add(questTag);
            }
            playerTag.put("Quests", questsTag);
            playerQuestsTag.add(playerTag);
        }
        pCompound.put("PlayerQuests", playerQuestsTag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);

        // 读取所有玩家的任务数据
        if (pCompound.contains("PlayerQuests", Tag.TAG_LIST)) {
            ListTag playerQuestsTag = pCompound.getList("PlayerQuests", Tag.TAG_COMPOUND);
            for (Tag tag : playerQuestsTag) {
                CompoundTag playerTag = (CompoundTag) tag;
                UUID playerId = playerTag.getUUID("PlayerId");

                List<Quest> quests = new ArrayList<>();
                ListTag questsTag = playerTag.getList("Quests", Tag.TAG_COMPOUND);
                for (Tag questTag : questsTag) {
                    Quest quest = new Quest((CompoundTag) questTag);
                    quests.add(quest);
                }
                playerQuests.put(playerId, quests);
            }
        }
    }

    /**
     * 获取指定玩家的任务列表
     * @param playerId 玩家UUID
     * @return 该玩家的任务列表(如果没有则创建空列表)
     */
    public List<Quest> getPlayerQuests(UUID playerId) {
        return playerQuests.computeIfAbsent(playerId, k -> new ArrayList<>());
    }

    /**
     * 为指定玩家添加任务
     * @param playerId 玩家UUID
     * @param quest 要添加的任务
     */
    public void addQuestForPlayer(UUID playerId, Quest quest) {
        if (quest == null) return;
        List<Quest> quests = getPlayerQuests(playerId);

        // 检查是否已存在相同ID的任务
        for (int i = 0; i < quests.size(); i++) {
            Quest existingQuest = quests.get(i);
            if (existingQuest != null && existingQuest.getQuestId().equals(quest.getQuestId())) {
                // 更新现有任务
                quests.set(i, quest);
                ChangShengJue.LOGGER.debug("更新玩家 {} 的现有任务: {}", playerId, quest.getQuestId());
                return;
            }
        }

        // 如果不存在，添加新任务
        quests.add(quest);
        ChangShengJue.LOGGER.debug("为玩家 {} 添加新任务: {}", playerId, quest.getQuestId());
    }

    /**
     * 获取所有玩家的任务数据(主要用于调试)
     * @return 所有玩家的任务映射
     */
    public Map<UUID, List<Quest>> getAllPlayerQuests() {
        return Collections.unmodifiableMap(playerQuests);
    }
}