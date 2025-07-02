package com.shengchanshe.chang_sheng_jue.capability.martial_arts.paoding;

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

public class PaodingCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PaodingCapability> PAODING_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private PaodingCapability paodingCapability = null;

    private final LazyOptional<PaodingCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private PaodingCapability createMartialArtsCapability() {
        if (this.paodingCapability == null){
            this.paodingCapability = new PaodingCapability();
        }
        return this.paodingCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PAODING_CAPABILITY){
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
