package com.shengchanshe.chang_sheng_jue.capability.martial_arts.turtle_breath_work;

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

public class TurtleBreathWorkCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<TurtleBreathWorkCapability> TURTLE_BREATH_WORK_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private TurtleBreathWorkCapability turtleBreathWorkCapability = null;

    private final LazyOptional<TurtleBreathWorkCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private TurtleBreathWorkCapability createMartialArtsCapability() {
        if (this.turtleBreathWorkCapability == null){
            this.turtleBreathWorkCapability = new TurtleBreathWorkCapability();
        }
        return this.turtleBreathWorkCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == TURTLE_BREATH_WORK_CAPABILITY){
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
