package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.gao_marksmanship.GaoMarksmanshipCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.gao_marksmanship.GaoMarksmanshipCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceClientData;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagers;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.*;
import com.shengchanshe.changshengjue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AirItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
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

    //能力给予事件,给生物添加能力
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if (event.getObject() instanceof Player){//判断生物为玩家,只给玩家添加这些能力
            //独孤九剑
            if (!event.getObject().getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"dugu_nine_swords_properties"),new DuguNineSwordsCapabilityProvider());
            }
            //金乌刀法
            if (!event.getObject().getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"golden_black_knife_method_properties"),new GoldenBlackKnifeMethodCapabilityProvider());
            }
            //玄女剑法
            if (!event.getObject().getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"xuannu_swordsmanship_properties"),new XuannuSwordsmanshipCapabilityProvider());
            }
            //高家枪法
            if (!event.getObject().getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"gao_marksmanship_properties"),new GaoMarksmanshipCapabilityProvider());
            }
            //少林棍法
            if (!event.getObject().getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"shaolin_stick_method_properties"),new ShaolinStickMethodCapabilityProvider());
            }
            //踏雪无痕
            if (!event.getObject().getCapability(TreadTheSnowWithoutTraceCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"shaolin_stick_method_capability_properties"),new TreadTheSnowWithoutTraceCapabilityProvider());
            }
        }
    }
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (!player.level().isClientSide){
            //踏雪无痕
             player.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY_CAPABILITY).ifPresent(treadTheSnowWithoutTrace -> {
                 if (treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent() > 0) {
                     treadTheSnowWithoutTrace.setTreadTheSnowWithoutTraceUseCooldownPercent();
                     ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTracePacket(treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel(),
                             treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend(), treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent()), (ServerPlayer) player);
                 }
             });
        }
//            // 我们把玩家脚下的location作为是原点O
//            for (double i = 0; i < 180; i += 180 / 6) {
//                // 依然要做角度与弧度的转换
//                double radians = Math.toRadians(i);
//                // 计算出来的半径
//                double radius = Math.sin(radians);
//                double y = Math.cos(radians);
//                for (double j = 0; j < 360; j += 180 / 6) {
//                    // 依然需要做角度转弧度的操作
//                    double radiansCircle = Math.toRadians(j);
//                    double x = Math.cos(radiansCircle) * radius;
//                    double z = Math.sin(radiansCircle) * radius;
//                    player.level().addParticle(ChangShengJueParticles.COMPREHEND_PARTICLE.get(), player.getX() + x, player.getY() + y + 1, player.getZ() + z, x, y ,z);
//                }
//            }

//            for(int i = 0; i < 3; ++i) {
//                int j = player.level().random.nextInt(2) * 2 - 1;
//                int k = player.level().random.nextInt(2) * 2 - 1;
//                double d0 = player.getX() + 0.15D * (double)j;
//                double d1 = (float)player.getY() + player.level().random.nextFloat();
//                double d2 = player.getZ() + 0.15D * (double)k;
//                double d3 = player.level().random.nextFloat() * (float)j;
//                double d4 = ((double)player.level().random.nextFloat() - 0.5D) * 0.125D;
//                double d5 = player.level().random.nextFloat() * (float)k;
//                player.level().addParticle(ChangShengJueParticles.COMPREHEND_PARTICLE.get(), d0, d1, d2, d3, d4, d5);
//            }
    }

    //玩家克隆事件,用于玩家死亡重生时或者从末地回到主世界时克隆旧玩家的属性到新玩家
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        Player oldPlayer = event.getOriginal();
        oldPlayer.reviveCaps();
        //独孤九剑
        oldPlayer.getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(newStore-> newStore.copyDuguNineSwords(oldStore)));
        //金乌刀法
        oldPlayer.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(newStore-> newStore.copyGoldenBlackKnifeMethod(oldStore)));
        //玄女剑法
        oldPlayer.getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).ifPresent(newStore-> newStore.copyXuannuSwordsmanship(oldStore)));
        //高家枪法
        oldPlayer.getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).ifPresent(newStore-> newStore.copyGaoMarksmanship(oldStore)));
        //少林棍法
        oldPlayer.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(newStore-> newStore.copyShaolinStickMethod(oldStore)));
        //踏雪无痕
        oldPlayer.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(TreadTheSnowWithoutTraceCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY_CAPABILITY).ifPresent(newStore-> newStore.copyTreadTheSnowWithoutTrace(oldStore)));
        event.getOriginal().invalidateCaps();
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        //把能力注册到世界中
        event.register(DuguNineSwordsCapability.class);
        event.register(GoldenBlackKnifeMethodCapability.class);
        event.register(XuannuSwordsmanshipCapability.class);
        event.register(GaoMarksmanshipCapability.class);
        event.register(ShaolinStickMethodCapability.class);
        event.register(TreadTheSnowWithoutTraceCapability.class);
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        //玩家进入世界时同步能力数据
        if(!event.getLevel().isClientSide()) {
            if(event.getEntity() instanceof ServerPlayer player) {
                player.getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(duguNineSword -> {
                    ChangShengJueMessages.sendToPlayer(new DuguNineSwordsPacket(duguNineSword.getDuguNineSwordsLevel(),duguNineSword.isDuguNineSwordsComprehend()), player);
                });
                player.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(goldenBlackKnifeMethod -> {
                    ChangShengJueMessages.sendToPlayer(new GoldenBlackKnifeMethodPacket(goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel(),goldenBlackKnifeMethod.isGoldenBlackKnifeMethodComprehend()), player);
                });
                player.getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).ifPresent(xuannuSwordsmanship -> {
                    ChangShengJueMessages.sendToPlayer(new XuannuSwordsmanshipPacket(xuannuSwordsmanship.getXuannuSwordsmanshipLevel(),xuannuSwordsmanship.isXuannuSwordsmanshipComprehend()), player);
                });
                player.getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).ifPresent(gaoMarksmanship -> {
                    ChangShengJueMessages.sendToPlayer(new GaoMarksmanshipPacket(gaoMarksmanship.getGaoMarksmanshipLevel(),gaoMarksmanship.isGaoMarksmanshipComprehend()), player);
                });
                player.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
                    ChangShengJueMessages.sendToPlayer(new ShaolinStickMethodPacket(shaolinStickMethod.getShaolinStickMethodLevel(),shaolinStickMethod.isShaolinStickMethodComprehend()), player);
                });
                player.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY_CAPABILITY).ifPresent(treadTheSnowWithoutTrace -> {
                    ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTracePacket(
                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel(),
                            treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend(),
                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent()), player);
                });
            }
        }
    }

}
