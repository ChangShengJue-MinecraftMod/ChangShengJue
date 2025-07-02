package com.shengchanshe.chang_sheng_jue.block.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.shengchanshe.chang_sheng_jue.block.entity.PlaqueEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PlaqueEntityRender  implements BlockEntityRenderer<PlaqueEntity> {
    public PlaqueEntityRender(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(PlaqueEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        String text = blockEntity.getText();

        if (!text.isEmpty()) {
            poseStack.pushPose();
            // 获取 FontRenderer（字体渲染器）
            Font font = Minecraft.getInstance().font;
            Direction facing = blockEntity.getFacing();
            switch (facing) {
                case NORTH -> {
                    poseStack.translate(0.55, 0.55,0.85); // 将文字放置在方块中央
                    poseStack.mulPose(Axis.YP.rotationDegrees(180));
                }
                case SOUTH -> {
                    poseStack.translate(0.45, 0.55,0.15);
                    poseStack.mulPose(Axis.YP.rotationDegrees(0));
                }
                case WEST -> {
                    poseStack.translate(0.85, 0.55,0.45);
                    poseStack.mulPose(Axis.YP.rotationDegrees(270));
                }
                case EAST -> {
                    poseStack.translate(0.15, 0.55,0.55);
                    poseStack.mulPose(Axis.YP.rotationDegrees(90));
                }
            }
//            poseStack.mulPose(Axis.YP.rotationDegrees(180F));
            poseStack.mulPose(Axis.XP.rotationDegrees(180f));
            poseStack.translate(0.1,0.1,0);
            poseStack.scale(0.065f, 0.065f, 0.065f); // 缩小文字尺寸
            // 渲染文字（居中对齐）
            float textWidth = font.width(text) / 2.0f;
            font.drawInBatch(text, -textWidth, -5, 0x000, false, poseStack.last().pose(),
                    bufferSource, Font.DisplayMode.POLYGON_OFFSET, 0, 0xF000F0);
            poseStack.popPose();
        }
    }
}