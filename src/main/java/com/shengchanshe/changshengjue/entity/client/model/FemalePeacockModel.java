package com.shengchanshe.changshengjue.entity.client.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.custom.peacock.FemalePeacockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FemalePeacockModel extends GeoModel<FemalePeacockEntity> {
    @Override
    public ResourceLocation getModelResource(FemalePeacockEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/female_peacock_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FemalePeacockEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/female_peacock_entity.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FemalePeacockEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/female_peacock_entity.animation.json");
    }
}
