package com.shengchanshe.chang_sheng_jue.gametest;

import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.custom.castingmolds.BullionsCastingMoldsBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.castingmolds.CastingMoldsBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.loom.ChangShengJueLoomBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.pottery.PotteryWheelEntity;
import com.shengchanshe.chang_sheng_jue.capability.kungfu.IKungFuCapability;
import com.shengchanshe.chang_sheng_jue.capability.kungfu.KungFuCapability;
import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapability;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.item.kungfuxp.ExternalKungfuXp;
import com.shengchanshe.chang_sheng_jue.item.kungfuxp.InternalkungfuXp;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.TurtleBreathWork;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.GoldenBellJar;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.Hercules;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.light_kungfu.TreadTheSnowWithoutTrace;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import com.shengchanshe.chang_sheng_jue.quest.QuestEffectEntry;
import com.shengchanshe.chang_sheng_jue.quest.QuestLoader;
import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.function.IntSupplier;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class QuestKungFuRegressionGameTests {
    private QuestKungFuRegressionGameTests() {
    }

    @GameTest(template = "empty", timeoutTicks = 40)
    public static void temporaryAttackEntitiesExpire(GameTestHelper helper) {
        BlockPos position = helper.absolutePos(BlockPos.ZERO);
        List<Projectile> attacks = List.of(
                Objects.requireNonNull(ChangShengJueEntity.DUGU_NINE_SOWRDS.get().create(helper.getLevel())),
                Objects.requireNonNull(ChangShengJueEntity.GOLDEN_BLACK_KNIFE_METHOD.get().create(helper.getLevel())),
                Objects.requireNonNull(ChangShengJueEntity.GE_SHAN_DA_NIU.get().create(helper.getLevel())),
                Objects.requireNonNull(ChangShengJueEntity.BEAT_DOG_STICK_ATTACK.get().create(helper.getLevel())),
                Objects.requireNonNull(ChangShengJueEntity.TU_LONG_DAO_ATTACK.get().create(helper.getLevel())),
                Objects.requireNonNull(ChangShengJueEntity.BA_WANG_QIANG_ATTACK.get().create(helper.getLevel())),
                Objects.requireNonNull(ChangShengJueEntity.YI_TIAN_JIAN_ATTACK.get().create(helper.getLevel()))
        );
        for (int index = 0; index < attacks.size(); index++) {
            Projectile attack = attacks.get(index);
            attack.setPos(position.getX() + 0.5D + index * 0.1D,
                    position.getY() + 1.0D, position.getZ() + 0.5D);
            helper.getLevel().addFreshEntity(attack);
        }

        helper.assertTrue(attacks.stream().noneMatch(Projectile::isRemoved),
                "临时攻击实体生成后立即被移除");
        helper.runAtTickTime(20, () -> {
            helper.assertTrue(attacks.stream().allMatch(attack -> attack.isRemoved() && attack.tickCount >= 5),
                    "临时攻击实体未按各自生命周期清理");
            helper.succeed();
        });
    }

    @GameTest(template = "empty")
    public static void malformedQuestNbtFallsBackAndClampsCounters(GameTestHelper helper) {
        CompoundTag tag = minimalQuestTag(UUID.randomUUID(), UUID.randomUUID());
        tag.putString("QuestType", "not_a_quest_type");
        tag.putInt("RequiredKills", -10);
        tag.putInt("CurrentKills", Integer.MAX_VALUE);
        tag.putString("TargetEntity", "not a resource location");

        Quest quest = new Quest(tag);
        helper.assertTrue(quest.getQuestType() == Quest.QuestType.GATHER,
                "unknown quest type did not fall back to GATHER");
        helper.assertTrue(quest.getRequiredKills() == 0 && quest.getCurrentKills() == 0,
                "malformed quest counters were not clamped");
        helper.assertTrue(!quest.matchesEntity(helper.makeMockPlayer()),
                "invalid entity resource location unexpectedly matched");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void missingOrWrongQuestIdRemainsInvalidAndStable(GameTestHelper helper) {
        CompoundTag missingId = minimalQuestTag(UUID.randomUUID(), UUID.randomUUID());
        missingId.remove("QuestId");
        Quest constructed = new Quest(missingId);
        Quest loaded = new Quest(minimalQuestTag(UUID.randomUUID(), UUID.randomUUID()));
        loaded.loadNBTData(missingId);

        CompoundTag wrongTypeId = missingId.copy();
        wrongTypeId.putString("QuestId", UUID.randomUUID().toString());
        Quest wrongTypeConstructed = new Quest(wrongTypeId);
        Quest wrongTypeLoaded = new Quest(minimalQuestTag(UUID.randomUUID(), UUID.randomUUID()));
        wrongTypeLoaded.loadNBTData(wrongTypeId);

        helper.assertTrue(constructed.getQuestId() == null && loaded.getQuestId() == null,
                "missing QuestId was replaced with an unstable random UUID");
        helper.assertTrue(wrongTypeConstructed.getQuestId() == null && wrongTypeLoaded.getQuestId() == null,
                "wrong-type QuestId was replaced with an unstable random UUID");
        helper.assertTrue(!constructed.isValid() && !loaded.isValid()
                        && !wrongTypeConstructed.isValid() && !wrongTypeLoaded.isValid(),
                "quest without a typed QuestId remained valid");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void questCapabilityLimitsMalformedQuestLists(GameTestHelper helper) {
        UUID playerId = UUID.randomUUID();
        CompoundTag root = new CompoundTag();
        ListTag players = new ListTag();
        CompoundTag player = new CompoundTag();
        player.putUUID("PlayerId", playerId);
        ListTag quests = new ListTag();
        for (int i = 0; i < 140; i++) {
            quests.add(minimalQuestTag(UUID.randomUUID(), UUID.randomUUID()));
        }
        player.put("Quests", quests);
        players.add(player);
        root.put("PlayerQuests", players);

        PlayerQuestCapability capability = new PlayerQuestCapability();
        capability.deserializeNBT(root);
        helper.assertTrue(capability.getQuests(playerId).size() == 128,
                "oversized quest list was not bounded during NBT load");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void questCapabilityEnforcesRuntimeCapacityAndAllowsReplacement(GameTestHelper helper) {
        UUID playerId = UUID.randomUUID();
        UUID npcId = UUID.randomUUID();
        PlayerQuestCapability capability = new PlayerQuestCapability();
        UUID firstQuestId = new UUID(0L, 1L);
        for (int i = 0; i < 128; i++) {
            UUID questId = new UUID(0L, i + 1L);
            helper.assertTrue(capability.trySetQuest(new Quest(minimalQuestTag(questId, npcId)), playerId),
                    "runtime quest within capacity was rejected at index " + i);
        }

        Quest overflow = new Quest(minimalQuestTag(new UUID(0L, 129L), npcId));
        helper.assertTrue(!capability.trySetQuest(overflow, playerId),
                "129th runtime quest was accepted");
        Quest replacement = new Quest(minimalQuestTag(firstQuestId, npcId));
        replacement.setComplete(true);
        helper.assertTrue(capability.trySetQuest(replacement, playerId),
                "same-ID replacement was rejected at full capacity");
        helper.assertTrue(capability.getQuests(playerId).size() == 128
                        && capability.getQuests(playerId).get(0) == replacement,
                "full-capacity replacement changed size or retained the stale quest");
        try {
            helper.assertTrue(PlayerQuestCapability.class
                            .getMethod("setQuests", Quest.class, UUID.class).getReturnType() == void.class,
                    "published void setQuests descriptor changed");
            helper.assertTrue(PlayerQuestCapability.class
                            .getMethod("trySetQuest", Quest.class, UUID.class).getReturnType() == boolean.class,
                    "bounded boolean quest helper is missing");
        } catch (NoSuchMethodException exception) {
            helper.fail("quest capability compatibility method is missing");
            return;
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void questCapabilityBoundsRuntimePlayersWithoutQuerySideEffects(GameTestHelper helper) {
        PlayerQuestCapability capability = new PlayerQuestCapability();
        UUID npcId = UUID.randomUUID();
        for (int i = 0; i < 4096; i++) {
            Quest quest = new Quest(minimalQuestTag(new UUID(6L, i + 1L), npcId));
            helper.assertTrue(capability.trySetQuest(quest, new UUID(7L, i + 1L)),
                    "runtime player within capacity was rejected at index " + i);
        }

        UUID overflowPlayer = new UUID(7L, 4097L);
        helper.assertTrue(capability.getQuests(overflowPlayer).isEmpty(),
                "querying an unknown player returned quests");
        Quest overflowQuest = new Quest(minimalQuestTag(new UUID(6L, 4097L), npcId));
        helper.assertTrue(!capability.trySetQuest(overflowQuest, overflowPlayer),
                "4097th runtime player was accepted");
        helper.assertTrue(capability.serializeNBT().getList("PlayerQuests", net.minecraft.nbt.Tag.TAG_COMPOUND).size() == 4096,
                "querying an unknown player created an empty persisted record");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void questHistoryIdsAreBoundedAndCountsSaturate(GameTestHelper helper) {
        UUID saturatedQuest = new UUID(2L, 1L);
        CompoundTag saved = new CompoundTag();
        CompoundTag counts = new CompoundTag();
        counts.putInt(saturatedQuest.toString(), 1_000_000);
        saved.put("QuestCompletionCounts", counts);
        PlayerQuestCapability capability = new PlayerQuestCapability();
        capability.deserializeNBT(saved);
        capability.setCompletionCount(saturatedQuest);
        helper.assertTrue(capability.getCompletionCount(saturatedQuest) == 1_000_000,
                "quest completion count overflowed its saturation limit");

        for (int i = 0; i < 4097; i++) {
            UUID questId = new UUID(3L, i + 1L);
            capability.markQuestAccepted(questId);
            capability.markQuestCompleted(questId);
            capability.setCompletionCount(questId);
        }
        CompoundTag serialized = capability.serializeNBT();
        helper.assertTrue(serialized.getList("AcceptedQuests", net.minecraft.nbt.Tag.TAG_INT_ARRAY).size() == 4096,
                "accepted quest history exceeded 4096 IDs");
        helper.assertTrue(serialized.getList("CompletedQuests", net.minecraft.nbt.Tag.TAG_INT_ARRAY).size() == 4096,
                "completed quest history exceeded 4096 IDs");
        helper.assertTrue(serialized.getCompound("QuestCompletionCounts").getAllKeys().size() == 4096,
                "quest completion-count IDs exceeded 4096");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void questItemCountsAndCollectionsRemainNbtRoundTripSafe(GameTestHelper helper) {
        List<ItemStack> parsed = QuestLoader.parseItemList(JsonParser.parseString(
                "[{\"item\":\"minecraft:stone\",\"count\":128},"
                        + "{\"item\":\"minecraft:dirt\",\"count\":{\"type\":\"minecraft:binomial\",\"n\":2147483647,\"p\":1.0}}]"));
        helper.assertTrue(parsed.size() == 2 && parsed.stream().allMatch(stack -> stack.getCount() == 127),
                "quest loader created an ItemStack count that cannot round-trip through byte Count NBT");

        Quest quest = new Quest(minimalQuestTag(UUID.randomUUID(), UUID.randomUUID()));
        List<ItemStack> oversizedRewards = new ArrayList<>();
        for (int i = 0; i < 140; i++) {
            oversizedRewards.add(new ItemStack(Items.STONE, 1_000_000));
        }
        quest.setQuestRewards(oversizedRewards);
        List<QuestEffectEntry> effects = new ArrayList<>();
        for (int i = 0; i < 70; i++) {
            effects.add(new QuestEffectEntry("minecraft:speed", 20, 0, false, true, true));
        }
        quest.setEffects(effects);
        List<UUID> conflicts = new ArrayList<>();
        for (int i = 0; i < 140; i++) conflicts.add(new UUID(8L, i + 1L));
        quest.setConflictQuestIds(conflicts);

        CompoundTag serialized = quest.toNbt();
        Quest roundTripped = new Quest(serialized);
        helper.assertTrue(serialized.getList("QuestRewards", net.minecraft.nbt.Tag.TAG_COMPOUND).size() == 128
                        && roundTripped.getQuestRewards().size() == 128
                        && roundTripped.getQuestRewards().stream().allMatch(stack -> stack.getCount() == 127),
                "quest reward list or count exceeded its NBT-safe boundary");
        helper.assertTrue(serialized.getList("Effects", net.minecraft.nbt.Tag.TAG_COMPOUND).size() == 64
                        && serialized.getList("ConflictQuestIds", net.minecraft.nbt.Tag.TAG_INT_ARRAY).size() == 128,
                "quest effect or UUID collection exceeded its serialized boundary");
        helper.succeed();
    }

    @GameTest(template = "empty")
    @SuppressWarnings("deprecation")
    public static void questAcceptanceAliasesPreserveLegacyInverseSemantics(GameTestHelper helper) {
        UUID questId = UUID.randomUUID();
        PlayerQuestCapability capability = new PlayerQuestCapability();
        helper.assertTrue(!capability.hasAcceptedQuest(questId)
                        && capability.hasNeverAcceptedQuest(questId)
                        && capability.isQuestAccepted(questId),
                "fresh acceptance aliases disagree with the legacy inverse method");
        capability.markQuestAccepted(questId);
        helper.assertTrue(capability.hasAcceptedQuest(questId)
                        && !capability.hasNeverAcceptedQuest(questId)
                        && !capability.isQuestAccepted(questId),
                "accepted quest aliases disagree with the legacy inverse method");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void questDefinitionsAreCachedButRuntimeQuestsRemainIndependent(GameTestHelper helper) {
        UUID npcId = UUID.randomUUID();
        List<Quest> firstLoad = QuestLoader.loadAllAvailableQuests(npcId, Set.of());
        List<Quest> secondLoad = QuestLoader.loadAllAvailableQuests(npcId, Set.of());
        helper.assertTrue(!firstLoad.isEmpty() && firstLoad.size() == secondLoad.size(),
                "server quest definition cache was empty or unstable after initial reload");
        Quest firstQuest = firstLoad.get(0);
        Quest secondQuest = secondLoad.stream()
                .filter(quest -> quest.getQuestId().equals(firstQuest.getQuestId()))
                .findFirst()
                .orElse(null);
        helper.assertTrue(secondQuest != null && secondQuest != firstQuest,
                "quest definition cache reused a mutable runtime Quest instance");
        firstQuest.setCurrentKills(42);
        helper.assertTrue(secondQuest.getCurrentKills() != 42,
                "quest definition cache shared mutable runtime quest progress");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void kungFuCapabilityKeepsPublishedTickAbi(GameTestHelper helper) {
        try {
            helper.assertTrue(IKungFuCapability.class.getMethod("tick", LivingEntity.class).getReturnType() == void.class,
                    "published void tick ABI changed");
        } catch (NoSuchMethodException exception) {
            helper.fail("published tick ABI is missing");
            return;
        }
        helper.assertTrue(hasNoMutableInstanceState(InternalkungfuXp.class)
                        && hasNoMutableInstanceState(ExternalKungfuXp.class),
                "kung fu experience item retained per-registry-item runtime state");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void kungFuCapabilitySkipsMalformedDuplicateAndOversizedSavedEntries(GameTestHelper helper) {
        CompoundTag firstExternal = new TurtleBreathWork().serializeNBT();
        firstExternal.putInt("KungFuCooldown", 11);
        CompoundTag duplicateExternal = firstExternal.copy();
        duplicateExternal.putInt("KungFuCooldown", 77);

        CompoundTag validInternal = new GoldenBellJar().serializeNBT();
        CompoundTag malformedName = new TreadTheSnowWithoutTrace().serializeNBT();
        malformedName.putString("KungFuName", "{");
        CompoundTag malformedType = new Hercules().serializeNBT();
        malformedType.putString("KungFuType", "not_a_kung_fu_type");

        ListTag savedEntries = new ListTag();
        savedEntries.add(firstExternal);
        savedEntries.add(malformedName);
        savedEntries.add(validInternal);
        savedEntries.add(malformedType);
        savedEntries.add(duplicateExternal);
        savedEntries.add(new CompoundTag());
        while (savedEntries.size() < 128) {
            CompoundTag unknown = new CompoundTag();
            unknown.putString("KungFuId", "chang_sheng_jue:unknown_saved_kung_fu_" + savedEntries.size());
            savedEntries.add(unknown);
        }
        savedEntries.add(new TreadTheSnowWithoutTrace().serializeNBT());

        CompoundTag savedCapability = new CompoundTag();
        savedCapability.put("LearnedKungFu", savedEntries);
        KungFuCapability capability = new KungFuCapability();
        capability.deserializeNBT(savedCapability);

        helper.assertTrue(capability.getAllLearned().size() == 2,
                "kung fu load did not bound or reject malformed saved entries");
        helper.assertTrue(capability.getKungFu(TurtleBreathWork.KUNG_FU_ID.toString()).isPresent(),
                "valid kung fu before a malformed entry was not restored");
        helper.assertTrue(capability.getCooldownTick(TurtleBreathWork.KUNG_FU_ID.toString()) == 11,
                "duplicate kung fu entry replaced the first valid saved state");
        helper.assertTrue(capability.getKungFu(GoldenBellJar.KUNG_FU_ID.toString()).isPresent(),
                "valid kung fu after a malformed entry was not restored");
        helper.assertTrue(capability.getKungFu(TreadTheSnowWithoutTrace.KUNG_FU_ID.toString()).isEmpty(),
                "kung fu entry beyond the saved-list hard limit was loaded");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void legacyBlockEntitiesSyncProgressResetOnlyOnce(GameTestHelper helper) {
        TrackingLoom loom = new TrackingLoom(
                BlockPos.ZERO, ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get().defaultBlockState());
        assertSingleProgressReset(helper, loom, "LoomBlockProgress", loom::tick, loom::dirtyCalls,
                "loom");

        TrackingPotteryWheel potteryWheel = new TrackingPotteryWheel(
                BlockPos.ZERO, ChangShengJueBlocks.POTTERY_WHEEL.get().defaultBlockState());
        assertSingleProgressReset(helper, potteryWheel, "PotteryProgress", potteryWheel::tick,
                potteryWheel::dirtyCalls, "pottery wheel");

        TrackingCastingMolds castingMolds = new TrackingCastingMolds(
                BlockPos.ZERO, ChangShengJueBlocks.CASTING_MOLDS.get().defaultBlockState());
        assertSingleProgressReset(helper, castingMolds, "CastingMoldsProgress", castingMolds::tick,
                castingMolds::dirtyCalls, "casting molds");

        TrackingBullionsCastingMolds bullionsCastingMolds = new TrackingBullionsCastingMolds(
                BlockPos.ZERO, ChangShengJueBlocks.BULLIONS_CASTING_MOLDS.get().defaultBlockState());
        assertSingleProgressReset(helper, bullionsCastingMolds, "LngotMoldsProgress", bullionsCastingMolds::tick,
                bullionsCastingMolds::dirtyCalls, "bullion casting molds");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void externalKungFuDamagesActuallyUsedStack(GameTestHelper helper) {
        ControlledUsePlayer player = new ControlledUsePlayer(helper.getLevel());
        player.getAbilities().instabuild = false;

        ItemStack mainHandStack = new ItemStack(Items.BOW);
        mainHandStack.setDamageValue(5);
        releaseKungFuWhileUsing(helper, player, InteractionHand.MAIN_HAND, mainHandStack,
                "survival main-hand");
        helper.assertTrue(player.getMainHandItem() == mainHandStack,
                "main-hand item identity changed during kung fu release");
        helper.assertTrue(player.getMainHandItem().getDamageValue() == 6,
                "external kung fu did not damage the held main-hand stack");

        ItemStack unchangedMainHand = new ItemStack(Items.BOW);
        unchangedMainHand.setDamageValue(10);
        player.setItemInHand(InteractionHand.MAIN_HAND, unchangedMainHand);
        ItemStack offHandStack = new ItemStack(Items.BOW);
        offHandStack.setDamageValue(20);
        releaseKungFuWhileUsing(helper, player, InteractionHand.OFF_HAND, offHandStack,
                "survival off-hand");
        helper.assertTrue(player.getMainHandItem() == unchangedMainHand,
                "off-hand kung fu replaced the main-hand stack identity");
        helper.assertTrue(player.getMainHandItem().getDamageValue() == 10,
                "off-hand kung fu damaged the main-hand stack");
        helper.assertTrue(player.getOffhandItem() == offHandStack,
                "off-hand item identity changed during kung fu release");
        helper.assertTrue(player.getOffhandItem().getDamageValue() == 21,
                "off-hand kung fu did not damage the actively used off-hand stack");

        player.getAbilities().instabuild = true;
        ItemStack creativeStack = new ItemStack(Items.BOW);
        creativeStack.setDamageValue(30);
        releaseKungFuWhileUsing(helper, player, InteractionHand.MAIN_HAND, creativeStack,
                "creative main-hand");
        helper.assertTrue(player.getMainHandItem().getDamageValue() == 30,
                "creative-mode item durability changed during kung fu release");

        player.getAbilities().instabuild = false;
        ItemStack nonDamageable = new ItemStack(Items.APPLE);
        releaseKungFuWhileUsing(helper, player, InteractionHand.MAIN_HAND, nonDamageable,
                "non-damageable main-hand");
        helper.assertTrue(player.getMainHandItem() == nonDamageable,
                "non-damageable main-hand item identity changed during kung fu release");
        helper.assertTrue(player.getMainHandItem().getDamageValue() == 0,
                "external kung fu changed a non-damageable main-hand stack");

        player.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
        readyTurtleBreathWork().release(player);
        helper.assertTrue(player.getMainHandItem().isEmpty(),
                "external kung fu did not preserve the empty main-hand boundary");
        helper.succeed();
    }

    private static CompoundTag minimalQuestTag(UUID questId, UUID npcId) {
        CompoundTag tag = new CompoundTag();
        tag.putUUID("QuestId", questId);
        tag.putUUID("QuestNpcId", npcId);
        tag.putString("QuestType", Quest.QuestType.KILL.name());
        tag.put("QuestRequirements", new ListTag());
        tag.put("QuestRewards", new ListTag());
        tag.put("Effects", new ListTag());
        tag.put("LimitQuestIds", new ListTag());
        tag.put("ConflictQuestIds", new ListTag());
        return tag;
    }

    private static void assertSingleProgressReset(GameTestHelper helper, BlockEntity blockEntity, String progressKey,
                                                  Runnable tick, IntSupplier dirtyCalls, String scenario) {
        CompoundTag saved = blockEntity.getUpdateTag();
        saved.putInt(progressKey, 4);
        blockEntity.load(saved);
        if (blockEntity instanceof DirtyCallTracker tracker) {
            tracker.resetDirtyCalls();
        } else {
            helper.fail(scenario + ": fixture does not track setChanged calls");
            return;
        }

        tick.run();
        helper.assertTrue(blockEntity.getUpdateTag().getInt(progressKey) == 0,
                scenario + ": invalid recipe did not reset non-zero progress");
        helper.assertTrue(dirtyCalls.getAsInt() == 1,
                scenario + ": non-zero progress reset did not call setChanged exactly once");

        tick.run();
        helper.assertTrue(dirtyCalls.getAsInt() == 1,
                scenario + ": zero progress caused a repeated setChanged call");
    }

    private static boolean hasNoMutableInstanceState(Class<?> itemClass) {
        return java.util.Arrays.stream(itemClass.getDeclaredFields())
                .noneMatch(field -> !Modifier.isStatic(field.getModifiers()));
    }

    private static TurtleBreathWork readyTurtleBreathWork() {
        TurtleBreathWork kungFu = new TurtleBreathWork();
        CompoundTag tag = kungFu.serializeNBT();
        tag.putBoolean("KungFuIsComprehend", true);
        tag.putInt("KungFuLevel", 1);
        tag.putInt("KungFuCooldown", 0);
        tag.putBoolean("KungFuIsStart", true);
        kungFu.deserializeNBT(tag);
        return kungFu;
    }

    private static void releaseKungFuWhileUsing(GameTestHelper helper, ControlledUsePlayer player,
                                                InteractionHand hand, ItemStack itemStack, String scenario) {
        player.beginUsing(hand, itemStack);
        try {
            helper.assertTrue(player.isUsingItem(), scenario + ": fixture did not establish an active use state");
            helper.assertTrue(player.getUsedItemHand() == hand, scenario + ": fixture activated the wrong hand");
            helper.assertTrue(player.getUseItem() == itemStack, scenario + ": fixture did not retain the selected item stack");
            readyTurtleBreathWork().release(player);
        } finally {
            player.endUsing();
        }
    }

    private static final class ControlledUsePlayer extends Player {
        private boolean controlledUsing;
        private InteractionHand controlledHand = InteractionHand.MAIN_HAND;
        private ItemStack controlledUseItem = ItemStack.EMPTY;

        private ControlledUsePlayer(Level level) {
            super(level, BlockPos.ZERO, 0.0F, new GameProfile(UUID.randomUUID(), "kungfu_test"));
        }

        private void beginUsing(InteractionHand hand, ItemStack itemStack) {
            setItemInHand(hand, itemStack);
            controlledHand = hand;
            controlledUseItem = itemStack;
            controlledUsing = true;
        }

        private void endUsing() {
            controlledUsing = false;
            controlledHand = InteractionHand.MAIN_HAND;
            controlledUseItem = ItemStack.EMPTY;
        }

        @Override
        public boolean isUsingItem() {
            return controlledUsing;
        }

        @Override
        public InteractionHand getUsedItemHand() {
            return controlledHand;
        }

        @Override
        public ItemStack getUseItem() {
            return controlledUseItem;
        }

        @Override
        public boolean isSpectator() {
            return false;
        }

        @Override
        public boolean isCreative() {
            return getAbilities().instabuild;
        }
    }

    private interface DirtyCallTracker {
        void resetDirtyCalls();
    }

    private static final class TrackingLoom extends ChangShengJueLoomBlockEntity implements DirtyCallTracker {
        private int dirtyCalls;

        private TrackingLoom(BlockPos pos, net.minecraft.world.level.block.state.BlockState state) {
            super(pos, state);
        }

        @Override
        public void setChanged() {
            dirtyCalls++;
            super.setChanged();
        }

        private int dirtyCalls() {
            return dirtyCalls;
        }

        @Override
        public void resetDirtyCalls() {
            dirtyCalls = 0;
        }
    }

    private static final class TrackingPotteryWheel extends PotteryWheelEntity implements DirtyCallTracker {
        private int dirtyCalls;

        private TrackingPotteryWheel(BlockPos pos, net.minecraft.world.level.block.state.BlockState state) {
            super(pos, state);
        }

        @Override
        public void setChanged() {
            dirtyCalls++;
            super.setChanged();
        }

        private int dirtyCalls() {
            return dirtyCalls;
        }

        @Override
        public void resetDirtyCalls() {
            dirtyCalls = 0;
        }
    }

    private static final class TrackingCastingMolds extends CastingMoldsBlockEntity implements DirtyCallTracker {
        private int dirtyCalls;

        private TrackingCastingMolds(BlockPos pos, net.minecraft.world.level.block.state.BlockState state) {
            super(pos, state);
        }

        @Override
        public void setChanged() {
            dirtyCalls++;
            super.setChanged();
        }

        private int dirtyCalls() {
            return dirtyCalls;
        }

        @Override
        public void resetDirtyCalls() {
            dirtyCalls = 0;
        }
    }

    private static final class TrackingBullionsCastingMolds extends BullionsCastingMoldsBlockEntity implements DirtyCallTracker {
        private int dirtyCalls;

        private TrackingBullionsCastingMolds(BlockPos pos, net.minecraft.world.level.block.state.BlockState state) {
            super(pos, state);
        }

        @Override
        public void setChanged() {
            dirtyCalls++;
            super.setChanged();
        }

        private int dirtyCalls() {
            return dirtyCalls;
        }

        @Override
        public void resetDirtyCalls() {
            dirtyCalls = 0;
        }
    }
}
