package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import com.shengchanshe.chang_sheng_jue.util.EffectUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class TurtleBreathWork extends AbstractionExternalKunfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "turtle_breath_work");
    public TurtleBreathWork() {
        super(KUNG_FU_ID.toString(),
                Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.BLUE),
                KungFuType.EXTERNAL_KUNFU_GLOVE,
                Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".glove.type"),0.0f,0.15f,2,0.0f,
                0.25f,3);
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
            player.addEffect(new MobEffectInstance(ChangShengJueEffects.TURTLE_BREATH_EFFECT.get(), 300, 0, false, true), player);
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 900, level <= 1 ? 1 : 2));
            addExp(pEntity, !player.getAbilities().instabuild ? 1 : 100);
            biluochunTeasAndLongJingTeasEffect(player);
        }
        pEntity.getMainHandItem().getItem().getDefaultInstance().hurtAndBreak(1, pEntity,
                (player1) -> player1.broadcastBreakEvent(pEntity.getUsedItemHand()));
    }
    @Override
    public float getDamage(LivingEntity entity) {
        return 0;
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
    public Component getDescription() {
        return Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".glove.type");
    }

    @Override
    public int getMaxCoolDown() {
        return KungFuConfig.TURTLE_BREATH_WORK_MAX_COOLDOWN.get();
    }

    @Override
    public int getSwingTick() {
        return 3;
    }
    @Override
    public int getMaxLevel() {
        return KungFuConfig.TURTLE_BREATH_WORK_MAX_LEVEL.get();
    }

    @Override
    public int getMaxExp() {
        return KungFuConfig.TURTLE_BREATH_WORK_MAX_EXP.get();
    }
    @Override
    public float getDamageFactor() {
        return 1.0f;
    }

    @Override
    public float getEffectProbability() {
        return super.getEffectProbability();
    }

}
