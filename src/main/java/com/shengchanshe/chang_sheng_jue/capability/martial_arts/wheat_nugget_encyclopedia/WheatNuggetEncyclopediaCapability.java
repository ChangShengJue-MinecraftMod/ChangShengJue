package com.shengchanshe.chang_sheng_jue.capability.martial_arts.wheat_nugget_encyclopedia;

import net.minecraft.nbt.CompoundTag;

public class WheatNuggetEncyclopediaCapability {
    private int wheatNuggetEncyclopediaLevel = 0;//技能等级
    private boolean wheatNuggetEncyclopediaComprehend = false;//是否领悟
    private int wheatNuggetEncyclopediaUseCount = 0;//使用次数
    private int wheatNuggetEncyclopediaToppedTick = 0;//技能领悟特效计时
    private int wheatNuggetEncyclopediaDachengTick = 0;//技能大成特效计时
    private boolean wheatNuggetEncyclopediaParticle = false;//技能特效显示

    public int getWheatNuggetEncyclopediaLevel() {
        return wheatNuggetEncyclopediaLevel;
    }
    public int getWheatNuggetEncyclopediaUseCount() {
        return wheatNuggetEncyclopediaUseCount;
    }
    public void addWheatNuggetEncyclopediaLevel(){
        this.wheatNuggetEncyclopediaLevel = this.wheatNuggetEncyclopediaUseCount >= 100 ? 2 : 1;
    }

    public boolean isWheatNuggetEncyclopediaComprehend() {
        return wheatNuggetEncyclopediaComprehend;
    }
    public void setWheatNuggetEncyclopediaComprehend(boolean wheatNuggetEncyclopediaComprehend) {
        this.wheatNuggetEncyclopediaComprehend = wheatNuggetEncyclopediaComprehend;
    }

    public void addWheatNuggetEncyclopediaUseCount(int wheatNuggetEncyclopediaUseCount){
        this.wheatNuggetEncyclopediaUseCount = this.wheatNuggetEncyclopediaUseCount + wheatNuggetEncyclopediaUseCount;
        if (this.wheatNuggetEncyclopediaUseCount>=100){
            this.addWheatNuggetEncyclopediaLevel();
        }
    }

    public int getWheatNuggetEncyclopediaToppedTick() {
        if (this.wheatNuggetEncyclopediaParticle && this.wheatNuggetEncyclopediaToppedTick >= 80){
            this.wheatNuggetEncyclopediaToppedTick = 0;
            this.wheatNuggetEncyclopediaParticle = false;
        }
        return wheatNuggetEncyclopediaToppedTick;
    }
    public int setWheatNuggetEncyclopediaToppedTick() {
        return this.wheatNuggetEncyclopediaToppedTick++;
    }

    public int getWheatNuggetEncyclopediaDachengTick() {
        if (this.wheatNuggetEncyclopediaParticle && this.wheatNuggetEncyclopediaDachengTick >= 30){
            this.wheatNuggetEncyclopediaDachengTick = 0;
            this.wheatNuggetEncyclopediaParticle = false;
        }
        return wheatNuggetEncyclopediaDachengTick;
    }
    public int setWheatNuggetEncyclopediaDachengTick() {
        return this.wheatNuggetEncyclopediaDachengTick++;
    }

    public void setWheatNuggetEncyclopediaParticle(boolean wheatNuggetEncyclopediaParticle) {
        this.wheatNuggetEncyclopediaParticle = wheatNuggetEncyclopediaParticle;
    }
    public boolean isWheatNuggetEncyclopediaParticle(){
        return this.wheatNuggetEncyclopediaParticle;
    }

    public void copyWheatNuggetEncyclopedia(WheatNuggetEncyclopediaCapability capability){
        this.wheatNuggetEncyclopediaLevel = capability.wheatNuggetEncyclopediaLevel;
        this.wheatNuggetEncyclopediaComprehend = capability.wheatNuggetEncyclopediaComprehend;
        this.wheatNuggetEncyclopediaUseCount = capability.wheatNuggetEncyclopediaUseCount;
        this.wheatNuggetEncyclopediaToppedTick = capability.wheatNuggetEncyclopediaToppedTick;
        this.wheatNuggetEncyclopediaDachengTick = capability.wheatNuggetEncyclopediaDachengTick;
        this.wheatNuggetEncyclopediaParticle = capability.wheatNuggetEncyclopediaParticle;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("WheatNuggetEncyclopediaLevel", wheatNuggetEncyclopediaLevel);
        nbt.putInt("WheatNuggetEncyclopediaUseCount", wheatNuggetEncyclopediaUseCount);
        nbt.putBoolean("WheatNuggetEncyclopediaComprehend",wheatNuggetEncyclopediaComprehend);
        nbt.putInt("WheatNuggetEncyclopediaToppedTick",wheatNuggetEncyclopediaToppedTick);
        nbt.putInt("WheatNuggetEncyclopediaDachengTick",wheatNuggetEncyclopediaDachengTick);
        nbt.putBoolean("WheatNuggetEncyclopediaParticle",wheatNuggetEncyclopediaParticle);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        wheatNuggetEncyclopediaLevel = nbt.getInt("WheatNuggetEncyclopediaLevel");
        wheatNuggetEncyclopediaUseCount = nbt.getInt("WheatNuggetEncyclopediaUseCount");
        wheatNuggetEncyclopediaComprehend = nbt.getBoolean("WheatNuggetEncyclopediaComprehend");
        wheatNuggetEncyclopediaToppedTick = nbt.getInt("WheatNuggetEncyclopediaToppedTick");
        wheatNuggetEncyclopediaDachengTick = nbt.getInt("WheatNuggetEncyclopediaDachengTick");
        wheatNuggetEncyclopediaParticle = nbt.getBoolean("WheatNuggetEncyclopediaParticle");
    }
}
