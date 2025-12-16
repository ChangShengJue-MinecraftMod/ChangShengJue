package com.shengchanshe.chang_sheng_jue.block.custom.furniture.bamboo_mat;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.entity.custom.butterfly.Butterfly;
import com.shengchanshe.chang_sheng_jue.entity.custom.butterfly.ButterflyRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BedPart;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.model.GeoModel;

public class BambooMatEntityModel extends GeoModel<BambooMatEntity> {
    @Override
    public ResourceLocation getModelResource(BambooMatEntity animatable) {
        if (animatable.getBlockState().getValue(BambooMat.PART) == BedPart.HEAD) {
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/bamboo_mat_head.geo.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/bamboo_mat_foot.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(BambooMatEntity animatable) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/block/bamboo_mat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BambooMatEntity animatable) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/block/bamboo_mat.animation.json");
    }
}
