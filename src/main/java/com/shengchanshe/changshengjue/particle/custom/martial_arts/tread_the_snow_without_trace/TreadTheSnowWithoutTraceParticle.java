package com.shengchanshe.changshengjue.particle.custom.martial_arts.tread_the_snow_without_trace;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TreadTheSnowWithoutTraceParticle extends SimpleAnimatedParticle {

    TreadTheSnowWithoutTraceParticle(ClientLevel pLevel, double pX, double pY, double pZ,
                                     double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pSprites, 0.0F);
        this.quadSize *= 1.0F;  // 可以调整尺寸
        this.lifetime = 40;     // 粒子的生命周期
        this.rCol = 1.0F;
        this.gCol = 1.0F;
        this.bCol = 1.0F;

        // 继续初始化粒子速度
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;

        this.setSpriteFromAge(pSprites);
    }

    public void move(double pX, double pY, double pZ) {
        this.setBoundingBox(this.getBoundingBox().move(pX, pY, pZ));
        this.setLocationFromBoundingbox();
    }
    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTicks) {
        // 粒子中心位置，相对于相机
        float centerX = (float) (Mth.lerp(partialTicks, this.xo, this.x) - camera.getPosition().x());
        float centerY = (float) (Mth.lerp(partialTicks, this.yo, this.y) - camera.getPosition().y());
        float centerZ = (float) (Mth.lerp(partialTicks, this.zo, this.z) - camera.getPosition().z());

        // 粒子大小
        float scale = this.getQuadSize(partialTicks);

        // 获取玩家视角的 Yaw 角度（水平旋转）
        float yaw = camera.getYRot(); // Yaw是水平角度
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
        buffer.vertex(centerX + x1, centerY, centerZ + z1).uv(u0, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        buffer.vertex(centerX + x2, centerY, centerZ + z2).uv(u0, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        buffer.vertex(centerX + x3, centerY, centerZ + z3).uv(u1, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        buffer.vertex(centerX + x4, centerY, centerZ + z4).uv(u1, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
    }
    @Override
    public void tick() {
        super.tick();
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet pSprites) {
            this.sprites = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            return new TreadTheSnowWithoutTraceParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.sprites);
        }
    }
}