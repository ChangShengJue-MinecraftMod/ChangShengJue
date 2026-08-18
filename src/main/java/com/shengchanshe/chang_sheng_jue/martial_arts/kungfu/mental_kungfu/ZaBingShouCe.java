package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.List;

public class ZaBingShouCe extends AbstractionMentalKungfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "za_bing_shou_ce");
    private static final double DETECTION_RANGE = 16.0;
    private static final int BUFF_DURATION_TICKS = 40;
    private static final int MASTERY_TRIGGER_COUNT = 1000;
    private int stackCount = 0;
    private int triggerCount = 0;
    private float pendingHeal = 0.0f;

    public ZaBingShouCe() {
        super(KUNG_FU_ID.toString(), Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.WHITE),
            KungFuType.MENTAL_KUNGFU, Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".mental_kungfu.type"), 0.15f);
    }

    @Override
    public void onInteraction(Player player) {
        // 被动心法，无需主动施展
    }

    @Override
    public void onInteraction(Player player, LivingEntity entity) {
        if (!isReady()) return;
    }

    public boolean updatePassiveState(Player player) {
        PassiveContext context = computePassiveContext(player);
        int oldStackCount = this.stackCount;
        this.stackCount = context.stackCount;
        return oldStackCount != this.stackCount;
    }

    public boolean applyPendingHeal(Player player) {
        if (pendingHeal <= 0.0f || !player.isAlive()) {
            pendingHeal = 0.0f;
            return false;
        }
        float maxHeal = Math.max(0.0f, player.getMaxHealth() - player.getHealth());
        float healAmount = Math.min(pendingHeal, maxHeal);
        int oldTriggerCount = this.triggerCount;
        int oldLevel = this.level;
        if (healAmount > 0.0f) {
            player.heal(healAmount);
            recordTrigger(player);
        }
        pendingHeal = 0.0f;
        return oldTriggerCount != this.triggerCount || oldLevel != this.level;
    }

    public static void applyPassiveToPlayer(Player target) {
        PassiveContext context = computePassiveContext(target);
        if (context.stackCount <= 0) {
            target.removeEffect(ChangShengJueEffects.ZA_BING_SHOU_CE_EFFECT.get());
            return;
        }
        int amplifier = Math.max(0, context.stackCount - 1);
        target.addEffect(new MobEffectInstance(ChangShengJueEffects.ZA_BING_SHOU_CE_EFFECT.get(), BUFF_DURATION_TICKS, amplifier, false, true, true));
    }

    public static void applyHealOnDamage(Player target) {
        PassiveContext context = computePassiveContext(target);
        if (context.stackCount <= 0) {
            return;
        }
        double totalHeal = 0.0;
        for (Contributor contributor : context.contributors) {
            totalHeal += contributor.healAmount;
        }
        ZaBingShouCe selfKungFu = getSelfKungFu(target);
        if (selfKungFu != null) {
            selfKungFu.queueHeal((float) totalHeal);
        }
    }

    private void recordTrigger(Player owner) {
        if (!isComprehend || level <= 0) {
            return;
        }
        triggerCount++;
        if (triggerCount >= MASTERY_TRIGGER_COUNT && level < getMaxLevel()) {
            exp = getMaxExp();
            levelUp(owner);
        }
    }

    private void queueHeal(float amount) {
        if (amount <= 0.0f) {
            return;
        }
        pendingHeal += amount;
    }

    public int getStackCount() {
        return stackCount;
    }

    public static int computeStackCount(Player target) {
        return computePassiveContext(target).stackCount;
    }

    public float getMonsterDamageMultiplier() {
        return getMonsterDamageMultiplier(stackCount);
    }

    public static float getMonsterDamageMultiplier(int stackCount) {
        if (stackCount <= 1) return 1.0f;
        return 1.0f + (stackCount - 1) * 0.025f;
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
        return KungFuConfig.ZA_BIGN_SHOU_CE_MAX_EXP.get();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = super.serializeNBT();
        tag.putInt("TriggerCount", this.triggerCount);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        super.deserializeNBT(tag);
        if (tag.contains("TriggerCount", Tag.TAG_INT)) {
            this.triggerCount = tag.getInt("TriggerCount");
        }
        this.stackCount = 0;
        this.pendingHeal = 0.0f;
    }

    private static PassiveContext computePassiveContext(Player player) {
        AABB searchBox = new AABB(
            player.getX() - DETECTION_RANGE, player.getY() - DETECTION_RANGE, player.getZ() - DETECTION_RANGE,
            player.getX() + DETECTION_RANGE, player.getY() + DETECTION_RANGE, player.getZ() + DETECTION_RANGE
        );

        List<Player> nearbyPlayers = player.level().getEntitiesOfClass(Player.class, searchBox, p -> p.isAlive());
        int stackCount = 0;
        List<Contributor> contributors = new ArrayList<>();
        for (Player nearbyPlayer : nearbyPlayers) {
            ZaBingShouCe kungFu = null;
            var capOpt = nearbyPlayer.getCapability(ChangShengJueCapabiliy.KUNGFU);
            if (capOpt.isPresent()) {
                final ZaBingShouCe[] holder = new ZaBingShouCe[1];
                capOpt.ifPresent(cap -> {
                    var opt = cap.getKungFu(KUNG_FU_ID.toString());
                    if (opt.isPresent() && opt.get() instanceof ZaBingShouCe) {
                        holder[0] = (ZaBingShouCe) opt.get();
                    }
                });
                kungFu = holder[0];
            }
            if (kungFu == null || !kungFu.isComprehend()) {
                continue;
            }
            double healAmount = kungFu.getLevel() >= 2 ? 2.0 : 1.0;
            contributors.add(new Contributor(healAmount));
            stackCount++;
        }

        return new PassiveContext(stackCount, contributors);
    }

    private static final class PassiveContext {
        private final int stackCount;
        private final List<Contributor> contributors;

        private PassiveContext(int stackCount, List<Contributor> contributors) {
            this.stackCount = stackCount;
            this.contributors = contributors;
        }
    }

    private static final class Contributor {
        private final double healAmount;

        private Contributor(double healAmount) {
            this.healAmount = healAmount;
        }
    }

    private static ZaBingShouCe getSelfKungFu(Player player) {
        var capOpt = player.getCapability(ChangShengJueCapabiliy.KUNGFU);
        if (capOpt.isPresent()) {
            final ZaBingShouCe[] holder = new ZaBingShouCe[1];
            capOpt.ifPresent(cap -> {
                var opt = cap.getKungFu(KUNG_FU_ID.toString());
                if (opt.isPresent() && opt.get() instanceof ZaBingShouCe) {
                    holder[0] = (ZaBingShouCe) opt.get();
                }
            });
            return holder[0];
        }
        return null;
    }
}
