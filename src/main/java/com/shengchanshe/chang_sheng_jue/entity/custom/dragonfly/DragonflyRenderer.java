package com.shengchanshe.chang_sheng_jue.entity.custom.dragonfly;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DragonflyRenderer extends GeoEntityRenderer<Dragonfly> {
    public DragonflyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DragonflyModel());
        this.shadowRadius = 0.3f;//阴影半径
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(Dragonfly instance) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/dragonfly_entity.png");
    }

    //获取渲染类型
    @Override
    public void render(Dragonfly entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.scale(0.8F,0.8F,0.8F);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
