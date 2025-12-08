package com.shengchanshe.chang_sheng_jue.block.custom.racks;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class DryingRailRenderer implements BlockEntityRenderer<DryingRailEntity> {
    private final EntityRenderDispatcher entityRenderer;

    private static class ArmorStandCache {
        private final List<ArmorStand> standardStands = new ArrayList<>();
        private final List<ArmorStand> smallStands = new ArrayList<>();

        public ArmorStand getArmorStand(Level level, boolean small) {
            List<ArmorStand> pool = small ? smallStands : standardStands;

            if (!pool.isEmpty()) {
                ArmorStand stand = pool.remove(pool.size() - 1);
                resetArmorStand(stand);
                return stand;
            }

            return createNewArmorStand(level, small);
        }

        public void returnArmorStand(ArmorStand stand, boolean small) {
            if (stand != null) {
                List<ArmorStand> pool = small ? smallStands : standardStands;
                pool.add(stand);
            }
        }

        private ArmorStand createNewArmorStand(Level level, boolean small) {
            ArmorStand armorStand = new ArmorStand(EntityType.ARMOR_STAND, level);
            CompoundTag tag = new CompoundTag();
            tag.putBoolean("Invisible", true);
            tag.putBoolean("NoGravity", true);
            tag.putBoolean("Small", small);
            tag.putFloat("Rotation", 180f);
            armorStand.load(tag);
            return armorStand;
        }

        private void resetArmorStand(ArmorStand stand) {
            stand.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
            stand.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
            stand.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);
            stand.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);
        }
    }

    private final ArmorStandCache armorStandCache = new ArmorStandCache();

    public DryingRailRenderer(BlockEntityRendererProvider.Context context) {
        this.entityRenderer = Minecraft.getInstance().getEntityRenderDispatcher();
    }

    @Override
    public void render(DryingRailEntity blockEntity, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        ItemStack armorItem = blockEntity.getArmorItem();
        if (armorItem.isEmpty() || !(armorItem.getItem() instanceof ArmorItem)) {
            return;
        }

        BlockState blockState = blockEntity.getBlockState();
        Direction direction = blockState.getValue(DryingRail.FACING);

        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);

        float rotation = -direction.toYRot();
        poseStack.mulPose(Axis.YP.rotationDegrees(rotation));

        if (armorItem.getItem() instanceof ArmorItem armor) {
            if (armor.getEquipmentSlot() == EquipmentSlot.CHEST) {
                poseStack.translate(0, -0.6, 0);
                poseStack.scale(1.5f, 1.5f, 1.5f);
            } else if (armor.getEquipmentSlot() == EquipmentSlot.LEGS) {
                poseStack.translate(0, -0.05, 0);
                poseStack.scale(1.5f, 1.5f, 1.5f);
            }
        }

        Level level = Minecraft.getInstance().level;
        if (level == null) {
            poseStack.popPose();
            return;
        }

        ArmorStand armorStand = armorStandCache.getArmorStand(level, true);

        armorStand.setPos(blockEntity.getBlockPos().getX() + 0.5,
                blockEntity.getBlockPos().getY(),
                blockEntity.getBlockPos().getZ() + 0.5);

        if (armorItem.getItem() instanceof ArmorItem armor) {
            EquipmentSlot slot = armor.getEquipmentSlot();
            armorStand.setItemSlot(slot, armorItem.copy());
        }

        entityRenderer.render(armorStand, 0, 0, 0, 0, partialTick, poseStack, bufferSource, packedLight);
        armorStandCache.returnArmorStand(armorStand, true);

        poseStack.popPose();
    }
}