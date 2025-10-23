package com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.tread_the_snow_without_trace;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.martial_arts.IKungFu;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.light_kungfu.TreadTheSnowWithoutTrace;
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
                player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                    cap.comprehendKungFu(player, TreadTheSnowWithoutTrace.KUNG_FU_ID.toString(), player);
                    cap.getKungFu(TreadTheSnowWithoutTrace.KUNG_FU_ID.toString())
                            .filter(kungFu -> kungFu instanceof IKungFu)
                            .map(kungFu -> (TreadTheSnowWithoutTrace) kungFu)
                            .filter(TreadTheSnowWithoutTrace::isReady)
                            .map(active -> {
                                active.onLightKungfu(player);
                                cap.syncToClient(player);
                                return true;
                            });
                });
            }

        });
        return true;
    }
}
