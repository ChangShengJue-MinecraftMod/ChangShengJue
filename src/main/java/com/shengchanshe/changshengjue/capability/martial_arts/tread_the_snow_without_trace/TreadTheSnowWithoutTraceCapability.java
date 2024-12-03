package com.shengchanshe.changshengjue.capability.martial_arts.tread_the_snow_without_trace;

import net.minecraft.nbt.CompoundTag;

public class TreadTheSnowWithoutTraceCapability {
    private int treadTheSnowWithoutTraceLevel = 0;
    private boolean treadTheSnowWithoutTraceComprehend = false;
    private int treadTheSnowWithoutTraceUseCount = 0;
    private int treadTheSnowWithoutTraceUseCooldownPercent = 0;

    public boolean isTreadTheSnowWithoutTraceComprehend() {
        return treadTheSnowWithoutTraceComprehend;
    }

    public int getTreadTheSnowWithoutTraceLevel() {
        return treadTheSnowWithoutTraceLevel;
    }

    public int getTreadTheSnowWithoutTraceUseCount() {
        return treadTheSnowWithoutTraceUseCount;
    }

    public void addTreadTheSnowWithoutTraceLevel(){
        this.treadTheSnowWithoutTraceLevel = this.treadTheSnowWithoutTraceUseCount >= 100 ? 2 : 1;
    }

    public void setTreadTheSnowWithoutTraceComprehend(boolean treadTheSnowWithoutTraceComprehend) {
        this.treadTheSnowWithoutTraceComprehend = treadTheSnowWithoutTraceComprehend;
    }

    public void addTreadTheSnowWithoutTraceUseCount(){
        if (this.treadTheSnowWithoutTraceUseCount >= 100){
            this.addTreadTheSnowWithoutTraceLevel();
        }
        this.treadTheSnowWithoutTraceUseCount++;
    }

    public void copyTreadTheSnowWithoutTrace(TreadTheSnowWithoutTraceCapability capability){
        this.treadTheSnowWithoutTraceLevel = capability.treadTheSnowWithoutTraceLevel;
        this.treadTheSnowWithoutTraceComprehend = capability.treadTheSnowWithoutTraceComprehend;
        this.treadTheSnowWithoutTraceUseCount = capability.treadTheSnowWithoutTraceUseCount;
        this.treadTheSnowWithoutTraceUseCooldownPercent = capability.treadTheSnowWithoutTraceUseCooldownPercent;
    }

    public int getTreadTheSnowWithoutTraceUseCooldownPercent() {
        return treadTheSnowWithoutTraceUseCooldownPercent;
    }

    public int setTreadTheSnowWithoutTraceUseCooldownPercent() {
        return this.treadTheSnowWithoutTraceUseCooldownPercent--;
    }
    public void setTreadTheSnowWithoutTraceUseCooldownPercent(int treadTheSnowWithoutTraceUseCooldownPercent) {
        this.treadTheSnowWithoutTraceUseCooldownPercent = treadTheSnowWithoutTraceUseCooldownPercent;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("TreadTheSnowWithoutTraceLevel", treadTheSnowWithoutTraceLevel);
        nbt.putInt("TreadTheSnowWithoutTraceUseCount", treadTheSnowWithoutTraceUseCount);
        nbt.putInt("TreadTheSnowWithoutTraceUseCooldownPercent",treadTheSnowWithoutTraceUseCooldownPercent);
        nbt.putBoolean("TreadTheSnowWithoutTraceComprehend",treadTheSnowWithoutTraceComprehend);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        treadTheSnowWithoutTraceLevel = nbt.getInt("TreadTheSnowWithoutTraceLevel");
        treadTheSnowWithoutTraceUseCount = nbt.getInt("TreadTheSnowWithoutTraceUseCount");
        treadTheSnowWithoutTraceUseCooldownPercent = nbt.getInt("TreadTheSnowWithoutTraceUseCooldownPercent");
        treadTheSnowWithoutTraceComprehend = nbt.getBoolean("TreadTheSnowWithoutTraceComprehend");
    }
}
