package com.shengchanshe.chang_sheng_jue.event;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.ChangShengJueConfig;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.food.TypeBlock;
import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.cilent.hud.kungfu.KungFuClientData;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.entity.custom.croc.Croc;
import com.shengchanshe.chang_sheng_jue.entity.custom.tiger.Tiger;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.other.GangLeader;
import com.shengchanshe.chang_sheng_jue.entity.villagers.ChangShengJueVillagers;
import com.shengchanshe.chang_sheng_jue.event.armor.ArmorEvent;
import com.shengchanshe.chang_sheng_jue.event.kungfu.GoldenBellJarEvent;
import com.shengchanshe.chang_sheng_jue.event.kungfu.KungFuEvent;
import com.shengchanshe.chang_sheng_jue.event.kungfu.PaodingEvent;
import com.shengchanshe.chang_sheng_jue.event.kungfu.RelentlessThrowingKnivesEvent;
import com.shengchanshe.chang_sheng_jue.event.quest.PlayerQuestEvent;
import com.shengchanshe.chang_sheng_jue.event.quest.QuestEvent;
import com.shengchanshe.chang_sheng_jue.event.xiu_xian.SpiritEvents;
import com.shengchanshe.chang_sheng_jue.event.xiu_xian.XiuXianEvent;
import com.shengchanshe.chang_sheng_jue.init.CSJAdvanceInit;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.knife.Knife;
import com.shengchanshe.chang_sheng_jue.item.items.Parcel;
import com.shengchanshe.chang_sheng_jue.item.items.StructureIntelligence;
import com.shengchanshe.chang_sheng_jue.quest.QuestManager;
import com.shengchanshe.chang_sheng_jue.util.TradeHelper;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.TradeWithVillagerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vazkii.patchouli.api.PatchouliAPI;

import java.util.List;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID)
public class CSJEvent {

    public static boolean hasWheatNuggetsTributeWine = false;

