package com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.breakthrough.qi_condensation;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.chang_sheng_jue.particle.custom.VerticalParticle;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QiCondensationBreakthrough1Particle extends VerticalParticle {
    private final Player targetPlayer;
    private static final float[][] COLOR_STAGES = {
            {0.9f, 1.0f, 0.48f},  // 阶段1: 亮黄绿
            {0.6f, 1.0f, 0.38f},   // 阶段2: 草绿
            {0.27f, 0.43f, 0.74f}, // 阶段3: 深蓝
            {0.49f, 1.0f, 0.89f},  // 阶段4: 浅青
            {1.0f, 0.94f, 0.7f}    // 阶段5: 暖白
    };

    public QiCondensationBreakthrough1Particle(ClientLevel pLevel, Player player, double pX, double pY, double pZ,
                                               double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pXSpeed,pYSpeed,pZSpeed);
        this.targetPlayer = player;
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.gravity = -0.1f;
        this.lifetime = 20;
        this.quadSize *= 0.75f;
        this.alpha = 1.0f;
        this.setSpriteFromAge(pSprites);
    }

    @Override
    public void tick() {
        super.tick();
        float sizeProgress = (float)this.age / (float)this.lifetime;
        float easedProgress = Mth.sin(sizeProgress * (float)Math.PI * 0.5f);
        this.alpha = Mth.lerp(easedProgress, 1.0f, 0.0f);
        // 五阶段颜色插值
        if (sizeProgress < 0.25f) {
            // 阶段1→2 (0%-25%)
            float stageProgress = sizeProgress * 4;
            interpolateColor(stageProgress, COLOR_STAGES[0], COLOR_STAGES[1]);
        } else if (sizeProgress < 0.5f) {
            // 阶段2→3 (25%-50%)
            float stageProgress = (sizeProgress - 0.25f) * 4;
            interpolateColor(stageProgress, COLOR_STAGES[1], COLOR_STAGES[2]);
        } else if (sizeProgress < 0.75f) {
            // 阶段3→4 (50%-75%)
            float stageProgress = (sizeProgress - 0.5f) * 4;
            interpolateColor(stageProgress, COLOR_STAGES[2], COLOR_STAGES[3]);
        } else {
            // 阶段4→5 (75%-100%)
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

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTicks) {
        super.verticalRenderer(buffer,camera,partialTicks,0.03f,0.7f);
    }

    @OnlyIn(Dist.CLIENT)
    public static class QiCondensationBreakthrough1ParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public QiCondensationBreakthrough1ParticleProvider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {
            Player nearestPlayer = level.getNearestPlayer(x, y, z, 10, false);
            if (nearestPlayer != null) {
                return new QiCondensationBreakthrough1Particle(level, nearestPlayer, x, y, z, xSpeed, ySpeed, zSpeed, sprites);
            }
            return null; // 无玩家时不生成
        }
    }
}
