package com.shengchanshe.changshengjue.particle.custom.martial_arts.wu_gang_cut_gui;

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

public class WuGangCutGuiParticle extends SimpleAnimatedParticle {
    private final float endRed;
    private final float endGreen;
    private final float endBlue;
    // 新增的加速度变量
    private double accelerationX;
    private double accelerationY;
    private double accelerationZ;

    WuGangCutGuiParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pSprites, -0.5F);
        this.xd = pXSpeed;
        this.yd = pYSpeed * 0.0;
        this.zd = pZSpeed * -1.0;
        this.quadSize *= 0.3F;
        this.lifetime = 20;
        this.friction = 1.0F;
        this.rCol = 1.0F;
        this.gCol = 1.0F;
        this.bCol = 0.0F;
        this.endRed = 1.0F;
        this.endGreen = 1.0F;
        this.endBlue = 1.0F;
        // 设置加速度为 (1, 1, 1)
        this.accelerationX = 0.01; // x轴加速度
        this.accelerationY = 0.08; // y轴加速度
        this.accelerationZ = 0.01; // z轴加速度
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

        float scale = this.getQuadSize(partialTicks);

        float x1 = -scale;
        float y1 = -scale;
        float z1 = 0;

        float x2 = -scale;
        float y2 = scale;
        float z2 = 0;

        float x3 = scale;
        float y3 = scale;
        float z3 = 0;

        float x4 = scale;
        float y4 = -scale;
        float z4 = 0;

        float yaw = camera.getYRot(); // 获取玩家的水平旋转角度（Yaw）
        float cosYaw = Mth.cos(yaw * ((float) Math.PI / 180F));
        float sinYaw = Mth.sin(yaw * ((float) Math.PI / 180F));

        float rx1 = x1 * cosYaw - z1 * sinYaw;
        float rz1 = x1 * sinYaw + z1 * cosYaw;

        float rx2 = x2 * cosYaw - z2 * sinYaw;
        float rz2 = x2 * sinYaw + z2 * cosYaw;

        float rx3 = x3 * cosYaw - z3 * sinYaw;
        float rz3 = x3 * sinYaw + z3 * cosYaw;

        float rx4 = x4 * cosYaw - z4 * sinYaw;
        float rz4 = x4 * sinYaw + z4 * cosYaw;

        float u0 = this.sprite.getU0();
        float u1 = this.sprite.getU1();
        float v0 = this.sprite.getV0();
        float v1 = this.sprite.getV1();

        int light = LightTexture.FULL_BRIGHT;

        buffer.vertex(centerX + rx1, centerY + y1, centerZ + rz1).uv(u0, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        buffer.vertex(centerX + rx2, centerY + y2, centerZ + rz2).uv(u0, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        buffer.vertex(centerX + rx3, centerY + y3, centerZ + rz3).uv(u1, v0).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
        buffer.vertex(centerX + rx4, centerY + y4, centerZ + rz4).uv(u1, v1).color(rCol, gCol, bCol, alpha).uv2(light).endVertex();
    }

    @Override
    public int getLightColor(float partialTicks) {
        return LightTexture.FULL_BRIGHT; // 设置粒子亮度
    }

    @Override
    public void tick() {
        super.tick();
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.xd += this.accelerationX; // 每帧加上x轴加速度
            this.yd += this.accelerationY; // 每帧加上y轴加速度
            this.zd += this.accelerationZ; // 每帧加上z轴加速度
            // 移动粒子
            this.move(xd, yd, zd);

            float f = (float)this.age / (float)this.lifetime;
            // 让摩擦力随着寿命的减少而减少
            this.friction = this.friction * f;
            // 计算颜色变化
            float red = this.rCol + f * (endRed - 1.0F);
            float green = this.gCol + f * (endGreen - 1.0F);
            float blue = this.bCol + f * (endBlue + 0.05F);
            // 设置当前颜色
            this.setColor(red, green, blue);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet pSprites) {
            this.sprites = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            return new WuGangCutGuiParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.sprites);
        }
    }
}