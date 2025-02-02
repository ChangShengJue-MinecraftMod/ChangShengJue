package com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu;

import net.minecraft.nbt.CompoundTag;

public class GeShanDaNiuCapability {
    private int geShanDaNiuLevel = 0;//技能等级
    private boolean geShanDaNiuComprehend = false;//是否领悟
    private int geShanDaNiuUseCount = 0;//使用次数
    private float geShanDaNiuUseCooldownPercent = 0;//技能冷却
    private float geShanDaNiuToppedTick = 0;//技能领悟特效计时
    private float geShanDaNiuDachengTick = 0;//技能领悟特效计时
    private boolean geShanDaNiuParticle = false;//技能特效显示
    private float geShanDaNiuUseCooldownPercentMax = 200;//技能总冷却时间
    // 技能状态
    private boolean skillZActive = false;
    private boolean skillXActive = false;
    private boolean skillCActive = false;

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

    public boolean isSkillZActive() {
        return skillZActive;
    }

    public void setSkillZActive(boolean skillZActive) {
        this.skillZActive = skillZActive;
    }

    public boolean isSkillXActive() {
        return skillXActive;
    }

    public void setSkillXActive(boolean skillXActive) {
        this.skillXActive = skillXActive;
    }

    public boolean isSkillCActive() {
        return skillCActive;
    }

    public void setSkillCActive(boolean skillCActive) {
        this.skillCActive = skillCActive;
    }
    public void copyGeShanDaNiu(GeShanDaNiuCapability capability){
        this.geShanDaNiuLevel = capability.geShanDaNiuLevel;
        this.geShanDaNiuComprehend = capability.geShanDaNiuComprehend;
        this.geShanDaNiuUseCount = capability.geShanDaNiuUseCount;
        this.geShanDaNiuUseCooldownPercent = capability.geShanDaNiuUseCooldownPercent;
        this.geShanDaNiuToppedTick = capability.geShanDaNiuToppedTick;
        this.geShanDaNiuDachengTick = capability.geShanDaNiuDachengTick;
        this.geShanDaNiuParticle = capability.geShanDaNiuParticle;
        this.geShanDaNiuUseCooldownPercentMax = capability.geShanDaNiuUseCooldownPercentMax;
        this.skillZActive = capability.skillZActive;
        this.skillXActive = capability.skillXActive;
        this.skillCActive = capability.skillCActive;
    }
    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("GeShanDaNiuLevel", geShanDaNiuLevel);
        nbt.putInt("GeShanDaNiuUseCount", geShanDaNiuUseCount);
        nbt.putBoolean("GeShanDaNiuComprehend",geShanDaNiuComprehend);
        nbt.putFloat("GeShanDaNiuUseCooldownPercent",geShanDaNiuUseCooldownPercent);
        nbt.putFloat("GeShanDaNiuToppedTick",geShanDaNiuToppedTick);
        nbt.putFloat("GeShanDaNiuDachengTick",geShanDaNiuDachengTick);
        nbt.putBoolean("GeShanDaNiuParticle",geShanDaNiuParticle);
        nbt.putFloat("GeShanDaNiuUseCooldownPercentMax",geShanDaNiuUseCooldownPercentMax);
        nbt.putBoolean("SkillZActive", skillZActive);
        nbt.putBoolean("SkillXActive", skillXActive);
        nbt.putBoolean("SkillCActive", skillCActive);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        geShanDaNiuLevel = nbt.getInt("GeShanDaNiuLevel");
        geShanDaNiuUseCount = nbt.getInt("GeShanDaNiuUseCount");
        geShanDaNiuUseCooldownPercent = nbt.getFloat("GeShanDaNiuUseCooldownPercent");
        geShanDaNiuComprehend = nbt.getBoolean("GeShanDaNiuComprehend");
        geShanDaNiuToppedTick = nbt.getFloat("GeShanDaNiuToppedTick");
        geShanDaNiuDachengTick = nbt.getFloat("GeShanDaNiuDachengTick");
        geShanDaNiuParticle = nbt.getBoolean("GeShanDaNiuParticle");
        geShanDaNiuUseCooldownPercentMax = nbt.getFloat("GeShanDaNiuUseCooldownPercentMax");
        skillZActive = nbt.getBoolean("SkillZActive");
        skillXActive = nbt.getBoolean("SkillXActive");
        skillCActive = nbt.getBoolean("SkillCActive");
    }
}
