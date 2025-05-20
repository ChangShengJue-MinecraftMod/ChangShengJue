package com.shengchanshe.changshengjue.item.combat.lance;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

import java.util.List;

public class RedTasselledSpearRender extends GeoItemRenderer<RedTasselledSpear> {
    public RedTasselledSpearRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"red_tasselled_spear")));
    }

    @Override
    public List<GeoRenderLayer<RedTasselledSpear>> getRenderLayers() {
        return super.getRenderLayers();
    }
}
