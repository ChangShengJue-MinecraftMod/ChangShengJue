package com.shengchanshe.changshengjue.item.combat.knife;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantments;


public class TuLongDao extends Knife {
    public TuLongDao() {
        super(Tiers.IRON, 5, -2.4F, new Properties().durability(4000).fireResistant());
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = new ItemStack(this);
        stack.enchant(Enchantments.MENDING, 1);
        stack.enchant(Enchantments.MOB_LOOTING, 3);
        return stack;
    }
}
