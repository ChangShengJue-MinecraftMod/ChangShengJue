package com.shengchanshe.changshengjue.effect.martial_arts;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.effect.EffectEntityPacket;
import com.shengchanshe.changshengjue.particle.ChangShengJueParticles;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeMod;

import java.util.Random;

public class DizzyEffect extends MobEffect {
    public DizzyEffect() {
        super(MobEffectCategory.HARMFUL, 00000000);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "ED1ED20F-766A-286D-BE69-C61A93AFC5A8",-1.0, AttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "E322D6CB-4C6F-9E12-FB4F-74D1DF6B86BA",-1.0, AttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(ForgeMod.ENTITY_GRAVITY.get(), "6E0B7E9C-1DEF-E820-92C9-C15E84F30FB8",10000.0, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
//        super.applyEffectTick(pLivingEntity, pAmplifier);
        if (this == ChangShengJueEffects.FIXATION_EFFECT.get()) {
            if (pLivingEntity.level().isClientSide){
                if (pLivingEntity.getEffect(ChangShengJueEffects.FIXATION_EFFECT.get()).getDuration() % 20 == 0){
                    pLivingEntity.level().addParticle(ChangShengJueParticles.SUNFLOWER_POINT_CAVEMAN_PARTICLE.get(),pLivingEntity.getX(),pLivingEntity.getEyeY() + 0.5,pLivingEntity.getZ(),pLivingEntity.getId(),0,0);
                    // 玩家当前坐标
                    double playerX = pLivingEntity.getX();
                    double playerY = pLivingEntity.getY() + pLivingEntity.getBbHeight() * 0.6; // 胸部高度
                    double playerZ = pLivingEntity.getZ();

                    // 获取玩家的朝向角度
                    float yaw = pLivingEntity.getYRot(); // 水平角度 (-180 到 180)

                    // 将角度转换为弧度
                    double yawRad = Math.toRadians(yaw);

                    // 计算粒子在玩家胸前的偏移量
                    double offsetX = -Math.sin(yawRad) * 0.2; // 前方向的 X 偏移
                    double offsetZ = Math.cos(yawRad) * 0.2;  // 前方向的 Z 偏移

                    // 最终粒子位置
                    double chestX = playerX + offsetX;
                    double chestY = playerY; // 胸部高度不变
                    double chestZ = playerZ + offsetZ;

                    pLivingEntity.level().addParticle(ChangShengJueParticles.SUNFLOWER_POINT_CAVEMAN_PARTICLE_1.get(),chestX,chestY,chestZ,pLivingEntity.getId(),0,0);
                }
                // 创建随机数生成器
                Random random = new Random();
                // 玩家脚部位置
                double centerX = pLivingEntity.getX();
                double centerY = pLivingEntity.getY(); // 玩家脚部的 Y 坐标
                double centerZ = pLivingEntity.getZ();

                // 设置圆的半径
                double radius = 0.5;

                // 粒子数量（越多越圆滑）
                int particleCount = 2;

                for (int i = 0; i < particleCount; i++) {
                    // 随机生成角度（0 到 2π 弧度）
                    double angle = 2 * Math.PI * random.nextDouble();

                    // 根据角度计算粒子位置
                    double offsetX1 = Math.cos(angle) * radius;
                    double offsetZ1 = Math.sin(angle) * radius;

                    // 最终粒子坐标
                    double particleX = centerX + offsetX1;
                    double particleY = centerY + 0.1; // 稍微抬高一点，避免粒子被方块遮挡
                    double particleZ = centerZ + offsetZ1;

                    // 生成粒子
                    pLivingEntity.level().addParticle(ChangShengJueParticles.SUNFLOWER_POINT_CAVEMAN_PARTICLE_2.get(), particleX, particleY, particleZ, pLivingEntity.getId(), 0, 0);
                }
            }
        }
    }
    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
        if (!entity.level().isClientSide) {
            MobEffectInstance instance = entity.getEffect(ChangShengJueEffects.FIXATION_EFFECT.get());
            if (instance != null) {
                ChangShengJueMessages.sendMSGToAll(new EffectEntityPacket(entity.getId(), entity.getId(), 0, instance.getDuration()));
            }
        }
        super.addAttributeModifiers(entity, map, i);
    }


    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
