package com.shengchanshe.changshengjue.entity.custom.tiger;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TigerRenderer extends GeoEntityRenderer<Tiger> {
    public TigerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TigerModel());
        this.shadowRadius = 1.0f;//阴影半径
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(Tiger instance) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/tiger_entity.png");
    }

    //获取渲染类型
    @Override
    public void render(Tiger entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.scale(1.0F,1.0F,1.0F);//缩放实体大小
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
