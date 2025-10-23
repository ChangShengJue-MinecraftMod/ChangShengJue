package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu.ImmortalMiracleParticlePacket;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

public class ImmortalMiracle extends AbstractionInternalkungfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "immortal_miracle");

    public ImmortalMiracle() {
        super(KUNG_FU_ID.toString(), Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.GOLD),
                KungFuType.INTERNAL_KUNGFU, Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".hand_and_glove.type"),0.15f, 3,0.0f);
    }

    @Override
    public void onEntityTick(LivingEntity player) {
        if ((getMaxCoolDown() - wheatNuggetsTributeWineEffect(player)) - cooldown <= 40 && level >= 1) {
            ChangShengJueMessages.sendToPlayer(new ImmortalMiracleParticlePacket(player.getUUID(), KUNG_FU_ID.toString()), (ServerPlayer) player);
        }
    }

    @Override
    public void onEntityHurt(LivingDamageEvent event) {
        if (!isReady()) return;
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity == null || event.getSource() == null) return;

        if (livingEntity.getHealth() <= event.getAmount()) {
            if (livingEntity instanceof Player player) {
                if (!player.getAbilities().instabuild) {
                    cooldown = getMaxCoolDown() - wheatNuggetsTributeWineEffect(player);
                    int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? hunger - 1 : hunger;
                    player.getFoodData().eat(-foodLevel, getSaturation());
                }
                addExp(player, !player.getAbilities().instabuild ? 1 : getMaxExp());
                biluochunTeasAndLongJingTeasEffect(player);
            }
            livingEntity.setHealth(livingEntity.getMaxHealth());
            livingEntity.playSound(ChangShengJueSound.IMMORTAL_MIRACLE_SOUND.get(), 1.0F, livingEntity.isBaby() ?
                    (randomSource.nextFloat() - randomSource.nextFloat()) * 0.2F + 1.5F :
                    (randomSource.nextFloat() - randomSource.nextFloat()) * 0.2F + 1.0F);
            event.setCanceled(true);
        }
    }

    @Override
    public void onInteranKungFu(Level pLevel, LivingEntity pEntity) {}

    @Override
    public void onLevelUp(LivingEntity livingEntity) {

    }

    @Override
    public int getMaxCoolDown() {
        if (level == 2){
            return KungFuConfig.IMMORTAL_MIRACLE_MAX_COOLDOWN.get() - 15;
        } else if (level > 2){
            return KungFuConfig.IMMORTAL_MIRACLE_MAX_COOLDOWN.get() - (level * 15);
        }else {
            return KungFuConfig.IMMORTAL_MIRACLE_MAX_COOLDOWN.get();
        }
    }

    @Override
    public int getMaxLevel() {
        return KungFuConfig.IMMORTAL_MIRACLE_MAX_LEVEL.get();
    }

    @Override
    public int getMaxExp() {
        return KungFuConfig.IMMORTAL_MIRACLE_MAX_EXP.get();
    }
}
