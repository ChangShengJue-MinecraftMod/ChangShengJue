package com.shengchanshe.changshengjue.network.packet.martial_arts;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.dugu_nine_swords.DuguNineSwordsClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class DuguNineSwordsPacket {
    private final int duguNineSwordsLevel;
    private final boolean duguNineSwordsComprehend;

    public DuguNineSwordsPacket(int duguNineSwordsLevel, boolean duguNineSwordsComprehend){
        this.duguNineSwordsLevel = duguNineSwordsLevel;
        this.duguNineSwordsComprehend = duguNineSwordsComprehend;
    }

    public DuguNineSwordsPacket(FriendlyByteBuf buf){
        this.duguNineSwordsLevel = buf.readInt();
        this.duguNineSwordsComprehend = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(duguNineSwordsLevel);
        buf.writeBoolean(duguNineSwordsComprehend);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            DuguNineSwordsClientData.setDuguNineSwordsLevel(duguNineSwordsLevel);
            DuguNineSwordsClientData.setDuguNineSwordsComprehend(duguNineSwordsComprehend);
        });
        return true;
    }
}
