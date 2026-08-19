package com.shengchanshe.chang_sheng_jue.gametest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.custom.plaque.Plaque;
import com.shengchanshe.chang_sheng_jue.block.custom.plaque.PlaqueEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.plaque.PlaqueTextLayout;
import com.shengchanshe.chang_sheng_jue.event.quest.PlayerQuestEvent;
import com.shengchanshe.chang_sheng_jue.event.quest.QuestEvent;
import com.shengchanshe.chang_sheng_jue.network.ServerPacketGuard;
import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

import java.util.UUID;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class QuestAndPlaqueGameTests {
    private QuestAndPlaqueGameTests() {
    }

    @GameTest(template = "empty")
    public static void questMessagesRemainClientLocalizable(GameTestHelper helper) {
        Component questName = PlayerQuestEvent.getColoredTranslation(
                "quest.chang_sheng_jue.kill.zombie.questName");
        Component trigger = PlayerQuestEvent.getColoredTranslation(
                "quest.chang_sheng_jue.trigger", questName);
        Component finish = QuestEvent.getColoredTranslation(
                "quest.chang_sheng_jue.finish", questName);

        helper.assertTrue(questName.getContents() instanceof TranslatableContents,
                "quest name was resolved to a server-side literal");
        helper.assertTrue(trigger.getContents() instanceof TranslatableContents,
                "quest trigger was resolved to a server-side literal");
        helper.assertTrue(finish.getContents() instanceof TranslatableContents,
                "quest completion was resolved to a server-side literal");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void plaqueCapacityTracksConnectedSameFacingSegment(GameTestHelper helper) {
        BlockPos west = new BlockPos(1, 1, 1);
        BlockPos middle = new BlockPos(2, 1, 1);
        BlockPos east = new BlockPos(3, 1, 1);
        BlockPos differentFacing = new BlockPos(4, 1, 1);
        BlockState northPlaque = ChangShengJueBlocks.PLAQUE.get().defaultBlockState()
                .setValue(Plaque.FACING, Direction.NORTH);
        BlockState eastPlaque = ChangShengJueBlocks.PLAQUE.get().defaultBlockState()
                .setValue(Plaque.FACING, Direction.EAST);

        helper.setBlock(west, northPlaque);
        helper.setBlock(middle, northPlaque);
        helper.setBlock(east, northPlaque);
        helper.setBlock(differentFacing, eastPlaque);

        BlockPos absoluteMiddle = helper.absolutePos(middle);
        helper.assertTrue(PlaqueTextLayout.getCapacity(helper.getLevel(), absoluteMiddle) == 3,
                "same-facing three-block segment must allow three characters");
        helper.assertTrue(PlaqueTextLayout.getCapacity(helper.getLevel(), helper.absolutePos(west)) == 3,
                "left endpoint did not discover the full segment");
        helper.assertTrue(PlaqueTextLayout.getCapacity(helper.getLevel(), helper.absolutePos(east)) == 3,
                "right endpoint did not discover the full segment");
        helper.assertTrue(PlaqueTextLayout.write(helper.getLevel(), absoluteMiddle, "天地人"),
                "valid segment text was rejected");
        helper.assertTrue("天地人".equals(PlaqueTextLayout.read(helper.getLevel(), absoluteMiddle)),
                "reading the segment did not preserve visual left-to-right order");

        assertPlaqueText(helper, east, "天");
        assertPlaqueText(helper, middle, "地");
        assertPlaqueText(helper, west, "人");
        assertPlaqueText(helper, differentFacing, "");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void plaqueSouthFacingSegmentUsesEveryEntryPoint(GameTestHelper helper) {
        assertDirectionalSegment(helper, Direction.SOUTH);
    }

    @GameTest(template = "empty")
    public static void plaqueEastFacingSegmentUsesEveryEntryPoint(GameTestHelper helper) {
        assertDirectionalSegment(helper, Direction.EAST);
    }

    @GameTest(template = "empty")
    public static void plaqueWestFacingSegmentUsesEveryEntryPoint(GameTestHelper helper) {
        assertDirectionalSegment(helper, Direction.WEST);
    }

    @GameTest(template = "empty")
    public static void plaqueWritesAreRateLimitedPerPlayer(GameTestHelper helper) {
        ServerPlayer player = new ServerPlayer(
                helper.getLevel().getServer(), helper.getLevel(),
                new GameProfile(UUID.randomUUID(), "plaque-rate-limit")) {
            @Override
            public boolean isSpectator() {
                return false;
            }

            @Override
            public boolean isCreative() {
                return true;
            }
        };

        helper.assertTrue(ServerPacketGuard.allowPlaqueWrite(player),
                "first plaque write should be accepted");
        helper.assertTrue(!ServerPacketGuard.allowPlaqueWrite(player),
                "repeated plaque write in the cooldown window should be rejected");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void plaqueRejectsTextBeyondCurrentSegmentWithoutMutation(GameTestHelper helper) {
        BlockPos first = new BlockPos(1, 1, 1);
        BlockPos second = new BlockPos(2, 1, 1);
        BlockState plaque = ChangShengJueBlocks.PLAQUE.get().defaultBlockState()
                .setValue(Plaque.FACING, Direction.NORTH);
        helper.setBlock(first, plaque);
        helper.setBlock(second, plaque);

        BlockPos absoluteFirst = helper.absolutePos(first);
        helper.assertTrue(PlaqueTextLayout.write(helper.getLevel(), absoluteFirst, "甲乙"),
                "valid two-character text was rejected");
        helper.assertTrue(!PlaqueTextLayout.write(helper.getLevel(), absoluteFirst, "甲乙丙"),
                "text longer than the current segment was accepted");
        helper.assertTrue("甲乙".equals(PlaqueTextLayout.read(helper.getLevel(), absoluteFirst)),
                "rejected text mutated the plaque segment");

        helper.assertTrue(PlaqueTextLayout.write(helper.getLevel(), absoluteFirst, "甲"),
                "shortening segment text was rejected");
        helper.assertTrue("甲".equals(PlaqueTextLayout.read(helper.getLevel(), absoluteFirst)),
                "shortened text was not stored");
        assertPlaqueText(helper, first, "");
        helper.succeed();
    }

    private static void assertPlaqueText(GameTestHelper helper, BlockPos relativePos, String expected) {
        if (!(helper.getLevel().getBlockEntity(helper.absolutePos(relativePos)) instanceof PlaqueEntity plaque)) {
            helper.fail("missing plaque block entity at " + relativePos);
            return;
        }
        helper.assertTrue(expected.equals(plaque.getText()),
                "unexpected plaque text at " + relativePos + ": " + plaque.getText());
    }

    private static void assertDirectionalSegment(GameTestHelper helper, Direction facing) {
        Plaque plaque = (Plaque) ChangShengJueBlocks.PLAQUE.get();
        BlockPos origin = new BlockPos(2, 1, 2);
        BlockPos left = origin.relative(plaque.leftOf(facing));
        BlockPos right = origin.relative(plaque.rightOf(facing));
        BlockState state = plaque.defaultBlockState().setValue(Plaque.FACING, facing);
        helper.setBlock(left, state);
        helper.setBlock(origin, state);
        helper.setBlock(right, state);

        for (BlockPos entry : new BlockPos[]{left, origin, right}) {
            helper.assertTrue(PlaqueTextLayout.getCapacity(helper.getLevel(), helper.absolutePos(entry)) == 3,
                    facing + " segment was not discovered from " + entry);
        }
        helper.assertTrue(PlaqueTextLayout.write(helper.getLevel(), helper.absolutePos(right), "甲乙丙"),
                facing + " segment rejected a valid write from its endpoint");
        helper.assertTrue("甲乙丙".equals(PlaqueTextLayout.read(helper.getLevel(), helper.absolutePos(left))),
                facing + " segment order changed between entry points");
        helper.succeed();
    }
}
