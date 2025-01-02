package com.shengchanshe.changshengjue.capability.martial_arts.qian_kun_da_nuo_yi;

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

public class QianKunDaNuoYiCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<QianKunDaNuoYiCapability> QIAN_KUN_DA_NUO_YI_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private QianKunDaNuoYiCapability qianKunDaNuoYiCapability = null;

    private final LazyOptional<QianKunDaNuoYiCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private QianKunDaNuoYiCapability createMartialArtsCapability() {
        if (this.qianKunDaNuoYiCapability == null){
            this.qianKunDaNuoYiCapability = new QianKunDaNuoYiCapability();
        }
        return this.qianKunDaNuoYiCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == QIAN_KUN_DA_NUO_YI_CAPABILITY){
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
