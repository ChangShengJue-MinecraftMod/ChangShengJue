package com.shengchanshe.changshengjue.network.packet.effect;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class EffectEntityPacket {
    private int entityID;
    private int fromEntityID;
    private int potionType;
    private int duration;

    private boolean remove;
    public EffectEntityPacket(int entityID, int fromEntityID, int potionType, int duration) {
        this(entityID, fromEntityID, potionType, duration, false);
    }

    public EffectEntityPacket(int entityID, int fromEntityID, int potionType, int duration, boolean remove){
        this.entityID = entityID;
        this.fromEntityID = fromEntityID;
        this.potionType = potionType;
        this.duration = duration;
        this.remove = remove;
    }

    public EffectEntityPacket(FriendlyByteBuf buf){
        this.entityID = buf.readInt();
        this.fromEntityID = buf.readInt();
        this.potionType = buf.readInt();
        this.duration = buf.readInt();
        this.remove = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(entityID);
        buf.writeInt(fromEntityID);
        buf.writeInt(potionType);
        buf.writeInt(duration);
        buf.writeBoolean(remove);
    }

    public static void handle(EffectEntityPacket message, Supplier<NetworkEvent.Context> context) {
        context.get().setPacketHandled(true);
        Player playerSided = context.get().getSender();
        if (context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT) {
            playerSided =  Minecraft.getInstance().player;
        }

        if (playerSided != null) {
            Entity entity = playerSided.level().getEntity(message.entityID);
            Entity senderEntity = playerSided.level().getEntity(message.fromEntityID);
            if (entity instanceof LivingEntity living && senderEntity != null && senderEntity.distanceTo(living) < 32) {
                MobEffect mobEffect = null;
                int level = 0;
                switch (message.potionType) {
                    case 0:
                        mobEffect = ChangShengJueEffects.FIXATION_EFFECT.get();
                        break;
                }
                if (mobEffect != null) {
                    if (message.remove) {
                        living.removeEffectNoUpdate(mobEffect);
                    } else {
                        living.addEffect(new MobEffectInstance(mobEffect, message.duration, level));
                    }
                }
            }
        }
    }

}
