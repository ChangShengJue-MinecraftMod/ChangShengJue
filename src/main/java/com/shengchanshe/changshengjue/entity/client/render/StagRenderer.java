package com.shengchanshe.changshengjue.entity.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.client.model.StagModel;
import com.shengchanshe.changshengjue.entity.custom.deer.StagEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class StagRenderer extends GeoEntityRenderer<StagEntity> {
    public StagRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new StagModel());
        this.shadowRadius = 0.3f;//阴影半径
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(StagEntity instance) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/stag_entity.png");
    }

    //获取渲染类型
    @Override
    public void render(StagEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()){
            poseStack.scale(0.5F,0.5F,0.5F);//缩放实体大小
        }
        poseStack.scale(1.0F,1.0F,1.0F);//缩放实体大小
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
