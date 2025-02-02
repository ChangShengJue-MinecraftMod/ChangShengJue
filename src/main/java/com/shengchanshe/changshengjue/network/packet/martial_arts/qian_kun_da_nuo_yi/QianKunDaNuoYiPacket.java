package com.shengchanshe.changshengjue.network.packet.martial_arts.qian_kun_da_nuo_yi;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.StringJoiner;
import java.util.function.Supplier;

public class QianKunDaNuoYiPacket {
    private int qianKunDaNuoYiLevel;
    private boolean qianKunDaNuoYiComprehend;
    private float qianKunDaNuoYiUseCooldownPercent;
    private boolean qianKunDaNuoYiOff;//技能是否启用
    private float qianKunDaNuoYiToppedTick;//技能领悟特效计时
    private float qianKunDaNuoYiDachengTick;//技能领悟特效计时
    private boolean qianKunDaNuoYiParticle;//技能特效显示
    private float qianKunDaNuoYiUseCooldownMax;
    // 技能状态
    private boolean skillZActive;
    private boolean skillXActive;
    private boolean skillCActive;
    public QianKunDaNuoYiPacket(int qianKunDaNuoYiLevel, boolean qianKunDaNuoYiComprehend, float qianKunDaNuoYiUseCooldownPercent, boolean qianKunDaNuoYiOff,
                                float qianKunDaNuoYiToppedTick, float qianKunDaNuoYiDachengTick, boolean qianKunDaNuoYiParticle,float qianKunDaNuoYiUseCooldownMax,
                                boolean skillZActive, boolean skillXActive, boolean skillCActive){
        this.qianKunDaNuoYiLevel = qianKunDaNuoYiLevel;
        this.qianKunDaNuoYiComprehend = qianKunDaNuoYiComprehend;
        this.qianKunDaNuoYiUseCooldownPercent = qianKunDaNuoYiUseCooldownPercent;
        this.qianKunDaNuoYiOff = qianKunDaNuoYiOff;
        this.qianKunDaNuoYiToppedTick = qianKunDaNuoYiToppedTick;
        this.qianKunDaNuoYiDachengTick = qianKunDaNuoYiDachengTick;
        this.qianKunDaNuoYiParticle = qianKunDaNuoYiParticle;
        this.qianKunDaNuoYiUseCooldownMax = qianKunDaNuoYiUseCooldownMax;
        this.skillZActive = skillZActive;
        this.skillXActive = skillXActive;
        this.skillCActive = skillCActive;
    }

    public QianKunDaNuoYiPacket(FriendlyByteBuf buf){
        this.qianKunDaNuoYiLevel = buf.readInt();
        this.qianKunDaNuoYiComprehend = buf.readBoolean();
        this.qianKunDaNuoYiUseCooldownPercent = buf.readFloat();
        this.qianKunDaNuoYiOff = buf.readBoolean();

        this.qianKunDaNuoYiToppedTick = buf.readFloat();
        this.qianKunDaNuoYiDachengTick = buf.readFloat();
        this.qianKunDaNuoYiParticle = buf.readBoolean();
        this.qianKunDaNuoYiUseCooldownMax = buf.readFloat();

        this.skillZActive = buf.readBoolean();
        this.skillXActive = buf.readBoolean();
        this.skillCActive = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(qianKunDaNuoYiLevel);
        buf.writeBoolean(qianKunDaNuoYiComprehend);
        buf.writeFloat(qianKunDaNuoYiUseCooldownPercent);
        buf.writeBoolean(qianKunDaNuoYiOff);
        buf.writeFloat(qianKunDaNuoYiToppedTick);
        buf.writeFloat(qianKunDaNuoYiDachengTick);
        buf.writeBoolean(qianKunDaNuoYiParticle);
        buf.writeFloat(qianKunDaNuoYiUseCooldownMax);
        buf.writeBoolean(skillZActive);
        buf.writeBoolean(skillXActive);
        buf.writeBoolean(skillCActive);
    }

    // 客户端处理
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            QianKunDaNuoYiClientData.setQianKunDaNuoYiLevel(qianKunDaNuoYiLevel);
            QianKunDaNuoYiClientData.setQianKunDaNuoYiComprehend(qianKunDaNuoYiComprehend);
            QianKunDaNuoYiClientData.setQianKunDaNuoYiUseCooldownPercent(qianKunDaNuoYiUseCooldownPercent);
            QianKunDaNuoYiClientData.setQianKunDaNuoYiOff(qianKunDaNuoYiOff);

            QianKunDaNuoYiClientData.setQianKunDaNuoYiToppedTick(qianKunDaNuoYiToppedTick);
            QianKunDaNuoYiClientData.setQianKunDaNuoYiDachengTick(qianKunDaNuoYiDachengTick);
            QianKunDaNuoYiClientData.setQianKunDaNuoYiParticle(qianKunDaNuoYiParticle);
            QianKunDaNuoYiClientData.setQianKunDaNuoYiUseCooldownMax(qianKunDaNuoYiUseCooldownMax);
            QianKunDaNuoYiClientData.setSkillZActive(skillZActive);
            QianKunDaNuoYiClientData.setSkillXActive(skillXActive);
            QianKunDaNuoYiClientData.setSkillCActive(skillCActive);
        });
        return true;
    }
}
