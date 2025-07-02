package com.shengchanshe.chang_sheng_jue.event;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.gao_marksmanship.GaoMarksmanshipCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.init.CSJAdvanceInit;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID)
public class CSJAdvanceEvent {
    private static int TASK_COUNT = 0;

    //检查物品
    private static void checkForItem(net.minecraft.world.entity.player.Player player) {
        boolean hasQiTianHelmet = false;
        boolean hasQiTianChestplate = false;
        boolean hasQiTianLeggings = false;
        boolean hasQiTianBoots = false;
        for (ItemStack itemStack : player.getInventory().items) {
            Item item = itemStack.getItem();
            if (player instanceof ServerPlayer serverPlayer) {
                //获取玩家所在群系
                 String biome = serverPlayer.level().getBiome(player.blockPosition()).toString();
                if (item == ChangShengJueItems.MI_FAN.get()) {
                    CSJAdvanceInit.HAS_MI_FAN.trigger(serverPlayer);//人是铁饭是钢
                }else if (item == ChangShengJueItems.SILVER_BULLIONS.get()) {
                    CSJAdvanceInit.HAS_SILVER_BULLIONS.trigger(serverPlayer);//银华熠熠
                }else if (item == ChangShengJueItems.GOLD_BULLIONS.get()) {
                    CSJAdvanceInit.HASGOLD_BULLIONS.trigger(serverPlayer);//金光闪闪
                }else if (item == ChangShengJueItems.BA_BAO_ZHOU.get()){
                    CSJAdvanceInit.HAS_BA_BAO_ZHOU.trigger(serverPlayer);//吉祥如意
                }else if(item == ChangShengJueItems.GUI_HUA_TANG_OU.get()){
                    CSJAdvanceInit.HAS_GUI_HUA_TANG_OU.trigger(serverPlayer);//甜蜜蜜
                }else if (item == ChangShengJueItems.BRONZE_SWORD.get()) {
                    CSJAdvanceInit.HAS_BRONZE_SWORD.trigger(serverPlayer);//侠客行
                }else if (item == ChangShengJueItems.LICHEE.get()) {
                    CSJAdvanceInit.HAS_LICHEE.trigger(serverPlayer);//似是妃子笑
                }else if (item == ChangShengJueItems.BILUOCHUN_TEAS.get()
                        || item == ChangShengJueItems.LONG_JING_TEAS.get()) {
                    CSJAdvanceInit.HAS_TEA.trigger(serverPlayer);//习习清风生
                }else if (item == ChangShengJueItems.SHI_LI_XIANG.get()
                        || item == ChangShengJueItems.FEN_JIU.get()
                        || item == ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get()) {
                    CSJAdvanceInit.HAS_WINE.trigger(serverPlayer);//对酒当歌
                }else if (item == ChangShengJueItems.TOMATO_EGG.get()) {
                    CSJAdvanceInit.HAS_TOMATO_EGG.trigger(serverPlayer);//家常小炒
                }else if (item == ChangShengJueItems.TU_LONG_DAO.get()
                        || item == ChangShengJueItems.YI_TIAN_JIAN.get()
                        || item == ChangShengJueItems.BA_WANG_QIANG.get()
                        || item == ChangShengJueItems.BEAT_DOG_STICK.get()) {
                    CSJAdvanceInit.HAS_SWORD.trigger(serverPlayer);//四大神器
                }else if (item == Items.LEATHER_CHESTPLATE
                        || item == ChangShengJueItems.FEMALE_TAOIST_CHESTPLATE.get()
                        || item == ChangShengJueItems.MALE_TAOIST_CHESTPLATE.get()
                        || item == ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_KYLIN_BUFU.get()
                        || item == ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_QUEEN_CLOTHING.get()
                        || item == ChangShengJueItems.CONFUCIAN_INK_CHESTPLATE.get()){
                    CSJAdvanceInit.HAS_ARMOR.trigger(serverPlayer);
                }else if (item == ChangShengJueItems.COTTON_CHESTPLATE.get()
                        || item == ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR.get()
                        || item == ChangShengJueItems.FLY_FISH_CHESTPLATE.get()
                        || item == ChangShengJueItems.WALKER_CHESTPLATE.get()
                        || item == ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LIGHT_CHESTPLATE.get()
                ){
                    CSJAdvanceInit.HAS_ADVANCED_ARRMOR.trigger(serverPlayer);
                }else if (item == ChangShengJueItems.PHOENIX_FEATHER_CAP.get()) {
                    hasQiTianHelmet = true;
                    if (hasQiTianHelmet && hasQiTianChestplate && hasQiTianLeggings && hasQiTianBoots) {
                        CSJAdvanceInit.HAS_QI_TIAN.trigger(serverPlayer);
                    }
                }else if (item == ChangShengJueItems.OLDEN_CHAIN_MAIL_SHIRT.get()){
                    hasQiTianChestplate = true;
                    if (hasQiTianHelmet && hasQiTianChestplate && hasQiTianLeggings && hasQiTianBoots) {
                        CSJAdvanceInit.HAS_QI_TIAN.trigger(serverPlayer);
                    }
                }else if (item == ChangShengJueItems.TIGER_SKIN_GARMENT.get()) {
                    hasQiTianLeggings = true;
                    if (hasQiTianHelmet && hasQiTianChestplate && hasQiTianLeggings && hasQiTianBoots) {
                        CSJAdvanceInit.HAS_QI_TIAN.trigger(serverPlayer);
                    }
                }else if (item == ChangShengJueItems.CLOUD_WALKING_BOOTS.get()) {
                    hasQiTianBoots = true;
                    if (hasQiTianHelmet && hasQiTianChestplate && hasQiTianLeggings && hasQiTianBoots) {
                        CSJAdvanceInit.HAS_QI_TIAN.trigger(serverPlayer);
                    }
                }else if (item == ChangShengJueItems.GANG_TOKEN.get() && itemStack.getCount() == 64) {
                    CSJAdvanceInit.A_GROUP_GANG_TOKEN.trigger(serverPlayer);
                }
            }
        }

    }
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.player instanceof ServerPlayer serverPlayer) {
            checkPlayerCungFu(serverPlayer);
            checkForItem(event.player);
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
            CSJAdvanceInit.USE_WAI_GONG.trigger(player);
        }
    }
    public static void CheckLevel(int level, ServerPlayer player){
        if(level == 1){
            CSJAdvanceInit.MATER_GONG_FA.trigger(player);
        }else if(level == 2){
            CSJAdvanceInit.MATER_GONG_FA.trigger(player);
            CSJAdvanceInit.GONG_FA_DONE.trigger(player);
        }
    }
    /**
     * 处理特定任务奖励（投名状）
     * @param player 完成任务的玩家
     * @param quest 完成的任务
     */
    public static void handleSpecialQuestReward(ServerPlayer player, Quest quest) {
        final UUID TOU_MING_ZHUANG = UUID.fromString("c4ac1553-b219-4e7c-a54d-e274f9815109");
        final UUID JIU_MING_XIA_YI = UUID.fromString("7dc9c671-ec29-4f3f-9467-5324fa026499");
        final UUID ZHAI_FAN = UUID.fromString("33954498-78EF-492C-9338-B2E85C0AD184");
        final UUID TIAN_RUO_YOU_QING = UUID.fromString("b005b283-34fa-4217-b417-866d830ccda8");
        final UUID CHU_BAO_AN_LIANG = UUID.fromString("066905EA-4B2D-408D-A86E-9D37F450B729");
        final UUID questId = quest.getQuestId();
        final Set<UUID> firstGroupQuests = Set.of(TOU_MING_ZHUANG, JIU_MING_XIA_YI, ZHAI_FAN);
        if (firstGroupQuests.contains(questId)) {
            CSJAdvanceInit.FINISH_TASK.trigger(player);
        } else if (TIAN_RUO_YOU_QING.equals(questId)) {
            CSJAdvanceInit.DONE_FINAL_TASK.trigger(player);
        } else if (CHU_BAO_AN_LIANG.equals(questId)) {
            final int needCount = quest.getNeedCompletionCount();
            if (needCount == 5) {
                CSJAdvanceInit.DONE_FIVE_TASK.trigger(player);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerOpenBook(PlayerInteractEvent.RightClickItem event) {
        if(event.getEntity() instanceof ServerPlayer player){
            ItemStack itemStack = event.getItemStack();
            if (!net.minecraftforge.fml.ModList.get().isLoaded("patchouli")) {
                return;
            }
            CompoundTag itemnbt = itemStack.getTag();
            if (itemnbt == null) return;

            if (itemnbt.contains("patchouli:book") &&
                    itemnbt.getString("patchouli:book").equals("chang_sheng_jue:wufanglu")) {
                CSJAdvanceInit.MI_CHANG_SHENG.trigger(player);
            }
        }

    }

}
