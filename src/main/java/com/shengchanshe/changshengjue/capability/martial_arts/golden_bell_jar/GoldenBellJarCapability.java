package com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar;

import net.minecraft.nbt.CompoundTag;

public class GoldenBellJarCapability {
    private int goldenBellJarLevel = 0;//技能dengji
    private boolean goldenBellJarComprehend = false;//是否领悟
    private int goldenBellJarUseCount = 0;//使用次数
    private int goldenBellJarUseCooldownPercent = 0;//技能冷却
    private boolean goldenBellJarOff = false;//技能是否启用
    private int goldenBellJarToppedTick = 0;//技能领悟特效计时
    private int goldenBellJarDachengTick = 0;//技能领悟特效计时
    private boolean goldenBellJarParticle = false;//技能特效显示

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
        this.goldenBellJarUseCount = this.goldenBellJarUseCount + goldenBellJarUseCount;
        if (this.goldenBellJarUseCount>=100){
            this.addGoldenBellJarLevel();
        }
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

    public int getGoldenBellJarToppedTick() {
        if (this.goldenBellJarParticle && this.goldenBellJarToppedTick >= 80){
            this.goldenBellJarToppedTick = 0;
            this.goldenBellJarParticle = false;
        }
        return goldenBellJarToppedTick;
    }
    public int setGoldenBellJarToppedTick() {
        return this.goldenBellJarToppedTick++;
    }

    public int getGoldenBellJarDachengTick() {
        if (this.goldenBellJarParticle && this.goldenBellJarDachengTick >= 30){
            this.goldenBellJarDachengTick = 0;
            this.goldenBellJarParticle = false;
        }
        return goldenBellJarDachengTick;
    }
    public int setGoldenBellJarDachengTick() {
        return this.goldenBellJarDachengTick++;
    }

    public void setGoldenBellJarParticle(boolean goldenBellJarParticle) {
        this.goldenBellJarParticle = goldenBellJarParticle;
    }
    public boolean isGoldenBellJarParticle(){
        return this.goldenBellJarParticle;
    }


    public void copyGoldenBellJar(GoldenBellJarCapability capability){
        this.goldenBellJarLevel = capability.goldenBellJarLevel;
        this.goldenBellJarComprehend = capability.goldenBellJarComprehend;
        this.goldenBellJarUseCount = capability.goldenBellJarUseCount;
        this.goldenBellJarUseCooldownPercent = capability.goldenBellJarUseCooldownPercent;
        this.goldenBellJarOff = capability.goldenBellJarOff;
        this.goldenBellJarToppedTick = capability.goldenBellJarToppedTick;
        this.goldenBellJarDachengTick = capability.goldenBellJarDachengTick;
        this.goldenBellJarParticle = capability.goldenBellJarParticle;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("GoldenBellJarLevel", goldenBellJarLevel);
        nbt.putInt("GoldenBellJarUseCount", goldenBellJarUseCount);
        nbt.putBoolean("GoldenBellJarComprehend",goldenBellJarComprehend);
        nbt.putInt("GoldenBellJarUseCooldownPercent",goldenBellJarUseCooldownPercent);
        nbt.putBoolean("GoldenBellJarOff",goldenBellJarOff);
        nbt.putInt("GoldenBellJarToppedTick",goldenBellJarToppedTick);
        nbt.putInt("GoldenBellJarDachengTick",goldenBellJarDachengTick);
        nbt.putBoolean("GoldenBellJarParticle",goldenBellJarParticle);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        goldenBellJarLevel = nbt.getInt("GoldenBellJarLevel");
        goldenBellJarUseCount = nbt.getInt("GoldenBellJarUseCount");
        goldenBellJarUseCooldownPercent = nbt.getInt("GoldenBellJarUseCooldownPercent");
        goldenBellJarComprehend = nbt.getBoolean("GoldenBellJarComprehend");
        goldenBellJarOff = nbt.getBoolean("GoldenBellJarOff");
        goldenBellJarToppedTick = nbt.getInt("GoldenBellJarToppedTick");
        goldenBellJarDachengTick = nbt.getInt("GoldenBellJarDachengTick");
        goldenBellJarParticle = nbt.getBoolean("GoldenBellJarParticle");
    }
}
