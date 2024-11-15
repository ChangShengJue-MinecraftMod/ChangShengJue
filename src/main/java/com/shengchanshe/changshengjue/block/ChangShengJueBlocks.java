package com.shengchanshe.changshengjue.block;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.custom.*;
import com.shengchanshe.changshengjue.block.cropper.*;
import com.shengchanshe.changshengjue.block.decoration.BlueAndWhitePorcelainFlowerPots;
import com.shengchanshe.changshengjue.block.decoration.PoplarDefoliation;
import com.shengchanshe.changshengjue.block.painting.BigPaintingScroll;
import com.shengchanshe.changshengjue.block.painting.HighPaintingScroll;
import com.shengchanshe.changshengjue.block.painting.PaintingScroll;
import com.shengchanshe.changshengjue.block.painting.WidthPaintingScroll;
import com.shengchanshe.changshengjue.block.tree_logs.LogBlock;
import com.shengchanshe.changshengjue.block.tree_logs.FruitLeaves;
import com.shengchanshe.changshengjue.block.tree_logs.MulberryLeaves;
import com.shengchanshe.changshengjue.block.tree_logs.PoplarLeaves;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.util.CSJWoodTypes;
import com.shengchanshe.changshengjue.util.ChangShengJueVoxelShape;
import com.shengchanshe.changshengjue.world.feature.tree.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

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
            ()-> new StemBlock((StemGrownBlock)CANTALOUPE_BLOCK.get(), () -> ChangShengJueItems.CANTALOUPE_SEEDS.get(),
                   BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.HARD_CROP).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> ATTACHED_CANTALOUPE_STEM = registerBlockWithoutBlockItem("attached_cantaloupe_stem",
            ()-> new AttachedStemBlock((StemGrownBlock)CANTALOUPE_BLOCK.get(),()-> ChangShengJueItems.CANTALOUPE_SEEDS.get()
                    ,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));

    //莲花
    public static final RegistryObject<Block> LOTUS_BLOCK = registerBlockWithoutBlockItem("lotus_block",
            ()-> new LotusBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission()
                    .randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    //树木
    public static final RegistryObject<Block> MANGO_LOG = registerBlock("mango_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> MANGO_LEAVES = registerBlock("mango_leaves",
            ()-> new FruitLeaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> MANGO_SAPLING = registerBlock("mango_sapling",
            ()-> new SaplingBlock(new MangoTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> BANANA_LOG = registerBlock("banana_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> BANANA_LEAVES = registerBlock("banana_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> BANANA_SAPLING = registerBlock("banana_sapling",
            ()-> new SaplingBlock(new BananaTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> PEAR_LOG = registerBlock("pear_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> PEAR_LEAVES = registerBlock("pear_leaves",
            ()-> new FruitLeaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> PEAR_SAPLING = registerBlock("pear_sapling",
            ()-> new SaplingBlock(new PearTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> LICHEE_LOG = registerBlock("lichee_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> LICHEE_LEAVES = registerBlock("lichee_leaves",
            ()-> new FruitLeaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> LICHEE_SAPLING = registerBlock("lichee_sapling",
            ()-> new SaplingBlock(new LicheeTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> DURIAN_LOG = registerBlock("durian_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> DURIAN_LEAVES = registerBlock("durian_leaves",
            ()-> new FruitLeaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> DURIAN_SAPLING = registerBlock("durian_sapling",
            ()-> new SaplingBlock(new DurianTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> GUI_HUA_LOG = registerBlock("gui_hua_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> GUI_HUA_LEAVES = registerBlock("gui_hua_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> GUI_HUA_SAPLING = registerBlock("gui_hua_sapling",
            ()-> new SaplingBlock(new GuiHuaTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> MEI_HUA_LOG = registerBlock("mei_hua_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> MEI_HUA_LEAVES = registerBlock("mei_hua_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> MEI_HUA_SAPLING = registerBlock("mei_hua_sapling",
            ()-> new SaplingBlock(new MeiHuaTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> HUANG_HUA_LI_LOG = registerBlock("huang_hua_li_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_HUANG_HUA_LI_LOG = registerBlock("stripped_huang_hua_li_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> HUANG_HUA_LI_PLANKS = registerBlock("huang_hua_li_planks",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> JI_CHI_MU_LOG = registerBlock("ji_chi_mu_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_JI_CHI_MU_LOG = registerBlock("ji_chi_mu_stripped_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> JI_CHI_MU_PLANKS = registerBlock("ji_chi_mu_planks",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> ZI_TAN_LOG = registerBlock("zi_tan_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_ZI_TAN_LOG = registerBlock("zi_tan_stripped_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> ZI_TAN_PLANKS = registerBlock("zi_tan_planks",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    //白杨树
    public static final RegistryObject<Block> POPLAR_LOG = registerBlock("poplar_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> POPLAR_LEAVES = registerBlock("poplar_leaves",
            ()-> new PoplarLeaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> POPLAR_SAPLING = registerBlock("poplar_sapling",
            ()-> new SaplingBlock(new PoplarTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> POPLAR_DEFOLIATION = registerBlock("poplar_defoliation",
            ()-> new PoplarDefoliation(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    //桑树
    public static final RegistryObject<Block> MULBERRY_LOG = registerBlock("mulberry_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_MULBERRY_LOG = registerBlock("stripped_mulberry_log",
            ()-> new LogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> MULBERRY_LEAVES = registerBlock("mulberry_leaves",
            ()-> new MulberryLeaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> MULBERRY_SAPLING = registerBlock("mulberry_sapling",
            ()-> new SaplingBlock(new MulberryTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    //花盆和花花草草
    public static final RegistryObject<Block> BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS = registerBlock("blue_and_white_porcelain_flower_pots",
            ()-> new BlueAndWhitePorcelainFlowerPots(BlockBehaviour.Properties.of().noOcclusion().instabreak().pushReaction(PushReaction.DESTROY)));
    //艾蒿
    public static final RegistryObject<Block> MUGWORT_BLOCK = registerBlock("mugwort_block",
            ()-> new FlowerBlock(()-> MobEffects.LEVITATION,8,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION)){
                protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
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
                protected static final VoxelShape SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
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
                protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
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
    public static final RegistryObject<Block> CAPSULE_BLOCK = registerBlockWithoutBlockItem("capsule_block",
            ()-> new CapsuleBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
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
    public static final RegistryObject<Block> ZHU_TAI_BLOCK = registerBlock("zhu_tai_block",
            ()-> new ZhuTaiBlock(BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel((p_50755_) -> 15).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY), ParticleTypes.FLAME));
    public static final RegistryObject<Block> WALL_ZHU_TAI_BLOCK = registerBlock("wall_zhu_tai_block",
            ()-> new WallZhuTaiBlock(BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel((p_50886_) -> 15).sound(SoundType.WOOD)
                    .dropsLike(ZHU_TAI_BLOCK.get()).pushReaction(PushReaction.DESTROY), ParticleTypes.FLAME));

    public static final RegistryObject<Block> HANG_TU_BLOCK = registerBlock("hang_tu_block",
            ()-> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> TU_PEI_BLOCK = registerBlock("tu_pei_block",
            ()-> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));
    //石灯
    public static final RegistryObject<Block> STONE_LAMPS_BASE_BLOCK = registerBlock("stone_lamps_base_block",
            ()-> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)){
                protected static final VoxelShape AABB = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
                @Override
                public VoxelShape getShape(BlockState p_57510_, BlockGetter p_57511_, BlockPos p_57512_, CollisionContext p_57513_) {
                    return AABB;
                }
            });
    public static final RegistryObject<Block> STONE_LAMPS_BLOCK = registerBlock("stone_lamps_block",
            ()-> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5F, 6.0F)){
                protected static final VoxelShape AABB = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
                @Override
                public VoxelShape getShape(BlockState p_57510_, BlockGetter p_57511_, BlockPos p_57512_, CollisionContext p_57513_) {
                    return AABB;
                }
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
            ()-> new StoneLampsBlock(BlockBehaviour.Properties.of().instabreak().lightLevel((p_50755_) -> 15).sound(SoundType.STONE), ParticleTypes.FLAME));

    public static final RegistryObject<Block> YELLOW_STONE_LION_BLOCK = registerBlock("yellow_stone_lion_block",
            ()-> new StoneLionBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    public static final RegistryObject<Block> GRE_STONE_LION_BLOCK = registerBlock("gre_stone_lion_block",
            ()-> new StoneLionBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion()));
    //扶梯
    public static final RegistryObject<Block> BAI_HUA_FU_TI_BLOCK = registerBlock("bai_hua_fu_ti_block",
            ()-> new EescalatorBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(1.0F, 6.0F)));
    public static final RegistryObject<Block> YUN_SHAN_FU_TI_BLOCK = registerBlock("yun_shan_fu_ti_block",
            ()-> new EescalatorBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(1.0F, 6.0F)));

    //筒瓦
    public static final RegistryObject<Block> GRE_CYLINDER_TILE_BLOCK = registerBlock("cylinder_tile_gre_block",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH, SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E;
                    };
                }
            });
    public static final RegistryObject<Block> GRE_CYLINDER_TILE_BLOCK_1 = registerBlock("cylinder_tile_gre_block_1",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_1;
                        case SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_1;
                        case EAST -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_1;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_1;
                    };
                }
            });
    public static final RegistryObject<Block> GRE_CYLINDER_TILE_BLOCK_2 = registerBlock("cylinder_tile_gre_block_2",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GRE_CYLINDER_TILE_BLOCK_3 = registerBlock("cylinder_tile_gre_block_3",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_3;
                        case SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_3;
                        case EAST -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_3;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_3;
                    };
                }
            });
    public static final RegistryObject<Block> RED_CYLINDER_TILE_BLOCK = registerBlock("cylinder_tile_red_block",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH, SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E;
                    };
                }
            });
    public static final RegistryObject<Block> RED_CYLINDER_TILE_BLOCK_1 = registerBlock("cylinder_tile_red_block_1",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_1;
                        case SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_1;
                        case EAST -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_1;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_1;
                    };
                }
            });
    public static final RegistryObject<Block> RED_CYLINDER_TILE_BLOCK_2 = registerBlock("cylinder_tile_red_block_2",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> RED_CYLINDER_TILE_BLOCK_3 = registerBlock("cylinder_tile_red_block_3",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_3;
                        case SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_3;
                        case EAST -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_3;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_3;
                    };
                }
            });
    public static final RegistryObject<Block> BLACK_CYLINDER_TILE_BLOCK = registerBlock("cylinder_tile_black_block",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH, SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E;
                    };
                }
            });
    public static final RegistryObject<Block> BLACK_CYLINDER_TILE_BLOCK_1 = registerBlock("cylinder_tile_black_block_1",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_1;
                        case SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_1;
                        case EAST -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_1;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_1;
                    };
                }
            });
    public static final RegistryObject<Block> BLACK_CYLINDER_TILE_BLOCK_2 = registerBlock("cylinder_tile_black_block_2",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLACK_CYLINDER_TILE_BLOCK_3 = registerBlock("cylinder_tile_black_block_3",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_3;
                        case SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_3;
                        case EAST -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_3;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_3;
                    };
                }
            });
    public static final RegistryObject<Block> GOLDEN_CYLINDER_TILE_BLOCK = registerBlock("cylinder_tile_golden_block",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH, SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E;
                    };
                }
            });
    public static final RegistryObject<Block> GOLDEN_CYLINDER_TILE_BLOCK_1 = registerBlock("cylinder_tile_golden_block_1",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_1;
                        case SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_1;
                        case EAST -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_1;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_1;
                    };
                }
            });
    public static final RegistryObject<Block> GOLDEN_CYLINDER_TILE_BLOCK_2 = registerBlock("cylinder_tile_golden_block_2",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_CYLINDER_TILE_BLOCK_3 = registerBlock("cylinder_tile_golden_block_3",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_3;
                        case SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_3;
                        case EAST -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_3;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_3;
                    };
                }
            });
    public static final RegistryObject<Block> BLUE_CYLINDER_TILE_BLOCK = registerBlock("cylinder_tile_blue_block",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH, SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E;
                    };
                }
            });
    public static final RegistryObject<Block> BLUE_CYLINDER_TILE_BLOCK_1 = registerBlock("cylinder_tile_blue_block_1",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_1;
                        case SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_1;
                        case EAST -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_1;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_1;
                    };
                }
            });
    public static final RegistryObject<Block> BLUE_CYLINDER_TILE_BLOCK_2 = registerBlock("cylinder_tile_blue_block_2",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> BLUE_CYLINDER_TILE_BLOCK_3 = registerBlock("cylinder_tile_blue_block_3",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()){
                @Override
                public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
                    Direction value = blockState.getValue(FACING);
                    return switch (value){
                        case NORTH -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_N_3;
                        case SOUTH ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_S_3;
                        case EAST -> ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_E_3;
                        default ->  ChangShengJueVoxelShape.CYLINDER_TILE_BLOCK_W_3;
                    };
                }
            });
    //瓦片
    public static final RegistryObject<Block> GOLDEN_TILE_BLOCK = registerBlock("golden_tile_block",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_TILE_BLOCK_1 = registerBlock("golden_tile_block_1",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_TILE_BLOCK_2 = registerBlock("golden_tile_block_2",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_TILE_BLOCK_3 = registerBlock("golden_tile_block_3",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> GOLDEN_TILE_BLOCK_4 = registerBlock("golden_tile_block_4",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> TILE_BLOCK = registerBlock("tile_block",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> TILE_BLOCK_1 = registerBlock("tile_block_1",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> TILE_BLOCK_2 = registerBlock("tile_block_2",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> TILE_BLOCK_3 = registerBlock("tile_block_3",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> TILE_BLOCK_4 = registerBlock("tile_block_4",
            ()-> new CylinderTileBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().noOcclusion()));

    // 门
    public static final RegistryObject<Block> DOOR_BIRCH_BLOCK = registerBlock("door_birch_block",
            ()-> new DoorsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.BIRCH));
    public static final RegistryObject<Block> DOOR_ACACIA_BLOCK = registerBlock("door_acacia_block",
            ()-> new DoorsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.ACACIA));
    public static final RegistryObject<Block> DOOR_DARK_OAK_BLOCK = registerBlock("door_dark_oak_block",
            ()-> new DoorsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.DARK_OAK));
    public static final RegistryObject<Block> DOOR_OAK_BLOCK = registerBlock("door_oak_block",
            ()-> new DoorsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));
    public static final RegistryObject<Block> DOOR_SPRUCE_BLOCK = registerBlock("door_spruce_block",
            ()-> new DoorsBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.SPRUCE));

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

    //窗户
    public static final RegistryObject<Block> WINDOWS_BIRCH_BLOCK = registerBlock("windows_birch_block",
            ()-> new WindowBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_BIRCH_BLOCK_1 = registerBlock("windows_birch_block_1",
            ()-> new WindowBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_ACACIA_BLOCK = registerBlock("windows_acacia_block",
            ()-> new WindowBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_ACACIA_BLOCK_1 = registerBlock("windows_acacia_block_1",
            ()-> new WindowBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_DARK_OAK_BLOCK = registerBlock("windows_dark_oak_block",
            ()-> new WindowBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_DARK_OAK_BLOCK_1 = registerBlock("windows_dark_oak_block_1",
            ()-> new WindowBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_OAK_BLOCK = registerBlock("windows_oak_block",
            ()-> new WindowBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_OAK_BLOCK_1 = registerBlock("windows_oak_block_1",
            ()-> new WindowBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_SPRUCE_BLOCK = registerBlock("windows_spruce_block",
            ()-> new WindowBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> WINDOWS_SPRUCE_BLOCK_1 = registerBlock("windows_spruce_block_1",
            ()-> new WindowBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<Block> WINDOWS_BIRCH_BLOCK_2 = registerBlock("windows_birch_block_2",
            ()-> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.BIRCH){
                @Override
                public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
                    return true;
                }
            });
    public static final RegistryObject<Block> WINDOWS_ACACIA_BLOCK_2 = registerBlock("windows_acacia_block_2",
            ()-> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR),BlockSetType.ACACIA){
                @Override
                public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
                    return true;
                }
            });
    public static final RegistryObject<Block> WINDOWS_DARK_OAK_BLOCK_2 = registerBlock("windows_dark_oak_block_2",
            ()-> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR),BlockSetType.DARK_OAK){
                @Override
                public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
                    return true;
                }
            });
    public static final RegistryObject<Block> WINDOWS_OAK_BLOCK_2 = registerBlock("windows_oak_block_2",
            ()-> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR),BlockSetType.OAK){
                @Override
                public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
                    return true;
                }
            });
    public static final RegistryObject<Block> WINDOWS_SPRUCE_BLOCK_2 = registerBlock("windows_spruce_block_2",
            ()-> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR),BlockSetType.SPRUCE){
                @Override
                public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
                    return true;
                }
            });

    //方块
    public static final RegistryObject<Block> HANG_TU_WALL = registerBlock("hang_tu_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> TU_PEI_WALL = registerBlock("tu_pei_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> WHITE_WALLS_BLOCK = registerBlock("white_walls_block",
            ()-> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COOL_WHITE_WALLS_BLOCK = registerBlock("cool_white_walls_block",
            ()-> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> WARM_WHITE_WALLS_BLOCK = registerBlock("warm_white_walls_block",
            ()-> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> WHITE_FINE_BRICKS = registerBlock("white_fine_bricks",
            ()-> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> WHITE_BRICKS = registerBlock("white_bricks",
            ()-> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> BLACK_STONE_FINE_BRICKS = registerBlock("black_stone_fine_bricks",
            ()-> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> BLACK_STONE_BRICKS = registerBlock("black_stone_bricks",
            ()-> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> BLUE_STONE_FINE_BRICKS = registerBlock("blue_stone_fine_bricks",
            ()-> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> BLUE_STONE_BRICKS = registerBlock("blue_stone_bricks",
            ()-> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));

    public static final RegistryObject<Block> BITUMEN_FLOOR_TILES_BLOCK = registerBlock("bitumen_floor_tiles_block",
            ()-> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> BLUE_FLOOR_TILES_BLOCK = registerBlock("blue_floor_tiles_block",
            ()-> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> BLACK_FLOOR_TILES_BLOCK = registerBlock("black_floor_tiles_block",
            ()-> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    //楼梯
    public static final RegistryObject<Block> HANG_TU_STAIRS = registerBlock("hang_tu_stairs",
            ()-> new StairBlock(()-> ChangShengJueBlocks.HANG_TU_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> TU_PEI_STAIRS = registerBlock("tu_pei_stairs",
            ()-> new StairBlock(()-> ChangShengJueBlocks.TU_PEI_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> WHITE_BRICKS_STAIRS = registerBlock("white_bricks_stairs",
            ()-> new StairBlock(()-> ChangShengJueBlocks.TU_PEI_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> BLACK_STONE_BRICKS_STAIRS = registerBlock("black_stone_bricks_stairs",
            ()-> new StairBlock(()-> ChangShengJueBlocks.TU_PEI_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> BLUE_STONE_BRICKS_STAIRS = registerBlock("blue_stone_bricks_stairs",
            ()-> new StairBlock(()-> ChangShengJueBlocks.TU_PEI_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5F, 6.0F)));
    //台阶
    public static final RegistryObject<Block> HANG_TU_SLAB = registerBlock("hang_tu_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> TU_PEI_SLAB = registerBlock("tu_pei_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> WHITE_BRICKS_SLAB = registerBlock("white_bricks_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> BLACK_STONE_BRICKS_SLAB = registerBlock("black_stone_bricks_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> BLUE_STONE_BRICKS_SLAB = registerBlock("blue_stone_bricks_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5F, 6.0F)));

    //竖墙
    public static final RegistryObject<Block> WHITE_BRICKS_VERTICAL_WALLS = registerBlock("white_bricks_vertical_walls",
            ()-> new VerticalWalls(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5F, 6.0F).noOcclusion()));
    public static final RegistryObject<Block> BLACK_STONE_VERTICAL_WALLS = registerBlock("black_stone_vertical_walls",
            ()-> new VerticalWalls(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5F, 6.0F).noOcclusion()));
    public static final RegistryObject<Block> BLUE_STONE_VERTICAL_WALLS = registerBlock("blue_stone_vertical_walls",
            ()-> new VerticalWalls(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5F, 6.0F).noOcclusion()));

    //矿石
    public static final RegistryObject<Block> AG_ORE = registerBlock("ag_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F)));
    public static final RegistryObject<Block> DEEPSLATE_AG_ORE = registerBlock("deepslate_ag_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(ChangShengJueBlocks.AG_ORE.get().defaultBlockState().getBlock()).mapColor(MapColor.DEEPSLATE).
                    strength(4.5F, 6.0F).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> KAOLIN_ORE = registerBlock("kaolin_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F)));

    public static final RegistryObject<Block> LIMESTONE = registerBlock("limestone",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> SYDEROLIFE_ORE = registerBlock("syderolife_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F)));

    //织布机
    public static final RegistryObject<Block> CHANG_SHENG_JUE_LOOM = registerBlock("chang_sheng_jue_loom",
            ()-> new ChangShengJueLoomBlock(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.WOOD)));
    //工作方块
    public static final RegistryObject<Block> POTTERY_WHEEL = registerBlock("pottery_wheel",
            ()-> new PotteryWheel(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> TOOL_TABLE = registerBlock("tool_table",
            ()-> new ToolTable(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> DESK = registerBlock("desk",
            ()-> new Desk(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PIG_TROUGH = registerBlock("pig_trough",
            ()-> new PigTrough(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(0.6F).sound(SoundType.WOOD).ignitedByLava().noCollission()));
    //浇铸模具
    public static final RegistryObject<Block> CASTING_MOLDS = registerBlock("casting_molds",
            ()-> new CastingMolds(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.STONE)));

    public static final RegistryObject<Block> BULLIONS_CASTING_MOLDS = registerBlock("bullions_casting_molds",
            ()-> new BullionsCastingMolds(BlockBehaviour.Properties.of().strength(2.5F).sound(SoundType.STONE)));

    //画轴
    public static final RegistryObject<Block> PAINTING_SCROLL = registerBlock("painting_scroll",
            ()-> new PaintingScroll(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> HIGH_PAINTING_SCROLL = registerBlock("high_painting_scroll",
            ()-> new HighPaintingScroll(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> WIDTH_PAINTING_SCROLL = registerBlock("width_painting_scroll",
            ()-> new WidthPaintingScroll(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> BIG_PAINTING_SCROLL = registerBlock("big_painting_scroll",
            ()-> new BigPaintingScroll(BlockBehaviour.Properties.of().replaceable().noCollission().instabreak().pushReaction(PushReaction.DESTROY)));

    //牌匾
    public static final RegistryObject<Block> PLAQUE = BLOCKS.register("plaque",
            () -> new Plaque(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), CSJWoodTypes.PLAQUE));

    public static final RegistryObject<Block> PLAQUE_STANDING = BLOCKS.register("plaque_standing",
            () -> new PlaqueStanding(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), CSJWoodTypes.PLAQUE));

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
        return ChangShengJueItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
