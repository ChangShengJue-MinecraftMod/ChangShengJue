package com.shengchanshe.chang_sheng_jue.entity.combat.golden_black_knife_method;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class GoldenBlackKnifeMethodEntityRender extends EntityRenderer<GoldenBlackKnifeMethodEntity> {
    private static final ResourceLocation[] TEXTURES = {
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_1.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_2.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_3.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_4.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_5.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_6.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_7.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_8.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_9.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_10.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_11.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_12.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_13.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_14.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_15.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_16.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_17.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/golden_black_knife_method_entity/golden_black_knife_method_entity_18.png"),
    };

    public GoldenBlackKnifeMethodEntityRender(EntityRendererProvider.Context renderManager) {
        super(renderManager);
    }

    @Override
    public void render(GoldenBlackKnifeMethodEntity entity, float yaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light) {
        poseStack.pushPose();

        PoseStack.Pose pose = poseStack.last();
        poseStack.mulPose(Axis.YP.rotationDegrees(135 - entity.getYRot()));
        poseStack.mulPose(Axis.ZP.rotationDegrees(entity.getXRot()));
//        float randomZ = new Random(31L * entity.getId()).nextInt(-18, 18);
        poseStack.mulPose(Axis.XP.rotationDegrees(30));
        int alpha = 200; // 范围 0-255

        drawSlash(pose, entity, alpha,bufferSource, entity.getBbWidth() * 1.5f);

        poseStack.popPose();

        super.render(entity, yaw, partialTicks, poseStack, bufferSource, light);
    }
    private void drawSlash(PoseStack.Pose pose, GoldenBlackKnifeMethodEntity entity, int alpha, MultiBufferSource bufferSource, float width) {
        Matrix4f poseMatrix = pose.pose();
        Matrix3f normalMatrix = pose.normal();

        VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityTranslucent(getTextureLocation(entity)));
        float halfWidth = width * 0.5f;
        float height = entity.getBbHeight() * 0.5f;

        consumer.vertex(poseMatrix, -halfWidth, height, -halfWidth).color(255, 255, 255, alpha)
                .uv(0f, 0f).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(normalMatrix, 0f, 1f, 0f).endVertex();
        consumer.vertex(poseMatrix, halfWidth, height, -halfWidth).color(255, 255, 255, alpha)
                .uv(1f, 0f).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(normalMatrix, 0f, 1f, 0f).endVertex();
        consumer.vertex(poseMatrix, halfWidth, height, halfWidth).color(255, 255, 255, alpha)
                .uv(1f, 1f).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(normalMatrix, 0f, 1f, 0f).endVertex();
        consumer.vertex(poseMatrix, -halfWidth, height, halfWidth).color(255, 255, 255, alpha)
                .uv(0f, 1f).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(normalMatrix, 0f, 1f, 0f).endVertex();
    }

    @Override
    public ResourceLocation getTextureLocation(GoldenBlackKnifeMethodEntity entity) {
        int frame = (entity.tickCount * 2)% TEXTURES.length;
        return TEXTURES[frame];
    }

}
