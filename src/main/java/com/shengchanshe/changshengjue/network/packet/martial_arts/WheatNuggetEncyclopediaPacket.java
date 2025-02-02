package com.shengchanshe.changshengjue.network.packet.martial_arts;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.wheat_nugget_encyclopedia.WheatNuggetEncyclopediaClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import java.util.function.Supplier;

public class WheatNuggetEncyclopediaPacket {
    private int wheatNuggetEncyclopediaToppedTick;//技能领悟特效计时
    private int wheatNuggetEncyclopediaDachengTick;//技能大成特效计时
    private boolean wheatNuggetEncyclopediaParticle;//技能特效显示

    public WheatNuggetEncyclopediaPacket(int wheatNuggetEncyclopediaToppedTick,int wheatNuggetEncyclopediaDachengTick, boolean wheatNuggetEncyclopediaParticle){
        this.wheatNuggetEncyclopediaToppedTick = wheatNuggetEncyclopediaToppedTick;
        this.wheatNuggetEncyclopediaDachengTick = wheatNuggetEncyclopediaDachengTick;
        this.wheatNuggetEncyclopediaParticle = wheatNuggetEncyclopediaParticle;
    }

    public WheatNuggetEncyclopediaPacket(FriendlyByteBuf buf){
        this.wheatNuggetEncyclopediaToppedTick = buf.readInt();
        this.wheatNuggetEncyclopediaDachengTick = buf.readInt();
        this.wheatNuggetEncyclopediaParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(wheatNuggetEncyclopediaToppedTick);
        buf.writeInt(wheatNuggetEncyclopediaDachengTick);
        buf.writeBoolean(wheatNuggetEncyclopediaParticle);
    }
    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            WheatNuggetEncyclopediaClientData.setWheatNuggetEncyclopediaToppedTick(wheatNuggetEncyclopediaToppedTick);
            WheatNuggetEncyclopediaClientData.setWheatNuggetEncyclopediaDachengTick(wheatNuggetEncyclopediaDachengTick);
            WheatNuggetEncyclopediaClientData.setWheatNuggetEncyclopediaParticle(wheatNuggetEncyclopediaParticle);
        });
        return true;
    }
}
