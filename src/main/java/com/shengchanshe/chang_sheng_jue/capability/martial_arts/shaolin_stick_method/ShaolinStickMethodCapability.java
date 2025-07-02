package com.shengchanshe.chang_sheng_jue.capability.martial_arts.shaolin_stick_method;

import net.minecraft.nbt.CompoundTag;

public class ShaolinStickMethodCapability {
    private int shaolinStickMethodLevel = 0;
    private boolean shaolinStickMethodComprehend = false;
    private int shaolinStickMethodUseCount = 0;
    private float shaolinStickMethodToppedTick = 0;//技能领悟特效计时
    private float shaolinStickMethodDachengTick = 0;//技能领悟特效计时
    private boolean shaolinStickMethodParticle = false;//技能特效显示

    public boolean isShaolinStickMethodComprehend() {
        return shaolinStickMethodComprehend;
    }

    public int getShaolinStickMethodLevel() {
        return shaolinStickMethodLevel;
    }

    public int getShaolinStickMethodUseCount() {
        return shaolinStickMethodUseCount;
    }

    public void addShaolinStickMethodLevel(){
        this.shaolinStickMethodLevel = this.shaolinStickMethodUseCount >= 100 ? 2 : 1;
    }

    public void setShaolinStickMethodComprehend(boolean shaolinStickMethodComprehend) {
        this.shaolinStickMethodComprehend = shaolinStickMethodComprehend;
    }

    public boolean getShaolinStickMethodComprehend(){
        return this.shaolinStickMethodComprehend;
    }

    public void addShaolinStickMethodUseCount(int shaolinStickMethodUseCount){
        this.shaolinStickMethodUseCount = this.shaolinStickMethodUseCount + shaolinStickMethodUseCount;
        if (this.shaolinStickMethodUseCount>=100){
            this.addShaolinStickMethodLevel();
        }
    }

    public float getShaolinStickMethodToppedTick() {
        if (this.shaolinStickMethodParticle && this.shaolinStickMethodToppedTick >= 80){
            this.shaolinStickMethodToppedTick = 0;
            this.shaolinStickMethodParticle = false;
        }
        return shaolinStickMethodToppedTick;
    }
    public float setShaolinStickMethodToppedTick() {
        return this.shaolinStickMethodToppedTick++;
    }

    public float getShaolinStickMethodDachengTick() {
        if (this.shaolinStickMethodParticle && this.shaolinStickMethodDachengTick >= 30){
            this.shaolinStickMethodDachengTick = 0;
            this.shaolinStickMethodParticle = false;
        }
        return shaolinStickMethodDachengTick;
    }
    public float setShaolinStickMethodDachengTick() {
        return this.shaolinStickMethodDachengTick++;
    }

    public void setShaolinStickMethodParticle(boolean shaolinStickMethodParticle) {
        this.shaolinStickMethodParticle = shaolinStickMethodParticle;
    }
    public boolean isShaolinStickMethodParticle(){
        return this.shaolinStickMethodParticle;
    }

    public void copyShaolinStickMethod(ShaolinStickMethodCapability capability){
        this.shaolinStickMethodLevel = capability.shaolinStickMethodLevel;
        this.shaolinStickMethodComprehend = capability.shaolinStickMethodComprehend;
        this.shaolinStickMethodUseCount = capability.shaolinStickMethodUseCount;
        this.shaolinStickMethodToppedTick = capability.shaolinStickMethodToppedTick;
        this.shaolinStickMethodDachengTick = capability.shaolinStickMethodDachengTick;
        this.shaolinStickMethodParticle = capability.shaolinStickMethodParticle;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("ShaolinStickMethodLevel", shaolinStickMethodLevel);
        nbt.putInt("ShaolinStickMethodUseCount", shaolinStickMethodUseCount);
        nbt.putBoolean("ShaolinStickMethodComprehend",shaolinStickMethodComprehend);
        nbt.putFloat("ShaolinStickMethodToppedTick",shaolinStickMethodToppedTick);
        nbt.putFloat("ShaolinStickMethodDachengTick",shaolinStickMethodDachengTick);
        nbt.putBoolean("ShaolinStickMethodParticle",shaolinStickMethodParticle);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        shaolinStickMethodLevel = nbt.getInt("ShaolinStickMethodLevel");
        shaolinStickMethodUseCount = nbt.getInt("ShaolinStickMethodUseCount");
        shaolinStickMethodComprehend = nbt.getBoolean("ShaolinStickMethodComprehend");
        shaolinStickMethodToppedTick = nbt.getFloat("ShaolinStickMethodToppedTick");
        shaolinStickMethodDachengTick = nbt.getFloat("ShaolinStickMethodDachengTick");
        shaolinStickMethodParticle = nbt.getBoolean("ShaolinStickMethodParticle");
    }
}
