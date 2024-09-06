package com.shengchanshe.changshengjue.entity.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.client.model.HunterModel;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueHunterEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HunterRenderer extends GeoEntityRenderer<ChangShengJueHunterEntity> {
    public HunterRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HunterModel());
        this.shadowRadius = 0.3f;//阴影半径
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(ChangShengJueHunterEntity instance) {
        if (instance.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/villager/chang_sheng_jue_villager_baby.png");
        }else {
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/villager/chang_sheng_jue_hunter.png");
        }
    }

    //获取渲染类型
    @Override
    public void render(ChangShengJueHunterEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.7F,0.7F,0.7F);//缩放实体大小
        }else {
            poseStack.scale(1.0F,1.0F,1.0F);//缩放实体大小
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
