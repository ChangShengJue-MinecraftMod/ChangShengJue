package com.shengchanshe.chang_sheng_jue.compat.arsenal;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;

/**
 * Arsenal 软兼容入口。这里不链接 Arsenal 类型，保证依赖缺失时公共代码仍可加载。
 */
public final class ArsenalCompat {
    private static final String MOD_ID = "arsenal_core";
    private static final String RAPIER_CLASS_NAME = "cn.mcmod.arsenal.item.rapier.RapierItem";

    private static final ClassValue<Boolean> RAPIER_TYPES = new ClassValue<>() {
        @Override
        protected Boolean computeValue(Class<?> type) {
            for (Class<?> current = type; current != null; current = current.getSuperclass()) {
                if (RAPIER_CLASS_NAME.equals(current.getName())) {
                    return true;
                }
            }
            return false;
        }
    };

    private ArsenalCompat() {
    }

    public static boolean isRapier(ItemStack stack) {
        return !stack.isEmpty()
                && ModList.get().isLoaded(MOD_ID)
                && RAPIER_TYPES.get(stack.getItem().getClass());
    }
}
