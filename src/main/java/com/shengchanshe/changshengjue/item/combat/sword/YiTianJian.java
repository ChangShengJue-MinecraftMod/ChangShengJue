package com.shengchanshe.changshengjue.item.combat.sword;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;

public class YiTianJian extends Sword {
    public YiTianJian() {
        super(Tiers.IRON, 6, -2.4F, new Item.Properties().durability(3880).fireResistant());
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        Map<Enchantment, Integer> enchantments = new HashMap<>();
        enchantments.put(Enchantments.MENDING, 1);
        enchantments.put(Enchantments.SHARPNESS, 1);
        EnchantmentHelper.setEnchantments(enchantments, pStack);
    }
}
