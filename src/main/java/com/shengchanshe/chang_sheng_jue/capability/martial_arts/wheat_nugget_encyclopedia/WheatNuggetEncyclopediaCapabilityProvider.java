package com.shengchanshe.chang_sheng_jue.capability.martial_arts.wheat_nugget_encyclopedia;

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

public class WheatNuggetEncyclopediaCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<WheatNuggetEncyclopediaCapability> WHEAT_NUGGET_ENCYCLOPEDIA_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private WheatNuggetEncyclopediaCapability wheatNuggetEncyclopediaCapability = null;

    private final LazyOptional<WheatNuggetEncyclopediaCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private WheatNuggetEncyclopediaCapability createMartialArtsCapability() {
        if (this.wheatNuggetEncyclopediaCapability == null){
            this.wheatNuggetEncyclopediaCapability = new WheatNuggetEncyclopediaCapability();
        }
        return this.wheatNuggetEncyclopediaCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == WHEAT_NUGGET_ENCYCLOPEDIA_CAPABILITY){
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
