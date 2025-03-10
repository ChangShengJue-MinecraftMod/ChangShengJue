package com.shengchanshe.changshengjue.entity.custom.croc;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CrocModel extends GeoModel<Croc> {
    @Override
    public ResourceLocation getModelResource(Croc entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/croc/croc_baby.geo.json");
        }else{
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/croc/croc.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(Croc entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/croc/croc_baby.png");
        }else{
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/croc/croc.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Croc entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/entity/croc/croc.animation.json");
    }
    @Override
    public void setCustomAnimations(Croc animatable, long instanceId, AnimationState<Croc> animationState) {
        CoreGeoBone head =  getAnimationProcessor().getBone("hand");
        if (head != null){
            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
