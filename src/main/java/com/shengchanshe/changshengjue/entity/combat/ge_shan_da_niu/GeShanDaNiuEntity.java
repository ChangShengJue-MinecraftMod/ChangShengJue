package com.shengchanshe.changshengjue.entity.combat.ge_shan_da_niu;

import com.shengchanshe.changshengjue.particle.ChangShengJueParticles;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import org.joml.Vector3d;
import software.bernie.example.registry.SoundRegistry;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.util.ClientUtils;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Random;

public class GeShanDaNiuEntity extends Projectile implements GeoEntity {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public GeShanDaNiuEntity(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.noPhysics = true;
    }

    @Override
    public void tick() {
        if (!firstTick) {
            firstTick = true;
        }
        if (level().isClientSide){
            if (this.tickCount % 2 == 0){
                this.geShanDaNiuParticle();
            }
        }
        if (tickCount >= 14){
            discard();
        }
    }

    public void geShanDaNiuParticle(){
        // 获取生物的位置和朝向
        float yaw = this.getYRot();
        float pitch =  this.getXRot();
        // 获取生物的碰撞箱
        double centerX = this.getBoundingBox().getCenter().x;
        double centerY = this.getBoundingBox().getCenter().y + 0.1;
        double centerZ = this.getBoundingBox().getCenter().z;
        // 生成一个随机数生成器
        Random random = new Random();
        // 偏移量，稍微向视角方向移动一点距离
        double offset = 0.2; // 偏移距离
        double radianYaw = Math.toRadians(yaw);
        double radianPitch = Math.toRadians(pitch);
        // 计算偏移后的粒子初始生成点
        double startX = centerX + offset * -Math.sin(radianYaw) * Math.cos(radianPitch);
        double startY = centerY + offset * -Math.sin(radianPitch);
        double startZ = centerZ + offset * Math.cos(radianYaw) * Math.cos(radianPitch);
        // 计算在生物视角方向两格内的随机位置
        double distance = 2 * random.nextDouble(); // 随机距离，范围0-2
        double particleX = startX + distance * -Math.sin(radianYaw) * Math.cos(radianPitch);
        double particleY = startY + distance * -Math.sin(radianPitch);
        double particleZ = startZ + distance * Math.cos(radianYaw) * Math.cos(radianPitch);
        // 计算粒子的随机运动方向，并将速度降低到原来的10%
        double xSpeed = (random.nextDouble() * 2 - 1) * 0.1;
        double ySpeed = (random.nextDouble() * 2 - 1) * 0.1;
        double zSpeed = (random.nextDouble() * 2 - 1) * 0.1;
        // 在计算出的位置生成粒子，并使粒子向计算出的方向运动
        this.level().addParticle(ChangShengJueParticles.GE_SHAN_DA_NIU_PARTICLE.get(), particleX, particleY, particleZ, xSpeed, ySpeed, zSpeed);
    }

    @Override
    protected void defineSynchedData() {

    }
    @Override
    public boolean shouldBeSaved() {
        return false;
    }

    @Override
    public void refreshDimensions() {
        return;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(((new AnimationController<>(this, "idle", 0, (state) ->
                state.setAndContinue(DefaultAnimations.IDLE))
//                .setParticleKeyframeHandler((particleEvent) -> {}
        ).setSoundKeyframeHandler((state) -> {
            Player player = ClientUtils.getClientPlayer();
            if (player != null) {
                player.playSound(ChangShengJueSound.GE_SHAN_DA_NIU_SOUND.get(), 1.0F, 1.0F);
            }})));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
