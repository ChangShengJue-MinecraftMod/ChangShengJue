package com.shengchanshe.changshengjue.entity.custom.deer.stag;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class StagModel extends GeoModel<Stag> {

    @Override
    public ResourceLocation getModelResource(Stag entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/stag_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Stag entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/stag_entity.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Stag entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/stag_entity.animation.json");
    }
}
