package com.shengchanshe.changshengjue.item.render.combat.armor.wedding;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.armor.taoistrobes.FemaleTaoistRobes;
import com.shengchanshe.changshengjue.item.combat.armor.wedding.RedDress;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class RedDressRender extends GeoArmorRenderer<RedDress> {
    public RedDressRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"armor/red_dress")));
    }
}
