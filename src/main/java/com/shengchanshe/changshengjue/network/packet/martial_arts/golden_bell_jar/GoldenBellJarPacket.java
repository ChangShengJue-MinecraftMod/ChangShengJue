package com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_bell_jar.GoldenBellJarClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class GoldenBellJarPacket {
    private final int goldenBellJarLevel;
    private final boolean goldenBellJarComprehend;
    private int goldenBellJarUseCooldownPercent;
    private boolean goldenBellJarOff;//技能是否启用


    public GoldenBellJarPacket(int goldenBellJarLevel, boolean goldenBellJarComprehend, int goldenBellJarUseCooldownPercent, boolean goldenBellJarOff){
        this.goldenBellJarLevel = goldenBellJarLevel;
        this.goldenBellJarComprehend = goldenBellJarComprehend;
        this.goldenBellJarUseCooldownPercent = goldenBellJarUseCooldownPercent;
        this.goldenBellJarOff = goldenBellJarOff;
    }

    public GoldenBellJarPacket(FriendlyByteBuf buf){
        this.goldenBellJarLevel = buf.readInt();
        this.goldenBellJarComprehend = buf.readBoolean();
        this.goldenBellJarUseCooldownPercent = buf.readInt();
        this.goldenBellJarOff = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(goldenBellJarLevel);
        buf.writeBoolean(goldenBellJarComprehend);
        buf.writeInt(goldenBellJarUseCooldownPercent);
        buf.writeBoolean(goldenBellJarOff);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            GoldenBellJarClientData.setGoldenBellJarLevel(goldenBellJarLevel);
            GoldenBellJarClientData.setGoldenBellJarComprehend(goldenBellJarComprehend);
            GoldenBellJarClientData.setGoldenBellJarUseCooldownPercent(goldenBellJarUseCooldownPercent);
            GoldenBellJarClientData.setGoldenBellJarOff(goldenBellJarOff);
        });
        return true;
    }
}
