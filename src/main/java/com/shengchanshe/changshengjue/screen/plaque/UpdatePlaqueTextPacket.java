package com.shengchanshe.changshengjue.screen.plaque;

import com.shengchanshe.changshengjue.block.entity.PlaqueEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdatePlaqueTextPacket {
    private final BlockPos pos;
    private final String text;

    public UpdatePlaqueTextPacket(BlockPos pos, String text) {
        this.pos = pos;
        this.text = text;
    }

    public UpdatePlaqueTextPacket(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos();
        this.text = buf.readUtf(32767);
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeUtf(text);
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerPlayer player = context.get().getSender();
            if (player != null && player.level().getBlockEntity(pos) instanceof PlaqueEntity plaqueBlockEntity) {
                plaqueBlockEntity.setText(text); // 更新方块实体中的文字
            }
        });
        context.get().setPacketHandled(true);
    }
}