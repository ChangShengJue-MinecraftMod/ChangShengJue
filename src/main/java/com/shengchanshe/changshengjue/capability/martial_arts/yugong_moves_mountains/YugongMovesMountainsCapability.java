package com.shengchanshe.changshengjue.capability.martial_arts.yugong_moves_mountains;

import net.minecraft.nbt.CompoundTag;

public class YugongMovesMountainsCapability {
    private int yugongMovesMountainsLevel = 0;
    private boolean yugongMovesMountainsComprehend = false;
    private int yugongMovesMountainsUseCount = 0;
    private float yugongMovesMountainsToppedTick = 0;//技能领悟特效计时
    private float yugongMovesMountainsDachengTick = 0;//技能领悟特效计时
    private boolean yugongMovesMountainsParticle = false;//技能特效显示

    public boolean isYugongMovesMountainsComprehend() {
        return yugongMovesMountainsComprehend;
    }

    public int getYugongMovesMountainsLevel() {
        return yugongMovesMountainsLevel;
    }

    public int getYugongMovesMountainsUseCount() {
        return yugongMovesMountainsUseCount;
    }

    public void addYugongMovesMountainsLevel(){
        this.yugongMovesMountainsLevel = this.yugongMovesMountainsUseCount >= 1000 ? 2 : 1;
    }

    public void setYugongMovesMountainsComprehend(boolean yugongMovesMountainsComprehend) {
        this.yugongMovesMountainsComprehend = yugongMovesMountainsComprehend;
    }

    public void addYugongMovesMountainsUseCount(int yugongMovesMountainsUseCount){
        if (this.yugongMovesMountainsUseCount >= 1000){
            this.addYugongMovesMountainsLevel();
        }
        this.yugongMovesMountainsUseCount = this.yugongMovesMountainsUseCount + yugongMovesMountainsUseCount;
    }
    public float getYugongMovesMountainsToppedTick() {
        if (this.yugongMovesMountainsParticle && this.yugongMovesMountainsToppedTick >= 80){
            this.yugongMovesMountainsToppedTick = 0;
            this.yugongMovesMountainsParticle = false;
        }
        return yugongMovesMountainsToppedTick;
    }
    public float setYugongMovesMountainsToppedTick() {
        return this.yugongMovesMountainsToppedTick++;
    }

    public float getYugongMovesMountainsDachengTick() {
        if (this.yugongMovesMountainsParticle && this.yugongMovesMountainsDachengTick >= 30){
            this.yugongMovesMountainsDachengTick = 0;
            this.yugongMovesMountainsParticle = false;
        }
        return yugongMovesMountainsDachengTick;
    }
    public float setYugongMovesMountainsDachengTick() {
        return this.yugongMovesMountainsDachengTick++;
    }

    public void setYugongMovesMountainsParticle(boolean yugongMovesMountainsParticle) {
        this.yugongMovesMountainsParticle = yugongMovesMountainsParticle;
    }
    public boolean isYugongMovesMountainsParticle(){
        return this.yugongMovesMountainsParticle;
    }

    public void copyYugongMovesMountains(YugongMovesMountainsCapability capability){
        this.yugongMovesMountainsLevel = capability.yugongMovesMountainsLevel;
        this.yugongMovesMountainsComprehend = capability.yugongMovesMountainsComprehend;
        this.yugongMovesMountainsUseCount = capability.yugongMovesMountainsUseCount;
        this.yugongMovesMountainsToppedTick = capability.yugongMovesMountainsToppedTick;
        this.yugongMovesMountainsDachengTick = capability.yugongMovesMountainsDachengTick;
        this.yugongMovesMountainsParticle = capability.yugongMovesMountainsParticle;
    }


    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("YugongMovesMountainsLevel", yugongMovesMountainsLevel);
        nbt.putInt("YugongMovesMountainsUseCount", yugongMovesMountainsUseCount);
        nbt.putBoolean("YugongMovesMountainsComprehend",yugongMovesMountainsComprehend);
        nbt.putFloat("YugongMovesMountainsToppedTick",yugongMovesMountainsToppedTick);
        nbt.putFloat("YugongMovesMountainsDachengTick",yugongMovesMountainsDachengTick);
        nbt.putBoolean("YugongMovesMountainsParticle",yugongMovesMountainsParticle);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        yugongMovesMountainsLevel = nbt.getInt("YugongMovesMountainsLevel");
        yugongMovesMountainsUseCount = nbt.getInt("YugongMovesMountainsUseCount");
        yugongMovesMountainsComprehend = nbt.getBoolean("YugongMovesMountainsComprehend");
        yugongMovesMountainsToppedTick = nbt.getFloat("YugongMovesMountainsToppedTick");
        yugongMovesMountainsDachengTick = nbt.getFloat("YugongMovesMountainsDachengTick");
        yugongMovesMountainsParticle = nbt.getBoolean("YugongMovesMountainsParticle");
    }
}
