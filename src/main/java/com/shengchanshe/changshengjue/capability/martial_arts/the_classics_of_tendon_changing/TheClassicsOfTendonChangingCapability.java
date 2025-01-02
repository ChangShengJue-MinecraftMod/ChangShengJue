package com.shengchanshe.changshengjue.capability.martial_arts.the_classics_of_tendon_changing;

import net.minecraft.nbt.CompoundTag;

public class TheClassicsOfTendonChangingCapability {
    private int theClassicsOfTendonChangingLevel = 0;
    private boolean theClassicsOfTendonChangingComprehend = false;
    private int theClassicsOfTendonChangingUseCount = 0;
    private float theClassicsOfTendonChangingToppedTick = 0;//技能领悟特效计时
    private float theClassicsOfTendonChangingDachengTick = 0;//技能领悟特效计时
    private boolean theClassicsOfTendonChangingParticle = false;//技能特效显示

    public boolean isTheClassicsOfTendonChangingComprehend() {
        return theClassicsOfTendonChangingComprehend;
    }

    public int getTheClassicsOfTendonChangingLevel() {
        return theClassicsOfTendonChangingLevel;
    }

    public int getTheClassicsOfTendonChangingUseCount() {
        return theClassicsOfTendonChangingUseCount;
    }

    public void addTheClassicsOfTendonChangingLevel(){
        this.theClassicsOfTendonChangingLevel = this.theClassicsOfTendonChangingUseCount >= 100 ? 2 : 1;
    }

    public void setTheClassicsOfTendonChangingComprehend(boolean theClassicsOfTendonChangingComprehend) {
        this.theClassicsOfTendonChangingComprehend = theClassicsOfTendonChangingComprehend;
    }

    public boolean theClassicsOfTendonChangingComprehend(){
        return this.theClassicsOfTendonChangingComprehend;
    }

    public void addTheClassicsOfTendonChangingUseCount(int theClassicsOfTendonChangingUseCount){
        this.theClassicsOfTendonChangingUseCount = this.theClassicsOfTendonChangingUseCount + theClassicsOfTendonChangingUseCount;
        if (this.theClassicsOfTendonChangingUseCount>=1000){
            this.addTheClassicsOfTendonChangingLevel();
        }
    }

    public float getTheClassicsOfTendonChangingToppedTick() {
        if (this.theClassicsOfTendonChangingParticle && this.theClassicsOfTendonChangingToppedTick >= 80){
            this.theClassicsOfTendonChangingToppedTick = 0;
            this.theClassicsOfTendonChangingParticle = false;
        }
        return theClassicsOfTendonChangingToppedTick;
    }
    public float setTheClassicsOfTendonChangingToppedTick() {
        return this.theClassicsOfTendonChangingToppedTick++;
    }

    public float getTheClassicsOfTendonChangingDachengTick() {
        if (this.theClassicsOfTendonChangingParticle && this.theClassicsOfTendonChangingDachengTick >= 30){
            this.theClassicsOfTendonChangingDachengTick = 0;
            this.theClassicsOfTendonChangingParticle = false;
        }
        return theClassicsOfTendonChangingDachengTick;
    }
    public float setTheClassicsOfTendonChangingDachengTick() {
        return this.theClassicsOfTendonChangingDachengTick++;
    }

    public void setTheClassicsOfTendonChangingParticle(boolean theClassicsOfTendonChangingParticle) {
        this.theClassicsOfTendonChangingParticle = theClassicsOfTendonChangingParticle;
    }
    public boolean isTheClassicsOfTendonChangingParticle(){
        return this.theClassicsOfTendonChangingParticle;
    }

    public void copyTheClassicsOfTendonChanging(TheClassicsOfTendonChangingCapability capability){
        this.theClassicsOfTendonChangingLevel = capability.theClassicsOfTendonChangingLevel;
        this.theClassicsOfTendonChangingComprehend = capability.theClassicsOfTendonChangingComprehend;
        this.theClassicsOfTendonChangingUseCount = capability.theClassicsOfTendonChangingUseCount;
        this.theClassicsOfTendonChangingToppedTick = capability.theClassicsOfTendonChangingToppedTick;
        this.theClassicsOfTendonChangingDachengTick = capability.theClassicsOfTendonChangingDachengTick;
        this.theClassicsOfTendonChangingParticle = capability.theClassicsOfTendonChangingParticle;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("TheClassicsOfTendonChangingLevel", theClassicsOfTendonChangingLevel);
        nbt.putInt("TheClassicsOfTendonChangingUseCount", theClassicsOfTendonChangingUseCount);
        nbt.putBoolean("TheClassicsOfTendonChangingComprehend",theClassicsOfTendonChangingComprehend);
        nbt.putFloat("TheClassicsOfTendonChangingToppedTick",theClassicsOfTendonChangingToppedTick);
        nbt.putFloat("TheClassicsOfTendonChangingDachengTick",theClassicsOfTendonChangingDachengTick);
        nbt.putBoolean("TheClassicsOfTendonChangingParticle",theClassicsOfTendonChangingParticle);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        theClassicsOfTendonChangingLevel = nbt.getInt("TheClassicsOfTendonChangingLevel");
        theClassicsOfTendonChangingUseCount = nbt.getInt("TheClassicsOfTendonChangingUseCount");
        theClassicsOfTendonChangingComprehend = nbt.getBoolean("TheClassicsOfTendonChangingComprehend");
        theClassicsOfTendonChangingToppedTick = nbt.getFloat("TheClassicsOfTendonChangingToppedTick");
        theClassicsOfTendonChangingDachengTick = nbt.getFloat("TheClassicsOfTendonChangingDachengTick");
        theClassicsOfTendonChangingParticle = nbt.getBoolean("TheClassicsOfTendonChangingParticle");
    }
}
