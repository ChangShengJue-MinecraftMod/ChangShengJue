package com.shengchanshe.changshengjue.item.foods;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ChangShengJueFoods {
    public static final FoodProperties CORN = (new FoodProperties.Builder()).nutrition(3).saturationMod(3.6F).build();
    public static final FoodProperties PINEAPPLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(2.4F).build();//.fast可以吃的更快
    public static final FoodProperties TOMATO = (new FoodProperties.Builder()).nutrition(3).saturationMod(1.8F).build();
    public static final FoodProperties MANGO = (new FoodProperties.Builder()).nutrition(3).saturationMod(1.8F).build();
    public static final FoodProperties GUI_HUA = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).build();
    public static final FoodProperties CANTALOUPE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.5F).build();
    public static final FoodProperties BANANA = (new FoodProperties.Builder()).nutrition(4).saturationMod(3.2F).build();
    public static final FoodProperties VENISON = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).meat().build();
    public static final FoodProperties COOKED_VENISON = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).meat().build();
    public static final FoodProperties PEANUT = (new FoodProperties.Builder()).nutrition(3).saturationMod(1.8F).meat().build();
    public static final FoodProperties BRINJAL = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().build();
    public static final FoodProperties PEAR = (new FoodProperties.Builder()).nutrition(4).saturationMod(2.4F).build();
    public static final FoodProperties LICHEE = (new FoodProperties.Builder()).nutrition(4).saturationMod(2.4F).build();
    public static final FoodProperties GRAPE = (new FoodProperties.Builder()).nutrition(4).saturationMod(2.4F).build();
    public static final FoodProperties OPEN_DURIAN = (new FoodProperties.Builder()).nutrition(6).saturationMod(3.6F).build();
    public static final FoodProperties MULBERRY = (new FoodProperties.Builder()).nutrition(3).saturationMod(1.8F).build();

    public static final FoodProperties CAPSULE_JIAO_ZI = (new FoodProperties.Builder()).nutrition(7).saturationMod(8.4F).meat().build();
    public static final FoodProperties ZHENG_CAI = (new FoodProperties.Builder()).nutrition(5).saturationMod(6.0F).meat().build();
    public static final FoodProperties PORTULACA_OLERACEA_CAKE = (new FoodProperties.Builder()).nutrition(5).saturationMod(6.0F).meat().build();
    public static final FoodProperties QING_TUAN = (new FoodProperties.Builder()).nutrition(6).saturationMod(7.2F).meat().build();
    public static final FoodProperties BAKED_CORN = (new FoodProperties.Builder()).nutrition(5).saturationMod(6.0F).meat().build();
    public static final FoodProperties TOMATO_EGG = (new FoodProperties.Builder()).nutrition(6).saturationMod(7.2F).meat().build();
    public static final FoodProperties GU_LAO_ROU = (new FoodProperties.Builder()).nutrition(7).saturationMod(8.4F).meat().build();
    public static final FoodProperties MEAT_FOAM_BRINJAL = (new FoodProperties.Builder()).nutrition(7).saturationMod(8.4F).meat().build();
    public static final FoodProperties SORGHUM_CAKE = (new FoodProperties.Builder()).nutrition(5).saturationMod(6.0F).meat().build();
    public static final FoodProperties STINKY_TOFU = (new FoodProperties.Builder()).nutrition(5).saturationMod(6.0F).meat().build();
    public static final FoodProperties ZHU_DU_JI = (new FoodProperties.Builder()).nutrition(7).saturationMod(8.4F).meat().build();
    public static final FoodProperties XIAO_MI_FAN = (new FoodProperties.Builder()).nutrition(5).saturationMod(6F).meat().build();
    public static final FoodProperties MI_FAN = (new FoodProperties.Builder()).nutrition(5).saturationMod(6.0F).meat().build();
    public static final FoodProperties GUI_HUA_TANG_OU = (new FoodProperties.Builder()).nutrition(5).saturationMod(6F).meat().build();
    public static final FoodProperties BA_BAO_ZHOU = (new FoodProperties.Builder()).nutrition(10).saturationMod(12.0F).meat().build();

    public static final FoodProperties MULBERRY_JUICE = (new FoodProperties.Builder()).nutrition(7).saturationMod(4.8F).build();
    public static final FoodProperties APPLE_JUICE = (new FoodProperties.Builder()).nutrition(7).saturationMod(4.8F).build();
    public static final FoodProperties HOT_PEAR_SOUP = (new FoodProperties.Builder()).nutrition(8).saturationMod(5.2F).build();
    public static final FoodProperties GRAPE_JUICE = (new FoodProperties.Builder()).nutrition(7).saturationMod(4.8F).build();

    //茶
    public static final FoodProperties BILUOCHUN_TEA = (new FoodProperties.Builder()).nutrition(1).saturationMod(1.0F).effect(new MobEffectInstance(ChangShengJueEffects.BILUOCHUN_TEAS.get(), 1200, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties LONG_JING_TEA = (new FoodProperties.Builder()).nutrition(1).saturationMod(1.0F).effect(new MobEffectInstance(ChangShengJueEffects.LONG_JING_TEAS.get(), 1200, 0), 1.0F).alwaysEat().build();
    //酒水
    public static final FoodProperties FEN_JIU = (new FoodProperties.Builder()).nutrition(1).saturationMod(1.0F).alwaysEat().build();
    public static final FoodProperties WHEAT_NUGGETS_TRIBUTE_WINE = (new FoodProperties.Builder()).nutrition(1).saturationMod(1.0F).alwaysEat().build();
    public static final FoodProperties SHI_LI_XIANG = (new FoodProperties.Builder()).nutrition(1).saturationMod(1.0F).alwaysEat().build();
}
