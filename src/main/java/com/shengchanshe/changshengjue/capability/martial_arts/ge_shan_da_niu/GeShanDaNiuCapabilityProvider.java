package com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu;

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

public class GeShanDaNiuCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<GeShanDaNiuCapability> GE_SHAN_DA_NIU_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private GeShanDaNiuCapability immortalMiracleCapability = null;

    private final LazyOptional<GeShanDaNiuCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private GeShanDaNiuCapability createMartialArtsCapability() {
        if (this.immortalMiracleCapability == null){
            this.immortalMiracleCapability = new GeShanDaNiuCapability();
        }
        return this.immortalMiracleCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == GE_SHAN_DA_NIU_CAPABILITY){
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
