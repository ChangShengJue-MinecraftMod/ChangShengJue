package com.shengchanshe.changshengjue.item.combat.sword;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class HanJianRender extends GeoItemRenderer<SoftSword> {
    public HanJianRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"han_jian")));
    }
}
