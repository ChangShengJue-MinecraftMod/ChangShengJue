package com.shengchanshe.chang_sheng_jue.capability.quest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.clubbed.ClubbedGangLeader;
import com.shengchanshe.chang_sheng_jue.event.quest.PlayerQuestEvent;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest.SyncQuestDataPacket;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import com.shengchanshe.chang_sheng_jue.quest.QuestLoader;
import com.shengchanshe.chang_sheng_jue.quest.QuestManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.player.Player;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.shengchanshe.chang_sheng_jue.event.quest.PlayerQuestEvent.getColoredTranslation;

public class PlayerQuestCapability {
    // 简化为只保存玩家任务列表和完成次数
    private final Map<UUID, List<Quest>> playerQuests = new ConcurrentHashMap<>();

    private final Map<UUID, Integer> questCompletionCounts = new ConcurrentHashMap<>();
    // 新增字段（使用ConcurrentHashMap保证线程安全）
    private final Set<UUID> completedQuests = ConcurrentHashMap.newKeySet();
    private final Set<UUID> acceptedQuests = ConcurrentHashMap.newKeySet();

    // 新增大额交易首次触发状态
    private boolean firstLargeTransactionTrigger = true;

    // 新增除暴安良任务首次触发状态
    private boolean firstChuBaoAnLiangTrigger = true;

    public void copyFrom(PlayerQuestCapability source) {
        this.playerQuests.clear();
        this.playerQuests.putAll(source.playerQuests);
        this.questCompletionCounts.clear();
        this.questCompletionCounts.putAll(source.questCompletionCounts);
        this.completedQuests.clear();
        this.completedQuests.addAll(source.completedQuests);
    }

    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();

        // 保存玩家任务列表（添加null检查）
        ListTag playersTag = new ListTag();
        playerQuests.forEach((uuid, quests) -> {
            // 跳过空玩家ID或空任务列表
            if (uuid == null || quests == null) return;

            CompoundTag playerTag = new CompoundTag();
            playerTag.putUUID("PlayerId", uuid);

            ListTag questsTag = new ListTag();
            quests.stream()
                    .filter(Objects::nonNull) // 过滤掉null任务
                    .forEach(quest -> {
                        CompoundTag questTag = quest.toNbt();
                        if (questTag != null) { // 额外检查NBT转换结果
                            questsTag.add(questTag);
                        }
                    });
            playerTag.put("Quests", questsTag);

            playersTag.add(playerTag);
        });
        tag.put("PlayerQuests", playersTag);

        // 保存任务完成次数（添加null检查）
        CompoundTag countsTag = new CompoundTag();
        questCompletionCounts.forEach((uuid, count) -> {
            if (uuid != null) { // 跳过null任务ID
                countsTag.putInt(uuid.toString(), count);
            }
        });
        tag.put("QuestCompletionCounts", countsTag);

        ListTag completedTag = new ListTag();
        completedQuests.stream()
                .filter(Objects::nonNull)
                .forEach(uuid -> completedTag.add(NbtUtils.createUUID(uuid)));
        tag.put("CompletedQuests", completedTag);

        ListTag acceptedTag = new ListTag();
        acceptedQuests.stream()
                .filter(Objects::nonNull)
                .forEach(uuid -> acceptedTag.add(NbtUtils.createUUID(uuid)));
        tag.put("AcceptedQuests", acceptedTag);

