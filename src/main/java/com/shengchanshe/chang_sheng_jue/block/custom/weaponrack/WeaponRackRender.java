package com.shengchanshe.chang_sheng_jue.block.custom.weaponrack;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;

@OnlyIn(Dist.CLIENT)
public class WeaponRackRender implements BlockEntityRenderer<WeaponRackEntity> {
    public WeaponRackRender(BlockEntityRendererProvider.Context context) {
    }
    @Override
    public void render(WeaponRackEntity entity, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        Direction opposite = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite();
        ItemStack stack = entity.getInventory().getStackInSlot(0);//获取方块实体中第一个物品栏的物品
        if (!stack.isEmpty()){
            poseStack.translate(0.5,0.5,0.5);
            ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
            BakedModel model = itemRenderer.getModel(stack, entity.getLevel(), null, 0);
            float rotationDegrees = opposite.toYRot();
            poseStack.mulPose(Axis.YP.rotationDegrees(rotationDegrees + 180f));
            switch (opposite) {
                case SOUTH,NORTH  ->  poseStack.mulPose(Axis.XN.rotationDegrees(20));
                default -> poseStack.mulPose(Axis.XP.rotationDegrees(20));
            }
            int light = LevelRenderer.getLightColor(Objects.requireNonNull(entity.getLevel()), entity.getBlockPos());
            Vec2 itemOffset = entity.getItemOffset();
            if (stack.getItem() instanceof TridentItem) {
                poseStack.translate(itemOffset.x + 0.5,itemOffset.y + 1.7,0.5);
            }else {
                poseStack.translate(itemOffset.x,itemOffset.y,0);
            }
            poseStack.scale(1.0f,1.0f,1.0f);
            if (entity.getLevel() != null){
                itemRenderer.render(
                        stack,
                        ItemDisplayContext.NONE,
                        false,
                        poseStack,
                        buffer,
                        light,
                        packedOverlay,
                        model
                );
            }
        }
        poseStack.popPose();
    }
}


