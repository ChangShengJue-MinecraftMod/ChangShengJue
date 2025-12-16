package com.shengchanshe.chang_sheng_jue.event.combat;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber
public class SharpeningEventHandler {
    private static final Random RANDOM = new Random();

    /**
     * 在物品工具提示中添加打磨加成显示
     */
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();

        if (itemStack.getTag() != null && itemStack.hasTag() && itemStack.getTag().contains("SharpeningBonus")) {
            float sharpeningBonus = itemStack.getTag().getFloat("SharpeningBonus");

            if (sharpeningBonus > 0) {
                List<Component> tooltip = event.getToolTip();

                Component bonusText = Component.literal(" ")
                    .append(Component.translatable("attribute.modifier.plus.0",
                        ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(sharpeningBonus),
                        Component.translatable("attribute.name.generic.attack_damage"))
                        .withStyle(ChatFormatting.BLUE));

                tooltip.add(bonusText);
            }
        }
    }

    /**
     * 在造成伤害时应用打磨加成
     */
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) {
            return;
        }

        ItemStack weapon = player.getMainHandItem();
        if (weapon.isEmpty()) {
            return;
        }

        if (weapon.getTag() != null && weapon.hasTag() && weapon.getTag().contains("SharpeningBonus")) {
            float sharpeningBonus = weapon.getTag().getFloat("SharpeningBonus");

            if (sharpeningBonus > 0) {
                // 增加伤害
                event.setAmount(event.getAmount() + sharpeningBonus);
            }
        }
    }

    /**
     * 打磨后的武器每次使用时有 5*(打磨次数+1)% 的概率消耗2点耐久
     */
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        // 获取攻击者
        if (!(event.getSource().getEntity() instanceof Player player)) {
            return;
        }

        // 获取玩家手持的武器
        ItemStack weapon = player.getMainHandItem();
        if (weapon.isEmpty()) {
            return;
        }

        // 检查武器是否被打磨过
        if (weapon.getTag() == null || !weapon.getTag().contains("SharpeningCount")) {
            return;
        }

        int sharpeningCount = weapon.getTag().getInt("SharpeningCount");
        if (sharpeningCount <= 0) {
            return;
        }

        // 计算额外耐久消耗的概率: 5*(打磨次数+1)%
        int chance = 5 * (sharpeningCount + 1);
        // 限制最大概率为100%
        chance = Math.min(chance, 100);

        // 随机判断是否触发额外耐久消耗
        if (RANDOM.nextInt(100) < chance) {
            // 消耗额外1点耐久
            weapon.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }
    }
}
