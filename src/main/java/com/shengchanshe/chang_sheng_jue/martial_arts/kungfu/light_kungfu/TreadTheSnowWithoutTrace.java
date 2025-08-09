package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.light_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu.TreadTheSnowWithoutTraceParticlePacket;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class TreadTheSnowWithoutTrace extends AbstractionLightKungfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "tread_the_snow_without_trace");
    public TreadTheSnowWithoutTrace() {
        super(KUNG_FU_ID.toString(), Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.GREEN),
                KungFuType.LIGHT_KUNGFU, Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".run_and_jump.type"), 0.15f);
    }

    @Override
    public void onLightKungfu(Player player) {
        if (!isReady()) return;

        if (!player.getAbilities().instabuild) {
            cooldown = (getMaxCoolDown() - wheatNuggetsTributeWineEffect(player));
            player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                    ChangShengJueSound.TREAD_THE_SNOW_WITHOUT_TRACE_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
        }
        addExp(player, !player.getAbilities().instabuild ? 1 : getMaxExp());
    }

    @Override
    public void onEntityTick(LivingEntity player) {
        if ((getMaxCoolDown() - wheatNuggetsTributeWineEffect(player)) - cooldown <= 40 && level >= 1) {
            ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTraceParticlePacket(player.getUUID(), KUNG_FU_ID.toString()), (ServerPlayer) player);
        }
    }

    @Override
    public Component getDescription() {
        return Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".run_and_jump.type");
    }

    @Override
    public int getMaxCoolDown() {
        return KungFuConfig.TREAD_THE_SNOW_WITHOUT_TRACE_MAX_COOLDOWN.get();
    }

    @Override
    public int getMaxLevel() {
        return KungFuConfig.TREAD_THE_SNOW_WITHOUT_TRACE_MAX_LEVEL.get();
    }

    @Override
    public int getMaxExp() {
        return KungFuConfig.TREAD_THE_SNOW_WITHOUT_TRACE_MAX_EXP.get();
    }
}
