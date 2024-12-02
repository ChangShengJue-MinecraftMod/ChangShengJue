package com.shengchanshe.changshengjue.network.packet.martial_arts;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.shaolin_stick_method.ShaolinStickMethodClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ShaolinStickMethodPacket {
    private final int shaolinStickMethodLevel;
    private final boolean shaolinStickMethodComprehend;

    public ShaolinStickMethodPacket(int shaolinStickMethodLevel, boolean shaolinStickMethodComprehend){
        this.shaolinStickMethodLevel = shaolinStickMethodLevel;
        this.shaolinStickMethodComprehend = shaolinStickMethodComprehend;
    }

    public ShaolinStickMethodPacket(FriendlyByteBuf buf){
        this.shaolinStickMethodLevel = buf.readInt();
        this.shaolinStickMethodComprehend = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(shaolinStickMethodLevel);
        buf.writeBoolean(shaolinStickMethodComprehend);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ShaolinStickMethodClientData.setShaolinStickMethodLevel(shaolinStickMethodLevel);
            ShaolinStickMethodClientData.setShaolinStickMethodComprehend(shaolinStickMethodComprehend);
        });
        return true;
    }
}
