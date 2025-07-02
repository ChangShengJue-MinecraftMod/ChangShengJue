package com.shengchanshe.chang_sheng_jue.capability.martial_arts.shaolin_stick_method;

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

public class ShaolinStickMethodCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<ShaolinStickMethodCapability> SHAOLIN_STICK_METHOD_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private ShaolinStickMethodCapability shaolinStickMethodCapability = null;

    private final LazyOptional<ShaolinStickMethodCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private ShaolinStickMethodCapability createMartialArtsCapability() {
        if (this.shaolinStickMethodCapability == null){
            this.shaolinStickMethodCapability = new ShaolinStickMethodCapability();
        }
        return this.shaolinStickMethodCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == SHAOLIN_STICK_METHOD_CAPABILITY){
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
