package com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar;

import net.minecraft.nbt.CompoundTag;

public class GoldenBellJarCapability {
    private int goldenBellJarLevel = 0;//技能dengji
    private boolean goldenBellJarComprehend = false;//是否领悟
    private int goldenBellJarUseCount = 0;//使用次数
    private int goldenBellJarUseCooldownPercent = 0;//技能冷却
    private boolean goldenBellJarOff = false;//技能是否启用

    public int getGoldenBellJarLevel() {
        return goldenBellJarLevel;
    }
    public int getGoldenBellJarUseCount() {
        return goldenBellJarUseCount;
    }
    public void addGoldenBellJarLevel(){
        this.goldenBellJarLevel = this.goldenBellJarUseCount >= 100 ? 2 : 1;
    }

    public boolean isGoldenBellJarComprehend() {
        return goldenBellJarComprehend;
    }
    public void setGoldenBellJarComprehend(boolean goldenBellJarComprehend) {
        this.goldenBellJarComprehend = goldenBellJarComprehend;
    }

    public void addGoldenBellJarUseCount(int goldenBellJarUseCount){
        if (this.goldenBellJarUseCount>=100){
            this.addGoldenBellJarLevel();
        }
        this.goldenBellJarUseCount =  this.goldenBellJarUseCount + goldenBellJarUseCount;
    }

    public int getGoldenBellJarUseCooldownPercent() {
        return goldenBellJarUseCooldownPercent;
    }
    public int setGoldenBellJarUseCooldownPercent() {
        return this.goldenBellJarUseCooldownPercent--;
    }
    public void setGoldenBellJarUseCooldownPercent(int goldenBellJarUseCooldownPercent) {
        this.goldenBellJarUseCooldownPercent = goldenBellJarUseCooldownPercent;
    }

    public void setGoldenBellJarOff(boolean goldenBellJarOff) {
        this.goldenBellJarOff = goldenBellJarOff;
    }
    public boolean isGoldenBellJarOff(){
        return this.goldenBellJarOff;
    }

    public void copyGoldenBellJar(GoldenBellJarCapability capability){
        this.goldenBellJarLevel = capability.goldenBellJarLevel;
        this.goldenBellJarComprehend = capability.goldenBellJarComprehend;
        this.goldenBellJarUseCount = capability.goldenBellJarUseCount;
        this.goldenBellJarUseCooldownPercent = capability.goldenBellJarUseCooldownPercent;
        this.goldenBellJarOff = capability.goldenBellJarOff;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("GoldenBellJarLevel", goldenBellJarLevel);
        nbt.putInt("GoldenBellJarUseCount", goldenBellJarUseCount);
        nbt.putBoolean("GoldenBellJarComprehend",goldenBellJarComprehend);
        nbt.putInt("GoldenBellJarUseCooldownPercent",goldenBellJarUseCooldownPercent);
        nbt.putBoolean("GoldenBellJarOff",goldenBellJarOff);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        goldenBellJarLevel = nbt.getInt("GoldenBellJarLevel");
        goldenBellJarUseCount = nbt.getInt("GoldenBellJarUseCount");
        goldenBellJarUseCooldownPercent = nbt.getInt("GoldenBellJarUseCooldownPercent");
        goldenBellJarComprehend = nbt.getBoolean("GoldenBellJarComprehend");
        goldenBellJarOff = nbt.getBoolean("GoldenBellJarOff");
    }
}
