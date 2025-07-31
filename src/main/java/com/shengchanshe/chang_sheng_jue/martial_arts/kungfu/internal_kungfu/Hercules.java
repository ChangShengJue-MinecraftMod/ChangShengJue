package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.level.Level;

public class Hercules extends AbstractionInternalkungfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "hercules");
    private static final Component CONTAINER_TITLE = Component.translatable("container.hercules");

    public Hercules() {
        super(KUNG_FU_ID.toString(), Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.GOLD),
                KungFuType.INTERNAL_KUNGFU, "description",0.15f, 0,0.0f);
    }

    @Override
    public void onEntityTick(LivingEntity player) {
        if (!player.level().isClientSide) {
            if (player instanceof ServerPlayer serverPlayer) {
                if (level == 1) {
                    int walkedDistanceInCm = serverPlayer.getStats().getValue(Stats.CUSTOM.get(Stats.WALK_ONE_CM));
                    this.addExp(player,!serverPlayer.getAbilities().instabuild ? walkedDistanceInCm - getExp() : getMaxExp());
                }
            }
        }
    }

    @Override
    public void onEntityHurt(LivingEntity livingEntity, DamageSource source, float amount) {

    }

    @Override
    public void onInteranKungFu(Level pLevel, LivingEntity pEntity) {
        if (pEntity instanceof ServerPlayer pPlayer) {
            if (isStart) {
                if (level > 1) {
                    // 打开末影箱
                    PlayerEnderChestContainer playerenderchestcontainer = pPlayer.getEnderChestInventory();
                    pPlayer.openMenu(new SimpleMenuProvider((i, inventory, player) -> ChestMenu.threeRows(i, inventory, playerenderchestcontainer), CONTAINER_TITLE));
                }
                pPlayer.getMainHandItem().hurtAndBreak(1, pPlayer, (player1) -> {//消耗耐久
                    player1.broadcastBreakEvent(pPlayer.getUsedItemHand());
                });
            }
        }
    }

    @Override
    public void onLevelUp(LivingEntity livingEntity) {
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            this.addExp(serverPlayer,serverPlayer.getStats().getValue(Stats.CUSTOM.get(Stats.WALK_ONE_CM)));
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
        return KungFuConfig.HERCULES_MAX_EXP.get();
    }
}
