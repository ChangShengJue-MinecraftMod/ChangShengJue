package com.shengchanshe.changshengjue.entity.client.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueHunterEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HunterModel extends GeoModel<ChangShengJueHunterEntity> {
    @Override
    public ResourceLocation getModelResource(ChangShengJueHunterEntity entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/villager_baby/chang_sheng_jue_villager.geo.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/chang_sheng_jue_villager.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(ChangShengJueHunterEntity entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/villager/chang_sheng_jue_villager_baby.png");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/villager/chang_sheng_jue_hunter.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(ChangShengJueHunterEntity entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/villager_baby/chang_sheng_jue_villager.animation.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/chang_sheng_jue_villager.animation.json");
        }
    }
}
