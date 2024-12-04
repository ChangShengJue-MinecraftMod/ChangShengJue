package com.shengchanshe.changshengjue.capability.martial_arts.paoding;

import net.minecraft.nbt.CompoundTag;

public class PaodingCapability {
    private int paodingLevel = 0;
    private boolean paodingComprehend = false;
    private int paodingUseCount = 0;

    public boolean isPaodingComprehend() {
        return paodingComprehend;
    }

    public int getPaodingLevel() {
        return paodingLevel;
    }

    public int getPaodingUseCount() {
        return paodingUseCount;
    }

    public void addPaodingLevel(){
        this.paodingLevel = this.paodingUseCount >= 1000 ? 2 : 1;
    }

    public void setPaodingComprehend(boolean paodingComprehend) {
        this.paodingComprehend = paodingComprehend;
    }

    public void addPaodingUseCount(){
        if (this.paodingUseCount >= 1000){
            this.addPaodingLevel();
        }
        this.paodingUseCount++;
    }

    public void copyPaoding(PaodingCapability capability){
        this.paodingLevel = capability.paodingLevel;
        this.paodingComprehend = capability.paodingComprehend;
        this.paodingUseCount = capability.paodingUseCount;
    }


    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("PaodingLevel", paodingLevel);
        nbt.putInt("PaodingUseCount", paodingUseCount);
        nbt.putBoolean("PaodingComprehend",paodingComprehend);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        paodingLevel = nbt.getInt("PaodingLevel");
        paodingUseCount = nbt.getInt("PaodingUseCount");
        paodingComprehend = nbt.getBoolean("PaodingComprehend");
    }
}
