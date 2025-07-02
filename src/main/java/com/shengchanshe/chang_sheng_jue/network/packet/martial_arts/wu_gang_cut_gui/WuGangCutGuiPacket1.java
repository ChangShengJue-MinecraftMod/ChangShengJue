package com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.wu_gang_cut_gui;

import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.wu_gang_cut_gui.WuGangCutGuiClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class WuGangCutGuiPacket1 {
    private float wuGangCutGuiToppedTick;//技能领悟特效计时
    private float wuGangCutGuiDachengTick;//技能领悟特效计时
    private boolean wuGangCutGuiParticle;//技能特效显示

    public WuGangCutGuiPacket1( float wuGangCutGuiToppedTick, float wuGangCutGuiDachengTick, boolean wuGangCutGuiParticle){
        this.wuGangCutGuiToppedTick = wuGangCutGuiToppedTick;
        this.wuGangCutGuiDachengTick = wuGangCutGuiDachengTick;
        this.wuGangCutGuiParticle = wuGangCutGuiParticle;
    }

    public WuGangCutGuiPacket1(FriendlyByteBuf buf){

        this.wuGangCutGuiToppedTick = buf.readFloat();
        this.wuGangCutGuiDachengTick = buf.readFloat();
        this.wuGangCutGuiParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeFloat(wuGangCutGuiToppedTick);
        buf.writeFloat(wuGangCutGuiDachengTick);
        buf.writeBoolean(wuGangCutGuiParticle);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            WuGangCutGuiClientData.setWuGangCutGuiToppedTick(wuGangCutGuiToppedTick);
            WuGangCutGuiClientData.setWuGangCutGuiDachengTick(wuGangCutGuiDachengTick);
            WuGangCutGuiClientData.setWuGangCutGuiParticle(wuGangCutGuiParticle);
        });
        return true;
    }
}
