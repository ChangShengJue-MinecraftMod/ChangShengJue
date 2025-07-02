package com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.breakthrough.mortal;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MortalBreakthrough0Particle extends TextureSheetParticle {
    private final Player targetPlayer;
    private final float endR;
    private final float endG;
    private final float endB;

    public MortalBreakthrough0Particle(ClientLevel pLevel, Player player, double pX, double pY, double pZ,
                                       double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pXSpeed,pYSpeed,pZSpeed);
        this.targetPlayer = player;
        this.rCol = 0.6f;
        this.gCol = 1.0f;
        this.bCol = 0.8f;
        this.endR = 0.18f;
        this.endG = 0.7f;
        this.endB = 0.82f;
        this.lifetime = 60;
        this.quadSize = 0.02f;
        this.alpha = 1.0f;
        this.friction = 1.0f;
        this.setSpriteFromAge(pSprites);
        this.hasPhysics = false;
    }

    @Override
    public void tick() {
        super.tick();

        float minSize = 0.02f;  // 初始极小尺寸
        float maxSize = 0.05f;  // 最大尺寸（保持较小）
        float sizeProgress = (float)this.age / (float)this.lifetime;
        // 使用正弦缓动
        float easedProgress = Mth.sin(sizeProgress * (float)Math.PI * 0.5f);
        this.quadSize = Mth.lerp(easedProgress, minSize, maxSize);

        // 计算颜色渐变进度
        this.rCol = Mth.lerp(easedProgress, this.rCol, endR);
        this.gCol = Mth.lerp(easedProgress, this.gCol, endG);
        this.bCol = Mth.lerp(easedProgress, this.bCol, endB);

        // 消失条件检查
        if (shouldRemove()) {
            this.remove();
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    private boolean shouldRemove() {
        return (targetPlayer.getBoundingBox().inflate(0.1).contains(this.x, this.y, this.z));
    }

    @OnlyIn(Dist.CLIENT)
    public static class BreakthroughParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public BreakthroughParticleProvider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {
            Player nearestPlayer = level.getNearestPlayer(x, y, z, 30, false);
            if (nearestPlayer != null) {
                return new MortalBreakthrough0Particle(level, nearestPlayer, x, y, z, xSpeed, ySpeed, zSpeed, sprites);
            }
            return null; // 无玩家时不生成
        }
    }
}
