package com.shengchanshe.chang_sheng_jue.item.combat.armor.hats.with_veil.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.hats.with_veil.HatsWithVeil;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.hats.with_veil.HatsWithVeilRender;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class HatsWithVeilRenderLayer extends GeoRenderLayer<HatsWithVeil> {
    public HatsWithVeilRenderLayer(GeoRenderer<HatsWithVeil> entityRendererIn) {
        super(entityRendererIn);
    }

    private static final ResourceLocation TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/hats_with_veil_layer.png");

    public void render(PoseStack poseStack, HatsWithVeil animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        ItemStack currentStack = ((HatsWithVeilRender) this.getRenderer()).getCurrentStack();
        RenderType armorRenderType;
        EquipmentSlot currentSlot = ((HatsWithVeilRender) this.getRenderer()).getCurrentSlot();
        float alpha = 1.0f; // 默认不透明
        if (currentSlot == EquipmentSlot.HEAD) {
            armorRenderType = RenderType.entityTranslucent(TEXTURE);
            alpha = 0.5f;
        } else {
            armorRenderType = RenderType.armorCutoutNoCull(TEXTURE);
        }

        int color = ((HatsWithVeilRender) this.getRenderer()).getArmorColor(currentStack);

        float red = (color >> 16 & 255) / 255.0f;
        float green = (color >> 8 & 255) / 255.0f;
        float blue = (color & 255) / 255.0f;

        this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, armorRenderType,
                bufferSource.getBuffer(armorRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, red, green, blue, alpha);
    }

}
