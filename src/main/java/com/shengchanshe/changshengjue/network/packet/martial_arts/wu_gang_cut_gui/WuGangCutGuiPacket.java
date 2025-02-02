package com.shengchanshe.changshengjue.network.packet.martial_arts.wu_gang_cut_gui;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.wu_gang_cut_gui.WuGangCutGuiClientData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class WuGangCutGuiPacket {
    private final BlockPos blockPos;
    private final float particleTick;

    public WuGangCutGuiPacket(BlockPos blockPos,float particleTick){
        this.blockPos = blockPos;
        this.particleTick = particleTick;
    }

    public WuGangCutGuiPacket(FriendlyByteBuf buf){
        this.blockPos = buf.readBlockPos();
        this.particleTick = buf.readFloat();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeBlockPos(blockPos);
        buf.writeFloat(particleTick);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            WuGangCutGuiClientData.setDropPos(blockPos);
            WuGangCutGuiClientData.setParticleTick(particleTick);
        });
        return true;
    }
}
