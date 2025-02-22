package com.shengchanshe.changshengjue.entity.custom.butterfly;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class ButterflyRenderer extends GeoEntityRenderer<Butterfly> {
    public static final Map<ButterflyVariant,ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ButterflyVariant.class),(map)->{
                map.put(ButterflyVariant.TEXTURES_0,
                        new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/butterfly_entity.png"));
                map.put(ButterflyVariant.TEXTURES_1,
                        new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/butterfly_entity_1.png"));
                map.put(ButterflyVariant.TEXTURES_2,
                        new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/butterfly_entity_2.png"));
                map.put(ButterflyVariant.TEXTURES_3,
                        new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/butterfly_entity_3.png"));
            });

    public ButterflyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ButterflyModel());
        this.shadowRadius = 0.3f;//阴影半径
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(Butterfly instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    //获取渲染类型
//    @Override
//    public RenderType getRenderType(ButterflyEntity animatable, float partialTicks, PoseStack stack,
//                                    @Nullable MultiBufferSource renderTypeBuffer,
//                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
//        stack.scale(1.0F,1.0F,1.0F);//缩放实体大小
//        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
//    }

    @Override
    public void render(Butterfly entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.scale(1.0F,1.0F,1.0F);//缩放实体大小
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
