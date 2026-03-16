package com.shengchanshe.chang_sheng_jue.item.combat.armor.render;

import com.shengchanshe.chang_sheng_jue.item.combat.armor.DyeableItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public final class ArmorRenderUtils {
    private ArmorRenderUtils() {}

    public static ItemStack getEffectiveArmorStack(GeoArmorRenderer<?> renderer) {
        ItemStack current = renderer.getCurrentStack();

        if (current == null || current.isEmpty() || isMissingDyeData(renderer, current)) {
            ItemStack equipped = getEquippedStack(renderer);
            if (!equipped.isEmpty()) {
                return equipped;
            }
        }

        return current == null ? ItemStack.EMPTY : current;
    }

    private static ItemStack getEquippedStack(GeoArmorRenderer<?> renderer) {
        if (renderer.getCurrentEntity() instanceof LivingEntity living) {
            EquipmentSlot slot = renderer.getCurrentSlot();
            if (slot != null) {
                return living.getItemBySlot(slot);
            }
        }
        return ItemStack.EMPTY;
    }

    private static boolean isMissingDyeData(GeoArmorRenderer<?> renderer, ItemStack current) {
        if (!(current.getItem() instanceof DyeableItem dyeable)) {
            return false;
        }
        if (dyeable.hasCustomColor(current)) {
            return false;
        }

        ItemStack equipped = getEquippedStack(renderer);
        if (!equipped.isEmpty() && equipped.getItem() == current.getItem()) {
            return dyeable.hasCustomColor(equipped);
        }

        return false;
    }

    private static String stackInfo(ItemStack stack) {
        if (stack == null || stack.isEmpty()) {
            return "empty";
        }
        String id = stack.getItem().toString();
        String color = "n/a";
        if (stack.getItem() instanceof DyeableItem dyeable) {
            color = dyeable.hasCustomColor(stack) ? String.format("#%06X", dyeable.getColor(stack)) : "default";
        }
        return id + " color=" + color;
    }
}
