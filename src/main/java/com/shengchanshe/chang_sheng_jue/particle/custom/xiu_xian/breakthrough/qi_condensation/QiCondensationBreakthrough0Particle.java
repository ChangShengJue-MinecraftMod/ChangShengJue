package com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.breakthrough.qi_condensation;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QiCondensationBreakthrough0Particle extends TextureSheetParticle {
    private final Player followingPlayer;
    private final float endR;
    private final float endG;
    private final float endB;
    QiCondensationBreakthrough0Particle(ClientLevel pLevel, Player player, double pX, double pY, double pZ,
                  double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
        this.followingPlayer = player;
        this.quadSize = 3.0f;
        this.lifetime = 120;
        this.gravity = 0;
        this.alpha = 0.0f;

        this.rCol = 0.38f;
        this.gCol = 0.7f;
        this.bCol = 1.0f;
        this.endR = 1.0f;
        this.endG = 0.96f;
        this.endB = 0.08f;

        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.setSize(0.001f, 0.001f);
        this.setSpriteFromAge(pSprites);
        this.hasPhysics = false;
    }

    @Override
    public void render(VertexConsumer pBuffer, Camera pRenderInfo, float pPartialTicks) {
        // 粒子中心位置，相对于相机
        float centerX = (float) (Mth.lerp(pPartialTicks, this.xo, this.x) - pRenderInfo.getPosition().x());
        float centerY = (float) (Mth.lerp(pPartialTicks, this.yo, this.y) - pRenderInfo.getPosition().y());
        float centerZ = (float) (Mth.lerp(pPartialTicks, this.zo, this.z) - pRenderInfo.getPosition().z());

        // 粒子大小
        float scale = this.getQuadSize(pPartialTicks);

        // 获取玩家视角的 Yaw 角度（水平旋转）
        float yaw = pRenderInfo.getYRot(); // Yaw是水平角度
        float cosYaw = Mth.cos(yaw * ((float) Math.PI / 180F));
        float sinYaw = Mth.sin(yaw * ((float) Math.PI / 180F));

        // 计算顶点坐标（仅水平旋转，不影响垂直轴）
        float x1 = -scale * cosYaw - -scale * sinYaw;
        float z1 = -scale * sinYaw + -scale * cosYaw;

        float x2 = -scale * cosYaw - scale * sinYaw;
        float z2 = -scale * sinYaw + scale * cosYaw;

        float x3 = scale * cosYaw - scale * sinYaw;
        float z3 = scale * sinYaw + scale * cosYaw;

        float x4 = scale * cosYaw - -scale * sinYaw;
        float z4 = scale * sinYaw + -scale * cosYaw;

        // 纹理坐标
        float u0 = this.sprite.getU0();
        float u1 = this.sprite.getU1();
        float v0 = this.sprite.getV0();
        float v1 = this.sprite.getV1();

        // 光照
        int light = LightTexture.FULL_BRIGHT;

        // 渲染四个顶点（Y坐标始终固定，XZ平面旋转）
        pBuffer.vertex(centerX + x1, centerY, centerZ + z1).uv(u0, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        pBuffer.vertex(centerX + x2, centerY, centerZ + z2).uv(u0, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        pBuffer.vertex(centerX + x3, centerY, centerZ + z3).uv(u1, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        pBuffer.vertex(centerX + x4, centerY, centerZ + z4).uv(u1, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();

        // 添加背面渲染（反转法线）
        pBuffer.vertex(centerX + x4, centerY, centerZ + z4).uv(u1, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        pBuffer.vertex(centerX + x3, centerY, centerZ + z3).uv(u1, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        pBuffer.vertex(centerX + x2, centerY, centerZ + z2).uv(u0, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        pBuffer.vertex(centerX + x1, centerY, centerZ + z1).uv(u0, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
    }

    @Override
    public void tick() {
        super.tick();
        float sizeProgress = (float)this.age / (float)this.lifetime;
        float easedProgress = Mth.sin(sizeProgress * (float)Math.PI * 0.5f);

        if (this.age <= 20) {
            this.alpha = (float)this.age / 20;
        } else if (this.age >= 90) {
            this.alpha = 1.0f - (float)(this.age - 90) / (lifetime - 90);
        } else {
            this.alpha = 1.0f;
        }

        this.rCol = Mth.lerp(easedProgress, this.rCol, endR);
        this.gCol = Mth.lerp(easedProgress, this.gCol, endG);
        this.bCol = Mth.lerp(easedProgress, this.bCol, endB);

        if (this.age <= 1){
            followingPlayer.level().addParticle(
                    ChangShengJueParticles.QI_CONDENSATION_BREAKTHROUGH3_PARTICLE.get(),
                    followingPlayer.getX(), followingPlayer.getY() + 1, followingPlayer.getZ(),
                    0, 0, 0
            );
        }
        if (this.age % 2 == 0 && this.age > 5) {
            spawnChildParticle();
            spawnChildParticle1();
        }

        if (this.age == 100){
            spawnChildParticle2();
        }
        if (this.age > 110){
            spawnChildParticle3();
        }

        this.x = followingPlayer.getX();
        this.y = followingPlayer.getVehicle() != null ? followingPlayer.getY() + 0.6 : followingPlayer.getY();
        this.z = followingPlayer.getZ();
    }

    private void spawnChildParticle() {
        double speed = 0.08 + followingPlayer.getRandom().nextDouble() * 0.04;
        double radius = 1.0;

        double angle = followingPlayer.getRandom().nextDouble() * 2 * Math.PI;
        double xOffset = Math.cos(angle) * radius;
        double zOffset = Math.sin(angle) * radius;

        double yOffset = 0.1 + followingPlayer.getRandom().nextDouble() * 1.7;

        double spawnX = followingPlayer.getX() + xOffset;
        double spawnY = followingPlayer.getY() + yOffset;
        double spawnZ = followingPlayer.getZ() + zOffset;

        double xDir = (followingPlayer.getRandom().nextDouble() - 0.5) * 0.2;
        double zDir = (followingPlayer.getRandom().nextDouble() - 0.5) * 0.2;

        followingPlayer.level().addParticle(
                ChangShengJueParticles.QI_CONDENSATION_BREAKTHROUGH1_PARTICLE.get(),
                spawnX, spawnY, spawnZ,
                xDir * speed,
                0,
                zDir * speed
        );
    }

    private void spawnChildParticle1() {
        double speed = 0.04 + followingPlayer.getRandom().nextDouble() * 0.02;
        double radius = 0.5f;

        double angle = followingPlayer.getRandom().nextDouble() * 2 * Math.PI;
        double xOffset = Math.cos(angle) * radius;
        double zOffset = Math.sin(angle) * radius;

        double yOffset = 0.1 + followingPlayer.getRandom().nextDouble() * 1.7;

        double spawnX = followingPlayer.getX() + xOffset;
        double spawnY = followingPlayer.getY() + yOffset;
        double spawnZ = followingPlayer.getZ() + zOffset;

        double xDir = (followingPlayer.getRandom().nextDouble() - 0.5) * 0.2;
        double zDir = (followingPlayer.getRandom().nextDouble() - 0.5) * 0.2;

        followingPlayer.level().addParticle(
                ChangShengJueParticles.QI_CONDENSATION_BREAKTHROUGH2_PARTICLE.get(),
                spawnX, spawnY, spawnZ,
                xDir * speed,
                0,
                zDir * speed
        );
    }

    private void spawnChildParticle2() {
        double centerX = followingPlayer.getX();
        double centerY = followingPlayer.getY() + 1.0; // 玩家胸口高度
        double centerZ = followingPlayer.getZ();

        int particleCount = 1200;
        double baseSpeed = 0.55;
        double speedVariation = 0.3;
        double radius = 0.5;

        for (int i = 0; i < particleCount; i++) {
            // 1. 球面均匀随机点（确保只在表面生成）
            double theta = followingPlayer.getRandom().nextDouble() * 2 * Math.PI;
            double phi = Math.acos(2 * followingPlayer.getRandom().nextDouble() - 1);

            // 2. 球坐标转笛卡尔坐标（固定半径）
            double xDir = Math.sin(phi) * Math.cos(theta);
            double yDir = Math.sin(phi) * Math.sin(theta);
            double zDir = Math.cos(phi);

            // 3. 生成位置（严格在球面上）
            double spawnX = centerX + xDir * radius;
            double spawnY = centerY + yDir * radius;
            double spawnZ = centerZ + zDir * radius;

            // 4. 速度控制（可选：速度与方向一致）
            double currentSpeed = baseSpeed + followingPlayer.getRandom().nextDouble() * speedVariation;

            // 5. 生成粒子
            followingPlayer.level().addParticle(
                    ChangShengJueParticles.QI_CONDENSATION_BREAKTHROUGH4_PARTICLE.get(),
                    spawnX, spawnY, spawnZ,
                    xDir * currentSpeed,
                    yDir * currentSpeed,
                    zDir * currentSpeed
            );
        }
    }

    private void spawnChildParticle3() {
        double centerX = followingPlayer.getX();
        double centerY = followingPlayer.getY() + 1.0; // 玩家胸口高度
        double centerZ = followingPlayer.getZ();
        int particleCount = 32;
        double baseSpeed = 0.5;
        double speedVariation = 0.3;
        double radius = 0.5;
        for (int i = 0; i < particleCount; i++) {
            double theta = followingPlayer.getRandom().nextDouble() * 2 * Math.PI;
            double phi = Math.acos(2 * followingPlayer.getRandom().nextDouble() - 1);

            double xDir = Math.sin(phi) * Math.cos(theta);
            double yDir = Math.sin(phi) * Math.sin(theta);
            double zDir = Math.cos(phi);

            double spawnX = centerX + xDir * radius;
            double spawnY = centerY + yDir * radius;
            double spawnZ = centerZ + zDir * radius;

            double currentSpeed = baseSpeed + followingPlayer.getRandom().nextDouble() * speedVariation;

            followingPlayer.level().addParticle(
                    ChangShengJueParticles.QI_CONDENSATION_BREAKTHROUGH4_PARTICLE.get(),
                    spawnX, spawnY, spawnZ,
                    xDir * currentSpeed,
                    yDir * currentSpeed,
                    zDir * currentSpeed
            );
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class QiCondensationBreakthrough0ParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public QiCondensationBreakthrough0ParticleProvider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            Player nearestPlayer = level.getNearestPlayer(pX, pY, pZ, 2, false);
            return nearestPlayer != null ? new QiCondensationBreakthrough0Particle(level, nearestPlayer, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.sprites) : null;
        }
    }
}
