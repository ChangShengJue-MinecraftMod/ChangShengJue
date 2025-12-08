package com.shengchanshe.chang_sheng_jue.event.combat;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;
import java.util.UUID;

@Mod.EventBusSubscriber
public class SharpeningEventHandler {
    private static final UUID SHARPENING_UUID = UUID.fromString("d8a5d8c5-8b8a-4f8a-8d8c-5a8b8f8a8d8c");
    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onItemAttributeModifier(ItemAttributeModifierEvent event) {
        ItemStack itemStack = event.getItemStack();

        if (itemStack.getTag() != null && itemStack.hasTag() && itemStack.getTag().contains("SharpeningBonus")) {
            float sharpeningBonus = itemStack.getTag().getFloat("SharpeningBonus");

            if (sharpeningBonus > 0) {
                if (event.getSlotType() == EquipmentSlot.MAINHAND) {
                    AttributeModifier modifier = new AttributeModifier(
                            SHARPENING_UUID, "sharpening_damage_bonus",
                            sharpeningBonus, AttributeModifier.Operation.ADDITION);

                    event.addModifier(Attributes.ATTACK_DAMAGE, modifier);
                }
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