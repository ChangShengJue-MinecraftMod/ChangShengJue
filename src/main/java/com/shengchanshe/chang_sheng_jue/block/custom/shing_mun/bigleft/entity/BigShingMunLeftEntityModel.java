package com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.bigleft.entity;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BigShingMunLeftEntityModel extends GeoModel<BigShingMunLeftEntity> {

    @Override
    public ResourceLocation getModelResource(BigShingMunLeftEntity entity) {
        if (entity.isRight()){
            if (entity.isTwo()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_two_open_1.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_two_1.geo.json");
                }
            }else if (entity.isFour()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_four_open_1.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_four_1.geo.json");
                }
            }else if (entity.isSix()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_six_open_1.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_six_1.geo.json");
                }
            }else if (entity.isEight()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_eight_open_1.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_eight_1.geo.json");
                }
            }else{
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_two_open_1.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_two_1.geo.json");
                }
            }
//            if (entity.isTwo()){
//                if (entity.isOpen()){
//                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_two_open.geo.json");
//                }else {
//                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_two.geo.json");
//                }
//            }else if (entity.isFour()){
//                if (entity.isOpen()){
//                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_four_open.geo.json");
//                }else {
//                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_four.geo.json");
//                }
//            }else if (entity.isSix()){
//                if (entity.isOpen()){
//                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_six_open.geo.json");
//                }else {
//                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_six.geo.json");
//                }
//            }else if (entity.isEight()){
//                if (entity.isOpen()){
//                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_eight_open.geo.json");
//                }else {
//                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_eight.geo.json");
//                }
//            }else{
//                if (entity.isOpen()){
//                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_two_open.geo.json");
//                }else {
//                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_left/shing_mun_left_two.geo.json");
//                }
//            }
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
    public ResourceLocation getTextureResource(BigShingMunLeftEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/shing_mun/shing_mun_1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BigShingMunLeftEntity entity) {
        if (entity.isRight()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/block/shing_mun_left/shing_mun_left_right.animation.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/block/shing_mun_left/shing_mun_left.animation.json");
        }
    }
}
