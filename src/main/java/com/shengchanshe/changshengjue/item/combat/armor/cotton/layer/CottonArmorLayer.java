package com.shengchanshe.changshengjue.item.combat.armor.cotton.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.armor.cotton.CottonArmor;
import com.shengchanshe.changshengjue.item.combat.armor.cotton.CottonArmorRender;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class CottonArmorLayer extends GeoRenderLayer<CottonArmor> {
    public CottonArmorLayer(GeoRenderer<CottonArmor> entityRendererIn) {
        super(entityRendererIn);
    }

    private static final ResourceLocation TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/cotton_armor_layer.png");

    public void render(PoseStack poseStack, CottonArmor animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        // 获取当前的 ItemStack
        ItemStack currentStack = ((CottonArmorRender) this.getRenderer()).getCurrentStack();
        RenderType armorRenderType = RenderType.armorCutoutNoCull(TEXTURE);
        // 从物品堆中获取颜色
        int color = ((CottonArmorRender) this.getRenderer()).getArmorColor(currentStack);

        // 将颜色分解为 RGBA
        float red = (color >> 16 & 255) / 255.0f;
        float green = (color >> 8 & 255) / 255.0f;
        float blue = (color & 255) / 255.0f;

        this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, armorRenderType, bufferSource.getBuffer(armorRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, red, green, blue, 1.0F);
    }

}
