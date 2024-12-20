package com.shengchanshe.changshengjue.network.packet.martial_arts;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.dugu_nine_swords.DuguNineSwordsClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class DuguNineSwordsPacket {
    private final int duguNineSwordsLevel;
    private final boolean duguNineSwordsComprehend;
    private float duguNineSwordsToppedTick;//技能领悟特效计时
    private float duguNineSwordsDachengTick;//技能领悟特效计时
    private boolean duguNineSwordsParticle;//技能特效显示

    public DuguNineSwordsPacket(int duguNineSwordsLevel, boolean duguNineSwordsComprehend, float duguNineSwordsToppedTick, float duguNineSwordsDachengTick, boolean duguNineSwordsParticle){
        this.duguNineSwordsLevel = duguNineSwordsLevel;
        this.duguNineSwordsComprehend = duguNineSwordsComprehend;
        this.duguNineSwordsToppedTick = duguNineSwordsToppedTick;
        this.duguNineSwordsDachengTick = duguNineSwordsDachengTick;
        this.duguNineSwordsParticle = duguNineSwordsParticle;
    }

    public DuguNineSwordsPacket(FriendlyByteBuf buf){
        this.duguNineSwordsLevel = buf.readInt();
        this.duguNineSwordsComprehend = buf.readBoolean();
        this.duguNineSwordsToppedTick = buf.readFloat();
        this.duguNineSwordsDachengTick = buf.readFloat();
        this.duguNineSwordsParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(duguNineSwordsLevel);
        buf.writeBoolean(duguNineSwordsComprehend);
        buf.writeFloat(duguNineSwordsToppedTick);
        buf.writeFloat(duguNineSwordsDachengTick);
        buf.writeBoolean(duguNineSwordsParticle);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            DuguNineSwordsClientData.setDuguNineSwordsLevel(duguNineSwordsLevel);
            DuguNineSwordsClientData.setDuguNineSwordsComprehend(duguNineSwordsComprehend);

            DuguNineSwordsClientData.setDuguNineSwordsToppedTick(duguNineSwordsToppedTick);
            DuguNineSwordsClientData.setDuguNineSwordsDachengTick(duguNineSwordsDachengTick);
            DuguNineSwordsClientData.setDuguNineSwordsParticle(duguNineSwordsParticle);
        });
        return true;
    }
}
