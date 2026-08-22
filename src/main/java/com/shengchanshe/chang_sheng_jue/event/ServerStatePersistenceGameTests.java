package com.shengchanshe.chang_sheng_jue.event;

import com.mojang.authlib.GameProfile;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

import java.util.UUID;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class ServerStatePersistenceGameTests {
    private static final String LAST_ATTEMPT = ChangShengJue.MOD_ID + ":last_bandit_attempt_day";
    private static final String NEXT_DAY = ChangShengJue.MOD_ID + ":next_bandit_day";
    private static final String SUMMON_COUNT = ChangShengJue.MOD_ID + ":bandit_summon_count";

    private ServerStatePersistenceGameTests() {
    }

    @GameTest(template = "empty")
    public static void banditStateMigratesIntoClonePersistentData(GameTestHelper helper) {
        ServerPlayer original = player(helper, "bandit-original");
        CompoundTag legacyRoot = original.getPersistentData();
        legacyRoot.putLong(LAST_ATTEMPT, 17L);
        legacyRoot.putLong(NEXT_DAY, 21L);
        legacyRoot.putInt(SUMMON_COUNT, 2);

        CompoundTag migrated = CSJAdvanceEvent.getBanditData(original);
        helper.assertTrue(migrated.getLong(LAST_ATTEMPT) == 17L,
                "legacy last bandit attempt day was not migrated");
        helper.assertTrue(migrated.getLong(NEXT_DAY) == 21L,
                "legacy next eligible bandit day was not migrated");
        helper.assertTrue(migrated.getInt(SUMMON_COUNT) == 2,
                "legacy bandit summon count was not migrated");
        helper.assertTrue(!legacyRoot.contains(LAST_ATTEMPT)
                        && !legacyRoot.contains(NEXT_DAY)
                        && !legacyRoot.contains(SUMMON_COUNT),
                "legacy root bandit keys were not removed after migration");
        helper.assertTrue(legacyRoot.contains(Player.PERSISTED_NBT_TAG, Tag.TAG_COMPOUND),
                "migrated bandit state was not stored in PlayerPersisted");

        CompoundTag cloneData = legacyRoot.getCompound(Player.PERSISTED_NBT_TAG).copy();
        ServerPlayer clone = player(helper, "bandit-clone");
        clone.getPersistentData().put(Player.PERSISTED_NBT_TAG, cloneData);
        CompoundTag clonedState = CSJAdvanceEvent.getBanditData(clone);
        helper.assertTrue(clonedState.getLong(LAST_ATTEMPT) == 17L
                        && clonedState.getLong(NEXT_DAY) == 21L
                        && clonedState.getInt(SUMMON_COUNT) == 2,
                "bandit state did not survive the Forge clone-data shape");

        CompoundTag secondRead = CSJAdvanceEvent.getBanditData(original);
        helper.assertTrue(secondRead.getLong(LAST_ATTEMPT) == 17L
                        && secondRead.getLong(NEXT_DAY) == 21L
                        && secondRead.getInt(SUMMON_COUNT) == 2,
                "one-time legacy migration changed persisted bandit state on a later read");
        helper.succeed();
    }

    private static ServerPlayer player(GameTestHelper helper, String name) {
        return new ServerPlayer(helper.getLevel().getServer(), helper.getLevel(),
                new GameProfile(UUID.randomUUID(), name));
    }
}
