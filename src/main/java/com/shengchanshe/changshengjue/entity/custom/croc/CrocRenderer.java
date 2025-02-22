package com.shengchanshe.changshengjue.entity.custom.croc;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CrocRenderer extends GeoEntityRenderer<Croc> {
    public CrocRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrocModel());
        this.shadowRadius = 0.5f;//阴影半径
//        this.addLayer(new SaddleLayer(this, new PigModel(p_174340_.bakeLayer(ModelLayers.PIG_SADDLE)), new ResourceLocation("textures/entity/pig/pig_saddle.png")));
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(Croc instance) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/croc_entity.png");
    }

    //获取渲染类型
    @Override
    public void render(Croc entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()){
            poseStack.scale(0.5F,0.5F,0.5F);//缩放实体大小
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
