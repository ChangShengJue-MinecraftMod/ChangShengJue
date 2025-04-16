package com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.quest;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * 任务数据实体类
 * 包含任务的所有元数据和进度要求
 */
public class Quest {
    private UUID questId;
    private String questName;
    private String questDescription;
    private List<ItemStack> questRequirements;
    private List<ItemStack> questRewards;
    private UUID questNpcId; // 发布任务的NPC唯一标识
    private UUID acceptedBy; // 接受任务的玩家ID，null表示未被接受
    private QuestType questType;
    private boolean repeatable; // 是否可重复完成
    private String targetEntity;  // 要击杀的生物ID
    private int requiredKills; // 需要击杀的数量
    private int currentKills; // 当前已击杀数量
    private boolean isEntityTag; // 标记是否是标签
    private String questRequirementsDescription; // 任务目标描述
    private boolean questGenerateTarget; // 是否需要生成目标
    private boolean givesEffect;//给予接受任务的玩家buff
    private boolean isComplete; // 任务是否已完成

    //收集任务构造方法
    public Quest(UUID questId, UUID questNpcId, String questName, String questDescription, List<ItemStack> questRequirements,
                 List<ItemStack> questRewards, QuestType questType, boolean repeatable,String questRequirementsDescription) {
        this.questId = Objects.requireNonNull(questId, "任务ID不能为null");
        this.questNpcId = questNpcId;
        this.questName = questName;
        this.questDescription = questDescription;
        this.questRequirements = questRequirements;
        this.questRewards = questRewards;
        this.acceptedBy = null;
        this.questType = questType;
        this.repeatable = repeatable;
        this.questRequirementsDescription = questRequirementsDescription;
    }

    //击杀任务构造方法
    public Quest(UUID questId, UUID questNpcId, String questName, String questDescription,
                 List<ItemStack> questRequirements, List<ItemStack> questRewards,
                 QuestType questType, String targetEntity, boolean isEntityTag, int requiredKills, boolean repeatable,
                 String questRequirementsDescription, boolean questGenerateTarget) {
        this.questId = Objects.requireNonNull(questId, "任务ID不能为null");
        this.questNpcId = questNpcId;
        this.questName = questName;
        this.questDescription = questDescription;
        this.questRequirements = questRequirements;
        this.questRewards = questRewards;
        this.acceptedBy = null;
        this.questType = questType;
        this.targetEntity = targetEntity;
        this.requiredKills = requiredKills;
        this.currentKills = 0;
        this.isEntityTag = isEntityTag;
        this.repeatable = repeatable;
        this.questRequirementsDescription = questRequirementsDescription;
        this.questGenerateTarget = questGenerateTarget;
    }

    //袭击和治疗任务构造方法
    public Quest(UUID questId, UUID questNpcId, String questName, String questDescription, List<ItemStack> questRequirements,
                 List<ItemStack> questRewards, QuestType questType, boolean repeatable,String questRequirementsDescription,boolean givesEffect){
        this.questId = Objects.requireNonNull(questId, "任务ID不能为null");
        this.questNpcId = questNpcId;
        this.questName = questName;
        this.questDescription = questDescription;
        this.questRequirements = questRequirements;
        this.questRewards = questRewards;
        this.acceptedBy = null;
        this.questType = questType;
        this.repeatable = repeatable;
        this.questRequirementsDescription = questRequirementsDescription;
        this.givesEffect = givesEffect;
    }

    // 更新当前任务数据（从另一个Quest实例复制）
    public void updateFrom(Quest newQuest) {
        this.questId = newQuest.questId;
        this.questName = newQuest.questName;
        this.questDescription = newQuest.questDescription;
        this.questRequirements = newQuest.questRequirements;
        this.questRewards = newQuest.questRewards;
        this.questNpcId = newQuest.questNpcId;
        this.acceptedBy = newQuest.acceptedBy;
        this.questType = newQuest.questType;
        this.targetEntity = newQuest.targetEntity;
        this.requiredKills = newQuest.requiredKills;
        this.currentKills = newQuest.currentKills;
        this.isEntityTag = newQuest.isEntityTag;
        this.repeatable = newQuest.repeatable;
        this.questRequirementsDescription = newQuest.questRequirementsDescription;
        this.questGenerateTarget = newQuest.questGenerateTarget;
        this.givesEffect = newQuest.givesEffect;
        this.isComplete = newQuest.isComplete;
    }