        return tag;
    }

    public void deserializeNBT(CompoundTag tag) {
        // 加载玩家任务（添加null检查）
        if (tag.contains("PlayerQuests", Tag.TAG_LIST)) {
            ListTag playersTag = tag.getList("PlayerQuests", Tag.TAG_COMPOUND);
            for (Tag t : playersTag) {
                if (!(t instanceof CompoundTag playerTag)) continue;

                UUID playerId = playerTag.hasUUID("PlayerId") ?
                        playerTag.getUUID("PlayerId") : null;
                if (playerId == null) continue;

                List<Quest> quests = new ArrayList<>();
                if (playerTag.contains("Quests", Tag.TAG_LIST)) {
                    ListTag questsTag = playerTag.getList("Quests", Tag.TAG_COMPOUND);
                    for (Tag q : questsTag) {
                        if (q instanceof CompoundTag questTag) {
                            Quest quest = new Quest(questTag);
                            if (quest.isValid()) { // 假设Quest类有验证方法
                                quests.add(quest);
                            }
                        }
                    }
                }

                if (tag.contains("AcceptedQuests", Tag.TAG_LIST)) {
                    ListTag acceptedTag = tag.getList("AcceptedQuests", Tag.TAG_INT_ARRAY);
                    acceptedTag.stream()
                            .map(NbtUtils::loadUUID)
                            .forEach(acceptedQuests::add);
                }

                if (!quests.isEmpty()) {
                    playerQuests.put(playerId, quests);
                }
            }
        }

        // 加载任务完成次数（添加null检查）
        if (tag.contains("QuestCompletionCounts", Tag.TAG_COMPOUND)) {
            CompoundTag countsTag = tag.getCompound("QuestCompletionCounts");
            for (String key : countsTag.getAllKeys()) {
                try {
                    UUID questId = UUID.fromString(key);
                    questCompletionCounts.put(questId, countsTag.getInt(key));
                } catch (IllegalArgumentException e) {
                    ChangShengJue.LOGGER.warn("Invalid quest UUID in saved data: {}", key);
                }
            }
        }

        if (tag.contains("CompletedQuests", Tag.TAG_LIST)) {
            ListTag completedTag = tag.getList("CompletedQuests", Tag.TAG_INT_ARRAY);
            completedTag.stream()
                    .map(NbtUtils::loadUUID)
                    .forEach(completedQuests::add);
        }
    }

    public Quest triggerGangQuest(Player player, AbstractGangLeader questNpc, Float triggerChance) {
        // 1. 前置校验
        if (!validateTriggerConditions(player, questNpc.getUUID(), triggerChance)) {
            return null;
        }
        // 2. 获取或创建任务列表
        List<Quest> quests = playerQuests.computeIfAbsent(player.getUUID(),
                k -> new CopyOnWriteArrayList<>());
        // 3. 检查现有任务
        Optional<Quest> existingQuest = findExistingQuest(quests, questNpc.getUUID());
        // 4. 处理任务触发
        if (existingQuest.isEmpty()) {
            return tryCreateNewQuest(player, questNpc, triggerChance, quests);
        } else {
            return handleExistingQuest(player, questNpc, triggerChance, quests, existingQuest.get());
        }
    }

    private boolean validateTriggerConditions(Player player, UUID questNpcId, Float chance) {
        if (player == null || questNpcId == null) {
            return false;
        }

        return !(player.getRandom().nextFloat() >= chance);
    }

    private Optional<Quest> findExistingQuest(List<Quest> quests, UUID npcId) {
        return quests.stream()
                .filter(Objects::nonNull)
                .filter(q -> npcId.equals(q.getQuestNpcId()))
                .findFirst();
    }

    private Quest tryCreateNewQuest(Player player, AbstractGangLeader questNpc, float chance, List<Quest> quests) {
        Quest newQuest = QuestLoader.loadQuest(questNpc.getUUID(), completedQuests);
        if (newQuest == null) {
            ChangShengJue.LOGGER.error("任务加载失败: {}", questNpc.getUUID());
            return null;
        }

        if (!validateNewQuest(player, newQuest, questNpc)) {
            return tryCreateNewQuest(player, questNpc, chance, quests);
        }

        syncToClient((ServerPlayer) player);
        return newQuest;
    }

    private boolean validateNewQuest(Player player, Quest quest, AbstractGangLeader questNpc) {
        // 前置任务检查
        if (quest.isNeedCompletePreQuest() && !quest.checkPrerequisiteQuests(this)) {
            return false;
        } else if (quest.isConflictQuest() && quest.checkConflictQuests(this)) {
            return false;
        }

        if (quest.getQuestId().equals(PlayerQuestEvent.VEGETARIAN_FOOD_QUEST_ID) && !(questNpc instanceof ClubbedGangLeader)){
            return false;
        }

        //任务条件检查
        if (player.level().getDifficulty() == Difficulty.PEACEFUL && quest.getQuestType() == Quest.QuestType.KILL) {
            return false;
        }
        // 不可重复任务检查
        if (!quest.isRepeatable() && completedQuests.contains(quest.getQuestId())) {
            return false;
        }

        return quest.isValid();
    }

