package com.shengchanshe.changshengjue.entity.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.client.model.MonkeyModel;
import com.shengchanshe.changshengjue.entity.custom.MonkeyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class MonkeyRenderer extends GeoEntityRenderer<MonkeyEntity> {
    public MonkeyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MonkeyModel());
        this.shadowRadius = 0.5f;//阴影半径
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(MonkeyEntity instance) {
        if (instance.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/monkey_entity.png");
        }
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/monkey_entity.png");
    }

    //获取渲染类型
    @Override
    public void render(MonkeyEntity entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()){
            poseStack.scale(0.4F,0.4F,0.4F);
        }else {
            poseStack.scale(1.0F,1.0F,1.0F);//缩放实体大小
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
