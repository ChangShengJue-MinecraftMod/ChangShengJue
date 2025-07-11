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
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.bandit.Bandit;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.challenger.Challenger;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.villain.Villain;
import com.shengchanshe.chang_sheng_jue.init.CSJAdvanceInit;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import com.shengchanshe.chang_sheng_jue.world.CSJStructures;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.Structures;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID)
public class CSJAdvanceEvent {
    private static int COOLDOWN = 3;
    private static final Set<ChunkPos> generatedVillainChunks = new HashSet<>(); // 新增：跟踪已生成Villain的区块

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.player instanceof ServerPlayer serverPlayer) {
            Player player = event.player;
            checkPlayerCungFu(serverPlayer);
            checkForItem(player);

            //玩家是否处于某结构
            Level level = player.level();
            BlockPos pos = player.blockPosition();
            ServerLevel serverLevel = (ServerLevel) level;
            List<ResourceKey<Structure>> villages = List.of(
                    CSJStructures.PIT_YARD,
                    CSJStructures.SANDSTONE_CASTLE,
                    CSJStructures.SI_HE_YUAN,
                    CSJStructures.SU_PAI_VILLAGE,
                    CSJStructures.WAN_PAI_VILLAGE,
                    BuiltinStructures.VILLAGE_DESERT,
                    BuiltinStructures.VILLAGE_PLAINS,
                    BuiltinStructures.VILLAGE_SAVANNA,
                    BuiltinStructures.VILLAGE_SNOWY,
                    BuiltinStructures.VILLAGE_TAIGA
            );
            boolean isInAnyVillage = false;
            ChunkPos villageChunk = null; // 记录村庄所在的区块

            for (ResourceKey<Structure> village : villages) {
                LocationPredicate predicate = LocationPredicate.inStructure(village);
                if (predicate.matches(serverLevel, pos.getX(), pos.getY(), pos.getZ())) {
                    villageChunk = new ChunkPos(pos);
                    isInAnyVillage = true;
                    break;
                }
            }
            if (isInAnyVillage && villageChunk != null && !generatedVillainChunks.contains(villageChunk)) {
                summonVillain(serverLevel, player, villageChunk); // 传递区块参数
                generatedVillainChunks.add(villageChunk); // 标记为已生成
            }
        }
    }



    private static void checkForItem(net.minecraft.world.entity.player.Player player) {
        boolean hasQiTianHelmet = false;
        boolean hasQiTianChestplate = false;
        boolean hasQiTianLeggings = false;
        boolean hasQiTianBoots = false;
        //获取世界时间
        Level level = player.level();
        long worldTime = level.getDayTime();
        if (worldTime % 24000 == 0) {
            if (COOLDOWN == 3) {
                //强盗
                //当玩家拥有8个铜钱时
                if (player.getInventory().countItem(ChangShengJueItems.YI_GUAN_TONG_QIAN.get()) >= 9 ||
                    player.getInventory().countItem(ChangShengJueItems.SILVER_BULLIONS.get()) >= 3 ||
                    player.getInventory().countItem(ChangShengJueItems.GOLD_BULLIONS.get()) >= 1)
                {
                    summonBandit(level, player);
                }
            } else if (COOLDOWN >= 4) {
                COOLDOWN = 0;
            } else {
                COOLDOWN++;
            }
        }


        for (ItemStack itemStack : player.getInventory().items) {
            Item item = itemStack.getItem();
            if (player instanceof ServerPlayer serverPlayer) {
                //获取玩家所在群系
                 String biome = serverPlayer.level().getBiome(player.blockPosition()).toString();
                //成就
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
                        || item == ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LIGHT_CHESTPLATE.get()) {
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

    public static void summonBandit(Level level, Player player) {
        if (level.isClientSide()) {
            return;
        }
        BlockPos pos = player.blockPosition();
        ServerLevel serverLevel = (ServerLevel) level;
        BlockPos playerPos = player.blockPosition();
        RandomSource random = serverLevel.getRandom();
        if (serverLevel.getRandom().nextInt(100) <= 5) {
            int numberOfBandits = RandomSource.create().nextInt(3) + 1;
            for (int i = 0; i < numberOfBandits; i++) {
                BlockPos spawnPos = findValidSpawnPosition(serverLevel, playerPos, random,20);
                if (spawnPos == null) {
                    spawnPos = new BlockPos(
                            playerPos.getX() + random.nextInt(10) - 5,
                            playerPos.getY() + random.nextInt(10) - 5, // 原方法的Y坐标随机
                            playerPos.getZ()
                    );
                }
                Bandit bandit = new Bandit(ChangShengJueEntity.BANDIT.get(), serverLevel);
                if (bandit != null) {
                    bandit.moveTo(spawnPos,
                            5.0F, 5.0F);
                    bandit.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(pos),
                            MobSpawnType.EVENT, null, null);
                    serverLevel.addFreshEntity(bandit);
                    COOLDOWN = 0;
                }
            }
        }
    }
    public static void summonVillain(Level level, Player player, ChunkPos villageChunk) {
        if (level.isClientSide()) {
            return;
        }
        ServerLevel serverLevel = (ServerLevel) level;
        BlockPos playerPos = player.blockPosition();
        RandomSource random = serverLevel.getRandom();

        // 50%概率生成
        if (random.nextInt(100) <= 50) {
            int numberOfVillains = random.nextInt(5) + 1;

            for (int i = 0; i < numberOfVillains; i++) {
                // 尝试寻找有效生成位置
                BlockPos spawnPos = findValidSpawnPosition(serverLevel, playerPos, random,20);

                // 如果失败则使用默认方法（直接在玩家附近生成）
                if (spawnPos == null) {
                    spawnPos = playerPos.offset(
                            random.nextInt(20) - 10,
                            0,
                            random.nextInt(20) - 10
                    );
                }

                // 生成实体
                Villain villain = new Villain(ChangShengJueEntity.VILLAIN.get(), serverLevel);
                if (villain != null) {
                    villain.moveTo(spawnPos, random.nextFloat() * 360.0F, 0.0F);
                    villain.finalizeSpawn(
                            serverLevel,
                            serverLevel.getCurrentDifficultyAt(spawnPos),
                            MobSpawnType.EVENT,
                            null,
                            null
                    );
                    serverLevel.addFreshEntity(villain);
                }
            }
        }
    }


    public static void summonChallenger(Level level, Player player) {
        // 仅在服务端执行实体生成逻辑
        if (level.isClientSide()) {
            return;
        }
        ServerLevel serverLevel = (ServerLevel) level;
        BlockPos playerPos = player.blockPosition();
        RandomSource random = serverLevel.getRandom();

        int numberOfChallengers = 1;

        for (int i = 0; i < numberOfChallengers; i++) {
            // 尝试寻找有效生成位置（避免实体卡在方块中）
            BlockPos spawnPos = findValidSpawnPosition(serverLevel, playerPos, random,5);

            // 如果未找到有效位置，使用玩家周围随机偏移位置
            if (spawnPos == null) {
                spawnPos = playerPos.offset(
                        random.nextInt(31) - 15,  // X轴：-15到15之间随机
                        0,  // Y轴保持与玩家同高度（避免空中/地下）
                        random.nextInt(31) - 15   // Z轴：-15到15之间随机
                );
            }

            // 创建挑战者实体并设置属性
            Challenger challenger = new Challenger(ChangShengJueEntity.CHALLENGER.get(), serverLevel);
            if (challenger != null) {
                // 设置实体位置和旋转角度
                challenger.moveTo(spawnPos, random.nextFloat() * 360.0F, 0.0F);
                // 初始化实体（难度适配、生成状态等）
                challenger.finalizeSpawn(
                        serverLevel,
                        serverLevel.getCurrentDifficultyAt(spawnPos),
                        MobSpawnType.EVENT,  // 标记为事件生成
                        null,  // 无额外NBT数据
                        null
                );
                // 将实体添加到世界
                serverLevel.addFreshEntity(challenger);
            }
        }
    }

    /**
     * 在玩家周围寻找有效的生成位置（避免卡在土里）
     */
    private static BlockPos findValidSpawnPosition(ServerLevel level, BlockPos playerPos, RandomSource random,int range) {
        // 尝试最多10次寻找有效位置
        for (int attempt = 0; attempt < 10; attempt++) {
            // 在玩家周围20×20区域内随机选择XZ坐标
            int x = playerPos.getX() + random.nextInt(2 * range + 1) - range; // -20到+20
            int z = playerPos.getZ() +  random.nextInt(2 * range + 1) - range; // -20到+20

            // 获取该坐标处的最高非空气方块
            BlockPos surfacePos = level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, new BlockPos(x, 0, z));

            // 检查方块是否可站立（实体生成在方块顶部）
            BlockState groundState = level.getBlockState(surfacePos.below());
            if (groundState.isSolidRender(level, surfacePos.below()) && // 下方方块是实体
                    !level.getBlockState(surfacePos).isSolidRender(level, surfacePos) && // 当前方块非实体
                    !level.getBlockState(surfacePos.above()).isSolidRender(level, surfacePos.above())) { // 上方方块非实体
                return surfacePos;
            }
        }
        return null; // 尝试失败，返回null
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
