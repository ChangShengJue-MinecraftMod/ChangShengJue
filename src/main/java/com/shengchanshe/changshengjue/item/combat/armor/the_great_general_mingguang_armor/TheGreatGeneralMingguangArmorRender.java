package com.shengchanshe.changshengjue.item.combat.armor.the_great_general_mingguang_armor;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.armor.qi_tian_da_sheng.QiTianDaSheng;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class TheGreatGeneralMingguangArmorRender extends GeoArmorRenderer<TheGreatGeneralMingguangArmor> {
    public TheGreatGeneralMingguangArmorRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/the_great_general_mingguang_armor")));
    }
}
