package com.shengchanshe.changshengjue.entity.client.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagerChiefEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VillagerChiefModel extends GeoModel<ChangShengJueVillagerChiefEntity> {

    @Override
    public ResourceLocation getModelResource(ChangShengJueVillagerChiefEntity changShengJueVillagerChiefEntity) {
        if (changShengJueVillagerChiefEntity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/villager_baby/chang_sheng_jue_villager.geo.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/chang_sheng_jue_villager.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(ChangShengJueVillagerChiefEntity changShengJueVillagerChiefEntity) {
        if (changShengJueVillagerChiefEntity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/villager/chang_sheng_jue_villager_baby.png");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/villager/chang_sheng_jue_villager_chief_entity.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(ChangShengJueVillagerChiefEntity changShengJueVillagerChiefEntity) {
        if (changShengJueVillagerChiefEntity.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/villager_baby/chang_sheng_jue_villager.animation.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/chang_sheng_jue_villager.animation.json");
        }
    }
}
