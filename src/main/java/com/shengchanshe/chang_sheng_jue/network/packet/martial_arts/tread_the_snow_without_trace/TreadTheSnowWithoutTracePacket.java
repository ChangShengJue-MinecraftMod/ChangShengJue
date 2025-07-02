package com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.tread_the_snow_without_trace;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TreadTheSnowWithoutTracePacket {
    private final int treadTheSnowWithoutTraceLevel;
    private final boolean treadTheSnowWithoutTraceComprehend;
    private final int treadTheSnowWithoutTraceUseCooldownPercent;
    private final float treadTheSnowWithoutTraceToppedTick;//技能领悟特效计时
    private final float treadTheSnowWithoutTraceDachengTick;//技能领悟特效计时
    private final boolean treadTheSnowWithoutTraceParticle;//技能特效显示

    public TreadTheSnowWithoutTracePacket(int treadTheSnowWithoutTraceLevel, boolean treadTheSnowWithoutTraceComprehend,int treadTheSnowWithoutTraceUseCooldownPercent ,
                                          float treadTheSnowWithoutTraceToppedTick, float treadTheSnowWithoutTraceDachengTick, boolean treadTheSnowWithoutTraceParticle){
        this.treadTheSnowWithoutTraceLevel = treadTheSnowWithoutTraceLevel;
        this.treadTheSnowWithoutTraceComprehend = treadTheSnowWithoutTraceComprehend;
        this.treadTheSnowWithoutTraceUseCooldownPercent = treadTheSnowWithoutTraceUseCooldownPercent;
        this.treadTheSnowWithoutTraceToppedTick = treadTheSnowWithoutTraceToppedTick;
        this.treadTheSnowWithoutTraceDachengTick = treadTheSnowWithoutTraceDachengTick;
        this.treadTheSnowWithoutTraceParticle = treadTheSnowWithoutTraceParticle;
    }

    public TreadTheSnowWithoutTracePacket(FriendlyByteBuf buf){
        this.treadTheSnowWithoutTraceLevel = buf.readInt();
        this.treadTheSnowWithoutTraceComprehend = buf.readBoolean();
        this.treadTheSnowWithoutTraceUseCooldownPercent = buf.readInt();
        this.treadTheSnowWithoutTraceToppedTick = buf.readFloat();
        this.treadTheSnowWithoutTraceDachengTick = buf.readFloat();
        this.treadTheSnowWithoutTraceParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(treadTheSnowWithoutTraceLevel);
        buf.writeBoolean(treadTheSnowWithoutTraceComprehend);
        buf.writeInt(treadTheSnowWithoutTraceUseCooldownPercent);
        buf.writeFloat(treadTheSnowWithoutTraceToppedTick);
        buf.writeFloat(treadTheSnowWithoutTraceDachengTick);
        buf.writeBoolean(treadTheSnowWithoutTraceParticle);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            TreadTheSnowWithoutTraceClientData.setTreadTheSnowWithoutTraceLevel(treadTheSnowWithoutTraceLevel);
            TreadTheSnowWithoutTraceClientData.setTreadTheSnowWithoutTraceComprehend(treadTheSnowWithoutTraceComprehend);
            TreadTheSnowWithoutTraceClientData.setTreadTheSnowWithoutTraceUseCooldownPercent(treadTheSnowWithoutTraceUseCooldownPercent);

            TreadTheSnowWithoutTraceClientData.setTreadTheSnowWithoutTraceToppedTick(treadTheSnowWithoutTraceToppedTick);
            TreadTheSnowWithoutTraceClientData.setTreadTheSnowWithoutTraceDachengTick(treadTheSnowWithoutTraceDachengTick);
            TreadTheSnowWithoutTraceClientData.setTreadTheSnowWithoutTraceParticle(treadTheSnowWithoutTraceParticle);
        });
        return true;
    }
}
