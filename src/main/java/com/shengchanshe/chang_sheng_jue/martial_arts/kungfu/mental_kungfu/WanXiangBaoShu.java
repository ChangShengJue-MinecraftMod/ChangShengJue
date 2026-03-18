package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class WanXiangBaoShu extends AbstractionMentalKungfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "wan_xiang_bao_shu");
    private static final double DETECTION_RANGE = 16.0; // 检测范围16格
    private static final int BUFF_DURATION_TICKS = 40;
    private static final String ATTACK_MODIFIER_PREFIX = "wan_xiang_bao_shu_attack_bonus_";
    private int stackCount = 0; // 当前叠加层数

    public WanXiangBaoShu() {
        super(KUNG_FU_ID.toString(), Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.WHITE),
                KungFuType.MENTAL_KUNGFU,Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".mental_kungfu.type"), 0.15f);
    }

    @Override
    public void onInteraction(Player player) {
        // 被动心法，无需主动施展
    }

    @Override
    public void onInteraction(Player player, LivingEntity entity) {
        if (!isReady()) return;
    }

    /**
     * 被动效果：对目标玩家应用自定义Buff
     */
    public static void applyPassiveToPlayer(Player target) {
        PassiveContext context = computePassiveContext(target);
        if (context.stackCount <= 0) {
            target.removeEffect(ChangShengJueEffects.WAN_XIANG_BAO_SHU_EFFECT.get());
            clearAttackModifiers(target, Set.of());
            return;
        }
        int amplifier = Math.max(0, context.stackCount - 1);
        target.addEffect(new MobEffectInstance(ChangShengJueEffects.WAN_XIANG_BAO_SHU_EFFECT.get(), BUFF_DURATION_TICKS, amplifier, false, true, true));
        applyPreciseAttackBonus(target, context.contributors);
    }

    /**
     * 被动心法：更新自身状态（层数、自动大成）
     */
    public void updatePassiveState(Player player) {
        PassiveContext context = computePassiveContext(player);
        this.stackCount = context.stackCount;
        if (context.stackCount >= 3 && level < getMaxLevel()) {
            exp = getMaxExp();
            levelUp(player);
        }
    }

    /**
     * 获取当前叠加层数
     */
    public int getStackCount() {
        return stackCount;
    }

    public static int computeStackCount(Player target) {
        return computePassiveContext(target).stackCount;
    }
    /**
     * 计算怪物伤害提升倍率
     * 每叠加1次提高2.5%
     */
    public float getMonsterDamageMultiplier() {
        return getMonsterDamageMultiplier(stackCount);
    }

    public static float getMonsterDamageMultiplier(int stackCount) {
        if (stackCount <= 1) return 1.0f;
        return 1.0f + (stackCount - 1) * 0.025f;
    }

    @Override
    public int getMaxCoolDown() {
        return 0; // 移除冷却
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public int getMaxExp() {
        return 3;
    }

    @Override
    public CompoundTag serializeNBT() {
        return super.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        super.deserializeNBT(tag);
        this.stackCount = 0;
    }

    private static PassiveContext computePassiveContext(Player player) {
        AABB searchBox = new AABB(
            player.getX() - DETECTION_RANGE, player.getY() - DETECTION_RANGE, player.getZ() - DETECTION_RANGE,
            player.getX() + DETECTION_RANGE, player.getY() + DETECTION_RANGE, player.getZ() + DETECTION_RANGE
        );

        List<Player> nearbyPlayers = player.level().getEntitiesOfClass(Player.class, searchBox, LivingEntity::isAlive);
        int stackCount = 0;
        boolean hasMastery = false;
        List<Contributor> contributors = new ArrayList<>();
        for (Player nearbyPlayer : nearbyPlayers) {
            WanXiangBaoShu kungFu = null;
            var capOpt = nearbyPlayer.getCapability(ChangShengJueCapabiliy.KUNGFU);
            if (capOpt.isPresent()) {
                final WanXiangBaoShu[] holder = new WanXiangBaoShu[1];
                capOpt.ifPresent(cap -> {
                    var opt = cap.getKungFu(KUNG_FU_ID.toString());
                    if (opt.isPresent() && opt.get() instanceof WanXiangBaoShu) {
                        holder[0] = (WanXiangBaoShu) opt.get();
                    }
                });
                kungFu = holder[0];
            }
            if (kungFu == null || !kungFu.isComprehend()) {
                continue;
            }
            int level = kungFu.getLevel();
            if (level >= 2) {
                hasMastery = true;
            }
            double bonus = level >= 2 ? 3.0 : 2.0;
            contributors.add(new Contributor(nearbyPlayer.getUUID(), bonus));
            stackCount++;
        }

        return new PassiveContext(stackCount, hasMastery, contributors);
    }

    private static final class PassiveContext {
        private final int stackCount;
        private final boolean hasMastery;
        private final List<Contributor> contributors;

        private PassiveContext(int stackCount, boolean hasMastery, List<Contributor> contributors) {
            this.stackCount = stackCount;
            this.hasMastery = hasMastery;
            this.contributors = contributors;
        }
    }

    private static final class Contributor {
        private final UUID uuid;
        private final double bonus;

        private Contributor(UUID uuid, double bonus) {
            this.uuid = uuid;
            this.bonus = bonus;
        }
    }

    private static void applyPreciseAttackBonus(Player target, List<Contributor> contributors) {
        AttributeInstance attackAttribute = target.getAttribute(Attributes.ATTACK_DAMAGE);
        if (attackAttribute == null) {
            return;
        }
        Set<UUID> expected = new HashSet<>();
        for (Contributor contributor : contributors) {
            UUID modifierId = getModifierId(contributor.uuid);
            expected.add(modifierId);
            AttributeModifier existing = attackAttribute.getModifier(modifierId);
            if (existing == null || existing.getAmount() != contributor.bonus) {
                if (existing != null) {
                    attackAttribute.removeModifier(modifierId);
                }
                attackAttribute.addTransientModifier(new AttributeModifier(
                    modifierId, ATTACK_MODIFIER_PREFIX + contributor.uuid,
                    contributor.bonus, AttributeModifier.Operation.ADDITION
                ));
            }
        }
        clearAttackModifiers(target, expected);
    }

    private static void clearAttackModifiers(Player target, Set<UUID> keep) {
        AttributeInstance attackAttribute = target.getAttribute(Attributes.ATTACK_DAMAGE);
        if (attackAttribute == null) {
            return;
        }
        List<UUID> toRemove = new ArrayList<>();
        for (AttributeModifier modifier : attackAttribute.getModifiers()) {
            if (modifier.getName().startsWith(ATTACK_MODIFIER_PREFIX) && !keep.contains(modifier.getId())) {
                toRemove.add(modifier.getId());
            }
        }
        for (UUID id : toRemove) {
            attackAttribute.removeModifier(id);
        }
    }

    private static UUID getModifierId(UUID contributorId) {
        return UUID.nameUUIDFromBytes((ATTACK_MODIFIER_PREFIX + contributorId).getBytes(StandardCharsets.UTF_8));
    }
}
