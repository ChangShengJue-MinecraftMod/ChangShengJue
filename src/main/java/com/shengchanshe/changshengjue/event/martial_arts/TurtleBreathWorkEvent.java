package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.turtle_breath_work.TurtleBreathWorkClientData;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.turtle_breath_work.TurtleBreathWorkPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.turtle_breath_work.TurtleBreathWorkPacket2;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class TurtleBreathWorkEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
                    if (turtleBreathWork.getTurtleBreathWorkUseCooldownPercent() > 0 && turtleBreathWork.isTurtleBreathWorkOff()) {
                        turtleBreathWork.setTurtleBreathWorkUseCooldownPercent();
                        ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
                                turtleBreathWork.getTurtleBreathWorkLevel(),
                                turtleBreathWork.isTurtleBreathWorkComprehend(),
                                turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
                                turtleBreathWork.isTurtleBreathWorkOff(),
                                turtleBreathWork.getTurtleBreathWorkToppedTick(),
                                turtleBreathWork.getTurtleBreathWorkDachengTick(),
                                turtleBreathWork.isTurtleBreathWorkParticle(),
                                turtleBreathWork.isSkillZActive(),
                                turtleBreathWork.isSkillXActive(),
                                turtleBreathWork.isSkillCActive()),(ServerPlayer) player);
                    }
                    if (turtleBreathWork.isTurtleBreathWorkParticle()){
                        if (turtleBreathWork.getTurtleBreathWorkLevel() == 1){
                            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING,-1, 1));
                            turtleBreathWork.setTurtleBreathWorkToppedTick();
                            ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
                                    turtleBreathWork.getTurtleBreathWorkLevel(),
                                    turtleBreathWork.isTurtleBreathWorkComprehend(),
                                    turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
                                    turtleBreathWork.isTurtleBreathWorkOff(),
                                    turtleBreathWork.getTurtleBreathWorkToppedTick(),
                                    turtleBreathWork.getTurtleBreathWorkDachengTick(),
                                    turtleBreathWork.isTurtleBreathWorkParticle(),
                                    turtleBreathWork.isSkillZActive(),
                                    turtleBreathWork.isSkillXActive(),
                                    turtleBreathWork.isSkillCActive()),(ServerPlayer) player);
                        }else if (turtleBreathWork.getTurtleBreathWorkLevel() == 2){
                            turtleBreathWork.setTurtleBreathWorkDachengTick();
                            ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
                                     turtleBreathWork.getTurtleBreathWorkLevel(),
                                    turtleBreathWork.isTurtleBreathWorkComprehend(),
                                    turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
                                    turtleBreathWork.isTurtleBreathWorkOff(),
                                    turtleBreathWork.getTurtleBreathWorkToppedTick(),
                                    turtleBreathWork.getTurtleBreathWorkDachengTick(),
                                    turtleBreathWork.isTurtleBreathWorkParticle(),
                                    turtleBreathWork.isSkillZActive(),
                                    turtleBreathWork.isSkillXActive(),
                                    turtleBreathWork.isSkillCActive()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide){
                if (TurtleBreathWorkClientData.isTurtleBreathWorkParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, TurtleBreathWorkClientData.getTurtleBreathWorkToppedTick());
                }
                if (TurtleBreathWorkClientData.isTurtleBreathWorkParticle()) {
                    DachengParticle.DachengParticle(player, level, TurtleBreathWorkClientData.getTurtleBreathWorkDachengTick());
                }
            }
        }
    }

//    //生物受伤事件
//    public static void onEntityHurt(LivingDamageEvent event){
//        Level level = event.getEntity().level();
//        if (!level.isClientSide){
//            if (event.getSource().getDirectEntity() instanceof Player directEntity){
//                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()){
//                    if (!directEntity.isShiftKeyDown()){
//                        event.setAmount(0);
//                    }
//                    directEntity.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
//                        if (turtleBreathWork.isTurtleBreathWorkComprehend() && turtleBreathWork.isTurtleBreathWorkOff() && turtleBreathWork.getTurtleBreathWorkLevel() == 0) {
//                            float probability = directEntity.getRandom().nextFloat();
//                            float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
//                            if (probability < defaultProbability) {
//                                level.playSound(null, directEntity.getX(), directEntity.getY(), directEntity.getZ(),
//                                        ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                                turtleBreathWork.addTurtleBreathWorkLevel();
//                                turtleBreathWork.setTurtleBreathWorkParticle(true);
//                            }
//                            ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
//                                    turtleBreathWork.getTurtleBreathWorkLevel(),
//                                    turtleBreathWork.isTurtleBreathWorkComprehend(),
//                                    turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
//                                    turtleBreathWork.isTurtleBreathWorkOff(),
//                                    turtleBreathWork.getTurtleBreathWorkToppedTick(),
//                                    turtleBreathWork.getTurtleBreathWorkDachengTick(),
//                                    turtleBreathWork.isTurtleBreathWorkParticle(),
//                                    turtleBreathWork.isSkillZActive(),
//                                    turtleBreathWork.isSkillXActive(),
//                                    turtleBreathWork.isSkillCActive()), (ServerPlayer) directEntity);
//                        }
//                    });
//                }
//            }
//        }
//    }
}
