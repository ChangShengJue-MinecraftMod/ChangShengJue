package com.shengchanshe.changshengjue.entity.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.client.model.CrocModel;
import com.shengchanshe.changshengjue.entity.custom.CrocEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CrocRenderer extends GeoEntityRenderer<CrocEntity> {
    public CrocRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrocModel());
        this.shadowRadius = 0.5f;//阴影半径
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(CrocEntity instance) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/croc_entity.png");
    }

    //获取渲染类型
    @Override
    public void render(CrocEntity entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.scale(1.0F,1.0F,1.0F);//缩放实体大小
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
