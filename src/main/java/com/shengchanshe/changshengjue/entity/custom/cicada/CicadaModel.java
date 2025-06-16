package com.shengchanshe.changshengjue.entity.custom.cicada;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CicadaModel extends GeoModel<Cicada> {
    @Override
    public ResourceLocation getModelResource(Cicada cicadaEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/cicada_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Cicada cicadaEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/cicada_entity.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Cicada cicadaEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/cicada_entity.animation.json");
    }
}
