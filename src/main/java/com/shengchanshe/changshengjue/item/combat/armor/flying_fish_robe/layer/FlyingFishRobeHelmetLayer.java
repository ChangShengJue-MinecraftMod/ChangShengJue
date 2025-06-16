package com.shengchanshe.changshengjue.item.combat.armor.flying_fish_robe.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.armor.flying_fish_robe.FlyingFishRobe;
import com.shengchanshe.changshengjue.item.combat.armor.flying_fish_robe.FlyingFishRobeRender;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class FlyingFishRobeHelmetLayer extends GeoRenderLayer<FlyingFishRobe> {
    public FlyingFishRobeHelmetLayer(GeoRenderer<FlyingFishRobe> entityRendererIn) {
        super(entityRendererIn);
    }

    private static final ResourceLocation TEXTURE_0 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/flying_fish_robe_layer_0.png");
    private static final ResourceLocation TEXTURE_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/flying_fish_robe_layer_1.png");

    public void render(PoseStack poseStack, FlyingFishRobe animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        // 获取当前的 ItemStack
        ItemStack currentStack = ((FlyingFishRobeRender) this.getRenderer()).getCurrentStack();
        RenderType armorRenderType = RenderType.armorCutoutNoCull(TEXTURE_0);
        if (currentStack.is(ChangShengJueItems.FLY_FISH_IRON_HAT.get())){
            armorRenderType = RenderType.armorCutoutNoCull(TEXTURE_0);
        }else if (currentStack.is(ChangShengJueItems.FLY_FISH_CLOUD_VEIL_CROWN.get())){
            armorRenderType = RenderType.armorCutoutNoCull(TEXTURE_1);
        }
        this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, armorRenderType,
                bufferSource.getBuffer(armorRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }

}
