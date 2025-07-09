package com.shengchanshe.chang_sheng_jue.item.foods;

import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
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
import java.util.UUID;

@Mod.EventBusSubscriber
public class PorcelainCupsFoodItem extends BlockItem {

    // 存储玩家UUID和是否已减少醉酒状态的映射
    private static final Map<UUID, Boolean> HAS_REDUCED_DRUNKENNESS = new HashMap<>();

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

                boolean reduced = HAS_REDUCED_DRUNKENNESS.getOrDefault(playerUUID, false);

                if (!reduced) {
                    // 获取当前的 DRUNKEN 效果
                    var effect = player.getEffect(ChangShengJueEffects.DRUNKEN.get());

                    //获取原版反胃效果
                    MobEffectInstance effect2 = player.getEffect(MobEffect.byId(9));
                    if (effect != null ) {
                        // 计算新的持续时间
                        int newDuration = Math.max(0, effect.getDuration() - 600); // 减少 30 秒

                        player.removeEffect(ChangShengJueEffects.DRUNKEN.get());


                        // 只有当新持续时间大于0时才重新添加效果
                        if (newDuration > 0) {
                            player.addEffect(new MobEffectInstance(
                                    ChangShengJueEffects.DRUNKEN.get(),
                                    newDuration,
                                    effect.getAmplifier(),
                                    effect.isAmbient(),
                                    effect.isVisible()
                            ));
                        }
                        if(effect2 != null) {
                            int newDuration2 = Math.max(0, effect2.getDuration() - 600);
                            player.removeEffect(MobEffect.byId(9));
                            if (newDuration2 > 0) {
                                player.addEffect(new MobEffectInstance(
                                        MobEffect.byId(9),
                                        newDuration2,
                                        effect2.getAmplifier(),
                                        effect2.isAmbient(),
                                        effect2.isVisible()
                                ));
                            }
                        }

                        // 标记玩家已经减少过这次醉酒状态
                        HAS_REDUCED_DRUNKENNESS.put(playerUUID, true);
                    }
                }
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
            if (!hasDrunkenEffect && HAS_REDUCED_DRUNKENNESS.containsKey(playerUUID)) {
                HAS_REDUCED_DRUNKENNESS.remove(playerUUID);
            }
        }
    }
}