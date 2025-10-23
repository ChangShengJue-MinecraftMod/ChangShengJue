package com.shengchanshe.chang_sheng_jue.util.particle;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class XpParatice {
    public static void XpParaticeParticle(SimpleParticleType simpleParticleType,Player player, Level level, float tick){
        if (tick > 0 && tick <= 20){
            double radius = 0.3;
//            player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 0.6F, 0.8F + player.getRandom().nextFloat() * 0.4F);
            for (int i = 0; i < 2; i++) {
                double phi = Math.random() * Math.PI * 2;
                double costheta = Math.random() * 2 - 1;
                double theta = Math.acos(costheta);
                double dx = radius * Math.sin(theta) * Math.cos(phi);
                double dy = radius * Math.sin(theta) * Math.sin(phi);
                double dz = radius * Math.cos(theta);

                double speedFactor = 0.1;
                double speedX = dx * speedFactor;
                double speedY = dy * speedFactor;
                double speedZ = dz * speedFactor;

                level.addParticle(simpleParticleType, player.getX() + dx, player.getY() + 0.3 + dy,
                        player.getZ() + dz, speedX, speedY, speedZ);
            }
        }
    }
}
