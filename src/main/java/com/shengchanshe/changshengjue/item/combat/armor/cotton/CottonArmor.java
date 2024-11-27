package com.shengchanshe.changshengjue.item.combat.armor.cotton;

import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CottonArmor extends ArmorItem {

    public CottonArmor(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onCottonArmorDamage(LivingDamageEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            LivingEntity entity = event.getEntity();
            if (entity != null && itemBySlot(entity)){
                if (event.getSource().is(DamageTypes.ON_FIRE)){
                    float originalDamage = event.getAmount();
                    float increasedDamage = originalDamage * 2f;
                    if (increasedDamage % originalDamage == 2){
                        event.setAmount(increasedDamage / 2);
                    }else {
                        event.setAmount(increasedDamage);
                    }
                }
                if (event.getSource().getDirectEntity() instanceof AbstractArrow){
                    float probability = entity.getRandom().nextFloat();
                    if (probability < 0.05F) {
                        event.setCanceled(true);
                    }
                }
            }
        }
    }

    public boolean itemBySlot(LivingEntity entity){
        boolean blueCottonArmor = entity.getItemBySlot(EquipmentSlot.HEAD).is(ChangShengJueItems.BLUE_COTTON_ARMOR_HELMET.get())
                && entity.getItemBySlot(EquipmentSlot.CHEST).is(ChangShengJueItems.BLUE_COTTON_ARMOR_CHESTPLATE.get())
                && entity.getItemBySlot(EquipmentSlot.LEGS).is(ChangShengJueItems.BLUE_COTTON_ARMOR_LEGGINGS.get())
                && entity.getItemBySlot(EquipmentSlot.FEET).is(ChangShengJueItems.COTTON_ARMOR_BOOTS.get());
        boolean redCottonArmor = entity.getItemBySlot(EquipmentSlot.HEAD).is(ChangShengJueItems.RED_COTTON_ARMOR_HELMET.get())
                && entity.getItemBySlot(EquipmentSlot.CHEST).is(ChangShengJueItems.RED_COTTON_ARMOR_CHESTPLATE.get())
                && entity.getItemBySlot(EquipmentSlot.LEGS).is(ChangShengJueItems.RED_COTTON_ARMOR_LEGGINGS.get())
                && entity.getItemBySlot(EquipmentSlot.FEET).is(ChangShengJueItems.COTTON_ARMOR_BOOTS.get());
        return blueCottonArmor || redCottonArmor;
    }
}
