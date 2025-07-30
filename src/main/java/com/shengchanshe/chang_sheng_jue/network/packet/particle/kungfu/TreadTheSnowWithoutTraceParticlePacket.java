package com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu;

import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public record TreadTheSnowWithoutTraceParticlePacket(UUID playerUUID, String kungFuId) {

    public void encode(FriendlyByteBuf buf) {
        buf.writeUUID(playerUUID);
        buf.writeUtf(kungFuId);
    }

    public static TreadTheSnowWithoutTraceParticlePacket decode(FriendlyByteBuf buf) {
        return new TreadTheSnowWithoutTraceParticlePacket(buf.readUUID(), buf.readUtf());
    }

    public static void handle(TreadTheSnowWithoutTraceParticlePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Minecraft mc = Minecraft.getInstance();
            if (mc.level == null) return;

            Player player = Minecraft.getInstance().level.getPlayerByUUID(packet.playerUUID());

            if (player != null && player.level() == mc.level) {
                int numParticles = 1;  // 可以根据需要调整数量
                Random random = new Random();

                for (int i = 0; i < numParticles; ++i) {
                    // 使用球坐标系生成球形范围内的粒子位置
                    double radius = 0.3;
                    double theta = random.nextDouble() * 2 * Math.PI;  // 0 到 2π 之间的随机角度
                    double phi = random.nextDouble() * Math.PI;  // 0 到 π 之间的随机角度

                    // 球坐标转换为笛卡尔坐标
                    double offsetX = radius * Math.sin(phi) * Math.cos(theta);
                    double offsetY = radius * Math.sin(phi) * Math.sin(theta);
                    double offsetZ = radius * Math.cos(phi);

                    double particleX = player.getX() + offsetX;
                    double particleY = player.getY() + offsetY;  // 生成在玩家的高度
                    double particleZ = player.getZ() + offsetZ;

                    // 获取玩家当前朝向的角度（以弧度为单位）
                    double playerYawRadians = Math.toRadians(player.getYRot());
                    double playerPitchRadians = Math.toRadians(player.getXRot());

                    // 计算玩家朝向的方向
                    double directionX = Math.sin(playerYawRadians) * Math.cos(playerPitchRadians);
                    double directionZ = -Math.cos(playerYawRadians) * Math.cos(playerPitchRadians);

                    Vec3 direction = new Vec3(directionX, 0, directionZ);
                    Vec3 normalizedDirection = direction.normalize();

                    // 设置粒子的速度，使其与玩家视角方向相反，速度设为每秒2格
                    double speedFactor = 0.3;  // 控制粒子速度的因子
                    double speedX = normalizedDirection.x * speedFactor;  // 粒子速度与玩家朝向的反方向
                    double speedZ = normalizedDirection.z * speedFactor;

                    // 生成粒子并设置速度
                    player.level().addParticle(ChangShengJueParticles.TREAD_THE_SNOW_WITHOUT_TRACE_PARTICLE.get(), particleX, particleY, particleZ, speedX, 0, speedZ);
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
