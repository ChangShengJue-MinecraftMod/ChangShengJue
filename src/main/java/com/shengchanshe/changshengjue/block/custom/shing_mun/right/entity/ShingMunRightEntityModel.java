package com.shengchanshe.changshengjue.block.custom.shing_mun.right.entity;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShingMunRightEntityModel extends GeoModel<ShingMunRightEntity> {

    @Override
    public ResourceLocation getModelResource(ShingMunRightEntity entity) {
        if (entity.isLeft()){
//            if (entity.isRest()){
//                if (entity.isTwo()){
//                    if (entity.isOpen()){
//                        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_two_open_1.geo.json");
//                    }else {
//                        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_two_1.geo.json");
//                    }
//                }else if (entity.isFour()){
//                    if (entity.isOpen()){
//                        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_four_open_1.geo.json");
//                    }else {
//                        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_four_1.geo.json");
//                    }
//                }else if (entity.isSix()){
//                    if (entity.isOpen()){
//                        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_six_open_1.geo.json");
//                    }else {
//                        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_six_1.geo.json");
//                    }
//                }else if (entity.isEight()){
//                    if (entity.isOpen()){
//                        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_eight_open_1.geo.json");
//                    }else {
//                        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_eight_1.geo.json");
//                    }
//                }else{
//                    if (entity.isOpen()){
//                        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_two_open_1.geo.json");
//                    }else {
//                        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_two_1.geo.json");
//                    }
//                }
//            }
            if (entity.isTwo()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_two_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_two.geo.json");
                }
            }else if (entity.isFour()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_four_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_four.geo.json");
                }
            }else if (entity.isSix()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_six_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_six.geo.json");
                }
            }else if (entity.isEight()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_eight_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_eight.geo.json");
                }
            }else{
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_two_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_two.geo.json");
                }
            }
        }else {
            if (entity.isOne()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_one_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_one.geo.json");
                }
            }else if (entity.isThree()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_three_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_three.geo.json");
                }
            }else if (entity.isFive()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_five_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_five.geo.json");
                }
            }else if (entity.isSeven()){
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_seven_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_seven.geo.json");
                }
            }else{
                if (entity.isOpen()){
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_one_open.geo.json");
                }else {
                    return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/shing_mun_right/shing_mun_right_one.geo.json");
                }
            }
        }
    }

    @Override
    public ResourceLocation getTextureResource(ShingMunRightEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/shing_mun/shing_mun.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ShingMunRightEntity entity) {
        if (entity.isLeft()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/block/shing_mun_right/shing_mun_right_right.animation.json");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"animations/block/shing_mun_right/shing_mun_right.animation.json");
        }
    }
}
