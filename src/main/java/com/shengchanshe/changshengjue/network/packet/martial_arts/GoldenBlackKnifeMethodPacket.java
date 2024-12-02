package com.shengchanshe.changshengjue.network.packet.martial_arts;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class GoldenBlackKnifeMethodPacket {
    private final int goldenBlackKnifeMethodLevel;
    private final boolean goldenBlackKnifeMethodComprehend;

    public GoldenBlackKnifeMethodPacket(int goldenBlackKnifeMethodLevel, boolean goldenBlackKnifeMethodComprehend){
        this.goldenBlackKnifeMethodLevel = goldenBlackKnifeMethodLevel;
        this.goldenBlackKnifeMethodComprehend = goldenBlackKnifeMethodComprehend;
    }

    public GoldenBlackKnifeMethodPacket(FriendlyByteBuf buf){
        this.goldenBlackKnifeMethodLevel = buf.readInt();
        this.goldenBlackKnifeMethodComprehend = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(goldenBlackKnifeMethodLevel);
        buf.writeBoolean(goldenBlackKnifeMethodComprehend);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            GoldenBlackKnifeMethodClientData.setGoldenBlackKnifeMethodLevel(goldenBlackKnifeMethodLevel);
            GoldenBlackKnifeMethodClientData.setGoldenBlackKnifeMethodComprehend(goldenBlackKnifeMethodComprehend);
        });
        return true;
    }
}
