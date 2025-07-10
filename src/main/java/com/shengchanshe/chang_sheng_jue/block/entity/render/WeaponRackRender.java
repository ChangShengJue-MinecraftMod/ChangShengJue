//package com.shengchanshe.chang_sheng_jue.block.entity.render;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.math.Axis;
//import com.shengchanshe.chang_sheng_jue.block.custom.WeaponRack;
//import com.shengchanshe.chang_sheng_jue.block.entity.WeaponRackEntity;
//import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.LevelRenderer;
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
//import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
//import net.minecraft.client.renderer.entity.ItemRenderer;
//import net.minecraft.client.resources.model.BakedModel;
//import net.minecraft.core.Direction;
//import net.minecraft.world.item.ItemDisplayContext;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//import java.util.Objects;
//
//@OnlyIn(Dist.CLIENT)
//public class WeaponRackRender implements BlockEntityRenderer<WeaponRackEntity> {
//
//
//    private boolean checkModWeapon(ItemStack item) {
//        return
//                item.getItem().equals(ChangShengJueItems.THREE_THROWING_KNIVES.get())
//                || item.getItem().equals(ChangShengJueItems.THROWING_KNIVES.get())
//                || item.getItem().equals(ChangShengJueItems.SEVEN_THROWING_KNIVES.get())
//
//
//                ;
//    }
//    private boolean checkModWeaponqiang(ItemStack item) {
//        return
//                item.getItem().equals(ChangShengJueItems.BA_WANG_QIANG.get())
//                || item.getItem().equals(ChangShengJueItems.RED_TASSELLED_SPEAR.get())
//
//                ;
//    }
//    private boolean checkModWeapongun(ItemStack item) {
//        return
//                item.getItem().equals(ChangShengJueItems.PAN_HUA_GUN.get())
//                || item.getItem().equals(ChangShengJueItems.BEAT_DOG_STICK.get())
//                ;
//    }
//    private boolean checkModWeapondao(ItemStack item) {
//        return
//                item.getItem().equals(ChangShengJueItems.LARGE_KNIFE.get())
//
//                ;
//    }
//
//    private boolean checkModWeapojian(ItemStack item) {
//        return
//                item.getItem().equals(ChangShengJueItems.YI_TIAN_JIAN.get())
//                || item.getItem().equals(ChangShengJueItems.TU_LONG_DAO.get())
//                || item.getItem().equals(ChangShengJueItems.BRONZE_SWORD.get())
//                || item.getItem().equals(ChangShengJueItems.HAN_JIAN.get())
//                ;
//    }
//
//    @Override
//    public void render(WeaponRackEntity entity, float partialTick, PoseStack poseStack,
//                       MultiBufferSource buffer, int packedLight, int packedOverlay) {
//
//        poseStack.pushPose();
//        Direction opposite = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite();
//        ItemStack itemStack = entity.getInventory().getStackInSlot(0);
//        if (!itemStack.isEmpty()) {
//            ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
//            BakedModel model = itemRenderer.getModel(itemStack, entity.getLevel(), null, 0);
//            float rotetionDegress = opposite.toYRot();
//            int light = LevelRenderer.getLightColor(Objects.requireNonNull(entity.getLevel()),  entity.getBlockPos());
//
//            Direction facing = entity.getBlockState().getValue(WeaponRack.FACING);
//
//            poseStack.translate( 0.5,0.55, 0.5);
//            poseStack.mulPose(Axis.XP.rotationDegrees(0f));
//            poseStack.mulPose(Axis.YP.rotationDegrees(rotetionDegress+90f));//渲染时会将物品y轴旋转
//            poseStack.mulPose(Axis.ZP.rotationDegrees(20f));//渲染时会将物品X轴旋转
//
//
//            switch (facing)
//            {
//                case EAST:
//                    poseStack.mulPose(Axis.ZP.rotationDegrees(0));//渲染时会将物品X轴旋转
//                case WEST:
//                    poseStack.mulPose(Axis.ZP.rotationDegrees(-45));//渲染时会将物品X轴旋转
//
//            }
//            if(checkModWeapon(itemStack)) {
//                // 应用缩放
//                float scale = 1.0f;
//                poseStack.scale(scale, scale, scale);
//            } else if (checkModWeaponqiang(itemStack)) {
//                // 应用缩放
//                float scale = 1.0f;
//                poseStack.scale(scale, scale, scale);
//            }else if (checkModWeapongun(itemStack)) {
//                // 应用缩放
//                float scale = 0.8f;
//                poseStack.scale(scale, scale, scale);
//            }else if (checkModWeapojian(itemStack)) {
//                // 应用缩放
//                float scale = 1.0f;
//                poseStack.scale(scale, scale, scale);
//            } else if(checkModWeapondao(itemStack)){
//                // 应用缩放
//                float scale = 0.8f;
//                poseStack.scale(scale, scale, scale);
//
//            }else if(itemStack.getItem().equals(ChangShengJueItems.KITCHEN_KNIFE.get())){
//                // 应用缩放
//                float scale = 1.0f;
//                poseStack.scale(scale, scale, scale);
//
//            }
//            else if(itemStack.getItem().equals(ChangShengJueItems.HENG_DAO.get())){
//                // 应用缩放
//                float scale = 1.0f;
//                poseStack.scale(scale, scale, scale);
//
//            } else if (itemStack.getItem().equals(ChangShengJueItems.SOFT_SWORD.get())) {
//                // 应用缩放
//                float scale = 1.0f;
//                poseStack.scale(scale, scale, scale);
//
//            } else {
//                switch (facing) {
//                    case EAST,NORTH,SOUTH:
//                        poseStack.mulPose(Axis. YP.rotationDegrees(rotetionDegress));//渲染时会将物品y轴旋转
//                    case WEST:
//                        poseStack.mulPose(Axis. YP.rotationDegrees(rotetionDegress));//渲染时会将物品y轴旋转
//                }
//
//                // 应用缩放
//                float scale = 0.8f;
//                poseStack.scale(scale, scale, scale);
//            }
//            if(entity.getLevel() != null){
//                itemRenderer.render(
//                        itemStack,
//                        ItemDisplayContext.NONE,
//                        false,
//                        poseStack,
//                        buffer,
//                        light,
//                        packedOverlay,
//                        model
//                );
//            }
//        }
//        poseStack.popPose();
//    }
//    public WeaponRackRender(BlockEntityRendererProvider.Context context) {
//    }
//}
package com.shengchanshe.chang_sheng_jue.block.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.shengchanshe.chang_sheng_jue.block.entity.WeaponRackEntity;
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


