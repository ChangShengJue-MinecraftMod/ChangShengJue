package com.shengchanshe.changshengjue.entity.client.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.custom.TigerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class TigerModel extends GeoModel<TigerEntity> {
    @Override
    public ResourceLocation getModelResource(TigerEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/tiger_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TigerEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/tiger_entity.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TigerEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/tiger_entity.animation.json");
    }

    //使生物头部转动
    @Override
    public void setCustomAnimations(TigerEntity animatable, long instanceId, AnimationState<TigerEntity> animationState) {
        CoreGeoBone head =  getAnimationProcessor().getBone("hand");
        if (head != null){
            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
