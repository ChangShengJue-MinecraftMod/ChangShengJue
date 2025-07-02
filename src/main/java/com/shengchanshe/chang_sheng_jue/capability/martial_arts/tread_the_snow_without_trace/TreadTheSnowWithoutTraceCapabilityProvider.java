package com.shengchanshe.chang_sheng_jue.capability.martial_arts.tread_the_snow_without_trace;

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

public class TreadTheSnowWithoutTraceCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<TreadTheSnowWithoutTraceCapability> TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private TreadTheSnowWithoutTraceCapability treadTheSnowWithoutTraceCapability = null;

    private final LazyOptional<TreadTheSnowWithoutTraceCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private TreadTheSnowWithoutTraceCapability createMartialArtsCapability() {
        if (this.treadTheSnowWithoutTraceCapability == null){
            this.treadTheSnowWithoutTraceCapability = new TreadTheSnowWithoutTraceCapability();
        }
        return this.treadTheSnowWithoutTraceCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY){
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
