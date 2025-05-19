package com.shengchanshe.changshengjue.item.combat.sword;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.knife.LargeKnife;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class YiTianJianRender extends GeoItemRenderer<LargeKnife> {
    public YiTianJianRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"yi_tian_jian")));
    }
}
