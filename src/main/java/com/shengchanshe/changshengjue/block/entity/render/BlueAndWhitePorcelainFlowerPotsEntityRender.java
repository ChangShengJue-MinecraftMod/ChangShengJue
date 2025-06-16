package com.shengchanshe.changshengjue.block.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.shengchanshe.changshengjue.block.decoration.BlueAndWhitePorcelainFlowerPots;
import com.shengchanshe.changshengjue.block.entity.BlueAndWhitePorcelainFlowerPotsEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BlueAndWhitePorcelainFlowerPotsEntityRender implements BlockEntityRenderer<BlueAndWhitePorcelainFlowerPotsEntity> {
    private final BlockRenderDispatcher blockRenderer;

    public BlueAndWhitePorcelainFlowerPotsEntityRender(BlockEntityRendererProvider.Context context) {
        this.blockRenderer = context.getBlockRenderDispatcher();
    }

    private BlockState getBlockState(Block block) {
        if (block instanceof DoublePlantBlock){
            return block.defaultBlockState().setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER);
        }
        return block.defaultBlockState();
    }


    @Override
    public void render(BlueAndWhitePorcelainFlowerPotsEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        pPoseStack.pushPose();

        BlockState blockState2;

        if (pBlockEntity.getPlant(BlueAndWhitePorcelainFlowerPots.Slot.PLANT).getItem() instanceof BlockItem blockItem) {
            blockState2 = getBlockState(blockItem.getBlock());
        } else {
            blockState2 = Blocks.AIR.defaultBlockState();
        }
        ItemStack itemStack = pBlockEntity.getPlant(BlueAndWhitePorcelainFlowerPots.Slot.PLANT);
        if (itemStack.getItem().equals(Items.CACTUS)) {
            pPoseStack.translate(0.5F, 0.25F, 0.5F);
            pPoseStack.mulPose(Axis.YP.rotationDegrees(0F));
            pPoseStack.scale(0.35F, 0.8F, 0.35F);
            pPoseStack.translate(-0.5F, 0.1F, -0.5F);
        } else {
            pPoseStack.translate(0.5F, 0.25F, 0.5F);
            pPoseStack.mulPose(Axis.YP.rotationDegrees(0F));
            pPoseStack.scale(0.8F, 0.8F, 0.8F);
            pPoseStack.translate(-0.5F, 0.1F, -0.5F);
        }
        this.blockRenderer.renderSingleBlock(blockState2, pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
        pPoseStack.popPose();
    }
}
