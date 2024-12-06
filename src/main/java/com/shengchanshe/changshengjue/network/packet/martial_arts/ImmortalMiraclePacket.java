package com.shengchanshe.changshengjue.network.packet.martial_arts;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.immortal_miracle.ImmortalMiracleClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ImmortalMiraclePacket {
    private final int immortalMiracleLevel;
    private final boolean immortalMiracleComprehend;
    private int immortalMiracleUseCooldownPercent;
    private boolean immortalMiracleOff;//技能是否启用
    private int immortalMiracleToppedTick;//技能领悟特效计时
    private int immortalMiracleDachengTick;//技能大成特效计时
    private boolean immortalMiracleParticle;//技能特效显示
    private int immortalMiracleUseCooldownPercentMax;

    public ImmortalMiraclePacket(int immortalMiracleLevel, boolean immortalMiracleComprehend, int immortalMiracleUseCooldownPercent, boolean immortalMiracleOff,
                                 int immortalMiracleToppedTick, int immortalMiracleDachengTick, boolean immortalMiracleParticle,int immortalMiracleUseCooldownPercentMax){
        this.immortalMiracleLevel = immortalMiracleLevel;
        this.immortalMiracleComprehend = immortalMiracleComprehend;
        this.immortalMiracleUseCooldownPercent = immortalMiracleUseCooldownPercent;
        this.immortalMiracleOff = immortalMiracleOff;
        this.immortalMiracleToppedTick = immortalMiracleToppedTick;
        this.immortalMiracleDachengTick = immortalMiracleDachengTick;
        this.immortalMiracleParticle = immortalMiracleParticle;
        this.immortalMiracleUseCooldownPercentMax = immortalMiracleUseCooldownPercentMax;
    }

    public ImmortalMiraclePacket(FriendlyByteBuf buf){
        this.immortalMiracleLevel = buf.readInt();
        this.immortalMiracleComprehend = buf.readBoolean();
        this.immortalMiracleUseCooldownPercent = buf.readInt();
        this.immortalMiracleOff = buf.readBoolean();
        this.immortalMiracleToppedTick = buf.readInt();
        this.immortalMiracleDachengTick = buf.readInt();
        this.immortalMiracleParticle = buf.readBoolean();
        this.immortalMiracleUseCooldownPercentMax = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(immortalMiracleLevel);
        buf.writeBoolean(immortalMiracleComprehend);
        buf.writeInt(immortalMiracleUseCooldownPercent);
        buf.writeBoolean(immortalMiracleOff);
        buf.writeInt(immortalMiracleToppedTick);
        buf.writeInt(immortalMiracleDachengTick);
        buf.writeBoolean(immortalMiracleParticle);
        buf.writeInt(immortalMiracleUseCooldownPercentMax);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ImmortalMiracleClientData.setImmortalMiracleLevel(immortalMiracleLevel);
            ImmortalMiracleClientData.setImmortalMiracleComprehend(immortalMiracleComprehend);
            ImmortalMiracleClientData.setImmortalMiracleUseCooldownPercent(immortalMiracleUseCooldownPercent);
            ImmortalMiracleClientData.setImmortalMiracleOff(immortalMiracleOff);
            ImmortalMiracleClientData.setImmortalMiracleToppedTick(immortalMiracleToppedTick);
            ImmortalMiracleClientData.setImmortalMiracleDachengTick(immortalMiracleDachengTick);
            ImmortalMiracleClientData.setImmortalMiracleParticle(immortalMiracleParticle);
            ImmortalMiracleClientData.setImmortalMiracleUseCooldownPercentMax(immortalMiracleUseCooldownPercentMax);
        });
        return true;
    }
}
