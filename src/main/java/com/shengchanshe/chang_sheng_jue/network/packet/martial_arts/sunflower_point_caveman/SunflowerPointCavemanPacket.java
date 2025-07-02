package com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.sunflower_point_caveman;

import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.sunflower_point_caveman.SunflowerPointCavemanClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SunflowerPointCavemanPacket {
    private final int sunflowerPointCavemanLevel;
    private final boolean sunflowerPointCavemanComprehend;
    private final float sunflowerPointCavemanUseCooldownPercent;
    private final boolean sunflowerPointCavemanOff;//技能是否启用
    private final float sunflowerPointCavemanToppedTick;//技能领悟特效计时
    private final float sunflowerPointCavemanDachengTick;//技能领悟特效计时
    private final boolean sunflowerPointCavemanParticle;//技能特效显示
    // 技能状态
    private final boolean skillActive;
    public SunflowerPointCavemanPacket(int sunflowerPointCavemanLevel, boolean sunflowerPointCavemanComprehend, float sunflowerPointCavemanUseCooldownPercent,boolean sunflowerPointCavemanOff,
                                       float sunflowerPointCavemanToppedTick, float sunflowerPointCavemanDachengTick, boolean sunflowerPointCavemanParticle,
                                       boolean skillActive){
        this.sunflowerPointCavemanLevel = sunflowerPointCavemanLevel;
        this.sunflowerPointCavemanComprehend = sunflowerPointCavemanComprehend;
        this.sunflowerPointCavemanUseCooldownPercent = sunflowerPointCavemanUseCooldownPercent;
        this.sunflowerPointCavemanOff = sunflowerPointCavemanOff;
        this.sunflowerPointCavemanToppedTick = sunflowerPointCavemanToppedTick;
        this.sunflowerPointCavemanDachengTick = sunflowerPointCavemanDachengTick;
        this.sunflowerPointCavemanParticle = sunflowerPointCavemanParticle;
        this.skillActive = skillActive;
    }

    public SunflowerPointCavemanPacket(FriendlyByteBuf buf){
        this.sunflowerPointCavemanLevel = buf.readInt();
        this.sunflowerPointCavemanComprehend = buf.readBoolean();
        this.sunflowerPointCavemanUseCooldownPercent = buf.readFloat();
        this.sunflowerPointCavemanOff = buf.readBoolean();

        this.sunflowerPointCavemanToppedTick = buf.readFloat();
        this.sunflowerPointCavemanDachengTick = buf.readFloat();
        this.sunflowerPointCavemanParticle = buf.readBoolean();

        this.skillActive = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(sunflowerPointCavemanLevel);
        buf.writeBoolean(sunflowerPointCavemanComprehend);
        buf.writeFloat(sunflowerPointCavemanUseCooldownPercent);
        buf.writeBoolean(sunflowerPointCavemanOff);
        buf.writeFloat(sunflowerPointCavemanToppedTick);
        buf.writeFloat(sunflowerPointCavemanDachengTick);
        buf.writeBoolean(sunflowerPointCavemanParticle);
        buf.writeBoolean(skillActive);
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
            SunflowerPointCavemanClientData.setSkillActive(skillActive);
        });
        return true;
    }
}
