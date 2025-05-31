package com.shengchanshe.changshengjue.block.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
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
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;

public class WeaponRackRender implements BlockEntityRenderer<WeaponRackEntity> {


    private boolean checkModWeapon(ItemStack item) {
        return
                item.getItem().equals(ChangShengJueItems.THREE_THROWING_KNIVES.get())
                || item.getItem().equals(ChangShengJueItems.THROWING_KNIVES.get())
                || item.getItem().equals(ChangShengJueItems.SEVEN_THROWING_KNIVES.get())


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


            poseStack.pushPose();


            //向右减NX，向左加NX
            //向下减NY，向上加NY
            //向前减NZ，向后加NZ
            if(checkModWeapon(itemStack)) {
                float NX = 0.50f;
                float NY = 0.55f;
                float NZ = 0.575f;
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(NX, NY, NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                    case SOUTH -> {
                        poseStack.translate(1-NX, NY, 1-NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                    case WEST -> {
                        poseStack.translate(NZ, NY, 1-NX);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));

                    }
                    case EAST -> {
                        poseStack.translate(1-NZ, NY, NX);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                    default -> {
                        poseStack.translate(0.0, 0.0, 0.0);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(0));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(0));
                    }
                }

                // 应用缩放
                float scale = 1.0f;
                poseStack.scale(scale, scale, scale);
            } else if (checkModWeaponqiang(itemStack)) {
                float NX = 0.05f;
                float NY = -0.1f;
                float NZ = 0.85f;
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(NX,NY, NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(0));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));
                    }
                    case SOUTH -> {
                        poseStack.translate(1-NX ,NY, 1-NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(0));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));
                    }
                    case WEST -> {
                        poseStack.translate(-0.1,0.25, 0.05);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(0));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-20));

                    }
                    case EAST -> {
                        poseStack.translate(1.1,0.25, NX);
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
                float scale = 1.0f;
                poseStack.scale(scale, scale, scale);
            }else if (checkModWeapongun(itemStack)) {
                float NX = 0.85f;
                float NY = 1.6f;
                float NZ = 0.5f;
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(NX,NY, NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(0));
                    }
                    case SOUTH -> {
                        poseStack.translate(1-NX ,NY, 1-NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(0));
                    }
                    case WEST -> {
                        poseStack.translate(NZ,NY, 1-NX);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(0));
                    }
                    case EAST -> {
                        poseStack.translate(1-NZ,NY, NX);
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
                float scale = 0.8f;
                poseStack.scale(scale, scale, scale);
            }else if (checkModWeapojian(itemStack)) {
                float NX = 0.0f;
                float NY = 2.18f;
                float NZ = 0.70f;
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(NX, NY, NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    case SOUTH -> {
                        poseStack.translate(1-NX, NY, 1-NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    case WEST -> {
                        poseStack.translate(NZ, NY, 1-NX);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));

                    }
                    case EAST -> {
                        poseStack.translate(1-NZ, NY, NX);
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
                float NX = 0.0f;
                float NY = 1.75f;
                float NZ = 0.6f;
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(NX, NY, NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    case SOUTH -> {
                        poseStack.translate(1-NX, NY, 1-NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    case WEST -> {
                        poseStack.translate(NZ, NY, 1-NX);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));

                    }
                    case EAST -> {
                        poseStack.translate(1-NZ, NY, NX);
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
                //向右减NX，向左加NX
                //向下减NY，向上加NY
                //向前减NZ，向后加NZ
                float NX = -0.25f;
                float NY = 1.0f;
                float NZ = 0.2f;
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(NX, NY, NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(265));
                        poseStack.mulPose(Axis.XP.rotationDegrees(210));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));
                    }
                    case SOUTH -> {
                        poseStack.translate(1-NX, NY, 1-NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(85));
                        poseStack.mulPose(Axis.XP.rotationDegrees(210));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));
                    }
                    case WEST -> {
                        poseStack.translate(NZ, NY, 1-NX);
                        poseStack.mulPose(Axis.YP.rotationDegrees(-5));
                        poseStack.mulPose(Axis.XP.rotationDegrees(210));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));

                    }
                    case EAST -> {
                        poseStack.translate(1-NZ, NY, NX);
                        poseStack.mulPose(Axis.YP.rotationDegrees(175));
                        poseStack.mulPose(Axis.XP.rotationDegrees(210));
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
                float scale = 1.0f;
                poseStack.scale(scale, scale, scale);

            }
            else if(itemStack.getItem().equals(ChangShengJueItems.HENG_DAO.get())){
                float NX = 0.0f;
                float NY = 2.05f;
                float NZ = 0.55f;
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(NX, NY, NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));
                    }
                    case SOUTH -> {
                        poseStack.translate(1-NX, NY, 1-NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));
                    }
                    case WEST -> {
                        poseStack.translate(NZ, NY, 1-NX);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));

                    }
                    case EAST -> {
                        poseStack.translate(1-NZ, NY, NX);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(20));
                    }
                    default -> {
                        poseStack.translate(0.0, 0.0, 0.0);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(0));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(0));
                    }
                }

                // 应用缩放
                float scale = 1.0f;
                poseStack.scale(scale, scale, scale);

            } else if (itemStack.getItem().equals(ChangShengJueItems.SOFT_SWORD.get())) {
                float NX = 0.1f;
                float NY = 2.05f;
                float NZ = 0.75f;
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(NX, NY, NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    case SOUTH -> {
                        poseStack.translate(1-NX, NY, 1-NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    case WEST -> {
                        poseStack.translate(NZ, NY, 1-NX);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));

                    }
                    case EAST -> {
                        poseStack.translate(1-NZ, NY, NX);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                        poseStack.mulPose(Axis.XP.rotationDegrees(180));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(25));
                    }
                    default -> {
                        poseStack.translate(0.0, 0.0, 0.0);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                }

                // 应用缩放
                float scale = 0.8f;
                poseStack.scale(scale, scale, scale);

            } else {
                float NX = 0.5f;
                float NY = 0.7f;
                float NZ = 0.595f;
                switch (facing) {
                    case NORTH -> {
                        poseStack.translate(NX, NY, NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                    case SOUTH -> {
                        poseStack.translate(1-NX, NY, 1-NZ);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                    case WEST -> {
                        poseStack.translate(NZ, NY, 1-NX);
                        poseStack.mulPose(Axis.YP.rotationDegrees(270));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));

                    }
                    case EAST -> {
                        poseStack.translate(1-NZ, NY, NX);
                        poseStack.mulPose(Axis.YP.rotationDegrees(90));
                        poseStack.mulPose(Axis.XP.rotationDegrees(160));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(-30));
                    }
                    default -> {
                        poseStack.translate(0.0, 0.0, 0.0);
                        poseStack.mulPose(Axis.YP.rotationDegrees(0));
                        poseStack.mulPose(Axis.XP.rotationDegrees(0));
                        poseStack.mulPose(Axis.ZP.rotationDegrees(0));
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

