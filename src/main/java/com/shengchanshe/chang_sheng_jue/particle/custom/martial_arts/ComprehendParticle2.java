package com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ComprehendParticle2 extends SimpleAnimatedParticle {
    private final float endRed;
    private final float endGreen;
    private final float endBlue;
    ComprehendParticle2(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pSprites, -1.6F);
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.quadSize *= 0.75F;
        this.lifetime = 40;
        this.friction = 1.0F;
        this.rCol = 1.0F;
        this.gCol = 0.99F;
        this.bCol = 0.0F;
        this.endRed = 0.0F;
        this.endGreen = 1.0F;
        this.endBlue = 1.0F;
        this.setSpriteFromAge(pSprites);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            float f = (float)this.age / (float)this.lifetime;
            this.friction = this.friction * f;
            float red = this.rCol + f * (endRed - 0.05F);
            float green = this.gCol + f * (endGreen - this.gCol);
            float blue = this.bCol + f * (endBlue - 0.05F);
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
            return new ComprehendParticle2(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.sprites);
        }
    }
}