package com.shengchanshe.chang_sheng_jue.item.foods;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.nbt.CompoundTag;
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

@Mod.EventBusSubscriber
public class PorcelainCupsFoodItem extends BlockItem {

    private static final String REDUCED_DRUNKENNESS_MARKER =
            ChangShengJue.MOD_ID + ":porcelain_cup_reduced_drunkenness";

    public PorcelainCupsFoodItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide && pEntityLiving instanceof Player) {
            Player player = (Player) pEntityLiving;

            if ((pStack.getItem() == ChangShengJueItems.LONG_JING_TEAS.get() ||
                    pStack.getItem() == ChangShengJueItems.BILUOCHUN_TEAS.get()) &&
                    player.hasEffect(ChangShengJueEffects.DRUNKEN.get())) {

                CompoundTag persistentData = player.getPersistentData();
                boolean reduced = hasReducedDrunkenness(persistentData);

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
                        markReducedDrunkenness(persistentData);
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
        if (entity instanceof Player player && !player.level().isClientSide) {
            updateReducedDrunkenness(
                    player.getPersistentData(), player.hasEffect(ChangShengJueEffects.DRUNKEN.get()));
        }
    }

    static boolean hasReducedDrunkenness(CompoundTag persistentData) {
        return persistentData.getBoolean(REDUCED_DRUNKENNESS_MARKER);
    }

    static void markReducedDrunkenness(CompoundTag persistentData) {
        persistentData.putBoolean(REDUCED_DRUNKENNESS_MARKER, true);
    }

    static void updateReducedDrunkenness(CompoundTag persistentData, boolean hasDrunkenEffect) {
        if (!hasDrunkenEffect) {
            clearReducedDrunkenness(persistentData);
        }
    }

    static void clearReducedDrunkenness(CompoundTag persistentData) {
        persistentData.remove(REDUCED_DRUNKENNESS_MARKER);
    }
}
