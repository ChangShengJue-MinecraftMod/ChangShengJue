package com.shengchanshe.changshengjue.item.combat.knife;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class KitchenKnifeRender extends GeoItemRenderer<LargeKnife> {
    public KitchenKnifeRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"kitchen_knife")));
    }
}
