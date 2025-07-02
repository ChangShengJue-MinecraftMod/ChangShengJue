package com.shengchanshe.chang_sheng_jue.capability.cultivation.entity;

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

public class CultivationCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<CultivationCapability> XIU_XIAN_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private CultivationCapability xiuXianCapability = null;

    private final LazyOptional<CultivationCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private CultivationCapability createMartialArtsCapability() {
        if (this.xiuXianCapability == null){
            this.xiuXianCapability = new CultivationCapability();
        }
        return this.xiuXianCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == XIU_XIAN_CAPABILITY){
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        createMartialArtsCapability().serializeNBT(compoundTag);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createMartialArtsCapability().deserializeNBT(nbt);
    }
}
