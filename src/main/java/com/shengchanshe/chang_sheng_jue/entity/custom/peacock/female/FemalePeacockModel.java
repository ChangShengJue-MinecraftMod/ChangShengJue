package com.shengchanshe.chang_sheng_jue.entity.custom.peacock.female;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class FemalePeacockModel extends GeoModel<FemalePeacock> {
    @Override
    public ResourceLocation getModelResource(FemalePeacock entity) {
        if (entity.isBaby()) {
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/peacock/peacock_baby.geo.json");
        } else {
            return new ResourceLocation(ChangShengJue.MOD_ID, "geo/entity/peacock/female_peacock.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(FemalePeacock entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/peacock/peacock_baby.png");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/peacock/female_peacock.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(FemalePeacock entity) {
        if (entity.isBaby()) {
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/entity/peacock/peacock_baby.animation.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/entity/peacock/female_peacock.animation.json");
        }
    }


    @Override
    public void setCustomAnimations(FemalePeacock animatable, long instanceId, AnimationState<FemalePeacock> animationState) {
        CoreGeoBone head =  getAnimationProcessor().getBone("hand");
        if (head != null && animatable.isBaby()){
            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
