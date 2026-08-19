package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.network.ServerPacketGuard;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ForgeCraftPacket {
    private final BlockPos pos;

    public ForgeCraftPacket(BlockPos pos) {
        this.pos = pos;
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
    }

    public static ForgeCraftPacket fromBytes(FriendlyByteBuf buf) {
        return new ForgeCraftPacket(buf.readBlockPos());
    }

    public static void handle(ForgeCraftPacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            var player = ctx.get().getSender();
            ServerPacketGuard.forgeBlock(player, packet.pos)
                    .ifPresent(entity -> entity.craftCurrentRecipe(player));
        });
        ctx.get().setPacketHandled(true);
    }
}
