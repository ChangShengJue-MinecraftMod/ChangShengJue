package com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.tread_the_snow_without_trace;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TreadTheSnowWithoutTracePacket {

    public TreadTheSnowWithoutTracePacket(){
    }

    public TreadTheSnowWithoutTracePacket(FriendlyByteBuf buf){
    }

    public void toBytes(FriendlyByteBuf buf){
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {
                TreadTheSnowWithoutTraceIntentGuard.submitIntent(player);
            }

        });
        context.setPacketHandled(true);
        return true;
    }
}
