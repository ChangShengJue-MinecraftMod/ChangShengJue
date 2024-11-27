package com.shengchanshe.changshengjue.item.render.combat.armor.taoistrobes;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.armor.taoistrobes.FemaleTaoistRobes;
import com.shengchanshe.changshengjue.item.combat.armor.taoistrobes.MaleTaoistRobes;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MaleTaoistRobesRender extends GeoArmorRenderer<MaleTaoistRobes> {
    public MaleTaoistRobesRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"armor/male_taoist_robes")));
    }
}
