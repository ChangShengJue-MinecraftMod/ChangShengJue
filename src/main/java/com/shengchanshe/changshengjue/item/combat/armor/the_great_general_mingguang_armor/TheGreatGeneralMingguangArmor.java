package com.shengchanshe.changshengjue.item.combat.armor.the_great_general_mingguang_armor;

import com.shengchanshe.changshengjue.item.combat.armor.ArmorInterface;
import com.shengchanshe.changshengjue.item.combat.armor.ChangShengJueArmorItem;
import com.shengchanshe.changshengjue.item.combat.armor.qi_tian_da_sheng.QiTianDaShengRender;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class TheGreatGeneralMingguangArmor extends ChangShengJueArmorItem implements GeoItem , ArmorInterface {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private final int durabilityMultiplier;
    public TheGreatGeneralMingguangArmor(ArmorMaterial pMaterial, Type pType, Properties pProperties, int durabilityMultiplier) {
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
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        // 禁止任何修复材料生效 禁用铁砧修复
        return false;
//                repair.is(Items.EMERALD);
    }
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GeoArmorRenderer<?> renderer;

            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null) {
                    this.renderer = new TheGreatGeneralMingguangArmorRender();
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
}
