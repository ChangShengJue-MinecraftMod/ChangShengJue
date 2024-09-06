package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID)
public class BlockPlacedEvent {
    @SubscribeEvent
    public static void blockPlace(BlockEvent.EntityPlaceEvent event){
        LevelAccessor world = event.getLevel();
        BlockState blockState = event.getPlacedBlock();
        int x = event.getPos().getX();
        int y = event.getPos().getY();
        int z = event.getPos().getZ();
        if (blockState.is(ChangShengJueBlocks.BAI_HUA_FU_TI_BLOCK.get()) || blockState.is(ChangShengJueBlocks.YUN_SHAN_FU_TI_BLOCK.get())){
            world.setBlock(new BlockPos(x, y + 1, z), blockState, 3);
            world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
        }
    }

//    @SubscribeEvent
//    public static void entityAttackEvent(TickEvent.PlayerTickEvent event){
//        Player player = event.player;
//        if (player.getMainHandItem().is(ChangShengJueItems.BANANA.get())){
//        }
//    }

}
