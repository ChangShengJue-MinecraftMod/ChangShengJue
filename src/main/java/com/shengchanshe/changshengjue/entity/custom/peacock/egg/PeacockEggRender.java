package com.shengchanshe.changshengjue.entity.custom.peacock.egg;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemDisplayContext;

public class PeacockEggRender extends EntityRenderer<PeacockEgg> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID ,"textures/item/peacock_eggs.png");
    private final ItemRenderer itemRenderer;
    private final float scale;
    public PeacockEggRender(EntityRendererProvider.Context context) {
        super(context);
        this.itemRenderer=context.getItemRenderer();
        this.scale=1.0F;
    }

    @Override
    public ResourceLocation getTextureLocation(PeacockEgg p_114482_) {
        return TEXTURE;
    }
    public void render(PeacockEgg entityIn, float entityYaw, float partialTicks, PoseStack poseStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        if (entityIn.tickCount >= 2 || !(this.entityRenderDispatcher.camera.getEntity().distanceToSqr(entityIn) < 12.25D)) {
            poseStackIn.pushPose();
            poseStackIn.scale(this.scale, this.scale, this.scale);
            poseStackIn.mulPose(this.entityRenderDispatcher.cameraOrientation());
            poseStackIn.mulPose(Axis.YP.rotationDegrees(180.0F));
            this.itemRenderer.renderStatic(((ItemSupplier)entityIn).getItem(), ItemDisplayContext.GROUND, packedLightIn, OverlayTexture.NO_OVERLAY, poseStackIn, bufferIn, entityIn.level(), entityIn.getId());
            poseStackIn.popPose();
            super.render(entityIn, entityYaw, partialTicks, poseStackIn, bufferIn, packedLightIn);
        }
    }

}
