package com.shengchanshe.changshengjue.event.armor;

import com.shengchanshe.changshengjue.damage.CSJDamageTypes;
import com.shengchanshe.changshengjue.item.combat.armor.ChangShengJueArmorItem;
import com.shengchanshe.changshengjue.item.combat.armor.cotton.CottonArmor;
import com.shengchanshe.changshengjue.item.combat.armor.qi_tian_da_sheng.QiTianDaSheng;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

public class ArmorEvent {

    public static void onArmorDamage(LivingDamageEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            LivingEntity entity = event.getEntity();
            float originalDamage = event.getAmount();
            float damageMultiplier = 1.0f;
            DamageSource source = event.getSource();
            if (entity != null){
                if (itemBySlot(entity)){
                    if (source.is(DamageTypes.ON_FIRE)){
                        float increasedDamage = originalDamage * 2f;
                        event.setAmount(increasedDamage);
                    }
                    if (event.getSource().getDirectEntity() instanceof AbstractArrow){
                        float probability = entity.getRandom().nextFloat();
                        if (probability < 0.05F) {
                            event.setCanceled(true);
                        }
                    }
                }
                if (source.is(CSJDamageTypes.MARTIAL_ARTS)) {
                    if (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof ChangShengJueArmorItem changShengJueArmorItem) {
                        float damageReduction = changShengJueArmorItem.getDamageReduction(entity.getItemBySlot(EquipmentSlot.CHEST));
                        event.setAmount(originalDamage * (damageMultiplier - damageReduction));
                    }else if (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof QiTianDaSheng qiTianDaSheng){
                        float damageReduction = qiTianDaSheng.getDamageReduction(entity.getItemBySlot(EquipmentSlot.CHEST));
                        event.setAmount(originalDamage * (damageMultiplier - damageReduction));
                    }else {
                        event.setAmount(originalDamage * damageMultiplier);
                    }
                }
            }
        }
    }
    public static boolean itemBySlot(LivingEntity entity){
        return entity.getItemBySlot(EquipmentSlot.HEAD).getItem()  instanceof CottonArmor
                && entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof CottonArmor
                && entity.getItemBySlot(EquipmentSlot.LEGS).getItem()  instanceof CottonArmor
                && entity.getItemBySlot(EquipmentSlot.FEET).getItem()  instanceof CottonArmor;
    }

}
