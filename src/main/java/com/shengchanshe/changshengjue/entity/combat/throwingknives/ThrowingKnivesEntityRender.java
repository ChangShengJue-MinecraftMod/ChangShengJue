package com.shengchanshe.changshengjue.entity.combat.throwingknives;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ThrowingKnivesEntityRender extends EntityRenderer<ThrowingKnivesEntity> {
    public static final ResourceLocation THROWING_KNIVES = new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/throwing_knives_entity.png");
    private final ThrowingKnivesEntityModel model;

    public ThrowingKnivesEntityRender(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new ThrowingKnivesEntityModel(pContext.bakeLayer(ThrowingKnivesEntityModel.LAYER_LOCATION));
    }

    @Override
    public void render(ThrowingKnivesEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 270.0F));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 270.0F));
        pPoseStack.scale(0.5f,0.5f,0.5f);
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, pEntity.isFoil());
        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrowingKnivesEntity pEntity) {
        return THROWING_KNIVES;
    }
}