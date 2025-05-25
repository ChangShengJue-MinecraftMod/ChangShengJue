package com.shengchanshe.changshengjue.item.items;

import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Parcel extends Item {
    // 使用 Item 列表
    private static final List<Item> COTTON_ARMOR_PARCEL;
    private static final List<Item> MOUNTAIN_PATTERN_ARMOR_PARCEL;
    private static final List<Item> THE_GREAT_GENERAL_MINGGUANG_ARMOR_PARCEL;
    private static final Random RANDOM = new Random();

    public Parcel() {
        super(new Item.Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            ItemStack parcelStack = pPlayer.getItemInHand(pUsedHand);
            if (parcelStack.is(ChangShengJueItems.COTTON_ARMOR_PARCEL.get())) {
                // 处理棉甲包裹
                for (Item item : COTTON_ARMOR_PARCEL) {
                    // 每次创建一个新的 ItemStack
                    ItemStack itemStack = new ItemStack(item);
                    // 尝试将物品放入玩家的背包
                    boolean added = pPlayer.getInventory().add(itemStack);
                    // 如果物品无法全部添加到背包，则掉落剩余的物品
                    if (!added) {
                        Containers.dropItemStack(pLevel, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), itemStack);
                    }
                }
                // 消耗包裹物品
                parcelStack.shrink(1);
                return InteractionResultHolder.success(parcelStack);
            }else if (parcelStack.is(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR_PARCEL.get())) {
                for (Item item : MOUNTAIN_PATTERN_ARMOR_PARCEL) {
                    // 每次创建一个新的 ItemStack
                    ItemStack itemStack = new ItemStack(item);
                    // 尝试将物品放入玩家的背包
                    boolean added = pPlayer.getInventory().add(itemStack);
                    // 如果物品无法全部添加到背包，则掉落剩余的物品
                    if (!added) {
                        Containers.dropItemStack(pLevel, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), itemStack);
                    }
                }
                // 消耗包裹物品
                parcelStack.shrink(1);
                return InteractionResultHolder.success(parcelStack);
            }else if (parcelStack.is(ChangShengJueItems.THE_GREAT_GENERAL_MINGGUANG_ARMOR_PARCEL.get())) {
                for (Item item : THE_GREAT_GENERAL_MINGGUANG_ARMOR_PARCEL) {
                    // 每次创建一个新的 ItemStack
                    ItemStack itemStack = new ItemStack(item);
                    // 尝试将物品放入玩家的背包
                    boolean added = pPlayer.getInventory().add(itemStack);
                    // 如果物品无法全部添加到背包，则掉落剩余的物品
                    if (!added) {
                        Containers.dropItemStack(pLevel, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), itemStack);
                    }
                }
                // 消耗包裹物品
                parcelStack.shrink(1);
                return InteractionResultHolder.success(parcelStack);
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    static {
        COTTON_ARMOR_PARCEL = Arrays.asList(
                RANDOM.nextBoolean() ? ChangShengJueItems.COTTON_HELMET.get() : ChangShengJueItems.WHITE_COTTON_HELMET.get(),
                ChangShengJueItems.COTTON_CHESTPLATE.get(),
                ChangShengJueItems.COTTON_LEGGINGS.get(),
                ChangShengJueItems.COTTON_BOOTS.get());
        MOUNTAIN_PATTERN_ARMOR_PARCEL = Arrays.asList(
                ChangShengJueItems.MOUNTAIN_PATTERN_HELMET_GUN_HOOD.get(),
                ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR.get(),
                ChangShengJueItems.MOUNTAIN_PATTERN_DEERSKIN_TIBIAL_ARMOR.get(),
                ChangShengJueItems.MOUNTAIN_PATTERN_CLOUD_BLACK_BOOTS.get());
        THE_GREAT_GENERAL_MINGGUANG_ARMOR_PARCEL = Arrays.asList(
                ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_PHOENIX_WINGS_HELMET.get(),
                ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LIGHT_CHESTPLATE.get(),
                ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LAZULI_KNEE_PADS.get(),
                ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_ANIMAL_SKIN_BOOTS.get());
    }
}