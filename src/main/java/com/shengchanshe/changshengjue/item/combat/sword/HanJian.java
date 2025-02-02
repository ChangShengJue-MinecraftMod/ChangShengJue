package com.shengchanshe.changshengjue.item.combat.sword;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class HanJian extends Sword {
    public HanJian() {
        super(Tiers.IRON, 4, -2.4F, new Item.Properties().durability(1500));
    }
}
