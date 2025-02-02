package com.shengchanshe.changshengjue.capability.martial_arts.qian_kun_da_nuo_yi;

import net.minecraft.nbt.CompoundTag;

public class QianKunDaNuoYiCapability {
    private int qianKunDaNuoYiLevel = 0;//技能等级
    private boolean qianKunDaNuoYiComprehend = false;//是否领悟
    private int qianKunDaNuoYiUseCount = 0;//使用次数
    private float qianKunDaNuoYiUseCooldownPercent = 0;//技能冷却
    private boolean qianKunDaNuoYiOff = false;//技能是否启用
    private float qianKunDaNuoYiToppedTick = 0;//技能领悟特效计时
    private float qianKunDaNuoYiDachengTick = 0;//技能领悟特效计时
    private boolean qianKunDaNuoYiParticle = false;//技能特效显示
    private float qianKunDaNuoYiUseCooldownMax = 60;
    private float qianKunDaNuoYiUseCooldownMaxAdd = 0;
    // 技能状态
    private boolean skillZActive = false;
    private boolean skillXActive = false;
    private boolean skillCActive = false;

    public int getQianKunDaNuoYiLevel() {
        return qianKunDaNuoYiLevel;
    }
    public int getQianKunDaNuoYiUseCount() {
        return qianKunDaNuoYiUseCount;
    }
    public void addQianKunDaNuoYiLevel(){
        this.qianKunDaNuoYiLevel = this.qianKunDaNuoYiUseCount >= 100 ? 2 : 1;
    }

    public boolean isQianKunDaNuoYiComprehend() {
        return qianKunDaNuoYiComprehend;
    }
    public void setQianKunDaNuoYiComprehend(boolean qianKunDaNuoYiComprehend) {
        this.qianKunDaNuoYiComprehend = qianKunDaNuoYiComprehend;
    }

    public void addQianKunDaNuoYiUseCount(int qianKunDaNuoYiUseCount){
        this.qianKunDaNuoYiUseCount = this.qianKunDaNuoYiUseCount + qianKunDaNuoYiUseCount;
        if (this.qianKunDaNuoYiUseCount >= 100){
            this.addQianKunDaNuoYiLevel();
        }
    }

    public float getQianKunDaNuoYiUseCooldownPercent() {
        return qianKunDaNuoYiUseCooldownPercent;
    }
    public float setQianKunDaNuoYiUseCooldownPercent() {
        return this.qianKunDaNuoYiUseCooldownPercent--;
    }
    public void setQianKunDaNuoYiUseCooldownPercent(float qianKunDaNuoYiUseCooldownPercent) {
        this.qianKunDaNuoYiUseCooldownPercent = qianKunDaNuoYiUseCooldownPercent;
    }

    public void setQianKunDaNuoYiOff(boolean qianKunDaNuoYiOff) {
        this.qianKunDaNuoYiOff = qianKunDaNuoYiOff;
    }
    public boolean isQianKunDaNuoYiOff(){
        return this.qianKunDaNuoYiOff;
    }

    public float getQianKunDaNuoYiToppedTick() {
        if (this.qianKunDaNuoYiParticle && this.qianKunDaNuoYiToppedTick >= 80){
            this.qianKunDaNuoYiToppedTick = 0;
            this.qianKunDaNuoYiParticle = false;
        }
        return qianKunDaNuoYiToppedTick;
    }
    public float setQianKunDaNuoYiToppedTick() {
        return this.qianKunDaNuoYiToppedTick++;
    }

    public float getQianKunDaNuoYiDachengTick() {
        if (this.qianKunDaNuoYiParticle && this.qianKunDaNuoYiDachengTick >= 30){
            this.qianKunDaNuoYiDachengTick = 0;
            this.qianKunDaNuoYiParticle = false;
        }
        return qianKunDaNuoYiDachengTick;
    }
    public float setQianKunDaNuoYiDachengTick() {
        return this.qianKunDaNuoYiDachengTick++;
    }

    public void setQianKunDaNuoYiParticle(boolean qianKunDaNuoYiParticle) {
        this.qianKunDaNuoYiParticle = qianKunDaNuoYiParticle;
    }
    public boolean isQianKunDaNuoYiParticle(){
        return this.qianKunDaNuoYiParticle;
    }

    public float getQianKunDaNuoYiUseCooldownMax() {
        return qianKunDaNuoYiUseCooldownMax;
    }

    public void setQianKunDaNuoYiUseCooldownMax(float qianKunDaNuoYiUseCooldownMax) {
        this.qianKunDaNuoYiUseCooldownMax = qianKunDaNuoYiUseCooldownMax;
    }

