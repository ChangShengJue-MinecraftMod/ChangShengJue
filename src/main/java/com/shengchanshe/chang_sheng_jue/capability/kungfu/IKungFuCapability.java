package com.shengchanshe.chang_sheng_jue.capability.kungfu;

import com.shengchanshe.chang_sheng_jue.martial_arts.IKungFu;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.Collection;
import java.util.Optional;

public interface IKungFuCapability {
    void learnKungFu(ServerPlayer player,String kungFuId);
    void comprehendKungFu(ServerPlayer player, String kungFuId, LivingEntity entity);
    boolean attack(ServerPlayer player, String kungFuId, LivingEntity source, Entity target);
    int getThrowingKnivesCount(String kungFuId);
    float getEffectProbability(String kungFuId);
    void castKungFu(String kungFuId, LivingEntity entity);
    void startKungFu(ServerPlayer player, String kungFuId, String kungFuName);
    boolean isStart(String kungFuId);
    int getCooldownTick(String kungFuId);
    int getKungFuLevel(String kungFuId);
    float getDamageFactor(ServerPlayer player, String kungFuId);
    int getSwingTick(ServerPlayer player, String kungFuId);
    Collection<IKungFu> getAllLearned();
    boolean getComprehendedKungFu(String id);
    Optional<IKungFu> getKungFu(String id);
    void syncToClient(ServerPlayer player);
    void tick(LivingEntity entity);
    void onHurt(DamageSource source, float amount, LivingEntity entity);
    // 序列化到NBT
    CompoundTag serializeNBT();
    void deserializeNBT(CompoundTag nbt);

}
