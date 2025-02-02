package com.shengchanshe.changshengjue.item.combat.armor.walker_set;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.armor.walker_set.layer.WalkerSetHelmetLayer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class WalkerSetRender extends GeoArmorRenderer<WalkerSet> {
    public WalkerSetRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"armor/walker_set")));
        this.addRenderLayer(new WalkerSetHelmetLayer(this));
    }
}
