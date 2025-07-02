package com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.tun_na;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TunNa1Particle extends SimpleAnimatedParticle {
    private final Player targetPlayer;
    private final Vec3 initialPos;
    private final float baseSpeed;

    public TunNa1Particle(ClientLevel pLevel, Player player, double pX, double pY, double pZ, SpriteSet pSprites, float speed) {
        super(pLevel, pX, pY, pZ, pSprites, 0.0F);
        this.targetPlayer = player;
        this.initialPos = new Vec3(x, y, z);
        this.baseSpeed = speed;
        this.setSpriteFromAge(sprites);
        this.lifetime = 100;
        this.quadSize *= 0.1f;
        this.gravity = 0;
        this.alpha = 0.3f;
        this.hasPhysics = false;
    }

    @Override
    public void tick() {
        super.tick();

        // 计算目标方向
        Vec3 targetPos = targetPlayer.position().add(0, 1.0, 0); // 瞄准玩家胸口
        Vec3 direction = targetPos.subtract(this.x, this.y, this.z).normalize();

        // 动态速度：距离越远速度越快
        double distance = targetPos.distanceTo(this.initialPos);
//        double speedFactor = Mth.clamp(1.5 - (distance / 10.0), 0.5, 1.5);距离越近速度越快
        double speedFactor = Mth.clamp(distance / 8, 0.5, 3.0); // 距离每增加8格，速度提升

        double currentSpeed = baseSpeed * speedFactor;

        // 更新位置
        this.xd = direction.x * currentSpeed;
        this.yd = direction.y * currentSpeed;
        this.zd = direction.z * currentSpeed;
        this.move(xd, yd, zd);

        // 动态透明度：距离越近透明度越高 (0-1.0范围)
        float maxDistance = 3.0f; // 最大有效距离（超过此距离透明度为0）
        float minDistance = 0.3f;  // 最小距离（避免除零）
        float normalizedDistance = Mth.clamp((float)distance, minDistance, maxDistance);
        this.alpha = 0.3f - (normalizedDistance - minDistance) / (maxDistance - minDistance);

        // 消失条件检查
        if (shouldRemove()) {
            this.remove();
        }
    }

    private boolean shouldRemove() {
        // 碰到玩家或者透明度为零时消失
        return (this.alpha <= 0.0f || targetPlayer.getBoundingBox().inflate(-0.1).contains(this.x, this.y, this.z));
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public int getLightColor(float partialTick) {
        return LightTexture.FULL_BRIGHT; // 发光粒子需全亮度
    }

    @OnlyIn(Dist.CLIENT)
    public static class TunNa1ParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public TunNa1ParticleProvider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {
            Player nearestPlayer = level.getNearestPlayer(x, y, z, 10, false);
            if (nearestPlayer != null) {
                return new TunNa1Particle(level, nearestPlayer, x, y, z, sprites, 0.02f);
            }
            return null; // 无玩家时不生成
        }
    }
}
