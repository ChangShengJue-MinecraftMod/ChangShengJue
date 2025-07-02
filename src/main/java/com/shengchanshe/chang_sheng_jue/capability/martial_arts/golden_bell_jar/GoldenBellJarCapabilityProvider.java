package com.shengchanshe.chang_sheng_jue.capability.martial_arts.golden_bell_jar;

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

public class GoldenBellJarCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<GoldenBellJarCapability> GOLDEN_BELL_JAR_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private GoldenBellJarCapability goldenBellJarCapability = null;

    private final LazyOptional<GoldenBellJarCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private GoldenBellJarCapability createMartialArtsCapability() {
        if (this.goldenBellJarCapability == null){
            this.goldenBellJarCapability = new GoldenBellJarCapability();
        }
        return this.goldenBellJarCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == GOLDEN_BELL_JAR_CAPABILITY){
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
