package com.shengchanshe.chang_sheng_jue.network.packet.gui.CraftItem;

import com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase.TailoringCaseEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
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

            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;

            Level level = player.level();
            BlockPos pos = packet.pos;
            BlockEntity entity = level.getBlockEntity(pos);

            if (entity instanceof TailoringCaseEntity tailoringEntity) {
                // 调用制作逻辑（实际制作应在服务端执行）

                tailoringEntity.craftCurrentRecipe(player);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}