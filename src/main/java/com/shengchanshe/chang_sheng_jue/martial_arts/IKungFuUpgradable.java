package com.shengchanshe.chang_sheng_jue.martial_arts;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public interface IKungFuUpgradable {
    /**
     * 武功等级
     * @return
     */
    int getLevel();
    /**
     * 武功等级上限
     * @return
     */
    int getMaxLevel();
    /**
     * 武功升级所需经验
     * @return
     */
    int getExp();
    /**
     * 武功升级所需经验上限
     * @return
     */
    int getMaxExp();
    /**
     * 武功经验增加
     * @param amount
     */
    void addExp(LivingEntity entity, int amount);
    /**
     * 武功升级
     */
    void levelUp(LivingEntity entity);
}
