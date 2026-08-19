package com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu;

import com.shengchanshe.chang_sheng_jue.network.ClientPacketBridge;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public record TriggerKungFuParticlePacket(UUID playerUUID, String kungFuId) {

    public void encode(FriendlyByteBuf buf) {
        buf.writeUUID(playerUUID);
        buf.writeUtf(kungFuId);
    }

    public static TriggerKungFuParticlePacket decode(FriendlyByteBuf buf) {
        return new TriggerKungFuParticlePacket(buf.readUUID(), buf.readUtf());
    }

    public static void handle(TriggerKungFuParticlePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> ClientPacketBridge.triggerKungFuParticle(packet.playerUUID(), packet.kungFuId()));
        ctx.get().setPacketHandled(true);
    }
}
