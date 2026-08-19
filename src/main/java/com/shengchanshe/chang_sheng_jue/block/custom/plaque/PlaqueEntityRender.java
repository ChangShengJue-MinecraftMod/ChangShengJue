package com.shengchanshe.chang_sheng_jue.block.custom.plaque;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class PlaqueEntityRender  implements BlockEntityRenderer<PlaqueEntity> {
    private static final int WRAP_WIDTH_PIXELS = 48;
    private static final int MAX_RENDERED_LINES = 4;
    private static final float BASE_SCALE = 0.065F;
    private static final float MAX_WORLD_WIDTH = 0.72F;
    private static final float MAX_WORLD_HEIGHT = 0.36F;

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
            List<FormattedCharSequence> wrappedLines = font.split(Component.literal(text), WRAP_WIDTH_PIXELS);
            int lineCount = Math.min(MAX_RENDERED_LINES, wrappedLines.size());
            if (lineCount == 0) {
                poseStack.popPose();
                return;
            }

            int maxLineWidth = 1;
            for (int index = 0; index < lineCount; index++) {
                maxLineWidth = Math.max(maxLineWidth, font.width(wrappedLines.get(index)));
            }
            float scale = Math.min(BASE_SCALE, Math.min(
                    MAX_WORLD_WIDTH / maxLineWidth,
                    MAX_WORLD_HEIGHT / (font.lineHeight * (float) lineCount)
            ));

            poseStack.scale(scale, scale, scale);
            float startY = -(font.lineHeight * lineCount) / 2.0F;
            for (int index = 0; index < lineCount; index++) {
                FormattedCharSequence line = wrappedLines.get(index);
                float lineX = -font.width(line) / 2.0F;
                font.drawInBatch(line, lineX, startY + index * font.lineHeight, 0x000000, false,
                        poseStack.last().pose(), bufferSource, Font.DisplayMode.POLYGON_OFFSET, 0, packedLight);
            }
            poseStack.popPose();
        }
    }
}
