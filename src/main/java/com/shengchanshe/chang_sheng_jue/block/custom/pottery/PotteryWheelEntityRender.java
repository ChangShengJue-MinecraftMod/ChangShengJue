package com.shengchanshe.chang_sheng_jue.block.custom.pottery;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.ItemStackHandler;

@OnlyIn(Dist.CLIENT)
public class PotteryWheelEntityRender implements BlockEntityRenderer<PotteryWheelEntity> {
    public PotteryWheelEntityRender(BlockEntityRendererProvider.Context context){}
    @Override
    public void render(PotteryWheelEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
//        Direction opposite = pBlockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite();
        ItemStackHandler inventroy = pBlockEntity.getInventory();
        int posLong = (int) pBlockEntity.getBlockPos().asLong();
        for (int i = 0; i < inventroy.getSlots(); i++) {
            ItemStack stackInSlot = inventroy.getStackInSlot(i);
            if (!stackInSlot.isEmpty()){
                pPoseStack.pushPose();
                pPoseStack.translate(0.5,1.0,0.5);
                long gameTime = pBlockEntity.getLevel().getGameTime();
                float rotationDegrees = ((gameTime % 20) + pPartialTick) * 18.0f;

                pPoseStack.mulPose(Axis.YP.rotationDegrees(rotationDegrees));//渲染时会将物品y轴旋转
                pPoseStack.mulPose(Axis.XP.rotationDegrees(0f));//渲染时会将物品x轴旋转
                Vec3 itemOffset = pBlockEntity.getItemOffset(i);
                pPoseStack.translate(itemOffset.x,itemOffset.y,itemOffset.z);
                pPoseStack.scale(0.6f,0.6f,0.6f);
                if (pBlockEntity.getLevel() != null){
                    Minecraft.getInstance().getItemRenderer().renderStatic(stackInSlot, ItemDisplayContext.FIXED,
                            LevelRenderer.getLightColor(pBlockEntity.getLevel(),pBlockEntity.getBlockPos()),
                            pPackedOverlay,pPoseStack,pBuffer,pBlockEntity.getLevel(),posLong + 1);
                }
                pPoseStack.popPose();
            }
        }

    }
}
