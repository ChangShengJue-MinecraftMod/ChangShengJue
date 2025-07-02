package com.shengchanshe.chang_sheng_jue.item.combat.lance;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.knife.LargeKnife;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class RedTasselledSpearLayer extends GeoRenderLayer<LargeKnife> {
    private static final ResourceLocation OVERLAY_TEXTURE =
            new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/red_tasselled_spear_overlay.png");

    public RedTasselledSpearLayer(GeoRenderer<LargeKnife> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack poseStack, LargeKnife animatable, BakedGeoModel bakedModel, RenderType renderType,
                       MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {

        // 1. 获取动态纹理偏移
        float uOffset = this.getTextureAnimationOffset(partialTick);

        // 渲染带UV偏移的模型
        poseStack.pushPose();
        poseStack.scale(1.2f, 1.2f, 1.2f);
        RenderType renderType1 = RenderType.energySwirl(OVERLAY_TEXTURE, uOffset, 0);
        getRenderer().reRender(
                getDefaultBakedModel(animatable),
                poseStack,
                bufferSource,
                animatable,
                renderType1,
                bufferSource.getBuffer(renderType1),
                partialTick,
                LightTexture.FULL_BRIGHT, // 强制最大亮度
                packedOverlay,
                1.0f, 1.0f, 1.0f, 0.7f // 提高alpha值增强发光
        );
        poseStack.popPose();
    }

    // 计算纹理动画偏移（基于时间）
    private float getTextureAnimationOffset(float partialTick) {
        if (Minecraft.getInstance().player != null) {
            return (Minecraft.getInstance().player.tickCount + partialTick) * 0.05F;
        }
        return partialTick;
    }
}
