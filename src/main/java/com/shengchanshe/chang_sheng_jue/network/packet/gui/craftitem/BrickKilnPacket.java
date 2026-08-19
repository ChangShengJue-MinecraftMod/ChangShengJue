package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.network.ServerPacketGuard;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class BrickKilnPacket {
    private final BlockPos pos;

    public BrickKilnPacket(BlockPos pos) {
        this.pos = pos;
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
    }

    public static BrickKilnPacket fromBytes(FriendlyByteBuf buf) {
        return new BrickKilnPacket(buf.readBlockPos());
    }

    public static void handle(BrickKilnPacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            var player = ctx.get().getSender();
            ServerPacketGuard.brickKiln(player, packet.pos)
                    .ifPresent(entity -> entity.craftCurrentRecipe(player));
        });
        ctx.get().setPacketHandled(true);
    }
}
