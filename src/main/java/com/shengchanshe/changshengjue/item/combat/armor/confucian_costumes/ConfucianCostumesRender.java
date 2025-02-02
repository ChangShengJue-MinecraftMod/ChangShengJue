package com.shengchanshe.changshengjue.item.combat.armor.confucian_costumes;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.armor.qi_tian_da_sheng.QiTianDaSheng;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ConfucianCostumesRender extends GeoArmorRenderer<ConfucianCostumes> {
    public ConfucianCostumesRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/confucian_costumes")));
    }
}
