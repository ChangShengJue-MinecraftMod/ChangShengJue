package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.capability.MartialArtsCapability;
import com.shengchanshe.changshengjue.capability.MartialArtsCapabilityProvider;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagers;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID)
public class CSJEvent {

    @SubscribeEvent
    public static void onVillagerInteract(PlayerInteractEvent.EntityInteractSpecific event) {
        if (event.getTarget() instanceof Villager villager) {
            CompoundTag villagerData = villager.getPersistentData();
            // 检查是否已经尝试过职业变更
            if (!villagerData.getBoolean("HasCheckedProfessionChange")) {
                VillagerProfession profession = villager.getVillagerData().getProfession();
                // 检查当前职业是否为ChangShengJue Hunter
                if (profession == ChangShengJueVillagers.CHANG_SHENG_JUE_POTTER.get()) {
                    Random random = new Random();
                    if (random.nextInt(100) == 0) { // 1%的概率
                        // 设置新职业为ChangShengJue Gatherer
                        villager.setVillagerData(villager.getVillagerData().setProfession(ChangShengJueVillagers.CHANG_SHENG_JUE_POTTER_1.get()));
                    }
                }
                // 标记已经进行过职业变更尝试
                villagerData.putBoolean("HasCheckedProfessionChange", true);
            }
        }
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == ChangShengJueVillagers.CHANG_SHENG_JUE_FARMER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4);
            ItemStack[] stack1 = new ItemStack[]{new ItemStack(ChangShengJueItems.CORN.get(), 20), new ItemStack(ChangShengJueItems.TOMATO.get(), 22), new ItemStack(ChangShengJueItems.PEANUT.get(), 22), new ItemStack(ChangShengJueItems.MI_FAN.get(), 4),};
            ItemStack[] stack2 = new ItemStack[]{new ItemStack(ChangShengJueItems.GRAPE.get(), 22), new ItemStack(ChangShengJueItems.ZHENG_CAI.get(), 4), new ItemStack(ChangShengJueItems.QING_TUAN.get(), 4),};
            ItemStack[] stack3 = new ItemStack[]{new ItemStack(ChangShengJueItems.GUI_HUA_TANG_OU.get(), 4), new ItemStack(ChangShengJueItems.ZHU_DU_JI.get(), 4),};
            ItemStack[] stack4 = new ItemStack[]{new ItemStack(Items.SUSPICIOUS_STEW, 1), new ItemStack(ChangShengJueItems.TOMATO_EGG.get(), 4),};
            ItemStack[] stack5 = new ItemStack[]{new ItemStack(ChangShengJueItems.MEAT_FOAM_BRINJAL.get(), 8), new ItemStack(ChangShengJueItems.BA_BAO_ZHOU.get(), 8),};
            // 存储第一个交易的索引
            final int[] firstIndex = new int[1];
            // 添加两个不重复的交易
            trades.get(1).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack1.length);
                ItemStack firstStack = stack1[firstIndex[0]];
                if (firstStack.is(ChangShengJueItems.MI_FAN.get())){
                    return new MerchantOffer(stack,firstStack ,16,2,0.05F);
                }else{
                    return new MerchantOffer(firstStack, stack,16,2,0.05F);
                }
            });
            trades.get(1).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack1.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack1[secondIndex];
                if (secondStack.is(ChangShengJueItems.MI_FAN.get())){
                    return new MerchantOffer(stack,secondStack ,16,2,0.05F);
                }else{
                    return new MerchantOffer(secondStack, stack,16,2,0.05F);
                }
            });

            trades.get(2).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack2.length);
                ItemStack firstStack = stack2[firstIndex[0]];
                if (firstStack.is(ChangShengJueItems.ZHENG_CAI.get())){
                    return new MerchantOffer(stack,firstStack ,12,5,0.05F);
                }else if (firstStack.is(ChangShengJueItems.QING_TUAN.get())){
                    return new MerchantOffer(stack,firstStack ,16,5,0.05F);
                }else{
                    return new MerchantOffer(firstStack, stack,12,5,0.05F);
                }
            });
            trades.get(2).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack2.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack2[secondIndex];
                if (secondStack.is(ChangShengJueItems.ZHENG_CAI.get())){
                    return new MerchantOffer(stack,secondStack ,12,5,0.05F);
                }else if (secondStack.is(ChangShengJueItems.QING_TUAN.get())){
                    return new MerchantOffer(stack,secondStack ,16,5,0.05F);
                }else{
                    return new MerchantOffer(secondStack, stack,12,5,0.05F);
                }
            });

            trades.get(3).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack3.length);
                ItemStack firstStack = stack3[firstIndex[0]];
                if (firstStack.is(ChangShengJueItems.GUI_HUA_TANG_OU.get())){
                    return new MerchantOffer(firstStack,stack ,12,20,0.05F);
                }else{
                    return new MerchantOffer(stack, firstStack,12,10,0.05F);
                }
            });
            trades.get(3).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack3.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack3[secondIndex];
                if (secondStack.is(ChangShengJueItems.GUI_HUA_TANG_OU.get())){
                    return new MerchantOffer(secondStack,stack ,12,20,0.05F);
                }else{
                    return new MerchantOffer(stack, secondStack,12,10,0.05F);
                }
            });

            trades.get(4).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack4.length);
                ItemStack firstStack = stack4[firstIndex[0]];
                return new MerchantOffer(stack, firstStack,12,15,0.05F);
            });
            trades.get(4).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack4.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack4[secondIndex];
                return new MerchantOffer(stack, secondStack,12,15,0.05F);
            });
            trades.get(5).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack5.length);
                ItemStack firstStack = stack5[firstIndex[0]];
                return new MerchantOffer(new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 8), firstStack,12,30,0.05F);
            });
            trades.get(5).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack5.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack5[secondIndex];
                return new MerchantOffer(new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 8), secondStack,12,30,0.05F);
            });

        }
        if(event.getType() == ChangShengJueVillagers.CHANG_SHENG_JUE_POTTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 8);
            ItemStack[] stack1 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLUE_STONE_BRICKS.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLUE_STONE_BRICKS_STAIRS.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLUE_STONE_BRICKS_SLAB.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLUE_STONE_VERTICAL_WALLS.get(), 32)};
            ItemStack[] stack2 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.BLUE_FLOOR_TILES_BLOCK.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLACK_FLOOR_TILES_BLOCK.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BITUMEN_FLOOR_TILES_BLOCK.get(), 32)};
            ItemStack[] stack3 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get(), 32),
                    new ItemStack(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_1.get(), 32),
                    new ItemStack(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_2.get(), 32),
                    new ItemStack(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_3.get(), 32)};
            ItemStack[] stack4 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_1.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_2.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_3.get(), 32)};
            ItemStack[] stack5 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.get(), 1),
                    new ItemStack(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get(), 1)};
            // 存储第一个交易的索引
            final int[] firstIndex = new int[1];
            // 添加两个不重复的交易
            trades.get(1).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack1.length);
                ItemStack firstStack = stack1[firstIndex[0]];
                return new MerchantOffer(stack, firstStack,32,2,0.05F);
            });
            trades.get(1).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack1.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack1[secondIndex];
                return new MerchantOffer(stack, secondStack,32,2,0.05F);
            });
            trades.get(2).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack2.length);
                ItemStack firstStack = stack2[firstIndex[0]];
                return new MerchantOffer(stack,firstStack ,32,5,0.05F);
            });
            trades.get(2).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack2.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack2[secondIndex];
                return new MerchantOffer(stack,secondStack ,32,5,0.05F);
            });
            trades.get(3).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack3.length);
                ItemStack firstStack = stack3[firstIndex[0]];
                return new MerchantOffer(stack, firstStack,32,10,0.05F);
            });
            trades.get(3).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack3.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack3[secondIndex];
                return new MerchantOffer(stack, secondStack,32,10,0.05F);
            });
            trades.get(4).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack4.length);
                ItemStack firstStack = stack4[firstIndex[0]];
                return new MerchantOffer(stack, firstStack,32,15,0.05F);
            });
            trades.get(4).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack4.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack4[secondIndex];
                return new MerchantOffer(stack, secondStack,32,15,0.05F);
            });
            trades.get(5).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack5.length);
                ItemStack firstStack = stack5[firstIndex[0]];
                return new MerchantOffer(new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4), firstStack,32,30,0.05F);
            });
            trades.get(5).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack5.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack5[secondIndex];
                return new MerchantOffer(new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4), secondStack,32,30,0.05F);
            });
        }
        if(event.getType() == ChangShengJueVillagers.CHANG_SHENG_JUE_POTTER_1.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 2);
                ItemStack[] stack1 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get(), 32),
                        new ItemStack(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_1.get(), 32),
                        new ItemStack(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_2.get(), 32),
                        new ItemStack(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_3.get(), 32)};
                ItemStack[] stack2 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get(), 32),
                        new ItemStack(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_1.get(), 32),
                        new ItemStack(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_2.get(), 32),
                        new ItemStack(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_3.get(), 32)};
                ItemStack[] stack3 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get(), 32),
                        new ItemStack(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_1.get(), 32),
                        new ItemStack(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_2.get(), 32),
                        new ItemStack(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_3.get(), 32)};
                ItemStack[] stack4 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.PAINTING_SCROLL.get(), 1),
                        new ItemStack(ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get(), 1),
                        new ItemStack(ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get(), 1),
                        new ItemStack(ChangShengJueBlocks.BIG_PAINTING_SCROLL.get(), 1),};
                ItemStack[] stack5 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.PAINTING_SCROLL.get(), 1),
                        new ItemStack(ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get(), 1),
                        new ItemStack(ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get(), 1),
                        new ItemStack(ChangShengJueBlocks.BIG_PAINTING_SCROLL.get(), 1),
                        new ItemStack(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get(), 1)};
                // 存储第一个交易的索引
                final int[] firstIndex = new int[1];
                // 添加两个不重复的交易
                trades.get(1).add((trader, rand) -> {
                    firstIndex[0] = rand.nextInt(stack1.length);
                    ItemStack firstStack = stack1[firstIndex[0]];
                    return new MerchantOffer(stack, firstStack,32,2,0.05F);
                });
                trades.get(1).add((trader, rand) -> {
                    int secondIndex;
                    do {
                        secondIndex = rand.nextInt(stack1.length);
                    } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                    ItemStack secondStack = stack1[secondIndex];
                    return new MerchantOffer(stack, secondStack,32,2,0.05F);
                });
                trades.get(2).add((trader, rand) -> {
                    firstIndex[0] = rand.nextInt(stack2.length);
                    ItemStack firstStack = stack2[firstIndex[0]];
                    return new MerchantOffer(stack,firstStack ,32,5,0.05F);
                });
                trades.get(2).add((trader, rand) -> {
                    int secondIndex;
                    do {
                        secondIndex = rand.nextInt(stack2.length);
                    } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                    ItemStack secondStack = stack2[secondIndex];
                    return new MerchantOffer(stack,secondStack ,32,5,0.05F);
                });
                trades.get(3).add((trader, rand) -> {
                    firstIndex[0] = rand.nextInt(stack3.length);
                    ItemStack firstStack = stack3[firstIndex[0]];
                    return new MerchantOffer(stack, firstStack,32,10,0.05F);
                });
                trades.get(3).add((trader, rand) -> {
                    int secondIndex;
                    do {
                        secondIndex = rand.nextInt(stack3.length);
                    } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                    ItemStack secondStack = stack3[secondIndex];
                    return new MerchantOffer(stack, secondStack,32,10,0.05F);
                });
                trades.get(4).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack4.length);
                ItemStack firstStack = stack4[firstIndex[0]];
                return new MerchantOffer(stack, firstStack,12,15,0.05F);
            });
                trades.get(4).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack4.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack4[secondIndex];
                return new MerchantOffer(stack, secondStack,12,15,0.05F);
            });
                trades.get(5).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack5.length);
                ItemStack firstStack = stack5[firstIndex[0]];
                return new MerchantOffer(new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 1), firstStack,12,30,0.05F);
            });
                trades.get(5).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack5.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack5[secondIndex];
                return new MerchantOffer(new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 1), secondStack,12,30,0.05F);
            });
        }
        if(event.getType() == ChangShengJueVillagers.CHANG_SHENG_JUE_HUNTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4);
            ItemStack[] stack1 = new ItemStack[]{new ItemStack(Items.CHICKEN, 14), new ItemStack(Items.RABBIT, 4), new ItemStack(Items.PORKCHOP, 7), new ItemStack(ChangShengJueItems.PEACOCK_EGGS.get(), 1)};
            ItemStack[] stack2 = new ItemStack[]{new ItemStack(Items.MUTTON, 7),new ItemStack(ChangShengJueItems.COOKED_VENISON.get(), 5), new ItemStack(ChangShengJueItems.DEER_BLOOD.get(), 1)};
            ItemStack[] stack3 = new ItemStack[]{new ItemStack(ChangShengJueItems.VENISON.get(), 7),new ItemStack(Items.BEEF, 10)};
            ItemStack[] stack4 = new ItemStack[]{new ItemStack(ChangShengJueItems.ANTLER.get(), 7)};
            ItemStack[] stack5 = new ItemStack[]{new ItemStack(ChangShengJueItems.TIGER_SKIN.get(), 5)};

            // 存储第一个交易的索引
            final int[] firstIndex = new int[1];
            // 添加两个不重复的交易
            trades.get(1).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack1.length);
                ItemStack firstStack = stack1[firstIndex[0]];
                if (firstStack.is(ChangShengJueItems.PEACOCK_EGGS.get())){
                    return new MerchantOffer(stack,firstStack ,12,1,0.05F);
                }else{
                    return new MerchantOffer(firstStack, stack,16,2,0.05F);
                }
            });
            trades.get(1).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack1.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack1[secondIndex];
                if (secondStack.is(ChangShengJueItems.PEACOCK_EGGS.get())){
                    return new MerchantOffer(stack,secondStack ,12,1,0.05F);
                }else{
                    return new MerchantOffer(secondStack, stack,16,2,0.05F);
                }
            });

            trades.get(2).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack2.length);
                ItemStack firstStack = stack2[firstIndex[0]];
                if (firstStack.is(Items.MUTTON)){
                    return new MerchantOffer(firstStack, stack,16,3,0.05F);
                }else{
                    return new MerchantOffer(stack,firstStack ,12,5,0.05F);
                }
            });
            trades.get(2).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack2.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack2[secondIndex];
                if (secondStack.is(Items.MUTTON)){
                    return new MerchantOffer(secondStack, stack,16,3,0.05F);
                }else{
                    return new MerchantOffer(stack,secondStack ,12,5,0.05F);
                }
            });

            trades.get(3).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack3.length);
                ItemStack firstStack = stack3[firstIndex[0]];
                return new MerchantOffer(firstStack, stack,16,20,0.05F);
            });
            trades.get(3).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack3.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack3[secondIndex];
                return new MerchantOffer(secondStack, stack,16,20,0.05F);
            });
            trades.get(4).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack4.length);
                ItemStack firstStack = stack4[firstIndex[0]];
                return new MerchantOffer(firstStack, new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 14),12,30,0.05F);
            });
            trades.get(5).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack5.length);
                ItemStack firstStack = stack5[firstIndex[0]];
                return new MerchantOffer(firstStack, new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 15),12,30,0.05F);
            });

        }
        if(event.getType() == ChangShengJueVillagers.CHANG_SHENG_JUE_CHIEF.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack[] stack1 = new ItemStack[]{new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 6),
                    new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 6)};
            ItemStack[] stack2 = new ItemStack[]{new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4),
                    new ItemStack(ChangShengJueItems.ZHU_TAI.get(), 2)};
            ItemStack[] stack3 = new ItemStack[]{new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4),
                    new ItemStack(Items.EMERALD, 1)};
            ItemStack[] stack4 = new ItemStack[]{new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4)};
            ItemStack[] stack5 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.PAINTING_SCROLL.get(), 1),
                    new ItemStack(ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get(), 1),
                    new ItemStack(ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get(), 1),
                    new ItemStack(ChangShengJueBlocks.BIG_PAINTING_SCROLL.get(), 1)};

            // 存储第一个交易的索引
            final int[] firstIndex = new int[1];
            // 添加两个不重复的交易
            trades.get(1).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack1.length);
                ItemStack firstStack = stack1[firstIndex[0]];
                if (firstStack.is(ChangShengJueItems.YI_GUAN_TONG_QIAN.get())){
                    return new MerchantOffer(new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 1),firstStack ,16,1,0.05F);
                }else{
                    return new MerchantOffer(new ItemStack(ChangShengJueItems.GOLD_BULLIONS.get(), 1), firstStack,16,1,0.05F);
                }
            });
            trades.get(1).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack1.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack1[secondIndex];
                if (secondStack.is(ChangShengJueItems.YI_GUAN_TONG_QIAN.get())){
                    return new MerchantOffer(new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 1),secondStack ,16,1,0.05F);
                }else{
                    return new MerchantOffer(new ItemStack(ChangShengJueItems.GOLD_BULLIONS.get(), 1), secondStack,16,1,0.05F);
                }
            });

            trades.get(2).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack2.length);
                ItemStack firstStack = stack2[firstIndex[0]];
                if (firstStack.is(ChangShengJueItems.YI_GUAN_TONG_QIAN.get())){
                    return new MerchantOffer(new ItemStack(Items.DIAMOND,1), firstStack,16,5,0.05F);
                }else{
                    return new MerchantOffer(stack2[firstIndex[0]],firstStack ,12,5,0.05F);
                }
            });
            trades.get(2).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack2.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack2[secondIndex];
                if (secondStack.is(ChangShengJueItems.YI_GUAN_TONG_QIAN.get())){
                    return new MerchantOffer(new ItemStack(Items.DIAMOND), secondStack,16,5,0.05F);
                }else{
                    return new MerchantOffer(stack2[firstIndex[0]],secondStack ,12,5,0.05F);
                }
            });

            trades.get(3).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack3.length);
                ItemStack firstStack = stack3[firstIndex[0]];
                if (firstStack.is(ChangShengJueItems.YI_GUAN_TONG_QIAN.get())){
                    return new MerchantOffer(new ItemStack(Items.COMPASS,1), firstStack,16,5,0.05F);
                }else{
                    return new MerchantOffer(stack2[firstIndex[0]],firstStack ,12,5,0.05F);
                }
            });
            trades.get(3).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack3.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack3[secondIndex];
                if (secondStack.is(ChangShengJueItems.YI_GUAN_TONG_QIAN.get())){
                    return new MerchantOffer(new ItemStack(Items.COMPASS,1), secondStack,16,20,0.05F);
                }else{
                    return new MerchantOffer(stack2[firstIndex[0]],secondStack ,12,10,0.05F);
                }
            });
            trades.get(4).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack4.length);
                ItemStack firstStack = stack4[firstIndex[0]];
                return new MerchantOffer(new ItemStack(Items.WRITABLE_BOOK, 1),firstStack,16,30,0.05F);
            });
            trades.get(5).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack5.length);
                ItemStack firstStack = stack5[firstIndex[0]];
                return new MerchantOffer(new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 1), firstStack,12,30,0.05F);
            });
            trades.get(5).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack5.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack5[secondIndex];
                return new MerchantOffer(new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 1), secondStack,12,30,0.05F);
            });

        }

        if(event.getType() == ChangShengJueVillagers.CHANG_SHENG_JUE_SEAMSTRESS.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack[] stack1 = new ItemStack[]{new ItemStack(ChangShengJueItems.NATURAL_SILK.get(), 6),
                    new ItemStack(ChangShengJueItems.COTTON.get(), 22)};
            ItemStack[] stack2 = new ItemStack[]{new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 10),
                    new ItemStack(ChangShengJueItems.SILK.get(), 4)};
            ItemStack[] stack3 = new ItemStack[]{new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4),
                    new ItemStack(Items.EMERALD, 1)};
            ItemStack[] stack4 = new ItemStack[]{new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4)};
            ItemStack[] stack5 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.PAINTING_SCROLL.get(), 1),
                    new ItemStack(ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get(), 1),
                    new ItemStack(ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get(), 1),
                    new ItemStack(ChangShengJueBlocks.BIG_PAINTING_SCROLL.get(), 1)};

            // 存储第一个交易的索引
            final int[] firstIndex = new int[1];
            // 添加两个不重复的交易
            trades.get(1).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack1.length);
                ItemStack firstStack = stack1[firstIndex[0]];
                return new MerchantOffer(firstStack,new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4),16,1,0.05F);
            });
            trades.get(1).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack1.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack1[secondIndex];
                return new MerchantOffer(secondStack,new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4),16,1,0.05F);
            });

            trades.get(2).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack2.length);
                ItemStack firstStack = stack2[firstIndex[0]];
                if (firstStack.is(ChangShengJueItems.YI_GUAN_TONG_QIAN.get())){
                    return new MerchantOffer(new ItemStack(ChangShengJueItems.DEERSKIN.get(),5), firstStack,16,5,0.05F);
                }else{
                    return new MerchantOffer(new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(),4),firstStack ,12,5,0.05F);
                }
            });
            trades.get(2).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack2.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack2[secondIndex];
                if (secondStack.is(ChangShengJueItems.YI_GUAN_TONG_QIAN.get())){
                    return new MerchantOffer(new ItemStack(ChangShengJueItems.DEERSKIN.get(),5), secondStack,16,5,0.05F);
                }else{
                    return new MerchantOffer(new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(),4),secondStack ,12,5,0.05F);
                }
            });

            trades.get(3).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack3.length);
                ItemStack firstStack = stack3[firstIndex[0]];
                if (firstStack.is(ChangShengJueItems.YI_GUAN_TONG_QIAN.get())){
                    return new MerchantOffer(new ItemStack(Items.COMPASS,1), firstStack,16,5,0.05F);
                }else{
                    return new MerchantOffer(stack2[firstIndex[0]],firstStack ,12,5,0.05F);
                }
            });
            trades.get(3).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack3.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack3[secondIndex];
                if (secondStack.is(ChangShengJueItems.YI_GUAN_TONG_QIAN.get())){
                    return new MerchantOffer(new ItemStack(Items.COMPASS,1), secondStack,16,20,0.05F);
                }else{
                    return new MerchantOffer(stack2[firstIndex[0]],secondStack ,12,10,0.05F);
                }
            });
            trades.get(4).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack4.length);
                ItemStack firstStack = stack4[firstIndex[0]];
                return new MerchantOffer(new ItemStack(Items.WRITABLE_BOOK, 1),firstStack,16,30,0.05F);
            });
            trades.get(5).add((trader, rand) -> {
                firstIndex[0] = rand.nextInt(stack5.length);
                ItemStack firstStack = stack5[firstIndex[0]];
                return new MerchantOffer(new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 1), firstStack,12,30,0.05F);
            });
            trades.get(5).add((trader, rand) -> {
                int secondIndex;
                do {
                    secondIndex = rand.nextInt(stack5.length);
                } while (secondIndex == firstIndex[0]);  // 确保两次选择不同
                ItemStack secondStack = stack5[secondIndex];
                return new MerchantOffer(new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 1), secondStack,12,30,0.05F);
            });

        }
    }

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if (event.getObject() instanceof Player){
            if (!event.getObject().getCapability(MartialArtsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"dugunineswordsproperties"),new MartialArtsCapabilityProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        Player oldPlayer = event.getOriginal();
        oldPlayer.reviveCaps();
        oldPlayer.getCapability(MartialArtsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(oldStore-> event.getEntity().getCapability(MartialArtsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(newStore->{
            newStore.copyDuguNineSwords(oldStore);
        }));
        event.getOriginal().invalidateCaps();
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        event.register(MartialArtsCapability.class);
    }
}
