package com.shengchanshe.changshengjue.entity.custom.crane;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CraneModel extends GeoModel<Crane> {
    @Override
    public ResourceLocation getModelResource(Crane craneEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/crane_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Crane craneEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/crane_entity.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Crane craneEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/crane_entity.animation.json");
    }
}
