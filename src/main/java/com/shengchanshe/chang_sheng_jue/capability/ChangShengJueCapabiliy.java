package com.shengchanshe.chang_sheng_jue.capability;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.cultivation.entity.CultivationCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.cultivation.entity.ICultivationCapability;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class ChangShengJueCapabiliy {
    // Capability 声明
    public static final Capability<ICultivationCapability> SPIRIT_ROOT_CAP =
            CapabilityManager.get(new CapabilityToken<>() {});

    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.register(ICultivationCapability.class);
    }

    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {//判断生物为玩家,只给玩家添加这些能力
            if (!event.getObject().getCapability(CultivationCapabilityProvider.XIU_XIAN_CAPABILITY).isPresent()) {
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID, "spirit_root"), new CultivationCapabilityProvider());
            }
        }
    }

//    public static void onAttachChunkCapabilities(AttachCapabilitiesEvent<LevelChunk> event) {
//        if (!event.getObject().getLevel().isClientSide()) {
//            event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID, "spirit_data"), new SpiritChunkProvider(event.getObject()));
//        }
//    }
}
