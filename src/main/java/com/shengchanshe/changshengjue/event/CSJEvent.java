package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.gao_marksmanship.GaoMarksmanshipCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.gao_marksmanship.GaoMarksmanshipCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.paoding.PaodingCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.paoding.PaodingCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.wheat_nugget_encyclopedia.WheatNuggetEncyclopediaCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.wu_gang_cut_gui.WuGangCutGuiCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.wu_gang_cut_gui.WuGangCutGuiCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.yugong_moves_mountains.YugongMovesMountainsCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.yugong_moves_mountains.YugongMovesMountainsCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.zhang_men_xin_xue.ZhangMenXinxueCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesClientData;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagers;
import com.shengchanshe.changshengjue.event.martial_arts.*;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.*;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu.GeShanDaNiuPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar.GoldenBellJarPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.turtle_breath_work.TurtleBreathWorkPacket;
import com.shengchanshe.changshengjue.particle.ChangShengJueParticles;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.particles.DustColorTransitionOptions;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.TradeWithVillagerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Vector3f;

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

        ZhangMenXinxueEvent.onVillagerInteract(event);
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

    //村民交易事件
    @SubscribeEvent
    public static void onTradeEvent(TradeWithVillagerEvent event) {
        ZhangMenXinxueEvent.onTradeEvent(event);
    }

    @SubscribeEvent
    public static void blockBlockBreakEvent(BlockEvent.BreakEvent event){
        WuGangCutGuiEvent.handleBlockBreakEvent(event);
        YugongMovesMountainsEvent.handleBlockBreakEvent(event);
    }
    @SubscribeEvent
    public static void onInteract(PlayerInteractEvent event) {
        WuGangCutGuiEvent.onInteract(event);
    }
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        //踏雪无痕
        TreadTheSnowWithoutTraceEvent.onPlayerTick(event);
        //葵花点穴手
        SunflowerPointCavemanEvent.onPlayerTick(event);
        //金钟罩
        GoldenBellJarEvent.onPlayerTick(event);
        //不死神功
        ImmortalMiracleEvent.onPlayerTick(event);
        //隔山打牛
        GeShanDaNiuEvent.onPlayerTick(event);
        //麦块百科
        WheatNuggetEncyclopediaEvent.onPlayerTick(event);
        //龟息功
        TurtleBreathWorkEvent.onPlayerTick(event);
        //无情飞刀
        RelentlessThrowingKnivesEvent.onPlayerTick(event);
        //吴刚伐桂
        WuGangCutGuiEvent.onPlayerTick(event);
        //独孤九剑
        DuguNineSwordsEvent.onPlayerTick(event);
        //高家枪法
        GaoMarksmanshipEvent.onPlayerTick(event);
        //金乌刀法
        GoldenBlackKnifeMethodEvent.onPlayerTick(event);
        //庖丁解牛
        PaodingEvent.onPlayerTick(event);
        //少林棍法
        ShaolinStickMethodEvent.onPlayerTick(event);
        //玄女剑法
        XuannuSwordsmanshipEvent.onPlayerTick(event);
    }
    //生物攻击事件
    @SubscribeEvent
    public static void onEntityAttack(LivingEvent.LivingTickEvent event){
    }
    //生物受伤事件
    @SubscribeEvent
    public static void onEntityHurt(LivingDamageEvent event){
        TreadTheSnowWithoutTraceEvent.onEntityHurt(event);
        WuGangCutGuiEvent.onEntityHurt(event);
        YugongMovesMountainsEvent.onEntityHurt(event);
        PaodingEvent.onEntityHurt(event);
        SunflowerPointCavemanEvent.onEntityHurt(event);
        GoldenBellJarEvent.onEntityHurt(event);
        ImmortalMiracleEvent.onEntityHurt(event);
        GeShanDaNiuEvent.onEntityHurt(event);
        TurtleBreathWorkEvent.onEntityHurt(event);
    }
    //生物死亡事件
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event){
        PaodingEvent.onEntityDeath(event);
    }
    //生物交互事件
    @SubscribeEvent
    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract event){
        SunflowerPointCavemanEvent.onPlayerEntityInteract(event);
        GoldenBellJarEvent.onPlayerEntityInteract(event);
        GeShanDaNiuEvent.onPlayerEntityInteract(event);
        TurtleBreathWorkEvent.onPlayerEntityInteract(event);
    }
    //玩家右键空气事件
    @SubscribeEvent
    public static void onPlayerRightClick(PlayerInteractEvent.RightClickEmpty event){
        GoldenBellJarEvent.onPlayerRightClick(event);
        GeShanDaNiuEvent.onPlayerRightClick(event);
        TurtleBreathWorkEvent.onPlayerRightClick(event);
    }
