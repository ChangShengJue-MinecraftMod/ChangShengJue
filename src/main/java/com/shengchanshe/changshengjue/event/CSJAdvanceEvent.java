package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.gao_marksmanship.GaoMarksmanshipCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipCapabilityProvider;
import com.shengchanshe.changshengjue.init.CSJAdvanceInit;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID)
public class CSJAdvanceEvent {

    @SubscribeEvent
    public static void onPlayerInventoryChanged(PlayerEvent.PlayerLoggedInEvent event) {
        checkForItem(event.getEntity());
    }

    @SubscribeEvent
    public static void onPlayerInventoryChanged(PlayerEvent.ItemPickupEvent event) {
        checkForItem(event.getEntity());
    }

    @SubscribeEvent
    public static void onPlayerInventoryChanged(PlayerEvent.ItemCraftedEvent event) {
        checkForItem(event.getEntity());
    }

    //检查物品
    private static void checkForItem(net.minecraft.world.entity.player.Player player) {
        boolean hasQiTianHelmet = false;
        boolean hasQiTianChestplate = false;
        boolean hasQiTianLeggings = false;
        boolean hasQiTianBoots = false;
        for (ItemStack itemStack : player.getInventory().items) {
            Item item = itemStack.getItem();
            if (player instanceof ServerPlayer serverPlayer) {
                if (item == ChangShengJueItems.MI_FAN.get()) {
                    CSJAdvanceInit.hasmifan.trigger(serverPlayer);//人是铁饭是钢
                }else if (item == ChangShengJueItems.SILVER_BULLIONS.get()) {
                    CSJAdvanceInit.hassilverbullions.trigger(serverPlayer);//银华熠熠
                }else if (item == ChangShengJueItems.GOLD_BULLIONS.get()) {
                    CSJAdvanceInit.hasgoldbullions.trigger(serverPlayer);//金光闪闪
                }else if (item == ChangShengJueItems.BA_BAO_ZHOU.get()){
                    CSJAdvanceInit.hasbabaozhou.trigger(serverPlayer);//吉祥如意
                }else if(item == ChangShengJueItems.GUI_HUA_TANG_OU.get()){
                    CSJAdvanceInit.hasguihuatangou.trigger(serverPlayer);//甜蜜蜜
                }else if (item == ChangShengJueItems.BRONZE_SWORD.get()) {
                    CSJAdvanceInit.hasbronzesword.trigger(serverPlayer);//侠客行
                }else if (item == ChangShengJueItems.LICHEE.get()) {
                    CSJAdvanceInit.haslichee.trigger(serverPlayer);//似是妃子笑
                }else if (item == ChangShengJueItems.BILUOCHUN_TEAS.get()
                        || item == ChangShengJueItems.LONG_JING_TEAS.get()) {
                    CSJAdvanceInit.hastea.trigger(serverPlayer);//习习清风生
                }else if (item == ChangShengJueItems.SHI_LI_XIANG.get()
                        || item == ChangShengJueItems.FEN_JIU.get()
                        || item == ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get()) {
                    CSJAdvanceInit.haswine.trigger(serverPlayer);//对酒当歌
                }else if (item == ChangShengJueItems.TOMATO_EGG.get()) {
                    CSJAdvanceInit.hastomatoegg.trigger(serverPlayer);//家常小炒
                }else if (item == ChangShengJueItems.TU_LONG_DAO.get()
                        || item == ChangShengJueItems.YI_TINA_JIAN.get()
                        || item == ChangShengJueItems.BA_WANG_QIANG.get()
                        || item == ChangShengJueItems.BEAT_DOG_STICK.get()) {
                    CSJAdvanceInit.hassword.trigger(serverPlayer);//四大神器
                }else if (item == Items.LEATHER_CHESTPLATE
                        || item == ChangShengJueItems.FEMALE_TAOIST_ROBES_CHESTPLATE.get()
                        || item == ChangShengJueItems.MALE_TAOIST_ROBES_CHESTPLATE.get()
                        || item == ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_CHESTPLATE.get()
                        || item == ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_CHESTPLATE.get()
                        || item == ChangShengJueItems.CONFUCIAN_COSTUMES_CHESTPLATE.get()){
                    CSJAdvanceInit.hasarmor.trigger(serverPlayer);
                }else if (item == Items.CHAINMAIL_CHESTPLATE
                        || item == Items.IRON_CHESTPLATE
                        || item == Items.GOLDEN_CHESTPLATE
                        || item == Items.DIAMOND_CHESTPLATE
                        || item == Items.NETHERITE_CHESTPLATE
                        || item == ChangShengJueItems.COTTON_ARMOR_CHESTPLATE.get()
                        || item == ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR_CHESTPLATE.get()
                        || item == ChangShengJueItems.FLYING_FISH_ROBE_CHESTPLATE.get()
                        || item == ChangShengJueItems.WALKER_SET_CHESTPLATE.get()
                        || item == ChangShengJueItems.THE_GREAT_GENERAL_MINGGUANG_ARMOR_CHESTPLATE.get()
                ){
                    CSJAdvanceInit.hasadvancedarrmor.trigger(serverPlayer);
                }else if (item == ChangShengJueItems.QI_TIAN_DA_SHENG_HELMET.get()) {
                    hasQiTianHelmet = true;
                    if (hasQiTianHelmet && hasQiTianChestplate && hasQiTianLeggings && hasQiTianBoots) {
                        CSJAdvanceInit.hasqitian.trigger(serverPlayer);
                    }
                }else if (item == ChangShengJueItems.QI_TIAN_DA_SHENG_CHESTPLATE.get()){
                    hasQiTianChestplate = true;
                    if (hasQiTianHelmet && hasQiTianChestplate && hasQiTianLeggings && hasQiTianBoots) {
                        CSJAdvanceInit.hasqitian.trigger(serverPlayer);
                    }
                }else if (item == ChangShengJueItems.QI_TIAN_DA_SHENG_LEGGINGS.get()) {
                    hasQiTianLeggings = true;
                    if (hasQiTianHelmet && hasQiTianChestplate && hasQiTianLeggings && hasQiTianBoots) {
                        CSJAdvanceInit.hasqitian.trigger(serverPlayer);
                    }
                }else if (item == ChangShengJueItems.QI_TIAN_DA_SHENG_BOOTS.get()) {
                    hasQiTianBoots = true;
                    if (hasQiTianHelmet && hasQiTianChestplate && hasQiTianLeggings && hasQiTianBoots) {
                        CSJAdvanceInit.hasqitian.trigger(serverPlayer);
                    }
                }
            }
        }
    }
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.player instanceof ServerPlayer serverPlayer) {
            checkPlayerCungFu(serverPlayer);
        }
    }
    private static void checkPlayerCungFu(ServerPlayer player) {
        // 获取玩家的独孤九剑能力
        player.getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(duguNineSwords -> {
            // 在这里添加你的能力检查逻辑
            int level = duguNineSwords.getDuguNineSwordsLevel();
            int count = duguNineSwords.getDuguNineSwordsUseCount();
            CheckLevel(level,player,count);
        });
        player.getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).ifPresent(gaoMarksmanship -> {
            int level = gaoMarksmanship.getGaoMarksmanshipLevel();
            int count = gaoMarksmanship.getGaoMarksmanshipUseCount();
            CheckLevel(level, player, count);
        });


        player.getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).ifPresent(xuannuSwordsmanship -> {
            int level = xuannuSwordsmanship.getXuannuSwordsmanshipLevel();
            int count = xuannuSwordsmanship.getXuannuSwordsmanshipUseCount();
            CheckLevel(level, player, count);
        });

        player.getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(relentlessThrowingKnives -> {
            int level = relentlessThrowingKnives.getRelentlessThrowingKnivesLevel();
            int count = relentlessThrowingKnives.getRelentlessThrowingKnivesUseCount();
            CheckLevel(level, player, count);
        });

        player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
            int level = geShanDaNiu.getGeShanDaNiuLevel();
            int count = geShanDaNiu.getGeShanDaNiuUseCount();
            CheckLevel(level, player, count);
        });

        player.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(goldenBlackKnifeMethod -> {
            int level = goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel();
            int count = goldenBlackKnifeMethod.getGoldenBlackKnifeMethodUseCount();
            CheckLevel(level, player, count);
        });

        player.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
            int level = shaolinStickMethod.getShaolinStickMethodLevel();
            int count = shaolinStickMethod.getShaolinStickMethodUseCount();
            CheckLevel(level, player, count);
        });

        player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
            int level = sunflowerPointCaveman.getSunflowerPointCavemanLevel();
            int count = sunflowerPointCaveman.getSunflowerPointCavemanUseCount();
            CheckLevel(level, player, count);
        });

        player.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
            int level = immortalMiracle.getImmortalMiracleLevel();
            CheckLevel(level,player);
        });

        player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
            int level = goldenBellJar.getGoldenBellJarLevel();
            CheckLevel(level,player);
        });

        player.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi -> {
            int level = qianKunDaNuoYi.getQianKunDaNuoYiLevel();
            CheckLevel(level,player);
        });
        
        player.getCapability(TheClassicsOfTendonChangingCapabilityProvider.THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY).ifPresent(theClassicsOfTendonChanging -> {
            int level = theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel();
            CheckLevel(level,player);
        });
        
        player.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
            int level = turtleBreathWork.getTurtleBreathWorkLevel();
            CheckLevel(level,player);
        });
    }

    public static void CheckLevel(int level, ServerPlayer player, int count){
        CheckLevel(level,player);
        if(count >= 1){
            CSJAdvanceInit.usewaigong.trigger(player);
        }
    }
    public static void CheckLevel(int level, ServerPlayer player){
        if(level == 1){
            CSJAdvanceInit.matergongfa.trigger(player);
        }else if(level == 2){
            CSJAdvanceInit.matergongfa.trigger(player);
            CSJAdvanceInit.gongfadone.trigger(player);
        }
    }

}
