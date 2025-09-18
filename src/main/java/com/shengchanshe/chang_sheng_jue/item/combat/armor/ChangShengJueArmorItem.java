package com.shengchanshe.chang_sheng_jue.item.combat.armor;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.inner_armor.GoldSilkSoftArmor;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.inner_armor.InnerArmorInterface;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ChangShengJueArmorItem extends ArmorItem {
    // 替换原有的 itemstack 字段和相关方法
    private static final String INNER_ARMOR_TAG = "InnerArmorData";
    private static final String DAMAGE_REDUCTION_TAG = "DamageReduction";
    private static final String TRAUMA = "Trauma";
    private final RandomSource RANDOM_SOURCE = RandomSource.create();
    public ChangShengJueArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        if (!stack.hasTag() || !stack.getTag().contains(DAMAGE_REDUCTION_TAG)) {
            if (this.getEquipmentSlot() == EquipmentSlot.CHEST) {
                CompoundTag tag = stack.getOrCreateTag();
                tag.putFloat(DAMAGE_REDUCTION_TAG, 30);
            }
        }
        if (!stack.hasTag() || !stack.getTag().contains(TRAUMA)) {
            if (this.getEquipmentSlot() == EquipmentSlot.CHEST) {
                CompoundTag tag = stack.getOrCreateTag();
                tag.putFloat(TRAUMA, 10);
            }
        }
        return stack;
    }

    private void ensureDamageReduction(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (!tag.contains(DAMAGE_REDUCTION_TAG)) {
            float newReduction = (150 + RANDOM_SOURCE.nextInt(151)) / 10f;
            if (this.getEquipmentSlot() == EquipmentSlot.CHEST) {
                tag.putFloat(DAMAGE_REDUCTION_TAG, Math.max(tag.getFloat(DAMAGE_REDUCTION_TAG), newReduction));
            }
        }
    }

    private void ensureTrauma(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (!tag.contains(TRAUMA)) {
            float newReduction = (50 + RANDOM_SOURCE.nextInt(51)) / 10f;
            if (this.getEquipmentSlot() == EquipmentSlot.CHEST) {
                tag.putFloat(TRAUMA, Math.max(tag.getFloat(TRAUMA), newReduction));
            }
        }
    }

    @Override
    public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        ensureDamageReduction(stack);
        ensureTrauma(stack);
        return super.initCapabilities(stack, nbt);
    }

    public float getTrauma(ItemStack stack){
        CompoundTag tag = stack.getOrCreateTag();
        return (tag.getFloat(TRAUMA));
    }

    public boolean hasTrauma(ItemStack stack){
        return stack.hasTag() && stack.getTag().contains(TRAUMA);
    }

    public float getDamageReduction(ItemStack stack){
        CompoundTag tag = stack.getOrCreateTag();
        return (tag.getFloat(DAMAGE_REDUCTION_TAG) / 100F);
    }

    public boolean hasDamageReduction(ItemStack stack){
        return stack.hasTag() && stack.getTag().contains(DAMAGE_REDUCTION_TAG);
    }

    //判断内甲状态
    public boolean hasInnerArmor(ItemStack stack) {
        return stack.hasTag() && stack.getTag().contains(INNER_ARMOR_TAG);
    }
    private void installInnerArmor(ItemStack armorStack, ItemStack innerArmor) {
        CompoundTag tag = armorStack.getOrCreateTag();
        tag.put(INNER_ARMOR_TAG, innerArmor.save(new CompoundTag()));
    }
    private Optional<ItemStack> getInnerArmorStack(ItemStack armorStack) {
        if (hasInnerArmor(armorStack)) {
            return Optional.of(ItemStack.of(armorStack.getTag().getCompound(INNER_ARMOR_TAG)));
        }
        return Optional.empty();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack armorStack = pPlayer.getItemInHand(pHand);
        if (!pLevel.isClientSide){
            // 检查背包是否有内甲材料
            if (pPlayer.isShiftKeyDown()) {
                ItemStack stack = pPlayer.getOffhandItem();
                if (!hasInnerArmor(armorStack) && !stack.isEmpty() && stack.getItem() instanceof InnerArmorInterface) {
                    if (this.getEquipmentSlot() == EquipmentSlot.CHEST){
                        if (stack.getItem() instanceof GoldSilkSoftArmor && armorStack.getItem() instanceof ArmorInterface){
                            pPlayer.displayClientMessage(Component.translatable("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.lining").append(stack.getHoverName().copy()), true);
                            return InteractionResultHolder.success(armorStack);
                        }
                        pPlayer.displayClientMessage(Component.translatable("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data").append(stack.getHoverName().copy()), true);
                        installInnerArmor(armorStack, stack.copyWithCount(1));
                        if (!pPlayer.getAbilities().instabuild) {
                            stack.shrink(1);
                        }
                    }else {
                        pPlayer.displayClientMessage(Component.translatable("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.lining1").append(stack.getHoverName().copy()), true);
                    }
                } else if (hasInnerArmor(armorStack)){
                    // 移除内甲
                    getInnerArmorStack(armorStack).ifPresent(innerStack -> {
                        pPlayer.displayClientMessage(Component.translatable("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.unload").append(innerStack.getHoverName().copy()), true);
                        if (!pPlayer.getInventory().add(innerStack)) {
                            pPlayer.drop(innerStack, false);
                        }
                        armorStack.getTag().remove(INNER_ARMOR_TAG);
                    });
                }else {
                    return super.use(pLevel, pPlayer, pHand);
                }
            } else {
                ItemStack itemBySlot = pPlayer.getItemBySlot(EquipmentSlot.CHEST);
                if (itemBySlot.getItem() instanceof InnerArmorInterface && this.getEquipmentSlot() == EquipmentSlot.CHEST) {
                    installInnerArmor(armorStack, itemBySlot.copyWithCount(1));
                    pPlayer.displayClientMessage(Component.translatable("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data").append(itemBySlot.getHoverName().copy()), true);
                    if (!pPlayer.getAbilities().instabuild) {
                        itemBySlot.shrink(1);
                    }
                }
                return super.use(pLevel, pPlayer, pHand);
            }
        }
        return InteractionResultHolder.consume(armorStack);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> modifiers = LinkedHashMultimap.create();
        modifiers.putAll(super.getAttributeModifiers(slot, stack));
        if (slot == this.getEquipmentSlot() && hasInnerArmor(stack)) {
            getInnerArmorStack(stack).ifPresent(innerItem -> {
                if (innerItem.getItem() instanceof ArmorItem innerArmor){
                    // 计算组合属性
                    double totalArmor = this.getMaterial().getDefenseForType(this.getType())
                            + innerArmor.getDefense();
                    double totalToughness = this.getMaterial().getToughness()
                            + innerArmor.getMaterial().getToughness();

                    // 使用槽位自适应的UUID生成策略
                    UUID slotUUID = UUID.nameUUIDFromBytes(
                            (stack.getDescriptionId() + slot.getName()).getBytes()
                    );
                    if (innerArmor instanceof GoldSilkSoftArmor){
                        totalArmor = totalArmor + 2;
                        totalToughness = totalToughness + 4;
                    }

//                    // 清除旧修饰符
//                    modifiers.removeAll(Attributes.ARMOR);
//                    modifiers.put(Attributes.ARMOR, new AttributeModifier(
//                            slotUUID,
//                            "Custom Armor Modifier",
//                            totalArmor,
//                            AttributeModifier.Operation.ADDITION
//                    ));
                    // 替换原有修饰符（避免叠加）
                    modifiers.replaceValues(Attributes.ARMOR, ImmutableList.of(
                            new AttributeModifier(
                                    slotUUID,
                                    "CombinedArmor",
                                    totalArmor,
                                    AttributeModifier.Operation.ADDITION
                            )
                    ));

                    modifiers.replaceValues(Attributes.ARMOR_TOUGHNESS, ImmutableList.of(
                            new AttributeModifier(
                                    slotUUID,
                                    "CombinedToughness",
                                    totalToughness,
                                    AttributeModifier.Operation.ADDITION
                            )
                    ));
                }
            });
        }
        return modifiers;
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (hasInnerArmor(pStack)){
            // 获取内甲ItemStack
            ItemStack innerArmor = ItemStack.of(pStack.getTag().getCompound(INNER_ARMOR_TAG));
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data").append(innerArmor.getHoverName().copy()).withStyle(ChatFormatting.GRAY));
        }
        if (hasDamageReduction(pStack)) {
            float reduction = pStack.getTag().getFloat(DAMAGE_REDUCTION_TAG);
            pTooltipComponents.add(Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".damage_reduction", reduction).withStyle(ChatFormatting.BLUE));
        }
        if (hasTrauma(pStack)) {
            float aFloat = pStack.getTag().getFloat(TRAUMA);
            pTooltipComponents.add(Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".trauma", aFloat).withStyle(ChatFormatting.BLUE));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}
