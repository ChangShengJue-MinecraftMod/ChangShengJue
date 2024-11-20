package com.shengchanshe.changshengjue.block;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.entity.*;
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


    public static void register(IEventBus eventBus){
        BLOCK_ENTITYES.register(eventBus);
    }
}
