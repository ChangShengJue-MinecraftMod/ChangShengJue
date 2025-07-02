package com.shengchanshe.chang_sheng_jue.capability.martial_arts.yugong_moves_mountains;

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

public class YugongMovesMountainsCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<YugongMovesMountainsCapability> YUGONG_MOVES_MOUNTAINS_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private YugongMovesMountainsCapability yugongMovesMountainsCapability = null;

    private final LazyOptional<YugongMovesMountainsCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private YugongMovesMountainsCapability createMartialArtsCapability() {
        if (this.yugongMovesMountainsCapability == null){
            this.yugongMovesMountainsCapability = new YugongMovesMountainsCapability();
        }
        return this.yugongMovesMountainsCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == YUGONG_MOVES_MOUNTAINS_CAPABILITY){
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
