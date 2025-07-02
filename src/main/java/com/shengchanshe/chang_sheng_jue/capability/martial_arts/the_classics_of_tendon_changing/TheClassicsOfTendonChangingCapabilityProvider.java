package com.shengchanshe.chang_sheng_jue.capability.martial_arts.the_classics_of_tendon_changing;

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

public class TheClassicsOfTendonChangingCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<TheClassicsOfTendonChangingCapability> THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private TheClassicsOfTendonChangingCapability theClassicsOfTendonChangingCapability = null;

    private final LazyOptional<TheClassicsOfTendonChangingCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private TheClassicsOfTendonChangingCapability createMartialArtsCapability() {
        if (this.theClassicsOfTendonChangingCapability == null){
            this.theClassicsOfTendonChangingCapability = new TheClassicsOfTendonChangingCapability();
        }
        return this.theClassicsOfTendonChangingCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY){
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
