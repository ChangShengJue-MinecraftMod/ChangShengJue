package com.shengchanshe.chang_sheng_jue.checkin;

import com.kfhzs.allthingsflying.AllThingsFlying;
import com.kfhzs.allthingsflying.items.Engine;
import com.kfhzs.allthingsflying.items.ItemsRegister;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.book.*;
import com.shengchanshe.chang_sheng_jue.item.items.Parcel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 签到奖励配置
 */
public class CheckInRewardConfig {

    /**
     * 奖励条目
     */
    public static class RewardEntry {
        private final ItemStack itemStack;

        public RewardEntry(ItemStack itemStack) {
            this.itemStack = itemStack;
        }

        public ItemStack getItemStack() {
            return itemStack.copy();
        }

        public ItemStack getItemStackWithMultiplier(double multiplier) {
            ItemStack result = itemStack.copy();
            int newCount = (int) Math.ceil(result.getCount() * multiplier);
            result.setCount(newCount);
            return result;
        }
    }

    private static final List<RewardEntry> REWARD_LIST = new ArrayList<>();
    private static final List<RewardEntry> WEEKEND_REWARD_LIST = new ArrayList<>();

    static {
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueBlocks.PAINTING_SCROLL.get(), 1)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get(), 1)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get(), 1)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueBlocks.BIG_PAINTING_SCROLL.get(), 1)));

        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.FEN_JIU.get(), 3)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get(), 3)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.SHI_LI_XIANG.get(), 3)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueBlocks.CANTALOUPE_BLOCK.get(), 3)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueBlocks.DURIAN.get(), 3)));

        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.LONG_JING_TEAS.get(), 3)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.BILUOCHUN_TEAS.get(), 3)));

        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.COOKED_VENISON.get(), 5)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.COOKED_PEACOCK.get(), 5)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.COOKED_CROC.get(), 5)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.BAKED_CORN.get(), 5)));

        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.PINEAPPLE.get(), 10)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.MANGO.get(), 10)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.BANANA.get(), 10)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.PEAR.get(), 10)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.LICHEE.get(), 10)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.GRAPE.get(), 10)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.MULBERRY.get(), 10)));

        REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 16)));

        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.CAKE, 1)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.GOLDEN_APPLE, 1)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.MILK_BUCKET, 1)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.PAINTING, 1)));

        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.EXPERIENCE_BOTTLE, 2)));

        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.ENDER_EYE, 3)));

        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.GOLD_INGOT, 5)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.IRON_INGOT, 5)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.COPPER_INGOT, 5)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.AMETHYST_SHARD, 5)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.LAPIS_LAZULI, 5)));

        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.RAW_IRON, 5)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.RAW_COPPER, 5)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.RAW_GOLD, 5)));

        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.WHITE_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.ORANGE_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.MAGENTA_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.LIGHT_BLUE_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.YELLOW_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.LIME_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.PINK_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.GRAY_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.LIGHT_GRAY_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.CYAN_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.PURPLE_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.BLUE_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.BROWN_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.GREEN_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.RED_DYE, 16)));
        REWARD_LIST.add(new RewardEntry(new ItemStack(Items.BLACK_DYE, 16)));

        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRONG_STRENGTH)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRONG_SWIFTNESS)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRONG_HEALING)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRONG_REGENERATION)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_FIRE_RESISTANCE)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_NIGHT_VISION)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_INVISIBILITY)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_WATER_BREATHING)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRONG_LEAPING)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_SLOW_FALLING)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_STRENGTH)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_SWIFTNESS)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_REGENERATION)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_LEAPING)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.FIRE_RESISTANCE)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.NIGHT_VISION)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.INVISIBILITY)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER_BREATHING)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.SWIFTNESS)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRENGTH)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LEAPING)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.REGENERATION)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.HEALING)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.SLOW_FALLING)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.TURTLE_MASTER)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.LONG_TURTLE_MASTER)));
        REWARD_LIST.add(new RewardEntry(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.STRONG_TURTLE_MASTER)));

        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.GOLD_BULLIONS.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.IMMORTAL_MIRACLE.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.HERCULES.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.GAO_MARKSMANSHIP.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.GE_SHAN_DA_NIU.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.TURTLE_BREATH_WORK.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.GOLDEN_BELL_JAR.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.PAODING.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.SHAOLIN_STICK_METHOD.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.XUANNU_SWORDSMANSHIP.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.ZHANG_MEN_XIN_XUE.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get(), 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get(), 1)));

        WEEKEND_REWARD_LIST.add(new RewardEntry(Parcel.createCottonParcel()));
        WEEKEND_REWARD_LIST.add(new RewardEntry(Parcel.createMountainParcel()));
        WEEKEND_REWARD_LIST.add(new RewardEntry(Parcel.createMingguangParcel()));
        WEEKEND_REWARD_LIST.add(new RewardEntry(Parcel.createQitianParcel()));
        WEEKEND_REWARD_LIST.add(new RewardEntry(Parcel.createMaleTaoistParcel()));
        WEEKEND_REWARD_LIST.add(new RewardEntry(Parcel.createFemaleTaoistParcel()));
        WEEKEND_REWARD_LIST.add(new RewardEntry(Parcel.createMaleWeddingDressParcel()));
        WEEKEND_REWARD_LIST.add(new RewardEntry(Parcel.createFemaleWeddingDressParcel()));

        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), 3)));

        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(Items.DIAMOND, 3)));

        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ChangShengJueItems.GANG_TOKEN.get(), 5)));

        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(Items.NETHER_STAR, 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(Items.GOLDEN_CARROT, 1)));
        WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 1)));

        if (ModList.get().isLoaded("allthingsflying")) {
            WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ItemsRegister.AERO_ENGINE.get(), 1)));
            WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ItemsRegister.THERMAL_ENGINE.get(), 1)));
            WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ItemsRegister.MAGIC_ENGINE.get(), 1)));
            WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ItemsRegister.DRONE_ENGINE.get(), 1)));
            WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ItemsRegister.CLOUD_ENGINE.get(), 1)));
            WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ItemsRegister.FLIGHT_GIFT_PACKAGE.get(), 1)));

            WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ItemsRegister.UPGRADE_CORE.get(), 2)));
            WEEKEND_REWARD_LIST.add(new RewardEntry(new ItemStack(ItemsRegister.HEAVY_UPGRADE_CORE.get(), 1)));
        }

    }

    /**
     * 获取指定索引的奖励
     */
    public static RewardEntry getReward(int index) {
        if (index >= 5) {
            if (WEEKEND_REWARD_LIST.isEmpty()) {
                return new RewardEntry(new ItemStack(Items.EMERALD, 1));
            }
            int actualIndex = index % WEEKEND_REWARD_LIST.size();
            return WEEKEND_REWARD_LIST.get(actualIndex);
        } else {
            if (REWARD_LIST.isEmpty()) {
                return new RewardEntry(new ItemStack(Items.EMERALD, 1));
            }
            int actualIndex = index % REWARD_LIST.size();
            return REWARD_LIST.get(actualIndex);
        }
    }

    /**
     * 从指定天数的奖励池中获取指定位置的奖励
     * @param dayIndex 天数索引 (0-6)
     * @param poolIndex 奖励池内的索引
     */
    public static RewardEntry getRewardFromPool(int dayIndex, int poolIndex) {
        if (dayIndex >= 5) {
            if (WEEKEND_REWARD_LIST.isEmpty()) {
                return new RewardEntry(new ItemStack(Items.EMERALD, 1));
            }
            int actualIndex = poolIndex % WEEKEND_REWARD_LIST.size();
            return WEEKEND_REWARD_LIST.get(actualIndex);
        } else {
            if (REWARD_LIST.isEmpty()) {
                return new RewardEntry(new ItemStack(Items.EMERALD, 1));
            }
            int actualIndex = poolIndex % REWARD_LIST.size();
            return REWARD_LIST.get(actualIndex);
        }
    }

    /**
     * 获取今日随机奖励(使用PlayerCheckInData保存的随机索引)
     * @param dayIndex 天数索引 (0-6)
     * @param randomIndex 随机索引
     */
    public static ItemStack getTodayRandomReward(int dayIndex, int randomIndex) {
        return getRewardFromPool(dayIndex, randomIndex).getItemStack();
    }

    /**
     * 获取奖励列表大小
     */
    public static int getRewardListSize() {
        return REWARD_LIST.size();
    }

    public static int getWeekendRewardListSize() {
        return WEEKEND_REWARD_LIST.size();
    }

    public static int getRewardListSize(int dayIndex) {
        return dayIndex >= 5 ? WEEKEND_REWARD_LIST.size() : REWARD_LIST.size();
    }

    /**
     * 添加自定义奖励(可用于配置)
     */
    public static void addReward(ItemStack itemStack) {
        REWARD_LIST.add(new RewardEntry(itemStack));
    }

    /**
     * 清空奖励列表
     */
    public static void clearRewards() {
        REWARD_LIST.clear();
    }

    /**
     * 获取下一个奖励(不应用倍数)
     */
    public static ItemStack getNextReward(int currentIndex) {
        return getReward(currentIndex + 1).getItemStack();
    }

    /**
     * 获取当前奖励(应用倍数)
     */
    public static ItemStack getCurrentRewardWithMultiplier(int currentIndex, double multiplier) {
        return getReward(currentIndex).getItemStackWithMultiplier(multiplier);
    }
}
