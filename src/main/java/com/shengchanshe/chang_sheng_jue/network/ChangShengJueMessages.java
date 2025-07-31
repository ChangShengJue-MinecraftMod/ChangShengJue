package com.shengchanshe.chang_sheng_jue.network;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.plaque.UpdatePlaqueTextPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.cultivation.CultivationPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.cultivation.SpiritDensityLevelPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.ForgeCraftPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.ForgeSyncRecipePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.TailoringCraftPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.TailoringSyncRecipePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.KilnWorkerSetTradeTypePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest.*;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.*;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.SyncKungFuCapabilityPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu.*;
import com.shengchanshe.chang_sheng_jue.network.packet.particle.xiu_xian.TriggerBreakthroughParticlePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.particle.xiu_xian.TriggerTunNaParticlePacket;
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
        net.messageBuilder(SubmitGangQuestsPacket.class, id())
                .decoder(SubmitGangQuestsPacket::decode)
                .encoder(SubmitGangQuestsPacket::encode)
                .consumerMainThread(SubmitGangQuestsPacket::handle)
                .add();
        net.messageBuilder(AbandonGangQuestPacket.class, id())
                .decoder(AbandonGangQuestPacket::decode)
                .encoder(AbandonGangQuestPacket::encode)
                .consumerMainThread(AbandonGangQuestPacket::handle)
                .add();
        net.messageBuilder(RefreshGangQuestPacket.class, id())
                .decoder(RefreshGangQuestPacket::decode)
                .encoder(RefreshGangQuestPacket::encode)
                .consumerMainThread(RefreshGangQuestPacket::handle)
                .add();

        // 1. 服务端→客户端同步包（任务数据下发）
        net.messageBuilder(SyncQuestDataPacket.class, id())
                .decoder(SyncQuestDataPacket::decode)
                .encoder(SyncQuestDataPacket::encode)
                .consumerMainThread(SyncQuestDataPacket::handle)
                .add();

        // 2. 客户端→服务端请求包（数据请求）
        net.messageBuilder(RequestQuestsPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(RequestQuestsPacket::new)
                .encoder(RequestQuestsPacket::encode)
                .consumerMainThread(RequestQuestsPacket::handle)
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

        //修仙
        net.messageBuilder(CultivationPacket.class, id())
                .decoder(CultivationPacket::decode)
                .encoder(CultivationPacket::encode)
                .consumerMainThread(CultivationPacket::handle)
                .add();
        net.messageBuilder(SpiritDensityLevelPacket.class, id())
                .decoder(SpiritDensityLevelPacket::decode)
                .encoder(SpiritDensityLevelPacket::encode)
                .consumerMainThread(SpiritDensityLevelPacket::handle)
                .add();

        net.messageBuilder(TriggerTunNaParticlePacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(TriggerTunNaParticlePacket::decode)
                .encoder(TriggerTunNaParticlePacket::encode)
                .consumerMainThread(TriggerTunNaParticlePacket::handle)
                .add();

        net.messageBuilder(TriggerBreakthroughParticlePacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(TriggerBreakthroughParticlePacket::decode)
                .encoder(TriggerBreakthroughParticlePacket::encode)
                .consumerMainThread(TriggerBreakthroughParticlePacket::handle)
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
