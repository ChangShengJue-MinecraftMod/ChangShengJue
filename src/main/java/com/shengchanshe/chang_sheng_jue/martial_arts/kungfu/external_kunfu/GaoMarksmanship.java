package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.item.combat.lance.Lance;
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

public class GaoMarksmanship extends AbstractionExternalKunfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "gao_marksmanship");

    public GaoMarksmanship() {
        super(KUNG_FU_ID.toString(),
                Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.RED),
                KungFuType.EXTERNAL_KUNFU,
                Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".lance.type"),0.1f,0.15f,2,0.0f,
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
        float radius = 5.0f;//攻击半径
        float distance = 5.0F;//攻击距离
        Vec3 forward = pEntity.getForward();//获取实体的前方方向

        Vec3 hitLocation = pEntity.position().add(0, pEntity.getBbHeight() * 0.3f, 0).add(forward.scale(distance));// 获取实体高度的面向,计算攻击和实体生成的位置
        var entities = pLevel.getEntities(pEntity, AABB.ofSize(hitLocation, radius * 2, radius * 2, radius * 2));// 创建包围盒

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
                        EffectUtils.setTrauma(pEntity, livingEntity, 5,140, traumaProbability);
                    }
                    if (pEntity instanceof Player player) {
                        addExp(pEntity, !player.getAbilities().instabuild ? 1 : 100);
                    }
                }
            }
        }
        pEntity.getMainHandItem().getItem().getDefaultInstance().hurtAndBreak(1, pEntity, (player1) -> player1.broadcastBreakEvent(pEntity.getUsedItemHand()));
    }

    @Override
    public float getDamage(LivingEntity entity) {
        if (entity.getMainHandItem().getItem() instanceof Lance lance){
            damage = funJiuEffect(entity, lance.getDamage());
        }
        return ((damage + 2) * getDamageFactor());
    }

    @Override
    public void attackEffect(LivingEntity source, Entity target) {
        if (target instanceof LivingEntity livingEntity) {
            if (target != source) {
                if (randomSource.nextFloat() < getEffectProbability()) {
                    livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.AIRBORNE_EFFECT.get(),
                            30, 1, false, true), source);
                }
                if (isComprehend && level > 0) {
                    super.attackEffect(source, target);
                    EffectUtils.setTrauma(source, livingEntity, 2, 140, traumaProbability);
                }
            }
        }
    }

    @Override
    public Component getDescription() {
        return Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".lance.type");
    }

    @Override
    public int getSwingTick() {
        return 6;
    }
    @Override
    public int getMaxLevel() {
        return KungFuConfig.GAO_MARKSMANSHIP_MAX_LEVEL.get();
    }

    @Override
    public int getMaxExp() {
        return KungFuConfig.GAO_MARKSMANSHIP_MAX_EXP.get();
    }
    @Override
    public float getDamageFactor() {
        if (level == 1){
            return 1.8f;
        }else if (level == 2){
            return 2.1f;
        }else {
            return level * 2.1f;
        }
    }

    @Override
    public int getMaxCoolDown() {
        return KungFuConfig.GAO_MARKSMANSHIP_MAX_COOLDOWN.get();
    }

    @Override
    public float getEffectProbability() {
        if (level >= 2){
            return super.getEffectProbability() * 2.5f;
        }else {
            return super.getEffectProbability();
        }
    }
}
