package com.shengchanshe.changshengjue.entity.client.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.client.model.DragonflyModel;
import com.shengchanshe.changshengjue.entity.custom.DragonflyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Vex;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DragonflyRenderer extends GeoEntityRenderer<DragonflyEntity> {
    public DragonflyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DragonflyModel());
        this.shadowRadius = 0.3f;//阴影半径
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(DragonflyEntity instance) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/dragonfly_entity.png");
    }

    //获取渲染类型
    @Override
    public void render(DragonflyEntity entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.scale(0.8F,0.8F,0.8F);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