    @SubscribeEvent
    public static void onVillagerInteract(PlayerInteractEvent.EntityInteractSpecific event) {
        KungFuEvent.onVillagerInteract(event);
    }
    @SubscribeEvent
    public static void onTrackingStart(PlayerEvent.StartTracking event) {
        PlayerQuestEvent.onTrackingStart(event);
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == ChangShengJueVillagers.CHANG_SHENG_JUE_FARMER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4);
            ItemStack[] stack1 = new ItemStack[]{new ItemStack(ChangShengJueItems.CORN.get(), 20), new ItemStack(ChangShengJueItems.TOMATO.get(), 22), new ItemStack(ChangShengJueItems.PEANUT.get(), 22), new ItemStack(ChangShengJueItems.MI_FAN.get(), 4),};
            ItemStack[] stack2 = new ItemStack[]{new ItemStack(ChangShengJueItems.GRAPE.get(), 22), new ItemStack(ChangShengJueItems.ZHENG_CAI.get(), 4), new ItemStack(ChangShengJueItems.QING_TUAN.get(), 4) ,};
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
                }else if(firstStack.is(ChangShengJueItems.QING_TUAN.get())){
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
                }else if(secondStack.is(ChangShengJueItems.QING_TUAN.get())){
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
                    new ItemStack(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_3.get(), 32),
                    new ItemStack(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_4.get(), 32)};
            ItemStack[] stack4 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_1.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_2.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_3.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_4.get(), 32)};
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
            // 初始化交易物品
            ItemStack intelligence = new ItemStack(ChangShengJueItems.STRUCTURE_INTELLIGENCE.get());
            intelligence.setDamageValue(StructureIntelligence.FORTRESSES_TYPE);

            // 定义各等级的交易物品
            ItemStack[] stack1 = {
                    new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 6),
                    new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 6)
            };

            ItemStack[] stack3 = {
                    new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4),
                    new ItemStack(Items.EMERALD, 1)
            };

            ItemStack[] stack4 = {
                    new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4)
            };

            ItemStack[] stack5 = {
                    new ItemStack(ChangShengJueBlocks.PAINTING_SCROLL.get(), 1),
                    new ItemStack(ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get(), 1),
                    new ItemStack(ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get(), 1),
                    new ItemStack(ChangShengJueBlocks.BIG_PAINTING_SCROLL.get(), 1)
            };

            // 获取交易列表
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // 等级1交易
            TradeHelper.addTradesForLevel(trades, 1, stack1,
                    item -> item.is(ChangShengJueItems.YI_GUAN_TONG_QIAN.get()) ?
                            new MerchantOffer(new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 1),
                                    item, 16, 1, 0.05F) :
                            new MerchantOffer(new ItemStack(ChangShengJueItems.GOLD_BULLIONS.get(), 1),
                                    item, 16, 1, 0.05F)
            );
            // 等级2的固定交易组合
            trades.get(2).add((trader, rand) ->
                    new MerchantOffer(
                            new ItemStack(Items.DIAMOND, 1),
                            new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4),
                            16, 5, 0.05F
                    )
            );
            trades.get(2).add((trader, rand) ->
                    new MerchantOffer(
                            new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4),
                            new ItemStack(ChangShengJueItems.ZHU_TAI.get(), 2),
                            12, 5, 0.05F
                    )
            );
            trades.get(2).add((trader, rand) ->
                    new MerchantOffer(
                            new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 2),
                            intelligence.copy(),
                            8, 5, 0.05F
                    )
            );
            // 等级3交易
            TradeHelper.addTradesForLevel(trades, 3, stack3,
                    item -> item.is(ChangShengJueItems.YI_GUAN_TONG_QIAN.get()) ?
                            new MerchantOffer(new ItemStack(Items.COMPASS,1), item, 16, 20, 0.05F) :
                            new MerchantOffer(new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(),4), item, 12, 10, 0.05F)
            );
            // 等级4交易
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.WRITABLE_BOOK, 1),
                    stack4[0],
                    12, 30, 0.05F
            ));

            // 等级5交易
            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 1),
                    stack5[0],
                    12, 30, 0.05F
            ));

            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 1),
                    stack5[1],
                    12, 30, 0.05F
            ));

            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 1),
                    stack5[2],
                    12, 30, 0.05F
            ));

            trades.get(5).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 1),
                    stack5[3],
                    12, 30, 0.05F
            ));
        }

        if(event.getType() == ChangShengJueVillagers.CHANG_SHENG_JUE_SEAMSTRESS.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // 定义各等级的交易物品
            ItemStack[] stack1 = new ItemStack[]{
                    new ItemStack(ChangShengJueItems.NATURAL_SILK.get(), 6),
                    new ItemStack(ChangShengJueItems.COTTON.get(), 22),
                    new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4),};

            ItemStack[] stack2 = new ItemStack[]{
                    new ItemStack(Items.LEATHER, 5),
                    new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 10),
                    new ItemStack(ChangShengJueItems.SILK.get(), 4)};

            ItemStack[] stack3 = new ItemStack[]{
                    new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 28)};

            ItemStack[] stack4 = new ItemStack[]{
                    new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 6)};

            ItemStack[] stack5 = new ItemStack[]{
                    new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 8)};

            trades.get(1).add((trader, rand) ->
                    new MerchantOffer(
                            stack1[0], stack1[2],
                            16, 3, 0.05F)
            );
            trades.get(1).add((trader, rand) ->
                    new MerchantOffer(
                            stack1[1], stack1[2],
                            16, 3, 0.05F)
            );

            trades.get(2).add((trader, rand) ->
                    new MerchantOffer(
                            stack2[0], stack2[1],
                            16, 3, 0.05F)
            );
            trades.get(2).add((trader, rand) ->
                    new MerchantOffer(
                            stack2[2], new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4),
                            12, 5, 0.05F)
            );
            trades.get(3).add((trader, rand) ->
                    new MerchantOffer(
                            stack3[0], Parcel.createMaleTaoistParcel(),
                            12, 20, 0.05F)
            );
            trades.get(3).add((trader, rand) ->
                    new MerchantOffer(
                            stack3[0], Parcel.createFemaleTaoistParcel(),
                            12, 20, 0.05F)
            );
            trades.get(4).add((trader, rand) ->
                    new MerchantOffer(
                            stack4[0], Parcel.createMaleWeddingDressParcel(),
                            12, 30, 0.05F)
            );
            trades.get(4).add((trader, rand) ->
                    new MerchantOffer(
                            stack4[0], Parcel.createFemaleWeddingDressParcel(),
                            12, 30, 0.05F)
            );

            trades.get(5).add((trader, rand) -> {
                ItemStack parcel = Parcel.createCottonParcel();
                parcel.getOrCreateTag().putBoolean("ForceGolden", true); // 添加标记
                return new MerchantOffer(
                        stack5[0], parcel,
                        12, 30, 0.05F);
            });
        }
    }

    //村民交易事件
    @SubscribeEvent
    public static void onTradeEvent(TradeWithVillagerEvent event) {
        KungFuEvent.onTradeEvent(event);
    }

    @SubscribeEvent
    public static void blockBlockBreakEvent(BlockEvent.BreakEvent event){
    }

    @SubscribeEvent
    public static void onInteract(PlayerInteractEvent event) {
//        WuGangCutGuiEvent.onInteract(event);
    }
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        hasWheatNuggetsTributeWine = player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get());
        KungFuEvent.onPlayerTick(event);
        // 任务
        PlayerQuestEvent.onPlayerTick(event);
        PlayerQuestEvent.onEntityGenerate(event);
        PlayerQuestEvent.onZombieGenerate(event);

        //修仙
        XiuXianEvent.onPlayerTick(event);
        SpiritEvents.onPlayerTick(event);
    }
    @SubscribeEvent
    public static void onAttachChunkCapabilities(AttachCapabilitiesEvent<LevelChunk> event) {
    }

    @SubscribeEvent
    public static void onItemPickup(EntityItemPickupEvent event) {
        RelentlessThrowingKnivesEvent.onItemPickup(event);
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        QuestEvent.onServerTick(event);
        SpiritEvents.onServerTick(event);
    }

    //生物攻击事件
    @SubscribeEvent
    public static void onEntityHurt(LivingAttackEvent event){
//        KungFuEvent.onEntityHurt(event);
    }

    @SubscribeEvent
    public static void onEntityAttack(LivingEvent.LivingTickEvent event){

    }

    //生物受伤事件
    @SubscribeEvent
    public static void onEntityHurt(LivingDamageEvent event){
        KungFuEvent.onEntityHurt(event);
        Knife.onKnifeAttack(event);

        ArmorEvent.onArmorDamage(event);
        PlayerQuestEvent.onEntityHurt(event);
    }

    //生物死亡事件
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event){
        //如果伤害来源为老虎
        if (event.getSource().getEntity() instanceof Tiger tiger && event.getEntity() instanceof Animal) {
            if (tiger.getFedTime() == 0 && !tiger.isTame())
                tiger.setFedTime(3.3 * 60 * 20);
        }
        if (event.getSource().getEntity() instanceof Croc croc && event.getEntity() instanceof Animal) {
            if (croc.getFedTime() == 0 && !croc.isTame())
                croc.setFedTime(3.3 * 60 * 20);
        }
        PaodingEvent.onEntityDeath(event);
        QuestEvent.onEntityDeath(event);
        PlayerQuestEvent.onPlayerDeath(event);
//        Parcel.onEntityDeath(event);
        //如果死亡的是帮派首领
        if (event.getSource().getEntity() instanceof Player player && event.getEntity() instanceof GangLeader){
            if (player instanceof ServerPlayer serverPlayer) {
                CSJAdvanceInit.BEAT_LEADER.trigger(serverPlayer);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        if (event.getSource().getEntity() instanceof Tiger tiger && event.getEntity() instanceof Animal){
            if (tiger.getFedTime() == 0 && !tiger.isTame())
                event.getDrops().clear();
            //所有会掉落生肉的动物依次if，然后改掉落物，或者干脆直接掉落物改为骨头（吃得只剩骨头了)
        }
        if (event.getSource().getEntity() instanceof Croc croc && event.getEntity() instanceof Animal) {
            if (croc.getFedTime() == 0 && !croc.isTame())
                event.getDrops().clear();
        }

    }

    //实体转换事件
    @SubscribeEvent
    public static void onLivingConversion(LivingConversionEvent.Post event) {
        QuestEvent.onCureComplete(event);
    }

    //生物交互事件
    @SubscribeEvent
    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract event){
        QuestEvent.onGoldenAppleUse(event);
        PlayerQuestEvent.onVillagerInteract(event);
        KungFuEvent.onPlayerEntityInteract(event);
    }

    //玩家右键空气事件
    @SubscribeEvent
    public static void onPlayerRightClick(PlayerInteractEvent.RightClickEmpty event){
    }

    @SubscribeEvent
    public static void onPlayerRightClickItem(PlayerInteractEvent.RightClickItem event) {
    }

    //玩家右键方块事件
    @SubscribeEvent
    public static void onPlayerEntityInteract(PlayerInteractEvent.RightClickBlock event){
        if (event.getLevel().getBlockState(event.getPos()).getBlock() instanceof TypeBlock){
            Player player = event.getEntity();

        }
    }

    //玩家重生事件
    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        GoldenBellJarEvent.onPlayerRespawn(event);
    }
    //能力给予事件,给生物添加能力
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        ChangShengJueCapabiliy.onAttachCapabilitiesPlayer(event);
    }

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        ChangShengJueConfig.onRegisterCommands(event);
    }

    //玩家克隆事件,用于玩家死亡重生时或者从末地回到主世界时克隆旧玩家的属性到新玩家
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        ChangShengJueCapabiliy.onPlayerCloned(event);
//        Player oldPlayer = event.getOriginal();
//        oldPlayer.reviveCaps();
//        //独孤九剑
//        oldPlayer.getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(newStore-> newStore.copyDuguNineSwords(oldStore)));
//        //金乌刀法
//        oldPlayer.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(newStore-> newStore.copyGoldenBlackKnifeMethod(oldStore)));
//        //玄女剑法
//        oldPlayer.getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).ifPresent(newStore-> newStore.copyXuannuSwordsmanship(oldStore)));
//        //高家枪法
//        oldPlayer.getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).ifPresent(newStore-> newStore.copyGaoMarksmanship(oldStore)));
//        //少林棍法
//        oldPlayer.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(newStore-> newStore.copyShaolinStickMethod(oldStore)));
//        //踏雪无痕
//        oldPlayer.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).ifPresent(newStore-> newStore.copyTreadTheSnowWithoutTrace(oldStore)));
//        //吴刚伐桂
//        oldPlayer.getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).ifPresent(newStore-> newStore.copyWuGangCutGui(oldStore)));
//        //愚公移山
//        oldPlayer.getCapability(YugongMovesMountainsCapabilityProvider.YUGONG_MOVES_MOUNTAINS_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(YugongMovesMountainsCapabilityProvider.YUGONG_MOVES_MOUNTAINS_CAPABILITY).ifPresent(newStore-> newStore.copyYugongMovesMountains(oldStore)));
//        //庖丁解牛
//        oldPlayer.getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).ifPresent(newStore-> newStore.copyPaoding(oldStore)));
//        //葵花点穴手
//        oldPlayer.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(newStore-> newStore.copySunflowerPointCaveman(oldStore)));
//        //金钟罩
//        oldPlayer.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(newStore-> newStore.copyGoldenBellJar(oldStore)));
//        //张门心学
//        oldPlayer.getCapability(ZhangMenXinxueCapabilityProvider.ZHANG_MEN_XIN_XUE_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(ZhangMenXinxueCapabilityProvider.ZHANG_MEN_XIN_XUE_CAPABILITY).ifPresent(newStore-> newStore.copyZhangMenXinxue(oldStore)));
//        //不死神功
//        oldPlayer.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(newStore-> newStore.copyImmortalMiracle(oldStore)));
//        //隔山打牛
//        oldPlayer.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(newStore-> newStore.copyGeShanDaNiu(oldStore)));
//        //麦块百科
//        oldPlayer.getCapability(WheatNuggetEncyclopediaCapabilityProvider.WHEAT_NUGGET_ENCYCLOPEDIA_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(WheatNuggetEncyclopediaCapabilityProvider.WHEAT_NUGGET_ENCYCLOPEDIA_CAPABILITY).ifPresent(newStore-> newStore.copyWheatNuggetEncyclopedia(oldStore)));
//        //龟息功
//        oldPlayer.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(newStore-> newStore.copyTurtleBreathWork(oldStore)));
//        //无情飞刀
//        oldPlayer.getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(newStore-> newStore.copyRelentlessThrowingKnives(oldStore)));
//        //易筋经
//        oldPlayer.getCapability(TheClassicsOfTendonChangingCapabilityProvider.THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(TheClassicsOfTendonChangingCapabilityProvider.THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY).ifPresent(newStore-> newStore.copyTheClassicsOfTendonChanging(oldStore)));
//        //乾坤大挪移
//        oldPlayer.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(newStore-> newStore.copyQianKunDaNuoYi(oldStore)));
//        //大力神功
//        oldPlayer.getCapability(HerculesCapabilityProvider.HERCULES_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(HerculesCapabilityProvider.HERCULES_CAPABILITY).ifPresent(newStore-> newStore.copyHercules(oldStore)));
//        //任务
//        oldPlayer.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(oldStore->
//                event.getEntity().getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(newStore-> newStore.copyFrom(oldStore)));
//        //修仙
//        XiuXianEvent.onPlayerCloned(event);
////        QuestsEvent.onPlayerCloned(event);
//        event.getOriginal().invalidateCaps();
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        //把能力注册到世界中
        ChangShengJueCapabiliy.registerCapabilities(event);
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        //玩家进入世界时同步能力数据
        ChangShengJueCapabiliy.onPlayerJoinWorld(event);
