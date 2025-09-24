package com.shengchanshe.chang_sheng_jue.item.kungfuxp;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.AbstractionInternalkungfu;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu.XpParticlePacket;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InternalkungfuXp extends Item {
    private boolean useOn = false;
    private int xpParticleTick = 0;

    public InternalkungfuXp(Properties pProperties) {
        super(pProperties);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemStack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide) {
            final int[] totalExpUsed = {0};
            final int maxExpFromItem = 5;

            pPlayer.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                List<AbstractionInternalkungfu> kungFus = new ArrayList<>();
                cap.getAllLearned().forEach(kungFu -> {
                    if (kungFu instanceof AbstractionInternalkungfu upgradable) {
                        kungFus.add(upgradable);
                    }
                });
                kungFus.sort(Comparator.comparingInt(kf -> kf.getMaxExp() - kf.getExp()));

                int remainingExp = maxExpFromItem;

                for (AbstractionInternalkungfu kungFu : kungFus) {
                    if (remainingExp <= 0) break;

                    if (kungFu.getLevel() < kungFu.getMaxLevel()) {
                        int expNeeded = kungFu.getMaxExp() - kungFu.getExp();
                        int expToAdd = Math.min(remainingExp, expNeeded);

                        kungFu.addExp(pPlayer, expToAdd);
                        remainingExp -= expToAdd;
                        totalExpUsed[0] += expToAdd;
                    }
                }
            });

            if (totalExpUsed[0] > 0) {
                itemStack.shrink(1);
                useOn = true;
                xpParticleTick = 1;
                return InteractionResultHolder.consume(itemStack);
            } else {
                return InteractionResultHolder.fail(itemStack);
            }
        }
        return InteractionResultHolder.pass(itemStack);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            if (!player.level().isClientSide){
                if (useOn && xpParticleTick > 0 && xpParticleTick <= 20) {
                    xpParticleTick++;
                    ChangShengJueMessages.sendToPlayer(new XpParticlePacket(player.getUUID(), ChangShengJueParticles.INTERNAL_KUNG_FU_XP_PARTICLE.get(), xpParticleTick), (ServerPlayer) player);
                }else {
                    useOn = false;
                    xpParticleTick = 0;
                }
            }
        }
    }
}
