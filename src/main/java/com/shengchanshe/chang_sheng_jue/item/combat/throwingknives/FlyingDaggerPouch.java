package com.shengchanshe.chang_sheng_jue.item.combat.throwingknives;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.ChangShengJueConfig;
import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.entity.combat.throwingknives.ThrowingKnivesEntity;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.RelentlessThrowingKnives;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlyingDaggerPouch extends Item {
    private static final String TAG_ITEMS = "StoredDaggers";

    public FlyingDaggerPouch() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if (!pPlayer.level().isClientSide){
            List<ItemStack> daggers = getDaggers(itemstack);

            if(pPlayer.isShiftKeyDown()) {
                return tryTakeOutDagger(pPlayer.level(), pPlayer, itemstack, daggers);
            }
            pPlayer.startUsingItem(pUsedHand);
        }
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseDuration) {
        List<ItemStack> daggers = getDaggers(stack);
        if (user instanceof Player player && !world.isClientSide) {
            int usedTicks = this.getUseDuration(stack) - remainingUseDuration;
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                int swingTick = cap.getSwingTick((ServerPlayer) player, RelentlessThrowingKnives.KUNG_FU_ID.toString());
                if (usedTicks >= swingTick && usedTicks >= 3) {
                    tryThrowDagger(player.level(), player, stack, daggers);
                }
            });
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000; // 最大持续时间（实际由逻辑控制）
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    private InteractionResultHolder<ItemStack> tryThrowDagger(Level level, Player player, ItemStack pouch, List<ItemStack> daggers) {
        if(daggers.isEmpty()) {
            player.displayClientMessage(Component.translatable("message." + ChangShengJue.MOD_ID + ".dagger_pouch.empty"), true);
            return InteractionResultHolder.fail(pouch);
        }
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                ChangShengJueSound.THROWING_KNIVES_SOUND.get(), SoundSource.PLAYERS, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

        if(!level.isClientSide()) {
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                cap.comprehendKungFu((ServerPlayer) player, RelentlessThrowingKnives.KUNG_FU_ID.toString(), player);
                if (cap.getKungFuLevel(RelentlessThrowingKnives.KUNG_FU_ID.toString()) >= 1
                        && cap.getCooldownTick(RelentlessThrowingKnives.KUNG_FU_ID.toString()) <= 0
                        && player.getFoodData().getFoodLevel() > 8 && player.getFoodData().getSaturationLevel() > 0) {
                    int throwingKnivesCount = cap.getThrowingKnivesCount(RelentlessThrowingKnives.KUNG_FU_ID.toString());
                    int i1 = Math.min(daggers.size(), throwingKnivesCount);
                    for (int i = 0; i < i1; i++) {
                        ItemStack daggerStack = daggers.get(daggers.size() - 1);
                        player.awardStat(Stats.ITEM_USED.get(daggerStack.getItem()));
                        daggerStack.hurtAndBreak(1, player, (pPlayer1) -> pPlayer1.broadcastBreakEvent(player.getUsedItemHand()));

                        ThrowingKnivesEntity dagger = new ThrowingKnivesEntity(level, player,daggerStack.copy().split(1));

                        dagger.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5f, 1.5F);
                        level.addFreshEntity(dagger);
                        if (!player.getAbilities().instabuild) {
                            daggers.remove(daggers.size() - 1);
                        }
                        setDaggers(pouch, daggers);
                    }
                } else {
                    ItemStack daggerStack = daggers.get(daggers.size() - 1);
                    player.awardStat(Stats.ITEM_USED.get(daggerStack.getItem()));
                    daggerStack.hurtAndBreak(1, player, (pPlayer1) -> pPlayer1.broadcastBreakEvent(player.getUsedItemHand()));
                    ThrowingKnivesEntity dagger = new ThrowingKnivesEntity(level, player,daggerStack.copy().split(1));

                    dagger.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                    level.addFreshEntity(dagger);
                    if (!player.getAbilities().instabuild) {
                        daggers.remove(daggers.size() - 1);
                    }
                    setDaggers(pouch, daggers);
                }
            });
        }

        return InteractionResultHolder.success(pouch);
    }

    private InteractionResultHolder<ItemStack> tryTakeOutDagger(Level level, Player player, ItemStack pouch, List<ItemStack> daggers) {
        if(daggers.isEmpty()) {
            player.displayClientMessage(Component.translatable("message." + ChangShengJue.MOD_ID + ".dagger_pouch.empty"), true);
            return InteractionResultHolder.fail(pouch);
        }

        if(!level.isClientSide()) {
            ItemStack daggerToGive = daggers.remove(daggers.size() - 1).copy();
            if (player.getInventory().add(daggerToGive)) {
                setDaggers(pouch, daggers);
                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, 1.0F);
                return InteractionResultHolder.success(pouch);
            }
        }

        return InteractionResultHolder.pass(pouch);
    }

    // 获取囊中所有飞刀
    public static List<ItemStack> getDaggers(ItemStack pouch) {
        List<ItemStack> daggers = new ArrayList<>();
        CompoundTag tag = pouch.getOrCreateTag();

        if(tag.contains(TAG_ITEMS)) {
            ListTag itemsTag = tag.getList(TAG_ITEMS, Tag.TAG_COMPOUND);
            for(int i = 0; i < itemsTag.size(); i++) {
                daggers.add(ItemStack.of(itemsTag.getCompound(i)));
            }
        }

        return daggers;
    }

    // 设置囊中飞刀
    public static void setDaggers(ItemStack pouch, List<ItemStack> daggers) {
        CompoundTag tag = pouch.getOrCreateTag();
        ListTag itemsTag = new ListTag();

        for(ItemStack stack : daggers) {
            if(stack.getItem() == ChangShengJueItems.THROWING_KNIVES.get()) { // 只允许存储飞刀
                itemsTag.add(stack.save(new CompoundTag()));
            }
        }

        tag.put(TAG_ITEMS, itemsTag);
    }

    // 尝试向囊中添加飞刀
    public static boolean tryAddDagger(ItemStack pouch, ItemStack dagger) {
        if(dagger.getItem() != ChangShengJueItems.THROWING_KNIVES.get()) return false;

        List<ItemStack> daggers = getDaggers(pouch);
        if(daggers.size() >= ChangShengJueConfig.FLYING_DAGGER_POUCH_MAX_SLOTS.get()) return false;

        daggers.add(dagger.copy().split(1));
        setDaggers(pouch, daggers);
        return true;
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack pStack, Slot pSlot, ClickAction pAction, Player pPlayer) {
        if (pAction == ClickAction.SECONDARY) {
            ItemStack stackInSlot = pSlot.getItem();

            if (stackInSlot.getItem() == ChangShengJueItems.THROWING_KNIVES.get()) {
                if (tryAddDagger(pStack, stackInSlot)) {
                    stackInSlot.shrink(1);
                    pPlayer.level().playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                            SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, 1.0F);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack pouch, ItemStack carriedStack, Slot slot, ClickAction action, Player player, SlotAccess access) {
        if (action == ClickAction.SECONDARY && carriedStack.getItem() == ChangShengJueItems.THROWING_KNIVES.get()) {
            if (tryAddDagger(pouch, carriedStack)) {
                carriedStack.shrink(1);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, 1.0F);
                return true;
            }
        }
        return false;
    }

//    public static boolean isCompatibleDagger(ItemStack stack) {
//        // 检查默认标签
//        return stack.is(CSJTags.COMPATIBLE_DAGGERS) ||
//                // 检查其他常见飞刀标签
//                stack.is(ItemTags.create(new ResourceLocation("forge", "tools/knives"))) ||
//                stack.is(ItemTags.create(new ResourceLocation("c", "daggers")));
//    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        List<ItemStack> daggers = getDaggers(stack);

        tooltip.add(Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".dagger_pouch.count", daggers.size(),
                ChangShengJueConfig.FLYING_DAGGER_POUCH_MAX_SLOTS.get()).withStyle(ChatFormatting.GRAY));

        tooltip.add(Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".flying_dagger_pouch.right_click.tooltip").withStyle(ChatFormatting.GRAY));

        if (Screen.hasShiftDown()) {
            if(daggers.isEmpty()) {
                tooltip.add(Component.translatable("message." + ChangShengJue.MOD_ID + ".dagger_pouch.empty"));
            } else {
                tooltip.add(Component.literal(""));
                tooltip.add(Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".dagger_pouch.contents").withStyle(ChatFormatting.GOLD));

                for(ItemStack dagger : daggers) {
                    tooltip.add(Component.literal(" - ").append(dagger.getHoverName()));
                    // 显示耐久信息
                    if(dagger.isDamageableItem()) {
                        int damage = dagger.getDamageValue();
                        int maxDurability = dagger.getMaxDamage();
                        tooltip.add(Component.literal("   ").append(Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".durability",
                                        maxDurability - damage, maxDurability).withStyle(ChatFormatting.DARK_GREEN)));
                    }
//                    // 显示附魔信息
                    Map<Enchantment, Integer> enchants = EnchantmentHelper.getEnchantments(dagger);
                    if(!enchants.isEmpty()) {
                        for(Map.Entry<Enchantment, Integer> entry : enchants.entrySet()) {
                            tooltip.add(Component.literal("   ").append(entry.getKey().getFullname(entry.getValue())));
                        }
                    }
                }
            }
        } else {
            tooltip.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID +".hold_shift.tooltip"));
        }
    }
}
