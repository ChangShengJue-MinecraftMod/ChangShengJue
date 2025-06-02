package com.shengchanshe.changshengjue.quest;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.gao_marksmanship.GaoMarksmanshipCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.hercules.HerculesCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.paoding.PaodingCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.wheat_nugget_encyclopedia.WheatNuggetEncyclopediaCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.wu_gang_cut_gui.WuGangCutGuiCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.yugong_moves_mountains.YugongMovesMountainsCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.zhang_men_xin_xue.ZhangMenXinxueCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.ClientQuestDataCache;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.playerquest.PlayerQuestMenu;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.clubbed.ClubbedGangLeader;
import com.shengchanshe.changshengjue.event.CSJAdvanceEvent;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.gui.playerquest.RefreshPlayerQuestScreenPacket;
import com.shengchanshe.changshengjue.network.packet.gui.playerquest.SyncQuestsPacket;
import com.shengchanshe.changshengjue.network.packet.gui.quest.RefreshQuestScreenPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.LevelResource;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.loading.FMLEnvironment;
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

    // 任务完成次数统计 <任务ID, 完成次数>
    private Map<UUID, Integer> questCompletionCounts = new ConcurrentHashMap<>();

    // 已完成的不可重复任务 <任务ID>
    private Set<UUID> completedNonRepeatable = ConcurrentHashMap.newKeySet();

    private Set<UUID> acceptQuestRepeatable = ConcurrentHashMap.newKeySet();

    private final Path storagePath;

    public static QuestManager getInstance() {
        if (instance == null) {
            instance = new QuestManager();
        }
        return instance;
    }

    private QuestManager() {
        this.storagePath = getWorldSpecificDataDir();
        try {
            Files.createDirectories(storagePath);

            // 统一使用复合判断条件
            boolean isServerSide = FMLEnvironment.dist.isDedicatedServer() ||
                    (FMLEnvironment.dist.isClient() && Minecraft.getInstance().isLocalServer());

            this.playerAcceptedQuests = isServerSide ?
                    QuestDataStorage.load(storagePath) : // 服务端/单人游戏加载数据
                    new ConcurrentHashMap<>();           // 纯客户端使用空Map

        } catch (IOException e) {
            ChangShengJue.LOGGER.error("初始化任务数据失败", e);
            this.playerAcceptedQuests = new ConcurrentHashMap<>();
        }
    }

    /**
     * 获取玩家数据存储路径（兼容服务端/客户端）
     */
    public static Path getWorldSpecificDataDir() {
        // 单人游戏或专用服务端
        if (FMLEnvironment.dist.isDedicatedServer() ||
                (FMLEnvironment.dist.isClient() && Minecraft.getInstance().isLocalServer())) {
            try {

                return ServerLifecycleHooks.getCurrentServer()
                        .getWorldPath(LevelResource.ROOT)
                        .resolve("data")
                        .resolve(ChangShengJue.MOD_ID);
            } catch (NullPointerException e) {
                ChangShengJue.LOGGER.error("服务端路径获取失败", e);
            }
        }

        // 纯客户端或异常情况
        return null;
    }

    public void onWorldLoad() {

        Path path = getWorldSpecificDataDir();
        QuestDataStorage.initWorldData(path); // 强制初始化文件
        playerAcceptedQuests = QuestDataStorage.load(path);
        completedNonRepeatable = QuestDataStorage.loadCompletedQuests(path);
        acceptQuestRepeatable = QuestDataStorage.loadDoneQuests(path);
        questCompletionCounts = QuestDataStorage.loadCompletionCounts(path);
    }

    /**
     * 为指定NPC生成一个新任务
     */
    public Quest generateNewQuestForNpc(AbstractGangLeader abstractGangLeader) {
        Quest quest = QuestLoader.loadQuest(abstractGangLeader.getUUID(), completedNonRepeatable);
        if (quest != null && quest.checkPrerequisiteQuests(this)) {
            if (quest.getQuestId().equals(UUID.fromString("33954498-78EF-492C-9338-B2E85C0AD184"))) {
                if (abstractGangLeader instanceof ClubbedGangLeader){
                    return quest;
                }
            }else {
                return quest;
            }
        }
        return generateNewQuestForNpc(abstractGangLeader);
    }

    /**
     * 为玩家生成指定类型的任务
     * @param player 目标玩家
     * @param specificQuestId 指定要生成的任务ID（可为null表示随机）
     * @return 生成的任务实例（可能为null如果生成失败）
     */
    public Quest generateSpecificQuestForPlayer(Player player, UUID specificQuestId,UUID npcId) {
        // 基础校验
        if (player == null) {
            ChangShengJue.LOGGER.error("生成任务参数错误: player={}", player);
            return null;
        }

        // 生成新任务（根据是否指定任务ID）
        Quest newQuest = QuestLoader.loadSpecificQuest(specificQuestId, completedNonRepeatable, npcId);

        // 设置任务属性
        if (newQuest != null && !newQuest.isComplete()) {
            if (newQuest.checkPrerequisiteQuests(this)){
                newQuest.setAcceptedBy(player.getUUID());
                newQuest.setQuestNpcId(npcId);
                newQuest.setComplete(false);
                player.sendSystemMessage(getColoredTranslation(
                        "quest." + ChangShengJue.MOD_ID + ".trigger", getColoredTranslation(newQuest.getQuestName())));

                playerAcceptedQuests.computeIfAbsent(player.getUUID(), k -> new ArrayList<>()).add(newQuest);
                this.saveData();
                return newQuest;
            }
        }

        return null;
    }

    // 获取带颜色的翻译文本
    public static Component getColoredTranslation(String key, Object... args) {
        String raw = Component.translatable(key, args).getString();
        return Component.literal(raw);
    }

    /**
     * 玩家接受帮派任务
     */
    public void acceptQuest(Player player, AbstractGangLeader gangLeader) {
        Quest npcQuest = gangLeader.getQuest();
        if (npcQuest == null || npcQuest.getAcceptedBy() != null) {
            return;
        }

        npcQuest.setAcceptedBy(player.getUUID());
        acceptQuestRepeatable.add(npcQuest.getQuestId());
        this.saveQuest(player, npcQuest);
        this.flushedContainer((ServerPlayer) player, gangLeader);
        syncQuestsToPlayer((ServerPlayer) player); // 增量同步
        this.spawnTargetForQuest((ServerPlayer) player,npcQuest, npcQuest.getRequiredKills());
    }
    /**
     * 玩家放弃帮派任务
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

        syncQuestsToPlayer((ServerPlayer) player); // 增量同步
        // 刷新UI
        this.flushedContainer((ServerPlayer) player, gangLeader);
    }
    /**
     * 玩家刷新帮派任务
     */
    public void refreshQuest(Player player, AbstractGangLeader gangLeader) {
        Quest npcQuest = gangLeader.getQuest();
        if (npcQuest == null || npcQuest.getAcceptedBy() != null) {
            return;
        }

        // 立即刷新NPC任务（无论是否可重复）
        gangLeader.setQuest(generateNewQuestForNpc(gangLeader));
        // 持久化数据
        this.saveData();
        syncQuestsToPlayer((ServerPlayer) player); // 增量同步
        // 刷新UI
        this.flushedContainer((ServerPlayer) player, gangLeader);
    }
    /**
     * 玩家提交帮派任务
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
            player.sendSystemMessage(Component.translatable("quest."+ChangShengJue.MOD_ID+".requirements.prompt"));
            return;
        }
        CSJAdvanceEvent.handleSpecialQuestReward((ServerPlayer) player, actualQuest);
        // 给予奖励并移除需求物品
        actualQuest.takeRequirements(player);
        actualQuest.giveRewards(player);
        actualQuest.setComplete(false);
        actualQuest.setAcceptedBy(null);
        actualQuest.applyEffects(player);
        if (!actualQuest.isRepeatable()) {
            completedNonRepeatable.add(actualQuest.getQuestId());
        }
        incrementQuestCompletion(actualQuest.getQuestId()); // 新增统计

        // 在玩家任务中移除已完成的任务
        this.removeQuest(actualQuest, playerQuests);
        // 不可重复任务：从玩家列表移除并记录
        if (!actualQuest.isRepeatable()) {
            completedNonRepeatable.add(actualQuest.getQuestId()); // 记录已完成
        }
        // 立即刷新NPC任务（无论是否可重复）
        gangLeader.setQuest(generateNewQuestForNpc(gangLeader));
        // 持久化数据
        this.saveData();
        syncQuestsToPlayer((ServerPlayer) player); // 增量同步
        // 刷新UI
        this.flushedContainer((ServerPlayer) player, gangLeader);
    }
    /**
     * 玩家提交背包任务
     */
    public void submitPlayerQuest(Player player, Quest quest, AbstractContainerMenu menu) {
        if (menu instanceof PlayerQuestMenu playerQuestMenu) {
            if (quest == null || !player.getUUID().equals(quest.getAcceptedBy())) {
                return;
            }

            List<Quest> playerQuests = this.getPlayerQuests(player.getUUID());
            Optional<Quest> matchedQuest = playerQuests.stream()
                    .filter(q -> q.getQuestId().equals(quest.getQuestId())) // 使用固定ID比较
                    .findFirst();

            if (matchedQuest.isEmpty()) {
                return;
            }

            Quest actualQuest = matchedQuest.get();
            if (!actualQuest.canComplete(player)) {
                player.sendSystemMessage(Component.translatable("quest."+ChangShengJue.MOD_ID+".requirements.prompt"));
                return;
            }

            actualQuest.takeRequirements(player);
            actualQuest.giveRewards(player);
            actualQuest.setComplete(false);
            actualQuest.setAcceptedBy(null);
            quest.applyEffects(player);
            if (actualQuest.getQuestId().equals(UUID.fromString("dab3e694-291c-4b58-8ed2-4b215fbcf543"))){
                this.addKungFuCount(player, 25);
            }
            if (!actualQuest.isRepeatable()) {
                completedNonRepeatable.add(actualQuest.getQuestId());
            }
            incrementQuestCompletion(actualQuest.getQuestId()); // 新增统计
            playerQuestMenu.removedCurrentQuest(quest.getQuestId());
            this.removeQuest(actualQuest, playerQuests);
            if (!actualQuest.isRepeatable()) {
                completedNonRepeatable.add(actualQuest.getQuestId()); // 记录已完成
            }
            this.saveData();
            syncQuestsToPlayer((ServerPlayer) player); // 增量同步
            ChangShengJueMessages.sendToPlayer(new RefreshPlayerQuestScreenPacket(), (ServerPlayer) player);
        }
    }
    /**
     * 玩家放弃背包任务
     */
    public void abandonPlayerQuest(Player player, Quest quest) {
        // 获取NPC当前任务并验证基础条件
        if (quest == null || !player.getUUID().equals(quest.getAcceptedBy())) {
            return;
        }

        // 获取玩家任务列表并匹配任务（通过固定ID比较）
        List<Quest> playerQuests = this.getPlayerQuests(player.getUUID());
        Optional<Quest> matchedQuest = playerQuests.stream()
                .filter(q -> q.getQuestId().equals(quest.getQuestId()))
                .findFirst();

        if (matchedQuest.isEmpty()) {
            return;
        }

        // 重置任务状态
        Quest actualQuest = matchedQuest.get();
        actualQuest.setAcceptedBy(null); // 清除接受者
        actualQuest.setComplete(false);
        this.removeQuest(actualQuest, playerQuests);
        this.saveData();

        syncQuestsToPlayer((ServerPlayer) player); // 增量同步
        ChangShengJueMessages.sendToPlayer(new RefreshPlayerQuestScreenPacket(), (ServerPlayer) player);
    }

    /**
     * 为任务生成目标生物
     * @param player 接取任务的玩家
     * @param quest 关联的任务
     */
    public void spawnTargetForQuest(ServerPlayer player, Quest quest, int count) {
        Level level = player.level();
        RandomSource rand = player.getRandom();
        String targetId = quest.getTargetEntity();

        if (quest.isAcceptQuestEffects()){
            quest.applyEffects(player);
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
                    for (int i = 0; i < count; i++){
                        LivingEntity entity = spawnEntityAtValidPosition(level, player, selectedType);
                        if (entity != null) {
                            setAttackTarget(entity, player);  // 设置攻击目标
                        }
                    }
                }
            } else {
                EntityType<?> type = ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(targetId));
                if (type != null) {
                    for (int i = 0; i < count; i++){
                        LivingEntity entity = spawnEntityAtValidPosition(level, player, type);
                        if (entity != null) {
                            setAttackTarget(entity, player);  // 设置攻击目标
                        }
                    }
                }
            }
        }
    }
    // 在有效位置生成实体
    private LivingEntity spawnEntityAtValidPosition(Level level, ServerPlayer player, EntityType<?> type) {
        for (int i = 0; i < 10; i++) {
            Vec3 pos = player.position()
                    .add(player.getRandom().nextInt(20) - 10, 0, player.getRandom().nextInt(20) - 10);

            BlockPos groundPos = findGroundPos(level, new BlockPos((int) pos.x, (int) pos.y, (int) pos.z));
            if (groundPos != null) {
                LivingEntity entity = (LivingEntity) type.create(level);
                if (entity != null) {
                    entity.setPos(groundPos.getX() + 0.5, groundPos.getY(), groundPos.getZ() + 0.5);
                    if (level.noCollision(entity)) {
                        level.addFreshEntity(entity);
                        entity.addEffect(new MobEffectInstance(
                                MobEffects.GLOWING,
                                500,
                                0,
                                false, // 无粒子
                                false  // 无图标
                        ));

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
    // 寻找可行走的地面位置
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
        Optional.ofNullable(npcId).ifPresent(id -> {
            playerAcceptedQuests.values().forEach(quests ->
                    quests.removeIf(quest -> id.equals(quest.getQuestNpcId()))
            );
        });
        this.saveData();
    }

    public void flushedContainer(ServerPlayer player, AbstractGangLeader gangLeader) {
        ChangShengJueMessages.sendToPlayer(new RefreshQuestScreenPacket(gangLeader.getQuest().toNbt()), player);
    }

    // 新增保存方法
    public void saveData() {
        QuestDataStorage.save(playerAcceptedQuests, getWorldSpecificDataDir());
        QuestDataStorage.saveCompletedQuests(completedNonRepeatable, getWorldSpecificDataDir());
        QuestDataStorage.saveDoneQuests(acceptQuestRepeatable, getWorldSpecificDataDir());
        QuestDataStorage.saveCompletionCounts(questCompletionCounts, getWorldSpecificDataDir()); // 新增
    }

    // 在修改数据的操作后调用保存
    public void saveQuest(Player player, Quest quest) {
        UUID uuid = player.getUUID();
        this.playerAcceptedQuests.computeIfAbsent(uuid, k -> new ArrayList<>()).add(quest);
        this.saveData();
    }

    public boolean removeQuest(Quest quest, List<Quest> quests) {
        return quests.removeIf(q -> q.equals(quest));
    }

    public void removePlayerQuests(Iterator<Quest> iterator) {
        iterator.remove();
        this.saveData();
    }

    // 获取玩家所有任务
    public List<Quest> getPlayerQuests(UUID playerId) {
        if (FMLEnvironment.dist.isDedicatedServer() ||
                (FMLEnvironment.dist.isClient() && Minecraft.getInstance().isLocalServer())) {
            return this.playerAcceptedQuests.getOrDefault(playerId, Collections.emptyList());
        }
        return ClientQuestDataCache.getClientQuests(playerId);
    }

    /**
     * 获取所有任务的完成次数总和
     * @return 所有任务完成次数的累加值
     */
    public int getTotalQuestCompletions() {
        return questCompletionCounts.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 获取任务完成次数
    public int getQuestCompletionCount(UUID questId) {
        return this.questCompletionCounts.getOrDefault(questId, 0);
    }
    // 删除指定任务完成记录
    public void removeQuestCompletion(UUID questId) {
        this.questCompletionCounts.remove(questId);
        this.saveData(); // 触发持久化
    }
    // 增加任务完成次数
    public void incrementQuestCompletion(UUID questId) {
        this.questCompletionCounts.merge(questId, 1, Integer::sum);
        this.saveData(); // 立即保存
    }

    public Set<UUID> getAllAcceptRepeatableQuests() {
        return Collections.unmodifiableSet(new HashSet<>(this.acceptQuestRepeatable));
    }

//    public void openNpcGui(AbstractGangLeader gangLeader) {
//        // 获取NPC当前任务
//        Quest npcQuest = gangLeader.getQuest();
//        if (npcQuest == null || npcQuest.getAcceptedBy() == null) {return;}
//        // 更高效的流式处理
//        getPlayerQuests(npcQuest.getAcceptedBy()).stream()
//                .filter(playerQuest -> playerQuest.equals(npcQuest))
//                .findFirst()
//                .ifPresent(matchingQuest -> {
//                    // 使用防御性拷贝
//                    gangLeader.setQuest(new Quest(matchingQuest.toNbt()));
//                    ChangShengJue.LOGGER.debug("已同步任务数据：{}", matchingQuest.getQuestId());
//                });
//    }

    public void saveQuestProgress(Quest quest){
        if (quest == null) return;
        if (quest.getAcceptedBy() == null) return;
        quest.setCurrentKills(quest.getCurrentKills());
    }

    public void addKungFuCount(Player player,int count){
        player.getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(duguNineSwords -> {
            duguNineSwords.addDuguNineSwordsUseCount(Math.min(duguNineSwords.getDuguNineSwordsUseCount() - 100, count));
        });
        player.getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).ifPresent(gaoMarksmanship -> {
            gaoMarksmanship.addGaoMarksmanshipUseCount(Math.min(gaoMarksmanship.getGaoMarksmanshipUseCount() - 100, count));
        });
        player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
            geShanDaNiu.addGeShanDaNiuUseCount(Math.min(geShanDaNiu.getGeShanDaNiuUseCount() - 100, count));
        });
        player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
            goldenBellJar.addGoldenBellJarUseCount(Math.min(goldenBellJar.getGoldenBellJarUseCount() - 100, count));
        });
        player.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(goldenBlackKnifeMethod -> {
            goldenBlackKnifeMethod.addGoldenBlackKnifeMethodUseCount(Math.min(goldenBlackKnifeMethod.getGoldenBlackKnifeMethodUseCount() - 100, count));
        });
        player.getCapability(HerculesCapabilityProvider.HERCULES_CAPABILITY).ifPresent(hercules -> {
            hercules.addHerculesUseCount(Math.min(hercules.getHerculesUseCount() - 100, count));
        });
        player.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
            immortalMiracle.addImmortalMiracleUseCount(Math.min(immortalMiracle.getImmortalMiracleUseCount() - 100, count));
        });
        player.getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).ifPresent(paoding -> {
            paoding.addPaodingUseCount(Math.min(paoding.getPaodingUseCount() - 100, count));
        });
        player.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi -> {
            qianKunDaNuoYi.addQianKunDaNuoYiUseCount(Math.min(qianKunDaNuoYi.getQianKunDaNuoYiUseCount() - 100, count));
        });
        player.getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(relentlessThrowingKnives -> {
            relentlessThrowingKnives.addRelentlessThrowingKnivesUseCount(Math.min(relentlessThrowingKnives.getRelentlessThrowingKnivesUseCount() - 100, count));
        });
        player.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
            shaolinStickMethod.addShaolinStickMethodUseCount(Math.min(shaolinStickMethod.getShaolinStickMethodUseCount() - 100, count));
        });
        player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
            sunflowerPointCaveman.addSunflowerPointCavemanUseCount(Math.min(sunflowerPointCaveman.getSunflowerPointCavemanUseCount() - 100, count));
        });
        player.getCapability(TheClassicsOfTendonChangingCapabilityProvider.THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY).ifPresent(theClassicsOfTendonChanging -> {
            theClassicsOfTendonChanging.addTheClassicsOfTendonChangingUseCount(Math.min(theClassicsOfTendonChanging.getTheClassicsOfTendonChangingUseCount() - 100, count));
        });
        player.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).ifPresent(treadTheSnowWithoutTrace -> {
            treadTheSnowWithoutTrace.addTreadTheSnowWithoutTraceUseCount(Math.min(treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCount() - 100, count));
        });
        player.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
            turtleBreathWork.addTurtleBreathWorkUseCount(Math.min(turtleBreathWork.getTurtleBreathWorkUseCount() - 100, count));
        });
        player.getCapability(WheatNuggetEncyclopediaCapabilityProvider.WHEAT_NUGGET_ENCYCLOPEDIA_CAPABILITY).ifPresent(wheatNuggetEncyclopedia -> {
            wheatNuggetEncyclopedia.addWheatNuggetEncyclopediaUseCount(Math.min(wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaUseCount() - 100, count));
        });
        player.getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).ifPresent(wuGangCutGui -> {
            wuGangCutGui.addWuGangCutGuiUseCount(Math.min(wuGangCutGui.getWuGangCutGuiUseCount() - 100, count));
        });
        player.getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).ifPresent(xuannuSwordsmanship -> {
            xuannuSwordsmanship.addXuannuSwordsmanshipUseCount(Math.min(xuannuSwordsmanship.getXuannuSwordsmanshipUseCount() - 100, count));
        });
        player.getCapability(YugongMovesMountainsCapabilityProvider.YUGONG_MOVES_MOUNTAINS_CAPABILITY).ifPresent(yugongMovesMountains -> {
            yugongMovesMountains.addYugongMovesMountainsUseCount(Math.min(yugongMovesMountains.getYugongMovesMountainsUseCount() - 100, count));
        });
        player.getCapability(ZhangMenXinxueCapabilityProvider.ZHANG_MEN_XIN_XUE_CAPABILITY).ifPresent(zhangMenXinxueCapability -> {
            zhangMenXinxueCapability.addZhangMenXinxueUseCount(Math.min(zhangMenXinxueCapability.getZhangMenXinxueUseCount() - 100, count));
        });
    }

    // 新增同步方法
    public void syncQuestsToPlayer(ServerPlayer player) {
        List<Quest> playerQuests = this.getPlayerQuests(player.getUUID());
        ChangShengJueMessages.sendToPlayer(
                new SyncQuestsPacket(
                        playerQuests,
                        this.completedNonRepeatable,
                        this.questCompletionCounts
                ),
                player
        );
    }

    public void encodeQuests(FriendlyByteBuf buf, List<Quest> quests) {
        buf.writeInt(quests.size());
        for (Quest quest : quests) {
            buf.writeNbt(quest.toNbt());
        }
    }

    public List<Quest> decodeQuests(FriendlyByteBuf buf) {
        List<Quest> quests = new ArrayList<>();
        int count = buf.readInt();
        for (int i = 0; i < count; i++) {
            quests.add(new Quest(Objects.requireNonNull(buf.readNbt())));
        }
        return quests;
    }

}