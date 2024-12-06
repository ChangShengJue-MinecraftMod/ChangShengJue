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
    private int goldenBellJarToppedTick;//技能领悟特效计时
    private int goldenBellJarDachengTick;//技能领悟特效计时
    private boolean goldenBellJarParticle;//技能特效显示

    public GoldenBellJarPacket(int goldenBellJarLevel, boolean goldenBellJarComprehend, int goldenBellJarUseCooldownPercent, boolean goldenBellJarOff,
                               int goldenBellJarToppedTick, int goldenBellJarDachengTick, boolean goldenBellJarParticle){
        this.goldenBellJarLevel = goldenBellJarLevel;
        this.goldenBellJarComprehend = goldenBellJarComprehend;
        this.goldenBellJarUseCooldownPercent = goldenBellJarUseCooldownPercent;
        this.goldenBellJarOff = goldenBellJarOff;
        this.goldenBellJarToppedTick = goldenBellJarToppedTick;
        this.goldenBellJarDachengTick = goldenBellJarDachengTick;
        this.goldenBellJarParticle = goldenBellJarParticle;
    }

    public GoldenBellJarPacket(FriendlyByteBuf buf){
        this.goldenBellJarLevel = buf.readInt();
        this.goldenBellJarComprehend = buf.readBoolean();
        this.goldenBellJarUseCooldownPercent = buf.readInt();
        this.goldenBellJarOff = buf.readBoolean();
        this.goldenBellJarToppedTick = buf.readInt();
        this.goldenBellJarDachengTick = buf.readInt();
        this.goldenBellJarParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(goldenBellJarLevel);
        buf.writeBoolean(goldenBellJarComprehend);
        buf.writeInt(goldenBellJarUseCooldownPercent);
        buf.writeBoolean(goldenBellJarOff);
        buf.writeInt(goldenBellJarToppedTick);
        buf.writeInt(goldenBellJarDachengTick);
        buf.writeBoolean(goldenBellJarParticle);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            GoldenBellJarClientData.setGoldenBellJarLevel(goldenBellJarLevel);
            GoldenBellJarClientData.setGoldenBellJarComprehend(goldenBellJarComprehend);
            GoldenBellJarClientData.setGoldenBellJarUseCooldownPercent(goldenBellJarUseCooldownPercent);
            GoldenBellJarClientData.setGoldenBellJarOff(goldenBellJarOff);
            GoldenBellJarClientData.setGoldenBellJarToppedTick(goldenBellJarToppedTick);
            GoldenBellJarClientData.setGoldenBellJarDachengTick(goldenBellJarDachengTick);
            GoldenBellJarClientData.setGoldenBellJarParticle(goldenBellJarParticle);
        });
        return true;
    }
}
