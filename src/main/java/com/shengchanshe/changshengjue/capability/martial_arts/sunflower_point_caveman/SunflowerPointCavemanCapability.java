package com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman;

import net.minecraft.nbt.CompoundTag;

public class SunflowerPointCavemanCapability {
    private int sunflowerPointCavemanLevel = 0;//技能等级
    private boolean sunflowerPointCavemanComprehend = false;//是否领悟
    private int sunflowerPointCavemanUseCount = 0;//使用次数
    private float sunflowerPointCavemanUseCooldownPercent = 0;//技能冷却
    private boolean sunflowerPointCavemanOff = false;//技能是否启用
    private float sunflowerPointCavemanToppedTick = 0;//技能领悟特效计时
    private float sunflowerPointCavemanDachengTick = 0;//技能领悟特效计时
    private boolean sunflowerPointCavemanParticle = false;//技能特效显示
    // 技能状态
    private boolean skillActive = false;

    public int getSunflowerPointCavemanLevel() {
        return sunflowerPointCavemanLevel;
    }
    public int getSunflowerPointCavemanUseCount() {
        return sunflowerPointCavemanUseCount;
    }
    public void addSunflowerPointCavemanLevel(){
        this.sunflowerPointCavemanLevel = this.sunflowerPointCavemanUseCount >= 100 ? 2 : 1;
    }

    public boolean isSunflowerPointCavemanComprehend() {
        return sunflowerPointCavemanComprehend;
    }
    public void setSunflowerPointCavemanComprehend(boolean sunflowerPointCavemanComprehend) {
        this.sunflowerPointCavemanComprehend = sunflowerPointCavemanComprehend;
    }

    public void addSunflowerPointCavemanUseCount(int sunflowerPointCavemanUseCount){
        this.sunflowerPointCavemanUseCount = this.sunflowerPointCavemanUseCount + sunflowerPointCavemanUseCount;
        if (this.sunflowerPointCavemanUseCount >= 100){
            this.addSunflowerPointCavemanLevel();
        }
    }

    public float getSunflowerPointCavemanUseCooldownPercent() {
        return sunflowerPointCavemanUseCooldownPercent;
    }
    public float setSunflowerPointCavemanUseCooldownPercent() {
        return this.sunflowerPointCavemanUseCooldownPercent--;
    }
    public void setSunflowerPointCavemanUseCooldownPercent(float sunflowerPointCavemanUseCooldownPercent) {
        this.sunflowerPointCavemanUseCooldownPercent = sunflowerPointCavemanUseCooldownPercent;
    }

    public void setSunflowerPointCavemanOff(boolean sunflowerPointCavemanOff) {
        this.sunflowerPointCavemanOff = sunflowerPointCavemanOff;
    }
    public boolean isSunflowerPointCavemanOff(){
        return this.sunflowerPointCavemanOff;
    }

    public float getSunflowerPointCavemanToppedTick() {
        if (this.sunflowerPointCavemanParticle && this.sunflowerPointCavemanToppedTick >= 80){
            this.sunflowerPointCavemanToppedTick = 0;
            this.sunflowerPointCavemanParticle = false;
        }
        return sunflowerPointCavemanToppedTick;
    }
    public float setSunflowerPointCavemanToppedTick() {
        return this.sunflowerPointCavemanToppedTick++;
    }

    public float getSunflowerPointCavemanDachengTick() {
        if (this.sunflowerPointCavemanParticle && this.sunflowerPointCavemanDachengTick >= 30){
            this.sunflowerPointCavemanDachengTick = 0;
            this.sunflowerPointCavemanParticle = false;
        }
        return sunflowerPointCavemanDachengTick;
    }
    public float setSunflowerPointCavemanDachengTick() {
        return this.sunflowerPointCavemanDachengTick++;
    }

    public void setSunflowerPointCavemanParticle(boolean sunflowerPointCavemanParticle) {
        this.sunflowerPointCavemanParticle = sunflowerPointCavemanParticle;
    }
    public boolean isSunflowerPointCavemanParticle(){
        return this.sunflowerPointCavemanParticle;
    }

    public boolean isSkillActive() {
        return skillActive;
    }

    public void setSkillActive(boolean skillActive) {
        this.skillActive = skillActive;
    }
    public void copySunflowerPointCaveman(SunflowerPointCavemanCapability capability){
        this.sunflowerPointCavemanLevel = capability.sunflowerPointCavemanLevel;
        this.sunflowerPointCavemanComprehend = capability.sunflowerPointCavemanComprehend;
        this.sunflowerPointCavemanUseCount = capability.sunflowerPointCavemanUseCount;
        this.sunflowerPointCavemanUseCooldownPercent = capability.sunflowerPointCavemanUseCooldownPercent;
        this.sunflowerPointCavemanOff = capability.sunflowerPointCavemanOff;
        this.sunflowerPointCavemanToppedTick = capability.sunflowerPointCavemanToppedTick;
        this.sunflowerPointCavemanDachengTick = capability.sunflowerPointCavemanDachengTick;
        this.sunflowerPointCavemanParticle = capability.sunflowerPointCavemanParticle;
        this.skillActive = capability.skillActive;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("SunflowerPointCavemanLevel", sunflowerPointCavemanLevel);
        nbt.putInt("SunflowerPointCavemanUseCount", sunflowerPointCavemanUseCount);
        nbt.putBoolean("SunflowerPointCavemanComprehend",sunflowerPointCavemanComprehend);
        nbt.putFloat("SunflowerPointCavemanUseCooldownPercent",sunflowerPointCavemanUseCooldownPercent);
        nbt.putBoolean("SunflowerPointCavemanOff",sunflowerPointCavemanOff);
        nbt.putFloat("SunflowerPointCavemanToppedTick",sunflowerPointCavemanToppedTick);
        nbt.putFloat("SunflowerPointCavemanDachengTick",sunflowerPointCavemanDachengTick);
        nbt.putBoolean("SunflowerPointCavemanParticle",sunflowerPointCavemanParticle);
        nbt.putBoolean("SkillActive", skillActive);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        sunflowerPointCavemanLevel = nbt.getInt("SunflowerPointCavemanLevel");
        sunflowerPointCavemanUseCount = nbt.getInt("SunflowerPointCavemanUseCount");
        sunflowerPointCavemanUseCooldownPercent = nbt.getFloat("SunflowerPointCavemanUseCooldownPercent");
        sunflowerPointCavemanComprehend = nbt.getBoolean("SunflowerPointCavemanComprehend");
        sunflowerPointCavemanOff = nbt.getBoolean("SunflowerPointCavemanOff");
        sunflowerPointCavemanToppedTick = nbt.getFloat("SunflowerPointCavemanToppedTick");
        sunflowerPointCavemanDachengTick = nbt.getFloat("SunflowerPointCavemanDachengTick");
        sunflowerPointCavemanParticle = nbt.getBoolean("SunflowerPointCavemanParticle");
        skillActive = nbt.getBoolean("SkillActive");
    }
}
