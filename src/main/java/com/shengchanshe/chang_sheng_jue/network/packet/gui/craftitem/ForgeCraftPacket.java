package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.block.custom.forgeblock.ForgeBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
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

            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;

            Level level = player.level();
            BlockPos pos = packet.pos;
            BlockEntity entity = level.getBlockEntity(pos);

            if (entity instanceof ForgeBlockEntity forgeEntity) {
                // 调用锻造台制作逻辑
                forgeEntity.craftCurrentRecipe(player);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}