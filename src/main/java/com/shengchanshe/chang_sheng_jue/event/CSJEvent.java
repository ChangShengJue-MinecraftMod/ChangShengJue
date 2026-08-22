package com.shengchanshe.chang_sheng_jue.event;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.ChangShengJueConfig;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.capability.kungfu.FoodDataOwnerTracker;
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
import com.shengchanshe.chang_sheng_jue.init.CSJAdvanceInit;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.knife.Knife;
import com.shengchanshe.chang_sheng_jue.item.items.Parcel;
import com.shengchanshe.chang_sheng_jue.item.items.StructureIntelligence;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu.MentalKungFuNeighborhoodSnapshot;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu.QingPingJi;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceIntentGuard;
import com.shengchanshe.chang_sheng_jue.util.TradeHelper;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import vazkii.patchouli.api.PatchouliAPI;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID)
public class CSJEvent {

    private static final UUID PENG_FAN_UUID = UUID.fromString("33c5bf5e-20e5-4bda-a7ec-efdb7cd048f0");
    @Deprecated
    public static boolean hasWheatNuggetsTributeWine = false;
    private static final String MONEY_SLAVE_END_TICK_KEY = "MoneySlaveEndTick";
    private static final String MONEY_SLAVE_KILLER_KEY = "MoneySlaveKiller";
    private static final String MONEY_SLAVE_NEXT_TICK_KEY = "MoneySlaveNextTick";
    private static final int MONEY_SLAVE_DURATION_TICKS = 15 * 60 * 20;
    private static final int MONEY_SLAVE_STEAL_INTERVAL_TICKS = 30 * 20;

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
            ItemStack[] stack3 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.GRE_CYLINDER_TILE.get(), 32),
                    new ItemStack(ChangShengJueBlocks.GRE_EAVES_TILE.get(), 32),
                    new ItemStack(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE.get(), 32),
                    new ItemStack(ChangShengJueBlocks.GRE_SMALL_DEMON_MASK.get(), 32),
                    new ItemStack(ChangShengJueBlocks.GRE_RIDGE_TILE.get(), 32)};
            ItemStack[] stack4 = new ItemStack[]{new ItemStack(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLACK_EAVES_TILE.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLACK_SMALL_DEMON_MASK.get(), 32),
                    new ItemStack(ChangShengJueBlocks.BLACK_RIDGE_TILE.get(), 32)};
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

    public static void blockBlockBreakEvent(BlockEvent.BreakEvent event){
    }

    public static void onInteract(PlayerInteractEvent event) {
//        WuGangCutGuiEvent.onInteract(event);
    }
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (!player.level().isClientSide
                && event.phase == TickEvent.Phase.END
                && player instanceof ServerPlayer serverPlayer) {
            FoodDataOwnerTracker.bind(serverPlayer);
        }
        KungFuEvent.onPlayerTick(event);
        // 任务
        PlayerQuestEvent.onPlayerTick(event);
        PlayerQuestEvent.onEntityGenerate(event);
        if (!player.level().isClientSide && event.phase == TickEvent.Phase.END) {
            if (player instanceof ServerPlayer serverPlayer) {
                TreadTheSnowWithoutTraceIntentGuard.tickPlayer(serverPlayer);
            }
            tickMoneySlave(player);
        }
    }
    public static void onAttachChunkCapabilities(AttachCapabilitiesEvent<LevelChunk> event) {
    }

    @SubscribeEvent
    public static void onItemPickup(EntityItemPickupEvent event) {
        RelentlessThrowingKnivesEvent.onItemPickup(event);
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        QuestEvent.onServerTick(event);
        if (event.phase == TickEvent.Phase.END) {
            StructureIntelligence.tickSearches(event.getServer());
        }
    }

    //生物攻击事件
    @SubscribeEvent
    public static void onEntityHurt(LivingAttackEvent event){
        KungFuEvent.onEntityHurt(event);
    }

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
        if (event.getSource().getEntity() instanceof Player killer
                && event.getEntity() instanceof Player victim
                && canTriggerQingPingJiTheft(killer)) {
            applyMoneySlaveOnDeath(killer, victim);
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
        if (event.getSource().getEntity() instanceof Player killer
                && event.getEntity() instanceof Player victim
                && canTriggerQingPingJiTheft(killer)) {
            tryStealOnKill(killer, victim, event);
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
    public static void onPlayerRightClick(PlayerInteractEvent.RightClickEmpty event){
    }

    @SubscribeEvent
    public static void onPlayerRightClickItem(PlayerInteractEvent.RightClickItem event) {
        KungFuEvent.onPlayerRightClickItem(event);
    }

    @SubscribeEvent
    public static void onPlayerAttackEntity(AttackEntityEvent event){
        KungFuEvent.onPlayerAttackEntity(event);
    }

    //玩家右键方块事件
    public static void onPlayerEntityInteract(PlayerInteractEvent.RightClickBlock event){
    }

    //玩家重生事件
    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        GoldenBellJarEvent.onPlayerRespawn(event);
        applyMoneySlaveOnRespawn(event.getEntity());
    }
    //能力给予事件,给生物添加能力
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        ChangShengJueCapabiliy.onAttachCapabilitiesPlayer(event);
    }

    /**
     * @deprecated 能力注册由 {@link ChangShengJueCapabiliy} 的 MOD 总线订阅完成。
     */
    @Deprecated(forRemoval = false)
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        ChangShengJueCapabiliy.registerCapabilities(event);
    }

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        ChangShengJueConfig.onRegisterCommands(event);
    }

    //玩家克隆事件,用于玩家死亡重生时或者从末地回到主世界时克隆旧玩家的属性到新玩家
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        ChangShengJueCapabiliy.onPlayerCloned(event);
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        //玩家进入世界时同步能力数据
        ChangShengJueCapabiliy.onPlayerJoinWorld(event);
    }

    @SubscribeEvent
    public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        if (event.getEntity() instanceof ServerPlayer serverPlayer) {
            QingPingJi.restoreInternalSuppression(serverPlayer);
            FoodDataOwnerTracker.unbind(serverPlayer);
            TreadTheSnowWithoutTraceIntentGuard.forget(serverPlayer);
        }
    }

    @SubscribeEvent
    public static void onServerStopping(ServerStoppingEvent event) {
        QingPingJi.restoreAllInternalSuppressions(event.getServer());
    }

    @SubscribeEvent
    public static void onServerStopped(ServerStoppedEvent event) {
        StructureIntelligence.clearSearches();
        QuestEvent.clearServerState();
        FoodDataOwnerTracker.clear();
        TreadTheSnowWithoutTraceIntentGuard.clearAll();
        MentalKungFuNeighborhoodSnapshot.clearAll();
        QingPingJi.clearInternalSuppressionTracking();
    }

    public void onWorldUnload(LevelEvent.Unload event) {
        handleWorldUnload(event);
    }

    @SubscribeEvent
    public static void onServerLevelUnload(LevelEvent.Unload event) {
        handleWorldUnload(event);
    }

    private static void handleWorldUnload(LevelEvent.Unload event) {
        QuestEvent.onWorldUnload(event);
        if (event.getLevel() instanceof net.minecraft.server.level.ServerLevel serverLevel) {
            MentalKungFuNeighborhoodSnapshot.clear(serverLevel);
        }
    }

    public static void onWorldLoad(LevelEvent.Load event) {
    }

    public static void onChunkUnload(ChunkEvent.Unload event) {
    }

    @SubscribeEvent
    public static void onPlayerFirstJoin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        // 检查是否为服务器端玩家
        if (player instanceof ServerPlayer serverPlayer) {
            // 判断是否为首次加入 - 通过检查玩家是否有统计数据
            boolean isFirstJoin;
            //如果玩家刚进入游戏，则修改为true
            isFirstJoin = !(serverPlayer.getStats().getValue(Stats.CUSTOM.get(Stats.LEAVE_GAME)) > 0);

            // 如果是首次加入才执行
            if (isFirstJoin) {
                if (PENG_FAN_UUID.equals(player.getUUID())) {
                    ItemStack reward = ChangShengJueItems.LONG_YUAN_SWORD.get().getDefaultInstance();
                    if (!player.getInventory().add(reward)) {
                        player.drop(reward, false);
                    }
                }

                // 检查Patchouli是否加载
                if (!ModList.get().isLoaded("patchouli")) {
                    player.sendSystemMessage(Component.translatable("message." + ChangShengJue.MOD_ID + ".install_patchouli_for_guide").withStyle(ChatFormatting.YELLOW));
                    return;
                }
                ItemStack book = PatchouliAPI.get().getBookStack(new ResourceLocation("chang_sheng_jue", "wufanglu"));
                if (!player.getInventory().add(book)) {
                    player.drop(book, false);
                }
            }
        }
    }

    private static void applyMoneySlaveOnDeath(Player killer, Player victim) {
        if (victim.level().isClientSide) return;
        if (killer == victim) return;
        if (!canTriggerQingPingJiTheft(killer)) return;
        long endTick = victim.level().getGameTime() + MONEY_SLAVE_DURATION_TICKS;
        victim.getPersistentData().putLong(MONEY_SLAVE_END_TICK_KEY, endTick);
        victim.getPersistentData().putUUID(MONEY_SLAVE_KILLER_KEY, killer.getUUID());
        victim.getPersistentData().putLong(MONEY_SLAVE_NEXT_TICK_KEY, victim.level().getGameTime() + MONEY_SLAVE_STEAL_INTERVAL_TICKS);
        victim.addEffect(new MobEffectInstance(
                ChangShengJueEffects.MONEY_SLAVE_EFFECT.get(),
                MONEY_SLAVE_DURATION_TICKS,
                0,
                false,
                true,
                true
        ));
    }

    private static void applyMoneySlaveOnRespawn(Player player) {
        if (player.level().isClientSide) return;
        long endTick = player.getPersistentData().getLong(MONEY_SLAVE_END_TICK_KEY);
        if (endTick <= 0) return;
        long remaining = endTick - player.level().getGameTime();
        if (remaining <= 0) {
            player.getPersistentData().remove(MONEY_SLAVE_END_TICK_KEY);
            player.getPersistentData().remove(MONEY_SLAVE_KILLER_KEY);
            player.getPersistentData().remove(MONEY_SLAVE_NEXT_TICK_KEY);
            return;
        }
        int duration = (int) Math.min(Integer.MAX_VALUE, remaining);
        player.addEffect(new MobEffectInstance(
                ChangShengJueEffects.MONEY_SLAVE_EFFECT.get(),
                duration,
                0,
                false,
                true,
                true
        ));
    }

    private static void tickMoneySlave(Player player) {
        long endTick = player.getPersistentData().getLong(MONEY_SLAVE_END_TICK_KEY);
        if (endTick <= 0) return;
        long now = player.level().getGameTime();
        if (now >= endTick) {
            player.getPersistentData().remove(MONEY_SLAVE_END_TICK_KEY);
            player.getPersistentData().remove(MONEY_SLAVE_KILLER_KEY);
            player.getPersistentData().remove(MONEY_SLAVE_NEXT_TICK_KEY);
            return;
        }
        if (!player.hasEffect(ChangShengJueEffects.MONEY_SLAVE_EFFECT.get())) return;
        long nextTick = player.getPersistentData().getLong(MONEY_SLAVE_NEXT_TICK_KEY);
        if (nextTick == 0) {
            nextTick = now + MONEY_SLAVE_STEAL_INTERVAL_TICKS;
            player.getPersistentData().putLong(MONEY_SLAVE_NEXT_TICK_KEY, nextTick);
            return;
        }
        if (now < nextTick) return;
        player.getPersistentData().putLong(MONEY_SLAVE_NEXT_TICK_KEY, now + MONEY_SLAVE_STEAL_INTERVAL_TICKS);
        if (!player.getPersistentData().hasUUID(MONEY_SLAVE_KILLER_KEY)) return;
        if (!(player.level() instanceof net.minecraft.server.level.ServerLevel serverLevel)) return;
        Player killer = serverLevel.getPlayerByUUID(player.getPersistentData().getUUID(MONEY_SLAVE_KILLER_KEY));
        if (killer == null || killer == player) return;
        if (!canTriggerQingPingJiTheft(killer)) {
            clearMoneySlaveState(player);
            return;
        }
        if (killer.getRandom().nextFloat() >= 0.35f) return;
        stealRandomItems(killer, player, 1, 5);
    }

    static boolean canTriggerQingPingJiTheft(Player player) {
        QingPingJi qingPingJi = QingPingJi.getKungFu(player);
        return qingPingJi != null
                && qingPingJi.isComprehend()
                && qingPingJi.isStart()
                && qingPingJi.getLevel() > 0;
    }

    private static void clearMoneySlaveState(Player player) {
        player.getPersistentData().remove(MONEY_SLAVE_END_TICK_KEY);
        player.getPersistentData().remove(MONEY_SLAVE_KILLER_KEY);
        player.getPersistentData().remove(MONEY_SLAVE_NEXT_TICK_KEY);
        player.removeEffect(ChangShengJueEffects.MONEY_SLAVE_EFFECT.get());
    }

    private static void stealRandomItems(Player killer, Player victim, int minCount, int maxCount) {
        var inventory = victim.getInventory();
        List<ItemStack> uniqueStacks = new ArrayList<>();
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack stack = inventory.getItem(i);
            if (stack.isEmpty()) continue;
            boolean exists = false;
            for (ItemStack existing : uniqueStacks) {
                if (ItemStack.isSameItemSameTags(existing, stack)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                uniqueStacks.add(stack.copy());
            }
        }
        if (uniqueStacks.isEmpty()) return;
        ItemStack target = uniqueStacks.get(killer.getRandom().nextInt(uniqueStacks.size()));
        int total = 0;
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack stack = inventory.getItem(i);
            if (!stack.isEmpty() && ItemStack.isSameItemSameTags(stack, target)) {
                total += stack.getCount();
            }
        }
        if (total <= 0) return;
        float pct = 0.05f + killer.getRandom().nextFloat() * 0.30f;
        int stealCount = (int) Math.ceil(total * pct);
        stealCount = Mth.clamp(stealCount, minCount, maxCount);
        if (stealCount <= 0) return;
        int remaining = stealCount;
        for (int i = 0; i < inventory.getContainerSize() && remaining > 0; i++) {
            ItemStack stack = inventory.getItem(i);
            if (stack.isEmpty() || !ItemStack.isSameItemSameTags(stack, target)) continue;
            int take = Math.min(stack.getCount(), remaining);
            ItemStack stolen = stack.copy();
            stolen.setCount(take);
            stack.shrink(take);
            remaining -= take;
            if (!killer.getInventory().add(stolen)) {
                killer.drop(stolen, false);
            }
        }
    }

    private static void tryStealOnKill(Player killer, Player victim, LivingDropsEvent event) {
        if (killer == victim) return;
        if (!canTriggerQingPingJiTheft(killer)) return;
        if (killer.getRandom().nextFloat() >= 0.35f) return;
        boolean keepInventory = victim.level().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY);
        if (keepInventory) {
            stealRandomItems(killer, victim, 1, 5);
        } else {
            stealRandomItemsFromDrops(killer, event.getDrops(), 1, 5);
        }
    }

    private static void stealRandomItemsFromDrops(Player killer, Collection<ItemEntity> drops, int minCount, int maxCount) {
        if (drops == null || drops.isEmpty()) return;
        List<ItemStack> uniqueStacks = new ArrayList<>();
        for (ItemEntity drop : drops) {
            ItemStack stack = drop.getItem();
            if (stack.isEmpty()) continue;
            boolean exists = false;
            for (ItemStack existing : uniqueStacks) {
                if (ItemStack.isSameItemSameTags(existing, stack)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                uniqueStacks.add(stack.copy());
            }
        }
        if (uniqueStacks.isEmpty()) return;
        ItemStack target = uniqueStacks.get(killer.getRandom().nextInt(uniqueStacks.size()));
        int total = 0;
        for (ItemEntity drop : drops) {
            ItemStack stack = drop.getItem();
            if (!stack.isEmpty() && ItemStack.isSameItemSameTags(stack, target)) {
                total += stack.getCount();
            }
        }
        if (total <= 0) return;
        float pct = 0.05f + killer.getRandom().nextFloat() * 0.30f;
        int stealCount = (int) Math.ceil(total * pct);
        stealCount = Mth.clamp(stealCount, minCount, maxCount);
        if (stealCount <= 0) return;
        int remaining = stealCount;
        Iterator<ItemEntity> iterator = drops.iterator();
        while (iterator.hasNext() && remaining > 0) {
            ItemEntity drop = iterator.next();
            ItemStack stack = drop.getItem();
            if (stack.isEmpty() || !ItemStack.isSameItemSameTags(stack, target)) continue;
            int take = Math.min(stack.getCount(), remaining);
            ItemStack stolen = stack.copy();
            stolen.setCount(take);
            stack.shrink(take);
            remaining -= take;
            if (stack.isEmpty()) {
                iterator.remove();
                drop.discard();
            }
            if (!killer.getInventory().add(stolen)) {
                killer.drop(stolen, false);
            }
        }
    }
}
