package com.shengchanshe.chang_sheng_jue.martial_arts;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public interface ILightKungfu extends IKungFu {
    void onLightKungfu(Player player);
    void onEntityTick(LivingEntity player);
}
