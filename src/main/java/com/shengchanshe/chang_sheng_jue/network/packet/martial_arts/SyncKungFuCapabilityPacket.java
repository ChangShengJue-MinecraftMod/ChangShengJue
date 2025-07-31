package com.shengchanshe.chang_sheng_jue.network.packet.martial_arts;

import com.shengchanshe.chang_sheng_jue.cilent.hud.kungfu.KungFuClientData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SyncKungFuCapabilityPacket {
    private final CompoundTag data;

    public SyncKungFuCapabilityPacket(CompoundTag data) {
        this.data = data;
    }

    public SyncKungFuCapabilityPacket(FriendlyByteBuf buf) {
        this.data = buf.readNbt();
    }

    public void encode(FriendlyByteBuf buf) {
        buf.writeNbt(data);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            KungFuClientData.get().handleKungFuSync(this.data);
        });
        return true;
    }
}