//        if(!event.getLevel().isClientSide()) {
//            if(event.getEntity() instanceof ServerPlayer player) {
//                QuestManager.getInstance().syncQuestsToPlayer(player); // 全量同步
//                XiuXianEvent.onPlayerJoinWorld(event);
//                player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY)
//                        .ifPresent(cap -> cap.syncToClient(player));
//                player.getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(duguNineSword -> {
//                    ChangShengJueMessages.sendToPlayer(new DuguNineSwordsPacket(duguNineSword.getDuguNineSwordsLevel(),
//                            duguNineSword.isDuguNineSwordsComprehend(),
//                            duguNineSword.getDuguNineSwordsToppedTick(),
//                            duguNineSword.getDuguNineSwordsDachengTick(),
//                            duguNineSword.isDuguNineSwordsParticle()), player);
//                });
//                player.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(goldenBlackKnifeMethod -> {
//                    ChangShengJueMessages.sendToPlayer(new GoldenBlackKnifeMethodPacket(goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel(),
//                            goldenBlackKnifeMethod.isGoldenBlackKnifeMethodComprehend(),
//                            goldenBlackKnifeMethod.getGoldenBlackKnifeMethodToppedTick(),
//                            goldenBlackKnifeMethod.getGoldenBlackKnifeMethodDachengTick(),
//                            goldenBlackKnifeMethod.isGoldenBlackKnifeMethodParticle()), player);
//                });
//                player.getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).ifPresent(xuannuSwordsmanship -> {
//                    ChangShengJueMessages.sendToPlayer(new XuannuSwordsmanshipPacket(xuannuSwordsmanship.getXuannuSwordsmanshipLevel(),xuannuSwordsmanship.isXuannuSwordsmanshipComprehend(),
//                            xuannuSwordsmanship.getXuannuSwordsmanshipToppedTick(),
//                            xuannuSwordsmanship.getXuannuSwordsmanshipDachengTick(),
//                            xuannuSwordsmanship.isXuannuSwordsmanshipParticle()), player);
//                });
//                player.getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).ifPresent(gaoMarksmanship -> {
//                    ChangShengJueMessages.sendToPlayer(new GaoMarksmanshipPacket(gaoMarksmanship.getGaoMarksmanshipLevel(),
//                            gaoMarksmanship.isGaoMarksmanshipComprehend(),
//                            gaoMarksmanship.getGaoMarksmanshipToppedTick(),
//                            gaoMarksmanship.getGaoMarksmanshipDachengTick(),
//                            gaoMarksmanship.isGaoMarksmanshipParticle()), player);
//                });
//                player.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
//                    ChangShengJueMessages.sendToPlayer(new ShaolinStickMethodPacket(shaolinStickMethod.getShaolinStickMethodLevel(),
//                            shaolinStickMethod.isShaolinStickMethodComprehend(),
//                            shaolinStickMethod.getShaolinStickMethodToppedTick(),
//                            shaolinStickMethod.getShaolinStickMethodDachengTick(),
//                            shaolinStickMethod.isShaolinStickMethodParticle()), player);
//                });
//                player.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).ifPresent(treadTheSnowWithoutTrace -> {
//                    ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTracePacket(
//                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel(),
//                            treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend(),
//                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent(),
//                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceToppedTick(),
//                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceDachengTick(),
//                            treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceParticle()), player);
//                });
//                player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
//                    ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
//                            sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
//                            sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
//                            sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
//                            sunflowerPointCaveman.isSunflowerPointCavemanOff(),
//                            sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
//                            sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
//                            sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
//                            sunflowerPointCaveman.isSkillActive()), player);
//                });
//                player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
//                    ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
//                            goldenBellJar.getGoldenBellJarLevel(),
//                            goldenBellJar.isGoldenBellJarComprehend(),
//                            goldenBellJar.getGoldenBellJarUseCooldownPercent(),
//                            goldenBellJar.isGoldenBellJarOff(),
//                            goldenBellJar.getGoldenBellJarToppedTick(),
//                            goldenBellJar.getGoldenBellJarDachengTick(),
//                            goldenBellJar.isGoldenBellJarParticle(),
//                            goldenBellJar.isSkillActive()), player);
//                });
//                player.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
//                    ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
//                            immortalMiracle.getImmortalMiracleLevel(),
//                            immortalMiracle.isImmortalMiracleComprehend(),
//                            immortalMiracle.getImmortalMiracleUseCooldownPercent(),
//                            immortalMiracle.isImmortalMiracleOff(),
//                            immortalMiracle.getImmortalMiracleToppedTick(),
//                            immortalMiracle.getImmortalMiracleDachengTick(),
//                            immortalMiracle.isImmortalMiracleParticle(),
//                            immortalMiracle.getImmortalMiracleUseCooldownPercentMax(),
//                            immortalMiracle.isSkillActive()), player);
//                });
//                player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
//                    ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
//                            geShanDaNiu.getGeShanDaNiuLevel(),
//                            geShanDaNiu.isGeShanDaNiuComprehend(),
//                            geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
//                            geShanDaNiu.getGeShanDaNiuToppedTick(),
//                            geShanDaNiu.getGeShanDaNiuDachengTick(),
//                            geShanDaNiu.isGeShanDaNiuParticle(),
//                            geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax(),
//                            geShanDaNiu.isSkillActive()), player);
//                });
//                player.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
//                    ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
//                            turtleBreathWork.getTurtleBreathWorkLevel(),
//                            turtleBreathWork.isTurtleBreathWorkComprehend(),
//                            turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
//                            turtleBreathWork.isTurtleBreathWorkOff(),
//                            turtleBreathWork.getTurtleBreathWorkToppedTick(),
//                            turtleBreathWork.getTurtleBreathWorkDachengTick(),
//                            turtleBreathWork.isTurtleBreathWorkParticle(),
//                            turtleBreathWork.isSkillActive()), player);
//                });
//                player.getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(relentlessThrowingKnives -> {
//                    ChangShengJueMessages.sendToPlayer(new RelentlessThrowingKnivesPacket(
//                            relentlessThrowingKnives.getRelentlessThrowingKnivesLevel(),
//                            relentlessThrowingKnives.isRelentlessThrowingKnivesComprehend(),
//                            relentlessThrowingKnives.getRelentlessThrowingKnivesUseCooldownPercent(),
//                            relentlessThrowingKnives.getRelentlessThrowingKnivesToppedTick(),
//                            relentlessThrowingKnives.getRelentlessThrowingKnivesDachengTick(),
//                            relentlessThrowingKnives.isRelentlessThrowingKnivesParticle()), player);
//                });
//                player.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi -> {
//                    ChangShengJueMessages.sendToPlayer(new QianKunDaNuoYiPacket(
//                            qianKunDaNuoYi.getQianKunDaNuoYiLevel(),
//                            qianKunDaNuoYi.isQianKunDaNuoYiComprehend(),
//                            qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownPercent(),
//                            qianKunDaNuoYi.isQianKunDaNuoYiOff(),
//                            qianKunDaNuoYi.getQianKunDaNuoYiToppedTick(),
//                            qianKunDaNuoYi.getQianKunDaNuoYiDachengTick(),
//                            qianKunDaNuoYi.isQianKunDaNuoYiParticle(),
//                            qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownMax(),
//                            qianKunDaNuoYi.isSkillActive(),
//                            qianKunDaNuoYi.getRecordTime(),
//                            qianKunDaNuoYi.getRecordDamage(),
//                            qianKunDaNuoYi.getRecordDamageSource()), (ServerPlayer) player);
//                });
//                player.getCapability(HerculesCapabilityProvider.HERCULES_CAPABILITY).ifPresent(hercules -> {
//                    ChangShengJueMessages.sendToPlayer(new HerculesPacket(
//                            hercules.getHerculesLevel(),
//                            hercules.isHerculesComprehend(),
//                            hercules.getHerculesToppedTick(),
//                            hercules.getHerculesDachengTick(),
//                            hercules.isHerculesParticle(),
//                            hercules.isSkillActive()), player);
//                });
//            }
//        }
    }

    // 在玩家退出世界时调用
    @SubscribeEvent
    public void onWorldUnload(LevelEvent.Unload event) {
        QuestEvent.onWorldUnload(event);
        KungFuClientData.get().clear();
    }

    @SubscribeEvent
    public static void onServerStopping(ServerStoppingEvent event) {
//        QuestManager.getInstance().saveData();
    }

    @SubscribeEvent
    public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
