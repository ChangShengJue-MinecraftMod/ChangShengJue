package com.shengchanshe.chang_sheng_jue.cilent.setup;

import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.DyeableItem;
import com.shengchanshe.chang_sheng_jue.util.ClientSetup;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public final class ClientColorRegistrar {
    private ClientColorRegistrar() {
    }

    public static void register() {
        ItemColors itemColors = Minecraft.getInstance().getItemColors();
        // 为每个物品注册颜色渲染器
        for (Supplier<? extends Item> itemSupplier : ClientSetup.ARMOR_ITEMS) {
            itemColors.register((stack, color) -> {
                if (color == 1 && stack.getItem() instanceof DyeableItem dyeable) {
                    // color == 1 表示这是覆盖层
                    return dyeable.hasCustomColor(stack) ? dyeable.getColor(stack) : dyeable == ChangShengJueItems.MALE_TAOIST_HELMET.get() ? 0x000000 : 0xFFFFFF;
                }else {
                    return 0xFFFFFF;
                }
            }, itemSupplier.get());
        }
    }
}

