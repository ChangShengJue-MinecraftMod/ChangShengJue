package com.shengchanshe.chang_sheng_jue.capability.martial_arts.zhang_men_xin_xue;

import net.minecraft.nbt.CompoundTag;

public class ZhangMenXinxueCapability {
    private int zhangMenXinxueLevel = 0;
    private boolean zhangMenXinxueComprehend = false;
    private int zhangMenXinxueUseCount = 0;

    public boolean isZhangMenXinxueComprehend() {
        return zhangMenXinxueComprehend;
    }

    public int getZhangMenXinxueLevel() {
        return zhangMenXinxueLevel;
    }

    public int getZhangMenXinxueUseCount() {
        return zhangMenXinxueUseCount;
    }

    public void addZhangMenXinxueLevel(){
        this.zhangMenXinxueLevel = this.zhangMenXinxueUseCount >= 100 ? 2 : 1;
    }

    public void setZhangMenXinxueComprehend(boolean zhangMenXinxueComprehend) {
        this.zhangMenXinxueComprehend = zhangMenXinxueComprehend;
    }

    public boolean zhangMenXinxueComprehend(){
        return this.zhangMenXinxueComprehend;
    }

    public void addZhangMenXinxueUseCount(int zhangMenXinxueUseCount){
        this.zhangMenXinxueUseCount = this.zhangMenXinxueUseCount + zhangMenXinxueUseCount;
        if (this.zhangMenXinxueUseCount>=100){
            this.addZhangMenXinxueLevel();
        }
    }

    public void copyZhangMenXinxue(ZhangMenXinxueCapability capability){
        this.zhangMenXinxueLevel = capability.zhangMenXinxueLevel;
        this.zhangMenXinxueComprehend = capability.zhangMenXinxueComprehend;
        this.zhangMenXinxueUseCount = capability.zhangMenXinxueUseCount;
    }

    // 将能力保存到 NBT 数据中
    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("ZhangMenXinxueLevel", zhangMenXinxueLevel);
        nbt.putInt("ZhangMenXinxueUseCount", zhangMenXinxueUseCount);
        nbt.putBoolean("ZhangMenXinxueComprehend",zhangMenXinxueComprehend);
    }

    // 从 NBT 数据中加载能力
    public void loadNBTData(CompoundTag nbt) {
        zhangMenXinxueLevel = nbt.getInt("ZhangMenXinxueLevel");
        zhangMenXinxueUseCount = nbt.getInt("ZhangMenXinxueUseCount");
        zhangMenXinxueComprehend = nbt.getBoolean("ZhangMenXinxueComprehend");
    }
}
