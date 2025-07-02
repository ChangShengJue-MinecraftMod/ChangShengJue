package com.shengchanshe.chang_sheng_jue.network.packet.cultivation;

import com.shengchanshe.chang_sheng_jue.cilent.hud.cultivation.spirit.CultivationClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record SpiritDensityLevelPacket(byte densityTier, float currentValue) {

    public static void encode(SpiritDensityLevelPacket packet, FriendlyByteBuf buf) {
        buf.writeByte(packet.densityTier);
        buf.writeFloat(packet.currentValue);
    }

    public static SpiritDensityLevelPacket decode(FriendlyByteBuf buf) {
        return new SpiritDensityLevelPacket( buf.readByte(),
                buf.readFloat());
    }
    public SpiritDensityLevelPacket(byte densityTier, float currentValue){
        this.densityTier = densityTier;
        this.currentValue = currentValue;
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            CultivationClientData.setDensityTier(this.densityTier);
            CultivationClientData.setCurrentValue(this.currentValue);
        });
        return true;
    }
}
