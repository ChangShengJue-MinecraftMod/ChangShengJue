package com.shengchanshe.chang_sheng_jue.entity.custom.tiger;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
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
        if (instance.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/tiger/tiger_baby.png");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/tiger/tiger.png");
        }
    }

    //获取渲染类型
    @Override
    public void render(Tiger entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
