package com.shengchanshe.chang_sheng_jue.capability.martial_arts.wu_gang_cut_gui;

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

public class WuGangCutGuiCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<WuGangCutGuiCapability> WU_GANG_CUT_GUI_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private WuGangCutGuiCapability wuGangCutGuiCapability = null;

    private final LazyOptional<WuGangCutGuiCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private WuGangCutGuiCapability createMartialArtsCapability() {
        if (this.wuGangCutGuiCapability == null){
            this.wuGangCutGuiCapability = new WuGangCutGuiCapability();
        }
        return this.wuGangCutGuiCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == WU_GANG_CUT_GUI_CAPABILITY){
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
