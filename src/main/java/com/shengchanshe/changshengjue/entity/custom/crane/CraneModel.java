package com.shengchanshe.changshengjue.entity.custom.crane;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.custom.monkey.Monkey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CraneModel extends GeoModel<Crane> {
    @Override
    public ResourceLocation getModelResource(Crane craneEntity) {
        if (craneEntity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/crane/crane_baby.geo.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/crane/crane.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(Crane craneEntity) {
        if (craneEntity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/crane/crane_baby.png");
        }else{
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/crane/crane.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Crane craneEntity) {
        return craneEntity.isBaby() ? new ResourceLocation(ChangShengJue.MOD_ID,"animations/entity/crane/crane_baby.animation.json") : new ResourceLocation(ChangShengJue.MOD_ID,"animations/entity/crane/crane.animation.json");
    }


    @Override
    public void setCustomAnimations(Crane animatable, long instanceId, AnimationState<Crane> animationState) {
        CoreGeoBone head =  getAnimationProcessor().getBone("head");
        if (animatable.isBaby()){
            if (head != null){
                EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
                head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
                head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
            }
        }
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
