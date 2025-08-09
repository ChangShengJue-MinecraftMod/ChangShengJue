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
import net.minecraftforge.event.entity.living.LivingDamageEvent;

public class WuGangCutGui extends AbstractionInternalkungfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "wu_gang_cut_gui");
    private int xuanhuaAxeMaxDamage= 0;
    public WuGangCutGui() {
        super(KUNG_FU_ID.toString(), Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.GREEN),
                KungFuType.INTERNAL_KUNGFU, Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".hand_and_glove.type"),0.15f, 0,0);
    }

    @Override
    public void onEntityTick(LivingEntity player) {
    }

    @Override
    public void onEntityHurt(LivingDamageEvent event) {

    }

    @Override
    public void onInteranKungFu(Level pLevel, LivingEntity pEntity) {
        if (pEntity instanceof Player player) {
            addExp(player, !player.getAbilities().instabuild ? 1 : getMaxExp());
        }
    }

    public int getXuanhuaAxeMaxDamage() {
        return xuanhuaAxeMaxDamage;
    }

    public void setXuanhuaAxeMaxDamage(int xuanhuaAxeMaxDamage) {
        this.xuanhuaAxeMaxDamage = xuanhuaAxeMaxDamage;
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
        return KungFuConfig.THE_CLASSICS_OF_TENDON_CHANGING_MAX_EXP.get();
    }
}
