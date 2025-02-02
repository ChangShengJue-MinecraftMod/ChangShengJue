package com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.ge_shan_da_niu.GeShanDaNiuClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class GeShanDaNiuPacket {
    private final int geShanDaNiuLevel;
    private final boolean geShanDaNiuComprehend;
    private float geShanDaNiuUseCooldownPercent;
    private float geShanDaNiuToppedTick;//技能领悟特效计时
    private float geShanDaNiuDachengTick;//技能大成特效计时
    private boolean geShanDaNiuParticle;//技能特效显示
    private float geShanDaNiuUseCooldownPercentMax;

    // 技能状态
    private boolean skillZActive;
    private boolean skillXActive;
    private boolean skillCActive;

    public GeShanDaNiuPacket(int geShanDaNiuLevel, boolean geShanDaNiuComprehend, float geShanDaNiuUseCooldownPercent,
                             float geShanDaNiuToppedTick, float geShanDaNiuDachengTick, boolean geShanDaNiuParticle, float geShanDaNiuUseCooldownPercentMax,
                             boolean skillZActive,boolean skillXActive,boolean skillCActive){
        this.geShanDaNiuLevel = geShanDaNiuLevel;
        this.geShanDaNiuComprehend = geShanDaNiuComprehend;
        this.geShanDaNiuUseCooldownPercent = geShanDaNiuUseCooldownPercent;
        this.geShanDaNiuToppedTick = geShanDaNiuToppedTick;
        this.geShanDaNiuDachengTick = geShanDaNiuDachengTick;
        this.geShanDaNiuParticle = geShanDaNiuParticle;
        this.geShanDaNiuUseCooldownPercentMax = geShanDaNiuUseCooldownPercentMax;
        this.skillZActive = skillZActive;
        this.skillXActive = skillXActive;
        this.skillCActive = skillCActive;
    }

    public GeShanDaNiuPacket(FriendlyByteBuf buf){
        this.geShanDaNiuLevel = buf.readInt();
        this.geShanDaNiuComprehend = buf.readBoolean();
        this.geShanDaNiuUseCooldownPercent = buf.readFloat();
        this.geShanDaNiuToppedTick = buf.readFloat();
        this.geShanDaNiuDachengTick = buf.readFloat();
        this.geShanDaNiuParticle = buf.readBoolean();
        this.geShanDaNiuUseCooldownPercentMax = buf.readFloat();
        this.skillZActive = buf.readBoolean();
        this.skillXActive = buf.readBoolean();
        this.skillCActive = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(geShanDaNiuLevel);
        buf.writeBoolean(geShanDaNiuComprehend);
        buf.writeFloat(geShanDaNiuUseCooldownPercent);
        buf.writeFloat(geShanDaNiuToppedTick);
        buf.writeFloat(geShanDaNiuDachengTick);
        buf.writeBoolean(geShanDaNiuParticle);
        buf.writeFloat(geShanDaNiuUseCooldownPercentMax);
        buf.writeBoolean(skillZActive);
        buf.writeBoolean(skillXActive);
        buf.writeBoolean(skillCActive);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            GeShanDaNiuClientData.setGeShanDaNiuLevel(geShanDaNiuLevel);
            GeShanDaNiuClientData.setGeShanDaNiuComprehend(geShanDaNiuComprehend);
            GeShanDaNiuClientData.setGeShanDaNiuUseCooldownPercent(geShanDaNiuUseCooldownPercent);
            GeShanDaNiuClientData.setGeShanDaNiuToppedTick(geShanDaNiuToppedTick);
            GeShanDaNiuClientData.setGeShanDaNiuDachengTick(geShanDaNiuDachengTick);
            GeShanDaNiuClientData.setGeShanDaNiuParticle(geShanDaNiuParticle);
            GeShanDaNiuClientData.setGeShanDaNiuUseCooldownPercentMax(geShanDaNiuUseCooldownPercentMax);
            GeShanDaNiuClientData.setSkillZActive(skillZActive);
            GeShanDaNiuClientData.setSkillXActive(skillXActive);
            GeShanDaNiuClientData.setSkillCActive(skillCActive);
        });
        return true;
    }
}
