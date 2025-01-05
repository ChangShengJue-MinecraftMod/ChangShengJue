package com.shengchanshe.changshengjue.item.combat.sword;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantments;

public class YiTianJian extends Sword {
    public YiTianJian() {
        super(Tiers.IRON, 6, -2.4F, new Item.Properties().durability(3880).fireResistant());
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = new ItemStack(this);
        stack.enchant(Enchantments.MENDING, 1);
        stack.enchant(Enchantments.SHARPNESS, 5);
        return stack;
    }
}
