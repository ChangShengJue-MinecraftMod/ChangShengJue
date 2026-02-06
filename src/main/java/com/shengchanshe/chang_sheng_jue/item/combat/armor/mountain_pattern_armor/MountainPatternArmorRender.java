package com.shengchanshe.chang_sheng_jue.item.combat.armor.mountain_pattern_armor;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.cotton.CottonArmor;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MountainPatternArmorRender extends GeoArmorRenderer<MountainPatternArmor> {
    public MountainPatternArmorRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/mountain_pattern_armor")));
    }
}
