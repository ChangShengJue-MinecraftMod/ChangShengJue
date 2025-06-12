package com.shengchanshe.changshengjue.item.combat.armor.qi_tian_da_sheng;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.function.Consumer;

public class QiTianDaSheng extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final String DAMAGE_REDUCTION_TAG = "DamageReduction";
    private static final String TRAUMA = "Trauma";
    private final int durabilityMultiplier;
    private final RandomSource RANDOM_SOURCE = RandomSource.create();
    public QiTianDaSheng(ArmorMaterial pMaterial, Type pType, Properties pProperties,int durabilityMultiplier) {
        super(pMaterial, pType, pProperties);
        this.durabilityMultiplier = durabilityMultiplier; // 存储自定义的耐久倍数
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        // 使用原版的 ArmorMaterial 耐久值计算，并乘以自定义倍数
        int[] baseDurability = {13, 15, 16, 11}; // 原版盔甲的基础耐久值
        EquipmentSlot slot = this.getEquipmentSlot();
        return baseDurability[slot.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        if (!stack.hasTag() || !stack.getTag().contains(DAMAGE_REDUCTION_TAG)) {
            if (this.getEquipmentSlot() == EquipmentSlot.CHEST) {
                CompoundTag tag = stack.getOrCreateTag();
                tag.putFloat(DAMAGE_REDUCTION_TAG, 40);
            }
        }
        if (!stack.hasTag() || !stack.getTag().contains(TRAUMA)) {
            if (this.getEquipmentSlot() == EquipmentSlot.CHEST) {
                CompoundTag tag = stack.getOrCreateTag();
                tag.putFloat(TRAUMA, 15);
            }
        }
        return stack;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        // 禁止任何修复材料生效 禁用铁砧修复
        return false;
//                repair.is(Items.EMERALD);
    }

    private void ensureTrauma(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (this.getEquipmentSlot() != EquipmentSlot.CHEST) return;
        if (!tag.contains(TRAUMA)) {
            float newReduction = (70 + RANDOM_SOURCE.nextInt(81)) /10.0f;
                tag.putFloat(TRAUMA, Math.max(tag.getFloat(TRAUMA), newReduction));
        }
    }

    private void ensureDamageReduction(ItemStack stack) {
        if (this.getEquipmentSlot() != EquipmentSlot.CHEST) return;
        if (!stack.hasTag() || !stack.getTag().contains(DAMAGE_REDUCTION_TAG)) {
            float newReduction = (200 + RANDOM_SOURCE.nextInt(201)) / 10.0f;
            CompoundTag tag = stack.getOrCreateTag();
            tag.putFloat(DAMAGE_REDUCTION_TAG,
                Math.max(newReduction, tag.getFloat(DAMAGE_REDUCTION_TAG)));
        }
    }

    public float getDamageReduction(ItemStack stack){
        CompoundTag tag = stack.getOrCreateTag();
        return (tag.getFloat(DAMAGE_REDUCTION_TAG) / 100F);
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        ensureDamageReduction(stack);
        ensureTrauma(stack);
        return super.initCapabilities(stack, nbt);
    }

    public boolean hasDamageReduction(ItemStack stack){
        return stack.hasTag() && stack.getTag().contains(DAMAGE_REDUCTION_TAG);
    }

    public float getTrauma(ItemStack stack){
        CompoundTag tag = stack.getOrCreateTag();
        return (tag.getFloat(TRAUMA));
    }

    public boolean hasTrauma(ItemStack stack){
        return stack.hasTag() && stack.getTag().contains(TRAUMA);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GeoArmorRenderer<?> renderer;

            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null) {
                    this.renderer = new QiTianDaShengRender();
                }

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(((new AnimationController<>(this, 0, (state) ->
                state.setAndContinue(DefaultAnimations.IDLE)))));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
//        if (hasDamageReduction(pStack)) {
//            int reduction = pStack.getTag().getInt(DAMAGE_REDUCTION_TAG);
//            pTooltipComponents.add(
//                    Component.translatable(
//                            "tooltip." + ChangShengJue.MOD_ID + ".damage_reduction",
//                            reduction
//                    ).withStyle(ChatFormatting.BLUE)
//            );
//        }
//        if (hasTrauma(pStack)) {
//            int anInt = pStack.getTag().getInt(TRAUMA);
//            pTooltipComponents.add(Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".trauma", anInt).withStyle(ChatFormatting.BLUE));
//        }
        if (Screen.hasShiftDown()) {
            if (hasDamageReduction(pStack)) {
                float reduction = pStack.getTag().getFloat(DAMAGE_REDUCTION_TAG);
                pTooltipComponents.add(Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".damage_reduction", reduction).withStyle(ChatFormatting.BLUE));
            }
            if (hasTrauma(pStack)) {
                float aFloat = pStack.getTag().getFloat(TRAUMA);
                pTooltipComponents.add(Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".trauma", aFloat).withStyle(ChatFormatting.BLUE));
            }
        } else {
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID +".hold_shift.tooltip"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