    public float getQianKunDaNuoYiUseCooldownMaxAdd() {
        if (qianKunDaNuoYiUseCooldownMaxAdd<=0){
            this.qianKunDaNuoYiUseCooldownMax = 60;
        }
        return qianKunDaNuoYiUseCooldownMaxAdd;
    }
    public void setQianKunDaNuoYiUseCooldownMaxAdd() {
        this.qianKunDaNuoYiUseCooldownMaxAdd--;
    }
    public void setQianKunDaNuoYiUseCooldownMaxAdd(float qianKunDaNuoYiUseCooldownMaxAdd) {
        this.qianKunDaNuoYiUseCooldownMaxAdd = qianKunDaNuoYiUseCooldownMaxAdd;
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
    public void copyQianKunDaNuoYi(QianKunDaNuoYiCapability capability){
        this.qianKunDaNuoYiLevel = capability.qianKunDaNuoYiLevel;
        this.qianKunDaNuoYiComprehend = capability.qianKunDaNuoYiComprehend;
        this.qianKunDaNuoYiUseCount = capability.qianKunDaNuoYiUseCount;
        this.qianKunDaNuoYiUseCooldownPercent = capability.qianKunDaNuoYiUseCooldownPercent;
        this.qianKunDaNuoYiOff = capability.qianKunDaNuoYiOff;
        this.qianKunDaNuoYiToppedTick = capability.qianKunDaNuoYiToppedTick;
        this.qianKunDaNuoYiDachengTick = capability.qianKunDaNuoYiDachengTick;
        this.qianKunDaNuoYiParticle = capability.qianKunDaNuoYiParticle;
        this.qianKunDaNuoYiUseCooldownMax = capability.qianKunDaNuoYiUseCooldownMax;
        this.qianKunDaNuoYiUseCooldownMaxAdd = capability.qianKunDaNuoYiUseCooldownMaxAdd;
        this.skillZActive = capability.skillZActive;
        this.skillXActive = capability.skillXActive;
        this.skillCActive = capability.skillCActive;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("QianKunDaNuoYiLevel", qianKunDaNuoYiLevel);
        nbt.putInt("QianKunDaNuoYiUseCount", qianKunDaNuoYiUseCount);
        nbt.putBoolean("QianKunDaNuoYiComprehend",qianKunDaNuoYiComprehend);
        nbt.putFloat("QianKunDaNuoYiUseCooldownPercent",qianKunDaNuoYiUseCooldownPercent);
        nbt.putBoolean("QianKunDaNuoYiOff",qianKunDaNuoYiOff);
        nbt.putFloat("QianKunDaNuoYiToppedTick",qianKunDaNuoYiToppedTick);
        nbt.putFloat("QianKunDaNuoYiDachengTick",qianKunDaNuoYiDachengTick);
        nbt.putBoolean("QianKunDaNuoYiParticle",qianKunDaNuoYiParticle);
        nbt.putFloat("QianKunDaNuoYiDachengTick",qianKunDaNuoYiDachengTick);
        nbt.putBoolean("QianKunDaNuoYiParticle",qianKunDaNuoYiParticle);
        nbt.putFloat("QianKunDaNuoYiUseCooldownMax",qianKunDaNuoYiUseCooldownMax);
        nbt.putFloat("QianKunDaNuoYiUseCooldownMaxAdd",qianKunDaNuoYiUseCooldownMaxAdd);
        nbt.putBoolean("SkillZActive", skillZActive);
        nbt.putBoolean("SkillXActive", skillXActive);
        nbt.putBoolean("SkillCActive", skillCActive);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        qianKunDaNuoYiLevel = nbt.getInt("QianKunDaNuoYiLevel");
        qianKunDaNuoYiUseCount = nbt.getInt("QianKunDaNuoYiUseCount");
        qianKunDaNuoYiUseCooldownPercent = nbt.getFloat("QianKunDaNuoYiUseCooldownPercent");
        qianKunDaNuoYiComprehend = nbt.getBoolean("QianKunDaNuoYiComprehend");
        qianKunDaNuoYiOff = nbt.getBoolean("QianKunDaNuoYiOff");
        qianKunDaNuoYiToppedTick = nbt.getFloat("QianKunDaNuoYiToppedTick");
        qianKunDaNuoYiDachengTick = nbt.getFloat("QianKunDaNuoYiDachengTick");
        qianKunDaNuoYiParticle = nbt.getBoolean("QianKunDaNuoYiParticle");
        qianKunDaNuoYiUseCooldownMax = nbt.getFloat("QianKunDaNuoYiUseCooldownMax");
        qianKunDaNuoYiUseCooldownMaxAdd = nbt.getFloat("QianKunDaNuoYiUseCooldownMaxAdd");
        skillZActive = nbt.getBoolean("SkillZActive");
        skillXActive = nbt.getBoolean("SkillXActive");
        skillCActive = nbt.getBoolean("SkillCActive");
    }
}
