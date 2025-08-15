package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuType;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

import java.util.Optional;
import java.util.UUID;

public class QianKunDaNuoYi extends AbstractionInternalkungfu {
    public static final ResourceLocation KUNG_FU_ID = new ResourceLocation(ChangShengJue.MOD_ID, "qian_kun_da_nuo_yi");
    private int recordTime = 0;
    private float recordDamage = 0;
    private UUID recordDamageSource = UUID.randomUUID();
    private int maxCooldown = KungFuConfig.QIAN_KUN_DA_NUO_YI_MAX_COOLDOWN.get();
    private int extraCooldown = 0;
    public QianKunDaNuoYi() {
        super(KUNG_FU_ID.toString(), Component.translatable("item."+ ChangShengJue.MOD_ID + "." + KUNG_FU_ID.getPath()).withStyle(ChatFormatting.YELLOW),
                KungFuType.INTERNAL_KUNGFU, Component.translatable("message.kungfu."+ ChangShengJue.MOD_ID +".hand_and_glove.type"),0.15f, 2,0.0f);
    }

    @Override
    public void onEntityTick(LivingEntity player) {
        if (recordTime > 0 && recordDamageSource != null && recordDamage != 0) {
            recordTime--;
        }
        if (recordTime <= 0){
            Optional<Entity> entityOpt = Optional.ofNullable(((ServerLevel) player.level()).getEntity(recordDamageSource));
            entityOpt.ifPresent(entity -> {
                entity.hurt(new DamageSource(player.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                        .getHolderOrThrow(getDamageType()), player), recordDamage);
                recordTime = KungFuConfig.QIAN_KUN_DA_NUO_YI_BOUNCE_DAMAGE_TICK.get();
                recordDamage = 0;
                recordDamageSource = UUID.randomUUID();
                extraCooldown = KungFuConfig.QIAN_KUN_DA_NUO_YI_MAX_COOLDOWN_EXTRA_TICK.get();
                addMaxCoolDown();
            });
        }
        if (extraCooldown > 0) extraCooldown--;
    }

    @Override
    public void onEntityHurt(LivingDamageEvent event) {

    }

    @Override
    public void onAttackHurt(LivingAttackEvent event) {
        if (!isReady()) return;
        LivingEntity livingEntity = event.getEntity();
        if (randomSource.nextFloat() < getBounceDamageProbability(livingEntity)) {
            Entity entity = event.getSource().getEntity();
            if (entity != null) {
                if (livingEntity instanceof Player player) {
                    if (!player.getAbilities().instabuild) {
                        cooldown = maxCooldown - wheatNuggetsTributeWineEffect(player);
                        int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? hunger - 1 : hunger;
                        player.getFoodData().eat(-foodLevel, getSaturation());
                    }
                    addExp(player, !player.getAbilities().instabuild ? 1 : getMaxExp());
                    biluochunTeasAndLongJingTeasEffect(player);
                }
                recordDamageSource = entity.getUUID();
                recordTime = KungFuConfig.QIAN_KUN_DA_NUO_YI_BOUNCE_DAMAGE_TICK.get();
                recordDamage = event.getAmount() * getBounceDamageMultiplier();
            }
        }
    }

    @Override
    public void onInteranKungFu(Level pLevel, LivingEntity pEntity) {}

    public float getBounceDamageProbability(LivingEntity livingEntity){
        float healthMax = livingEntity.getMaxHealth();
        float baseChance = KungFuConfig.QIAN_KUN_DA_NUO_YI_BOUNCE_DAMAGE_PROBABILITY.get() / 100f;
        float healthBonus = (healthMax - 20.0F) * (KungFuConfig.QIAN_KUN_DA_NUO_YI_BOUNCE_DAMAGE_EXTRA_PROBABILITY.get() / 100f);
        float totalChance = baseChance + Math.max(0, healthBonus);
        return level < getMaxLevel() ? baseChance : totalChance;
    }

    public float getBounceDamageMultiplier() {
        if (level <= 2) {
            return (KungFuConfig.QIAN_KUN_DA_NUO_YI_BOUNCE_DAMAGE_MULTIPLIER.get() / 100f);
        }else {
            return level * (KungFuConfig.QIAN_KUN_DA_NUO_YI_BOUNCE_DAMAGE_MULTIPLIER.get() / 100f);
        }
    }

    public void addMaxCoolDown(){
        maxCooldown = maxCooldown + 20;
    }

    @Override
    public int getMaxCoolDown() {
        return maxCooldown;
    }

    @Override
    public int getMaxLevel() {
        return KungFuConfig.QIAN_KUN_DA_NUO_YI_MAX_LEVEL.get();
    }

    @Override
    public int getMaxExp() {
        return KungFuConfig.QIAN_KUN_DA_NUO_YI_MAX_EXP.get();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = super.serializeNBT();
        tag.putInt("RecordTime", this.recordTime);
        tag.putFloat("RecordDamage", this.recordDamage);
        tag.putUUID("RecordDamageSource", this.recordDamageSource);
        tag.putInt("MaxCooldown", this.maxCooldown);
        tag.putInt("ExtraCooldown", this.extraCooldown);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        super.deserializeNBT(tag);
        this.recordTime = tag.getInt("RecordTime");
        this.recordDamage = tag.getFloat("RecordDamage");
        if (!tag.contains("RecordDamageSource")) {
            this.recordDamageSource = UUID.randomUUID();
        }else {
            this.recordDamageSource = tag.getUUID("RecordDamageSource");
        }
        this.maxCooldown = tag.getInt("MaxCooldown");
        this.extraCooldown = tag.getInt("ExtraCooldown");
    }
}
