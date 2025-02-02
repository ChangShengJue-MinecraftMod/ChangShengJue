package com.shengchanshe.changshengjue.event.armor;

import com.shengchanshe.changshengjue.damage.CSJDamageTypes;
import com.shengchanshe.changshengjue.item.combat.armor.cotton.CottonArmor;
import com.shengchanshe.changshengjue.item.combat.armor.flying_fish_robe.FlyingFishRobe;
import com.shengchanshe.changshengjue.item.combat.armor.mountain_pattern_armor.MountainPatternArmor;
import com.shengchanshe.changshengjue.item.combat.armor.qi_tian_da_sheng.QiTianDaSheng;
import com.shengchanshe.changshengjue.item.combat.armor.taoistrobes.TaoistRobes;
import com.shengchanshe.changshengjue.item.combat.armor.walker_set.WalkerSet;
import com.shengchanshe.changshengjue.item.combat.armor.wedding.ChineseWeddingDress;
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
                    if (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof CottonArmor) {
                        event.setAmount(originalDamage * (damageMultiplier - 0.3F));
                    }else if (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof TaoistRobes){
                        event.setAmount(originalDamage * (damageMultiplier - 0.25F));
                    }else if (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof ChineseWeddingDress){
                        event.setAmount(originalDamage * (damageMultiplier - 0.2F));
                    }else if (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof MountainPatternArmor){
                        event.setAmount(originalDamage * (damageMultiplier - 0.3F));
                    }else if (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof WalkerSet){
                        event.setAmount(originalDamage * (damageMultiplier - 0.25F));
                    }else if (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof FlyingFishRobe){
                        event.setAmount(originalDamage * (damageMultiplier - 0.25F));
                    }else if (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof QiTianDaSheng){
                        event.setAmount(originalDamage * (damageMultiplier - 0.4F));
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
