package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.ge_shan_da_niu.GeShanDaNiuClientData;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.turtle_breath_work.TurtleBreathWorkClientData;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar.GoldenBellJarPacket2;
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
                                turtleBreathWork.isTurtleBreathWorkParticle()), (ServerPlayer) player);
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
                                    turtleBreathWork.isTurtleBreathWorkParticle()), (ServerPlayer) player);
                        }else if (turtleBreathWork.getTurtleBreathWorkLevel() == 2){
                            turtleBreathWork.setTurtleBreathWorkDachengTick();
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

    //生物受伤事件
    public static void onEntityHurt(LivingDamageEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            if (event.getSource().getDirectEntity() instanceof Player directEntity){
                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()){
                    if (!directEntity.isShiftKeyDown()){
                        event.setAmount(0);
                    }
                    directEntity.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
                        if (turtleBreathWork.isTurtleBreathWorkComprehend() && turtleBreathWork.isTurtleBreathWorkOff() && turtleBreathWork.getTurtleBreathWorkLevel() == 0) {
                            float probability = directEntity.getRandom().nextFloat();
                            float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
                            if (probability < defaultProbability) {
                                level.playSound(null, directEntity.getX(), directEntity.getY(), directEntity.getZ(),
                                        ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                turtleBreathWork.addTurtleBreathWorkLevel();
                                turtleBreathWork.setTurtleBreathWorkParticle(true);
                            }
                            ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
                                    turtleBreathWork.getTurtleBreathWorkLevel(),
                                    turtleBreathWork.isTurtleBreathWorkComprehend(),
                                    turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
                                    turtleBreathWork.isTurtleBreathWorkOff(),
                                    turtleBreathWork.getTurtleBreathWorkToppedTick(),
                                    turtleBreathWork.getTurtleBreathWorkDachengTick(),
                                    turtleBreathWork.isTurtleBreathWorkParticle()), (ServerPlayer) directEntity);
                        }
                    });
                }
            }
        }
    }

    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        if (!event.getLevel().isClientSide) {
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
                            if (turtleBreathWork.getTurtleBreathWorkUseCount() < 100){
                                turtleBreathWork.addTurtleBreathWorkUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                if (turtleBreathWork.getTurtleBreathWorkUseCount() >= 100){
                                    turtleBreathWork.setTurtleBreathWorkParticle(true);
                                    event.getLevel().playSound(null, player.getX(), player.getY(), player.getZ(),
                                            ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
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
        }else {
            boolean turtleBreathWorkComprehend = TurtleBreathWorkClientData.isTurtleBreathWorkComprehend();
            boolean turtleBreathWorkOff = TurtleBreathWorkClientData.isTurtleBreathWorkOff();
            if (turtleBreathWorkComprehend && turtleBreathWorkOff){
                if (TurtleBreathWorkClientData.getTurtleBreathWorkLevel() >= 1){
                    if (TurtleBreathWorkClientData.getTurtleBreathWorkUseCooldownPercent()<=0) {
                        if (player.getFoodData().getFoodLevel() > 8){
                            player.swing(player.getUsedItemHand());
                        }
                    }
                }
            }
        }
    }

    public static void onPlayerRightClickItem(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        if (!player.isUsingItem()){
            return;
        }
        ChangShengJueMessages.sendToServer(new TurtleBreathWorkPacket2());
        boolean geShanDaNiuComprehend = GeShanDaNiuClientData.isGeShanDaNiuComprehend();
        boolean geShanDaNiuOff = GeShanDaNiuClientData.isGeShanDaNiuOff();
        if (geShanDaNiuComprehend && geShanDaNiuOff){
            if (GeShanDaNiuClientData.getGeShanDaNiuLevel() >= 1){
                if (GeShanDaNiuClientData.getGeShanDaNiuUseCooldownPercent()<=0) {
                    if (player.getFoodData().getFoodLevel() > 8){
                        player.swing(player.getUsedItemHand());
                    }
                }
            }
        }
    }

    public static void onPlayerRightClick(PlayerInteractEvent.RightClickEmpty event) {
        Player player = event.getEntity();
        ChangShengJueMessages.sendToServer(new TurtleBreathWorkPacket2());
        boolean turtleBreathWorkComprehend = TurtleBreathWorkClientData.isTurtleBreathWorkComprehend();
        boolean turtleBreathWorkOff = TurtleBreathWorkClientData.isTurtleBreathWorkOff();
        if (turtleBreathWorkComprehend && turtleBreathWorkOff){
            if (TurtleBreathWorkClientData.getTurtleBreathWorkLevel() >= 1){
                if (TurtleBreathWorkClientData.getTurtleBreathWorkUseCooldownPercent()<=0) {
                    if (player.getFoodData().getFoodLevel() > 8){
                        player.swing(player.getUsedItemHand());
                    }
                }
            }
        }
    }
}
