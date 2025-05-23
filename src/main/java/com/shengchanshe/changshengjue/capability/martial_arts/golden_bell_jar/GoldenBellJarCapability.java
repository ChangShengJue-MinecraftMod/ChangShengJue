package com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar;

import net.minecraft.nbt.CompoundTag;

public class GoldenBellJarCapability {
    private int goldenBellJarLevel = 0;//技能dengji
    private boolean goldenBellJarComprehend = false;//是否领悟
    private int goldenBellJarUseCount = 0;//使用次数
    private float goldenBellJarUseCooldownPercent = 0;//技能冷却
    private boolean goldenBellJarOff = false;//技能是否启用
    private float goldenBellJarToppedTick = 0;//技能领悟特效计时
    private float goldenBellJarDachengTick = 0;//技能领悟特效计时
    private boolean goldenBellJarParticle = false;//技能特效显示
//    private int goldenBellJarKey;
    private boolean skillActive = false;
//    private int goldenBellJarKeyTick = 100;

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

    public float getGoldenBellJarUseCooldownPercent() {
        return goldenBellJarUseCooldownPercent;
    }
    public float setGoldenBellJarUseCooldownPercent() {
        return this.goldenBellJarUseCooldownPercent--;
    }
    public void setGoldenBellJarUseCooldownPercent(float goldenBellJarUseCooldownPercent) {
        this.goldenBellJarUseCooldownPercent = goldenBellJarUseCooldownPercent;
    }

    public void setGoldenBellJarOff(boolean goldenBellJarOff) {
        this.goldenBellJarOff = goldenBellJarOff;
    }
    public boolean isGoldenBellJarOff(){
        return this.goldenBellJarOff;
    }

    public float getGoldenBellJarToppedTick() {
        if (this.goldenBellJarParticle && this.goldenBellJarToppedTick >= 80){
            this.goldenBellJarToppedTick = 0;
            this.goldenBellJarParticle = false;
        }
        return goldenBellJarToppedTick;
    }
    public float setGoldenBellJarToppedTick() {
        return this.goldenBellJarToppedTick++;
    }

    public float getGoldenBellJarDachengTick() {
        if (this.goldenBellJarParticle && this.goldenBellJarDachengTick >= 30){
            this.goldenBellJarDachengTick = 0;
            this.goldenBellJarParticle = false;
        }
        return goldenBellJarDachengTick;
    }
    public float setGoldenBellJarDachengTick() {
        return this.goldenBellJarDachengTick++;
    }

    public void setGoldenBellJarParticle(boolean goldenBellJarParticle) {
        this.goldenBellJarParticle = goldenBellJarParticle;
    }
    public boolean isGoldenBellJarParticle(){
        return this.goldenBellJarParticle;
    }

    public boolean isSkillActive() {
        return skillActive;
    }

    public void setSkillActive(boolean skillActive) {
        this.skillActive = skillActive;
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
        this.skillActive = capability.skillActive;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("GoldenBellJarLevel", goldenBellJarLevel);
        nbt.putInt("GoldenBellJarUseCount", goldenBellJarUseCount);
        nbt.putBoolean("GoldenBellJarComprehend",goldenBellJarComprehend);
        nbt.putFloat("GoldenBellJarUseCooldownPercent",goldenBellJarUseCooldownPercent);
        nbt.putBoolean("GoldenBellJarOff",goldenBellJarOff);
        nbt.putFloat("GoldenBellJarToppedTick",goldenBellJarToppedTick);
        nbt.putFloat("GoldenBellJarDachengTick",goldenBellJarDachengTick);
        nbt.putBoolean("GoldenBellJarParticle",goldenBellJarParticle);
        nbt.putBoolean("SkillActive",skillActive);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        goldenBellJarLevel = nbt.getInt("GoldenBellJarLevel");
        goldenBellJarUseCount = nbt.getInt("GoldenBellJarUseCount");
        goldenBellJarUseCooldownPercent = nbt.getFloat("GoldenBellJarUseCooldownPercent");
        goldenBellJarComprehend = nbt.getBoolean("GoldenBellJarComprehend");
        goldenBellJarOff = nbt.getBoolean("GoldenBellJarOff");
        goldenBellJarToppedTick = nbt.getFloat("GoldenBellJarToppedTick");
        goldenBellJarDachengTick = nbt.getFloat("GoldenBellJarDachengTick");
        goldenBellJarParticle = nbt.getBoolean("GoldenBellJarParticle");
        skillActive = nbt.getBoolean("SkillActive");
    }
}
