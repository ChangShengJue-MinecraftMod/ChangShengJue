package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.martial_arts.IKungFu;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class QingPingJi extends AbstractionMentalKungfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "qing_ping_ji");
    private static final String ATTACK_MODIFIER_PREFIX = "qing_ping_ji_attack_bonus_";
    private static final String SUPPRESSED_INTERNAL_MARKER = ChangShengJue.MOD_ID + ":qing_ping_suppressed_internal";

    private int stealCount = 0;

    private static final Map<UUID, Set<String>> SUPPRESSED_INTERNAL = new HashMap<>();

    public QingPingJi() {
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

    public void updateSelfState(Player player) {
        if (isActiveSelf()) {
            applySelfAttackBonus(player);
        } else {
            removeSelfAttackBonus(player);
        }
    }

    private boolean isActiveSelf() {
        return isComprehend && isStart && level > 0;
    }

    private void applySelfAttackBonus(Player player) {
        AttributeInstance attackAttribute = player.getAttribute(Attributes.ATTACK_DAMAGE);
        if (attackAttribute == null) {
            return;
        }
        UUID modifierId = getModifierId(player.getUUID());
        double bonus = level >= 2 ? 4.0 : 2.0;
        AttributeModifier existing = attackAttribute.getModifier(modifierId);
        if (existing == null || existing.getAmount() != bonus) {
            if (existing != null) {
                attackAttribute.removeModifier(modifierId);
            }
            attackAttribute.addTransientModifier(new AttributeModifier(
                modifierId,
                ATTACK_MODIFIER_PREFIX + player.getUUID(),
                bonus,
                AttributeModifier.Operation.ADDITION
            ));
        }
    }

    private void removeSelfAttackBonus(Player player) {
        AttributeInstance attackAttribute = player.getAttribute(Attributes.ATTACK_DAMAGE);
        if (attackAttribute == null) {
            return;
        }
        UUID modifierId = getModifierId(player.getUUID());
        attackAttribute.removeModifier(modifierId);
    }

    public static void updateInternalSuppression(Player target) {
        updateInternalSuppressionAndReportChange(target);
    }

    public static boolean updateInternalSuppressionAndReportChange(Player target) {
        boolean suppress = shouldSuppressInternal(target);
        boolean[] changed = {false};
        if (suppress) {
            target.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                Set<String> suppressed = getOrLoadSuppressedInternal(target);
                for (IKungFu kungFu : cap.getAllLearned()) {
                    if (kungFu.getKungFuType() == KungFuType.INTERNAL_KUNGFU && kungFu.isStart()) {
                        if (suppressed.add(kungFu.getId())) {
                            writePersistedSuppressedInternal(target.getPersistentData(), suppressed);
                        }
                        kungFu.startKungFu(false);
                        changed[0] = true;
                    }
                }
            });
            return changed[0];
        }

        return restoreInternalSuppressionAndReportChange(target);
    }

    public static void restoreInternalSuppression(Player target) {
        restoreInternalSuppressionAndReportChange(target);
    }

    public static boolean restoreInternalSuppressionAndReportChange(Player target) {
        boolean[] changed = {false};
        boolean[] capabilityAvailable = {false};
        Set<String> suppressed = getOrLoadSuppressedInternal(target);
        if (!suppressed.isEmpty()) {
            target.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                capabilityAvailable[0] = true;
                for (String id : suppressed) {
                    cap.getKungFu(id).ifPresent(kungFu -> {
                        if (!kungFu.isStart()) {
                            kungFu.startKungFu(true);
                            changed[0] = true;
                        }
                    });
                }
            });
            if (capabilityAvailable[0]) {
                SUPPRESSED_INTERNAL.remove(target.getUUID());
                writePersistedSuppressedInternal(target.getPersistentData(), Set.of());
            }
        } else {
            SUPPRESSED_INTERNAL.remove(target.getUUID());
        }
        return changed[0];
    }

    public static void restoreAllInternalSuppressions(MinecraftServer server) {
        for (Player player : server.getPlayerList().getPlayers()) {
            restoreInternalSuppression(player);
        }
        SUPPRESSED_INTERNAL.clear();
    }

    public static void clearInternalSuppressionTracking() {
        SUPPRESSED_INTERNAL.clear();
    }

    private static Set<String> getOrLoadSuppressedInternal(Player target) {
        return SUPPRESSED_INTERNAL.computeIfAbsent(target.getUUID(), ignored ->
                new HashSet<>(readPersistedSuppressedInternal(target.getPersistentData())));
    }

    static Set<String> readPersistedSuppressedInternal(CompoundTag entityPersistentData) {
        if (!entityPersistentData.contains(Player.PERSISTED_NBT_TAG, Tag.TAG_COMPOUND)) {
            return Set.of();
        }
        CompoundTag persisted = entityPersistentData.getCompound(Player.PERSISTED_NBT_TAG);
        if (!persisted.contains(SUPPRESSED_INTERNAL_MARKER, Tag.TAG_LIST)) {
            return Set.of();
        }
        ListTag ids = persisted.getList(SUPPRESSED_INTERNAL_MARKER, Tag.TAG_STRING);
        Set<String> result = new LinkedHashSet<>();
        for (int i = 0; i < ids.size(); i++) {
            String id = ids.getString(i);
            if (!id.isBlank()) {
                result.add(id);
            }
        }
        return Set.copyOf(result);
    }

    static void writePersistedSuppressedInternal(CompoundTag entityPersistentData, Set<String> suppressed) {
        CompoundTag persisted = entityPersistentData.contains(Player.PERSISTED_NBT_TAG, Tag.TAG_COMPOUND)
                ? entityPersistentData.getCompound(Player.PERSISTED_NBT_TAG)
                : new CompoundTag();
        if (suppressed.isEmpty()) {
            persisted.remove(SUPPRESSED_INTERNAL_MARKER);
        } else {
            ListTag ids = new ListTag();
            suppressed.stream()
                    .filter(id -> id != null && !id.isBlank())
                    .sorted()
                    .map(StringTag::valueOf)
                    .forEach(ids::add);
            if (ids.isEmpty()) {
                persisted.remove(SUPPRESSED_INTERNAL_MARKER);
            } else {
                persisted.put(SUPPRESSED_INTERNAL_MARKER, ids);
            }
        }
        entityPersistentData.put(Player.PERSISTED_NBT_TAG, persisted);
    }

    private static boolean shouldSuppressInternal(Player target) {
        int enabledWanXiang = 0;
        int activeQingPing = 0;
        int targetEntityId = target.getId();
        for (MentalKungFuNeighborhoodSnapshot.Entry entry : MentalKungFuNeighborhoodSnapshot.get(target)) {
            if (entry.wanXiangComprehended() && entry.wanXiangStarted() && entry.wanXiangLevel() > 0) {
                enabledWanXiang++;
            }
            if (entry.entityId() != targetEntityId && entry.qingPingActive()) {
                activeQingPing++;
            }
        }
        return enabledWanXiang < 3 && activeQingPing > 0;
    }

    public boolean tryStealMoney(Player attacker, Player victim) {
        if (attacker.getRandom().nextFloat() > 0.35f) {
            return false;
        }
        if (victim.getAbilities().instabuild) {
            return false;
        }

        Item stolen = stealOneMoneyItem(victim);
        if (stolen == null) {
            return false;
        }
        attacker.getInventory().add(new net.minecraft.world.item.ItemStack(stolen, 1));
        recordSteal(attacker);
        return true;
    }

    public boolean tryStealMoneyFromNpc(Player attacker, LivingEntity victim) {
        if (attacker.getRandom().nextFloat() > 0.35f) {
            return false;
        }
        CompoundTag data = victim.getPersistentData();
        int alreadyStolen = data.getInt("QingPingJiStolen");
        if (alreadyStolen >= 9) {
            return false;
        }

        double maxHealth = victim.getMaxHealth();
        int base = Math.min(2, (int) Math.floor(maxHealth / 10.0));
        int extraSteps = Math.max(0, (int) Math.floor((maxHealth - 20.0) / 10.0));
        int extra = 0;
        for (int i = 0; i < extraSteps; i++) {
            if (attacker.getRandom().nextFloat() < 0.45f) {
                extra++;
            }
        }
        int amount = Math.min(base + extra, 9 - alreadyStolen);
        if (amount <= 0) {
            return false;
        }

        ItemStack stack = new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), amount);
        if (!attacker.getInventory().add(stack)) {
            attacker.drop(stack, false);
        }

        data.putInt("QingPingJiStolen", alreadyStolen + amount);
        recordSteal(attacker);
        return true;
    }

    private Item stealOneMoneyItem(Player victim) {
        List<Item> moneyItems = List.of(
            ChangShengJueItems.YI_GUAN_TONG_QIAN.get(),
            ChangShengJueItems.TONG_QIAN.get(),
            ChangShengJueItems.SILVER_BULLIONS.get(),
            ChangShengJueItems.GOLD_BULLIONS.get()
        );
        List<Item> available = new ArrayList<>();
        for (Item item : moneyItems) {
            if (victim.getInventory().countItem(item) > 0) {
                available.add(item);
            }
        }
        if (available.isEmpty()) {
            return null;
        }
        Item target = available.get(victim.getRandom().nextInt(available.size()));
        for (int i = 0; i < victim.getInventory().getContainerSize(); i++) {
            var stack = victim.getInventory().getItem(i);
            if (!stack.isEmpty() && stack.getItem() == target) {
                stack.shrink(1);
                return target;
            }
        }
        return null;
    }

    private void recordSteal(Player owner) {
        if (!isComprehend || level <= 0) {
            return;
        }
        stealCount++;
        if (stealCount >= KungFuConfig.QING_PING_JI_MASTERY_STEAL_COUNT.get() && level < getMaxLevel()) {
            exp = getMaxExp();
            levelUp(owner);
        }
    }

    public static QingPingJi getKungFu(Player player) {
        var capOpt = player.getCapability(ChangShengJueCapabiliy.KUNGFU);
        if (capOpt.isPresent()) {
            final QingPingJi[] holder = new QingPingJi[1];
            capOpt.ifPresent(cap -> {
                var opt = cap.getKungFu(KUNG_FU_ID.toString());
                if (opt.isPresent() && opt.get() instanceof QingPingJi) {
                    holder[0] = (QingPingJi) opt.get();
                }
            });
            return holder[0];
        }
        return null;
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
        return KungFuConfig.ZHANG_MEN_XIN_XUE_MAX_EXP.get();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = super.serializeNBT();
        tag.putInt("StealCount", this.stealCount);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        super.deserializeNBT(tag);
        if (tag.contains("StealCount", Tag.TAG_INT)) {
            this.stealCount = tag.getInt("StealCount");
        }
    }

    private static UUID getModifierId(UUID playerId) {
        return UUID.nameUUIDFromBytes((ATTACK_MODIFIER_PREFIX + playerId).getBytes(StandardCharsets.UTF_8));
    }
}
