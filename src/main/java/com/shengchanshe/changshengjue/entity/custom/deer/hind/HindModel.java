package com.shengchanshe.changshengjue.entity.custom.deer.hind;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HindModel extends GeoModel<Hind> {
    @Override
    public ResourceLocation getModelResource(Hind entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/hind_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Hind entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/hind_entity.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Hind entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/hind_entity.animation.json");
    }
}
