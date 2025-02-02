package com.shengchanshe.changshengjue.util.particle;

import com.shengchanshe.changshengjue.particle.ChangShengJueParticles;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class ComprehendParticle {

    public static void ComprehendParticle(Player player,Level level,float tick){
        if (tick > 0 && tick <= 20){
            int numParticles = 3;  // 可以根据需要调整数量
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
                double particleY = player.getY() + offsetY + 1;  // 稍微调整Y坐标，避免粒子在地面上
                double particleZ = player.getZ() + offsetZ;

                // 计算粒子朝向玩家的速度
                Vec3 direction = new Vec3(player.getX() - particleX, player.getY() + (player.getEyeHeight() - 0.5) - particleY, player.getZ() - particleZ);
                Vec3 normalizedDirection = direction.normalize();

                // 设置粒子的速度
                double speedFactor = 0.3;  // 控制粒子速度的因子，可以根据需要调整
                double speedX = normalizedDirection.x * speedFactor;
                double speedY = normalizedDirection.y * speedFactor;
                double speedZ = normalizedDirection.z * speedFactor;

                // 在玩家附近生成粒子并朝玩家汇聚
                level.addParticle(ChangShengJueParticles.COMPREHEND_PARTICLE.get(), particleX, particleY, particleZ, -speedX, -speedY, -speedZ);
            }
        }
        if (tick > 40 && tick < 80){
            double radius = 0.3;
            for (int i = 0; i < 2; i++) {
                // 在球体上随机生成一个点
                double phi = Math.random() * Math.PI * 2;
                double costheta = Math.random() * 2 - 1;
                double theta = Math.acos(costheta);
                double dx = radius * Math.sin(theta) * Math.cos(phi);
                double dy = radius * Math.sin(theta) * Math.sin(phi);
                double dz = radius * Math.cos(theta);

                double speedFactor = 0.1;
                // 计算粒子的速度向量，向外飞出
                double speedX = dx * speedFactor;
                double speedY = dy * speedFactor;
                double speedZ = dz * speedFactor;

                // 生成粒子并设置速度
                level.addParticle(ChangShengJueParticles.COMPREHEND_PARTICLE_2.get(), player.getX() + dx, player.getY() + 0.3 + dy, player.getZ() + dz, speedX, speedY, speedZ);
            }
        }
    }

}
