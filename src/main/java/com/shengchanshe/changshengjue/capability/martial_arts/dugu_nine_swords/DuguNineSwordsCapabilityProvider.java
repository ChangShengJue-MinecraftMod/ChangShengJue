package com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords;

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

public class DuguNineSwordsCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<DuguNineSwordsCapability> MARTIAL_ARTS_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private DuguNineSwordsCapability martialArtsCapability = null;

    private final LazyOptional<DuguNineSwordsCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private DuguNineSwordsCapability createMartialArtsCapability() {
        if (this.martialArtsCapability == null){
            this.martialArtsCapability = new DuguNineSwordsCapability();
        }
        return this.martialArtsCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == MARTIAL_ARTS_CAPABILITY){
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
