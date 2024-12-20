package com.shengchanshe.changshengjue.network.packet.martial_arts;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class GoldenBlackKnifeMethodPacket {
    private final int goldenBlackKnifeMethodLevel;
    private final boolean goldenBlackKnifeMethodComprehend;
    private float goldenBlackKnifeMethodToppedTick;//技能领悟特效计时
    private float goldenBlackKnifeMethodDachengTick;//技能领悟特效计时
    private boolean goldenBlackKnifeMethodParticle;//技能特效显示

    public GoldenBlackKnifeMethodPacket(int goldenBlackKnifeMethodLevel, boolean goldenBlackKnifeMethodComprehend, float goldenBlackKnifeMethodToppedTick, float goldenBlackKnifeMethodDachengTick, boolean goldenBlackKnifeMethodParticle){
        this.goldenBlackKnifeMethodLevel = goldenBlackKnifeMethodLevel;
        this.goldenBlackKnifeMethodComprehend = goldenBlackKnifeMethodComprehend;
        this.goldenBlackKnifeMethodToppedTick = goldenBlackKnifeMethodToppedTick;
        this.goldenBlackKnifeMethodDachengTick = goldenBlackKnifeMethodDachengTick;
        this.goldenBlackKnifeMethodParticle = goldenBlackKnifeMethodParticle;
    }

    public GoldenBlackKnifeMethodPacket(FriendlyByteBuf buf){
        this.goldenBlackKnifeMethodLevel = buf.readInt();
        this.goldenBlackKnifeMethodComprehend = buf.readBoolean();
        this.goldenBlackKnifeMethodToppedTick = buf.readFloat();
        this.goldenBlackKnifeMethodDachengTick = buf.readFloat();
        this.goldenBlackKnifeMethodParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(goldenBlackKnifeMethodLevel);
        buf.writeBoolean(goldenBlackKnifeMethodComprehend);
        buf.writeFloat(goldenBlackKnifeMethodToppedTick);
        buf.writeFloat(goldenBlackKnifeMethodDachengTick);
        buf.writeBoolean(goldenBlackKnifeMethodParticle);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            GoldenBlackKnifeMethodClientData.setGoldenBlackKnifeMethodLevel(goldenBlackKnifeMethodLevel);
            GoldenBlackKnifeMethodClientData.setGoldenBlackKnifeMethodComprehend(goldenBlackKnifeMethodComprehend);

            GoldenBlackKnifeMethodClientData.setGoldenBlackKnifeMethodToppedTick(goldenBlackKnifeMethodToppedTick);
            GoldenBlackKnifeMethodClientData.setGoldenBlackKnifeMethodDachengTick(goldenBlackKnifeMethodDachengTick);
            GoldenBlackKnifeMethodClientData.setGoldenBlackKnifeMethodParticle(goldenBlackKnifeMethodParticle);
        });
        return true;
    }
}
