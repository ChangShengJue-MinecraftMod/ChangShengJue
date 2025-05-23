package com.shengchanshe.changshengjue.item.combat.glove;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GoldThreadGloveRender extends GeoItemRenderer<GoldThreadGlove> {
    public GoldThreadGloveRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"gold_thread_glove")));
    }
}
