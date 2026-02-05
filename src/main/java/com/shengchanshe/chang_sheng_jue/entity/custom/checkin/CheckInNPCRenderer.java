package com.shengchanshe.chang_sheng_jue.entity.custom.checkin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

/**
 * 签到NPC渲染器
 */
public class CheckInNPCRenderer extends GeoEntityRenderer<CheckInNPC> {
    public CheckInNPCRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CheckInNPCModel());
    }

    @Override
    public void render(CheckInNPC entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
