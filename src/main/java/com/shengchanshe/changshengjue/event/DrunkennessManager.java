package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber
public class DrunkennessManager {
    // 存储玩家UUID和是否已减少醉酒状态的映射
    private static final Map<UUID, Boolean> hasReducedDrunkenness = new HashMap<>();

    /**
     * 尝试减少玩家的醉酒状态
     * @param player 玩家实体
     * @return 如果成功减少返回true，否则返回false
     */
    public static boolean tryReduceDrunkenness(Player player) {
        if (player == null || !player.hasEffect(ChangShengJueEffects.DRUNKEN.get())) {
            return false;
        }

        UUID playerUUID = player.getUUID();
        boolean reduced = hasReducedDrunkenness.getOrDefault(playerUUID, false);

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
                hasReducedDrunkenness.put(playerUUID, true);
            }
        }

        return false;
    }

    /**
     * 检查玩家是否有未处理的醉酒状态
     * @param player 玩家实体
     * @return 如果玩家有醉酒状态且尚未减少过返回true
     */
    public static boolean canReduceDrunkenness(Player player) {
        if (player == null || !player.hasEffect(ChangShengJueEffects.DRUNKEN.get())) {
            return false;
        }

        UUID playerUUID = player.getUUID();
        return !hasReducedDrunkenness.getOrDefault(playerUUID, false);
    }

    /**
     * 清除玩家的醉酒状态标记
     * 通常在醉酒效果结束时调用
     */
    public static void clearReductionFlag(Player player) {
        if (player != null) {
            hasReducedDrunkenness.remove(player.getUUID());
        }
    }

    // 监听实体更新事件，当醉酒效果结束时清除标记
    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        var entity = event.getEntity();
        if (entity instanceof Player player) {
            // 检查玩家是否有醉酒效果
            boolean hasDrunkenEffect = player.hasEffect(ChangShengJueEffects.DRUNKEN.get());

            // 如果玩家没有醉酒效果但有标记，则清除标记
            UUID playerUUID = player.getUUID();
            if (!hasDrunkenEffect && hasReducedDrunkenness.containsKey(playerUUID)) {
                hasReducedDrunkenness.remove(playerUUID);
            }
        }
    }
}