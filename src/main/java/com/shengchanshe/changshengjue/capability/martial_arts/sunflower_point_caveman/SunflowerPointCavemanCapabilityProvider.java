package com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman;

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

public class SunflowerPointCavemanCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<SunflowerPointCavemanCapability> SUNFLOWER_POINT_CAVEMAN_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private SunflowerPointCavemanCapability sunflowerPointCavemanCapability = null;

    private final LazyOptional<SunflowerPointCavemanCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private SunflowerPointCavemanCapability createMartialArtsCapability() {
        if (this.sunflowerPointCavemanCapability == null){
            this.sunflowerPointCavemanCapability = new SunflowerPointCavemanCapability();
        }
        return this.sunflowerPointCavemanCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == SUNFLOWER_POINT_CAVEMAN_CAPABILITY){
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
