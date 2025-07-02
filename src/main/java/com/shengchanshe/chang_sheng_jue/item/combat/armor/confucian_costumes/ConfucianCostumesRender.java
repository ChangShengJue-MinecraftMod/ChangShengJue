package com.shengchanshe.chang_sheng_jue.item.combat.armor.confucian_costumes;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ConfucianCostumesRender extends GeoArmorRenderer<ConfucianCostumes> {
    public ConfucianCostumesRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/confucian_costumes")));
    }
}
