package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class GoldenBellJar extends AbstractionInternalkungfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "golden_bell_jar");

    public GoldenBellJar() {
        super(KUNG_FU_ID.toString(), Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.GOLD),
                KungFuType.INTERNAL_KUNGFU, "description",0.15f, 2,0.0f);
    }

    @Override
    public void onEntityTick(LivingEntity player) {}

    @Override
    public void onEntityHurt(LivingEntity livingEntity, DamageSource source, float amount) {
        if (!isReady()) return;

        if (livingEntity instanceof Player player) {
            if (!player.getAbilities().instabuild) {
                cooldown = getMaxCoolDown() - wheatNuggetsTributeWineEffect(player);
                int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? hunger - 1 : hunger;
                player.getFoodData().eat(-foodLevel, getSaturation());
            }
            addExp(player, !player.getAbilities().instabuild ? 1 : getMaxExp());
            biluochunTeasAndLongJingTeasEffect(player);
        }
        livingEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 160,
                getEffectLevel(level),true, true), livingEntity);
        livingEntity.level().playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(),
                ChangShengJueSound.GOLDEN_BELLJAR_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
    }

    @Override
    public void onInteranKungFu(Level pLevel, LivingEntity pEntity) {}

    @Override
    public void onLevelUp(LivingEntity livingEntity) {
        if (livingEntity instanceof Player player) {
            AttributeInstance armorAttribute = player.getAttribute(Attributes.ARMOR);
            if (armorAttribute == null) return;

            UUID MODIFIER_ID = UUID.fromString("0592fca4-d671-43da-94a6-00f478d0b3b8");

            armorAttribute.removeModifier(MODIFIER_ID);

            double bonus = getarmorAttribute(level);
            armorAttribute.addPermanentModifier(new AttributeModifier(MODIFIER_ID, "golden_bell_jar", bonus, AttributeModifier.Operation.ADDITION));
        }
    }

    public float getarmorAttribute(int level) {
        float baseValue = level * 4.0f;
        return Math.min(baseValue, 20.0f);
    }

    public int getEffectLevel(int level) {
        int baseValue = level * 2;
        return Math.min(baseValue, 4);
    }

    @Override
    public int getMaxCoolDown() {
        return KungFuConfig.GOLDEN_BELL_JAR_MAX_COOLDOWN.get();
    }

    @Override
    public int getMaxLevel() {
        return KungFuConfig.GOLDEN_BELL_JAR_MAX_LEVEL.get();
    }

    @Override
    public int getMaxExp() {
        return KungFuConfig.GOLDEN_BELL_JAR_MAX_EXP.get();
    }
}
