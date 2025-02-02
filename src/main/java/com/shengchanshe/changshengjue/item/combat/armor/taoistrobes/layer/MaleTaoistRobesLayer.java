package com.shengchanshe.changshengjue.item.combat.armor.taoistrobes.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.armor.taoistrobes.MaleTaoistRobes;
import com.shengchanshe.changshengjue.item.combat.armor.taoistrobes.MaleTaoistRobesRender;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class MaleTaoistRobesLayer extends GeoRenderLayer<MaleTaoistRobes> {
    public MaleTaoistRobesLayer(GeoRenderer<MaleTaoistRobes> entityRendererIn) {
        super(entityRendererIn);
    }

    private static final ResourceLocation TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/male_taoist_robes_layer.png");

    public void render(PoseStack poseStack, MaleTaoistRobes animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        // 获取当前的 ItemStack
        ItemStack currentStack = ((MaleTaoistRobesRender) this.getRenderer()).getCurrentStack();

        // 从物品堆中获取颜色
        int color = ((MaleTaoistRobesRender) this.getRenderer()).getArmorColor(currentStack);

        // 将颜色分解为 RGBA
        float red = (color >> 16 & 255) / 255.0f;
        float green = (color >> 8 & 255) / 255.0f;
        float blue = (color & 255) / 255.0f;
        RenderType armorRenderType;
        float alpha = 1.0f; // 默认不透明
        // 判断当前正在渲染的盔甲部分
        EquipmentSlot currentSlot = ((MaleTaoistRobesRender) this.getRenderer()).getCurrentSlot();

        if (currentSlot == EquipmentSlot.HEAD) {
            // 如果是头盔，则使用透明的 RenderType
            armorRenderType = RenderType.entityTranslucent(TEXTURE);
//                    getTransparentArmorRenderType(TEXTURE);
            alpha = 0.5f; // 设置透明度
        } else {
            // 其他盔甲部位使用默认的 RenderType
            armorRenderType = RenderType.armorCutoutNoCull(TEXTURE);
        }

        // 渲染带透明度的盔甲
        this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, armorRenderType,
                bufferSource.getBuffer(armorRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, red, green, blue, alpha);
    }

}
