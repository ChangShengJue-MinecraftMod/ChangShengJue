package com.shengchanshe.chang_sheng_jue.capability.martial_arts.relentless_throwing_knives;

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

public class RelentlessThrowingKnivesCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<RelentlessThrowingKnivesCapability> RELENTLESS_THROWING_KNIVES_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private RelentlessThrowingKnivesCapability relentlessThrowingKnivesCapability = null;

    private final LazyOptional<RelentlessThrowingKnivesCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private RelentlessThrowingKnivesCapability createMartialArtsCapability() {
        if (this.relentlessThrowingKnivesCapability == null){
            this.relentlessThrowingKnivesCapability = new RelentlessThrowingKnivesCapability();
        }
        return this.relentlessThrowingKnivesCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == RELENTLESS_THROWING_KNIVES_CAPABILITY){
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
