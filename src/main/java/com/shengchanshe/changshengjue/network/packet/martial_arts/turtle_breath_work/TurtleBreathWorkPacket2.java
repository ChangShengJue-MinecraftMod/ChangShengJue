package com.shengchanshe.changshengjue.network.packet.martial_arts.turtle_breath_work;

import com.shengchanshe.changshengjue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TurtleBreathWorkPacket2 {

    public TurtleBreathWorkPacket2(){
    }

    public TurtleBreathWorkPacket2(FriendlyByteBuf buf){
    }

    public void toBytes(FriendlyByteBuf buf){
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();
            player.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
                if (turtleBreathWork.isTurtleBreathWorkComprehend() && turtleBreathWork.isTurtleBreathWorkOff() && turtleBreathWork.getTurtleBreathWorkLevel() > 0) {
                    if (turtleBreathWork.getTurtleBreathWorkUseCooldownPercent() <= 0) {
                        if (player.getFoodData().getFoodLevel() > 8) {
                            if (player.hasEffect(ChangShengJueEffects.BILUOCHUN_TEAS.get())){
                                if (!player.getAbilities().instabuild) {
                                    player.getFoodData().eat((int) -(4 - (4 * 0.25)), (float) -(2 - (2 * 0.25)));//消耗饱食度
                                }
                                turtleBreathWork.setTurtleBreathWorkUseCooldownPercent(!player.getAbilities().instabuild ? 900 - (900 * 0.15F) : 0);
                            }else if (player.hasEffect(ChangShengJueEffects.LONG_JING_TEAS.get())){
                                if (!player.getAbilities().instabuild) {
                                    player.getFoodData().eat((int) -(4 - (4 * 0.15)), (float) -(2 - (2 * 0.15)));//消耗饱食度
                                }
                                turtleBreathWork.setTurtleBreathWorkUseCooldownPercent(!player.getAbilities().instabuild ? 900 - (900 * 0.25F) : 0);
                            }else {
                                if (!player.getAbilities().instabuild) {
                                    player.getFoodData().eat(-4, -2);//消耗饱食度
                                }
                                turtleBreathWork.setTurtleBreathWorkUseCooldownPercent(!player.getAbilities().instabuild ? 900 : 0);
                            }
                            player.addEffect(new MobEffectInstance(ChangShengJueEffects.TURTLE_BREATH_EFFECT.get(), 300, 0, false, true), player);
                            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING,-1, turtleBreathWork.getTurtleBreathWorkLevel() <= 1 ? 1 : 2));
                            if (turtleBreathWork.getTurtleBreathWorkUseCount() <= 100){
                                turtleBreathWork.addTurtleBreathWorkUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                if (turtleBreathWork.getTurtleBreathWorkUseCount() >= 100){
                                    turtleBreathWork.setTurtleBreathWorkParticle(true);
                                }
                            }
                            ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
                                    turtleBreathWork.getTurtleBreathWorkLevel(),
                                    turtleBreathWork.isTurtleBreathWorkComprehend(),
                                    turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
                                    turtleBreathWork.isTurtleBreathWorkOff(),
                                    turtleBreathWork.getTurtleBreathWorkToppedTick(),
                                    turtleBreathWork.getTurtleBreathWorkDachengTick(),
                                    turtleBreathWork.isTurtleBreathWorkParticle()), (ServerPlayer) player);
                        }
                    }
                }
            });
        });
        return true;
    }
}
