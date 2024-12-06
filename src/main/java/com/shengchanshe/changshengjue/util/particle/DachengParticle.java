package com.shengchanshe.changshengjue.util.particle;

import com.shengchanshe.changshengjue.particle.ChangShengJueParticles;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class DachengParticle {
    public static void DachengParticle(Player player,Level level, int tick){
        if (tick > 0 && tick <= 2){
            onDachengParticle(player,level);
        }else if (tick >= 15 && tick <= 17){
            onDachengParticle(player,level);
        }else if (tick >= 28 && tick <= 30){
            onDachengParticle(player,level);
        }
    }

    public static void onDachengParticle(Player player,Level level){
        double radius = 1.0;  // 设置球体的半径
        int particleCount = 60;  // 控制粒子的数量

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

            level.addParticle(ChangShengJueParticles.DACHENG_PARTICLE.get(), player.getX() + dx, player.getY() + 1 + dy, player.getZ() + dz, speedX, speedY, speedZ);
        }
    }
}