    // 从NBT读取任务
    public Quest(CompoundTag tag) {
        this.questId = tag.getUUID("QuestId");
        this.questNpcId = tag.getUUID("QuestNpcId");
        this.questName = tag.getString("QuestName");
        this.questDescription = tag.getString("QuestDescription");

        this.questRewards = new ArrayList<>();
        ListTag rewardList = tag.getList("QuestRewards", Tag.TAG_COMPOUND);
        for (int i = 0; i < rewardList.size(); i++) {
            questRewards.add(ItemStack.of(rewardList.getCompound(i)));
        }

        if (tag.hasUUID("AcceptedBy")) {
            this.acceptedBy = tag.getUUID("AcceptedBy");
        }
        this.repeatable = tag.getBoolean("Repeatable");
        this.givesEffect = tag.getBoolean("GivesEffect");
        this.questType = QuestType.valueOf(tag.getString("QuestType"));
        this.questRequirementsDescription = tag.getString("QuestRequirementsDescription");

        if (this.questType == QuestType.GATHER) {
            this.questRequirements = new ArrayList<>();
            ListTag reqList = tag.getList("QuestRequirements", Tag.TAG_COMPOUND);
            for (int i = 0; i < reqList.size(); i++) {
                questRequirements.add(ItemStack.of(reqList.getCompound(i)));
            }
        }else if (this.questType == QuestType.KILL){
            if (tag.contains("TargetEntity")) {
                this.targetEntity = tag.getString("TargetEntity");
            }

            this.requiredKills = tag.getInt("RequiredKills");
            this.currentKills = tag.getInt("CurrentKills");
            this.isEntityTag = tag.getBoolean("IsEntityTag");
            this.questGenerateTarget = tag.getBoolean("QuestGenerateTarget");
        }else if (this.questType == QuestType.RAID || this.questType == QuestType.TREAT){
            this.givesEffect = tag.getBoolean("GivesEffect");
            this.isComplete = tag.getBoolean("IsComplete");
        }
    }

    // 将任务写入NBT
    public CompoundTag toNbt() {
        CompoundTag tag = new CompoundTag();
        tag.putUUID("QuestId", questId);
        tag.putUUID("QuestNpcId", questNpcId);
        tag.putString("QuestName", questName);
        tag.putString("QuestDescription", questDescription);
        ListTag rewardList = new ListTag();
        for (ItemStack stack : questRewards) {
            rewardList.add(stack.save(new CompoundTag()));
        }
        tag.put("QuestRewards", rewardList);
        if (acceptedBy != null) {
            tag.putUUID("AcceptedBy", acceptedBy);
        }
        tag.putBoolean("Repeatable", repeatable);
        tag.putBoolean("GivesEffect", givesEffect);
        tag.putString("QuestType", questType.name());
        tag.putString("QuestRequirementsDescription", questRequirementsDescription);

        if (this.questType == QuestType.GATHER) {
            ListTag reqList = new ListTag();
            for (ItemStack stack : questRequirements) {
                reqList.add(stack.save(new CompoundTag()));
            }
            tag.put("QuestRequirements", reqList);
        }else if (this.questType == QuestType.KILL){
            if (targetEntity != null) {
                tag.putString("TargetEntity", targetEntity);
            }
            tag.putInt("RequiredKills", requiredKills);
            tag.putInt("CurrentKills", currentKills);
            tag.putBoolean("IsEntityTag", isEntityTag);

            tag.putBoolean("QuestGenerateTarget", questGenerateTarget);
        }else if (this.questType == QuestType.RAID || this.questType == QuestType.TREAT){
            tag.putBoolean("GivesEffect", givesEffect);
            tag.putBoolean("IsComplete", isComplete);
        }
        return tag;
    }

    public void saveNBTData(CompoundTag compound) {
        compound.putUUID("QuestId", questId);
        compound.putUUID("QuestNpcId", questNpcId);
        compound.putString("QuestName", questName);
        compound.putString("QuestDescription", questDescription);

        ListTag rewardList = new ListTag();
        for (ItemStack stack : questRewards) {
            rewardList.add(stack.save(new CompoundTag()));
        }
        compound.put("QuestRewards", rewardList);

        if (acceptedBy != null) {
            compound.putUUID("AcceptedBy", acceptedBy);
        }
        compound.putBoolean("Repeatable", repeatable);
        compound.putBoolean("GivesEffect", givesEffect);
        compound.putString("QuestType", questType.name());
        compound.putString("QuestRequirementsDescription", questRequirementsDescription);

        if (this.questType == QuestType.GATHER){
            ListTag reqList = new ListTag();
            for (ItemStack stack : questRequirements) {
                reqList.add(stack.save(new CompoundTag()));
            }
            compound.put("QuestRequirements", reqList);
        } else if (this.questType == QuestType.KILL){
            if (targetEntity != null) {
                compound.putString("TargetEntity", targetEntity);
            }
            compound.putInt("RequiredKills", requiredKills);
            compound.putInt("CurrentKills", currentKills);
            compound.putBoolean("IsEntityTag", isEntityTag);

            compound.putBoolean("QuestGenerateTarget", questGenerateTarget);
        }else if (this.questType == QuestType.RAID || this.questType == QuestType.TREAT){
            compound.putBoolean("GivesEffect", givesEffect);
            compound.putBoolean("IsComplete", isComplete);
        }
    }

