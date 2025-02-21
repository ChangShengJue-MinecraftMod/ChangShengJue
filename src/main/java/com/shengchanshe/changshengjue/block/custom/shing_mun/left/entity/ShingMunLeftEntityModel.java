package com.shengchanshe.changshengjue.block.custom.shing_mun.left.entity;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShingMunLeftEntityModel extends GeoModel<ShingMunLeftEntity> {

    @Override
    public ResourceLocation getModelResource(ShingMunLeftEntity entity) {
        if (entity.isRight()){
            if (entity.isTwo()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_two_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_two.geo.json");
                }
            }else if (entity.isFour()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_four_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_four.geo.json");
                }
            }else if (entity.isSix()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_six_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_six.geo.json");
                }
            }else if (entity.isEight()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_eight_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_eight.geo.json");
                }
            }else{
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_two_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_two.geo.json");
                }
            }
        }else {
            if (entity.isOne()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_one_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_one.geo.json");
                }
            }else if (entity.isThree()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_three_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_three.geo.json");
                }
            }else if (entity.isFive()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_five_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_five.geo.json");
                }
            }else if (entity.isSeven()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_seven_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_seven.geo.json");
                }
            }else{
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_one_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_one.geo.json");
                }
            }
        }
    }

    @Override
    public ResourceLocation getTextureResource(ShingMunLeftEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/block/shing_mun.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ShingMunLeftEntity entity) {
        if (entity.isRight()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/block/shing_mun_left/shing_mun_left_right.animation.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/block/shing_mun_left/shing_mun_left.animation.json");
        }
    }
}
