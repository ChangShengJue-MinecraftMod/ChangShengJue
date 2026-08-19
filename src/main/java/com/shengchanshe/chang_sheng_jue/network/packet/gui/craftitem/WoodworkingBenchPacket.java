package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.network.ServerPacketGuard;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class WoodworkingBenchPacket {
    private final BlockPos pos;

    public WoodworkingBenchPacket(BlockPos pos) {
        this.pos = pos;
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
    }

    public static WoodworkingBenchPacket fromBytes(FriendlyByteBuf buf) {
        return new WoodworkingBenchPacket(buf.readBlockPos());
    }

    public static void handle(WoodworkingBenchPacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            var player = ctx.get().getSender();
            ServerPacketGuard.woodworkingBench(player, packet.pos)
                    .ifPresent(entity -> entity.craftCurrentRecipe(player));
        });
        ctx.get().setPacketHandled(true);
    }
}
