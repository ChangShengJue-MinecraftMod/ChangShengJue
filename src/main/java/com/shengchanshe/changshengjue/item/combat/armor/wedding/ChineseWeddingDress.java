package com.shengchanshe.changshengjue.item.combat.armor.wedding;

import com.shengchanshe.changshengjue.item.combat.armor.DyeableChineseWeddingDressItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ChineseWeddingDress extends ArmorItem implements DyeableChineseWeddingDressItem, GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public ChineseWeddingDress(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public int getColor(ItemStack pStack) {
        return DyeableChineseWeddingDressItem.super.getColor(pStack) != -1 ? DyeableChineseWeddingDressItem.super.getColor(pStack) : 0x0000FF;
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
