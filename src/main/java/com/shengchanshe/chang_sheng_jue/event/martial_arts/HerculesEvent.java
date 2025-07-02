package com.shengchanshe.chang_sheng_jue.event.martial_arts;

import com.shengchanshe.chang_sheng_jue.capability.martial_arts.hercules.HerculesCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.hercules.HerculesClientData;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.hercules.HerculesPacket;
import com.shengchanshe.chang_sheng_jue.util.particle.ComprehendParticle;
import com.shengchanshe.chang_sheng_jue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;

public class HerculesEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(HerculesCapabilityProvider.HERCULES_CAPABILITY).ifPresent(hercules -> {
                    if (hercules.isHerculesParticle()){
                        if (hercules.getHerculesLevel() == 1){
                            hercules.setHerculesToppedTick();
                            ChangShengJueMessages.sendToPlayer(new HerculesPacket(
                                    hercules.getHerculesLevel(),
                                    hercules.isHerculesComprehend(),
                                    hercules.getHerculesToppedTick(),
                                    hercules.getHerculesDachengTick(),
                                    hercules.isHerculesParticle(),
                                    hercules.isSkillActive()), (ServerPlayer) player);
                        }else if (hercules.getHerculesLevel() == 2){
                            hercules.setHerculesDachengTick();
                            ChangShengJueMessages.sendToPlayer(new HerculesPacket(
                                    hercules.getHerculesLevel(),
                                    hercules.isHerculesComprehend(),
                                    hercules.getHerculesToppedTick(),
                                    hercules.getHerculesDachengTick(),
                                    hercules.isHerculesParticle(),
                                    hercules.isSkillActive()), (ServerPlayer) player);
                        }
                    }
                    if (hercules.getHerculesLevel() == 1){
//                        player.getFoodData().addExhaustion(-0.1F);
                        if (player instanceof ServerPlayer serverPlayer){
                            int walkedDistanceInCm = serverPlayer.getStats().getValue(Stats.CUSTOM.get(Stats.WALK_ONE_CM));
                            if (walkedDistanceInCm - hercules.getHerculesUseCount() >= (!player.getAbilities().instabuild ? 1000000 : 1)){
                                hercules.addHerculesUseCount(1000000);
                                hercules.setHerculesParticle(true);
                                ChangShengJueMessages.sendToPlayer(new HerculesPacket(
                                        hercules.getHerculesLevel(),
                                        hercules.isHerculesComprehend(),
                                        hercules.getHerculesToppedTick(),
                                        hercules.getHerculesDachengTick(),
                                        hercules.isHerculesParticle(),
                                        hercules.isSkillActive()), (ServerPlayer) player);
                            }
                        }
                    }
                });
            }
            if (player.level().isClientSide){
                if (HerculesClientData.isHerculesParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, HerculesClientData.getHerculesToppedTick());
                }
                if (HerculesClientData.isHerculesParticle()) {
                    DachengParticle.DachengParticle(player, level, HerculesClientData.getHerculesDachengTick());
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
//                    directEntity.getCapability(HerculesCapabilityProvider.HERCULES_CAPABILITY).ifPresent(hercules -> {
//                        if (hercules.isHerculesComprehend() && hercules.getHerculesLevel() == 0) {
//                            if (hercules.isSkillZActive() || hercules.isSkillXActive() || hercules.isSkillCActive()) {
//                                float probability = directEntity.getRandom().nextFloat();
//                                float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
//                                if (probability < defaultProbability) {
//                                    hercules.addHerculesLevel();
//                                    hercules.setHerculesParticle(true);
//                                    if (directEntity instanceof ServerPlayer serverPlayer){
//                                        hercules.addHerculesUseCount(serverPlayer.getStats().getValue(Stats.CUSTOM.get(Stats.WALK_ONE_CM)));
//                                    }
//                                    directEntity.level().playSound(null, directEntity.getX(), directEntity.getY(), directEntity.getZ(),
//                                            ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                                    ChangShengJueMessages.sendToPlayer(new HerculesPacket(
//                                            hercules.getHerculesLevel(),
//                                            hercules.isHerculesComprehend(),
//                                            hercules.getHerculesToppedTick(),
//                                            hercules.getHerculesDachengTick(),
//                                            hercules.isHerculesParticle(),
//                                            hercules.isSkillZActive(),
//                                            hercules.isSkillXActive(),
//                                            hercules.isSkillCActive()), (ServerPlayer) directEntity);
//                                }
//                            }
//                        }
//                    });
//                }
//            }
//        }
//    }
}
