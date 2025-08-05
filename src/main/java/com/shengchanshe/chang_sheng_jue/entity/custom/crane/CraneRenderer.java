package com.shengchanshe.chang_sheng_jue.entity.custom.crane;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
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
        return instance.isBaby() ? new ResourceLocation(ChangShengJue.MOD_ID , "textures/entity/crane/crane_baby.png") : new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/crane/crane.png");
    }

    //获取渲染类型
    @Override
    public void render(Crane entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.scale(1.0F,1.0F,1.0F);//缩放实体大小
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
