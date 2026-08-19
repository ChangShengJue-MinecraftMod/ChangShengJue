package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.network.ServerPacketGuard;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TailoringCraftPacket {
    private final BlockPos pos;

    public TailoringCraftPacket(BlockPos pos) {
        this.pos = pos;
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
    }

    public static TailoringCraftPacket fromBytes(FriendlyByteBuf buf) {
        return new TailoringCraftPacket(buf.readBlockPos());
    }

    public static void handle(TailoringCraftPacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            var player = ctx.get().getSender();
            ServerPacketGuard.tailoringCase(player, packet.pos)
                    .ifPresent(entity -> entity.craftCurrentRecipe(player));
        });
        ctx.get().setPacketHandled(true);
    }
}
