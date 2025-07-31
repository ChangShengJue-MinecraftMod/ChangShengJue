package com.shengchanshe.chang_sheng_jue.block.custom.forgeblock;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class ForgeBlockEntityRender implements BlockEntityRenderer<ForgeBlockEntity> {
    @Override
    public void render(ForgeBlockEntity forgeBlockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {

    }

    public ForgeBlockEntityRender(BlockEntityRendererProvider.Context context) {}

}