package com.shengchanshe.chang_sheng_jue.item.combat.armor.confucian_costumes.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.confucian_costumes.ConfucianCostumes;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.confucian_costumes.ConfucianCostumesRender;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.cotton.CottonArmor;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.cotton.CottonArmorRender;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class ConfucianCostumesLayer extends GeoRenderLayer<ConfucianCostumes> {
    public ConfucianCostumesLayer(GeoRenderer<ConfucianCostumes> entityRendererIn) {
        super(entityRendererIn);
    }

    private static final ResourceLocation TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/confucian_costumes_layer.png");

    public void render(PoseStack poseStack, ConfucianCostumes animatable, BakedGeoModel bakedModel, RenderType renderType,
                       MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        // 获取当前的 ItemStack
        ItemStack currentStack = ((ConfucianCostumesRender) this.getRenderer()).getCurrentStack();
        RenderType armorRenderType = RenderType.armorCutoutNoCull(TEXTURE);
        // 从物品堆中获取颜色
        int color = ((ConfucianCostumesRender) this.getRenderer()).getArmorColor(currentStack);

        // 将颜色分解为 RGBA
        float red = (color >> 16 & 255) / 255.0f;
        float green = (color >> 8 & 255) / 255.0f;
        float blue = (color & 255) / 255.0f;

        this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, armorRenderType, bufferSource.getBuffer(armorRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, red, green, blue, 1.0F);
    }

}
