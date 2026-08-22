package com.shengchanshe.chang_sheng_jue.block.custom.storage;

import net.minecraft.world.item.ItemStack;

final class StoredItemRenderHelper {
    private static final int MAX_VISIBLE_ITEMS = 8;

    private StoredItemRenderHelper() {
    }

    static int visibleCount(ItemStack stack) {
        return Math.min(stack.getCount(), MAX_VISIBLE_ITEMS);
    }
}
