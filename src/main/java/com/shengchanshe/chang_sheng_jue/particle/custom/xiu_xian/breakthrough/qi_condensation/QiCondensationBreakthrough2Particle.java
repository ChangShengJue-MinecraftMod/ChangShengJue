package com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.breakthrough.qi_condensation;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QiCondensationBreakthrough2Particle extends TextureSheetParticle {
    private final Player targetPlayer;
    private static final float[][] COLOR_STAGES = {
            {0.51f, 1.0f, 0.48f},
            {0.7f, 1.0f, 0.85f}
    };

    public QiCondensationBreakthrough2Particle(ClientLevel pLevel, Player player, double pX, double pY, double pZ,
                                               double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pXSpeed,pYSpeed,pZSpeed);
        this.targetPlayer = player;
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.gravity = -0.1f;
        this.lifetime = 20;
        this.quadSize *= 0.2f;
        this.alpha = 1.0f;
        this.setSpriteFromAge(pSprites);
    }

    @Override
    public void tick() {
        super.tick();
        float sizeProgress = (float)this.age / (float)this.lifetime;
        float easedProgress = Mth.sin(sizeProgress * (float)Math.PI * 0.5f);
        this.alpha = Mth.lerp(easedProgress, 1.0f, 0.0f);
        float stageProgress = sizeProgress * 4;
        interpolateColor(stageProgress, COLOR_STAGES[0], COLOR_STAGES[1]);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    // 辅助方法：颜色插值
    private void interpolateColor(float progress, float[] startColor, float[] endColor) {
        this.rCol = Mth.lerp(progress, startColor[0], endColor[0]);
        this.gCol = Mth.lerp(progress, startColor[1], endColor[1]);
        this.bCol = Mth.lerp(progress, startColor[2], endColor[2]);
    }

    @OnlyIn(Dist.CLIENT)
    public static class QiCondensationBreakthrough2ParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public QiCondensationBreakthrough2ParticleProvider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {
            Player nearestPlayer = level.getNearestPlayer(x, y, z, 10, false);
            if (nearestPlayer != null) {
                return new QiCondensationBreakthrough2Particle(level, nearestPlayer, x, y, z, xSpeed, ySpeed, zSpeed, sprites);
            }
            return null; // 无玩家时不生成
        }
    }
}
