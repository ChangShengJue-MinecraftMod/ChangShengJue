package com.shengchanshe.changshengjue.capability.martial_arts.qian_kun_da_nuo_yi;

import net.minecraft.nbt.CompoundTag;

import java.util.UUID;

public class QianKunDaNuoYiCapability {
    private int qianKunDaNuoYiLevel = 0;//技能等级
    private boolean qianKunDaNuoYiComprehend = false;//是否领悟
    private int qianKunDaNuoYiUseCount = 0;//使用次数
    private float qianKunDaNuoYiUseCooldownPercent = 0;//技能冷却
    private boolean qianKunDaNuoYiOff = false;//技能是否启用
    private float qianKunDaNuoYiToppedTick = 0;//技能领悟特效计时
    private float qianKunDaNuoYiDachengTick = 0;//技能领悟特效计时
    private boolean qianKunDaNuoYiParticle = false;//技能特效显示
    private float qianKunDaNuoYiUseCooldownMax = 40;
    private float qianKunDaNuoYiUseCooldownMaxAdd = 0;
    private int recordTime = 0;
    private float recordDamage = 0;
    private UUID recordDamageSource = UUID.randomUUID();
    // 技能状态
    private boolean skillActive = false;

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

    public int getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(int recordTime) {
        this.recordTime = recordTime;
    }

    public int setRecordTime() {
        return recordTime--;
    }


    public float getRecordDamage() {
        return recordDamage;
    }

    public void setRecordDamage(float recordDamage) {
        this.recordDamage = recordDamage;
    }

    public UUID getRecordDamageSource() {
        return recordDamageSource;
    }

    public void setRecordDamageSource(UUID recordDamageSource) {
        this.recordDamageSource = recordDamageSource;
    }

    public boolean isSkillActive() {
        return skillActive;
    }

    public void setSkillActive(boolean skillActive) {
        this.skillActive = skillActive;
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
        this.recordTime = capability.recordTime;
        this.recordDamage = capability.recordDamage;
        this.recordDamageSource = capability.recordDamageSource;
        this.skillActive = capability.skillActive;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("QianKunDaNuoYiLevel",  this.qianKunDaNuoYiLevel);
        nbt.putInt("QianKunDaNuoYiUseCount",  this.qianKunDaNuoYiUseCount);
        nbt.putBoolean("QianKunDaNuoYiComprehend", this.qianKunDaNuoYiComprehend);
        nbt.putFloat("QianKunDaNuoYiUseCooldownPercent", this.qianKunDaNuoYiUseCooldownPercent);
        nbt.putBoolean("QianKunDaNuoYiOff", this.qianKunDaNuoYiOff);
        nbt.putFloat("QianKunDaNuoYiToppedTick", this.qianKunDaNuoYiToppedTick);
        nbt.putFloat("QianKunDaNuoYiDachengTick", this.qianKunDaNuoYiDachengTick);
        nbt.putBoolean("QianKunDaNuoYiParticle", this.qianKunDaNuoYiParticle);
        nbt.putFloat("QianKunDaNuoYiDachengTick", this.qianKunDaNuoYiDachengTick);
        nbt.putBoolean("QianKunDaNuoYiParticle", this.qianKunDaNuoYiParticle);
        nbt.putFloat("QianKunDaNuoYiUseCooldownMax", this.qianKunDaNuoYiUseCooldownMax);
        nbt.putFloat("QianKunDaNuoYiUseCooldownMaxAdd", this.qianKunDaNuoYiUseCooldownMaxAdd);
        nbt.putInt("RecordTime", this.recordTime);
        nbt.putFloat("RecordDamage", this.recordDamage);
        nbt.putUUID("RecordDamageSource", this.recordDamageSource);
        nbt.putBoolean("SkillActive",  this.skillActive);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        this.qianKunDaNuoYiLevel = nbt.getInt("QianKunDaNuoYiLevel");
        this.qianKunDaNuoYiUseCount = nbt.getInt("QianKunDaNuoYiUseCount");
        this.qianKunDaNuoYiUseCooldownPercent = nbt.getFloat("QianKunDaNuoYiUseCooldownPercent");
        this.qianKunDaNuoYiComprehend = nbt.getBoolean("QianKunDaNuoYiComprehend");
        this.qianKunDaNuoYiOff = nbt.getBoolean("QianKunDaNuoYiOff");
        this.qianKunDaNuoYiToppedTick = nbt.getFloat("QianKunDaNuoYiToppedTick");
        this.qianKunDaNuoYiDachengTick = nbt.getFloat("QianKunDaNuoYiDachengTick");
        this.qianKunDaNuoYiParticle = nbt.getBoolean("QianKunDaNuoYiParticle");
        this.qianKunDaNuoYiUseCooldownMax = nbt.getFloat("QianKunDaNuoYiUseCooldownMax");
        this.qianKunDaNuoYiUseCooldownMaxAdd = nbt.getFloat("QianKunDaNuoYiUseCooldownMaxAdd");
        this.recordTime = nbt.getInt("RecordTime");
        this.recordDamage = nbt.getFloat("RecordDamage");
        // 处理旧数据（无UUID字段的情况）
        if (!nbt.contains("RecordDamageSource")) {
            this.recordDamageSource = UUID.randomUUID(); // 生成新UUID
        }else {
            this.recordDamageSource = nbt.getUUID("RecordDamageSource");
        }

        this.skillActive = nbt.getBoolean("SkillActive");
    }
}
