package com.shengchanshe.chang_sheng_jue.block.custom.storage;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
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
public class BookGridRenderer implements BlockEntityRenderer<BookGridEntity> {
    private final BookGridModel model;
    private final ItemRenderer itemRenderer;

    private static final ResourceLocation BIRCH_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/birch_storage_compartment.png");
    private static final ResourceLocation JUNGLE_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/jungle_storage_compartment.png");
    private static final ResourceLocation CRIMSON_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/crimson_storage_compartment.png");
    private static final ResourceLocation WARPED_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/warped_storage_compartment.png");
    private static final ResourceLocation MANGROVE_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/mangrove_storage_compartment.png");
    private static final ResourceLocation HUANG_HUA_LI_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/huang_hua_li_storage_compartment.png");
    private static final ResourceLocation WENGE_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/wenge_storage_compartment.png");
    private static final ResourceLocation ACACIA_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/acacia_storage_compartment.png");
    private static final ResourceLocation DARK_OAK_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/dark_oak_storage_compartment.png");
    private static final ResourceLocation OAK_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/oak_storage_compartment.png");
    private static final ResourceLocation CHERRY_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/cherry_storage_compartment.png");
    private static final ResourceLocation SPRUCE_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/spruce_storage_compartment.png");
    private static final ResourceLocation ZI_TAN_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/block/zi_tan_storage_compartment.png");

    public BookGridRenderer(BlockEntityRendererProvider.Context context) {
        this.model = new BookGridModel(context.bakeLayer(BookGridModel.LAYER_LOCATION));
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(BookGridEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        renderStorageModel(blockEntity, poseStack, bufferSource, packedLight, packedOverlay);
        renderStoredItems(blockEntity, poseStack, bufferSource, packedLight);
    }

    private void renderStorageModel(BookGridEntity blockEntity, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        var blockState = blockEntity.getBlockState();
        Direction facing = blockState.getValue(BookGrid.FACING);
        ChestType chestType = blockState.getValue(BookGrid.TYPE);

        poseStack.pushPose();
        poseStack.translate(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(Axis.YP.rotationDegrees(-facing.toYRot()));
        poseStack.mulPose(Axis.ZN.rotationDegrees(-180));
        poseStack.translate(0.0F, -1.0F, 0.0F);
        ResourceLocation texture = getTextureForBlock(blockState);
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutout(texture));

        switch (chestType) {
            case SINGLE -> model.renderSingle(poseStack, vertexConsumer, packedLight, packedOverlay);
            case LEFT -> model.renderLeft(poseStack, vertexConsumer, packedLight, packedOverlay);
            case RIGHT -> model.renderRight(poseStack, vertexConsumer, packedLight, packedOverlay);
        }

        poseStack.popPose();
    }

    private ResourceLocation getTextureForBlock(BlockState state) {
        Block block = state.getBlock();

        if (block == ChangShengJueBlocks.BIRCH_BOOK_GRID.get()) {
            return BIRCH_TEXTURE;
        } else if (block == ChangShengJueBlocks.JUNGLE_BOOK_GRID.get()) {
            return JUNGLE_TEXTURE;
        } else if (block == ChangShengJueBlocks.CRIMSON_BOOK_GRID.get()) {
            return CRIMSON_TEXTURE;
        } else if (block == ChangShengJueBlocks.WARPED_BOOK_GRID.get()) {
            return WARPED_TEXTURE;
        } else if (block == ChangShengJueBlocks.MANGROVE_BOOK_GRID.get()) {
            return MANGROVE_TEXTURE;
        } else if (block == ChangShengJueBlocks.HUANG_HUA_LI_BOOK_GRID.get()) {
            return HUANG_HUA_LI_TEXTURE;
        } else if (block == ChangShengJueBlocks.WENGE_BOOK_GRID.get()) {
            return WENGE_TEXTURE;
        } else if (block == ChangShengJueBlocks.ACACIA_BOOK_GRID.get()) {
            return ACACIA_TEXTURE;
        } else if (block == ChangShengJueBlocks.DARK_OAK_BOOK_GRID.get()) {
            return DARK_OAK_TEXTURE;
        } else if (block == ChangShengJueBlocks.OAK_BOOK_GRID.get()) {
            return OAK_TEXTURE;
        } else if (block == ChangShengJueBlocks.CHERRY_BOOK_GRID.get()) {
            return CHERRY_TEXTURE;
        } else if (block == ChangShengJueBlocks.SPRUCE_BOOK_GRID.get()) {
            return SPRUCE_TEXTURE;
        } else if (block == ChangShengJueBlocks.ZI_TAN_BOOK_GRID.get()) {
            return ZI_TAN_TEXTURE;
        }

        return BIRCH_TEXTURE;
    }

    private void renderStoredItems(BookGridEntity blockEntity, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        ItemStack storedItem = blockEntity.getItem(0);
        if (storedItem.isEmpty() || storedItem.getItem() instanceof TieredItem) return;

        int itemCount = storedItem.getCount();

        poseStack.pushPose();

        poseStack.translate(0.5, 0.1, 0.5);

        Direction facing = blockEntity.getBlockState().getValue(BookGrid.FACING);
        poseStack.mulPose(Axis.YP.rotationDegrees(-facing.toYRot()));

        if (!(storedItem.getItem() instanceof BlockItem)) {
            poseStack.scale(0.75f, 0.75f, 0.75f);
            float layerHeight = 0.06f;
            int maxPerRow = 1;

            for (int i = 0; i < itemCount; i++) {
                poseStack.pushPose();
                int row = i / maxPerRow;
                float xOffset = 0;
                float yOffset = row * layerHeight;
                poseStack.translate(xOffset, yOffset, 0.0f);
                poseStack.mulPose(Axis.XP.rotationDegrees(90.0f));
                float randomRot = (i * 137.5f) % 360.0f;
                poseStack.mulPose(Axis.ZP.rotationDegrees(randomRot));
                itemRenderer.renderStatic(storedItem, ItemDisplayContext.FIXED, packedLight,
                        net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY,
                        poseStack, bufferSource, blockEntity.getLevel(), 0);
                poseStack.popPose();
            }
        } else {
            poseStack.scale(0.8f, 0.8f, 0.8f);

            float scaleFactor = 1.0f + (itemCount - 1) * 0.05f;
            poseStack.scale(scaleFactor, scaleFactor, scaleFactor);

            poseStack.mulPose(Axis.YP.rotationDegrees(180.0f));

            poseStack.translate(0, 0.3f, 0);

            itemRenderer.renderStatic(storedItem, ItemDisplayContext.FIXED, packedLight,
                    net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY,
                    poseStack, bufferSource, blockEntity.getLevel(), 0);

        }
        poseStack.popPose();
    }
}