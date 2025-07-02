package com.shengchanshe.chang_sheng_jue.capability.martial_arts.hercules;

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

public class HerculesCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<HerculesCapability> HERCULES_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private HerculesCapability herculesCapability = null;

    private final LazyOptional<HerculesCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private HerculesCapability createMartialArtsCapability() {
        if (this.herculesCapability == null){
            this.herculesCapability = new HerculesCapability();
        }
        return this.herculesCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == HERCULES_CAPABILITY){
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
