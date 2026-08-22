package com.shengchanshe.chang_sheng_jue.gametest;

import com.mojang.authlib.GameProfile;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.ChangShengJueConfig;
import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapability;
import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.other.GangLeader;
import com.shengchanshe.chang_sheng_jue.event.quest.PlayerQuestEvent;
import com.shengchanshe.chang_sheng_jue.event.quest.QuestEvent;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import com.shengchanshe.chang_sheng_jue.quest.QuestManager;
import net.minecraft.core.Direction;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.npc.Villager;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class QuestSynchronizationGameTests {
    private QuestSynchronizationGameTests() {
    }

    @GameTest(template = "empty")
    public static void unchangedExistingQuestDoesNotSynchronize(GameTestHelper helper) {
        TestServerPlayer player = new TestServerPlayer(helper, "quest-no-change");
        UUID questId = UUID.randomUUID();
        Quest quest = createQuest(questId, Quest.QuestType.AUTOMATIC, 0, 0,
                "", "", 0, 0, 0, false);
        player.questCapability.setQuests(quest, player.getUUID());

        player.questCapability.triggerQuest(player, questId, 1.0F, null);

        helper.assertTrue(player.questCapability.syncCount == 0,
                "unchanged existing quest emitted a synchronization packet");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void newlyAddedQuestSynchronizesExactlyOnce(GameTestHelper helper) {
        TestServerPlayer player = new TestServerPlayer(helper, "quest-new");

        player.questCapability.triggerQuest(player, PlayerQuestEvent.REN_WO_XING_QUEST_ID, 1.0F, null);

        helper.assertTrue(player.questCapability.getQuests(player.getUUID()).stream()
                        .anyMatch(quest -> PlayerQuestEvent.REN_WO_XING_QUEST_ID.equals(quest.getQuestId())),
                "valid quest was not added to the player capability");
        helper.assertTrue(player.questCapability.syncCount == 1,
                "newly added quest did not synchronize exactly once");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void existingDailyQuestProgressSynchronizesExactlyOnce(GameTestHelper helper) {
        TestServerPlayer player = new TestServerPlayer(helper, "quest-daily");
        Quest quest = createQuest(PlayerQuestEvent.REN_WO_XING_QUEST_ID, Quest.QuestType.AUTOMATIC,
                0, 0, "", "", 0, 0, 0, false);
        player.questCapability.setQuests(quest, player.getUUID());

        player.questCapability.triggerQuest(player, PlayerQuestEvent.REN_WO_XING_QUEST_ID, 1.0F, null);

        helper.assertTrue(quest.getQuestCurrentDay() == 1,
                "existing daily quest progress did not change");
        helper.assertTrue(player.questCapability.syncCount == 1,
                "daily quest progress did not synchronize exactly once");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void disabledQuestSystemStillAdvancesExistingDailyQuest(GameTestHelper helper) {
        TestServerPlayer player = new TestServerPlayer(helper, "quest-disabled");
        Quest quest = createQuest(PlayerQuestEvent.VEGETARIAN_FOOD_QUEST_ID, Quest.QuestType.TREAT,
                0, 0, "", "", 0, 0, 0, false);
        player.questCapability.setQuests(quest, player.getUUID());
        boolean previous = ChangShengJueConfig.ENABLE_QUESTS.get();
        long previousDayTime = helper.getLevel().getDayTime();
        try {
            helper.getLevel().setDayTime(1L);
            ChangShengJueConfig.ENABLE_QUESTS.set(false);
            PlayerQuestEvent.onPlayerTick(new TickEvent.PlayerTickEvent(TickEvent.Phase.END, player));
        } finally {
            ChangShengJueConfig.ENABLE_QUESTS.set(previous);
            helper.getLevel().setDayTime(previousDayTime);
        }

        helper.assertTrue(quest.getQuestCurrentDay() == 1,
                "disabled automatic acquisition also froze existing quest progress");
        helper.assertTrue(player.questCapability.syncCount == 1,
                "existing quest progress did not synchronize while automatic acquisition was disabled");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void disabledQuestSystemRejectsOnlyNewAutomaticQuest(GameTestHelper helper) {
        TestServerPlayer player = new TestServerPlayer(helper, "quest-disabled-new");
        boolean previous = ChangShengJueConfig.ENABLE_QUESTS.get();
        try {
            ChangShengJueConfig.ENABLE_QUESTS.set(false);
            player.questCapability.triggerQuest(
                    player, PlayerQuestEvent.REN_WO_XING_QUEST_ID, 1.0F, null);
        } finally {
            ChangShengJueConfig.ENABLE_QUESTS.set(previous);
        }

        helper.assertTrue(player.questCapability.getQuests(player.getUUID()).isEmpty(),
                "disabled automatic acquisition added a new automatic quest");
        helper.assertTrue(!player.questCapability.hasAcceptedQuest(PlayerQuestEvent.REN_WO_XING_QUEST_ID),
                "rejected automatic quest polluted accepted history");
        helper.assertTrue(player.questCapability.syncCount == 0,
                "rejected automatic quest emitted synchronization");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void disabledAutomaticAcquisitionStillAllowsManualGangQuest(GameTestHelper helper) {
        TestServerPlayer player = new TestServerPlayer(helper, "quest-manual-disabled");
        GangLeader leader = ChangShengJueEntity.GANG_LEADER.get().create(helper.getLevel());
        helper.assertTrue(leader != null, "gang leader fixture was not created");
        Quest manualQuest = createQuest(UUID.randomUUID(), Quest.QuestType.KILL,
                0, 0, "", "", 0, 0, 0, false);
        manualQuest.setQuestNpcId(leader.getUUID());
        leader.addQuestForPlayer(player.getUUID(), manualQuest);

        boolean accepted;
        boolean previous = ChangShengJueConfig.ENABLE_QUESTS.get();
        try {
            ChangShengJueConfig.ENABLE_QUESTS.set(false);
            accepted = QuestManager.getInstance().tryAcceptQuest(player, leader, manualQuest.getQuestId());
        } finally {
            ChangShengJueConfig.ENABLE_QUESTS.set(previous);
        }

        helper.assertTrue(accepted && player.getUUID().equals(manualQuest.getAcceptedBy()),
                "automatic-acquisition toggle blocked a manual gang quest");
        helper.assertTrue(player.questCapability.hasAcceptedQuest(manualQuest.getQuestId())
                        && player.questCapability.syncCount == 1,
                "manual gang quest was not committed and synchronized exactly once");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void fullQuestCapacityRejectsGangQuestWithoutSideEffects(GameTestHelper helper) {
        TestServerPlayer player = new TestServerPlayer(helper, "quest-full-gang");
        UUID npcId = UUID.randomUUID();
        for (int i = 0; i < 128; i++) {
            Quest existing = createQuest(new UUID(5L, i + 1L), Quest.QuestType.KILL,
                    0, 0, "", "", 0, 0, 0, false);
            existing.setQuestNpcId(npcId);
            helper.assertTrue(player.questCapability.trySetQuest(existing, player.getUUID()),
                    "capacity fixture rejected quest " + i);
        }
        GangLeader leader = ChangShengJueEntity.GANG_LEADER.get().create(helper.getLevel());
        helper.assertTrue(leader != null, "gang leader fixture was not created");
        Quest rejected = createGeneratedGangQuest(UUID.randomUUID(), leader.getUUID());
        leader.addQuestForPlayer(player.getUUID(), rejected);
        int cowsBefore = countEntities(helper, EntityType.COW);

        boolean accepted = QuestManager.getInstance()
                .tryAcceptQuest(player, leader, rejected.getQuestId());
        int cowsAfter = countEntities(helper, EntityType.COW);

        helper.assertTrue(!accepted && rejected.getAcceptedBy() == null,
                "full quest capacity mutated the gang quest acceptance state");
        helper.assertTrue(!player.questCapability.hasAcceptedQuest(rejected.getQuestId())
                        && player.questCapability.syncCount == 0,
                "rejected gang quest marked history or synchronized");
        helper.assertTrue(cowsAfter == cowsBefore
                        && leader.getPlayerQuests(player.getUUID()).size() == 1,
                "rejected gang quest generated targets or mutated the NPC quest list");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void completedDailyQuestDoesNotResynchronize(GameTestHelper helper) {
        TestServerPlayer player = new TestServerPlayer(helper, "quest-complete");
        Quest quest = createQuest(PlayerQuestEvent.REN_WO_XING_QUEST_ID, Quest.QuestType.AUTOMATIC,
                0, 0, "", "", 0, 0, 0, true);
        player.questCapability.setQuests(quest, player.getUUID());

        player.questCapability.triggerQuest(player, PlayerQuestEvent.REN_WO_XING_QUEST_ID, 1.0F, null);

        helper.assertTrue(quest.getQuestCurrentDay() == 0 && quest.isComplete(),
                "completed daily quest changed unexpectedly");
        helper.assertTrue(player.questCapability.syncCount == 0,
                "completed daily quest emitted a redundant synchronization packet");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void zeroChanceTriggerLeavesQuestListNbtUnchanged(GameTestHelper helper) {
        TestServerPlayer player = new TestServerPlayer(helper, "quest-zero");
        Quest existingQuest = createQuest(UUID.randomUUID(), Quest.QuestType.AUTOMATIC,
                0, 0, "", "", 0, 0, 0, false);
        player.questCapability.setQuests(existingQuest, player.getUUID());
        CompoundTag before = player.questCapability.serializeNBT();

        player.questCapability.triggerQuest(player, PlayerQuestEvent.REN_WO_XING_QUEST_ID, 0.0F, null);

        helper.assertTrue(before.equals(player.questCapability.serializeNBT()),
                "zero-chance trigger changed the serialized quest list");
        helper.assertTrue(player.questCapability.syncCount == 0,
                "zero-chance trigger emitted a synchronization packet");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void deathProgressConsolidatesFirstAndSecondKillSynchronization(GameTestHelper helper) {
        TestServerPlayer player = new TestServerPlayer(helper, "quest-kills");
        Quest firstTargetQuest = createQuest(UUID.randomUUID(), Quest.QuestType.KILL,
                1, 0, "minecraft:cow", "", 0, 0, 0, false);
        Quest secondTargetQuest = createQuest(UUID.randomUUID(), Quest.QuestType.KILL,
                1, 1, "minecraft:zombie", "minecraft:cow", 1, 0, 0, false);
        player.questCapability.setQuests(firstTargetQuest, player.getUUID());
        player.questCapability.setQuests(secondTargetQuest, player.getUUID());
        Cow cow = new Cow(EntityType.COW, helper.getLevel());

        QuestEvent.onEntityDeath(new LivingDeathEvent(
                cow, helper.getLevel().damageSources().playerAttack(player)));

        helper.assertTrue(firstTargetQuest.getCurrentKills() == 1,
                "first kill target progress was not incremented");
        helper.assertTrue(secondTargetQuest.getSecondCurrentKills() == 1,
                "second kill target progress was not incremented");
        helper.assertTrue(player.questCapability.syncCount == 1,
                "multiple kill progress changes were not consolidated into one synchronization");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void unmatchedKillDoesNotSynchronize(GameTestHelper helper) {
        TestServerPlayer player = new TestServerPlayer(helper, "quest-miss");
        Quest quest = createQuest(UUID.randomUUID(), Quest.QuestType.KILL,
                1, 0, "minecraft:zombie", "", 0, 0, 0, false);
        player.questCapability.setQuests(quest, player.getUUID());
        Cow cow = new Cow(EntityType.COW, helper.getLevel());

        QuestEvent.onEntityDeath(new LivingDeathEvent(
                cow, helper.getLevel().damageSources().playerAttack(player)));

        helper.assertTrue(quest.getCurrentKills() == 0,
                "unmatched kill changed quest progress");
        helper.assertTrue(player.questCapability.syncCount == 0,
                "unmatched kill emitted a synchronization packet");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void animalDeathResetsVegetarianDayOnce(GameTestHelper helper) {
        TestServerPlayer player = new TestServerPlayer(helper, "quest-animal");
        Quest quest = createQuest(PlayerQuestEvent.VEGETARIAN_FOOD_QUEST_ID, Quest.QuestType.TREAT,
                0, 0, "", "", 0, 0, 1, true);
        player.questCapability.setQuests(quest, player.getUUID());
        Cow cow = new Cow(EntityType.COW, helper.getLevel());

        QuestEvent.onEntityDeath(new LivingDeathEvent(
                cow, helper.getLevel().damageSources().playerAttack(player)));

        helper.assertTrue(quest.getQuestCurrentDay() == 0,
                "animal death did not reset vegetarian quest day progress");
        helper.assertTrue(player.questCapability.syncCount == 1,
                "vegetarian quest reset did not synchronize exactly once");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void animalDeathAtZeroVegetarianDayDoesNotSynchronize(GameTestHelper helper) {
        TestServerPlayer player = new TestServerPlayer(helper, "quest-animal0");
        Quest quest = createQuest(PlayerQuestEvent.VEGETARIAN_FOOD_QUEST_ID, Quest.QuestType.TREAT,
                0, 0, "", "", 0, 0, 0, true);
        player.questCapability.setQuests(quest, player.getUUID());
        Cow cow = new Cow(EntityType.COW, helper.getLevel());

        QuestEvent.onEntityDeath(new LivingDeathEvent(
                cow, helper.getLevel().damageSources().playerAttack(player)));

        helper.assertTrue(quest.getQuestCurrentDay() == 0,
                "animal death changed zero vegetarian day progress");
        helper.assertTrue(player.questCapability.syncCount == 0,
                "zero vegetarian day emitted a redundant synchronization packet");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void villagerEffectChangeDoesNotSynchronizeQuestData(GameTestHelper helper) {
        TestServerPlayer player = new TestServerPlayer(helper, "quest-villager");
        player.addEffect(new MobEffectInstance(
                ChangShengJueEffects.VILLAGER_CHARM_EFFECT.get(), 200, 0, false, false));
        Villager villager = new Villager(EntityType.VILLAGER, helper.getLevel());

        QuestEvent.onEntityDeath(new LivingDeathEvent(
                villager, helper.getLevel().damageSources().playerAttack(player)));

        helper.assertTrue(player.hasEffect(ChangShengJueEffects.INSTANT_DISFAVOR_EFFECT.get()),
                "villager death fixture did not exercise the effect replacement branch");
        helper.assertTrue(player.questCapability.syncCount == 0,
                "villager effect replacement emitted an unrelated quest synchronization packet");
        helper.succeed();
    }

    private static Quest createQuest(UUID questId, Quest.QuestType type,
                                     int requiredKills, int currentKills, String targetEntity,
                                     String secondTargetEntity, int secondRequiredKills,
                                     int secondCurrentKills, int currentDay, boolean complete) {
        CompoundTag tag = new CompoundTag();
        tag.putUUID("QuestId", questId);
        tag.putUUID("QuestNpcId", UUID.randomUUID());
        tag.putString("QuestType", type.name());
        tag.putInt("RequiredKills", requiredKills);
        tag.putInt("CurrentKills", currentKills);
        tag.putString("TargetEntity", targetEntity);
        tag.putString("SecondTargetEntity", secondTargetEntity);
        tag.putInt("SecondRequiredKills", secondRequiredKills);
        tag.putInt("SecondCurrentKills", secondCurrentKills);
        tag.putInt("QuestDay", Math.max(7, currentDay));
        tag.putInt("QuestCurrentDay", currentDay);
        tag.putBoolean("IsComplete", complete);
        return new Quest(tag);
    }

    private static Quest createGeneratedGangQuest(UUID questId, UUID npcId) {
        CompoundTag tag = new CompoundTag();
        tag.putUUID("QuestId", questId);
        tag.putUUID("QuestNpcId", npcId);
        tag.putString("QuestType", Quest.QuestType.KILL.name());
        tag.putString("TargetEntity", "minecraft:cow");
        tag.putInt("RequiredKills", 1);
        tag.putBoolean("QuestGenerateTarget", true);
        return new Quest(tag);
    }

    private static int countEntities(GameTestHelper helper, EntityType<?> type) {
        int count = 0;
        for (Entity entity : helper.getLevel().getAllEntities()) {
            if (entity.getType() == type) {
                count++;
            }
        }
        return count;
    }

    private static final class CountingQuestCapability extends PlayerQuestCapability {
        private int syncCount;

        @Override
        public void syncToClient(ServerPlayer player) {
            syncCount++;
        }
    }

    private static final class TestServerPlayer extends ServerPlayer {
        private final CountingQuestCapability questCapability = new CountingQuestCapability();
        private final LazyOptional<PlayerQuestCapability> questOptional = LazyOptional.of(() -> questCapability);

        private TestServerPlayer(GameTestHelper helper, String name) {
            super(helper.getLevel().getServer(), helper.getLevel(), new GameProfile(UUID.randomUUID(), name));
        }

        @Override
        public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> capability,
                                                          @Nullable Direction side) {
            if (capability == PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY && questOptional != null) {
                return questOptional.cast();
            }
            return super.getCapability(capability, side);
        }

        @Override
        public void sendSystemMessage(Component component) {
        }

        @Override
        public void sendSystemMessage(Component component, boolean actionBar) {
        }

        @Override
        protected void onEffectAdded(MobEffectInstance effect, @Nullable Entity source) {
            // 无连接夹具只屏蔽 ServerPlayer 的效果同步包；addEffect 仍维护真实活动效果表。
        }

        @Override
        protected void onEffectUpdated(MobEffectInstance effect, boolean reapplyEffect,
                                       @Nullable Entity source) {
        }

        @Override
        protected void onEffectRemoved(MobEffectInstance effect) {
            // removeEffect 已在调用此钩子前从真实活动效果表删除效果。
        }
    }
}
