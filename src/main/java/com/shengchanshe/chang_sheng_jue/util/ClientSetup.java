package com.shengchanshe.chang_sheng_jue.util;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.ChangShengJueMenuTypes;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.forgeblock.ForgeBlockScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.plaque.PlaqueScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.tailoringcase.TailoringCaseScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.blacksmith.BlacksmithScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangQuestsScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangleaderTradingScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.innkeeper.InnkeeperScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest.PlayerQuestScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.worker.KilnWorkerScreen;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.combat.beat_dog_stick.BeatDogStickAttackEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.dugu_nine_swords.DuguNineSwordsEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.ge_shan_da_niu.GeShanDaNiuRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.golden_black_knife_method.GoldenBlackKnifeMethodEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.lance.BaWangQiangAttackEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.lance.ThrownBaWangQiangRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.lance.ThrownRedTasselledSpearRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.stakes.StakesRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.throwingknives.ThrowingKnivesEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.tu_long_dao.TuLongDaoAttackEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.combat.yi_tian_jian.YiTianJianAttackEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.custom.butterfly.ButterflyRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.cicada.CicadaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.crane.CraneRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.croc.CrocRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.deer.hind.HindRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.deer.stag.StagRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.dragonfly.DragonflyRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.monkey.MonkeyRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.peacock.female.FemalePeacockRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.peacock.male.MalePeacockRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.tiger.TigerRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.assassin.AssassinRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.bandit.BanditRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.blacksmith.BlacksmithRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.challenger.ChallengerRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.evoker.EvokerWuXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.clubbed.ClubbedGangLeaderRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.knife.KnifeGangLeaderRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.lance.LanceGangLeaderRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.other.GangLeaderRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.sword.SwordGangLeaderRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.innkeeper.female.FemaleInnkeeperRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.innkeeper.male.MaleInnkeeperRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.piglin.PiglinWuXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.pillager.PillagerWuXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.villain.VillainRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.vindicator.VindicatorWuXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.witch.WitchWuXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.xia.clubbed.ClubbedMingXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.xia.fist.FistMingXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.xia.knife.KnifeMingXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.xia.sword.SwordMingXiaRenderer;
import com.shengchanshe.chang_sheng_jue.entity.villagers.render.ChangShengJueVillagerRender;
import com.shengchanshe.chang_sheng_jue.entity.villagers.warrior.WarriorRenderer;
import com.shengchanshe.chang_sheng_jue.entity.villagers.worker.KilnWorkerRenderer;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.DyeableItem;
import com.shengchanshe.chang_sheng_jue.item.combat.lance.Lance;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
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

            ChangShengJueItems.FLY_FISH_CLOUD_VEIL_CROWN,
            ChangShengJueItems.FLY_FISH_CHESTPLATE,
            ChangShengJueItems.FLY_FISH_LONG_BOOTS,

            ChangShengJueItems.HENG_DAO,

            ChangShengJueItems.CONFUCIAN_HELMET,
            ChangShengJueItems.CONFUCIAN_INK_CHESTPLATE,
            ChangShengJueItems.CONFUCIAN_INK_LEGGINGS,
            ChangShengJueItems.CONFUCIAN_INK_BOOTS,

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
            ChangShengJueItems.NIGHT_SUIT_LEGGINGS
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
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RICE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BILUOCHUN_TEA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_JING_TEA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HORDEUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WILDLIFE_HORDEUM.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CANTALOUPE_STEM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ATTACHED_CANTALOUPE_STEM.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGO_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGO_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OSMANTHUS_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OSMANTHUS_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OSMANTHUS_DEFOLIATION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PLUM_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PLUM_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PLUM_DEFOLIATION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_LEAVES.get(),  RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WENGE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WENGE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_SAPLING.get(), RenderType.cutout());
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

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZHU_TAI.get(), RenderType.translucent());

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

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_BIRCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_ACACIA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_DARK_OAK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_OAK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_SPRUCE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_5.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_5.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_5.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_5.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_5.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_6.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_6.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_6.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_6.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_6.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_7.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_8.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_8.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_8.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_8.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_8.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE_1.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_ROOF_RIDGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_ROOF_RIDGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_ROOF_RIDGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_ROOF_RIDGE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_DEMON_MASK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PLAQUE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_HIPPED_ROOF.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_HIPPED_ROOF.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_HIPPED_ROOF.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_HIPPED_ROOF.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_HIGH_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_HIGH_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_HIGH_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_HIGH_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_HIGH_CYLINDER_TILE_SIDE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_EAVES_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_EAVES_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());

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
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_BIRCH_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_JUNGLE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_MANGROVE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_CHERRY_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_CRIMSON_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_WARPED_BLOCK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.POTTERY_WHEEL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WIND_CHIME.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_WINE_TABLE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JI_CHI_MU_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_BOOK_DESK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JI_CHI_MU_TEAPOY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_TEAPOY.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JI_CHI_MU_TAISHI_CHAIR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JI_CHI_MU_FIVE_SCREEN_THRONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE.get(), RenderType.cutout());