//        QuestManager.getInstance().saveData();
    }

    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
//        if (event.getLevel() instanceof ServerLevel) {
            // 世界加载时初始化数据
//            QuestManager.getInstance().onWorldLoad();
//        }
    }

    @SubscribeEvent
    public static void onChunkUnload(ChunkEvent.Unload event) {
    }

    @SubscribeEvent
    public static void onPlayerFirstJoin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();

        // 检查是否为服务器端玩家
        if (player instanceof ServerPlayer serverPlayer) {
            QuestManager.getInstance().syncQuestsToPlayer(serverPlayer); // 全量同步

            // 检查Patchouli是否加载
            if (!net.minecraftforge.fml.ModList.get().isLoaded("patchouli")) {
                return;
            }

            // 判断是否为首次加入 - 通过检查玩家是否有统计数据
            boolean isFirstJoin;
            //如果玩家刚进入游戏，则修改为true
            isFirstJoin = !(serverPlayer.getStats().getValue(Stats.CUSTOM.get(Stats.LEAVE_GAME)) > 0);

            // 如果是首次加入才执行书籍检查和赠送
            if (isFirstJoin) {
                ItemStack book = PatchouliAPI.get().getBookStack(new ResourceLocation("chang_sheng_jue", "wufanglu"));
                boolean hasBook = false;

                // 遍历玩家背包检查是否已有书籍
                for (ItemStack itemStack : player.getInventory().items) {
                    if (itemStack.getItem() == book.getItem()) {
                        hasBook = true;
                        break; // 发现书籍后立即终止循环
                    }
                }

                // 未找到书籍时执行赠送
                if (!hasBook) {
                    player.getInventory().add(book);
                }
            }
        }
    }


