package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import com.shengchanshe.chang_sheng_jue.util.EffectUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class SunflowerPointCaveman extends AbstractionExternalKunfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "sunflower_point_caveman");

    public SunflowerPointCaveman() {
        super(KUNG_FU_ID.toString(),
                Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.GOLD),
                KungFuType.EXTERNAL_KUNFU_GLOVE,
                "description",0.1f,0.15f,2,0.25f,
                0.25f, 3);
    }

    @Override
    public float getDamage(LivingEntity entity) {
        return 0;
    }

    @Override
    public float getDamageFactor() {
        return 0;
    }

    @Override
    public void release(LivingEntity livingEntity) {
        if (!isReady()) return;

        if (livingEntity instanceof Player player) {
            if (!player.getAbilities().instabuild) {
                int maxCoolDown = (getMaxCoolDown() - wheatNuggetsTributeWineEffect(player));
                cooldown = maxCoolDown;
                int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? hunger - 1 : hunger;
                player.getFoodData().eat(-foodLevel, getSaturation());
                player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), maxCoolDown);
            }
            biluochunTeasAndLongJingTeasEffect(player);
            Vec3 lookVec = player.getLookAngle();
            Vec3 startVec = player.getEyePosition(1.0F);
            Vec3 endVec = startVec.add(lookVec.x * 5, lookVec.y * 5, lookVec.z * 5);

            EntityHitResult result = ProjectileUtil.getEntityHitResult(
                    player,
                    startVec,
                    endVec,
                    new AABB(startVec, endVec),
                    entity -> !entity.isSpectator() && entity.isPickable(), 5 * 5);

            if (result != null && result.getEntity() instanceof LivingEntity target) {
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        ChangShengJueSound.SUNFLOWER_POINT_CAVEMAN_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                target.addEffect(new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), getEffectTick(), 1, false, true), player);
                addExp(player, !player.getAbilities().instabuild ? 1 : getMaxExp());
            }
        }
        livingEntity.getMainHandItem().getItem().getDefaultInstance().hurtAndBreak(1, livingEntity, (player1) -> player1.broadcastBreakEvent(livingEntity.getUsedItemHand()));
    }

    @Override
    public void release(LivingEntity source, LivingEntity target) {
        if (!isReady()) return;

        if (source instanceof Player player) {
            if (!player.getAbilities().instabuild) {
                cooldown = getMaxCoolDown();
                int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? hunger - 1
                        : player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) ? 3 : hunger;
                player.getFoodData().eat(-foodLevel, getSaturation()); // 消耗饱食度
                player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), getMaxCoolDown()); //添加使用冷却
            }
        }
        if (target.getHealth() < getHealth()) {
            source.level().playSound(null, source.getX(), source.getY(), source.getZ(),
                    ChangShengJueSound.SUNFLOWER_POINT_CAVEMAN_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
            target.addEffect(new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), getEffectTick(), 1, false, true), source);
            if (source instanceof Player player) {
                addExp(source, !player.getAbilities().instabuild ? 1 : getMaxExp());
            }
        }
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
        return KungFuConfig.SUNFLOWER_POINT_CAVEMAN_MAX_COOLDOWN.get();
    }

    @Override
    public int getMaxLevel() {
        return KungFuConfig.SUNFLOWER_POINT_CAVEMAN_MAX_LEVEL.get();
    }

    @Override
    public int getMaxExp() {
        return KungFuConfig.SUNFLOWER_POINT_CAVEMAN_MAX_EXP.get();
    }

    public int getEffectTick(){
        int effectTick;
        if (level == 1) {
            effectTick = 40;
        }else if (level == 2) {
            effectTick = 60;
        }else {
            effectTick = 60 + 5 * level;
        }
        return effectTick;
    }

    public float getHealth() {
        float health;
        if (level == 1) {
            health = 25;
        }else if (level == 2) {
            health = 200;
        }else {
            health = 200 + 100 * level;
        }
        return health;
    }
}
