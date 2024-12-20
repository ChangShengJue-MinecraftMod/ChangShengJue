package com.shengchanshe.changshengjue.capability.martial_arts.paoding;

import net.minecraft.nbt.CompoundTag;

public class PaodingCapability {
    private int paodingLevel = 0;
    private boolean paodingComprehend = false;
    private int paodingUseCount = 0;
    private float paodingToppedTick = 0;//技能领悟特效计时
    private float paodingDachengTick = 0;//技能领悟特效计时
    private boolean paodingParticle = false;//技能特效显示

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
        this.paodingLevel = this.paodingUseCount >= 100 ? 2 : 1;
    }

    public void setPaodingComprehend(boolean paodingComprehend) {
        this.paodingComprehend = paodingComprehend;
    }

    public boolean paodingComprehend(){
        return this.paodingComprehend;
    }

    public void addPaodingUseCount(int paodingUseCount){
        this.paodingUseCount = this.paodingUseCount + paodingUseCount;
        if (this.paodingUseCount>=1000){
            this.addPaodingLevel();
        }
    }

    public float getPaodingToppedTick() {
        if (this.paodingParticle && this.paodingToppedTick >= 80){
            this.paodingToppedTick = 0;
            this.paodingParticle = false;
        }
        return paodingToppedTick;
    }
    public float setPaodingToppedTick() {
        return this.paodingToppedTick++;
    }

    public float getPaodingDachengTick() {
        if (this.paodingParticle && this.paodingDachengTick >= 30){
            this.paodingDachengTick = 0;
            this.paodingParticle = false;
        }
        return paodingDachengTick;
    }
    public float setPaodingDachengTick() {
        return this.paodingDachengTick++;
    }

    public void setPaodingParticle(boolean paodingParticle) {
        this.paodingParticle = paodingParticle;
    }
    public boolean isPaodingParticle(){
        return this.paodingParticle;
    }

    public void copyPaoding(PaodingCapability capability){
        this.paodingLevel = capability.paodingLevel;
        this.paodingComprehend = capability.paodingComprehend;
        this.paodingUseCount = capability.paodingUseCount;
        this.paodingToppedTick = capability.paodingToppedTick;
        this.paodingDachengTick = capability.paodingDachengTick;
        this.paodingParticle = capability.paodingParticle;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("PaodingLevel", paodingLevel);
        nbt.putInt("PaodingUseCount", paodingUseCount);
        nbt.putBoolean("PaodingComprehend",paodingComprehend);
        nbt.putFloat("PaodingToppedTick",paodingToppedTick);
        nbt.putFloat("PaodingDachengTick",paodingDachengTick);
        nbt.putBoolean("PaodingParticle",paodingParticle);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        paodingLevel = nbt.getInt("PaodingLevel");
        paodingUseCount = nbt.getInt("PaodingUseCount");
        paodingComprehend = nbt.getBoolean("PaodingComprehend");
        paodingToppedTick = nbt.getFloat("PaodingToppedTick");
        paodingDachengTick = nbt.getFloat("PaodingDachengTick");
        paodingParticle = nbt.getBoolean("PaodingParticle");
    }
}