    public void loadNBTData(CompoundTag tag) {
        this.questId = tag.getUUID("QuestId");
        this.questNpcId = tag.getUUID("QuestNpcId");
        this.questName = tag.getString("QuestName");
        this.questDescription = tag.getString("QuestDescription");

        this.questRewards = new ArrayList<>();
        ListTag rewardList = tag.getList("QuestRewards", Tag.TAG_COMPOUND);
        for (int i = 0; i < rewardList.size(); i++) {
            questRewards.add(ItemStack.of(rewardList.getCompound(i)));
        }

        if (tag.hasUUID("AcceptedBy")) {
            this.acceptedBy = tag.getUUID("AcceptedBy");
        }
        this.repeatable = tag.getBoolean("Repeatable");
        this.givesEffect = tag.getBoolean("GivesEffect");
        this.questType = QuestType.valueOf(tag.getString("QuestType"));
        this.questRequirementsDescription = tag.getString("QuestRequirementsDescription");

        if (this.questType == QuestType.GATHER) {
            this.questRequirements = new ArrayList<>();
            ListTag reqList = tag.getList("QuestRequirements", Tag.TAG_COMPOUND);
            for (int i = 0; i < reqList.size(); i++) {
                questRequirements.add(ItemStack.of(reqList.getCompound(i)));
            }
        }else if (this.questType == QuestType.KILL){
            if (tag.contains("TargetEntity")) {
                this.targetEntity = tag.getString("TargetEntity");
            }
            this.requiredKills = tag.getInt("RequiredKills");
            this.currentKills = tag.getInt("CurrentKills");
            this.isEntityTag = tag.getBoolean("IsEntityTag");
            this.questGenerateTarget = tag.getBoolean("QuestGenerateTarget");
        }else if (this.questType == QuestType.RAID || this.questType == QuestType.TREAT){
            this.givesEffect = tag.getBoolean("GivesEffect");
            this.isComplete = tag.getBoolean("IsComplete");
        }
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

    public UUID getQuestNpcId() {
        return questNpcId;
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

    public int getCurrentKills() {
        return currentKills;
    }

    public void setCurrentKills(int kills) {
        this.currentKills = kills;
    }

    public void incrementKills() {
        this.currentKills++;
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

    public boolean isGivesEffect() {
        return givesEffect;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
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
            return currentKills >= requiredKills;
        }else if (questType == QuestType.RAID || questType == QuestType.TREAT){
            return isComplete;
        }
        return false;
    }

    // 判断是否是同一种任务
    public boolean isSameQuestType(Quest other) {
        return this.questId.equals(other.questId);
    }

    // 添加方法检查实体是否匹配
    public boolean matchesEntity(Entity entity) {
        ResourceLocation entityId = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType());
        if (isEntityTag) {
            // 处理标签匹配
            TagKey<EntityType<?>> tag = TagKey.create(
                    ForgeRegistries.ENTITY_TYPES.getRegistryKey(),
                    new ResourceLocation(targetEntity.substring(1)) // 去掉#
            );
            return entity.getType().is(tag);
        } else {
            // 处理具体实体匹配
            return entityId.toString().equals(targetEntity);
        }
    }

    // 给予玩家奖励
    public void giveRewards(Player player) {
        for (ItemStack reward : questRewards) {
            player.getInventory().add(reward.copy());
        }
    }

    // 从玩家背包中移除需求物品
    public void takeRequirements(Player player) {
        for (ItemStack req : questRequirements) {
            player.getInventory().clearOrCountMatchingItems(p -> p.getItem() == req.getItem(), req.getCount(), player.inventoryMenu.getCraftSlots());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quest)) return false;
        Quest quest = (Quest) o;
        // 根据实际业务需求定义关键字段
        return Objects.equals(questId, quest.questId) // 任务ID必须相同
                && Objects.equals(questNpcId, quest.questNpcId) // 发布NPC必须相同
                && questType == quest.questType; // 任务类型必须相同
    }

    @Override
    public int hashCode() {
        return Objects.hash(questId, questNpcId, questType); // 必须与equals()字段一致
    }

    public enum QuestType {
        GATHER,  // 收集物品
        KILL,     // 击杀生物
        RAID,
        TREAT
    }

}