package com.shengchanshe.chang_sheng_jue.quest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest.PlayerQuestMenu;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import com.shengchanshe.chang_sheng_jue.event.CSJAdvanceEvent;
import com.shengchanshe.chang_sheng_jue.event.quest.PlayerQuestEvent;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest.RefreshPlayerQuestScreenPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest.SyncQuestDataPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.RefreshQuestScreenPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class QuestManager {
    private static QuestManager instance;
    // 任务完成次数统计 <任务ID, 完成次数>
    private final Map<UUID, Integer> questCompletionCounts = new ConcurrentHashMap<>();

    public static QuestManager getInstance() {
        if (instance == null) {
            instance = new QuestManager();
        }
        return instance;
    }

    /**
     * 玩家接受帮派任务
     */
    public void acceptQuest(Player player, AbstractGangLeader gangLeader) {
        player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
            List<Quest> npcQuest = gangLeader.getPlayerQuests(player.getUUID());
            Optional<Quest> existingQuest = npcQuest.stream()
                    .filter(Objects::nonNull)
                    .findFirst();
            if (existingQuest.isPresent()) {
                Quest quest1 = existingQuest.get();
                quest1.setAcceptedBy(player.getUUID());
                cap.setQuests(quest1, player.getUUID());
                int requiredKills = quest1.getRequiredKills();

                this.spawnTargetForQuest((ServerPlayer) player,quest1,requiredKills);

                gangLeader.removeUnacceptedQuests(player.getUUID());

                if (player instanceof ServerPlayer serverPlayer) {
                    cap.syncToClient(serverPlayer);

                    // 发送专用刷新包
                    ChangShengJueMessages.sendToPlayer(
                            new RefreshQuestScreenPacket(quest1.toNbt()),
                            serverPlayer
                    );
                }
            }

        });
    }

    /**
     * 玩家刷新帮派任务
     */
    public void refreshQuest(Player player, AbstractGangLeader gangLeader) {
        player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
            List<Quest> npcQuest = gangLeader.getPlayerQuests(player.getUUID());
            Optional<Quest> existingQuest = npcQuest.stream()
                    .filter(Objects::nonNull)
                    .filter(q -> q.getAcceptedBy() == null)
                    .findFirst();
            if (existingQuest.isPresent()) {
                Quest quest1 = cap.triggerGangQuest(player, gangLeader, 1.0f);
                gangLeader.removeUnacceptedQuests(player.getUUID());
                gangLeader.addQuestForPlayer(player.getUUID(), quest1);
                if (player instanceof ServerPlayer serverPlayer) {
                    cap.syncToClient(serverPlayer);
                    // 发送专用刷新包
                    ChangShengJueMessages.sendToPlayer(
                            new RefreshQuestScreenPacket(quest1.toNbt()),
                            serverPlayer
                    );
                }
            }
        });
    }
    /**
     * 玩家放弃帮派任务
     */
    public void abandonQuest(Player player, AbstractGangLeader gangLeader) {
        player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
            // 获取NPC当前任务并验证基础条件
            List<Quest> npcQuest = gangLeader.getPlayerQuests(player.getUUID());
            Optional<Quest> existingQuest = npcQuest.stream()
                    .filter(Objects::nonNull)
                    .filter(q -> q.getAcceptedBy() != null && q.getAcceptedBy().equals(player.getUUID()))
                    .findFirst();
            if (existingQuest.isPresent()) {
                Quest quest = existingQuest.get();
                Optional<Quest> matchedQuest = cap.getQuests(player.getUUID()).stream()
                        .filter(q -> q != null && q.getQuestId().equals(quest.getQuestId()))
                        .findFirst();

                if (matchedQuest.isEmpty()) {
                    return;
                }
                Quest actualQuest = matchedQuest.get();
                // 4. 处理任务完成
                actualQuest.setAcceptedBy(null);
                actualQuest.setCurrentKills(0);
                actualQuest.setComplete(false);

                cap.removeQuestFromAllPlayers(quest.getQuestId());
                if (player.hasEffect(MobEffects.BAD_OMEN)){
                    player.removeEffect(MobEffects.BAD_OMEN);
                }
                gangLeader.addQuestForPlayer(player.getUUID(),new Quest(actualQuest.toNbt()));

                if (player instanceof ServerPlayer serverPlayer) {
                    cap.syncToClient(serverPlayer);

                    // 发送专用刷新包
                    ChangShengJueMessages.sendToPlayer(
                            new RefreshQuestScreenPacket(actualQuest.toNbt()),
                            serverPlayer
                    );
                }
            }

        });
    }

    /**
     * 玩家提交帮派任务
     */
    public void submitQuest(Player player, AbstractGangLeader gangLeader) {
        player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
            //  获取NPC当前任务并验证基础条件
            List<Quest> npcQuest = gangLeader.getPlayerQuests(player.getUUID());
            Optional<Quest> existingQuest = npcQuest.stream()
                    .filter(Objects::nonNull)
                    .filter(q -> q.getAcceptedBy().equals(player.getUUID()))
                    .findFirst();
            if (existingQuest.isPresent()) {
                Quest quest = existingQuest.get();
                Optional<Quest> matchedQuest = cap.getQuests(player.getUUID()).stream()
                        .filter(q -> q != null && q.getQuestId().equals(quest.getQuestId()))
                        .findFirst();

                if (matchedQuest.isEmpty()) {
                    return;
                }
                Quest actualQuest = matchedQuest.get();
                // 3. 验证任务状态
                if (!actualQuest.canComplete(player)) {
                    player.sendSystemMessage(Component.translatable("quest." + ChangShengJue.MOD_ID + ".requirements.prompt"));
                    return;
                }
                CSJAdvanceEvent.handleSpecialQuestReward((ServerPlayer) player, actualQuest);
                // 给予奖励并移除需求物品
                actualQuest.takeRequirements(player);
                actualQuest.giveRewards(player);
                actualQuest.setComplete(false);
                actualQuest.setAcceptedBy(null);
//                actualQuest.applyEffects(player);

                cap.markQuestCompleted(actualQuest.getQuestId());
                cap.setCompletionCount(actualQuest.getQuestId());
                cap.removeQuestFromAllPlayers(actualQuest.getQuestId());

                questCompletionCounts.merge(actualQuest.getQuestId(), 1, Integer::sum);

                gangLeader.removeQuest(player.getUUID(), actualQuest.getQuestId());

                Quest quest1 = cap.triggerGangQuest(player, gangLeader, 1.0f);
                gangLeader.addQuestForPlayer(player.getUUID(), quest1);

                if (player instanceof ServerPlayer serverPlayer) {
                    cap.syncToClient(serverPlayer);

                    // 发送专用刷新包
                    ChangShengJueMessages.sendToPlayer(
                            new RefreshQuestScreenPacket(quest1.toNbt()),
                            serverPlayer
                    );
                }
            }

        });
    }
    /**
     * 玩家提交背包任务
     */
    public void submitPlayerQuest(Player player, Quest quest, AbstractContainerMenu menu) {
        if (menu instanceof PlayerQuestMenu) {
            if (quest == null) {
                return;
            }
            player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
                // 2. 查找任务（线程安全方式）
                Optional<Quest> matchedQuest = cap.getQuests(player.getUUID()).stream()
                        .filter(q -> q != null && q.getQuestId().equals(quest.getQuestId()))
                        .findFirst();

                if (matchedQuest.isEmpty()) {
                    return;
                }
                Quest actualQuest = matchedQuest.get();
                // 3. 验证任务状态
                if (!actualQuest.canComplete(player)) {
                    player.sendSystemMessage(Component.translatable("quest."+ChangShengJue.MOD_ID+".requirements.prompt"));
                    return;
                }
                // 4. 处理任务完成
                actualQuest.takeRequirements(player);
                actualQuest.giveRewards(player);
                actualQuest.setComplete(false);
                actualQuest.applyEffects(player);
                actualQuest.setAcceptedBy(null);
                actualQuest.setNeedRefresh(true);

                if (actualQuest.getQuestId().equals(PlayerQuestEvent.KUAI_YI_EN_CHOU_QUEST_ID) && quest.getQuestNpcId() != null) {
                    questCompletionCounts.merge(actualQuest.getQuestId(), 1, Integer::sum);
                }

                cap.markQuestCompleted(actualQuest.getQuestId());
                cap.setCompletionCount(actualQuest.getQuestId());
                cap.removeQuestFromAllPlayers(actualQuest.getQuestId());

                // 6. 特殊任务处理
                if (actualQuest.getQuestId().equals(UUID.fromString("dab3e694-291c-4b58-8ed2-4b215fbcf543"))) {
                    this.addKungFuCount(player, 25);
                }
                if (player instanceof ServerPlayer serverPlayer) {
                    cap.syncToClient(serverPlayer);

                    // 发送专用刷新包
                    ChangShengJueMessages.sendToPlayer(
                            new RefreshPlayerQuestScreenPacket(),
                            serverPlayer
                    );
                }

            });

        }
    }
    /**
     * 玩家放弃背包任务
     */
    public void abandonPlayerQuest(Player player, Quest quest) {
        // 获取NPC当前任务并验证基础条件
        if (quest == null) {
            return;
        }
        player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
            // 2. 查找任务（线程安全方式）
            Optional<Quest> matchedQuest = cap.getQuests(player.getUUID()).stream()
                    .filter(q -> q != null && q.getQuestId().equals(quest.getQuestId()))
                    .findFirst();

            if (matchedQuest.isEmpty()) {
                return;
            }
            Quest actualQuest = matchedQuest.get();
            // 4. 处理任务完成
            actualQuest.setComplete(false);
            actualQuest.setAcceptedBy(null);

            cap.removeQuestFromAllPlayers(quest.getQuestId());

            if (player instanceof ServerPlayer serverPlayer) {
                cap.syncToClient(serverPlayer);
                // 发送专用刷新包
                ChangShengJueMessages.sendToPlayer(
                        new RefreshPlayerQuestScreenPacket(),
                        serverPlayer
                );
            }
        });
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

    // 获取玩家所有任务
    public List<Quest> getPlayerQuests(UUID playerId) {
        if (playerId == null) {
            return Collections.emptyList();
        }

        if (Minecraft.getInstance().level != null) {
            Player player = Minecraft.getInstance().level.getPlayerByUUID(playerId);
            if (player != null) {
                return getQuestsFromCapability(player);
            }
        }

        ServerPlayer serverPlayer = ServerLifecycleHooks.getCurrentServer()
                .getPlayerList()
                .getPlayer(playerId);
        if (serverPlayer != null) {
            return getQuestsFromCapability(serverPlayer);
        }

        return Collections.emptyList();
    }

    // 提取的公共能力获取方法
    private List<Quest> getQuestsFromCapability(Player player) {
        return player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY)
                .map(cap -> cap.getQuests(player.getUUID())) // 使用新方法
                .orElse(Collections.emptyList());
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

    public void addKungFuCount(Player player,int count){
//        player.getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(duguNineSwords -> {
//            duguNineSwords.addDuguNineSwordsUseCount(Math.min(duguNineSwords.getDuguNineSwordsUseCount() - 100, count));
//        });
//        player.getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).ifPresent(gaoMarksmanship -> {
//            gaoMarksmanship.addGaoMarksmanshipUseCount(Math.min(gaoMarksmanship.getGaoMarksmanshipUseCount() - 100, count));
//        });
//        player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
//            geShanDaNiu.addGeShanDaNiuUseCount(Math.min(geShanDaNiu.getGeShanDaNiuUseCount() - 100, count));
//        });
//        player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
//            goldenBellJar.addGoldenBellJarUseCount(Math.min(goldenBellJar.getGoldenBellJarUseCount() - 100, count));
//        });
//        player.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(goldenBlackKnifeMethod -> {
//            goldenBlackKnifeMethod.addGoldenBlackKnifeMethodUseCount(Math.min(goldenBlackKnifeMethod.getGoldenBlackKnifeMethodUseCount() - 100, count));
//        });
//        player.getCapability(HerculesCapabilityProvider.HERCULES_CAPABILITY).ifPresent(hercules -> {
//            hercules.addHerculesUseCount(Math.min(hercules.getHerculesUseCount() - 100, count));
//        });
//        player.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
//            immortalMiracle.addImmortalMiracleUseCount(Math.min(immortalMiracle.getImmortalMiracleUseCount() - 100, count));
//        });
//        player.getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).ifPresent(paoding -> {
//            paoding.addPaodingUseCount(Math.min(paoding.getPaodingUseCount() - 100, count));
//        });
//        player.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi -> {
//            qianKunDaNuoYi.addQianKunDaNuoYiUseCount(Math.min(qianKunDaNuoYi.getQianKunDaNuoYiUseCount() - 100, count));
//        });
//        player.getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(relentlessThrowingKnives -> {
//            relentlessThrowingKnives.addRelentlessThrowingKnivesUseCount(Math.min(relentlessThrowingKnives.getRelentlessThrowingKnivesUseCount() - 100, count));
//        });
//        player.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
//            shaolinStickMethod.addShaolinStickMethodUseCount(Math.min(shaolinStickMethod.getShaolinStickMethodUseCount() - 100, count));
//        });
//        player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
//            sunflowerPointCaveman.addSunflowerPointCavemanUseCount(Math.min(sunflowerPointCaveman.getSunflowerPointCavemanUseCount() - 100, count));
//        });
//        player.getCapability(TheClassicsOfTendonChangingCapabilityProvider.THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY).ifPresent(theClassicsOfTendonChanging -> {
//            theClassicsOfTendonChanging.addTheClassicsOfTendonChangingUseCount(Math.min(theClassicsOfTendonChanging.getTheClassicsOfTendonChangingUseCount() - 100, count));
//        });
//        player.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).ifPresent(treadTheSnowWithoutTrace -> {
//            treadTheSnowWithoutTrace.addTreadTheSnowWithoutTraceUseCount(Math.min(treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCount() - 100, count));
//        });
//        player.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
//            turtleBreathWork.addTurtleBreathWorkUseCount(Math.min(turtleBreathWork.getTurtleBreathWorkUseCount() - 100, count));
//        });
//        player.getCapability(WheatNuggetEncyclopediaCapabilityProvider.WHEAT_NUGGET_ENCYCLOPEDIA_CAPABILITY).ifPresent(wheatNuggetEncyclopedia -> {
//            wheatNuggetEncyclopedia.addWheatNuggetEncyclopediaUseCount(Math.min(wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaUseCount() - 100, count));
//        });
//        player.getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).ifPresent(wuGangCutGui -> {
//            wuGangCutGui.addWuGangCutGuiUseCount(Math.min(wuGangCutGui.getWuGangCutGuiUseCount() - 100, count));
//        });
//        player.getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).ifPresent(xuannuSwordsmanship -> {
//            xuannuSwordsmanship.addXuannuSwordsmanshipUseCount(Math.min(xuannuSwordsmanship.getXuannuSwordsmanshipUseCount() - 100, count));
//        });
//        player.getCapability(YugongMovesMountainsCapabilityProvider.YUGONG_MOVES_MOUNTAINS_CAPABILITY).ifPresent(yugongMovesMountains -> {
//            yugongMovesMountains.addYugongMovesMountainsUseCount(Math.min(yugongMovesMountains.getYugongMovesMountainsUseCount() - 100, count));
//        });
//        player.getCapability(ZhangMenXinxueCapabilityProvider.ZHANG_MEN_XIN_XUE_CAPABILITY).ifPresent(zhangMenXinxueCapability -> {
//            zhangMenXinxueCapability.addZhangMenXinxueUseCount(Math.min(zhangMenXinxueCapability.getZhangMenXinxueUseCount() - 100, count));
//        });
    }

    // 新增同步方法
    public void syncQuestsToPlayer(ServerPlayer player) {
        player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY)
                .ifPresent(cap -> {
                    CompoundTag tag = cap.serializeNBT();
                    ChangShengJueMessages.sendToPlayer(
                            new SyncQuestDataPacket(player.getUUID(), tag), player);});
    }


}