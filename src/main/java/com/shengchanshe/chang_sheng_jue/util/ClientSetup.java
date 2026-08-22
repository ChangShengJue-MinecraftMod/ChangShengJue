package com.shengchanshe.chang_sheng_jue.util;

import com.shengchanshe.chang_sheng_jue.cilent.setup.ClientColorRegistrar;
import com.shengchanshe.chang_sheng_jue.cilent.network.ClientPacketHandlers;
import com.shengchanshe.chang_sheng_jue.cilent.setup.ClientItemPropertyRegistrar;
import com.shengchanshe.chang_sheng_jue.cilent.setup.ClientMenuRegistrar;
import com.shengchanshe.chang_sheng_jue.cilent.setup.ClientRendererRegistrar;
import com.shengchanshe.chang_sheng_jue.cilent.setup.ClientRenderTypeRegistrar;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ClientSetup {
    // 所有需要注册颜色渲染器的物品的集合
    public static final List<Supplier<? extends Item>> ARMOR_ITEMS = Arrays.asList(
            ChangShengJueItems.COTTON_HELMET,
            ChangShengJueItems.WHITE_COTTON_HELMET,
            ChangShengJueItems.COTTON_CHESTPLATE,
            ChangShengJueItems.COTTON_LEGGINGS,
            ChangShengJueItems.COTTON_BOOTS,

            ChangShengJueItems.FEMALE_TAOIST_HELMET,
            ChangShengJueItems.FEMALE_TAOIST_CHESTPLATE,
            ChangShengJueItems.MALE_TAOIST_HELMET,
            ChangShengJueItems.MALE_TAOIST_CHESTPLATE,
            ChangShengJueItems.TAOIST_BOOTS,

            ChangShengJueItems.TAOIST_LEGGINGS,

            ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_BLACK_GAUZE_CAP,
            ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_KYLIN_BUFU,
            ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_PHOENIX_CORONET,
            ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_QUEEN_CLOTHING,
            ChangShengJueItems.CHINESE_WEDDING_DRESS_GOLDEN_THREAD_SHOES,

            ChangShengJueItems.SIDE_FASTENING_LEATHER_HELMET,
            ChangShengJueItems.SIDE_FASTENING_LEATHER_CHESTPLATE,

            ChangShengJueItems.OUTER_ROBE_HELMET,
            ChangShengJueItems.OUTER_ROBE_CHESTPLATE,

            ChangShengJueItems.FLY_FISH_CLOUD_VEIL_CROWN,
            ChangShengJueItems.FLY_FISH_CHESTPLATE,
            ChangShengJueItems.FLY_FISH_LONG_BOOTS,

            ChangShengJueItems.CONFUCIAN_HELMET,
            ChangShengJueItems.CONFUCIAN_INK_CHESTPLATE,
            ChangShengJueItems.CONFUCIAN_INK_LEGGINGS,
            ChangShengJueItems.CONFUCIAN_INK_BOOTS,

            ChangShengJueItems.CONSTABLE_UNIFORM_HELMET,
            ChangShengJueItems.CONSTABLE_UNIFORM_CHESTPLATE,
            ChangShengJueItems.CONSTABLE_UNIFORM_LEGGINGS,
            ChangShengJueItems.CONSTABLE_UNIFORM_BOOTS,


            ChangShengJueItems.HATS_WITH_VEIL_HELMET,
            ChangShengJueItems.HATS_WITH_VEIL_CHESTPLATE,

            ChangShengJueItems.HATS_BLACK_ROBE_HELMET,
            ChangShengJueItems.HATS_BLACK_ROBE_CHESTPLATE,
            ChangShengJueItems.HATS_BLACK_ROBE_LEGGINGS,

            ChangShengJueItems.DUAN_DA_CHESTPLATE,
            ChangShengJueItems.BUDDHIST_ROBE_CHESTPLATE,

            ChangShengJueItems.FOREHEAD_BAND_HELMET1,
            ChangShengJueItems.FOREHEAD_BAND_HELMET2,
            ChangShengJueItems.HAIR_CROWN_HELMET1,
            ChangShengJueItems.HAIR_CROWN_HELMET2,
            ChangShengJueItems.NIGHT_SUIT_HELMET,
            ChangShengJueItems.NIGHT_SUIT_CHESTPLATE,
            ChangShengJueItems.LONG_GOWN_CHESTPLATE,
            ChangShengJueItems.NIGHT_SUIT_LEGGINGS,
            ChangShengJueItems.PLEATED_SKIRT_CHESTPLATE,
            ChangShengJueItems.PLEATED_SKIRT_LEGGINGS,
            ChangShengJueItems.MAGUA_ROBE_SUIT_HELMET,
            ChangShengJueItems.MAGUA_ROBE_SUIT_CHESTPLATE,
            ChangShengJueItems.QING_OFFICIAL_SUIT_HELMET,
            ChangShengJueItems.QING_OFFICIAL_SUIT_CHESTPLATE,
            ChangShengJueItems.QING_PRINCE_SUIT_CHESTPLATE,
            ChangShengJueItems.QING_SOLDIER_ARMOR_CHESTPLATE
    );

    public static void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            TooltipInput.installShiftStateSupplier(Screen::hasShiftDown);
            ClientPacketHandlers.register();
            ClientRenderTypeRegistrar.register();
            ClientColorRegistrar.register();
            ClientMenuRegistrar.register();
            ClientRendererRegistrar.register();
        });
        ClientItemPropertyRegistrar.register(event);
    }
}
