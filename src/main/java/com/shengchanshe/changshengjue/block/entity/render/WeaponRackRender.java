package com.shengchanshe.changshengjue.block.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.custom.WeaponRack;
import com.shengchanshe.changshengjue.block.entity.WeaponRackEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.clubbed.BeatDogStick;
import com.shengchanshe.changshengjue.item.combat.clubbed.BeatDogStickRender;
import com.shengchanshe.changshengjue.item.combat.clubbed.PanHuaGun;
import com.shengchanshe.changshengjue.item.combat.clubbed.PanHuaGunRender;
import com.shengchanshe.changshengjue.item.combat.knife.*;
import com.shengchanshe.changshengjue.item.combat.lance.BaWangQiang;
import com.shengchanshe.changshengjue.item.combat.lance.BaWangQiangRender;
import com.shengchanshe.changshengjue.item.combat.lance.RedTasselledSpear;
import com.shengchanshe.changshengjue.item.combat.lance.RedTasselledSpearRender;
import com.shengchanshe.changshengjue.item.combat.sword.*;
import net.minecraft.client.Minecraft;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.phys.Vec2;

public class WeaponRackRender implements BlockEntityRenderer<WeaponRackEntity> {


    private boolean checkModWeapon(ItemStack item) {
        return
                item.getItem().equals(ChangShengJueItems.THREE_THROWING_KNIVES.get())


                ;
    }
    private boolean checkModWeaponqiang(ItemStack item) {
        return
                item.getItem().equals(ChangShengJueItems.BA_WANG_QIANG.get())
                || item.getItem().equals(ChangShengJueItems.RED_TASSELLED_SPEAR.get())

                ;
    }
    private boolean checkModWeapongun(ItemStack item) {
        return
                item.getItem().equals(ChangShengJueItems.PAN_HUA_GUN.get())
                || item.getItem().equals(ChangShengJueItems.BEAT_DOG_STICK.get())
                ;
    }
    private boolean checkModWeapondao(ItemStack item) {
        return
                item.getItem().equals(ChangShengJueItems.LARGE_KNIFE.get())

                ;
    }

    private boolean checkModWeapojian(ItemStack item) {
        return
                item.getItem().equals(ChangShengJueItems.YI_TIAN_JIAN.get())
                || item.getItem().equals(ChangShengJueItems.TU_LONG_DAO.get())
                || item.getItem().equals(ChangShengJueItems.BRONZE_SWORD.get())
                || item.getItem().equals(ChangShengJueItems.HAN_JIAN.get())
                ;
    }

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
//            poseStack.translate(1.5,1.0, 0.3);
//            poseStack.mulPose(Axis.YP.rotationDegrees(facing.toYRot()));
//            poseStack.translate(-0.5, -0.5, -0.5);

            // 应用偏移
//            poseStack.translate(centerX + 0.5, centerY / 16f, 0.45);


