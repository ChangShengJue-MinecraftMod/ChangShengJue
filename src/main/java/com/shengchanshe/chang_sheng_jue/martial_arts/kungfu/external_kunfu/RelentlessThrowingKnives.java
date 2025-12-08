package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.item.combat.throwingknives.FlyingDaggerPouch;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import com.shengchanshe.chang_sheng_jue.util.EffectUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class RelentlessThrowingKnives extends AbstractionExternalKunfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "relentless_throwing_knives");

    public RelentlessThrowingKnives() {
        super(KUNG_FU_ID.toString(),
                Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.BLUE),
                KungFuType.EXTERNAL_KUNFU,
                Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".throwingknives.type"),0.1f,0.15f,2,0.0f,
                0.25f, 3);
    }

    @Override
    public void release(LivingEntity pEntity) {
        if (!isReady()) return;

        if (pEntity instanceof Player player) {
            if (!player.getAbilities().instabuild) {
                int maxCoolDown = (getMaxCoolDown() - wheatNuggetsTributeWineEffect(player));
                cooldown = maxCoolDown;
                int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? hunger - 1 : hunger;
                player.getFoodData().eat(-foodLevel, getSaturation());
                if (!(player.getMainHandItem().getItem() instanceof FlyingDaggerPouch)) {
                    player.getCooldowns().addCooldown(player.getMainHandItem().getItem(), maxCoolDown);
                }
            }
            addExp(pEntity, !player.getAbilities().instabuild ? 1 : getMaxExp());
            biluochunTeasAndLongJingTeasEffect(player);
        }
    }

    @Override
    public float getDamage(LivingEntity entity) {
        return 0;
    }

    @Override
    public void attackEffect(LivingEntity source, Entity target) {
        if (target instanceof LivingEntity livingEntity) {
            if (isComprehend && level > 0) {
                if (target != source) {
                    EffectUtils.setTrauma(source, livingEntity, 2,140,traumaProbability);
                }
            }
        }
    }

    @Override
    public Component getDescription() {
        return Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".throwingknives.type");
    }

    @Override
    public int getSwingTick() {
        return 3;
    }

    public int getThrowingKnivesCount() {
        if (level == 1) {
            return level + 2;
        } else if (level == 2) {
            return level + 5;
        }else {
            return level + 7;
        }
    }

    @Override
    public float getDamageFactor() {
        if (level == 1){
            return 1.3f;
        } else if (level == 2){
            return 1.5f;
        } else {
            return level + 1.5f;
        }
    }

    @Override
    public float getEffectProbability() {
        if (level >= 2){
            return super.getEffectProbability() * 1.25f;
        }else {
            return super.getEffectProbability();
        }
    }

    @Override
    public int getMaxCoolDown() {
        return KungFuConfig.RELENTLESS_THROWING_KNIVES_MAX_COOLDOWN.get();
    }

    @Override
    public int getMaxLevel() {
        return KungFuConfig.RELENTLESS_THROWING_KNIVES_MAX_LEVEL.get();
    }

    @Override
    public int getMaxExp() {
        return KungFuConfig.RELENTLESS_THROWING_KNIVES_MAX_EXP.get();
    }

}
