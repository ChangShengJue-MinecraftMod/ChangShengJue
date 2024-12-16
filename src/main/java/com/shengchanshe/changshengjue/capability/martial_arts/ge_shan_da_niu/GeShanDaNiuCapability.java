package com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu;

import net.minecraft.nbt.CompoundTag;

public class GeShanDaNiuCapability {
    private int geShanDaNiuLevel = 0;//技能等级
    private boolean geShanDaNiuComprehend = false;//是否领悟
    private int geShanDaNiuUseCount = 0;//使用次数
    private float geShanDaNiuUseCooldownPercent = 0;//技能冷却
    private boolean geShanDaNiuOff = false;//技能是否启用
    private float geShanDaNiuToppedTick = 0;//技能领悟特效计时
    private float geShanDaNiuDachengTick = 0;//技能领悟特效计时
    private boolean geShanDaNiuParticle = false;//技能特效显示
    private float geShanDaNiuUseCooldownPercentMax = 200;//技能总冷却时间

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

    public float getGeShanDaNiuUseCooldownPercent() {
        return geShanDaNiuUseCooldownPercent;
    }
    public float setGeShanDaNiuUseCooldownPercent() {
        return this.geShanDaNiuUseCooldownPercent--;
    }
    public void setGeShanDaNiuUseCooldownPercent(float geShanDaNiuUseCooldownPercent) {
        this.geShanDaNiuUseCooldownPercent = geShanDaNiuUseCooldownPercent;
    }

    public float getGeShanDaNiuUseCooldownPercentMax() {
        return geShanDaNiuUseCooldownPercentMax;
    }
    public float setGeShanDaNiuUseCooldownPercentMax(float geShanDaNiuUseCooldownPercentMax) {
        return this.geShanDaNiuUseCooldownPercentMax = geShanDaNiuUseCooldownPercentMax;
    }

    public void setGeShanDaNiuOff(boolean geShanDaNiuOff) {
        this.geShanDaNiuOff = geShanDaNiuOff;
    }
    public boolean isGeShanDaNiuOff(){
        return this.geShanDaNiuOff;
    }

    public float getGeShanDaNiuToppedTick() {
        if (this.geShanDaNiuParticle && this.geShanDaNiuToppedTick >= 80){
            this.geShanDaNiuToppedTick = 0;
            this.geShanDaNiuParticle = false;
        }
        return geShanDaNiuToppedTick;
    }
    public float setGeShanDaNiuToppedTick() {
        return this.geShanDaNiuToppedTick++;
    }

    public float getGeShanDaNiuDachengTick() {
        if (this.geShanDaNiuParticle && this.geShanDaNiuDachengTick >= 30){
            this.geShanDaNiuDachengTick = 0;
            this.geShanDaNiuParticle = false;
        }
        return geShanDaNiuDachengTick;
    }
    public float setGeShanDaNiuDachengTick() {
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
        nbt.putFloat("GeShanDaNiuUseCooldownPercent",geShanDaNiuUseCooldownPercent);
        nbt.putBoolean("GeShanDaNiuOff",geShanDaNiuOff);
        nbt.putFloat("GeShanDaNiuToppedTick",geShanDaNiuToppedTick);
        nbt.putFloat("GeShanDaNiuDachengTick",geShanDaNiuDachengTick);
        nbt.putBoolean("GeShanDaNiuParticle",geShanDaNiuParticle);
        nbt.putFloat("GeShanDaNiuUseCooldownPercentMax",geShanDaNiuUseCooldownPercentMax);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        geShanDaNiuLevel = nbt.getInt("GeShanDaNiuLevel");
        geShanDaNiuUseCount = nbt.getInt("GeShanDaNiuUseCount");
        geShanDaNiuUseCooldownPercent = nbt.getFloat("GeShanDaNiuUseCooldownPercent");
        geShanDaNiuComprehend = nbt.getBoolean("GeShanDaNiuComprehend");
        geShanDaNiuOff = nbt.getBoolean("GeShanDaNiuOff");
        geShanDaNiuToppedTick = nbt.getFloat("GeShanDaNiuToppedTick");
        geShanDaNiuDachengTick = nbt.getFloat("GeShanDaNiuDachengTick");
        geShanDaNiuParticle = nbt.getBoolean("GeShanDaNiuParticle");
        geShanDaNiuUseCooldownPercentMax = nbt.getFloat("GeShanDaNiuUseCooldownPercentMax");
    }
}
