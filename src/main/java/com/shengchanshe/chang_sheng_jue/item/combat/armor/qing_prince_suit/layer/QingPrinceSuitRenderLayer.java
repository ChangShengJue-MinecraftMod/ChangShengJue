package com.shengchanshe.chang_sheng_jue.item.combat.armor.qing_prince_suit.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.qing_prince_suit.QingPrinceSuit;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.qing_prince_suit.QingPrinceSuitRender;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.render.ArmorRenderUtils;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class QingPrinceSuitRenderLayer extends GeoRenderLayer<QingPrinceSuit> {

    public QingPrinceSuitRenderLayer(GeoRenderer<QingPrinceSuit> entityRendererIn) {
        super(entityRendererIn);
    }

    private static final ResourceLocation TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/qing_prince_suit_layer.png");

    public void render(PoseStack poseStack, QingPrinceSuit animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        ItemStack currentStack = ArmorRenderUtils.getEffectiveArmorStack((QingPrinceSuitRender) this.getRenderer());
        RenderType armorRenderType = RenderType.armorCutoutNoCull(TEXTURE);

        int color = ((QingPrinceSuitRender) this.getRenderer()).getArmorColor(currentStack);

        float red = (color >> 16 & 255) / 255.0f;
        float green = (color >> 8 & 255) / 255.0f;
        float blue = (color & 255) / 255.0f;

        this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, armorRenderType,
                bufferSource.getBuffer(armorRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, red, green, blue, 1.0f);
    }

}




