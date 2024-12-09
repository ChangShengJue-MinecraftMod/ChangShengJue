package com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle;

import net.minecraft.nbt.CompoundTag;

public class ImmortalMiracleCapability {
    private int immortalMiracleLevel = 0;//技能等级
    private boolean immortalMiracleComprehend = false;//是否领悟
    private int immortalMiracleUseCount = 0;//使用次数
    private int immortalMiracleUseCooldownPercent = 0;//技能冷却
    private boolean immortalMiracleOff = false;//技能是否启用
    private int immortalMiracleToppedTick = 0;//技能领悟特效计时
    private int immortalMiracleDachengTick = 0;//技能领悟特效计时
    private boolean immortalMiracleParticle = false;//技能特效显示
    private int immortalMiracleUseCooldownPercentMax = 1600;//技能总冷却时间


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

    public int getImmortalMiracleUseCooldownPercent() {
        return immortalMiracleUseCooldownPercent;
    }
    public int setImmortalMiracleUseCooldownPercent() {
        return this.immortalMiracleUseCooldownPercent--;
    }
    public void setImmortalMiracleUseCooldownPercent(int immortalMiracleUseCooldownPercent) {
        this.immortalMiracleUseCooldownPercent = immortalMiracleUseCooldownPercent;
    }

    public int getImmortalMiracleUseCooldownPercentMax() {
        return immortalMiracleUseCooldownPercentMax;
    }
    public int setImmortalMiracleUseCooldownPercentMax(int immortalMiracleUseCooldownPercentMax) {
        return this.immortalMiracleUseCooldownPercentMax = immortalMiracleUseCooldownPercentMax;
    }

    public void setImmortalMiracleOff(boolean immortalMiracleOff) {
        this.immortalMiracleOff = immortalMiracleOff;
    }
    public boolean isImmortalMiracleOff(){
        return this.immortalMiracleOff;
    }

    public int getImmortalMiracleToppedTick() {
        if (this.immortalMiracleParticle && this.immortalMiracleToppedTick >= 80){
            this.immortalMiracleToppedTick = 0;
            this.immortalMiracleParticle = false;
        }
        return immortalMiracleToppedTick;
    }
    public int setImmortalMiracleToppedTick() {
        return this.immortalMiracleToppedTick++;
    }

    public int getImmortalMiracleDachengTick() {
        if (this.immortalMiracleParticle && this.immortalMiracleDachengTick >= 30){
            this.immortalMiracleDachengTick = 0;
            this.immortalMiracleParticle = false;
        }
        return immortalMiracleDachengTick;
    }
    public int setImmortalMiracleDachengTick() {
        return this.immortalMiracleDachengTick++;
    }

    public void setImmortalMiracleParticle(boolean immortalMiracleParticle) {
        this.immortalMiracleParticle = immortalMiracleParticle;
    }
    public boolean isImmortalMiracleParticle(){
        return this.immortalMiracleParticle;
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
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("ImmortalMiracleLevel", immortalMiracleLevel);
        nbt.putInt("ImmortalMiracleUseCount", immortalMiracleUseCount);
        nbt.putBoolean("ImmortalMiracleComprehend",immortalMiracleComprehend);
        nbt.putInt("ImmortalMiracleUseCooldownPercent",immortalMiracleUseCooldownPercent);
        nbt.putBoolean("ImmortalMiracleOff",immortalMiracleOff);
        nbt.putInt("ImmortalMiracleToppedTick",immortalMiracleToppedTick);
        nbt.putInt("ImmortalMiracleDachengTick",immortalMiracleDachengTick);
        nbt.putBoolean("ImmortalMiracleParticle",immortalMiracleParticle);
        nbt.putInt("ImmortalMiracleUseCooldownPercentMax",immortalMiracleUseCooldownPercentMax);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        immortalMiracleLevel = nbt.getInt("ImmortalMiracleLevel");
        immortalMiracleUseCount = nbt.getInt("ImmortalMiracleUseCount");
        immortalMiracleUseCooldownPercent = nbt.getInt("ImmortalMiracleUseCooldownPercent");
        immortalMiracleComprehend = nbt.getBoolean("ImmortalMiracleComprehend");
        immortalMiracleOff = nbt.getBoolean("ImmortalMiracleOff");
        immortalMiracleToppedTick = nbt.getInt("ImmortalMiracleToppedTick");
        immortalMiracleDachengTick = nbt.getInt("ImmortalMiracleDachengTick");
        immortalMiracleParticle = nbt.getBoolean("ImmortalMiracleParticle");
        immortalMiracleUseCooldownPercentMax = nbt.getInt("ImmortalMiracleUseCooldownPercentMax");
    }
}
