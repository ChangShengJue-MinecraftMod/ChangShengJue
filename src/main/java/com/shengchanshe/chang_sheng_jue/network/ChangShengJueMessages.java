package com.shengchanshe.chang_sheng_jue.network;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.plaque.UpdatePlaqueTextPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.KilnWorkerSetTradeTypePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem.*;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest.*;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.AcceptGangQuestsPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.OpenGangQuestScreenPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.quest.RefreshQuestScreenPacket;
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
    private static final String PROTOCOL_VERSION = "1.0";
    private static final int UPDATE_PLAQUE_TEXT = 0;
    private static final int TREAD_THE_SNOW_WITHOUT_TRACE = 1;
    private static final int SYNC_KUNG_FU_CAPABILITY = 2;
    private static final int TRIGGER_KUNG_FU_PARTICLE = 3;
    private static final int TRIGGER_KUNG_FU_LEVEL_UP_PARTICLE = 4;
    private static final int IMMORTAL_MIRACLE_PARTICLE = 5;
    private static final int WU_GANG_CUT_GUI_PARTICLE = 6;
    private static final int TREAD_THE_SNOW_PARTICLE = 7;
    private static final int XP_PARTICLE = 8;
    private static final int KILN_WORKER_SET_TRADE_TYPE = 9;
    private static final int ACCEPT_GANG_QUESTS = 10;
    private static final int SYNC_QUEST_DATA = 11;
    private static final int SUBMIT_PLAYER_QUESTS = 12;
    private static final int ABANDON_PLAYER_QUEST = 13;
    private static final int OPEN_GANG_QUEST_SCREEN = 14;
    private static final int OPEN_PLAYER_QUEST_SCREEN = 15;
    private static final int REFRESH_QUEST_SCREEN = 16;
    private static final int REFRESH_PLAYER_QUEST_SCREEN = 17;
    private static final int TAILORING_CRAFT = 18;
    private static final int TAILORING_SYNC_RECIPE = 19;
    private static final int FORGE_CRAFT = 20;
    private static final int FORGE_SYNC_RECIPE = 21;
    private static final int WOODWORKING_BENCH_CRAFT = 22;
    private static final int WOODWORKING_BENCH_SYNC_RECIPE = 23;
    private static final int WOODWORKING_BENCH_SET_AMOUNT = 24;
    private static final int BRICK_KILN_CRAFT = 25;
    private static final int BRICK_KILN_SYNC_RECIPE = 26;
    private static final int BRICK_KILN_SET_AMOUNT = 27;
    private static SimpleChannel INSTANCE;

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(ChangShengJue.MOD_ID, "messages"))
                .networkProtocolVersion(() -> PROTOCOL_VERSION)
                .clientAcceptedVersions(PROTOCOL_VERSION::equals)
                .serverAcceptedVersions(PROTOCOL_VERSION::equals)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(UpdatePlaqueTextPacket.class, UPDATE_PLAQUE_TEXT, NetworkDirection.PLAY_TO_SERVER)
                .decoder(UpdatePlaqueTextPacket::new)
                .encoder(UpdatePlaqueTextPacket::toBytes)
                .consumerMainThread(UpdatePlaqueTextPacket::handle)
                .add();

        //踏雪无痕
        net.messageBuilder(TreadTheSnowWithoutTracePacket.class, TREAD_THE_SNOW_WITHOUT_TRACE, NetworkDirection.PLAY_TO_SERVER)
                .decoder(TreadTheSnowWithoutTracePacket::new)
                .encoder(TreadTheSnowWithoutTracePacket::toBytes)
                .consumerMainThread(TreadTheSnowWithoutTracePacket::handle)
                .add();
        // 武功
        net.messageBuilder(SyncKungFuCapabilityPacket.class, SYNC_KUNG_FU_CAPABILITY, NetworkDirection.PLAY_TO_CLIENT)
                .decoder(SyncKungFuCapabilityPacket::new)
                .encoder(SyncKungFuCapabilityPacket::encode)
                .consumerMainThread(SyncKungFuCapabilityPacket::handle)
                .add();
        //武功粒子
        net.messageBuilder(TriggerKungFuParticlePacket.class, TRIGGER_KUNG_FU_PARTICLE, NetworkDirection.PLAY_TO_CLIENT)
                .decoder(TriggerKungFuParticlePacket::decode)
                .encoder(TriggerKungFuParticlePacket::encode)
                .consumerMainThread(TriggerKungFuParticlePacket::handle)
                .add();
        net.messageBuilder(TriggerKungFuLevelUpParticlePacket.class, TRIGGER_KUNG_FU_LEVEL_UP_PARTICLE, NetworkDirection.PLAY_TO_CLIENT)
                .decoder(TriggerKungFuLevelUpParticlePacket::decode)
                .encoder(TriggerKungFuLevelUpParticlePacket::encode)
                .consumerMainThread(TriggerKungFuLevelUpParticlePacket::handle)
                .add();
        net.messageBuilder(ImmortalMiracleParticlePacket.class, IMMORTAL_MIRACLE_PARTICLE, NetworkDirection.PLAY_TO_CLIENT)
                .decoder(ImmortalMiracleParticlePacket::decode)
                .encoder(ImmortalMiracleParticlePacket::encode)
                .consumerMainThread(ImmortalMiracleParticlePacket::handle)
                .add();
        net.messageBuilder(WuGangCutGuiParticlePacket.class, WU_GANG_CUT_GUI_PARTICLE, NetworkDirection.PLAY_TO_CLIENT)
                .decoder(WuGangCutGuiParticlePacket::decode)
                .encoder(WuGangCutGuiParticlePacket::encode)
                .consumerMainThread(WuGangCutGuiParticlePacket::handle)
                .add();
        net.messageBuilder(TreadTheSnowWithoutTraceParticlePacket.class, TREAD_THE_SNOW_PARTICLE, NetworkDirection.PLAY_TO_CLIENT)
                .decoder(TreadTheSnowWithoutTraceParticlePacket::decode)
                .encoder(TreadTheSnowWithoutTraceParticlePacket::encode)
                .consumerMainThread(TreadTheSnowWithoutTraceParticlePacket::handle)
                .add();
        net.messageBuilder(XpParticlePacket.class, XP_PARTICLE, NetworkDirection.PLAY_TO_CLIENT)
                .decoder(XpParticlePacket::decode)
                .encoder(XpParticlePacket::encode)
                .consumerMainThread(XpParticlePacket::handle)
                .add();
        // 按钮切换交易类型
        net.messageBuilder(KilnWorkerSetTradeTypePacket.class, KILN_WORKER_SET_TRADE_TYPE, NetworkDirection.PLAY_TO_SERVER)
                .decoder(KilnWorkerSetTradeTypePacket::decode)
                .encoder(KilnWorkerSetTradeTypePacket::encode)
                .consumerMainThread( KilnWorkerSetTradeTypePacket::handle)
                .add();
        // 帮派任务按钮
        net.messageBuilder(AcceptGangQuestsPacket.class, ACCEPT_GANG_QUESTS, NetworkDirection.PLAY_TO_SERVER)
                .decoder(AcceptGangQuestsPacket::decode)
                .encoder(AcceptGangQuestsPacket::encode)
                .consumerMainThread(AcceptGangQuestsPacket::handle)
                .add();

        // 服务端→客户端同步包（任务数据下发）
        net.messageBuilder(SyncQuestDataPacket.class, SYNC_QUEST_DATA, NetworkDirection.PLAY_TO_CLIENT)
                .decoder(SyncQuestDataPacket::decode)
                .encoder(SyncQuestDataPacket::encode)
                .consumerMainThread(SyncQuestDataPacket::handle)
                .add();

        // 背包任务按钮
        net.messageBuilder(SubmitPlayerQuestsPacket.class, SUBMIT_PLAYER_QUESTS, NetworkDirection.PLAY_TO_SERVER)
                .decoder(SubmitPlayerQuestsPacket::decode)
                .encoder(SubmitPlayerQuestsPacket::encode)
                .consumerMainThread(SubmitPlayerQuestsPacket::handle)
                .add();
        net.messageBuilder(AbandonPlayerQuestPacket.class, ABANDON_PLAYER_QUEST, NetworkDirection.PLAY_TO_SERVER)
                .decoder(AbandonPlayerQuestPacket::decode)
                .encoder(AbandonPlayerQuestPacket::encode)
                .consumerMainThread(AbandonPlayerQuestPacket::handle)
                .add();

        // 任务UI
        net.messageBuilder(OpenGangQuestScreenPacket.class, OPEN_GANG_QUEST_SCREEN, NetworkDirection.PLAY_TO_SERVER)
                .decoder(OpenGangQuestScreenPacket::decode)
                .encoder(OpenGangQuestScreenPacket::encode)
                .consumerMainThread(OpenGangQuestScreenPacket::handle)
                .add();
        net.messageBuilder(OpenPlayerQuestScreenPacket.class, OPEN_PLAYER_QUEST_SCREEN, NetworkDirection.PLAY_TO_SERVER)
                .decoder(OpenPlayerQuestScreenPacket::decode)
                .encoder(OpenPlayerQuestScreenPacket::encode)
                .consumerMainThread(OpenPlayerQuestScreenPacket::handle)
                .add();

        net.messageBuilder(RefreshQuestScreenPacket.class, REFRESH_QUEST_SCREEN, NetworkDirection.PLAY_TO_CLIENT)
                .decoder(RefreshQuestScreenPacket::decode)
                .encoder(RefreshQuestScreenPacket::encode)
                .consumerMainThread(RefreshQuestScreenPacket::handle)
                .add();
        net.messageBuilder(RefreshPlayerQuestScreenPacket.class, REFRESH_PLAYER_QUEST_SCREEN, NetworkDirection.PLAY_TO_CLIENT)
                .decoder(RefreshPlayerQuestScreenPacket::decode)
                .encoder(RefreshPlayerQuestScreenPacket::encode)
                .consumerMainThread(RefreshPlayerQuestScreenPacket::handle)
                .add();

        net.messageBuilder(TailoringCraftPacket.class, TAILORING_CRAFT, NetworkDirection.PLAY_TO_SERVER)
                .decoder(TailoringCraftPacket::fromBytes)
                .encoder(TailoringCraftPacket::toBytes)
                .consumerMainThread(TailoringCraftPacket::handle)
                .add();

        // 注册配方同步
        net.messageBuilder(TailoringSyncRecipePacket.class, TAILORING_SYNC_RECIPE, NetworkDirection.PLAY_TO_SERVER)
                .decoder(TailoringSyncRecipePacket::fromBytes)
                .encoder(TailoringSyncRecipePacket::toBytes)
                .consumerMainThread(TailoringSyncRecipePacket::handle)
                .add();

        //forgeblock
        net.messageBuilder(ForgeCraftPacket.class, FORGE_CRAFT, NetworkDirection.PLAY_TO_SERVER)
                .decoder(ForgeCraftPacket::fromBytes)
                .encoder(ForgeCraftPacket::toBytes)
                .consumerMainThread(ForgeCraftPacket::handle)
                .add();

        net.messageBuilder(ForgeSyncRecipePacket.class, FORGE_SYNC_RECIPE, NetworkDirection.PLAY_TO_SERVER)
                .decoder(ForgeSyncRecipePacket::fromBytes)
                .encoder(ForgeSyncRecipePacket::toBytes)
                .consumerMainThread(ForgeSyncRecipePacket::handle)
                .add();

        net.messageBuilder(WoodworkingBenchPacket.class, WOODWORKING_BENCH_CRAFT, NetworkDirection.PLAY_TO_SERVER)
                .decoder(WoodworkingBenchPacket::fromBytes)
                .encoder(WoodworkingBenchPacket::toBytes)
                .consumerMainThread(WoodworkingBenchPacket::handle)
                .add();

        net.messageBuilder(WoodworkingBenchSyncRecipePacket.class, WOODWORKING_BENCH_SYNC_RECIPE, NetworkDirection.PLAY_TO_SERVER)
                .decoder(WoodworkingBenchSyncRecipePacket::fromBytes)
                .encoder(WoodworkingBenchSyncRecipePacket::toBytes)
                .consumerMainThread(WoodworkingBenchSyncRecipePacket::handle)
                .add();

        net.messageBuilder(WoodworkingBenchSetAmountPacket.class, WOODWORKING_BENCH_SET_AMOUNT, NetworkDirection.PLAY_TO_SERVER)
                .decoder(WoodworkingBenchSetAmountPacket::new)
                .encoder(WoodworkingBenchSetAmountPacket::toBytes)
                .consumerMainThread(WoodworkingBenchSetAmountPacket::handle)
                .add();

        net.messageBuilder(BrickKilnPacket.class, BRICK_KILN_CRAFT, NetworkDirection.PLAY_TO_SERVER)
                .decoder(BrickKilnPacket::fromBytes)
                .encoder(BrickKilnPacket::toBytes)
                .consumerMainThread(BrickKilnPacket::handle)
                .add();

        net.messageBuilder(BrickKilnSyncRecipePacket.class, BRICK_KILN_SYNC_RECIPE, NetworkDirection.PLAY_TO_SERVER)
                .decoder(BrickKilnSyncRecipePacket::fromBytes)
                .encoder(BrickKilnSyncRecipePacket::toBytes)
                .consumerMainThread(BrickKilnSyncRecipePacket::handle)
                .add();

        net.messageBuilder(BrickKilnSetAmountPacket.class, BRICK_KILN_SET_AMOUNT, NetworkDirection.PLAY_TO_SERVER)
                .decoder(BrickKilnSetAmountPacket::new)
                .encoder(BrickKilnSetAmountPacket::toBytes)
                .consumerMainThread(BrickKilnSetAmountPacket::handle)
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
