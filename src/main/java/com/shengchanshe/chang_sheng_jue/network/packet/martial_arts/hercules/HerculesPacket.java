package com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.hercules;

import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.hercules.HerculesClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class HerculesPacket {
    private final int herculesLevel;
    private final boolean herculesComprehend;
    private float herculesToppedTick;//技能领悟特效计时
    private float herculesDachengTick;//技能领悟特效计时
    private boolean herculesParticle;//技能特效显示

    private boolean skillActive;

    public HerculesPacket(int herculesLevel, boolean herculesComprehend, float herculesToppedTick, float herculesDachengTick,
                          boolean herculesParticle,boolean skillActive){
        this.herculesLevel = herculesLevel;
        this.herculesComprehend = herculesComprehend;
        this.herculesToppedTick = herculesToppedTick;
        this.herculesDachengTick = herculesDachengTick;
        this.herculesParticle = herculesParticle;
        this.skillActive = skillActive;
    }

    public HerculesPacket(FriendlyByteBuf buf){
        this.herculesLevel = buf.readInt();
        this.herculesComprehend = buf.readBoolean();
        this.herculesToppedTick = buf.readFloat();
        this.herculesDachengTick = buf.readFloat();
        this.herculesParticle = buf.readBoolean();
        this.skillActive = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(herculesLevel);
        buf.writeBoolean(herculesComprehend);
        buf.writeFloat(herculesToppedTick);
        buf.writeFloat(herculesDachengTick);
        buf.writeBoolean(herculesParticle);
        buf.writeBoolean(skillActive);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            HerculesClientData.setHerculesLevel(herculesLevel);
            HerculesClientData.setHerculesComprehend(herculesComprehend);

            HerculesClientData.setHerculesToppedTick(herculesToppedTick);
            HerculesClientData.setHerculesDachengTick(herculesDachengTick);
            HerculesClientData.setHerculesParticle(herculesParticle);
            HerculesClientData.setSkillActive(skillActive);
        });
        return true;
    }
}
