package com.shengchanshe.changshengjue.item.combat.clubbed;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PanHuaGunRender extends GeoItemRenderer<PanHuaGun> {
    public PanHuaGunRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"pan_hua_gun")));
    }
}
