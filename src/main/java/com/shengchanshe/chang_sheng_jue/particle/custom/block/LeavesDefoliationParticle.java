package com.shengchanshe.chang_sheng_jue.particle.custom.block;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LeavesDefoliationParticle extends TextureSheetParticle {
    private final float endRed;
    private final float endGreen;
    private final float endBlue;
    protected LeavesDefoliationParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
                                        SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(level, xCoord, yCoord, zCoord, pXSpeed, pYSpeed, pZSpeed);
        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;

        // 设置结束颜色（淡褐色）
        this.endRed = 0.7F;
        this.endGreen = 0.5F;
        this.endBlue = 0.3F;
//
        this.setColor(rCol, gCol, bCol); // 设置粒子的初始颜色
        this.pickSprite(spriteSet);
        this.friction = 0.8F;
        this.xd = pXSpeed * 0.1;
        this.yd = pYSpeed * 0.1;
        this.zd = pZSpeed * 0.1;
        this.quadSize *= 1.5F;
        this.lifetime = 500;
        this.setSpriteFromAge(spriteSet);
        this.gravity = 0.5F;


        this.hasPhysics = false; // 粒子是否可以被碰撞
    }

    @Override
    public void tick() {
        super.tick();
        fadeOut();
        // 计算当前生命周期的进度
        float lifeProgress = (float)this.age / (float)this.lifetime;

        // 根据生命周期进度插值计算颜色
        float red = this.rCol + lifeProgress * (endRed - this.rCol);
        float green = this.gCol + lifeProgress * (endGreen - this.gCol);
        float blue = this.bCol + lifeProgress * (endBlue - this.bCol);

        // 设置当前颜色
        this.setColor(red, green, blue);

        this.xd = 0.05;
        this.yd = -0.1;

        // 控制下落速度，避免粒子直接掉落太快
        if (this.onGround) {
            this.remove();  // 当粒子碰到地面时移除它
        }

    }

    private void fadeOut() {
        this.alpha = (-(1/(float)lifetime) * age + 1);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z,
                                       double pXSpeed, double pYSpeed, double pZSpeed) {
            return new LeavesDefoliationParticle(level, x, y, z, this.sprites, pXSpeed, pYSpeed, pZSpeed);
        }
    }
}