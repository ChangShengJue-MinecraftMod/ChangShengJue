package com.shengchanshe.changshengjue.network.packet.martial_arts.immortal_miracle;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.ge_shan_da_niu.GeShanDaNiuClientData;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.immortal_miracle.ImmortalMiracleClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ImmortalMiraclePacket {
    private final int immortalMiracleLevel;
    private final boolean immortalMiracleComprehend;
    private float immortalMiracleUseCooldownPercent;
    private boolean immortalMiracleOff;//技能是否启用
    private float immortalMiracleToppedTick;//技能领悟特效计时
    private float immortalMiracleDachengTick;//技能大成特效计时
    private boolean immortalMiracleParticle;//技能特效显示
    private float immortalMiracleUseCooldownPercentMax;
    // 技能状态
    private boolean skillZActive;
    private boolean skillXActive;
    private boolean skillCActive;

    public ImmortalMiraclePacket(int immortalMiracleLevel, boolean immortalMiracleComprehend, float immortalMiracleUseCooldownPercent, boolean immortalMiracleOff,
                                 float immortalMiracleToppedTick, float immortalMiracleDachengTick, boolean immortalMiracleParticle,float immortalMiracleUseCooldownPercentMax,
                                 boolean skillZActive,boolean skillXActive,boolean skillCActive){
        this.immortalMiracleLevel = immortalMiracleLevel;
        this.immortalMiracleComprehend = immortalMiracleComprehend;
        this.immortalMiracleUseCooldownPercent = immortalMiracleUseCooldownPercent;
        this.immortalMiracleOff = immortalMiracleOff;
        this.immortalMiracleToppedTick = immortalMiracleToppedTick;
        this.immortalMiracleDachengTick = immortalMiracleDachengTick;
        this.immortalMiracleParticle = immortalMiracleParticle;
        this.immortalMiracleUseCooldownPercentMax = immortalMiracleUseCooldownPercentMax;
        this.skillZActive = skillZActive;
        this.skillXActive = skillXActive;
        this.skillCActive = skillCActive;
    }

    public ImmortalMiraclePacket(FriendlyByteBuf buf){
        this.immortalMiracleLevel = buf.readInt();
        this.immortalMiracleComprehend = buf.readBoolean();
        this.immortalMiracleUseCooldownPercent = buf.readFloat();
        this.immortalMiracleOff = buf.readBoolean();
        this.immortalMiracleToppedTick = buf.readFloat();
        this.immortalMiracleDachengTick = buf.readFloat();
        this.immortalMiracleParticle = buf.readBoolean();
        this.immortalMiracleUseCooldownPercentMax = buf.readFloat();
        this.skillZActive = buf.readBoolean();
        this.skillXActive = buf.readBoolean();
        this.skillCActive = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(immortalMiracleLevel);
        buf.writeBoolean(immortalMiracleComprehend);
        buf.writeFloat(immortalMiracleUseCooldownPercent);
        buf.writeBoolean(immortalMiracleOff);
        buf.writeFloat(immortalMiracleToppedTick);
        buf.writeFloat(immortalMiracleDachengTick);
        buf.writeBoolean(immortalMiracleParticle);
        buf.writeFloat(immortalMiracleUseCooldownPercentMax);
        buf.writeBoolean(skillZActive);
        buf.writeBoolean(skillXActive);
        buf.writeBoolean(skillCActive);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ImmortalMiracleClientData.setImmortalMiracleLevel(immortalMiracleLevel);
            ImmortalMiracleClientData.setImmortalMiracleComprehend(immortalMiracleComprehend);
            ImmortalMiracleClientData.setImmortalMiracleUseCooldownPercent(immortalMiracleUseCooldownPercent);
            ImmortalMiracleClientData.setImmortalMiracleOff(immortalMiracleOff);
            ImmortalMiracleClientData.setImmortalMiracleToppedTick(immortalMiracleToppedTick);
            ImmortalMiracleClientData.setImmortalMiracleDachengTick(immortalMiracleDachengTick);
            ImmortalMiracleClientData.setImmortalMiracleParticle(immortalMiracleParticle);
            ImmortalMiracleClientData.setImmortalMiracleUseCooldownPercentMax(immortalMiracleUseCooldownPercentMax);
            ImmortalMiracleClientData.setSkillZActive(skillZActive);
            ImmortalMiracleClientData.setSkillXActive(skillXActive);
            ImmortalMiracleClientData.setSkillCActive(skillCActive);
        });
        return true;
    }
}
