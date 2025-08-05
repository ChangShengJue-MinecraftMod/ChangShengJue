package com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu;

import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record WuGangCutGuiParticlePacket(float x, float y, float z) {

    public void encode(FriendlyByteBuf buf) {
        buf.writeFloat(x);
        buf.writeFloat(y);
        buf.writeFloat(z);
    }

    public static WuGangCutGuiParticlePacket decode(FriendlyByteBuf buf) {
        return new WuGangCutGuiParticlePacket(buf.readFloat(), buf.readFloat(), buf.readFloat());
    }

    public static void handle(WuGangCutGuiParticlePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Minecraft mc = Minecraft.getInstance();
            if (mc.level == null) return;
            mc.level.addParticle(ChangShengJueParticles.WU_GANG_CUT_GUI_PARTICLE_1.get(), packet.x, packet.y, packet.z, 0, 0, 0);
        });
        ctx.get().setPacketHandled(true);
    }
}
