package com.shengchanshe.changshengjue.item.render.combat.armor.walker_set.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.armor.flying_fish_robe.FlyingFishRobe;
import com.shengchanshe.changshengjue.item.combat.armor.walker_set.WalkerSet;
import com.shengchanshe.changshengjue.item.render.combat.armor.flying_fish_robe.FlyingFishRobeRender;
import com.shengchanshe.changshengjue.item.render.combat.armor.walker_set.WalkerSetRender;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class WalkerSetHelmetLayer extends GeoRenderLayer<WalkerSet> {
    public WalkerSetHelmetLayer(GeoRenderer<WalkerSet> entityRendererIn) {
        super(entityRendererIn);
    }

    private static final ResourceLocation TEXTURE_0 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/walker_set_layer_0.png");
    private static final ResourceLocation TEXTURE_1 = new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/walker_set_layer_1.png");


    public void render(PoseStack poseStack, WalkerSet animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        // 获取当前的 ItemStack
        ItemStack currentStack = ((WalkerSetRender) this.getRenderer()).getCurrentStack();
        RenderType armorRenderType = RenderType.armorCutoutNoCull(TEXTURE_0);
        if (currentStack.is(ChangShengJueItems.WALKER_SET_HELMET_0.get())){
            armorRenderType = RenderType.armorCutoutNoCull(TEXTURE_0);
        }else if (currentStack.is(ChangShengJueItems.WALKER_SET_HELMET_1.get())){
            armorRenderType = RenderType.armorCutoutNoCull(TEXTURE_1);
        }
        this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, armorRenderType, bufferSource.getBuffer(armorRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }

}
