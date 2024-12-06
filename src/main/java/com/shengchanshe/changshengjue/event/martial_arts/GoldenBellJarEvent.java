package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_bell_jar.GoldenBellJarClientData;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar.GoldenBellJarPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar.GoldenBellJarPacket2;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class GoldenBellJarEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
                    if (goldenBellJar.getGoldenBellJarUseCooldownPercent() > 0 && goldenBellJar.isGoldenBellJarOff()) {
                        goldenBellJar.setGoldenBellJarUseCooldownPercent();
                        ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                                goldenBellJar.getGoldenBellJarLevel(),
                                goldenBellJar.isGoldenBellJarComprehend(),
                                goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                                goldenBellJar.isGoldenBellJarOff(),
                                goldenBellJar.getGoldenBellJarToppedTick(),
                                goldenBellJar.getGoldenBellJarDachengTick(),
                                goldenBellJar.isGoldenBellJarParticle()), (ServerPlayer) player);
                    }
                    if (goldenBellJar.isGoldenBellJarParticle()){
                        if (goldenBellJar.getGoldenBellJarLevel() == 1){
                            goldenBellJar.setGoldenBellJarToppedTick();
                            ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                                    goldenBellJar.getGoldenBellJarLevel(),
                                    goldenBellJar.isGoldenBellJarComprehend(),
                                    goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                                    goldenBellJar.isGoldenBellJarOff(),
                                    goldenBellJar.getGoldenBellJarToppedTick(),
                                    goldenBellJar.getGoldenBellJarDachengTick(),
                                    goldenBellJar.isGoldenBellJarParticle()), (ServerPlayer) player);
                        }else if (goldenBellJar.getGoldenBellJarLevel() == 2){
                            goldenBellJar.setGoldenBellJarDachengTick();
                            ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                                    goldenBellJar.getGoldenBellJarLevel(),
                                    goldenBellJar.isGoldenBellJarComprehend(),
                                    goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                                    goldenBellJar.isGoldenBellJarOff(),
                                    goldenBellJar.getGoldenBellJarToppedTick(),
                                    goldenBellJar.getGoldenBellJarDachengTick(),
                                    goldenBellJar.isGoldenBellJarParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide){
                if (GoldenBellJarClientData.isGoldenBellJarParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, GoldenBellJarClientData.getGoldenBellJarToppedTick());
                }
                if (GoldenBellJarClientData.isGoldenBellJarParticle()) {
                    DachengParticle.DachengParticle(player, level, GoldenBellJarClientData.getGoldenBellJarDachengTick());
                }
            }
        }
    }

    //生物受伤事件
    public static void onEntityHurt(LivingDamageEvent event) {
        Level level = event.getEntity().level();
        if (!level.isClientSide) {
            if (event.getSource().getDirectEntity() instanceof Player directEntity) {
                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()) {
                    if (!directEntity.isShiftKeyDown()) {
                        event.setAmount(0);
                    }
                    directEntity.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
                        if (goldenBellJar.isGoldenBellJarComprehend() && goldenBellJar.isGoldenBellJarOff() && goldenBellJar.getGoldenBellJarLevel() == 0) {
                            float probability = directEntity.getRandom().nextFloat();
                            float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
                            if (probability < defaultProbability) {
                                goldenBellJar.addGoldenBellJarLevel();
                                goldenBellJar.setGoldenBellJarParticle(true);
                                ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                                        goldenBellJar.getGoldenBellJarLevel(),
                                        goldenBellJar.isGoldenBellJarComprehend(),
                                        goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                                        goldenBellJar.isGoldenBellJarOff(),
                                        goldenBellJar.getGoldenBellJarToppedTick(),
                                        goldenBellJar.getGoldenBellJarDachengTick(),
                                        goldenBellJar.isGoldenBellJarParticle()), (ServerPlayer) directEntity);
                            }
                        }
                    });
                }
            }
        }
    }

    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();
        if (!event.getLevel().isClientSide) {
            player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
                if (goldenBellJar.isGoldenBellJarComprehend() && goldenBellJar.isGoldenBellJarOff() && goldenBellJar.getGoldenBellJarLevel() > 0) {
                    if (goldenBellJar.getGoldenBellJarUseCooldownPercent() <= 0) {
                        if (player.getFoodData().getFoodLevel() > 8) {
                            if (!player.getAbilities().instabuild) {
                                player.getFoodData().eat(-3, -2);//消耗饱食度
                            }
                            if (goldenBellJar.getGoldenBellJarLevel() < 2) {
                                player.addEffect(new MobEffectInstance(ChangShengJueEffects.GOLDEN_BELL_JAR_EFFECT.get(), 120, 0, false, false), player);
                            } else {
                                player.addEffect(new MobEffectInstance(ChangShengJueEffects.GOLDEN_BELL_JAR_EFFECT.get(), 120, 1, false, false), player);
                            }
                            if (goldenBellJar.getGoldenBellJarUseCount() <= 100){
                                goldenBellJar.addGoldenBellJarUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                goldenBellJar.setGoldenBellJarParticle(true);
                            }
                            goldenBellJar.setGoldenBellJarUseCooldownPercent(!player.getAbilities().instabuild ? 160 : 0);
                            ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                                    goldenBellJar.getGoldenBellJarLevel(),
                                    goldenBellJar.isGoldenBellJarComprehend(),
                                    goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                                    goldenBellJar.isGoldenBellJarOff(),
                                    goldenBellJar.getGoldenBellJarToppedTick(),
                                    goldenBellJar.getGoldenBellJarDachengTick(),
                                    goldenBellJar.isGoldenBellJarParticle()), (ServerPlayer) player);
                        }
                    }
                }
            });
        }else {
            boolean goldenBellJarComprehend = GoldenBellJarClientData.isGoldenBellJarComprehend();
            boolean goldenBellJarOff = GoldenBellJarClientData.isGoldenBellJarOff();
            if (goldenBellJarComprehend && goldenBellJarOff){
                if (GoldenBellJarClientData.getGoldenBellJarLevel() >= 1){
                    if (GoldenBellJarClientData.getGoldenBellJarUseCooldownPercent()<=0) {
                        if (player.getFoodData().getFoodLevel() > 8){
                            player.swing(player.getUsedItemHand());
                        }
                    }
                }
            }
        }
    }

    public static void onPlayerRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        ChangShengJueMessages.sendToServer(new GoldenBellJarPacket2());
        Player player = event.getEntity();
        boolean goldenBellJarComprehend = GoldenBellJarClientData.isGoldenBellJarComprehend();
        boolean goldenBellJarOff = GoldenBellJarClientData.isGoldenBellJarOff();
        if (goldenBellJarComprehend && goldenBellJarOff){
            if (GoldenBellJarClientData.getGoldenBellJarLevel() >= 1){
                if (GoldenBellJarClientData.getGoldenBellJarUseCooldownPercent()<=0) {
                    if (player.getFoodData().getFoodLevel() > 8){
                        player.swing(player.getUsedItemHand());
                    }
                }
            }
        }
    }

    public static void onPlayerRightClick(PlayerInteractEvent.RightClickEmpty event) {
        ChangShengJueMessages.sendToServer(new GoldenBellJarPacket2());
        Player player = event.getEntity();
        boolean goldenBellJarComprehend = GoldenBellJarClientData.isGoldenBellJarComprehend();
        boolean goldenBellJarOff = GoldenBellJarClientData.isGoldenBellJarOff();
        if (goldenBellJarComprehend && goldenBellJarOff){
            if (GoldenBellJarClientData.getGoldenBellJarLevel() >= 1){
                if (GoldenBellJarClientData.getGoldenBellJarUseCooldownPercent()<=0) {
                    if (player.getFoodData().getFoodLevel() > 8){
                        player.swing(player.getUsedItemHand());
                    }
                }
            }
        }
    }
}
