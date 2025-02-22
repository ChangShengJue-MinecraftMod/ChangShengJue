package com.shengchanshe.changshengjue.entity.custom.peacock.female;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FemalePeacockModel extends GeoModel<FemalePeacock> {
    @Override
    public ResourceLocation getModelResource(FemalePeacock entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/female_peacock_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FemalePeacock entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/female_peacock_entity.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FemalePeacock entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/female_peacock_entity.animation.json");
    }
}
