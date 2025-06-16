package com.shengchanshe.changshengjue.item.combat.armor.taoistrobes;

import com.shengchanshe.changshengjue.item.combat.armor.ChangShengJueArmorItem;
import com.shengchanshe.changshengjue.item.combat.armor.DyeableItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class TaoistRobes extends ChangShengJueArmorItem implements DyeableItem {

    public TaoistRobes(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public int getColor(ItemStack pStack) {
        return DyeableItem.super.getColor(pStack) != -1 ? DyeableItem.super.getColor(pStack) : 0x0000FF;
    }
}
