package com.shengchanshe.chang_sheng_jue.capability.martial_arts.immortal_miracle;

import net.minecraft.nbt.CompoundTag;

public class ImmortalMiracleCapability {
    private int immortalMiracleLevel = 0;//技能等级
    private boolean immortalMiracleComprehend = false;//是否领悟
    private int immortalMiracleUseCount = 0;//使用次数
    private float immortalMiracleUseCooldownPercent = 0;//技能冷却
    private boolean immortalMiracleOff = false;//技能是否启用
    private float immortalMiracleToppedTick = 0;//技能领悟特效计时
    private float immortalMiracleDachengTick = 0;//技能领悟特效计时
    private boolean immortalMiracleParticle = false;//技能特效显示
    private float immortalMiracleUseCooldownPercentMax = 1600;//技能总冷却时间
    // 技能状态
    private boolean skillActive = false;

    public int getImmortalMiracleLevel() {
        return immortalMiracleLevel;
    }
    public int getImmortalMiracleUseCount() {
        return immortalMiracleUseCount;
    }
    public void addImmortalMiracleLevel(){
        this.immortalMiracleLevel = this.immortalMiracleUseCount >= 100 ? 2 : 1;
    }

    public boolean isImmortalMiracleComprehend() {
        return immortalMiracleComprehend;
    }
    public void setImmortalMiracleComprehend(boolean immortalMiracleComprehend) {
        this.immortalMiracleComprehend = immortalMiracleComprehend;
    }

    public void addImmortalMiracleUseCount(int immortalMiracleUseCount){
        this.immortalMiracleUseCount = this.immortalMiracleUseCount + immortalMiracleUseCount;
        if (this.immortalMiracleUseCount>=100){
            this.addImmortalMiracleLevel();
        }
    }

    public float getImmortalMiracleUseCooldownPercent() {
        return immortalMiracleUseCooldownPercent;
    }
    public float setImmortalMiracleUseCooldownPercent() {
        return this.immortalMiracleUseCooldownPercent--;
    }
    public void setImmortalMiracleUseCooldownPercent(float immortalMiracleUseCooldownPercent) {
        this.immortalMiracleUseCooldownPercent = immortalMiracleUseCooldownPercent;
    }

    public float getImmortalMiracleUseCooldownPercentMax() {
        return immortalMiracleUseCooldownPercentMax;
    }
    public float setImmortalMiracleUseCooldownPercentMax(float immortalMiracleUseCooldownPercentMax) {
        return this.immortalMiracleUseCooldownPercentMax = immortalMiracleUseCooldownPercentMax;
    }

    public void setImmortalMiracleOff(boolean immortalMiracleOff) {
        this.immortalMiracleOff = immortalMiracleOff;
    }
    public boolean isImmortalMiracleOff(){
        return this.immortalMiracleOff;
    }

    public float getImmortalMiracleToppedTick() {
        if (this.immortalMiracleParticle && this.immortalMiracleToppedTick >= 80){
            this.immortalMiracleToppedTick = 0;
            this.immortalMiracleParticle = false;
        }
        return immortalMiracleToppedTick;
    }
    public float setImmortalMiracleToppedTick() {
        return this.immortalMiracleToppedTick++;
    }

    public float getImmortalMiracleDachengTick() {
        if (this.immortalMiracleParticle && this.immortalMiracleDachengTick >= 30){
            this.immortalMiracleDachengTick = 0;
            this.immortalMiracleParticle = false;
        }
        return immortalMiracleDachengTick;
    }
    public float setImmortalMiracleDachengTick() {
        return this.immortalMiracleDachengTick++;
    }

    public void setImmortalMiracleParticle(boolean immortalMiracleParticle) {
        this.immortalMiracleParticle = immortalMiracleParticle;
    }
    public boolean isImmortalMiracleParticle(){
        return this.immortalMiracleParticle;
    }


    public boolean isSkillActive() {
        return skillActive;
    }

    public void setSkillActive(boolean skillActive) {
        this.skillActive = skillActive;
    }

    public void copyImmortalMiracle(ImmortalMiracleCapability capability){
        this.immortalMiracleLevel = capability.immortalMiracleLevel;
        this.immortalMiracleComprehend = capability.immortalMiracleComprehend;
        this.immortalMiracleUseCount = capability.immortalMiracleUseCount;
        this.immortalMiracleUseCooldownPercent = capability.immortalMiracleUseCooldownPercent;
        this.immortalMiracleOff = capability.immortalMiracleOff;
        this.immortalMiracleToppedTick = capability.immortalMiracleToppedTick;
        this.immortalMiracleDachengTick = capability.immortalMiracleDachengTick;
        this.immortalMiracleParticle = capability.immortalMiracleParticle;
        this.immortalMiracleUseCooldownPercentMax = capability.immortalMiracleUseCooldownPercentMax;
        this.skillActive = capability.skillActive;
    }
    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("ImmortalMiracleLevel", immortalMiracleLevel);
        nbt.putInt("ImmortalMiracleUseCount", immortalMiracleUseCount);
        nbt.putBoolean("ImmortalMiracleComprehend",immortalMiracleComprehend);
        nbt.putFloat("ImmortalMiracleUseCooldownPercent",immortalMiracleUseCooldownPercent);
        nbt.putBoolean("ImmortalMiracleOff",immortalMiracleOff);
        nbt.putFloat("ImmortalMiracleToppedTick",immortalMiracleToppedTick);
        nbt.putFloat("ImmortalMiracleDachengTick",immortalMiracleDachengTick);
        nbt.putBoolean("ImmortalMiracleParticle",immortalMiracleParticle);
        nbt.putFloat("ImmortalMiracleUseCooldownPercentMax",immortalMiracleUseCooldownPercentMax);
        nbt.putBoolean("SkillActive", skillActive);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        immortalMiracleLevel = nbt.getInt("ImmortalMiracleLevel");
        immortalMiracleUseCount = nbt.getInt("ImmortalMiracleUseCount");
        immortalMiracleUseCooldownPercent = nbt.getFloat("ImmortalMiracleUseCooldownPercent");
        immortalMiracleComprehend = nbt.getBoolean("ImmortalMiracleComprehend");
        immortalMiracleOff = nbt.getBoolean("ImmortalMiracleOff");
        immortalMiracleToppedTick = nbt.getFloat("ImmortalMiracleToppedTick");
        immortalMiracleDachengTick = nbt.getFloat("ImmortalMiracleDachengTick");
        immortalMiracleParticle = nbt.getBoolean("ImmortalMiracleParticle");
        immortalMiracleUseCooldownPercentMax = nbt.getFloat("ImmortalMiracleUseCooldownPercentMax");
        skillActive = nbt.getBoolean("SkillActive");
    }
}
