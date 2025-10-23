package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.block.custom.workbench.WoodworkingBenchEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class WoodworkingBenchSetAmountPacket {
    // 修改类名和变量名以反映功能变化
    private final BlockPos pos;
    private final int times; // 改为times

    public WoodworkingBenchSetAmountPacket(BlockPos pos, int times) {
        this.pos = pos;
        this.times = times;
    }

    public WoodworkingBenchSetAmountPacket(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos();
        this.times = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
        buf.writeInt(times);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player != null) {
                ServerLevel level = player.serverLevel();
                BlockEntity blockEntity = level.getBlockEntity(pos);
                if (blockEntity instanceof WoodworkingBenchEntity benchEntity) {
                    benchEntity.setCraftTimes(times); // 改为setCraftTimes
                }
            }
        });
        return true;
    }
}