//    @SubscribeEvent
//    public static void onPlayerRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
//        GoldenBellJarEvent.onPlayerRightClickBlock(event);
//        GeShanDaNiuEvent.onPlayerRightClickBlock(event);
//        TurtleBreathWorkEvent.onPlayerRightClickBlock(event);
//    }

    @SubscribeEvent
    public static void onPlayerRightClickItem(PlayerInteractEvent.RightClickItem event) {
        GoldenBellJarEvent.onPlayerRightClickItem(event);
        GeShanDaNiuEvent.onPlayerRightClickItem(event);
        TurtleBreathWorkEvent.onPlayerRightClickItem(event);
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
            if (!event.getObject().getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"tread_the_snow_without_trace_properties"),new TreadTheSnowWithoutTraceCapabilityProvider());
            }
            //吴刚伐桂
            if (!event.getObject().getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"wu_gang_cut_gui_properties"),new WuGangCutGuiCapabilityProvider());
            }
            //吴刚伐桂
            if (!event.getObject().getCapability(YugongMovesMountainsCapabilityProvider.YUGONG_MOVES_MOUNTAINS_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"yugong_moves_mountains_properties"),new YugongMovesMountainsCapabilityProvider());
            }
            //庖丁解牛
            if (!event.getObject().getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"paoding_properties"),new PaodingCapabilityProvider());
            }
            //葵花点穴手
            if (!event.getObject().getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"sunflower_point_caveman_properties"),new SunflowerPointCavemanCapabilityProvider());
            }
            //金钟罩
            if (!event.getObject().getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"golden_bell_jar_properties"),new GoldenBellJarCapabilityProvider());
            }
            //张门心学
            if (!event.getObject().getCapability(ZhangMenXinxueCapabilityProvider.ZHANG_MEN_XIN_XUE_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"zhang_men_xin_xue_properties"),new ZhangMenXinxueCapabilityProvider());
            }
            //不死神功
            if (!event.getObject().getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"immortal_miracle_properties"),new ImmortalMiracleCapabilityProvider());
            }
            //隔山打牛
            if (!event.getObject().getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"ge_shan_da_niu_properties"),new GeShanDaNiuCapabilityProvider());
            }
            //麦块百科
            if (!event.getObject().getCapability(WheatNuggetEncyclopediaCapabilityProvider.WHEAT_NUGGET_ENCYCLOPEDIA_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"wheat_nugget_encyclopedia_properties"),new WheatNuggetEncyclopediaCapabilityProvider());
            }
            //龟息功
            if (!event.getObject().getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"turtle_breath_work_properties"),new TurtleBreathWorkCapabilityProvider());
            }
            //无情飞刀
            if (!event.getObject().getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).isPresent()){
                event.addCapability(new ResourceLocation(ChangShengJue.MOD_ID,"relentless_throwing_knives_properties"),new RelentlessThrowingKnivesCapabilityProvider());
            }
        }
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
        oldPlayer.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).ifPresent(newStore-> newStore.copyTreadTheSnowWithoutTrace(oldStore)));
        //吴刚伐桂
        oldPlayer.getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).ifPresent(newStore-> newStore.copyWuGangCutGui(oldStore)));
        //愚公移山
        oldPlayer.getCapability(YugongMovesMountainsCapabilityProvider.YUGONG_MOVES_MOUNTAINS_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(YugongMovesMountainsCapabilityProvider.YUGONG_MOVES_MOUNTAINS_CAPABILITY).ifPresent(newStore-> newStore.copyYugongMovesMountains(oldStore)));
        //庖丁解牛
        oldPlayer.getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).ifPresent(newStore-> newStore.copyPaoding(oldStore)));
        //葵花点穴手
        oldPlayer.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(newStore-> newStore.copySunflowerPointCaveman(oldStore)));
        //金钟罩
        oldPlayer.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(newStore-> newStore.copyGoldenBellJar(oldStore)));
        //张门心学
        oldPlayer.getCapability(ZhangMenXinxueCapabilityProvider.ZHANG_MEN_XIN_XUE_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(ZhangMenXinxueCapabilityProvider.ZHANG_MEN_XIN_XUE_CAPABILITY).ifPresent(newStore-> newStore.copyZhangMenXinxue(oldStore)));
        //不死神功
        oldPlayer.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(newStore-> newStore.copyImmortalMiracle(oldStore)));
        //隔山打牛
        oldPlayer.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(newStore-> newStore.copyGeShanDaNiu(oldStore)));
        //麦块百科
        oldPlayer.getCapability(WheatNuggetEncyclopediaCapabilityProvider.WHEAT_NUGGET_ENCYCLOPEDIA_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(WheatNuggetEncyclopediaCapabilityProvider.WHEAT_NUGGET_ENCYCLOPEDIA_CAPABILITY).ifPresent(newStore-> newStore.copyWheatNuggetEncyclopedia(oldStore)));
        //龟息功
        oldPlayer.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(newStore-> newStore.copyTurtleBreathWork(oldStore)));
        //无情飞刀
        oldPlayer.getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(newStore-> newStore.copyRelentlessThrowingKnives(oldStore)));

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
        event.register(WuGangCutGuiCapability.class);
        event.register(YugongMovesMountainsCapability.class);
        event.register(PaodingCapability.class);
        event.register(SunflowerPointCavemanCapability.class);
        event.register(GoldenBellJarCapabilityProvider.class);
        event.register(ZhangMenXinxueCapabilityProvider.class);
        event.register(ImmortalMiracleCapabilityProvider.class);
        event.register(GeShanDaNiuCapabilityProvider.class);
        event.register(WheatNuggetEncyclopediaCapabilityProvider.class);
        event.register(TurtleBreathWorkCapabilityProvider.class);
        event.register(RelentlessThrowingKnivesCapabilityProvider.class);
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        //玩家进入世界时同步能力数据
        if(!event.getLevel().isClientSide()) {
            if(event.getEntity() instanceof ServerPlayer player) {
                player.getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(duguNineSword -> {
                    ChangShengJueMessages.sendToPlayer(new DuguNineSwordsPacket(duguNineSword.getDuguNineSwordsLevel(),
                            duguNineSword.isDuguNineSwordsComprehend(),
                            duguNineSword.getDuguNineSwordsToppedTick(),
                            duguNineSword.getDuguNineSwordsDachengTick(),
                            duguNineSword.isDuguNineSwordsParticle()), player);
                });
                player.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(goldenBlackKnifeMethod -> {
                    ChangShengJueMessages.sendToPlayer(new GoldenBlackKnifeMethodPacket(goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel(),
                            goldenBlackKnifeMethod.isGoldenBlackKnifeMethodComprehend(),
                            goldenBlackKnifeMethod.getGoldenBlackKnifeMethodToppedTick(),
                            goldenBlackKnifeMethod.getGoldenBlackKnifeMethodDachengTick(),
                            goldenBlackKnifeMethod.isGoldenBlackKnifeMethodParticle()), player);
                });
                player.getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).ifPresent(xuannuSwordsmanship -> {
                    ChangShengJueMessages.sendToPlayer(new XuannuSwordsmanshipPacket(xuannuSwordsmanship.getXuannuSwordsmanshipLevel(),xuannuSwordsmanship.isXuannuSwordsmanshipComprehend(),
                            xuannuSwordsmanship.getXuannuSwordsmanshipToppedTick(),
                            xuannuSwordsmanship.getXuannuSwordsmanshipDachengTick(),
                            xuannuSwordsmanship.isXuannuSwordsmanshipParticle()), player);
                });
                player.getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).ifPresent(gaoMarksmanship -> {
                    ChangShengJueMessages.sendToPlayer(new GaoMarksmanshipPacket(gaoMarksmanship.getGaoMarksmanshipLevel(),
                            gaoMarksmanship.isGaoMarksmanshipComprehend(),
                            gaoMarksmanship.getGaoMarksmanshipToppedTick(),
                            gaoMarksmanship.getGaoMarksmanshipDachengTick(),
                            gaoMarksmanship.isGaoMarksmanshipParticle()), player);
                });
                player.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
                    ChangShengJueMessages.sendToPlayer(new ShaolinStickMethodPacket(shaolinStickMethod.getShaolinStickMethodLevel(),
                            shaolinStickMethod.isShaolinStickMethodComprehend(),
                            shaolinStickMethod.getShaolinStickMethodToppedTick(),
                            shaolinStickMethod.getShaolinStickMethodDachengTick(),
                            shaolinStickMethod.isShaolinStickMethodParticle()), player);
                });
                player.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).ifPresent(treadTheSnowWithoutTrace -> {
                    ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTracePacket(
                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel(),
                            treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend(),
                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent(),
                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceToppedTick(),
                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceDachengTick(),
                            treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceParticle()), player);
                });
                player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                    ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                            sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                            sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                            sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                            sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                            sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                            sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                            sunflowerPointCaveman.isSunflowerPointCavemanParticle()), player);
                });
                player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
                    ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                            goldenBellJar.getGoldenBellJarLevel(),
                            goldenBellJar.isGoldenBellJarComprehend(),
                            goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                            goldenBellJar.isGoldenBellJarOff(),
                            goldenBellJar.getGoldenBellJarToppedTick(),
                            goldenBellJar.getGoldenBellJarDachengTick(),
                            goldenBellJar.isGoldenBellJarParticle()), player);
                });
                player.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
                    ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
                            immortalMiracle.getImmortalMiracleLevel(),
                            immortalMiracle.isImmortalMiracleComprehend(),
                            immortalMiracle.getImmortalMiracleUseCooldownPercent(),
                            immortalMiracle.isImmortalMiracleOff(),
                            immortalMiracle.getImmortalMiracleToppedTick(),
                            immortalMiracle.getImmortalMiracleDachengTick(),
                            immortalMiracle.isImmortalMiracleParticle(),
                            immortalMiracle.getImmortalMiracleUseCooldownPercentMax()), player);
                });
                player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
                    ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
                            geShanDaNiu.getGeShanDaNiuLevel(),
                            geShanDaNiu.isGeShanDaNiuComprehend(),
                            geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
                            geShanDaNiu.isGeShanDaNiuOff(),
                            geShanDaNiu.getGeShanDaNiuToppedTick(),
                            geShanDaNiu.getGeShanDaNiuDachengTick(),
                            geShanDaNiu.isGeShanDaNiuParticle(),
                            geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax()), player);
                });
                player.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
                    ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
                            turtleBreathWork.getTurtleBreathWorkLevel(),
                            turtleBreathWork.isTurtleBreathWorkComprehend(),
                            turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
                            turtleBreathWork.isTurtleBreathWorkOff(),
                            turtleBreathWork.getTurtleBreathWorkToppedTick(),
                            turtleBreathWork.getTurtleBreathWorkDachengTick(),
                            turtleBreathWork.isTurtleBreathWorkParticle()), player);
                });
                player.getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(relentlessThrowingKnives -> {
                    ChangShengJueMessages.sendToPlayer(new RelentlessThrowingKnivesPacket(
                            relentlessThrowingKnives.getRelentlessThrowingKnivesLevel(),
                            relentlessThrowingKnives.isRelentlessThrowingKnivesComprehend(),
                            relentlessThrowingKnives.getRelentlessThrowingKnivesUseCooldownPercent(),
                            relentlessThrowingKnives.getRelentlessThrowingKnivesToppedTick(),
                            relentlessThrowingKnives.getRelentlessThrowingKnivesDachengTick(),
                            relentlessThrowingKnives.isRelentlessThrowingKnivesParticle()), player);
                });
            }
        }
    }
}
