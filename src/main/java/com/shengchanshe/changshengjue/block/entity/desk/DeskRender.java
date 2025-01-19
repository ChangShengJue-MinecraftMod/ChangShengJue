package com.shengchanshe.changshengjue.block.entity.desk;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.items.ItemStackHandler;

public class DeskRender implements BlockEntityRenderer<Desk> {
    public DeskRender(BlockEntityRendererProvider.Context context){}
    @Override
    public void render(Desk pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        Direction opposite = pBlockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite();
        ItemStackHandler inventroy = pBlockEntity.getInventory();
        int posLong = (int) pBlockEntity.getBlockPos().asLong();
        ItemStack stackInSlot = inventroy.getStackInSlot(0);
        if (!stackInSlot.isEmpty()){
            pPoseStack.pushPose();
            Vec2 itemOffset = pBlockEntity.getItemOffset(0);
            pPoseStack.translate(0.5,itemOffset.y,0.5);
            float rotationDegrees = opposite.toYRot();

            pPoseStack.mulPose(Axis.YP.rotationDegrees(rotationDegrees + 90f));//渲染时会将物品y轴旋转
            pPoseStack.mulPose(Axis.XP.rotationDegrees(90f));//渲染时会将物品x轴旋转
//            pPoseStack.translate(itemOffset.x,itemOffset.y,0);
            pPoseStack.scale(0.6f,0.7f,0.6f);
            if (pBlockEntity.getLevel() != null){
                Minecraft.getInstance().getItemRenderer().renderStatic(stackInSlot, ItemDisplayContext.FIXED,
                        LevelRenderer.getLightColor(pBlockEntity.getLevel(),pBlockEntity.getBlockPos()),
                        pPackedOverlay,pPoseStack,pBuffer,pBlockEntity.getLevel(),posLong + 1);
            }
            pPoseStack.popPose();
        }
    }
}
