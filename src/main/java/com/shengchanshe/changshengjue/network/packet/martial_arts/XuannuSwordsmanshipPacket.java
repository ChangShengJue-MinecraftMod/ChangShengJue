package com.shengchanshe.changshengjue.network.packet.martial_arts;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class XuannuSwordsmanshipPacket {
    private final int xuannuSwordsmanshipLevel;
    private final boolean xuannuSwordsmanshipComprehend;

    public XuannuSwordsmanshipPacket(int xuannuSwordsmanshipLevel, boolean xuannuSwordsmanshipComprehend){
        this.xuannuSwordsmanshipLevel = xuannuSwordsmanshipLevel;
        this.xuannuSwordsmanshipComprehend = xuannuSwordsmanshipComprehend;
    }

    public XuannuSwordsmanshipPacket(FriendlyByteBuf buf){
        this.xuannuSwordsmanshipLevel = buf.readInt();
        this.xuannuSwordsmanshipComprehend = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(xuannuSwordsmanshipLevel);
        buf.writeBoolean(xuannuSwordsmanshipComprehend);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            XuannuSwordsmanshipClientData.setXuannuSwordsmanshipLevel(xuannuSwordsmanshipLevel);
            XuannuSwordsmanshipClientData.setXuannuSwordsmanshipComprehend(xuannuSwordsmanshipComprehend);
        });
        return true;
    }
}
