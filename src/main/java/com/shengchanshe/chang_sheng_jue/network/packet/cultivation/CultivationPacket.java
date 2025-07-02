package com.shengchanshe.chang_sheng_jue.network.packet.cultivation;

import com.shengchanshe.chang_sheng_jue.cilent.hud.cultivation.spirit.CultivationClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record CultivationPacket(String stageName,
                                int stageOrdinal,
                                float spiritPower,
                                float spiritPowerMax,
                                float truePower,
                                float truePowerMax,
                                int tunNaTick) {

    public static void encode(CultivationPacket packet, FriendlyByteBuf buf) {
        buf.writeUtf(packet.stageName);
        buf.writeInt(packet.stageOrdinal);
        buf.writeFloat(packet.spiritPower);
        buf.writeFloat(packet.spiritPowerMax);
        buf.writeFloat(packet.truePower);
        buf.writeFloat(packet.truePowerMax);
        buf.writeInt(packet.tunNaTick);
    }

    public static CultivationPacket decode(FriendlyByteBuf buf) {
        return new CultivationPacket(
                buf.readUtf(),
                buf.readInt(),
                buf.readFloat(),
                buf.readFloat(),
                buf.readFloat(),
                buf.readFloat(),
                buf.readInt()
        );
    }
    public CultivationPacket(String stageName, int stageOrdinal, float spiritPower, float spiritPowerMax, float truePower, float truePowerMax, int tunNaTick) {
        this.stageName = stageName;
        this.stageOrdinal = stageOrdinal;
        this.spiritPower = spiritPower;
        this.spiritPowerMax = spiritPowerMax;
        this.truePower = truePower;
        this.truePowerMax = truePowerMax;
        this.tunNaTick = tunNaTick;
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            CultivationClientData.setStageName(this.stageName);
            CultivationClientData.setStageOrdinal(this.stageOrdinal);
            CultivationClientData.setSpiritPower(this.spiritPower);
            CultivationClientData.setSpiritPowerMax(this.spiritPowerMax);
            CultivationClientData.setTruePower(this.truePower);
            CultivationClientData.setTruePowerMax(this.truePowerMax);
            CultivationClientData.setTunNaTick(this.tunNaTick);
        });
        return true;
    }
}
