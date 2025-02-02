package com.shengchanshe.changshengjue.network.packet.martial_arts;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class XuannuSwordsmanshipPacket {
    private final int xuannuSwordsmanshipLevel;
    private final boolean xuannuSwordsmanshipComprehend;
    private float xuannuSwordsmanshipToppedTick;//技能领悟特效计时
    private float xuannuSwordsmanshipDachengTick;//技能领悟特效计时
    private boolean xuannuSwordsmanshipParticle;//技能特效显示

    public XuannuSwordsmanshipPacket(int xuannuSwordsmanshipLevel, boolean xuannuSwordsmanshipComprehend, float xuannuSwordsmanshipToppedTick, float xuannuSwordsmanshipDachengTick, boolean xuannuSwordsmanshipParticle){
        this.xuannuSwordsmanshipLevel = xuannuSwordsmanshipLevel;
        this.xuannuSwordsmanshipComprehend = xuannuSwordsmanshipComprehend;
        this.xuannuSwordsmanshipToppedTick = xuannuSwordsmanshipToppedTick;
        this.xuannuSwordsmanshipDachengTick = xuannuSwordsmanshipDachengTick;
        this.xuannuSwordsmanshipParticle = xuannuSwordsmanshipParticle;
    }

    public XuannuSwordsmanshipPacket(FriendlyByteBuf buf){
        this.xuannuSwordsmanshipLevel = buf.readInt();
        this.xuannuSwordsmanshipComprehend = buf.readBoolean();
        this.xuannuSwordsmanshipToppedTick = buf.readFloat();
        this.xuannuSwordsmanshipDachengTick = buf.readFloat();
        this.xuannuSwordsmanshipParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(xuannuSwordsmanshipLevel);
        buf.writeBoolean(xuannuSwordsmanshipComprehend);
        buf.writeFloat(xuannuSwordsmanshipToppedTick);
        buf.writeFloat(xuannuSwordsmanshipDachengTick);
        buf.writeBoolean(xuannuSwordsmanshipParticle);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            XuannuSwordsmanshipClientData.setXuannuSwordsmanshipLevel(xuannuSwordsmanshipLevel);
            XuannuSwordsmanshipClientData.setXuannuSwordsmanshipComprehend(xuannuSwordsmanshipComprehend);

            XuannuSwordsmanshipClientData.setXuannuSwordsmanshipToppedTick(xuannuSwordsmanshipToppedTick);
            XuannuSwordsmanshipClientData.setXuannuSwordsmanshipDachengTick(xuannuSwordsmanshipDachengTick);
            XuannuSwordsmanshipClientData.setXuannuSwordsmanshipParticle(xuannuSwordsmanshipParticle);
        });
        return true;
    }
}
