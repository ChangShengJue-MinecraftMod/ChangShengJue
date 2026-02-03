package com.shengchanshe.chang_sheng_jue.mixin;

import cn.mcmod.arsenal.item.rapier.RapierItem;
import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.item.combat.clubbed.Clubbed;
import com.shengchanshe.chang_sheng_jue.item.combat.glove.GoldThreadGlove;
import com.shengchanshe.chang_sheng_jue.item.combat.knife.Knife;
import com.shengchanshe.chang_sheng_jue.item.combat.lance.Lance;
import com.shengchanshe.chang_sheng_jue.item.combat.sword.Sword;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.DuguNineSwords;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.XuannuSwordsmanship;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class MixinItem {

    @Inject(method = "releaseUsing(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/LivingEntity;I)V" , at = @At("HEAD"))
    @Unique
    public void changShengJue$releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged, CallbackInfo ci) {
        if (pLivingEntity instanceof Player player && !pLevel.isClientSide) {
            if ((player.getFoodData().getFoodLevel() > 8) || player.getAbilities().instabuild) {
                int usedTicks = pStack.getItem().getUseDuration(pStack) - pTimeCharged;
                if (net.minecraftforge.fml.ModList.get().isLoaded("arsenal_core")) {
                    if (pStack.getItem() instanceof RapierItem) {
                        player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                            if (cap.getCooldownTick(XuannuSwordsmanship.KUNG_FU_ID.toString()) <= 0 && cap.getKungFuLevel(XuannuSwordsmanship.KUNG_FU_ID.toString()) >= 1) {
                                // 检查是否按住至少 0.3 秒（6 tick）
                                if (usedTicks >= cap.getSwingTick((ServerPlayer) player, XuannuSwordsmanship.KUNG_FU_ID.toString()) && !player.isShiftKeyDown()) {
                                    cap.castKungFu(XuannuSwordsmanship.KUNG_FU_ID.toString(), player);
                                }
                            }
                        });
                    }
                }
                if (pStack.getItem() instanceof SwordItem
                        && !(pStack.getItem() instanceof Sword)
                        && !(pStack.getItem() instanceof Lance)
                        && !(pStack.getItem() instanceof Knife)
                        && !(pStack.getItem() instanceof GoldThreadGlove)
                        && !(pStack.getItem() instanceof Clubbed)) {
                    player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                        if (cap.getCooldownTick(DuguNineSwords.KUNG_FU_ID.toString()) <= 0 && cap.getKungFuLevel(DuguNineSwords.KUNG_FU_ID.toString()) >= 1) {
                            if (usedTicks >= cap.getSwingTick((ServerPlayer) player, DuguNineSwords.KUNG_FU_ID.toString())) {
                                cap.castKungFu(DuguNineSwords.KUNG_FU_ID.toString(), player);
                            }
                        }
                    });
                }
            }
        }
    }

    @Inject(method = "getUseDuration(Lnet/minecraft/world/item/ItemStack;)I" , at = @At("HEAD"), cancellable = true)
    @Unique
    public void changShengJue$getUseDuration(ItemStack pStack, CallbackInfoReturnable<Integer> cir) {
        if (pStack.getItem() instanceof SwordItem
                && !(pStack.getItem() instanceof Sword)
                && !(pStack.getItem() instanceof Lance)
                && !(pStack.getItem() instanceof Knife)
                && !(pStack.getItem() instanceof GoldThreadGlove)
                && !(pStack.getItem() instanceof Clubbed)) {
            cir.setReturnValue(72000);
        }

        if (net.minecraftforge.fml.ModList.get().isLoaded("arsenal_core")) {
            if (pStack.getItem() instanceof RapierItem) {
                cir.setReturnValue(72000);
            }
        }
    }
}
