package com.shengchanshe.changshengjue.particle.custom.martial_arts.golden_bell_jar;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GoldenBellJarParticle extends TextureSheetParticle {
    protected GoldenBellJarParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
                                    SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(level, xCoord, yCoord, zCoord, pXSpeed, pYSpeed, pZSpeed);
        this.rCol = 1.0f;
        this.gCol = 1.0f;
        this.bCol = 0.0f;
        this.pickSprite(spriteSet);
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.quadSize *= 0.45F;
        this.lifetime = 40;
        this.friction = 1.0F;
        this.setSpriteFromAge(spriteSet);
        this.gravity = -0.01F;
        this.alpha = 0.0F;

        this.hasPhysics = false; // 粒子是否可以被碰撞
    }

    @Override
    public void tick() {
        super.tick();
        float lifeRatio = (float) this.age / this.lifetime; // 当前生命比例（0到1之间）
        // 透明度公式：从透明 -> 不透明 -> 透明
        this.alpha = (float) Math.sin(Math.PI * lifeRatio);;
    }

    @Override
    public int getLightColor(float partialTick) {
        return LightTexture.FULL_BRIGHT; // 返回最大亮度值
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z,
                                       double pXSpeed, double pYSpeed, double pZSpeed) {
            GoldenBellJarParticle particle = new GoldenBellJarParticle(level, x, y, z, this.sprites, pXSpeed, pYSpeed, pZSpeed);
            particle.pickSprite(this.sprites); // 随机选择一张纹理贴图
            return particle;
        }
    }
}