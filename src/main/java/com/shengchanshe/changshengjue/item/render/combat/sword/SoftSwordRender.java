package com.shengchanshe.changshengjue.item.render.combat.sword;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.sword.SoftSword;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SoftSwordRender extends GeoItemRenderer<SoftSword> {
    public SoftSwordRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"soft_sword")));
    }
}
