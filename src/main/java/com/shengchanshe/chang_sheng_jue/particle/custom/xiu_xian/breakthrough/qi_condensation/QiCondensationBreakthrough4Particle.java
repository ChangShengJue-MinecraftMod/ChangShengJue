package com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.breakthrough.qi_condensation;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QiCondensationBreakthrough4Particle extends TextureSheetParticle {
    private final Player targetPlayer;
    private final SpriteSet pSprites;
    private static final float[][] COLOR_STAGES = {
            {0.33f, 1.0f, 0.27f},
            {0.25f, 1.0f, 0.69f},
            {0.86f, 0.94f, 0.25f},
            {0.26f, 0.77f, 0.18f},
            {0.33f, 0.52f, 0.27f}
    };

    public QiCondensationBreakthrough4Particle(ClientLevel pLevel, Player player, double pX, double pY, double pZ,
                                               double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pXSpeed,pYSpeed,pZSpeed);
        this.targetPlayer = player;
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.rCol = COLOR_STAGES[0][0];
        this.gCol = COLOR_STAGES[0][1];
        this.bCol = COLOR_STAGES[0][2];
        this.pSprites = pSprites;
        this.gravity = 0.0f;
        this.lifetime = 20;
        this.quadSize *= 1.0f;
        this.alpha = 1.0f;
        this.hasPhysics = false;
        this.setSpriteFromAge(pSprites);
    }

    @Override
    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.pSprites);
        float sizeProgress = (float)this.age / (float)this.lifetime;
        if (this.age > 10) {
            this.setAlpha(1.0F - ((float)this.age - (float)(this.lifetime / 2)) / (float)this.lifetime);
        }
        float progress = (float)this.age / this.lifetime;

        float easedProgress = Mth.sin(progress * (float)Math.PI * 0.5f);
        this.quadSize = (float) (quadSize + (0.2 - quadSize) * easedProgress);

        if (sizeProgress < 0.25f) {
            float stageProgress = sizeProgress * 4;
            interpolateColor(stageProgress, COLOR_STAGES[0], COLOR_STAGES[1]);
        } else if (sizeProgress < 0.5f) {
            float stageProgress = (sizeProgress - 0.25f) * 4;
            interpolateColor(stageProgress, COLOR_STAGES[1], COLOR_STAGES[2]);
        } else if (sizeProgress < 0.75f) {
            float stageProgress = (sizeProgress - 0.5f) * 4;
            interpolateColor(stageProgress, COLOR_STAGES[2], COLOR_STAGES[3]);
        } else {
            float stageProgress = (sizeProgress - 0.75f) * 4;
            interpolateColor(stageProgress, COLOR_STAGES[3], COLOR_STAGES[4]);
        }
    }


    private void interpolateColor(float progress, float[] startColor, float[] endColor) {
        this.rCol = Mth.lerp(progress, startColor[0], endColor[0]);
        this.gCol = Mth.lerp(progress, startColor[1], endColor[1]);
        this.bCol = Mth.lerp(progress, startColor[2], endColor[2]);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class QiCondensationBreakthrough4ParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public QiCondensationBreakthrough4ParticleProvider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {
            Player nearestPlayer = level.getNearestPlayer(x, y, z, 10, false);
            if (nearestPlayer != null) {
                return new QiCondensationBreakthrough4Particle(level, nearestPlayer, x, y, z, xSpeed, ySpeed, zSpeed, sprites);
            }
            return null; // 无玩家时不生成
        }
    }
}
