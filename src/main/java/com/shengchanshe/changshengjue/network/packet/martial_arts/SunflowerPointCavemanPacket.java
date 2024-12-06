package com.shengchanshe.changshengjue.network.packet.martial_arts;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.sunflower_point_caveman.SunflowerPointCavemanClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SunflowerPointCavemanPacket {
    private final int sunflowerPointCavemanLevel;
    private final boolean sunflowerPointCavemanComprehend;
    private int sunflowerPointCavemanUseCooldownPercent;
    private boolean sunflowerPointCavemanOff;//技能是否启用
    private int sunflowerPointCavemanToppedTick;//技能领悟特效计时
    private int sunflowerPointCavemanDachengTick;//技能领悟特效计时
    private boolean sunflowerPointCavemanParticle;//技能特效显示


    public SunflowerPointCavemanPacket(int sunflowerPointCavemanLevel, boolean sunflowerPointCavemanComprehend, int sunflowerPointCavemanUseCooldownPercent,boolean sunflowerPointCavemanOff,
                                       int sunflowerPointCavemanToppedTick, int sunflowerPointCavemanDachengTick, boolean sunflowerPointCavemanParticle){
        this.sunflowerPointCavemanLevel = sunflowerPointCavemanLevel;
        this.sunflowerPointCavemanComprehend = sunflowerPointCavemanComprehend;
        this.sunflowerPointCavemanUseCooldownPercent = sunflowerPointCavemanUseCooldownPercent;
        this.sunflowerPointCavemanOff = sunflowerPointCavemanOff;
        this.sunflowerPointCavemanToppedTick = sunflowerPointCavemanToppedTick;
        this.sunflowerPointCavemanDachengTick = sunflowerPointCavemanDachengTick;
        this.sunflowerPointCavemanParticle = sunflowerPointCavemanParticle;
    }

    public SunflowerPointCavemanPacket(FriendlyByteBuf buf){
        this.sunflowerPointCavemanLevel = buf.readInt();
        this.sunflowerPointCavemanComprehend = buf.readBoolean();
        this.sunflowerPointCavemanUseCooldownPercent = buf.readInt();
        this.sunflowerPointCavemanOff = buf.readBoolean();

        this.sunflowerPointCavemanToppedTick = buf.readInt();
        this.sunflowerPointCavemanDachengTick = buf.readInt();
        this.sunflowerPointCavemanParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(sunflowerPointCavemanLevel);
        buf.writeBoolean(sunflowerPointCavemanComprehend);
        buf.writeInt(sunflowerPointCavemanUseCooldownPercent);
        buf.writeBoolean(sunflowerPointCavemanOff);
        buf.writeInt(sunflowerPointCavemanToppedTick);
        buf.writeInt(sunflowerPointCavemanDachengTick);
        buf.writeBoolean(sunflowerPointCavemanParticle);
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
        });
        return true;
    }
}
