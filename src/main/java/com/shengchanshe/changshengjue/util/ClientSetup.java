package com.shengchanshe.changshengjue.util;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.client.render.*;
import com.shengchanshe.changshengjue.entity.client.render.combat.ge_shan_da_niu.GeShanDaNiuRender;
import com.shengchanshe.changshengjue.entity.client.render.combat.stakes.StakesRender;
import com.shengchanshe.changshengjue.entity.combat.dugu_nine_swords.DuguNineSwordsEntityRender;
import com.shengchanshe.changshengjue.entity.client.render.combat.throwingknives.ThrowingKnivesEntityEntityRender;
import com.shengchanshe.changshengjue.entity.combat.golden_black_knife_method.GoldenBlackKnifeMethodEntityRender;
import com.shengchanshe.changshengjue.entity.villagers.render.ChangShengJueVillagerRender;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.armor.DyeableChineseWeddingDressItem;
import com.shengchanshe.changshengjue.item.combat.armor.DyeableItem;
import com.shengchanshe.changshengjue.screen.ChangShengJueMenuTypes;
import com.shengchanshe.changshengjue.screen.plaque.PlaqueScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ClientSetup {
    // 假设你有一个包含所有需要注册颜色渲染器的物品的集合
    static List<Supplier<? extends Item>> cottonArmorItems = Arrays.asList(
            ChangShengJueItems.COTTON_ARMOR_FEATHER_HELMET,
            ChangShengJueItems.COTTON_ARMOR_WHITE_FEATHER_HELMET,
            ChangShengJueItems.COTTON_ARMOR_CHESTPLATE,
            ChangShengJueItems.COTTON_ARMOR_LEGGINGS,
            ChangShengJueItems.COTTON_ARMOR_BOOTS,

            ChangShengJueItems.FEMALE_TAOIST_ROBES_HELMET,
            ChangShengJueItems.FEMALE_TAOIST_ROBES_CHESTPLATE,
            ChangShengJueItems.MALE_TAOIST_ROBES_HELMET,
            ChangShengJueItems.MALE_TAOIST_ROBES_CHESTPLATE,
            ChangShengJueItems.TAOIST_ROBES_BOOTS,

            ChangShengJueItems.SILK_LEGGINGS,

            ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_HELMET,
            ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_CHESTPLATE,
            ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_HELMET,
            ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_CHESTPLATE,
            ChangShengJueItems.CHINESE_WEDDING_DRESS_BOOTS,

            ChangShengJueItems.FLYING_FISH_ROBE_HELMET_1,
            ChangShengJueItems.FLYING_FISH_ROBE_CHESTPLATE,
            ChangShengJueItems.FLYING_FISH_ROBE_BOOTS
    );
    public static void clientSetup(final FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PINEAPPLE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SOYBEAN_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TOMATO_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GU_ZI_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SORGHUM_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LOTUS_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.REDBEAN_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.COTTON_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.STICKYRICE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CORN_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JALAPENOS_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PEANUT_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BRINJAL_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRAPE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RICE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BILUOCHUN_TEA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_JING_TEA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HORDEUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WILDLIFE_HORDEUM.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CANTALOUPE_STEM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ATTACHED_CANTALOUPE_STEM.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGO_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGO_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GUI_HUA_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GUI_HUA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_HUA_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_HUA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BANANA_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BANANA_FRUIT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BANANA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PEAR_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.POPLAR_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.POPLAR_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.POPLAR_DEFOLIATION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MULBERRY_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MULBERRY_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PEAR_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LICHEE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LICHEE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DURIAN_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DURIAN_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MUGWORT_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CUCKOO_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JASMINE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TAN_HUA_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CAPSULE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.STIPA_GRANDIS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TALL_STIPA_GRANDIS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TALL_STIPA_GRANDIS_VARIANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_KNOTWEED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_RED_KNOTWEED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RAPE_FLOWERS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SOLIDAGO.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GEUM_TRIFLORUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_DANDELION.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.STONE_LAMPS_BLOCK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZHU_TAI_BLOCK.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_OAK_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_OAK_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK_1.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_BIRCH_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_ACACIA_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_DARK_OAK_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_OAK_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_SPRUCE_BLOCK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_3.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_TILE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TILE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TILE_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TILE_BLOCK_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TILE_BLOCK_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TILE_BLOCK_4.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_ACACIA_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_DARK_OAK_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_OAK_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_SPRUCE_BLOCK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.POTTERY_WHEEL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DESK.get(), RenderType.cutout());

        ItemColors itemColors = Minecraft.getInstance().getItemColors();
        // 为每个物品注册颜色渲染器
        for (Supplier<? extends Item> itemSupplier : cottonArmorItems) {
            itemColors.register((stack, color) -> {
                if (color == 1 && stack.getItem() instanceof DyeableItem dyeable) {
                    // color == 1 表示这是覆盖层
                    return dyeable.hasCustomColor(stack) ? dyeable.getColor(stack) : dyeable == ChangShengJueItems.MALE_TAOIST_ROBES_HELMET.get() ? 0x000000 : 0xFFFFFF;
                }else if (color == 1 && stack.getItem() instanceof DyeableChineseWeddingDressItem dyeable){
                    // color == 1 表示这是覆盖层
                    return dyeable.hasCustomColor(stack) ? dyeable.getColor(stack) : 0xC81717;
                }else {
                    return 0xFFFFFF;
                }
            }, itemSupplier.get());
        }


        MenuScreens.register(ChangShengJueMenuTypes.PLAQUE_MENU.get(), PlaqueScreen::new);

        EntityRenderers.register(ChangShengJueEntity.BUTTERFLY_ENTITY.get(), ButterflyRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.MONKEY_ENTITY.get(), MonkeyRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.DRAGONFLY_ENTITY.get(), DragonflyRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CICADA_ENTITY.get(), CicadaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CRANE_ENTITY.get(), CraneRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.MALE_PEACOCK_ENTITY.get(), MalePeacockRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.FEMALE_PEACOCK_ENTITY.get(), FemalePeacockRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.STAG_ENTITY.get(), StagRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.HIND_ENTITY.get(), HindRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.TIGER_ENTITY.get(), TigerRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CROC_ENTITY.get(), CrocRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER.get(), ChangShengJueVillagerRender::new);

        EntityRenderers.register(ChangShengJueEntity.THROWING_KNIVES_ENTITY.get(), ThrowingKnivesEntityEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.GE_SHAN_DA_NIU.get(), GeShanDaNiuRender::new);

        EntityRenderers.register(ChangShengJueEntity.DUGU_NINE_SOWRDS_ENTITY.get(), DuguNineSwordsEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.GOLDEN_BLACK_KNIFE_METHOD_ENTITY.get(), GoldenBlackKnifeMethodEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.STAKES.get(), StakesRender::new);
    }
}
