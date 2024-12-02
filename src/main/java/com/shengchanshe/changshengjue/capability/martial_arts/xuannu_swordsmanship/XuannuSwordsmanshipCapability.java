package com.shengchanshe.changshengjue.capability.martial_arts.xuannu_swordsmanship;

import net.minecraft.nbt.CompoundTag;

public class XuannuSwordsmanshipCapability {
    private int xuannuSwordsmanshipLevel = 0;
    private boolean xuannuSwordsmanshipComprehend = false;
    private int xuannuSwordsmanshipUseCount = 0;

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

    public void addXuannuSwordsmanshipUseCount(){
        if (this.xuannuSwordsmanshipUseCount>=100){
            this.addXuannuSwordsmanshipLevel();
        }
        this.xuannuSwordsmanshipUseCount++;
    }

    public void copyXuannuSwordsmanship(XuannuSwordsmanshipCapability capability){
        this.xuannuSwordsmanshipLevel = capability.xuannuSwordsmanshipLevel;
        this.xuannuSwordsmanshipComprehend = capability.xuannuSwordsmanshipComprehend;
        this.xuannuSwordsmanshipUseCount = capability.xuannuSwordsmanshipUseCount;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("XuannuSwordsmanshipLevel", xuannuSwordsmanshipLevel);
        nbt.putInt("XuannuSwordsmanshipUseCount", xuannuSwordsmanshipUseCount);
        nbt.putBoolean("XuannuSwordsmanshipComprehend",xuannuSwordsmanshipComprehend);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        xuannuSwordsmanshipLevel = nbt.getInt("XuannuSwordsmanshipLevel");
        xuannuSwordsmanshipUseCount = nbt.getInt("XuannuSwordsmanshipUseCount");
        xuannuSwordsmanshipComprehend = nbt.getBoolean("XuannuSwordsmanshipComprehend");
    }
}
