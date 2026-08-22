package com.shengchanshe.chang_sheng_jue.event;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.ChangShengJueConfig;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.bandit.Bandit;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.challenger.Challenger;
import com.shengchanshe.chang_sheng_jue.init.CSJAdvanceInit;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID)
public class CSJAdvanceEvent {
    private static final int INVENTORY_CHECK_INTERVAL = 20;
    private static final int BANDIT_COOLDOWN_DAYS = 4;
    private static final int MAX_BANDIT_SUMMONS = 3;
    private static final String LAST_BANDIT_ATTEMPT_DAY = ChangShengJue.MOD_ID + ":last_bandit_attempt_day";
    private static final String NEXT_BANDIT_DAY = ChangShengJue.MOD_ID + ":next_bandit_day";
    private static final String BANDIT_SUMMON_COUNT = ChangShengJue.MOD_ID + ":bandit_summon_count";

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END
                && event.player instanceof ServerPlayer serverPlayer
                && serverPlayer.tickCount % INVENTORY_CHECK_INTERVAL == 0) {
            checkForItem(serverPlayer);
        }
    }

    private static void checkForItem(ServerPlayer player) {
        boolean hasQiTianHelmet = false;
        boolean hasQiTianChestplate = false;
        boolean hasQiTianLeggings = false;
        boolean hasQiTianBoots = false;
        tryDailyBanditSpawn(player);


        for (ItemStack itemStack : player.getInventory().items) {
            Item item = itemStack.getItem();
                if (item == ChangShengJueItems.MI_FAN.get()) {
                    CSJAdvanceInit.HAS_MI_FAN.trigger(player);//人是铁饭是钢
                }else if (item == ChangShengJueItems.SILVER_BULLIONS.get()) {
                    CSJAdvanceInit.HAS_SILVER_BULLIONS.trigger(player);//银华熠熠
                }else if (item == ChangShengJueItems.GOLD_BULLIONS.get()) {
                    CSJAdvanceInit.HASGOLD_BULLIONS.trigger(player);//金光闪闪
                }else if (item == ChangShengJueItems.BA_BAO_ZHOU.get()){
                    CSJAdvanceInit.HAS_BA_BAO_ZHOU.trigger(player);//吉祥如意
                }else if(item == ChangShengJueItems.GUI_HUA_TANG_OU.get()){
                    CSJAdvanceInit.HAS_GUI_HUA_TANG_OU.trigger(player);//甜蜜蜜
                }else if (item == ChangShengJueItems.BRONZE_SWORD.get()) {
                    CSJAdvanceInit.HAS_BRONZE_SWORD.trigger(player);//侠客行
                }else if (item == ChangShengJueItems.LICHEE.get()) {
                    CSJAdvanceInit.HAS_LICHEE.trigger(player);//似是妃子笑
                }else if (item == ChangShengJueItems.BILUOCHUN_TEAS.get()
                        || item == ChangShengJueItems.LONG_JING_TEAS.get()) {
                    CSJAdvanceInit.HAS_TEA.trigger(player);//习习清风生
                }else if (item == ChangShengJueItems.SHI_LI_XIANG.get()
                        || item == ChangShengJueItems.FEN_JIU.get()
                        || item == ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get()) {
                    CSJAdvanceInit.HAS_WINE.trigger(player);//对酒当歌
                }else if (item == ChangShengJueItems.TOMATO_EGG.get()) {
                    CSJAdvanceInit.HAS_TOMATO_EGG.trigger(player);//家常小炒
                }else if (item == ChangShengJueItems.TU_LONG_DAO.get()
                        || item == ChangShengJueItems.YI_TIAN_JIAN.get()
                        || item == ChangShengJueItems.BA_WANG_QIANG.get()
                        || item == ChangShengJueItems.BEAT_DOG_STICK.get()) {
                    CSJAdvanceInit.HAS_SWORD.trigger(player);//四大神器
                }else if (item == Items.LEATHER_CHESTPLATE
                        || item == ChangShengJueItems.FEMALE_TAOIST_CHESTPLATE.get()
                        || item == ChangShengJueItems.MALE_TAOIST_CHESTPLATE.get()
                        || item == ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_KYLIN_BUFU.get()
                        || item == ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_QUEEN_CLOTHING.get()
                        || item == ChangShengJueItems.CONFUCIAN_INK_CHESTPLATE.get()){
                    CSJAdvanceInit.HAS_ARMOR.trigger(player);
                }else if (item == ChangShengJueItems.COTTON_CHESTPLATE.get()
                        || item == ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR.get()
                        || item == ChangShengJueItems.FLY_FISH_CHESTPLATE.get()
                        || item == ChangShengJueItems.WALKER_CHESTPLATE.get()
                        || item == ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LIGHT_CHESTPLATE.get()) {
                    CSJAdvanceInit.HAS_ADVANCED_ARRMOR.trigger(player);
                }else if (item == ChangShengJueItems.PHOENIX_FEATHER_CAP.get()) {
                    hasQiTianHelmet = true;
                }else if (item == ChangShengJueItems.OLDEN_CHAIN_MAIL_SHIRT.get()){
                    hasQiTianChestplate = true;
                }else if (item == ChangShengJueItems.TIGER_SKIN_GARMENT.get()) {
                    hasQiTianLeggings = true;
                }else if (item == ChangShengJueItems.CLOUD_WALKING_BOOTS.get()) {
                    hasQiTianBoots = true;
                }else if (item == ChangShengJueItems.GANG_TOKEN.get() && itemStack.getCount() == 64) {
                    CSJAdvanceInit.A_GROUP_GANG_TOKEN.trigger(player);
                }
        }
        if (hasQiTianHelmet && hasQiTianChestplate && hasQiTianLeggings && hasQiTianBoots) {
            CSJAdvanceInit.HAS_QI_TIAN.trigger(player);
        }
    }

    private static void tryDailyBanditSpawn(ServerPlayer player) {
        CompoundTag data = getBanditData(player);
        long currentDay = player.level().getDayTime() / 24000L;
        long lastAttemptDay = data.contains(LAST_BANDIT_ATTEMPT_DAY, Tag.TAG_LONG)
                ? data.getLong(LAST_BANDIT_ATTEMPT_DAY) : Long.MIN_VALUE;
        if (lastAttemptDay == currentDay) {
            return;
        }
        data.putLong(LAST_BANDIT_ATTEMPT_DAY, currentDay);

        long nextEligibleDay = data.getLong(NEXT_BANDIT_DAY);
        boolean hasTribute = player.getInventory().countItem(ChangShengJueItems.YI_GUAN_TONG_QIAN.get()) >= 9
                || player.getInventory().countItem(ChangShengJueItems.SILVER_BULLIONS.get()) >= 3
                || player.getInventory().countItem(ChangShengJueItems.GOLD_BULLIONS.get()) >= 1;
        if (hasTribute && currentDay >= nextEligibleDay && trySummonBandit(player.serverLevel(), player)) {
            data.putLong(NEXT_BANDIT_DAY, currentDay + BANDIT_COOLDOWN_DAYS);
        }
    }

    public static void summonBandit(Level level, Player player) {
        if (level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer) {
            trySummonBandit(serverLevel, serverPlayer);
        }
    }

    private static boolean trySummonBandit(ServerLevel serverLevel, ServerPlayer player) {
        if (!ChangShengJueConfig.ENABLE_BANDIT_SPAWN.get()) {
            return false;
        }
        CompoundTag data = getBanditData(player);
        int summonCount = data.getInt(BANDIT_SUMMON_COUNT);
        if (summonCount >= MAX_BANDIT_SUMMONS) {
            return false;
        }
        BlockPos pos = player.blockPosition();
        BlockPos playerPos = player.blockPosition();
        RandomSource random = serverLevel.getRandom();
        boolean spawned = false;
        if (random.nextInt(100) <= 20) {
            int numberOfBandits = random.nextInt(3) + 1;
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
                bandit.moveTo(spawnPos, random.nextFloat() * 360.0F, 0.0F);
                bandit.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(pos),
                        MobSpawnType.EVENT, null, null);
                if (serverLevel.addFreshEntity(bandit)) {
                    spawned = true;
                }
            }
        }
        if (spawned) {
            data.putInt(BANDIT_SUMMON_COUNT, summonCount + 1);
        }
        return spawned;
    }

    static CompoundTag getBanditData(Player player) {
        CompoundTag entityData = player.getPersistentData();
        CompoundTag persisted = entityData.contains(Player.PERSISTED_NBT_TAG, Tag.TAG_COMPOUND)
                ? entityData.getCompound(Player.PERSISTED_NBT_TAG)
                : new CompoundTag();
        migrateLegacyLong(entityData, persisted, LAST_BANDIT_ATTEMPT_DAY);
        migrateLegacyLong(entityData, persisted, NEXT_BANDIT_DAY);
        migrateLegacyInt(entityData, persisted, BANDIT_SUMMON_COUNT);
        entityData.put(Player.PERSISTED_NBT_TAG, persisted);
        return persisted;
    }

    private static void migrateLegacyLong(CompoundTag entityData, CompoundTag persisted, String key) {
        if (!persisted.contains(key, Tag.TAG_ANY_NUMERIC) && entityData.contains(key, Tag.TAG_ANY_NUMERIC)) {
            persisted.putLong(key, entityData.getLong(key));
        }
        entityData.remove(key);
    }

    private static void migrateLegacyInt(CompoundTag entityData, CompoundTag persisted, String key) {
        if (!persisted.contains(key, Tag.TAG_ANY_NUMERIC) && entityData.contains(key, Tag.TAG_ANY_NUMERIC)) {
            persisted.putInt(key, entityData.getInt(key));
        }
        entityData.remove(key);
    }

    public static void summonChallenger(Level level, Player player) {
        // 仅在服务端执行实体生成逻辑
        if (level.isClientSide()) {
            return;
        }
        ServerLevel serverLevel = (ServerLevel) level;
        BlockPos playerPos = player.blockPosition();
        RandomSource random = serverLevel.getRandom();

        if (random.nextInt(100) <= 20) {
            int numberOfChallengers = 1;

            for (int i = 0; i < numberOfChallengers; i++) {
                // 尝试寻找有效生成位置（避免实体卡在方块中）
                BlockPos spawnPos = findValidSpawnPosition(serverLevel, playerPos, random, 5);

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

    public static void CheckLevel(int level, ServerPlayer player, int count, int maxLevel){
        if (level >= 1){
            CheckLevel(level, player, maxLevel);
        }
        if(count == 1){
            CSJAdvanceInit.USE_WAI_GONG.trigger(player);
        }
    }
    public static void CheckLevel(int level, ServerPlayer player, int maxLevel){
        if(level == 1) {
            CSJAdvanceInit.MATER_GONG_FA.trigger(player);
        }else if(level >= maxLevel){
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
