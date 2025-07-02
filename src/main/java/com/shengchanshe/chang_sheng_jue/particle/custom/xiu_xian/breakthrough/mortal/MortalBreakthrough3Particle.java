package com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.breakthrough.mortal;

import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import com.shengchanshe.chang_sheng_jue.particle.custom.VerticalParticle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MortalBreakthrough3Particle extends VerticalParticle {
    private final Player targetPlayer;
    private final float endR; // 目标天蓝色 (RGB: 0.53, 0.81, 0.92)
    private final float endG;
    private final float endB;

    public MortalBreakthrough3Particle(ClientLevel pLevel, Player player, double pX, double pY, double pZ,
                                       double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ,pXSpeed, pYSpeed, pZSpeed);
        this.targetPlayer = player;
        this.rCol = 0.6f;
        this.gCol = 1.0f;
        this.bCol = 0.8f;
        this.endR = 0.18f;
        this.endG = 0.7f;
        this.endB = 0.82f;
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.lifetime = 120;
        this.quadSize = 1.0f;
        this.alpha = 0.1f;
        this.hasPhysics = false;
        this.setSize(0.001f, 0.001f); // 设置极小碰撞箱
        this.setSpriteFromAge(pSprites);
    }

    @Override
    public void tick() {
        super.tick();
        float sizeProgress = (float)this.age / (float)this.lifetime;
        float easedProgress = Mth.sin(sizeProgress * (float)Math.PI * 0.5f);
//        if (this.age < this.lifetime * 0.5) {

        if (this.age > 95){
            this.alpha = 0;
        }else {
            this.alpha = (float) this.age / (this.lifetime);
        }

//        } else {
//            this.alpha = 0.5f;
//        }
        // 计算颜色渐变进度
        this.rCol = Mth.lerp(easedProgress, this.rCol, endR);
        this.gCol = Mth.lerp(easedProgress, this.gCol, endG);
        this.bCol = Mth.lerp(easedProgress, this.bCol, endB);

        this.x = targetPlayer.getX();
        this.y = targetPlayer.getY() + 1;
        this.z = targetPlayer.getZ();

        if (this.age > 0 && this.age <= 90) {
            for (int i = 0; i < 5; ++i) {
                double radius = 10;
                double r = radius * Math.cbrt(targetPlayer.getRandom().nextDouble());
                double theta = targetPlayer.getRandom().nextDouble() * 2 * Math.PI;
                double phi = Math.acos(2 * targetPlayer.getRandom().nextDouble() - 1);

                double offsetX = r * Math.sin(phi) * Math.cos(theta);
                double offsetY = r * Math.cos(phi);
                double offsetZ = r * Math.sin(phi) * Math.sin(theta);

                double particleX = targetPlayer.getX() + offsetX;
                double particleY = targetPlayer.getY() + offsetY + 1.0; // Y轴偏移
                double particleZ = targetPlayer.getZ() + offsetZ;

                targetPlayer.level().addParticle(
                        ChangShengJueParticles.MORTAL_BREAKTHROUGH0_PARTICLE.get(),
                        particleX, particleY, particleZ,
                        0, 0, 0);
            }
        }
        if (this.age > 20 && this.age <= 90) {
            for (int i = 0; i < 3; ++i) {
                double radius = 5;
                double r = radius * Math.cbrt(targetPlayer.getRandom().nextDouble());
                double theta = targetPlayer.getRandom().nextDouble() * 2 * Math.PI;
                double phi = Math.acos(2 * targetPlayer.getRandom().nextDouble() - 1);

                double offsetX = r * Math.sin(phi) * Math.cos(theta);
                double offsetY = r * Math.cos(phi);
                double offsetZ = r * Math.sin(phi) * Math.sin(theta);

                double particleX = targetPlayer.getX() + offsetX;
                double particleY = targetPlayer.getY() + offsetY + 1.0; // Y轴偏移
                double particleZ = targetPlayer.getZ() + offsetZ;

                Vec3 targetPos = targetPlayer.position().add(0, 1.0, 0);
                Vec3 direction = targetPos.subtract(particleX, particleY, particleZ).normalize();
                double currentSpeed = 0.2;

                targetPlayer.level().addParticle(
                        ChangShengJueParticles.MORTAL_BREAKTHROUGH0_PARTICLE.get(),
                        particleX, particleY, particleZ,
                        direction.x * currentSpeed,
                        direction.y * currentSpeed,
                        direction.z * currentSpeed
                );
            }
        }
        if (this.age % 10 == 0 && this.age >= 40 && this.age <= 80) {
            double speed = 0.1 + targetPlayer.getRandom().nextDouble() * 0.2;

            double theta = targetPlayer.getRandom().nextDouble() * 2 * Math.PI;
            double horizontalFactor = 0.7;
            double xDir = Math.cos(theta) * horizontalFactor;
            double zDir = Math.sin(theta) * horizontalFactor;

            double yDir = 0.3 + targetPlayer.getRandom().nextDouble() * 0.3;

            targetPlayer.level().addParticle(
                    ChangShengJueParticles.MORTAL_BREAKTHROUGH1_PARTICLE.get(),
                    targetPlayer.getX(),
                    targetPlayer.getY() + 1.0,
                    targetPlayer.getZ(),
                    xDir * speed,
                    yDir * speed,
                    zDir * speed
            );
        }
        if (this.age >= 110 && this.age < 120) {
            for (int i = 0; i < 10; ++i) { // 增加粒子数量
                // 1. 基础参数
                double speed = 0.08 + targetPlayer.getRandom().nextDouble() * 0.04; // 速度范围：0.08~0.12
                double radius = 1.0; // 脚底圆半径

                // 2. 圆形分布（XZ平面）
                double angle = targetPlayer.getRandom().nextDouble() * 2 * Math.PI;
                double xOffset = Math.cos(angle) * radius;
                double zOffset = Math.sin(angle) * radius;

                // 3. 生成位置（玩家脚底+随机圆环）
                double spawnX = targetPlayer.getX() + xOffset;
                double spawnY = targetPlayer.getY() + 0.1; // 略高于脚底
                double spawnZ = targetPlayer.getZ() + zOffset;

                // 4. 运动方向（主要向上+轻微随机偏移）
                double xDir = (targetPlayer.getRandom().nextDouble() - 0.5) * 0.2; // -0.1~0.1
                double yDir = 1.0; // 固定向上
                double zDir = (targetPlayer.getRandom().nextDouble() - 0.5) * 0.2;

                // 5. 生成粒子
                targetPlayer.level().addParticle(
                        ChangShengJueParticles.MORTAL_BREAKTHROUGH2_PARTICLE.get(),
                        spawnX, spawnY, spawnZ,
                        xDir * speed,
                        yDir * speed,
                        zDir * speed
                );
            }
            for (int i = 0; i < 2; ++i) {
                double speed = 0.1 + targetPlayer.getRandom().nextDouble() * 0.2;
                double offsetY = (targetPlayer.getRandom().nextDouble() + 0.5) * 0.7;

                double theta = targetPlayer.getRandom().nextDouble() * 2 * Math.PI;
                double horizontalFactor = 0.7;
                double xDir = Math.cos(theta) * horizontalFactor;
                double zDir = Math.sin(theta) * horizontalFactor;

                double yDir = 0.3 + targetPlayer.getRandom().nextDouble() * 0.3;

                targetPlayer.level().addParticle(
                        ChangShengJueParticles.MORTAL_BREAKTHROUGH1_PARTICLE.get(),
                        targetPlayer.getX(),
                        targetPlayer.getY() + offsetY, // 沿玩家身高随机生成
                        targetPlayer.getZ(),
                        xDir * speed,
                        yDir * speed,
                        zDir * speed
                );
            }
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Breakthrough3ParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Breakthrough3ParticleProvider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {
            Player nearestPlayer = level.getNearestPlayer(x, y, z, 10, false);
            if (nearestPlayer != null) {
                return new MortalBreakthrough3Particle(level, nearestPlayer, x, y, z, xSpeed, ySpeed, zSpeed, sprites);
            }
            return null; // 无玩家时不生成
        }
    }
}
