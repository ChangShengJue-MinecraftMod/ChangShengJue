package com.shengchanshe.chang_sheng_jue.martial_arts;

import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public interface IKungFu {
    /**
     * 武功id
     * @return
     */
    String getId();
    /**
     * 武功名称
     * @return
     */
    Component getName();
    /**
     * 武功类型
     * @return
     */
    KungFuType getKungFuType();
    /**
     * 武功描述
     * @return
     */
    Component getDescription();
    /**
     * 武功是否领悟
     * @return
     */
    boolean isComprehend();
    /**
     * 领悟武功
     * @return
     */
    void comprehendKungFu(LivingEntity entity);

    /**
     * 领悟武功的概率
     * @return
     */
    float getComprehendProbability(LivingEntity entity);
    /**
     * 领悟和升级武功的显示特效的tick
     * @return
     */
    int getLevelUpTick();
    void setLevelUpTick();
    /**
     * 武功升级显示的特效的tick
     * @return
     */
    int getDachengTick();
    void setDachengTick();
    /**
     * 武功伤害类型
     *
     * @return
     */
    ResourceKey<DamageType> getDamageType();
    /**
     * 武功是否可以释放
     * @return
     */
    boolean isReady();
    /**
     * 武功消耗饥饿值
     * @return
     */
    int getHunger();
    void setHunger(int hunger);
    /**
     * 武功消耗饱和度
     *
     * @return
     */
    float getSaturation();
    void setSaturation(float saturation);
    /**
     * 武功附带Effect的概率
     * @return
     */
    float getEffectProbability();
    void attackEffect(LivingEntity source, Entity target);

    /**
     * 武功冷却时间
     * @return
     */
    int getCoolDown();
    /**
     * 武功冷却时间上限
     * @return
     */
    int getMaxCoolDown();
    /**
     * 武功冷却时间递减
     */
    void tickCooldown();
    /**
     * 武功冷却时间倍率
     */
    float getCoolDownFactor();
    /**
     * 武功是否启动
     */
    boolean isStart();
    /**
     * 启动武功
     */
    void startKungFu(boolean isStart);
    /**
     * 碧螺春茶和龙井茶效果
     */
    void biluochunTeasAndLongJingTeasEffect(LivingEntity source);
    /**
     * 汾酒效果
     */
    float funJiuEffect(LivingEntity source, float damage);
    /**
     * 麦块贡酒效果
     */
    int wheatNuggetsTributeWineEffect(LivingEntity source);
    /**
     * 将武功写入tag
     * @return
     */
    CompoundTag serializeNBT();
    /**
     * 从tag中读取武功
     * @return
     */
    void deserializeNBT(CompoundTag tag);
}
