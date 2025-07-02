package com.shengchanshe.chang_sheng_jue.capability.martial_arts.gao_marksmanship;

import net.minecraft.nbt.CompoundTag;

public class GaoMarksmanshipCapability {
    private int gaoMarksmanshipLevel = 0;
    private boolean gaoMarksmanshipComprehend = false;
    private int gaoMarksmanshipUseCount = 0;
    private float gaoMarksmanshipToppedTick = 0;//技能领悟特效计时
    private float gaoMarksmanshipDachengTick = 0;//技能领悟特效计时
    private boolean gaoMarksmanshipParticle = false;//技能特效显示

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

    public void addGaoMarksmanshipUseCount(int gaoMarksmanshipUseCount){
        this.gaoMarksmanshipUseCount = this.gaoMarksmanshipUseCount + gaoMarksmanshipUseCount;
        if (this.gaoMarksmanshipUseCount>=100){
            this.addGaoMarksmanshipLevel();
        }
    }

    public float getGaoMarksmanshipToppedTick() {
        if (this.gaoMarksmanshipParticle && this.gaoMarksmanshipToppedTick >= 80){
            this.gaoMarksmanshipToppedTick = 0;
            this.gaoMarksmanshipParticle = false;
        }
        return gaoMarksmanshipToppedTick;
    }
    public float setGaoMarksmanshipToppedTick() {
        return this.gaoMarksmanshipToppedTick++;
    }

    public float getGaoMarksmanshipDachengTick() {
        if (this.gaoMarksmanshipParticle && this.gaoMarksmanshipDachengTick >= 30){
            this.gaoMarksmanshipDachengTick = 0;
            this.gaoMarksmanshipParticle = false;
        }
        return gaoMarksmanshipDachengTick;
    }
    public float setGaoMarksmanshipDachengTick() {
        return this.gaoMarksmanshipDachengTick++;
    }

    public void setGaoMarksmanshipParticle(boolean gaoMarksmanshipParticle) {
        this.gaoMarksmanshipParticle = gaoMarksmanshipParticle;
    }
    public boolean isGaoMarksmanshipParticle(){
        return this.gaoMarksmanshipParticle;
    }

    public void copyGaoMarksmanship(GaoMarksmanshipCapability capability){
        this.gaoMarksmanshipLevel = capability.gaoMarksmanshipLevel;
        this.gaoMarksmanshipComprehend = capability.gaoMarksmanshipComprehend;
        this.gaoMarksmanshipUseCount = capability.gaoMarksmanshipUseCount;
        this.gaoMarksmanshipToppedTick = capability.gaoMarksmanshipToppedTick;
        this.gaoMarksmanshipDachengTick = capability.gaoMarksmanshipDachengTick;
        this.gaoMarksmanshipParticle = capability.gaoMarksmanshipParticle;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("GaoMarksmanshipLevel", gaoMarksmanshipLevel);
        nbt.putInt("GaoMarksmanshipUseCount", gaoMarksmanshipUseCount);
        nbt.putBoolean("GaoMarksmanshipComprehend",gaoMarksmanshipComprehend);
        nbt.putFloat("GaoMarksmanshipToppedTick",gaoMarksmanshipToppedTick);
        nbt.putFloat("GaoMarksmanshipDachengTick",gaoMarksmanshipDachengTick);
        nbt.putBoolean("GaoMarksmanshipParticle",gaoMarksmanshipParticle);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        gaoMarksmanshipLevel = nbt.getInt("GaoMarksmanshipLevel");
        gaoMarksmanshipUseCount = nbt.getInt("GaoMarksmanshipUseCount");
        gaoMarksmanshipComprehend = nbt.getBoolean("GaoMarksmanshipComprehend");
        gaoMarksmanshipToppedTick = nbt.getFloat("GaoMarksmanshipToppedTick");
        gaoMarksmanshipDachengTick = nbt.getFloat("GaoMarksmanshipDachengTick");
        gaoMarksmanshipParticle = nbt.getBoolean("GaoMarksmanshipParticle");
    }
}
