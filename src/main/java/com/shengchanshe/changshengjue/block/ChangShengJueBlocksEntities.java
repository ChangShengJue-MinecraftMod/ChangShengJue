package com.shengchanshe.changshengjue.block;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.custom.shing_mun.bigleft.entity.BigShingMunLeftEntity;
import com.shengchanshe.changshengjue.block.custom.shing_mun.bigright.BigShingMunRight;
import com.shengchanshe.changshengjue.block.custom.shing_mun.bigright.entity.BigShingMunRightEntity;
import com.shengchanshe.changshengjue.block.custom.shing_mun.left.entity.ShingMunLeftEntity;
import com.shengchanshe.changshengjue.block.custom.shing_mun.right.entity.ShingMunRightEntity;
import com.shengchanshe.changshengjue.block.entity.*;
import com.shengchanshe.changshengjue.block.entity.desk.Desk;
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
            BLOCK_ENTITYES.register("tool_table_entity",()-> BlockEntityType.Builder.of(ToolTableEntity::new, ChangShengJueBlocks.TOOL_TABLE.get()).build(null));

    public static final RegistryObject<BlockEntityType<BlueAndWhitePorcelainFlowerPotsEntity>> BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS_ENTITY =
            BLOCK_ENTITYES.register("blue_and_white_porcelain_flower_pots_entity",
                    ()-> BlockEntityType.Builder.of(BlueAndWhitePorcelainFlowerPotsEntity::new, ChangShengJueBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS.get()).build(null));

    public static final RegistryObject<BlockEntityType<ChangShengJueLoomBlockEntity>> CHANG_SHENG_JUE_LOOM_BLOCK_ENTITY =
            BLOCK_ENTITYES.register("chang_sheng_jue_loom_block_entity",
                    ()-> BlockEntityType.Builder.of(ChangShengJueLoomBlockEntity::new, ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get()).build(null));

    public static final RegistryObject<BlockEntityType<PlaqueEntity>> PLAQUE_ENTITY =
            BLOCK_ENTITYES.register("plaque_entity", ()-> BlockEntityType.Builder.of(PlaqueEntity::new, ChangShengJueBlocks.PLAQUE.get()).build(null));

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


    //桌子
    public static final RegistryObject<BlockEntityType<Desk>> DESK =
            BLOCK_ENTITYES.register("desk",()-> BlockEntityType.Builder.of(Desk::new,
                    ChangShengJueBlocks.BIRCH_WINE_TABLE.get(),
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

                    ChangShengJueBlocks.BIRCH_BOOK_DESK.get(),
                    ChangShengJueBlocks.CRIMSON_BOOK_DESK.get(),
                    ChangShengJueBlocks.WARPED_BOOK_DESK.get(),
                    ChangShengJueBlocks.MANGROVE_BOOK_DESK.get(),
                    ChangShengJueBlocks.HUANG_HUA_LI_BOOK_DESK.get(),
                    ChangShengJueBlocks.JI_CHI_MU_BOOK_DESK.get(),
                    ChangShengJueBlocks.ACACIA_BOOK_DESK.get(),
                    ChangShengJueBlocks.DARK_OAK_BOOK_DESK.get(),
                    ChangShengJueBlocks.OAK_BOOK_DESK.get(),
                    ChangShengJueBlocks.CHERRY_BOOK_DESK.get(),
                    ChangShengJueBlocks.SPRUCE_BOOK_DESK.get(),
                    ChangShengJueBlocks.ZI_TAN_BOOK_DESK.get(),

                    ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get(),
                    ChangShengJueBlocks.JI_CHI_MU_TEAPOY.get(),
                    ChangShengJueBlocks.ZI_TAN_TEAPOY.get(),
                    ChangShengJueBlocks.BIRCH_LOW_DESK.get(),
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
                    ChangShengJueBlocks.ZI_TAN_LOW_DESK.get()
            ).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITYES.register(eventBus);
    }
}
