package com.shengchanshe.changshengjue.item.render.combat.armor.wedding;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.armor.taoistrobes.MaleTaoistRobes;
import com.shengchanshe.changshengjue.item.combat.armor.wedding.ChineseWeddingDress;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ChineseWeddingDressRender extends GeoArmorRenderer<ChineseWeddingDress> {
    public ChineseWeddingDressRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"armor/chinese_wedding_dress")));
    }
}
