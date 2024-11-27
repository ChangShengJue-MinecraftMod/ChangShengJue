package com.shengchanshe.changshengjue.item.render.combat.armor.taoistrobes;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.armor.taoistrobes.FemaleTaoistRobes;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FemaleTaoistRobesRender extends GeoArmorRenderer<FemaleTaoistRobes> {
    public FemaleTaoistRobesRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"armor/female_taoist_robes")));
    }
}
