package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.wheat_nugget_encyclopedia.WheatNuggetEncyclopediaCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.zhang_men_xin_xue.ZhangMenXinxueCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.wheat_nugget_encyclopedia.WheatNuggetEncyclopediaClientData;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.WheatNuggetEncyclopediaPacket;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.TradeWithVillagerEvent;

public class WheatNuggetEncyclopediaEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(WheatNuggetEncyclopediaCapabilityProvider.WHEAT_NUGGET_ENCYCLOPEDIA_CAPABILITY).ifPresent(wheatNuggetEncyclopedia -> {
                    if (wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaLevel() != 0 && player.level().getGameTime() % 20 == 0){
                        if (player.experienceLevel >= 30 && wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaUseCount() <= 100){
                            wheatNuggetEncyclopedia.addWheatNuggetEncyclopediaUseCount(100);
                            wheatNuggetEncyclopedia.setWheatNuggetEncyclopediaParticle(true);
                        }
                    }

                    if (wheatNuggetEncyclopedia.isWheatNuggetEncyclopediaParticle()){
                        if (wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaLevel() == 1){
                            wheatNuggetEncyclopedia.setWheatNuggetEncyclopediaToppedTick();
                            ChangShengJueMessages.sendToPlayer(new WheatNuggetEncyclopediaPacket(
                                    wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaToppedTick(),
                                    wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaDachengTick(),
                                    wheatNuggetEncyclopedia.isWheatNuggetEncyclopediaParticle()), (ServerPlayer) player);
                        }else if (wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaLevel() == 2){
                            wheatNuggetEncyclopedia.setWheatNuggetEncyclopediaDachengTick();
                            ChangShengJueMessages.sendToPlayer(new WheatNuggetEncyclopediaPacket(
                                    wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaToppedTick(),
                                    wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaDachengTick(),
                                    wheatNuggetEncyclopedia.isWheatNuggetEncyclopediaParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide) {
                if (WheatNuggetEncyclopediaClientData.isWheatNuggetEncyclopediaParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, WheatNuggetEncyclopediaClientData.getWheatNuggetEncyclopediaToppedTick());
                }
                if (WheatNuggetEncyclopediaClientData.isWheatNuggetEncyclopediaParticle()) {
                    DachengParticle.DachengParticle(player, level, WheatNuggetEncyclopediaClientData.getWheatNuggetEncyclopediaDachengTick());
                }
            }
        }
    }
    public static void onTradeEvent(TradeWithVillagerEvent event) {
        Player player = event.getEntity();
        MerchantOffer merchantOffer = event.getMerchantOffer();
        player.getCapability(WheatNuggetEncyclopediaCapabilityProvider.WHEAT_NUGGET_ENCYCLOPEDIA_CAPABILITY).ifPresent(wheatNuggetEncyclopedia -> {
            if (wheatNuggetEncyclopedia.isWheatNuggetEncyclopediaComprehend()){
                // 随机决定是否获得经验
                if (wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaLevel() <= 1) { // 未大成
                    if (Math.random() < 0.25) { // 25%的概率
                        player.giveExperiencePoints(5); // 获得5点经验
                    }
                } else { // 已大成
                    if (Math.random() < 0.35) { // 35%的概率
                        player.giveExperiencePoints(10); // 获得10点经验
                    }
                }
            }
        });
    }
}
