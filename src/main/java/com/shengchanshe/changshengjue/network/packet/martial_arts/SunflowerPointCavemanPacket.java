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


    public SunflowerPointCavemanPacket(int sunflowerPointCavemanLevel, boolean sunflowerPointCavemanComprehend, int sunflowerPointCavemanUseCooldownPercent,boolean sunflowerPointCavemanOff){
        this.sunflowerPointCavemanLevel = sunflowerPointCavemanLevel;
        this.sunflowerPointCavemanComprehend = sunflowerPointCavemanComprehend;
        this.sunflowerPointCavemanUseCooldownPercent = sunflowerPointCavemanUseCooldownPercent;
        this.sunflowerPointCavemanOff = sunflowerPointCavemanOff;
    }

    public SunflowerPointCavemanPacket(FriendlyByteBuf buf){
        this.sunflowerPointCavemanLevel = buf.readInt();
        this.sunflowerPointCavemanComprehend = buf.readBoolean();
        this.sunflowerPointCavemanUseCooldownPercent = buf.readInt();
        this.sunflowerPointCavemanOff = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(sunflowerPointCavemanLevel);
        buf.writeBoolean(sunflowerPointCavemanComprehend);
        buf.writeInt(sunflowerPointCavemanUseCooldownPercent);
        buf.writeBoolean(sunflowerPointCavemanOff);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            SunflowerPointCavemanClientData.setSunflowerPointCavemanLevel(sunflowerPointCavemanLevel);
            SunflowerPointCavemanClientData.setSunflowerPointCavemanComprehend(sunflowerPointCavemanComprehend);
            SunflowerPointCavemanClientData.setSunflowerPointCavemanUseCooldownPercent(sunflowerPointCavemanUseCooldownPercent);
            SunflowerPointCavemanClientData.setSunflowerPointCavemanOff(sunflowerPointCavemanOff);
        });
        return true;
    }
}
