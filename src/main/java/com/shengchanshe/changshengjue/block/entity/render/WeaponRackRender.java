package com.shengchanshe.changshengjue.block.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.shengchanshe.changshengjue.block.custom.WeaponRack;
import com.shengchanshe.changshengjue.block.entity.WeaponRackEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.items.ItemStackHandler;

public class WeaponRackRender implements BlockEntityRenderer<WeaponRackEntity> {
    @Override
    public void render(WeaponRackEntity entity, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {

        ItemStack itemStack = entity.getInventory().getStackInSlot(0);
        if (!itemStack.isEmpty()) {
            Direction facing = entity.getBlockState().getValue(WeaponRack.FACING);
            Vec2 offset = entity.getItemOffset();

//            // 计算中心点偏移（8,8是16x16方块的中心）
//            float centerX = (offset.x - 8) / 16f;
//            float centerY = (offset.y - 8) / 16f;

            poseStack.pushPose();
//            // 根据方块朝向调整旋转
//            poseStack.translate(0.5, 0.5, 0.5);
//            poseStack.mulPose(Axis.YP.rotationDegrees(facing.toYRot()));
//            poseStack.translate(-0.5, -0.5, -0.5);

            // 应用偏移
//            poseStack.translate(centerX + 0.5, centerY / 16f, 0.45);


            switch (facing) {
                case NORTH -> {
                    poseStack.translate(0.50, 0.65,0.75);
                    poseStack.mulPose(Axis.YP.rotationDegrees(180));
                }
                case SOUTH -> {
                    poseStack.translate(0.50, 0.65,0.25);
                    poseStack.mulPose(Axis.YP.rotationDegrees(0));
                }
               case WEST -> {
                   poseStack.translate(0.75, 0.65,0.5);
                   poseStack.mulPose(Axis.YP.rotationDegrees(270));

               }
                case EAST -> {
                    poseStack.translate(0.25, 0.65,0.5);
                    poseStack.mulPose(Axis.YP.rotationDegrees(90));
                }
                default -> {
                    poseStack.translate(0.0, 0.25,0.15);
                    poseStack.mulPose(Axis.YP.rotationDegrees(0));
                }
            }

            // 应用缩放
            float scale = entity.getItemScale();
            poseStack.scale(scale, scale, scale);

            // 实际渲染
            Minecraft.getInstance().getItemRenderer().renderStatic(
                    itemStack,
                    ItemDisplayContext.FIXED,
                    packedLight,
                    packedOverlay,
                    poseStack,
                    buffer,
                    entity.getLevel(),
                    (int) entity.getBlockPos().asLong()
            );

            poseStack.popPose();
        }
    }
    public WeaponRackRender(BlockEntityRendererProvider.Context context) {
    }
}

