package com.shengchanshe.changshengjue.network.packet.martial_arts;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.shaolin_stick_method.ShaolinStickMethodClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ShaolinStickMethodPacket {
    private final int shaolinStickMethodLevel;
    private final boolean shaolinStickMethodComprehend;
    private float shaolinStickMethodToppedTick;//技能领悟特效计时
    private float shaolinStickMethodDachengTick;//技能领悟特效计时
    private boolean shaolinStickMethodParticle;//技能特效显示

    public ShaolinStickMethodPacket(int shaolinStickMethodLevel, boolean shaolinStickMethodComprehend, float shaolinStickMethodToppedTick, float shaolinStickMethodDachengTick, boolean shaolinStickMethodParticle){
        this.shaolinStickMethodLevel = shaolinStickMethodLevel;
        this.shaolinStickMethodComprehend = shaolinStickMethodComprehend;
        this.shaolinStickMethodToppedTick = shaolinStickMethodToppedTick;
        this.shaolinStickMethodDachengTick = shaolinStickMethodDachengTick;
        this.shaolinStickMethodParticle = shaolinStickMethodParticle;
    }

    public ShaolinStickMethodPacket(FriendlyByteBuf buf){
        this.shaolinStickMethodLevel = buf.readInt();
        this.shaolinStickMethodComprehend = buf.readBoolean();
        this.shaolinStickMethodToppedTick = buf.readFloat();
        this.shaolinStickMethodDachengTick = buf.readFloat();
        this.shaolinStickMethodParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(shaolinStickMethodLevel);
        buf.writeBoolean(shaolinStickMethodComprehend);
        buf.writeFloat(shaolinStickMethodToppedTick);
        buf.writeFloat(shaolinStickMethodDachengTick);
        buf.writeBoolean(shaolinStickMethodParticle);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ShaolinStickMethodClientData.setShaolinStickMethodLevel(shaolinStickMethodLevel);
            ShaolinStickMethodClientData.setShaolinStickMethodComprehend(shaolinStickMethodComprehend);

            ShaolinStickMethodClientData.setShaolinStickMethodToppedTick(shaolinStickMethodToppedTick);
            ShaolinStickMethodClientData.setShaolinStickMethodDachengTick(shaolinStickMethodDachengTick);
            ShaolinStickMethodClientData.setShaolinStickMethodParticle(shaolinStickMethodParticle);
        });
        return true;
    }
}
