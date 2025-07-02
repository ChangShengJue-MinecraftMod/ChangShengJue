package com.shengchanshe.chang_sheng_jue.capability.martial_arts.dugu_nine_swords;

import net.minecraft.nbt.CompoundTag;

public class DuguNineSwordsCapability {
    private int duguNineSwordsLevel = 0;
    private boolean duguNineSwordsComprehend = false;
    private int duguNineSwordsUseCount = 0;
    private float duguNineSwordsToppedTick = 0;//技能领悟特效计时
    private float duguNineSwordsDachengTick = 0;//技能领悟特效计时
    private boolean duguNineSwordsParticle = false;//技能特效显示

    public boolean isDuguNineSwordsComprehend() {
        return duguNineSwordsComprehend;
    }

    public int getDuguNineSwordsLevel() {
        return duguNineSwordsLevel;
    }

    public int getDuguNineSwordsUseCount() {
        return duguNineSwordsUseCount;
    }

    public void addDuguNineSwordsLevel(){
        this.duguNineSwordsLevel = this.duguNineSwordsUseCount >= 100 ? 2 : 1;
    }

    public void setDuguNineSwordsComprehend(boolean duguNineSwordsComprehend) {
        this.duguNineSwordsComprehend = duguNineSwordsComprehend;
    }

    public boolean duguNineSwordsComprehend(){
        return this.duguNineSwordsComprehend;
    }

    public void addDuguNineSwordsUseCount(int duguNineSwordsUseCount){
        this.duguNineSwordsUseCount = this.duguNineSwordsUseCount + duguNineSwordsUseCount;
        if (this.duguNineSwordsUseCount>=100){
            this.addDuguNineSwordsLevel();
        }
    }

    public float getDuguNineSwordsToppedTick() {
        if (this.duguNineSwordsParticle && this.duguNineSwordsToppedTick >= 80){
            this.duguNineSwordsToppedTick = 0;
            this.duguNineSwordsParticle = false;
        }
        return duguNineSwordsToppedTick;
    }
    public float setDuguNineSwordsToppedTick() {
        return this.duguNineSwordsToppedTick++;
    }

    public float getDuguNineSwordsDachengTick() {
        if (this.duguNineSwordsParticle && this.duguNineSwordsDachengTick >= 30){
            this.duguNineSwordsDachengTick = 0;
            this.duguNineSwordsParticle = false;
        }
        return duguNineSwordsDachengTick;
    }
    public float setDuguNineSwordsDachengTick() {
        return this.duguNineSwordsDachengTick++;
    }

    public void setDuguNineSwordsParticle(boolean duguNineSwordsParticle) {
        this.duguNineSwordsParticle = duguNineSwordsParticle;
    }
    public boolean isDuguNineSwordsParticle(){
        return this.duguNineSwordsParticle;
    }

    public void copyDuguNineSwords(DuguNineSwordsCapability capability){
        this.duguNineSwordsLevel = capability.duguNineSwordsLevel;
        this.duguNineSwordsComprehend = capability.duguNineSwordsComprehend;
        this.duguNineSwordsUseCount = capability.duguNineSwordsUseCount;
        this.duguNineSwordsToppedTick = capability.duguNineSwordsToppedTick;
        this.duguNineSwordsDachengTick = capability.duguNineSwordsDachengTick;
        this.duguNineSwordsParticle = capability.duguNineSwordsParticle;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("DuguNineSwordsLevel", duguNineSwordsLevel);
        nbt.putInt("DuguNineSwordsUseCount", duguNineSwordsUseCount);
        nbt.putBoolean("DuguNineSwordsComprehend",duguNineSwordsComprehend);
        nbt.putFloat("DuguNineSwordsToppedTick",duguNineSwordsToppedTick);
        nbt.putFloat("DuguNineSwordsDachengTick",duguNineSwordsDachengTick);
        nbt.putBoolean("DuguNineSwordsParticle",duguNineSwordsParticle);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        duguNineSwordsLevel = nbt.getInt("DuguNineSwordsLevel");
        duguNineSwordsUseCount = nbt.getInt("DuguNineSwordsUseCount");
        duguNineSwordsComprehend = nbt.getBoolean("DuguNineSwordsComprehend");
        duguNineSwordsToppedTick = nbt.getFloat("DuguNineSwordsToppedTick");
        duguNineSwordsDachengTick = nbt.getFloat("DuguNineSwordsDachengTick");
        duguNineSwordsParticle = nbt.getBoolean("DuguNineSwordsParticle");
    }
}
