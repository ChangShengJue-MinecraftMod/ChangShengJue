package com.shengchanshe.chang_sheng_jue.network.packet.gui.quest;

import com.mojang.authlib.GameProfile;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapability;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangQuestsMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangleaderTradingMenu;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.other.GangLeader;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

import java.util.List;
import java.util.UUID;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class ServerAuthorityGameTests {
    private ServerAuthorityGameTests() {
    }

    @GameTest(template = "empty")
    public static void gangQuestGuardRejectsWrongContextWithoutMutation(GameTestHelper helper) {
        helper.assertTrue(GangQuestPacketGuard.validateOpen(null) == null
                        && GangQuestPacketGuard.validateAccept(null) == null,
                "missing sender was not rejected safely");
        GangLeader leader = createGangLeader(helper);
        BlockPos leaderPos = helper.absolutePos(BlockPos.ZERO);
        leader.setPos(leaderPos.getX() + 0.5D, leaderPos.getY(), leaderPos.getZ() + 0.5D);

        ServerPlayer menuOwner = createUnconnectedServerPlayer(helper, "quest-owner");
        menuOwner.setPos(leader.getX(), leader.getY(), leader.getZ());
        leader.setTradingPlayer(menuOwner);
        GangleaderTradingMenu ownerMenu = new GangleaderTradingMenu(1, menuOwner.getInventory(), leader);
        menuOwner.containerMenu = ownerMenu;

        ServerPlayer attacker = createUnconnectedServerPlayer(helper, "quest-attacker");
        attacker.setPos(leader.getX(), leader.getY(), leader.getZ());
        attacker.containerMenu = ownerMenu;
        assertGuardRejectedWithoutMutation(helper, attacker, leader,
                () -> GangQuestPacketGuard.validateOpen(attacker), "wrong sender was accepted");

        menuOwner.containerMenu = menuOwner.inventoryMenu;
        assertGuardRejectedWithoutMutation(helper, menuOwner, leader,
                () -> GangQuestPacketGuard.validateOpen(menuOwner), "wrong menu was accepted");

        ServerPlayer farPlayer = createUnconnectedServerPlayer(helper, "quest-far");
        farPlayer.setPos(leader.getX() + 16.0D, leader.getY(), leader.getZ());
        leader.setTradingPlayer(farPlayer);
        farPlayer.containerMenu = new GangleaderTradingMenu(2, farPlayer.getInventory(), leader);
        assertGuardRejectedWithoutMutation(helper, farPlayer, leader,
                () -> GangQuestPacketGuard.validateOpen(farPlayer), "distant sender was accepted");
        farPlayer.setPos(leader.getX(), leader.getY(), leader.getZ());
        helper.assertTrue(GangQuestPacketGuard.validateOpen(farPlayer) == leader,
                "rejected distant request consumed the valid request cooldown");

        ServerPlayer validPlayer = createUnconnectedServerPlayer(helper, "quest-valid");
        validPlayer.setPos(leader.getX(), leader.getY(), leader.getZ());
        leader.setTradingPlayer(validPlayer);
        validPlayer.containerMenu = new GangleaderTradingMenu(3, validPlayer.getInventory(), leader);
        helper.assertTrue(GangQuestPacketGuard.validateOpen(validPlayer) == leader,
                "valid menu-bound sender was rejected");
        helper.assertTrue(GangQuestPacketGuard.validateOpen(validPlayer) == null,
                "open packet rate limit accepted an immediate replay");

        ServerPlayer questOwner = createUnconnectedServerPlayer(helper, "accept-owner");
        questOwner.setPos(leader.getX(), leader.getY(), leader.getZ());
        GangQuestsMenu questMenu = new GangQuestsMenu(4, questOwner.getInventory(), leader, List.of());
        questOwner.containerMenu = questMenu;
        ServerPlayer acceptAttacker = createUnconnectedServerPlayer(helper, "accept-attacker");
        acceptAttacker.setPos(leader.getX(), leader.getY(), leader.getZ());
        acceptAttacker.containerMenu = questMenu;
        assertGuardRejectedWithoutMutation(helper, acceptAttacker, leader,
                () -> GangQuestPacketGuard.validateAccept(acceptAttacker), "accept packet trusted another player's menu");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void questCapabilityLoadsAcceptedOnlyLegacyNbt(GameTestHelper helper) {
        UUID acceptedQuest = UUID.randomUUID();
        CompoundTag legacy = new CompoundTag();
        ListTag accepted = new ListTag();
        accepted.add(NbtUtils.createUUID(acceptedQuest));
        legacy.put("AcceptedQuests", accepted);

        PlayerQuestCapability capability = new PlayerQuestCapability();
        capability.deserializeNBT(legacy);
        helper.assertTrue(capability.hasAcceptedQuest(acceptedQuest)
                        && !capability.isQuestAccepted(acceptedQuest),
                "accepted quest was lost when legacy NBT had no active PlayerQuests list");
        helper.assertTrue(capability.serializeNBT().getList("AcceptedQuests", net.minecraft.nbt.Tag.TAG_INT_ARRAY).size() == 1,
                "accepted-only legacy NBT was not preserved on save");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void questCapabilityCopyIsDeepAndComplete(GameTestHelper helper) {
        UUID playerId = UUID.randomUUID();
        UUID questId = UUID.randomUUID();
        UUID npcId = UUID.randomUUID();
        UUID completedId = UUID.randomUUID();
        Quest sourceQuest = createMinimalQuest(questId, npcId);

        PlayerQuestCapability source = new PlayerQuestCapability();
        source.setQuests(sourceQuest, playerId);
        source.markQuestAccepted(questId);
        source.markQuestCompleted(completedId);
        source.setCompletionCount(completedId);
        source.setFirstLargeTransactionTrigger(false);

        PlayerQuestCapability copy = new PlayerQuestCapability();
        copy.copyFrom(source);
        sourceQuest.setComplete(true);

        Quest copiedQuest = copy.getQuests(playerId).get(0);
        helper.assertTrue(copiedQuest != sourceQuest && !copiedQuest.isComplete(),
                "death copy retained the original mutable quest instance");
        helper.assertTrue(copy.hasAcceptedQuest(questId)
                        && !copy.isQuestAccepted(questId),
                "death copy lost accepted quest history");
        helper.assertTrue(copy.isQuestCompleted(completedId) && copy.getCompletionCount(completedId) == 1,
                "death copy lost completion history");
        helper.assertTrue(!copy.isFirstLargeTransactionTrigger(),
                "death copy reset first large transaction state");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void questPacketsPreservePublishedWireFormat(GameTestHelper helper) {
        UUID playerId = UUID.randomUUID();
        UUID questId = UUID.randomUUID();
        FriendlyByteBuf buffer = new FriendlyByteBuf(Unpooled.buffer());
        try {
            OpenGangQuestScreenPacket.encode(new OpenGangQuestScreenPacket(playerId), buffer);
            helper.assertTrue(buffer.readableBytes() == 16, "open quest packet UUID size changed");
            helper.assertTrue(OpenGangQuestScreenPacket.decode(buffer).playerId().equals(playerId),
                    "open quest packet UUID order changed");

            buffer.clear();
            AcceptGangQuestsPacket.encode(new AcceptGangQuestsPacket(questId), buffer);
            helper.assertTrue(buffer.readableBytes() == 16, "accept quest packet UUID size changed");
            helper.assertTrue(AcceptGangQuestsPacket.decode(buffer).questId().equals(questId),
                    "accept quest packet UUID order changed");

            buffer.clear();
            new TreadTheSnowWithoutTracePacket().toBytes(buffer);
            helper.assertTrue(buffer.readableBytes() == 0, "tread-the-snow intent packet gained wire fields");
            new TreadTheSnowWithoutTracePacket(buffer);
        } finally {
            buffer.release();
        }
        helper.succeed();
    }

    private static GangLeader createGangLeader(GameTestHelper helper) {
        GangLeader leader = ChangShengJueEntity.GANG_LEADER.get().create(helper.getLevel());
        helper.assertTrue(leader != null, "gang leader test entity was not created");
        return leader;
    }

    private static ServerPlayer createUnconnectedServerPlayer(GameTestHelper helper, String name) {
        return new ServerPlayer(
                helper.getLevel().getServer(),
                helper.getLevel(),
                new GameProfile(UUID.randomUUID(), name)
        ) {
            @Override
            public boolean isSpectator() {
                return false;
            }

            @Override
            public boolean isCreative() {
                return false;
            }
        };
    }

    private static Quest createMinimalQuest(UUID questId, UUID npcId) {
        CompoundTag tag = new CompoundTag();
        tag.putUUID("QuestId", questId);
        tag.putUUID("QuestNpcId", npcId);
        tag.putString("QuestName", "quest.test.name");
        tag.putString("QuestDescription", "quest.test.description");
        tag.putString("QuestRequirementsDescription", "quest.test.requirements");
        tag.putString("QuestType", Quest.QuestType.KILL.name());
        tag.put("QuestRequirements", new ListTag());
        tag.put("QuestRewards", new ListTag());
        tag.put("Effects", new ListTag());
        tag.put("LimitQuestIds", new ListTag());
        tag.put("ConflictQuestIds", new ListTag());
        return new Quest(tag);
    }

    private static void assertGuardRejectedWithoutMutation(GameTestHelper helper, ServerPlayer player,
                                                            GangLeader leader, GuardAttempt attempt,
                                                            String message) {
        CompoundTag leaderBefore = leader.saveWithoutId(new CompoundTag());
        ListTag inventoryBefore = new ListTag();
        player.getInventory().save(inventoryBefore);
        helper.assertTrue(attempt.get() == null, message);
        helper.assertTrue(leaderBefore.equals(leader.saveWithoutId(new CompoundTag())),
                message + " (NPC state changed)");
        ListTag inventoryAfter = new ListTag();
        player.getInventory().save(inventoryAfter);
        helper.assertTrue(inventoryBefore.equals(inventoryAfter), message + " (inventory changed)");
    }

    @FunctionalInterface
    private interface GuardAttempt {
        AbstractGangLeader get();
    }
}
