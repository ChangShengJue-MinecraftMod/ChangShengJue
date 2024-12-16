package com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_bell_jar.GoldenBellJarClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class GoldenBellJarPacket {
    private final int goldenBellJarLevel;
    private final boolean goldenBellJarComprehend;
    private float goldenBellJarUseCooldownPercent;
    private boolean goldenBellJarOff;//技能是否启用
    private float goldenBellJarToppedTick;//技能领悟特效计时
    private float goldenBellJarDachengTick;//技能领悟特效计时
    private boolean goldenBellJarParticle;//技能特效显示

    public GoldenBellJarPacket(int goldenBellJarLevel, boolean goldenBellJarComprehend, float goldenBellJarUseCooldownPercent, boolean goldenBellJarOff,
                               float goldenBellJarToppedTick, float goldenBellJarDachengTick, boolean goldenBellJarParticle){
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
        this.goldenBellJarUseCooldownPercent = buf.readFloat();
        this.goldenBellJarOff = buf.readBoolean();
        this.goldenBellJarToppedTick = buf.readFloat();
        this.goldenBellJarDachengTick = buf.readFloat();
        this.goldenBellJarParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(goldenBellJarLevel);
        buf.writeBoolean(goldenBellJarComprehend);
        buf.writeFloat(goldenBellJarUseCooldownPercent);
        buf.writeBoolean(goldenBellJarOff);
        buf.writeFloat(goldenBellJarToppedTick);
        buf.writeFloat(goldenBellJarDachengTick);
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
