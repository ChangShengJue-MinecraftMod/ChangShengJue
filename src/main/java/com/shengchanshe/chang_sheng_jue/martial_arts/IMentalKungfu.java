package com.shengchanshe.chang_sheng_jue.martial_arts;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffer;

public interface IMentalKungfu extends IKungFu {
    void onInteraction(Player player);
    void onInteraction(Player player, LivingEntity entity);
    void onInteraction(Player player, MerchantOffer merchantOffer);
}
