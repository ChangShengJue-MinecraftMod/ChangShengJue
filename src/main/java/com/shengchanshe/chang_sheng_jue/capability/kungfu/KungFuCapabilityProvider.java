package com.shengchanshe.chang_sheng_jue.capability.kungfu;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class KungFuCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    private final LazyOptional<IKungFuCapability> optional;
    private final IKungFuCapability capability;

    public KungFuCapabilityProvider(LivingEntity entity) {
        this.capability = new KungFuCapability();
        this.optional = LazyOptional.of(() -> this.capability);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return ChangShengJueCapabiliy.KUNGFU.orEmpty(cap, optional);
    }

    @Override
    public CompoundTag serializeNBT() {
        return capability.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        capability.deserializeNBT(nbt);
    }
}