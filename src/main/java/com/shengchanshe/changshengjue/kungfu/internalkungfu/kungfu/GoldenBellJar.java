package com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu;

import com.shengchanshe.changshengjue.kungfu.internalkungfu.InternalKungFuCapability;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.UUID;

public class GoldenBellJar implements InternalKungFuCapability {
    private static final int INTERNAL_KUNGFU_COOLDOWN_TIME = 8 * 20; // 冷却时间，单位为tick（1秒=20tick）
    private int internalKungFuCooldown; // 当前冷却时间
    private String internalKungFuID = "GoldenBellJar";

    public GoldenBellJar() {
        this.internalKungFuCooldown = 0; // 初始化冷却时间为0
    }

    @Override
    public String getInternalKungFuID() {
        return internalKungFuID;
    }

    @Override
    public void applyAttackEffect(LivingEntity livingEntity) {
        if (internalKungFuCooldown > 0) {
            // 如果还在冷却中，直接返回
            return;
        }
        livingEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 160, 5, true, true), livingEntity);
        if (!livingEntity.getPersistentData().getBoolean("HasArmorBoost")) {
            AttributeInstance armorAttr = livingEntity.getAttribute(Attributes.ARMOR);
            if (armorAttr != null) {
                AttributeModifier armorBoost = new AttributeModifier(
                        UUID.fromString("a3b2c1d0-1234-5678-9101-112131415161"),
                        "golden_bell_jar_armor",
                        8.0,
                        AttributeModifier.Operation.ADDITION
                );

                armorAttr.removeModifier(armorBoost.getId());
                armorAttr.addPermanentModifier(armorBoost);

                livingEntity.getPersistentData().putBoolean("HasArmorBoost", true);
            }
        }
        internalKungFuCooldown = INTERNAL_KUNGFU_COOLDOWN_TIME; // 设置冷却时间
    }

    @Override
    public void saveNBTData(CompoundTag compound) {
        compound.putString("InternalKungFuID", internalKungFuID);
        compound.putInt("InternalKungFuCooldown", internalKungFuCooldown);
    }

    @Override
    public void loadNBTData(CompoundTag compound) {
        internalKungFuID = compound.getString("InternalKungFuID");
        internalKungFuCooldown = compound.getInt("InternalKungFuCooldown");
    }

    @Override
    public boolean isInternalKungFuCooldownOver() {
        return internalKungFuCooldown <= 0;
    }

    @Override
    public void updateInternalKungFuCooldown() {
        if (internalKungFuCooldown > 0) {
            internalKungFuCooldown--;
        }
    }

}
