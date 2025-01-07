package com.shengchanshe.changshengjue.entity.combat.ge_shan_da_niu;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GeShanDaNiuRender extends GeoEntityRenderer<GeShanDaNiuEntity> {
    public GeShanDaNiuRender(EntityRendererProvider.Context renderManager) {
        super(renderManager,new DefaultedEntityGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"ge_shan_da_niu")));
    }

    @Override
    public void render(GeShanDaNiuEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();

        poseStack.mulPose(Axis.YP.rotationDegrees(360 - entity.getYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(entity.getXRot()));

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }
}

