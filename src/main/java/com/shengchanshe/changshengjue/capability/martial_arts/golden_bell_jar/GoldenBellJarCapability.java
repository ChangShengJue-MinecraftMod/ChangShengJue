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
    // 技能状态
    private boolean skillZActive = false;
    private boolean skillXActive = false;
    private boolean skillCActive = false;
//    private int goldenBellJarKey;
//    private boolean skillActive = false;
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

    public boolean isSkillZActive() {
        return skillZActive;
    }

    public void setSkillZActive(boolean skillZActive) {
        this.skillZActive = skillZActive;
    }

    public boolean isSkillXActive() {
        return skillXActive;
    }

    public void setSkillXActive(boolean skillXActive) {
        this.skillXActive = skillXActive;
    }

    public boolean isSkillCActive() {
        return skillCActive;
    }

    public void setSkillCActive(boolean skillCActive) {
        this.skillCActive = skillCActive;
    }

    //    public int getGoldenBellJarKey() {
//        return goldenBellJarKey;
//    }
//
//    public void setGoldenBellJarKey(int goldenBellJarKey) {
//        this.goldenBellJarKey = goldenBellJarKey;
//    }
//
//    public boolean isSkillActive() {
//        return skillActive;
//    }
//
//    public void setSkillActive(boolean skillActive) {
//        this.skillActive = skillActive;
//    }
//
//    public int getGoldenBellJarKeyTick() {
//        return goldenBellJarKeyTick--;
//    }
//
//    public void setGoldenBellJarKeyTick(int goldenBellJarKeyTick) {
//        this.goldenBellJarKeyTick = goldenBellJarKeyTick;
//    }

    public void copyGoldenBellJar(GoldenBellJarCapability capability){
        this.goldenBellJarLevel = capability.goldenBellJarLevel;
        this.goldenBellJarComprehend = capability.goldenBellJarComprehend;
        this.goldenBellJarUseCount = capability.goldenBellJarUseCount;
        this.goldenBellJarUseCooldownPercent = capability.goldenBellJarUseCooldownPercent;
        this.goldenBellJarOff = capability.goldenBellJarOff;
        this.goldenBellJarToppedTick = capability.goldenBellJarToppedTick;
        this.goldenBellJarDachengTick = capability.goldenBellJarDachengTick;
        this.goldenBellJarParticle = capability.goldenBellJarParticle;
//        this.goldenBellJarKey = capability.goldenBellJarKey;
//        this.skillActive = capability.skillActive;
//        this.goldenBellJarKeyTick = capability.goldenBellJarKeyTick;
        this.skillZActive = capability.skillZActive;
        this.skillXActive = capability.skillXActive;
        this.skillCActive = capability.skillCActive;
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
        nbt.putBoolean("SkillZActive", skillZActive);
        nbt.putBoolean("SkillXActive", skillXActive);
        nbt.putBoolean("SkillCActive", skillCActive);
//        nbt.putInt("GoldenBellJarKey", goldenBellJarKey);
//        nbt.putBoolean("SkillActive",skillActive);
//        nbt.putInt("GoldenBellJarKeyTick", goldenBellJarKeyTick);
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
        skillZActive = nbt.getBoolean("SkillZActive");
        skillXActive = nbt.getBoolean("SkillXActive");
        skillCActive = nbt.getBoolean("SkillCActive");
//        goldenBellJarKey = nbt.getInt("GoldenBellJarKey");
//        skillActive = nbt.getBoolean("SkillActive");
//        goldenBellJarKeyTick = nbt.getInt("GoldenBellJarKeyTick");
    }
}
