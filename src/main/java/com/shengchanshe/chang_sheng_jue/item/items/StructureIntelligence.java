package com.shengchanshe.chang_sheng_jue.item.items;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.tags.CSJTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;

public class StructureIntelligence extends Item {
    // 使用DamageValue区分结构类型
    public static final int PIT_YARD_TYPE = 0;
    public static final int SANDSTONE_CASTLE_TYPE = 1;
    public static final int SI_HE_YUAN_TYPE = 2;
    public static final int SU_PAI_VILLAGE_TYPE = 3;
    public static final int HUI_PAI_VILLAGE_TYPE = 4;
    public static final int FORTRESSES_TYPE = 5;

    public StructureIntelligence(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (level.isClientSide) return;

        if (entity instanceof Player player) {
            if (player.getMainHandItem().equals(stack) || player.getOffhandItem().equals(stack)) {
                if (!stack.hasTag() || !stack.getOrCreateTag().getBoolean("found")) {
                    TagKey<Structure> structureTag = getStructureTag(stack);
                    if (structureTag != null) {
                        BlockPos pos = ((ServerLevel)level).findNearestMapStructure(
                                structureTag, entity.blockPosition(), 100, false);

                        if (pos != null) {
                            bindPosition(stack, pos);
                            sendDiscoveryMessage(entity, getStructureName(stack), pos);
                        }
                    }
                }
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide && stack.hasTag()) {
            BlockPos pos = new BlockPos(stack.getTag().getInt("posX"), player.getBlockY(), stack.getTag().getInt("posZ"));
            sendDiscoveryMessage(player, getStructureName(stack), pos);
        }
        return InteractionResultHolder.success(stack);
    }
    // 将结构坐标绑定到物品NBT
    private void bindPosition(ItemStack stack, BlockPos pos) {
        stack.getOrCreateTag().putInt("posX", pos.getX());
        stack.getOrCreateTag().putInt("posZ", pos.getZ());
        stack.getOrCreateTag().putBoolean("found", true);
    }

    // 发送发现消息给玩家
    private void sendDiscoveryMessage(Entity entity, Component structureName, BlockPos pos) {
        if (entity instanceof Player player) {
            player.displayClientMessage(
                    Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".structural_location",
                            pos.getX(), pos.getZ(), structureName).withStyle(ChatFormatting.AQUA),false);
        }
    }

    // 根据DamageValue获取对应结构
    private TagKey<Structure> getStructureTag(ItemStack stack) {
        return switch(stack.getDamageValue()) {
            case PIT_YARD_TYPE -> CSJTags.StructureTypes.PIT_YARD;
            case SANDSTONE_CASTLE_TYPE -> CSJTags.StructureTypes.SANDSTONE_CASTLE;
            case SI_HE_YUAN_TYPE -> CSJTags.StructureTypes.SI_HE_YUAN;
            case SU_PAI_VILLAGE_TYPE -> CSJTags.StructureTypes.SU_PAI_VILLAGE;
            case HUI_PAI_VILLAGE_TYPE -> CSJTags.StructureTypes.HUI_PAI_VILLAGE;
            case FORTRESSES_TYPE -> CSJTags.StructureTypes.FORTRESSES;
            default -> null;
        };
    }

    private Component getStructureName(ItemStack stack) {
        return switch(stack.getDamageValue()) {
            case PIT_YARD_TYPE -> Component.translatable("tooltip." + ChangShengJue.MOD_ID + "." + "pit_yard.tooltip");
            case SANDSTONE_CASTLE_TYPE -> Component.translatable("tooltip." + ChangShengJue.MOD_ID + "." + "sandstone_castle.tooltip");
            case SI_HE_YUAN_TYPE -> Component.translatable("tooltip." + ChangShengJue.MOD_ID + "." + "si_he_yuan.tooltip");
            case SU_PAI_VILLAGE_TYPE -> Component.translatable("tooltip." + ChangShengJue.MOD_ID + "." + "su_pai_village.tooltip");
            case HUI_PAI_VILLAGE_TYPE ->   Component.translatable("tooltip." + ChangShengJue.MOD_ID + "." + "hui_pai_village.tooltip");
            case FORTRESSES_TYPE ->   Component.translatable("tooltip." + ChangShengJue.MOD_ID + "." + "fortresses_type.tooltip");
            default -> Component.translatable("tooltip." + ChangShengJue.MOD_ID + "." + "null.structure.tooltip");
        };
    }

    @Override
    public Component getName(ItemStack pStack) {
        int damage = pStack.getDamageValue();
        return Component.translatable(this.getDescriptionId() + "." + damage, getStructureName(pStack));
    }

}
