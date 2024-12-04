package com.shengchanshe.changshengjue.network.packet.martial_arts.tread_the_snow_without_trace;

import com.shengchanshe.changshengjue.capability.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceCapabilityProvider;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TreadTheSnowWithoutTracePacket2 {

    public TreadTheSnowWithoutTracePacket2(){
    }

    public TreadTheSnowWithoutTracePacket2(FriendlyByteBuf buf){
    }

    public void toBytes(FriendlyByteBuf buf){
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();
            player.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).ifPresent(treadTheSnowWithoutTrace->{
                treadTheSnowWithoutTrace.setTreadTheSnowWithoutTraceUseCooldownPercent(100);
                if (treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCount() <= 100){
                    treadTheSnowWithoutTrace.addTreadTheSnowWithoutTraceUseCount();
                }
                ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTracePacket(treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel(),
                        treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend(),
                        treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent()),player);
            });
        });
        return true;
    }
}
