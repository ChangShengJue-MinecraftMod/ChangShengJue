package com.shengchanshe.chang_sheng_jue.quest;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapability;
import com.shengchanshe.chang_sheng_jue.event.quest.PlayerQuestEvent;
import com.shengchanshe.chang_sheng_jue.item.kungfuxp.ExternalKungfuXp;
import com.shengchanshe.chang_sheng_jue.item.kungfuxp.InternalkungfuXp;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.AbstractionExternalKunfu;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.AbstractionInternalkungfu;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Quest {
    private UUID questId;
    private String questName;
    private String questDescription;
    private List<ItemStack> questRequirements;
    private List<ItemStack> questRewards;
    private UUID questNpcId; // 发布任务的NPC唯一标识
    private UUID acceptedBy; // 接受任务的玩家ID，null表示未被接受
    private boolean needRefresh;//是否需要刷新任务
    private QuestType questType;
    private boolean repeatable; // 是否可重复完成
    private String targetEntity;  // 要击杀的生物ID
    private int requiredKills; // 需要击杀的数量
    private int currentKills; // 当前已击杀数量
    private String secondTargetEntity;  // 第二个目标实体
    private int secondRequiredKills; // 第二个目标需要击杀的数量
    private int secondCurrentKills; // 第二个目标当前击杀数量
    private boolean isEntityTag; // 标记是否是标签
    private boolean isSecondEntityTag;
    private String questRequirementsDescription; // 任务目标描述
    private boolean questGenerateTarget; // 是否需要生成目标
    private int questTargetCount; // 生成任务目标次数
    private int questCurrentTargetCount; // 当前生成任务目标次数
    private List<QuestEffectEntry> effects = new ArrayList<>();// 给予接受任务的玩家buff
    private boolean isComplete; // 任务是否已完成
    private int questDay; // 任务天数
    private int questCurrentDay; // 当前任务天数
    private int questTime; // 任务时间
    private int questCurrentTime; // 当前任务时间
    private boolean isAcceptQuestEffects;
    private List<UUID> limitQuestIds;
    private boolean isNeedCompletePreQuest;//是否需要完成前置任务
    private List<UUID> conflictQuestIds;
    private boolean isConflictQuest;//是否有冲突任务
    private int needCompletionCount;// 完成任务次数
    private int weight; // 任务权重

    /**
     * 全参数构造方法
     * @param questId 任务唯一ID
     * @param questNpcId 发布NPC的ID
     * @param questName 任务名称
     * @param questDescription 任务描述
     * @param questRequirements 需求物品列表
     * @param questRewards 奖励物品列表
     * @param questType 任务类型
     * @param targetEntity 目标实体ID（击杀任务用）
     * @param isEntityTag 目标是否为标签
     * @param isSecondEntityTag 第二个目标是否为标签
     * @param requiredKills 需要击杀数量
     * @param repeatable 是否可重复
     * @param questRequirementsDescription 任务需求描述
     * @param questGenerateTarget 是否生成目标
     * @param questDay 任务天数要求
     * @param questTargetCount 目标生成次数
     * @param questTime 任务时间要求
     * @param effects 效果列表（新版）
     * @param isAcceptQuestEffects 是否在接受任务时给予玩家效果
     */
    public Quest(UUID questId, UUID questNpcId, String questName, String questDescription,boolean needRefresh,
                 List<ItemStack> questRequirements, List<ItemStack> questRewards,
                 QuestType questType, String targetEntity, boolean isEntityTag, int requiredKills,
                 String secondTargetEntity, int secondRequiredKills, boolean isSecondEntityTag,
                 boolean repeatable, String questRequirementsDescription, boolean questGenerateTarget,
                 int questDay, int questTargetCount, int questTime, List<QuestEffectEntry> effects, boolean isAcceptQuestEffects,
                 List<UUID> limitQuestIds,boolean isNeedCompletePreQuest, List<UUID> conflictQuestIds, boolean isConflictQuest,
                 int needCompletionCount,int weight) {
        this.questId = Objects.requireNonNull(questId, "任务ID不能为null");
        this.questNpcId = questNpcId;
        this.questName = questName;
        this.needRefresh = needRefresh;
        this.questDescription = questDescription;
        this.questRequirements = questRequirements != null ? questRequirements : new ArrayList<>();
        this.questRewards = questRewards != null ? questRewards : new ArrayList<>();
        this.questType = questType;
        this.repeatable = repeatable;
        this.questRequirementsDescription = questRequirementsDescription;
        this.effects = effects != null ? effects : new ArrayList<>();
        this.limitQuestIds = limitQuestIds != null ? limitQuestIds : new ArrayList<>();;
        this.targetEntity = targetEntity;
        this.requiredKills = requiredKills;
        this.currentKills = 0;
        this.isEntityTag = isEntityTag;
        this.secondTargetEntity = secondTargetEntity;
        this.secondRequiredKills = secondRequiredKills;
        this.secondCurrentKills = 0;
        this.isSecondEntityTag = isSecondEntityTag;
        this.questGenerateTarget = questGenerateTarget;
        this.questDay = questDay;
        this.questCurrentDay = 0;
        this.questTargetCount = questTargetCount;
        this.questCurrentTargetCount = 0;
        this.questTime = questTime;
        this.questCurrentTime = 0;
        this.isComplete = false;
        this.isAcceptQuestEffects = isAcceptQuestEffects;
        this.isNeedCompletePreQuest = isNeedCompletePreQuest;
        this.conflictQuestIds = conflictQuestIds != null ? conflictQuestIds : new ArrayList<>();;
        this.isConflictQuest = isConflictQuest;
        this.needCompletionCount = needCompletionCount;
        this.weight = weight;
    }

    public void updateFrom(Quest newQuest) {
        this.questId = newQuest.questId;
        this.questName = newQuest.questName;
        this.questDescription = newQuest.questDescription;
        this.questRequirements = newQuest.questRequirements;
        this.questRewards = newQuest.questRewards;
        this.questNpcId = newQuest.questNpcId;
        this.acceptedBy = newQuest.acceptedBy;
        this.needRefresh = newQuest.needRefresh;
        this.questType = newQuest.questType;
        this.targetEntity = newQuest.targetEntity;
        this.requiredKills = newQuest.requiredKills;
        this.currentKills = newQuest.currentKills;
        this.isEntityTag = newQuest.isEntityTag;
        this.secondTargetEntity = newQuest.secondTargetEntity;
        this.secondRequiredKills = newQuest.secondRequiredKills;
        this.secondCurrentKills = newQuest.secondCurrentKills;
        this.isSecondEntityTag = newQuest.isSecondEntityTag;
        this.repeatable = newQuest.repeatable;
        this.questRequirementsDescription = newQuest.questRequirementsDescription;
        this.questGenerateTarget = newQuest.questGenerateTarget;
        this.effects = newQuest.effects;
        this.isComplete = newQuest.isComplete;
        this.questDay = newQuest.questDay;
        this.questCurrentDay = newQuest.questCurrentDay;
        this.questTargetCount = newQuest.questTargetCount;
        this.questCurrentTargetCount = newQuest.questCurrentTargetCount;
        this.questTime = newQuest.questTime;
        this.isAcceptQuestEffects = newQuest.isAcceptQuestEffects;
        this.limitQuestIds = newQuest.limitQuestIds;
        this.isNeedCompletePreQuest = newQuest.isNeedCompletePreQuest;
        this.conflictQuestIds = newQuest.conflictQuestIds;
        this.isConflictQuest = newQuest.isConflictQuest;
        this.needCompletionCount = newQuest.needCompletionCount;
        this.weight = newQuest.weight;
    }

    public Quest(CompoundTag tag) {
        this.questId = tag.hasUUID("QuestId") ? tag.getUUID("QuestId") : UUID.randomUUID();
        this.questName = tag.contains("QuestName") ? tag.getString("QuestName") : "当前未接取任务";
        this.questDescription = tag.contains("QuestDescription") ? tag.getString("QuestDescription") : "当前未接取任务";

        if (tag.contains("QuestRewards")) {
            this.questRewards = new ArrayList<>();
            ListTag rewardList = tag.getList("QuestRewards", Tag.TAG_COMPOUND);
            for (int i = 0; i < rewardList.size(); i++) {
                questRewards.add(ItemStack.of(rewardList.getCompound(i)));
            }
        }

        if (tag.hasUUID("AcceptedBy")) {
            this.acceptedBy = tag.getUUID("AcceptedBy");
        }
        this.needRefresh = tag.getBoolean("NeedRefresh");

        if (tag.contains("Repeatable")) {
            this.repeatable = tag.getBoolean("Repeatable");
        }
        if (tag.contains("Effects")) {
            ListTag effectsList = tag.getList("Effects", Tag.TAG_COMPOUND);
            for (int i = 0; i < effectsList.size(); i++) {
                CompoundTag effectTag = effectsList.getCompound(i);
                effects.add(new QuestEffectEntry(
                        effectTag.getString("id"),
                        effectTag.getInt("duration"),
                        effectTag.getInt("amplifier"),
                        effectTag.getBoolean("ambient"),
                        effectTag.getBoolean("showParticles"),
                        effectTag.getBoolean("showIcon")
                ));
            }
        }
        if (tag.contains("QuestType")) {
            this.questType = QuestType.valueOf(tag.getString("QuestType"));
        }
        this.questRequirementsDescription = tag.contains("QuestRequirementsDescription") ? tag.getString("QuestRequirementsDescription") : "";
        if (tag.hasUUID("QuestNpcId")) {
            this.questNpcId = tag.getUUID("QuestNpcId");
        }

        if (tag.contains("QuestRequirements")) {
            this.questRequirements = new ArrayList<>();
            ListTag reqList = tag.getList("QuestRequirements", Tag.TAG_COMPOUND);
            for (int i = 0; i < reqList.size(); i++) {
                questRequirements.add(ItemStack.of(reqList.getCompound(i)));
            }
        }

        if (tag.contains("TargetEntity")) {
            this.targetEntity = tag.getString("TargetEntity");
        }
        if (tag.contains("RequiredKills")) {
            this.requiredKills = tag.getInt("RequiredKills");
        }
        if (tag.contains("CurrentKills")) {
            this.currentKills = tag.getInt("CurrentKills");
        }
        if (tag.contains("SecondTargetEntity")) {
            this.secondTargetEntity = tag.getString("SecondTargetEntity");
        }
        if (tag.contains("SecondRequiredKills")) {
            this.secondRequiredKills = tag.getInt("SecondRequiredKills");
        }
        if (tag.contains("SecondCurrentKills")) {
            this.secondCurrentKills = tag.getInt("SecondCurrentKills");
        }
        if (tag.contains("IsEntityTag")) {
            this.isEntityTag = tag.getBoolean("IsEntityTag");
        }
        if (tag.contains("IsSecondEntityTag")) {
            this.isSecondEntityTag = tag.getBoolean("IsSecondEntityTag");
        }
        if (tag.contains("QuestGenerateTarget")) {
            this.questGenerateTarget = tag.getBoolean("QuestGenerateTarget");
        }
        if (tag.contains("IsComplete")) {
            this.isComplete = tag.getBoolean("IsComplete");
        }
        if (tag.contains("QuestDay")) {
            this.questDay = tag.getInt("QuestDay");
        }
        if (tag.contains("QuestCurrentDay")) {
            this.questCurrentDay = tag.getInt("QuestCurrentDay");
        }
        if (tag.contains("QuestTargetCount")) {
            this.questTargetCount = tag.getInt("QuestTargetCount");
        }
        if (tag.contains("QuestCurrentTargetCount")){
            this.questCurrentTargetCount = tag.getInt("QuestCurrentTargetCount");
        }
        if (tag.contains("QuestTime")){
            this.questTime = tag.getInt("QuestTime");
        }
        if (tag.contains("IsAcceptQuestEffects")){
            this.isAcceptQuestEffects = tag.getBoolean("IsAcceptQuestEffects");
        }

        this.limitQuestIds = new ArrayList<>();
        if (tag.contains("LimitQuestIds")) {
            ListTag idList = tag.getList("LimitQuestIds", Tag.TAG_INT_ARRAY);
            for (Tag value : idList) {
                limitQuestIds.add(NbtUtils.loadUUID(value));
            }
        }

        if (tag.contains("IsNeedCompletePreQuest")) {
            this.isNeedCompletePreQuest = tag.getBoolean("IsNeedCompletePreQuest");
        }

        this.conflictQuestIds = new ArrayList<>();
        if (tag.contains("ConflictQuestIds")) {
            ListTag idList = tag.getList("ConflictQuestIds", Tag.TAG_INT_ARRAY);
            for (Tag value : idList) {
                conflictQuestIds.add(NbtUtils.loadUUID(value));
            }
        }

        if (tag.contains("IsConflictQuest")) {
            this.isConflictQuest = tag.getBoolean("IsConflictQuest");
        }

        if (tag.contains("NeedCompletionCount")){
            this.needCompletionCount = tag.getInt("NeedCompletionCount");
        }
        if (tag.contains("Weight")) {
            this.weight = tag.getInt("Weight");
        }
    }

    // 将任务写入NBT
    public CompoundTag toNbt() {
        CompoundTag tag = new CompoundTag();
        if (this.questId != null){
            tag.putUUID("QuestId", this.questId);
        }
        if (this.questName != null){
            tag.putString("QuestName", this.questName);
        }
        if (this.questDescription != null) {
            tag.putString("QuestDescription", this.questDescription);
        }
        if (this.questRewards != null) {
            ListTag rewardList = new ListTag();
            for (ItemStack stack : this.questRewards) {
                rewardList.add(stack.save(new CompoundTag()));
            }
            tag.put("QuestRewards", rewardList);
        }

        if (this.acceptedBy != null) {
            tag.putUUID("AcceptedBy", this.acceptedBy);
        }
        tag.putBoolean("NeedRefresh", this.needRefresh);
        tag.putBoolean("Repeatable", this.repeatable);

        ListTag effectsList = getTags();
        tag.put("Effects", effectsList);

        if (this.questType != null) {
            tag.putString("QuestType", this.questType.name());
        }
        if (this.questRequirementsDescription != null) {
            tag.putString("QuestRequirementsDescription", this.questRequirementsDescription);
        }
        if (this.questNpcId != null) {
            tag.putUUID("QuestNpcId", this.questNpcId);
        }

        if (this.questRequirements != null) {
            ListTag reqList = new ListTag();
            for (ItemStack stack : this.questRequirements) {
                reqList.add(stack.save(new CompoundTag()));
            }
            tag.put("QuestRequirements", reqList);
        }

        if (this.targetEntity != null) {
            tag.putString("TargetEntity", this.targetEntity);
        }
        tag.putInt("RequiredKills", this.requiredKills);
        tag.putInt("CurrentKills", this.currentKills);
        tag.putBoolean("IsEntityTag", this.isEntityTag);
        tag.putBoolean("IsSecondEntityTag", this.isSecondEntityTag);
        tag.putBoolean("QuestGenerateTarget", this.questGenerateTarget);
        tag.putBoolean("IsComplete", this.isComplete);
        tag.putInt("QuestDay", this.questDay);
        tag.putInt("QuestCurrentDay", this.questCurrentDay);
        tag.putInt("QuestTargetCount", this.questTargetCount);
        tag.putInt("QuestCurrentTargetCount", this.questCurrentTargetCount);
        tag.putInt("QuestTime", this.questTime);
        tag.putBoolean("IsAcceptQuestEffects", this.isAcceptQuestEffects);
        ListTag idList = new ListTag();
        limitQuestIds.forEach(id -> idList.add(NbtUtils.createUUID(id)));
        tag.put("LimitQuestIds", idList);
        tag.putBoolean("IsNeedCompletePreQuest", this.isNeedCompletePreQuest);

        ListTag idListC = new ListTag();
        conflictQuestIds.forEach(id -> idListC.add(NbtUtils.createUUID(id)));
        tag.put("ConflictQuestIds", idListC);
        tag.putBoolean("IsConflictQuest", this.isConflictQuest);

        tag.putInt("NeedCompletionCount", this.needCompletionCount);

        if (this.secondTargetEntity != null) {
            tag.putString("SecondTargetEntity", this.secondTargetEntity);
        }
        tag.putInt("SecondRequiredKills", this.secondRequiredKills);
        tag.putInt("SecondCurrentKills", this.secondCurrentKills);
        tag.putInt("Weight", this.weight);
        return tag;
    }

    public void saveNBTData(CompoundTag compound) {
        if (this.questId != null){
            compound.putUUID("QuestId", this.questId);
        }
        if (this.questName != null){
            compound.putString("QuestName", this.questName);
        }
        if (this.questDescription != null) {
            compound.putString("QuestDescription", this.questDescription);
        }
        if (this.questRewards != null) {
            ListTag rewardList = new ListTag();
            for (ItemStack stack : this.questRewards) {
                rewardList.add(stack.save(new CompoundTag()));
            }
            compound.put("QuestRewards", rewardList);
        }
        if (this.acceptedBy != null) {
            compound.putUUID("AcceptedBy", this.acceptedBy);
        }
        compound.putBoolean("Repeatable", this.repeatable);
        ListTag effectsList = getTags();
        compound.put("Effects", effectsList);
        if (this.questType != null) {
            compound.putString("QuestType", this.questType.name());
        }
        if (this.questRequirementsDescription != null) {
            compound.putString("QuestRequirementsDescription", this.questRequirementsDescription);
        }
        if (this.questNpcId != null) {
            compound.putUUID("QuestNpcId", this.questNpcId);
        }

        if (this.questRequirements != null) {
            ListTag reqList = new ListTag();
            for (ItemStack stack : this.questRequirements) {
                reqList.add(stack.save(new CompoundTag()));
            }
            compound.put("QuestRequirements", reqList);
        }

        if (this.targetEntity != null) {
            compound.putString("TargetEntity", this.targetEntity);
        }
        compound.putInt("RequiredKills", this.requiredKills);
        compound.putInt("CurrentKills", this.currentKills);
        compound.putBoolean("IsEntityTag", this.isEntityTag);
        compound.putBoolean("IsSecondEntityTag", this.isSecondEntityTag);
        compound.putBoolean("QuestGenerateTarget", this.questGenerateTarget);
        compound.putBoolean("IsComplete", this.isComplete);
        compound.putInt("QuestDay", this.questDay);
        compound.putInt("QuestCurrentDay", this.questCurrentDay);
        compound.putInt("QuestTargetCount", this.questTargetCount);
        compound.putInt("QuestCurrentTargetCount", this.questCurrentTargetCount);
        compound.putInt("QuestTime", this.questTime);
        compound.putBoolean("IsAcceptQuestEffects", this.isAcceptQuestEffects);

        ListTag idList = new ListTag();
        limitQuestIds.forEach(id -> idList.add(NbtUtils.createUUID(id)));
        compound.put("LimitQuestIds", idList);

        compound.putBoolean("IsNeedCompletePreQuest", this.isNeedCompletePreQuest);

        compound.putInt("NeedCompletionCount", this.needCompletionCount);

        if (this.secondTargetEntity != null) {
            compound.putString("SecondTargetEntity", this.secondTargetEntity);
        }
        compound.putInt("SecondRequiredKills", this.secondRequiredKills);
        compound.putInt("SecondCurrentKills", this.secondCurrentKills);
        compound.putInt("Weight", this.weight);

    }
    public void loadNBTData(CompoundTag tag) {
        this.questId = tag.hasUUID("QuestId") ? tag.getUUID("QuestId") : UUID.randomUUID();
        this.questName = tag.contains("QuestName") ? tag.getString("QuestName") : "当前没有任务";
        this.questDescription = tag.contains("QuestDescription") ? tag.getString("QuestDescription") : "当前没有任务";

        if (tag.contains("QuestRewards")) {
            this.questRewards = new ArrayList<>();
            ListTag rewardList = tag.getList("QuestRewards", Tag.TAG_COMPOUND);
            for (int i = 0; i < rewardList.size(); i++) {
                questRewards.add(ItemStack.of(rewardList.getCompound(i)));
            }
        }
        this.questRequirementsDescription = tag.contains("QuestRequirementsDescription") ? tag.getString("QuestRequirementsDescription") : "";
        if (tag.hasUUID("AcceptedBy")) {
            this.acceptedBy = tag.getUUID("AcceptedBy");
        }
        if (tag.contains("Repeatable")) {
            this.repeatable = tag.getBoolean("Repeatable");
        }
        if (tag.contains("QuestType")) {
            this.questType = QuestType.valueOf(tag.getString("QuestType"));
        }
        this.questRequirementsDescription = tag.contains("QuestRequirementsDescription") ? tag.getString("QuestRequirementsDescription") : "当前未接取任务";
        if (tag.hasUUID("QuestNpcId")) {
            this.questNpcId = tag.getUUID("QuestNpcId");
        }

        if (tag.contains("QuestRequirements")) {
            this.questRequirements = new ArrayList<>();
            ListTag reqList = tag.getList("QuestRequirements", Tag.TAG_COMPOUND);
            for (int i = 0; i < reqList.size(); i++) {
                questRequirements.add(ItemStack.of(reqList.getCompound(i)));
            }
        }

        if (tag.contains("TargetEntity")) {
            this.targetEntity = tag.getString("TargetEntity");
        }
        if (tag.contains("RequiredKills")) {
            this.requiredKills = tag.getInt("RequiredKills");
        }
        if (tag.contains("CurrentKills")) {
            this.currentKills = tag.getInt("CurrentKills");
        }
        if (tag.contains("IsEntityTag")) {
            this.isEntityTag = tag.getBoolean("IsEntityTag");
        }
        if (tag.contains("IsSecondEntityTag")) {
            this.isSecondEntityTag = tag.getBoolean("IsSecondEntityTag");
        }
        if (tag.contains("QuestGenerateTarget")) {
            this.questGenerateTarget = tag.getBoolean("QuestGenerateTarget");
        }
        if (tag.contains("IsComplete")) {
            this.isComplete = tag.getBoolean("IsComplete");
        }
        if (tag.contains("QuestDay")) {
            this.questDay = tag.getInt("QuestDay");
        }
        if (tag.contains("QuestCurrentDay")) {
            this.questCurrentDay = tag.getInt("QuestCurrentDay");
        }
        if (tag.contains("QuestTargetCount")) {
            this.questTargetCount = tag.getInt("QuestTargetCount");
        }
        if (tag.contains("QuestCurrentTargetCount")) {
            this.questCurrentTargetCount = tag.getInt("QuestCurrentTargetCount");
        }
        if (tag.contains("QuestTime")) {
            this.questTime = tag.getInt("QuestTime");
        }
        if (tag.contains("Effects")) {
            ListTag effectsList = tag.getList("Effects", Tag.TAG_COMPOUND);
            for (int i = 0; i < effectsList.size(); i++) {
                CompoundTag effectTag = effectsList.getCompound(i);
                effects.add(new QuestEffectEntry(
                        effectTag.getString("id"),
                        effectTag.getInt("duration"),
                        effectTag.getInt("amplifier"),
                        effectTag.getBoolean("ambient"),
                        effectTag.getBoolean("showParticles"),
                        effectTag.getBoolean("showIcon")
                ));
            }
        }
        if (tag.contains("IsAcceptQuestEffects")){
            this.isAcceptQuestEffects = tag.getBoolean("IsAcceptQuestEffects");
        }
        this.limitQuestIds = new ArrayList<>();
        if (tag.contains("LimitQuestIds")) {
            ListTag idList = tag.getList("LimitQuestIds", Tag.TAG_INT_ARRAY);
            for (Tag value : idList) {
                limitQuestIds.add(NbtUtils.loadUUID(value));
            }
        }
        if (tag.contains("IsNeedCompletePreQuest")) {
            this.isNeedCompletePreQuest = tag.getBoolean("IsNeedCompletePreQuest");
        }
        if (tag.contains("NeedCompletionCount")){
            this.needCompletionCount = tag.getInt("NeedCompletionCount");
        }
        if (tag.contains("SecondTargetEntity")) {
            this.secondTargetEntity = tag.getString("SecondTargetEntity");
        }
        if (tag.contains("SecondRequiredKills")) {
            this.secondRequiredKills = tag.getInt("SecondRequiredKills");
        }
        if (tag.contains("SecondCurrentKills")) {
            this.secondCurrentKills = tag.getInt("SecondCurrentKills");
        }
        if (tag.contains("Weight")) {
            this.weight = tag.getInt("Weight");
        }
    }
    public boolean isValid() {
        return this.questId != null && this.questNpcId != null;
    }
    // Getter 和 Setter 方法
    public UUID getQuestId() {
        return questId;
    }

    public String getQuestName() {
        return questName;
    }

    public String getQuestDescription() {
        return questDescription;
    }

    public List<ItemStack> getQuestRequirements() {
        return questRequirements;
    }

    public List<ItemStack> getQuestRewards() {
        return questRewards;
    }

    public void setQuestRewards(List<ItemStack> questRewards) {
        this.questRewards = questRewards;
    }

    public boolean isNeedRefresh() {
        return needRefresh;
    }

    public void setNeedRefresh(boolean needRefresh) {
        this.needRefresh = needRefresh;
    }

    public UUID getQuestNpcId() {
        return questNpcId;
    }

    public void setQuestNpcId(UUID questNpcId) {
        this.questNpcId = questNpcId;
    }

    public UUID getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(UUID playerId) {
        this.acceptedBy = playerId;
    }

    public QuestType getQuestType() {
        return questType;
    }

    public String getTargetEntity() {
        return targetEntity;
    }

    public int getRequiredKills() {
        return requiredKills;
    }

    public void setRequiredKills(int requiredKills) {
        this.requiredKills = requiredKills;
    }

    public int getCurrentKills() {
        return currentKills;
    }

    public void setCurrentKills(int kills) {
        this.currentKills = kills;
    }

    public void incrementKills() {
        this.currentKills++;
    }

    public void secondIncrementKills() {
        this.secondCurrentKills++;
    }

    public boolean isRepeatable() {
        return repeatable;
    }

    public String getQuestRequirementsDescription() {
        return questRequirementsDescription;
    }

    public boolean isQuestGenerateTarget() {
        return questGenerateTarget;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        this.isComplete = complete;
    }

    public int getQuestCurrentDay() {
        return questCurrentDay;
    }

    public void setQuestCurrentDay(int questCurrentDay) {
        this.questCurrentDay = questCurrentDay;
    }

    public int getQuestDay() {
        return questDay;
    }

    public int getQuestTargetCount() {
        return questTargetCount;
    }

    public int getQuestCurrentTargetCount() {
        return questCurrentTargetCount;
    }

    public void setQuestCurrentTargetCount(int questCurrentTargetCount) {
        this.questCurrentTargetCount = questCurrentTargetCount;
    }

    public int getQuestTime() {
        return questTime;
    }

    public int getQuestCurrentTime() {
        return questCurrentTime;
    }

    public void setQuestCurrentTime() {
        this.questCurrentTime++;
    }

    public List<QuestEffectEntry> getEffects() {
        return effects;
    }

    public void setEffects(List<QuestEffectEntry> effects) {
        this.effects = effects != null ? effects : new ArrayList<>();
    }

    public boolean isAcceptQuestEffects() {
        return isAcceptQuestEffects;
    }

    public void setAcceptQuestEffects(boolean acceptQuestEffects) {
        isAcceptQuestEffects = acceptQuestEffects;
    }

    public boolean isEntityTag() {
        return isEntityTag;
    }

    public boolean isSecondEntityTag() {
        return isSecondEntityTag;
    }

    public String getSecondTargetEntity() {
        return secondTargetEntity;
    }

    public int getSecondRequiredKills() {
        return secondRequiredKills;
    }

    public int getSecondCurrentKills() {
        return secondCurrentKills;
    }

    public void setSecondCurrentKills(int kills) {
        this.secondCurrentKills = kills;
    }

    public boolean isConflictQuest() {
        return isConflictQuest;
    }

    public void setConflictQuest(boolean conflictQuest) {
        isConflictQuest = conflictQuest;
    }

    public List<UUID> getConflictQuestIds() {
        return conflictQuestIds;
    }

    public void setConflictQuestIds(List<UUID> conflictQuestIds) {
        this.conflictQuestIds = conflictQuestIds;
    }

    public List<UUID> getLimitQuestIds() {
        return limitQuestIds;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // 检查玩家是否满足任务需求
    public boolean canComplete(Player player) {
        if (questType == QuestType.GATHER) {
            for (ItemStack req : questRequirements) {
                if (player.getInventory().countItem(req.getItem()) < req.getCount()) {
                    return false;
                }
            }
            return true;
        } else if (questType == QuestType.KILL) {
            if (secondTargetEntity == null) {
                return currentKills >= requiredKills;
            } else {
                boolean firstTargetComplete = currentKills >= requiredKills;
                boolean secondTargetComplete = secondCurrentKills >= secondRequiredKills;
                return firstTargetComplete && secondTargetComplete;
            }

        } else if (questType == QuestType.RAID || questType == QuestType.TREAT || questType == QuestType.AUTOMATIC) {
            return this.isComplete;
        }
        return false;
    }
    // 判断是否是同一种任务
    public boolean isSameQuestType(Quest other) {
        return this.questId.equals(other.questId);
    }

    public boolean isNeedCompletePreQuest() {
        return isNeedCompletePreQuest;
    }

    public int getNeedCompletionCount() {
        return needCompletionCount;
    }

    // 添加方法检查实体是否匹配
    public boolean matchesEntity(Entity entity) {
        return isEntityTag ? matchesEntityTag(entity, targetEntity) : matchesEntityId(entity, targetEntity);
    }
    public boolean matchesSecondEntity(Entity entity) {
        return isSecondEntityTag ? matchesEntityTag(entity, secondTargetEntity) : matchesEntityId(entity, secondTargetEntity);
    }

    private boolean matchesEntityTag(Entity entity, String targetEntity) {
        TagKey<EntityType<?>> tag = TagKey.create(
            ForgeRegistries.ENTITY_TYPES.getRegistryKey(),
            new ResourceLocation(targetEntity.substring(1)) // 去掉#
        );
        return entity.getType().is(tag);
    }

    private boolean matchesEntityId(Entity entity, String targetEntity) {
        ResourceLocation entityId = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType());
        return entityId.toString().equals(targetEntity);
    }

    /**
     * 检查玩家是否完成过冲突的任务
     */
    public boolean checkConflictQuests(PlayerQuestCapability capability) {
        if (this.conflictQuestIds.isEmpty()) return false;
        return this.isConflictQuest && checkConflictPrerequisites(capability);
    }
    // 检查是否完成过任一冲突的任务
    private boolean checkConflictPrerequisites(PlayerQuestCapability capability) {
        return conflictQuestIds.stream()
                .anyMatch(capability::isQuestCompleted);
    }

    /**
     * 检查玩家是否完成任意一个前置任务
     * @return 如果不需要前置任务或已完成任一前置则返回true
     */
    public boolean checkPrerequisiteQuests(PlayerQuestCapability capability) {
        if (this.limitQuestIds.isEmpty()) return true;
        return this.isNeedCompletePreQuest ?
                // 检查是否完成过任一前置任务
                checkCompletedPrerequisites(capability) :
                // 检查是否接受过任一前置任务
                checkNeverAcceptedPrerequisites(capability);
    }
    // 检查是否完成过任一前置任务
    private boolean checkCompletedPrerequisites(PlayerQuestCapability capability) {
        return limitQuestIds.stream()
                .anyMatch(limitQuestIds -> capability.getCompletionCount(limitQuestIds) >= this.needCompletionCount);
    }
    // 检查是否从未接受过所有前置任务
    private boolean checkNeverAcceptedPrerequisites(PlayerQuestCapability capability) {
        return limitQuestIds.stream().anyMatch(capability::isQuestAccepted);
    }

    // 给予玩家奖励
    public void giveRewards(Player player) {
        // 特定任务奖励逻辑
        if (this.questId.equals(PlayerQuestEvent.REN_WO_XING_QUEST_ID)) {
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                List<AbstractionInternalkungfu> kungFus = new ArrayList<>();
                cap.getAllLearned().forEach(kungFu -> {
                    if (kungFu instanceof AbstractionInternalkungfu upgradable) {
                        kungFus.add(upgradable);
                    }
                });
                kungFus.sort(Comparator.comparingInt(kf -> kf.getMaxExp() - kf.getExp()));
                for (AbstractionInternalkungfu kungFu : kungFus) {
                    if (kungFu.getLevel() < kungFu.getMaxLevel()) {
                        for (ItemStack reward : questRewards) {
                            if (reward.getItem() instanceof InternalkungfuXp) {
                                player.getInventory().add(reward.copy());
                                return;
                            }
                        }
                    } else {
                        for (ItemStack reward : questRewards) {
                            if (!(reward.getItem() instanceof InternalkungfuXp)) {
                                player.getInventory().add(reward.copy());
                                return;
                            }
                        }
                    }
                }
            });
            return;
        }
        if (this.questId.equals(PlayerQuestEvent.KUAI_YI_EN_CHOU_QUEST_ID)) {
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                List<AbstractionExternalKunfu> kungFus = new ArrayList<>();
                cap.getAllLearned().forEach(kungFu -> {
                    if (kungFu instanceof AbstractionExternalKunfu upgradable) {
                        kungFus.add(upgradable);
                    }
                });
                kungFus.sort(Comparator.comparingInt(kf -> kf.getMaxExp() - kf.getExp()));

                for (AbstractionExternalKunfu kungFu : kungFus) {
                    if (kungFu.getLevel() < kungFu.getMaxLevel()) {
                        for (ItemStack reward : questRewards) {
                            if (reward.getItem() instanceof ExternalKungfuXp) {
                                player.getInventory().add(reward.copy());
                                return;
                            }
                        }
                    } else {
                        for (ItemStack reward : questRewards) {
                            if (!(reward.getItem() instanceof ExternalKungfuXp)) {
                                player.getInventory().add(reward.copy());
                                return;
                            }
                        }
                    }
                }
            });
            return;
        }
        // 默认奖励逻辑
        for (ItemStack reward : questRewards) {
            player.getInventory().add(reward.copy());
        }
    }

    // 从玩家背包中移除需求物品
    public void takeRequirements(Player player) {
        if (questRequirements != null){
            for (ItemStack req : questRequirements) {
                player.getInventory().clearOrCountMatchingItems(p -> p.getItem() == req.getItem(), req.getCount(), player.inventoryMenu.getCraftSlots());
            }
        }
    }

    //应用效果方法
    public void applyEffects(Player player) {
        if (player.level().isClientSide) return;

        for (QuestEffectEntry effect : effects) {
            MobEffect mobEffect = ForgeRegistries.MOB_EFFECTS.getValue(
                    new ResourceLocation(effect.effectId())
            );
            if (mobEffect != null) {
                player.addEffect(new MobEffectInstance(
                        mobEffect,
                        effect.duration(),
                        effect.amplifier(),
                        effect.isAmbient(),
                        effect.showParticles(),
                        effect.showIcon()
                ));
            }
        }
    }

    private @NotNull ListTag getTags() {
        ListTag effectsList = new ListTag();
        for (QuestEffectEntry effect : effects) {
            CompoundTag effectTag = new CompoundTag();
            effectTag.putString("id", effect.effectId());
            effectTag.putInt("duration", effect.duration());
            effectTag.putInt("amplifier", effect.amplifier());
            effectTag.putBoolean("ambient", effect.isAmbient());
            effectTag.putBoolean("showParticles", effect.showParticles());
            effectTag.putBoolean("showIcon", effect.showIcon());
            effectsList.add(effectTag);
        }
        return effectsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quest quest)) return false;
        return Objects.equals(questId, quest.questId) // 任务ID必须相同
                && Objects.equals(questNpcId, quest.questNpcId) // 发布NPC必须相同
                && questType == quest.questType; // 任务类型必须相同
    }

    @Override
    public int hashCode() {
        return Objects.hash(questId, questNpcId, questType);
    }
    public enum QuestType {
        GATHER,  // 收集物品
        KILL,     // 击杀生物
        RAID,
        TREAT,
        AUTOMATIC
    }

}