package com.shengchanshe.changshengjue.particle.custom.martial_arts.sunflower_point_caveman;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.particle.ChangShengJueParticles;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SunflowerPointCavemanParticle extends TextureSheetParticle {
    private final SpriteSet sprites;
    private final int entityId;
    protected SunflowerPointCavemanParticle(ClientLevel pLevel, double pX, double pY, double pZ,int entityId, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, 0.0D, 0.0D, 0.0D);
        this.friction = 0.96F;
        this.gravity = 0.0F;
        this.sprites = pSprites;
        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
        this.entityId = entityId;
        this.rCol = 1.0F;
        this.gCol = 1.0F;
        this.bCol = 0.2F;
        this.lifetime = 20;
        this.setSpriteFromAge(pSprites);
        this.hasPhysics = false;
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
    @Override
    public int getLightColor(float partialTick) {
        return 15728880; // 返回最大亮度值
    }

    @Override
    public void tick() {
        super.tick();
        flickerEffect();
        Entity entity = level.getEntity(entityId);
        if (entity instanceof LivingEntity living && !living.hasEffect(ChangShengJueEffects.FIXATION_EFFECT.get())) {
            this.remove();
        }
    }

    private void flickerEffect() {
        // 使用正弦函数来控制 alpha 值或颜色，让粒子闪烁
        float flicker = (float) (0.5F + 0.5F * Math.sin(2 * Math.PI * this.age / 10.0)); // 每 5 tick 完成一个周期
        this.alpha = flicker;// 让粒子透明度随闪烁变化
    }

    public float getQuadSize(float pScaleFactor) {
        return 0.15F;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet pSprites) {
            this.sprites = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            return new SunflowerPointCavemanParticle(pLevel, pX, pY, pZ, (int) pXSpeed, this.sprites);
        }
    }
}