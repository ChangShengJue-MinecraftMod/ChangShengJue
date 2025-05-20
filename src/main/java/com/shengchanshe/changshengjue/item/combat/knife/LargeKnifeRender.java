package com.shengchanshe.changshengjue.item.combat.knife;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.lance.RedTasselledSpearLayer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class LargeKnifeRender extends GeoItemRenderer<LargeKnife> {
    public LargeKnifeRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"large_knife")));
//        this.addRenderLayer(new RedTasselledSpearLayer(this));
    }
}
