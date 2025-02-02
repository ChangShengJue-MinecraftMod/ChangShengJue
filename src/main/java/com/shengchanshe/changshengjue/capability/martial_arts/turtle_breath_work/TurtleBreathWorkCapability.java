package com.shengchanshe.changshengjue.capability.martial_arts.turtle_breath_work;

import net.minecraft.nbt.CompoundTag;

public class TurtleBreathWorkCapability {
    private int turtleBreathWorkLevel = 0;//技能等级
    private boolean turtleBreathWorkComprehend = false;//是否领悟
    private int turtleBreathWorkUseCount = 0;//使用次数
    private float turtleBreathWorkUseCooldownPercent = 0;//技能冷却
    private boolean turtleBreathWorkOff = false;//技能是否启用
    private float turtleBreathWorkToppedTick = 0;//技能领悟特效计时
    private float turtleBreathWorkDachengTick = 0;//技能领悟特效计时
    private boolean turtleBreathWorkParticle = false;//技能特效显示
    // 技能状态
    private boolean skillZActive = false;
    private boolean skillXActive = false;
    private boolean skillCActive = false;


    public int getTurtleBreathWorkLevel() {
        return turtleBreathWorkLevel;
    }
    public int getTurtleBreathWorkUseCount() {
        return turtleBreathWorkUseCount;
    }
    public void addTurtleBreathWorkLevel(){
        this.turtleBreathWorkLevel = this.turtleBreathWorkUseCount >= 100 ? 2 : 1;
    }

    public boolean isTurtleBreathWorkComprehend() {
        return turtleBreathWorkComprehend;
    }
    public void setTurtleBreathWorkComprehend(boolean turtleBreathWorkComprehend) {
        this.turtleBreathWorkComprehend = turtleBreathWorkComprehend;
    }

    public void addTurtleBreathWorkUseCount(int turtleBreathWorkUseCount){
        this.turtleBreathWorkUseCount = this.turtleBreathWorkUseCount + turtleBreathWorkUseCount;
        if (this.turtleBreathWorkUseCount>=100){
            this.addTurtleBreathWorkLevel();
        }
    }

    public float getTurtleBreathWorkUseCooldownPercent() {
        return turtleBreathWorkUseCooldownPercent;
    }
    public float setTurtleBreathWorkUseCooldownPercent() {
        return this.turtleBreathWorkUseCooldownPercent--;
    }
    public void setTurtleBreathWorkUseCooldownPercent(float turtleBreathWorkUseCooldownPercent) {
        this.turtleBreathWorkUseCooldownPercent = turtleBreathWorkUseCooldownPercent;
    }

    public void setTurtleBreathWorkOff(boolean turtleBreathWorkOff) {
        this.turtleBreathWorkOff = turtleBreathWorkOff;
    }
    public boolean isTurtleBreathWorkOff(){
        return this.turtleBreathWorkOff;
    }

    public float getTurtleBreathWorkToppedTick() {
        if (this.turtleBreathWorkParticle && this.turtleBreathWorkToppedTick >= 80){
            this.turtleBreathWorkToppedTick = 0;
            this.turtleBreathWorkParticle = false;
        }
        return turtleBreathWorkToppedTick;
    }
    public float setTurtleBreathWorkToppedTick() {
        return this.turtleBreathWorkToppedTick++;
    }

    public float getTurtleBreathWorkDachengTick() {
        if (this.turtleBreathWorkParticle && this.turtleBreathWorkDachengTick >= 30){
            this.turtleBreathWorkDachengTick = 0;
            this.turtleBreathWorkParticle = false;
        }
        return turtleBreathWorkDachengTick;
    }
    public float setTurtleBreathWorkDachengTick() {
        return this.turtleBreathWorkDachengTick++;
    }

    public void setTurtleBreathWorkParticle(boolean turtleBreathWorkParticle) {
        this.turtleBreathWorkParticle = turtleBreathWorkParticle;
    }
    public boolean isTurtleBreathWorkParticle(){
        return this.turtleBreathWorkParticle;
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
    public void copyTurtleBreathWork(TurtleBreathWorkCapability capability){
        this.turtleBreathWorkLevel = capability.turtleBreathWorkLevel;
        this.turtleBreathWorkComprehend = capability.turtleBreathWorkComprehend;
        this.turtleBreathWorkUseCount = capability.turtleBreathWorkUseCount;
        this.turtleBreathWorkUseCooldownPercent = capability.turtleBreathWorkUseCooldownPercent;
        this.turtleBreathWorkOff = capability.turtleBreathWorkOff;
        this.turtleBreathWorkToppedTick = capability.turtleBreathWorkToppedTick;
        this.turtleBreathWorkDachengTick = capability.turtleBreathWorkDachengTick;
        this.turtleBreathWorkParticle = capability.turtleBreathWorkParticle;
        this.skillZActive = capability.skillZActive;
        this.skillXActive = capability.skillXActive;
        this.skillCActive = capability.skillCActive;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("TurtleBreathWorkLevel", turtleBreathWorkLevel);
        nbt.putInt("TurtleBreathWorkUseCount", turtleBreathWorkUseCount);
        nbt.putBoolean("TurtleBreathWorkComprehend",turtleBreathWorkComprehend);
        nbt.putFloat("TurtleBreathWorkUseCooldownPercent",turtleBreathWorkUseCooldownPercent);
        nbt.putBoolean("TurtleBreathWorkOff",turtleBreathWorkOff);
        nbt.putFloat("TurtleBreathWorkToppedTick",turtleBreathWorkToppedTick);
        nbt.putFloat("TurtleBreathWorkDachengTick",turtleBreathWorkDachengTick);
        nbt.putBoolean("TurtleBreathWorkParticle",turtleBreathWorkParticle);
        nbt.putBoolean("SkillZActive", skillZActive);
        nbt.putBoolean("SkillXActive", skillXActive);
        nbt.putBoolean("SkillCActive", skillCActive);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        turtleBreathWorkLevel = nbt.getInt("TurtleBreathWorkLevel");
        turtleBreathWorkUseCount = nbt.getInt("TurtleBreathWorkUseCount");
        turtleBreathWorkUseCooldownPercent = nbt.getFloat("TurtleBreathWorkUseCooldownPercent");
        turtleBreathWorkComprehend = nbt.getBoolean("TurtleBreathWorkComprehend");
        turtleBreathWorkOff = nbt.getBoolean("TurtleBreathWorkOff");
        turtleBreathWorkToppedTick = nbt.getFloat("TurtleBreathWorkToppedTick");
        turtleBreathWorkDachengTick = nbt.getFloat("TurtleBreathWorkDachengTick");
        turtleBreathWorkParticle = nbt.getBoolean("TurtleBreathWorkParticle");
        skillZActive = nbt.getBoolean("SkillZActive");
        skillXActive = nbt.getBoolean("SkillXActive");
        skillCActive = nbt.getBoolean("SkillCActive");
    }
}
