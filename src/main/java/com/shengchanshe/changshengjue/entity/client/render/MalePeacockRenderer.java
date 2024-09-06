package com.shengchanshe.changshengjue.entity.client.render;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.client.model.MalePeacockModel;
import com.shengchanshe.changshengjue.entity.custom.peacock.MalePeacockEntity;
import com.shengchanshe.changshengjue.entity.custom.peacock.PeacockVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class MalePeacockRenderer extends GeoEntityRenderer<MalePeacockEntity> {
    public static final Map<PeacockVariant,ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(PeacockVariant.class),(map)->{
                map.put(PeacockVariant.MALE,
                        new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/male_peacock_entity.png"));
                map.put(PeacockVariant.WHITE,
                        new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/white_peacock_entity.png"));
            });
    public MalePeacockRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MalePeacockModel());
        this.shadowRadius = 0.3f;//阴影半径
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(MalePeacockEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    //获取渲染类型
    @Override
    public void render(MalePeacockEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()){
            poseStack.scale(0.5F,0.5F,0.5F);//缩放实体大小
        }else {
            poseStack.scale(1.0F,1.0F,1.0F);//缩放实体大小
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
