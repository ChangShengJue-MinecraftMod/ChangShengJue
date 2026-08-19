package com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu;

import com.shengchanshe.chang_sheng_jue.network.ClientPacketBridge;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record WuGangCutGuiParticlePacket(float x, float y, float z) {

    public void encode(FriendlyByteBuf buf) {
        buf.writeFloat(x);
        buf.writeFloat(y);
        buf.writeFloat(z);
    }

    public static WuGangCutGuiParticlePacket decode(FriendlyByteBuf buf) {
        return new WuGangCutGuiParticlePacket(buf.readFloat(), buf.readFloat(), buf.readFloat());
    }

    public static void handle(WuGangCutGuiParticlePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> ClientPacketBridge.wuGangCutGuiParticle(packet.x(), packet.y(), packet.z()));
        ctx.get().setPacketHandled(true);
    }
}
