package com.shengchanshe.chang_sheng_jue.item.items;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.cotton.CottonArmor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public class Parcel extends Item {
    // 包裹类型枚举
    public enum ParcelType {
        COTTON_ARMOR,
        MOUNTAIN_PATTERN,
        MINGGUANG_ARMOR,
        QI_TIAN_DA_SHENG,
        MALE_TAOIST,
        FEMALE_TAOIST,
        MALE_WEDDING_DRESS,
        FEMALE_WEDDING_DRESS,
    }

    // NBT标签键
    private static final String TYPE_TAG = "ParcelType";
    private static final RandomSource RANDOM = RandomSource.create();

    // 各类型包含的物品
    private static final List<Supplier<Item>>[] PARCEL_CONTENTS = new List[ParcelType.values().length];

    public Parcel() {
        super(new Item.Properties().stacksTo(1));
    }

    // 创建指定类型的包裹
    public static ItemStack createParcel(ParcelType type) {
        ItemStack stack = new ItemStack(ChangShengJueItems.ARMOR_PARCEL.get());
        CompoundTag tag = stack.getOrCreateTag();
        tag.putInt(TYPE_TAG, type.ordinal());
        return stack;
    }

    private ParcelType getParcelType(ItemStack stack) {
        if (!stack.hasTag() || !stack.getTag().contains(TYPE_TAG)) {
            return ParcelType.COTTON_ARMOR;
        }
        int typeOrdinal = stack.getTag().getInt(TYPE_TAG);
        return ParcelType.values()[typeOrdinal];
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            ParcelType type = getParcelType(stack);
            List<Supplier<Item>> contents = PARCEL_CONTENTS[type.ordinal()];

            for (Supplier<Item> itemSupplier : contents) {
                ItemStack itemStack = new ItemStack(itemSupplier.get());
                if (stack.hasTag() && stack.getTag().getBoolean("ForceGolden")) {
                    if (itemStack.getItem() instanceof CottonArmor cottonArmor) {
                        cottonArmor.setColor(itemStack, 0xFFD700);
                    }
                }
                if (!player.addItem(itemStack)) {
                    Containers.dropItemStack(level, player.getX(), player.getY(), player.getZ(), itemStack);
                }
            }

            stack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

//    @Override
//    public void appendHoverText(ItemStack stack, @Nullable Level level,
//                                List<Component> tooltip, TooltipFlag flag) {
//        ParcelType type = getParcelType(stack);
//        tooltip.add(Component.translatable("tooltip.armor_parcel.type." + type.name().toLowerCase())
//                .withStyle(ChatFormatting.GRAY));
//    }

    @Override
    public String getDescriptionId(ItemStack stack) {
        ParcelType type = getParcelType(stack);
        return "item."+ ChangShengJue.MOD_ID +".armor_parcel." + type.name().toLowerCase();
    }
    // 获取所有包裹
    public static Collection<ItemStack> createParcel() {
        return new ArrayList<>(Arrays.asList(createCottonParcel(), createMountainParcel(),
                createMingguangParcel(), createQitianParcel(),
                createMaleTaoistParcel(), createFemaleTaoistParcel(),
                createMaleWeddingDressParcel(), createFemaleWeddingDressParcel()));
    }

    // 包裹创建快捷方法
    public static ItemStack createCottonParcel() {
        return Parcel.createParcel(Parcel.ParcelType.COTTON_ARMOR);
    }

    public static ItemStack createMountainParcel() {
        return Parcel.createParcel(Parcel.ParcelType.MOUNTAIN_PATTERN);
    }

    public static ItemStack createMingguangParcel() {
        return Parcel.createParcel(Parcel.ParcelType.MINGGUANG_ARMOR);
    }

    public static ItemStack createQitianParcel() {
        return Parcel.createParcel(Parcel.ParcelType.QI_TIAN_DA_SHENG);
    }

    public static ItemStack createMaleTaoistParcel() {
        return Parcel.createParcel(ParcelType.MALE_TAOIST);
    }

    public static ItemStack createFemaleTaoistParcel() {
        return Parcel.createParcel(ParcelType.FEMALE_TAOIST);
    }

    public static ItemStack createMaleWeddingDressParcel() {
        return Parcel.createParcel(ParcelType.MALE_WEDDING_DRESS);
    }

    public static ItemStack createFemaleWeddingDressParcel() {
        return Parcel.createParcel(ParcelType.FEMALE_WEDDING_DRESS);
    }

    static {
        // 初始化包裹内容
        PARCEL_CONTENTS[ParcelType.COTTON_ARMOR.ordinal()] = Arrays.asList(
                () -> RANDOM.nextBoolean() ? ChangShengJueItems.COTTON_HELMET.get() : ChangShengJueItems.WHITE_COTTON_HELMET.get(),
                ChangShengJueItems.COTTON_CHESTPLATE,
                ChangShengJueItems.COTTON_LEGGINGS,
                ChangShengJueItems.COTTON_BOOTS
        );

        PARCEL_CONTENTS[ParcelType.MOUNTAIN_PATTERN.ordinal()] = Arrays.asList(
                ChangShengJueItems.MOUNTAIN_PATTERN_HELMET_GUN_HOOD,
                ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR,
                ChangShengJueItems.MOUNTAIN_PATTERN_DEERSKIN_TIBIAL_ARMOR,
                ChangShengJueItems.MOUNTAIN_PATTERN_CLOUD_BLACK_BOOTS
        );

        PARCEL_CONTENTS[ParcelType.MINGGUANG_ARMOR.ordinal()] = Arrays.asList(
                ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_PHOENIX_WINGS_HELMET,
                ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LIGHT_CHESTPLATE,
                ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LAZULI_KNEE_PADS,
                ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_ANIMAL_SKIN_BOOTS
        );

        PARCEL_CONTENTS[ParcelType.QI_TIAN_DA_SHENG.ordinal()] = Arrays.asList(
                ChangShengJueItems.PHOENIX_FEATHER_CAP,
                ChangShengJueItems.OLDEN_CHAIN_MAIL_SHIRT,
                ChangShengJueItems.TIGER_SKIN_GARMENT,
                ChangShengJueItems.CLOUD_WALKING_BOOTS
        );

        PARCEL_CONTENTS[ParcelType.MALE_TAOIST.ordinal()] = Arrays.asList(
                ChangShengJueItems.MALE_TAOIST_HELMET,
                ChangShengJueItems.MALE_TAOIST_CHESTPLATE,
                ChangShengJueItems.TAOIST_LEGGINGS,
                ChangShengJueItems.TAOIST_BOOTS
        );
        PARCEL_CONTENTS[ParcelType.FEMALE_TAOIST.ordinal()] = Arrays.asList(
                ChangShengJueItems.FEMALE_TAOIST_HELMET,
                ChangShengJueItems.FEMALE_TAOIST_CHESTPLATE,
                ChangShengJueItems.TAOIST_LEGGINGS,
                ChangShengJueItems.TAOIST_BOOTS
        );

        PARCEL_CONTENTS[ParcelType.MALE_WEDDING_DRESS.ordinal()] = Arrays.asList(
                ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_BLACK_GAUZE_CAP,
                ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_KYLIN_BUFU,
                ChangShengJueItems.TAOIST_LEGGINGS,
                ChangShengJueItems.CHINESE_WEDDING_DRESS_GOLDEN_THREAD_SHOES
        );
        PARCEL_CONTENTS[ParcelType.FEMALE_WEDDING_DRESS.ordinal()] = Arrays.asList(
                ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_PHOENIX_CORONET,
                ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_QUEEN_CLOTHING,
                ChangShengJueItems.TAOIST_LEGGINGS,
                ChangShengJueItems.CHINESE_WEDDING_DRESS_GOLDEN_THREAD_SHOES
        );

    }
}