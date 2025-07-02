package com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.breakthrough.mortal;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.chang_sheng_jue.particle.custom.VerticalParticle;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MortalBreakthrough2Particle extends VerticalParticle {
    private final Player targetPlayer;
    private final float endR; // 目标天蓝色 (RGB: 0.53, 0.81, 0.92)
    private final float endG;
    private final float endB;

    public MortalBreakthrough2Particle(ClientLevel pLevel, Player player, double pX, double pY, double pZ,
                                       double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
        this.targetPlayer = player;
        this.rCol = 0.6f;
        this.gCol = 1.0f;
        this.bCol = 0.8f;
        this.endR = 0.18f;
        this.endG = 0.7f;
        this.endB = 0.82f;
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.gravity = -0.5f;
        this.lifetime = 40;
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
        // 计算颜色渐变进度
        this.rCol = Mth.lerp(easedProgress, this.rCol, endR);
        this.gCol = Mth.lerp(easedProgress, this.gCol, endG);
        this.bCol = Mth.lerp(easedProgress, this.bCol, endB);
    }

    @Override
    public void render(VertexConsumer buffer, Camera camera, float partialTicks) {
        super.verticalRenderer(buffer,camera,partialTicks,0.03f,0.7f);
    }

    @OnlyIn(Dist.CLIENT)
    public static class Breakthrough2ParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Breakthrough2ParticleProvider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {
            Player nearestPlayer = level.getNearestPlayer(x, y, z, 10, false);
            if (nearestPlayer != null) {
                return new MortalBreakthrough2Particle(level, nearestPlayer, x, y, z, xSpeed, ySpeed, zSpeed, sprites);
            }
            return null; // 无玩家时不生成
        }
    }
}
