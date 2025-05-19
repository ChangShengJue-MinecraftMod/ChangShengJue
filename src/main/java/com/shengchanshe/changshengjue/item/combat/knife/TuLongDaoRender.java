package com.shengchanshe.changshengjue.item.combat.knife;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class TuLongDaoRender extends GeoItemRenderer<LargeKnife> {
    public TuLongDaoRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"tu_long_dao")));
    }
}
