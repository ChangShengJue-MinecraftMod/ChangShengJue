package com.shengchanshe.chang_sheng_jue.capability.quest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.GangleaderVariant2;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.clubbed.ClubbedGangLeader;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.other.GangLeader;
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

    private final Map<UUID, List<Quest>> playerQuests = new ConcurrentHashMap<>();

    private final Map<UUID, Integer> questCompletionCounts = new ConcurrentHashMap<>();

    private final Set<UUID> completedQuests = ConcurrentHashMap.newKeySet();
    private final Set<UUID> acceptedQuests = ConcurrentHashMap.newKeySet();

    // 新增大额交易首次触发状态
    private boolean firstLargeTransactionTrigger = true;

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

        // 保存玩家任务列表
        ListTag playersTag = new ListTag();
        playerQuests.forEach((uuid, quests) -> {
            // 跳过空玩家ID或空任务列表
            if (uuid == null || quests == null) return;

            CompoundTag playerTag = new CompoundTag();
            playerTag.putUUID("PlayerId", uuid);

            ListTag questsTag = new ListTag();
            quests.stream()
                    .filter(Objects::nonNull)
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

        // 保存任务完成次数
        CompoundTag countsTag = new CompoundTag();
        questCompletionCounts.forEach((uuid, count) -> {
            if (uuid != null) {
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
        // 加载玩家任务
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
                            if (quest.isValid()) {
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

        // 加载任务完成次数
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

    public List<Quest> triggerGangQuest(Player player, AbstractGangLeader questNpc, Float triggerChance) {
        // 前置校验
        if (!validateTriggerConditions(player, questNpc.getUUID(), triggerChance)) {
            return null;
        }
        // 获取或创建任务列表
        List<Quest> quests = playerQuests.computeIfAbsent(player.getUUID(),
                k -> new CopyOnWriteArrayList<>());
        // 检查现有任务
        Optional<Quest> existingQuest = findExistingQuest(quests, questNpc.getUUID());
        // 处理任务触发
        if (existingQuest.isEmpty()) {
            return tryCreateNewQuests(player, questNpc, triggerChance, quests);
        } else {
            return handleExistingQuests(player, questNpc, triggerChance, quests);
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

    private List<Quest> tryCreateNewQuests(Player player, AbstractGangLeader questNpc, float chance, List<Quest> existingQuests) {
        List<Quest> newQuests = new ArrayList<>();

        // 获取所有可用的任务
        List<Quest> allAvailableQuests = QuestLoader.loadAllAvailableQuests(questNpc.getUUID(), completedQuests);
        if (allAvailableQuests.isEmpty()) {
            ChangShengJue.LOGGER.error("没有可用的任务: {}", questNpc.getUUID());
            return newQuests;
        }

        // 过滤出有效的任务
        List<Quest> validQuests = new ArrayList<>();
        for (Quest quest : allAvailableQuests) {
            if (validateNewQuest(player, quest, questNpc)) {
                validQuests.add(quest);
            }
        }

        newQuests.addAll(validQuests);

        syncToClient((ServerPlayer) player);
        return newQuests;
    }

    private boolean validateNewQuest(Player player, Quest quest, AbstractGangLeader questNpc) {
        // 前置任务检查
        if (quest.isNeedCompletePreQuest() && !quest.checkPrerequisiteQuests(this)) {
            return false;
        }
        if (quest.isConflictQuest() && quest.checkConflictQuests(this)) {
            return false;
        }

        if (quest.getQuestId().equals(PlayerQuestEvent.VEGETARIAN_FOOD_QUEST_ID)){
            if (questNpc instanceof GangLeader gangLeader) {
                GangleaderVariant2 variant = gangLeader.getVariant();
                if (variant != GangleaderVariant2.TEXTURES_0) return false;
            } else if (!(questNpc instanceof ClubbedGangLeader)) {
                return false;
            }
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

    private List<Quest> handleExistingQuests(Player player, AbstractGangLeader questNpc, float chance,
                                             List<Quest> quests) {
        List<Quest> validQuests = new ArrayList<>();

        // 筛选出属于当前NPC的有效任务
        for (Quest existingQuest : quests) {
            if (existingQuest != null && questNpc.getUUID().equals(existingQuest.getQuestNpcId())) {
                validQuests.add(existingQuest);
            }
        }
        if (validQuests.isEmpty()) {
            return tryCreateNewQuests(player, questNpc, chance, quests);
        }

        return validQuests;
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
                    boolean checkConflictQuests = newQuest.checkConflictQuests(this);
                    boolean checkPrerequisiteQuests = newQuest.checkPrerequisiteQuests(this);
                    if (checkPrerequisiteQuests && !checkConflictQuests) {
                        if (isQuestCompleted(questId) && !newQuest.isRepeatable()) {
                            return;
                        }
                        if (newQuest.isValid()) {
                            if (newQuest.getQuestType() == Quest.QuestType.AUTOMATIC && !newQuest.getQuestId().equals(PlayerQuestEvent.REN_WO_XING_QUEST_ID)) {
                                newQuest.setComplete(true);
                            }
                            if (mobId != null) {
                                newQuest.setQuestNpcId(mobId);
                            }
                            newQuest.setAcceptedBy(player.getUUID());
                            quests.add(newQuest);
                            markQuestAccepted(newQuest.getQuestId());
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
     * 从当前玩家的任务列表中删除指定任务ID的任务
     * @param playerId 当前玩家ID
     * @param questId 要删除的任务ID
     */
    public void removeQuestFromPlayer(UUID playerId, UUID questId) {
        // 获取当前玩家的任务列表
        List<Quest> playerQuestList = playerQuests.get(playerId);

        if (playerQuestList != null) {
            // 使用removeIf移除匹配的任务
            playerQuestList.removeIf(quest -> quest.getQuestId().equals(questId));

            // 如果玩家的任务列表为空，移除该玩家的条目
            if (playerQuestList.isEmpty()) {
                playerQuests.remove(playerId);
            }
        }
    }

    public List<Quest> getQuests(UUID playerId) {
        return Collections.unmodifiableList(
                playerQuests.computeIfAbsent(playerId, k -> new ArrayList<>()));
    }

    public void setQuests(Quest quest, UUID playerId) {
        List<Quest> quests = playerQuests.computeIfAbsent(playerId,
                k -> new CopyOnWriteArrayList<>());
        for (int i = 0; i < quests.size(); i++) {
            Quest existingQuest = quests.get(i);
            if (existingQuest != null && existingQuest.getQuestId().equals(quest.getQuestId())) {
                quests.set(i, quest);
                return;
            }
        }
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
        return questId != null && !acceptedQuests.contains(questId);
    }

    // 重置任务接受状态
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

}