package com.shengchanshe.changshengjue.block.animated;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
//import com.shengchanshe.changshengjue.block.animated.entity.AnimatedLotusBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChangShengJueBlocksEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITYES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ChangShengJue.MOD_ID);

//    public static final RegistryObject<BlockEntityType<AnimatedLotusBlockEntity>> ANIMATED_BLOCK_ENTITY =
//            BLOCK_ENTITYES.register("animated_lotus_block_entity",()-> BlockEntityType.Builder.of(AnimatedLotusBlockEntity::new, ChangShengJueBlocks.LOTUS_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITYES.register(eventBus);
    }
}
