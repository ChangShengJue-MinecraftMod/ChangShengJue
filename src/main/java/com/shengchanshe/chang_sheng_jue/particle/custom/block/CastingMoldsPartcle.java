package com.shengchanshe.chang_sheng_jue.particle.custom.block;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CastingMoldsPartcle  extends SimpleAnimatedParticle {
    protected CastingMoldsPartcle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pSprites, 0.0f);
        this.lifetime = 40;     // 粒子的生命周期
        this.quadSize = 0.5F;  // 可以调整尺寸
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.setSpriteFromAge(pSprites);
    }

    protected CastingMoldsPartcle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites, float pGravity) {
        super(pLevel, pX, pY, pZ, pSprites, pGravity);
        this.lifetime = 20;     // 粒子的生命周期
        this.quadSize = 0.1F;  // 可以调整尺寸
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.setSpriteFromAge(pSprites);
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
            return new CastingMoldsPartcle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.sprites);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider1 implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider1(SpriteSet pSprites) {
            this.sprites = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            return new CastingMoldsPartcle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.sprites, -0.3F);
        }
    }
}
