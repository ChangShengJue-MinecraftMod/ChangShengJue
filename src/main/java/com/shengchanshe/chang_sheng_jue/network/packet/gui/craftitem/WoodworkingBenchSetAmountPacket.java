package com.shengchanshe.chang_sheng_jue.network.packet.gui.craftitem;

import com.shengchanshe.chang_sheng_jue.network.ServerPacketGuard;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
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
            if (!ServerPacketGuard.isCraftAmountValid(times)) {
                return;
            }
            ServerPacketGuard.woodworkingBench(context.getSender(), pos)
                    .ifPresent(entity -> entity.setCraftTimes(times));
        });
        context.setPacketHandled(true);
        return true;
    }
}
