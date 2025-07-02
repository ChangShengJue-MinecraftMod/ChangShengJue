package com.shengchanshe.chang_sheng_jue.capability.martial_arts.immortal_miracle;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ImmortalMiracleCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<ImmortalMiracleCapability> IMMORTAL_MIRACLE_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private ImmortalMiracleCapability immortalMiracleCapability = null;

    private final LazyOptional<ImmortalMiracleCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private ImmortalMiracleCapability createMartialArtsCapability() {
        if (this.immortalMiracleCapability == null){
            this.immortalMiracleCapability = new ImmortalMiracleCapability();
        }
        return this.immortalMiracleCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == IMMORTAL_MIRACLE_CAPABILITY){
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        createMartialArtsCapability().saveNBTData(compoundTag);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createMartialArtsCapability().loadNBTData(nbt);
    }
}
