package com.shengchanshe.chang_sheng_jue.network.packet.particle.xiu_xian;

import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public record TriggerBreakthroughParticlePacket(UUID playerUUID, int cultivationStage , int breakthroughTick) {

    public void encode(FriendlyByteBuf buf) {
        buf.writeUUID(playerUUID);
        buf.writeInt(cultivationStage);
        buf.writeInt(breakthroughTick);
    }

    public static TriggerBreakthroughParticlePacket decode(FriendlyByteBuf buf) {
        return new TriggerBreakthroughParticlePacket(buf.readUUID(), buf.readInt(), buf.readInt());
    }

    public static void handle(TriggerBreakthroughParticlePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Minecraft mc = Minecraft.getInstance();
            if (mc.level == null) return;

            Player player = Minecraft.getInstance().level.getPlayerByUUID(packet.playerUUID());

            if (player != null && player.level() == mc.level) {
                if (packet.cultivationStage() == 1) {
                    player.level().addParticle(
                            ChangShengJueParticles.MORTAL_BREAKTHROUGH3_PARTICLE.get(),
                            player.getX(), player.getY() + 1, player.getZ(),
                            0, 0, 0);
                }else if (packet.cultivationStage() == 2) {
                    player.level().addParticle(
                            ChangShengJueParticles.QI_CONDENSATION_BREAKTHROUGH0_PARTICLE.get(),
                            player.getX(), player.getY() + 1, player.getZ(),
                            0, 0, 0);
                    player.level().addParticle(
                            ChangShengJueParticles.QI_CONDENSATION_BREAKTHROUGH3_PARTICLE.get(),
                            player.getX(), player.getY() + 1, player.getZ(),
                            0, 0, 0);
                }
//                if (packet.breakthroughTick > 0 && packet.breakthroughTick <= 80) {
//
//                    for (int i = 0; i < 5; ++i) {
//                        double radius = 10;
//                        double r = radius * Math.cbrt(player.getRandom().nextDouble());
//                        double theta = player.getRandom().nextDouble() * 2 * Math.PI;
//                        double phi = Math.acos(2 * player.getRandom().nextDouble() - 1);
//
//                        double offsetX = r * Math.sin(phi) * Math.cos(theta);
//                        double offsetY = r * Math.cos(phi);
//                        double offsetZ = r * Math.sin(phi) * Math.sin(theta);
//
//                        double particleX = player.getX() + offsetX;
//                        double particleY = player.getY() + offsetY + 1.0; // Y轴偏移
//                        double particleZ = player.getZ() + offsetZ;
//
//                        player.level().addParticle(
//                                ChangShengJueParticles.BREAKTHROUGH_PARTICLE.get(),
//                                particleX, particleY, particleZ,
//                                0, 0, 0);
//                    }
//                }
//                if (packet.breakthroughTick > 20 && packet.breakthroughTick <= 80) {
//                    for (int i = 0; i < 7; ++i) {
//                        double radius = 10;
//                        double r = radius * Math.cbrt(player.getRandom().nextDouble());
//                        double theta = player.getRandom().nextDouble() * 2 * Math.PI;
//                        double phi = Math.acos(2 * player.getRandom().nextDouble() - 1);
//
//                        double offsetX = r * Math.sin(phi) * Math.cos(theta);
//                        double offsetY = r * Math.cos(phi);
//                        double offsetZ = r * Math.sin(phi) * Math.sin(theta);
//
//                        double particleX = player.getX() + offsetX;
//                        double particleY = player.getY() + offsetY + 1.0; // Y轴偏移
//                        double particleZ = player.getZ() + offsetZ;
//
//                        Vec3 targetPos = player.position().add(0, 1.0, 0);
//                        Vec3 direction = targetPos.subtract(particleX, particleY, particleZ).normalize();
//                        double currentSpeed = 0.2;
//
//                        player.level().addParticle(
//                                ChangShengJueParticles.BREAKTHROUGH_PARTICLE.get(),
//                                particleX, particleY, particleZ,
//                                direction.x * currentSpeed,
//                                direction.y * currentSpeed,
//                                direction.z * currentSpeed
//                        );
//                    }
//                }
//                if (packet.breakthroughTick == 40 || packet.breakthroughTick == 50 || packet.breakthroughTick == 60
//                        || packet.breakthroughTick == 70|| packet.breakthroughTick == 80){
//                    double speed = 0.1 + player.getRandom().nextDouble() * 0.2;
//
//                    double theta = player.getRandom().nextDouble() * 2 * Math.PI;
//                    double horizontalFactor = 0.7;
//                    double xDir = Math.cos(theta) * horizontalFactor;
//                    double zDir = Math.sin(theta) * horizontalFactor;
//
//                    double yDir = 0.3 + player.getRandom().nextDouble() * 0.3;
//
//                    player.level().addParticle(
//                            ChangShengJueParticles.BREAKTHROUGH_1_PARTICLE.get(),
//                            player.getX(),
//                            player.getY() + 1.0,
//                            player.getZ(),
//                            xDir * speed,
//                            yDir * speed,
//                            zDir * speed
//                    );
//                }
//                if (packet.breakthroughTick >= 90 && packet.breakthroughTick < 100) {
//                    for (int i = 0; i < 10; ++i) { // 增加粒子数量
//                        // 1. 基础参数
//                        double speed = 0.08 + player.getRandom().nextDouble() * 0.04; // 速度范围：0.08~0.12
//                        double radius = 0.6; // 脚底圆半径
//
//                        // 2. 圆形分布（XZ平面）
//                        double angle = player.getRandom().nextDouble() * 2 * Math.PI;
//                        double xOffset = Math.cos(angle) * radius;
//                        double zOffset = Math.sin(angle) * radius;
//
//                        // 3. 生成位置（玩家脚底+随机圆环）
//                        double spawnX = player.getX() + xOffset;
//                        double spawnY = player.getY() + 0.1; // 略高于脚底
//                        double spawnZ = player.getZ() + zOffset;
//
//                        // 4. 运动方向（主要向上+轻微随机偏移）
//                        double xDir = (player.getRandom().nextDouble() - 0.5) * 0.2; // -0.1~0.1
//                        double yDir = 1.0; // 固定向上
//                        double zDir = (player.getRandom().nextDouble() - 0.5) * 0.2;
//
//                        // 5. 生成粒子
//                        player.level().addParticle(
//                                ChangShengJueParticles.BREAKTHROUGH_2_PARTICLE.get(),
//                                spawnX, spawnY, spawnZ,
//                                xDir * speed,
//                                yDir * speed,
//                                zDir * speed
//                        );
//                    }
//                    for (int i = 0; i < 2; ++i) {
//                        double speed = 0.1 + player.getRandom().nextDouble() * 0.2;
//                        double offsetY = (player.getRandom().nextDouble() + 0.5) * 0.7;
//
//                        double theta = player.getRandom().nextDouble() * 2 * Math.PI;
//                        double horizontalFactor = 0.7;
//                        double xDir = Math.cos(theta) * horizontalFactor;
//                        double zDir = Math.sin(theta) * horizontalFactor;
//
//                        double yDir = 0.3 + player.getRandom().nextDouble() * 0.3;
//
//                        player.level().addParticle(
//                                ChangShengJueParticles.BREAKTHROUGH_1_PARTICLE.get(),
//                                player.getX(),
//                                player.getY() + offsetY, // 沿玩家身高随机生成
//                                player.getZ(),
//                                xDir * speed,
//                                yDir * speed,
//                                zDir * speed
//                        );
//                    }
//                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
