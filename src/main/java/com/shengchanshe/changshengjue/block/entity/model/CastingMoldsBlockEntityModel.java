package com.shengchanshe.changshengjue.block.entity.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.entity.CastingMoldsBlockEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.items.ItemStackHandler;
import software.bernie.geckolib.model.GeoModel;

public class CastingMoldsBlockEntityModel extends GeoModel<CastingMoldsBlockEntity> {

    @Override
    public ResourceLocation getModelResource(CastingMoldsBlockEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/casting_molds.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CastingMoldsBlockEntity entity) {
        ItemStackHandler inventroy = entity.getInventory();
        if (!inventroy.getStackInSlot(0).isEmpty() && inventroy.getStackInSlot(1).isEmpty()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/block/casting_molds_1.png");
        }else if (!inventroy.getStackInSlot(0).isEmpty() && !inventroy.getStackInSlot(1).isEmpty()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/block/casting_molds_2.png");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/block/casting_molds.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(CastingMoldsBlockEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/casting_molds.animation.json");
    }
}
