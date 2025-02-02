package com.shengchanshe.changshengjue.capability.martial_arts.xuannu_swordsmanship;

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

public class XuannuSwordsmanshipCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<XuannuSwordsmanshipCapability> XUANNU_SWORDSMANSHIP_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private XuannuSwordsmanshipCapability xuannuSwordsmanshipCapability = null;

    private final LazyOptional<XuannuSwordsmanshipCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private XuannuSwordsmanshipCapability createMartialArtsCapability() {
        if (this.xuannuSwordsmanshipCapability == null){
            this.xuannuSwordsmanshipCapability = new XuannuSwordsmanshipCapability();
        }
        return this.xuannuSwordsmanshipCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == XUANNU_SWORDSMANSHIP_CAPABILITY){
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
