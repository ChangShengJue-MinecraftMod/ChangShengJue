package com.shengchanshe.changshengjue.entity.custom.peacock.male;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MalePeacockModel extends GeoModel<MalePeacock> {
    @Override
    public ResourceLocation getModelResource(MalePeacock malePeacockEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/peacock_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MalePeacock malePeacockEntity) {
        return MalePeacockRenderer.LOCATION_BY_VARIANT.get(malePeacockEntity.getVariant());
    }

    @Override
    public ResourceLocation getAnimationResource(MalePeacock malePeacockEntity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/peacock_entity.animation.json");
    }
}
