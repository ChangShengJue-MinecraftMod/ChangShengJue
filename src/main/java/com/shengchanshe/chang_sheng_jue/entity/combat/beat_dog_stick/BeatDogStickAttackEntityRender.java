package com.shengchanshe.chang_sheng_jue.entity.combat.beat_dog_stick;

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
public class BeatDogStickAttackEntityRender extends EntityRenderer<BeatDogStickAttackEntity> {
    private static final ResourceLocation[] TEXTURES = {
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/beat_dog_stick_attack/beat_dog_stick_attack_1.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/beat_dog_stick_attack/beat_dog_stick_attack_2.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/beat_dog_stick_attack/beat_dog_stick_attack_3.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/beat_dog_stick_attack/beat_dog_stick_attack_4.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/beat_dog_stick_attack/beat_dog_stick_attack_5.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/beat_dog_stick_attack/beat_dog_stick_attack_6.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/beat_dog_stick_attack/beat_dog_stick_attack_7.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/beat_dog_stick_attack/beat_dog_stick_attack_8.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/beat_dog_stick_attack/beat_dog_stick_attack_9.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/beat_dog_stick_attack/beat_dog_stick_attack_10.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/beat_dog_stick_attack/beat_dog_stick_attack_11.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/beat_dog_stick_attack/beat_dog_stick_attack_12.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/beat_dog_stick_attack/beat_dog_stick_attack_13.png"),
            new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/beat_dog_stick_attack/beat_dog_stick_attack_14.png"),
    };

    public BeatDogStickAttackEntityRender(EntityRendererProvider.Context renderManager) {
        super(renderManager);
    }


    @Override
    public void render(BeatDogStickAttackEntity entity, float yaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light) {
        poseStack.pushPose();

        PoseStack.Pose pose = poseStack.last();
        poseStack.mulPose(Axis.YP.rotationDegrees(-90 - entity.getYRot()));
        poseStack.mulPose(Axis.ZP.rotationDegrees(entity.getXRot() + 90));
        poseStack.mulPose(Axis.XP.rotationDegrees(0));

        int alpha = 255; // 范围 0-255
        drawSlash(pose, entity, alpha,bufferSource, entity.getBbWidth() * 1.5f);

        poseStack.popPose();

        super.render(entity, yaw, partialTicks, poseStack, bufferSource, light);
    }
    private void drawSlash(PoseStack.Pose pose, BeatDogStickAttackEntity entity, int alpha, MultiBufferSource bufferSource, float width) {
        Matrix4f poseMatrix = pose.pose();
        Matrix3f normalMatrix = pose.normal();

        VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityTranslucent(getTextureLocation(entity)));
        float halfWidth = width * 0.5f;
        float height = entity.getBbHeight() * 0.1f;

        consumer.vertex(poseMatrix, -halfWidth, height, -halfWidth).color(255, 255, 255, alpha)
                .uv(0f, 0f).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(normalMatrix, 1f, 1f, 1f).endVertex();
        consumer.vertex(poseMatrix, halfWidth, height, -halfWidth).color(255, 255, 255, alpha)
                .uv(1f, 0f).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(normalMatrix, 1f, 1f, 1f).endVertex();
        consumer.vertex(poseMatrix, halfWidth, height, halfWidth).color(255, 255, 255, alpha)
                .uv(1f, 1f).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(normalMatrix, 1f, 1f, 1f).endVertex();
        consumer.vertex(poseMatrix, -halfWidth, height, halfWidth).color(255, 255, 255, alpha)
                .uv(0f, 1f).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(LightTexture.FULL_BRIGHT).normal(normalMatrix, 1f, 1f, 1f).endVertex();
    }

    @Override
    public ResourceLocation getTextureLocation(BeatDogStickAttackEntity entity) {
        int frame = (entity.tickCount * 2) % TEXTURES.length;
        return TEXTURES[frame];
    }

}
