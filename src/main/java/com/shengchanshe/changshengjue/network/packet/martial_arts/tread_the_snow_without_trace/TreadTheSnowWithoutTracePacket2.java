package com.shengchanshe.changshengjue.network.packet.martial_arts.tread_the_snow_without_trace;

import com.shengchanshe.changshengjue.capability.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceCapabilityProvider;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
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
                if (treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCount() < 100){
                    treadTheSnowWithoutTrace.addTreadTheSnowWithoutTraceUseCount(!player.getAbilities().instabuild ? 1 : 100);
                    if (treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCount() >= 100){
                        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                        treadTheSnowWithoutTrace.setTreadTheSnowWithoutTraceParticle(true);
                    }
                }
                ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTracePacket(treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel(),
                        treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend(),
                        treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent(),
                        treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceToppedTick(),
                        treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceDachengTick(),
                        treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceParticle()),player);
            });
        });
        return true;
    }
}
