package com.shengchanshe.chang_sheng_jue.network.packet.martial_arts;

import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.gao_marksmanship.GaoMarksmanshipClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class GaoMarksmanshipPacket {
    private final int gaoMarksmanshipLevel;
    private final boolean gaoMarksmanshipComprehend;
    private float gaoMarksmanshipToppedTick;//技能领悟特效计时
    private float gaoMarksmanshipDachengTick;//技能领悟特效计时
    private boolean gaoMarksmanshipParticle;//技能特效显示

    public GaoMarksmanshipPacket(int gaoMarksmanshipLevel, boolean gaoMarksmanshipComprehend, float gaoMarksmanshipToppedTick, float gaoMarksmanshipDachengTick, boolean gaoMarksmanshipParticle){
        this.gaoMarksmanshipLevel = gaoMarksmanshipLevel;
        this.gaoMarksmanshipComprehend = gaoMarksmanshipComprehend;
        this.gaoMarksmanshipToppedTick = gaoMarksmanshipToppedTick;
        this.gaoMarksmanshipDachengTick = gaoMarksmanshipDachengTick;
        this.gaoMarksmanshipParticle = gaoMarksmanshipParticle;
    }

    public GaoMarksmanshipPacket(FriendlyByteBuf buf){
        this.gaoMarksmanshipLevel = buf.readInt();
        this.gaoMarksmanshipComprehend = buf.readBoolean();
        this.gaoMarksmanshipToppedTick = buf.readFloat();
        this.gaoMarksmanshipDachengTick = buf.readFloat();
        this.gaoMarksmanshipParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(gaoMarksmanshipLevel);
        buf.writeBoolean(gaoMarksmanshipComprehend);
        buf.writeFloat(gaoMarksmanshipToppedTick);
        buf.writeFloat(gaoMarksmanshipDachengTick);
        buf.writeBoolean(gaoMarksmanshipParticle);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            GaoMarksmanshipClientData.setGaoMarksmanshipLevel(gaoMarksmanshipLevel);
            GaoMarksmanshipClientData.setGaoMarksmanshipComprehend(gaoMarksmanshipComprehend);

            GaoMarksmanshipClientData.setGaoMarksmanshipToppedTick(gaoMarksmanshipToppedTick);
            GaoMarksmanshipClientData.setGaoMarksmanshipDachengTick(gaoMarksmanshipDachengTick);
            GaoMarksmanshipClientData.setGaoMarksmanshipParticle(gaoMarksmanshipParticle);
        });
        return true;
    }
}