// 食物方块透明渲染设置
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CI_PAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CI_WAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CI_BEI.get(), RenderType.cutout());

// 玉米相关
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CORN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BAKED_CORN.get(), RenderType.cutout());

// 水果类
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PEAR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PINEAPPLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGO.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LICHEE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BANANA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRAPE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MULBERRY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DURIAN.get(), RenderType.cutout());

// 饺子相关
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CAPSULE_JIAO_ZI_PAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CAPSULE_JIAO_ZI_WAN.get(), RenderType.cutout());

// 马齿苋饼
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_PAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_WAN.get(), RenderType.cutout());

// 青团
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.QING_TUAN_PAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.QING_TUAN_WAN.get(), RenderType.cutout());

// 高粱饼
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SORGHUM_CAKE_PAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SORGHUM_CAKE_WAN.get(), RenderType.cutout());

// 米饭
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MI_FAN_PAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MI_FAN_WAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.XIAO_MI_FAN_PAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.XIAO_MI_FAN_WAN.get(), RenderType.cutout());

// 蒸菜类
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZHENG_CAI.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TOMATO_EGG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GU_LAO_ROU.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEAT_FOAM_BRINJAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.STINKY_TOFU.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GUI_HUA_TANG_OU.get(), RenderType.cutout());

// 汤类
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HOT_PEAR_SOUP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZHU_DU_JI.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BA_BAO_ZHOU.get(), RenderType.cutout());

// 饮料类
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MULBERRY_JUICE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.APPLE_JUICE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRAPE_JUICE.get(), RenderType.cutout());

// 茶类
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BILUOCHUN_TEAS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_JING_TEAS.get(), RenderType.cutout());

// 酒杯类
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.EMPTY_FEN_JIU.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.EMPTY_SHI_LI_XIANG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.EMPTY_WHEAT_NUGGETS_TRIBUTE_WINE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.FEN_JIU.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHI_LI_XIANG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WHEAT_NUGGETS_TRIBUTE_WINE.get(), RenderType.cutout());
        //雀替和斗拱
        // 雀替类方块透明渲染设置
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_MANGROVE_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_BIRCH_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_JUNGLE_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_CRIMSON_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_WARPED_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_ACACIA_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_DARK_OAK_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_OAK_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_CHERRY_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_SPRUCE_BACK_BRACKET.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_MANGROVE_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_BIRCH_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_JUNGLE_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_CRIMSON_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_WARPED_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_ACACIA_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_DARK_OAK_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_OAK_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_CHERRY_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_SPRUCE_FLOWER_BRACKET.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_MANGROVE_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_BIRCH_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_JUNGLE_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_CRIMSON_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_WARPED_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_ACACIA_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_DARK_OAK_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_OAK_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_CHERRY_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_SPRUCE_BACK_BRACKET.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_MANGROVE_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_BIRCH_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_JUNGLE_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_CRIMSON_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_WARPED_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_ACACIA_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_DARK_OAK_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_OAK_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_CHERRY_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_SPRUCE_FLOWER_BRACKET.get(), RenderType.cutout());

