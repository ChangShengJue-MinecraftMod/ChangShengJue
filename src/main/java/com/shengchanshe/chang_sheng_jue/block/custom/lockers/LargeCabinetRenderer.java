package com.shengchanshe.chang_sheng_jue.block.custom.lockers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.BigBlockType;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LargeCabinetRenderer implements BlockEntityRenderer<LargeCabinetEntity> {
    private final LargeCabinetModel<?> model;
    private static final ResourceLocation BIRCH_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/birch_large_cabinet.png");
    private static final ResourceLocation JUNGLE_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/jungle_large_cabinet.png");
    private static final ResourceLocation CRIMSON_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/crimson_large_cabinet.png");
    private static final ResourceLocation WARPED_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/warped_large_cabinet.png");
    private static final ResourceLocation MANGROVE_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/mangrove_large_cabinet.png");
    private static final ResourceLocation HUANG_HUA_LI_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/huang_hua_li_large_cabinet.png");
    private static final ResourceLocation WENGE_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/wenge_large_cabinet.png");
    private static final ResourceLocation ACACIA_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/acacia_large_cabinet.png");
    private static final ResourceLocation DARK_OAK_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/dark_oak_large_cabinet.png");
    private static final ResourceLocation OAK_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/oak_large_cabinet.png");
    private static final ResourceLocation CHERRY_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/cherry_large_cabinet.png");
    private static final ResourceLocation SPRUCE_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/spruce_large_cabinet.png");
    private static final ResourceLocation ZI_TAN_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/zi_tan_large_cabinet.png");

    public LargeCabinetRenderer(BlockEntityRendererProvider.Context ctx) {
        this.model = new LargeCabinetModel<>(ctx.bakeLayer(LargeCabinetModel.LAYER_LOCATION));
    }

    private ResourceLocation getTextureForBlock(BlockState state) {
        Block block = state.getBlock();

        if (block == ChangShengJueBlocks.BIRCH_LARGE_CABINET.get()) {
            return BIRCH_TEXTURE;
        } else if (block == ChangShengJueBlocks.JUNGLE_LARGE_CABINET.get()) {
            return JUNGLE_TEXTURE;
        } else if (block == ChangShengJueBlocks.CRIMSON_LARGE_CABINET.get()) {
            return CRIMSON_TEXTURE;
        } else if (block == ChangShengJueBlocks.WARPED_LARGE_CABINET.get()) {
            return WARPED_TEXTURE;
        } else if (block == ChangShengJueBlocks.MANGROVE_LARGE_CABINET.get()) {
            return MANGROVE_TEXTURE;
        } else if (block == ChangShengJueBlocks.HUANG_HUA_LI_LARGE_CABINET.get()) {
            return HUANG_HUA_LI_TEXTURE;
        } else if (block == ChangShengJueBlocks.WENGE_LARGE_CABINET.get()) {
            return WENGE_TEXTURE;
        } else if (block == ChangShengJueBlocks.ACACIA_LARGE_CABINET.get()) {
            return ACACIA_TEXTURE;
        } else if (block == ChangShengJueBlocks.DARK_OAK_LARGE_CABINET.get()) {
            return DARK_OAK_TEXTURE;
        } else if (block == ChangShengJueBlocks.OAK_LARGE_CABINET.get()) {
            return OAK_TEXTURE;
        } else if (block == ChangShengJueBlocks.CHERRY_LARGE_CABINET.get()) {
            return CHERRY_TEXTURE;
        } else if (block == ChangShengJueBlocks.SPRUCE_LARGE_CABINET.get()) {
            return SPRUCE_TEXTURE;
        } else if (block == ChangShengJueBlocks.ZI_TAN_LARGE_CABINET.get()) {
            return ZI_TAN_TEXTURE;
        }

        return BIRCH_TEXTURE;
    }

    @Override
    public void render(LargeCabinetEntity largeCabinet, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if (largeCabinet.getLevel() == null) return;

        BlockState state = largeCabinet.getBlockState();
        BigBlockType part = state.getValue(LargeCabinet.PART);

        float openProgress = largeCabinet.getOpenNess(partialTick);

        poseStack.pushPose();

        poseStack.translate(0.5f, 1.5f, 0.5f);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180f));

        Direction facing = state.getValue(LargeCabinet.FACING);
        float rotation = switch (facing) {
            case NORTH -> 0;
            case SOUTH -> 180;
            case EAST -> 90;
            case WEST -> 270;
            default -> 0;
        };
        poseStack.mulPose(Axis.YP.rotationDegrees(rotation));

        setDoorAnimationForPart(openProgress, part);

        ResourceLocation texture = getTextureForBlock(state);
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(texture));

        renderSpecificPart(poseStack, vertexConsumer, packedLight, packedOverlay, part);

        poseStack.popPose();
    }

    private void setDoorAnimationForPart(float openProgress, BigBlockType part) {
        switch (part) {
            case BOTTOM_LEFT -> model.setDoorAngles(openProgress, 0, 0, 0, 0, 0);
            case MIDDLE_LEFT -> model.setDoorAngles(0, openProgress, 0, 0, 0, 0);
            case TOP_LEFT -> model.setDoorAngles(0, 0, openProgress, 0, 0, 0);
            case BOTTOM_RIGHT -> model.setDoorAngles(0, 0, 0, openProgress, 0, 0);
            case MIDDLE_RIGHT -> model.setDoorAngles(0, 0, 0, 0, openProgress, 0);
            case TOP_RIGHT -> model.setDoorAngles(0, 0, 0, 0, 0, openProgress);
        }
    }

    private void renderSpecificPart(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, BigBlockType part) {
        switch (part) {
            case BOTTOM_LEFT -> model.renderBottomLeft(poseStack, vertexConsumer, packedLight, packedOverlay);
            case MIDDLE_LEFT -> model.renderMiddleLeft(poseStack, vertexConsumer, packedLight, packedOverlay);
            case TOP_LEFT -> model.renderTopLeft(poseStack, vertexConsumer, packedLight, packedOverlay);
            case BOTTOM_RIGHT -> model.renderBottomRight(poseStack, vertexConsumer, packedLight, packedOverlay);
            case MIDDLE_RIGHT -> model.renderMiddleRight(poseStack, vertexConsumer, packedLight, packedOverlay);
            case TOP_RIGHT -> model.renderTopRight(poseStack, vertexConsumer, packedLight, packedOverlay);
        }
    }
}
