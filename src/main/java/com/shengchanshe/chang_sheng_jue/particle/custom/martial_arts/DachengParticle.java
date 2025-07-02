package com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DachengParticle extends TextureSheetParticle {
    private final SpriteSet sprites;
    private final float endRed;
    private final float endGreen;
    private final float endBlue;
    protected DachengParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed,
                              SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, 0.0D, 0.0D, 0.0D);
        this.friction = 0.96F;
        this.gravity = 0.0F;
        this.sprites = pSprites;
        this.xd += pXSpeed;
        this.yd += pYSpeed;
        this.zd += pZSpeed;
        this.rCol = 1.0F;
        this.gCol = 1.0F;
        this.bCol = 1.0F;
        this.endRed = 1.0F;
        this.endGreen = 1.0F;
        this.endBlue = 0.0F;
        this.quadSize *= 0.75F;
        this.lifetime = 15;
        this.setSpriteFromAge(pSprites);
        this.hasPhysics = false;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public float getQuadSize(float pScaleFactor) {
        return this.quadSize * Mth.clamp(((float)this.age + pScaleFactor) / (float)this.lifetime * 32.0F, 0.0F, 1.0F);
    }

    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.sprites);
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            float f = (float)this.age / (float)this.lifetime;
            // 让摩擦力随着寿命的减少而减少
            this.friction = this.friction * f;

            if (this.age > 5){
                this.gravity = 2.0F;
            }
            // 根据生命周期进度插值计算颜色
            float red = this.rCol + f * (endRed - this.rCol);
            float green = this.gCol + f * (endGreen - this.gCol);
            float blue = this.bCol + f * (endBlue - this.bCol);
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
            return new DachengParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed,  this.sprites);
        }
    }
}