package com.shengchanshe.changshengjue.item.combat.knife;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class KitchenKnife extends knife {
    public KitchenKnife() {
        super(Tiers.IRON, 2, -2.4F, new Item.Properties().durability(500));
    }
}
