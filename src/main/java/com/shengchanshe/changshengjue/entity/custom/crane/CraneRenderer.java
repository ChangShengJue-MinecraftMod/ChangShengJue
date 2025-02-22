package com.shengchanshe.changshengjue.entity.custom.crane;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CraneRenderer extends GeoEntityRenderer<Crane> {
    public CraneRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CraneModel());
        this.shadowRadius = 0.3f;//阴影半径
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(Crane instance) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/crane_entity.png");
    }

    //获取渲染类型
    @Override
    public void render(Crane entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()){
            poseStack.scale(0.5F,0.5F,0.5F);
        }else {
            poseStack.scale(1.0F,1.0F,1.0F);//缩放实体大小
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
