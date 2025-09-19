package com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu;

import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import com.shengchanshe.chang_sheng_jue.util.particle.XpParatice;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

public record XpParticlePacket(UUID playerUUID, SimpleParticleType particleType, int tick) {

    public void encode(FriendlyByteBuf buf) {
        buf.writeUUID(playerUUID);
        buf.writeResourceLocation(Objects.requireNonNull(ForgeRegistries.PARTICLE_TYPES.getKey(particleType)));
        buf.writeInt(tick);
    }

    public static XpParticlePacket decode(FriendlyByteBuf buf) {
        UUID playerUUID = buf.readUUID();
        ParticleType<?> particleType = ForgeRegistries.PARTICLE_TYPES.getValue(buf.readResourceLocation());
        int tick = buf.readInt();

        if (particleType instanceof SimpleParticleType simpleParticleType) {
            return new XpParticlePacket(playerUUID, simpleParticleType, tick);
        } else {
            return new XpParticlePacket(playerUUID, ChangShengJueParticles.EXTERNAL_KUN_FU_XP_PARTICLE.get(), tick);
        }
    }
    public static void handle(XpParticlePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Minecraft mc = Minecraft.getInstance();
            if (mc.level == null) return;

            Player player = Minecraft.getInstance().level.getPlayerByUUID(packet.playerUUID());

            if (player != null && player.level() == mc.level) {
                XpParatice.XpParaticeParticle(packet.particleType(), player, player.level(), packet.tick);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
