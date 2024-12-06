package com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman;

import net.minecraft.nbt.CompoundTag;

public class SunflowerPointCavemanCapability {
    private int sunflowerPointCavemanLevel = 0;//技能等级
    private boolean sunflowerPointCavemanComprehend = false;//是否领悟
    private int sunflowerPointCavemanUseCount = 0;//使用次数
    private int sunflowerPointCavemanUseCooldownPercent = 0;//技能冷却
    private boolean sunflowerPointCavemanOff = false;//技能是否启用
    private int sunflowerPointCavemanToppedTick = 0;//技能领悟特效计时
    private int sunflowerPointCavemanDachengTick = 0;//技能领悟特效计时
    private boolean sunflowerPointCavemanParticle = false;//技能特效显示

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
        if (this.sunflowerPointCavemanUseCount>=100){
            this.addSunflowerPointCavemanLevel();
        }
    }

    public int getSunflowerPointCavemanUseCooldownPercent() {
        return sunflowerPointCavemanUseCooldownPercent;
    }
    public int setSunflowerPointCavemanUseCooldownPercent() {
        return this.sunflowerPointCavemanUseCooldownPercent--;
    }
    public void setSunflowerPointCavemanUseCooldownPercent(int sunflowerPointCavemanUseCooldownPercent) {
        this.sunflowerPointCavemanUseCooldownPercent = sunflowerPointCavemanUseCooldownPercent;
    }

    public void setSunflowerPointCavemanOff(boolean sunflowerPointCavemanOff) {
        this.sunflowerPointCavemanOff = sunflowerPointCavemanOff;
    }
    public boolean isSunflowerPointCavemanOff(){
        return this.sunflowerPointCavemanOff;
    }

    public int getSunflowerPointCavemanToppedTick() {
        if (this.sunflowerPointCavemanParticle && this.sunflowerPointCavemanToppedTick >= 80){
            this.sunflowerPointCavemanToppedTick = 0;
            this.sunflowerPointCavemanParticle = false;
        }
        return sunflowerPointCavemanToppedTick;
    }
    public int setSunflowerPointCavemanToppedTick() {
        return this.sunflowerPointCavemanToppedTick++;
    }

    public int getSunflowerPointCavemanDachengTick() {
        if (this.sunflowerPointCavemanParticle && this.sunflowerPointCavemanDachengTick >= 30){
            this.sunflowerPointCavemanDachengTick = 0;
            this.sunflowerPointCavemanParticle = false;
        }
        return sunflowerPointCavemanDachengTick;
    }
    public int setSunflowerPointCavemanDachengTick() {
        return this.sunflowerPointCavemanDachengTick++;
    }

    public void setSunflowerPointCavemanParticle(boolean sunflowerPointCavemanParticle) {
        this.sunflowerPointCavemanParticle = sunflowerPointCavemanParticle;
    }
    public boolean isSunflowerPointCavemanParticle(){
        return this.sunflowerPointCavemanParticle;
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
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("SunflowerPointCavemanLevel", sunflowerPointCavemanLevel);
        nbt.putInt("SunflowerPointCavemanUseCount", sunflowerPointCavemanUseCount);
        nbt.putBoolean("SunflowerPointCavemanComprehend",sunflowerPointCavemanComprehend);
        nbt.putInt("SunflowerPointCavemanUseCooldownPercent",sunflowerPointCavemanUseCooldownPercent);
        nbt.putBoolean("SunflowerPointCavemanOff",sunflowerPointCavemanOff);
        nbt.putInt("SunflowerPointCavemanToppedTick",sunflowerPointCavemanToppedTick);
        nbt.putInt("SunflowerPointCavemanDachengTick",sunflowerPointCavemanDachengTick);
        nbt.putBoolean("SunflowerPointCavemanParticle",sunflowerPointCavemanParticle);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        sunflowerPointCavemanLevel = nbt.getInt("SunflowerPointCavemanLevel");
        sunflowerPointCavemanUseCount = nbt.getInt("SunflowerPointCavemanUseCount");
        sunflowerPointCavemanUseCooldownPercent = nbt.getInt("SunflowerPointCavemanUseCooldownPercent");
        sunflowerPointCavemanComprehend = nbt.getBoolean("SunflowerPointCavemanComprehend");
        sunflowerPointCavemanOff = nbt.getBoolean("SunflowerPointCavemanOff");
        sunflowerPointCavemanToppedTick = nbt.getInt("SunflowerPointCavemanToppedTick");
        sunflowerPointCavemanDachengTick = nbt.getInt("SunflowerPointCavemanDachengTick");
        sunflowerPointCavemanParticle = nbt.getBoolean("SunflowerPointCavemanParticle");
    }
}
