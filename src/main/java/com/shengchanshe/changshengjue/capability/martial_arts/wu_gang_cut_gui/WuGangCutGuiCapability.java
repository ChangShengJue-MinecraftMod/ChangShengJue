package com.shengchanshe.changshengjue.capability.martial_arts.wu_gang_cut_gui;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;

public class WuGangCutGuiCapability {
    private int wuGangCutGuiLevel = 0;
    private boolean wuGangCutGuiComprehend = false;
    private int wuGangCutGuiUseCount = 0;
    private float wuGangCutGuiToppedTick = 0;//技能领悟特效计时
    private float wuGangCutGuiDachengTick = 0;//技能领悟特效计时
    private boolean wuGangCutGuiParticle = false;//技能特效显示

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

    public void addWuGangCutGuiUseCount(int wuGangCutGuiUseCount){
        this.wuGangCutGuiUseCount = this.wuGangCutGuiUseCount + wuGangCutGuiUseCount;
        if (this.wuGangCutGuiUseCount >= 1000){
            this.addWuGangCutGuiLevel();
        }
    }

    public float getWuGangCutGuiToppedTick() {
        if (this.wuGangCutGuiParticle && this.wuGangCutGuiToppedTick >= 80){
            this.wuGangCutGuiToppedTick = 0;
            this.wuGangCutGuiParticle = false;
        }
        return wuGangCutGuiToppedTick;
    }
    public float setWuGangCutGuiToppedTick() {
        return this.wuGangCutGuiToppedTick++;
    }

    public float getWuGangCutGuiDachengTick() {
        if (this.wuGangCutGuiParticle && this.wuGangCutGuiDachengTick >= 30){
            this.wuGangCutGuiDachengTick = 0;
            this.wuGangCutGuiParticle = false;
        }
        return wuGangCutGuiDachengTick;
    }
    public float setWuGangCutGuiDachengTick() {
        return this.wuGangCutGuiDachengTick++;
    }

    public void setWuGangCutGuiParticle(boolean wuGangCutGuiParticle) {
        this.wuGangCutGuiParticle = wuGangCutGuiParticle;
    }
    public boolean isWuGangCutGuiParticle(){
        return this.wuGangCutGuiParticle;
    }

    public void copyWuGangCutGui(WuGangCutGuiCapability capability){
        this.wuGangCutGuiLevel = capability.wuGangCutGuiLevel;
        this.wuGangCutGuiComprehend = capability.wuGangCutGuiComprehend;
        this.wuGangCutGuiUseCount = capability.wuGangCutGuiUseCount;
        this.wuGangCutGuiToppedTick = capability.wuGangCutGuiToppedTick;
        this.wuGangCutGuiDachengTick = capability.wuGangCutGuiDachengTick;
        this.wuGangCutGuiParticle = capability.wuGangCutGuiParticle;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("WuGangCutGuiLevel", wuGangCutGuiLevel);
        nbt.putInt("WuGangCutGuiUseCount", wuGangCutGuiUseCount);
        nbt.putBoolean("WuGangCutGuiComprehend",wuGangCutGuiComprehend);
        nbt.putFloat("WuGangCutGuiToppedTick",wuGangCutGuiToppedTick);
        nbt.putFloat("WuGangCutGuiDachengTick",wuGangCutGuiDachengTick);
        nbt.putBoolean("WuGangCutGuiParticle",wuGangCutGuiParticle);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        wuGangCutGuiLevel = nbt.getInt("WuGangCutGuiLevel");
        wuGangCutGuiUseCount = nbt.getInt("WuGangCutGuiUseCount");
        wuGangCutGuiComprehend = nbt.getBoolean("WuGangCutGuiComprehend");
        wuGangCutGuiToppedTick = nbt.getFloat("WuGangCutGuiToppedTick");
        wuGangCutGuiDachengTick = nbt.getFloat("WuGangCutGuiDachengTick");
        wuGangCutGuiParticle = nbt.getBoolean("WuGangCutGuiParticle");
    }
}
