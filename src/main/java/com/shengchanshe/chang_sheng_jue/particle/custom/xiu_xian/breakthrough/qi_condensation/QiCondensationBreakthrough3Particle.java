package com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.breakthrough.qi_condensation;

import com.shengchanshe.chang_sheng_jue.particle.custom.VerticalParticle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QiCondensationBreakthrough3Particle extends VerticalParticle {
    private final Player targetPlayer;
    private static final float[][] COLOR_STAGES = {
            {0.0f, 1.0f, 0.67f},
            {0.37f, 0.89f, 0.43f},
            {1.0f, 0.96f, 0.08f}
    };

    public QiCondensationBreakthrough3Particle(ClientLevel pLevel, Player player, double pX, double pY, double pZ,
                                               double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ,pXSpeed, pYSpeed, pZSpeed);
        this.targetPlayer = player;
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.lifetime = 100;
        this.quadSize = 1.0f;
        this.alpha = 0.0f;
        this.hasPhysics = false;
        this.setSize(0.001f, 0.001f); // 设置极小碰撞箱
        this.setSpriteFromAge(pSprites);
    }

    @Override
    public void tick() {
        super.tick();
        float progress = (float)this.age / this.lifetime;

        this.alpha = (float) this.age / (this.lifetime);
        if (progress < 0.5f) {
            float stageProgress = progress * 2;
            interpolateColor(stageProgress, COLOR_STAGES[0], COLOR_STAGES[1]);
        } else {
            float stageProgress = (progress - 0.5f) * 2;
            interpolateColor(stageProgress, COLOR_STAGES[1], COLOR_STAGES[2]);
        }

        this.x = targetPlayer.getX();
        this.y = targetPlayer.getY() + 1;
        this.z = targetPlayer.getZ();
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

    @Override
    protected int getLightColor(float pPartialTick) {
        return LightTexture.FULL_BLOCK;
    }

    @OnlyIn(Dist.CLIENT)
    public static class QiCondensationBreakthrough3ParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public QiCondensationBreakthrough3ParticleProvider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {
            Player nearestPlayer = level.getNearestPlayer(x, y, z, 10, false);
            if (nearestPlayer != null) {
                return new QiCondensationBreakthrough3Particle(level, nearestPlayer, x, y, z, xSpeed, ySpeed, zSpeed, sprites);
            }
            return null; // 无玩家时不生成
        }
    }
}
