package com.shengchanshe.changshengjue.block.entity.model;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.entity.BullionsCastingMoldsBlockEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.items.ItemStackHandler;
import software.bernie.geckolib.model.GeoModel;

public class BullionsCastingMoldsBlockEntityModel extends GeoModel<BullionsCastingMoldsBlockEntity> {

    @Override
    public ResourceLocation getModelResource(BullionsCastingMoldsBlockEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/bullions_casting_molds.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BullionsCastingMoldsBlockEntity entity) {
        ItemStackHandler inventroy = entity.getInventory();
        if (!inventroy.getStackInSlot(0).isEmpty() && inventroy.getStackInSlot(1).isEmpty()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/block/bullions_casting_molds_1.png");
        }else if (!inventroy.getStackInSlot(0).isEmpty() && !inventroy.getStackInSlot(1).isEmpty()){
            if (inventroy.getStackInSlot(1).is(ChangShengJueItems.SILVER_BULLIONS.get())){
                return new ResourceLocation(ChangShengJue.MOD_ID,"textures/block/bullions_casting_molds_silver.png");
            }else {
                return new ResourceLocation(ChangShengJue.MOD_ID,"textures/block/bullions_casting_molds_gold.png");
            }
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/block/bullions_casting_molds.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(BullionsCastingMoldsBlockEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/bullions_casting_molds.animation.json");
    }
}
