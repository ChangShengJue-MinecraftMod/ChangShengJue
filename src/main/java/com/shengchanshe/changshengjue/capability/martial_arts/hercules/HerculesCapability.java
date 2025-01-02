package com.shengchanshe.changshengjue.capability.martial_arts.hercules;

import net.minecraft.nbt.CompoundTag;

public class HerculesCapability {
    private int herculesLevel = 0;
    private boolean herculesComprehend = false;
    private int herculesUseCount = 0;
    private float herculesToppedTick = 0;//技能领悟特效计时
    private float herculesDachengTick = 0;//技能领悟特效计时
    private boolean herculesParticle = false;//技能特效显示
    // 技能状态
    private boolean skillZActive = false;
    private boolean skillXActive = false;
    private boolean skillCActive = false;
    public boolean isHerculesComprehend() {
        return herculesComprehend;
    }

    public int getHerculesLevel() {
        return herculesLevel;
    }

    public int getHerculesUseCount() {
        return herculesUseCount;
    }

    public void addHerculesLevel(){
        this.herculesLevel = this.herculesUseCount >= 1000000 ? 2 : 1;
    }

    public void setHerculesComprehend(boolean herculesComprehend) {
        this.herculesComprehend = herculesComprehend;
    }

    public boolean herculesComprehend(){
        return this.herculesComprehend;
    }

    public void addHerculesUseCount(int herculesUseCount){
        this.herculesUseCount = this.herculesUseCount + herculesUseCount;
        if (this.herculesUseCount >= 1000000){
            this.addHerculesLevel();
        }
    }

    public float getHerculesToppedTick() {
        if (this.herculesParticle && this.herculesToppedTick >= 80){
            this.herculesToppedTick = 0;
            this.herculesParticle = false;
        }
        return herculesToppedTick;
    }
    public float setHerculesToppedTick() {
        return this.herculesToppedTick++;
    }

    public float getHerculesDachengTick() {
        if (this.herculesParticle && this.herculesDachengTick >= 30){
            this.herculesDachengTick = 0;
            this.herculesParticle = false;
        }
        return herculesDachengTick;
    }
    public float setHerculesDachengTick() {
        return this.herculesDachengTick++;
    }

    public void setHerculesParticle(boolean herculesParticle) {
        this.herculesParticle = herculesParticle;
    }
    public boolean isHerculesParticle(){
        return this.herculesParticle;
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
    public void copyHercules(HerculesCapability capability){
        this.herculesLevel = capability.herculesLevel;
        this.herculesComprehend = capability.herculesComprehend;
        this.herculesUseCount = capability.herculesUseCount;
        this.herculesToppedTick = capability.herculesToppedTick;
        this.herculesDachengTick = capability.herculesDachengTick;
        this.herculesParticle = capability.herculesParticle;
        this.skillZActive = capability.skillZActive;
        this.skillXActive = capability.skillXActive;
        this.skillCActive = capability.skillCActive;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("HerculesLevel", herculesLevel);
        nbt.putInt("HerculesUseCount", herculesUseCount);
        nbt.putBoolean("HerculesComprehend",herculesComprehend);
        nbt.putFloat("HerculesToppedTick",herculesToppedTick);
        nbt.putFloat("HerculesDachengTick",herculesDachengTick);
        nbt.putBoolean("HerculesParticle",herculesParticle);
        nbt.putBoolean("SkillZActive", skillZActive);
        nbt.putBoolean("SkillXActive", skillXActive);
        nbt.putBoolean("SkillCActive", skillCActive);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        herculesLevel = nbt.getInt("HerculesLevel");
        herculesUseCount = nbt.getInt("HerculesUseCount");
        herculesComprehend = nbt.getBoolean("HerculesComprehend");
        herculesToppedTick = nbt.getFloat("HerculesToppedTick");
        herculesDachengTick = nbt.getFloat("HerculesDachengTick");
        herculesParticle = nbt.getBoolean("HerculesParticle");
        skillZActive = nbt.getBoolean("SkillZActive");
        skillXActive = nbt.getBoolean("SkillXActive");
        skillCActive = nbt.getBoolean("SkillCActive");
    }
}
