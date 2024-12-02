package com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method;

import net.minecraft.nbt.CompoundTag;

public class GoldenBlackKnifeMethodCapability {
    private int goldenBlackKnifeMethodLevel = 0;
    private boolean goldenBlackKnifeMethodComprehend = false;
    private int goldenBlackKnifeMethodUseCount = 0;

    public boolean isGoldenBlackKnifeMethodComprehend() {
        return goldenBlackKnifeMethodComprehend;
    }

    public int getGoldenBlackKnifeMethodLevel() {
        return goldenBlackKnifeMethodLevel;
    }

    public int getGoldenBlackKnifeMethodUseCount() {
        return goldenBlackKnifeMethodUseCount;
    }

    public void addGoldenBlackKnifeMethodLevel(){
        this.goldenBlackKnifeMethodLevel = this.goldenBlackKnifeMethodUseCount >= 100 ? 2 : 1;
    }

    public void setGoldenBlackKnifeMethodComprehend(boolean goldenBlackKnifeMethodComprehend) {
        this.goldenBlackKnifeMethodComprehend = goldenBlackKnifeMethodComprehend;
    }

    public boolean goldenBlackKnifeMethodComprehend(){
        return this.goldenBlackKnifeMethodComprehend;
    }

    public void addGoldenBlackKnifeMethodUseCount(){
        if (this.goldenBlackKnifeMethodUseCount>=100){
            this.addGoldenBlackKnifeMethodLevel();
        }
        this.goldenBlackKnifeMethodUseCount++;
    }

    public void copyGoldenBlackKnifeMethod(GoldenBlackKnifeMethodCapability capability){
        this.goldenBlackKnifeMethodLevel = capability.goldenBlackKnifeMethodLevel;
        this.goldenBlackKnifeMethodComprehend = capability.goldenBlackKnifeMethodComprehend;
        this.goldenBlackKnifeMethodUseCount = capability.goldenBlackKnifeMethodUseCount;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("GoldenBlackKnifeMethodLevel", goldenBlackKnifeMethodLevel);
        nbt.putInt("GoldenBlackKnifeMethodUseCount", goldenBlackKnifeMethodUseCount);
        nbt.putBoolean("GoldenBlackKnifeMethodComprehend",goldenBlackKnifeMethodComprehend);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        goldenBlackKnifeMethodLevel = nbt.getInt("GoldenBlackKnifeMethodLevel");
        goldenBlackKnifeMethodUseCount = nbt.getInt("GoldenBlackKnifeMethodUseCount");
        goldenBlackKnifeMethodComprehend = nbt.getBoolean("GoldenBlackKnifeMethodComprehend");
    }
}
