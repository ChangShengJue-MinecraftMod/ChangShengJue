package com.shengchanshe.changshengjue.entity.custom.peacock.female;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FemalePeacockRenderer extends GeoEntityRenderer<FemalePeacock> {
    public FemalePeacockRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FemalePeacockModel());
        this.shadowRadius = 0.3f;//阴影半径
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(FemalePeacock instance) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/female_peacock_entity.png");
    }

    //获取渲染类型
    @Override
    public void render(FemalePeacock entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()){
            poseStack.scale(0.5F,0.5F,0.5F);//缩放实体大小
        }
        poseStack.scale(1.0F,1.0F,1.0F);//缩放实体大小
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
