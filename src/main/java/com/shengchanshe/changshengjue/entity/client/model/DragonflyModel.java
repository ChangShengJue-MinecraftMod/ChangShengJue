package com.shengchanshe.changshengjue.entity.client.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.custom.DragonflyEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class DragonflyModel extends GeoModel<DragonflyEntity> {
    @Override
    public ResourceLocation getModelResource(DragonflyEntity dragonflyEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/dragonfly_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DragonflyEntity dragonflyEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/dragonfly_entity.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DragonflyEntity dragonflyEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/dragonfly_entity.animation.json");
    }
}
