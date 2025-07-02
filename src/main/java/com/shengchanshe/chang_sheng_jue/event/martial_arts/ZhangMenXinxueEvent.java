package com.shengchanshe.chang_sheng_jue.event.martial_arts;

import com.shengchanshe.chang_sheng_jue.capability.martial_arts.zhang_men_xin_xue.ZhangMenXinxueCapabilityProvider;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.TradeWithVillagerEvent;

public class ZhangMenXinxueEvent {
    public static void onVillagerInteract(PlayerInteractEvent.EntityInteractSpecific event) {
        Player player = event.getEntity();
        player.getCapability(ZhangMenXinxueCapabilityProvider.ZHANG_MEN_XIN_XUE_CAPABILITY).ifPresent(zhangMenXinxueCapability -> {
            if (zhangMenXinxueCapability.isZhangMenXinxueComprehend()){
                if (event.getTarget() instanceof Villager villager) {
                    VillagerData villagerData1 = villager.getVillagerData();
                    if (villagerData1.getLevel() == 1) {
                        villager.setVillagerXp(10);
                    }
                }
            }
        });
    }

    public static void onTradeEvent(TradeWithVillagerEvent event) {
        Player player = event.getEntity();
        MerchantOffer merchantOffer = event.getMerchantOffer();
        player.getCapability(ZhangMenXinxueCapabilityProvider.ZHANG_MEN_XIN_XUE_CAPABILITY).ifPresent(zhangMenXinxueCapability -> {
            if (zhangMenXinxueCapability.isZhangMenXinxueComprehend()){
                // 随机决定是否消耗物品
                if (Math.random() > (zhangMenXinxueCapability.getZhangMenXinxueLevel() <= 1 ? 1 : 0.9)) {  //10% 的概率不消耗物品
        //             将物品添加回玩家的背包
                        int specialPriceDiff = merchantOffer.getSpecialPriceDiff();
                        ItemStack baseCostA = merchantOffer.getBaseCostA();
                        ItemStack costB = merchantOffer.getCostB();
                        player.getInventory().add(baseCostA.copyWithCount(merchantOffer.getBaseCostA().getCount() + specialPriceDiff));
                        player.getInventory().add(costB.copy().copyWithCount( merchantOffer.getCostB().getCount() + specialPriceDiff));
                }
                if (zhangMenXinxueCapability.getZhangMenXinxueUseCount() <= 100){
                    zhangMenXinxueCapability.addZhangMenXinxueUseCount(!player.getAbilities().instabuild ? 1 : 100);
                }
            }
        });
    }
}