//    private static final double PLAYER_SEARCH_RANGE = 10.0; // 玩家搜索范围
//    @SubscribeEvent
//    public static void onWorldTick(TickEvent.LevelTickEvent event) {
//        // 只在服务器端执行，避免客户端和服务器端重复执行
////        if (event.side.isClient() || event.phase != TickEvent.Phase.END) {
////            return;
////        }
//
//        Level world = event.level;
//        // 获取在线玩家
//        ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers().forEach(player -> {
//            if (player.level() != world) return; // 确保玩家在当前世界
//            // 搜索玩家附近的村民
//            List<Villager> villagers = world.getEntitiesOfClass(
//                    Villager.class,
//                    player.getBoundingBox().inflate(PLAYER_SEARCH_RANGE),
//                    Entity::isAlive
//            );
//
//            for (Villager villager : villagers) {
//                // 检查村民附近的门
//                BlockPos.betweenClosedStream(
//                        villager.blockPosition().offset(0, 0, 0),
//                        villager.blockPosition().offset(1, 1, 1)
//                ).forEach(pos -> {
//                    BlockState state = world.getBlockState(pos);
//                    if (state.getBlock() instanceof DoorsBlock doorBlock && !state.getValue(DoorsBlock.OPEN)) {
//                        // 打开门
//                        doorBlock.setOpen(null, world, state, pos, true);
//                    }
//                });
//                BlockPos.betweenClosedStream(
//                        villager.blockPosition().offset(1, 1, 1),
//                        villager.blockPosition().offset(2, 2, 2)
//                ).forEach(pos -> {
//                    BlockState state = world.getBlockState(pos);
//                    if (state.getBlock() instanceof DoorsBlock doorBlock && state.getValue(DoorsBlock.OPEN)) {
//                        // 打开门
//                        doorBlock.setClose(null, world, state, pos, false);
//                    }
//                });
//            }
//        });
//    }
}
