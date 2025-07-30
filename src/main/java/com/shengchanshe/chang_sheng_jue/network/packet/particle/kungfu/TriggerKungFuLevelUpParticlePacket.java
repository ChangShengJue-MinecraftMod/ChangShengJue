package com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu;

import com.shengchanshe.chang_sheng_jue.cilent.hud.kungfu.KungFuClientData;
import com.shengchanshe.chang_sheng_jue.util.particle.DachengParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public record TriggerKungFuLevelUpParticlePacket(UUID playerUUID,String kungFuId) {

    public void encode(FriendlyByteBuf buf) {
        buf.writeUUID(playerUUID);
        buf.writeUtf(kungFuId);
    }

    public static TriggerKungFuLevelUpParticlePacket decode(FriendlyByteBuf buf) {
        return new TriggerKungFuLevelUpParticlePacket(buf.readUUID(), buf.readUtf());
    }

    public static void handle(TriggerKungFuLevelUpParticlePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Minecraft mc = Minecraft.getInstance();
            if (mc.level == null) return;

            Player player = Minecraft.getInstance().level.getPlayerByUUID(packet.playerUUID());

            if (player != null && player.level() == mc.level) {
                int remainingCooldown = KungFuClientData.get().kungFuLevelUpTick(packet.kungFuId);
                DachengParticle.DachengParticle(player, player.level(), remainingCooldown);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
