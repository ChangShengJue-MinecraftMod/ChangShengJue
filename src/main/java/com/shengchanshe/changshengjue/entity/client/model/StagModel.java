package com.shengchanshe.changshengjue.entity.client.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.custom.deer.HindEntity;
import com.shengchanshe.changshengjue.entity.custom.deer.StagEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class StagModel extends GeoModel<StagEntity> {

    @Override
    public ResourceLocation getModelResource(StagEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/stag_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StagEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/stag_entity.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StagEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/stag_entity.animation.json");
    }
}
