package com.shengchanshe.chang_sheng_jue.item.kungfuxp;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.AbstractionInternalkungfu;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InternalkungfuXp extends Item {
    public InternalkungfuXp(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide) {
            int totalExpUsed = grantExperience(pPlayer, 5);
            if (totalExpUsed > 0) {
                playExperienceParticle(pPlayer);
                return InteractionResultHolder.consume(itemStack);
            } else {
                return InteractionResultHolder.fail(itemStack);
            }
        }
        return InteractionResultHolder.pass(itemStack);
    }

    public static int grantExperience(Player player, int maximumExperience) {
        if (player.level().isClientSide || maximumExperience <= 0) {
            return 0;
        }
        int[] totalExpUsed = {0};
        player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
            List<AbstractionInternalkungfu> kungFus = new ArrayList<>();
            cap.getAllLearned().forEach(kungFu -> {
                if (kungFu instanceof AbstractionInternalkungfu upgradable) {
                    kungFus.add(upgradable);
                }
            });
            kungFus.sort(Comparator.comparingInt(kf -> kf.getMaxExp() - kf.getExp()));

            int remainingExp = maximumExperience;

            for (AbstractionInternalkungfu kungFu : kungFus) {
                if (remainingExp <= 0) break;

                if (kungFu.getLevel() < kungFu.getMaxLevel()) {
                    int expNeeded = kungFu.getMaxExp() - kungFu.getExp();
                    int expToAdd = Math.min(remainingExp, expNeeded);

                    kungFu.addExp(player, expToAdd);
                    remainingExp -= expToAdd;
                    totalExpUsed[0] += expToAdd;
                }
            }
        });
        return totalExpUsed[0];
    }

    public static void playExperienceParticle(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            KungFuXpParticleScheduler.start(serverPlayer,
                    ChangShengJueParticles.INTERNAL_KUNG_FU_XP_PARTICLE.get());
        }
    }
}
