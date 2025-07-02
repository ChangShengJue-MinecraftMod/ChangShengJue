package com.shengchanshe.chang_sheng_jue.capability.martial_arts.golden_black_knife_method;

import net.minecraft.nbt.CompoundTag;

public class GoldenBlackKnifeMethodCapability {
    private int goldenBlackKnifeMethodLevel = 0;
    private boolean goldenBlackKnifeMethodComprehend = false;
    private int goldenBlackKnifeMethodUseCount = 0;
    private float goldenBlackKnifeMethodToppedTick = 0;//技能领悟特效计时
    private float goldenBlackKnifeMethodDachengTick = 0;//技能领悟特效计时
    private boolean goldenBlackKnifeMethodParticle = false;//技能特效显示

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

    public void addGoldenBlackKnifeMethodUseCount(int goldenBlackKnifeMethodUseCount){
        this.goldenBlackKnifeMethodUseCount = this.goldenBlackKnifeMethodUseCount + goldenBlackKnifeMethodUseCount;
        if (this.goldenBlackKnifeMethodUseCount>=100){
            this.addGoldenBlackKnifeMethodLevel();
        }
    }

    public float getGoldenBlackKnifeMethodToppedTick() {
        if (this.goldenBlackKnifeMethodParticle && this.goldenBlackKnifeMethodToppedTick >= 80){
            this.goldenBlackKnifeMethodToppedTick = 0;
            this.goldenBlackKnifeMethodParticle = false;
        }
        return goldenBlackKnifeMethodToppedTick;
    }
    public float setGoldenBlackKnifeMethodToppedTick() {
        return this.goldenBlackKnifeMethodToppedTick++;
    }

    public float getGoldenBlackKnifeMethodDachengTick() {
        if (this.goldenBlackKnifeMethodParticle && this.goldenBlackKnifeMethodDachengTick >= 30){
            this.goldenBlackKnifeMethodDachengTick = 0;
            this.goldenBlackKnifeMethodParticle = false;
        }
        return goldenBlackKnifeMethodDachengTick;
    }
    public float setGoldenBlackKnifeMethodDachengTick() {
        return this.goldenBlackKnifeMethodDachengTick++;
    }

    public void setGoldenBlackKnifeMethodParticle(boolean goldenBlackKnifeMethodParticle) {
        this.goldenBlackKnifeMethodParticle = goldenBlackKnifeMethodParticle;
    }
    public boolean isGoldenBlackKnifeMethodParticle(){
        return this.goldenBlackKnifeMethodParticle;
    }

    public void copyGoldenBlackKnifeMethod(GoldenBlackKnifeMethodCapability capability){
        this.goldenBlackKnifeMethodLevel = capability.goldenBlackKnifeMethodLevel;
        this.goldenBlackKnifeMethodComprehend = capability.goldenBlackKnifeMethodComprehend;
        this.goldenBlackKnifeMethodUseCount = capability.goldenBlackKnifeMethodUseCount;
        this.goldenBlackKnifeMethodToppedTick = capability.goldenBlackKnifeMethodToppedTick;
        this.goldenBlackKnifeMethodDachengTick = capability.goldenBlackKnifeMethodDachengTick;
        this.goldenBlackKnifeMethodParticle = capability.goldenBlackKnifeMethodParticle;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("GoldenBlackKnifeMethodLevel", goldenBlackKnifeMethodLevel);
        nbt.putInt("GoldenBlackKnifeMethodUseCount", goldenBlackKnifeMethodUseCount);
        nbt.putBoolean("GoldenBlackKnifeMethodComprehend",goldenBlackKnifeMethodComprehend);
        nbt.putFloat("GoldenBlackKnifeMethodToppedTick",goldenBlackKnifeMethodToppedTick);
        nbt.putFloat("GoldenBlackKnifeMethodDachengTick",goldenBlackKnifeMethodDachengTick);
        nbt.putBoolean("GoldenBlackKnifeMethodParticle",goldenBlackKnifeMethodParticle);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        goldenBlackKnifeMethodLevel = nbt.getInt("GoldenBlackKnifeMethodLevel");
        goldenBlackKnifeMethodUseCount = nbt.getInt("GoldenBlackKnifeMethodUseCount");
        goldenBlackKnifeMethodComprehend = nbt.getBoolean("GoldenBlackKnifeMethodComprehend");
        goldenBlackKnifeMethodToppedTick = nbt.getFloat("GoldenBlackKnifeMethodToppedTick");
        goldenBlackKnifeMethodDachengTick = nbt.getFloat("GoldenBlackKnifeMethodDachengTick");
        goldenBlackKnifeMethodParticle = nbt.getBoolean("GoldenBlackKnifeMethodParticle");
    }
}
