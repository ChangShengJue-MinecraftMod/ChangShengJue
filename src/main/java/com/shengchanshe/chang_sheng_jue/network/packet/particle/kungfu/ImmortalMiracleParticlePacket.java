package com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu;

import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
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
        ctx.get().enqueueWork(() -> {
            Minecraft mc = Minecraft.getInstance();
            if (mc.level == null) return;

            Player player = Minecraft.getInstance().level.getPlayerByUUID(packet.playerUUID());

            if (player != null && player.level() == mc.level) {
                double radius = 0.4;  // 设置球体的半径
                int particleCount = 3;  // 控制粒子的数量

                for (int i = 0; i < particleCount; i++) {
                    // 在球体上随机生成一个点并引入随机角度偏差
                    double phi = Math.random() * Math.PI * 2;  // 产生随机的phi角
                    double costheta = Math.random() * 2 - 1;  // 产生随机的cos(theta)
                    double theta = Math.acos(costheta);  // 计算theta角

                    // 在角度上引入一定的随机波动
                    double randomAngleVariation = Math.random() * 0.5 - 0.25;  // 角度变化范围[-0.25, 0.25]
                    phi += randomAngleVariation;  // 在phi角上增加偏差

                    // 计算粒子位置
                    double dx = radius * Math.sin(theta) * Math.cos(phi);
                    double dy = radius * Math.sin(theta) * Math.sin(phi);
                    double dz = radius * Math.cos(theta);

                    double speedFactor = 0.2;  // 控制粒子的移动速度
                    // 计算粒子的速度向量
                    double speedX = dx * speedFactor;
                    double speedY = dy * speedFactor;
                    double speedZ = dz * speedFactor;

                    player.level().addParticle(ChangShengJueParticles.IMMORTAL_MIRACLE_PARTICLE.get(), player.getX() + dx, player.getY() + 1.3 + dy, player.getZ() + dz, speedX, speedY, speedZ);
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
