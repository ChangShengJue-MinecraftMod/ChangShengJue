package com.shengchanshe.changshengjue.entity.custom.dragonfly;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DragonflyModel extends GeoModel<Dragonfly> {
    @Override
    public ResourceLocation getModelResource(Dragonfly dragonflyEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/dragonfly_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Dragonfly dragonflyEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/dragonfly_entity.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Dragonfly dragonflyEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/dragonfly_entity.animation.json");
    }
}
