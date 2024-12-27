package com.shengchanshe.changshengjue.item.render.combat.armor.wedding.layer;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.combat.armor.wedding.MaleChineseWeddingDress;
import com.shengchanshe.changshengjue.item.render.combat.armor.wedding.MaleChineseWeddingDressRender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class MaleChineseWeddingDressLayer extends GeoRenderLayer<MaleChineseWeddingDress> {
    public MaleChineseWeddingDressLayer(GeoRenderer<MaleChineseWeddingDress> entityRendererIn) {
        super(entityRendererIn);
    }

    private static final ResourceLocation TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/item/armor/male_chinese_wedding_dress_layer.png");
    @Override
    public void render(PoseStack poseStack, MaleChineseWeddingDress animatable, BakedGeoModel bakedModel, RenderType renderType,
                       MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        // 获取当前的 ItemStack
        ItemStack currentStack = ((MaleChineseWeddingDressRender) this.getRenderer()).getCurrentStack();


        // 从物品堆中获取颜色
        int color = ((MaleChineseWeddingDressRender) this.getRenderer()).getArmorColor(currentStack);

        // 将颜色分解为 RGBA
        float red = (color >> 16 & 255) / 255.0f;
        float green = (color >> 8 & 255) / 255.0f;
        float blue = (color & 255) / 255.0f;
        RenderType armorRenderType;
        float alpha = 1.0f; // 默认不透明
        // 判断当前正在渲染的盔甲部分
        EquipmentSlot currentSlot = ((MaleChineseWeddingDressRender) this.getRenderer()).getCurrentSlot();

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

//    /**
//     * 创建一个支持透明的自定义 RenderType
//     */
//    private RenderType getTransparentArmorRenderType(ResourceLocation texture) {
//        return RenderType.create(
//                "transparent_armor", // 自定义渲染类型名称
//                DefaultVertexFormat.NEW_ENTITY, // 顶点格式
//                VertexFormat.Mode.QUADS, // 渲染模式
//                256, // 缓冲区大小
//                true, // 是否需要排序
//                true, // 是否使用深度测试
//                RenderType.CompositeState.builder()
//                        // 配置纹理
//                        .setTextureState(new RenderStateShard.TextureStateShard(texture, false, false))
//
//                        // 配置透明混合
//                        .setTransparencyState(new RenderStateShard.TransparencyStateShard("translucent",
//                                () -> {
//                                    RenderSystem.enableBlend();
//                                    RenderSystem.blendFunc(
//                                            GlStateManager.SourceFactor.SRC_ALPHA,
//                                            GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA
//                                    );
//                                },
//                                () -> RenderSystem.disableBlend()
//                        ))
//
//                        // 配置着色器
//                        .setShaderState(new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityTranslucentShader))
//
//                        // 禁用剔除，确保双面渲染
//                        .setCullState(new RenderStateShard.CullStateShard(false))
//
//                        // 配置颜色写入状态
//                        .setWriteMaskState(new RenderStateShard.WriteMaskStateShard(true, true))
//
//                        // 配置输出目标
//                        .setOutputState(new RenderStateShard.OutputStateShard("translucent_target",
//                                () -> Minecraft.getInstance().getMainRenderTarget().bindWrite(false),
//                                () -> {}
//                        ))
//
//                        .createCompositeState(true) // 创建复合状态
//        );
//    }
}