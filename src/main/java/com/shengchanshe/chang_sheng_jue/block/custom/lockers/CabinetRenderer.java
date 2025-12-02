package com.shengchanshe.chang_sheng_jue.block.custom.lockers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.custom.storage.BookGrid;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CabinetRenderer implements BlockEntityRenderer<CabinetEntity> {
    private final CabinetModel model;

    private static final ResourceLocation BIRCH_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/birch_cabinet.png");
    private static final ResourceLocation JUNGLE_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/jungle_cabinet.png");
    private static final ResourceLocation CRIMSON_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/crimson_cabinet.png");
    private static final ResourceLocation WARPED_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/warped_cabinet.png");
    private static final ResourceLocation MANGROVE_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/mangrove_cabinet.png");
    private static final ResourceLocation HUANG_HUA_LI_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/huang_hua_li_cabinet.png");
    private static final ResourceLocation WENGE_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/wenge_cabinet.png");
    private static final ResourceLocation ACACIA_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/acacia_cabinet.png");
    private static final ResourceLocation DARK_OAK_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/dark_oak_cabinet.png");
    private static final ResourceLocation OAK_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/oak_cabinet.png");
    private static final ResourceLocation CHERRY_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/cherry_cabinet.png");
    private static final ResourceLocation SPRUCE_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/spruce_cabinet.png");
    private static final ResourceLocation ZI_TAN_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/zi_tan_cabinet.png");

    public CabinetRenderer(BlockEntityRendererProvider.Context context) {
        this.model = new CabinetModel(context.bakeLayer(CabinetModel.LAYER_LOCATION));
    }

    @Override
    public void render(CabinetEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        renderStorageModel(blockEntity, partialTick, poseStack, bufferSource, packedLight, packedOverlay);
    }

    private void renderStorageModel(CabinetEntity blockEntity, float partialTick,PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        var blockState = blockEntity.getBlockState();
        Direction facing = blockState.getValue(BookGrid.FACING);
        ChestType chestType = blockState.getValue(BookGrid.TYPE);

        poseStack.pushPose();
        poseStack.translate(0.5F, 0.5F, 0.5F);

        poseStack.mulPose(Axis.YP.rotationDegrees(-facing.toYRot()));
        poseStack.mulPose(Axis.ZN.rotationDegrees(-180));
        poseStack.translate(0.0F, -1.0F, 0.0F);
        // 设置柜门动画
        float openProgress = blockEntity.getOpenNess(partialTick);

        model.setDoorAngles(openProgress);
        // 获取对应的纹理
        ResourceLocation texture = getTextureForBlock(blockState);
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entitySolid(texture));

        // 根据类型渲染对应的模型部分
        switch (chestType) {
            case SINGLE -> model.renderSingle(poseStack, vertexConsumer, packedLight, packedOverlay);
            case LEFT -> model.renderLeft(poseStack, vertexConsumer, packedLight, packedOverlay);
            case RIGHT -> model.renderRight(poseStack, vertexConsumer, packedLight, packedOverlay);
        }

        poseStack.popPose();
    }

    private ResourceLocation getTextureForBlock(BlockState state) {
        Block block = state.getBlock();

        if (block == ChangShengJueBlocks.BIRCH_CABINET.get()) {
            return BIRCH_TEXTURE;
        } else if (block == ChangShengJueBlocks.JUNGLE_CABINET.get()) {
            return JUNGLE_TEXTURE;
        } else if (block == ChangShengJueBlocks.CRIMSON_CABINET.get()) {
            return CRIMSON_TEXTURE;
        } else if (block == ChangShengJueBlocks.WARPED_CABINET.get()) {
            return WARPED_TEXTURE;
        } else if (block == ChangShengJueBlocks.MANGROVE_CABINET.get()) {
            return MANGROVE_TEXTURE;
        } else if (block == ChangShengJueBlocks.HUANG_HUA_LI_CABINET.get()) {
            return HUANG_HUA_LI_TEXTURE;
        } else if (block == ChangShengJueBlocks.WENGE_CABINET.get()) {
            return WENGE_TEXTURE;
        } else if (block == ChangShengJueBlocks.ACACIA_CABINET.get()) {
            return ACACIA_TEXTURE;
        } else if (block == ChangShengJueBlocks.DARK_OAK_CABINET.get()) {
            return DARK_OAK_TEXTURE;
        } else if (block == ChangShengJueBlocks.OAK_CABINET.get()) {
            return OAK_TEXTURE;
        } else if (block == ChangShengJueBlocks.CHERRY_CABINET.get()) {
            return CHERRY_TEXTURE;
        } else if (block == ChangShengJueBlocks.SPRUCE_CABINET.get()) {
            return SPRUCE_TEXTURE;
        } else if (block == ChangShengJueBlocks.ZI_TAN_CABINET.get()) {
            return ZI_TAN_TEXTURE;
        }

        return BIRCH_TEXTURE;
    }

}