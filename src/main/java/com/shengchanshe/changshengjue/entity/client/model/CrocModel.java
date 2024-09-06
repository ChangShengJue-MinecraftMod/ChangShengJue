package com.shengchanshe.changshengjue.entity.client.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.custom.CrocEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CrocModel extends GeoModel<CrocEntity> {
    @Override
    public ResourceLocation getModelResource(CrocEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/croc_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CrocEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/croc_entity.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CrocEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/croc_entity.animation.json");
    }
    @Override
    public void setCustomAnimations(CrocEntity animatable, long instanceId, AnimationState<CrocEntity> animationState) {
        CoreGeoBone head =  getAnimationProcessor().getBone("hand");
        if (head != null){
            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
