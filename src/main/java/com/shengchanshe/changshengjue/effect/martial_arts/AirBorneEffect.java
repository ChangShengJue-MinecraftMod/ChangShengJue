package com.shengchanshe.changshengjue.effect.martial_arts;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;

public class AirBorneEffect extends MobEffect {
    public AirBorneEffect() {
        // 第二个参数是颜色
        super(MobEffectCategory.HARMFUL, 00000000);
        addAttributeModifier(ForgeMod.ENTITY_GRAVITY.get(), "20D64EBF-8669-F7A4-E220-3F18BEF4ACD7",-0.3, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }
}
