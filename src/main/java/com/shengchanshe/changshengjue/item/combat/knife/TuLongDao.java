package com.shengchanshe.changshengjue.item.combat.knife;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;

public class TuLongDao extends Knife {
    public TuLongDao() {
        super(Tiers.IRON, 5, -2.4F, new Properties().durability(4000).fireResistant());
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        // 获取物品当前的所有附魔
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(pStack);
        // 如果物品没有 MENDING 附魔，就添加 MENDING 1级
        if (!enchantments.containsKey(Enchantments.MENDING)) {
            enchantments.put(Enchantments.MENDING, 1);
        }
        if (!enchantments.containsKey(Enchantments.MOB_LOOTING)){
            enchantments.put(Enchantments.MOB_LOOTING, 3);
        }
        // 将附魔设置回物品
        EnchantmentHelper.setEnchantments(enchantments, pStack);
    }
}
