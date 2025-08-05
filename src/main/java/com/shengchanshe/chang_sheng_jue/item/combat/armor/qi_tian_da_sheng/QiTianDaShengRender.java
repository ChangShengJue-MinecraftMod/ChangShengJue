package com.shengchanshe.chang_sheng_jue.item.combat.armor.qi_tian_da_sheng;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class QiTianDaShengRender extends GeoArmorRenderer<QiTianDaSheng> {
    public QiTianDaShengRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/qi_tian_da_sheng")));
    }
}
