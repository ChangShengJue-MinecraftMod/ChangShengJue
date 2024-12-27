package com.shengchanshe.changshengjue.item.render.combat.armor.qi_tian_ta_sheng;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.armor.qi_tian_ta_sheng.QiTianDaSheng;
import com.shengchanshe.changshengjue.item.combat.armor.walker_set.WalkerSet;
import com.shengchanshe.changshengjue.item.render.combat.armor.walker_set.layer.WalkerSetHelmetLayer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class QiTianDaShengRender extends GeoArmorRenderer<QiTianDaSheng> {
    public QiTianDaShengRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/qi_tian_da_sheng")));
    }
}
