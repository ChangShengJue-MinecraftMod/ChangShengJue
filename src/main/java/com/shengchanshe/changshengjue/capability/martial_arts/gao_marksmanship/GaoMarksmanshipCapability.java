package com.shengchanshe.changshengjue.capability.martial_arts.gao_marksmanship;

import net.minecraft.nbt.CompoundTag;

public class GaoMarksmanshipCapability {
    private int gaoMarksmanshipLevel = 0;
    private boolean gaoMarksmanshipComprehend = false;
    private int gaoMarksmanshipUseCount = 0;

    public boolean isGaoMarksmanshipComprehend() {
        return gaoMarksmanshipComprehend;
    }

    public int getGaoMarksmanshipLevel() {
        return gaoMarksmanshipLevel;
    }

    public int getGaoMarksmanshipUseCount() {
        return gaoMarksmanshipUseCount;
    }

    public void addGaoMarksmanshipLevel(){
        this.gaoMarksmanshipLevel = this.gaoMarksmanshipUseCount >= 100 ? 2 : 1;
    }

    public void setGaoMarksmanshipComprehend(boolean gaoMarksmanshipComprehend) {
        this.gaoMarksmanshipComprehend = gaoMarksmanshipComprehend;
    }

    public boolean gaoMarksmanshipComprehend(){
        return this.gaoMarksmanshipComprehend;
    }

    public void addGaoMarksmanshipUseCount(){
        if (this.gaoMarksmanshipUseCount>=100){
            this.addGaoMarksmanshipLevel();
        }
        this.gaoMarksmanshipUseCount++;
    }

    public void copyGaoMarksmanship(GaoMarksmanshipCapability capability){
        this.gaoMarksmanshipLevel = capability.gaoMarksmanshipLevel;
        this.gaoMarksmanshipComprehend = capability.gaoMarksmanshipComprehend;
        this.gaoMarksmanshipUseCount = capability.gaoMarksmanshipUseCount;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("GaoMarksmanshipLevel", gaoMarksmanshipLevel);
        nbt.putInt("GaoMarksmanshipUseCount", gaoMarksmanshipUseCount);
        nbt.putBoolean("GaoMarksmanshipComprehend",gaoMarksmanshipComprehend);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        gaoMarksmanshipLevel = nbt.getInt("GaoMarksmanshipLevel");
        gaoMarksmanshipUseCount = nbt.getInt("GaoMarksmanshipUseCount");
        gaoMarksmanshipComprehend = nbt.getBoolean("GaoMarksmanshipComprehend");
    }
}
