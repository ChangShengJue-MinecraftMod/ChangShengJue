package com.shengchanshe.changshengjue.capability.martial_arts.shaolin_stick_method;

import net.minecraft.nbt.CompoundTag;

public class ShaolinStickMethodCapability {
    private int shaolinStickMethodLevel = 0;
    private boolean shaolinStickMethodComprehend = false;
    private int shaolinStickMethodUseCount = 0;

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

    public void addShaolinStickMethodUseCount(){
        if (this.shaolinStickMethodUseCount>=100){
            this.addShaolinStickMethodLevel();
        }
        this.shaolinStickMethodUseCount++;
    }

    public void copyShaolinStickMethod(ShaolinStickMethodCapability capability){
        this.shaolinStickMethodLevel = capability.shaolinStickMethodLevel;
        this.shaolinStickMethodComprehend = capability.shaolinStickMethodComprehend;
        this.shaolinStickMethodUseCount = capability.shaolinStickMethodUseCount;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("ShaolinStickMethodLevel", shaolinStickMethodLevel);
        nbt.putInt("ShaolinStickMethodUseCount", shaolinStickMethodUseCount);
        nbt.putBoolean("ShaolinStickMethodComprehend",shaolinStickMethodComprehend);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        shaolinStickMethodLevel = nbt.getInt("ShaolinStickMethodLevel");
        shaolinStickMethodUseCount = nbt.getInt("ShaolinStickMethodUseCount");
        shaolinStickMethodComprehend = nbt.getBoolean("ShaolinStickMethodComprehend");
    }
}
