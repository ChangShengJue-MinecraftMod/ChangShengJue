package com.shengchanshe.changshengjue.particle.custom.martial_arts.sunflower_point_caveman;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SunflowerPointCavemanParticle1 extends TextureSheetParticle {
    private final SpriteSet sprites;
    private final int entityId;
    protected SunflowerPointCavemanParticle1(ClientLevel pLevel, double pX, double pY, double pZ, int entityId, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, 0.0D, 0.0D, 0.0D);
        this.friction = 0.96F;
        this.gravity = 0.0F;
        this.sprites = pSprites;
        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
        this.entityId = entityId;
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
        Entity entity = level.getEntity(entityId);
        if (entity instanceof LivingEntity living && !living.hasEffect(ChangShengJueEffects.FIXATION_EFFECT.get())) {
            this.remove();
        }
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
            return new SunflowerPointCavemanParticle1(pLevel, pX, pY, pZ, (int) pXSpeed, this.sprites);
        }
    }
}