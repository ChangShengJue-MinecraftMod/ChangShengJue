package com.shengchanshe.changshengjue.network;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.gui.screens.plaque.UpdatePlaqueTextPacket;
import com.shengchanshe.changshengjue.network.packet.effect.EffectEntityPacket;
import com.shengchanshe.changshengjue.network.packet.gui.KilnWorkerSetTradeTypePacket;
import com.shengchanshe.changshengjue.network.packet.gui.playerquest.*;
import com.shengchanshe.changshengjue.network.packet.gui.quest.*;
import com.shengchanshe.changshengjue.network.packet.martial_arts.*;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu.GeShanDaNiuPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar.GoldenBellJarPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.hercules.HerculesPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.immortal_miracle.ImmortalMiraclePacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.sunflower_point_caveman.SunflowerPointCavemanPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket2;
import com.shengchanshe.changshengjue.network.packet.martial_arts.turtle_breath_work.TurtleBreathWorkPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.wu_gang_cut_gui.WuGangCutGuiPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.wu_gang_cut_gui.WuGangCutGuiPacket1;
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


        //独孤九剑
        net.messageBuilder(DuguNineSwordsPacket.class, id())
                .decoder(DuguNineSwordsPacket::new)
                .encoder(DuguNineSwordsPacket::toBytes)
                .consumerMainThread(DuguNineSwordsPacket::handle)
                .add();
        //金乌刀法
        net.messageBuilder(GoldenBlackKnifeMethodPacket.class, id())
                .decoder(GoldenBlackKnifeMethodPacket::new)
                .encoder(GoldenBlackKnifeMethodPacket::toBytes)
                .consumerMainThread(GoldenBlackKnifeMethodPacket::handle)
                .add();
        //玄女剑法
        net.messageBuilder(XuannuSwordsmanshipPacket.class, id())
                .decoder(XuannuSwordsmanshipPacket::new)
                .encoder(XuannuSwordsmanshipPacket::toBytes)
                .consumerMainThread(XuannuSwordsmanshipPacket::handle)
                .add();
        //高家枪法
        net.messageBuilder(GaoMarksmanshipPacket.class, id())
                .decoder(GaoMarksmanshipPacket::new)
                .encoder(GaoMarksmanshipPacket::toBytes)
                .consumerMainThread(GaoMarksmanshipPacket::handle)
                .add();
        //少林棍法
        net.messageBuilder(ShaolinStickMethodPacket.class, id())
                .decoder(ShaolinStickMethodPacket::new)
                .encoder(ShaolinStickMethodPacket::toBytes)
                .consumerMainThread(ShaolinStickMethodPacket::handle)
                .add();
        //踏雪无痕
        net.messageBuilder(TreadTheSnowWithoutTracePacket.class, id())
                .decoder(TreadTheSnowWithoutTracePacket::new)
                .encoder(TreadTheSnowWithoutTracePacket::toBytes)
                .consumerMainThread(TreadTheSnowWithoutTracePacket::handle)
                .add();
        net.messageBuilder(TreadTheSnowWithoutTracePacket2.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(TreadTheSnowWithoutTracePacket2::new)
                .encoder(TreadTheSnowWithoutTracePacket2::toBytes)
                .consumerMainThread(TreadTheSnowWithoutTracePacket2::handle)
                .add();
        //葵花点穴手
        net.messageBuilder(SunflowerPointCavemanPacket.class, id())
                .decoder(SunflowerPointCavemanPacket::new)
                .encoder(SunflowerPointCavemanPacket::toBytes)
                .consumerMainThread(SunflowerPointCavemanPacket::handle)
                .add();
//        net.messageBuilder(EffectEntityPacket.class, id())
//                .decoder(EffectEntityPacket::new)
//                .encoder(EffectEntityPacket::toBytes)
//                .consumerMainThread(EffectEntityPacket::handle)
//                .add();
        //金钟罩
        net.messageBuilder(GoldenBellJarPacket.class, id())
                .decoder(GoldenBellJarPacket::new)
                .encoder(GoldenBellJarPacket::toBytes)
                .consumerMainThread(GoldenBellJarPacket::handle)
                .add();
//        net.messageBuilder(GoldenBellJarPacketKey.class, id(),NetworkDirection.PLAY_TO_SERVER)
//                .decoder(GoldenBellJarPacketKey::new)
//                .encoder(GoldenBellJarPacketKey::toBytes)
//                .consumerMainThread(GoldenBellJarPacketKey::handle)
//                .add();
        //不死神功
        net.messageBuilder(ImmortalMiraclePacket.class, id())
                .decoder(ImmortalMiraclePacket::new)
                .encoder(ImmortalMiraclePacket::toBytes)
                .consumerMainThread(ImmortalMiraclePacket::handle)
                .add();
        //隔山打牛
        net.messageBuilder(GeShanDaNiuPacket.class, id())
                .decoder(GeShanDaNiuPacket::new)
                .encoder(GeShanDaNiuPacket::toBytes)
                .consumerMainThread(GeShanDaNiuPacket::handle)
                .add();
        //麦块百科
        net.messageBuilder(WheatNuggetEncyclopediaPacket.class, id())
                .decoder(WheatNuggetEncyclopediaPacket::new)
                .encoder(WheatNuggetEncyclopediaPacket::toBytes)
                .consumerMainThread(WheatNuggetEncyclopediaPacket::handle)
                .add();
        //龟息功
        net.messageBuilder(TurtleBreathWorkPacket.class, id())
                .decoder(TurtleBreathWorkPacket::new)
                .encoder(TurtleBreathWorkPacket::toBytes)
                .consumerMainThread(TurtleBreathWorkPacket::handle)
                .add();
        //无情飞刀
        net.messageBuilder(RelentlessThrowingKnivesPacket.class, id())
                .decoder(RelentlessThrowingKnivesPacket::new)
                .encoder(RelentlessThrowingKnivesPacket::toBytes)
                .consumerMainThread(RelentlessThrowingKnivesPacket::handle)
                .add();
        //吴刚伐桂
        net.messageBuilder(WuGangCutGuiPacket.class, id())
                .decoder(WuGangCutGuiPacket::new)
                .encoder(WuGangCutGuiPacket::toBytes)
                .consumerMainThread(WuGangCutGuiPacket::handle)
                .add();
        net.messageBuilder(WuGangCutGuiPacket1.class, id())
                .decoder(WuGangCutGuiPacket1::new)
                .encoder(WuGangCutGuiPacket1::toBytes)
                .consumerMainThread(WuGangCutGuiPacket1::handle)
                .add();
        //庖丁解牛
        net.messageBuilder(PaodingPacket.class, id())
                .decoder(PaodingPacket::new)
                .encoder(PaodingPacket::toBytes)
                .consumerMainThread(PaodingPacket::handle)
                .add();
        //愚公移山
        net.messageBuilder(YugongMovesMountainsPacket.class, id())
                .decoder(YugongMovesMountainsPacket::new)
                .encoder(YugongMovesMountainsPacket::toBytes)
                .consumerMainThread(YugongMovesMountainsPacket::handle)
                .add();
        //易筋经
        net.messageBuilder(TheClassicsOfTendonChangingPacket.class, id())
                .decoder(TheClassicsOfTendonChangingPacket::new)
                .encoder(TheClassicsOfTendonChangingPacket::toBytes)
                .consumerMainThread(TheClassicsOfTendonChangingPacket::handle)
                .add();
        //乾坤大挪移
        net.messageBuilder(QianKunDaNuoYiPacket.class, id())
                .decoder(QianKunDaNuoYiPacket::new)
                .encoder(QianKunDaNuoYiPacket::toBytes)
                .consumerMainThread(QianKunDaNuoYiPacket::handle)
                .add();
        //大力神功
        net.messageBuilder(HerculesPacket.class, id())
                .decoder(HerculesPacket::new)
                .encoder(HerculesPacket::toBytes)
                .consumerMainThread(HerculesPacket::handle)
                .add();
        //Food
//        net.messageBuilder(FoodPacket.class, id())
//                .decoder(FoodPacket::new)
//                .encoder(FoodPacket::toBytes)
//                .consumerMainThread(FoodPacket::handle)
//                .add();
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
        net.messageBuilder(SyncQuestsPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT) // 修改方向
                .decoder(SyncQuestsPacket::new)
                .encoder(SyncQuestsPacket::encode)
                .consumerMainThread(SyncQuestsPacket::handle)
                .add();

        // 2. 客户端→服务端请求包（数据请求）
        net.messageBuilder(RequestQuestsPacket.class, id(), NetworkDirection.PLAY_TO_SERVER) // 保持原方向
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
