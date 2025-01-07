package com.shengchanshe.changshengjue.item.render.combat.lance;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.lance.BaWangQiang;
import com.shengchanshe.changshengjue.item.combat.lance.RedTasselledSpear;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class BaWangQiangRender extends GeoItemRenderer<BaWangQiang> {
    public BaWangQiangRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"ba_wang_qiang")));
    }
}
