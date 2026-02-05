package com.shengchanshe.chang_sheng_jue.network.packet.checkin;

import com.shengchanshe.chang_sheng_jue.checkin.PlayerCheckInData;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.UUID;
import java.util.function.Supplier;

/**
 * 同步签到数据到客户端
 */
public record SyncCheckInDataPacket(CompoundTag dataTag) {

    public static void encode(SyncCheckInDataPacket packet, FriendlyByteBuf buf) {
        buf.writeNbt(packet.dataTag);
    }

    public static SyncCheckInDataPacket decode(FriendlyByteBuf buf) {
        return new SyncCheckInDataPacket(buf.readNbt());
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            handleClientSide(this.dataTag);
        });
        ctx.get().setPacketHandled(true);
    }

    @OnlyIn(Dist.CLIENT)
    private static void handleClientSide(CompoundTag dataTag) {
        if (dataTag != null) {
            UUID playerId = dataTag.getUUID("PlayerId");
            PlayerCheckInData clientData = new PlayerCheckInData(playerId);
            clientData.deserializeNBT(dataTag);

            // 存储到客户端缓存
            ClientCheckInDataCache.setPlayerData(clientData);

            // 如果当前正在显示签到界面,刷新界面
            if (Minecraft.getInstance().screen instanceof com.shengchanshe.chang_sheng_jue.cilent.gui.screens.checkin.CheckInScreen screen) {
                screen.refreshUI();
            }
        }
    }

    /**
     * 发送数据到客户端
     */
    public static void sendToClient(ServerPlayer player, PlayerCheckInData data) {
        CompoundTag tag = data.serializeNBT();
        ChangShengJueMessages.sendToPlayer(new SyncCheckInDataPacket(tag), player);
    }
}
