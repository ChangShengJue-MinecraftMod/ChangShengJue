package com.shengchanshe.chang_sheng_jue.network;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.plaque.UpdatePlaqueTextPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.KilnWorkerSetTradeTypePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.*;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest.*;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.AcceptGangQuestsPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.OpenGangQuestScreenPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.RefreshQuestScreenPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.checkin.CheckInPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.checkin.SyncCheckInDataPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.SyncKungFuCapabilityPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.server.ServerLifecycleHooks;

public class ChangShengJueMessages {
    private static SimpleChannel INSTANCE;
    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(ChangShengJue.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(UpdatePlaqueTextPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(UpdatePlaqueTextPacket::new)
                .encoder(UpdatePlaqueTextPacket::toBytes)
                .consumerMainThread(UpdatePlaqueTextPacket::handle)
                .add();

        //踏雪无痕
        net.messageBuilder(TreadTheSnowWithoutTracePacket.class, id())
                .decoder(TreadTheSnowWithoutTracePacket::new)
                .encoder(TreadTheSnowWithoutTracePacket::toBytes)
                .consumerMainThread(TreadTheSnowWithoutTracePacket::handle)
                .add();
        // 武功
        net.messageBuilder(SyncKungFuCapabilityPacket.class, id())
                .decoder(SyncKungFuCapabilityPacket::new)
                .encoder(SyncKungFuCapabilityPacket::encode)
                .consumerMainThread(SyncKungFuCapabilityPacket::handle)
                .add();
        //武功粒子
        net.messageBuilder(TriggerKungFuParticlePacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(TriggerKungFuParticlePacket::decode)
                .encoder(TriggerKungFuParticlePacket::encode)
                .consumerMainThread(TriggerKungFuParticlePacket::handle)
                .add();
        net.messageBuilder(TriggerKungFuLevelUpParticlePacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(TriggerKungFuLevelUpParticlePacket::decode)
                .encoder(TriggerKungFuLevelUpParticlePacket::encode)
                .consumerMainThread(TriggerKungFuLevelUpParticlePacket::handle)
                .add();
        net.messageBuilder(ImmortalMiracleParticlePacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(ImmortalMiracleParticlePacket::decode)
                .encoder(ImmortalMiracleParticlePacket::encode)
                .consumerMainThread(ImmortalMiracleParticlePacket::handle)
                .add();
        net.messageBuilder(WuGangCutGuiParticlePacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(WuGangCutGuiParticlePacket::decode)
                .encoder(WuGangCutGuiParticlePacket::encode)
                .consumerMainThread(WuGangCutGuiParticlePacket::handle)
                .add();
        net.messageBuilder(TreadTheSnowWithoutTraceParticlePacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(TreadTheSnowWithoutTraceParticlePacket::decode)
                .encoder(TreadTheSnowWithoutTraceParticlePacket::encode)
                .consumerMainThread(TreadTheSnowWithoutTraceParticlePacket::handle)
                .add();
        net.messageBuilder(XpParticlePacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(XpParticlePacket::decode)
                .encoder(XpParticlePacket::encode)
                .consumerMainThread(XpParticlePacket::handle)
                .add();
        // 按钮切换交易类型
        net.messageBuilder(KilnWorkerSetTradeTypePacket.class, id())
                .decoder(KilnWorkerSetTradeTypePacket::decode)
                .encoder(KilnWorkerSetTradeTypePacket::encode)
                .consumerMainThread( KilnWorkerSetTradeTypePacket::handle)
                .add();
        // 帮派任务按钮
        net.messageBuilder(AcceptGangQuestsPacket.class, id())
                .decoder(AcceptGangQuestsPacket::decode)
                .encoder(AcceptGangQuestsPacket::encode)
                .consumerMainThread(AcceptGangQuestsPacket::handle)
                .add();

        // 服务端→客户端同步包（任务数据下发）
        net.messageBuilder(SyncQuestDataPacket.class, id())
                .decoder(SyncQuestDataPacket::decode)
                .encoder(SyncQuestDataPacket::encode)
                .consumerMainThread(SyncQuestDataPacket::handle)
                .add();

        // 背包任务按钮
        net.messageBuilder(SubmitPlayerQuestsPacket.class, id())
                .decoder(SubmitPlayerQuestsPacket::decode)
                .encoder(SubmitPlayerQuestsPacket::encode)
                .consumerMainThread(SubmitPlayerQuestsPacket::handle)
                .add();
        net.messageBuilder(AbandonPlayerQuestPacket.class, id())
                .decoder(AbandonPlayerQuestPacket::decode)
                .encoder(AbandonPlayerQuestPacket::encode)
                .consumerMainThread(AbandonPlayerQuestPacket::handle)
                .add();

        // 任务UI
        net.messageBuilder(OpenGangQuestScreenPacket.class, id())
                .decoder(OpenGangQuestScreenPacket::decode)
                .encoder(OpenGangQuestScreenPacket::encode)
                .consumerMainThread(OpenGangQuestScreenPacket::handle)
                .add();
        net.messageBuilder(OpenPlayerQuestScreenPacket.class, id())
                .decoder(OpenPlayerQuestScreenPacket::decode)
                .encoder(OpenPlayerQuestScreenPacket::encode)
                .consumerMainThread(OpenPlayerQuestScreenPacket::handle)
                .add();

        net.messageBuilder(RefreshQuestScreenPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(RefreshQuestScreenPacket::decode)
                .encoder(RefreshQuestScreenPacket::encode)
                .consumerMainThread(RefreshQuestScreenPacket::handle)
                .add();
        net.messageBuilder(RefreshPlayerQuestScreenPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(RefreshPlayerQuestScreenPacket::decode)
                .encoder(RefreshPlayerQuestScreenPacket::encode)
                .consumerMainThread(RefreshPlayerQuestScreenPacket::handle)
                .add();

        net.messageBuilder(TailoringCraftPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(TailoringCraftPacket::fromBytes)
                .encoder(TailoringCraftPacket::toBytes)
                .consumerMainThread(TailoringCraftPacket::handle)
                .add();

        // 注册配方同步
        net.messageBuilder(TailoringSyncRecipePacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(TailoringSyncRecipePacket::fromBytes)
                .encoder(TailoringSyncRecipePacket::toBytes)
                .consumerMainThread(TailoringSyncRecipePacket::handle)
                .add();

        //forgeblock
        net.messageBuilder(ForgeCraftPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(ForgeCraftPacket::fromBytes)
                .encoder(ForgeCraftPacket::toBytes)
                .consumerMainThread(ForgeCraftPacket::handle)
                .add();

        net.messageBuilder(ForgeSyncRecipePacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(ForgeSyncRecipePacket::fromBytes)
                .encoder(ForgeSyncRecipePacket::toBytes)
                .consumerMainThread(ForgeSyncRecipePacket::handle)
                .add();

        net.messageBuilder(WoodworkingBenchPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(WoodworkingBenchPacket::fromBytes)
                .encoder(WoodworkingBenchPacket::toBytes)
                .consumerMainThread(WoodworkingBenchPacket::handle)
                .add();

        net.messageBuilder(WoodworkingBenchSyncRecipePacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(WoodworkingBenchSyncRecipePacket::fromBytes)
                .encoder(WoodworkingBenchSyncRecipePacket::toBytes)
                .consumerMainThread(WoodworkingBenchSyncRecipePacket::handle)
                .add();

        net.messageBuilder(WoodworkingBenchSetAmountPacket.class, id())
                .decoder(WoodworkingBenchSetAmountPacket::new)
                .encoder(WoodworkingBenchSetAmountPacket::toBytes)
                .consumerMainThread(WoodworkingBenchSetAmountPacket::handle)
                .add();

        net.messageBuilder(BrickKilnPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(BrickKilnPacket::fromBytes)
                .encoder(BrickKilnPacket::toBytes)
                .consumerMainThread(BrickKilnPacket::handle)
                .add();

        net.messageBuilder(BrickKilnSyncRecipePacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(BrickKilnSyncRecipePacket::fromBytes)
                .encoder(BrickKilnSyncRecipePacket::toBytes)
                .consumerMainThread(BrickKilnSyncRecipePacket::handle)
                .add();

        net.messageBuilder(BrickKilnSetAmountPacket.class, id())
                .decoder(BrickKilnSetAmountPacket::new)
                .encoder(BrickKilnSetAmountPacket::toBytes)
                .consumerMainThread(BrickKilnSetAmountPacket::handle)
                .add();

        // 签到系统
        net.messageBuilder(CheckInPacket.class, id())
                .decoder(CheckInPacket::decode)
                .encoder(CheckInPacket::encode)
                .consumerMainThread(CheckInPacket::handle)
                .add();

        net.messageBuilder(SyncCheckInDataPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(SyncCheckInDataPacket::decode)
                .encoder(SyncCheckInDataPacket::encode)
                .consumerMainThread(SyncCheckInDataPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }
    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
    public static <MSG> void sendToClients(MSG message) {
        INSTANCE.send(PacketDistributor.ALL.noArg(), message);
    }

    public static <MSG> void sendMSGToAll(MSG message) {
        for (ServerPlayer player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()) {
            sendNonLocal(message, player);
        }
    }

    public static <MSG> void sendNonLocal(MSG msg, ServerPlayer player) {
        INSTANCE.sendTo(msg, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }

}
