package com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.tun_na;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TunNaParticle extends SimpleAnimatedParticle {
    private final Player followingPlayer;

    TunNaParticle(ClientLevel pLevel, Player player, double pX, double pY, double pZ,
                         double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pSprites, 0.0F);
        this.followingPlayer = player;
        this.quadSize = 0.5f;  // 可以调整尺寸
        this.lifetime = 20;
        this.gravity = 0;
        this.alpha = 0.0f;
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
        if (this.age < this.lifetime * 0.5f) {
            this.alpha = 1.0f - (float) this.age / (this.lifetime);
        } else {
            this.alpha = 0.67f;
        }

        if (this.age < this.lifetime * 0.8f) {
            spawnChildParticle();
        }

        this.x = followingPlayer.getX();
        this.y = followingPlayer.getVehicle() != null ? followingPlayer.getY() + 0.6 : followingPlayer.getY();
        this.z = followingPlayer.getZ();
    }

    private void spawnChildParticle() {
        RandomSource random = RandomSource.create();
        // 玩家胸口中心坐标（Y轴+1.0格）
        double centerX = followingPlayer.getX();
        double centerY = followingPlayer.getY() + 1.0;
        double centerZ = followingPlayer.getZ();

        for (int i = 0; i < 2; i++) {
            Vec3 pos = getRandomPointInSphere(random, 0.35)
                    .add(centerX, centerY, centerZ);

            level.addParticle(
                    ChangShengJueParticles.TUN_NA_1_PARTICLE.get(),
                    pos.x, pos.y, pos.z,
                    centerX, centerY, centerZ
            );
        }
    }

    // 球体内随机点生成算法（单位球）
    private Vec3 getRandomPointInSphere(RandomSource random, double radius) {
        double x, y, z, d2;
        do {
            x = random.nextDouble() * 2 - 1; // [-1, 1]
            y = random.nextDouble() * 2 - 1;
            z = random.nextDouble() * 2 - 1;
            d2 = x * x + y * y + z * z;
        } while (d2 > 1.0); // 确保在单位球内

        return new Vec3(x, y, z).scale(radius);
    }

//    private static void spawnConvergingParticles(Minecraft mc, Player player) {
//        RandomSource random = RandomSource.create();
//        Vec3 playerPos = player.position().add(0, 1.5, 0); // 玩家头顶位置
//
//        // 在玩家周围5米半径生成10个汇聚粒子
//        for (int i = 0; i < 50; i++) {
//            // 随机起始位置（球面分布）
//            double radius = 5.0;
//            double theta = random.nextDouble() * Math.PI * 2;
//            double phi = random.nextDouble() * Math.PI;
//            double x = radius * Math.sin(phi) * Math.cos(theta);
//            double y = radius * Math.sin(phi) * Math.sin(theta);
//            double z = radius * Math.cos(phi);
//
//            Vec3 startPos = playerPos.add(x, y, z);
//
//            // 计算朝向玩家的方向向量
//            Vec3 toPlayer = playerPos.subtract(startPos).normalize();
//            double speed = 0.1 + random.nextDouble() * 0.2;
//
//            // 生成粒子（假设第二种粒子注册为CONVERGING_PARTICLE）
//            mc.particleEngine.createParticle(
//                    ParticleTypes.FLAME,
//                    startPos.x, startPos.y, startPos.z,
//                    toPlayer.x * speed, // X方向速度
//                    toPlayer.y * speed, // Y方向速度
//                    toPlayer.z * speed  // Z方向速度
//            );
//        }
//    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public int getLightColor(float partialTicks) {
        return 0; // 设置粒子亮度
    }

    @OnlyIn(Dist.CLIENT)
    public static class TunNaParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public TunNaParticleProvider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            Player nearestPlayer = level.getNearestPlayer(pX, pY, pZ, 2, false);
            return nearestPlayer != null ? new TunNaParticle(level, nearestPlayer, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.sprites) : null;
        }
    }
}