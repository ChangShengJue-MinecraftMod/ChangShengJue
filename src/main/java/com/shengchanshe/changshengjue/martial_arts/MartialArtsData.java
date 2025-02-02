package com.shengchanshe.changshengjue.martial_arts;

import net.minecraft.world.entity.LivingEntity;

import java.util.HashSet;
import java.util.Set;

public abstract class MartialArtsData {
    private boolean learned;      // 是否学习
    private boolean mastered;     // 是否领悟
    private int cooldown;         // 冷却时间
    private int level;            // 技能等级
    private int pFooddeplete;     //饱食度消耗
    private int pSaturationdeplete;//饱和度消耗
    private String effect;        // 技能效果描述或类型（如“fireball”）
    private Set<Integer> boundKeys = new HashSet<>(); // 技能绑定的按键

    public MartialArtsData(boolean learned, boolean mastered, int cooldown, int level, int pFooddeplete, int pSaturationdeplete, String effect, Set<Integer> boundKeys) {
        this.learned = learned;
        this.mastered = mastered;
        this.cooldown = cooldown;
        this.level = level;
        this.pFooddeplete = pFooddeplete;
        this.pSaturationdeplete = pSaturationdeplete;
        this.effect = effect;
        this.boundKeys = boundKeys;
    }

    public boolean isLearned() {
        return learned;
    }

    public void setLearned(boolean learned) {
        this.learned = learned;
    }

    public boolean isMastered() {
        return mastered;
    }

    public void setMastered(boolean mastered) {
        this.mastered = mastered;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getpFooddeplete() {
        return pFooddeplete;
    }

    public void setpFooddeplete(int pFooddeplete) {
        this.pFooddeplete = pFooddeplete;
    }

    public int getpSaturationdeplete() {
        return pSaturationdeplete;
    }

    public void setpSaturationdeplete(int pSaturationdeplete) {
        this.pSaturationdeplete = pSaturationdeplete;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Set<Integer> getBoundKeys() {
        return boundKeys;
    }

    public void setBoundKeys(Set<Integer> boundKeys) {
        this.boundKeys = boundKeys;
    }

    // 技能效果，由具体的技能类实现
    public abstract void execute(LivingEntity player);

}
