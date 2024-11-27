package com.shengchanshe.changshengjue.item.render.combat.armor.cotton;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.armor.cotton.BlueCottonArmor;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BlueCottonArmorRender extends GeoArmorRenderer<BlueCottonArmor> {
    public BlueCottonArmorRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"armor/blue_cotton_armor")));
    }
}
