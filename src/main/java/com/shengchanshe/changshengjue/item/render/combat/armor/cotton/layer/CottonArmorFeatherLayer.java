package com.shengchanshe.changshengjue.item.render.combat.armor.cotton.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.armor.cotton.CottonArmor;
import com.shengchanshe.changshengjue.item.render.combat.armor.cotton.CottonArmorRender;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class CottonArmorFeatherLayer extends GeoRenderLayer<CottonArmor> {
    public CottonArmorFeatherLayer(GeoRenderer<CottonArmor> entityRendererIn) {
        super(entityRendererIn);
    }

    private static final ResourceLocation TEXTURE_0 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/cotton_armor_feather_layer_0.png");
    private static final ResourceLocation TEXTURE_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/cotton_armor_white_feather_layer_1.png");


    public void render(PoseStack poseStack, CottonArmor animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        // 获取当前的 ItemStack
        ItemStack currentStack = ((CottonArmorRender) this.getRenderer()).getCurrentStack();
        RenderType armorRenderType = RenderType.armorCutoutNoCull(TEXTURE_0);
        if (currentStack.is(ChangShengJueItems.COTTON_ARMOR_FEATHER_HELMET.get())){
            armorRenderType = RenderType.armorCutoutNoCull(TEXTURE_0);
        }else if (currentStack.is(ChangShengJueItems.COTTON_ARMOR_WHITE_FEATHER_HELMET.get())){
            armorRenderType = RenderType.armorCutoutNoCull(TEXTURE_1);
        }
        this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, armorRenderType, bufferSource.getBuffer(armorRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }

}
