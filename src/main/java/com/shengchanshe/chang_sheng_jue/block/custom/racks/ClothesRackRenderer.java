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

import java.util.List;
@OnlyIn(Dist.CLIENT)
public class ClothesRackRenderer implements BlockEntityRenderer<ClothesRackEntity> {
    private final EntityRenderDispatcher entityRenderer;

    public ClothesRackRenderer(BlockEntityRendererProvider.Context context) {
        this.entityRenderer = Minecraft.getInstance().getEntityRenderDispatcher();
    }

    @Override
    public void render(ClothesRackEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        List<ItemStack> armorItems = blockEntity.getAllArmorItems();
        if (armorItems.isEmpty()) {
            return;
        }

        BlockState blockState = blockEntity.getBlockState();
        Direction direction = blockState.getValue(ClothesRack.FACING);

        for (int i = 0; i < armorItems.size(); i++) {
            ItemStack armorItem = armorItems.get(i);
            if (armorItem.isEmpty() || !(armorItem.getItem() instanceof ArmorItem)) {
                continue;
            }

            poseStack.pushPose();
            poseStack.translate(0.5, 0.5, 0.5);

            float rotation = -direction.toYRot();
            poseStack.mulPose(Axis.YP.rotationDegrees(rotation));

            float yOffset = getFixedYOffsetForSlot(i);
            poseStack.translate(0, yOffset, 0);
            poseStack.scale(1.0f, 1.0f, 1.0f);

            ArmorStand armorStand = createArmorStand(blockEntity.getLevel(), blockEntity.getBlockPos(), armorItem);
            entityRenderer.render(armorStand, 0, 0, 0, 0, partialTick, poseStack, bufferSource, packedLight);
            poseStack.popPose();
        }
    }

    private float getFixedYOffsetForSlot(int slotIndex) {
        return switch (slotIndex) {
            case 0 -> -0.1f;
            case 1 -> -0.2f;
            case 2 -> -0.35f;
            default -> 0f;
        };
    }

    private ArmorStand createArmorStand(Level level, BlockPos pos, ItemStack armorItem) {
        ArmorStand armorStand = new ArmorStand(EntityType.ARMOR_STAND, level);

        CompoundTag tag = new CompoundTag();
        tag.putBoolean("Invisible", true);
        tag.putBoolean("NoGravity", true);
        tag.putBoolean("Small", false);
        tag.putFloat("Rotation", 180f);
        armorStand.load(tag);

        if (!armorItem.isEmpty() && armorItem.getItem() instanceof ArmorItem armor) {
            EquipmentSlot slot = armor.getEquipmentSlot();
            // 清除所有装备槽
            armorStand.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
            armorStand.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
            armorStand.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);
            armorStand.setItemSlot(EquipmentSlot.FEET, ItemStack.EMPTY);

            // 只设置当前盔甲
            armorStand.setItemSlot(slot, armorItem.copy());
        }

        return armorStand;
    }
}