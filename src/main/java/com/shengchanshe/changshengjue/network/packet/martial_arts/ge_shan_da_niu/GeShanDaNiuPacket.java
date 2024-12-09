package com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.ge_shan_da_niu.GeShanDaNiuClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class GeShanDaNiuPacket {
    private final int geShanDaNiuLevel;
    private final boolean geShanDaNiuComprehend;
    private int geShanDaNiuUseCooldownPercent;
    private boolean geShanDaNiuOff;//技能是否启用
    private int geShanDaNiuToppedTick;//技能领悟特效计时
    private int geShanDaNiuDachengTick;//技能大成特效计时
    private boolean geShanDaNiuParticle;//技能特效显示
    private int geShanDaNiuUseCooldownPercentMax;

    public GeShanDaNiuPacket(int geShanDaNiuLevel, boolean geShanDaNiuComprehend, int geShanDaNiuUseCooldownPercent, boolean geShanDaNiuOff,
                             int geShanDaNiuToppedTick, int geShanDaNiuDachengTick, boolean geShanDaNiuParticle, int geShanDaNiuUseCooldownPercentMax){
        this.geShanDaNiuLevel = geShanDaNiuLevel;
        this.geShanDaNiuComprehend = geShanDaNiuComprehend;
        this.geShanDaNiuUseCooldownPercent = geShanDaNiuUseCooldownPercent;
        this.geShanDaNiuOff = geShanDaNiuOff;
        this.geShanDaNiuToppedTick = geShanDaNiuToppedTick;
        this.geShanDaNiuDachengTick = geShanDaNiuDachengTick;
        this.geShanDaNiuParticle = geShanDaNiuParticle;
        this.geShanDaNiuUseCooldownPercentMax = geShanDaNiuUseCooldownPercentMax;
    }

    public GeShanDaNiuPacket(FriendlyByteBuf buf){
        this.geShanDaNiuLevel = buf.readInt();
        this.geShanDaNiuComprehend = buf.readBoolean();
        this.geShanDaNiuUseCooldownPercent = buf.readInt();
        this.geShanDaNiuOff = buf.readBoolean();
        this.geShanDaNiuToppedTick = buf.readInt();
        this.geShanDaNiuDachengTick = buf.readInt();
        this.geShanDaNiuParticle = buf.readBoolean();
        this.geShanDaNiuUseCooldownPercentMax = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(geShanDaNiuLevel);
        buf.writeBoolean(geShanDaNiuComprehend);
        buf.writeInt(geShanDaNiuUseCooldownPercent);
        buf.writeBoolean(geShanDaNiuOff);
        buf.writeInt(geShanDaNiuToppedTick);
        buf.writeInt(geShanDaNiuDachengTick);
        buf.writeBoolean(geShanDaNiuParticle);
        buf.writeInt(geShanDaNiuUseCooldownPercentMax);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            GeShanDaNiuClientData.setGeShanDaNiuLevel(geShanDaNiuLevel);
            GeShanDaNiuClientData.setGeShanDaNiuComprehend(geShanDaNiuComprehend);
            GeShanDaNiuClientData.setGeShanDaNiuUseCooldownPercent(geShanDaNiuUseCooldownPercent);
            GeShanDaNiuClientData.setGeShanDaNiuOff(geShanDaNiuOff);
            GeShanDaNiuClientData.setGeShanDaNiuToppedTick(geShanDaNiuToppedTick);
            GeShanDaNiuClientData.setGeShanDaNiuDachengTick(geShanDaNiuDachengTick);
            GeShanDaNiuClientData.setGeShanDaNiuParticle(geShanDaNiuParticle);
            GeShanDaNiuClientData.setGeShanDaNiuUseCooldownPercentMax(geShanDaNiuUseCooldownPercentMax);
        });
        return true;
    }
}
