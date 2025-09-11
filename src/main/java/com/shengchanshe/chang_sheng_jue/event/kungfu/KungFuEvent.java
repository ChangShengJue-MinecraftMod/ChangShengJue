package com.shengchanshe.chang_sheng_jue.event.kungfu;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.cilent.hud.kungfu.KungFuClientData;
import com.shengchanshe.chang_sheng_jue.item.combat.glove.GoldThreadGlove;
import com.shengchanshe.chang_sheng_jue.martial_arts.IKungFu;
import com.shengchanshe.chang_sheng_jue.martial_arts.IMentalKungfu;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.GeShanDaNiu;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.SunflowerPointCaveman;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.TurtleBreathWork;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.QianKunDaNuoYi;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu.WheatNuggetEncyclopedia;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu.ZhangMenXinXue;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu.TriggerKungFuLevelUpParticlePacket;
import com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu.TriggerKungFuParticlePacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.TradeWithVillagerEvent;

public class KungFuEvent {
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            if (!player.level().isClientSide){
                player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                    cap.tick(player);
                });
                for (String kungFuId : KungFuClientData.get().getComprehendTickKungFu()) {
                    ChangShengJueMessages.sendToPlayer(new TriggerKungFuParticlePacket(player.getUUID(), kungFuId), (ServerPlayer) player);
                }
                for (String kungFuId : KungFuClientData.get().getLevelUpTickKungFu()) {
                    ChangShengJueMessages.sendToPlayer(new TriggerKungFuLevelUpParticlePacket(player.getUUID(), kungFuId), (ServerPlayer) player);
                }
            }
        }
    }

    public static void onEntityHurt(LivingDamageEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide) {
            LivingEntity entity = event.getEntity();
            if (event.getSource().getEntity() instanceof Player player) {
                if (player.getMainHandItem().isEmpty() || player.getMainHandItem().getItem() instanceof GoldThreadGlove) {
                    player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                        if (cap.isStart(GeShanDaNiu.KUNG_FU_ID.toString())) {
                            cap.attack((ServerPlayer) player, GeShanDaNiu.KUNG_FU_ID.toString(), player, entity);
                        } else if (cap.isStart(SunflowerPointCaveman.KUNG_FU_ID.toString())) {
                            cap.attack((ServerPlayer) player, SunflowerPointCaveman.KUNG_FU_ID.toString(), player, entity);
                        } else if (cap.isStart(TurtleBreathWork.KUNG_FU_ID.toString())) {
                            cap.attack((ServerPlayer) player, TurtleBreathWork.KUNG_FU_ID.toString(), player, entity);
                        }
                    });
                }
            }
            if (event.getEntity() instanceof Player player && event.getSource().getEntity() != null) {
                if ((player.getFoodData().getFoodLevel() > 8 && player.getFoodData().getSaturationLevel() > 0)) {
                    player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                        cap.getAllLearned().forEach(id -> {
                            if (!id.getId().equals(QianKunDaNuoYi.KUNG_FU_ID.toString())) {
                                cap.onHurt(event);
                            }
                        });
                    });
                }
            }
        }
    }

    public static void onEntityHurt(LivingAttackEvent event) {
        if (event.getEntity() instanceof Player player && event.getSource().getEntity() != null) {
            if ((player.getFoodData().getFoodLevel() > 8 && player.getFoodData().getSaturationLevel() > 0)) {
                player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                    cap.getKungFu(QianKunDaNuoYi.KUNG_FU_ID.toString())
                            .filter(kungFu -> kungFu instanceof IKungFu)
                            .map(kungFu -> (QianKunDaNuoYi) kungFu)
                            .map(active -> {
                                cap.onAttack(event);
                                if (player instanceof ServerPlayer) {
                                    cap.syncToClient((ServerPlayer) player);
                                }
                                return true;
                            });
                });
            }
        }
    }

    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract event){
        Player pPlayer = event.getEntity();
        if (!pPlayer.level().isClientSide) {
            pPlayer.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                cap.comprehendKungFu((ServerPlayer) pPlayer, WheatNuggetEncyclopedia.KUNG_FU_ID.toString(), pPlayer);
                cap.comprehendKungFu((ServerPlayer) pPlayer, ZhangMenXinXue.KUNG_FU_ID.toString(), pPlayer);
            });
        }
    }

    public static void onTradeEvent(TradeWithVillagerEvent event) {
        Player player = event.getEntity();
        MerchantOffer merchantOffer = event.getMerchantOffer();
        if (!player.level().isClientSide) {
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                cap.getKungFu(WheatNuggetEncyclopedia.KUNG_FU_ID.toString())
                        .filter(kungFu -> kungFu instanceof IMentalKungfu).ifPresent(active -> {
                            ((IMentalKungfu) active).onInteraction(player);
                            cap.syncToClient((ServerPlayer) player);
                        });
                cap.getKungFu(ZhangMenXinXue.KUNG_FU_ID.toString())
                        .filter(kungFu -> kungFu instanceof IMentalKungfu).ifPresent(active -> {
                            ((IMentalKungfu) active).onInteraction(player, merchantOffer);
                            cap.syncToClient((ServerPlayer) player);
                        });
            });
        }
    }

    public static void onVillagerInteract(PlayerInteractEvent.EntityInteractSpecific event) {
        Player player = event.getEntity();
        if (!player.level().isClientSide) {
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                cap.getKungFu(ZhangMenXinXue.KUNG_FU_ID.toString())
                        .filter(kungFu -> kungFu instanceof IMentalKungfu).ifPresent(active -> {
                            if (event.getTarget() instanceof LivingEntity livingEntity) {
                                ((IMentalKungfu) active).onInteraction(player, livingEntity);
                            }
                            cap.syncToClient((ServerPlayer) player);
                        });
            });
        }
    }
}
