package com.shengchanshe.changshengjue.entity.client.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.client.render.ButterflyRenderer;
import com.shengchanshe.changshengjue.entity.custom.ButterflyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ButterflyModel  extends GeoModel<ButterflyEntity> {
    @Override
    public ResourceLocation getModelResource(ButterflyEntity butterflyEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/butterfly_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ButterflyEntity butterflyEntity) {
        return ButterflyRenderer.LOCATION_BY_VARIANT.get(butterflyEntity.getVariant());
    }

    @Override
    public ResourceLocation getAnimationResource(ButterflyEntity butterflyEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/butterfly_entity.animation.json");
    }
}
