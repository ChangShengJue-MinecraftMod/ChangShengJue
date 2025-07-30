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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.*;

public class KungFuCapability implements IKungFuCapability {
    private final Map<String, IKungFu> learnedKungFu = new HashMap<>();
    private final Set<IInteranlKungFu> activePassives = new HashSet<>();

    @Override
    public void learnKungFu(ServerPlayer player, String kungFuId) {
        // 检查是否已学习该武功
        if (learnedKungFu.containsKey(kungFuId)) {
            if (!learnedKungFu.get(kungFuId).getId().equals(Hercules.KUNG_FU_ID.toString()) && learnedKungFu.get(kungFuId).getKungFuType() != KungFuType.EXTERNAL_KUNFU_GLOVE) {
                player.sendSystemMessage(Component.translatable("kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.kungfu"), false);
            }
            return;
        }
        KungFuRegistry.getInstance().getKungFu(kungFuId).map(kungFu -> {
            learnedKungFu.put(kungFuId, kungFu);
            if (kungFu instanceof IInteranlKungFu passive) {
                activePassives.add(passive);
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
    public int getCooldownTick(ServerPlayer player, String kungFuId) {
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
                .filter(IExternalKunfu::isAttackReday)
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
                .map(IExternalKunfu::getEffectProbability).orElse(1.0f);
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

                        player.sendSystemMessage(
                                Component.translatable("message.kungfu." + ChangShengJue.MOD_ID + ".state_change.kungfu",
                                        Component.translatable("item."+ ChangShengJue.MOD_ID + "." + kungFuName),
                                        newState ? Component.translatable("kungfu.open") : Component.translatable("kungfu.off")
                                ).withStyle(ChatFormatting.YELLOW), true);
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

        ListTag kungFuList = tag.getList("LearnedKungFu", Tag.TAG_COMPOUND);
        for (Tag t : kungFuList) {
            CompoundTag kungFuTag = (CompoundTag)t;
            String id = kungFuTag.getString("KungFuId");
            KungFuRegistry.getInstance().getKungFu(id).ifPresent(kungFu -> {
                kungFu.deserializeNBT(kungFuTag);
                learnedKungFu.put(id, kungFu);
                if (kungFu instanceof IInteranlKungFu passive) {
                    activePassives.add(passive);
                }
            });
        }
    }

    @Override
    public void tick(LivingEntity entity) {
        learnedKungFu.values().forEach(kungFu -> {
            kungFu.tickCooldown();
            if (kungFu.getLevelUpTick() > 0) {
                kungFu.setLevelUpTick();
            }
            if (kungFu.getDachengTick() > 0) {
                kungFu.setDachengTick();
            }
            if (kungFu instanceof IInteranlKungFu internal) {
                internal.onEntityTick(entity);
            }
            if (kungFu instanceof ILightKungfu lightKungfu){
                lightKungfu.onEntityTick(entity);
            }
            syncToClient((ServerPlayer) entity);
        });
    }

    @Override
    public void onHurt(DamageSource source, float amount, LivingEntity entity) {
        if (!source.is(DamageTypes.OUTSIDE_BORDER) && !source.is(DamageTypes.GENERIC_KILL)) {
            activePassives.forEach(passive -> {
                passive.onEntityHurt(entity, source, amount);
                if (passive instanceof TheClassicsOfTendonChanging theClassicsOfTendonChanging){
                    if (theClassicsOfTendonChanging.isReady()) {
                        passive.onInteranKungFu(entity.level(),entity);
                    }
                }
            });
        }
    }
}