package com.shengchanshe.chang_sheng_jue.network.packet.martial_arts;

import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class RelentlessThrowingKnivesPacket {
    private final int relentlessThrowingKnivesLevel;
    private final boolean relentlessThrowingKnivesComprehend;
    private int relentlessThrowingKnivesUseCooldownPercent;
    private int relentlessThrowingKnivesToppedTick;//技能领悟特效计时
    private int relentlessThrowingKnivesDachengTick;//技能领悟特效计时
    private boolean relentlessThrowingKnivesParticle;//技能特效显示


    public RelentlessThrowingKnivesPacket(int relentlessThrowingKnivesLevel, boolean relentlessThrowingKnivesComprehend, int relentlessThrowingKnivesUseCooldownPercent,
                                       int relentlessThrowingKnivesToppedTick, int relentlessThrowingKnivesDachengTick, boolean relentlessThrowingKnivesParticle){
        this.relentlessThrowingKnivesLevel = relentlessThrowingKnivesLevel;
        this.relentlessThrowingKnivesComprehend = relentlessThrowingKnivesComprehend;
        this.relentlessThrowingKnivesUseCooldownPercent = relentlessThrowingKnivesUseCooldownPercent;
        this.relentlessThrowingKnivesToppedTick = relentlessThrowingKnivesToppedTick;
        this.relentlessThrowingKnivesDachengTick = relentlessThrowingKnivesDachengTick;
        this.relentlessThrowingKnivesParticle = relentlessThrowingKnivesParticle;
    }

    public RelentlessThrowingKnivesPacket(FriendlyByteBuf buf){
        this.relentlessThrowingKnivesLevel = buf.readInt();
        this.relentlessThrowingKnivesComprehend = buf.readBoolean();
        this.relentlessThrowingKnivesUseCooldownPercent = buf.readInt();
        this.relentlessThrowingKnivesToppedTick = buf.readInt();
        this.relentlessThrowingKnivesDachengTick = buf.readInt();
        this.relentlessThrowingKnivesParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(relentlessThrowingKnivesLevel);
        buf.writeBoolean(relentlessThrowingKnivesComprehend);
        buf.writeInt(relentlessThrowingKnivesUseCooldownPercent);
        buf.writeInt(relentlessThrowingKnivesToppedTick);
        buf.writeInt(relentlessThrowingKnivesDachengTick);
        buf.writeBoolean(relentlessThrowingKnivesParticle);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            RelentlessThrowingKnivesClientData.setRelentlessThrowingKnivesLevel(relentlessThrowingKnivesLevel);
            RelentlessThrowingKnivesClientData.setRelentlessThrowingKnivesComprehend(relentlessThrowingKnivesComprehend);
            RelentlessThrowingKnivesClientData.setRelentlessThrowingKnivesUseCooldownPercent(relentlessThrowingKnivesUseCooldownPercent);

            RelentlessThrowingKnivesClientData.setRelentlessThrowingKnivesToppedTick(relentlessThrowingKnivesToppedTick);
            RelentlessThrowingKnivesClientData.setRelentlessThrowingKnivesDachengTick(relentlessThrowingKnivesDachengTick);
            RelentlessThrowingKnivesClientData.setRelentlessThrowingKnivesParticle(relentlessThrowingKnivesParticle);
        });
        return true;
    }
}