//    private void processValidQuest(ServerPlayer player, Quest quest) {
//        quest.setComplete(true);
//        int killCount = quest.getRequiredKills() + 1;
//        QuestManager.getInstance().spawnTargetForQuest(player, quest, killCount);
//    }

    private Quest handleExistingQuest(Player player, AbstractGangLeader questNpc, float chance,
                                     List<Quest> quests, Quest existingQuest) {
        if (!questNpc.getUUID().equals(existingQuest.getQuestNpcId())) {
            return tryCreateNewQuest(player, questNpc, chance, quests);
        }else {
            return existingQuest;
        }
    }

    public void triggerQuest(Player player, UUID questId, Float f, UUID mobId){
        // 前置参数检查
        if (player == null || questId == null) {
            ChangShengJue.LOGGER.warn("触发任务失败：玩家ID或任务ID为null");
            return;
        }
        // 获取或创建任务列表（线程安全）
        List<Quest> quests = playerQuests.computeIfAbsent(player.getUUID(),
                k -> new CopyOnWriteArrayList<>());

        // 查找现有任务（带健壮性检查）
        Optional<Quest> existingQuest = quests.stream()
                .filter(Objects::nonNull)
                .filter(q -> questId.equals(q.getQuestId()))
                .findFirst();
        if (existingQuest.isEmpty()) {
            if (player.getRandom().nextFloat() < f) {
                Quest newQuest = QuestLoader.loadSpecificQuest(questId, mobId != null ? mobId : player.getUUID());// 您的任务生成逻辑
                if (newQuest != null) {
                    if (player.level().getDifficulty() == Difficulty.PEACEFUL && newQuest.getQuestType() == Quest.QuestType.KILL) {
                        return;
                    }
                    if (newQuest.checkPrerequisiteQuests(this) && !newQuest.checkConflictQuests(this)) {
                        if (isQuestCompleted(questId) && !newQuest.isRepeatable()) {
                            return;
                        }
                        if (newQuest.isValid()) {
                            if (newQuest.getQuestType() == Quest.QuestType.AUTOMATIC){
                                newQuest.setComplete(true);
                            }
                            if (mobId != null) {
                                newQuest.setQuestNpcId(mobId);
                            }
                            newQuest.setAcceptedBy(player.getUUID());
                            quests.add(newQuest);
                            QuestManager.getInstance().spawnTargetForQuest((ServerPlayer) player, newQuest, newQuest.getRequiredKills());
                            player.sendSystemMessage(getColoredTranslation(
                                    "quest." + ChangShengJue.MOD_ID + ".trigger", getColoredTranslation(newQuest.getQuestName())));
                        }
                    }
                    this.syncToClient((ServerPlayer) player);
                }
            }
        } else {
            Quest quest = existingQuest.get();
            if (quest.getQuestId().equals(PlayerQuestEvent.REN_WO_XING_QUEST_ID)) {
                if (quest.getQuestCurrentDay() < 7) {
                    quest.setQuestCurrentDay(quest.getQuestCurrentDay() + 1);
                } else if (quest.getQuestCurrentDay() >= 7) {
                    if (!quest.isComplete()) {
                        quest.setComplete(true);
                        quest.setQuestCurrentDay(0);
                        player.sendSystemMessage(getColoredTranslation(
                                "quest." + ChangShengJue.MOD_ID + ".finish", getColoredTranslation(quest.getQuestName())));
                    }
                }
            }else if (quest.getQuestId().equals(PlayerQuestEvent.VEGETARIAN_FOOD_QUEST_ID)) {
                if (quest.getQuestCurrentDay() < 2) {
                    quest.setQuestCurrentDay(quest.getQuestCurrentDay() + 1);
                } else if (quest.getQuestCurrentDay() >= 2) {
                    if (!quest.isComplete()) {
                        quest.setComplete(true);
                        quest.setQuestCurrentDay(0);
                        player.sendSystemMessage(getColoredTranslation(
                                "quest." + ChangShengJue.MOD_ID + ".finish", getColoredTranslation(quest.getQuestName())));
                    }
                }
            }
        }
    }


    public void syncToClient(ServerPlayer player) {
        CompoundTag data = new CompoundTag();
        ListTag questsTag = new ListTag();
        getQuests(player.getUUID()).forEach(q -> questsTag.add(q.toNbt()));
        data.put("Quests", questsTag);
        ChangShengJueMessages.sendToPlayer(new SyncQuestDataPacket(player.getUUID(), data), player);
    }

    /**
     * 从所有玩家的任务列表中删除指定任务ID的任务
     * @param questId 要删除的任务ID
     */
    public void removeQuestFromAllPlayers(UUID questId) {
        playerQuests.forEach((playerId, quests) -> {
            // 使用removeIf移除匹配的任务
            quests.removeIf(quest -> quest.getQuestId().equals(questId));

            // 如果玩家的任务列表为空，可以选择移除该玩家的条目
            if (quests.isEmpty()) {
                playerQuests.remove(playerId);
            }

        });
    }

    public List<Quest> getQuests(UUID playerId) {
        return Collections.unmodifiableList(
                playerQuests.computeIfAbsent(playerId, k -> new ArrayList<>()));
    }

    public void setQuests(Quest quest, UUID playerId) {
        List<Quest> quests = playerQuests.computeIfAbsent(playerId,
                k -> new CopyOnWriteArrayList<>());
        quests.add(quest);
    }

    public int getCompletionCount(UUID questId) {
        return questCompletionCounts.getOrDefault(questId, 0);
    }

    public void setCompletionCount(UUID questId) {
        questCompletionCounts.merge(questId, 1, Integer::sum);
    }

    // 标记任务完成
    public void markQuestCompleted(UUID questId) {
        if (questId != null) {
            completedQuests.add(questId);
        }
    }

    // 检查任务是否已完成
    public boolean isQuestCompleted(UUID questId) {
        return questId != null && completedQuests.contains(questId);
    }

    // 重置任务状态（用于可重复任务）
    public void resetQuestCompletion(UUID questId) {
        if (questId != null) {
            completedQuests.remove(questId);
        }
    }

    // 标记任务为已接受
    public void markQuestAccepted(UUID questId) {
        if (questId != null) {
            acceptedQuests.add(questId);
        }
    }

    // 检查是否已接受过任务
    public boolean isQuestAccepted(UUID questId) {
        return questId != null && acceptedQuests.contains(questId);
    }

    // 重置任务接受状态（用于任务重置）
    public void resetQuestAcceptance(UUID questId) {
        if (questId != null) {
            acceptedQuests.remove(questId);
        }
    }

    public boolean isFirstLargeTransactionTrigger() {
        return firstLargeTransactionTrigger;
    }

    public void setFirstLargeTransactionTrigger(boolean firstLargeTransactionTrigger) {
        this.firstLargeTransactionTrigger = firstLargeTransactionTrigger;
    }

    public boolean isFirstChuBaoAnLiangTrigger() {
        return firstChuBaoAnLiangTrigger;
    }

    public void setFirstChuBaoAnLiangTrigger(boolean firstChuBaoAnLiangTrigger) {
        this.firstChuBaoAnLiangTrigger = firstChuBaoAnLiangTrigger;
    }
}