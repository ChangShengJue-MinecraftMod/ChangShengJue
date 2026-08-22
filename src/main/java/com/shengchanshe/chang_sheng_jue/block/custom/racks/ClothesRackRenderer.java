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
public class ClothesRackRenderer implements BlockEntityRenderer<ClothesRackEntity> {
    private final EntityRenderDispatcher entityRenderer;

    private static class ArmorStandCache {
        private static final int MAX_POOL_SIZE = 16;
        private final List<ArmorStand> standardStands = new ArrayList<>();
        private final List<ArmorStand> smallStands = new ArrayList<>();
        private Level cachedLevel;

        public ArmorStand getArmorStand(Level level, boolean small) {
            ensureLevel(level);
            List<ArmorStand> pool = small ? smallStands : standardStands;

            if (!pool.isEmpty()) {
                ArmorStand stand = pool.remove(pool.size() - 1);
                resetArmorStand(stand);
                return stand;
            }

            return createNewArmorStand(level, small);
        }

        public void returnArmorStand(ArmorStand stand, boolean small) {
            if (stand != null && stand.level() == cachedLevel) {
                List<ArmorStand> pool = small ? smallStands : standardStands;
                if (pool.size() < MAX_POOL_SIZE) {
                    pool.add(stand);
                }
            }
        }

        private void ensureLevel(Level level) {
            if (cachedLevel != level) {
                clear();
                cachedLevel = level;
            }
        }

        private void clear() {
            standardStands.clear();
            smallStands.clear();
            cachedLevel = null;
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
            for (EquipmentSlot slot : EquipmentSlot.values()) {
                stand.setItemSlot(slot, ItemStack.EMPTY);
            }
        }
    }

    private static final ArmorStandCache ARMOR_STAND_CACHE = new ArmorStandCache();

    public static void clearArmorStandCache() {
        ARMOR_STAND_CACHE.clear();
    }

    public ClothesRackRenderer(BlockEntityRendererProvider.Context context) {
        this.entityRenderer = Minecraft.getInstance().getEntityRenderDispatcher();
    }

    @Override
    public void render(ClothesRackEntity blockEntity, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        List<ItemStack> armorItems = blockEntity.getAllArmorItems();
        if (armorItems.isEmpty()) {
            return;
        }

        BlockState blockState = blockEntity.getBlockState();
        Direction direction = blockState.getValue(ClothesRack.FACING);

        Level level = Minecraft.getInstance().level;
        if (level == null) {
            return;
        }

        for (int i = 0; i < armorItems.size(); i++) {
            ItemStack armorItem = armorItems.get(i);
            if (armorItem.isEmpty() || !(armorItem.getItem() instanceof ArmorItem)) {
                continue;
            }

            poseStack.pushPose();
            ArmorStand armorStand = null;
            try {
                poseStack.translate(0.5, 0.5, 0.5);

                float rotation = -direction.toYRot();
                poseStack.mulPose(Axis.YP.rotationDegrees(rotation));

                float yOffset = getFixedYOffsetForSlot(i);
                poseStack.translate(0, yOffset, 0);

                armorStand = ARMOR_STAND_CACHE.getArmorStand(level, false);
                armorStand.setPos(blockEntity.getBlockPos().getX() + 0.5,
                        blockEntity.getBlockPos().getY(),
                        blockEntity.getBlockPos().getZ() + 0.5);

                ArmorItem armor = (ArmorItem) armorItem.getItem();
                armorStand.setItemSlot(armor.getEquipmentSlot(), armorItem.copy());
                entityRenderer.render(armorStand, 0, 0, 0, 0, partialTick, poseStack, bufferSource, packedLight);
            } finally {
                ARMOR_STAND_CACHE.returnArmorStand(armorStand, false);
                poseStack.popPose();
            }
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
}
