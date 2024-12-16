package com.shengchanshe.changshengjue.network.packet.martial_arts.turtle_breath_work;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.turtle_breath_work.TurtleBreathWorkClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TurtleBreathWorkPacket {
    private final int turtleBreathWorkLevel;
    private final boolean turtleBreathWorkComprehend;
    private float turtleBreathWorkUseCooldownPercent;
    private boolean turtleBreathWorkOff;//技能是否启用
    private float turtleBreathWorkToppedTick;//技能领悟特效计时
    private float turtleBreathWorkDachengTick;//技能领悟特效计时
    private boolean turtleBreathWorkParticle;//技能特效显示

    public TurtleBreathWorkPacket(int turtleBreathWorkLevel, boolean turtleBreathWorkComprehend, float turtleBreathWorkUseCooldownPercent, boolean turtleBreathWorkOff,
                                  float turtleBreathWorkToppedTick, float turtleBreathWorkDachengTick, boolean turtleBreathWorkParticle){
        this.turtleBreathWorkLevel = turtleBreathWorkLevel;
        this.turtleBreathWorkComprehend = turtleBreathWorkComprehend;
        this.turtleBreathWorkUseCooldownPercent = turtleBreathWorkUseCooldownPercent;
        this.turtleBreathWorkOff = turtleBreathWorkOff;
        this.turtleBreathWorkToppedTick = turtleBreathWorkToppedTick;
        this.turtleBreathWorkDachengTick = turtleBreathWorkDachengTick;
        this.turtleBreathWorkParticle = turtleBreathWorkParticle;
    }

    public TurtleBreathWorkPacket(FriendlyByteBuf buf){
        this.turtleBreathWorkLevel = buf.readInt();
        this.turtleBreathWorkComprehend = buf.readBoolean();
        this.turtleBreathWorkUseCooldownPercent = buf.readFloat();
        this.turtleBreathWorkOff = buf.readBoolean();

        this.turtleBreathWorkToppedTick = buf.readFloat();
        this.turtleBreathWorkDachengTick = buf.readFloat();
        this.turtleBreathWorkParticle = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(turtleBreathWorkLevel);
        buf.writeBoolean(turtleBreathWorkComprehend);
        buf.writeFloat(turtleBreathWorkUseCooldownPercent);
        buf.writeBoolean(turtleBreathWorkOff);
        buf.writeFloat(turtleBreathWorkToppedTick);
        buf.writeFloat(turtleBreathWorkDachengTick);
        buf.writeBoolean(turtleBreathWorkParticle);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            TurtleBreathWorkClientData.setTurtleBreathWorkLevel(turtleBreathWorkLevel);
            TurtleBreathWorkClientData.setTurtleBreathWorkComprehend(turtleBreathWorkComprehend);
            TurtleBreathWorkClientData.setTurtleBreathWorkUseCooldownPercent(turtleBreathWorkUseCooldownPercent);
            TurtleBreathWorkClientData.setTurtleBreathWorkOff(turtleBreathWorkOff);

            TurtleBreathWorkClientData.setTurtleBreathWorkToppedTick(turtleBreathWorkToppedTick);
            TurtleBreathWorkClientData.setTurtleBreathWorkDachengTick(turtleBreathWorkDachengTick);
            TurtleBreathWorkClientData.setTurtleBreathWorkParticle(turtleBreathWorkParticle);
        });
        return true;
    }
}
