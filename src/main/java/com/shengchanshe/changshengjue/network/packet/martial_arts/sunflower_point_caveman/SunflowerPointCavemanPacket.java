package com.shengchanshe.changshengjue.network.packet.martial_arts.sunflower_point_caveman;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.immortal_miracle.ImmortalMiracleClientData;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.sunflower_point_caveman.SunflowerPointCavemanClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SunflowerPointCavemanPacket {
    private int sunflowerPointCavemanLevel;
    private boolean sunflowerPointCavemanComprehend;
    private float sunflowerPointCavemanUseCooldownPercent;
    private boolean sunflowerPointCavemanOff;//技能是否启用
    private float sunflowerPointCavemanToppedTick;//技能领悟特效计时
    private float sunflowerPointCavemanDachengTick;//技能领悟特效计时
    private boolean sunflowerPointCavemanParticle;//技能特效显示
    // 技能状态
    private boolean skillZActive;
    private boolean skillXActive;
    private boolean skillCActive;
    public SunflowerPointCavemanPacket(int sunflowerPointCavemanLevel, boolean sunflowerPointCavemanComprehend, float sunflowerPointCavemanUseCooldownPercent,boolean sunflowerPointCavemanOff,
                                       float sunflowerPointCavemanToppedTick, float sunflowerPointCavemanDachengTick, boolean sunflowerPointCavemanParticle,
                                       boolean skillZActive,boolean skillXActive,boolean skillCActive){
        this.sunflowerPointCavemanLevel = sunflowerPointCavemanLevel;
        this.sunflowerPointCavemanComprehend = sunflowerPointCavemanComprehend;
        this.sunflowerPointCavemanUseCooldownPercent = sunflowerPointCavemanUseCooldownPercent;
        this.sunflowerPointCavemanOff = sunflowerPointCavemanOff;
        this.sunflowerPointCavemanToppedTick = sunflowerPointCavemanToppedTick;
        this.sunflowerPointCavemanDachengTick = sunflowerPointCavemanDachengTick;
        this.sunflowerPointCavemanParticle = sunflowerPointCavemanParticle;
        this.skillZActive = skillZActive;
        this.skillXActive = skillXActive;
        this.skillCActive = skillCActive;
    }

    public SunflowerPointCavemanPacket(FriendlyByteBuf buf){
        this.sunflowerPointCavemanLevel = buf.readInt();
        this.sunflowerPointCavemanComprehend = buf.readBoolean();
        this.sunflowerPointCavemanUseCooldownPercent = buf.readFloat();
        this.sunflowerPointCavemanOff = buf.readBoolean();

        this.sunflowerPointCavemanToppedTick = buf.readFloat();
        this.sunflowerPointCavemanDachengTick = buf.readFloat();
        this.sunflowerPointCavemanParticle = buf.readBoolean();

        this.skillZActive = buf.readBoolean();
        this.skillXActive = buf.readBoolean();
        this.skillCActive = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(sunflowerPointCavemanLevel);
        buf.writeBoolean(sunflowerPointCavemanComprehend);
        buf.writeFloat(sunflowerPointCavemanUseCooldownPercent);
        buf.writeBoolean(sunflowerPointCavemanOff);
        buf.writeFloat(sunflowerPointCavemanToppedTick);
        buf.writeFloat(sunflowerPointCavemanDachengTick);
        buf.writeBoolean(sunflowerPointCavemanParticle);
        buf.writeBoolean(skillZActive);
        buf.writeBoolean(skillXActive);
        buf.writeBoolean(skillCActive);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            SunflowerPointCavemanClientData.setSunflowerPointCavemanLevel(sunflowerPointCavemanLevel);
            SunflowerPointCavemanClientData.setSunflowerPointCavemanComprehend(sunflowerPointCavemanComprehend);
            SunflowerPointCavemanClientData.setSunflowerPointCavemanUseCooldownPercent(sunflowerPointCavemanUseCooldownPercent);
            SunflowerPointCavemanClientData.setSunflowerPointCavemanOff(sunflowerPointCavemanOff);

            SunflowerPointCavemanClientData.setSunflowerPointCavemanToppedTick(sunflowerPointCavemanToppedTick);
            SunflowerPointCavemanClientData.setSunflowerPointCavemanDachengTick(sunflowerPointCavemanDachengTick);
            SunflowerPointCavemanClientData.setSunflowerPointCavemanParticle(sunflowerPointCavemanParticle);
            SunflowerPointCavemanClientData.setSkillZActive(skillZActive);
            SunflowerPointCavemanClientData.setSkillXActive(skillXActive);
            SunflowerPointCavemanClientData.setSkillCActive(skillCActive);
        });
        return true;
    }
}
