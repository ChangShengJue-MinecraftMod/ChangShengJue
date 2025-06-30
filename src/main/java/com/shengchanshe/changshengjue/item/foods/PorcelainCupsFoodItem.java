package com.shengchanshe.changshengjue.item.foods;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.event.DrunkennessManager;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Mod.EventBusSubscriber
public class PorcelainCupsFoodItem extends BlockItem {

    // 存储玩家UUID和是否已减少醉酒状态的映射
    private static final Map<UUID, Boolean> hasReducedDrunkenness = new HashMap<>();

    public PorcelainCupsFoodItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide && pEntityLiving instanceof Player) {
            Player player = (Player) pEntityLiving;
            UUID playerUUID = player.getUUID();

            if ((pStack.getItem() == ChangShengJueItems.LONG_JING_TEAS.get() ||
                    pStack.getItem() == ChangShengJueItems.BILUOCHUN_TEAS.get()) &&
                    player.hasEffect(ChangShengJueEffects.DRUNKEN.get())) {

                DrunkennessManager.tryReduceDrunkenness(player);
            }
        }

        ItemStack itemstack = super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pEntityLiving instanceof Player && ((Player)pEntityLiving).getAbilities().instabuild ?
                itemstack : new ItemStack(ChangShengJueItems.CI_BEI.get());
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    // 监听实体更新事件，当醉酒效果结束时清除标记
    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Player) {
            Player player = (Player) entity;
            UUID playerUUID = player.getUUID();

            // 检查玩家是否有醉酒效果
            boolean hasDrunkenEffect = player.hasEffect(ChangShengJueEffects.DRUNKEN.get());

            // 如果玩家没有醉酒效果但有标记，则清除标记
            if (!hasDrunkenEffect && hasReducedDrunkenness.containsKey(playerUUID)) {
                hasReducedDrunkenness.remove(playerUUID);
            }
        }
    }
}