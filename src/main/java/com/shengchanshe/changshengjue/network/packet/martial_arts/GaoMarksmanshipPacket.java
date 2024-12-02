package com.shengchanshe.changshengjue.network.packet.martial_arts;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.gao_marksmanship.GaoMarksmanshipClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class GaoMarksmanshipPacket {
    private final int gaoMarksmanshipLevel;
    private final boolean gaoMarksmanshipComprehend;

    public GaoMarksmanshipPacket(int gaoMarksmanshipLevel, boolean gaoMarksmanshipComprehend){
        this.gaoMarksmanshipLevel = gaoMarksmanshipLevel;
        this.gaoMarksmanshipComprehend = gaoMarksmanshipComprehend;
    }

    public GaoMarksmanshipPacket(FriendlyByteBuf buf){
        this.gaoMarksmanshipLevel = buf.readInt();
        this.gaoMarksmanshipComprehend = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(gaoMarksmanshipLevel);
        buf.writeBoolean(gaoMarksmanshipComprehend);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            GaoMarksmanshipClientData.setGaoMarksmanshipLevel(gaoMarksmanshipLevel);
            GaoMarksmanshipClientData.setGaoMarksmanshipComprehend(gaoMarksmanshipComprehend);
        });
        return true;
    }
}
