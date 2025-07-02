package com.shengchanshe.chang_sheng_jue.util;

import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.ChangShengJueArmorItem;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.qi_tian_da_sheng.QiTianDaSheng;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;

public class EffectUtils {

    public static void setTrauma(LivingEntity source,LivingEntity target, int traumaLevel, int duration, float probability){
        float probability1 = source.getRandom().nextFloat();
        if (target.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof ChangShengJueArmorItem changShengJueArmorItem) {
            probability =  probability - changShengJueArmorItem.getTrauma(target.getItemBySlot(EquipmentSlot.CHEST));
        }else if (target.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof QiTianDaSheng qiTianDaSheng) {
            probability =  probability - qiTianDaSheng.getTrauma(target.getItemBySlot(EquipmentSlot.CHEST));
        }
        if (probability1 < probability) {
            if (!(target instanceof Zombie)){
                int level = source.getRandom().nextInt(traumaLevel); // 0或1

                // 如果已有外伤效果，延长1秒并保持最高等级
                if (target.hasEffect(ChangShengJueEffects.TRAUMA_EFFECT.get())) {
                    MobEffectInstance oldEffect = target.getEffect(ChangShengJueEffects.TRAUMA_EFFECT.get());
                    if (oldEffect != null) {
                        duration = oldEffect.getDuration() + 20;
                        level = Math.max(level, oldEffect.getAmplifier());
                    }
                }

                target.addEffect(new MobEffectInstance(
                        ChangShengJueEffects.TRAUMA_EFFECT.get(), duration, level,
                        true,
                        true,
                        true
                ), source);
            }
        }
    }

}
