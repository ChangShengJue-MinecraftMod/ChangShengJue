package com.shengchanshe.changshengjue.entity.client.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.custom.TigerEntity;
import com.shengchanshe.changshengjue.entity.custom.deer.HindEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class HindModel extends GeoModel<HindEntity> {
    @Override
    public ResourceLocation getModelResource(HindEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/hind_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HindEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/hind_entity.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HindEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/hind_entity.animation.json");
    }
}