            if(checkModWeapon(itemStack)) {

                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(0.50, 0.85, 0.625);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                    case SOUTH -> {
                        poseStack.translate(0.50, 0.85, 0.375);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                    case WEST -> {
                        poseStack.translate(0.625, 0.85, 0.50);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));

                    }
                    case EAST -> {
                        poseStack.translate(0.375, 0.85, 0.50);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                    default -> {
                        poseStack.translate(0.0, 0.85, 0.15);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                }

                // 应用缩放
                float scale = 1.0f;
                poseStack.scale(scale, scale, scale);
            } else if (checkModWeaponqiang(itemStack)) {
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(0.15,1.0, 1.1);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(0));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));

                    }
                    case SOUTH -> {
                        poseStack.translate(0.85 ,1.0, -0.1);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(0));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));
                    }
                    case WEST -> {
                        poseStack.translate(0.35,1.20, 0.15);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(0));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-20));

                    }
                    case EAST -> {
                        poseStack.translate(0.65,1.20, 0.85);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                        poseStack.mulPose(Axis.XP.rotationDegrees(0));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-20));

                    }
                    default -> {
                        poseStack.translate(0.0, 1.40, 0.15);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(90));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));
                    }
                }

                // 应用缩放
                float scale = 0.75f;
                poseStack.scale(scale, scale, scale);
            }else if (checkModWeapongun(itemStack)) {
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(0.85,2.2, 0.72);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(0));
                    }
                    case SOUTH -> {
                        poseStack.translate(0.15 ,2.2, 0.28);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(0));
                    }
                    case WEST -> {
                        poseStack.translate(0.72,2.2, 0.15);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(0));
                    }
                    case EAST -> {
                        poseStack.translate(0.28,2.2, 0.85);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(0));
                    }
                    default -> {
                        poseStack.translate(0.0, 0.85, 0.15);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(0));
                    }
                }

                // 应用缩放
                float scale = 0.7f;
                poseStack.scale(scale, scale, scale);
            }else if (checkModWeapojian(itemStack)) {
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(0.0, 2.18, 0.70);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    case SOUTH -> {
                        poseStack.translate(1.0, 2.18, 0.30);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    case WEST -> {
                        poseStack.translate(0.70, 2.18, 1.0);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));

                    }
                    case EAST -> {
                        poseStack.translate(0.30, 2.18, 0.0);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    default -> {
                        poseStack.translate(0.0, 1.2, 0.15);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                }

                // 应用缩放
                float scale = 1.0f;
                poseStack.scale(scale, scale, scale);
            } else if(checkModWeapondao(itemStack)){
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(0, 1.75, 0.6);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    case SOUTH -> {
                        poseStack.translate(1, 1.75, 0.4);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    case WEST -> {
                        poseStack.translate(0.6, 1.75, 1);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));

                    }
                    case EAST -> {
                        poseStack.translate(0.4, 1.75, 0);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    default -> {
                        poseStack.translate(0.0, 1.2, 0.15);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                }

                // 应用缩放
                float scale = 0.8f;
                poseStack.scale(scale, scale, scale);

            }else if(itemStack.getItem().equals(ChangShengJueItems.KITCHEN_KNIFE.get())){
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(0, 1.25, 0.6);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-25));
                    }
                    case SOUTH -> {
                        poseStack.translate(1, 1.25, 0.4);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-25));
                    }
                    case WEST -> {
                        poseStack.translate(0.6, 1.25, 1);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-25));

                    }
                    case EAST -> {
                        poseStack.translate(0.4, 1.25, 0);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-25));
                    }
                    default -> {
                        poseStack.translate(0.0, 1.2, 0.15);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                }

                // 应用缩放
                float scale = 1.0f;
                poseStack.scale(scale, scale, scale);

            }
            else if(itemStack.getItem().equals(ChangShengJueItems.HENG_DAO.get())){
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(0.11, 1.85, 0.57);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));
                    }
                    case SOUTH -> {
                        poseStack.translate(0.89, 1.85, 0.43);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));
                    }
                    case WEST -> {
                        poseStack.translate(0.57, 1.85, 0.89);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));

                    }
                    case EAST -> {
                        poseStack.translate(0.43, 1.85, 0.11);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));
                    }
                    default -> {
                        poseStack.translate(0.0, 1.2, 0.15);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                }

                // 应用缩放
                float scale = 0.8f;
                poseStack.scale(scale, scale, scale);

            } else if (itemStack.getItem().equals(ChangShengJueItems.SOFT_SWORD.get())) {
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(0.1, 2.05, 0.75);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    case SOUTH -> {
                        poseStack.translate(0.9, 2.05, 0.25);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    case WEST -> {
                        poseStack.translate(0.75, 2.05, 0.9);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));

                    }
                    case EAST -> {
                        poseStack.translate(0.25, 2.05, 0.1);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    default -> {
                        poseStack.translate(0.0, 1.2, 0.15);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                }

                // 应用缩放
                float scale = 0.8f;
                poseStack.scale(scale, scale, scale);

            } else {
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(0.50, 0.7, 0.595);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                    case SOUTH -> {
                        poseStack.translate(0.50, 0.7, 0.505);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                    case WEST -> {
                        poseStack.translate(0.595, 0.7, 0.5);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));

                    }
                    case EAST -> {
                        poseStack.translate(0.505, 0.7, 0.5);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                    default -> {
                        poseStack.translate(0.0, 0.7, 0.15);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                }

                // 应用缩放
                float scale = 0.8f;
                poseStack.scale(scale, scale, scale);
            }

            // 自定义模型渲染
            if (itemStack.getItem() instanceof BaWangQiang) {
                BaWangQiangRender renderer = new BaWangQiangRender();
                renderer.renderByItem(itemStack, ItemDisplayContext.FIXED, poseStack, buffer, packedLight, packedOverlay);
            } else if (itemStack.getItem() instanceof RedTasselledSpear) {
                RedTasselledSpearRender renderer = new RedTasselledSpearRender();
                renderer.renderByItem(itemStack, ItemDisplayContext.FIXED, poseStack, buffer, packedLight, packedOverlay);
            }else if (itemStack.getItem() instanceof BeatDogStick) {
                BeatDogStickRender renderer = new BeatDogStickRender();
                renderer.renderByItem(itemStack, ItemDisplayContext.FIXED, poseStack, buffer, packedLight, packedOverlay);
            }else if (itemStack.getItem() instanceof PanHuaGun) {
                PanHuaGunRender renderer = new PanHuaGunRender();
                renderer.renderByItem(itemStack, ItemDisplayContext.FIXED, poseStack, buffer, packedLight, packedOverlay);
            }else if(itemStack.getItem() instanceof SoftSword){
                SoftSwordRender renderer = new SoftSwordRender();
                renderer.renderByItem(itemStack, ItemDisplayContext.FIXED, poseStack, buffer, packedLight, packedOverlay);
            }else if(itemStack.getItem() instanceof LargeKnife){
                LargeKnifeRender renderer = new LargeKnifeRender();
                renderer.renderByItem(itemStack, ItemDisplayContext.FIXED, poseStack, buffer, packedLight, packedOverlay);
            } else if (itemStack.getItem() instanceof HengDao) {
                HengDaoRender renderer = new HengDaoRender();
                renderer.renderByItem(itemStack, ItemDisplayContext.FIXED, poseStack, buffer, packedLight, packedOverlay);
            } else if (itemStack.getItem() instanceof YiTianJian) {
                YiTianJianRender renderer = new YiTianJianRender();
                renderer.renderByItem(itemStack, ItemDisplayContext.FIXED, poseStack, buffer, packedLight, packedOverlay);
            } else if (itemStack.getItem() instanceof TuLongDao) {
                TuLongDaoRender renderer = new TuLongDaoRender();
                renderer.renderByItem(itemStack, ItemDisplayContext.FIXED, poseStack, buffer, packedLight, packedOverlay);
            } else if (itemStack.getItem() instanceof HanJian) {
                HanJianRender renderer = new HanJianRender();
                renderer.renderByItem(itemStack, ItemDisplayContext.FIXED, poseStack, buffer, packedLight, packedOverlay);
            } else if (itemStack.getItem() instanceof KitchenKnife) {
                KitchenKnifeRender renderer = new KitchenKnifeRender();
                renderer.renderByItem(itemStack, ItemDisplayContext.FIXED, poseStack, buffer, packedLight, packedOverlay);
            } else if (itemStack.getItem() instanceof BronzeSword) {
                BronzeSwordRender renderer = new BronzeSwordRender();
                renderer.renderByItem(itemStack, ItemDisplayContext.FIXED, poseStack, buffer, packedLight, packedOverlay);
            }

            else {
                // 默认渲染逻辑
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
            }

            poseStack.popPose();
        }
    }
    public WeaponRackRender(BlockEntityRendererProvider.Context context) {
    }
}

