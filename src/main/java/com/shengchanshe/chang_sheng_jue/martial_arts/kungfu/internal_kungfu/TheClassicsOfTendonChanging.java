package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class TheClassicsOfTendonChanging extends AbstractionInternalkungfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "the_classics_of_tendon_changing");

    public TheClassicsOfTendonChanging() {
        super(KUNG_FU_ID.toString(), Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.YELLOW),
                KungFuType.INTERNAL_KUNGFU, "description",0.15f, 0,0);
    }

    @Override
    public void onEntityTick(LivingEntity player) {}

    @Override
    public void onEntityHurt(LivingEntity livingEntity, DamageSource source, float amount) {

    }

    @Override
    public void onInteranKungFu(Level pLevel, LivingEntity pEntity) {
        if (pEntity instanceof Player player) {
            addExp(player, !player.getAbilities().instabuild ? 1 : getMaxExp());
        }
    }

    @Override
    public void onLevelUp(LivingEntity livingEntity) {
        getTendonChangingReduction(livingEntity);
    }

    public void getTendonChangingReduction(LivingEntity source) {
        if (source instanceof Player player) {
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                cap.getAllLearned().forEach(id -> {
                    cap.getKungFu(id.getId()).ifPresent(kungFu -> {
                        if (level == 1) {
                            id.setHunger(id.getHunger() - 1);
                            id.setSaturation(id.getSaturation() + 0.25f);
                        } else {
                            id.setHunger(id.getHunger() - 1);
                            id.setSaturation(id.getSaturation() - 0.25f);
                        }
                    });
                });
            });
        }
    }

    @Override
    public int getMaxCoolDown() {
        return 0;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public int getMaxExp() {
        return KungFuConfig.THE_CLASSICS_OF_TENDON_CHANGING_MAX_EXP.get();
    }
}
