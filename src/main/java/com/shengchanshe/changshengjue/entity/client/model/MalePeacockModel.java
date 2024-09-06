package com.shengchanshe.changshengjue.entity.client.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.client.render.MalePeacockRenderer;
import com.shengchanshe.changshengjue.entity.custom.peacock.MalePeacockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MalePeacockModel extends GeoModel<MalePeacockEntity> {
    @Override
    public ResourceLocation getModelResource(MalePeacockEntity malePeacockEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/peacock_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MalePeacockEntity malePeacockEntity) {
        return MalePeacockRenderer.LOCATION_BY_VARIANT.get(malePeacockEntity.getVariant());
    }

    @Override
    public ResourceLocation getAnimationResource(MalePeacockEntity malePeacockEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/peacock_entity.animation.json");
    }
}