// 斗拱类方块透明渲染设置
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JUNGLE_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GREEN_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_DOUGONG.get(), RenderType.cutout());
        ItemColors itemColors = Minecraft.getInstance().getItemColors();
        // 为每个物品注册颜色渲染器
        for (Supplier<? extends Item> itemSupplier : ARMOR_ITEMS) {
            itemColors.register((stack, color) -> {
                if (color == 1 && stack.getItem() instanceof DyeableItem dyeable) {
                    // color == 1 表示这是覆盖层
                    return dyeable.hasCustomColor(stack) ? dyeable.getColor(stack) : dyeable == ChangShengJueItems.MALE_TAOIST_HELMET.get() ? 0x000000 : 0xFFFFFF;
                }else {
                    return 0xFFFFFF;
                }
            }, itemSupplier.get());
        }

        MenuScreens.register(ChangShengJueMenuTypes.PLAQUE_MENU.get(), PlaqueScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.INNKEEPER_MENU.get(), InnkeeperScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.BLACKSMITH_MENU.get(), BlacksmithScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.KILNWORKER_MENU.get(), KilnWorkerScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.GANGLEADER_MENU.get(), GangleaderTradingScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.GANG_QUESTS_MENU.get(), GangQuestsScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.PLAYER_QUEST_MENU.get(), PlayerQuestScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.TAILORING_CASE_MENU.get(), TailoringCaseScreen::new);
        //ForgeBlockScreen
        MenuScreens.register(ChangShengJueMenuTypes.FORGE_BLOCK_MENU.get(), ForgeBlockScreen::new);

        EntityRenderers.register(ChangShengJueEntity.BUTTERFLY.get(), ButterflyRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.MONKEY.get(), MonkeyRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.DRAGONFLY.get(), DragonflyRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CICADA.get(), CicadaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CRANE.get(), CraneRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.MALE_PEACOCK.get(), MalePeacockRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.FEMALE_PEACOCK.get(), FemalePeacockRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.STAG.get(), StagRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.HIND.get(), HindRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.TIGER.get(), TigerRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CROC.get(), CrocRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER.get(), ChangShengJueVillagerRender::new);

        EntityRenderers.register(ChangShengJueEntity.THROWING_KNIVES_ENTITY.get(), ThrowingKnivesEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.GE_SHAN_DA_NIU.get(), GeShanDaNiuRender::new);

        EntityRenderers.register(ChangShengJueEntity.BA_WANG_QIANG.get(), ThrownBaWangQiangRender::new);
        EntityRenderers.register(ChangShengJueEntity.RED_TASSELLED_SPEAR.get(), ThrownRedTasselledSpearRender::new);

        EntityRenderers.register(ChangShengJueEntity.DUGU_NINE_SOWRDS.get(), DuguNineSwordsEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.GOLDEN_BLACK_KNIFE_METHOD.get(), GoldenBlackKnifeMethodEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.BEAT_DOG_STICK_ATTACK.get(), BeatDogStickAttackEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.TU_LONG_DAO_ATTACK.get(), TuLongDaoAttackEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.BA_WANG_QIANG_ATTACK.get(), BaWangQiangAttackEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.YI_TIAN_JIAN_ATTACK.get(), YiTianJianAttackEntityRender::new);
        EntityRenderers.register(ChangShengJueEntity.STAKES.get(), StakesRender::new);

        EntityRenderers.register(ChangShengJueEntity.WARRIOR.get(), WarriorRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.KILN_WORKER.get(), KilnWorkerRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.MALE_INNKEEPER.get(), MaleInnkeeperRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.FEMALE_INNKEEPER.get(), FemaleInnkeeperRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CHALLENGER.get(), ChallengerRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.BLACKSMITH.get(), BlacksmithRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.LANCE_GANG_LEADER.get(), LanceGangLeaderRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.KNIFE_GANG_LEADER.get(), KnifeGangLeaderRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.SWORD_GANG_LEADER.get(), SwordGangLeaderRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.CLUBBED_GANG_LEADER.get(), ClubbedGangLeaderRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.GANG_LEADER.get(), GangLeaderRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.BANDIT.get(), BanditRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.VILLAIN.get(), VillainRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.ASSASSIN.get(), AssassinRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.PIGLIN_WU_XIA.get(), PiglinWuXiaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.WITCH_WU_XIA.get(), WitchWuXiaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.EVOKER_WU_XIA.get(), EvokerWuXiaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.VINDICATOR_WU_XIA.get(), VindicatorWuXiaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.PILLAGER_WU_XIA.get(), PillagerWuXiaRenderer::new);

        EntityRenderers.register(ChangShengJueEntity.CLUBBED_MING_XIA.get(), ClubbedMingXiaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.SWORD_MING_XIA.get(), SwordMingXiaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.KNIFE_MING_XIA.get(), KnifeMingXiaRenderer::new);
        EntityRenderers.register(ChangShengJueEntity.FIST_MING_XIA.get(), FistMingXiaRenderer::new);

        ItemProperties.register(ChangShengJueItems.BA_WANG_QIANG.get(),new ResourceLocation("throwing"),(stack, clientLevel, livingEntity, i) ->
                livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack
                        && stack.getItem() instanceof Lance lance && lance.isThrowing ? 1.0F : 0.0F);
        ItemProperties.register(ChangShengJueItems.RED_TASSELLED_SPEAR.get(),new ResourceLocation("throwing"),(stack, clientLevel, livingEntity, i) ->
                livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack
                        && stack.getItem() instanceof Lance lance && lance.isThrowing ? 1.0F : 0.0F);
    }
}
