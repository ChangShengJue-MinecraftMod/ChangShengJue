package com.shengchanshe.changshengjue.item.render.combat.lance;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.lance.RedTasselledSpear;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class RedTasselledSpearRender extends GeoItemRenderer<RedTasselledSpear> {
    public RedTasselledSpearRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"red_tasselled_spear")));
    }
}
