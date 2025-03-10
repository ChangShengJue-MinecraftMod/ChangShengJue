package com.shengchanshe.changshengjue.entity.villagers.warrior.kungfu;

import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.immortal_miracle.ImmortalMiraclePacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ImmortalMiracle implements KungFuCapability {

    @Override
    public void applyAttackEffect(LivingEntity livingEntity, Entity target) {

    }

    @Override
    public void saveNBTData(CompoundTag compound) {
    }

    @Override
    public void loadNBTData(CompoundTag compound) {

    }

    @Override
    public String getID() {
        return "ImmortalMiracle";
    }

}
