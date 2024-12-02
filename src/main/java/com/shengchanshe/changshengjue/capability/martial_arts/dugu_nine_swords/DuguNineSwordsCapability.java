package com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords;

import net.minecraft.nbt.CompoundTag;

public class DuguNineSwordsCapability {
    private int duguNineSwordsLevel = 0;
    private boolean duguNineSwordsComprehend = false;
    private int duguNineSwordsUseCount = 0;

    public boolean isDuguNineSwordsComprehend() {
        return duguNineSwordsComprehend;
    }

    public int getDuguNineSwordsLevel() {
        return duguNineSwordsLevel;
    }

    public int getDuguNineSwordsUseCount() {
        return duguNineSwordsUseCount;
    }

    public void addDuguNineSwordsLevel(){
        this.duguNineSwordsLevel = this.duguNineSwordsUseCount >= 100 ? 2 : 1;
    }

    public void setDuguNineSwordsComprehend(boolean duguNineSwordsComprehend) {
        this.duguNineSwordsComprehend = duguNineSwordsComprehend;
    }

    public boolean duguNineSwordsComprehend(){
        return this.duguNineSwordsComprehend;
    }

    public void addDuguNineSwordsUseCount(){
        if (this.duguNineSwordsUseCount>=100){
            this.addDuguNineSwordsLevel();
        }
        this.duguNineSwordsUseCount++;
    }

    public void copyDuguNineSwords(DuguNineSwordsCapability capability){
        this.duguNineSwordsLevel = capability.duguNineSwordsLevel;
        this.duguNineSwordsComprehend = capability.duguNineSwordsComprehend;
        this.duguNineSwordsUseCount = capability.duguNineSwordsUseCount;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("DuguNineSwordsLevel", duguNineSwordsLevel);
        nbt.putInt("duguNineSwordsUseCount", duguNineSwordsUseCount);
        nbt.putBoolean("DuguNineSwordsComprehend",duguNineSwordsComprehend);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        duguNineSwordsLevel = nbt.getInt("DuguNineSwordsLevel");
        duguNineSwordsUseCount = nbt.getInt("duguNineSwordsUseCount");
        duguNineSwordsComprehend = nbt.getBoolean("DuguNineSwordsComprehend");
    }
}
