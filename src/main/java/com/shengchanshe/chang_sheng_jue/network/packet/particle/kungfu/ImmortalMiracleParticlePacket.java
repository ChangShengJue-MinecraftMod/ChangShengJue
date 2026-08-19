package com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu;

import com.shengchanshe.chang_sheng_jue.network.ClientPacketBridge;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public record ImmortalMiracleParticlePacket(UUID playerUUID, String kungFuId) {

    public void encode(FriendlyByteBuf buf) {
        buf.writeUUID(playerUUID);
        buf.writeUtf(kungFuId);
    }

    public static ImmortalMiracleParticlePacket decode(FriendlyByteBuf buf) {
        return new ImmortalMiracleParticlePacket(buf.readUUID(), buf.readUtf());
    }

    public static void handle(ImmortalMiracleParticlePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> ClientPacketBridge.immortalMiracleParticle(packet.playerUUID(), packet.kungFuId()));
        ctx.get().setPacketHandled(true);
    }
}
