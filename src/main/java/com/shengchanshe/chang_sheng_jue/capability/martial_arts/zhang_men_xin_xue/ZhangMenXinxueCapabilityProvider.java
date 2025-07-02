package com.shengchanshe.chang_sheng_jue.capability.martial_arts.zhang_men_xin_xue;

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

public class ZhangMenXinxueCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<ZhangMenXinxueCapability> ZHANG_MEN_XIN_XUE_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});

    private ZhangMenXinxueCapability zhangMenXinxueCapability = null;

    private final LazyOptional<ZhangMenXinxueCapability> optional = LazyOptional.of(this::createMartialArtsCapability);

    private ZhangMenXinxueCapability createMartialArtsCapability() {
        if (this.zhangMenXinxueCapability == null){
            this.zhangMenXinxueCapability = new ZhangMenXinxueCapability();
        }
        return this.zhangMenXinxueCapability;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ZHANG_MEN_XIN_XUE_CAPABILITY){
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
