package com.shengchanshe.chang_sheng_jue.network.packet.particle.xiu_xian;

import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public record TriggerTunNaParticlePacket(UUID playerUUID) {

    public void encode(FriendlyByteBuf buf) {
        buf.writeUUID(playerUUID);
    }

    public static TriggerTunNaParticlePacket decode(FriendlyByteBuf buf) {
        return new TriggerTunNaParticlePacket(buf.readUUID());
    }

    public static void handle(TriggerTunNaParticlePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Minecraft mc = Minecraft.getInstance();
            if (mc.level == null) return;

            Player player = Minecraft.getInstance().level.getPlayerByUUID(packet.playerUUID());

            if (player != null && player.level() == mc.level) {
                mc.particleEngine.createParticle(
                        ChangShengJueParticles.TUN_NA_PARTICLE.get(),
                        player.getX(), player.getVehicle() != null ? player.getY() + 0.6 : player.getY(), player.getZ(),
                        0, 0, 0);
            }
        });
        ctx.get().setPacketHandled(true); // 必须标记处理完成
    }


}
