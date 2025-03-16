package com.shengchanshe.changshengjue.network.packet.food;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class FoodPacket {
    private final int nutrition;
    private final float saturationMod;

    // 参数构造函数
    public FoodPacket(int nutrition, float saturationMod) {
        this.nutrition = nutrition;
        this.saturationMod = saturationMod;
    }

    // 反序列化构造函数
    public FoodPacket(FriendlyByteBuf buf) {
        this.nutrition = buf.readInt();
        this.saturationMod = buf.readFloat();
    }

    // 序列化方法
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(nutrition);
        buf.writeFloat(saturationMod);
    }

    // 网络处理逻辑
    public static void handle(FoodPacket packet, Supplier<NetworkEvent.Context> context) {
        context.get().setPacketHandled(true);
        Player player = context.get().getSender() != null ?
                context.get().getSender() : // 服务端获取发送者
                Minecraft.getInstance().player; // 客户端获取本地玩家

        context.get().enqueueWork(() -> {
            if (player != null && player.isAlive()) {
                // 恢复饥饿值逻辑
                player.getFoodData().eat(packet.nutrition, packet.saturationMod);
            }
        });
    }
}
