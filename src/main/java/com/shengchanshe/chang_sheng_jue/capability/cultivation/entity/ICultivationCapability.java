package com.shengchanshe.chang_sheng_jue.capability.cultivation.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

import java.util.EnumSet;

public interface ICultivationCapability {
    // 获取当前境界
    CultivationStage getCultivationStage();
    // 设置当前境界
    void setCultivationStage(CultivationStage cultivationStage);
    // 获取当前灵根集合
    EnumSet<SpiritRootType> getSpiritRoots();
    // 添加灵根（返回是否成功）
    boolean addSpiritRoot(SpiritRootType spiritRootType);
    // 是否拥有全部五种灵根
    boolean hasAllRoots();
    // 默认随机灵根
    EnumSet<SpiritRootType> initializeRandomSpiritRoots();

    // 获取当前灵力
    float getSpiritPower();
    // 设置当前灵力
    void setSpiritPower(float spiritPower);
    // 获取当前灵力上限
    float getMaxSpiritPower();
    //设置灵力上限
    void setMaxSpiritPower(float maxSpiritPower);
    // 计算最终灵力上限
    float calculateMaxSpiritPower(CultivationStage stage, int size, int ordinal);
    // 获取当前真元
    float getTruePower();
    // 设置当前真元
    void setTruePower(float truePower);
    // 获取当前真元上限
    float getMaxTruePower();

    //获取资质
    int getAptitude();
    //设置资质
    void setAptitude(int aptitude);
    //计算最终资质
    int calculateAptitude();

    //获取悟性
    float getComprehension();
    //设置悟性
    void setComprehension(float comprehension);

    //获取寿元
    int getLifeSpan();
    //设置寿元
    void setLifeSpan(int lifeSpan);

    //获取体质
    Physique getPhysique();
    //设置体质
    boolean setPhysique(Physique physiqueType);

    //获取吐纳时间
    int getTunNaTick();
    //设置吐纳时间
    void setTunNaTick(int tunNaTick);
    //获取吐纳转换灵气效率
    float getTunNaEfficiency();
    //设置吐纳转换灵气效率
    void setTunNaEfficiency(float tunNaEfficiency);
    //最终吐纳效率计算
    float calculateTunNaEfficiency();

    //是否开始闭关
    boolean isSeclusion();
    //设置是否开始闭关
    void setSeclusion(boolean seclusion);
    //获取闭关时间
    int getSeclusionTick();
    //设置闭关时间
    void setSeclusionTick(int seclusionTick);
    //获取闭关转换真元效率
    float getSeclusionEfficiency();
    //设置闭关转换真元效率
    void setSeclusionEfficiency(float cultivationSeclusionZhenYuanEfficiency);
    //最终闭关转换真元效率计算
    float calculateSeclusionEfficiency();
    //获取心境
    int getHeartRealm();
    //设置心境
    void setHeartRealm(int heartRealm);
    //获取心境上限
    HeartRealm getCurrentLevel();

    //获取当前聚气效率
    float getJiQiEfficiency();
    //设置当前聚气效率
    void setJiQiEfficiency(float jiQiEfficiency);
    //计算最终聚气效率
    float calculateJiQiEfficiency(Player player);

    // 吐纳吸收灵力转换方法
    void absorbSpiritPower(Player player);

    //闭关转换真元方法
    void convertTruePower(Player player);

    //突破方法
    void checkStageAdvancement(Player player, float truePower);

    // 序列化到NBT
    CompoundTag serializeNBT(CompoundTag nbt);
    void deserializeNBT(CompoundTag nbt);
    // 克隆旧属性到新实体方法
    void copy(ICultivationCapability oldStore);
}
