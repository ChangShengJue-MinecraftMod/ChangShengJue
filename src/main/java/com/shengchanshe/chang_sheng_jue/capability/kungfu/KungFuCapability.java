package com.shengchanshe.chang_sheng_jue.capability.kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.init.CSJAdvanceInit;
import com.shengchanshe.chang_sheng_jue.martial_arts.*;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.RelentlessThrowingKnives;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.Hercules;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.TheClassicsOfTendonChanging;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.SyncKungFuCapabilityPacket;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class KungFuCapability implements IKungFuCapability {
    private static final int MAX_SAVED_KUNG_FU_ENTRIES = 128;
    private static final long MALFORMED_NBT_WARNING_INTERVAL_NANOS = TimeUnit.MINUTES.toNanos(1);
    private static final AtomicLong LAST_MALFORMED_NBT_WARNING_NANOS = new AtomicLong();
    private final Map<String, IKungFu> learnedKungFu = new HashMap<>();
    private final Set<IInteranlKungFu> activePassives = new HashSet<>();
    private final Map<String, Integer> lastObservedCooldowns = new HashMap<>();

    @Override
    public void learnKungFu(ServerPlayer player, String kungFuId) {
        // 检查是否已学习该武功
        if (learnedKungFu.containsKey(kungFuId)) {
            if (!learnedKungFu.get(kungFuId).getId().equals(Hercules.KUNG_FU_ID.toString()) && learnedKungFu.get(kungFuId).getKungFuType() != KungFuType.EXTERNAL_KUNFU_GLOVE) {
                if (learnedKungFu.get(kungFuId) instanceof IExternalKunfu externalKunfu) {
                    player.sendSystemMessage(
                            Component.translatable("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.studied.kungfu", learnedKungFu.get(kungFuId).getName(),
                                    learnedKungFu.get(kungFuId).isComprehend()
                                            ? Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu.true.comprehend",
                                            learnedKungFu.get(kungFuId).getDescription(), ((float)externalKunfu.getSwingTick() / 20))
                                            : Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu.fales.comprehend",
                                            learnedKungFu.get(kungFuId).getDescription())
                            ).withStyle(ChatFormatting.YELLOW),false);
                }else if (learnedKungFu.get(kungFuId) instanceof IInteranlKungFu){
                    player.sendSystemMessage(
                            Component.translatable("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.studied.kungfu", learnedKungFu.get(kungFuId).getName(),
                                    learnedKungFu.get(kungFuId).isComprehend()
                                            ? Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu.true.comprehend",
                                            learnedKungFu.get(kungFuId).getDescription())
                                            : Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu.fales.comprehend",
                                            learnedKungFu.get(kungFuId).getDescription())
                            ).withStyle(ChatFormatting.YELLOW),false);
                }else if (learnedKungFu.get(kungFuId) instanceof ILightKungfu) {
                    player.sendSystemMessage(
                            Component.translatable("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.studied.kungfu", learnedKungFu.get(kungFuId).getName(),
                                    learnedKungFu.get(kungFuId).isComprehend()
                                            ? Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu.true.comprehend",
                                            learnedKungFu.get(kungFuId).getDescription())
                                            : Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".light_kungfu.fales.comprehend",
                                            learnedKungFu.get(kungFuId).getDescription())
                            ).withStyle(ChatFormatting.YELLOW),false);
                }else if (learnedKungFu.get(kungFuId) instanceof IMentalKungfu) {
                    player.sendSystemMessage(
                            Component.translatable("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.studied.kungfu", learnedKungFu.get(kungFuId).getName(),
                                    learnedKungFu.get(kungFuId).isComprehend()
                                            ? Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu.true.comprehend",
                                            learnedKungFu.get(kungFuId).getDescription())
                                            : Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".mental_kungfu.fales.comprehend",
                                            learnedKungFu.get(kungFuId).getDescription())
                            ).withStyle(ChatFormatting.YELLOW),false);
                }
            }
            return;
        }
        KungFuRegistry.getInstance().getKungFu(kungFuId).map(kungFu -> {
            learnedKungFu.put(kungFuId, kungFu);
            if (kungFu instanceof IInteranlKungFu passive) {
                activePassives.add(passive);
            }
            if (kungFu.getKungFuType() == KungFuType.EXTERNAL_KUNFU) {
                player.sendSystemMessage(
                        Component.translatable("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.external_kunfu",
                                        learnedKungFu.get(kungFuId).getName(), learnedKungFu.get(kungFuId).getDescription())
                                .withStyle(ChatFormatting.YELLOW),false);
            }else if (kungFu.getKungFuType() == KungFuType.EXTERNAL_KUNFU_GLOVE) {
                player.sendSystemMessage(
                        Component.translatable("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.external_kunfu_glove",
                                        learnedKungFu.get(kungFuId).getName(), learnedKungFu.get(kungFuId).getDescription())
                                .withStyle(ChatFormatting.YELLOW),false);
            }else if (kungFu.getKungFuType() == KungFuType.INTERNAL_KUNGFU) {
                player.sendSystemMessage(
                        Component.translatable("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.internal_kungfu",
                                        learnedKungFu.get(kungFuId).getName(), learnedKungFu.get(kungFuId).getDescription())
                                .withStyle(ChatFormatting.YELLOW),false);
            }else if (kungFu.getKungFuType() == KungFuType.LIGHT_KUNGFU) {
                player.sendSystemMessage(
                        Component.translatable("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.light_kungfu",
                                        learnedKungFu.get(kungFuId).getName(), learnedKungFu.get(kungFuId).getDescription())
                                .withStyle(ChatFormatting.YELLOW),false);
            }else if (kungFu.getKungFuType() == KungFuType.MENTAL_KUNGFU) {
                player.sendSystemMessage(
                        Component.translatable("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.mental_kungfu",
                                        learnedKungFu.get(kungFuId).getName(), learnedKungFu.get(kungFuId).getDescription())
                                .withStyle(ChatFormatting.YELLOW),false);
            }
            CSJAdvanceInit.LEARN_GONG_FA.trigger(player);
            syncToClient(player);
            return true;
        });
    }

    @Override
    public void comprehendKungFu(ServerPlayer player, String kungFuId, LivingEntity entity) {
        getKungFu(kungFuId)
                .filter(kungFu -> kungFu instanceof IKungFu)
                .map(active -> {
                    active.comprehendKungFu(entity);
                    syncToClient(player);
                    return true;
                });
    }

    @Override
    public int getSwingTick(ServerPlayer player, String kungFuId) {
        return getKungFu(kungFuId).filter(kungFu -> kungFu instanceof IExternalKunfu)
                .map(kungFu -> (IExternalKunfu) kungFu)
                .map(IExternalKunfu::getSwingTick)
                .orElse(0);
    }

    @Override
    public int getCooldownTick(String kungFuId) {
        return getKungFu(kungFuId).filter(kungFu -> kungFu instanceof IKungFu)
                .map(IKungFu::getCoolDown)
                .orElse(0);
    }

    @Override
    public int getKungFuLevel(String kungFuId) {
        return getKungFu(kungFuId).filter(kungFu -> kungFu instanceof IKungFuUpgradable)
                .map(kungFu -> (IKungFuUpgradable) kungFu)
                .map(IKungFuUpgradable::getLevel)
                .orElse(0);
    }

    @Override
    public float getDamageFactor(ServerPlayer player, String kungFuId) {
        return getKungFu(kungFuId).filter(kungFu -> kungFu instanceof IExternalKunfu)
                .map(kungFu -> (IExternalKunfu) kungFu)
                .map(IExternalKunfu::getDamageFactor)
                .orElse(0f);
    }

    @Override
    public boolean attack(ServerPlayer player,String kungFuId, LivingEntity source, Entity target) {
        return getKungFu(kungFuId)
                .filter(kungFu -> kungFu instanceof IExternalKunfu)
                .map(kungFu -> (IExternalKunfu)kungFu)
                .map(active -> {
                    active.attackEffect(source, target);
                    syncToClient(player);
                    return true;
                }).orElse(false);
    }

    @Override
    public float getEffectProbability(String kungFuId) {
        return getKungFu(kungFuId)
                .filter(kungFu -> kungFu instanceof IExternalKunfu)
                .map(kungFu -> (IExternalKunfu)kungFu)
                .filter(IExternalKunfu::isAttackReday)
                .map(IExternalKunfu::getEffectProbability).orElse(0.1f);
    }

    @Override
    public void castKungFu(String kungFuId, LivingEntity entity) {
        getKungFu(kungFuId)
                .filter(kungFu -> kungFu instanceof IKungFu)
                .map(kungFu -> (IExternalKunfu) kungFu)
                .filter(IExternalKunfu::isReady)
                .map(active -> {
                    active.release(entity);
                    activePassives.forEach(passive -> {
                        if (passive instanceof TheClassicsOfTendonChanging theClassicsOfTendonChanging){
                            if (theClassicsOfTendonChanging.isReady()) {
                                passive.onInteranKungFu(entity.level(),entity);
                            }
                        }
                    });
                    if (entity instanceof ServerPlayer) {
                        syncToClient((ServerPlayer) entity);
                    }
                    return true;
                });
    }

    @Override
    public void startKungFu(ServerPlayer player, String kungFuId, String kungFuName) {
        if (learnedKungFu.containsKey(kungFuId)) {
            learnedKungFu.forEach((id, kungFu) -> {
                if (!id.equals(kungFuId) && kungFu instanceof IExternalKunfu external) {
                    if (external.isStart() && external.getKungFuType() == KungFuType.EXTERNAL_KUNFU_GLOVE) {
                        external.startKungFu(false);
                    }
                }
            });

            getKungFu(kungFuId)
                    .filter(kungFu -> kungFu instanceof IKungFu)
                    .ifPresent(active -> {
                        boolean newState = !active.isStart();
                        active.startKungFu(newState);

                        syncToClient(player);
                        if (!active.isComprehend()){
                            if (active.getKungFuType() == KungFuType.EXTERNAL_KUNFU_GLOVE){
                                player.sendSystemMessage(
                                        Component.translatable("message.kungfu." + ChangShengJue.MOD_ID + ".state_change.kungfu",
                                                Component.translatable("item."+ ChangShengJue.MOD_ID + "." + kungFuName),
                                                newState ? Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID + ".external_kunfu_glove.open",
                                                        active.getDescription())
                                                        : Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.off")
                                        ).withStyle(ChatFormatting.YELLOW), true);
                            }else if (active.getKungFuType() == KungFuType.INTERNAL_KUNGFU) {
                                player.sendSystemMessage(
                                        Component.translatable("message.kungfu." + ChangShengJue.MOD_ID + ".state_change.kungfu",
                                                Component.translatable("item."+ ChangShengJue.MOD_ID + "." + kungFuName),
                                                newState ? Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu_glove.open",
                                                        active.getDescription())
                                                        : Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.off")
                                        ).withStyle(ChatFormatting.YELLOW), true);
                            }
                        }else {
                            if (active instanceof IExternalKunfu) {
                                player.sendSystemMessage(
                                        Component.translatable("message.kungfu." + ChangShengJue.MOD_ID + ".state_change.kungfu",
                                                Component.translatable("item."+ ChangShengJue.MOD_ID + "." + kungFuName),
                                                newState ? Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.comprehend.open",
                                                        active.getDescription(), ((float)((IExternalKunfu) active).getSwingTick() / 20))
                                                        : Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.off")
                                        ).withStyle(ChatFormatting.YELLOW), true);
                            }else if (active instanceof IInteranlKungFu){
                                player.sendSystemMessage(
                                        Component.translatable("message.kungfu." + ChangShengJue.MOD_ID + ".state_change.kungfu",
                                                Component.translatable("item."+ ChangShengJue.MOD_ID + "." + kungFuName),
                                                newState ? Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu_glove.comprehend.open",
                                                        active.getDescription())
                                                        : Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.off")
                                        ).withStyle(ChatFormatting.YELLOW), true);
                            }
                        }
                    });
        }
    }

    @Override
    public int getThrowingKnivesCount(String kungFuId) {
       return getKungFu(kungFuId).filter(kungFu -> kungFu instanceof IExternalKunfu)
                       .map(kungFu -> (RelentlessThrowingKnives) kungFu)
                       .map(RelentlessThrowingKnives::getThrowingKnivesCount)
                       .orElse(0);
    }

    @Override
    public boolean isStart(String kungFuId) {
        return getKungFu(kungFuId)
                .filter(kungFu -> kungFu instanceof IKungFu)
                .map(IKungFu::isStart).orElse(false);
    }

    @Override
    public Collection<IKungFu> getAllLearned() {
        return Collections.unmodifiableCollection(learnedKungFu.values());
    }

    @Override
    public boolean getComprehendedKungFu(String kungFuId) {
        return getKungFu(kungFuId)
                .filter(kungFu -> kungFu instanceof IExternalKunfu)
                .map(kungFu -> (IExternalKunfu) kungFu)
                .map(IExternalKunfu::isComprehend).orElse(false);
    }

    @Override
    public Optional<IKungFu> getKungFu(String id) {
        return Optional.ofNullable(learnedKungFu.get(id));
    }

    @Override
    public void syncToClient(ServerPlayer player) {
        player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
            ChangShengJueMessages.sendToPlayer(new SyncKungFuCapabilityPacket(cap.serializeNBT()), player);
            learnedKungFu.forEach((id, kungFu) -> lastObservedCooldowns.put(id, kungFu.getCoolDown()));
        });
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        ListTag kungFuList = new ListTag();

        learnedKungFu.forEach((id, kungFu) -> {
            CompoundTag kungFuTag = kungFu.serializeNBT();
            kungFuList.add(kungFuTag);
        });

        tag.put("LearnedKungFu", kungFuList);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        learnedKungFu.clear();
        activePassives.clear();
        lastObservedCooldowns.clear();

        ListTag kungFuList = tag.getList("LearnedKungFu", Tag.TAG_COMPOUND);
        int emptyIds = 0;
        int unknownIds = 0;
        int duplicateIds = 0;
        int invalidEntries = 0;
        int entriesToRead = Math.min(kungFuList.size(), MAX_SAVED_KUNG_FU_ENTRIES);
        for (int index = 0; index < entriesToRead; index++) {
            CompoundTag kungFuTag = kungFuList.getCompound(index);
            String id = kungFuTag.getString("KungFuId");
            if (id.isBlank()) {
                emptyIds++;
                continue;
            }
            if (learnedKungFu.containsKey(id)) {
                duplicateIds++;
                continue;
            }
            Optional<IKungFu> registeredKungFu = KungFuRegistry.getInstance().getKungFu(id);
            if (registeredKungFu.isEmpty()) {
                unknownIds++;
                continue;
            }

            IKungFu kungFu = registeredKungFu.get();
            String storedType = kungFuTag.getString("KungFuType");
            if (!id.equals(kungFu.getId()) || !kungFu.getKungFuType().name().equals(storedType)) {
                invalidEntries++;
                continue;
            }
            try {
                kungFu.deserializeNBT(kungFuTag);
            } catch (RuntimeException exception) {
                invalidEntries++;
                continue;
            }
            if (!id.equals(kungFu.getId()) || !storedType.equals(kungFu.getKungFuType().name())) {
                invalidEntries++;
                continue;
            }
            learnedKungFu.put(id, kungFu);
            if (kungFu instanceof IInteranlKungFu passive) {
                activePassives.add(passive);
            }
        }

        int truncatedEntries = Math.max(0, kungFuList.size() - MAX_SAVED_KUNG_FU_ENTRIES);
        warnAboutRejectedSavedKungFu(emptyIds, unknownIds, duplicateIds, invalidEntries, truncatedEntries);
    }

    private static void warnAboutRejectedSavedKungFu(int emptyIds, int unknownIds, int duplicateIds,
                                                      int invalidEntries, int truncatedEntries) {
        int rejectedEntries = emptyIds + unknownIds + duplicateIds + invalidEntries + truncatedEntries;
        if (rejectedEntries == 0) {
            return;
        }

        long now = System.nanoTime();
        long previous = LAST_MALFORMED_NBT_WARNING_NANOS.get();
        if (previous != 0L && now - previous < MALFORMED_NBT_WARNING_INTERVAL_NANOS) {
            return;
        }
        if (LAST_MALFORMED_NBT_WARNING_NANOS.compareAndSet(previous, now)) {
            ChangShengJue.LOGGER.warn(
                    "忽略武功能力存档中的无效条目：空ID {}，未知ID {}，重复ID {}，非法字段 {}，超限 {}",
                    emptyIds, unknownIds, duplicateIds, invalidEntries, truncatedEntries);
        }
    }

    @Override
    public void tick(LivingEntity entity) {
        tickAndReportChanges(entity);
    }

    @Override
    public boolean tickAndReportChanges(LivingEntity entity) {
        boolean requiresImmediateSync = false;
        for (IKungFu kungFu : learnedKungFu.values()) {
            int cooldownBefore = kungFu.getCoolDown();
            int lastObservedCooldown = lastObservedCooldowns.getOrDefault(kungFu.getId(), cooldownBefore);
            int levelUpBefore = kungFu.getLevelUpTick();
            int dachengBefore = kungFu.getDachengTick();
            kungFu.tickCooldown();
            if (levelUpBefore > 0) {
                kungFu.setLevelUpTick();
            }
            if (dachengBefore > 0) {
                kungFu.setDachengTick();
            }
            if (kungFu instanceof IInteranlKungFu internal) {
                internal.onEntityTick(entity);
            }
            if (kungFu instanceof ILightKungfu lightKungfu){
                lightKungfu.onEntityTick(entity);
            }
            int cooldownAfter = kungFu.getCoolDown();
            int levelUpAfter = kungFu.getLevelUpTick();
            int dachengAfter = kungFu.getDachengTick();
            requiresImmediateSync |= cooldownBefore > lastObservedCooldown;
            requiresImmediateSync |= cooldownBefore > 0 && cooldownAfter == 0;
            requiresImmediateSync |= levelUpBefore == 1 && levelUpAfter > 1;
            requiresImmediateSync |= dachengBefore == 1 && dachengAfter > 1;
            requiresImmediateSync |= levelUpBefore > 0 && levelUpAfter == 0;
            requiresImmediateSync |= dachengBefore > 0 && dachengAfter == 0;
            requiresImmediateSync |= cooldownBefore == 0 && cooldownAfter > 0;
            requiresImmediateSync |= levelUpBefore == 0 && levelUpAfter == 1;
            requiresImmediateSync |= dachengBefore == 0 && dachengAfter == 1;
            lastObservedCooldowns.put(kungFu.getId(), cooldownAfter);
        }
        return requiresImmediateSync;
    }

    @Override
    public void onHurt(LivingDamageEvent event) {
        if (!event.getSource().is(DamageTypes.OUTSIDE_BORDER) && !event.getSource().is(DamageTypes.GENERIC_KILL)) {
            activePassives.forEach(passive -> {
                passive.onEntityHurt(event);
                if (passive instanceof TheClassicsOfTendonChanging theClassicsOfTendonChanging){
                    if (theClassicsOfTendonChanging.isReady()) {
                        passive.onInteranKungFu(event.getEntity().level(), event.getEntity());
                    }
                }
            });
        }
    }

    @Override
    public void onAttack(LivingAttackEvent event) {
        if (!event.getSource().is(DamageTypes.OUTSIDE_BORDER) && !event.getSource().is(DamageTypes.GENERIC_KILL)) {
            activePassives.forEach(passive -> {
                passive.onAttackHurt(event);
                if (passive instanceof TheClassicsOfTendonChanging theClassicsOfTendonChanging){
                    if (theClassicsOfTendonChanging.isReady()) {
                        passive.onInteranKungFu(event.getEntity().level(), event.getEntity());
                    }
                }
            });
        }
    }
}
