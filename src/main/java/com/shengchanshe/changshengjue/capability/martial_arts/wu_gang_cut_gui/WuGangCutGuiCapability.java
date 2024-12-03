package com.shengchanshe.changshengjue.capability.martial_arts.wu_gang_cut_gui;

import net.minecraft.nbt.CompoundTag;

public class WuGangCutGuiCapability {
    private int wuGangCutGuiLevel = 0;
    private boolean wuGangCutGuiComprehend = false;
    private int wuGangCutGuiUseCount = 0;

    public boolean isWuGangCutGuiComprehend() {
        return wuGangCutGuiComprehend;
    }

    public int getWuGangCutGuiLevel() {
        return wuGangCutGuiLevel;
    }

    public int getWuGangCutGuiUseCount() {
        return wuGangCutGuiUseCount;
    }

    public void addWuGangCutGuiLevel(){
        this.wuGangCutGuiLevel = this.wuGangCutGuiUseCount >= 1000 ? 2 : 1;
    }

    public void setWuGangCutGuiComprehend(boolean wuGangCutGuiComprehend) {
        this.wuGangCutGuiComprehend = wuGangCutGuiComprehend;
    }

    public void addWuGangCutGuiUseCount(){
        if (this.wuGangCutGuiUseCount >= 1000){
            this.addWuGangCutGuiLevel();
        }
        this.wuGangCutGuiUseCount++;
    }

    public void copyWuGangCutGui(WuGangCutGuiCapability capability){
        this.wuGangCutGuiLevel = capability.wuGangCutGuiLevel;
        this.wuGangCutGuiComprehend = capability.wuGangCutGuiComprehend;
        this.wuGangCutGuiUseCount = capability.wuGangCutGuiUseCount;
    }


    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("WuGangCutGuiLevel", wuGangCutGuiLevel);
        nbt.putInt("WuGangCutGuiUseCount", wuGangCutGuiUseCount);
        nbt.putBoolean("WuGangCutGuiComprehend",wuGangCutGuiComprehend);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        wuGangCutGuiLevel = nbt.getInt("WuGangCutGuiLevel");
        wuGangCutGuiUseCount = nbt.getInt("WuGangCutGuiUseCount");
        wuGangCutGuiComprehend = nbt.getBoolean("WuGangCutGuiComprehend");
    }
}
