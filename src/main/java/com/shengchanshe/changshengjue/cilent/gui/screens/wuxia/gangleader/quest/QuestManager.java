package com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.quest;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.GangQuestsMenu;
import com.shengchanshe.changshengjue.entity.custom.wuxia.challenger.Challenger;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import com.shengchanshe.changshengjue.entity.custom.wuxia.xia.AbstractMingXia;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.gui.quest.RefreshQuestScreenPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.LevelResource;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class QuestManager {
    private static QuestManager instance;
    private Quest currentQuest;
    //玩家当前任务 <玩家ID, 任务列表>
    private Map<UUID, List<Quest>> playerAcceptedQuests;
    // 已完成的不可重复任务 <任务ID>
    private Set<UUID> completedNonRepeatable = ConcurrentHashMap.newKeySet();

    private final Path storagePath;

    public static QuestManager getInstance() {
        if (instance == null) {
            instance = new QuestManager();
        }
        return instance;
    }

    private QuestManager() {
        Map<UUID, List<Quest>> playerAcceptedQuests1;
        this.storagePath = getWorldSpecificDataDir();
        try {
            // 确保目录存在（包括父目录）
            Files.createDirectories(storagePath);
            playerAcceptedQuests1 = QuestDataStorage.load(storagePath);
        } catch (IOException e) {
            ChangShengJue.LOGGER.error("无法创建任务数据目录", e);
            playerAcceptedQuests1 = new ConcurrentHashMap<>();
        }
        playerAcceptedQuests = playerAcceptedQuests1;
    }

    /**
     * 获取玩家数据存储路径
     */
    public static Path getWorldSpecificDataDir() {
        return ServerLifecycleHooks.getCurrentServer()
                .getWorldPath(LevelResource.ROOT)  // 获取世界根目录
                .resolve("data")
                .resolve(ChangShengJue.MOD_ID);
    }

    public void onWorldLoad() {
        Path path = getWorldSpecificDataDir();
        QuestDataStorage.initWorldData(path); // 强制初始化文件
        playerAcceptedQuests = QuestDataStorage.load(path);
        completedNonRepeatable = QuestDataStorage.loadCompletedQuests(path);
    }

    /**
     * 为指定NPC生成一个新任务
     */
    public Quest generateNewQuestForNpc(UUID npcId) {
        return QuestLoader.loadQuest(npcId, completedNonRepeatable);
    }

    /**
     * 玩家接受任务
     */
    public void acceptQuest(Player player, AbstractGangLeader gangLeader) {
        Quest quest = gangLeader.getQuest();
        if (quest == null || quest.getAcceptedBy() != null) {
            return;
        }

        quest.setAcceptedBy(player.getUUID());
        this.saveQuest(player, quest);
        this.flushedContainer((ServerPlayer) player, gangLeader);
        this.spawnTargetForQuest((ServerPlayer) player,quest);
    }
    /**
     * 玩家放弃任务
     */
    public void abandonQuest(Player player, AbstractGangLeader gangLeader) {
        // 获取NPC当前任务并验证基础条件
        Quest npcQuest = gangLeader.getQuest();
        if (npcQuest == null || !player.getUUID().equals(npcQuest.getAcceptedBy())) {
            return;
        }
        // 获取玩家任务列表并匹配任务（通过固定ID比较）
        List<Quest> playerQuests = this.getPlayerQuests(player.getUUID());
        Optional<Quest> matchedQuest = playerQuests.stream()
                .filter(q -> q.getQuestId().equals(npcQuest.getQuestId()))
                .findFirst();

        if (matchedQuest.isEmpty()) {
            return;
        }
        // 重置任务状态
        Quest actualQuest = matchedQuest.get();
        actualQuest.setAcceptedBy(null); // 清除接受者
        actualQuest.setCurrentKills(0);
        actualQuest.setComplete(false);
        // 从玩家任务列表中移除（可选，根据设计需求）
        this.removeQuest(actualQuest, playerQuests);
        // 刷新NPC任务（保留任务但重置状态）
        gangLeader.setQuest(new Quest(npcQuest.toNbt())); // 深拷贝重置
        npcQuest.setAcceptedBy(null);
        // 持久化数据
        this.saveData();

        // 刷新UI
        this.flushedContainer((ServerPlayer) player, gangLeader);
    }
    /**
     * 玩家刷新任务
     */
    public void refreshQuest(Player player, AbstractGangLeader gangLeader) {
        Quest npcQuest = gangLeader.getQuest();
        if (npcQuest == null || npcQuest.getAcceptedBy() != null) {
            return;
        }
        // 立即刷新NPC任务（无论是否可重复）
        gangLeader.setQuest(generateNewQuestForNpc(npcQuest.getQuestNpcId()));
        // 持久化数据
        this.saveData();
        // 刷新UI
        this.flushedContainer((ServerPlayer) player, gangLeader);
    }

    /**
     * 玩家提交任务
     */
    public void submitQuest(Player player, AbstractGangLeader gangLeader) {
        //  获取NPC当前任务并验证基础条件
        Quest npcQuest = gangLeader.getQuest();
        if (npcQuest == null || !player.getUUID().equals(npcQuest.getAcceptedBy())) {
            return;
        }

        // 获取玩家任务列表并匹配任务（通过固定ID比较）
        List<Quest> playerQuests = this.getPlayerQuests(player.getUUID());
        Optional<Quest> matchedQuest = playerQuests.stream()
                .filter(q -> q.getQuestId().equals(npcQuest.getQuestId())) // 使用固定ID比较
                .findFirst();

        if (matchedQuest.isEmpty()) {
            return;
        }

        // 检查任务完成条件
        Quest actualQuest = matchedQuest.get();
        if (!actualQuest.canComplete(player)) {
            player.sendSystemMessage(Component.translatable("quest.requirements.prompt"));
            return;
        }

        // 给予奖励并移除需求物品
        actualQuest.takeRequirements(player);
        actualQuest.giveRewards(player);
        actualQuest.setComplete(false);
        actualQuest.setAcceptedBy(null);
        // 在玩家任务中移除已完成的任务
        this.removeQuest(actualQuest, playerQuests);
        // 不可重复任务：从玩家列表移除并记录
        if (!actualQuest.isRepeatable()) {
            completedNonRepeatable.add(actualQuest.getQuestId()); // 记录已完成
        }
        // 立即刷新NPC任务（无论是否可重复）
        gangLeader.setQuest(generateNewQuestForNpc(npcQuest.getQuestNpcId()));
        // 持久化数据
        this.saveData();
        // 刷新UI
        this.flushedContainer((ServerPlayer) player, gangLeader);
    }

    /**
     * 为任务生成目标生物
     * @param player 接取任务的玩家
     * @param quest 关联的任务
     */
    public void spawnTargetForQuest(ServerPlayer player, Quest quest) {
        Level level = player.level();
        RandomSource rand = player.getRandom();
        String targetId = quest.getTargetEntity();

        if (quest.isGivesEffect()){
            player.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 120000, 2, false, false, true));
        }

        if (quest.isQuestGenerateTarget()){
            if (targetId.startsWith("#")) {
                ResourceLocation tagId = new ResourceLocation(targetId.substring(1));
                TagKey<EntityType<?>> entityTag = TagKey.create(Registries.ENTITY_TYPE, tagId);

                List<EntityType<?>> possibleTypes = ForgeRegistries.ENTITY_TYPES.getValues()
                        .stream()
                        .filter(type -> {
                            Optional<Holder<EntityType<?>>> holder = ForgeRegistries.ENTITY_TYPES.getHolder(type);
                            return holder.map(h -> level.registryAccess()
                                            .registryOrThrow(Registries.ENTITY_TYPE)
                                            .getTag(entityTag)
                                            .map(tag -> tag.contains(h))
                                            .orElse(false))
                                    .orElse(false);
                        })
                        .toList();

                if (!possibleTypes.isEmpty()) {
                    EntityType<?> selectedType = possibleTypes.get(rand.nextInt(possibleTypes.size()));
                    LivingEntity entity = spawnEntityAtValidPosition(level, player, selectedType);
                    if (entity != null) {
                        setAttackTarget(entity, player);  // 设置攻击目标
                    }
                }
            } else {
                EntityType<?> type = ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(targetId));
                if (type != null) {
                    LivingEntity entity = spawnEntityAtValidPosition(level, player, type);
                    if (entity != null) {
                        setAttackTarget(entity, player);  // 设置攻击目标
                    }
                }
            }
        }
    }

    // 辅助方法：在有效位置生成实体
    // 修改后的生成方法，返回生成的实体
    private LivingEntity spawnEntityAtValidPosition(Level level, ServerPlayer player, EntityType<?> type) {
        for (int i = 0; i < 10; i++) {
            Vec3 pos = player.position()
                    .add(player.getRandom().nextInt(20) - 10,
                            0,
                            player.getRandom().nextInt(20) - 10);

            BlockPos groundPos = findGroundPos(level, new BlockPos((int) pos.x, (int) pos.y, (int) pos.z));
            if (groundPos != null) {
                LivingEntity entity = (LivingEntity) type.create(level);
                if (entity != null) {
                    entity.setPos(groundPos.getX() + 0.5, groundPos.getY(), groundPos.getZ() + 0.5);
                    if (level.noCollision(entity)) {
                        level.addFreshEntity(entity);
                        return entity;  // 返回生成的实体
                    }
                    entity.discard();
                }
            }
        }
        // 回退到玩家位置生成
        LivingEntity entity = (LivingEntity) type.create(level);
        if (entity != null) {
            entity.setPos(player.position());
            level.addFreshEntity(entity);
            return entity;
        }
        return null;
    }

    // 设置攻击目标
    private void setAttackTarget(LivingEntity entity, Player player) {
        if (entity instanceof Mob mob) {
            mob.setTarget(player);  // 对Mob类生物设置目标
        } else if (entity instanceof NeutralMob neutralMob) {
            neutralMob.setTarget(player);  // 对中立生物设置目标
        }
    }

    // 辅助方法：寻找可行走的地面位置
    private BlockPos findGroundPos(Level level, BlockPos startPos) {
        // 向上查找（防止卡在地下）
        BlockPos.MutableBlockPos mutablePos = startPos.mutable();
        while (mutablePos.getY() < level.getMaxBuildHeight()) {
            if (canSpawnAt(level, mutablePos)) {
                return mutablePos;
            }
            mutablePos.move(Direction.UP);
        }

        // 向下查找（防止浮在空中）
        mutablePos.set(startPos);
        while (mutablePos.getY() > level.getMinBuildHeight()) {
            if (canSpawnAt(level, mutablePos)) {
                return mutablePos;
            }
            mutablePos.move(Direction.DOWN);
        }

        return null;  // 未找到合适位置
    }

    // 检查该位置是否可生成实体
    private boolean canSpawnAt(Level level, BlockPos pos) {
        BlockState blockState = level.getBlockState(pos);
        BlockState belowState = level.getBlockState(pos.below());

        // 当前位置是空气/可穿越的
        // 下方是固体方块（防止悬空）
        return (blockState.isAir() || blockState.canBeReplaced())
                && belowState.isSolidRender(level, pos.below());
    }

    public void removeNpcQuests(UUID npcId) {
        // 清理玩家任务列表中的相关任务
        playerAcceptedQuests.forEach((playerId, quests) -> {
            quests.removeIf(quest -> quest.getQuestNpcId().equals(npcId));
        });

        this.saveData();
    }

