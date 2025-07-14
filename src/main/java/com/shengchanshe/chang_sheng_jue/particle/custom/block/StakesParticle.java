package com.shengchanshe.chang_sheng_jue.particle.custom.block;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class StakesParticle extends TextureSheetParticle {
    protected StakesParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
                                        SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(level, xCoord, yCoord, zCoord, pXSpeed, pYSpeed, pZSpeed);
        this.pickSprite(spriteSet);
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.quadSize *= 0.5F;
        this.lifetime = 10;
        this.setSpriteFromAge(spriteSet);
        this.gravity = 0.5F;

        this.hasPhysics = false; // 粒子是否可以被碰撞
    }

    @Override
    public void tick() {
        super.tick();
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
            return new StakesParticle(level, x, y, z, this.sprites, pXSpeed, pYSpeed, pZSpeed);
        }
    }
}