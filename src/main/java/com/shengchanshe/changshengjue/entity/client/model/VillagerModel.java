package com.shengchanshe.changshengjue.entity.client.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VillagerModel extends GeoModel<ChangShengJueVillagerEntity> {

    @Override
    public ResourceLocation getModelResource(ChangShengJueVillagerEntity entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/villager_baby/chang_sheng_jue_villager.geo.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/chang_sheng_jue_villager.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(ChangShengJueVillagerEntity entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/villager/chang_sheng_jue_villager_baby.png");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/villager/chang_sheng_jue_villager.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(ChangShengJueVillagerEntity entity) {
        if (entity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/villager_baby/chang_sheng_jue_villager.animation.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/chang_sheng_jue_villager.animation.json");
        }
    }
}
