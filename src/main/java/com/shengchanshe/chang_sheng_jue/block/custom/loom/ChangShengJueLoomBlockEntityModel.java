package com.shengchanshe.chang_sheng_jue.block.custom.loom;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
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
