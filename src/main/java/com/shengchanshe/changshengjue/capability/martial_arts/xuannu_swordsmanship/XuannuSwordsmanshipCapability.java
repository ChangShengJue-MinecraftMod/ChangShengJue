package com.shengchanshe.changshengjue.capability.martial_arts.xuannu_swordsmanship;

import net.minecraft.nbt.CompoundTag;

public class XuannuSwordsmanshipCapability {
    private int xuannuSwordsmanshipLevel = 0;
    private boolean xuannuSwordsmanshipComprehend = false;
    private int xuannuSwordsmanshipUseCount = 0;
    private float xuannuSwordsmanshipToppedTick = 0;//技能领悟特效计时
    private float xuannuSwordsmanshipDachengTick = 0;//技能领悟特效计时
    private boolean xuannuSwordsmanshipParticle = false;//技能特效显示

    public boolean isXuannuSwordsmanshipComprehend() {
        return xuannuSwordsmanshipComprehend;
    }

    public int getXuannuSwordsmanshipLevel() {
        return xuannuSwordsmanshipLevel;
    }

    public int getXuannuSwordsmanshipUseCount() {
        return xuannuSwordsmanshipUseCount;
    }

    public void addXuannuSwordsmanshipLevel(){
        this.xuannuSwordsmanshipLevel = this.xuannuSwordsmanshipUseCount >= 100 ? 2 : 1;
    }

    public void setXuannuSwordsmanshipComprehend(boolean xuannuSwordsmanshipComprehend) {
        this.xuannuSwordsmanshipComprehend = xuannuSwordsmanshipComprehend;
    }

    public boolean xuannuSwordsmanshipComprehend(){
        return this.xuannuSwordsmanshipComprehend;
    }

    public void addXuannuSwordsmanshipUseCount(int xuannuSwordsmanshipUseCount){
        this.xuannuSwordsmanshipUseCount = this.xuannuSwordsmanshipUseCount + xuannuSwordsmanshipUseCount;
        if (this.xuannuSwordsmanshipUseCount>=100){
            this.addXuannuSwordsmanshipLevel();
        }
    }

    public float getXuannuSwordsmanshipToppedTick() {
        if (this.xuannuSwordsmanshipParticle && this.xuannuSwordsmanshipToppedTick >= 80){
            this.xuannuSwordsmanshipToppedTick = 0;
            this.xuannuSwordsmanshipParticle = false;
        }
        return xuannuSwordsmanshipToppedTick;
    }
    public float setXuannuSwordsmanshipToppedTick() {
        return this.xuannuSwordsmanshipToppedTick++;
    }

    public float getXuannuSwordsmanshipDachengTick() {
        if (this.xuannuSwordsmanshipParticle && this.xuannuSwordsmanshipDachengTick >= 30){
            this.xuannuSwordsmanshipDachengTick = 0;
            this.xuannuSwordsmanshipParticle = false;
        }
        return xuannuSwordsmanshipDachengTick;
    }
    public float setXuannuSwordsmanshipDachengTick() {
        return this.xuannuSwordsmanshipDachengTick++;
    }

    public void setXuannuSwordsmanshipParticle(boolean xuannuSwordsmanshipParticle) {
        this.xuannuSwordsmanshipParticle = xuannuSwordsmanshipParticle;
    }
    public boolean isXuannuSwordsmanshipParticle(){
        return this.xuannuSwordsmanshipParticle;
    }

    public void copyXuannuSwordsmanship(XuannuSwordsmanshipCapability capability){
        this.xuannuSwordsmanshipLevel = capability.xuannuSwordsmanshipLevel;
        this.xuannuSwordsmanshipComprehend = capability.xuannuSwordsmanshipComprehend;
        this.xuannuSwordsmanshipUseCount = capability.xuannuSwordsmanshipUseCount;
        this.xuannuSwordsmanshipToppedTick = capability.xuannuSwordsmanshipToppedTick;
        this.xuannuSwordsmanshipDachengTick = capability.xuannuSwordsmanshipDachengTick;
        this.xuannuSwordsmanshipParticle = capability.xuannuSwordsmanshipParticle;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("XuannuSwordsmanshipLevel", xuannuSwordsmanshipLevel);
        nbt.putInt("XuannuSwordsmanshipUseCount", xuannuSwordsmanshipUseCount);
        nbt.putBoolean("XuannuSwordsmanshipComprehend",xuannuSwordsmanshipComprehend);
        nbt.putFloat("XuannuSwordsmanshipToppedTick",xuannuSwordsmanshipToppedTick);
        nbt.putFloat("XuannuSwordsmanshipDachengTick",xuannuSwordsmanshipDachengTick);
        nbt.putBoolean("XuannuSwordsmanshipParticle",xuannuSwordsmanshipParticle);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        xuannuSwordsmanshipLevel = nbt.getInt("XuannuSwordsmanshipLevel");
        xuannuSwordsmanshipUseCount = nbt.getInt("XuannuSwordsmanshipUseCount");
        xuannuSwordsmanshipComprehend = nbt.getBoolean("XuannuSwordsmanshipComprehend");
        xuannuSwordsmanshipToppedTick = nbt.getFloat("XuannuSwordsmanshipToppedTick");
        xuannuSwordsmanshipDachengTick = nbt.getFloat("XuannuSwordsmanshipDachengTick");
        xuannuSwordsmanshipParticle = nbt.getBoolean("XuannuSwordsmanshipParticle");
    }
}
