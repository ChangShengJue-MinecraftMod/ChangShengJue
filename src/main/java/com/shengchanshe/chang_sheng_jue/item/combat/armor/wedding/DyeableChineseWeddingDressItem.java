package com.shengchanshe.chang_sheng_jue.item.combat.armor.wedding;

import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public interface DyeableChineseWeddingDressItem extends DyeableLeatherItem {
    int DEFAULT_COLOR = 16711680;

    default boolean hasCustomColor(ItemStack pStack) {
        CompoundTag compoundtag = pStack.getTagElement("display");
        return compoundtag != null && compoundtag.contains("color", 99);
    }

    default int getColor(ItemStack pStack) {
        CompoundTag compoundtag = pStack.getTagElement("display");
        if (pStack.is(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_BLACK_GAUZE_CAP.get())){
            return compoundtag != null && compoundtag.contains("color", 99) ? compoundtag.getInt("color") : 0;
        }else {
            return compoundtag != null && compoundtag.contains("color", 99) ? compoundtag.getInt("color") : DEFAULT_COLOR;
        }
    }

    default void clearColor(ItemStack pStack) {
        CompoundTag compoundtag = pStack.getTagElement("display");
        if (compoundtag != null && compoundtag.contains("color")) {
            compoundtag.remove("color");
        }

    }

    default void setColor(ItemStack pStack, int pColor) {
        pStack.getOrCreateTagElement("display").putInt("color", pColor);
    }
}