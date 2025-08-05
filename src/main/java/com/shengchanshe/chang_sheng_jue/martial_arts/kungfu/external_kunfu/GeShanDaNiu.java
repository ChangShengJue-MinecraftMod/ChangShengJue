package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.combat.ge_shan_da_niu.GeShanDaNiuEntity;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import com.shengchanshe.chang_sheng_jue.util.EffectUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GeShanDaNiu extends AbstractionExternalKunfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "ge_shan_da_niu");
    // 攻击范围
    protected float range = 4.0f;

    public GeShanDaNiu() {
        super(KUNG_FU_ID.toString(),
                Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.YELLOW),
                KungFuType.EXTERNAL_KUNFU_GLOVE,
                "description",0.0f,0.15f,2,0.0f,
                0.25f,6);
    }

    @Override
    public void release(LivingEntity pEntity) {
        if (!isReady()) return;

        if (pEntity instanceof Player player) {
            if (!player.getAbilities().instabuild) {
                int maxCoolDown = (getMaxCoolDown() - wheatNuggetsTributeWineEffect(player));
                cooldown = maxCoolDown;
                int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? hunger - 1 : hunger;
                player.getFoodData().eat(-foodLevel, getSaturation());
                player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), maxCoolDown);
            }
            biluochunTeasAndLongJingTeasEffect(player);
        }

        Level pLevel = pEntity.level();
        float radius = getRange();//攻击半径
        float distance = 2.0F;//攻击距离
        Vec3 forward = pEntity.getForward();//获取实体的前方方向

        Vec3 hitLocation = pEntity.position().add(0, pEntity.getBbHeight() * 0.3f, 0).add(forward.scale(distance));// 获取实体高度的面向,计算攻击和实体生成的位置
        var entities = pLevel.getEntities(pEntity, AABB.ofSize(hitLocation, radius, radius * 2, radius));// 创建包围盒

        for (Entity entity : entities) {//遍历包围盒中的实体
            if (pEntity.isPickable() && pEntity.distanceToSqr(entity) < radius * radius && entity instanceof LivingEntity && entity.isAlive()) {
                if (entity.hurt(new DamageSource(pLevel.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                        .getHolderOrThrow(getDamageType()), pEntity), getDamage(pEntity))) {//造成伤害
                    EnchantmentHelper.doPostDamageEffects(pEntity, entity);//应用附魔
                    if (entity instanceof LivingEntity livingEntity) {
                        float probability = randomSource.nextFloat();
                        if (probability < getEffectProbability()) {
                            ((LivingEntity) entity).addEffect(new MobEffectInstance(ChangShengJueEffects.AIRBORNE_EFFECT.get(),
                                    30, 1, false, false), pEntity);
                        }
                        EffectUtils.setInternal(pEntity, livingEntity, 1,300, traumaProbability);
                    }
                    if (pEntity instanceof Player player) {
                        addExp(pEntity, !player.getAbilities().instabuild ? 1 : 100);
                    }
                }
            }
        }
        pEntity.getMainHandItem().getItem().getDefaultInstance().hurtAndBreak(1, pEntity, (player1) -> player1.broadcastBreakEvent(pEntity.getUsedItemHand()));
        GeShanDaNiuEntity geShanDaNiuEntity = new GeShanDaNiuEntity(ChangShengJueEntity.GE_SHAN_DA_NIU.get(), pLevel);
        geShanDaNiuEntity.moveTo(hitLocation);
        geShanDaNiuEntity.setYRot(pEntity.getYRot());
        geShanDaNiuEntity.setXRot(pEntity.getXRot());
        pLevel.addFreshEntity(geShanDaNiuEntity);
    }

    public float getRange() {
        if (level == 1) {
            return range;
        }else if (level == 2) {
            return range + 2.0f;
        }else {
            return range + 2.0f * level;
        }
    }

    @Override
    public float getDamage(LivingEntity entity) {
        damage = funJiuEffect(entity, 22);
        return (damage * getDamageFactor());
    }

    @Override
    public void attackEffect(LivingEntity source, Entity target) {
        super.attackEffect(source, target);
        if (target instanceof LivingEntity livingEntity) {
            if (isStart) {
                if (isComprehend && level > 0) {
                    if (target != source) {
                        EffectUtils.setInternal(source, livingEntity, 0,300, traumaProbability);
                    }
                }
            }
        }
    }

    @Override
    public int getMaxCoolDown() {
        return KungFuConfig.GE_SHAN_DA_NIU_MAX_COOLDOWN.get();
    }

    @Override
    public int getSwingTick() {
        return 6;
    }
    @Override
    public int getMaxLevel() {
        return KungFuConfig.GE_SHAN_DA_NIU_MAX_LEVEL.get();
    }

    @Override
    public int getMaxExp() {
        return KungFuConfig.GE_SHAN_DA_NIU_MAX_EXP.get();
    }
    @Override
    public float getDamageFactor() {
        if (level >= 1 && level <= 2) {
            return 1.0f;
        }else {
            return (level) * 1.3f;
        }
    }

    @Override
    public float getEffectProbability() {
        return super.getEffectProbability();
    }
}
