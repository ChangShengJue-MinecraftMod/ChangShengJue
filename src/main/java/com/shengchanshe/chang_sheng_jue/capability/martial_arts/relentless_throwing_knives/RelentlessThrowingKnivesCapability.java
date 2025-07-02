package com.shengchanshe.chang_sheng_jue.capability.martial_arts.relentless_throwing_knives;

import net.minecraft.nbt.CompoundTag;

public class RelentlessThrowingKnivesCapability {
    private int relentlessThrowingKnivesLevel = 0;//技能等级
    private boolean relentlessThrowingKnivesComprehend = false;//是否领悟
    private int relentlessThrowingKnivesUseCount = 0;//使用次数
    private int relentlessThrowingKnivesUseCooldownPercent = 0;//技能冷却
    private int relentlessThrowingKnivesToppedTick = 0;//技能领悟特效计时
    private int relentlessThrowingKnivesDachengTick = 0;//技能领悟特效计时
    private boolean relentlessThrowingKnivesParticle = false;//技能特效显示

    public int getRelentlessThrowingKnivesLevel() {
        return relentlessThrowingKnivesLevel;
    }
    public int getRelentlessThrowingKnivesUseCount() {
        return relentlessThrowingKnivesUseCount;
    }
    public void addRelentlessThrowingKnivesLevel(){
        this.relentlessThrowingKnivesLevel = this.relentlessThrowingKnivesUseCount >= 100 ? 2 : 1;
    }

    public boolean isRelentlessThrowingKnivesComprehend() {
        return relentlessThrowingKnivesComprehend;
    }
    public void setRelentlessThrowingKnivesComprehend(boolean relentlessThrowingKnivesComprehend) {
        this.relentlessThrowingKnivesComprehend = relentlessThrowingKnivesComprehend;
    }

    public void addRelentlessThrowingKnivesUseCount(int relentlessThrowingKnivesUseCount){
        this.relentlessThrowingKnivesUseCount = this.relentlessThrowingKnivesUseCount + relentlessThrowingKnivesUseCount;
        if (this.relentlessThrowingKnivesUseCount>=100){
            this.addRelentlessThrowingKnivesLevel();
        }
    }

    public int getRelentlessThrowingKnivesUseCooldownPercent() {
        return relentlessThrowingKnivesUseCooldownPercent;
    }
    public int setRelentlessThrowingKnivesUseCooldownPercent() {
        return this.relentlessThrowingKnivesUseCooldownPercent--;
    }
    public void setRelentlessThrowingKnivesUseCooldownPercent(int relentlessThrowingKnivesUseCooldownPercent) {
        this.relentlessThrowingKnivesUseCooldownPercent = relentlessThrowingKnivesUseCooldownPercent;
    }

    public int getRelentlessThrowingKnivesToppedTick() {
        if (this.relentlessThrowingKnivesParticle && this.relentlessThrowingKnivesToppedTick >= 80){
            this.relentlessThrowingKnivesToppedTick = 0;
            this.relentlessThrowingKnivesParticle = false;
        }
        return relentlessThrowingKnivesToppedTick;
    }
    public int setRelentlessThrowingKnivesToppedTick() {
        return this.relentlessThrowingKnivesToppedTick++;
    }

    public int getRelentlessThrowingKnivesDachengTick() {
        if (this.relentlessThrowingKnivesParticle && this.relentlessThrowingKnivesDachengTick >= 30){
            this.relentlessThrowingKnivesDachengTick = 0;
            this.relentlessThrowingKnivesParticle = false;
        }
        return relentlessThrowingKnivesDachengTick;
    }
    public int setRelentlessThrowingKnivesDachengTick() {
        return this.relentlessThrowingKnivesDachengTick++;
    }

    public void setRelentlessThrowingKnivesParticle(boolean relentlessThrowingKnivesParticle) {
        this.relentlessThrowingKnivesParticle = relentlessThrowingKnivesParticle;
    }
    public boolean isRelentlessThrowingKnivesParticle(){
        return this.relentlessThrowingKnivesParticle;
    }

    public void copyRelentlessThrowingKnives(RelentlessThrowingKnivesCapability capability){
        this.relentlessThrowingKnivesLevel = capability.relentlessThrowingKnivesLevel;
        this.relentlessThrowingKnivesComprehend = capability.relentlessThrowingKnivesComprehend;
        this.relentlessThrowingKnivesUseCount = capability.relentlessThrowingKnivesUseCount;
        this.relentlessThrowingKnivesUseCooldownPercent = capability.relentlessThrowingKnivesUseCooldownPercent;
        this.relentlessThrowingKnivesToppedTick = capability.relentlessThrowingKnivesToppedTick;
        this.relentlessThrowingKnivesDachengTick = capability.relentlessThrowingKnivesDachengTick;
        this.relentlessThrowingKnivesParticle = capability.relentlessThrowingKnivesParticle;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("RelentlessThrowingKnivesLevel", relentlessThrowingKnivesLevel);
        nbt.putInt("RelentlessThrowingKnivesUseCount", relentlessThrowingKnivesUseCount);
        nbt.putBoolean("RelentlessThrowingKnivesComprehend",relentlessThrowingKnivesComprehend);
        nbt.putInt("RelentlessThrowingKnivesUseCooldownPercent",relentlessThrowingKnivesUseCooldownPercent);
        nbt.putInt("RelentlessThrowingKnivesToppedTick",relentlessThrowingKnivesToppedTick);
        nbt.putInt("RelentlessThrowingKnivesDachengTick",relentlessThrowingKnivesDachengTick);
        nbt.putBoolean("RelentlessThrowingKnivesParticle",relentlessThrowingKnivesParticle);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        relentlessThrowingKnivesLevel = nbt.getInt("RelentlessThrowingKnivesLevel");
        relentlessThrowingKnivesUseCount = nbt.getInt("RelentlessThrowingKnivesUseCount");
        relentlessThrowingKnivesUseCooldownPercent = nbt.getInt("RelentlessThrowingKnivesUseCooldownPercent");
        relentlessThrowingKnivesComprehend = nbt.getBoolean("RelentlessThrowingKnivesComprehend");
        relentlessThrowingKnivesToppedTick = nbt.getInt("RelentlessThrowingKnivesToppedTick");
        relentlessThrowingKnivesDachengTick = nbt.getInt("RelentlessThrowingKnivesDachengTick");
        relentlessThrowingKnivesParticle = nbt.getBoolean("RelentlessThrowingKnivesParticle");
    }
}
