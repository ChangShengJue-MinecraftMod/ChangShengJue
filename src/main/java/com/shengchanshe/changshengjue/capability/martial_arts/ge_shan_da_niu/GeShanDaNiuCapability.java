package com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu;

import net.minecraft.nbt.CompoundTag;

public class GeShanDaNiuCapability {
    private int geShanDaNiuLevel = 0;//技能等级
    private boolean geShanDaNiuComprehend = false;//是否领悟
    private int geShanDaNiuUseCount = 0;//使用次数
    private int geShanDaNiuUseCooldownPercent = 0;//技能冷却
    private boolean geShanDaNiuOff = false;//技能是否启用
    private int geShanDaNiuToppedTick = 0;//技能领悟特效计时
    private int geShanDaNiuDachengTick = 0;//技能领悟特效计时
    private boolean geShanDaNiuParticle = false;//技能特效显示
    private int geShanDaNiuUseCooldownPercentMax = 200;//技能总冷却时间

    public int getGeShanDaNiuLevel() {
        return geShanDaNiuLevel;
    }
    public int getGeShanDaNiuUseCount() {
        return geShanDaNiuUseCount;
    }
    public void addGeShanDaNiuLevel(){
        this.geShanDaNiuLevel = this.geShanDaNiuUseCount >= 100 ? 2 : 1;
    }

    public boolean isGeShanDaNiuComprehend() {
        return geShanDaNiuComprehend;
    }
    public void setGeShanDaNiuComprehend(boolean geShanDaNiuComprehend) {
        this.geShanDaNiuComprehend = geShanDaNiuComprehend;
    }

    public void addGeShanDaNiuUseCount(int geShanDaNiuUseCount){
        this.geShanDaNiuUseCount = this.geShanDaNiuUseCount + geShanDaNiuUseCount;
        if (this.geShanDaNiuUseCount>=100){
            this.addGeShanDaNiuLevel();
        }
    }

    public int getGeShanDaNiuUseCooldownPercent() {
        return geShanDaNiuUseCooldownPercent;
    }
    public int setGeShanDaNiuUseCooldownPercent() {
        return this.geShanDaNiuUseCooldownPercent--;
    }
    public void setGeShanDaNiuUseCooldownPercent(int geShanDaNiuUseCooldownPercent) {
        this.geShanDaNiuUseCooldownPercent = geShanDaNiuUseCooldownPercent;
    }

    public int getGeShanDaNiuUseCooldownPercentMax() {
        return geShanDaNiuUseCooldownPercentMax;
    }
    public int setGeShanDaNiuUseCooldownPercentMax(int geShanDaNiuUseCooldownPercentMax) {
        return this.geShanDaNiuUseCooldownPercentMax = geShanDaNiuUseCooldownPercentMax;
    }

    public void setGeShanDaNiuOff(boolean geShanDaNiuOff) {
        this.geShanDaNiuOff = geShanDaNiuOff;
    }
    public boolean isGeShanDaNiuOff(){
        return this.geShanDaNiuOff;
    }

    public int getGeShanDaNiuToppedTick() {
        if (this.geShanDaNiuParticle && this.geShanDaNiuToppedTick >= 80){
            this.geShanDaNiuToppedTick = 0;
            this.geShanDaNiuParticle = false;
        }
        return geShanDaNiuToppedTick;
    }
    public int setGeShanDaNiuToppedTick() {
        return this.geShanDaNiuToppedTick++;
    }

    public int getGeShanDaNiuDachengTick() {
        if (this.geShanDaNiuParticle && this.geShanDaNiuDachengTick >= 30){
            this.geShanDaNiuDachengTick = 0;
            this.geShanDaNiuParticle = false;
        }
        return geShanDaNiuDachengTick;
    }
    public int setGeShanDaNiuDachengTick() {
        return this.geShanDaNiuDachengTick++;
    }

    public void setGeShanDaNiuParticle(boolean geShanDaNiuParticle) {
        this.geShanDaNiuParticle = geShanDaNiuParticle;
    }
    public boolean isGeShanDaNiuParticle(){
        return this.geShanDaNiuParticle;
    }

    public void copyGeShanDaNiu(GeShanDaNiuCapability capability){
        this.geShanDaNiuLevel = capability.geShanDaNiuLevel;
        this.geShanDaNiuComprehend = capability.geShanDaNiuComprehend;
        this.geShanDaNiuUseCount = capability.geShanDaNiuUseCount;
        this.geShanDaNiuUseCooldownPercent = capability.geShanDaNiuUseCooldownPercent;
        this.geShanDaNiuOff = capability.geShanDaNiuOff;
        this.geShanDaNiuToppedTick = capability.geShanDaNiuToppedTick;
        this.geShanDaNiuDachengTick = capability.geShanDaNiuDachengTick;
        this.geShanDaNiuParticle = capability.geShanDaNiuParticle;
        this.geShanDaNiuUseCooldownPercentMax = capability.geShanDaNiuUseCooldownPercentMax;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("GeShanDaNiuLevel", geShanDaNiuLevel);
        nbt.putInt("GeShanDaNiuUseCount", geShanDaNiuUseCount);
        nbt.putBoolean("GeShanDaNiuComprehend",geShanDaNiuComprehend);
        nbt.putInt("GeShanDaNiuUseCooldownPercent",geShanDaNiuUseCooldownPercent);
        nbt.putBoolean("GeShanDaNiuOff",geShanDaNiuOff);
        nbt.putInt("GeShanDaNiuToppedTick",geShanDaNiuToppedTick);
        nbt.putInt("GeShanDaNiuDachengTick",geShanDaNiuDachengTick);
        nbt.putBoolean("GeShanDaNiuParticle",geShanDaNiuParticle);
        nbt.putInt("GeShanDaNiuUseCooldownPercentMax",geShanDaNiuUseCooldownPercentMax);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        geShanDaNiuLevel = nbt.getInt("GeShanDaNiuLevel");
        geShanDaNiuUseCount = nbt.getInt("GeShanDaNiuUseCount");
        geShanDaNiuUseCooldownPercent = nbt.getInt("GeShanDaNiuUseCooldownPercent");
        geShanDaNiuComprehend = nbt.getBoolean("GeShanDaNiuComprehend");
        geShanDaNiuOff = nbt.getBoolean("GeShanDaNiuOff");
        geShanDaNiuToppedTick = nbt.getInt("GeShanDaNiuToppedTick");
        geShanDaNiuDachengTick = nbt.getInt("GeShanDaNiuDachengTick");
        geShanDaNiuParticle = nbt.getBoolean("GeShanDaNiuParticle");
        geShanDaNiuUseCooldownPercentMax = nbt.getInt("GeShanDaNiuUseCooldownPercentMax");
    }
}
