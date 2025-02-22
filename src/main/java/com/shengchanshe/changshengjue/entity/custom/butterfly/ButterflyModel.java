package com.shengchanshe.changshengjue.entity.custom.butterfly;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ButterflyModel  extends GeoModel<Butterfly> {
    @Override
    public ResourceLocation getModelResource(Butterfly butterflyEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/butterfly_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Butterfly butterflyEntity) {
        return ButterflyRenderer.LOCATION_BY_VARIANT.get(butterflyEntity.getVariant());
    }

    @Override
    public ResourceLocation getAnimationResource(Butterfly butterflyEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/butterfly_entity.animation.json");
    }
}
