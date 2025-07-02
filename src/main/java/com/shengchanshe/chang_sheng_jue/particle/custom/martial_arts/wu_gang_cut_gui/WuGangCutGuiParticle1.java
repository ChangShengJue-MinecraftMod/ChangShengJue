package com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts.wu_gang_cut_gui;

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

@OnlyIn(Dist.CLIENT)
public class WuGangCutGuiParticle1 extends SimpleAnimatedParticle {
    private final float endRed;
    private final float endGreen;
    private final float endBlue;
    WuGangCutGuiParticle1(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pSprites, -0.0F);
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.lifetime = 40;
        this.rCol = 1.0F;
        this.gCol = 1.0F;
        this.bCol = 0.0F;
        this.endRed = 1.0F;
        this.endGreen = 1.0F;
        this.endBlue = 1.0F;
        this.setSpriteFromAge(pSprites);
        this.setSize(1.5F, 21.0F);
        this.quadSize *= 0.75F;
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

        // 粒子的大小：宽1格、高21格
        float width = 0.5f;   // 左右各0.5格，总宽1格
        float height = 21.0f; // 总高21格

        // 计算四个顶点，将粒子中心位置调整到底部
        float x1 = -width;
        float y1 = 0.0f;       // 底部顶点
        float z1 = 0;

        float x2 = -width;
        float y2 = height;     // 顶部顶点
        float z2 = 0;

        float x3 = width;
        float y3 = height;     // 顶部顶点
        float z3 = 0;

        float x4 = width;
        float y4 = 0.0f;       // 底部顶点
        float z4 = 0;

        // 通过玩家视角的Yaw（水平角度）旋转顶点
        float yaw = camera.getYRot();
        float cosYaw = Mth.cos(yaw * ((float) Math.PI / 180F));
        float sinYaw = Mth.sin(yaw * ((float) Math.PI / 180F));

        // 旋转顶点位置，使粒子在XZ平面朝向玩家
        float rx1 = x1 * cosYaw - z1 * sinYaw;
        float rz1 = x1 * sinYaw + z1 * cosYaw;

        float rx2 = x2 * cosYaw - z2 * sinYaw;
        float rz2 = x2 * sinYaw + z2 * cosYaw;

        float rx3 = x3 * cosYaw - z3 * sinYaw;
        float rz3 = x3 * sinYaw + z3 * cosYaw;

        float rx4 = x4 * cosYaw - z4 * sinYaw;
        float rz4 = x4 * sinYaw + z4 * cosYaw;

        // 纹理坐标
        float u0 = this.sprite.getU0();
        float u1 = this.sprite.getU1();
        float v0 = this.sprite.getV0();
        float v1 = this.sprite.getV1();

        // 光照
        int light = LightTexture.FULL_BRIGHT;

        // 渲染四个顶点，粒子中心在底部
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
            float f = (float)this.age / (float)this.lifetime;
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
            return new WuGangCutGuiParticle1(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.sprites);
        }
    }
}