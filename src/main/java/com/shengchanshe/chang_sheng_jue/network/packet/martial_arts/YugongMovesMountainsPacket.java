package com.shengchanshe.chang_sheng_jue.network.packet.martial_arts;

import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.yugong_moves_mountains.YugongMovesMountainsClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class YugongMovesMountainsPacket {
    private final int yugongMovesMountainsLevel;
    private final boolean yugongMovesMountainsComprehend;
    private float yugongMovesMountainsToppedTick;//技能领悟特效计时
    private float yugongMovesMountainsDachengTick;//技能领悟特效计时
    private boolean yugongMovesMountainsParticle;//技能特效显示

    public YugongMovesMountainsPacket(int yugongMovesMountainsLevel, boolean yugongMovesMountainsComprehend, float yugongMovesMountainsToppedTick, float yugongMovesMountainsDachengTick, boolean yugongMovesMountainsParticle){
        this.yugongMovesMountainsLevel = yugongMovesMountainsLevel;
        this.yugongMovesMountainsComprehend = yugongMovesMountainsComprehend;
        this.yugongMovesMountainsToppedTick = yugongMovesMountainsToppedTick;
        this.yugongMovesMountainsDachengTick = yugongMovesMountainsDachengTick;
        this.yugongMovesMountainsParticle = yugongMovesMountainsParticle;
    }

    public YugongMovesMountainsPacket(FriendlyByteBuf buf){
        this.yugongMovesMountainsLevel = buf.readInt();
        this.yugongMovesMountainsComprehend = buf.readBoolean();
        this.yugongMovesMountainsToppedTick = buf.readFloat();
        this.yugongMovesMountainsDachengTick = buf.readFloat();
        this.yugongMovesMountainsParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(yugongMovesMountainsLevel);
        buf.writeBoolean(yugongMovesMountainsComprehend);
        buf.writeFloat(yugongMovesMountainsToppedTick);
        buf.writeFloat(yugongMovesMountainsDachengTick);
        buf.writeBoolean(yugongMovesMountainsParticle);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            YugongMovesMountainsClientData.setYugongMovesMountainsLevel(yugongMovesMountainsLevel);
            YugongMovesMountainsClientData.setYugongMovesMountainsComprehend(yugongMovesMountainsComprehend);

            YugongMovesMountainsClientData.setYugongMovesMountainsToppedTick(yugongMovesMountainsToppedTick);
            YugongMovesMountainsClientData.setYugongMovesMountainsDachengTick(yugongMovesMountainsDachengTick);
            YugongMovesMountainsClientData.setYugongMovesMountainsParticle(yugongMovesMountainsParticle);
        });
        return true;
    }
}
