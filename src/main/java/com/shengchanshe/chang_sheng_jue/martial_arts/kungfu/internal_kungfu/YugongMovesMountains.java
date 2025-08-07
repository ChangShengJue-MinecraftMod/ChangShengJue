package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class YugongMovesMountains extends AbstractionInternalkungfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "yugong_moves_mountains");

    private int kaishanPickaxeMaxDamage = 0;

    public YugongMovesMountains() {
        super(KUNG_FU_ID.toString(), Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.GRAY),
                KungFuType.INTERNAL_KUNGFU, Component.translatable("description"),0.15f, 0,0);
    }

    @Override
    public void onEntityTick(LivingEntity player) {
    }

    @Override
    public void onEntityHurt(LivingEntity livingEntity, DamageSource source, float amount) {
    }

    @Override
    public void onInteranKungFu(Level pLevel, LivingEntity pEntity) {
        if (pEntity instanceof Player player) {
            addExp(player, !player.getAbilities().instabuild ? 1 : getMaxExp());
        }
    }

    public int getKaishanPickaxeMaxDamage() {
        return kaishanPickaxeMaxDamage;
    }

    public void setKaishanPickaxeMaxDamage(int kaishanPickaxeMaxDamage) {
        this.kaishanPickaxeMaxDamage = kaishanPickaxeMaxDamage;
    }

    @Override
    public void onLevelUp(LivingEntity livingEntity) {
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
        return KungFuConfig.YUGONG_MOVES_MOUNTAINS_MAX_EXP.get();
    }
}