//    辅助方法：根据任务ID查找任务
//    private Quest findQuestById(UUID questId) {
//        return playerAcceptedQuests.values().stream()
//                .flatMap(List::stream)
//                .filter(q -> q.getQuestId().equals(questId))
//                .findFirst()
//                .orElse(null);
//    }

    public void flushedContainer(ServerPlayer player, AbstractGangLeader gangLeader) {
        // 改为发送刷新数据包
        ChangShengJueMessages.sendToPlayer(
                new RefreshQuestScreenPacket(gangLeader.getQuest().toNbt()), player
        );
    }

    // 新增保存方法
    public void saveData() {
        QuestDataStorage.save(playerAcceptedQuests, getWorldSpecificDataDir());
        QuestDataStorage.saveCompletedQuests(completedNonRepeatable, getWorldSpecificDataDir());
    }

    // 在修改数据的操作后调用保存
    public void saveQuest(Player player, Quest quest) {
        UUID uuid = player.getUUID();
        playerAcceptedQuests.computeIfAbsent(uuid, k -> new ArrayList<>()).add(quest);
        this.saveData();
    }

    public boolean removeQuest(Quest quest, List<Quest> quests) {
        return quests.removeIf(q -> q.equals(quest));
    }

    // 获取玩家所有任务
    public List<Quest> getPlayerQuests(UUID playerId) {
        return playerAcceptedQuests.getOrDefault(playerId, Collections.emptyList());
    }

    public void openNpcGui(AbstractGangLeader gangLeader) {
        // 获取NPC当前任务
        Quest npcQuest = gangLeader.getQuest();
        if (npcQuest == null || npcQuest.getAcceptedBy() == null) {return;}
        // 更高效的流式处理
        getPlayerQuests(npcQuest.getAcceptedBy()).stream()
                .filter(playerQuest -> playerQuest.equals(npcQuest))
                .findFirst()
                .ifPresent(matchingQuest -> {
                    // 使用防御性拷贝
                    gangLeader.setQuest(new Quest(matchingQuest.toNbt()));
                    ChangShengJue.LOGGER.debug("已同步任务数据：{}", matchingQuest.getQuestId());
                });
    }

    public void saveQuestProgress(Quest quest){
        if (quest.getAcceptedBy() == null) return;
        quest.setCurrentKills(quest.getCurrentKills());
    }
}