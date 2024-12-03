package com.shengchanshe.changshengjue.network.packet.martial_arts.tread_the_snow_without_trace;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TreadTheSnowWithoutTracePacket {
    private final int treadTheSnowWithoutTraceLevel;
    private final boolean treadTheSnowWithoutTraceComprehend;
    private int treadTheSnowWithoutTraceUseCooldownPercent;

    public TreadTheSnowWithoutTracePacket(int treadTheSnowWithoutTraceLevel, boolean treadTheSnowWithoutTraceComprehend,int treadTheSnowWithoutTraceUseCooldownPercent){
        this.treadTheSnowWithoutTraceLevel = treadTheSnowWithoutTraceLevel;
        this.treadTheSnowWithoutTraceComprehend = treadTheSnowWithoutTraceComprehend;
        this.treadTheSnowWithoutTraceUseCooldownPercent = treadTheSnowWithoutTraceUseCooldownPercent;
    }

    public TreadTheSnowWithoutTracePacket(FriendlyByteBuf buf){
        this.treadTheSnowWithoutTraceLevel = buf.readInt();
        this.treadTheSnowWithoutTraceComprehend = buf.readBoolean();
        this.treadTheSnowWithoutTraceUseCooldownPercent = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(treadTheSnowWithoutTraceLevel);
        buf.writeBoolean(treadTheSnowWithoutTraceComprehend);
        buf.writeInt(treadTheSnowWithoutTraceUseCooldownPercent);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            TreadTheSnowWithoutTraceClientData.setTreadTheSnowWithoutTraceLevel(treadTheSnowWithoutTraceLevel);
            TreadTheSnowWithoutTraceClientData.setTreadTheSnowWithoutTraceComprehend(treadTheSnowWithoutTraceComprehend);
            TreadTheSnowWithoutTraceClientData.setTreadTheSnowWithoutTraceUseCooldownPercent(treadTheSnowWithoutTraceUseCooldownPercent);
        });
        return true;
    }
}
