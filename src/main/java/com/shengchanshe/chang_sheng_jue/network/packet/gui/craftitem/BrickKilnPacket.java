package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.block.custom.brick_kiln.BrickKilnEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
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

            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;

            Level level = player.level();
            BlockPos pos = packet.pos;
            BlockEntity entity = level.getBlockEntity(pos);

            if (entity instanceof BrickKilnEntity entity1) {
                // 调用锻造台制作逻辑
                entity1.craftCurrentRecipe(player);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}