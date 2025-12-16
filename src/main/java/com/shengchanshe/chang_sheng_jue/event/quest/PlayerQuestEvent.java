package com.shengchanshe.chang_sheng_jue.event.quest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.ChangShengJueConfig;
import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.entity.custom.tiger.Tiger;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.AbstractWuXiaMonster;
import com.shengchanshe.chang_sheng_jue.entity.villagers.ChangShengJueVillagerEntity;
import com.shengchanshe.chang_sheng_jue.entity.villagers.ChangShengJueVillagers;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import com.shengchanshe.chang_sheng_jue.quest.QuestManager;
import com.shengchanshe.chang_sheng_jue.util.TimeDetection;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class PlayerQuestEvent {
    public static final UUID FIRST_VILLAGER_QUEST_ID = UUID.fromString("2b0fedb0-2b4d-4b24-81fb-c4b6c8a47fa7");
    public static final UUID KUAI_YI_EN_CHOU_QUEST_ID = UUID.fromString("584DF3EE-BD1A-44C1-B66D-5F1015AF8A0E");
    private static final UUID WEI_MIN_CHU_HAI_QUEST_ID = UUID.fromString("3A54CDE8-91B4-42A8-9F37-9C40934A15C8");
    private static final UUID CHU_BAO_AN_LIANG_QUEST_ID = UUID.fromString("066905EA-4B2D-408D-A86E-9D37F450B729");
    private static final UUID LARGE_TRANSACTIONS_A_QUEST_ID = UUID.fromString("7C19EB4E-6E86-41B1-A397-36F7572D383B");
    private static final UUID LARGE_TRANSACTIONS_B_QUEST_ID = UUID.fromString("0A9301D6-0B79-4346-A700-35E7C8339658");
    public static final UUID MARTIAL_ARTS_QUEST_ID = UUID.fromString("C8DA8DB7-2AE8-4FB0-9956-179D9D9D1CA8");
    public static final UUID REN_WO_XING_QUEST_ID = UUID.fromString("dab3e694-291c-4b58-8ed2-4b215fbcf543");
    private static final UUID CHU_QIANG_FU_RUO_QUEST_ID = UUID.fromString("D8633102-1BC2-47D4-A9D4-311A28860F7D");
    private static final UUID JIANG_HU_ZHUI_SHA_LING_QUEST_ID = UUID.fromString("4ECF3936-B0F7-4F78-90FE-C7E613A08916");
    private static final UUID AO_QI_TINA_DI_JIAN_QUEST_ID = UUID.fromString("edd0cd54-c00c-43b7-aa4c-105e949cf883");
    private static final UUID TIAN_RUO_YOU_QIANG_TIN_YI_LAO_QUEST_ID = UUID.fromString("b005b283-34fa-4217-b417-866d830ccda8");

    public static final UUID VEGETARIAN_FOOD_QUEST_ID = UUID.fromString("33954498-78EF-492C-9338-B2E85C0AD184");

    public static void onPlayerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (player.level().isClientSide) return;
            player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
                List<Quest> quests = cap.getQuests(player.getUUID());
                Optional<Quest> existingUncompleted = quests.stream()
                        .filter(Objects::nonNull)
                        .filter(quest -> quest.getQuestId().equals(AO_QI_TINA_DI_JIAN_QUEST_ID) ||
                                quest.getQuestId().equals(REN_WO_XING_QUEST_ID) )
                        .findFirst();

                if (existingUncompleted.isPresent()) {
                    Quest quest = existingUncompleted.get();
                    if (REN_WO_XING_QUEST_ID.equals(quest.getQuestId())) {
                        quest.setQuestCurrentDay(0);
                    }
                    if (AO_QI_TINA_DI_JIAN_QUEST_ID.equals(quest.getQuestId())) {
                        if (!quest.canComplete(player) && quest.getQuestCurrentTime() < quest.getQuestTime()) {
                            cap.removeQuestFromPlayer(player.getUUID(), quest.getQuestId());
                            player.sendSystemMessage(getColoredTranslation(
                                    "quest." + ChangShengJue.MOD_ID + ".fail",
                                    getColoredTranslation(quest.getQuestName())));
                        }
                    }
                }
            });
        }
    }

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (player.level().isClientSide) return;
        if (event.phase != TickEvent.Phase.END) return;
        // 获取当前游戏时间（0-23999）
        long currentTime = player.level().getDayTime() % 24000;
        // 每天只在第一次tick时检查（避免重复触发）
        if (currentTime != 1) return; // 改为每天开始时检测


        player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
            cap.triggerQuest(player, VEGETARIAN_FOOD_QUEST_ID, 0.1F, null);
            // 全局开关检查
            if (!ChangShengJueConfig.ENABLE_QUESTS.get()) return;
            cap.triggerQuest(player, JIANG_HU_ZHUI_SHA_LING_QUEST_ID, 0.1F, null);

            cap.triggerQuest(player, REN_WO_XING_QUEST_ID, 1.0F, null);

            int jiangHuZhuiShaLingCount = cap.getCompletionCount(JIANG_HU_ZHUI_SHA_LING_QUEST_ID);
            if (jiangHuZhuiShaLingCount >= 2) {
                cap.triggerQuest(player, TIAN_RUO_YOU_QIANG_TIN_YI_LAO_QUEST_ID, 1.0F, null);
            }

            int tianRuoYouQiangTinYiLaoCount = cap.getCompletionCount(TIAN_RUO_YOU_QIANG_TIN_YI_LAO_QUEST_ID);
            if (tianRuoYouQiangTinYiLaoCount >= 1) {
                if (!player.hasEffect(ChangShengJueEffects.VILLAGER_CHARM_EFFECT.get())) {
                    player.addEffect(new MobEffectInstance(ChangShengJueEffects.VILLAGER_CHARM_EFFECT.get(), -1,
                            1, false, false, true));
                }
            }
        });

    }

    public static void onEntityGenerate(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (!(player instanceof ServerPlayer)) return;
        if (event.phase != TickEvent.Phase.END) return;
        // 全局开关检查
        if (!ChangShengJueConfig.ENABLE_QUESTS.get()) return;
        entityGenerate(player, 200, JIANG_HU_ZHUI_SHA_LING_QUEST_ID, 3);
    }

    public static void entityGenerate(Player player, int tick, UUID questUUID, int count) {
        if ((player.level().getGameTime() % tick != 0)) return;
        player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
            QuestManager instance = QuestManager.getInstance();
            List<Quest> quests = cap.getQuests(player.getUUID());
            Optional<Quest> existingUncompleted = quests.stream()
                    .filter(Objects::nonNull)
                    .filter(quest -> quest.getQuestId().equals(questUUID))
                    .findFirst();
            if (existingUncompleted.isPresent()) {
                Quest quest = existingUncompleted.get();
                if (quest.getQuestCurrentTargetCount() < quest.getQuestTargetCount()) {
                    if (!quest.canComplete(player) && quest.isComplete()) {
                        instance.spawnTargetForQuest((ServerPlayer) player, quest, ((quest.getRequiredKills()) / count));
                        quest.setQuestCurrentTargetCount(quest.getQuestCurrentTargetCount() + 1);
                    }
                }
            }
        });
    }

    public static void onVillagerInteract(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getTarget() instanceof ChangShengJueVillagerEntity villager)) return;
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        // 全局开关检查
        if (!ChangShengJueConfig.ENABLE_QUESTS.get()) return;
        // 检查村民职业（例如农民）
        if (villager.getVillagerData().getProfession() != ChangShengJueVillagers.CHANG_SHENG_JUE_CHIEF.get()) {
            return;
        }

        player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
            cap.triggerQuest(player, CHU_QIANG_FU_RUO_QUEST_ID, 0.3F, null);

            if (player.getRandom().nextFloat() < 0.5) {
                float triggerChance = cap.isQuestAccepted(CHU_BAO_AN_LIANG_QUEST_ID) ? 0.2F : 0.5F;
                cap.triggerQuest(player, CHU_BAO_AN_LIANG_QUEST_ID, triggerChance, null);
            } else {
                List<Quest> quests = cap.getQuests(player.getUUID());
                Optional<Quest> existingUncompleted = quests.stream()
                        .filter(Objects::nonNull)
                        .filter(quest -> quest.getQuestId().equals(LARGE_TRANSACTIONS_A_QUEST_ID) ||
                                quest.getQuestId().equals(LARGE_TRANSACTIONS_B_QUEST_ID))
                        .findFirst();

                if (existingUncompleted.isEmpty()) {
                    float triggerChance = cap.isQuestAccepted(CHU_BAO_AN_LIANG_QUEST_ID) ? 0.2F : 0.5F;
                    UUID newQuestId = player.getRandom().nextBoolean() ? LARGE_TRANSACTIONS_A_QUEST_ID : LARGE_TRANSACTIONS_B_QUEST_ID;
                    cap.triggerQuest(player, newQuestId, triggerChance, null);
                }
            }
        });
    }

    public static void onTrackingStart(PlayerEvent.StartTracking event) {
        if (event.getEntity().level().isClientSide) return;
        if (!ChangShengJueConfig.ENABLE_QUESTS.get()) return;

        Player player = event.getEntity();
        Entity target = event.getTarget();
        BlockPos blockPos = player.blockPosition();
        ServerLevel level = (ServerLevel) player.level();

        if (target instanceof Villager) {
            player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
                cap.triggerQuest(player, FIRST_VILLAGER_QUEST_ID, 1.0f, null);
            });
        }
        if (target instanceof Tiger) {
            player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
                float triggerChance = cap.isQuestAccepted(WEI_MIN_CHU_HAI_QUEST_ID) ? 0.05F : 0.75F;
                cap.triggerQuest(player, WEI_MIN_CHU_HAI_QUEST_ID, triggerChance, null);
            });
        } else if (target instanceof Zombie) {
            player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
                if (TimeDetection.isFullNight(player.level())) {
                    if (level.isVillage(blockPos) || isPlayerInVillage(player)) {
                        cap.triggerQuest(player, MARTIAL_ARTS_QUEST_ID, 0.25F, null);
                    }
                }
            });
        }
    }


    public static boolean isPlayerInVillage(Player player) {
        if (player.level() instanceof ServerLevel serverLevel) {
            // 获取玩家所在区块的村庄管理器
            PoiManager poiManager = serverLevel.getPoiManager();

            // 检查玩家周围是否有村庄
            Optional<BlockPos> nearestVillageCenter = poiManager.findClosest(
                    holder -> holder.is(PoiTypeTags.VILLAGE),
                    player.blockPosition(),
                    64, // 搜索半径
                    PoiManager.Occupancy.ANY
            );

            // 检查至少1个有效村民（非幼儿）
            AABB searchBox = new AABB(player.blockPosition()).inflate(64);
            boolean hasVillager = !serverLevel.getEntitiesOfClass(
                    Villager.class,
                    searchBox,
                    v -> !v.isBaby()).isEmpty();

            // 检查有效床铺数量
            long beds = poiManager.getCountInRange(holder -> holder.is(PoiTypes.HOME),
                    player.blockPosition(),
                    64, // 村庄半径
                    PoiManager.Occupancy.HAS_SPACE
            );

            return nearestVillageCenter.isPresent() && beds >= 1 && hasVillager;
        }
        return false;
    }

    public static void onEntityHurt(LivingDamageEvent event) {
        if (event.getEntity().level().isClientSide) return;
        if (!ChangShengJueConfig.ENABLE_QUESTS.get()) return;

        if (event.getEntity() instanceof Player player) {
            if (event.getSource().getEntity() instanceof Mob mob && !(mob instanceof AbstractWuXiaMonster)
                    && !(mob instanceof Creeper) && !(mob instanceof Spider) && !(mob instanceof Silverfish) && !(mob instanceof Endermite)) {
                player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(cap -> {
                    cap.triggerQuest(player, KUAI_YI_EN_CHOU_QUEST_ID, 0.05F, mob.getUUID());
                });
            }
        }
    }

    // 获取带颜色的翻译文本
    public static Component getColoredTranslation(String key, Object... args) {
        String raw = Component.translatable(key, args).getString();
        return Component.literal(raw);
    }

}
