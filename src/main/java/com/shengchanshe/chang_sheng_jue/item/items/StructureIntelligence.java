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

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class StructureIntelligence extends Item {
    // 使用DamageValue区分结构类型
    public static final int PIT_YARD_TYPE = 0;
    public static final int SANDSTONE_CASTLE_TYPE = 1;
    public static final int SI_HE_YUAN_TYPE = 2;
    public static final int SU_PAI_VILLAGE_TYPE = 3;
    public static final int HUI_PAI_VILLAGE_TYPE = 4;
    public static final int FORTRESSES_TYPE = 5;
    private static final int SEARCH_RADIUS = 100; // 搜索半径

    public StructureIntelligence(Properties properties) {
        super(properties);
    }

    private static final Map<UUID, CompletableFuture<BlockPos>> activeSearches = new ConcurrentHashMap<>();

    private UUID getOrCreateItemId(ItemStack stack) {
        var tag = stack.getOrCreateTag();
        if (!tag.hasUUID("itemId")) {
            tag.putUUID("itemId", UUID.randomUUID());
        }
        return tag.getUUID("itemId");
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (level.isClientSide) {
            return InteractionResultHolder.success(stack);
        }

        var tag = stack.getOrCreateTag();

        if (tag.getBoolean("found")) {
            BlockPos pos = new BlockPos(tag.getInt("posX"), player.getBlockY(), tag.getInt("posZ"));
            sendDiscoveryMessage(player, getStructureName(stack), pos);
            return InteractionResultHolder.success(stack);
        }

        UUID itemId = getOrCreateItemId(stack);
        if (activeSearches.containsKey(itemId)) {
            player.displayClientMessage(
                Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".searching")
                    .withStyle(ChatFormatting.YELLOW), true);
            return InteractionResultHolder.consume(stack);
        }

        TagKey<Structure> structureTag = getStructureTag(stack);
        if (structureTag == null) {
            return InteractionResultHolder.fail(stack);
        }

        player.displayClientMessage(
            Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".search_start", getStructureName(stack))
                .withStyle(ChatFormatting.YELLOW), true);

        // 异步搜索结构
        CompletableFuture<BlockPos> future = CompletableFuture.supplyAsync(() ->
            ((ServerLevel)level).findNearestMapStructure(
                structureTag, player.blockPosition(), SEARCH_RADIUS, false)
        );

        activeSearches.put(itemId, future);

        future.thenAccept(pos -> {
            level.getServer().execute(() -> {
                if (pos != null) {
                    bindPosition(stack, pos);
                    sendDiscoveryMessage(player, getStructureName(stack), pos);
                } else {
                    player.displayClientMessage(
                        Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".structure_not_found", getStructureName(stack))
                            .withStyle(ChatFormatting.RED), false);
                }
                activeSearches.remove(itemId);
            });
        }).exceptionally(ex -> {
            level.getServer().execute(() -> {
                player.displayClientMessage(
                    Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".search_error")
                        .withStyle(ChatFormatting.RED), false);
                activeSearches.remove(itemId);
            });
            return null;
        });

        return InteractionResultHolder.consume(stack);
    }

    private void bindPosition(ItemStack stack, BlockPos pos) {
        stack.getOrCreateTag().putInt("posX", pos.getX());
        stack.getOrCreateTag().putInt("posZ", pos.getZ());
        stack.getOrCreateTag().putBoolean("found", true);
    }

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
