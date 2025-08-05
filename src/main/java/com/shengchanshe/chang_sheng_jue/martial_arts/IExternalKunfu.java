package com.shengchanshe.chang_sheng_jue.martial_arts;

import net.minecraft.world.entity.LivingEntity;

public interface IExternalKunfu extends IKungFu {
    /**
     * 武功伤害
     * @return
     */
    float getDamage(LivingEntity entity);
    /**
     * 武功伤害系数
     * @return
     */
    float getDamageFactor();
    /**
     * 武功释放
     * @return
     */
    void release(LivingEntity livingEntity);
    void release(LivingEntity source, LivingEntity target);

    /**
     * 武功是否可以释放
     * @return
     */
    boolean isAttackReday();
    /**
     * 武功前摇时间
     * @return
     */
    int getSwingTick();
}
