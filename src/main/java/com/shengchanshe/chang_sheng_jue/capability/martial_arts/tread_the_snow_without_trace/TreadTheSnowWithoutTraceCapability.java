package com.shengchanshe.chang_sheng_jue.capability.martial_arts.tread_the_snow_without_trace;

import net.minecraft.nbt.CompoundTag;

public class TreadTheSnowWithoutTraceCapability {
    private int treadTheSnowWithoutTraceLevel = 0;
    private boolean treadTheSnowWithoutTraceComprehend = false;
    private int treadTheSnowWithoutTraceUseCount = 0;
    private int treadTheSnowWithoutTraceUseCooldownPercent = 0;
    private float treadTheSnowWithoutTraceToppedTick = 0;//技能领悟特效计时
    private float treadTheSnowWithoutTraceDachengTick = 0;//技能领悟特效计时
    private boolean treadTheSnowWithoutTraceParticle = false;//技能特效显示

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

    public void addTreadTheSnowWithoutTraceUseCount(int treadTheSnowWithoutTraceUseCount){
        if (this.treadTheSnowWithoutTraceUseCount >= 100){
            this.addTreadTheSnowWithoutTraceLevel();
        }
        this.treadTheSnowWithoutTraceUseCount = this.treadTheSnowWithoutTraceUseCount + treadTheSnowWithoutTraceUseCount;
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

    public float getTreadTheSnowWithoutTraceToppedTick() {
        if (this.treadTheSnowWithoutTraceParticle && this.treadTheSnowWithoutTraceToppedTick >= 80){
            this.treadTheSnowWithoutTraceToppedTick = 0;
            this.treadTheSnowWithoutTraceParticle = false;
        }
        return treadTheSnowWithoutTraceToppedTick;
    }
    public float setTreadTheSnowWithoutTraceToppedTick() {
        return this.treadTheSnowWithoutTraceToppedTick++;
    }

    public float getTreadTheSnowWithoutTraceDachengTick() {
        if (this.treadTheSnowWithoutTraceParticle && this.treadTheSnowWithoutTraceDachengTick >= 30){
            this.treadTheSnowWithoutTraceDachengTick = 0;
            this.treadTheSnowWithoutTraceParticle = false;
        }
        return treadTheSnowWithoutTraceDachengTick;
    }
    public float setTreadTheSnowWithoutTraceDachengTick() {
        return this.treadTheSnowWithoutTraceDachengTick++;
    }

    public void setTreadTheSnowWithoutTraceParticle(boolean treadTheSnowWithoutTraceParticle) {
        this.treadTheSnowWithoutTraceParticle = treadTheSnowWithoutTraceParticle;
    }
    public boolean isTreadTheSnowWithoutTraceParticle(){
        return this.treadTheSnowWithoutTraceParticle;
    }

    public void copyTreadTheSnowWithoutTrace(TreadTheSnowWithoutTraceCapability capability){
        this.treadTheSnowWithoutTraceLevel = capability.treadTheSnowWithoutTraceLevel;
        this.treadTheSnowWithoutTraceComprehend = capability.treadTheSnowWithoutTraceComprehend;
        this.treadTheSnowWithoutTraceUseCount = capability.treadTheSnowWithoutTraceUseCount;
        this.treadTheSnowWithoutTraceUseCooldownPercent = capability.treadTheSnowWithoutTraceUseCooldownPercent;
        this.treadTheSnowWithoutTraceToppedTick = capability.treadTheSnowWithoutTraceToppedTick;
        this.treadTheSnowWithoutTraceDachengTick = capability.treadTheSnowWithoutTraceDachengTick;
        this.treadTheSnowWithoutTraceParticle = capability.treadTheSnowWithoutTraceParticle;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("TreadTheSnowWithoutTraceLevel", treadTheSnowWithoutTraceLevel);
        nbt.putInt("TreadTheSnowWithoutTraceUseCount", treadTheSnowWithoutTraceUseCount);
        nbt.putInt("TreadTheSnowWithoutTraceUseCooldownPercent",treadTheSnowWithoutTraceUseCooldownPercent);
        nbt.putBoolean("TreadTheSnowWithoutTraceComprehend",treadTheSnowWithoutTraceComprehend);
        nbt.putFloat("TreadTheSnowWithoutTraceToppedTick",treadTheSnowWithoutTraceToppedTick);
        nbt.putFloat("TreadTheSnowWithoutTraceDachengTick",treadTheSnowWithoutTraceDachengTick);
        nbt.putBoolean("TreadTheSnowWithoutTraceParticle",treadTheSnowWithoutTraceParticle);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        treadTheSnowWithoutTraceLevel = nbt.getInt("TreadTheSnowWithoutTraceLevel");
        treadTheSnowWithoutTraceUseCount = nbt.getInt("TreadTheSnowWithoutTraceUseCount");
        treadTheSnowWithoutTraceUseCooldownPercent = nbt.getInt("TreadTheSnowWithoutTraceUseCooldownPercent");
        treadTheSnowWithoutTraceComprehend = nbt.getBoolean("TreadTheSnowWithoutTraceComprehend");
        treadTheSnowWithoutTraceToppedTick = nbt.getFloat("TreadTheSnowWithoutTraceToppedTick");
        treadTheSnowWithoutTraceDachengTick = nbt.getFloat("TreadTheSnowWithoutTraceDachengTick");
        treadTheSnowWithoutTraceParticle = nbt.getBoolean("TreadTheSnowWithoutTraceParticle");
    }
}
