package com.shengchanshe.chang_sheng_jue.block;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.custom.brick_kiln.BrickKilnEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.castingmolds.BullionsCastingMoldsBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.castingmolds.CastingMoldsBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.forgeblock.ForgeBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.bed.ArhatBedEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.bamboo_mat.BambooMatEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.desk.entity.DesksEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.gong.GongEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.lockers.CabinetEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.lockers.ChestOfDrawersEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.lockers.LargeCabinetEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.loom.ChangShengJueLoomBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.plaque.PlaqueEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.pottery.PotteryWheelEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.racks.ClothesRackEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.racks.DryingRailEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.bigleft.entity.BigShingMunLeftEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.bigright.entity.BigShingMunRightEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.left.entity.ShingMunLeftEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.right.entity.ShingMunRightEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.storage.BookGridEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.storage.FretworkOpenworkPanelEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.storage.LianggeEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase.TailoringCaseEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.tool_table.ToolTableEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.weaponrack.WeaponRackEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.workbench.WoodworkingBenchEntity;
import com.shengchanshe.chang_sheng_jue.block.decoration.flowerpot.BlueAndWhitePorcelainFlowerPotsEntity;
import com.shengchanshe.chang_sheng_jue.block.decoration.windchime.WindChimeEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChangShengJueBlocksEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITYES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ChangShengJue.MOD_ID);

    public static final RegistryObject<BlockEntityType<PotteryWheelEntity>> POTTERY_WHEEL_ENTITY =
        BLOCK_ENTITYES.register("pottery_wheel_entity",()-> BlockEntityType.Builder.of(PotteryWheelEntity::new, ChangShengJueBlocks.POTTERY_WHEEL.get()).build(null));

    public static final RegistryObject<BlockEntityType<ToolTableEntity>> TOOL_TABLE_ENTITY =
            BLOCK_ENTITYES.register("tool_table_entity",
                    ()-> BlockEntityType.Builder.of(ToolTableEntity::new,
                            ChangShengJueBlocks.TOOL_TABLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<WeaponRackEntity>> WEAPON_RACK_ENTITY =
            BLOCK_ENTITYES.register("weapon_rack_entity",
                    () -> BlockEntityType.Builder.of(WeaponRackEntity::new,
                            ChangShengJueBlocks.WEAPON_RACK.get()).build(null));

    public static final RegistryObject<BlockEntityType<BlueAndWhitePorcelainFlowerPotsEntity>> BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS_ENTITY =
            BLOCK_ENTITYES.register("blue_and_white_porcelain_flower_pots_entity",
                    ()-> BlockEntityType.Builder.of(BlueAndWhitePorcelainFlowerPotsEntity::new, ChangShengJueBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS.get()).build(null));

    public static final RegistryObject<BlockEntityType<ChangShengJueLoomBlockEntity>> CHANG_SHENG_JUE_LOOM_BLOCK_ENTITY =
            BLOCK_ENTITYES.register("chang_sheng_jue_loom_block_entity",
                    ()-> BlockEntityType.Builder.of(ChangShengJueLoomBlockEntity::new, ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get()).build(null));

    public static final RegistryObject<BlockEntityType<PlaqueEntity>> PLAQUE_ENTITY =
            BLOCK_ENTITYES.register("plaque_entity", ()-> BlockEntityType.Builder.of(PlaqueEntity::new, ChangShengJueBlocks.PLAQUE.get()).build(null));

    public static final RegistryObject<BlockEntityType<TailoringCaseEntity>> TAILORING_CASE_ENTITY =
            BLOCK_ENTITYES.register("tailoring_case_entity", ()-> BlockEntityType.Builder.of(TailoringCaseEntity::new, ChangShengJueBlocks.TAILORING_CASE.get()).build(null));

    //forgeblcok
    public static final RegistryObject<BlockEntityType<ForgeBlockEntity>> FORGE_BLOCK_ENTITY =
            BLOCK_ENTITYES.register("forge_block_entity",()-> BlockEntityType.Builder.of(ForgeBlockEntity::new, ChangShengJueBlocks.FORGE_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<CastingMoldsBlockEntity>> CASTING_MOLDS_BLOCK_ENTITY =
            BLOCK_ENTITYES.register("casting_molds_block_entity",()-> BlockEntityType.Builder.of(CastingMoldsBlockEntity::new, ChangShengJueBlocks.CASTING_MOLDS.get()).build(null));

    public static final RegistryObject<BlockEntityType<BullionsCastingMoldsBlockEntity>> BULLIONS_CASTING_MOLDS_BLOCK_ENTITY =
            BLOCK_ENTITYES.register("bullions_casting_molds_block_entity",()-> BlockEntityType.Builder.of(BullionsCastingMoldsBlockEntity::new, ChangShengJueBlocks.BULLIONS_CASTING_MOLDS.get()).build(null));

    //大门
    public static final RegistryObject<BlockEntityType<ShingMunLeftEntity>> SHING_MUN_LEFT_ENTITY =
            BLOCK_ENTITYES.register("shing_mun_left_entity",()-> BlockEntityType.Builder.of(ShingMunLeftEntity::new, ChangShengJueBlocks.SHING_MUN_LEFT.get()).build(null));

    public static final RegistryObject<BlockEntityType<ShingMunRightEntity>> SHING_MUN_RIGHT_ENTITY =
            BLOCK_ENTITYES.register("shing_mun_right_entity",()-> BlockEntityType.Builder.of(ShingMunRightEntity::new, ChangShengJueBlocks.SHING_MUN_RIGHT.get()).build(null));

    public static final RegistryObject<BlockEntityType<BigShingMunLeftEntity>> BIG_SHING_MUN_LEFT_ENTITY =
            BLOCK_ENTITYES.register("big_shing_mun_left_entity", ()-> BlockEntityType.Builder.of(BigShingMunLeftEntity::new,
                    ChangShengJueBlocks.BIG_SHING_MUN_LEFT.get()).build(null));

    public static final RegistryObject<BlockEntityType<BigShingMunRightEntity>> BIG_SHING_MUN_RIGHT_ENTITY =
            BLOCK_ENTITYES.register("big_shing_mun_right_entity", ()-> BlockEntityType.Builder.of(BigShingMunRightEntity::new,
                    ChangShengJueBlocks.BIG_SHING_MUN_RIGHT.get()).build(null));

    //风铃
    public static final RegistryObject<BlockEntityType<WindChimeEntity>> WIND_CHIME_ENTITY =
            BLOCK_ENTITYES.register("wind_chime_entity",
                    ()-> BlockEntityType.Builder.of(WindChimeEntity::new, ChangShengJueBlocks.WIND_CHIME.get()).build(null));
    //锣
    public static final RegistryObject<BlockEntityType<GongEntity>> GONG_ENTITY =
            BLOCK_ENTITYES.register("gong_entity", ()-> BlockEntityType.Builder.of(
                    GongEntity::new, ChangShengJueBlocks.GONG.get()).build(null));
    //木工台
    public static final RegistryObject<BlockEntityType<WoodworkingBenchEntity>> WOOD_WORKING_BENCH_ENTITY =
            BLOCK_ENTITYES.register("wood_working_bench_entity",
                    ()-> BlockEntityType.Builder.of(WoodworkingBenchEntity::new, ChangShengJueBlocks.WOOD_WORKING_BENCH.get()).build(null));
    //砖窑炉
    public static final RegistryObject<BlockEntityType<BrickKilnEntity>> BRICK_KILN_ENTITY =
            BLOCK_ENTITYES.register("brick_kiln_entity",
                    ()-> BlockEntityType.Builder.of(BrickKilnEntity::new,
                            ChangShengJueBlocks.BRICK_KILN.get()).build(null));
    //晾衣杆
    public static final RegistryObject<BlockEntityType<DryingRailEntity>> DRYING_RAIL_ENTITY =
            BLOCK_ENTITYES.register("drying_rail_entity",
                    () -> BlockEntityType.Builder.of(DryingRailEntity::new,
                            ChangShengJueBlocks.BIRCH_DRYING_RAIL.get(),
                            ChangShengJueBlocks.JUNGLE_DRYING_RAIL.get(),
                            ChangShengJueBlocks.CRIMSON_DRYING_RAIL.get(),
                            ChangShengJueBlocks.WARPED_DRYING_RAIL.get(),
                            ChangShengJueBlocks.MANGROVE_DRYING_RAIL.get(),
                            ChangShengJueBlocks.HUANG_HUA_LI_DRYING_RAIL.get(),
                            ChangShengJueBlocks.WENGE_DRYING_RAIL.get(),
                            ChangShengJueBlocks.ACACIA_DRYING_RAIL.get(),
                            ChangShengJueBlocks.DARK_OAK_DRYING_RAIL.get(),
                            ChangShengJueBlocks.OAK_DRYING_RAIL.get(),
                            ChangShengJueBlocks.CHERRY_DRYING_RAIL.get(),
                            ChangShengJueBlocks.SPRUCE_DRYING_RAIL.get(),
                            ChangShengJueBlocks.ZI_TAN_DRYING_RAIL.get()
                    ).build(null));
    //衣架
    public static final RegistryObject<BlockEntityType<ClothesRackEntity>> CLOTHES_RACK_ENTITY =
            BLOCK_ENTITYES.register("clothes_rack_entity",
                    () -> BlockEntityType.Builder.of(ClothesRackEntity::new,
                            ChangShengJueBlocks.BIRCH_CLOTHES_RACK.get(),
                            ChangShengJueBlocks.JUNGLE_CLOTHES_RACK.get(),
                            ChangShengJueBlocks.CRIMSON_CLOTHES_RACK.get(),
                            ChangShengJueBlocks.WARPED_CLOTHES_RACK.get(),
                            ChangShengJueBlocks.MANGROVE_CLOTHES_RACK.get(),
                            ChangShengJueBlocks.HUANG_HUA_LI_CLOTHES_RACK.get(),
                            ChangShengJueBlocks.WENGE_CLOTHES_RACK.get(),
                            ChangShengJueBlocks.ACACIA_CLOTHES_RACK.get(),
                            ChangShengJueBlocks.DARK_OAK_CLOTHES_RACK.get(),
                            ChangShengJueBlocks.OAK_CLOTHES_RACK.get(),
                            ChangShengJueBlocks.CHERRY_CLOTHES_RACK.get(),
                            ChangShengJueBlocks.SPRUCE_CLOTHES_RACK.get(),
                            ChangShengJueBlocks.ZI_TAN_CLOTHES_RACK.get()
                    ).build(null));

    //柜子
    public static final RegistryObject<BlockEntityType<CabinetEntity>> CABINET_ENTITY =
            BLOCK_ENTITYES.register("cabinet_entity",
                    () -> BlockEntityType.Builder.of(CabinetEntity::new,
                            ChangShengJueBlocks.BIRCH_CABINET.get(),
                            ChangShengJueBlocks.JUNGLE_CABINET.get(),
                            ChangShengJueBlocks.CRIMSON_CABINET.get(),
                            ChangShengJueBlocks.WARPED_CABINET.get(),
                            ChangShengJueBlocks.MANGROVE_CABINET.get(),
                            ChangShengJueBlocks.HUANG_HUA_LI_CABINET.get(),
                            ChangShengJueBlocks.WENGE_CABINET.get(),
                            ChangShengJueBlocks.ACACIA_CABINET.get(),
                            ChangShengJueBlocks.DARK_OAK_CABINET.get(),
                            ChangShengJueBlocks.OAK_CABINET.get(),
                            ChangShengJueBlocks.CHERRY_CABINET.get(),
                            ChangShengJueBlocks.SPRUCE_CABINET.get(),
                            ChangShengJueBlocks.ZI_TAN_CABINET.get()).build(null));
    // 大柜子
    public static final RegistryObject<BlockEntityType<LargeCabinetEntity>> LARGE_CABINET_ENTITY =
            BLOCK_ENTITYES.register("large_cabinet_entity",
                    () -> BlockEntityType.Builder.of(LargeCabinetEntity::new,
                            ChangShengJueBlocks.BIRCH_LARGE_CABINET.get(),
                            ChangShengJueBlocks.JUNGLE_LARGE_CABINET.get(),
                            ChangShengJueBlocks.CRIMSON_LARGE_CABINET.get(),
                            ChangShengJueBlocks.WARPED_LARGE_CABINET.get(),
                            ChangShengJueBlocks.MANGROVE_LARGE_CABINET.get(),
                            ChangShengJueBlocks.HUANG_HUA_LI_LARGE_CABINET.get(),
                            ChangShengJueBlocks.WENGE_LARGE_CABINET.get(),
                            ChangShengJueBlocks.ACACIA_LARGE_CABINET.get(),
                            ChangShengJueBlocks.DARK_OAK_LARGE_CABINET.get(),
                            ChangShengJueBlocks.OAK_LARGE_CABINET.get(),
                            ChangShengJueBlocks.CHERRY_LARGE_CABINET.get(),
                            ChangShengJueBlocks.SPRUCE_LARGE_CABINET.get(),
                            ChangShengJueBlocks.ZI_TAN_LARGE_CABINET.get()).build(null));

    public static final RegistryObject<BlockEntityType<ChestOfDrawersEntity>> CHEST_OF_DRAWERS_ENTITY =
            BLOCK_ENTITYES.register("chest_of_drawers_entity",
                    () -> BlockEntityType.Builder.of(ChestOfDrawersEntity::new,
                            ChangShengJueBlocks.BIRCH_CHEST_OF_DRAWERS.get(),
                            ChangShengJueBlocks.JUNGLE_CHEST_OF_DRAWERS.get(),
                            ChangShengJueBlocks.CRIMSON_CHEST_OF_DRAWERS.get(),
                            ChangShengJueBlocks.WARPED_CHEST_OF_DRAWERS.get(),
                            ChangShengJueBlocks.MANGROVE_CHEST_OF_DRAWERS.get(),
                            ChangShengJueBlocks.HUANG_HUA_LI_CHEST_OF_DRAWERS.get(),
                            ChangShengJueBlocks.WENGE_CHEST_OF_DRAWERS.get(),
                            ChangShengJueBlocks.ACACIA_CHEST_OF_DRAWERS.get(),
                            ChangShengJueBlocks.DARK_OAK_CHEST_OF_DRAWERS.get(),
                            ChangShengJueBlocks.OAK_CHEST_OF_DRAWERS.get(),
                            ChangShengJueBlocks.CHERRY_CHEST_OF_DRAWERS.get(),
                            ChangShengJueBlocks.SPRUCE_CHEST_OF_DRAWERS.get(),
                            ChangShengJueBlocks.ZI_TAN_CHEST_OF_DRAWERS.get()).build(null));
    //置物格
    public static final RegistryObject<BlockEntityType<FretworkOpenworkPanelEntity>> STORAGE_COMPARTMENT_ENTITY =
        BLOCK_ENTITYES.register("storage_compartment_entity",
                ()-> BlockEntityType.Builder.of(FretworkOpenworkPanelEntity::new,
                        ChangShengJueBlocks.BIRCH_FRETWORK_OPENWORK_PANEL.get(),
                        ChangShengJueBlocks.JUNGLE_FRETWORK_OPENWORK_PANEL.get(),
                        ChangShengJueBlocks.CRIMSON_FRETWORK_OPENWORK_PANEL.get(),
                        ChangShengJueBlocks.WARPED_FRETWORK_OPENWORK_PANEL.get(),
                        ChangShengJueBlocks.MANGROVE_FRETWORK_OPENWORK_PANEL.get(),
                        ChangShengJueBlocks.HUANG_HUA_LI_FRETWORK_OPENWORK_PANEL.get(),
                        ChangShengJueBlocks.WENGE_FRETWORK_OPENWORK_PANEL.get(),
                        ChangShengJueBlocks.ACACIA_FRETWORK_OPENWORK_PANEL.get(),
                        ChangShengJueBlocks.DARK_OAK_FRETWORK_OPENWORK_PANEL.get(),
                        ChangShengJueBlocks.OAK_FRETWORK_OPENWORK_PANEL.get(),
                        ChangShengJueBlocks.CHERRY_FRETWORK_OPENWORK_PANEL.get(),
                        ChangShengJueBlocks.SPRUCE_FRETWORK_OPENWORK_PANEL.get(),
                        ChangShengJueBlocks.ZI_TAN_FRETWORK_OPENWORK_PANEL.get()).build(null));
    public static final RegistryObject<BlockEntityType<BookGridEntity>> BOOK_GRID_ENTITY =
            BLOCK_ENTITYES.register("book_grid_entity",
                    ()-> BlockEntityType.Builder.of(BookGridEntity::new,
                            ChangShengJueBlocks.BIRCH_BOOK_GRID.get(),
                            ChangShengJueBlocks.JUNGLE_BOOK_GRID.get(),
                            ChangShengJueBlocks.CRIMSON_BOOK_GRID.get(),
                            ChangShengJueBlocks.WARPED_BOOK_GRID.get(),
                            ChangShengJueBlocks.MANGROVE_BOOK_GRID.get(),
                            ChangShengJueBlocks.HUANG_HUA_LI_BOOK_GRID.get(),
                            ChangShengJueBlocks.WENGE_BOOK_GRID.get(),
                            ChangShengJueBlocks.ACACIA_BOOK_GRID.get(),
                            ChangShengJueBlocks.DARK_OAK_BOOK_GRID.get(),
                            ChangShengJueBlocks.OAK_BOOK_GRID.get(),
                            ChangShengJueBlocks.CHERRY_BOOK_GRID.get(),
                            ChangShengJueBlocks.SPRUCE_BOOK_GRID.get(),
                            ChangShengJueBlocks.ZI_TAN_BOOK_GRID.get()).build(null));

    public static final RegistryObject<BlockEntityType<LianggeEntity>> LIANGGE_ENTITY =
            BLOCK_ENTITYES.register("liangge_entity",
                    ()-> BlockEntityType.Builder.of(LianggeEntity::new,
                            ChangShengJueBlocks.BIRCH_LIANGGE.get(),
                            ChangShengJueBlocks.JUNGLE_LIANGGE.get(),
                            ChangShengJueBlocks.CRIMSON_LIANGGE.get(),
                            ChangShengJueBlocks.WARPED_LIANGGE.get(),
                            ChangShengJueBlocks.MANGROVE_LIANGGE.get(),
                            ChangShengJueBlocks.HUANG_HUA_LI_LIANGGE.get(),
                            ChangShengJueBlocks.WENGE_LIANGGE.get(),
                            ChangShengJueBlocks.ACACIA_LIANGGE.get(),
                            ChangShengJueBlocks.DARK_OAK_LIANGGE.get(),
                            ChangShengJueBlocks.OAK_LIANGGE.get(),
                            ChangShengJueBlocks.CHERRY_LIANGGE.get(),
                            ChangShengJueBlocks.SPRUCE_LIANGGE.get(),
                            ChangShengJueBlocks.ZI_TAN_LIANGGE.get()).build(null));
    //竹席
    public static final RegistryObject<BlockEntityType<BambooMatEntity>> BAMBOO_MAT_ENTITY =
            BLOCK_ENTITYES.register("bamboo_mat_entity",
                    ()-> BlockEntityType.Builder.of(BambooMatEntity::new,
                            ChangShengJueBlocks.BAMBOO_MAT.get()).build(null));

    public static final RegistryObject<BlockEntityType<ArhatBedEntity>> ARHAT_BED_ENTITY =
            BLOCK_ENTITYES.register("arhat_bed_entity",
                    ()-> BlockEntityType.Builder.of(ArhatBedEntity::new,
                            ChangShengJueBlocks.BIRCH_ARHAT_BED.get(),
                            ChangShengJueBlocks.JUNGLE_ARHAT_BED.get(),
                            ChangShengJueBlocks.CRIMSON_ARHAT_BED.get(),
                            ChangShengJueBlocks.WARPED_ARHAT_BED.get(),
                            ChangShengJueBlocks.MANGROVE_ARHAT_BED.get(),
                            ChangShengJueBlocks.HUANG_HUA_LI_ARHAT_BED.get(),
                            ChangShengJueBlocks.WENGE_ARHAT_BED.get(),
                            ChangShengJueBlocks.ACACIA_ARHAT_BED.get(),
                            ChangShengJueBlocks.DARK_OAK_ARHAT_BED.get(),
                            ChangShengJueBlocks.OAK_ARHAT_BED.get(),
                            ChangShengJueBlocks.CHERRY_ARHAT_BED.get(),
                            ChangShengJueBlocks.SPRUCE_ARHAT_BED.get(),
                            ChangShengJueBlocks.ZI_TAN_ARHAT_BED.get()).build(null));

    //桌子
    public static final RegistryObject<BlockEntityType<DesksEntity>> DESK =
            BLOCK_ENTITYES.register("desk",()-> BlockEntityType.Builder.of(DesksEntity::new,
                    ChangShengJueBlocks.BIRCH_WINE_TABLE.get(),
                    ChangShengJueBlocks.JUNGLE_WINE_TABLE.get(),
                    ChangShengJueBlocks.CRIMSON_WINE_TABLE.get(),
                    ChangShengJueBlocks.WARPED_WINE_TABLE.get(),
                    ChangShengJueBlocks.MANGROVE_WINE_TABLE.get(),
                    ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE.get(),
                    ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE.get(),
                    ChangShengJueBlocks.ACACIA_WINE_TABLE.get(),
                    ChangShengJueBlocks.DARK_OAK_WINE_TABLE.get(),
                    ChangShengJueBlocks.OAK_WINE_TABLE.get(),
                    ChangShengJueBlocks.CHERRY_WINE_TABLE.get(),
                    ChangShengJueBlocks.SPRUCE_WINE_TABLE.get(),
                    ChangShengJueBlocks.ZI_TAN_WINE_TABLE.get(),

                    ChangShengJueBlocks.BIRCH_TEAPOY.get(),
                    ChangShengJueBlocks.JUNGLE_TEAPOY.get(),
                    ChangShengJueBlocks.CRIMSON_TEAPOY.get(),
                    ChangShengJueBlocks.WARPED_TEAPOY.get(),
                    ChangShengJueBlocks.MANGROVE_TEAPOY.get(),
                    ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get(),
                    ChangShengJueBlocks.WENGE_TEAPOY.get(),
                    ChangShengJueBlocks.ACACIA_TEAPOY.get(),
                    ChangShengJueBlocks.DARK_OAK_TEAPOY.get(),
                    ChangShengJueBlocks.OAK_TEAPOY.get(),
                    ChangShengJueBlocks.CHERRY_TEAPOY.get(),
                    ChangShengJueBlocks.SPRUCE_TEAPOY.get(),
                    ChangShengJueBlocks.ZI_TAN_TEAPOY.get(),

                    ChangShengJueBlocks.BIRCH_LOW_DESK.get(),
                    ChangShengJueBlocks.JUNGLE_LOW_DESK.get(),
                    ChangShengJueBlocks.CRIMSON_LOW_DESK.get(),
                    ChangShengJueBlocks.WARPED_LOW_DESK.get(),
                    ChangShengJueBlocks.MANGROVE_LOW_DESK.get(),
                    ChangShengJueBlocks.HUANG_HUA_LI_LOW_DESK.get(),
                    ChangShengJueBlocks.JI_CHI_MU_LOW_DESK.get(),
                    ChangShengJueBlocks.ACACIA_LOW_DESK.get(),
                    ChangShengJueBlocks.DARK_OAK_LOW_DESK.get(),
                    ChangShengJueBlocks.OAK_LOW_DESK.get(),
                    ChangShengJueBlocks.CHERRY_LOW_DESK.get(),
                    ChangShengJueBlocks.SPRUCE_LOW_DESK.get(),
                    ChangShengJueBlocks.ZI_TAN_LOW_DESK.get(),

                    ChangShengJueBlocks.STONE_TABLE.get()
            ).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITYES.register(eventBus);
    }
}
