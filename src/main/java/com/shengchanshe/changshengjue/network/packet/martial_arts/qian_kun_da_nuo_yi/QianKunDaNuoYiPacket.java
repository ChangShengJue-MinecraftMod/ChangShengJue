package com.shengchanshe.changshengjue.network.packet.martial_arts.qian_kun_da_nuo_yi;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.StringJoiner;
import java.util.UUID;
import java.util.function.Supplier;

public class QianKunDaNuoYiPacket {
    private final int qianKunDaNuoYiLevel;
    private final boolean qianKunDaNuoYiComprehend;
    private final float qianKunDaNuoYiUseCooldownPercent;
    private final boolean qianKunDaNuoYiOff;//技能是否启用
    private final float qianKunDaNuoYiToppedTick;//技能领悟特效计时
    private final float qianKunDaNuoYiDachengTick;//技能领悟特效计时
    private final boolean qianKunDaNuoYiParticle;//技能特效显示
    private final float qianKunDaNuoYiUseCooldownMax;
    private final int recordTime;
    private final float recordDamage;
    private final UUID recordDamageSource;
    // 技能状态
    private final boolean skillActive;
    public QianKunDaNuoYiPacket(int qianKunDaNuoYiLevel, boolean qianKunDaNuoYiComprehend, float qianKunDaNuoYiUseCooldownPercent, boolean qianKunDaNuoYiOff,
                                float qianKunDaNuoYiToppedTick, float qianKunDaNuoYiDachengTick, boolean qianKunDaNuoYiParticle,float qianKunDaNuoYiUseCooldownMax,
                                boolean skillActive, int recordTime, float recordDamage, UUID recordDamageSource){
        this.qianKunDaNuoYiLevel = qianKunDaNuoYiLevel;
        this.qianKunDaNuoYiComprehend = qianKunDaNuoYiComprehend;
        this.qianKunDaNuoYiUseCooldownPercent = qianKunDaNuoYiUseCooldownPercent;
        this.qianKunDaNuoYiOff = qianKunDaNuoYiOff;
        this.qianKunDaNuoYiToppedTick = qianKunDaNuoYiToppedTick;
        this.qianKunDaNuoYiDachengTick = qianKunDaNuoYiDachengTick;
        this.qianKunDaNuoYiParticle = qianKunDaNuoYiParticle;
        this.qianKunDaNuoYiUseCooldownMax = qianKunDaNuoYiUseCooldownMax;
        this.recordTime = recordTime;
        this.recordDamage = recordDamage;
        this.recordDamageSource = recordDamageSource;
        this.skillActive = skillActive;
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
        this.recordTime = buf.readInt();
        this.recordDamage = buf.readFloat();
        this.recordDamageSource = buf.readUUID();

        this.skillActive = buf.readBoolean();
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
        buf.writeInt(recordTime);
        buf.writeFloat(recordDamage);
        buf.writeBoolean(skillActive);
        buf.writeUUID(recordDamageSource);
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
            QianKunDaNuoYiClientData.setRecordTime(this.recordTime);
            QianKunDaNuoYiClientData.setRecordDamage(this.recordDamage);
            QianKunDaNuoYiClientData.setRecordDamageSource(this.recordDamageSource);

            QianKunDaNuoYiClientData.setSkillActive(skillActive);
        });
        return true;
    }
}
