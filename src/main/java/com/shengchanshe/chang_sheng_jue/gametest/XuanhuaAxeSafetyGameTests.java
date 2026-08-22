package com.shengchanshe.chang_sheng_jue.gametest;

import com.mojang.authlib.GameProfile;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.tool.XuanhuaAxe;
import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class XuanhuaAxeSafetyGameTests {
    private XuanhuaAxeSafetyGameTests() {
    }

    @GameTest(template = "empty")
    public static void sixtyFourConnectedLogsAreAllChopped(GameTestHelper helper) {
        List<BlockPos> logs = placeConnectedLogs(helper, 64);
        ItemStack axe = new ItemStack(ChangShengJueItems.XUANHUA_AXE.get());
        ServerPlayer player = player(helper, false);

        int chopped = invokeChopTree(helper, logs.get(0), axe, player);

        helper.assertTrue(chopped == 64, "expected all 64 connected logs to be chopped, got " + chopped);
        helper.assertTrue(countLogs(helper, logs) == 0, "a tree within the safety budget must be fully chopped");
        helper.assertTrue(axe.getDamageValue() == 64, "survival durability must be charged once per chopped log");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void sixtyFiveConnectedLogsStopAtSafetyBudget(GameTestHelper helper) {
        List<BlockPos> logs = placeConnectedLogs(helper, 65);
        ItemStack axe = new ItemStack(ChangShengJueItems.XUANHUA_AXE.get());
        ServerPlayer player = player(helper, false);

        int chopped = invokeChopTree(helper, logs.get(0), axe, player);

        helper.assertTrue(chopped == 64, "a single use must chop exactly 64 of 65 connected logs");
        helper.assertTrue(countLogs(helper, logs) == 1, "the 65th connected log must remain in the world");
        helper.assertTrue(axe.getDamageValue() == 64, "the budgeted use must consume exactly 64 durability");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void lastDurabilityChopsLastAffordableLogThenStops(GameTestHelper helper) {
        List<BlockPos> logs = placeConnectedLogs(helper, 5);
        ItemStack axe = new ItemStack(ChangShengJueItems.XUANHUA_AXE.get());
        axe.setDamageValue(axe.getMaxDamage() - 3);
        ServerPlayer player = player(helper, false);

        int chopped = invokeChopTree(helper, logs.get(0), axe, player);

        helper.assertTrue(chopped == 3, "three remaining durability must afford exactly three logs");
        helper.assertTrue(countLogs(helper, logs) == 2, "chopping must stop as soon as the tool breaks");
        helper.assertTrue(axe.isEmpty(), "the final affordable log must consume the last durability point");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void creativeUseStillStopsAtSafetyBudgetWithoutDamage(GameTestHelper helper) {
        List<BlockPos> logs = placeConnectedLogs(helper, 65);
        ItemStack axe = new ItemStack(ChangShengJueItems.XUANHUA_AXE.get());
        ServerPlayer player = player(helper, true);

        int chopped = invokeChopTree(helper, logs.get(0), axe, player);

        helper.assertTrue(chopped == 64, "creative use must still stop at the 64-log safety budget");
        helper.assertTrue(countLogs(helper, logs) == 1, "creative use must leave the 65th log intact");
        helper.assertTrue(axe.getDamageValue() == 0, "creative use must not consume durability");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void malformedBonusDurabilityCannotOverflowMaxDamage(GameTestHelper helper) {
        ItemStack axe = new ItemStack(ChangShengJueItems.XUANHUA_AXE.get());
        int baseDurability = axe.getMaxDamage();
        axe.getOrCreateTag().putInt("xuanhuaAxeMaxDamage", Integer.MAX_VALUE);
        helper.assertTrue(axe.getMaxDamage() == baseDurability + 1_000_000,
                "oversized bonus durability was not clamped safely");
        invokeIncreaseBonus(axe, 1);
        helper.assertTrue(axe.getOrCreateTag().getInt("xuanhuaAxeMaxDamage") == 1_000_000,
                "bonus durability write overflowed its persisted upper bound");
        axe.getOrCreateTag().putInt("xuanhuaAxeMaxDamage", Integer.MIN_VALUE);
        invokeIncreaseBonus(axe, 1);
        helper.assertTrue(axe.getMaxDamage() == baseDurability + 1,
                "negative bonus durability was not sanitized before its next write");
        helper.succeed();
    }

    private static List<BlockPos> placeConnectedLogs(GameTestHelper helper, int count) {
        List<BlockPos> logs = new ArrayList<>(count);
        for (int y = 1; y <= 4 && logs.size() < count; y++) {
            for (int z = 0; z < 4 && logs.size() < count; z++) {
                for (int x = 0; x < 5 && logs.size() < count; x++) {
                    BlockPos relativePos = new BlockPos(x, y, z);
                    helper.setBlock(relativePos, Blocks.OAK_LOG);
                    logs.add(helper.absolutePos(relativePos));
                }
            }
        }
        helper.assertTrue(logs.size() == count, "test fixture did not create the requested connected logs");
        return logs;
    }

    private static int countLogs(GameTestHelper helper, List<BlockPos> positions) {
        return (int) positions.stream()
                .filter(pos -> helper.getLevel().getBlockState(pos).is(Blocks.OAK_LOG))
                .count();
    }

    private static int invokeChopTree(GameTestHelper helper, BlockPos start, ItemStack axe, Player player) {
        try {
            Method chopTree = XuanhuaAxe.class.getDeclaredMethod(
                    "chopTree", ServerLevel.class, BlockPos.class, BlockPos.class, ItemStack.class, Player.class);
            chopTree.setAccessible(true);
            return (int) chopTree.invoke(null, helper.getLevel(), start, start, axe, player);
        } catch (NoSuchMethodException | IllegalAccessException exception) {
            throw new IllegalStateException("unable to access Xuanhua axe safety traversal", exception);
        } catch (InvocationTargetException exception) {
            throw new IllegalStateException("Xuanhua axe safety traversal failed", exception.getCause());
        }
    }

    private static void invokeIncreaseBonus(ItemStack axe, int amount) {
        try {
            Method increase = XuanhuaAxe.class.getDeclaredMethod("increaseBonusDurability", ItemStack.class, int.class);
            increase.setAccessible(true);
            increase.invoke(null, axe, amount);
        } catch (NoSuchMethodException | IllegalAccessException exception) {
            throw new IllegalStateException("unable to access Xuanhua bonus durability write", exception);
        } catch (InvocationTargetException exception) {
            throw new IllegalStateException("Xuanhua bonus durability write failed", exception.getCause());
        }
    }

    private static ServerPlayer player(GameTestHelper helper, boolean creative) {
        return new ServerPlayer(helper.getLevel().getServer(), helper.getLevel(),
                new GameProfile(UUID.randomUUID(), creative ? "xuanhua-creative" : "xuanhua-survival")) {
            @Override
            public boolean isSpectator() {
                return false;
            }

            @Override
            public boolean isCreative() {
                return creative;
            }
        };
    }
}
