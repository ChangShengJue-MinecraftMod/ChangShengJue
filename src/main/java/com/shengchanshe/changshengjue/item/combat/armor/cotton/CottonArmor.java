package com.shengchanshe.changshengjue.item.combat.armor.cotton;

import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.armor.DyeableItem;
import com.shengchanshe.changshengjue.item.render.combat.armor.cotton.CottonArmorRender;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class CottonArmor extends ArmorItem implements DyeableItem, GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public CottonArmor(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public int getColor(ItemStack pStack) {
        return DyeableItem.super.getColor(pStack) != -1 ? DyeableItem.super.getColor(pStack) : 0x0000FF;
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
        boolean cottonArmor0 = entity.getItemBySlot(EquipmentSlot.HEAD).is(ChangShengJueItems.COTTON_ARMOR_FEATHER_HELMET.get())
                && entity.getItemBySlot(EquipmentSlot.CHEST).is(ChangShengJueItems.COTTON_ARMOR_CHESTPLATE.get())
                && entity.getItemBySlot(EquipmentSlot.LEGS).is(ChangShengJueItems.COTTON_ARMOR_LEGGINGS.get())
                && entity.getItemBySlot(EquipmentSlot.FEET).is(ChangShengJueItems.COTTON_ARMOR_BOOTS.get());
        boolean cottonArmor1 = entity.getItemBySlot(EquipmentSlot.HEAD).is(ChangShengJueItems.COTTON_ARMOR_WHITE_FEATHER_HELMET.get())
                && entity.getItemBySlot(EquipmentSlot.CHEST).is(ChangShengJueItems.COTTON_ARMOR_CHESTPLATE.get())
                && entity.getItemBySlot(EquipmentSlot.LEGS).is(ChangShengJueItems.COTTON_ARMOR_LEGGINGS.get())
                && entity.getItemBySlot(EquipmentSlot.FEET).is(ChangShengJueItems.COTTON_ARMOR_BOOTS.get());
        return cottonArmor0 || cottonArmor1;
    }


    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GeoArmorRenderer<?> renderer;

            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null) {
                    this.renderer = new CottonArmorRender();
                }

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(((new AnimationController<>(this, 0, (state) ->
                state.setAndContinue(DefaultAnimations.IDLE)))));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
