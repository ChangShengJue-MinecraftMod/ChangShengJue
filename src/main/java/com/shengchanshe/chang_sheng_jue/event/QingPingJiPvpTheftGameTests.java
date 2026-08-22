package com.shengchanshe.chang_sheng_jue.event;

import com.mojang.authlib.GameProfile;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.capability.kungfu.IKungFuCapability;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu.QingPingJi;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

import java.util.UUID;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class QingPingJiPvpTheftGameTests {
    private QingPingJiPvpTheftGameTests() {
    }

    @GameTest(template = "empty")
    public static void pvpTheftRequiresActiveComprehendedQingPingJi(GameTestHelper helper) {
        ServerPlayer player = new ServerPlayer(
                helper.getLevel().getServer(),
                helper.getLevel(),
                new GameProfile(UUID.randomUUID(), "qingping-theft")
        );
        helper.assertTrue(!CSJEvent.canTriggerQingPingJiTheft(player),
                "an unlearned player was allowed to trigger Qing Ping Ji theft");

        IKungFuCapability capability = player.getCapability(ChangShengJueCapabiliy.KUNGFU)
                .resolve().orElse(null);
        helper.assertTrue(capability != null, "the test player did not receive the kung fu capability");

        QingPingJi qingPingJi = new QingPingJi();
        CompoundTag learnedState = qingPingJi.serializeNBT();
        learnedState.putBoolean("KungFuIsComprehend", true);
        learnedState.putBoolean("KungFuIsStart", true);
        learnedState.putInt("KungFuLevel", 1);
        ListTag learnedKungFu = new ListTag();
        learnedKungFu.add(learnedState);
        CompoundTag capabilityState = new CompoundTag();
        capabilityState.put("LearnedKungFu", learnedKungFu);
        capability.deserializeNBT(capabilityState);

        helper.assertTrue(CSJEvent.canTriggerQingPingJiTheft(player),
                "an active, comprehended Qing Ping Ji could not trigger its theft effect");
        QingPingJi loaded = QingPingJi.getKungFu(player);
        helper.assertTrue(loaded != null, "the Qing Ping Ji test state was not loaded");
        loaded.startKungFu(false);
        helper.assertTrue(!CSJEvent.canTriggerQingPingJiTheft(player),
                "a stopped Qing Ping Ji was allowed to trigger theft");
        helper.succeed();
    }
}
