package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.paoding.PaodingCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.paoding.PaodingClientData;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.entity.custom.deer.AbstractDeer;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.PaodingPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class PaodingEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).ifPresent(paoding -> {
                    if (paoding.isPaodingParticle()){
                        if (paoding.getPaodingLevel() == 1){
                            paoding.setPaodingToppedTick();
                            ChangShengJueMessages.sendToPlayer(new PaodingPacket(
                                    paoding.getPaodingLevel(),
                                    paoding.isPaodingComprehend(),
                                    paoding.getPaodingToppedTick(),
                                    paoding.getPaodingDachengTick(),
                                    paoding.isPaodingParticle()), (ServerPlayer) player);
                        }else if (paoding.getPaodingLevel() == 2){
                            paoding.setPaodingDachengTick();
                            ChangShengJueMessages.sendToPlayer(new PaodingPacket(
                                    paoding.getPaodingLevel(),
                                    paoding.isPaodingComprehend(),
                                    paoding.getPaodingToppedTick(),
                                    paoding.getPaodingDachengTick(),
                                    paoding.isPaodingParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide){
                if (PaodingClientData.isPaodingParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, PaodingClientData.getPaodingToppedTick());
                }
                if (PaodingClientData.isPaodingParticle()) {
                    DachengParticle.DachengParticle(player, level, PaodingClientData.getPaodingDachengTick());
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
//                    directEntity.getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).ifPresent(paoding -> {
//                        if (paoding.isPaodingComprehend() && paoding.getPaodingLevel() == 0) {
//                            float probability = directEntity.getRandom().nextFloat();
//                            float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
//                            if (probability < defaultProbability) {
//                                paoding.addPaodingLevel();
//                                paoding.setPaodingParticle(true);
//                                directEntity.level().playSound(null, directEntity.getX(), directEntity.getY(), directEntity.getZ(),
//                                        ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                                ChangShengJueMessages.sendToPlayer(new PaodingPacket(
//                                        paoding.getPaodingLevel(),
//                                        paoding.isPaodingComprehend(),
//                                        paoding.getPaodingToppedTick(),
//                                        paoding.getPaodingDachengTick(),
//                                        paoding.isPaodingParticle()), (ServerPlayer) directEntity);
//                            }
//                        }
//                    });
//                }
//            }
//        }
//    }

    public static void onEntityDeath(LivingDeathEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            Entity directEntity = event.getSource().getDirectEntity();
            if (directEntity instanceof Player player){
                directEntity.getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).ifPresent(paoding -> {
                    if (paoding.isPaodingComprehend() && paoding.getPaodingLevel() != 0){
                        if (event.getEntity() instanceof Animal && player.getMainHandItem().is(ChangShengJueItems.KITCHEN_KNIFE.get())){
                            float probability = player.getRandom().nextFloat();
                            float defaultProbability = 0.5F;
                            if (paoding.getPaodingLevel() > 1){
                                defaultProbability = (float) (defaultProbability * 0.25);
                            }
                            if (probability >= defaultProbability){
                                if (event.getEntity() instanceof Chicken){
                                    ItemEntity entityToSpawn = new ItemEntity(level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(Items.CHICKEN));
                                    level.addFreshEntity(entityToSpawn);
                                }else if (event.getEntity() instanceof Cow){
                                    ItemEntity entityToSpawn = new ItemEntity(level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(Items.BEEF));
                                    level.addFreshEntity(entityToSpawn);
                                }else if (event.getEntity() instanceof Pig){
                                    ItemEntity entityToSpawn = new ItemEntity(level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(Items.PORKCHOP));
                                    level.addFreshEntity(entityToSpawn);
                                }else if (event.getEntity() instanceof Sheep){
                                    ItemEntity entityToSpawn = new ItemEntity(level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(Items.MUTTON));
                                    level.addFreshEntity(entityToSpawn);
                                }else if (event.getEntity() instanceof Rabbit){
                                    ItemEntity entityToSpawn = new ItemEntity(level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(Items.RABBIT));
                                    level.addFreshEntity(entityToSpawn);
                                }else if (event.getEntity() instanceof AbstractDeer){
                                    ItemEntity entityToSpawn = new ItemEntity(level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), new ItemStack(ChangShengJueItems.VENISON.get()));
                                    level.addFreshEntity(entityToSpawn);
                                }
                                if (paoding.getPaodingUseCount() < 1000) {
                                    paoding.addPaodingUseCount(!player.getAbilities().instabuild ? 1 : 1000);
                                    if (paoding.getPaodingUseCount() >= 1000){
                                        paoding.setPaodingParticle(true);
                                        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                                                ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                        ChangShengJueMessages.sendToPlayer(new PaodingPacket( paoding.getPaodingLevel(),
                                                paoding.isPaodingComprehend(),
                                                paoding.getPaodingToppedTick(),
                                                paoding.getPaodingDachengTick(),
                                                paoding.isPaodingParticle()), (ServerPlayer) player);
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
