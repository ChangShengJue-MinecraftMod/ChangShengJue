package com.shengchanshe.chang_sheng_jue.network.packet.martial_arts;

import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TheClassicsOfTendonChangingPacket {
    private final int theClassicsOfTendonChangingLevel;
    private final boolean theClassicsOfTendonChangingComprehend;
    private float theClassicsOfTendonChangingToppedTick;//技能领悟特效计时
    private float theClassicsOfTendonChangingDachengTick;//技能领悟特效计时
    private boolean theClassicsOfTendonChangingParticle;//技能特效显示

    public TheClassicsOfTendonChangingPacket(int theClassicsOfTendonChangingLevel, boolean theClassicsOfTendonChangingComprehend, float theClassicsOfTendonChangingToppedTick,
                                             float theClassicsOfTendonChangingDachengTick, boolean theClassicsOfTendonChangingParticle){
        this.theClassicsOfTendonChangingLevel = theClassicsOfTendonChangingLevel;
        this.theClassicsOfTendonChangingComprehend = theClassicsOfTendonChangingComprehend;
        this.theClassicsOfTendonChangingToppedTick = theClassicsOfTendonChangingToppedTick;
        this.theClassicsOfTendonChangingDachengTick = theClassicsOfTendonChangingDachengTick;
        this.theClassicsOfTendonChangingParticle = theClassicsOfTendonChangingParticle;
    }

    public TheClassicsOfTendonChangingPacket(FriendlyByteBuf buf){
        this.theClassicsOfTendonChangingLevel = buf.readInt();
        this.theClassicsOfTendonChangingComprehend = buf.readBoolean();
        this.theClassicsOfTendonChangingToppedTick = buf.readFloat();
        this.theClassicsOfTendonChangingDachengTick = buf.readFloat();
        this.theClassicsOfTendonChangingParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(theClassicsOfTendonChangingLevel);
        buf.writeBoolean(theClassicsOfTendonChangingComprehend);
        buf.writeFloat(theClassicsOfTendonChangingToppedTick);
        buf.writeFloat(theClassicsOfTendonChangingDachengTick);
        buf.writeBoolean(theClassicsOfTendonChangingParticle);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            TheClassicsOfTendonChangingClientData.setTheClassicsOfTendonChangingLevel(theClassicsOfTendonChangingLevel);
            TheClassicsOfTendonChangingClientData.setTheClassicsOfTendonChangingComprehend(theClassicsOfTendonChangingComprehend);

            TheClassicsOfTendonChangingClientData.setTheClassicsOfTendonChangingToppedTick(theClassicsOfTendonChangingToppedTick);
            TheClassicsOfTendonChangingClientData.setTheClassicsOfTendonChangingDachengTick(theClassicsOfTendonChangingDachengTick);
            TheClassicsOfTendonChangingClientData.setTheClassicsOfTendonChangingParticle(theClassicsOfTendonChangingParticle);
        });
        return true;
    }
}
