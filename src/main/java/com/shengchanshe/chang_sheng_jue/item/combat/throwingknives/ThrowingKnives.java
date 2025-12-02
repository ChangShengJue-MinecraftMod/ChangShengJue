package com.shengchanshe.chang_sheng_jue.item.combat.throwingknives;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.entity.combat.throwingknives.ThrowingKnivesEntity;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.RelentlessThrowingKnives;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nullable;
import java.util.List;

public class ThrowingKnives extends SwordItem {
    public ThrowingKnives() {
        super(Tiers.IRON, 1, -2.4F, new Item.Properties().durability(250));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand hand) {
        ItemStack itemstack = pPlayer.getItemInHand(hand);
        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), ChangShengJueSound.THROWING_KNIVES_SOUND.get(), SoundSource.PLAYERS, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            pPlayer.startUsingItem(hand);
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }


    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseDuration) {
        if (!world.isClientSide) {
            int usedTicks = this.getUseDuration(stack) - remainingUseDuration;
            if (user instanceof Player pPlayer) {
                if (usedTicks >= 3) {
                    pPlayer.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                        cap.comprehendKungFu((ServerPlayer) pPlayer, RelentlessThrowingKnives.KUNG_FU_ID.toString(), pPlayer);
                    });
                    pPlayer.awardStat(Stats.ITEM_USED.get(this));
                    stack.hurtAndBreak(1, pPlayer, (pPlayer1) -> {
                        pPlayer1.broadcastBreakEvent(pPlayer.getUsedItemHand());
                    });
                    ThrowingKnivesEntity feiDaoEntity = new ThrowingKnivesEntity(world, pPlayer, stack);
                    feiDaoEntity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 2.5F, 1.0F);
                    world.addFreshEntity(feiDaoEntity);
                    if (!pPlayer.getAbilities().instabuild) {
                        pPlayer.getInventory().removeItem(stack);
                    }
                }
            }
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        if (ModList.get().isLoaded("epicfight")) {
            return Integer.MAX_VALUE;
        }
        return 72000; // 最大持续时间（实际由逻辑控制）
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".throwing_knives.right_click.tooltip").withStyle(ChatFormatting.GRAY));

    }
}
