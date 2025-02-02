package com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method;

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

public class GoldenBlackKnifeMethodCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<GoldenBlackKnifeMethodCapability> GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private GoldenBlackKnifeMethodCapability goldenBlackKnifeMethodCapability = null;

    private final LazyOptional<GoldenBlackKnifeMethodCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private GoldenBlackKnifeMethodCapability createMartialArtsCapability() {
        if (this.goldenBlackKnifeMethodCapability == null){
            this.goldenBlackKnifeMethodCapability = new GoldenBlackKnifeMethodCapability();
        }
        return this.goldenBlackKnifeMethodCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY){
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
