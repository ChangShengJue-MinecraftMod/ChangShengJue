package com.shengchanshe.chang_sheng_jue.entity.custom.deer.stag;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class StagModel extends GeoModel<Stag> {

    @Override
    public ResourceLocation getModelResource(Stag entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/deer/deer_baby.geo.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID, "geo/entity/deer/stag.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(Stag entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/deer/deer_baby.png");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID, "textures/entity/deer/stag.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Stag entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/entity/deer/deer_baby.animation.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID, "animations/entity/deer/stag.animation.json");
        }
    }
}
