package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public class WheatNuggetEncyclopedia extends AbstractionMentalKungfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "wheat_nugget_encyclopedia");

    public WheatNuggetEncyclopedia() {
        super(KUNG_FU_ID.toString(), Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.GREEN),
                KungFuType.MENTAL_KUNGFU, Component.translatable("description"), 0.15f);
    }

    @Override
    public void onInteraction(Player player) {
        if (!isReady()) return;
        if (level == 1) {
            if (randomSource.nextFloat() < 0.25f) {
                player.giveExperiencePoints(5); // 给予经验
            }
        }else if (level >= 2) {
            if (randomSource.nextFloat() < 0.35f) {
                player.giveExperiencePoints(10);
            }
        }

        int experienceLevel = player.experienceLevel;
        if (experienceLevel >= getMaxExp() && level < getMaxLevel()) {
            addExp(player,30);
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
        return 30;
    }
}
