package com.shengchanshe.chang_sheng_jue.entity.custom.monkey;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MonkeyModel extends GeoModel<Monkey> {
    @Override
    public ResourceLocation getModelResource(Monkey monkeyEntity) {
        if (monkeyEntity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/monkey/monkey_baby.geo.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/monkey/monkey.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(Monkey monkeyEntity) {
        if (monkeyEntity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/monkey/monkey_baby.png");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/monkey/monkey.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Monkey monkeyEntity) {
        if (monkeyEntity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/entity/monkey/monkey_baby.animation.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/entity/monkey/monkey.animation.json");
        }
    }

    @Override
    public void setCustomAnimations(Monkey animatable, long instanceId, AnimationState<Monkey> animationState) {
        CoreGeoBone head =  getAnimationProcessor().getBone("hand");
        if (head != null){
            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
