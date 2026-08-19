package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.plaque;

import com.shengchanshe.chang_sheng_jue.block.custom.plaque.PlaqueTextLayout;
import com.shengchanshe.chang_sheng_jue.network.ServerPacketGuard;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdatePlaqueTextPacket {
    public static final int MAX_TEXT_LENGTH = PlaqueTextLayout.MAX_TEXT_LENGTH;

    private final BlockPos pos;
    private final String text;

    public UpdatePlaqueTextPacket(BlockPos pos, String text) {
        this.pos = pos;
        this.text = text;
    }

    public UpdatePlaqueTextPacket(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos();
        this.text = buf.readUtf(MAX_TEXT_LENGTH);
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeUtf(text, MAX_TEXT_LENGTH);
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        NetworkEvent.Context networkContext = context.get();
        try {
            networkContext.enqueueWork(() -> {
                ServerPlayer player = networkContext.getSender();
                if (player == null
                        || this.text.length() > MAX_TEXT_LENGTH
                        || !player.mayBuild()
                        || !player.serverLevel().mayInteract(player, this.pos)) {
                    return;
                }

                ServerPacketGuard.plaque(player, this.pos)
                        .filter(ignored -> ServerPacketGuard.allowPlaqueWrite(player))
                        .ifPresent(plaque -> PlaqueTextLayout.write(
                                player.serverLevel(), plaque.getBlockPos(), this.text));
            });
        } finally {
            networkContext.setPacketHandled(true);
        }
    }
}
