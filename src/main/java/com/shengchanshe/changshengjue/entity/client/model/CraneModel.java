package com.shengchanshe.changshengjue.entity.client.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.custom.CraneEntity;
import com.shengchanshe.changshengjue.entity.custom.TigerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CraneModel extends GeoModel<CraneEntity> {
    @Override
    public ResourceLocation getModelResource(CraneEntity craneEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/crane_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CraneEntity craneEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/crane_entity.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CraneEntity craneEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/crane_entity.animation.json");
    }
}
