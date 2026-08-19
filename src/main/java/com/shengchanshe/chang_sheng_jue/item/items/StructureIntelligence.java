package com.shengchanshe.chang_sheng_jue.item.items;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.tags.CSJTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class StructureIntelligence extends Item {
    // 使用DamageValue区分结构类型
    public static final int PIT_YARD_TYPE = 0;
    public static final int SANDSTONE_CASTLE_TYPE = 1;
    public static final int SI_HE_YUAN_TYPE = 2;
    public static final int SU_PAI_VILLAGE_TYPE = 3;
    public static final int HUI_PAI_VILLAGE_TYPE = 4;
    public static final int FORTRESSES_TYPE = 5;
    private static final int SEARCH_RADIUS = 100; // 搜索半径
    private static final long SEARCH_EXPIRY_TICKS = 60L * 20L;
    private static final int MAX_ACTIVE_SEARCHES = 128;
    private static final int MAX_ACTIVE_SEARCHES_PER_PLAYER = 2;
    private static final int MAX_SEARCHES_PER_TICK = 1;
    private static final int SEARCH_SUBMISSION_COOLDOWN_TICKS = 10;
    private static final int MAX_TRACKED_PLAYER_COOLDOWNS = 1024;

    public StructureIntelligence(Properties properties) {
        super(properties);
    }

    private static final Map<UUID, PendingSearch> activeSearches = new LinkedHashMap<>();
    private static final LinkedHashMap<UUID, Long> lastSearchTicks = new LinkedHashMap<>(16, 0.75F, true);

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

        MinecraftServer server = level.getServer();
        if (server == null) {
            return InteractionResultHolder.fail(stack);
        }
        UUID playerId = player.getUUID();
        long currentServerTick = server.getTickCount();
        Long lastSearchTick = lastSearchTicks.get(playerId);
        if (lastSearchTick != null
                && currentServerTick >= lastSearchTick
                && currentServerTick - lastSearchTick < SEARCH_SUBMISSION_COOLDOWN_TICKS) {
            player.displayClientMessage(
                    Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".searching")
                            .withStyle(ChatFormatting.YELLOW), true);
            return InteractionResultHolder.consume(stack);
        }
        if (activeSearches.size() >= MAX_ACTIVE_SEARCHES
                || countActiveSearches(playerId) >= MAX_ACTIVE_SEARCHES_PER_PLAYER) {
            player.displayClientMessage(
                    Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".search_error")
                            .withStyle(ChatFormatting.RED), true);
            return InteractionResultHolder.consume(stack);
        }

        player.displayClientMessage(
            Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".search_start", getStructureName(stack))
                .withStyle(ChatFormatting.YELLOW), true);

        activeSearches.put(itemId, new PendingSearch(
                playerId, level.dimension(), hand, itemId, stack.getDamageValue(), structureTag,
                level.getGameTime(), player.blockPosition()));
        rememberSearchSubmission(playerId, currentServerTick);

        return InteractionResultHolder.consume(stack);
    }

    public static void tickSearches(MinecraftServer server) {
        if (!server.isSameThread()) {
            throw new IllegalStateException("Structure searches must run on the server thread");
        }
        if (activeSearches.isEmpty()) {
            return;
        }
        int searchBudget = Math.min(MAX_SEARCHES_PER_TICK, activeSearches.size());
        Iterator<Map.Entry<UUID, PendingSearch>> iterator = activeSearches.entrySet().iterator();
        for (int processed = 0; processed < searchBudget && iterator.hasNext(); processed++) {
            PendingSearch pending = iterator.next().getValue();
            iterator.remove();
            processSearch(server, pending);
        }
    }

    public static void clearSearches() {
        activeSearches.clear();
        lastSearchTicks.clear();
    }

    private static void processSearch(MinecraftServer server, PendingSearch pending) {
        ServerLevel level = server.getLevel(pending.dimension());
        ServerPlayer player = server.getPlayerList().getPlayer(pending.playerId());
        if (level == null || player == null || !player.isAlive() || player.level() != level) {
            return;
        }
        ItemStack stack = player.getItemInHand(pending.hand());
        if (!matchesPendingItem(stack, pending)) {
            return;
        }
        long now = level.getGameTime();
        if (now < pending.submittedTick() || now - pending.submittedTick() > SEARCH_EXPIRY_TICKS) {
            player.displayClientMessage(
                    Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".search_error")
                            .withStyle(ChatFormatting.RED), false);
            return;
        }

        BlockPos pos = level.findNearestMapStructure(
                pending.structureTag(), pending.origin(), SEARCH_RADIUS, false);
        ItemStack currentStack = player.getItemInHand(pending.hand());
        if (!matchesPendingItem(currentStack, pending)) {
            return;
        }
        StructureIntelligence item = (StructureIntelligence) currentStack.getItem();
        if (pos != null) {
            item.bindPosition(currentStack, pos);
            item.sendDiscoveryMessage(player, item.getStructureName(currentStack), pos);
        } else {
            player.displayClientMessage(
                    Component.translatable("tooltip." + ChangShengJue.MOD_ID + ".structure_not_found",
                                    item.getStructureName(currentStack))
                            .withStyle(ChatFormatting.RED), false);
        }
    }

    private static int countActiveSearches(UUID playerId) {
        int count = 0;
        for (PendingSearch pending : activeSearches.values()) {
            if (pending.playerId().equals(playerId)) {
                count++;
            }
        }
        return count;
    }

    private static void rememberSearchSubmission(UUID playerId, long currentServerTick) {
        if (!lastSearchTicks.containsKey(playerId)
                && lastSearchTicks.size() >= MAX_TRACKED_PLAYER_COOLDOWNS) {
            Iterator<UUID> iterator = lastSearchTicks.keySet().iterator();
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        lastSearchTicks.put(playerId, currentServerTick);
    }

    private static boolean matchesPendingItem(ItemStack stack, PendingSearch pending) {
        return stack.getItem() instanceof StructureIntelligence
                && stack.getDamageValue() == pending.damageValue()
                && stack.getTag() != null
                && stack.getTag().hasUUID("itemId")
                && pending.itemId().equals(stack.getTag().getUUID("itemId"));
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

    private record PendingSearch(UUID playerId, ResourceKey<Level> dimension, InteractionHand hand,
                                 UUID itemId, int damageValue, TagKey<Structure> structureTag,
                                 long submittedTick, BlockPos origin) {
    }

}
