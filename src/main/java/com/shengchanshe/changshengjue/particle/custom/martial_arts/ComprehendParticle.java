package com.shengchanshe.changshengjue.particle.custom.martial_arts;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ComprehendParticle extends SimpleAnimatedParticle {
    private final double xStart;
    private final double yStart;
    private final double zStart;
    private final float endRed;
    private final float endGreen;
    private final float endBlue;
    ComprehendParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pSprites, 0.0F);
        this.xd = pXSpeed * 3.0;
        this.yd = pYSpeed * 3.0;
        this.zd = pZSpeed * 3.0;
        this.x = pX; // 微调初始位置
        this.y = pY; // 微调初始位置
        this.z = pZ; // 微调初始位置
        this.quadSize *= 0.3F;
        this.lifetime = 20;
        this.setSpriteFromAge(pSprites);
        this.xStart = this.x;
        this.yStart = this.y;
        this.zStart = this.z;
        this.rCol = 1.0F;
        this.gCol = 1.0F;
        this.bCol = 1.0F;
        this.endRed = 1.0F;
        this.endGreen = 1.0F;
        this.endBlue = 0.0F;
    }

    public void move(double pX, double pY, double pZ) {
        this.setBoundingBox(this.getBoundingBox().move(pX, pY, pZ));
        this.setLocationFromBoundingbox();
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet pSprites) {
            this.sprites = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            return new ComprehendParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.sprites);
        }
    }
    @Override
    public float getQuadSize(float pScaleFactor) {
        float f = ((float)this.age + pScaleFactor) / (float)this.lifetime;
        f = 1.0F - f;
        f *= f;
        f = 1.0F - f;
        return this.quadSize * f;
    }
    @Override
    public void tick() {
        this.setSpriteFromAge(this.sprites);
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            float f = (float)this.age / (float)this.lifetime;
            float f1 = -f + f * f * 2.0F;
            float f2 = 1.0F - f1;
            // 根据生命周期调整速度
            float speedFactor = 1.0F - f; // 速度因子随时间递减
            this.x = this.xStart + this.xd * (double)f2 * speedFactor;
            this.y = this.yStart + this.yd * (double)f2 * speedFactor;
            this.z = this.zStart + this.zd * (double)f2 * speedFactor;
            this.setPos(this.x, this.y, this.z);

            if (this.age > 18){
                // 根据生命周期进度插值计算颜色
                float red = this.rCol + f * (endRed - this.rCol);
                float green = this.gCol + f * (endGreen - this.gCol);
                float blue = this.bCol + f * (endBlue - 0.2F);
                // 设置当前颜色
                this.setColor(red, green, blue);
            }
        }
    }
    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}