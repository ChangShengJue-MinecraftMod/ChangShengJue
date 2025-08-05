package com.shengchanshe.chang_sheng_jue.entity.custom.deer.hind;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HindModel extends GeoModel<Hind> {
    @Override
    public ResourceLocation getModelResource(Hind entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/deer/deer_baby.geo.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/deer/hind.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(Hind entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/deer/deer_baby.png");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/deer/hind.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Hind entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/entity/deer/deer_baby.animation.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/entity/deer/hind.animation.json");
        }
    }

}
