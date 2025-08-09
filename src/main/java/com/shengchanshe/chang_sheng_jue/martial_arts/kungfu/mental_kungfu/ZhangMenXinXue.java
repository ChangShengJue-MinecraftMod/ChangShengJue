package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;

public class ZhangMenXinXue extends AbstractionMentalKungfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "zhang_men_xin_xue");

    public ZhangMenXinXue() {
        super(KUNG_FU_ID.toString(), Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.WHITE),
                KungFuType.MENTAL_KUNGFU,Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".mental_kungfu.type"), 0.15f);
    }

    @Override
    public void onInteraction(Player player) {
    }

    @Override
    public void onInteraction(Player player, LivingEntity entity) {
        if (!isReady()) return;
        if (entity instanceof Villager villager) {
            if (level >= 1) {
                VillagerData villagerData1 = villager.getVillagerData();
                if (villagerData1.getLevel() == 1) {
                    villager.setVillagerXp(10);
                }
            }
        }
    }

    @Override
    public void onInteraction(Player player, MerchantOffer merchantOffer) {
        if (!isReady()) return;
        if (level >= 2) {
            if (randomSource.nextFloat() <= (KungFuConfig.ZHANG_MEN_XIN_XUE_EXTRA_PROBABILITY.get() / 100f)) {
                //将物品添加回玩家的背包
                int specialPriceDiff = merchantOffer.getSpecialPriceDiff();
                ItemStack baseCostA = merchantOffer.getBaseCostA();
                ItemStack costB = merchantOffer.getCostB();
                player.getInventory().add(baseCostA.copyWithCount(merchantOffer.getBaseCostA().getCount() + specialPriceDiff));
                player.getInventory().add(costB.copy().copyWithCount( merchantOffer.getCostB().getCount() + specialPriceDiff));
            }
        }else {
            addExp(player, !player.getAbilities().instabuild ? 1 : getMaxExp());
        }
    }

    @Override
    public int getMaxCoolDown() {
        return 0;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public int getMaxExp() {
        return KungFuConfig.ZHANG_MEN_XIN_XUE_MAX_EXP.get();
    }
}
