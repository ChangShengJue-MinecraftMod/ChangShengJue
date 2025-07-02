package com.shengchanshe.chang_sheng_jue.network.packet.martial_arts;

import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.paoding.PaodingClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PaodingPacket {
    private final int paodingLevel;
    private final boolean paodingComprehend;
    private float paodingToppedTick;//技能领悟特效计时
    private float paodingDachengTick;//技能领悟特效计时
    private boolean paodingParticle;//技能特效显示

    public PaodingPacket(int paodingLevel, boolean paodingComprehend, float paodingToppedTick, float paodingDachengTick, boolean paodingParticle){
        this.paodingLevel = paodingLevel;
        this.paodingComprehend = paodingComprehend;
        this.paodingToppedTick = paodingToppedTick;
        this.paodingDachengTick = paodingDachengTick;
        this.paodingParticle = paodingParticle;
    }

    public PaodingPacket(FriendlyByteBuf buf){
        this.paodingLevel = buf.readInt();
        this.paodingComprehend = buf.readBoolean();
        this.paodingToppedTick = buf.readFloat();
        this.paodingDachengTick = buf.readFloat();
        this.paodingParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(paodingLevel);
        buf.writeBoolean(paodingComprehend);
        buf.writeFloat(paodingToppedTick);
        buf.writeFloat(paodingDachengTick);
        buf.writeBoolean(paodingParticle);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            PaodingClientData.setPaodingLevel(paodingLevel);
            PaodingClientData.setPaodingComprehend(paodingComprehend);

            PaodingClientData.setPaodingToppedTick(paodingToppedTick);
            PaodingClientData.setPaodingDachengTick(paodingDachengTick);
            PaodingClientData.setPaodingParticle(paodingParticle);
        });
        return true;
    }
}
