package com.shengchanshe.changshengjue.network;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.network.packet.martial_arts.*;
import com.shengchanshe.changshengjue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket2;
import com.shengchanshe.changshengjue.screen.plaque.UpdatePlaqueTextPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

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

}
