package com.shengchanshe.changshengjue.entity.custom.peacock.male;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.custom.monkey.Monkey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MalePeacockModel extends GeoModel<MalePeacock> {
    @Override
    public ResourceLocation getModelResource(MalePeacock malePeacockEntity) {
        if (malePeacockEntity.isBaby()) {
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/peacock/peacock_baby.geo.json");
        } else{
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/peacock/peacock.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(MalePeacock malePeacockEntity) {
        if (malePeacockEntity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/peacock/peacock_baby.png");
        }else {
            return MalePeacockRenderer.LOCATION_BY_VARIANT.get(malePeacockEntity.getVariant());
        }
    }

    @Override
    public ResourceLocation getAnimationResource(MalePeacock malePeacockEntity) {
        if (malePeacockEntity.isBaby()) {
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/entity/peacock/peacock_baby.animation.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/entity/peacock/peacock.animation.json");
        }
    }

    @Override
    public void setCustomAnimations(MalePeacock animatable, long instanceId, AnimationState<MalePeacock> animationState) {
        CoreGeoBone head =  getAnimationProcessor().getBone("hand");
        if (head != null && animatable.isBaby()){
            EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
