package com.shengchanshe.changshengjue.entity.client.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.custom.CicadaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CicadaModel extends GeoModel<CicadaEntity> {
    @Override
    public ResourceLocation getModelResource(CicadaEntity cicadaEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/cicada_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CicadaEntity cicadaEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/cicada_entity.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CicadaEntity cicadaEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/cicada_entity.animation.json");
    }
}
