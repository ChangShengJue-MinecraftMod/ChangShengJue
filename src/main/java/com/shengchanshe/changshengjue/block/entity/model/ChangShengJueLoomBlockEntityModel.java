package com.shengchanshe.changshengjue.block.entity.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.entity.ChangShengJueLoomBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ChangShengJueLoomBlockEntityModel extends GeoModel<ChangShengJueLoomBlockEntity> {

    @Override
    public ResourceLocation getModelResource(ChangShengJueLoomBlockEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/chang_sheng_jue_loom.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChangShengJueLoomBlockEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/block/chang_sheng_jue_loom.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChangShengJueLoomBlockEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/chang_sheng_jue_loom.animation.json");
    }
}
