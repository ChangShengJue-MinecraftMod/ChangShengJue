package com.shengchanshe.changshengjue.item.combat.armor.mountain_pattern_armor;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.armor.cotton.CottonArmor;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MountainPatternArmorRender extends GeoArmorRenderer<CottonArmor> {
    public MountainPatternArmorRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/mountain_pattern_armor")));
    }
}
