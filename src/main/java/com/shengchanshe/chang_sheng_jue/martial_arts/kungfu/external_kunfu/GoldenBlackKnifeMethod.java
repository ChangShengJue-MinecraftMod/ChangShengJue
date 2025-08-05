package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.combat.golden_black_knife_method.GoldenBlackKnifeMethodEntity;
import com.shengchanshe.chang_sheng_jue.item.combat.knife.Knife;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import com.shengchanshe.chang_sheng_jue.util.EffectUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GoldenBlackKnifeMethod extends AbstractionExternalKunfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "golden_black_knife_method");

    public GoldenBlackKnifeMethod() {
        super(KUNG_FU_ID.toString(),
                Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.GOLD),
                KungFuType.EXTERNAL_KUNFU,
                "description",0.1f,0.15f,2,0.0f,
                0.25f, 6);
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
        float radius = 4.0F;//攻击半径
        float distance = 4.0F;//攻击距离
        Vec3 forward = pEntity.getForward();//获取实体的前方方向

        Vec3 hitLocation = pEntity.position().add(0, pEntity.getBbHeight() * 0.3f, 0).add(forward.scale(distance));// 获取实体高度的面向,计算攻击和实体生成的位置
        var entities = pLevel.getEntities(pEntity, AABB.ofSize(hitLocation, radius * 2, radius * 2, radius * 2));// 创建包围盒

        for (Entity entity : entities) {// 遍历包围盒中的实体
            if (pEntity.isPickable() && pEntity.distanceToSqr(entity) < radius * radius && entity instanceof LivingEntity && entity.isAlive()) {
                float amount = getDamage(pEntity);
                float probability = randomSource.nextFloat();
                if (entity.hurt(new DamageSource(pLevel.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                        .getHolderOrThrow(getDamageType()), pEntity), probability < getEffectProbability() ? amount * 1.8f : amount)) {//造成伤害
                    EnchantmentHelper.doPostDamageEffects(pEntity, entity);//应用附魔
                    if (entity instanceof LivingEntity livingEntity) {
                        EffectUtils.setTrauma(pEntity, livingEntity, 5,140,traumaProbability);
                    }
                    if (pEntity instanceof Player player) {
                        addExp(pEntity, !player.getAbilities().instabuild ? 1 : getMaxExp());
                    }
                }
            }
        }
        pEntity.getMainHandItem().getItem().getDefaultInstance().hurtAndBreak(1, pEntity, (player1) -> player1.broadcastBreakEvent(pEntity.getUsedItemHand()));
        pLevel.playSound(null, pEntity.getX(), pEntity.getY(), pEntity.getZ(),
                ChangShengJueSound.DUGU_NINE_SWORDS_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
        GoldenBlackKnifeMethodEntity goldenBlackKnifeMethodEntity = new GoldenBlackKnifeMethodEntity(ChangShengJueEntity.GOLDEN_BLACK_KNIFE_METHOD.get(), pLevel);
        goldenBlackKnifeMethodEntity.moveTo(hitLocation);
        goldenBlackKnifeMethodEntity.setYRot(pEntity.getYRot());
        goldenBlackKnifeMethodEntity.setXRot(-pEntity.getXRot());
        pLevel.addFreshEntity(goldenBlackKnifeMethodEntity);
    }

    @Override
    public float getDamage(LivingEntity entity) {
        if (entity.getMainHandItem().getItem() instanceof Knife knife) {
            damage = funJiuEffect(entity, knife.getDamage());
        }
        return ((damage + 2) * getDamageFactor());
    }

    @Override
    public void attackEffect(LivingEntity source, Entity target) {
        super.attackEffect(source, target);
        if (target instanceof LivingEntity livingEntity) {
            if (isStart) {
                if (isComprehend && level > 0) {
                    if (target != source) {
                        EffectUtils.setTrauma(source, livingEntity, 2,140, traumaProbability);
                    }
                }
            }
        }
    }

    @Override
    public int getSwingTick() {
        return 6;
    }

    @Override
    public float getDamageFactor() {
        if (level == 1){
            return 1.9f;
        }else if (level == 2){
            return 2.0f;
        }else {
            return level * 2.0f;
        }
    }

    @Override
    public float getEffectProbability() {
        if (level >= 2){
            return super.getEffectProbability() * 2.0f;
        }else {
            return super.getEffectProbability();
        }
    }

    @Override
    public int getMaxCoolDown() {
        return KungFuConfig.GOLDEN_BLACK_KNIFE_METHOD_MAX_COOLDOWN.get();
    }

    @Override
    public int getMaxLevel() {
        return KungFuConfig.GOLDEN_BLACK_KNIFE_METHOD_MAX_LEVEL.get();
    }

    @Override
    public int getMaxExp() {
        return KungFuConfig.GOLDEN_BLACK_KNIFE_METHOD_MAX_EXP.get();
    }
}
