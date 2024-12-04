package com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar;

import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class GoldenBellJarPacket2 {

    public GoldenBellJarPacket2(){
    }

    public GoldenBellJarPacket2(FriendlyByteBuf buf){
    }

    public void toBytes(FriendlyByteBuf buf){
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();
            player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
                if (goldenBellJar.isGoldenBellJarComprehend() && goldenBellJar.isGoldenBellJarOff() && goldenBellJar.getGoldenBellJarLevel() > 0){
                    if (goldenBellJar.getGoldenBellJarUseCooldownPercent() <= 0){
                        if (player.getFoodData().getFoodLevel() > 8){
                            if (!player.getAbilities().instabuild){
                                player.getFoodData().eat(-3, -2);//消耗饱食度
                            }
                            if (goldenBellJar.getGoldenBellJarLevel() < 2){
                                player.addEffect(new MobEffectInstance(ChangShengJueEffects.GOLDEN_BELL_JAR_EFFECT.get(), 120, 0, false, false), player);
                            }else {
                                player.addEffect(new MobEffectInstance(ChangShengJueEffects.GOLDEN_BELL_JAR_EFFECT.get(), 120, 1, false, false), player);
                            }
                            goldenBellJar.addGoldenBellJarUseCount(!player.getAbilities().instabuild ? 100 : 1);
                            goldenBellJar.setGoldenBellJarUseCooldownPercent(!player.getAbilities().instabuild ? 160 : 0);
                            ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                                    goldenBellJar.getGoldenBellJarLevel(),
                                    goldenBellJar.isGoldenBellJarComprehend(),
                                    goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                                    goldenBellJar.isGoldenBellJarOff()), player);
                        }
                    }
//                    if (player.getMainHandItem().isEmpty()){
//                    }
                }
            });
        });
        return true;
    }
}
