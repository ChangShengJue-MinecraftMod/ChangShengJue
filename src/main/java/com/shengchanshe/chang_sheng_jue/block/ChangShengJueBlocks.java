package com.shengchanshe.chang_sheng_jue.block;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.cropper.*;
import com.shengchanshe.chang_sheng_jue.block.custom.*;
import com.shengchanshe.chang_sheng_jue.block.custom.balustrade.Balustrade;
import com.shengchanshe.chang_sheng_jue.block.custom.balustrade.Guardrail;
import com.shengchanshe.chang_sheng_jue.block.custom.balustrade.StoneBalustrade;
import com.shengchanshe.chang_sheng_jue.block.custom.balustrade.WoodenBalustrade;
import com.shengchanshe.chang_sheng_jue.block.custom.bracket.*;
import com.shengchanshe.chang_sheng_jue.block.custom.brick_kiln.BrickKiln;
import com.shengchanshe.chang_sheng_jue.block.custom.castingmolds.BullionsCastingMolds;
import com.shengchanshe.chang_sheng_jue.block.custom.castingmolds.CastingMolds;
import com.shengchanshe.chang_sheng_jue.block.custom.eescalator.Eescalator;
import com.shengchanshe.chang_sheng_jue.block.custom.forgeblock.ForgeBlock;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.bed.ArhatBed;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.bamboo_mat.BambooMat;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.bed.CanopyBed;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.chair.*;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.desk.*;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.folding_screen.FoldingScreen;
import com.shengchanshe.chang_sheng_jue.block.custom.gong.Gong;
import com.shengchanshe.chang_sheng_jue.block.custom.lantern.HeightLightStand;
import com.shengchanshe.chang_sheng_jue.block.custom.lantern.Lantern;
import com.shengchanshe.chang_sheng_jue.block.custom.lantern.LightStand;
import com.shengchanshe.chang_sheng_jue.block.custom.lockers.Cabinet;
import com.shengchanshe.chang_sheng_jue.block.custom.lockers.ChestOfDrawers;
import com.shengchanshe.chang_sheng_jue.block.custom.lockers.LargeCabinet;
import com.shengchanshe.chang_sheng_jue.block.custom.loom.ChangShengJueLoomBlock;
import com.shengchanshe.chang_sheng_jue.block.custom.plaque.Plaque;
import com.shengchanshe.chang_sheng_jue.block.custom.pottery.PotteryWheel;
import com.shengchanshe.chang_sheng_jue.block.custom.racks.ClothesRack;
import com.shengchanshe.chang_sheng_jue.block.custom.racks.DryingRail;
import com.shengchanshe.chang_sheng_jue.block.custom.sharpening_stone.DiamondSharpeningStone;
import com.shengchanshe.chang_sheng_jue.block.custom.sharpening_stone.NetheriteSharpeningStone;
import com.shengchanshe.chang_sheng_jue.block.custom.sharpening_stone.StoneSharpeningStone;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.bigleft.BigShingMunLeft;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.bigright.BigShingMunRight;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.left.ShingMunLeft;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.right.ShingMunRight;
import com.shengchanshe.chang_sheng_jue.block.custom.storage.BookGrid;
import com.shengchanshe.chang_sheng_jue.block.custom.storage.FretworkOpenworkPanel;
import com.shengchanshe.chang_sheng_jue.block.custom.storage.Liangge;
import com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase.TailoringCase;
import com.shengchanshe.chang_sheng_jue.block.custom.tile.*;
import com.shengchanshe.chang_sheng_jue.block.custom.tool_table.ToolTable;
import com.shengchanshe.chang_sheng_jue.block.custom.weaponrack.WeaponRack;
import com.shengchanshe.chang_sheng_jue.block.custom.window.HighWindows;
import com.shengchanshe.chang_sheng_jue.block.custom.window.Windows;
import com.shengchanshe.chang_sheng_jue.block.custom.workbench.WoodworkingBench;
import com.shengchanshe.chang_sheng_jue.block.decoration.LeavesDefoliation;
import com.shengchanshe.chang_sheng_jue.block.decoration.flowerpot.BlueAndWhitePorcelainFlowerPots;
import com.shengchanshe.chang_sheng_jue.block.decoration.windchime.WindChime;
import com.shengchanshe.chang_sheng_jue.block.food.cibei.CiBei;
import com.shengchanshe.chang_sheng_jue.block.food.cibei.CiBeiFood;
import com.shengchanshe.chang_sheng_jue.block.food.cibei.CiBeiTea;
import com.shengchanshe.chang_sheng_jue.block.food.cipan.CiPan;
import com.shengchanshe.chang_sheng_jue.block.food.cipan.CiPanFood;
import com.shengchanshe.chang_sheng_jue.block.food.ciwan.CiWan;
import com.shengchanshe.chang_sheng_jue.block.food.ciwan.CiWanFood;
import com.shengchanshe.chang_sheng_jue.block.food.nobox.*;
import com.shengchanshe.chang_sheng_jue.block.food.wine.*;
import com.shengchanshe.chang_sheng_jue.block.painting.BigPaintingScroll;
import com.shengchanshe.chang_sheng_jue.block.painting.HighPaintingScroll;
import com.shengchanshe.chang_sheng_jue.block.painting.PaintingScroll;
import com.shengchanshe.chang_sheng_jue.block.painting.WidthPaintingScroll;
import com.shengchanshe.chang_sheng_jue.block.tree_logs.*;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.world.feature.tree.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ChangShengJueBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChangShengJue.MOD_ID);

    public static final RegistryObject<Block> PINEAPPLE_BLOCK = registerBlockWithoutBlockItem("pineapple_block",
            ()-> new PineappleBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> SOYBEAN_BLOCK = registerBlockWithoutBlockItem("soybean_block",
            ()-> new SoyBeanBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> TOMATO_BLOCK = registerBlockWithoutBlockItem("tomato_block",
            ()-> new TomatoBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> GU_ZI_BLOCK = registerBlockWithoutBlockItem("gu_zi_block",
            ()-> new GuZiBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> SORGHUM_BLOCK = registerBlockWithoutBlockItem("sorghum_block",
            ()-> new SorghumBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> REDBEAN_BLOCK = registerBlockWithoutBlockItem("redbean_block",
            ()-> new RedBeanBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> COTTON_BLOCK = registerBlockWithoutBlockItem("cotton_block",
            ()-> new CottonBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> STICKYRICE_BLOCK = registerBlockWithoutBlockItem("stickyrice_block",
            ()-> new StickyRiceBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> CORN_BLOCK = registerBlockWithoutBlockItem("corn_block",
            ()-> new CornBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> JALAPENOS_BLOCK = registerBlockWithoutBlockItem("jalapenos_block",
            ()-> new JalapenosBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> PEANUT_BLOCK = registerBlockWithoutBlockItem("peanut_block",
            ()-> new PeanutBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> BRINJAL_BLOCK = registerBlockWithoutBlockItem("brinjal_block",
            ()-> new BrinjalBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> GRAPE_BLOCK = registerBlockWithoutBlockItem("grape_block",
            ()-> new GrapeBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));

    //水稻
    public static final RegistryObject<Block> RICE = registerBlockWithoutBlockItem("rice",
            ()-> new RiceBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    //碧螺春
    public static final RegistryObject<Block> BILUOCHUN_TEA = registerBlockWithoutBlockItem("biluochun_tea",
            ()-> new BiluochunTeaBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    //龙井
    public static final RegistryObject<Block> LONG_JING_TEA = registerBlockWithoutBlockItem("long_jing_tea",
            ()-> new LongJingTeaBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    //大麦
    public static final RegistryObject<Block> HORDEUM = registerBlockWithoutBlockItem("hordeum",
            ()-> new HordeumBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    //哈密瓜
    public static final RegistryObject<Block> CANTALOUPE_BLOCK = registerBlock("cantaloupe_block",
            ()-> new CantaloupeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .instrument(NoteBlockInstrument.DIDGERIDOO).pushReaction(PushReaction.DESTROY)
                    .strength(1.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CANTALOUPE_STEM = registerBlockWithoutBlockItem("cantaloupe_stem",
            ()-> new StemBlock((StemGrownBlock)CANTALOUPE_BLOCK.get(), ChangShengJueItems.CANTALOUPE_SEEDS,
                   BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.HARD_CROP).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> ATTACHED_CANTALOUPE_STEM = registerBlockWithoutBlockItem("attached_cantaloupe_stem",
            ()-> new AttachedStemBlock((StemGrownBlock)CANTALOUPE_BLOCK.get(), ChangShengJueItems.CANTALOUPE_SEEDS
                    ,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));

    //莲花
    public static final RegistryObject<Block> LOTUS_BLOCK = registerBlockWithoutBlockItem("lotus_block",
            ()-> new LotusBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission()
                    .randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    //树木
    //芒果树
    public static final RegistryObject<Block> MANGO_LOG = registerBlock("mango_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_MANGO_LOG = registerBlock("stripped_mango_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> MANGO_WOOD = registerBlock("mango_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_MANGO_WOOD = registerBlock("stripped_mango_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> MANGO_PLANKS = registerBlock("mango_planks",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> MANGO_LEAVES = registerBlock("mango_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> MANGO_SAPLING = registerBlock("mango_sapling",
            ()-> new SaplingBlock(new MangoTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> BANANA_LOG = registerBlock("banana_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> BANANA_LEAVES = registerBlock("banana_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> BANANA_FRUIT = registerBlock("banana_fruit",
            ()-> new BananaFruit(BlockBehaviour.Properties.copy(Blocks.MELON)));
    public static final RegistryObject<Block> BANANA_SAPLING = registerBlock("banana_sapling",
            ()-> new SaplingBlock(new BananaTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    //梨树
    public static final RegistryObject<Block> PEAR_LOG = registerBlock("pear_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_PEAR_LOG = registerBlock("stripped_pear_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> PEAR_WOOD = registerBlock("pear_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_PEAR_WOOD = registerBlock("stripped_pear_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> PEAR_PLANKS = registerBlock("pear_planks",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> PEAR_LEAVES = registerBlock("pear_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> PEAR_SAPLING = registerBlock("pear_sapling",
            ()-> new SaplingBlock(new PearTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    //荔枝
    public static final RegistryObject<Block> LICHEE_LOG = registerBlock("lichee_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_LICHEE_LOG = registerBlock("stripped_lichee_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> LICHEE_WOOD = registerBlock("lichee_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_LICHEE_WOOD = registerBlock("stripped_lichee_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> LICHEE_PLANKS = registerBlock("lichee_planks",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> LICHEE_LEAVES = registerBlock("lichee_leaves",
            ()-> new FruitLeaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> LICHEE_SAPLING = registerBlock("lichee_sapling",
            ()-> new SaplingBlock(new LicheeTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    //榴莲
    public static final RegistryObject<Block> DURIAN_LOG = registerBlock("durian_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_DURIAN_LOG = registerBlock("stripped_durian_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> DURIAN_WOOD = registerBlock("durian_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_DURIAN_WOOD = registerBlock("stripped_durian_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> DURIAN_PLANKS = registerBlock("durian_planks",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> DURIAN_LEAVES = registerBlock("durian_leaves",
            ()-> new FruitLeaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> DURIAN_SAPLING = registerBlock("durian_sapling",
            ()-> new SaplingBlock(new DurianTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    //桂花树
    public static final RegistryObject<Block> OSMANTHUS_LOG = registerBlock("osmanthus_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> OSMANTHUS_WOOD = registerBlock("osmanthus_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_OSMANTHUS_LOG = registerBlock("stripped_osmanthus_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_OSMANTHUS_WOOD = registerBlock("stripped_osmanthus_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> OSMANTHUS_PLANKS = registerBlock("osmanthus_planks",
            ()-> new Planks(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> OSMANTHUS_LEAVES = registerBlock("osmanthus_leaves",
            ()-> new GuiHuaLeaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> OSMANTHUS_SAPLING = registerBlock("osmanthus_sapling",
            ()-> new SaplingBlock(new GuiHuaTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> OSMANTHUS_DEFOLIATION = registerBlock("osmanthus_defoliation",
            ()-> new LeavesDefoliation(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> PLUM_LOG = registerBlock("plum_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> PLUM_WOOD = registerBlock("plum_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_PLUM_LOG = registerBlock("stripped_plum_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_PLUM_WOOD = registerBlock("stripped_plum_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> PLUM_PLANKS = registerBlock("plum_planks",
            ()-> new Planks(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> PLUM_LEAVES = registerBlock("plum_leaves",
            ()-> new MeiHuaLeaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> PLUM_SAPLING = registerBlock("plum_sapling",
            ()-> new SaplingBlock(new MeiHuaTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> PLUM_DEFOLIATION = registerBlock("plum_defoliation",
            ()-> new LeavesDefoliation(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    //黄花梨
    public static final RegistryObject<Block> HUANG_HUA_LI_LOG = registerBlock("huang_hua_li_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_HUANG_HUA_LI_LOG = registerBlock("stripped_huang_hua_li_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> HUANG_HUA_LI_WOOD = registerBlock("huang_hua_li_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_HUANG_HUA_LI_WOOD = registerBlock("stripped_huang_hua_li_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> HUANG_HUA_LI_PLANKS = registerBlock("huang_hua_li_planks",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> HUANG_HUA_LI_LEAVES = registerBlock("huang_hua_li_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> HUANG_HUA_LI_SAPLING = registerBlock("huang_hua_li_sapling",
            ()-> new SaplingBlock(new HuangHuaLiTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    //鸡翅木
    public static final RegistryObject<Block> WENGE_LOG = registerBlock("wenge_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_WENGE_LOG = registerBlock("stripped_wenge_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> WENGE_WOOD = registerBlock("wenge_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_WENGE_WOOD = registerBlock("stripped_wenge_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> WENGE_PLANKS = registerBlock("wenge_planks",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> WENGE_LEAVES = registerBlock("wenge_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> WENGE_SAPLING = registerBlock("wenge_sapling",
            ()-> new SaplingBlock(new JiChiMuTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> ZI_TAN_LOG = registerBlock("zi_tan_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> ZI_TAN_WOOD = registerBlock("zi_tan_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_ZI_TAN_LOG = registerBlock("stripped_zi_tan_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_ZI_TAN_WOOD = registerBlock("stripped_zi_tan_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> ZI_TAN_PLANKS = registerBlock("zi_tan_planks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> ZI_TAN_LEAVES = registerBlock("zi_tan_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> ZI_TAN_SAPLING = registerBlock("zi_tan_sapling",
            ()-> new SaplingBlock(new ZiTanTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    //白杨树
    public static final RegistryObject<Block> POPLAR_LOG = registerBlock("poplar_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> POPLAR_WOOD = registerBlock("poplar_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_POPLAR_LOG = registerBlock("stripped_poplar_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_POPLAR_WOOD = registerBlock("stripped_poplar_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> POPLAR_PLANKS = registerBlock("poplar_planks",
            ()-> new Planks(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> POPLAR_LEAVES = registerBlock("poplar_leaves",
            ()-> new PoplarLeaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> POPLAR_SAPLING = registerBlock("poplar_sapling",
            ()-> new SaplingBlock(new PoplarTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POPLAR_DEFOLIATION = registerBlock("poplar_defoliation",
            ()-> new LeavesDefoliation(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    //桑树
    public static final RegistryObject<Block> MULBERRY_LOG = registerBlock("mulberry_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> MULBERRY_WOOD = registerBlock("mulberry_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_MULBERRY_LOG = registerBlock("stripped_mulberry_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_MULBERRY_WOOD = registerBlock("stripped_mulberry_wood",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> MULBERRY_PLANKS = registerBlock("mulberry_planks",
            ()-> new Planks(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> MULBERRY_LEAVES = registerBlock("mulberry_leaves",
            ()-> new MulberryLeaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), MulberryLeaves.State.LEAVES));
    public static final RegistryObject<Block> MULBERRY_LEAVES_FRUITS = registerBlock("mulberry_leaves_fruits",
            ()-> new MulberryLeaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), MulberryLeaves.State.FRUITS));
    public static final RegistryObject<Block> MULBERRY_SAPLING = registerBlock("mulberry_sapling",
            ()-> new SaplingBlock(new MulberryTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    //花盆和花花草草
    public static final RegistryObject<Block> BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS = registerBlock("blue_and_white_porcelain_flower_pots",
            ()-> new BlueAndWhitePorcelainFlowerPots(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).noOcclusion().instabreak().pushReaction(PushReaction.DESTROY)));
    //艾蒿
    public static final RegistryObject<Block> MUGWORT_BLOCK = registerBlock("mugwort_block",
            ()-> new FlowerBlock(()-> MobEffects.LEVITATION,8,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)){
                private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
                @Override
                public VoxelShape getShape(BlockState p_53517_, BlockGetter p_53518_, BlockPos p_53519_, CollisionContext p_53520_) {
                    Vec3 vec3 = p_53517_.getOffset(p_53518_, p_53519_);
                    return SHAPE.move(vec3.x, vec3.y, vec3.z);
                }
            });
    public static final RegistryObject<Block> POTTED_MUGWORT_BLOCK = registerBlockWithoutBlockItem("potted_mugwort_block",
            ()-> new FlowerPotBlock(()->(FlowerPotBlock) Blocks.FLOWER_POT,ChangShengJueBlocks.MUGWORT_BLOCK,BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    //杜鹃
    public static final RegistryObject<Block> CUCKOO_BLOCK = registerBlock("cuckoo_block",
            ()-> new FlowerBlock(MobEffects.LEVITATION,8,BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> POTTED_CUCKOO_BLOCK = registerBlockWithoutBlockItem("potted_cuckoo_block",
            ()-> new FlowerPotBlock(()->(FlowerPotBlock) Blocks.FLOWER_POT,ChangShengJueBlocks.CUCKOO_BLOCK,BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    //马齿苋
    public static final RegistryObject<Block> PORTULACA_OLERACEA_BLOCK = registerBlock("portulaca_oleracea_block",
            ()-> new FlowerBlock(MobEffects.LEVITATION,8,BlockBehaviour.Properties.copy(Blocks.DANDELION)){
                protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
                @Override
                public VoxelShape getShape(BlockState p_53517_, BlockGetter p_53518_, BlockPos p_53519_, CollisionContext p_53520_) {
                    Vec3 vec3 = p_53517_.getOffset(p_53518_, p_53519_);
                    return SHAPE.move(vec3.x, vec3.y, vec3.z);
                }
            });
    public static final RegistryObject<Block> POTTED_PORTULACA_OLERACEA_BLOCK = registerBlockWithoutBlockItem("potted_portulaca_oleracea_block",
            ()-> new FlowerPotBlock(()->(FlowerPotBlock) Blocks.FLOWER_POT,ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK,BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));
    //茉莉花
    public static final RegistryObject<Block> JASMINE_BLOCK = registerBlock("jasmine_block",
            ()-> new FlowerBlock(MobEffects.LEVITATION,8,BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> POTTED_JASMINE_BLOCK = registerBlockWithoutBlockItem("potted_jasmine_block",
            ()-> new FlowerPotBlock(()->(FlowerPotBlock) Blocks.FLOWER_POT,ChangShengJueBlocks.JASMINE_BLOCK,BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    //地肤草
    public static final RegistryObject<Block> KOCHIA_SCOPARIA_BLOCK = registerBlock("kochia_scoparia_block",
            ()-> new FlowerBlock(MobEffects.LEVITATION,8,BlockBehaviour.Properties.copy(Blocks.DANDELION)){
                private static final VoxelShape SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
                @Override
                public VoxelShape getShape(BlockState p_53517_, BlockGetter p_53518_, BlockPos p_53519_, CollisionContext p_53520_) {
                    Vec3 vec3 = p_53517_.getOffset(p_53518_, p_53519_);
                    return SHAPE.move(vec3.x, vec3.y, vec3.z);
                }
            });
    public static final RegistryObject<Block> POTTED_KOCHIA_SCOPARIA_BLOCK = registerBlockWithoutBlockItem("potted_kochia_scoparia_block",
            ()-> new FlowerPotBlock(()->(FlowerPotBlock) Blocks.FLOWER_POT,ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK,BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    //水仙
    public static final RegistryObject<Block> SHUI_XIAN_BLOCK = registerBlock("shui_xian_block",
            ()-> new FlowerBlock(MobEffects.LEVITATION,8,BlockBehaviour.Properties.copy(Blocks.DANDELION)){
                private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
                @Override
                public VoxelShape getShape(BlockState p_53517_, BlockGetter p_53518_, BlockPos p_53519_, CollisionContext p_53520_) {
                    Vec3 vec3 = p_53517_.getOffset(p_53518_, p_53519_);
                    return SHAPE.move(vec3.x, vec3.y, vec3.z);
                }
            });
    public static final RegistryObject<Block> POTTED_SHUI_XIAN_BLOCK = registerBlockWithoutBlockItem("potted_shui_xian_block",
            ()-> new FlowerPotBlock(()->(FlowerPotBlock) Blocks.FLOWER_POT,ChangShengJueBlocks.SHUI_XIAN_BLOCK,BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));
    //昙花
    public static final RegistryObject<Block> TAN_HUA_BLOCK = registerBlock("tan_hua_block",
            ()-> new FlowerBlock(MobEffects.LEVITATION,8,BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> POTTED_TAN_HUA_BLOCK = registerBlockWithoutBlockItem("potted_tan_hua_block",
            ()-> new FlowerPotBlock(()->(FlowerPotBlock) Blocks.FLOWER_POT,ChangShengJueBlocks.TAN_HUA_BLOCK,BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));
    //秋麒麟
    public static final RegistryObject<Block> SOLIDAGO = registerBlock("solidago",
            ()-> new FlowerBlock(MobEffects.LEVITATION,8,BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> POTTED_SOLIDAGO = registerBlockWithoutBlockItem("potted_solidago",
            ()-> new FlowerPotBlock(()->(FlowerPotBlock) Blocks.FLOWER_POT,ChangShengJueBlocks.SOLIDAGO,BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));
    //三花路边青
    public static final RegistryObject<Block> GEUM_TRIFLORUM = registerBlock("geum_triflorum",
            ()-> new FlowerBlock(MobEffects.LEVITATION,8,BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> POTTED_GEUM_TRIFLORUM = registerBlockWithoutBlockItem("potted_geum_triflorum",
            ()-> new FlowerPotBlock(()->(FlowerPotBlock) Blocks.FLOWER_POT,ChangShengJueBlocks.GEUM_TRIFLORUM,BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));
    //紫色蒲公英
    public static final RegistryObject<Block> PURPLE_DANDELION = registerBlock("purple_dandelion",
            ()-> new FlowerBlock(MobEffects.LEVITATION,8,BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> POTTED_PURPLE_DANDELION = registerBlockWithoutBlockItem("potted_purple_dandelion",
            ()-> new FlowerPotBlock(()->(FlowerPotBlock) Blocks.FLOWER_POT,ChangShengJueBlocks.PURPLE_DANDELION,BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));
    //红蓼
    public static final RegistryObject<Block> RED_KNOTWEED = registerBlock("red_knotweed",
            ()-> new DoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.SUNFLOWER)));
    public static final RegistryObject<Block> PURPLE_RED_KNOTWEED = registerBlock("purple_red_knotweed",
            ()-> new DoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.SUNFLOWER)));


    //油菜花
    public static final RegistryObject<Block> RAPE_FLOWERS = registerBlock("rape_flowers",
            ()-> new DoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.SUNFLOWER)));
    //荠菜
    public static final RegistryObject<Block> CAPSULE_BLOCK = registerBlock("capsule_block",
            ()-> new CapsuleBlock(BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    //大针茅
    public static final RegistryObject<Block> STIPA_GRANDIS = registerBlock("stipa_grandis",
            ()-> new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)));
    public static final RegistryObject<Block> TALL_STIPA_GRANDIS = registerBlock("tall_stipa_grandis",
            ()-> new DoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> TALL_STIPA_GRANDIS_VARIANT = registerBlock("tall_stipa_grandis_variant",
            ()-> new DoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));

    public static final RegistryObject<Block> WILDLIFE_HORDEUM = registerBlock("wildlife_hordeum",
            ()-> new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS)));
    //建筑
    public static final RegistryObject<Block> ZHU_TAI = registerBlockWithoutBlockItem("zhu_tai",
            ()-> new ZhuTaiBlock(BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel((p_50755_) -> 15).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), ParticleTypes.FLAME));
    public static final RegistryObject<Block> WALL_ZHU_TAI = registerBlockWithoutBlockItem("wall_zhu_tai",
            ()-> new WallZhuTaiBlock(BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel((p_50886_) -> 15).sound(SoundType.WOOD)
                    .dropsLike(ZHU_TAI.get()).pushReaction(PushReaction.DESTROY), ParticleTypes.FLAME));

    public static final RegistryObject<Block> HANG_TU_BLOCK = registerBlock("hang_tu_block",
            ()-> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> TU_PEI_BLOCK = registerBlock("tu_pei_block",
            ()-> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));
    //石灯
    public static final RegistryObject<Block> STONE_LAMPS_BASE_BLOCK = registerBlock("stone_lamps_base_block",
            ()-> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(1.5F, 6.0F).noOcclusion()));
    public static final RegistryObject<Block> STONE_LAMPS_BLOCK = registerBlock("stone_lamps_block",
            ()-> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(1.5F, 6.0F).noOcclusion()){
                @Override
                public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
                    if (player.getItemInHand(hand).is(Items.FLINT_AND_STEEL)){
                        level.setBlock(blockPos,ChangShengJueBlocks.STONE_LAMPS_LIANG_BLOCK.get().defaultBlockState(),3);
                        if (!player.getAbilities().instabuild) {
                            player.getItemInHand(hand).hurtAndBreak(1,player,(p)->p.broadcastBreakEvent(hand));
                        }
                        return InteractionResult.SUCCESS;
                    }
                    return InteractionResult.PASS;
                }
            });
    public static final RegistryObject<Block> STONE_LAMPS_LIANG_BLOCK = registerBlock("stone_lamps_liang_block",
            ()-> new StoneLampsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instabreak().noOcclusion().lightLevel((state) -> 15).sound(SoundType.STONE), ParticleTypes.FLAME));

    public static final RegistryObject<Block> YELLOW_STONE_LION_BLOCK = registerBlock("yellow_stone_lion_block",
            ()-> new StoneLionBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistryObject<Block> GRE_STONE_LION_BLOCK = registerBlock("gre_stone_lion_block",
            ()-> new StoneLionBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    //扶梯
    public static final RegistryObject<Block> BAI_HUA_FU_TI_BLOCK = registerBlock("bai_hua_fu_ti_block",
            ()-> new Eescalator(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> YUN_SHAN_FU_TI_BLOCK = registerBlock("yun_shan_fu_ti_block",
            ()-> new Eescalator(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));

    //琉璃瓦
    public static final RegistryObject<Block> GRE_CYLINDER_TILE_BLOCK = registerBlock("gre_cylinder_tile_block",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_CYLINDER_TILE_BLOCK = registerBlock("red_cylinder_tile_block",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_CYLINDER_TILE_BLOCK = registerBlock("black_cylinder_tile_block",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_CYLINDER_TILE_BLOCK = registerBlock("golden_cylinder_tile_block",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_CYLINDER_TILE_BLOCK = registerBlock("cyan_cylinder_tile_block",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_CYLINDER_TILE_BLOCK = registerBlock("blue_cylinder_tile_block",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_CYLINDER_TILE_BLOCK = registerBlock("purple_cylinder_tile_block",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> GRE_CYLINDER_TILE = registerBlock("gre_cylinder_tile",
            ()-> new HalfCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_CYLINDER_TILE = registerBlock("red_cylinder_tile",
            ()-> new HalfCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_CYLINDER_TILE = registerBlock("black_cylinder_tile",
            ()-> new HalfCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_CYLINDER_TILE = registerBlock("golden_cylinder_tile",
            ()-> new HalfCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_CYLINDER_TILE = registerBlock("cyan_cylinder_tile",
            ()-> new HalfCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_CYLINDER_TILE = registerBlock("blue_cylinder_tile",
            ()-> new HalfCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_CYLINDER_TILE = registerBlock("purple_cylinder_tile",
            ()-> new HalfCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //瓦当
    public static final RegistryObject<Block> GRE_EAVES_TILE = registerBlock("gre_eaves_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_EAVES_TILE = registerBlock("red_eaves_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_EAVES_TILE = registerBlock("black_eaves_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_EAVES_TILE = registerBlock("golden_eaves_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_EAVES_TILE = registerBlock("cyan_eaves_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_EAVES_TILE = registerBlock("blue_eaves_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_EAVES_TILE = registerBlock("purple_eaves_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //侧瓦当
    public static final RegistryObject<Block> GRE_EAVES_TILE_SIDE = registerBlock("gre_eaves_tile_side",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_EAVES_TILE_SIDE = registerBlock("red_eaves_tile_side",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_EAVES_TILE_SIDE = registerBlock("black_eaves_tile_side",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_EAVES_TILE_SIDE = registerBlock("golden_eaves_tile_side",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_EAVES_TILE_SIDE = registerBlock("cyan_eaves_tile_side",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_EAVES_TILE_SIDE = registerBlock("blue_eaves_tile_side",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_EAVES_TILE_SIDE = registerBlock("purple_eaves_tile_side",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //双层琉璃瓦
    public static final RegistryObject<Block> GRE_DOUBLE_CYLINDER_TILE = registerBlock("gre_double_cylinder_tile",
            ()-> new BaffleCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_DOUBLE_CYLINDER_TILE = registerBlock("red_double_cylinder_tile",
            ()-> new BaffleCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_DOUBLE_CYLINDER_TILE = registerBlock("black_double_cylinder_tile",
            ()-> new BaffleCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_DOUBLE_CYLINDER_TILE = registerBlock("golden_double_cylinder_tile",
            ()-> new BaffleCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_DOUBLE_CYLINDER_TILE = registerBlock("cyan_double_cylinder_tile",
            ()-> new BaffleCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_DOUBLE_CYLINDER_TILE = registerBlock("blue_double_cylinder_tile",
            ()-> new BaffleCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_DOUBLE_CYLINDER_TILE = registerBlock("purple_double_cylinder_tile",
            ()-> new BaffleCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //小鸱吻
    public static final RegistryObject<Block> GRE_SMALL_DEMON_MASK = registerBlock("gre_small_demon_mask",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_SMALL_DEMON_MASK = registerBlock("red_small_demon_mask",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_SMALL_DEMON_MASK = registerBlock("black_small_demon_mask",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_SMALL_DEMON_MASK = registerBlock("golden_small_demon_mask",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_SMALL_DEMON_MASK = registerBlock("cyan_small_demon_mask",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_SMALL_DEMON_MASK = registerBlock("blue_small_demon_mask",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_SMALL_DEMON_MASK = registerBlock("purple_small_demon_mask",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //鸱吻
    public static final RegistryObject<Block> GRE_DEMON_MASK = registerBlock("gre_demon_mask",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_DEMON_MASK = registerBlock("red_demon_mask",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_DEMON_MASK = registerBlock("black_demon_mask",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_DEMON_MASK = registerBlock("golden_demon_mask",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_DEMON_MASK = registerBlock("cyan_demon_mask",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_DEMON_MASK = registerBlock("blue_demon_mask",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_DEMON_MASK = registerBlock("purple_demon_mask",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //脊瓦
    public static final RegistryObject<Block> GRE_RIDGE_TILE = registerBlock("gre_ridge_tile",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_RIDGE_TILE = registerBlock("red_ridge_tile",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_RIDGE_TILE = registerBlock("black_ridge_tile",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_RIDGE_TILE = registerBlock("golden_ridge_tile",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_RIDGE_TILE = registerBlock("cyan_ridge_tile",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_RIDGE_TILE = registerBlock("blue_ridge_tile",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_RIDGE_TILE = registerBlock("purple_ridge_tile",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //双层脊瓦
    public static final RegistryObject<Block> GRE_DOUBLE_RIDGE_TILE = registerBlock("gre_double_ridge_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_DOUBLE_RIDGE_TILE = registerBlock("red_double_ridge_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_DOUBLE_RIDGE_TILE = registerBlock("black_double_ridge_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_DOUBLE_RIDGE_TILE = registerBlock("golden_double_ridge_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_DOUBLE_RIDGE_TILE = registerBlock("cyan_double_ridge_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_DOUBLE_RIDGE_TILE = registerBlock("blue_double_ridge_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_DOUBLE_RIDGE_TILE = registerBlock("purple_double_ridge_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //侧向飞檐
    public static final RegistryObject<Block> GRE_OCTAGONAL_UPTURNED_EAVES = registerBlock("gre_octagonal_upturned_eaves",
            ()-> new OctagonalUpturnedEaves(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_OCTAGONAL_UPTURNED_EAVES = registerBlock("red_octagonal_upturned_eaves",
            ()-> new OctagonalUpturnedEaves(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_OCTAGONAL_UPTURNED_EAVES = registerBlock("black_octagonal_upturned_eaves",
            ()-> new OctagonalUpturnedEaves(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_OCTAGONAL_UPTURNED_EAVES = registerBlock("golden_octagonal_upturned_eaves",
            ()-> new OctagonalUpturnedEaves(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_OCTAGONAL_UPTURNED_EAVES = registerBlock("cyan_octagonal_upturned_eaves",
            ()-> new OctagonalUpturnedEaves(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_OCTAGONAL_UPTURNED_EAVES = registerBlock("blue_octagonal_upturned_eaves",
            ()-> new OctagonalUpturnedEaves(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_OCTAGONAL_UPTURNED_EAVES = registerBlock("purple_octagonal_upturned_eaves",
            ()-> new OctagonalUpturnedEaves(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //飞檐
    public static final RegistryObject<Block> GRE_EAVES_CYLINDER_TILE = registerBlock("gre_eaves_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_EAVES_CYLINDER_TILE = registerBlock("red_eaves_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_EAVES_CYLINDER_TILE = registerBlock("black_eaves_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_EAVES_CYLINDER_TILE = registerBlock("golden_eaves_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_EAVES_CYLINDER_TILE = registerBlock("cyan_eaves_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_EAVES_CYLINDER_TILE = registerBlock("blue_eaves_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_EAVES_CYLINDER_TILE = registerBlock("purple_eaves_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //琉璃瓦块台阶
    public static final RegistryObject<Block> GRE_CYLINDER_TILE_SLAB = registerBlock("gre_cylinder_tile_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_CYLINDER_TILE_SLAB = registerBlock("red_cylinder_tile_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_CYLINDER_TILE_SLAB = registerBlock("black_cylinder_tile_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_CYLINDER_TILE_SLAB = registerBlock("golden_cylinder_tile_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_CYLINDER_TILE_SLAB = registerBlock("cyan_cylinder_tile_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_CYLINDER_TILE_SLAB = registerBlock("blue_cylinder_tile_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_CYLINDER_TILE_SLAB = registerBlock("purple_cylinder_tile_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //侧琉璃瓦
    public static final RegistryObject<Block> GRE_CYLINDER_TILE_SIDE = registerBlock("gre_cylinder_tile_side",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_CYLINDER_TILE_SIDE = registerBlock("red_cylinder_tile_side",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_CYLINDER_TILE_SIDE = registerBlock("black_cylinder_tile_side",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_CYLINDER_TILE_SIDE = registerBlock("golden_cylinder_tile_side",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_CYLINDER_TILE_SIDE = registerBlock("cyan_cylinder_tile_side",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_CYLINDER_TILE_SIDE = registerBlock("blue_cylinder_tile_side",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_CYLINDER_TILE_SIDE = registerBlock("purple_cylinder_tile_side",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //蹲兽脊瓦
    public static final RegistryObject<Block> ANIMALS_GRE_RIDGE_TILE = registerBlock("animals_gre_ridge_tile",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> ANIMALS_RED_RIDGE_TILE = registerBlock("animals_red_ridge_tile",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> ANIMALS_BLACK_RIDGE_TILE = registerBlock("animals_black_ridge_tile",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> ANIMALS_GOLDEN_RIDGE_TILE = registerBlock("animals_golden_ridge_tile",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> ANIMALS_CYAN_RIDGE_TILE = registerBlock("animals_cyan_ridge_tile",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> ANIMALS_BLUE_RIDGE_TILE = registerBlock("animals_blue_ridge_tile",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> ANIMALS_PURPLE_RIDGE_TILE = registerBlock("animals_purple_ridge_tile",
            ()-> new HalfAnimalsCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //垂兽脊瓦
    public static final RegistryObject<Block> HANGING_BEAST_GRE_RIDGE_TILE = registerBlock("hanging_beast_gre_ridge_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> HANGING_BEAST_RED_RIDGE_TILE = registerBlock("hanging_beast_red_ridge_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> HANGING_BEAST_BLACK_RIDGE_TILE = registerBlock("hanging_beast_black_ridge_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> HANGING_BEAST_GOLDEN_RIDGE_TILE = registerBlock("hanging_beast_golden_ridge_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> HANGING_BEAST_CYAN_RIDGE_TILE = registerBlock("hanging_beast_cyan_ridge_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> HANGING_BEAST_BLUE_RIDGE_TILE = registerBlock("hanging_beast_blue_ridge_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> HANGING_BEAST_PURPLE_RIDGE_TILE = registerBlock("hanging_beast_purple_ridge_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //屋脊
    public static final RegistryObject<Block> GRE_ROOF_RIDGE = registerBlock("gre_roof_ridge",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_ROOF_RIDGE = registerBlock("red_roof_ridge",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_ROOF_RIDGE = registerBlock("black_roof_ridge",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_ROOF_RIDGE = registerBlock("golden_roof_ridge",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_ROOF_RIDGE = registerBlock("cyan_roof_ridge",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_ROOF_RIDGE = registerBlock("blue_roof_ridge",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_ROOF_RIDGE = registerBlock("purple_roof_ridge",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //脊刹
    public static final RegistryObject<Block> GRE_RIDGE_FINIAL_PAVILION = registerBlock("gre_ridge_finial_pavilion",
            ()-> new Pavilion(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_RIDGE_FINIAL_PAVILION = registerBlock("red_ridge_finial_pavilion",
            ()-> new Pavilion(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_RIDGE_FINIAL_PAVILION = registerBlock("black_ridge_finial_pavilion",
            ()-> new Pavilion(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_RIDGE_FINIAL_PAVILION = registerBlock("golden_ridge_finial_pavilion",
            ()-> new Pavilion(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_RIDGE_FINIAL_PAVILION = registerBlock("cyan_ridge_finial_pavilion",
            ()-> new Pavilion(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_RIDGE_FINIAL_PAVILION = registerBlock("blue_ridge_finial_pavilion",
            ()-> new Pavilion(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_RIDGE_FINIAL_PAVILION = registerBlock("purple_ridge_finial_pavilion",
            ()-> new Pavilion(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> GRE_CHARACTER_PLAQUE_PAVILION = registerBlock("gre_character_plaque_pavilion",
            ()-> new Pavilion(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_CHARACTER_PLAQUE_PAVILION = registerBlock("red_character_plaque_pavilion",
            ()-> new Pavilion(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_CHARACTER_PLAQUE_PAVILION = registerBlock("black_character_plaque_pavilion",
            ()-> new Pavilion(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_CHARACTER_PLAQUE_PAVILION = registerBlock("golden_character_plaque_pavilion",
            ()-> new Pavilion(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_CHARACTER_PLAQUE_PAVILION = registerBlock("cyan_character_plaque_pavilion",
            ()-> new Pavilion(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_CHARACTER_PLAQUE_PAVILION = registerBlock("blue_character_plaque_pavilion",
            ()-> new Pavilion(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_CHARACTER_PLAQUE_PAVILION = registerBlock("purple_character_plaque_pavilion",
            ()-> new Pavilion(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));

    //攒尖
    public static final RegistryObject<Block> GRE_HIPPED_ROOF = registerBlock("gre_hipped_roof",
            ()-> new HippedRoof(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_HIPPED_ROOF = registerBlock("red_hipped_roof",
            ()-> new HippedRoof(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_HIPPED_ROOF = registerBlock("black_hipped_roof",
            ()-> new HippedRoof(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_HIPPED_ROOF = registerBlock("golden_hipped_roof",
            ()-> new HippedRoof(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_HIPPED_ROOF = registerBlock("cyan_hipped_roof",
            ()-> new HippedRoof(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_HIPPED_ROOF = registerBlock("blue_hipped_roof",
            ()-> new HippedRoof(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_HIPPED_ROOF = registerBlock("purple_hipped_roof",
            ()-> new HippedRoof(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));

    //垂脊琉璃瓦
    public static final RegistryObject<Block> GRE_GABLE_RIDGE_CYLINDER_TILE = registerBlock("gre_gable_ridge_cylinder_tile",
            ()-> new GableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_GABLE_RIDGE_CYLINDER_TILE = registerBlock("red_gable_ridge_cylinder_tile",
            ()-> new GableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_GABLE_RIDGE_CYLINDER_TILE = registerBlock("black_gable_ridge_cylinder_tile",
            ()-> new GableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_GABLE_RIDGE_CYLINDER_TILE = registerBlock("golden_gable_ridge_cylinder_tile",
            ()-> new GableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_GABLE_RIDGE_CYLINDER_TILE = registerBlock("cyan_gable_ridge_cylinder_tile",
            ()-> new GableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_GABLE_RIDGE_CYLINDER_TILE = registerBlock("blue_gable_ridge_cylinder_tile",
            ()-> new GableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_GABLE_RIDGE_CYLINDER_TILE = registerBlock("purple_gable_ridge_cylinder_tile",
            ()-> new GableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));

    //八角矮垂脊(前)
    public static final RegistryObject<Block> GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT = registerBlock("gre_octagonal_dwarf_ridge_tiles_front",
            ()-> new OctagonalDwarfRidgeTiles(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT = registerBlock("red_octagonal_dwarf_ridge_tiles_front",
            ()-> new OctagonalDwarfRidgeTiles(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT = registerBlock("black_octagonal_dwarf_ridge_tiles_front",
            ()-> new OctagonalDwarfRidgeTiles(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT = registerBlock("golden_octagonal_dwarf_ridge_tiles_front",
            ()-> new OctagonalDwarfRidgeTiles(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT = registerBlock("cyan_octagonal_dwarf_ridge_tiles_front",
            ()-> new OctagonalDwarfRidgeTiles(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT = registerBlock("blue_octagonal_dwarf_ridge_tiles_front",
            ()-> new OctagonalDwarfRidgeTiles(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT = registerBlock("purple_octagonal_dwarf_ridge_tiles_front",
            ()-> new OctagonalDwarfRidgeTiles(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND = registerBlock("gre_octagonal_dwarf_ridge_tiles_behind",
            ()-> new OctagonalDwarfRidgeTiles(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND = registerBlock("red_octagonal_dwarf_ridge_tiles_behind",
            ()-> new OctagonalDwarfRidgeTiles(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND = registerBlock("black_octagonal_dwarf_ridge_tiles_behind",
            ()-> new OctagonalDwarfRidgeTiles(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND = registerBlock("golden_octagonal_dwarf_ridge_tiles_behind",
            ()-> new OctagonalDwarfRidgeTiles(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND = registerBlock("cyan_octagonal_dwarf_ridge_tiles_behind",
            ()-> new OctagonalDwarfRidgeTiles(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND = registerBlock("blue_octagonal_dwarf_ridge_tiles_behind",
            ()-> new OctagonalDwarfRidgeTiles(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND = registerBlock("purple_octagonal_dwarf_ridge_tiles_behind",
            ()-> new OctagonalDwarfRidgeTiles(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));

    //八角高垂脊(前)
    public static final RegistryObject<Block> GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT = registerBlock("gre_octagonal_high_ridge_tiles_front",
            ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT = registerBlock("red_octagonal_high_ridge_tiles_front",
            ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT = registerBlock("black_octagonal_high_ridge_tiles_front",
            ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT = registerBlock("golden_octagonal_high_ridge_tiles_front",
            ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT = registerBlock("cyan_octagonal_high_ridge_tiles_front",
            ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT = registerBlock("blue_octagonal_high_ridge_tiles_front",
            ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT = registerBlock("purple_octagonal_high_ridge_tiles_front",
            ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //八角高垂脊(后)
    public static final RegistryObject<Block> GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND = registerBlock("gre_octagonal_high_ridge_tiles_behind",
            ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND = registerBlock("red_octagonal_high_ridge_tiles_behind",
            ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND = registerBlock("black_octagonal_high_ridge_tiles_behind",
            ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND = registerBlock("golden_octagonal_high_ridge_tiles_behind",
            ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND = registerBlock("cyan_octagonal_high_ridge_tiles_behind",
            ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND = registerBlock("blue_octagonal_high_ridge_tiles_behind",
            ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND = registerBlock("purple_octagonal_high_ridge_tiles_behind",
            ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));

    //八角双层垂脊
    public static final RegistryObject<Block> GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT =
            registerBlock("gre_octagonal_double_gable_ridge_cylinder_tile_front",
                    ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT =
            registerBlock("red_octagonal_double_gable_ridge_cylinder_tile_front",
                    ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT =
            registerBlock("black_octagonal_double_gable_ridge_cylinder_tile_front",
                    ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT =
            registerBlock("golden_octagonal_double_gable_ridge_cylinder_tile_front",
                    ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT =
            registerBlock("cyan_octagonal_double_gable_ridge_cylinder_tile_front",
                    ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT =
            registerBlock("blue_octagonal_double_gable_ridge_cylinder_tile_front",
                    ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT =
            registerBlock("purple_octagonal_double_gable_ridge_cylinder_tile_front",
                    ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND =
            registerBlock("gre_octagonal_double_gable_ridge_cylinder_tile_behind",
                    ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND =
            registerBlock("red_octagonal_double_gable_ridge_cylinder_tile_behind",
                    ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND =
            registerBlock("black_octagonal_double_gable_ridge_cylinder_tile_behind",
                    ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND =
            registerBlock("golden_octagonal_double_gable_ridge_cylinder_tile_behind",
                    ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND =
            registerBlock("cyan_octagonal_double_gable_ridge_cylinder_tile_behind",
                    ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND =
            registerBlock("blue_octagonal_double_gable_ridge_cylinder_tile_behind",
                    ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND =
            registerBlock("purple_octagonal_double_gable_ridge_cylinder_tile_behind",
                    ()-> new OctagonalDoubleGableRidgeCylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));

    //八角垂脊
    public static final RegistryObject<Block> GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE = registerBlock("gre_octagonal_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE = registerBlock("red_octagonal_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE = registerBlock("black_octagonal_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE = registerBlock("golden_octagonal_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE = registerBlock("cyan_octagonal_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE = registerBlock("blue_octagonal_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE = registerBlock("purple_octagonal_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //双层垂脊
    public static final RegistryObject<Block> GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE = registerBlock("gre_double_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE = registerBlock("red_double_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE = registerBlock("black_double_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE = registerBlock("golden_double_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE = registerBlock("cyan_double_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE = registerBlock("blue_double_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE = registerBlock("purple_double_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE = registerBlock("gre_double_hanging_beast_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE = registerBlock("red_double_hanging_beast_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE = registerBlock("black_double_hanging_beast_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE = registerBlock("golden_double_hanging_beast_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE = registerBlock("cyan_double_hanging_beast_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE = registerBlock("blue_double_hanging_beast_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE = registerBlock("purple_double_hanging_beast_gable_ridge_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //短琉璃瓦
    public static final RegistryObject<Block> GRE_SHORT_CYLINDER_TILE = registerBlock("gre_short_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_SHORT_CYLINDER_TILE = registerBlock("red_short_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_SHORT_CYLINDER_TILE = registerBlock("black_short_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_SHORT_CYLINDER_TILE = registerBlock("golden_short_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_SHORT_CYLINDER_TILE = registerBlock("cyan_short_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_SHORT_CYLINDER_TILE = registerBlock("blue_short_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_SHORT_CYLINDER_TILE = registerBlock("purple_short_cylinder_tile",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //侧双层琉璃瓦
    public static final RegistryObject<Block> GRE_DOUBLE_CYLINDER_TILE_SIDE = registerBlock("gre_double_cylinder_tile_side",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_DOUBLE_CYLINDER_TILE_SIDE = registerBlock("red_double_cylinder_tile_side",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_DOUBLE_CYLINDER_TILE_SIDE = registerBlock("black_double_cylinder_tile_side",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_DOUBLE_CYLINDER_TILE_SIDE = registerBlock("golden_double_cylinder_tile_side",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> CYAN_DOUBLE_CYLINDER_TILE_SIDE = registerBlock("cyan_double_cylinder_tile_side",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_DOUBLE_CYLINDER_TILE_SIDE = registerBlock("blue_double_cylinder_tile_side",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> PURPLE_DOUBLE_CYLINDER_TILE_SIDE = registerBlock("purple_double_cylinder_tile_side",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    //瓦片
    public static final RegistryObject<Block> GOLDEN_TILE = registerBlock("golden_tile",
            ()-> new SheetTiles(Blocks.STONE_STAIRS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_GENTLE_TILE = registerBlock("golden_gentle_tile",
            ()-> new SheetGentleTiles(Blocks.STONE_STAIRS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_CORNICES = registerBlock("golden_cornices",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_GENTLE_CORNICES = registerBlock("golden_gentle_cornices",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_TILE_BLOCK_2 = registerBlock("golden_tile_block_2",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_TILE_BLOCK_3 = registerBlock("golden_tile_block_3",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_TILE_BLOCK_4 = registerBlock("golden_tile_block_4",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> BLACK_TILE = registerBlock("black_tile",
            ()-> new SheetTiles(Blocks.STONE_STAIRS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistryObject<Block> BLACK_GENTLE_TILE = registerBlock("black_gentle_tile",
            ()-> new SheetGentleTiles(Blocks.STONE_STAIRS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistryObject<Block> BLACK_CORNICES = registerBlock("black_cornices",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_GENTLE_CORNICES = registerBlock("black_gentle_cornices",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> TILE_BLOCK_2 = registerBlock("tile_block_2",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> TILE_BLOCK_3 = registerBlock("tile_block_3",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> TILE_BLOCK_4 = registerBlock("tile_block_4",
            ()-> new CylinderTile(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));

    // 门
    public static final RegistryObject<Block> DOOR_BIRCH = registerBlock("door_birch",
            ()-> new DoorsBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_DOOR), BlockSetType.BIRCH));
    public static final RegistryObject<Block> DOOR_ACACIA = registerBlock("door_acacia",
            ()-> new DoorsBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_DOOR), BlockSetType.ACACIA));
    public static final RegistryObject<Block> DOOR_DARK_OAK = registerBlock("door_dark_oak",
            ()-> new DoorsBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_DOOR), BlockSetType.DARK_OAK));
    public static final RegistryObject<Block> DOOR_OAK = registerBlock("door_oak",
            ()-> new DoorsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final RegistryObject<Block> DOOR_SPRUCE = registerBlock("door_spruce",
            ()-> new DoorsBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_DOOR), BlockSetType.SPRUCE));

    public static final RegistryObject<Block> MEI_REN_KAO_ACACIA_BLOCK = registerBlock("mei_ren_kao_acacia_block",
            ()-> new MeiRenKaoBlock(Blocks.ACACIA_WOOD.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));
    public static final RegistryObject<Block> MEI_REN_KAO_DARK_OAK_BLOCK = registerBlock("mei_ren_kao_dark_oak_block",
            ()-> new MeiRenKaoBlock(Blocks.ACACIA_WOOD.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));
    public static final RegistryObject<Block> MEI_REN_KAO_OAK_BLOCK = registerBlock("mei_ren_kao_oak_block",
            ()-> new MeiRenKaoBlock(Blocks.ACACIA_WOOD.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));
    public static final RegistryObject<Block> MEI_REN_KAO_SPRUCE_BLOCK = registerBlock("mei_ren_kao_spruce_block",
            ()-> new MeiRenKaoBlock(Blocks.ACACIA_WOOD.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));
    public static final RegistryObject<Block> MEI_REN_KAO_BIRCH_BLOCK = registerBlock("mei_ren_kao_birch_block",
            ()-> new MeiRenKaoBlock(Blocks.ACACIA_WOOD.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));
    public static final RegistryObject<Block> MEI_REN_KAO_JUNGLE_BLOCK = registerBlock("mei_ren_kao_jungle_block",
            ()-> new MeiRenKaoBlock(Blocks.ACACIA_WOOD.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));
    public static final RegistryObject<Block> MEI_REN_KAO_MANGROVE_BLOCK = registerBlock("mei_ren_kao_mangrove_block",
            ()-> new MeiRenKaoBlock(Blocks.ACACIA_WOOD.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));
    public static final RegistryObject<Block> MEI_REN_KAO_CHERRY_BLOCK = registerBlock("mei_ren_kao_cherry_block",
            ()-> new MeiRenKaoBlock(Blocks.ACACIA_WOOD.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));
    public static final RegistryObject<Block> MEI_REN_KAO_CRIMSON_BLOCK = registerBlock("mei_ren_kao_crimson_block",
            ()-> new MeiRenKaoBlock(Blocks.ACACIA_WOOD.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));
    public static final RegistryObject<Block> MEI_REN_KAO_WARPED_BLOCK = registerBlock("mei_ren_kao_warped_block",
            ()-> new MeiRenKaoBlock(Blocks.ACACIA_WOOD.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

    //窗户
    public static final RegistryObject<Block> WINDOWS_BIRCH_BLOCK = registerBlock("windows_birch_block",
            ()-> new Windows(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).strength(0.5F).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_BIRCH_BLOCK_1 = registerBlock("windows_birch_block_1",
            ()-> new Windows(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).strength(0.5F).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_ACACIA_BLOCK = registerBlock("windows_acacia_block",
            ()-> new Windows(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).strength(0.5F).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_ACACIA_BLOCK_1 = registerBlock("windows_acacia_block_1",
            ()-> new Windows(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).strength(0.5F).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_DARK_OAK_BLOCK = registerBlock("windows_dark_oak_block",
            ()-> new Windows(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).strength(0.5F).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_DARK_OAK_BLOCK_1 = registerBlock("windows_dark_oak_block_1",
            ()-> new Windows(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).strength(0.5F).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_OAK_BLOCK = registerBlock("windows_oak_block",
            ()-> new Windows(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(0.5F).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_OAK_BLOCK_1 = registerBlock("windows_oak_block_1",
            ()-> new Windows(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(0.5F).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_SPRUCE_BLOCK = registerBlock("windows_spruce_block",
            ()-> new Windows(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).strength(0.5F).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_SPRUCE_BLOCK_1 = registerBlock("windows_spruce_block_1",
            ()-> new Windows(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).strength(0.5F).noOcclusion()));

    public static final RegistryObject<Block> HIGH_BIRCH_WINDOWS = registerBlock("high_birch_windows",
            ()-> new HighWindows(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.BIRCH));
    public static final RegistryObject<Block> HIGH_ACACIA_WINDOWS = registerBlock("high_acacia_windows",
            ()-> new HighWindows(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR),BlockSetType.ACACIA));
    public static final RegistryObject<Block> HIGH_DARK_OAK_WINDOWS = registerBlock("high_dark_oak_windows",
            ()-> new HighWindows(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR),BlockSetType.DARK_OAK));
    public static final RegistryObject<Block> HIGH_OAK_WINDOWS = registerBlock("high_oak_windows",
            ()-> new HighWindows(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR),BlockSetType.OAK));
    public static final RegistryObject<Block> HIGH_SPRUCE_WINDOWS = registerBlock("high_spruce_windows",
            ()-> new HighWindows(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR),BlockSetType.SPRUCE));

    //方块
    public static final RegistryObject<Block> HANG_TU_WALL = registerBlock("hang_tu_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.copy(HANG_TU_BLOCK.get()).forceSolidOn()));
    public static final RegistryObject<Block> TU_PEI_WALL = registerBlock("tu_pei_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.copy(TU_PEI_BLOCK.get()).forceSolidOn()));
    public static final RegistryObject<Block> WHITE_WALLS_BLOCK = registerBlock("white_walls_block", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> COOL_WHITE_WALLS_BLOCK = registerBlock("cool_white_walls_block", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> WARM_WHITE_WALLS_BLOCK = registerBlock("warm_white_walls_block", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> WHITE_FINE_BRICKS = registerBlock("white_fine_bricks", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> WHITE_BRICKS = registerBlock("white_bricks", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> BLACK_STONE_FINE_BRICKS = registerBlock("black_stone_fine_bricks", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> BLACK_STONE_BRICKS = registerBlock("black_stone_bricks", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> BLUE_STONE_FINE_BRICKS = registerBlock("blue_stone_fine_bricks", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> BLUE_STONE_BRICKS = registerBlock("blue_stone_bricks", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> WHITE_JADE_BLOCK = registerBlock("white_jade_block", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> WHITE_JADE_WALL = registerBlock("white_jade_wall", ()-> new WallBlock(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WHITE_JADE_BLOCK.get())));

    public static final RegistryObject<Block> BITUMEN_FLOOR_TILES_BLOCK = registerBlock("bitumen_floor_tiles_block", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> BLUE_FLOOR_TILES_BLOCK = registerBlock("blue_floor_tiles_block", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).forceSolidOn()));
    public static final RegistryObject<Block> BLACK_FLOOR_TILES_BLOCK = registerBlock("black_floor_tiles_block", ()-> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).forceSolidOn()));
    //楼梯
    public static final RegistryObject<Block> WHITE_JADE_STAIRS = registerBlock("white_jade_stairs",
            ()-> new StairBlock(()-> ChangShengJueBlocks.WHITE_JADE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ChangShengJueBlocks.WHITE_JADE_BLOCK.get())));
    public static final RegistryObject<Block> HANG_TU_STAIRS = registerBlock("hang_tu_stairs",
            ()-> new StairBlock(()-> ChangShengJueBlocks.HANG_TU_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> TU_PEI_STAIRS = registerBlock("tu_pei_stairs",
            ()-> new StairBlock(()-> ChangShengJueBlocks.TU_PEI_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> WHITE_BRICKS_STAIRS = registerBlock("white_bricks_stairs",
            ()-> new StairBlock(()-> ChangShengJueBlocks.WHITE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ChangShengJueBlocks.WHITE_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_STONE_BRICKS_STAIRS = registerBlock("black_stone_bricks_stairs",
            ()-> new StairBlock(()-> ChangShengJueBlocks.BLACK_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ChangShengJueBlocks.BLACK_STONE_BRICKS.get())));
    public static final RegistryObject<Block> BLUE_STONE_BRICKS_STAIRS = registerBlock("blue_stone_bricks_stairs",
            ()-> new StairBlock(()-> ChangShengJueBlocks.BLUE_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ChangShengJueBlocks.BLUE_STONE_BRICKS.get())));

    //栏杆
    public static final RegistryObject<Block> WHITE_JADE_BALUSTRADE = registerBlock("white_jade_balustrade",
            ()-> new Balustrade(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WHITE_JADE_BLOCK.get()).instrument(NoteBlockInstrument.BASEDRUM)));
    public static final RegistryObject<Block> WHITE_JADE_GUARDRAIL = registerBlock("white_jade_guardrail",
            ()-> new Guardrail(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WHITE_JADE_BLOCK.get()).instrument(NoteBlockInstrument.BASEDRUM)));

    public static final RegistryObject<Block> STONE_BALUSTRADE = registerBlock("stone_balustrade",
            ()-> new StoneBalustrade(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion().instrument(NoteBlockInstrument.BASEDRUM)));

    public static final RegistryObject<Block> OAK_BALUSTRADE = registerBlock("oak_balustrade",
            ()-> new WoodenBalustrade(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));

    public static final RegistryObject<Block> SPRUCE_BALUSTRADE = registerBlock("spruce_balustrade",
            ()-> new WoodenBalustrade(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE_GATE)));

    public static final RegistryObject<Block> BIRCH_BALUSTRADE = registerBlock("birch_balustrade",
            ()-> new WoodenBalustrade(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE_GATE)));

    public static final RegistryObject<Block> JUNGLE_BALUSTRADE = registerBlock("jungle_balustrade",
            ()-> new WoodenBalustrade(BlockBehaviour.Properties.copy(Blocks.JUNGLE_FENCE_GATE)));

    public static final RegistryObject<Block> ACACIA_BALUSTRADE = registerBlock("acacia_balustrade",
            ()-> new WoodenBalustrade(BlockBehaviour.Properties.copy(Blocks.ACACIA_FENCE_GATE)));

    public static final RegistryObject<Block> MANGROVE_BALUSTRADE = registerBlock("mangrove_balustrade",
            ()-> new WoodenBalustrade(BlockBehaviour.Properties.copy(Blocks.MANGROVE_FENCE_GATE)));

    public static final RegistryObject<Block> CHERRY_BALUSTRADE = registerBlock("cherry_balustrade",
            ()-> new WoodenBalustrade(BlockBehaviour.Properties.copy(Blocks.CHERRY_FENCE_GATE)));

    public static final RegistryObject<Block> DARK_OAK_BALUSTRADE = registerBlock("dark_oak_balustrade",
            ()-> new WoodenBalustrade(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_FENCE_GATE)));

    public static final RegistryObject<Block> CRIMSON_BALUSTRADE = registerBlock("crimson_balustrade",
            ()-> new WoodenBalustrade(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE_GATE)));

    public static final RegistryObject<Block> WARPED_BALUSTRADE = registerBlock("warped_balustrade",
            ()-> new WoodenBalustrade(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE_GATE)));

    //台阶
    public static final RegistryObject<Block> WHITE_JADE_SLAB =  registerBlock("white_jade_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WHITE_JADE_BLOCK.get())));
    public static final RegistryObject<Block> HANG_TU_SLAB = registerBlock("hang_tu_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(ChangShengJueBlocks.HANG_TU_BLOCK.get())));
    public static final RegistryObject<Block> TU_PEI_SLAB = registerBlock("tu_pei_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(ChangShengJueBlocks.TU_PEI_BLOCK.get())));
    public static final RegistryObject<Block> WHITE_BRICKS_SLAB = registerBlock("white_bricks_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WHITE_BRICKS.get())));
    public static final RegistryObject<Block> BLACK_STONE_BRICKS_SLAB = registerBlock("black_stone_bricks_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(ChangShengJueBlocks.BLACK_STONE_BRICKS.get())));
    public static final RegistryObject<Block> BLUE_STONE_BRICKS_SLAB = registerBlock("blue_stone_bricks_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(ChangShengJueBlocks.BLUE_STONE_BRICKS.get())));

    //竖墙
    public static final RegistryObject<Block> WHITE_BRICKS_VERTICAL_WALLS = registerBlock("white_bricks_vertical_walls",
            ()-> new VerticalWalls(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WHITE_BRICKS.get()).noOcclusion()));
    public static final RegistryObject<Block> BLACK_STONE_VERTICAL_WALLS = registerBlock("black_stone_vertical_walls",
            ()-> new VerticalWalls(BlockBehaviour.Properties.copy(ChangShengJueBlocks.BLACK_STONE_BRICKS.get()).noOcclusion()));
    public static final RegistryObject<Block> BLUE_STONE_VERTICAL_WALLS = registerBlock("blue_stone_vertical_walls",
            ()-> new VerticalWalls(BlockBehaviour.Properties.copy(ChangShengJueBlocks.BLUE_STONE_BRICKS.get()).noOcclusion()));

    //霸王拳
    public static final RegistryObject<Block> MANGROVE_OVERLORD_FIST = registerBlock("mangrove_overlord_fist",
            ()-> new OverLordFist(Block.Properties.copy(Blocks.MANGROVE_PLANKS).noCollission()));
    public static final RegistryObject<Block> BIRCH_OVERLORD_FIST = registerBlock("birch_overlord_fist",
            ()-> new OverLordFist(Block.Properties.copy(Blocks.BIRCH_PLANKS).noCollission()));
    public static final RegistryObject<Block> JUNGLE_OVERLORD_FIST = registerBlock("jungle_overlord_fist",
            ()-> new OverLordFist(Block.Properties.copy(Blocks.JUNGLE_PLANKS).noCollission()));
    public static final RegistryObject<Block> CRIMSON_OVERLORD_FIST = registerBlock("crimson_overlord_fist",
            ()-> new OverLordFist(Block.Properties.copy(Blocks.CRIMSON_PLANKS).noCollission()));
    public static final RegistryObject<Block> WARPED_OVERLORD_FIST = registerBlock("warped_overlord_fist",
            ()-> new OverLordFist(Block.Properties.copy(Blocks.WARPED_PLANKS).noCollission()));
    public static final RegistryObject<Block> ACACIA_OVERLORD_FIST = registerBlock("acacia_overlord_fist",
            ()-> new OverLordFist(Block.Properties.copy(Blocks.ACACIA_PLANKS).noCollission()));
    public static final RegistryObject<Block> DARK_OAK_OVERLORD_FIST = registerBlock("dark_oak_overlord_fist",
            ()-> new OverLordFist(Block.Properties.copy(Blocks.DARK_OAK_PLANKS).noCollission()));
    public static final RegistryObject<Block> OAK_OVERLORD_FIST = registerBlock("oak_overlord_fist",
            ()-> new OverLordFist(Block.Properties.copy(Blocks.OAK_PLANKS).noCollission()));
    public static final RegistryObject<Block> CHERRY_OVERLORD_FIST = registerBlock("cherry_overlord_fist",
            ()-> new OverLordFist(Block.Properties.copy(Blocks.CHERRY_PLANKS).noCollission()));
    public static final RegistryObject<Block> SPRUCE_OVERLORD_FIST = registerBlock("spruce_overlord_fist",
            ()-> new OverLordFist(Block.Properties.copy(Blocks.SPRUCE_PLANKS).noCollission()));
    /*雀替-短*/
    //回纹雀替
    public static final RegistryObject<Block> SHORT_MANGROVE_BACK_BRACKET = registerBlock("short_mangrove_back_bracket",
            ()-> new ChineseBracketShort(Block.Properties.copy(Blocks.MANGROVE_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_BIRCH_BACK_BRACKET = registerBlock("short_birch_back_bracket",
            ()-> new ChineseBracketShort(Block.Properties.copy(Blocks.BIRCH_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_JUNGLE_BACK_BRACKET = registerBlock("short_jungle_back_bracket",
            ()-> new ChineseBracketShort(Block.Properties.copy(Blocks.JUNGLE_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_CRIMSON_BACK_BRACKET = registerBlock("short_crimson_back_bracket",
            ()-> new ChineseBracketShort(Block.Properties.copy(Blocks.CRIMSON_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_WARPED_BACK_BRACKET = registerBlock("short_warped_back_bracket",
            ()-> new ChineseBracketShort(Block.Properties.copy(Blocks.WARPED_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_ACACIA_BACK_BRACKET = registerBlock("short_acacia_back_bracket",
            ()-> new ChineseBracketShort(Block.Properties.copy(Blocks.ACACIA_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_DARK_OAK_BACK_BRACKET = registerBlock("short_dark_oak_back_bracket",
            ()-> new ChineseBracketShort(Block.Properties.copy(Blocks.DARK_OAK_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_OAK_BACK_BRACKET = registerBlock("short_oak_back_bracket",
            ()-> new ChineseBracketShort(Block.Properties.copy(Blocks.OAK_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_CHERRY_BACK_BRACKET = registerBlock("short_cherry_back_bracket",
            ()-> new ChineseBracketShort(Block.Properties.copy(Blocks.CHERRY_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_SPRUCE_BACK_BRACKET = registerBlock("short_spruce_back_bracket",
            ()-> new ChineseBracketShort(Block.Properties.copy(Blocks.SPRUCE_PLANKS).noCollission()));
    //花牙子雀替
    public static final RegistryObject<Block> SHORT_MANGROVE_FLOWER_BRACKET = registerBlock("short_mangrove_flower_bracket",
            ()-> new ChineseFlowerBracketShort(Block.Properties.copy(Blocks.MANGROVE_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_BIRCH_FLOWER_BRACKET = registerBlock("short_birch_flower_bracket",
            ()-> new ChineseFlowerBracketShort(Block.Properties.copy(Blocks.BIRCH_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_JUNGLE_FLOWER_BRACKET = registerBlock("short_jungle_flower_bracket",
            ()-> new ChineseFlowerBracketShort(Block.Properties.copy(Blocks.JUNGLE_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_CRIMSON_FLOWER_BRACKET = registerBlock("short_crimson_flower_bracket",
            ()-> new ChineseFlowerBracketShort(Block.Properties.copy(Blocks.CRIMSON_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_WARPED_FLOWER_BRACKET = registerBlock("short_warped_flower_bracket",
            ()-> new ChineseFlowerBracketShort(Block.Properties.copy(Blocks.WARPED_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_ACACIA_FLOWER_BRACKET = registerBlock("short_acacia_flower_bracket",
            ()-> new ChineseFlowerBracketShort(Block.Properties.copy(Blocks.ACACIA_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_DARK_OAK_FLOWER_BRACKET = registerBlock("short_dark_oak_flower_bracket",
            ()-> new ChineseFlowerBracketShort(Block.Properties.copy(Blocks.DARK_OAK_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_OAK_FLOWER_BRACKET = registerBlock("short_oak_flower_bracket",
            ()-> new ChineseFlowerBracketShort(Block.Properties.copy(Blocks.OAK_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_CHERRY_FLOWER_BRACKET = registerBlock("short_cherry_flower_bracket",
            ()-> new ChineseFlowerBracketShort(Block.Properties.copy(Blocks.CHERRY_PLANKS).noCollission()));
    public static final RegistryObject<Block> SHORT_SPRUCE_FLOWER_BRACKET = registerBlock("short_spruce_flower_bracket",
            ()-> new ChineseFlowerBracketShort(Block.Properties.copy(Blocks.SPRUCE_PLANKS).noCollission()));
    /*雀替-长*/
    public static final RegistryObject<Block> LONG_MANGROVE_BACK_BRACKET = registerBlock("long_mangrove_back_bracket",
            ()-> new ChineseBracketLong(Block.Properties.copy(Blocks.MANGROVE_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_BIRCH_BACK_BRACKET = registerBlock("long_birch_back_bracket",
            ()-> new ChineseBracketLong(Block.Properties.copy(Blocks.BIRCH_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_JUNGLE_BACK_BRACKET = registerBlock("long_jungle_back_bracket",
            ()-> new ChineseBracketLong(Block.Properties.copy(Blocks.JUNGLE_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_CRIMSON_BACK_BRACKET = registerBlock("long_crimson_back_bracket",
            ()-> new ChineseBracketLong(Block.Properties.copy(Blocks.CRIMSON_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_WARPED_BACK_BRACKET = registerBlock("long_warped_back_bracket",
            ()-> new ChineseBracketLong(Block.Properties.copy(Blocks.WARPED_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_ACACIA_BACK_BRACKET = registerBlock("long_acacia_back_bracket",
            ()-> new ChineseBracketLong(Block.Properties.copy(Blocks.ACACIA_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_DARK_OAK_BACK_BRACKET = registerBlock("long_dark_oak_back_bracket",
            ()-> new ChineseBracketLong(Block.Properties.copy(Blocks.DARK_OAK_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_OAK_BACK_BRACKET = registerBlock("long_oak_back_bracket",
            ()-> new ChineseBracketLong(Block.Properties.copy(Blocks.OAK_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_CHERRY_BACK_BRACKET = registerBlock("long_cherry_back_bracket",
            ()-> new ChineseBracketLong(Block.Properties.copy(Blocks.CHERRY_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_SPRUCE_BACK_BRACKET = registerBlock("long_spruce_back_bracket",
            ()-> new ChineseBracketLong(Block.Properties.copy(Blocks.SPRUCE_PLANKS).noCollission()));
    //花牙子雀替
    public static final RegistryObject<Block> LONG_MANGROVE_FLOWER_BRACKET = registerBlock("long_mangrove_flower_bracket",
            ()-> new ChineseFlowerBracketLong(Block.Properties.copy(Blocks.MANGROVE_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_BIRCH_FLOWER_BRACKET = registerBlock("long_birch_flower_bracket",
            ()-> new ChineseFlowerBracketLong(Block.Properties.copy(Blocks.BIRCH_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_JUNGLE_FLOWER_BRACKET = registerBlock("long_jungle_flower_bracket",
            ()-> new ChineseFlowerBracketLong(Block.Properties.copy(Blocks.JUNGLE_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_CRIMSON_FLOWER_BRACKET = registerBlock("long_crimson_flower_bracket",
            ()-> new ChineseFlowerBracketLong(Block.Properties.copy(Blocks.CRIMSON_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_WARPED_FLOWER_BRACKET = registerBlock("long_warped_flower_bracket",
            ()-> new ChineseFlowerBracketLong(Block.Properties.copy(Blocks.WARPED_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_ACACIA_FLOWER_BRACKET = registerBlock("long_acacia_flower_bracket",
            ()-> new ChineseFlowerBracketLong(Block.Properties.copy(Blocks.ACACIA_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_DARK_OAK_FLOWER_BRACKET = registerBlock("long_dark_oak_flower_bracket",
            ()-> new ChineseFlowerBracketLong(Block.Properties.copy(Blocks.DARK_OAK_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_OAK_FLOWER_BRACKET = registerBlock("long_oak_flower_bracket",
            ()-> new ChineseFlowerBracketLong(Block.Properties.copy(Blocks.OAK_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_CHERRY_FLOWER_BRACKET = registerBlock("long_cherry_flower_bracket",
            ()-> new ChineseFlowerBracketLong(Block.Properties.copy(Blocks.CHERRY_PLANKS).noCollission()));
    public static final RegistryObject<Block> LONG_SPRUCE_FLOWER_BRACKET = registerBlock("long_spruce_flower_bracket",
            ()-> new ChineseFlowerBracketLong(Block.Properties.copy(Blocks.SPRUCE_PLANKS).noCollission()));
    //斗拱
    public static final RegistryObject<Block> MANGROVE_DOUGONG = registerBlock("mangrove_dougong",
            ()-> new Dougong(Block.Properties.copy(Blocks.MANGROVE_PLANKS).noCollission()));
    public static final RegistryObject<Block> BIRCH_DOUGONG = registerBlock("birch_dougong",
            ()-> new Dougong(Block.Properties.copy(Blocks.BIRCH_PLANKS).noCollission()));
    public static final RegistryObject<Block> JUNGLE_DOUGONG = registerBlock("jungle_dougong",
            ()-> new Dougong(Block.Properties.copy(Blocks.JUNGLE_PLANKS).noCollission()));
    public static final RegistryObject<Block> CRIMSON_DOUGONG = registerBlock("crimson_dougong",
            ()-> new Dougong(Block.Properties.copy(Blocks.CRIMSON_PLANKS).noCollission()));
    public static final RegistryObject<Block> WARPED_DOUGONG = registerBlock("warped_dougong",
            ()-> new Dougong(Block.Properties.copy(Blocks.WARPED_PLANKS).noCollission()));
    public static final RegistryObject<Block> ACACIA_DOUGONG = registerBlock("acacia_dougong",
            ()-> new Dougong(Block.Properties.copy(Blocks.ACACIA_PLANKS).noCollission()));
    public static final RegistryObject<Block> DARK_OAK_DOUGONG = registerBlock("dark_oak_dougong",
            ()-> new Dougong(Block.Properties.copy(Blocks.DARK_OAK_PLANKS).noCollission()));
    public static final RegistryObject<Block> OAK_DOUGONG = registerBlock("oak_dougong",
            ()-> new Dougong(Block.Properties.copy(Blocks.OAK_PLANKS).noCollission()));
    public static final RegistryObject<Block> CHERRY_DOUGONG = registerBlock("cherry_dougong",
            ()-> new Dougong(Block.Properties.copy(Blocks.CHERRY_PLANKS).noCollission()));
    public static final RegistryObject<Block> SPRUCE_DOUGONG = registerBlock("spruce_dougong",
            ()-> new Dougong(Block.Properties.copy(Blocks.SPRUCE_PLANKS).noCollission()));
    //绿、青斗拱
    public static final RegistryObject<Block> GREEN_DOUGONG = registerBlock("green_dougong", ()-> new Dougong(Block.Properties.copy(Blocks.STONE).noCollission()));
    public static final RegistryObject<Block> BLUE_DOUGONG = registerBlock("blue_dougong", ()-> new Dougong(Block.Properties.copy(Blocks.STONE).noCollission()));

    //矿石
    public static final RegistryObject<Block> AG_ORE = registerBlock("ag_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().mapColor(MapColor.STONE).strength(3.0F, 6.0F)));
    public static final RegistryObject<Block> DEEPSLATE_AG_ORE = registerBlock("deepslate_ag_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(ChangShengJueBlocks.AG_ORE.get().defaultBlockState().getBlock()).mapColor(MapColor.DEEPSLATE).
                    strength(4.5F, 6.0F).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> KAOLIN_ORE = registerBlock("kaolin_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).mapColor(MapColor.STONE)));

    public static final RegistryObject<Block> LIMESTONE = registerBlock("limestone",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> SYDEROLIFE_ORE = registerBlock("syderolife_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> NATURAL_ASPHALT_ORE = registerBlock("natural_asphalt_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().mapColor(MapColor.STONE).strength(1.5F, 6.0F)));

    //织布机
    public static final RegistryObject<Block> CHANG_SHENG_JUE_LOOM = registerBlock("chang_sheng_jue_loom",
            ()-> new ChangShengJueLoomBlock(BlockBehaviour.Properties.copy(Blocks.LOOM).noOcclusion()));
    //工作方块
    public static final RegistryObject<Block> POTTERY_WHEEL = registerBlock("pottery_wheel",
            ()-> new PotteryWheel(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.WOOD).mapColor(MapColor.WOOD).noOcclusion()));

    public static final RegistryObject<Block> TOOL_TABLE = registerBlock("tool_table",
            ()-> new ToolTable(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.WOOD).mapColor(MapColor.WOOD).noOcclusion()));

    public static final RegistryObject<Block> WEAPON_RACK = registerBlock("weapon_rack",
            ()-> new WeaponRack(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.WOOD).mapColor(MapColor.WOOD).noOcclusion()));

    public static final RegistryObject<Block> DESK = registerBlock("desk",
            ()-> new Desk(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.WOOD).mapColor(MapColor.WOOD).noOcclusion()));

    public static final RegistryObject<Block> PIG_TROUGH = registerBlock("pig_trough",
            ()-> new PigTrough(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(0.6F).sound(SoundType.WOOD).ignitedByLava().noOcclusion()));
    //砖窑炉
    public static final RegistryObject<Block> BRICK_KILN = registerBlock("brick_kiln",
            ()-> new BrickKiln(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5F).lightLevel(litBlockEmission(13)).noOcclusion()));
    //大门
    public static final RegistryObject<Block> SHING_MUN_LEFT = registerBlock("shing_mun_left",
            ()-> new ShingMunLeft(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.WOOD).mapColor(MapColor.COLOR_RED)));

    public static final RegistryObject<Block> SHING_MUN_RIGHT = registerBlock("shing_mun_right",
            ()-> new ShingMunRight(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.WOOD).mapColor(MapColor.COLOR_RED)));

    public static final RegistryObject<Block> BIG_SHING_MUN_LEFT = registerBlock("big_shing_mun_left",
            ()-> new BigShingMunLeft(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.WOOD).mapColor(MapColor.COLOR_RED)));

    public static final RegistryObject<Block> BIG_SHING_MUN_RIGHT = registerBlock("big_shing_mun_right",
            ()-> new BigShingMunRight(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.WOOD).mapColor(MapColor.COLOR_RED)));

    //浇铸模具
    public static final RegistryObject<Block> CASTING_MOLDS = registerBlock("casting_molds",
            ()-> new CastingMolds(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.STONE).mapColor(MapColor.STONE)));

    public static final RegistryObject<Block> BULLIONS_CASTING_MOLDS = registerBlock("bullions_casting_molds",
            ()-> new BullionsCastingMolds(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.STONE).mapColor(MapColor.STONE)));

    //家具
    //酒桌
    public static final RegistryObject<Block> BIRCH_WINE_TABLE = registerBlock("birch_wine_table",
            ()-> new WineTable(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_WINE_TABLE = registerBlock("jungle_wine_table",
            ()-> new WineTable(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_WINE_TABLE = registerBlock("crimson_wine_table",
            ()-> new WineTable(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_WINE_TABLE = registerBlock("warped_wine_table",
            ()-> new WineTable(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_WINE_TABLE = registerBlock("mangrove_wine_table",
            ()-> new WineTable(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_WINE_TABLE = registerBlock("huang_hua_li_wine_table",
            ()-> new WineTable(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JI_CHI_MU_WINE_TABLE = registerBlock("ji_chi_mu_wine_table",
            ()-> new WineTable(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_WINE_TABLE = registerBlock("acacia_wine_table",
            ()-> new WineTable(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_WINE_TABLE = registerBlock("dark_oak_wine_table",
            ()-> new WineTable(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_WINE_TABLE = registerBlock("oak_wine_table",
            ()-> new WineTable(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_WINE_TABLE = registerBlock("cherry_wine_table",
            ()-> new WineTable(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_WINE_TABLE = registerBlock("spruce_wine_table",
            ()-> new WineTable(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_WINE_TABLE = registerBlock("zi_tan_wine_table",
            ()-> new WineTable(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    //酒桌椅
    public static final RegistryObject<Block> BIRCH_DRINKING_TABLE_AND_CHAIRS = registerBlock("birch_drinking_table_and_chairs",
            ()-> new DrinkingTableAndChairs(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_DRINKING_TABLE_AND_CHAIRS = registerBlock("jungle_drinking_table_and_chairs",
            ()-> new DrinkingTableAndChairs(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_DRINKING_TABLE_AND_CHAIRS = registerBlock("crimson_drinking_table_and_chairs",
            ()-> new DrinkingTableAndChairs(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_DRINKING_TABLE_AND_CHAIRS = registerBlock("warped_drinking_table_and_chairs",
            ()-> new DrinkingTableAndChairs(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_DRINKING_TABLE_AND_CHAIRS = registerBlock("mangrove_drinking_table_and_chairs",
            ()-> new DrinkingTableAndChairs(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_DRINKING_TABLE_AND_CHAIRS = registerBlock("huang_hua_li_drinking_table_and_chairs",
            ()-> new DrinkingTableAndChairs(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JI_CHI_MU_DRINKING_TABLE_AND_CHAIRS = registerBlock("ji_chi_mu_drinking_table_and_chairs",
            ()-> new DrinkingTableAndChairs(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_DRINKING_TABLE_AND_CHAIRS = registerBlock("acacia_drinking_table_and_chairs",
            ()-> new DrinkingTableAndChairs(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_DRINKING_TABLE_AND_CHAIRS = registerBlock("dark_oak_drinking_table_and_chairs",
            ()-> new DrinkingTableAndChairs(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_DRINKING_TABLE_AND_CHAIRS = registerBlock("oak_drinking_table_and_chairs",
            ()-> new DrinkingTableAndChairs(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_DRINKING_TABLE_AND_CHAIRS = registerBlock("cherry_drinking_table_and_chairs",
            ()-> new DrinkingTableAndChairs(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_DRINKING_TABLE_AND_CHAIRS = registerBlock("spruce_drinking_table_and_chairs",
            ()-> new DrinkingTableAndChairs(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_DRINKING_TABLE_AND_CHAIRS = registerBlock("zi_tan_drinking_table_and_chairs",
            ()-> new DrinkingTableAndChairs(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    //方凳
    public static final RegistryObject<Block> BIRCH_SQUARE_STOOL = registerBlock("birch_square_stool",
            ()-> new SquareStool(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_SQUARE_STOOL = registerBlock("jungle_square_stool",
            ()-> new SquareStool(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_SQUARE_STOOL = registerBlock("crimson_square_stool",
            ()-> new SquareStool(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_SQUARE_STOOL = registerBlock("warped_square_stool",
            ()-> new SquareStool(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_SQUARE_STOOL = registerBlock("mangrove_square_stool",
            ()-> new SquareStool(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_SQUARE_STOOL = registerBlock("huang_hua_li_square_stool",
            ()-> new SquareStool(BlockBehaviour.Properties.copy(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> WENGE_SQUARE_STOOL = registerBlock("wenge_square_stool",
            ()-> new SquareStool(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WENGE_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_SQUARE_STOOL = registerBlock("acacia_square_stool",
            ()-> new SquareStool(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_SQUARE_STOOL = registerBlock("dark_oak_square_stool",
            ()-> new SquareStool(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_SQUARE_STOOL = registerBlock("oak_square_stool",
            ()-> new SquareStool(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_SQUARE_STOOL = registerBlock("cherry_square_stool",
            ()-> new SquareStool(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_SQUARE_STOOL = registerBlock("spruce_square_stool",
            ()-> new SquareStool(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_SQUARE_STOOL = registerBlock("zi_tan_square_stool",
            ()-> new SquareStool(BlockBehaviour.Properties.copy(ChangShengJueBlocks.ZI_TAN_PLANKS.get()).noOcclusion()));
    //折屏
    public static final RegistryObject<Block> BIRCH_FOLDING_SCREEN = registerBlock("birch_folding_screen",
            ()-> new FoldingScreen(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_FOLDING_SCREEN = registerBlock("jungle_folding_screen",
            ()-> new FoldingScreen(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_FOLDING_SCREEN = registerBlock("crimson_folding_screen",
            ()-> new FoldingScreen(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_FOLDING_SCREEN = registerBlock("warped_folding_screen",
            ()-> new FoldingScreen(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_FOLDING_SCREEN = registerBlock("mangrove_folding_screen",
            ()-> new FoldingScreen(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_FOLDING_SCREEN = registerBlock("huang_hua_li_folding_screen",
            ()-> new FoldingScreen(BlockBehaviour.Properties.copy(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> WENGE_FOLDING_SCREEN = registerBlock("wenge_folding_screen",
            ()-> new FoldingScreen(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WENGE_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_FOLDING_SCREEN = registerBlock("acacia_folding_screen",
            ()-> new FoldingScreen(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_FOLDING_SCREEN = registerBlock("dark_oak_folding_screen",
            ()-> new FoldingScreen(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_FOLDING_SCREEN = registerBlock("oak_folding_screen",
            ()-> new FoldingScreen(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_FOLDING_SCREEN = registerBlock("cherry_folding_screen",
            ()-> new FoldingScreen(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_FOLDING_SCREEN = registerBlock("spruce_folding_screen",
            ()-> new FoldingScreen(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_FOLDING_SCREEN = registerBlock("zi_tan_folding_screen",
            ()-> new FoldingScreen(BlockBehaviour.Properties.copy(ChangShengJueBlocks.ZI_TAN_PLANKS.get()).noOcclusion()));
    //竹席
    public static final RegistryObject<Block> BAMBOO_MAT = registerBlockWithoutBlockItem("bamboo_mat",
            ()->   new BambooMat(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor((p_284863_) ->
                    p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.YELLOW.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD)
                    .strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY).forceSolidOn()));

    //罗汉床
    public static final RegistryObject<Block> BIRCH_ARHAT_BED = registerBlock("birch_arhat_bed",
            ()-> new ArhatBed(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor((p_284863_) ->
                            p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.YELLOW.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD)
                    .strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> JUNGLE_ARHAT_BED = registerBlock("jungle_arhat_bed",
            ()-> new ArhatBed(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor((p_284863_) ->
                            p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.YELLOW.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD)
                    .strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CRIMSON_ARHAT_BED = registerBlock("crimson_arhat_bed",
            ()-> new ArhatBed(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor((p_284863_) ->
                            p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.YELLOW.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD)
                    .strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WARPED_ARHAT_BED = registerBlock("warped_arhat_bed",
            ()-> new ArhatBed(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor((p_284863_) ->
                            p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.YELLOW.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD)
                    .strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> MANGROVE_ARHAT_BED = registerBlock("mangrove_arhat_bed",
            ()-> new ArhatBed(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor((p_284863_) ->
                            p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.YELLOW.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD)
                    .strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> HUANG_HUA_LI_ARHAT_BED = registerBlock("huang_hua_li_arhat_bed",
            ()-> new ArhatBed(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor((p_284863_) ->
                            p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.YELLOW.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD)
                    .strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WENGE_ARHAT_BED = registerBlock("wenge_arhat_bed",
            ()-> new ArhatBed(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor((p_284863_) ->
                            p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.YELLOW.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD)
                    .strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ACACIA_ARHAT_BED = registerBlock("acacia_arhat_bed",
            ()-> new ArhatBed(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor((p_284863_) ->
                            p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.YELLOW.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD)
                    .strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> DARK_OAK_ARHAT_BED = registerBlock("dark_oak_arhat_bed",
            ()-> new ArhatBed(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor((p_284863_) ->
                            p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.YELLOW.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD)
                    .strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> OAK_ARHAT_BED = registerBlock("oak_arhat_bed",
            ()-> new ArhatBed(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor((p_284863_) ->
                            p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.YELLOW.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD)
                    .strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CHERRY_ARHAT_BED = registerBlock("cherry_arhat_bed",
            ()-> new ArhatBed(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor((p_284863_) ->
                            p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.YELLOW.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD)
                    .strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SPRUCE_ARHAT_BED = registerBlock("spruce_arhat_bed",
            ()-> new ArhatBed(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor((p_284863_) ->
                            p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.YELLOW.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD)
                    .strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ZI_TAN_ARHAT_BED = registerBlock("zi_tan_arhat_bed",
            ()-> new ArhatBed(DyeColor.YELLOW, BlockBehaviour.Properties.of().mapColor((p_284863_) ->
                            p_284863_.getValue(BedBlock.PART) == BedPart.FOOT ? DyeColor.YELLOW.getMapColor() : MapColor.WOOL).sound(SoundType.WOOD)
                    .strength(0.2F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)));
    //架子床
    public static final RegistryObject<Block> BIRCH_CANOPY_BED = registerBlock("birch_canopy_bed",
            ()-> new CanopyBed(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_CANOPY_BED = registerBlock("jungle_canopy_bed",
            ()-> new CanopyBed(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_CANOPY_BED = registerBlock("crimson_canopy_bed",
            ()-> new CanopyBed(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_CANOPY_BED = registerBlock("warped_canopy_bed",
            ()-> new CanopyBed(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_CANOPY_BED = registerBlock("mangrove_canopy_bed",
            ()-> new CanopyBed(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_CANOPY_BED = registerBlock("huang_hua_li_canopy_bed",
            ()-> new CanopyBed(BlockBehaviour.Properties.copy(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> WENGE_CANOPY_BED = registerBlock("wenge_canopy_bed",
            ()-> new CanopyBed(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WENGE_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_CANOPY_BED = registerBlock("acacia_canopy_bed",
            ()-> new CanopyBed(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_CANOPY_BED = registerBlock("dark_oak_canopy_bed",
            ()-> new CanopyBed(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_CANOPY_BED = registerBlock("oak_canopy_bed",
            ()-> new CanopyBed(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_CANOPY_BED = registerBlock("cherry_canopy_bed",
            ()-> new CanopyBed(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_CANOPY_BED = registerBlock("spruce_canopy_bed",
            ()-> new CanopyBed(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_CANOPY_BED = registerBlock("zi_tan_canopy_bed",
            ()-> new CanopyBed(BlockBehaviour.Properties.copy(ChangShengJueBlocks.ZI_TAN_PLANKS.get()).noOcclusion()));
    //石凳
    public static final RegistryObject<Block> STONE_BENCH = registerBlock("stone_bench",
            ()-> new StoneBench(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    //石桌
    public static final RegistryObject<Block> STONE_TABLE = registerBlock("stone_table",
            ()-> new StoneTable(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    //回纹亮格
    public static final RegistryObject<Block> BIRCH_FRETWORK_OPENWORK_PANEL = registerBlock("birch_fretwork_openwork_panel",
            ()-> new FretworkOpenworkPanel(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_FRETWORK_OPENWORK_PANEL = registerBlock("jungle_fretwork_openwork_panel",
            ()-> new FretworkOpenworkPanel(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_FRETWORK_OPENWORK_PANEL = registerBlock("crimson_fretwork_openwork_panel",
            ()-> new FretworkOpenworkPanel(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_FRETWORK_OPENWORK_PANEL = registerBlock("warped_fretwork_openwork_panel",
            ()-> new FretworkOpenworkPanel(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_FRETWORK_OPENWORK_PANEL = registerBlock("mangrove_fretwork_openwork_panel",
            ()-> new FretworkOpenworkPanel(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_FRETWORK_OPENWORK_PANEL = registerBlock("huang_hua_li_fretwork_openwork_panel",
            ()-> new FretworkOpenworkPanel(BlockBehaviour.Properties.copy(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> WENGE_FRETWORK_OPENWORK_PANEL = registerBlock("wenge_fretwork_openwork_panel",
            ()-> new FretworkOpenworkPanel(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WENGE_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_FRETWORK_OPENWORK_PANEL = registerBlock("acacia_fretwork_openwork_panel",
            ()-> new FretworkOpenworkPanel(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_FRETWORK_OPENWORK_PANEL = registerBlock("dark_oak_fretwork_openwork_panel",
            ()-> new FretworkOpenworkPanel(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_FRETWORK_OPENWORK_PANEL = registerBlock("oak_fretwork_openwork_panel",
            ()-> new FretworkOpenworkPanel(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_FRETWORK_OPENWORK_PANEL = registerBlock("cherry_fretwork_openwork_panel",
            ()-> new FretworkOpenworkPanel(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_FRETWORK_OPENWORK_PANEL = registerBlock("spruce_fretwork_openwork_panel",
            ()-> new FretworkOpenworkPanel(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_FRETWORK_OPENWORK_PANEL = registerBlock("zi_tan_fretwork_openwork_panel",
            ()-> new FretworkOpenworkPanel(BlockBehaviour.Properties.copy(ChangShengJueBlocks.ZI_TAN_PLANKS.get()).noOcclusion()));
    //书格
    public static final RegistryObject<Block> BIRCH_BOOK_GRID = registerBlock("birch_book_grid",
            ()-> new BookGrid(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_BOOK_GRID = registerBlock("jungle_book_grid",
            ()-> new BookGrid(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_BOOK_GRID = registerBlock("crimson_book_grid",
            ()-> new BookGrid(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_BOOK_GRID = registerBlock("warped_book_grid",
            ()-> new BookGrid(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_BOOK_GRID = registerBlock("mangrove_book_grid",
            ()-> new BookGrid(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_BOOK_GRID = registerBlock("huang_hua_li_book_grid",
            ()-> new BookGrid(BlockBehaviour.Properties.copy(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> WENGE_BOOK_GRID = registerBlock("wenge_book_grid",
            ()-> new BookGrid(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WENGE_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_BOOK_GRID = registerBlock("acacia_book_grid",
            ()-> new BookGrid(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_BOOK_GRID = registerBlock("dark_oak_book_grid",
            ()-> new BookGrid(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_BOOK_GRID = registerBlock("oak_book_grid",
            ()-> new BookGrid(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_BOOK_GRID = registerBlock("cherry_book_grid",
            ()-> new BookGrid(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_BOOK_GRID = registerBlock("spruce_book_grid",
            ()-> new BookGrid(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_BOOK_GRID = registerBlock("zi_tan_book_grid",
            ()-> new BookGrid(BlockBehaviour.Properties.copy(ChangShengJueBlocks.ZI_TAN_PLANKS.get()).noOcclusion()));
    //亮格
    public static final RegistryObject<Block> BIRCH_LIANGGE = registerBlock("birch_liangge",
            ()-> new Liangge(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_LIANGGE = registerBlock("jungle_liangge",
            ()-> new Liangge(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_LIANGGE = registerBlock("crimson_liangge",
            ()-> new Liangge(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_LIANGGE = registerBlock("warped_liangge",
            ()-> new Liangge(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_LIANGGE = registerBlock("mangrove_liangge",
            ()-> new Liangge(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_LIANGGE = registerBlock("huang_hua_li_liangge",
            ()-> new Liangge(BlockBehaviour.Properties.copy(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> WENGE_LIANGGE = registerBlock("wenge_liangge",
            ()-> new Liangge(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WENGE_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_LIANGGE = registerBlock("acacia_liangge",
            ()-> new Liangge(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_LIANGGE = registerBlock("dark_oak_liangge",
            ()-> new Liangge(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_LIANGGE = registerBlock("oak_liangge",
            ()-> new Liangge(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_LIANGGE = registerBlock("cherry_liangge",
            ()-> new Liangge(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_LIANGGE = registerBlock("spruce_liangge",
            ()-> new Liangge(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_LIANGGE = registerBlock("zi_tan_liangge",
            ()-> new Liangge(BlockBehaviour.Properties.copy(ChangShengJueBlocks.ZI_TAN_PLANKS.get()).noOcclusion()));
    //柜子
    public static final RegistryObject<Block> BIRCH_CABINET = registerBlock("birch_cabinet",
            ()-> new Cabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_CABINET = registerBlock("jungle_cabinet",
            ()-> new Cabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_CABINET = registerBlock("crimson_cabinet",
            ()-> new Cabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> WARPED_CABINET = registerBlock("warped_cabinet",
            ()-> new Cabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_CABINET = registerBlock("mangrove_cabinet",
            ()-> new Cabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_CABINET = registerBlock("huang_hua_li_cabinet",
            ()-> new Cabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> WENGE_CABINET = registerBlock("wenge_cabinet",
            ()-> new Cabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_CABINET = registerBlock("acacia_cabinet",
            ()-> new Cabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_CABINET = registerBlock("dark_oak_cabinet",
            ()-> new Cabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> OAK_CABINET = registerBlock("oak_cabinet",
            ()-> new Cabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_CABINET = registerBlock("cherry_cabinet",
            ()-> new Cabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_CABINET = registerBlock("spruce_cabinet",
            ()-> new Cabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_CABINET = registerBlock("zi_tan_cabinet",
            ()-> new Cabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));

    public static final RegistryObject<Block> BIRCH_LARGE_CABINET = registerBlock("birch_large_cabinet",
            ()-> new LargeCabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_LARGE_CABINET = registerBlock("jungle_large_cabinet",
            ()-> new LargeCabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_LARGE_CABINET = registerBlock("crimson_large_cabinet",
            ()-> new LargeCabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> WARPED_LARGE_CABINET = registerBlock("warped_large_cabinet",
            ()-> new LargeCabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_LARGE_CABINET = registerBlock("mangrove_large_cabinet",
            ()-> new LargeCabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_LARGE_CABINET = registerBlock("huang_hua_li_large_cabinet",
            ()-> new LargeCabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> WENGE_LARGE_CABINET = registerBlock("wenge_large_cabinet",
            ()-> new LargeCabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_LARGE_CABINET = registerBlock("acacia_large_cabinet",
            ()-> new LargeCabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_LARGE_CABINET = registerBlock("dark_oak_large_cabinet",
            ()-> new LargeCabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> OAK_LARGE_CABINET = registerBlock("oak_large_cabinet",
            ()-> new LargeCabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_LARGE_CABINET = registerBlock("cherry_large_cabinet",
            ()-> new LargeCabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_LARGE_CABINET = registerBlock("spruce_large_cabinet",
            ()-> new LargeCabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_LARGE_CABINET = registerBlock("zi_tan_large_cabinet",
            ()-> new LargeCabinet(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));

    public static final RegistryObject<Block> BIRCH_CHEST_OF_DRAWERS = registerBlock("birch_chest_of_drawers",
            ()-> new ChestOfDrawers(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_CHEST_OF_DRAWERS = registerBlock("jungle_chest_of_drawers",
            ()-> new ChestOfDrawers(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_CHEST_OF_DRAWERS = registerBlock("crimson_chest_of_drawers",
            ()-> new ChestOfDrawers(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> WARPED_CHEST_OF_DRAWERS = registerBlock("warped_chest_of_drawers",
            ()-> new ChestOfDrawers(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_CHEST_OF_DRAWERS = registerBlock("mangrove_chest_of_drawers",
            ()-> new ChestOfDrawers(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_CHEST_OF_DRAWERS = registerBlock("huang_hua_li_chest_of_drawers",
            ()-> new ChestOfDrawers(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> WENGE_CHEST_OF_DRAWERS = registerBlock("wenge_chest_of_drawers",
            ()-> new ChestOfDrawers(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_CHEST_OF_DRAWERS = registerBlock("acacia_chest_of_drawers",
            ()-> new ChestOfDrawers(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_CHEST_OF_DRAWERS = registerBlock("dark_oak_chest_of_drawers",
            ()-> new ChestOfDrawers(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> OAK_CHEST_OF_DRAWERS = registerBlock("oak_chest_of_drawers",
            ()-> new ChestOfDrawers(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_CHEST_OF_DRAWERS = registerBlock("cherry_chest_of_drawers",
            ()-> new ChestOfDrawers(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_CHEST_OF_DRAWERS = registerBlock("spruce_chest_of_drawers",
            ()-> new ChestOfDrawers(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_CHEST_OF_DRAWERS = registerBlock("zi_tan_chest_of_drawers",
            ()-> new ChestOfDrawers(BlockBehaviour.Properties.copy(Blocks.CHEST).strength(2.5f).noOcclusion()));
    //晾衣杆
    public static final RegistryObject<Block> BIRCH_DRYING_RAIL = registerBlock("birch_drying_rail",
            ()-> new DryingRail(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE).noOcclusion().strength(0.5f)));
    public static final RegistryObject<Block> JUNGLE_DRYING_RAIL = registerBlock("jungle_drying_rail",
            ()-> new DryingRail(BlockBehaviour.Properties.copy(Blocks.JUNGLE_FENCE).noOcclusion().strength(0.5f)));
    public static final RegistryObject<Block> CRIMSON_DRYING_RAIL = registerBlock("crimson_drying_rail",
            ()-> new DryingRail(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE).noOcclusion().strength(0.5f)));
    public static final RegistryObject<Block> WARPED_DRYING_RAIL = registerBlock("warped_drying_rail",
            ()-> new DryingRail(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE).noOcclusion().strength(0.5f)));
    public static final RegistryObject<Block> MANGROVE_DRYING_RAIL = registerBlock("mangrove_drying_rail",
            ()-> new DryingRail(BlockBehaviour.Properties.copy(Blocks.MANGROVE_FENCE).noOcclusion().strength(0.5f)));
    public static final RegistryObject<Block> HUANG_HUA_LI_DRYING_RAIL = registerBlock("huang_hua_li_drying_rail",
            ()-> new DryingRail(BlockBehaviour.Properties.copy(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()).noOcclusion().strength(0.5f)));
    public static final RegistryObject<Block> WENGE_DRYING_RAIL = registerBlock("wenge_drying_rail",
            ()-> new DryingRail(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WENGE_PLANKS.get()).noOcclusion().strength(0.5f)));
    public static final RegistryObject<Block> ACACIA_DRYING_RAIL = registerBlock("acacia_drying_rail",
            ()-> new DryingRail(BlockBehaviour.Properties.copy(Blocks.ACACIA_FENCE).noOcclusion().strength(0.5f)));
    public static final RegistryObject<Block> DARK_OAK_DRYING_RAIL = registerBlock("dark_oak_drying_rail",
            ()-> new DryingRail(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_FENCE).noOcclusion().strength(0.5f)));
    public static final RegistryObject<Block> OAK_DRYING_RAIL = registerBlock("oak_drying_rail",
            ()-> new DryingRail(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).noOcclusion().strength(0.5f)));
    public static final RegistryObject<Block> CHERRY_DRYING_RAIL = registerBlock("cherry_drying_rail",
            ()-> new DryingRail(BlockBehaviour.Properties.copy(Blocks.CHERRY_FENCE).noOcclusion().strength(0.5f)));
    public static final RegistryObject<Block> SPRUCE_DRYING_RAIL = registerBlock("spruce_drying_rail",
            ()-> new DryingRail(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE).noOcclusion().strength(0.5f)));
    public static final RegistryObject<Block> ZI_TAN_DRYING_RAIL = registerBlock("zi_tan_drying_rail",
            ()-> new DryingRail(BlockBehaviour.Properties.copy(ChangShengJueBlocks.ZI_TAN_PLANKS.get()).noOcclusion().strength(0.5f)));
    //衣架
    public static final RegistryObject<Block> BIRCH_CLOTHES_RACK = registerBlock("birch_clothes_rack",
            ()-> new ClothesRack(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_CLOTHES_RACK = registerBlock("jungle_clothes_rack",
            ()-> new ClothesRack(BlockBehaviour.Properties.copy(Blocks.JUNGLE_FENCE).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_CLOTHES_RACK = registerBlock("crimson_clothes_rack",
            ()-> new ClothesRack(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE).noOcclusion()));
    public static final RegistryObject<Block> WARPED_CLOTHES_RACK = registerBlock("warped_clothes_rack",
            ()-> new ClothesRack(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_CLOTHES_RACK = registerBlock("mangrove_clothes_rack",
            ()-> new ClothesRack(BlockBehaviour.Properties.copy(Blocks.MANGROVE_FENCE).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_CLOTHES_RACK = registerBlock("huang_hua_li_clothes_rack",
            ()-> new ClothesRack(BlockBehaviour.Properties.copy(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> WENGE_CLOTHES_RACK = registerBlock("wenge_clothes_rack",
            ()-> new ClothesRack(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WENGE_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_CLOTHES_RACK = registerBlock("acacia_clothes_rack",
            ()-> new ClothesRack(BlockBehaviour.Properties.copy(Blocks.ACACIA_FENCE).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_CLOTHES_RACK = registerBlock("dark_oak_clothes_rack",
            ()-> new ClothesRack(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_FENCE).noOcclusion()));
    public static final RegistryObject<Block> OAK_CLOTHES_RACK = registerBlock("oak_clothes_rack",
            ()-> new ClothesRack(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_CLOTHES_RACK = registerBlock("cherry_clothes_rack",
            ()-> new ClothesRack(BlockBehaviour.Properties.copy(Blocks.CHERRY_FENCE).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_CLOTHES_RACK = registerBlock("spruce_clothes_rack",
            ()-> new ClothesRack(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_CLOTHES_RACK = registerBlock("zi_tan_clothes_rack",
            ()-> new ClothesRack(BlockBehaviour.Properties.copy(ChangShengJueBlocks.ZI_TAN_PLANKS.get()).noOcclusion()));

    //长凳
    public static final RegistryObject<Block> BIRCH_BENCH = registerBlock("birch_bench",
            ()-> new Bench(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_BENCH = registerBlock("jungle_bench",
            ()-> new Bench(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_BENCH = registerBlock("crimson_bench",
            ()-> new Bench(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_BENCH = registerBlock("warped_bench",
            ()-> new Bench(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_BENCH = registerBlock("mangrove_bench",
            ()-> new Bench(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_BENCH = registerBlock("huang_hua_li_bench",
            ()-> new Bench(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JI_CHI_MU_BENCH = registerBlock("ji_chi_mu_bench",
            ()-> new Bench(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_BENCH = registerBlock("acacia_bench",
            ()-> new Bench(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_BENCH = registerBlock("dark_oak_bench",
            ()-> new Bench(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_BENCH = registerBlock("oak_bench",
            ()-> new Bench(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_BENCH = registerBlock("cherry_bench",
            ()-> new Bench(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_BENCH = registerBlock("spruce_bench",
            ()-> new Bench(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_BENCH = registerBlock("zi_tan_bench",
            ()-> new Bench(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    //书桌
    public static final RegistryObject<Block> BIRCH_BOOK_DESK = registerBlock("birch_book_desk",
            ()-> new BookDesk(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_BOOK_DESK = registerBlock("jungle_book_desk",
            ()-> new BookDesk(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_BOOK_DESK = registerBlock("crimson_book_desk",
            ()-> new BookDesk(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_BOOK_DESK = registerBlock("warped_book_desk",
            ()-> new BookDesk(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_BOOK_DESK = registerBlock("mangrove_book_desk",
            ()-> new BookDesk(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_BOOK_DESK = registerBlock("huang_hua_li_book_desk",
            ()-> new BookDesk(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JI_CHI_MU_BOOK_DESK = registerBlock("ji_chi_mu_book_desk",
            ()-> new BookDesk(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_BOOK_DESK = registerBlock("acacia_book_desk",
            ()-> new BookDesk(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_BOOK_DESK = registerBlock("dark_oak_book_desk",
            ()-> new BookDesk(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_BOOK_DESK = registerBlock("oak_book_desk",
            ()-> new BookDesk(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_BOOK_DESK = registerBlock("cherry_book_desk",
            ()-> new BookDesk(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_BOOK_DESK = registerBlock("spruce_book_desk",
            ()-> new BookDesk(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_BOOK_DESK = registerBlock("zi_tan_book_desk",
            ()-> new BookDesk(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    //茶几
    public static final RegistryObject<Block> BIRCH_TEAPOY = registerBlock("birch_teapoy",
            ()-> new Teapoy(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_TEAPOY = registerBlock("jungle_teapoy",
            ()-> new Teapoy(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_TEAPOY = registerBlock("crimson_teapoy",
            ()-> new Teapoy(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_TEAPOY = registerBlock("warped_teapoy",
            ()-> new Teapoy(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_TEAPOY = registerBlock("mangrove_teapoy",
            ()-> new Teapoy(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_TEAPOY = registerBlock("huang_hua_li_teapoy",
            ()-> new Teapoy(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WENGE_TEAPOY = registerBlock("wenge_teapoy",
            ()-> new Teapoy(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_TEAPOY = registerBlock("acacia_teapoy",
            ()-> new Teapoy(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_TEAPOY = registerBlock("dark_oak_teapoy",
            ()-> new Teapoy(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_TEAPOY = registerBlock("oak_teapoy",
            ()-> new Teapoy(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_TEAPOY = registerBlock("cherry_teapoy",
            ()-> new Teapoy(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_TEAPOY = registerBlock("spruce_teapoy",
            ()-> new Teapoy(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_TEAPOY = registerBlock("zi_tan_teapoy",
            ()-> new Teapoy(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    //太师椅
    public static final RegistryObject<Block> BIRCH_TAISHI_CHAIR = registerBlock("birch_taishi_chair",
            ()-> new TaishiChair(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_TAISHI_CHAIR = registerBlock("jungle_taishi_chair",
            ()-> new TaishiChair(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_TAISHI_CHAIR = registerBlock("crimson_taishi_chair",
            ()-> new TaishiChair(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_TAISHI_CHAIR = registerBlock("warped_taishi_chair",
            ()-> new TaishiChair(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_TAISHI_CHAIR = registerBlock("mangrove_taishi_chair",
            ()-> new TaishiChair(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_TAISHI_CHAIR = registerBlock("huang_hua_li_taishi_chair",
            ()-> new TaishiChair(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WENGE_TAISHI_CHAIR = registerBlock("wenge_taishi_chair",
            ()-> new TaishiChair(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_TAISHI_CHAIR = registerBlock("acacia_taishi_chair",
            ()-> new TaishiChair(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_TAISHI_CHAIR = registerBlock("dark_oak_taishi_chair",
            ()-> new TaishiChair(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_TAISHI_CHAIR = registerBlock("oak_taishi_chair",
            ()-> new TaishiChair(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_TAISHI_CHAIR = registerBlock("cherry_taishi_chair",
            ()-> new TaishiChair(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_TAISHI_CHAIR = registerBlock("spruce_taishi_chair",
            ()-> new TaishiChair(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_TAISHI_CHAIR = registerBlock("zi_tan_taishi_chair",
            ()-> new TaishiChair(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    //五围屏宝座
    public static final RegistryObject<Block> BIRCH_FIVE_SCREEN_THRONE = registerBlock("birch_five_screen_throne",
            ()-> new FiveScreenThrone(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_FIVE_SCREEN_THRONE = registerBlock("jungle_five_screen_throne",
            ()-> new FiveScreenThrone(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_FIVE_SCREEN_THRONE = registerBlock("crimson_five_screen_throne",
            ()-> new FiveScreenThrone(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_FIVE_SCREEN_THRONE = registerBlock("warped_five_screen_throne",
            ()-> new FiveScreenThrone(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_FIVE_SCREEN_THRONE = registerBlock("mangrove_five_screen_throne",
            ()-> new FiveScreenThrone(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_FIVE_SCREEN_THRONE = registerBlock("huang_hua_li_five_screen_throne",
            ()-> new FiveScreenThrone(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WENGE_FIVE_SCREEN_THRONE = registerBlock("wenge_five_screen_throne",
            ()-> new FiveScreenThrone(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_FIVE_SCREEN_THRONE = registerBlock("acacia_five_screen_throne",
            ()-> new FiveScreenThrone(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_FIVE_SCREEN_THRONE = registerBlock("dark_oak_five_screen_throne",
            ()-> new FiveScreenThrone(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_FIVE_SCREEN_THRONE = registerBlock("oak_five_screen_throne",
            ()-> new FiveScreenThrone(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_FIVE_SCREEN_THRONE = registerBlock("cherry_five_screen_throne",
            ()-> new FiveScreenThrone(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_FIVE_SCREEN_THRONE = registerBlock("spruce_five_screen_throne",
            ()-> new FiveScreenThrone(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_FIVE_SCREEN_THRONE = registerBlock("zi_tan_five_screen_throne",
            ()-> new FiveScreenThrone(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    //席桌
    public static final RegistryObject<Block> BIRCH_LOW_DESK = registerBlock("birch_low_desk",
            ()-> new LowDesk(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_LOW_DESK = registerBlock("jungle_low_desk",
            ()-> new LowDesk(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_LOW_DESK = registerBlock("crimson_low_desk",
            ()-> new LowDesk(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_LOW_DESK = registerBlock("warped_low_desk",
            ()-> new LowDesk(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_LOW_DESK = registerBlock("mangrove_low_desk",
            ()-> new LowDesk(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_LOW_DESK = registerBlock("huang_hua_li_low_desk",
            ()-> new LowDesk(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JI_CHI_MU_LOW_DESK = registerBlock("ji_chi_mu_low_desk",
            ()-> new LowDesk(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_LOW_DESK = registerBlock("acacia_low_desk",
            ()-> new LowDesk(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_LOW_DESK = registerBlock("dark_oak_low_desk",
            ()-> new LowDesk(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_LOW_DESK = registerBlock("oak_low_desk",
            ()-> new LowDesk(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_LOW_DESK = registerBlock("cherry_low_desk",
            ()-> new LowDesk(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_LOW_DESK = registerBlock("spruce_low_desk",
            ()-> new LowDesk(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_LOW_DESK = registerBlock("zi_tan_low_desk",
            ()-> new LowDesk(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    //灯笼
    public static final RegistryObject<Block> LANTERN = registerBlock("lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.WOOL).noOcclusion()));
    public static final RegistryObject<Block> WHITE_LANTERN = registerBlock("white_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.WOOL).noOcclusion()));
    public static final RegistryObject<Block> ORANGE_LANTERN  = registerBlock("orange_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_ORANGE).noOcclusion()));
    public static final RegistryObject<Block> MAGENTA_LANTERN  = registerBlock("magenta_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_MAGENTA).noOcclusion()));
    public static final RegistryObject<Block> LIGHT_BLUE_LANTERN  = registerBlock("light_blue_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_LIGHT_BLUE).noOcclusion()));
    public static final RegistryObject<Block> YELLOW_LANTERN  = registerBlock("yellow_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_YELLOW).noOcclusion()));
    public static final RegistryObject<Block> LIME_LANTERN  = registerBlock("lime_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_LIGHT_GREEN).noOcclusion()));
    public static final RegistryObject<Block> PINK_LANTERN  = registerBlock("pink_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_PINK).noOcclusion()));
    public static final RegistryObject<Block> GRAY_LANTERN  = registerBlock("gray_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_GRAY).noOcclusion()));
    public static final RegistryObject<Block> LIGHT_GRAY_LANTERN  = registerBlock("light_gray_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_LIGHT_GRAY).noOcclusion()));
    public static final RegistryObject<Block> CYAN_LANTERN  = registerBlock("cyan_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_CYAN).noOcclusion()));
    public static final RegistryObject<Block> PURPLE_LANTERN  = registerBlock("purple_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_PURPLE).noOcclusion()));
    public static final RegistryObject<Block> BLUE_LANTERN  = registerBlock("blue_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_BLUE).noOcclusion()));
    public static final RegistryObject<Block> BROWN_LANTERN  = registerBlock("brown_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_BROWN).noOcclusion()));
    public static final RegistryObject<Block> GREEN_LANTERN  = registerBlock("green_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_GREEN).noOcclusion()));
    public static final RegistryObject<Block> RED_LANTERN  = registerBlock("red_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_RED).noOcclusion()));
    public static final RegistryObject<Block> BLACK_LANTERN  = registerBlock("black_lantern",
            () -> new Lantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.WOOD).mapColor(MapColor.COLOR_BLACK).noOcclusion()));

    public static final RegistryObject<Block> BIRCH_LIGHT_STAND = registerBlock("birch_light_stand",
            ()-> new LightStand(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_LIGHT_STAND = registerBlock("jungle_light_stand",
            ()-> new LightStand(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_LIGHT_STAND = registerBlock("crimson_light_stand",
            ()-> new LightStand(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_LIGHT_STAND = registerBlock("warped_light_stand",
            ()-> new LightStand(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_LIGHT_STAND = registerBlock("mangrove_light_stand",
            ()-> new LightStand(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_LIGHT_STAND = registerBlock("huang_hua_li_light_stand",
            ()-> new LightStand(BlockBehaviour.Properties.copy(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> WENGE_LIGHT_STAND = registerBlock("wenge_light_stand",
            ()-> new LightStand(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WENGE_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_LIGHT_STAND = registerBlock("acacia_light_stand",
            ()-> new LightStand(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_LIGHT_STAND = registerBlock("dark_oak_light_stand",
            ()-> new LightStand(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_LIGHT_STAND = registerBlock("oak_light_stand",
            ()-> new LightStand(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_LIGHT_STAND = registerBlock("cherry_light_stand",
            ()-> new LightStand(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_LIGHT_STAND = registerBlock("spruce_light_stand",
            ()-> new LightStand(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_LIGHT_STAND = registerBlock("zi_tan_light_stand",
            ()-> new LightStand(BlockBehaviour.Properties.copy(ChangShengJueBlocks.ZI_TAN_PLANKS.get()).noOcclusion()));

    public static final RegistryObject<Block> BIRCH_HEIGHT_LIGHT_STAND = registerBlock("birch_height_light_stand",
            ()-> new HeightLightStand(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_HEIGHT_LIGHT_STAND = registerBlock("jungle_height_light_stand",
            ()-> new HeightLightStand(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_HEIGHT_LIGHT_STAND = registerBlock("crimson_height_light_stand",
            ()-> new HeightLightStand(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> WARPED_HEIGHT_LIGHT_STAND = registerBlock("warped_height_light_stand",
            ()-> new HeightLightStand(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_HEIGHT_LIGHT_STAND = registerBlock("mangrove_height_light_stand",
            ()-> new HeightLightStand(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> HUANG_HUA_LI_HEIGHT_LIGHT_STAND = registerBlock("huang_hua_li_height_light_stand",
            ()-> new HeightLightStand(BlockBehaviour.Properties.copy(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> WENGE_HEIGHT_LIGHT_STAND = registerBlock("wenge_height_light_stand",
            ()-> new HeightLightStand(BlockBehaviour.Properties.copy(ChangShengJueBlocks.WENGE_PLANKS.get()).noOcclusion()));
    public static final RegistryObject<Block> ACACIA_HEIGHT_LIGHT_STAND = registerBlock("acacia_height_light_stand",
            ()-> new HeightLightStand(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_HEIGHT_LIGHT_STAND = registerBlock("dark_oak_height_light_stand",
            ()-> new HeightLightStand(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> OAK_HEIGHT_LIGHT_STAND = registerBlock("oak_height_light_stand",
            ()-> new HeightLightStand(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> CHERRY_HEIGHT_LIGHT_STAND = registerBlock("cherry_height_light_stand",
            ()-> new HeightLightStand(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_HEIGHT_LIGHT_STAND = registerBlock("spruce_height_light_stand",
            ()-> new HeightLightStand(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final RegistryObject<Block> ZI_TAN_HEIGHT_LIGHT_STAND = registerBlock("zi_tan_height_light_stand",
            ()-> new HeightLightStand(BlockBehaviour.Properties.copy(ChangShengJueBlocks.ZI_TAN_PLANKS.get()).noOcclusion()));
    // 磨刀石
    public static final RegistryObject<Block> STONE_SHARPENING_STONE = registerBlock("stone_sharpening_stone", StoneSharpeningStone::new);
    public static final RegistryObject<Block> DIAMOND_SHARPENING_STONE = registerBlock("diamond_sharpening_stone", DiamondSharpeningStone::new);
    public static final RegistryObject<Block> NETHERITE_SHARPENING_STONE = registerBlock("netherite_sharpening_stone", NetheriteSharpeningStone::new);
    //蒲团
    public static final RegistryObject<Block> ZAFU = registerBlock("zafu",
            ()-> new Zafu(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).noOcclusion()));
    //风铃
    public static final RegistryObject<Block> WIND_CHIME = registerBlock("wind_chime",
            ()-> new WindChime(BlockBehaviour.Properties.of().strength(1.5F).sound(SoundType.CHAIN).noOcclusion().mapColor(MapColor.STONE)));
    //画轴
    public static final RegistryObject<Block> PAINTING_SCROLL = registerBlock("painting_scroll",
            ()-> new PaintingScroll(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().pushReaction(PushReaction.DESTROY).mapColor(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> HIGH_PAINTING_SCROLL = registerBlock("high_painting_scroll",
            ()-> new HighPaintingScroll(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().pushReaction(PushReaction.DESTROY).mapColor(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> WIDTH_PAINTING_SCROLL = registerBlock("width_painting_scroll",
            ()-> new WidthPaintingScroll(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().pushReaction(PushReaction.DESTROY).mapColor(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> BIG_PAINTING_SCROLL = registerBlock("big_painting_scroll",
            ()-> new BigPaintingScroll(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().pushReaction(PushReaction.DESTROY).mapColor(MapColor.COLOR_GRAY)));

    //牌匾
    public static final RegistryObject<Block> PLAQUE = registerBlock("plaque",
            () -> new Plaque(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN)));

    //裁衣案
    public static final RegistryObject<Block> TAILORING_CASE = registerBlock("tailoring_case",
            ()-> new TailoringCase(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE).noOcclusion()));
    //锻台
    public static final RegistryObject<Block> FORGE_BLOCK = registerBlock("forge_block",
            () -> new ForgeBlock(BlockBehaviour.Properties.of().strength(1.5F).mapColor(MapColor.COLOR_BLUE).sound(SoundType.CHAIN).noOcclusion()));
    //木工台
    public static final RegistryObject<Block> WOOD_WORKING_BENCH = registerBlockWithoutBlockItem("wood_working_bench",
            ()-> new WoodworkingBench(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE).noOcclusion()));
    //锣
    public static final RegistryObject<Block> GONG = registerBlockWithoutBlockItem("gong",
            () -> new Gong(BlockBehaviour.Properties.copy(Blocks.BELL)));

    //*食物*//
    public static final RegistryObject<Block> CI_PAN = registerBlockWithoutBlockItem("ci_pan",
            ()-> new CiPan(BlockBehaviour.Properties.copy(Blocks.CAKE), true, 0, 0f));
    public static final RegistryObject<Block> CI_WAN = registerBlockWithoutBlockItem("ci_wan",
            ()-> new CiWan(BlockBehaviour.Properties.copy(Blocks.CAKE), true, 0, 0f));
    public static final RegistryObject<Block> CI_BEI = registerBlockWithoutBlockItem("ci_bei",
            ()-> new CiBei(BlockBehaviour.Properties.copy(Blocks.CAKE), true, 0, 0f));
    //玉米
    public static final RegistryObject<Block> CORN = registerBlockWithoutBlockItem("corn",
            ()-> new Corn(BlockBehaviour.Properties.copy(Blocks.CAKE), 1, 0.6f));
    //烤玉米
    public static final RegistryObject<Block> BAKED_CORN = registerBlockWithoutBlockItem("baked_corn",
            ()-> new Corn(BlockBehaviour.Properties.copy(Blocks.CAKE), 6, 1.0f));
    //梨
    public static final RegistryObject<Block> PEAR = registerBlockWithoutBlockItem("pear",
            ()-> new Pear(BlockBehaviour.Properties.copy(Blocks.CAKE), 4, 0.6f));
    //菠萝
    public static final RegistryObject<Block> PINEAPPLE = registerBlockWithoutBlockItem("pineapple",
            ()-> new Pineapple(BlockBehaviour.Properties.copy(Blocks.CAKE), 4, 0.6f));
    //芒果
    public static final RegistryObject<Block> MANGO = registerBlockWithoutBlockItem("mango",
            ()-> new Mango(BlockBehaviour.Properties.copy(Blocks.CAKE), 3, 0.6F));
    //荔枝
    public static final RegistryObject<Block> LICHEE = registerBlockWithoutBlockItem("lichee",
            ()-> new Lichee(BlockBehaviour.Properties.copy(Blocks.CAKE), 4, 0.6f));
    //香蕉
    public static final RegistryObject<Block> BANANA = registerBlockWithoutBlockItem("banana",
            ()-> new Banana(BlockBehaviour.Properties.copy(Blocks.CAKE), 4, 0.8F));
    //葡萄
    public static final RegistryObject<Block> GRAPE = registerBlockWithoutBlockItem("grape",
            ()-> new Grape(BlockBehaviour.Properties.copy(Blocks.CAKE), 4, 0.6f));
    //桑葚
    public static final RegistryObject<Block> MULBERRY = registerBlockWithoutBlockItem("mulberry",
            ()-> new Mulberry(BlockBehaviour.Properties.copy(Blocks.CAKE), 1, 0.5F));
    //榴莲
    public static final RegistryObject<Block> DURIAN = registerBlockWithoutBlockItem("durian",
            ()-> new Durian(BlockBehaviour.Properties.copy(Blocks.CAKE), 0, 0f));
    /*直接食用*/
    //饺子
    public static final RegistryObject<Block> CAPSULE_JIAO_ZI_PAN = registerBlockWithoutBlockItem("capsule_jiao_zi_pan",
            ()-> new CiPanFood(Block.Properties.copy(Blocks.CAKE), true, 13, 1.587301587301587F));
    public static final RegistryObject<Block> CAPSULE_JIAO_ZI_WAN = registerBlockWithoutBlockItem("capsule_jiao_zi_wan",
            ()-> new CiWanFood(Block.Properties.copy(Blocks.CAKE), true, 13, 1.2F));
    //马齿苋饼
    public static final RegistryObject<Block> PORTULACA_OLERACEA_CAKE_PAN = registerBlockWithoutBlockItem("portulaca_oleracea_cake_pan",
            ()-> new CiPanFood(Block.Properties.copy(Blocks.CAKE), true, 7, 1.2F));
    public static final RegistryObject<Block> PORTULACA_OLERACEA_CAKE_WAN = registerBlockWithoutBlockItem("portulaca_oleracea_cake_wan",
            ()-> new CiWanFood(Block.Properties.copy(Blocks.CAKE), true, 7, 1.2F));
    //青团
    public static final RegistryObject<Block> QING_TUAN_PAN = registerBlockWithoutBlockItem("qing_tuan_pan",
            ()-> new CiPanFood(Block.Properties.copy(Blocks.CAKE), true, 12, 1.607142857142857f));
    public static final RegistryObject<Block> QING_TUAN_WAN = registerBlockWithoutBlockItem("qing_tuan_wan",
            ()-> new CiWanFood(Block.Properties.copy(Blocks.CAKE), true, 12, 1.607142857142857f));
    //高粱饼
    public static final RegistryObject<Block> SORGHUM_CAKE_PAN = registerBlockWithoutBlockItem("sorghum_cake_pan",
            ()-> new CiPanFood(Block.Properties.copy(Blocks.CAKE), true, 7, 1.2F));
    public static final RegistryObject<Block> SORGHUM_CAKE_WAN = registerBlockWithoutBlockItem("sorghum_cake_wan",
            ()-> new CiWanFood(Block.Properties.copy(Blocks.CAKE), true, 7, 1.2F));
    //米饭
    public static final RegistryObject<Block> MI_FAN_PAN = registerBlockWithoutBlockItem("mi_fan_pan",
            ()-> new CiPanFood(Block.Properties.copy(Blocks.CAKE), true, 7, 1.2F));
    public static final RegistryObject<Block> MI_FAN_WAN = registerBlockWithoutBlockItem("mi_fan_wan",
            ()-> new CiWanFood(Block.Properties.copy(Blocks.CAKE), true, 7, 1.2F));
    //小米饭
    public static final RegistryObject<Block> XIAO_MI_FAN_PAN = registerBlockWithoutBlockItem("xiao_mi_fan_pan",
            ()-> new CiPanFood(Block.Properties.copy(Blocks.CAKE), true, 7, 1.2F));
    public static final RegistryObject<Block> XIAO_MI_FAN_WAN = registerBlockWithoutBlockItem("xiao_mi_fan_wan",
            ()-> new CiWanFood(Block.Properties.copy(Blocks.CAKE), true, 7, 1.2F));
    /*盘*/
    //蒸菜
    public static final RegistryObject<Block> ZHENG_CAI = registerBlockWithoutBlockItem("zheng_cai",
            ()-> new CiPanFood(Block.Properties.copy(Blocks.CAKE), true, 14, 1.2f));
    //番茄炒蛋
    public static final RegistryObject<Block> TOMATO_EGG = registerBlockWithoutBlockItem("tomato_egg",
            ()-> new CiPanFood(Block.Properties.copy(Blocks.CAKE), true, 12, 1.6f));
    //咕咾肉
    public static final RegistryObject<Block> GU_LAO_ROU = registerBlockWithoutBlockItem("gu_lao_rou",
            ()-> new CiPanFood(Block.Properties.copy(Blocks.CAKE), true, 14, 1.4f));
    //肉末茄子
    public static final RegistryObject<Block> MEAT_FOAM_BRINJAL = registerBlockWithoutBlockItem("meat_foam_brinjal",
            ()-> new CiPanFood(Block.Properties.copy(Blocks.CAKE), true, 14, 1.4f));
    //臭豆腐
    public static final RegistryObject<Block> STINKY_TOFU = registerBlockWithoutBlockItem("stinky_tofu",
            ()-> new CiPanFood(Block.Properties.copy(Blocks.CAKE), true, 7, 1.6f));
    //桂花糖藕
    public static final RegistryObject<Block> GUI_HUA_TANG_OU = registerBlockWithoutBlockItem("gui_hua_tang_ou",
            ()-> new CiPanFood(Block.Properties.copy(Blocks.CAKE), true, 9, 1.6f));
    /*碗*/
    //热梨汤
    public static final RegistryObject<Block> HOT_PEAR_SOUP = registerBlockWithoutBlockItem("hot_pear_soup",
            ()-> new CiWanFood(Block.Properties.copy(Blocks.CAKE), true, 5, 1.333f));
    //猪肚鸡
    public static final RegistryObject<Block> ZHU_DU_JI = registerBlockWithoutBlockItem("zhu_du_ji",
            ()-> new CiWanFood(Block.Properties.copy(Blocks.CAKE), true, 15, 1.333f));
    //八宝粥
    public static final RegistryObject<Block> BA_BAO_ZHOU = registerBlockWithoutBlockItem("ba_bao_zhou",
            ()-> new CiWanFood(Block.Properties.copy(Blocks.CAKE), true, 18, 1.111f));
    /*杯*/
    //桑葚汁
    public static final RegistryObject<Block> MULBERRY_JUICE = registerBlockWithoutBlockItem("mulberry_juice",
            ()-> new CiBeiFood(Block.Properties.copy(Blocks.CAKE), true, 7, 0.69f));
    //苹果汁
    public static final RegistryObject<Block> APPLE_JUICE = registerBlockWithoutBlockItem("apple_juice",
            ()-> new CiBeiFood(Block.Properties.copy(Blocks.CAKE), true, 7, 0.69f));
    //葡萄汁
    public static final RegistryObject<Block> GRAPE_JUICE = registerBlockWithoutBlockItem("grape_juice",
            ()-> new CiBeiFood(Block.Properties.copy(Blocks.CAKE), true, 7, 0.69f));
    //碧螺春
    public static final RegistryObject<Block> BILUOCHUN_TEAS = registerBlockWithoutBlockItem("biluochun_teas",
            ()-> new CiBeiTea(Block.Properties.copy(Blocks.CAKE), true, 1, 1.0f,
                    1));
    //龙井茶
    public static final RegistryObject<Block> LONG_JING_TEAS = registerBlockWithoutBlockItem("long_jing_teas",
            ()-> new CiBeiTea(Block.Properties.copy(Blocks.CAKE), true, 1, 1.0f,
                    2));
    //空汾酒杯
    public static final RegistryObject<Block> EMPTY_FEN_JIU = registerBlockWithoutBlockItem("empty_fen_jiu",
            ()-> new EmptyFenJiu(Block.Properties.copy(Blocks.CAKE), true, 0, 0.0f));
    //空十里香
    public static final RegistryObject<Block> EMPTY_SHI_LI_XIANG = registerBlockWithoutBlockItem("empty_shi_li_xiang",
            ()-> new EmptyShiLiXiang(Block.Properties.copy(Blocks.CAKE), true, 0, 0.0f));
    //空麦块贡酒
    public static final RegistryObject<Block> EMPTY_WHEAT_NUGGETS_TRIBUTE_WINE = registerBlockWithoutBlockItem("empty_wheat_nuggets_tribute_wine",
            ()-> new EmptyWheatNuggetsTributeWine(Block.Properties.copy(Blocks.CAKE), true, 0, 0.0f));

    //汾酒
    public static final RegistryObject<Block> FEN_JIU = registerBlockWithoutBlockItem("fen_jiu",
            ()-> new FenJiu(Block.Properties.copy(Blocks.CAKE), true, 1, 1.0f));
    //十里香
    public static final RegistryObject<Block> SHI_LI_XIANG = registerBlockWithoutBlockItem("shi_li_xiang",
            ()-> new ShiLiXiang(Block.Properties.copy(Blocks.CAKE), true, 1, 1.0f));
    //麦块贡酒
    public static final RegistryObject<Block> WHEAT_NUGGETS_TRIBUTE_WINE = registerBlockWithoutBlockItem("wheat_nuggets_tribute_wine",
            ()-> new WheatNuggetsTributeWine(Block.Properties.copy(Blocks.CAKE), true, 1, 1.0f));

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name,Supplier<T> block){
        return BLOCKS.register(name,block);
    }
//    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
//        RegistryObject<T> toReturn = BLOCKS.register(name, block);
//        registerBlockItem(name,toReturn);
//        return toReturn;
//    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ChangShengJueItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()){
            @Override
            public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                return super.getBurnTime(itemStack, recipeType);
            }
        });
    }

//    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, int burnTime) {
//        return ChangShengJueItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()){
//            @Override
//            public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
//                return burnTime;
//            }
//        });
//    }

    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return (p_50763_) -> {
            return (Boolean)p_50763_.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
        };
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
