package com.shengchanshe.changshengjue.entity.client.render.combat;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.combat.feidao.FeiDaoEntity;
import com.shengchanshe.changshengjue.entity.client.model.combat.FeiDaoModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class FeiDaoEntityRender extends EntityRenderer<FeiDaoEntity> {
    public static final ResourceLocation TRIDENT_LOCATION = new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/fei_dao.png");
    private final FeiDaoModel model;

   public FeiDaoEntityRender(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new FeiDaoModel(pContext.bakeLayer(FeiDaoModel.LAYER_LOCATION));
    }

    public void render(FeiDaoEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource
    pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F));
        pPoseStack.scale(0.4F,0.4F,0.4F);
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, pEntity.isFoil());
        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(FeiDaoEntity pEntity) {
        return TRIDENT_LOCATION;
    }
}