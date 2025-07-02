package com.shengchanshe.chang_sheng_jue.item.combat.armor;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.function.Supplier;

public enum ChangShengJueArmorMaterials implements ArmorMaterial {
    GOLD_SILK("gold_silk" , 18, new int[]{0, 4, 0, 0}, 25, SoundEvents.ARMOR_EQUIP_GOLD,
            0.0F, 0.0F, () -> Ingredient.of(Tags.Items.INGOTS_GOLD)),

    LEATHER("leather" , 6, new int[]{0, 3, 0, 0}, 15, SoundEvents.ARMOR_EQUIP_GOLD,
            0.0F, 0.0F, () -> Ingredient.of(Tags.Items.LEATHER)),

    COTTON("cotton", 40, new int[]{2, 5, 4, 2}, 15, SoundEvents.ARMOR_EQUIP_LEATHER,
            1.0F, 0.0F, () -> Ingredient.of(ChangShengJueItems.COTTON.get())),

    WALK("walk", 18, new int[]{1, 4, 4, 1}, 15, SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> Ingredient.of(ChangShengJueItems.COTTON.get())),

    SILK("silk", 6, new int[]{2, 4, 3, 2}, 15, SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> Ingredient.of(ChangShengJueItems.SILK.get())),

    TAOIST("taoist", 18, new int[]{1, 4, 3, 1}, 10, SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> Ingredient.of(ChangShengJueItems.SILK.get())),

    TAOIST_1("taoist_1",18, new int[]{2, 3, 3, 1}, 10, SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> Ingredient.of(ChangShengJueItems.SILK.get())),

    MOUNTAIN("mountain", 40, new int[]{3, 7, 5, 2}, 0, SoundEvents.ARMOR_EQUIP_CHAIN,
            2.0F, 0.0F, () -> Ingredient.of(Tags.Items.INGOTS_IRON)),

    INK("ink", 6, new int[]{1, 4, 3, 1}, 0, SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F, 0.0F, () -> Ingredient.of(ChangShengJueItems.SILK.get())),

    BRIGHT("bright", 40, new int[]{3, 7, 5, 2}, 0, SoundEvents.ARMOR_EQUIP_GOLD,
            2.0F, 0.0F, () -> Ingredient.merge(Arrays.asList(Ingredient.of(Tags.Items.INGOTS_IRON),
            Ingredient.of(Tags.Items.INGOTS_GOLD), Ingredient.of(Tags.Items.LEATHER)))),

    FLY("fly", 18, new int[]{2, 5, 4, 2}, 0, SoundEvents.ARMOR_EQUIP_GOLD,
            0.0F, 0.0F, () -> Ingredient.merge(Arrays.asList(Ingredient.of(Tags.Items.INGOTS_IRON),
            Ingredient.of(Tags.Items.INGOTS_GOLD), Ingredient.of(ChangShengJueItems.SILK.get())))),

    FLY_HAT("fly_hat", 18, new int[]{3, 5, 4, 2}, 0, SoundEvents.ARMOR_EQUIP_GOLD,
            1.0F, 0.0F, () -> Ingredient.merge(Arrays.asList(Ingredient.of(Tags.Items.INGOTS_IRON))));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] DEFAULT_PROTECTIONS = new int[]{11, 16, 15, 13};

    ChangShengJueArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return DEFAULT_PROTECTIONS[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return ChangShengJue.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
